package br.com.fornax.corporativo.status.service.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.fornax.corporativo.status.model.Rede;
import br.com.fornax.corporativo.status.service.MailService;
import br.com.fornax.corporativo.status.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
	private static Rede u28;
	private static Rede nt770;
	private static Rede internet;
	
	@Inject
	private MailService mailService;

	public StatusServiceImpl() {
		u28 = new Rede();
		u28.setNome("PORTO - u28");
		u28.setUrl("http://u28/index.html");
		u28.setQtdErros(0);
		u28.setEnviarEmail(true);
		
		nt770 = new Rede();
		nt770.setNome("PORTO - NT770");
		nt770.setUrl("http://172.26.171.17/index.html");
		nt770.setQtdErros(0);
		nt770.setEnviarEmail(false);

		internet = new Rede();
		internet.setNome("INTERNET");
		internet.setUrl("http://www.fornax.com.br");
		internet.setQtdErros(0);
		internet.setEnviarEmail(false);
	}

	@Override
	public Rede statusConexao(String servico) {
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

	private boolean verificaConexao(Rede servico) {
		boolean retorno = false;
		HttpURLConnection conexao = null;
		try {
			conexao = (HttpURLConnection) new URL(servico.getUrl())
					.openConnection();
			servico.setStatus(Integer.valueOf(conexao.getResponseCode())
					.toString());
			retorno  = verificaStarted(servico);
		} catch (Exception e) {
			servico.setStatus("0");
			servico.setQtdErros(servico.getQtdErros() + 1);
		}
		return retorno;
	}

	private boolean verificaStarted(Rede servico) {
		boolean retornoStarted = true;
		// Se o serviço não estiver em execução e o status do serviço igual
		// 200(quando o serviço for iniciado) grava a data e
		// hora de início e exibe uma msg de serviço iniciado.
		if (!servico.getStarted() && servico.getStatus().equals("200")) {
			servico.setStarted(Boolean.TRUE);
			servico.setDataInicio(Calendar.getInstance());

			System.out.println("Serviço: " + servico.getNome()
					+ " iniciado em " + servico.getDataInicio().getTime());
			
			if(servico.getEnviarEmail() == true){
				mailService.enviaEmailConexaoEstabelecida(servico);
			}
			// Se o serviço estiver iniciado e o status do serviço for diferente
			// de 200(quando o serviço "cair") grava a data e hora de término e
			// exibe uma msg mostrando a duração do serviço, exibe uma msg de
			// serviço terminado.
		} else if (servico.getStarted() && !servico.getStatus().equals("200")) {
			servico.setQtdErros(servico.getQtdErros() + 1);
			retornoStarted = false;
		}
		return retornoStarted;
	}

	// Executa o metodo a cada 10seg.
	@Scheduled(fixedDelay = 10000)
	public void verificaConexao() {
		verificaConexao(internet);
		boolean retornoU28 = verificaConexao(u28);
		boolean retornoNt770 = verificaConexao(nt770);
		
		if(!retornoU28 && !retornoNt770){
			if (u28.getStarted() && u28.getQtdErros() >= 3 && nt770.getStarted() && nt770.getQtdErros() >= 3 ) {
				encerrarServico(u28);
				encerrarServico(nt770);
				System.out.println("Enviando e-mail...");
				mailService.enviaEmailConexaoFora(u28);
			}
			
		}
	}
	
	private void encerrarServico(Rede servico) {
		servico.setDataFim(Calendar.getInstance());
		servico.setStarted(Boolean.FALSE);
		servico.setTempoDeConexao((servico.getDataFim()
				.getTimeInMillis() - servico.getDataInicio()
				.getTimeInMillis()) / 1000);
		servico.setQtdErros(0);

		System.out.println("Serviço: " + servico.getNome()
				+ " finalizado em " + servico.getDataFim().getTime());
		System.out.println("Tempo Total de Conexão: " + servico.getTempoDeConexao());
	}
	
}