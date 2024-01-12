package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	private RegisterService service;
	public MainController(RegisterService service) {
		this.service=service;
	}
	
	@RequestMapping("/")
	public String loginView() {
		return "login";
	}
	
//	@PostMapping("login.do")
//	public String login(HttpServletRequest request, HttpSession session) {
//		System.out.println("login.do");
//		System.out.println(request.getParameter("id")+" "+request.getParameter("pass"));
//		//받아온 데이터를 세션에 저장, login_result에 해당 데이터를 출력
//
//		session.setAttribute("id", request.getParameter("id"));
//		session.setAttribute("pass", request.getParameter("pass"));
//		
//		return "login_result";
//	}
	
	
//	@PostMapping("login.do")
//	public String login(String id,String pass, HttpSession session) {
//		System.out.println("login.do");
//		//받아온 데이터를 세션에 저장, login_result에 해당 데이터를 출력
//		
//		session.setAttribute("id", id);
//		session.setAttribute("pass", pass);
//		
//		return "login_result";
//	}
	
	@PostMapping("login.do")
	public String login(@RequestParam(name="id", defaultValue = "user") String id,
			@RequestParam(name="pass", required = true) String pass, HttpSession session) {
		System.out.println("log in.do");
		//받아온 데이터를 세션에 저장, login_result에 해당 데이터를 출력
		
		session.setAttribute("id", id);
		session.setAttribute("pass", pass);
		
		return "login_result";
	}
	
	@GetMapping("registerView.do")
	public String registerView() {
		return "member_register";
	}
	
	@PostMapping("register.do")
	public ModelAndView register(RegisterDTO dto, ModelAndView view) {
		System.out.println(dto);
		
		//request영역에 데이터 저장
		view.addObject("dto",dto);
		view.addObject("msg","request영역");
		
		//이동할 페이지 설정
		view.setViewName("register_result");
		service.test();
		return view;
	}
	
	
}
