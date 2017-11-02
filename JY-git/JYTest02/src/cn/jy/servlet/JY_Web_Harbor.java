package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Harborinfo;
import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Harbor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String 		bid,gid,state, simg, ftochnharbortime, pboxtime, senttime,
						transtime, transtid, stime;
	private int 		hid, transtcount, percount;
	private double 		perweight;

	// bid,hid,state,simg,ftochnharbortime,pboxtime,senttime,transtime,transtid,transtcount,pertcount,pertweight,stime

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
	private int operId = 0, // 操作类型;
			nSize = 0, // 长度;
			nItemLimit = MyConfig.N_PAGE_COUNT, // 数量限制;
			pageCurrent = 0, // 当前页数;
			pageCount = 0, // 页码计数;
			itemCount = 0; // 条目计数;

	private ArrayList<Harborinfo>		list;
	private DBTool 						dbTool;
	private HttpSession 				session	=	null;
	private Workerinfo 					user;
	private MyConfig 					myConfig;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 数据传输的类型;
		resp.setContentType("text/html;charset=utf-8");
		// 写数据信息操作;
		operId 			= 	Integer.parseInt(req.getParameter("operid"));
		dbTool 			= 	new DBTool();
		myConfig		=	new MyConfig();
		session 		= 	req.getSession();
		user			=	(Workerinfo)session.getAttribute("user");
		switch (operId) {
		// 操作内容;
		case 1:

			break;
		case 2:
			sql			= 	"select * from Harborinfo order by hid limit 0," + nItemLimit;
			list 		= 	dbTool.doDBQueryHarborinfo(sql);
			session.setAttribute("listHarbor", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", " ");
			sResult 	= 	"harbor/harbor_all.jsp";
			break;
		case 3:
			hid			= 	Integer.valueOf(req.getParameter("hid"));
			sql 		= 	"select * from Harborinfo where hid='" + hid + "'";
			list 		= 	dbTool.doDBQueryHarborinfo(sql);
			simg		=	list.get(0).getSimg();
			imgs=simg.split("_");
			session.setAttribute("listHarbor", list);
			session.setAttribute("imgs", imgs);
			sResult 	= 	"harbor/harbor_detail.jsp";
			break;
		// 04.单条信息删除;
		case 4:
//			hid 		= 	Integer.valueOf(req.getParameter("hid"));
//			sql 		= 	"delete from Harborinfo where hid='" + hid + "'";
//			dbTool.doDBUpdate(sql);
//			searchvalue=(String)session.getAttribute("searchvalue");
//			pageCurrent=Integer.valueOf((String)session.getAttribute("pageCurrent"));
//			sResult		=	"../../JYTest02/harbor_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			searchvalue		=	req.getParameter("searchvalue");
			sPageCurrent 	= 	req.getParameter("pageCurrent");
			pageCurrent 	= 	Integer.parseInt(sPageCurrent);
			hid 		= 	Integer.valueOf(req.getParameter("hid"));
			sql 		= 	"delete from Harborinfo where hid='" + hid + "'";
			dbTool.doDBUpdate(sql);		
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+req.getParameter("bid")+"'," +
					"'"+req.getParameter("gid")+"'," +
					"'口岸货物操作'," +
					"'删除编号为"+hid+"的口岸货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where  hid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from Harborinfo " + tmp + " order by hid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryHarborinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listHarbor", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "harbor/harbor_all.jsp";
				}
			}
			
			
			break;	
		case 5:
			hid 		= 	Integer.valueOf(req.getParameter("hid"));
			sql 		= 	"select * from Harborinfo where hid='" + hid + "'";
			list 		= 	dbTool.doDBQueryHarborinfo(sql);
			simg		=	list.get(0).getSimg();
			imgs		=	simg.split("_");
			session.setAttribute("imgs", imgs);
			session.setAttribute("listHarbor", list);
			sResult 	= 	"harbor/harbor_update.jsp";
			break;
		// 06.条件查询;
		case 6:
			kindName = new String(req.getParameter("kindName").getBytes( "ISO8859_1"), "utf-8");
			kindValue = new String(req.getParameter("kindValue").getBytes( "ISO8859_1"), "utf-8");
			
			if (kindName.equals(" ")) {
				tmp = "";
			} else {
				tmp = "where " + kindName + " like '" + "%" + kindValue + "%" + "'";
			}
			sql = "select * from Harborinfo " + tmp + " order by hid limit 0," + nItemLimit;
			list = dbTool.doDBQueryHarborinfo(sql);

			session.setAttribute("listHarbor", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);

			sResult = "harbor/harbor_all.jsp";
			break;
		// 07.全信息删除;
		case 7:
			searchvalue		= 	req.getParameter("searchvalue");
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			str   		= 	new String(req.getParameter("id").getBytes("ISO8859_1"),"utf-8");
			strs		=	str.split(",");
			int len=strs.length;
			tmp="";
			for(int i=0;i< len ;i++){
				if(i==len-1)
					tmp	+=	"hid="+strs[i]+" ";
				else
					tmp	+=	"hid="+strs[i]+" or ";
			}
			sql			=	"delete from Harborinfo where "+tmp;
			dbTool.doDBUpdate(sql);
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'口岸货物操作'," +
					"'删除编号为"+str+"的口岸货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where  hid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from Harborinfo " + tmp + " order by hid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryHarborinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listHarbor", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "harbor/harbor_all.jsp";
				}
			}
