package com.ssafy;

public class Member {
//서로 관련있는 속성을 묶는 클래스
	private String name;
	private int age;
	private String email;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

//	@Override
//    public String toString() {
//	  //return super.toString();
//	  return "[이름은 "+name+"이고 나이는 "+age+
//			  "이고 이메일은 "+email+"입니다]";
//	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", email=" + email + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
    
}




