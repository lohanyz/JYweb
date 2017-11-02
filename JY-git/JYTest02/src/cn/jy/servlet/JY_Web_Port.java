package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Portinfo;
import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Port extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 		bid,gid,inporttime,ctime,intime, pboxtime,state,simg,lkind,reporttime,classorderid,tid,tkind,oid,gtime,stime;
	private int 		pid,percount,tcount;
	private boolean 	islean;
	private double 		perweight,tformatweight;
	
	//bid,inporttime,ctime,intime, pboxtime,state,simg,lkind,reporttime,classorderid,tid,tkind,oid,gtime,stime,
	//pid,pertcount,tcount
	//islean,pertweight,tformatweight;
	
	private String 		sResult	=	"error.jsp",
						sql,
						tmp,
						str,
						searchvalue,
						kindName,
						kindValue,
						sPageCurrent
						;
	private	String[]	strs,
						imgs;
	private int 		operId 	   =	0,	//	操作类型;
			  			nSize	   =	0,	//	长度;
			  			nItemLimit =	MyConfig.N_PAGE_COUNT,	//	数量限制;
			  			pageCurrent=	0,	//	当前页数;
			  			pageCount  =	0,	//	页码计数;
			  			itemCount  =	0;	//	条目计数;	

	private ArrayList<Portinfo> 		list;
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
		dbTool 			= 	new DBTool();
		myConfig		=	new MyConfig();
		session 		= 	req.getSession();
		user			=	(Workerinfo)session.getAttribute("user");
		
		switch (operId) {
		//	操作内容;
		case 1:
		
			break;
			
		case 2:
			sql			=	"select * from portinfo order by bid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryPortinfo(sql);
			session.setAttribute("listPort", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", " ");
			sResult		=	"port/port_all.jsp";
			break;
		case 3:
			pid 		= 	Integer.valueOf(req.getParameter("pid"));
			sql			=	"select * from portinfo where pid='"+pid+"'";
			list		=	dbTool.doDBQueryPortinfo(sql);
			simg		=	list.get(0).getSimg();
			imgs=simg.split("_");
			session.setAttribute("listPort", list);
			session.setAttribute("imgs", imgs);
			sResult		=	"port/port_detail.jsp";
			break;
//			04.单条信息删除;
		case 4:
//			pid = Integer.valueOf(req.getParameter("pid"));
//			sql			=	"delete from portinfo where pid='"+pid+"'";
//			dbTool.doDBUpdate(sql);		
//			searchvalue=(String)session.getAttribute("searchvalue");
//			pageCurrent=Integer.valueOf((String)session.getAttribute("pageCurrent"));
//			sResult		=	"../../JYTest02/port_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			searchvalue		=	req.getParameter("searchvalue");
			sPageCurrent 	= 	req.getParameter("pageCurrent");
			pageCurrent 	= 	Integer.parseInt(sPageCurrent);
			pid = Integer.valueOf(req.getParameter("pid"));
			sql			=	"delete from portinfo where pid='"+pid+"'";
			dbTool.doDBUpdate(sql);		
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+req.getParameter("bid")+"'," +
					"'"+req.getParameter("gid")+"'," +
					"'港口货物操作'," +
					"'删除编号为"+pid+"的港口货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and pid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from portinfo " + tmp + " order by pid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryPortinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listPort", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "port/port_all.jsp";
				}
			}
			break;	
		case 5:
			pid = Integer.valueOf(req.getParameter("pid"));
			sql			=	"select * from portinfo where pid='"+pid+"'";
			list		=	dbTool.doDBQueryPortinfo(sql);
			simg		=	list.get(0).getSimg();
			imgs=simg.split("_");
			session.setAttribute("imgs", imgs);
			session.setAttribute("listPort", list);
			sResult		=	"port/port_update.jsp";
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
			sql			=	"select * from portinfo "+tmp+" order by bid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryPortinfo(sql);
			
			session.setAttribute("listPort", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			
			sResult		=	"port/port_all.jsp";
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
			sql = "select * from portinfo " + tmp + " order by pid limit 0," + nItemLimit;
			list = dbTool.doDBQueryPortinfo(sql);

			session.setAttribute("listPort", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			sResult = "port/port_all.jsp";
			break;
		//	07.全信息删除;
		case 7:
			searchvalue		=	req.getParameter("searchvalue");
			sPageCurrent 	= 	req.getParameter("pageCurrent");
			pageCurrent 	= 	Integer.parseInt(sPageCurrent);
			
			str   		= 	new String(req.getParameter("id").getBytes("ISO8859_1"),"utf-8");
			strs		=	str.split(",");
			int len=strs.length;
			tmp="";
			for(int i=0;i< len ;i++){
				if(i==len-1)
					tmp	+=	"pid="+strs[i]+" ";
				else
					tmp	+=	"pid="+strs[i]+" or ";
			}
			sql			=	"delete from portinfo where "+tmp;
			dbTool.doDBUpdate(sql);
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'港口货物操作'," +
					"'删除编号为"+str+"的港口货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and pid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from portinfo " + tmp + " order by pid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryPortinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listPort", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "port/port_all.jsp";
				}
			}
