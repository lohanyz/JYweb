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

import cn.jy.entity.Getgoodsinfo;
import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Getgoods extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String		bid,gid,gstate,gsimg,lkind,tid,tkind,oid,gtime,stime;
	private int 		ggid,percount,tcount;
	private double		perweight,tformatweight;
	//bid,gstate,gsimg,lkind,tid,tkind,oid,gtime,stime,ggid,pertcount,tcount,pertweight,tformatweight;
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

	private ArrayList<Getgoodsinfo> 	list;
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
//		wid				=	(String)session.getAttribute("wid");
		user			=	(Workerinfo)session.getAttribute("user");
		switch (operId) {
		//	操作内容;
		case 1:
		
			break;
		case 2:
			sql			=	"select * from getgoodsinfo order by ggid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryGetgoodsinfo(sql);
			session.setAttribute("listGetgoods", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", " ");
			sResult		=	"getgoods/getgoods_all.jsp";
			break;
		//单条信息
		case 3:
			ggid  		= 	Integer.valueOf(req.getParameter("ggid"));
			sql			=	"select * from getgoodsinfo where ggid='"+ggid+"'";
			list		=	dbTool.doDBQueryGetgoodsinfo(sql);
			gsimg		=	list.get(0).getGsimg();
			imgs		=	gsimg.split("_");
			session.setAttribute("imgs", imgs);
			session.setAttribute("listGetgoods", list);
			sResult		=	"getgoods/getgoods_detail.jsp";
			break;
		//04.单条信息删除;
		case 4:
			searchvalue		=	req.getParameter("searchvalue");
			sPageCurrent 	= 	req.getParameter("pageCurrent");
			pageCurrent 	= 	Integer.parseInt(sPageCurrent);
			ggid  			= 	Integer.valueOf(req.getParameter("ggid"));
			sql				=	"delete from getgoodsinfo where ggid='"+ggid+"'";
			
			dbTool.doDBUpdate(sql);		
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+req.getParameter("bid")+"'," +
					"'"+req.getParameter("gid")+"'," +
					"'提货操作'," +
					"'删除编号为"+ggid+"的提货信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
//			searchvalue =	(String)session.getAttribute("searchvalue");
//			pageCurrent =	Integer.valueOf((String)session.getAttribute("pageCurrent"));
//			sResult		=	"../../JYTest02/getgoods_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			
			str				=	searchvalue+" ";
			System.out.println(pageCurrent);
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and ggid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from getgoodsinfo " + tmp + " order by ggid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryGetgoodsinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listGetgoods", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "getgoods/getgoods_all.jsp";
				}
			}
			
			break;
		case 5:
			ggid  		= 	Integer.valueOf(req.getParameter("ggid"));
			sql			=	"select * from getgoodsinfo where ggid='"+ggid+"'";
			list		=	dbTool.doDBQueryGetgoodsinfo(sql);
			session.setAttribute("listGetgoods", list);
			gsimg		=	list.get(0).getGsimg();
			imgs=gsimg.split("_");
			session.setAttribute("imgs", imgs);
			sResult		=	"getgoods/getgoods_update.jsp";
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
			sql			=	"select * from getgoodsinfo "+tmp+" order by ggid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryGetgoodsinfo(sql);
			
			session.setAttribute("listGetgoods", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			
			sResult		=	"getgoods/getgoods_all.jsp";
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
			sql = "select * from getgoodsinfo " + tmp + " order by ggid limit 0," + nItemLimit;
			list = dbTool.doDBQueryGetgoodsinfo(sql);

			session.setAttribute("listGetgoods", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			sResult = "getgoods/getgoods_all.jsp";
			break;
		//	07.全信息删除;
		case 7:
//			searchvalue	=	new String(req.getParameter("searchvalue").getBytes("ISO8859_1"),"utf-8");
			searchvalue		= 	req.getParameter("searchvalue");
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			str   		= 	new String(req.getParameter("id").getBytes("ISO8859_1"),"utf-8");
			strs		=	str.split(",");
			int len=strs.length;
			tmp="";
			for(int i=0;i< len ;i++){
				if(i==len-1)
					tmp	+=	"ggid="+strs[i]+" ";
				else
					tmp	+=	"ggid="+strs[i]+" or ";
			}
			sql			=	"delete from getgoodsinfo where "+tmp;
			dbTool.doDBUpdate(sql);
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'提货操作'," +
					"'删除编号为"+str+"的提货信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and ggid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			System.out.println("条件："+str);
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from getgoodsinfo " + tmp + " order by ggid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryGetgoodsinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listGetgoods", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "getgoods/getgoods_all.jsp";
				}
			}
