package business;

import java.sql.ResultSet;

import entities.BuyUser;

public interface BuyUserRules {
	public boolean  addUser(BuyUser buyuser);
	public boolean  modifyUser(BuyUser buyuser);
	public boolean  removeUser(BuyUser buyuser);
	public ResultSet loginUser(BuyUser buyuser);
	public boolean isContaintUser(String name);

}
