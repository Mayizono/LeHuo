package com.dbconn;

public class UserBean {

	private String account;
	private String password;
	private String name;
	private String sex;
	private String age;
	private String idcard;
	private String tel;
	private String address;
	
	public UserBean(String account, String password,String name,String sex,
            String age,String idcard,String tel,String address){
		this.account = account;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.idcard = idcard;
		this.tel = tel;
		this.address = address;
	}
	
	public void setAccount(String account){
		this.account = account;
	}
	public String getAccount(){
		return this.account;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return this.sex;
	}
	
	public void setAge(String age){
		this.age = age;
	}
	public String getAge(){
		return this.age;
	}
	
	public void setIdcard(String idcard){
		this.idcard = idcard;
	}
	public String getIdcard(){
		return this.idcard;
	}
	
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getTel(){
		return this.tel;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
}
