package business;

import java.sql.ResultSet;
import entities.SellUser;

public interface SellUserRules {
	//拍卖用户接口
	public boolean  addUser(SellUser sellUser);
	public boolean  modifyUser(SellUser sellUser);
	public boolean  removeUser(SellUser sellUser);
	public ResultSet loginUser(SellUser sellUser);
	public boolean isContaintUser(String name);

}
