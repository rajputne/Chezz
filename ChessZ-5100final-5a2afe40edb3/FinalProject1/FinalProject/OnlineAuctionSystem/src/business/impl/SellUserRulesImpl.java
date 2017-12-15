package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dataaccess.SellUserAccess;
import dataaccess.SqlConnection;
import dataaccess.impl.SellUserAccessImpl;
import entities.SellUser;
import business.SellUserRules;

public class SellUserRulesImpl implements SellUserRules {

	SellUserAccess sUser=new SellUserAccessImpl();
	SqlConnection consql=new SqlConnection();
	public boolean addUser(SellUser sellUser) {
		// TODO Auto-generated method stub
		String sql="insert into SellUser values('"+sellUser.getUsername()+"','"+sellUser.getPassword()+"'" +
		",'"+sellUser.getTetlePhone()+"','"+sellUser.getEMail()+"','"+sellUser.getTrueName()+"'" +
				",'"+sellUser.getAddress()+"','"+sellUser.getPostBoy()+"','"+sellUser.getPassHint()+"',"+0+")";
		//System.out.println(sql);
		return this.sUser.addUser(sql);
	}

	public boolean modifyUser(SellUser sellUser) {
		// TODO Auto-generated method stub
		String sql="update SellUser set Password='"+sellUser.getPassword()+"' where pkid="+sellUser.getId()+"";
		return this.sUser.updateyUser(sql);
	}

	public boolean removeUser(SellUser sellUser) {
		// TODO Auto-generated method stub
		String sql="delete SellUser where pkid="+sellUser.getId()+"";
		return this.sUser.deleteeUser(sql);
	}

	public ResultSet loginUser(SellUser sellUser) {
		// TODO Auto-generated method stub
		String sql="select * from SellUser where UserName='"+sellUser.getUsername()+"' and Password='"+sellUser.getPassword()+"'";
		ResultSet rs=this.sUser.selectUser(sql);		
		return rs;
	}

	public boolean isContaintUser(String name) {
		// TODO Auto-generated method stub
		boolean tag=false;
		String sql="select * from SellUser where UserName='"+name+"'";
		ResultSet rs=this.sUser.selectUser(sql);
		try {
			tag=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//关闭数据库连接
			try {
				this.consql.sqlCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tag;
	}
	
}
