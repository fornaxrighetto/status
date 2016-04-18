package br.com.fornax.corporativo.status.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.corporativo.status.model.Maquina;
import br.com.fornax.corporativo.status.service.MaquinaService;
import br.com.fornax.corporativo.status.service.StatusService;

@Controller
public class MaquinaController {
//	@SuppressWarnings("unused")
//	@Inject
//	private StatusService statusService;
//	
//	@SuppressWarnings("unused")
//	@Inject
//	private ParseService parseService;
	
	@Inject
	private MaquinaService maquinaService;
	
	@SuppressWarnings("unused")
	@Inject
	private StatusService statusService;
	
	private boolean pesquisaBanco = true;
	
	ModelAndView mav = new ModelAndView();
	
	
	@RequestMapping("/salvarMaquina")
	public String salvarMaquina(Maquina maquina) {
		maquinaService.cadastrar(maquina);
		pesquisaBanco = true;
		pesquisarBanco();
		return "redirect:/";
	}
	
	@RequestMapping("/cadastro")
	public String formCadastro() {
		return "cadastroMaquina";
	}
	
	public void pesquisarBanco(){
		while(pesquisaBanco){
			List<Maquina> m = new ArrayList<Maquina>();
			m = maquinaService.listarMaquinas();
			if(!m.isEmpty() && maquinaService.listarMaquinas() != null){
				System.out.println("Maquina m da Controller nao eh nula!!!!");
				System.out.println("SIZE: " + (m.size()-1));
			}
			maquinaService.setMaquina(m);
			pesquisaBanco = false;
		}
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
		pesquisarBanco();
		
		ModelAndView mav = new ModelAndView();
		Maquina portoNt770 = maquinaService.statusConexao("PORTO - NT770");
		Maquina portoU28 = maquinaService.statusConexao("PORTO - u28");
		Maquina internet = maquinaService.statusConexao("INTERNET");
		
		
		System.out.println(portoU28.getNome() + " " + portoU28.getStatus());
		System.out.println(internet.getNome() + " " + internet.getStatus());
		System.out.println(portoNt770.getNome() + " " + portoNt770.getStatus());

		mav.setViewName("index");
		
//		List<Maquina> maquinaEn = maquinaService.listarMaquinas();
//		for(Maquina m: maquinaEn){
//		}
		
		mav.addObject("internet", internet);
		mav.addObject("u28", portoU28);
		mav.addObject("nt770", portoNt770);
		mav.addObject("maquinas", maquinaService.status());
		return mav;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarMaquina() {
		mav.clear();
		mav.setViewName("listarMaquina");
		mav.addObject("maquinas", maquinaService.status());
		return mav;
	}
	
	@RequestMapping(value="editar/{idMaquina}")
	public ModelAndView formEditar(@PathVariable("idMaquina") long idMaquina){
		mav.clear();
		mav.setViewName("editarMaquina");
		mav.addObject("maquinas", maquinaService.buscarMaquinaPorId(idMaquina));
		return mav;
	}
	
	@RequestMapping(value="editarMaquina", method=RequestMethod.POST)
	public String editarMaquina(Maquina maquina){
		maquinaService.editar(maquina);
		pesquisaBanco = true;
		pesquisarBanco();
		return "redirect:/";
	}
	
	@RequestMapping(value="deletar/{idMaquina}")
	public ModelAndView formDeletar(@PathVariable("idMaquina") long idMaquina){
		mav.clear();
		maquinaService.deletarMaquinaPorId(idMaquina);
		mav.setViewName("listarMaquina");
		mav.addObject("maquinas", maquinaService.status());
		return mav;
	}
	
	@RequestMapping(value="pesquisarMaquina/{maquina}")
	public ModelAndView formPing(@PathVariable("maquina") String maquina){
		mav.clear();
		mav.setViewName("ping");
		mav.addObject("maquina", maquina);
		return mav;
	}
	
//	@RequestMapping("/cadastro")
//	public ModelAndView formCadastro(){
//		mav.clear();
//		mav.setViewName("cadastroMaquina");
//		mav.addObject("maquinas", maquinaService.listarMaquinas());
//		return mav;
//	}
	
//	@ResponseBody
//	@RequestMapping(value = "consultarMaquina", method = RequestMethod.POST)
//	public List<Maquina> consultarMaquina(String nome, String ip) {
//		List<Maquina> maquina = maquinaService.
//			return null;
//	}
	
	/*
	 @RequestMapping
	public ModelAndView listarAcoes() {
		mav.clear();
		mav.setViewName("listarAcoes");
		mav.addObject("acoes", acaoService.listarAcoes());
		return mav;
	}
	 */
}
