package com.StudentProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.StudentProject.dto.StudentDTO;

@Mapper
public interface StudentMapper {

	List<StudentDTO> selectAllStudent();
	void deleteStudent(String studentNo);
	StudentDTO selectStudent(String studentNo);
	void updateStudent(StudentDTO dto);
	void insertStudent(StudentDTO dto);
	List<StudentDTO> selectavgscorestudent();

}