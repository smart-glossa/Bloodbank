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

	public void addUser(String uname, String lname, String bgroup, int mno, String email) throws Exception {
		try {
			String query = "insert into orders(uname,lname,bgroup,mno,email)values('" + uname + "','" + lname + "','"
					+ bgroup + "'," + mno + ",'" + email + "')";
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
					log.put("status", 1);
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
			String query = "Select * from orders";
			rs = stat.executeQuery(query);
			while (rs.next()) {
				JSONObject get = new JSONObject();
				get.put("Name", rs.getString(2));
				get.put("lName", rs.getString(3));
				get.put("bgroup", rs.getString(4));
				get.put("mno", rs.getString(5));
				get.put("email", rs.getString(6));
				gets.put(get);
			}
			return gets;
		} finally {
			closeConnection();
			// TODO: handle finally clause
		}

	}

	public JSONArray getOne(String bgroup) throws Exception {
		try {
			JSONArray getss = new JSONArray();
			String query = "select * from orders where bgroup='" + bgroup + "'";
			rs = stat.executeQuery(query);
			while (rs.next()) {
				JSONObject oder = new JSONObject();
				oder.put("Name", rs.getString(2));
				oder.put("lName", rs.getString(3));
				oder.put("bg", rs.getString(4));
				oder.put("pno", rs.getString(5));
				oder.put("email", rs.getString(6));
				getss.put(oder);
			}
			return getss;
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

	public JSONArray retunsons(String bgroup) {
		JSONArray ss = new JSONArray();
		try {

			Statement stat = con.createStatement();
			String query = "select * from orders where bgroup=" + bgroup + "";
			ResultSet rs = stat.executeQuery(query);
			while (rs.next()) {
				JSONObject one = new JSONObject();
				one.put("Name", rs.getInt(1));
				one.put("bgroup", rs.getDate(2));
				one.put("mno", rs.getInt(3));
				one.put("email", rs.getDate(4));
				ss.put(one);

			}
		} catch (Exception e) {

		}
		return ss;

	}
	public JSONObject getone(String unames) {
		JSONObject res1 = new JSONObject();
		try {
			Statement stat = con.createStatement();
			String query = "select email from orders where uname=" +unames;
			ResultSet rset = stat.executeQuery(query);
			if (rset.next()) {
				
				res1.put("email", rset.getString(8));
				
			}
		} catch (Exception e) {

		}
		return res1;
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