//			sResult		=	"../../JYTest02/harbor_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			break;
		// 08.信息新增;
		case 8:
//			bid 		= 	new String(req.getParameter("bid").getBytes("ISO8859_1"), "utf-8");
			tmp			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			bid			=	tmp.substring(0, tmp.indexOf("-"));
			gid			=	tmp.substring(tmp.indexOf("-")+1 );
			hid		 	= 	Integer.valueOf(req.getParameter("hid"));
			state 		= 	new String(req.getParameter("state").getBytes("ISO8859_1"), "utf-8");
			simg 		= 	new String(req.getParameter("simg").getBytes("ISO8859_1"), "utf-8");
			ftochnharbortime = new String(req.getParameter("ftochnharbortime") .getBytes("ISO8859_1"), "utf-8");
			pboxtime 	= 	new String(req.getParameter("pboxtime").getBytes( "ISO8859_1"), "utf-8");
			senttime 	= 	new String(req.getParameter("senttime").getBytes( "ISO8859_1"), "utf-8");
			transtime 	= 	new String(req.getParameter("transtime").getBytes( "ISO8859_1"), "utf-8");
			transtid 	= 	new String(req.getParameter("transtid").getBytes( "ISO8859_1"), "utf-8");
			transtcount	= 	Integer.valueOf(req.getParameter("transtcount"));
			percount 	= 	Integer.valueOf(req.getParameter("percount"));
			perweight 	= 	Double.valueOf(req.getParameter("perweight"));
			stime 		= 	new String(req.getParameter("stime").getBytes("ISO8859_1"), "utf-8");

			sql = "insert into Harborinfo(bid,gid,hid,state,simg,ftochnharbortime,pboxtime,senttime,transtime,transtid,transtcount,percount,perweight,stime) "
					+ "values(" 
					+ "'"+ bid+ "',"
					+ "'"+ gid+ "',"
					+ "'"+ hid+ "',"
					+ "'"+ state+ "',"
					+ "'"+ simg+ "',"
					+ "'"+ ftochnharbortime+ "',"
					+ "'"+ pboxtime+ "',"
					+ "'"+ senttime+ "',"
					+ "'"+ transtime+ "',"
					+ "'"+ transtid+ "',"
					+ "'"+ transtcount+ "',"
					+ "'"+ percount+ "',"
					+ "'"+ perweight+ "',"
					+ "'"+ stime + "')";
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'口岸货物操作'," +
					"'新增编号为"+hid+"的口岸货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			sResult = "../../JYTest02/harbor_info?operid=3&hid=" + hid + "";

			break;
		// 09.信息修改后完成;
		case 9:
			bid 		= 	new String(req.getParameter("bid").getBytes("ISO8859_1"), "utf-8");
			gid 		= 	new String(req.getParameter("gid").getBytes("ISO8859_1"), "utf-8");
			hid		 	= 	Integer.valueOf(req.getParameter("hid"));
