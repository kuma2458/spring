package com.studentproject.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.studentproject.dto.MajorDTO;
import com.studentproject.dto.StudentDTO;
import com.studentproject.service.MajorService;
import com.studentproject.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	private StudentService studentservice;
	private MajorService majorservice;

	public MainController(StudentService studentservice, MajorService majorservice) {
		super();
		this.studentservice = studentservice;
		this.majorservice = majorservice;
	}

	@RequestMapping("/")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping("/login")
	public String login(String id, String passwd,HttpSession session) {
		if(id.equals("admin")&&passwd.equals("123456")) {
			session.setAttribute("login", true);
			return "redirect:/main";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/main")
	public ModelAndView main(ModelAndView view) {
		//모든 학생 정보
		List<StudentDTO> studentlist =studentservice.selectAllStudent();
		//모든 학과정보
		List<MajorDTO> majorlist=majorservice.selectAllMajor();
		view.addObject("studentList", studentlist);
		view.addObject("majorList", majorlist);
		view.setViewName("main");
		
		return view;
	}
	
	@RequestMapping("/student/delete/{studentNo}")
	public String deletestudent(@PathVariable("studentNo") String studentNo) {
		studentservice.deleteStudent(studentNo);
		return "redirect:/main";
			
	}
	
	@GetMapping("/student/update/{studentNo}")
	public ModelAndView updateview(@PathVariable("studentNo") String studentNo, ModelAndView view) {
		StudentDTO dto=studentservice.selectStudent(studentNo);
		List<MajorDTO> list =majorservice.selectAllMajor();
		view.addObject("dto",dto);
		view.addObject("majorList",list);
		view.setViewName("student_update");
		return view;
	}
	
	@PostMapping("/student/update")
	public String studentupdate(String studentNo,String studentName,double score, String gender,int majorNo) {
		studentservice.updateStudent(new StudentDTO(studentNo, studentName, score, gender, majorNo));

			return "redirect:/main";
		}
	
	@GetMapping("/student/insert/view")
	public ModelAndView insertStudentView(ModelAndView view) {
		view.setViewName("student_register");
		List<MajorDTO> majorList =majorservice.selectAllMajor();
		view.addObject("majorList", majorList);
		return view;
	}
	
	
	@PostMapping("/student/insert")
	public String insertStudent(String studentNo,String studentName,double score, String gender,int majorNo) {
		studentservice.insertStudent(new StudentDTO(studentNo, studentName, score, gender, majorNo));
		
		
		return "redirect:/main";
	}
	
	
	@GetMapping("/major")
	public ModelAndView majorMain(ModelAndView view) {
		view.setViewName("major_main");
		List<MajorDTO> majorList =majorservice.selectAllMajor();
		view.addObject("majorList", majorList);
		return view;
	}
	
	@PutMapping("/major/update/{majorNo}")
	@ResponseBody
	public ResponseEntity majorupdate(@PathVariable int majorNo,@RequestBody MajorDTO dto) {
		HashMap<String, Object> map =new HashMap<String, Object>();
		int result =majorservice.updateMajor(dto);
		map.put("result", result);
		List<MajorDTO> majorList=majorservice.selectAllMajor();
		map.put("list", majorList);
		if(result==0)
			map.put("msg", "업데이트 실패");
		else
			map.put("msg", "업데이트 성공");
		return new ResponseEntity(map,HttpStatus.OK);
	}
	
	@DeleteMapping("/major/delete/{majorNo}")
	@ResponseBody
	public ResponseEntity majordelete(@PathVariable int majorNo) {
		HashMap<String, Object> map =new HashMap<String, Object>();
		int result =majorservice.deleteMajor(majorNo);
		map.put("result", result);
		List<MajorDTO> majorList=majorservice.selectAllMajor();
		map.put("list", majorList);
		if(result==0)
			map.put("msg", "삭제 실패");
		else
			map.put("msg", "삭제 성공");
		return new ResponseEntity(map,HttpStatus.OK);
	}
	
	@PostMapping("/major/insert")
	@ResponseBody
	public ResponseEntity majorInsert(int majorNo,String majorName) {
		HashMap<String, Object> map =new HashMap<String, Object>();
		int result =majorservice.insertMajor(new MajorDTO(majorNo, majorName));
		map.put("result", result);
		List<MajorDTO> majorList=majorservice.selectAllMajor();
		map.put("list", majorList);
		if(result==0)
			map.put("msg", "등록 실패");
		else
			map.put("msg", "등록 성공");
		return new ResponseEntity(map,HttpStatus.OK);
	}
	
	
	
	}
	


	
	
	
	
//	@RequestMapping("main")
//	public ModelAndView main(ModelAndView view) {
//		view.setViewName("main.do");
//		return view;
//	}
//	@RequestMapping("main.do")
//	public ModelAndView maindo(ModelAndView view,HttpSession session) {
//		List<StudentDTO> studentlist =studentservice.selectAllStudent();
//		List<MajorDTO> majorlist=majorservice.selectAllMajor();
//		view.addObject("studentList", studentlist);
//		System.out.println(studentlist);
//		view.setViewName("main");
//		session.setAttribute("majorList", majorlist);
//		return view;
//	}
	
//	@PostMapping("login.do")
//	public String login(String id, String passwd, HttpSession session) {
//		String id1 = id;
//		String passwd1=passwd;
//		System.out.println(id1);
//		if(id1.equals("admin")&&passwd1.equals("123456")) {		
//			session.setAttribute("login", true);
//			return "main";
//		}
//		else
//			return "index";
//	}
	