//			sResult		=	"../../JYTest02/getgoods_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			break;
		//	08.信息新增;
		case 8:
			tmp			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			bid			=	tmp.substring(0, tmp.indexOf("-"));
			gid			=	tmp.substring(tmp.indexOf("-")+1 );
			gstate		=	new String(req.getParameter("gstate").getBytes("ISO8859_1"),"utf-8");
			gsimg		=	new String(req.getParameter("gsimg").getBytes("ISO8859_1"),"utf-8");
			lkind		=	new String(req.getParameter("lkind").getBytes("ISO8859_1"),"utf-8");
			tid			=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			tkind		=	new String(req.getParameter("tkind").getBytes("ISO8859_1"),"utf-8");
			oid			=	new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
			gtime		=	new String(req.getParameter("gtime").getBytes("ISO8859_1"),"utf-8");
			stime		=	new String(req.getParameter("stime").getBytes("ISO8859_1"),"utf-8");
			percount	=	Integer.valueOf(req.getParameter("percount"));
			perweight	=	Double.valueOf(req.getParameter("perweight"));
			ggid		=	Integer.valueOf(req.getParameter("ggid"));
			
			if(lkind.equals("汽运"))
				tcount		=	Integer.valueOf(req.getParameter("tcount"));
			if(lkind.equals("铁路"))
				tformatweight=  Double.valueOf(req.getParameter("tformatweight"));
			
			sql		=	"insert into getgoodsinfo(bid,gid,gstate,gsimg,lkind,tid,tkind,oid,gtime,stime,ggid, percount,tcount,perweight,tformatweight) " +
							"values(" +
							"'"+bid+"'," +
							"'"+gid+"'," +
							"'"+gstate+"'," +
							"'"+gsimg+"'," +
							"'"+lkind+"'," +
							"'"+tid+"'," +
							"'"+tkind+"'," +
							"'"+oid+"'," +
							"'"+gtime+"'," +
							"'"+stime+"'," +
							"'"+ggid+"'," +
							"'"+percount+"'," +
							"'"+tcount+"'," +
							"'"+perweight+"'," +
							"'"+tformatweight+"')";
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'提货操作'," +
					"'新增编号为"+ggid+"的提货信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			sResult		=	"../../JYTest02/getgoods_info?operid=3&ggid="+ggid+"";

			break;
		//	09.信息修改后完成;
		case 9:
			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			gid			=	new String(req.getParameter("gid").getBytes("ISO8859_1"),"utf-8");
