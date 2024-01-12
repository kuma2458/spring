package com.studentproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.studentproject.dto.MajorDTO;

@Mapper
public interface MajorMapper {

	public List<MajorDTO> selectAllMajor();
	public int insertMajor(MajorDTO majorDTO);
	public int updateMajor(MajorDTO majorDTO);
	public int deleteMajor(int majorNo);

}
