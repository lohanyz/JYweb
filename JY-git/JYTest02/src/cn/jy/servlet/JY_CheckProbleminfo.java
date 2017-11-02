package cn.jy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.jy.entity.Probleminfo;
import cn.jy.tool.DBTool;

public class JY_CheckProbleminfo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int 		nOperType,
						nSize;
	private String 		pid,bid,wid,wname,pcity,poper,pstate,pexception,ptime,pimg,
						sql,
						sOperType,
						sResult="fail";	
	ArrayList<Probleminfo> list;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = 	resp.getWriter();	
		DBTool 		dbTool	=	new DBTool();
		sOperType			=	req.getParameter("operType"); 
		nOperType			=	Integer.parseInt(sOperType);
		
		switch (nOperType) {
		
		//信息查询
		case 1:
			pid  		= 	req.getParameter("pid");
			sql			=	"select * from probleminfo where pid="+pid;
			list		=	dbTool.doDBQueryProbleminfo(sql);
			nSize=list.size();
			if(nSize>0){			
				JSONArray array = new JSONArray();
				for (Probleminfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("bid", bean.getBid());
						obj.put("pid", bean.getPid());
						obj.put("wid", bean.getWid());
						obj.put("wname", bean.getWname());
						obj.put("pcity", bean.getPcity());
						obj.put("poper", bean.getPoper());
						obj.put("pstate", bean.getPstate());
						obj.put("pexception", bean.getPexception());
						obj.put("ptime", bean.getPtime());
						obj.put("pimg", bean.getPimg());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult=array.toString();
			}		
			break;
		
		//信息新增
		case 2:
			bid 	= 	req.getParameter("bid");
			wid 	= 	req.getParameter("wid");
			wname	= 	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
			pcity 	= 	new String(req.getParameter("pcity").getBytes("ISO8859_1"),"utf-8");
			poper 	= 	new String(req.getParameter("poper").getBytes("ISO8859_1"),"utf-8");
			pstate 	= 	new String(req.getParameter("pstate").getBytes("ISO8859_1"),"utf-8");
			pexception = 	new String(req.getParameter("pexception").getBytes("ISO8859_1"),"utf-8");
			ptime 	= 	new String(req.getParameter("ptime").getBytes("ISO8859_1"),"utf-8");
			pimg 	= 	new String(req.getParameter("pimg").getBytes("ISO8859_1"),"utf-8");
			
			String		sql		= "insert into probleminfo (" +
								"bid,wid,wname,pcity,poper,pstate,pexception,ptime,pimg) values (" +
								"'"+bid+"'," +
								"'"+wid+"',"+ 
								"'"+wname+"'," +
								"'"+pcity+"'," +
								"'"+poper+"'," +
								"'"+pstate+"'," +
								"'"+pexception+"'," +
								"'"+ptime+"'," +
								"'"+pimg+"')"; 
			
			dbTool.doDBUpdate(sql);
			sResult="success";
			break;
			
		//信息修改
		case 3:
			pid		= 	req.getParameter("pid");
			bid 	= 	req.getParameter("bid");
			wid 	= 	req.getParameter("wid");
			wname	= 	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
			pcity 	= 	new String(req.getParameter("pcity").getBytes("ISO8859_1"),"utf-8");
			poper 	= 	new String(req.getParameter("poper").getBytes("ISO8859_1"),"utf-8");
			pstate 	= 	new String(req.getParameter("pstate").getBytes("ISO8859_1"),"utf-8");
			pexception = 	new String(req.getParameter("pexception").getBytes("ISO8859_1"),"utf-8");
			ptime 	= 	new String(req.getParameter("ptime").getBytes("ISO8859_1"),"utf-8");
			pimg 	= 	new String(req.getParameter("pimg").getBytes("ISO8859_1"),"utf-8");
					
			sql		=	"update probleminfo set " 
						+"bid='"+bid+"',"
						+ "wid='"+wid+"',"
						+ "wname='"+wname+"',"
						+ "pcity='"+pcity+"',"
						+ "poper='"+poper+"',"
						+ "pstate='"+pstate+"',"
						+ "pexception='"+pexception+"',"
						+ "ptime='"+ptime+"',"
						+ "pimg='"+pimg+"' "
						+ "where pid='"+pid+"'";
			
			dbTool.doDBUpdate(sql);
			sResult="success";
			break;
			
		default:
			break;
		}
		
		
		
		pWriter.print("success");
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
