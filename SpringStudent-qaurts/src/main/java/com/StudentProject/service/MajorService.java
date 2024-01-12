package com.StudentProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentProject.dto.MajorDTO;
import com.StudentProject.mapper.MajorMapper;

@Service
public class MajorService {
	private MajorMapper majorMapper;

	public MajorService(MajorMapper majorMapper) {
		this.majorMapper = majorMapper;
	}

	public List<MajorDTO> selectAllMajor() {
		return majorMapper.selectAllMajor();
	}

	public int insertMajor(MajorDTO dto) {
		return majorMapper.insertMajor(dto);
	}

	public int updateMajor(MajorDTO dto) {
		return majorMapper.updateMajor(dto);
	}

	public int deleteMajor(int majorNo) {
		return majorMapper.deleteMajor(majorNo);
	}
	
	
}