//			sResult		=	"../../JYTest02/port_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			break;
		//	08.信息新增;
		case 8:
//			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			tmp			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			bid			=	tmp.substring(0, tmp.indexOf("-"));
			gid			=	tmp.substring(tmp.indexOf("-")+1 );
			inporttime	=	new String(req.getParameter("inporttime").getBytes("ISO8859_1"),"utf-8");
			ctime 		=	new String(req.getParameter("ctime").getBytes("ISO8859_1"),"utf-8");
			intime 		=	new String(req.getParameter("intime").getBytes("ISO8859_1"),"utf-8");
			pboxtime	=	new String(req.getParameter("pboxtime").getBytes("ISO8859_1"),"utf-8");
			state		=	new String(req.getParameter("state").getBytes("ISO8859_1"),"utf-8");
			simg		=	new String(req.getParameter("simg").getBytes("ISO8859_1"),"utf-8");
			islean		=	Boolean.valueOf(req.getParameter("islean"));
			lkind		=	new String(req.getParameter("lkind").getBytes("ISO8859_1"),"utf-8");
			tid			=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			tkind		=	new String(req.getParameter("tkind").getBytes("ISO8859_1"),"utf-8");
			oid			=	new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
// 			gtime		=	new String(req.getParameter("gtime").getBytes("ISO8859_1"),"utf-8");
			stime		=	new String(req.getParameter("stime").getBytes("ISO8859_1"),"utf-8");
			pid			=	Integer.valueOf(req.getParameter("pid"));
			percount		=	Integer.valueOf(req.getParameter("percount"));
			perweight	=	Double.valueOf(req.getParameter("perweight"));
			
			if(lkind.equals("汽运"))
				tcount		=	Integer.valueOf(req.getParameter("tcount"));
			if(lkind.equals("铁路")){
				tformatweight=  Double.valueOf(req.getParameter("tformatweight"));
				reporttime	=	new String(req.getParameter("reporttime").getBytes("ISO8859_1"),"utf-8");
				classorderid	=	new String(req.getParameter("classorderid").getBytes("ISO8859_1"),"utf-8");
			}
			sql	 		=	"insert into portinfo(bid,gid,inporttime,ctime,intime, pboxtime,"
					+ "state,simg,lkind,reporttime,classorderid,tid,tkind,oid,gtime,stime,"
					+ "pid,percount,tcount,islean,perweight,tformatweight) " +
							"values(" +
							"'"+bid+"'," +
							"'"+gid+"'," +
							"'"+inporttime+"'," +
							"'"+ctime+"'," +
							"'"+intime+"'," +
							"'"+pboxtime+"'," +
							"'"+state+"'," +
							"'"+simg+"'," +
							"'"+lkind+"'," +
							"'"+reporttime+"'," +
							"'"+classorderid+"'," +
							"'"+tid+"'," +
							"'"+tkind+"'," +
							"'"+oid+"'," +
							"'"+gtime+"'," +
							"'"+stime+"'," +
							"'"+pid+"'," +
							"'"+percount+"'," +
							"'"+tcount+"'," +
							"'"+islean+"'," +
							"'"+perweight+"'," +
							"'"+tformatweight+"')";
			
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'港口货物操作'," +
					"'新增编号为"+pid+"的港口货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			sResult		=	"../../JYTest02/port_info?operid=3&pid="+pid+"";

			break;
		//	09.信息修改后完成;
		case 9:
			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			gid			=	new String(req.getParameter("gid").getBytes("ISO8859_1"),"utf-8");
