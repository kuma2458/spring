package com.boardproject.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boardproject.dto.BoardDTO;
import com.boardproject.dto.FileDTO;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> selectAllboard(HashMap<String, Object> map);

	public int selectboardcount();

	public BoardDTO selectboardcontent(int bno);

	public int boardlikeup(HashMap<String, Object> map);

	public int boardtotallike(int bno);
	public int boardlikedown(HashMap<String, Object> map);

	public int boardhateup(HashMap<String, Object> map);

	public int boardhatedown(HashMap<String, Object> map);

	public int boardtotalhate(int bno);

	public int selectBoardNo();

	public int insertBoard(BoardDTO board);

	public int insertFile(FileDTO e);

	public List<FileDTO> getfilelist(int bno);

	public FileDTO selectfile(HashMap<String, Object> map);

	public int selectImageFileNo();

	public int insertImageFile(FileDTO fileDTO);

	public FileDTO selectImageFile(int fno);

}