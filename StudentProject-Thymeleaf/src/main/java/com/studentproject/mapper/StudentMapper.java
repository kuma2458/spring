package com.studentproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.studentproject.dto.StudentDTO;

@Mapper
public interface StudentMapper {


	public List<StudentDTO> selectAllStudent();
 
	public void insertStudent(StudentDTO studentDTO);

	public void deleteStudent(String studentNo);

	public StudentDTO selectStudent(String studentNo);

	public void updateStudent(StudentDTO studentDTO);
	
}
