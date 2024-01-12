package ex.spring.di;

public class MemberDTO {
	private String memberID;
	private String memberPass;
	private String memberName;
	private int age;
	private String gender;
	private int gradeNo;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String memberID, String memberPass, String memberName, int age, String gender, int gradeNo) {
		super();
		this.memberID = memberID;
		this.memberPass = memberPass;
		this.memberName = memberName;
		this.age = age;
		this.gender = gender;
		this.gradeNo = gradeNo;
		System.out.println("한번만 출력되나요?");
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}
	
	
	
}
