package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mybatis.dto.GradeDTO;

@Mapper
public interface GradeMapper {

	List<GradeDTO> selectAllGrade();

	
}
