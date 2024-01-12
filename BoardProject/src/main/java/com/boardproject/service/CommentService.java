package com.boardproject.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boardproject.dto.CommentDTO;
import com.boardproject.mapper.CommentMapper;

@Service
public class CommentService {
	private CommentMapper mapper;

	public CommentService(CommentMapper mapper) {
		this.mapper = mapper;
	}


	public int registercomment(CommentDTO comment) {
		return mapper.registercomment(comment);
	}


	public List<CommentDTO> getcomment(int bno) {
		return mapper.getcomment(bno);
	}


	public int commentlikeup(String id, int cno) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("id", id);
		map.put("cno", cno);
		return mapper.commentlikeup(map);
	}


	public int commentlikedown(String id, int cno) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("id", id);
		map.put("cno", cno);
		return mapper.commentlikedown(map);
	}


	public int commenttotallike(int cno) {
		return mapper.commenttotallike(cno);
	}


	public int commenthateup(String id, int cno) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("id", id);
		map.put("cno", cno);
		return mapper.commenthateup(map);
		
	}
	
	public int commenthatedown(String id, int cno) {
		HashMap<String, Object> map =new HashMap<String,Object>();
		map.put("id", id);
		map.put("cno", cno);
		return mapper.commenthatedown(map);
	}


	public int commenttotalhate(int cno) {
		return mapper.commenttotalhate(cno);
	}
	
}