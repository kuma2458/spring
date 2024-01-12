package com.studentproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentproject.dto.MajorDTO;
import com.studentproject.dto.StudentDTO;
import com.studentproject.mapper.MajorMapper;
import com.studentproject.mapper.StudentMapper;

@Service
public class StudentService {
	private StudentMapper studentMapper;

	public StudentService(StudentMapper studentMapper) {
		super();
		this.studentMapper = studentMapper;
	}



	public List<StudentDTO> selectAllStudent() {
		return studentMapper.selectAllStudent();
	}


	public void insertStudent(StudentDTO studentDTO) {
		studentMapper.insertStudent(studentDTO);
	}

	public void deleteStudent(String studentNo) {
		studentMapper.deleteStudent(studentNo);
	}

	public StudentDTO selectStudent(String studentNo) {
		if(studentNo == null || studentNo.equals(""))
			return null;
		return studentMapper.selectStudent(studentNo);
	}

	public void updateStudent(StudentDTO studentDTO) {
		studentMapper.updateStudent(studentDTO);
	}

}







