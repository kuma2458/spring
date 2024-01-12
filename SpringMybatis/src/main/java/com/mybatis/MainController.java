package com.mybatis;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.dto.GradeDTO;
import com.mybatis.dto.MemberDTO;
import com.mybatis.service.MemberService;

@Controller
public class MainController {

	private MemberService service;


	public MainController(MemberService service) {
		super();
		this.service = service;
	}



	@RequestMapping("/")
	public ModelAndView main(ModelAndView view) {
		//전체 회원정보
		List<MemberDTO> list=service.selectAllmember();
		
		//회원 등급 정보
		List<GradeDTO> grade=service.selectAllgrade();
		view.addObject("list",list);
		view.addObject("grade",grade);
		
		view.setViewName("main");
		return view;
	}
	
}
