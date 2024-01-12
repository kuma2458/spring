package com.boardproject.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boardproject.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	public int registercomment(CommentDTO comment);

	public List<CommentDTO> getcomment(int bno);

	public int commentlikeup(HashMap<String, Object> map);

	public int commentlikedown(HashMap<String, Object> map);

	public int commenttotallike(int cno);

	public int commenthateup(HashMap<String, Object> map);

	public int commenthatedown(HashMap<String, Object> map);

	public int commenttotalhate(int cno);

}