//			inporttime	=	new String(req.getParameter("inporttime").getBytes("ISO8859_1"),"utf-8");
//			ctime 		=	new String(req.getParameter("ctime").getBytes("ISO8859_1"),"utf-8");
//			intime 		=	new String(req.getParameter("intime").getBytes("ISO8859_1"),"utf-8");
//			pboxtime	=	new String(req.getParameter("pboxtime").getBytes("ISO8859_1"),"utf-8");
//			state		=	new String(req.getParameter("state").getBytes("ISO8859_1"),"utf-8");
//			simg		=	new String(req.getParameter("simg").getBytes("ISO8859_1"),"utf-8");
//			islean		=	Boolean.valueOf(req.getParameter("islean"));
//			lkind		=	new String(req.getParameter("lkind").getBytes("ISO8859_1"),"utf-8");
//			tid			=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
//			tkind		=	new String(req.getParameter("tkind").getBytes("ISO8859_1"),"utf-8");
//			oid			=	new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
// 			gtime		=	new String(req.getParameter("gtime").getBytes("ISO8859_1"),"utf-8");
//			stime		=	new String(req.getParameter("stime").getBytes("ISO8859_1"),"utf-8");
//			pid			=	Integer.valueOf(req.getParameter("pid"));
//			percount		=	Integer.valueOf(req.getParameter("percount"));
//			perweight	=	Double.valueOf(req.getParameter("perweight"));
			
			
			inporttime	=	req.getParameter("inporttime");
			ctime 		=	req.getParameter("ctime");
			intime 		=	req.getParameter("intime");
			pboxtime	=	req.getParameter("pboxtime");
			state		=	req.getParameter("state");
			simg		=	req.getParameter("simg");
			islean		=	Boolean.valueOf(req.getParameter("islean"));
			lkind		=	req.getParameter("lkind");
			tid			=	req.getParameter("tid");
			tkind		=	req.getParameter("tkind");
			oid			=	req.getParameter("oid");
			stime		=	req.getParameter("stime");
			pid			=	Integer.valueOf(req.getParameter("pid"));
			percount		=	Integer.valueOf(req.getParameter("percount"));
			perweight	=	Double.valueOf(req.getParameter("perweight"));
			
			if(lkind.equals("汽运"))
				tcount		=	Integer.valueOf(req.getParameter("tcount"));
			if(lkind.equals("铁路")){
				tformatweight=  Double.valueOf(req.getParameter("tformatweight"));
				reporttime	=	req.getParameter("reporttime");
				classorderid	=	req.getParameter("classorderid");
			}

			sql	 		=	"update portinfo "
					+ "set inporttime='"+inporttime+"',"
					+ "ctime='"+ctime+"',"
					+ "intime='"+intime+"',"
					+ "pboxtime='"+pboxtime+"',"
					+ "state='"+state+"',"
					+ "simg='"+simg+"',"
					+ "lkind='"+lkind+"',"
					+ "reporttime='"+reporttime+"',"
					+ "classorderid='"+classorderid+"',"
					+ "tid='"+tid+"',"
					+ "tkind='"+tkind+"',"
					+ "oid='"+oid+"',"
					+ "gtime='"+gtime+"',"
					+ "stime='"+stime+"',"
					+ "percount='"+percount+"',"
					+ "tcount='"+tcount+"',"
					+ "islean='"+islean+"',"
					+ "perweight='"+perweight+"',"
					+ "tformatweight='"+tformatweight+"' "
					
					+ "where pid='"+pid+"'";
			dbTool.doDBUpdate(sql);
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'港口货物操作'," +
					"'修改编号为"+pid+"的港口货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			sResult		=	"../../JYTest02/port_info?operid=3&pid="+pid+"";
			break;
		//	10.上一页;
		case 10:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
		 
			if(str.equals(" ")){
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and pid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			if(pageCurrent>0){
				pageCount	=	(pageCurrent-1);
				itemCount	=	pageCount*nItemLimit;
				sql			=	"select * from portinfo "+tmp+" order by bid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryPortinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listPort", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult		=	"port/port_all.jsp";
				}
			}
			break;
		//	11.下一页;
		case 11:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if(str.equals(" ")){
				System.out.println(str+"ddddddd");
				tmp		=	"";
			}else{
				System.out.println("ssssssssssssssss");
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and pid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from portinfo "+tmp+" order by pid limit "+itemCount+","+nItemLimit;
				System.out.println(sql);
				list		=	dbTool.doDBQueryPortinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listPort", list);
					session.setAttribute("searchvalue", searchvalue);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult		=	"port/port_all.jsp";
				}
			}
			break;

		// 12.某一页;
		case 12:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if(str.equals(" ")){
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and pid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent - 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from portinfo " + tmp + " order by bid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryPortinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listPort", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "port/port_all.jsp";
				}
			}
			break;
		// 14.综合在一个页面，多条件查询
		case 14:
			searchvalue = new String(req.getParameter("searchvalue").getBytes( "ISO8859_1"), "utf-8");
			str = searchvalue + " ";
			if (str.equals(" ")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and pid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			sql = "select * from portinfo  " + tmp + " order by pid limit 0," + nItemLimit;
			list = dbTool.doDBQueryPortinfo(sql);
			session.setAttribute("listPort", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", searchvalue);

			sResult = "port/port_all.jsp";
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