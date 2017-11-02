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
import cn.jy.entity.Truckinfo;
import cn.jy.tool.DBTool;

public class JY_CheckTruckinfo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int 		nOperType,
						nSize;
	private String 		tid,toil01,wid,bid,
						sql,
						sOperType,
						sResult="fail"
						;	
	ArrayList<Truckinfo> list;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();
		
		DBTool 		dbTool	=	new DBTool();
		sOperType			=	req.getParameter("operType"); 
		nOperType			=	Integer.parseInt(sOperType);
		switch (nOperType) {
		//信息查询
		case 1:
			tid = req.getParameter("tid");
			sql="select * from truckinfo where tid="+tid;
			list=dbTool.doDBQueryTruckinfo(sql);
			nSize=list.size();
			if(nSize>0){			
				JSONArray array = new JSONArray();
				for (Truckinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("tid", bean.getTid());
						obj.put("toil01", bean.getToil01());
						obj.put("wid", bean.getWid());
						obj.put("bid", bean.getBid());
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
			tid	 		=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			toil01		=	new String(req.getParameter("toil01").getBytes("ISO8859_1"),"utf-8");
			wid			=	new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
			bid 		=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
				
			sql	 		=	"insert into truckinfo(tid,toil01,wid,bid) " +
							"values(" +
							"'"+tid+"'," +
							""+toil01+"," +
							"'"+wid+"'," +
							"'"+bid+"')";
			
			dbTool.doDBUpdate(sql);
			sResult="success";
			break;
		
		//修改信息
		case 3:
			tid	 		=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			toil01		=	new String(req.getParameter("toil01").getBytes("ISO8859_1"),"utf-8");
			wid			=	new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
			bid 		=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
				
			sql	 		=	"update truckinfo"
							+ " set "
							+ "toil01="+toil01+","
							+ "wid='"+wid+"',"
							+ "bid='"+bid+"' "
							+ "where tid='"+tid+"'";
			
			dbTool.doDBUpdate(sql);
			sResult="success";
			break;		
		//删除信息
		case 4:
			tid = new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			 
			sql			=	"delete from truckinfo where tid='"+tid+"'";

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;

		default:
			break;
		
		}
		System.out.println("sResult="+sResult);
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
