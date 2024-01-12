package com.mvc;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMainController {
	@RequestMapping("/main2")
	public String main() {
		return "index";
	}
	
	@RequestMapping("/callData")
	public ResponseEntity<String> callData(String data) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		HttpStatus status=HttpStatus.OK;
		
		if(data.equals("true"))
			map.put("result", "Exception이 발생하지 않았습니다.");
		else
		{
			map.put("result", "Exception이 발생하였습니다.");
			map.put("errorCode",777);
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity(map,status);
	}
	
	//객체 리턴하면 알아서 JSON 형태로 변환 해줌
	@RequestMapping("/get")
	public MemberDTO get() {
		return new MemberDTO("A0001","123456","홍길동");
	}
	
	@RequestMapping("/map")
	public HashMap<String, Object> returnObject(){
		HashMap<String, Object> map =new HashMap<String, Object>();
		
		map.put("result","Exception이 발생하지 않았습니다");
		ArrayList<MemberDTO> list =new ArrayList<MemberDTO>();
		list.add(new MemberDTO("A0001", "123456", "홍길동"));
		list.add(new MemberDTO("A0002", "123456", "김철수"));
		list.add(new MemberDTO("A0003", "123456", "이영희"));
		list.add(new MemberDTO("A0004", "123456", "박동수"));
		
		map.put("list", list);
		return map;
	}
}