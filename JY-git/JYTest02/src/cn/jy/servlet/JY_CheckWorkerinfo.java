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
import cn.jy.entity.Goodsinfo;
import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;

public class JY_CheckWorkerinfo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private int 		nOperType,
						nSize;
	private String 		wid,
						wname,
						wcall,
						wpwd,
						wnote,
						wtype,
						wpermission,
						sql,
						sOperType,
						sResult="fail"
						;	
	
	private 			ArrayList<Workerinfo> list;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = 	resp.getWriter();
		DBTool 		dbTool	=	new DBTool();
		sOperType			=	req.getParameter("operType"); 
		nOperType			=	Integer.parseInt(sOperType);
		switch (nOperType) {
		//	查询信息
		case 1:
			wid 			= 	req.getParameter("wid");
			sql				=	"select * from workerinfo where wid='" +wid+"' ";
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
						obj.put("wtype", bean.getWtype());
						obj.put("wpermission", bean.getWpermission());
						obj.put("wnote", bean.getWnote());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult=array.toString();
			}		
			else 
				sResult=null;
			break;
		//修改密码
		case 2:
			wid	 	= req.getParameter("wid");
			String pwd	= req.getParameter("pwd");
			wpwd	= req.getParameter("wpwd");
			System.out.println(wpwd);
			sql			=	"select * from workerinfo where wid='"+wid+"' and  wpwd='"+pwd+"'";
			list		=	dbTool.doDBQueryWorkerinfo(sql);
			nSize		=	list.size();
			JSONArray array 	= 	new JSONArray();
			JSONObject obj 	 	= 	new JSONObject();
			if(nSize>0) {				
				sql	 		=	"update workerinfo set wpwd='"+wpwd+"' where wid='"+wid+"' and  wpwd='"+pwd+"'";
				dbTool.doDBUpdate(sql);
				obj.put("message", "密码修改成功！");
				System.out.println("密码修改成功！");
			}
			else{
				obj.put("message", "原始密码错误！");
				System.out.println("原始密码错误！");
			}
			array.add(obj);
			sResult		=	array.toString();
			break;
		default:
			break;
		}


		pWriter.print(sResult)	;
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
