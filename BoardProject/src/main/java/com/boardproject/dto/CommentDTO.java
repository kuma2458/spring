package com.boardproject.dto;

import org.apache.ibatis.type.Alias;

@Alias("comment")
public class CommentDTO {
	private int cno;
	private String content;
	private String cdate;
	private int bno;
	private String writer;
	private String nick;
	private int clike;
	private int chate;
	
	public CommentDTO() {}

	public CommentDTO(int cno, String content, String cdate, int bno, String writer, String nick, int clike,
			int chate) {
		super();
		this.cno = cno;
		this.content = content;
		this.cdate = cdate;
		this.bno = bno;
		this.writer = writer;
		this.nick = nick;
		this.clike = clike;
		this.chate = chate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public int getClike() {
		return clike;
	}

	public void setClike(int clike) {
		this.clike = clike;
	}

	public int getChate() {
		return chate;
	}

	public void setChate(int chate) {
		this.chate = chate;
	}

	@Override
	public String toString() {
		return "CommentDTO [cno=" + cno + ", content=" + content + ", cdate=" + cdate + ", bno=" + bno + ", writer="
				+ writer + ", nick=" + nick + ", clike=" + clike + ", chate=" + chate + "]";
	}

	


	
	
}
