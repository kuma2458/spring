package com.mvc;

public class RegisterDTO {
	private String memberId;
	private String passwd;
	private String name;
	private int age;
	
	public RegisterDTO() {

	}
	
	public RegisterDTO(String memberId, String passwd, String name, int age) {
		super();
		this.memberId = memberId;
		this.passwd = passwd;
		this.name = name;
		this.age = age;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "RegisterDTO [memberId=" + memberId + ", passwd=" + passwd + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
