package kr.co.kmarket.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket.dao.AdminDAO;

@WebServlet("/admin/delete.do")
public class AdminDeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo[] = req.getParameterValues("prodNo[]");
		AdminDAO dao = AdminDAO.getInstance();
		int result = 0;
		for(int i = 0; i<prodNo.length; i++) {
			result = dao.deleteAdmin(prodNo[i]);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
		
	}
}
