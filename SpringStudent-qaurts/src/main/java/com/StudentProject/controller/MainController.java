package com.StudentProject.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.StudentProject.AutoDatePrintJob;
import com.StudentProject.TestCronTrigger;
import com.StudentProject.dto.MajorDTO;
import com.StudentProject.dto.StudentDTO;
import com.StudentProject.service.MajorService;
import com.StudentProject.service.StudentService;

import batch.SelectStudentLowScore;
import jakarta.servlet.http.HttpSession;



@Controller
public class MainController {

	private StudentService studentService;
	private MajorService majorService;
	public MainController(StudentService studentService, MajorService majorService) {
		this.studentService = studentService;
		this.majorService = majorService;
		TestCronTrigger trigger=new TestCronTrigger("0 0 12 1 1/6 ? *", SelectStudentLowScore.class);
		trigger.triggerJob();
	}



	@RequestMapping("/")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping("/login")
	public String login(String id, String passwd,HttpSession session) {
		if(id.equals("admin") && passwd.equals("123456")) {
			session.setAttribute("login", true);
			return "redirect:/main";
		}
		return "redirect:/";
	}
	@RequestMapping("/main")
	public ModelAndView main(ModelAndView view) {
		//모든 학생 정보
		List<StudentDTO> studentList = studentService.selectAllStudent();
		//모든 학과 정보
		List<MajorDTO> majorList = majorService.selectAllMajor();
		
		view.addObject("studentList", studentList);
		view.addObject("majorList", majorList);
		view.setViewName("main");
		
		return view;
	}
	
	@RequestMapping("/student/delete/{studentNo}")
	public String deleteMember(@PathVariable("studentNo") String studentNo) {
		studentService.deleteStudent(studentNo);
		return "redirect:/main";
	}
	
	@GetMapping("/student/update/{studentNo}")
	public ModelAndView updateStudentView(@PathVariable("studentNo") String studentNo, ModelAndView view) {
		StudentDTO dto = studentService.selectStudent(studentNo);
		List<MajorDTO> majorList = majorService.selectAllMajor();
		view.setViewName("student_update");
		view.addObject("majorList", majorList);

		view.addObject("dto", dto);
		return view;
	}
	
	@PostMapping("/student/update")
	public String updateStudent(StudentDTO dto) {
		studentService.updateStudent(dto);
		return "redirect:/main";
	}
	
	@GetMapping("/student/insert/view")
	public ModelAndView insertStudentView(ModelAndView view) {
		view.setViewName("student_register");
		List<MajorDTO> majorList = majorService.selectAllMajor();
		view.addObject("majorList", majorList);
		return view;
	}
	
	@PostMapping("/student/insert")
	public String insertStudent(StudentDTO dto) {
		studentService.insertStudent(dto);
		return "redirect:/main";
	}
	
	@GetMapping("/major")
	public ModelAndView majorMain(ModelAndView view) {
		view.setViewName("major_main");
		List<MajorDTO> majorList = majorService.selectAllMajor();
		view.addObject("majorList", majorList);
		return view;
	}
	
	@PostMapping("/major/insert")
	@ResponseBody
	public ResponseEntity insertMajor(MajorDTO dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int result = majorService.insertMajor(dto);
		map.put("result", result);
		List<MajorDTO> majorList = majorService.selectAllMajor();
		map.put("list", majorList);
		if(result == 0) {
			map.put("msg", "학과정보 등록 실패");
		}else {
			map.put("msg", "학과정보 등록 성공");
		}
		
		return new ResponseEntity(map,HttpStatus.OK);
	}
	
	@DeleteMapping("/major/delete/{majorNo}")
	@ResponseBody
	public ResponseEntity deleteMajor(@PathVariable int majorNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int result = majorService.deleteMajor(majorNo);
		map.put("result", result);
		List<MajorDTO> majorList = majorService.selectAllMajor();
		map.put("list", majorList);
		if(result == 0) {
			map.put("msg", "학과정보 삭제 실패");
		}else {
			map.put("msg", "학과정보 삭제 성공");
		}
		
		return new ResponseEntity(map,HttpStatus.OK);
	}
	
	@PutMapping("/major/update/{majorNo}")
	@ResponseBody
	public ResponseEntity updateMajor(@RequestBody MajorDTO dto,@PathVariable int majorNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int result = majorService.updateMajor(dto);
		map.put("result", result);
		List<MajorDTO> majorList = majorService.selectAllMajor();
		map.put("list", majorList);
		if(result == 0) {
			map.put("msg", "학과정보 수정 실패");
		}else {
			map.put("msg", "학과정보 수정 성공");
		}
		
		return new ResponseEntity(map,HttpStatus.OK);
	}
	
	@RequestMapping("/student/low-score-list")
	public ResponseEntity<String> studentLowScoreList(){
		List<StudentDTO> list = studentService.selectavgscorestudent();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@RequestMapping("/student/lowscore")
	public ModelAndView lowscore(ModelAndView view) {
		view.setViewName("lowscore");
		return view;
	}
}


















