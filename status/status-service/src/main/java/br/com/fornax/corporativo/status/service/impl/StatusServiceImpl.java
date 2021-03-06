package br.com.fornax.corporativo.status.service.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.fornax.corporativo.status.dao.MaquinaDAO;
import br.com.fornax.corporativo.status.model.Maquina;
import br.com.fornax.corporativo.status.service.MailService;
import br.com.fornax.corporativo.status.service.MaquinaService;
import br.com.fornax.corporativo.status.service.ParseService;
import br.com.fornax.corporativo.status.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
	private static Maquina u28;
	private static Maquina nt770;
	private static Maquina internet;
	private static Maquina lucas;
	private static long emailEnviadoOnline = 0;
	private static long emailEnviadoOffline = 0;
	
	private static List<Maquina> maquina = new ArrayList<Maquina>();
	
	
	@Inject
	private MailService mailService;
	
	@SuppressWarnings("unused")
	@Inject
	private MaquinaDAO maquinaDAO;
	
	@SuppressWarnings("unused")
	@Inject
	private ParseService parseService;
	
	@SuppressWarnings("unused")
	@Inject
	private MaquinaService maquinaService;

	public StatusServiceImpl() {
		
//		List<MaquinaEntity> maquinaEn = maquinaDAO.listarMaquinas();
//		List<Maquina> maquinas = new ArrayList<Maquina>();
//		if(maquinaEn != null && !maquinaEn.isEmpty()){
//			for(MaquinaEntity q: maquinaEn){
//				maquinas.add(parseService.parseToModel(q));
//			}
//			for(int i=0;i <= maquinas.size();i++){
//				System.out.println("Informacoes sobre o Array: " + maquinas.get(i));
//			}
//		}
//		if(listarMaquina() != null && !listarMaquina().isEmpty()){
//			maquina = listarMaquina();
//		}
		
		u28 = new Maquina();
		u28.setNome("PORTO - u28");
		u28.setUrl("http://u28/index.html");
		u28.setQtdErros(0);
		u28.setEnviarEmail(true);
		
		maquina.add(u28);
		
		nt770 = new Maquina();
		nt770.setNome("PORTO - NT770");
		//nt770.setUrl("http://172.26.171.17/index.html");
		nt770.setUrl("http://172.26.171.17/portal/Usuario/LogOn?ReturnUrl=%2fportal");
		nt770.setQtdErros(0);
		nt770.setEnviarEmail(true);
		
		maquina.add(nt770);

		internet = new Maquina();
		internet.setNome("INTERNET");
		internet.setUrl("http://www.fornax.com.br");
		internet.setQtdErros(0);
		internet.setEnviarEmail(true);
		
		maquina.add(internet);
		
		lucas = new Maquina();
		lucas.setNome("Lucas");
		lucas.setUrl("http://192.168.64.18:8081/gestao-projetos/");
		lucas.setQtdErros(0);
		lucas.setEnviarEmail(true);
		
		maquina.add(lucas);
		
		//maquina = maquinaService.listarMaquinas();
		
	}

	@Override
	public Maquina statusConexao(String servico) {
		if (u28.getNome().equals(servico)) {
			return u28;
		} else if (internet.getNome().equals(servico)) {
			return internet;
		}
		else if (nt770.getNome().equals(servico)) {
			return nt770;
		}
		return null;
	}
	
	//Verifica a Conexao de Cada Maquina
	private boolean verificaConexao(Maquina servico) {
		System.out.println("Verifica Conexao: " + servico.getNome());
		boolean retorno = false;
		HttpURLConnection conexao = null;
		try {
			conexao = (HttpURLConnection) new URL(servico.getUrl())
					.openConnection();
			servico.setStatus(Integer.valueOf(conexao.getResponseCode())
					.toString());
			System.out.println("Status Code Sucesso: " + servico.getNome() + " Status: " +  servico.getStatus());
			retorno  = verificaStarted(servico);
		} catch (Exception e) {
			servico.setStatus("0");
			servico.setQtdErros(servico.getQtdErros() + 1);
			System.out.println("Status Code Erro: " + servico.getNome() + " Status: " +  servico.getStatus());
		}
		return retorno;
	}

	//Verifica se a maquina foi startada
	private boolean verificaStarted(Maquina servico) {
		boolean retornoStarted = true;
		// Se o servi�o n�o estiver em execu��o e o status do servi�o igual
		// 200(quando o servi�o for iniciado) grava a data e
		// hora de in�cio e exibe uma msg de servi�o iniciado.
		if (!servico.getStarted() && servico.getStatus().equals("200")) {
			servico.setStarted(Boolean.TRUE);
			servico.setDataInicio(Calendar.getInstance());

			System.out.println("Servi�o: " + servico.getNome()
					+ " iniciado em " + servico.getDataInicio().getTime());
			
			if(servico.getEnviarEmail() == true){
				//mailService.enviaEmailConexaoEstabelecida(servico);
			}
			// Se o servi�o estiver iniciado e o status do servi�o for diferente
			// de 200(quando o servi�o "cair") grava a data e hora de t�rmino e
			// exibe uma msg mostrando a dura��o do servi�o, exibe uma msg de
			// servi�o terminado.
		} else if (servico.getStarted() && !servico.getStatus().equals("200")) {
			servico.setQtdErros(servico.getQtdErros() + 1);
			retornoStarted = false;
		}
		return retornoStarted;
	}

	// Executa o metodo a cada 10seg.
