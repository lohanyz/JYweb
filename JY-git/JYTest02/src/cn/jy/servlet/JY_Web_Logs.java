package cn.jy.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Editinfo;
import cn.jy.entity.Getgoodsinfo;
import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Logs extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String		bid,wid,wname,gid,operkind,editkind,edittime;
	private int 		eid;
	private String 		sResult	=	"error.jsp",
						sql,
						tmp,
						str,
						kindName,
						kindValue,
						sPageCurrent,
						searchvalue
						;
	private	String[]	strs,
						imgs;
	private int 		operId 	   =	0,	//	操作类型;
			  			nSize	   =	0,	//	长度;
			  			nItemLimit =	MyConfig.N_PAGE_COUNT,	//	数量限制;
			  			pageCurrent=	0,	//	当前页数;
			  			pageCount  =	0,	//	页码计数;
			  			itemCount  =	0;	//	条目计数;	

	private ArrayList<Editinfo> 	list;
	private DBTool 						dbTool;
	private HttpSession 				session	=	null;
	private Workerinfo 					user;
	private MyConfig 					myConfig;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//	数据传输的类型;
		resp.setContentType("text/html;charset=utf-8");
		//	写数据信息操作;
		operId			=	Integer.parseInt(req.getParameter("operid")) ;
		dbTool			=	new DBTool();
		myConfig		=	new MyConfig();
		session			=	req.getSession();
		switch (operId) {
		//	操作内容;
		case 1:
			System.out.println("dss");
			sql			=	"select * from Editinfo order by eid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryEditinfo(sql);
			session.setAttribute("listLogs", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", " ");
			sResult		=	"logs/logs_all.jsp";
			break;
		//查询信息
		case 2:
			searchvalue = new String(req.getParameter("searchvalue").getBytes( "ISO8859_1"), "utf-8");
			str = searchvalue+" ";
			if (str.equals(" ")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where operkind like '" + "%" + strs[0].trim() + "%"
						+ "' and bid like '" + "%" + strs[1].trim() + "%"
						+ "' and gid like '" + "%" + strs[2].trim() + "%"
						+ "' and wid like '" + "%" + strs[3].trim() + "%"
						+ "' and wname like '" + "%" + strs[4].trim() + "%"
						+ "' and edittime like '" + "%" + strs[5].trim() + "%"
						+ "'";
			}
			sql = "select * from Editinfo  " + tmp + " order by eid limit 0," + nItemLimit;
			System.out.println(sql);
			list = dbTool.doDBQueryEditinfo(sql);
			session.setAttribute("listLogs", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", searchvalue);

			sResult		=	"logs/logs_all.jsp";
			break;
		//单条信息
		case 3:
			eid  		= 	Integer.valueOf(req.getParameter("eid"));
			sql			=	"select * from Editinfo where eid='"+eid+"'";
			list		=	dbTool.doDBQueryEditinfo(sql);
			session.setAttribute("listLogs", list);
			sResult		=	"logs/logs_detail.jsp";
			break;
		//04.单条信息删除;
		case 4:
//			eid  		= 	Integer.valueOf(req.getParameter("eid"));
//			sql			=	"delete from Editinfo where eid='"+eid+"'";
//			dbTool.doDBUpdate(sql);		
//			searchvalue=(String)session.getAttribute("searchvalue");
//			pageCurrent=Integer.valueOf((String)session.getAttribute("pageCurrent"));
//			sResult		=	"../../JYTest02/logs_info?operid=8&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			
			searchvalue		=	req.getParameter("searchvalue");
			sPageCurrent 	= 	req.getParameter("pageCurrent");
			pageCurrent 	= 	Integer.parseInt(sPageCurrent);
			eid  		= 	Integer.valueOf(req.getParameter("eid"));
			sql			=	"delete from Editinfo where eid='"+eid+"'";
			dbTool.doDBUpdate(sql);		
			
			str				=	searchvalue+" ";
			System.out.println(pageCurrent);
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where operkind like '" + "%" + strs[0].trim() + "%"
						+ "' and  CONCAT(bid,'-',gid)  like '" + "%" + strs[1].trim() + "%"
						+ "' and wid like '" + "%" + strs[2].trim() + "%"
						+ "' and wname like '" + "%" + strs[3].trim() + "%"
						+ "' and edittime like '" + "%" + strs[4].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from Editinfo " + tmp + " order by eid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryEditinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listLogs", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "logs/logs_all.jsp";
				}
			}
			break;
		//	05.全信息删除;
		case 5:
			searchvalue		=	req.getParameter("searchvalue");
			sPageCurrent 	= 	req.getParameter("pageCurrent");
			pageCurrent 	= 	Integer.parseInt(sPageCurrent);
			
			str   		= 	new String(req.getParameter("id").getBytes("ISO8859_1"),"utf-8");
			strs		=	str.split(",");
			int len=strs.length;
			tmp="";
			for(int i=0;i< len ;i++){
				if(i==len-1)
					tmp	+=	"eid="+strs[i]+" ";
				else
					tmp	+=	"eid="+strs[i]+" or ";
			}
			sql			=	"delete from Editinfo where "+tmp;
			dbTool.doDBUpdate(sql);
			
			str				=	searchvalue+" ";
			System.out.println(pageCurrent);
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where operkind like '" + "%" + strs[0].trim() + "%"
						+ "' and  CONCAT(bid,'-',gid)  like '" + "%" + strs[1].trim() + "%"
						+ "' and wid like '" + "%" + strs[2].trim() + "%"
						+ "' and wname like '" + "%" + strs[3].trim() + "%"
						+ "' and edittime like '" + "%" + strs[4].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from Editinfo " + tmp + " order by eid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryEditinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listLogs", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "logs/logs_all.jsp";
				}
			}
