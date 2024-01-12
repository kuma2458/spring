package com.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.dto.GradeDTO;
import com.mybatis.dto.MemberDTO;
import com.mybatis.mapper.GradeMapper;
import com.mybatis.mapper.MemberMapper;

@Service
public class MemberService {
	private MemberMapper mapper;
	private GradeMapper grademapper;


	public MemberService(MemberMapper mapper, GradeMapper grademapper) {
		this.mapper = mapper;
		this.grademapper = grademapper;
	}
	
	public List<MemberDTO> selectAllmember() {
		return mapper.selectAllMember();
	}
	public List<GradeDTO> selectAllgrade() {
		return grademapper.selectAllGrade();
	}
	
}
