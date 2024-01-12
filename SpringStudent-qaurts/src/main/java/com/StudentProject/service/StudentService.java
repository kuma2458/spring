package com.StudentProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentProject.dto.StudentDTO;
import com.StudentProject.mapper.StudentMapper;

@Service
public class StudentService {
	private StudentMapper studentMapper;

	public StudentService(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	public List<StudentDTO> selectAllStudent() {
		return studentMapper.selectAllStudent();
	}

	public void deleteStudent(String studentNo) {
		studentMapper.deleteStudent(studentNo);
	}

	public StudentDTO selectStudent(String studentNo) {
		return studentMapper.selectStudent(studentNo);
	}

	public void updateStudent(StudentDTO dto) {
		studentMapper.updateStudent(dto);
	}

	public void insertStudent(StudentDTO dto) {
		studentMapper.insertStudent(dto);
	}

	public List<StudentDTO> selectavgscorestudent() {
		return studentMapper.selectavgscorestudent();
	}
	
	
}






