package business.impl;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.BuyUser;
import business.BuyUserRules;
import dataaccess.BuyUserAccess;
import dataaccess.SqlConnection;
import dataaccess.impl.BuyUserAccessImpl;

public class BuyUserRulesImpl implements BuyUserRules {
	BuyUserAccess buyuser=new BuyUserAccessImpl();
	SqlConnection consql=new SqlConnection();
	public boolean addUser(BuyUser buyuser) {
		String sql="insert into BuyUser values('"+buyuser.getName()+"','"+buyuser.getPassword()+"'" +
				",'"+buyuser.getTelePhone()+"','"+buyuser.getEmail()+"','"+buyuser.getTrueName()+"'" +
						",'"+buyuser.getAddress()+"','"+buyuser.getPostBoy()+"','"+buyuser.getPassHint()+"')";
		//System.out.println(sql);
		return this.buyuser.addUser(sql);
	}

	public boolean modifyUser(BuyUser buyuser) {
		// TODO Auto-generated method stub  �޸��û�
		String sql="update BuyUser set Password='"+buyuser.getPassword()+"' where pkid="+buyuser.getId()+"";
		return this.buyuser.updateyUser(sql);
	}

	public boolean removeUser(BuyUser buyuser) {
		// TODO Auto-generated method stubɾ���û�
		String sql="delete BuyUser where pkid="+buyuser.getId()+"";
		return this.buyuser.deleteeUser(sql);
	}

	public ResultSet loginUser(BuyUser buyuser) {
		//�û���½
		String sql="select * from BuyUser where UserName='"+buyuser.getName()+"' and Password='"+buyuser.getPassword()+"'";
		//BuyUser bu=new BuyUser();
		ResultSet rs=this.buyuser.selectUser(sql);		
		return rs;
	}

	public boolean isContaintUser(String name) {
		// TODO Auto-generated method stub
		boolean tag=false;
		String sql="select * from BuyUser where UserName='"+name+"'";
		ResultSet rs=this.buyuser.selectUser(sql);
		try {
			tag=rs.next();//�ж��Ƿ��Ѿ����ڴ�ʱע����û�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//�ر����ݿ�����
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
