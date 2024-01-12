package com.studentproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentproject.dto.MajorDTO;
import com.studentproject.dto.StudentDTO;
import com.studentproject.mapper.MajorMapper;
import com.studentproject.mapper.StudentMapper;

@Service
public class MajorService {
	private MajorMapper majorMapper;

	public MajorService(MajorMapper majorMapper) {
		super();
		this.majorMapper = majorMapper;
	}

	public List<MajorDTO> selectAllMajor() {
		return majorMapper.selectAllMajor();
	}

	public int insertMajor(MajorDTO majorDTO) {
		return majorMapper.insertMajor(majorDTO);
	}

	public int updateMajor(MajorDTO majorDTO) {
		return majorMapper.updateMajor(majorDTO);
	}

	public int deleteMajor(int majorNo) {
		return majorMapper.deleteMajor(majorNo);
	}

	
}







