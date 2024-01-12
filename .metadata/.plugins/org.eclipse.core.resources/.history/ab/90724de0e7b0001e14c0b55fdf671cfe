package com.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.student.dto.StudentDTO;

@Mapper
public interface StudentMapper {

	List<StudentDTO> selectAllStudent();
	void deleteStudent(String studentNo);
	StudentDTO selectStudent(String studentNo);
	void updateStudent(StudentDTO dto);
	void insertStudent(StudentDTO dto);

}
