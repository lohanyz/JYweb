package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Truckinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Truck extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String  tid,toil01,wid,bid;

	private String  sResult	=	"error.jsp",
				    sql,
				    tmp,
				    kindName,
				    kindValue,
				    sPageCurrent
				    ;

	
	private int     operId	   =	0,	//	操作类型;
	   				nSize	   =	0,	//	长度;
	   				nItemLimit =	MyConfig.N_PAGE_COUNT,	//	数量限制;
	   				pageCurrent=	0,	//	当前页数;
	   				pageCount  =	0,	//	页码计数;
	   				itemCount  =	0;	//	条目计数;	
	
	
	
	private ArrayList<Truckinfo>  list;
	private DBTool dbTool;
	private HttpSession session	;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//	数据传输的类型;
		resp.setContentType("text/html;charset=utf-8");
		//	写数据信息操作;
		operId				=	Integer.parseInt(req.getParameter("operid")) ;
		dbTool				=	new DBTool();
		session				=	req.getSession();
		switch (operId) {
		//	操作内容;
		case 1:
		
			break;
		
		//	04.单条信息删除;
		case 4:
			tid  		= 	req.getParameter("tid");
			sql			=	"delete from truckinfo where tid='"+tid+"'";
			dbTool.doDBUpdate(sql);	
			kindName=(String)session.getAttribute("kindName");
			kindValue=(String)session.getAttribute("kindValue");
			sResult		=	"../../JYTest02/truck_info?operid=6&kindName="+kindName+"&kindValue="+kindValue+"";
			break;
			
		//	02.主车信息查询;
		case 2:
			sql			=	"select * from truckinfo order by tid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryTruckinfo(sql);
			session.setAttribute("listTruck", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult		=	"truck/truck_all.jsp";
			break;
			
		//	03.单条信息显示;
		case 3:
			tid  		= 	req.getParameter("tid");
			sql			=	"select * from truckinfo where tid='"+tid+"'";
			list		=	dbTool.doDBQueryTruckinfo(sql);
			session.setAttribute("listTruck", list);
			sResult		=	"truck/truck_detail.jsp";
			
			break;
		//	05.单条信息修改;
		case 5:
			tid  		= 	req.getParameter("tid");
			sql			=	"select * from truckinfo where tid='"+tid+"'";
			list		=	dbTool.doDBQueryTruckinfo(sql);
			session.setAttribute("listTruck", list);
			sResult		=	"truck/truck_update.jsp";
			break;
		//	06.条件查询;
		case 6:
			kindName  	= 	req.getParameter("kindName");
			kindValue  	= 	req.getParameter("kindValue");
			if(kindName.equals(" ")){
				tmp		=	"";
			}else{
				tmp		=	"where "+kindName+" like '"+"%"+kindValue+"%"+"'";
			}
			sql			=	"select * from truckinfo "+tmp+" order by tid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryTruckinfo(sql);
			session.setAttribute("listTruck", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);

			sResult		=	"truck/truck_all.jsp";
			break;
		//	07.全信息删除;
		case 7:
			sql			=	"delete from truckinfo ";
			dbTool.doDBUpdate(sql);
			sql			=	"select * from truckinfo ";
			list		=	dbTool.doDBQueryTruckinfo(sql);
			session.setAttribute("listTruck", list);
			sResult		=	"truck/truck_all.jsp";
			break;
		//	08.信息新增;
		case 8:
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
			sql			=	"select * from truckinfo order by tid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryTruckinfo(sql);
			session.setAttribute("listTruck", list);
			session.setAttribute("pageCurrent", "0");
			//	空信息;
			session.setAttribute("kindName", " ");
//			sResult		=	"truck/truck_info.jsp";
			sResult		=	"../../JYTest02/truck_info?operid=3&tid="+tid+"";

			break;
		//	09.信息修改后完成;
		case 9:
			tid	 		=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			toil01		=	new String(req.getParameter("toil01").getBytes("ISO8859_1"),"utf-8");
			wid			=	new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
			bid 		=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			System.out.println("tid="+tid);
			sql	 		=	"update truckinfo set toil01="+toil01+",wid='"+wid+"',bid='"+bid+"' where tid='"+tid+"'";
			dbTool.doDBUpdate(sql);
					
			sql			=	"select * from truckinfo order by tid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryTruckinfo(sql);
			session.setAttribute("listTruck", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
//			sResult		=	"truck/truck_all.jsp";
			sResult		=	"../../JYTest02/truck_info?operid=5&tid="+tid+"";
			break;
		//	10.上一页;
		case 10:
			kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
			kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
			
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if(kindName.equals(" ")){
				tmp		=	"";
			}else{
				tmp		=	"where "+kindName+"='"+kindValue+"'";
			}
			if(pageCurrent>0){
				pageCount	=	(pageCurrent-1);
				itemCount	=	pageCount*nItemLimit;
				sql			=	"select * from truckinfo "+tmp+" order by tid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryTruckinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listTruck", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					sResult		=	"truck/truck_all.jsp";
				}
			}
			break;
		//	11.下一页;
		case 11:
			kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
			kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
			
			sPageCurrent=	req.getParameter("pageCurrent");
			pageCurrent	=	Integer.parseInt(sPageCurrent);
			
			if(kindName.equals(" ")){
				tmp		=	"";
			}else{
				tmp		=	"where "+kindName+"='"+kindValue+"'";
			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from truckinfo "+tmp+" order by tid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryTruckinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listTruck", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult	=	"truck/truck_all.jsp";
				}
			}
			break;
		// 12.某一页;
		case 12:
			kindName = new String(req.getParameter("kindName").getBytes( "ISO8859_1"), "utf-8");
			kindValue = new String(req.getParameter("kindValue").getBytes( "ISO8859_1"), "utf-8");

			sPageCurrent = req.getParameter("pageCurrent");
			pageCurrent = Integer.parseInt(sPageCurrent);

			if (kindName.equals(" ")) {
				tmp = "";
			} else {
				tmp = "where " + kindName + "='" + kindValue + "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent - 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from truckinfo " + tmp + " order by tid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryTruckinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listTruck", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult = "truck/truck_all.jsp";
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
