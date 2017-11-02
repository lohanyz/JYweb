package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Businessinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Business extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 	bid,bname,bkind,bcoman,bgaddress,bgoid,bshipcom,bpretoportday,boxid,boxsize,boxkind,boxbelong,retransway;
	
	private String 	sResult	=	"error.jsp",
					sql,				//	SQL语句
					tmp,				//	字符串组成段;
					kindName,			//	查询键;
					kindValue,			//	查询值;
					sPageCurrent		//	当前页码签;
					;
	
	private int 	operId	   =	0,	//	操作类型;
	   				nSize	   =	0,	//	长度;
	   				nItemLimit =	MyConfig.N_PAGE_COUNT,	//	数量限制;
	   				pageCurrent=	0,	//	当前页数;
	   				pageCount  =	0,	//	页码计数;
	   				itemCount  =	0;	//	条目计数;	

	
	private ArrayList<Businessinfo> list;
	private DBTool  dbTool;
	private HttpSession session	=	null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//	数据传输的类型;
		resp.setContentType("text/html;charset=utf-8");
		//	写数据信息操作;
		operId			=	Integer.parseInt(req.getParameter("operid")) ;
		dbTool			=	new DBTool();
		session			=	req.getSession();
		switch (operId) {
		//	操作内容;
		case 1:
		
			break;
			//	04.单条信息删除;
		case 4:
			bid  		= 	req.getParameter("bid");
			sql			=	"delete from businessinfo where bid='"+bid+"'";
			dbTool.doDBUpdate(sql);	
			kindName=(String)session.getAttribute("kindName");
			kindValue=(String)session.getAttribute("kindValue");
			sResult		=	"../../JYTest02/business_info?operid=6&kindName="+kindName+"&kindValue="+kindValue+"";
			break;
			
			
		//  02.全部查询
		case 2:
			sql			=	"select * from businessinfo order by bid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryBusinessinfo(sql);
			session.setAttribute("listBusiness", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult		=	"business/business_all.jsp";
			break;
		//  03.单条查询
		case 3:
			bid			=	req.getParameter("bid");
			sql			=	"select * from businessinfo where bid='"+bid+"'";
			list		=	dbTool.doDBQueryBusinessinfo(sql);
			session.setAttribute("listBusiness", list);
			sResult		=	"business/business_detail.jsp";
			break;
			//  05.信息修改
		case 5:
			bid			=	req.getParameter("bid");
			sql			=	"select * from businessinfo where bid='"+bid+"'";
			list		=	dbTool.doDBQueryBusinessinfo(sql);
			session.setAttribute("listBusiness", list);
			sResult		=	"business/business_update.jsp";
			break;
			//	06.条件查询;
		case 6:
			kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");
			kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");
			if(kindName.equals(" ")){
				tmp		=	"";
			}else{
				tmp		=	"where "+kindName+" like '"+"%"+kindValue+"%"+"'";
			}
			sql			=	"select * from businessinfo "+tmp+" order by bid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryBusinessinfo(sql);
			
			session.setAttribute("listBusiness", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			sResult		=	"business/business_all.jsp";
			break;
			
			//	13.分类查询;
		case 13:
//			bstate  	= 	new String(req.getParameter("bstate").getBytes("ISO8859_1"),"utf-8");
//					
//			sql			=	"select * from businessinfo where bstate="+bstate+" order by bid limit 0,"+nItemLimit;
//			list		=	dbTool.doDBQueryBusinessinfo(sql);
//			
//			session.setAttribute("listBusiness", list);
//			session.setAttribute("pageCurrent", "0");
//			session.setAttribute("kindName", "bstate");
//			session.setAttribute("kindValue", bstate);
			sResult		=	"business/business_all.jsp";
			break;
		//	07.全信息删除;
		case 7:
			sql			=	"delete from businessinfo ";
			dbTool.doDBUpdate(sql);
			sql			=	"select * from businessinfo ";
			list		=	dbTool.doDBQueryBusinessinfo(sql);
			session.setAttribute("listBusiness", list);
			sResult		=	"business/business_all.jsp";
			break;
		//	08.信息新增;
		case 8:
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
			sql			=	"select * from businessinfo order by bid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryBusinessinfo(sql);
			session.setAttribute("listBusiness", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult		=	"../../JYTest02/business_info?operid=3&bid="+bid+"";
			break;
		//	09.信息修改后完成;
		case 9:
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
					
			sql			=	"select * from businessinfo order by wid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryBusinessinfo(sql);
			session.setAttribute("listBusiness", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
//			sResult		=	"business/business_info.jsp";
			sResult		=	"../../JYTest02/business_info?operid=5&bid="+bid+"";
			break;
		//	10.上一页;
		case 10:
			kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
			kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
			
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			System.out.println("pageCurrent="+pageCurrent);
			if(kindName.equals(" ")){
				tmp		=	"";
			}else{
				tmp		=	"where "+kindName+"='"+kindValue+"'";
			}
			if(pageCurrent>0){
				pageCount	=	(pageCurrent-1);
				itemCount	=	pageCount*nItemLimit;
				sql			=	"select * from businessinfo "+tmp+" order by bid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryBusinessinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listBusiness", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					sResult	=	"business/business_all.jsp";
				}
			}
			break;
		//	11.下一页;
		case 11:
			kindName  		= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
			kindValue  		= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
			
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if(kindName.equals(" ")){
				tmp			=	"";
			}else{
				tmp			=	"where "+kindName+"='"+kindValue+"'";
			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from businessinfo "+tmp+" order by bid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryBusinessinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listBusiness", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult	=	"business/business_all.jsp";
				}
			}
			break;
			//	12 某一页;
			case 12:
				kindName  		= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
				kindValue  		= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
				
				sPageCurrent	=	req.getParameter("pageCurrent");
				pageCurrent		=	Integer.parseInt(sPageCurrent);
				
				if(kindName.equals(" ")){
					tmp			=	"";
				}else{
					tmp			=	"where "+kindName+"='"+kindValue+"'";
				}
				if(pageCurrent>=0){
					pageCount	=	(pageCurrent-1);
					itemCount	= 	pageCount*nItemLimit;
					sql			=	"select * from businessinfo "+tmp+" order by bid limit "+itemCount+","+nItemLimit;
					list		=	dbTool.doDBQueryBusinessinfo(sql);
					nSize		=	list.size();
					if(nSize>0){					
						session.setAttribute("listBusiness", list);
						session.setAttribute("pageCurrent", String.valueOf(pageCount));
						sResult	=	"business/business_all.jsp";
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
