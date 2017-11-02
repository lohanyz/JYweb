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
import cn.jy.entity.Businessinfo;
import cn.jy.tool.DBTool;

public class JY_CheckBusinessinfo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int 		nOperType,
						nSize;
	private String 		bid,bname,bkind,bcoman,bgaddress,bgoid,bshipcom,bpretoportday,boxid,boxsize,boxkind,boxbelong,retransway;
	private String  	tmp;
	private String  	sql,
						sOperType,
						sResult="fail"
						;	
	ArrayList<Businessinfo> list;

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
			tmp			=	new String(req.getParameter("bid").getBytes("iso-8859-1"),"utf-8");
			if(tmp.indexOf("-")<0)
				bid=tmp;
			else
				bid			=	tmp.substring(0, tmp.indexOf("-"));
			sql			=	"select * from businessinfo where bid='"+bid+"'";
			System.out.println(sql);
			list		=	dbTool.doDBQueryBusinessinfo(sql);
			nSize		=	list.size();
			if(nSize>0){			
				JSONArray array = new JSONArray();
				for (Businessinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("bid", bean.getBid());
						obj.put("bname", bean.getBname());
						obj.put("bkind", bean.getBkind());
						obj.put("bcoman", bean.getBcoman());
						obj.put("bgaddress", bean.getBgaddress());
						obj.put("bgoid", bean.getBgoid());
						obj.put("bshipcom", bean.getBshipcom());
						obj.put("bpretoportday", bean.getBpretoportday());
						obj.put("boxid", bean.getBoxid());
						obj.put("boxsize", bean.getBoxsize());
						obj.put("boxkind", bean.getBoxkind());
						obj.put("boxbelong", bean.getBoxbelong());
						obj.put("retransway", bean.getRetransway());
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
			
		//信息新增
		case 2:
			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			bname		=	new String(req.getParameter("bname").getBytes("ISO8859_1"),"utf-8");
			bkind		=	new String(req.getParameter("bkind").getBytes("ISO8859_1"),"utf-8");	
			bcoman		=	new String(req.getParameter("bcoman").getBytes("ISO8859_1"),"utf-8");
			bgaddress	=	new String(req.getParameter("bgaddress").getBytes("ISO8859_1"),"utf-8");
			bgoid		=	new String(req.getParameter("bgoid").getBytes("ISO8859_1"),"utf-8");
			bshipcom	=	new String(req.getParameter("bshipcom").getBytes("ISO8859_1"),"utf-8");
			bpretoportday	=	new String(req.getParameter("bpretoportday").getBytes("ISO8859_1"),"utf-8");
			boxid		=	new String(req.getParameter("boxid").getBytes("ISO8859_1"),"utf-8");
			boxsize		=	new String(req.getParameter("boxsize").getBytes("ISO8859_1"),"utf-8");
			boxkind		=	new String(req.getParameter("boxkind").getBytes("ISO8859_1"),"utf-8");
			boxbelong	=	new String(req.getParameter("boxbelong").getBytes("ISO8859_1"),"utf-8");
			retransway	=	new String(req.getParameter("retransway").getBytes("ISO8859_1"),"utf-8");
			
			sql	 		=	"insert into businessinfo(bid,bname,bkind,bcoman,bgaddress,bgoid,bshipcom,bpretoportday,boxid,boxsize,boxkind,boxbelong,retransway) " +
							"values(" +
							"'"+bid+"'," +
							"'"+bname+"'," +
							"'"+bkind+"'," +
							"'"+bcoman+"'," +
							"'"+bgaddress+"'," +
							"'"+bgoid+"'," +
							"'"+bshipcom+"'," +
							"'"+bpretoportday+"'," +
							"'"+boxid+"'," +
							"'"+boxsize+"'," +
							"'"+boxkind+"'," +
							"'"+boxbelong+"',"+ 
							"'"+retransway+"')";
			
			dbTool.doDBUpdate(sql);
			sResult="success";
			break;
		
		//修改信息
		case 3:
			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			bname		=	new String(req.getParameter("bname").getBytes("ISO8859_1"),"utf-8");
			bkind		=	new String(req.getParameter("bkind").getBytes("ISO8859_1"),"utf-8");	
			bcoman		=	new String(req.getParameter("bcoman").getBytes("ISO8859_1"),"utf-8");
			bgaddress	=	new String(req.getParameter("bgaddress").getBytes("ISO8859_1"),"utf-8");
			bgoid		=	new String(req.getParameter("bgoid").getBytes("ISO8859_1"),"utf-8");
			bshipcom	=	new String(req.getParameter("bshipcom").getBytes("ISO8859_1"),"utf-8");
			bpretoportday	=	new String(req.getParameter("bpretoportday").getBytes("ISO8859_1"),"utf-8");
			boxid		=	new String(req.getParameter("boxid").getBytes("ISO8859_1"),"utf-8");
			boxsize		=	new String(req.getParameter("boxsize").getBytes("ISO8859_1"),"utf-8");
			boxkind		=	new String(req.getParameter("boxkind").getBytes("ISO8859_1"),"utf-8");
			boxbelong	=	new String(req.getParameter("boxbelong").getBytes("ISO8859_1"),"utf-8");
			retransway	=	new String(req.getParameter("retransway").getBytes("ISO8859_1"),"utf-8");

			sql	 		=	"update businessinfo "
						+ "set bname='"+bname+"',"
						+ "bkind='"+bkind+"',"
						+ "bcoman='"+bcoman+"',"
						+ "bgaddress='"+bgaddress+"',"
						+ "bgoid='"+bgoid+"',"
						+ "bshipcom='"+bshipcom+"',"
						+ "bpretoportday='"+bpretoportday+"',"
						+ "boxid='"+boxid+"',"
						+ "boxsize='"+boxsize+"',"
						+ "boxkind='"+boxkind+"',"
						+ "boxbelong='"+boxbelong+"',"
						+ "retransway='"+retransway+"' "
						+ "where bid='"+bid+"'";

			dbTool.doDBUpdate(sql);
			sResult="success";
			break;		
		//删除信息
		case 4:
			bid = new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			 
			sql			=	"delete from businessinfo where bid='"+bid+"'";

			dbTool.doDBUpdate(sql);
			sResult = "success";
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
