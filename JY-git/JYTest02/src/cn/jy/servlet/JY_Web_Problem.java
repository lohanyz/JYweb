package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Probleminfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Problem extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 		pid;
	private String		bid,wid,wname,pcity,poper,pstate,pexception,ptime,pimg;
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
	
	
	private ArrayList<Probleminfo> list;
	private DBTool		  dbTool;
	private HttpSession   session	=	null;
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
			pid  		= 	req.getParameter("pid");
			sql			=	"delete from probleminfo where pid="+pid;
			dbTool.doDBUpdate(sql);	
			kindName=(String)session.getAttribute("kindName");
			kindValue=(String)session.getAttribute("kindValue");
			sResult		=	"../../JYTest02/problem_info?operid=6&kindName="+kindName+"&kindValue="+kindValue+"";
			break;
		case 2:
			sql			=	"select * from probleminfo order by pid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryProbleminfo(sql);
			session.setAttribute("listProblem", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult		=	"problem/problem_all.jsp";
			
			break;
		case 3:
			pid 		= 	req.getParameter("pid");
			sql			=	"select * from probleminfo where pid="+pid;
			list		=	dbTool.doDBQueryProbleminfo(sql);
			session.setAttribute("listProblem", list);
			sResult		=	"problem/problem_detail.jsp";
			
			break;
		case 5:
			pid 		= 	req.getParameter("pid");
			sql			=	"select * from probleminfo where pid="+pid+"";
			list		=	dbTool.doDBQueryProbleminfo(sql);
			session.setAttribute("listProblem", list);
			sResult		=	"problem/problem_update.jsp";
			
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
			sql			=	"select * from probleminfo "+tmp+" order by pid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryProbleminfo(sql);
			
			session.setAttribute("listProblem", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			sResult		=	"problem/problem_all.jsp";
			break;
		// 13.分类查询;
		case 13:
			kindName = new String(req.getParameter("kindName").getBytes( "ISO8859_1"), "utf-8");
			kindValue = new String(req.getParameter("kindValue").getBytes( "ISO8859_1"), "utf-8");
			if (kindName.equals(" ")) {
				tmp = "";
			} else {
				tmp = "where " + kindName + " ='" + kindValue + "'";
			}
			sql = "select * from probleminfo " + tmp + " order by pid limit 0," + nItemLimit;
			list = dbTool.doDBQueryProbleminfo(sql);

			session.setAttribute("listProblem", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			sResult = "problem/problem_all.jsp";
			break;
		//	07.全信息删除;
		case 7:
			sql			=	"delete from probleminfo ";
			dbTool.doDBUpdate(sql);
			sql			=	"select * from probleminfo ";
			list		=	dbTool.doDBQueryProbleminfo(sql);
			session.setAttribute("listProblem", list);
			sResult		=	"problem/problem_all.jsp";
			break;
		//增加
		case 8:
			bid 	= 	req.getParameter("bid");
			wid 	= 	req.getParameter("wid");
			wname	= 	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
			pcity 	= 	new String(req.getParameter("pcity").getBytes("ISO8859_1"),"utf-8");
			poper 	= 	new String(req.getParameter("poper").getBytes("ISO8859_1"),"utf-8");
			pstate 	= 	new String(req.getParameter("pstate").getBytes("ISO8859_1"),"utf-8");
			if(pstate.equals("exception"))
				pexception = 	new String(req.getParameter("pexception").getBytes("ISO8859_1"),"utf-8");
			else
				pexception =	null;
			
			ptime 	= 	new String(req.getParameter("ptime").getBytes("ISO8859_1"),"utf-8");
//			pimg 	= 	new String(req.getParameter("pimg").getBytes("ISO8859_1"),"utf-8");
			pimg	=	"oil/images/1.jpg";
			
			sql		=	"insert into probleminfo (" +
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
			
			sql			=	"select * from probleminfo order by pid desc limit 1";
			list		=	dbTool.doDBQueryProbleminfo(sql);
			sResult		=	"../../JYTest02/problem_info?operid=3&pid="+list.get(0).getPid()+"";
			break;
			
		//修改完成后
		case 9:
			pid		=	req.getParameter("pid");
			bid 	= 	req.getParameter("bid");
			wid 	= 	req.getParameter("wid");
			wname	= 	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
			pcity 	= 	new String(req.getParameter("pcity").getBytes("ISO8859_1"),"utf-8");
			poper 	= 	new String(req.getParameter("poper").getBytes("ISO8859_1"),"utf-8");
			pstate 	= 	new String(req.getParameter("pstate").getBytes("ISO8859_1"),"utf-8");
			pexception = 	new String(req.getParameter("pexception").getBytes("ISO8859_1"),"utf-8");
			ptime 	= 	new String(req.getParameter("ptime").getBytes("ISO8859_1"),"utf-8");
//			pimg 	= 	new String(req.getParameter("pimg").getBytes("ISO8859_1"),"utf-8");
			pimg	=	"oil/images/1.jpg";
			sql		=	"update probleminfo set " +
						"bid='"+bid+"',wid='"+wid+"',wname='"+wname+"',pcity='"+pcity+"',poper='"+poper+"',"
						+ "pstate='"+pstate+"',pexception='"+pexception+"',ptime='"+ptime+"',pimg='"+pimg+"' "
						+ "where pid='"+pid+"'";
			dbTool.doDBUpdate(sql);
			sResult		=	"../../JYTest02/problem_info?operid=5&pid="+pid+"";
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
				sql			=	"select * from probleminfo "+tmp+" order by pid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryProbleminfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listProblem", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					sResult	=	"problem/problem_all.jsp";
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
				tmp		=	"";
			}else{
				tmp		=	"where "+kindName+"='"+kindValue+"'";
			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from probleminfo "+tmp+" order by pid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryProbleminfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listWorker", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult		=	"problem/problem_all.jsp";
				}
			}
			break;
//			11.某一页;
				case 12:
					kindName  		= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
					kindValue  		= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
					
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
						sql			=	"select * from probleminfo "+tmp+" order by pid limit "+itemCount+","+nItemLimit;
						list		=	dbTool.doDBQueryProbleminfo(sql);
						nSize		=	list.size();
						if(nSize>0){					
							session.setAttribute("listWorker", list);
							session.setAttribute("pageCurrent", String.valueOf(pageCount));
							sResult		=	"problem/problem_all.jsp";
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
		resp.setContentType("text/html;charset=utf-8");
		doGet(req, resp);
	}
}
