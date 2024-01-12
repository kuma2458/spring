package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mybatis.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	List<MemberDTO> selectAllMember();

}