//			sResult		=	"../../JYTest02/logs_info?operid=8&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			break;
		//	6.上一页;
		case 6:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where operkind like '" + "%" + strs[0].trim() + "%"
						+ "' and  CONCAT(bid,'-',gid)  like '" + "%" + strs[1].trim() + "%"
						+ "' and wid like '" + "%" + strs[2].trim() + "%"
						+ "' and wname like '" + "%" + strs[3].trim() + "%"
						+ "' and edittime like '" + "%" + strs[4].trim() + "%"
						+ "'";
			}
			
			if(pageCurrent>0){
				pageCount	=	(pageCurrent-1);
				itemCount	=	pageCount*nItemLimit;
				sql			=	"select * from Editinfo "+tmp+" order by eid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryEditinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listLogs", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					session.setAttribute("searchvalue", searchvalue);
					sResult		=	"logs/logs_all.jsp";
				}
			}
			break;
		//	7.下一页;
		case 7:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where operkind like '" + "%" + strs[0].trim() + "%"
						+ "' and  CONCAT(bid,'-',gid)  like '" + "%" + strs[1].trim() + "%"
						+ "' and wid like '" + "%" + strs[2].trim() + "%"
						+ "' and wname like '" + "%" + strs[3].trim() + "%"
						+ "' and edittime like '" + "%" + strs[4].trim() + "%"
						+ "'";
			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from Editinfo "+tmp+" order by eid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryEditinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listLogs", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult		=	"logs/logs_all.jsp";
				}
			}
			break;
		//	8.某一页;
		case 8:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent = req.getParameter("pageCurrent");
			pageCurrent = Integer.parseInt(sPageCurrent);

			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where operkind like '" + "%" + strs[0].trim() + "%"
						+ "' and  CONCAT(bid,'-',gid)  like '" + "%" + strs[1].trim() + "%"
						+ "' and wid like '" + "%" + strs[2].trim() + "%"
						+ "' and wname like '" + "%" + strs[3].trim() + "%"
						+ "' and edittime like '" + "%" + strs[4].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent - 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from Editinfo " + tmp + " order by eid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryEditinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listLogs", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult		=	"logs/logs_all.jsp";
				}
			}
			break;
		default:
			break;
		}
		resp.sendRedirect(sResult);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
