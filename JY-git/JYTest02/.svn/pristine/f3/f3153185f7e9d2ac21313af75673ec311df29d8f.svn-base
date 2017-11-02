package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Struckinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Struck extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 		sid,snote,tid,bid;
	
	
	private String 		sResult	=	"error.jsp",
						sql,
						tmp,
						kindName,
						kindValue,
						sPageCurrent
						;
	
	private int 		operId	   =	0,	//	操作类型;
						nSize	   =	0,	//	长度;
						nItemLimit =	MyConfig.N_PAGE_COUNT,	//	数量限制;
						pageCurrent=	0,	//	当前页数;
						pageCount  =	0,	//	页码计数;
						itemCount  =	0;	//	条目计数;

	
	private ArrayList<Struckinfo>  list;
	private DBTool 				   dbTool	;
	private HttpSession 	  	   session	=	null;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//	数据传输的类型;
		resp.setContentType("text/html;charset=utf-8");
		//	写数据信息操作;
		operId							=	Integer.parseInt(req.getParameter("operid")) ;
		dbTool							=	new DBTool();
		session							=	req.getSession();
		switch (operId) {
		//	操作内容;
		case 1:
		
			break;
		//	04.单条信息删除;
		case 4:
			sid  		= 	req.getParameter("sid");
			sql			=	"delete from struckinfo where sid='"+sid+"'";
			dbTool.doDBUpdate(sql);		
			kindName=(String)session.getAttribute("kindName");
			kindValue=(String)session.getAttribute("kindValue");
			sResult		=	"../../JYTest02/struck_info?operid=6&kindName="+kindName+"&kindValue="+kindValue+"";
			break;
			
		//	02.全信息查询
		case 2:
			sql			=	"select * from struckinfo order by sid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryStruckinfo(sql);
			session.setAttribute("listStruck", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult		=	"struck/struck_all.jsp";
			break;
		//	03.单条信息显示;
		case 3:
			sid 		= 	req.getParameter("sid");
			sql			=	"select * from struckinfo where sid='"+sid+"'";
			list		=	dbTool.doDBQueryStruckinfo(sql);
			session.setAttribute("listStruck", list);
			sResult		=	"struck/struck_detail.jsp";
			
			break;
		//	05.单条信息修改;
		case 5:
			sid 		= 	req.getParameter("sid");
			sql			=	"select * from struckinfo where sid='"+sid+"'";
			list		=	dbTool.doDBQueryStruckinfo(sql);
			session.setAttribute("listStruck", list);
			sResult		=	"struck/struck_update.jsp";
			
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
			sql			=	"select * from struckinfo "+tmp+" order by sid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryStruckinfo(sql);
			
			session.setAttribute("listStruck", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			
			sResult		=	"struck/struck_all.jsp";
			break;
		//	07.全信息删除;
		case 7:
			sql			=	"delete from struckinfo ";
			dbTool.doDBUpdate(sql);
			sql			=	"select * from struckinfo ";
			list		=	dbTool.doDBQueryStruckinfo(sql);
			session.setAttribute("listStruck", list);
			sResult		=	"struck/struck_all.jsp";
			
			break;
		//	08.信息新增;
		case 8:
			sid			=	new String(req.getParameter("sid").getBytes("ISO8859_1"),"utf-8");
			snote		=	new String(req.getParameter("snote").getBytes("ISO8859_1"),"utf-8");
			tid			=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			
			sql	 		=	"insert into struckinfo(sid,snote,tid,bid) " +
							"values(" +
							"'"+sid+"'," +
							""+snote+"," +
							"'"+tid+"'," +
							"'"+bid+"')";
			dbTool.doDBUpdate(sql);
			sql			=	"select * from struckinfo order by sid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryStruckinfo(sql);
			session.setAttribute("listStruck", list);
			session.setAttribute("pageCurrent", "0");
			//	空信息;
			session.setAttribute("kindName", " ");
//			sResult		=	"struck/struck_all.jsp";
			sResult		=	"../../JYTest02/struck_info?operid=3&sid="+sid+"";

			break;
		//	09.信息修改后完成;
		case 9:
			sid			=	new String(req.getParameter("sid").getBytes("ISO8859_1"),"utf-8");
			snote		=	new String(req.getParameter("snote").getBytes("ISO8859_1"),"utf-8");
			tid			=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");

			sql	 		=	"update struckinfo set snote='"+snote+"',tid='"+tid+"',bid='"+bid+"' where sid='"+sid+"'";

			dbTool.doDBUpdate(sql);
					
			sql			=	"select * from struckinfo order by sid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryStruckinfo(sql);
			session.setAttribute("listStruck", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			
//			sResult		=	"struck/struck_all.jsp";
			sResult		=	"../../JYTest02/struck_info?operid=5&sid="+sid+"";
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
				sql			=	"select * from struckinfo "+tmp+" order by sid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryStruckinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listStruck", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					sResult		=	"struck/struck_all.jsp";
				}
			}
			break;
		//	11.下一页;
		case 11:
			kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
			kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
			
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if(kindName.equals(" ")){
				tmp		=	"";
			}else{
				tmp		=	"where "+kindName+"='"+kindValue+"'";
			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from struckinfo "+tmp+" order by sid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryStruckinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listStruck", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult		=	"struck/struck_all.jsp";
				}
			}
			break;
//			12.某一页;
				case 12:
					kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
					kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
					
					sPageCurrent	=	req.getParameter("pageCurrent");
					pageCurrent		=	Integer.parseInt(sPageCurrent);
					
					if(kindName.equals(" ")){
						tmp		=	"";
					}else{
						tmp		=	"where "+kindName+"='"+kindValue+"'";
					}
					if(pageCurrent>=0){
						pageCount	=	(pageCurrent-1);
						itemCount	= 	pageCount*nItemLimit;
						sql			=	"select * from struckinfo "+tmp+" order by sid limit "+itemCount+","+nItemLimit;
						list		=	dbTool.doDBQueryStruckinfo(sql);
						nSize		=	list.size();
						if(nSize>0){					
							session.setAttribute("listStruck", list);
							session.setAttribute("pageCurrent", String.valueOf(pageCount));
							sResult		=	"struck/struck_all.jsp";
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
