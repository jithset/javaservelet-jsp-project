package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import utils.Utils.Constants;

public class Utils {
	static Map<String, String> currentUser = new HashMap();
	public static int customer_id, employee_id;
	public static Map getCurrentUser() {
		return currentUser;
	}
	public static void setCurrentUser(ResultSet resultSet) {
		try {
			int account_id = resultSet.getInt(1);
			int account_usertype_id = resultSet.getInt(2);
			String username = resultSet.getString(3);
			currentUser.put("account_id", account_id+"");
			currentUser.put("account_usertype_id", account_usertype_id+"");
			currentUser.put("username", username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static class Constants {
		public static final String account_id = "account_id";
		public static final String username = "username";
		public static final String usertype_id = "account_usertype_id";
		
	}
	
	public static int getCurrentUserId() {
		String id = currentUser.get(Constants.account_id);
		return Integer.parseInt(id);
	}
	public static int getCustomer_id() {
		return customer_id;
	}
	public static void setCustomer_id(int customer_id) {
		Utils.customer_id = customer_id;
	}
	public static int getEmployee_id() {
		return employee_id;
	}
	public static void setEmployee_id(int employee_id) {
		Utils.employee_id = employee_id;
	}	
	
	
	public class Status {
		public static final int pending =1;
		public static final int processing =2;
		public static final int dispatched =3;
		public static final int delivered =4;
		
	}
	
}
