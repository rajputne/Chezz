package business.impl;

import dataaccess.LeaveWordAccess;
import dataaccess.impl.LeaveWordAccessImpl;
import entities.LeaveWord;
import business.LeaveWordRules;

public class LeaveWordRulesImpl implements LeaveWordRules {
	LeaveWordAccess leave=new LeaveWordAccessImpl();
	public boolean saveLeave(LeaveWord leaveword) {
		// TODO Auto-generated method stub
		
		String sql="insert into LeaveWord values("+leaveword.getBUserid()+",'"+leaveword.getContent()+"'," +
				"'"+leaveword.getLtime()+"')";
		return this.leave.addLeaveWord(sql);
	}

}
