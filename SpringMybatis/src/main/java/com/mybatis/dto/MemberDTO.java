package com.mybatis.dto;

import org.apache.ibatis.type.Alias;

@Alias("member")
public class MemberDTO {
	private String memberId;
	private String memberPasswd;
	private String memberName;
	private int memberAge;
	private String memberGender;
	private int gradeNo;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String memberId, String memberPasswd, String memberName, int memberAge, String memberGender,
			int gradeNo) {
		super();
		this.memberId = memberId;
		this.memberPasswd = memberPasswd;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.memberGender = memberGender;
		this.gradeNo = gradeNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPasswd() {
		return memberPasswd;
	}

	public void setMemberPasswd(String memberPasswd) {
		this.memberPasswd = memberPasswd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public int getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberPasswd=" + memberPasswd + ", memberName=" + memberName
				+ ", memberAge=" + memberAge + ", memberGender=" + memberGender + ", gradeNo=" + gradeNo + "]";
	}
	
	
}
