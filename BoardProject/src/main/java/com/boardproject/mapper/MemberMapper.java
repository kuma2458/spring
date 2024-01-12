package com.boardproject.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.boardproject.dto.MemberDTO;

@Mapper
public interface MemberMapper {


	public MemberDTO login(HashMap<String, Object> map);

}
