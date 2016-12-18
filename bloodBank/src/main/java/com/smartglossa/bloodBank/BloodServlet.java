package com.smartglossa.bloodBank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;


public class BloodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		if (op.equals("reg")) {
			String uname = request.getParameter("Name");
			String pass = request.getParameter("password");

			// JSON NEW OBJECT
			JSONObject updte = new JSONObject();
			try {
				Blood obj = new Blood();
				obj.Reg(uname, pass);
				updte.put("status", 1);
			} catch (Exception e) {
				e.printStackTrace();
				updte.put("status", 0);
			}
			response.getWriter().print(updte);
		} else if (op.equals("userAdd")) {
			String uname = request.getParameter("uName");
			String lname = request.getParameter("lname");
			String bgroup = request.getParameter("bgroup");
			int mno = Integer.parseInt( request.getParameter("mno"));
			String email = request.getParameter("email");
			JSONObject obj1 = new JSONObject();
			try {
				Blood user = new Blood();
				user.addUser(uname, lname, bgroup, mno, email);
				obj1.put("status", 1);
			} catch (Exception e) {
				obj1.put("status", 0);
				obj1.put("message", e.getMessage());
				e.printStackTrace();
			}
			response.getWriter().print(obj1);
		} else if (op.equals("login")) {

			String uname = request.getParameter("Names");
			String pass = request.getParameter("pass");
			JSONObject obj = new JSONObject();
			try {
				Blood bog=new Blood();
				if(uname!=""){
					obj = bog.login(uname, pass);
					}else{
						obj.put("status",0);
					}
         	//result.put("message", result);
			} catch (Exception e) {
				obj.put("status", 0);
				obj.put("message", e.getMessage());
				e.printStackTrace();

				// TODO: handle exception
			}
			response.getWriter().print(obj);
		
		}else if (op.equals("getgroup")) {
			String bgroup =request.getParameter("bgroup");
			JSONObject retun = new JSONObject();
			try {
				Blood geton = new Blood();
				JSONArray retuns = geton.retunsons(bgroup);
				retun.put("status", 1);
			} catch (Exception e) {
				retun.put("status", 0);
			}
			response.getWriter().println(retun);
		}else if (op.equals("getAll")) {
			JSONObject obj = new JSONObject();
			try {
				Blood userAll = new Blood();
				JSONArray user = userAll.userAll();
				
			} catch (Exception e) {
				obj.put("status", 0);
				e.printStackTrace();
				// TODO: handle exception
			}
			response.getWriter().print(obj);
		} else if (op.equals("getonly")) {
			String uname = request.getParameter("uName");
			JSONObject obj2 = new JSONObject();
			try {
				Blood one = new Blood();
				one.getOne(uname);
				obj2.put("status", 1);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}