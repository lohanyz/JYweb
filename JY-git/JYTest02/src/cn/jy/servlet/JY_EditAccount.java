package cn.jy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.jy.tool.DBTool;

public class JY_EditAccount extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();
		
		
		String wid = new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
		String wcall = new String(req.getParameter("wcall").getBytes("ISO8859_1"),"utf-8");
		String wpwd = new String(req.getParameter("wpwd").getBytes("ISO8859_1"),"utf-8");
		String wnote = new String(req.getParameter("wnote").getBytes("ISO8859_1"),"utf-8");
	
	
		DBTool dbTool=new DBTool();
		String sql="update workerinfo set wcall='"+wcall+"',wpwd='"+wpwd+"',wnote='"+wnote+"' where wid='"+wid+"'";
		System.out.println("sql="+sql);
		dbTool.doDBUpdate(sql);
		pWriter.print("success")	;
		pWriter.flush();
		pWriter.close();
	}
	
	
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();
		
		String wId = req.getParameter("wid");
		String wPwd = req.getParameter("wpwd");
		System.out.println("wid="+wId);
		System.out.println("wpwd="+wPwd);
		pWriter.flush();
		pWriter.close();
	}

}
