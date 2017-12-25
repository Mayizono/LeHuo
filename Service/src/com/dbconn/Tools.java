package com.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class Tools {

	private UserBean userBean;
	private VolWork volwork;
	private boolean islogin;
	private boolean isRegister;
	static Connection dbConn;
	public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载JDBC驱动 
	public static String dbURL = "jdbc:sqlserver://192.168.23.3:1433; DatabaseName=VolunteerManagement"; //连接服务器和数据库sample 
	public static String userName = "fyc"; //用户名 
	public static String userPwd = "123456"; //密码   
	//数据库连接
	public void UserRegister(){
		
//		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载JDBC驱动 
//		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=youqu"; //连接服务器和数据库sample 
//		String userName = "xue"; //用户名 
//		String userPwd = "miyazono0704"; //密码   

  
            try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
  
	    }
		
	
	
    public static Connection getConnection(){  
        try{  
        	dbConn=DriverManager.getConnection(dbURL,userName,userPwd);  
        }  
        catch(SQLException e){  
            e.printStackTrace();  
        }  
        return dbConn;  
    }  
    
	
	//设置待注册的用户
	public void setUserBean(UserBean userBean){
		this.userBean = userBean;
	}
	
	public void setVolWork(VolWork volwork){
		this.volwork = volwork;
	}
	
	//注册用户
	public void regist() throws Exception{
		String reg = "insert into userinfo(account,password,name,sex,age,idcard,tel,address) values(?,?,?,?,?,?,?,?)";
	     Connection conn=Tools.getConnection();  
//	     if(conn==null){  
//	         System.out.println("数据库连接失败！");  
//	     }  else{
//	     	System.out.println("数据库连接成功！！"); 
//	     }
		try{
			PreparedStatement pstmt = conn.prepareStatement(reg);
			pstmt.setString(1, userBean.getAccount());
			pstmt.setString(2, userBean.getPassword());
			pstmt.setString(3, userBean.getName());
			pstmt.setString(4, userBean.getSex());
			pstmt.setString(5, userBean.getAge());
			pstmt.setString(6, userBean.getIdcard());
			pstmt.setString(7, userBean.getTel());
			pstmt.setString(8, userBean.getAddress());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	
	//登录检测   /////会话
	public boolean LoginCheck(String account,String password){
		try{
		     Connection conn=Tools.getConnection();  
            Statement stmt=dbConn.createStatement();  
        String sql="select * from userinfo where account='"+account+"'and password='"+password+"'";  
        ResultSet rs= stmt.executeQuery(sql); 
        if(rs.next()){
//        	UserBean userbean = new UserBean();
//        	userbean.setUserName(username);
//        	userbean.setPassword(password);
//        }
        	String passwordR = new String(rs.getString("userpwd"));
        	if(passwordR.equals(password)){
        		System.out.println("passwordR");
        		return islogin=true;
        	}
        	else{
        		return islogin=true;
        	}
        }
		}catch(SQLException e){
			e.printStackTrace();
		}
		return islogin;
	}
	
//	userpwd='"+password+"'
	public boolean RegisterCheck(String account){
		try{
		    Connection conn=Tools.getConnection();  
            Statement stmt=dbConn.createStatement();  
        String sql="select * from userinfo where account='"+account;  
        ResultSet rs = stmt.executeQuery(sql); 
        if(rs.next()){
        	String userID = new String(rs.getString("userid"));
        	System.out.println(userID);
        	if(userID.equals(account)){
        		System.out.println(userID);
//        	UserBean ub = new UserBean();
//        	ub.setUserName(username);
//        	ub.setPassword(password);
        	
        		return isRegister=true;
        	}
        	else{
        		return isRegister=false;
        	}
        }
		}catch(SQLException e){
			e.printStackTrace();
		}
		return isRegister;
	}

//查询义工活动
	public JSONArray VolWork(){
		JSONArray ja = new JSONArray();
		try{
		    Connection conn=Tools.getConnection();  
            Statement stmt=dbConn.createStatement();  
        String sql="select * from Prainfo where eventstate = '可参与'";  
        ResultSet rs = stmt.executeQuery(sql); 
        rs.last();
        int len=rs.getRow();
        if(rs.next()){
        	for(int i = 0;i<len;i++){
        	
        	JSONObject js = new JSONObject();
        	
        	String publisher = new String(rs.getString("publisher"));
        	String eventdesp = new String(rs.getString("eventdesp"));
        	String pradate = new String(rs.getString("pradate"));
        	String advnum = new String(rs.getString("advnum"));
        	String realnum = new String(rs.getString("realnum"));
        	
        	js.put("publisher",publisher);
        	js.put("eventdesp",eventdesp);
        	js.put("pradate",pradate);
        	js.put("advnum",advnum);
        	js.put("realnum",realnum);
        	JSONObject json = new JSONObject();
        	json.put("第"+i+"个", js);
        	ja.add(json);
        	}
        }	
//        	System.out.println(userID);
        	
        
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ja;
	}
}