//			state 		= 	new String(req.getParameter("state").getBytes("ISO8859_1"), "utf-8");
//			simg 		= 	new String(req.getParameter("simg").getBytes("ISO8859_1"), "utf-8");
//			ftochnharbortime = new String(req.getParameter("ftochnharbortime") .getBytes("ISO8859_1"), "utf-8");
//			pboxtime 	= 	new String(req.getParameter("pboxtime").getBytes( "ISO8859_1"), "utf-8");
//			senttime 	= 	new String(req.getParameter("senttime").getBytes( "ISO8859_1"), "utf-8");
//			transtime 	= 	new String(req.getParameter("transtime").getBytes( "ISO8859_1"), "utf-8");
//			transtid 	= 	new String(req.getParameter("transtid").getBytes( "ISO8859_1"), "utf-8");
//			transtcount	= 	Integer.valueOf(req.getParameter("transtcount"));
//			percount 	= 	Integer.valueOf(req.getParameter("percount"));
//			perweight 	= 	Double.valueOf(req.getParameter("perweight"));
//			stime 		= 	new String(req.getParameter("stime").getBytes("ISO8859_1"), "utf-8");
			state 		=	req.getParameter("state");
			simg 		=	req.getParameter("simg");
			ftochnharbortime = 		req.getParameter("ftochnharbortime");
			pboxtime 	= 	req.getParameter("pboxtime");
			senttime 	= 	req.getParameter("senttime");
			transtime 	=	req.getParameter("transtime");
			transtid 	=	req.getParameter("transtid");
			transtcount	= 	Integer.valueOf(req.getParameter("transtcount"));
			percount 	= 	Integer.valueOf(req.getParameter("percount"));
			perweight 	= 	Double.valueOf(req.getParameter("perweight"));
			stime 		=	req.getParameter("stime");

			sql = "update Harborinfo " 
					+ "set state='" + state + "'," 
					+ "simg='" + simg + "'," 
					+ "ftochnharbortime='" + ftochnharbortime + "'," 
					+ "pboxtime='" + pboxtime + "'," 
					+ "senttime='" + senttime + "'," 
					+ "transtime='" + transtime + "',"
					+ "transtid='" + transtid + "'," 
					+ "transtcount='" + transtcount + "'," 
					+ "percount='" + percount + "',"
					+ "perweight='" + perweight + "'," 
					+ "stime='" + stime + "' " 
					+ "where hid='" + hid + "'";
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'口岸货物操作'," +
					"'修改编号为"+hid+"的口岸货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			sResult = "../../JYTest02/harbor_info?operid=3&hid=" + hid + "";

			break;
		// 10.上一页;
		case 10:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where  hid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			if (pageCurrent > 0) {
				pageCount = (pageCurrent - 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from Harborinfo " + tmp + " order by hid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryHarborinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listHarbor", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "harbor/harbor_all.jsp";
				}
			}
			break;
		// 11.下一页;
		case 11:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where  hid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent + 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from Harborinfo " + tmp + " order by hid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryHarborinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listHarbor", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "harbor/harbor_all.jsp";
				}
			}
			break;

		// 12.某一页;
		case 12:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			System.out.println(str+"ddd");
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where  hid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			System.out.println(str+"ddd");
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent - 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from Harborinfo " + tmp + " order by hid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryHarborinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listHarbor", list);
					session.setAttribute("pageCurrent",String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "harbor/harbor_all.jsp";
				}
			}
			break;
		// 14.综合在一个页面，多条件查询
		case 14:
			searchvalue = new String(req.getParameter("searchvalue").getBytes( "ISO8859_1"), "utf-8");
			str = searchvalue + " ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where  hid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			sql = "select * from Harborinfo  " + tmp + " order by hid limit 0," + nItemLimit;
			list = dbTool.doDBQueryHarborinfo(sql);
			session.setAttribute("listHarbor", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", searchvalue);

			sResult = "harbor/harbor_all.jsp";
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
