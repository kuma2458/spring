package com.boardproject.dto;

import org.apache.ibatis.type.Alias;

@Alias("board")
public class BoardDTO {
	private int bno;
	private String title;
	private String writer;
	private String nick;
	private String date;
	private	int bcount;
	private String content;
	private int blike;
	private int bhate;
	
	public BoardDTO() {
		
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getBcount() {
		return bcount;
	}


	public void setBcount(int bcount) {
		this.bcount = bcount;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getBlike() {
		return blike;
	}


	public void setBlike(int blike) {
		this.blike = blike;
	}


	public int getBhate() {
		return bhate;
	}


	public void setBhate(int bhate) {
		this.bhate = bhate;
	}



	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", nick=" + nick + ", date=" + date
				+ ", bcount=" + bcount + ", content=" + content + ", blike=" + blike + ", bhate=" + bhate +  "]";
	}


	

	
}
