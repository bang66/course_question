package org.tea.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.midi.Soundbank;

import com.mysql.jdbc.Statement;

public class Server {
	
	
	//关闭连接的方法
	public void closeJdbc(Connection conn,Statement stmt) {
            if(conn!=null){
                try{
                    conn.close();
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        
	}
	
	//教师端登录查询密码
	public String getPass(String id) {
		String passwd="";
		String sql="select passwd from tea where tid= '"+id+"'";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//建立查询
			stmt = (Statement) conn.createStatement();
			//执行sql语句返回rs
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				passwd=rs.getString("passwd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeJdbc(conn, stmt);
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passwd;
	}
	
	
	//教师端注册方法
	public void insertTea(String id,String name,String course,String passwd) {
		String sql="insert into tea(tid,name,course,passwd)value('"+id+"','"+name+"','"+course+"','"+passwd+"')";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tea regist success!");
		closeJdbc(conn, stmt);
	}
	
	
	//手动录入学生信息
	public void insertStu(String id,String name,String classString,String url) {
		String sql="insert into stu(sid,name,classes,pic_url)value('"+id+"','"+name+"','"+classString+"','"+url+"')";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//建立插入
			stmt = (Statement) conn.createStatement();
			//执行sql
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("stu regist success!");
		closeJdbc(conn, stmt);
	}
	
	
	
	//插入学生的缺勤记录
	public void insertTruncy(String cname,String sid) {
		String timestamp=MyUtils.getTimeStamp();
		String sql="insert into event(cname,timestmp,sid,call_state)value('"+cname+"','"+timestamp+"','"+sid+"','0')";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//建立插入
			stmt = (Statement) conn.createStatement();
			//执行sql
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("truncy insert success!");
		closeJdbc(conn, stmt);
	}
	
	
	//插入学生提问信息
	public void insertAsk(String cname,String sid,String quest_state) {
		String timestamp=MyUtils.getTimeStamp();
		String sql="insert into event(cname,timestmp,sid,quest_state)value('"+cname+"','"+timestamp+"','"+sid+"','"+quest_state+"')";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//建立插入
			stmt = (Statement) conn.createStatement();
			//执行sql
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("truncy insert success!");
		closeJdbc(conn, stmt);
	}
	
	
	//查看学生信息记录
	public String disEvent() {
		String all="";
		String sql="select * from event ";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//建立查询
			stmt = (Statement) conn.createStatement();
			//执行sql
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				String cname=rs.getString("cname");
				String timestmp = rs.getString("timestmp");
				String sid=rs.getString("sid");
				String call_state=rs.getString("call_state");
				String quest_state=rs.getString("quest_state");
				if (call_state.equals("0")) {
					all+=cname+" , "+timestmp+" , "+sid+" , "+"缺勤"+" , "+"未回答问题"+"\r\n";
					
				}else {
					if (quest_state==null) {
						all+=cname+" , "+timestmp+" , "+sid+" , "+"已到"+" , "+"未回答问题"+"\r\n";
					}else {
						all+=cname+" , "+timestmp+" , "+sid+" , "+"已到"+" , "+quest_state+"\r\n";
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeJdbc(conn, stmt);
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}
	
	
	//修改学生名字
	public void changeStuName(String id,String name) {
		
		String sql="update stu set name='"+name+"' where sid = '"+id+"'";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		try {
			//建立修改
			stmt = (Statement) conn.createStatement();
			//执行sql
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("stu change name success!");
		closeJdbc(conn, stmt);
	}
		
	
	//修改学生班级
    public void changeStuClass(String id,String classes) {
    	String sql="update stu set classes='"+classes+"' where sid = '"+id+"'";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		try {
			//建立修改
			stmt = (Statement) conn.createStatement();
			//执行sql
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("stu change classes success!");
		closeJdbc(conn, stmt);
	}
    
  //修改学生图片
    public void changeStuPic(String id,String pic) {
    	String sql="update stu set pic_url='"+pic+"' where sid = '"+id+"'";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("stu change pic_url success!");
		closeJdbc(conn, stmt);
		
	}
    
    //获取学生数量
    public int getStuNum() {
		int num=0;
		String sql="select sid from stu ";
		System.out.println(sql);
		Connect connect=new Connect();
		Connection conn=connect.getCon();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt = (Statement) conn.createStatement();
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeJdbc(conn, stmt);
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	

}
