package com.boardproject.dto;

import org.apache.ibatis.type.Alias;

@Alias("file")
public class FileDTO {
	private int bno;
	private int fno;
	private String path;
	
	public FileDTO() {}
	public FileDTO(int bno, int fno, String path) {
		super();
		this.bno = bno;
		this.fno = fno;
		this.path = path;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "FileDTO [bno=" + bno + ", fno=" + fno + ", path=" + path + "]";
	}
	
	

}
