package cn.jy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;

public class JY_CheckAccount extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int 	nOperType,
					nSize;
	private String  sOperType,
					wid,
					wname,
					wcall,
					wpwd,
					wnote,
					sql,
					sResult="fail"
					;
	private ArrayList<Workerinfo> list;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = 	resp.getWriter();
		DBTool 		dbTool	=	new DBTool();
		sOperType			=	req.getParameter("operType"); 
		nOperType			=	Integer.parseInt(sOperType);
		switch (nOperType) {
		//	登录
		case 1:
			wid 			= 	req.getParameter("wid");
			wpwd 			= 	req.getParameter("wpwd");
			sql				=	"select * from workerinfo where wid='" +wid+"' and wpwd='"+wpwd+"'";
			list			=	dbTool.doDBQueryWorkerinfo(sql);
			nSize			=	list.size();
			if(nSize>0){			
				JSONArray 	   array = new JSONArray();
				for (Workerinfo bean : list) {
					JSONObject obj 	 = new JSONObject();
					try {
						obj.put("wid", bean.getWid());
						obj.put("wname", bean.getWname());
						obj.put("wcall", bean.getWcall());
						obj.put("wpwd", bean.getWpwd());
						obj.put("wnote", bean.getWnote());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult=array.toString();
			}		
			System.out.println("result="+sResult);
			break;
		//	注册;
		case 2:
			//	用户名称;
			wname 			= 	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
			//	用户昵称;
			wcall 			= 	new String(req.getParameter("wcall").getBytes("ISO8859_1"),"utf-8");
			wpwd 			= 	new String(req.getParameter("wpwd").getBytes("ISO8859_1"),"utf-8");
			wid				=	getID();
			wnote			=	"临时";
			sql				=	"insert into workerinfo (wid,wname,wcall,wpwd,wnote,wtype) values ('"+wid+"','"+wname+"','"+wcall+"','"+wpwd+"','"+wnote+"','"+wnote+"')";
			System.out.println(sql);
			dbTool.doDBUpdate(sql);
			
			sResult			=	wid;
			break;
		default:
			break;
		}


		pWriter.print(sResult)	;
		pWriter.flush();
		pWriter.close();
	}
	
	public String getID(){
		String sid=null;
		Calendar Cld=Calendar.getInstance();
		int YY=Cld.get(Calendar.YEAR);
		int mm=Cld.get(Calendar.MONTH)+1;
		int dd=Cld.get(Calendar.DAY_OF_MONTH);
		int h=Cld.get(Calendar.HOUR_OF_DAY);
		int m=Cld.get(Calendar.MINUTE);
		sid=YY+""+mm+dd+h+m;
		return sid;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
