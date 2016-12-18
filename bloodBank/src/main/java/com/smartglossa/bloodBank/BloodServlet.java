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
			JSONArray user=new JSONArray();
			try {
				Blood userAll = new Blood();
				user = userAll.userAll();
				
			} catch (Exception e) {
				JSONObject obj=new JSONObject();
				obj.put("status", 0);
				e.printStackTrace();
				
			}
			response.getWriter().print(user);
		} else if (op.equals("getonly")) {
			String bgroup= request.getParameter("bgroups");
			JSONArray gets=new JSONArray();
			try {
				Blood one = new Blood();
				gets=one.getOne(bgroup);
			} catch (Exception e) {

				e.printStackTrace();
			}
			response.getWriter().println(gets);
		}else if(op.equals("emails")){
			String unames=request.getParameter("names");
			{
				JSONObject res1 = new JSONObject();
				try {
					Blood lib3 = new Blood();
					res1 = lib3.getone(unames);
				} catch (Exception e) {
					res1.put("status", 0);
					e.printStackTrace();
				}
				response.getWriter().print(res1);
			}
			}else if(op.equals("send")){
				String to = request.getParameter("to");
		        String message =  request.getParameter("message");
		        JSONObject sent=new JSONObject();
		        try {
					Email snd=new Email();
					snd.send(to, message);
				} catch (Exception e) {
					// TODO: handle exception
				}
		        
		       System.out.println("Mail send successfully");
		    }   
		}
	}
