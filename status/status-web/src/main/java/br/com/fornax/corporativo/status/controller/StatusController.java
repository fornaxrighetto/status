package br.com.fornax.corporativo.status.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.corporativo.status.model.Maquina;
import br.com.fornax.corporativo.status.service.MaquinaService;
import br.com.fornax.corporativo.status.service.StatusService;

@Controller
public class StatusController {

	@Inject
	private StatusService statusService;
	
	@SuppressWarnings("unused")
	@Inject
	private MaquinaService maquinaService;

	//@RequestMapping("/")
	@RequestMapping("teste")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		Maquina portoNt770 = statusService.statusConexao("PORTO - NT770");
		Maquina portoU28 = statusService.statusConexao("PORTO - u28");
		Maquina internet = statusService.statusConexao("INTERNET");
		
		
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
		mav.addObject("maquinas", statusService.status());
		return mav;
	}
}
