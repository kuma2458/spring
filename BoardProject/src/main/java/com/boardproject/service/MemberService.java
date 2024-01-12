package com.boardproject.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.boardproject.dto.MemberDTO;
import com.boardproject.mapper.MemberMapper;

@Service
public class MemberService {
	
	private MemberMapper mapper;

	public MemberService(MemberMapper mapper) {
		this.mapper = mapper;
	}

	public MemberDTO login(String id, String passwd) {
		HashMap<String, Object> map=new HashMap<String,Object>();
		map.put("id",id);
		map.put("passwd", passwd);
		return mapper.login(map);
	}
	
	
	
	
}