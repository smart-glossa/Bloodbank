package com.smartglossa.bloodBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class Blood {

	Connection con = null;
	Statement stat = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public Blood() throws ClassNotFoundException, Exception {
		openConnection();

	}

	public void Reg(String uname, String pass) throws Exception {
		try {
			String query = "insert into reg(uname,pass)values('" + uname + "','" + pass + "')";
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	public void addUser(String uname, String fname, String lname, String bgroup, String pno, String email)
			throws Exception {
		try {
			String query = "insert into user(userName,password,firstName,lastName,bgroup,phoneNumber,emailId)values('"
					+ uname + "','" + bgroup + "','" + fname + "','" + lname + "','" + pno + "','" + email + "')";
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	public void updateUser(String uname, String fname, String lname, String bgroup, String pno, String email)
			throws Exception {
		try {
			String query = "update user set firstName='" + fname + "',lastName='" + lname + "','" + bgroup
					+ "',phoneNumber='" + pno + "',emailId='" + email + "' where userName='" + uname + "'";
			stat.execute(query);
		} finally {
			closeConnection();
		}
	}

	public JSONObject login(String uname, String pass) throws Exception {
		try {
			JSONObject log = new JSONObject();
			String query = "Select uname from reg where uname='" + uname + "' AND pass='" + pass + "'";
			rs = stat.executeQuery(query);
			if (rs.next()) {
				if (uname != "") {
					log.put("username", rs.getString(1));
					log.put("status",1);
				}
			} else {
				log.put("status", "error");

			}
			return log;
		} finally {
			closeConnection();
		}
		
	}

	public JSONArray userAll() throws Exception {
		try {
			JSONArray gets = new JSONArray();
			String query = "Select * from User";
			rs = stat.executeQuery(query);
			while (rs.next()) {
				JSONObject get = new JSONObject();
				get.put("userName", rs.getString(1));
				get.put("fName", rs.getString(3));
				get.put("lName", rs.getString(4));
				get.put("bgroup", rs.getString(5));
				get.put("pno", rs.getString(6));
				get.put("email", rs.getString(7));
				gets.put(get);
			}
			return gets;
		} finally {
			closeConnection();
			// TODO: handle finally clause
		}

	}

	public JSONObject getOne(String bgroup) throws Exception {
		try {
			JSONObject gets = new JSONObject();
			String query = "select * from user where bgroup='" + bgroup + "'";
			rs = stat.executeQuery(query);
			if (rs.next()) {
				gets.put("userName", rs.getString(1));
				gets.put("fName", rs.getString(3));
				gets.put("lName", rs.getString(4));
				gets.put("pno", rs.getString(5));
				gets.put("email", rs.getString(6));
			}
			return gets;
		} finally {
			closeConnection();
		}

	}

	public JSONObject getMsg(String uname) throws Exception {
		try {
			JSONObject gets = new JSONObject();
			String query = "select phoneNumber from user where userName='" + uname + "'";
			rs = stat.executeQuery(query);
			if (rs.next()) {

				gets.put("pno", rs.getString(1));

			}
			return gets;
		} finally {
			closeConnection();
		}

	}

	private void openConnection() throws ClassNotFoundException, Exception {
		Class.forName(BloodConstant.MYSQL_DRIVER);
		con = DriverManager.getConnection(BloodConstant.MYSQL_SERVER + "/" + BloodConstant.DATABASE,
				BloodConstant.USERNAME, BloodConstant.PASSWORD);
		stat = con.createStatement();

	}

	private void closeConnection() throws Exception {

		if (con != null) {
			con.close();
		}
		if (stat != null) {
			stat.close();
		}
		if (rs != null) {
			rs.close();
		}
	}

}
