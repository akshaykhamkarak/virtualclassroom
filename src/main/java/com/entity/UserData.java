package com.entity;

public class UserData {

	private String name;
	private String email;
	private String city;
	private String address;
	private String username;
	private String password;
	private String phonenum;
	private String pincode;
	private int postid;
	private String postname;
	private String userid;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(String name, String email, String city, String address, String username, String password,
			String phonenum, String pincode,int postid) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.address = address;
		this.username = username;
		this.password = password;
		this.phonenum = phonenum;
		this.pincode = pincode;
		this.postid=postid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	
	
	
	
}