//			gstate		=	new String(req.getParameter("gstate").getBytes("ISO8859_1"),"utf-8");
//			gsimg		=	new String(req.getParameter("gsimg").getBytes("ISO8859_1"),"utf-8");
//			lkind		=	new String(req.getParameter("lkind").getBytes("ISO8859_1"),"utf-8");
//			tid			=	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
//			tkind		=	new String(req.getParameter("tkind").getBytes("ISO8859_1"),"utf-8");
//			oid			=	new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
//			gtime		=	new String(req.getParameter("gtime").getBytes("ISO8859_1"),"utf-8");
//			stime		=	new String(req.getParameter("stime").getBytes("ISO8859_1"),"utf-8");
//			ggid		=	Integer.valueOf(req.getParameter("ggid"));
//			percount	=	Integer.valueOf(req.getParameter("percount"));
//			perweight	=	Double.valueOf(req.getParameter("perweight"));
			gstate		=	req.getParameter("gstate");
			gsimg		=	req.getParameter("gsimg");
			lkind		=	req.getParameter("lkind");
			tid			=	req.getParameter("tid");
			tkind		=	req.getParameter("tkind");
			oid			=	req.getParameter("oid");
			gtime		=	req.getParameter("gtime");
			stime		=	req.getParameter("stime");
			percount	=	Integer.valueOf(req.getParameter("percount"));
			perweight	=	Double.valueOf(req.getParameter("perweight"));
			ggid		=	Integer.valueOf(req.getParameter("ggid"));
			
			if(lkind.equals("汽运"))
				tcount		=	Integer.valueOf(req.getParameter("tcount"));
			if(lkind.equals("铁路"))
				tformatweight=  Double.valueOf(req.getParameter("tformatweight")); 
			sql	 		=	"update getgoodsinfo "
					+ "set gstate='"+gstate+"',"
					+ "gsimg='"+gsimg+"',"
					+ "lkind='"+lkind+"',"
					+ "tid='"+tid+"',"
					+ "tkind='"+tkind+"',"
					+ "oid='"+oid+"',"
					+ "gtime='"+gtime+"',"
					+ "stime='"+stime+"',"
					+ "percount='"+percount+"',"
					+ "tcount='"+tcount+"',"
					+ "perweight='"+perweight+"',"
					+ "tformatweight='"+tformatweight+"' "
					+ "where ggid='"+ggid+"'";
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'提货操作'," +
					"'修改编号为"+ggid+"的提货信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			sResult		=	"../../JYTest02/getgoods_info?operid=3&ggid="+ggid+"&characterEncoding=UTF-8";
			break;
		//	10.上一页;
		case 10:
//			kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
//			kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if(str.trim().equals("")){
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and ggid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			
			if(pageCurrent>0){
				pageCount	=	(pageCurrent-1);
				itemCount	=	pageCount*nItemLimit;
				sql			=	"select * from getgoodsinfo "+tmp+" order by ggid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryGetgoodsinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listGetgoods", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					session.setAttribute("searchvalue", searchvalue);
					sResult		=	"getgoods/getgoods_all.jsp";
				}
			}
			break;
		//	11.下一页;
		case 11:
//			kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
//			kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			if(str.trim().equals("")){
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and ggid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from getgoodsinfo "+tmp+" order by ggid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryGetgoodsinfo(sql);
				System.out.println(sql);
				nSize		=	list.size();
				System.out.println(nSize);
				if(nSize>0){					
					session.setAttribute("listGetgoods", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult		=	"getgoods/getgoods_all.jsp";
				}
			}
			break;
//			12.某一页;
		case 12:
//			kindName = new String(req.getParameter("kindName").getBytes( "ISO8859_1"), "utf-8");
//			kindValue = new String(req.getParameter("kindValue").getBytes(	"ISO8859_1"), "utf-8");
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent = req.getParameter("pageCurrent");
			pageCurrent = Integer.parseInt(sPageCurrent);
			
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and ggid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
				System.out.println("条件："+str);
				System.out.println("运输方式："+strs[0]);
			}
			System.out.println("条件："+str);
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent - 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from getgoodsinfo " + tmp + " order by ggid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryGetgoodsinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listGetgoods", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "getgoods/getgoods_all.jsp";
				}
			}
			break;
		// 14.综合在一个页面，多条件查询
		case 14:
			searchvalue = new String(req.getParameter("searchvalue").getBytes("ISO8859_1"),"utf-8");
			str = searchvalue+" ";
			System.out.println(str);
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where lkind like '" + "%" + strs[0].trim() + "%"
						+ "' and ggid like '" + "%" + strs[1] + "%"
						+ "' and  bid like '" + "%" + strs[2].trim() + "%"
						+ "' and  gid like '" + "%" + strs[3].trim() + "%"
						+ "'";
			}
			sql = "select * from getgoodsinfo  " + tmp + " order by ggid limit 0," + nItemLimit;
			list = dbTool.doDBQueryGetgoodsinfo(sql);
			session.setAttribute("listGetgoods", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", searchvalue);

			sResult = "getgoods/getgoods_all.jsp";
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