//	@Scheduled(fixedDelay = 10000)
//	public void verificaConexao() {
//		//verificaConexao(internet);
//		//boolean retornoU28 = verificaConexao(u28);
//		//boolean retornoNt770 = verificaConexao(nt770);
//		
//		//List<Maquina> verificaMaquinas = status();
//		//List<Maquina> verificaMaquinas = maquina;
//		long erro = 0;
//		long enviarEmail = 0;
//		Maquina maquinaErro = new Maquina();
//		Maquina maquinaSucesso = new Maquina();
//		for(Maquina m: maquina){
//			verificaConexao(m);
//			System.out.println("Nome: " + m.getNome() + " Started: " + m.getStarted() + " Status: " + m.getStatus());
//			if(!m.getStarted() && m.getQtdErros() >= 1 && m.getEnviarEmail() && !m.getStatus().equals("200")){
//				erro++;
//				maquinaErro = m;
//				System.out.println("Enviando e-mail..." + m.getNome() + " - " + m.getQtdErros());
//				encerrarServico(m);
//				//m.setQtdErros(m.getQtdErros() + 1);
//			}
//			if(m.getStarted() && m.getEnviarEmail() && m.getStatus().equals("200")){
//				enviarEmail++;
//				maquinaSucesso = m;
//			}
//		}
//		
//		if(erro >= (maquina.size()-1) && emailEnviadoOffline == 0){
//			mailService.enviaEmailConexaoFora(maquinaErro);
//			emailEnviadoOffline = 1;
//			System.out.println("emailEnviadoOffline: " + emailEnviadoOffline);
//			emailEnviadoOnline = 0;
//			System.out.println("emailEnviadoOnline: " + emailEnviadoOnline);
//			System.out.println("SIZE: " + (maquina.size()-1));
//			System.out.println("Email Enviado!");
//		}
//		
//		if(enviarEmail >= (maquina.size()-1) && emailEnviadoOnline == 0){
//			mailService.enviaEmailConexaoEstabelecida(maquinaSucesso);
//			emailEnviadoOnline = 1;
//			System.out.println("emailEnviadoOnline: " + emailEnviadoOnline);
//			emailEnviadoOffline = 0;
//			System.out.println("emailEnviadoOffline: " + emailEnviadoOffline);
//			System.out.println("SIZE: " + (maquina.size()-1));
//		}
//		
//		//Verifica das maquinas
//		
////		if(!retornoU28 && !retornoNt770){
////			if (u28.getStarted() && u28.getQtdErros() >= 3 && nt770.getStarted() && nt770.getQtdErros() >= 3 ) {
////				encerrarServico(u28);
////				encerrarServico(nt770);
////				System.out.println("Enviando e-mail...");
////				mailService.enviaEmailConexaoFora(u28);
////			}
////			
////		}
//	}
	
	private void encerrarServico(Maquina servico) {
		servico.setDataFim(Calendar.getInstance());
		servico.setStarted(Boolean.FALSE);
		//servico.setTempoDeConexao(100);
//		servico.setTempoDeConexao((servico.getDataFim()
//				.getTimeInMillis()
//				- servico.getDataInicio().getTimeInMillis()));
		servico.setQtdErros(0);

		System.out.println("Servi�o: " + servico.getNome()
				+ " finalizado em " + servico.getDataFim().getTime());
		System.out.println("Tempo Total de Conex�o: " + servico.getTempoDeConexao());
	}
	
//	public List<Maquina> listarMaquina(){
//		List<MaquinaEntity> maquinaEn = maquinaDAO.listarMaquinas();
//		List<Maquina> maquinas = new ArrayList<Maquina>();
//		for(MaquinaEntity q: maquinaEn){
//			maquinas.add(parseService.parseToModel(q));
//		}
//		return maquinas;
//	}

	@Override
	public List<Maquina> status() {
		return maquina;
	}
	
}