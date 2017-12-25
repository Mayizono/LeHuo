package com.dbconn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class dbTest {

		public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载JDBC驱动 
		public static String dbURL = "jdbc:sqlserver://192.168.23.3:1433; DatabaseName=VolunteerManagement"; //连接服务器和数据库sample 
		public static String userName = "fyc"; //默认用户名 
		public static String userPwd = "123456"; //密码 
		public static Connection dbConn;
	    //装载驱动  
	    static{  
	        try{  
	            Class.forName(driverName);  
	        }  
	        catch(ClassNotFoundException e){  
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
	    
	    //建立数据库连接  
	    public static void main(String[] args){
	    	
	    	
//	    UserRegister ur = new UserRegister();
//	    UserBean ub = new UserBean();
//	    ub.setUserId("te");
//	    ub.setPassword("te1");
//	    ur.setUserBean(ub);
//	    try {
//	       ur.regist();
//	   } catch (Exception e) {
//	     // TODO Auto-generated catch block
//	       e.printStackTrace();
//	   }
	     Connection conn=dbTest.getConnection();  
	     if(conn==null){  
	         System.out.println("数据库连接失败！");  
	     }  else{
	     	System.out.println("数据库连接成功！！"); 
	     }
//	    System.out.println(ur.LoginCheck("te", "te1"));
//	      System.out.println(ur.LoginCheck("u1", "pwd1"));

	        }  
	    //关闭数据库连接  
//	    public static void Close(){  
//	        if(dbConn!=null){  
//	            try{  
//	                dbConn.close();  
//	            }  
//	            catch(SQLException e){  
//	                e.printStackTrace();  
//	            }  
//	        }  
//	    }

//      UserRegister ur = new UserRegister();
//      UserBean ub = new UserBean();
//      ub.setUserId("te");
//      ub.setPassword("te1");
//      ur.setUserBean(ub);
//     try {
//       ur.regist();
//   } catch (Exception e) {
//     // TODO Auto-generated catch block
//       e.printStackTrace();
//   }
//     Connection conn=dbTest.getConnection();  
//     if(conn==null){  
//         System.out.println("数据库连接失败！");  
//     }  else{
//     	System.out.println("数据库连接成功！！"); 
//     }
//    System.out.println(ur.LoginCheck("t3", "te1"));
//      System.out.println(ur.LoginCheck("u1", "pwd1"));
}
