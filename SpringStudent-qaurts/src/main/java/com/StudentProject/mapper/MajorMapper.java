package com.StudentProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.StudentProject.dto.MajorDTO;

@Mapper
public interface MajorMapper {

	List<MajorDTO> selectAllMajor();

	int insertMajor(MajorDTO dto);

	int updateMajor(MajorDTO dto);

	int deleteMajor	(int majorNo);

}
