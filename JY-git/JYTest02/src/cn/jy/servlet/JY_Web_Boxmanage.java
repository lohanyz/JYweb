package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Boxmanageinfo;
import cn.jy.entity.Getgoodsinfo;
import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Boxmanage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String 		bid,gid,getboxspace, getboxtime, backchnportime, backportstorehoustime, 
				   		portranstime, transtid, downlineovertime,railwaydownlinetime,
				   		fbacknulltime,state,simg, img;
	private int 		bmid;

	// bid, getboxspace, getboxtime, backchnportime, backportstorehoustime portranstime, transtid, downlineovertime,railwaydownlinetime,fbacknulltime,state,simg, img,bmid;
	
	private String 		sResult = "error.jsp",
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
	
	private int operId = 0, // 操作类型;
			nSize = 0, // 长度;
			nItemLimit = MyConfig.N_PAGE_COUNT, // 数量限制;
			pageCurrent = 0, // 当前页数;
			pageCount = 0, // 页码计数;
			itemCount = 0; // 条目计数;

	private ArrayList<Boxmanageinfo> 	list;
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
		operId			= 	Integer.parseInt(req.getParameter("operid"));
		dbTool 			= 	new DBTool();
		myConfig		=	new MyConfig();
		session 		= 	req.getSession();
		user			=	(Workerinfo)session.getAttribute("user");
		
		switch (operId) {
		// 操作内容;
		case 1:

			break;
		
		case 2:
			sql			= 	"select * from boxmanageinfo order by bmid limit 0," + nItemLimit;
			list 		= 	dbTool.doDBQueryBoxmanageinfo(sql);
			session.setAttribute("listBoxmanage", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", " ");
			sResult 	= 	"boxmanage/boxmanage_all.jsp";
			break;
		case 3:
			bmid 		= 	Integer.valueOf(req.getParameter("bmid"));
			sql 		= 	"select * from boxmanageinfo where bmid='" + bmid + "'";
			list 		= 	dbTool.doDBQueryBoxmanageinfo(sql);
			simg		=	list.get(0).getSimg();
			imgs		=	simg.split("_");
			session.setAttribute("listBoxmanage", list);
			session.setAttribute("imgs", imgs);
			sResult = "boxmanage/boxmanage_detail.jsp";
			break;
			
		// 04.单条信息删除;
		case 4:
//			bmid 		= 	Integer.valueOf(req.getParameter("bmid"));
//			sql 		= 	"delete from boxmanageinfo where bmid='" + bmid + "'";
//			dbTool.doDBUpdate(sql);
//			searchvalue	=	(String)session.getAttribute("searchvalue");
//			pageCurrent	=	Integer.valueOf((String)session.getAttribute("pageCurrent"));
//			sResult	 	= 	"../../JYTest02/boxmanage_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			searchvalue		=	req.getParameter("searchvalue");
			sPageCurrent 	= 	req.getParameter("pageCurrent");
			pageCurrent 	= 	Integer.parseInt(sPageCurrent);
			bmid  			= 	Integer.valueOf(req.getParameter("bmid"));
			sql				=	"delete from boxmanageinfo where bmid='"+bmid+"'";
			dbTool.doDBUpdate(sql);	
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+req.getParameter("bid")+"'," +
					"'"+req.getParameter("gid")+"'," +
					"'箱管货物操作'," +
					"'删除编号为"+bmid+"的箱管货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where  bmid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from boxmanageinfo " + tmp + " order by bmid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryBoxmanageinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listBoxmanage", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "boxmanage/boxmanage_all.jsp";
				}
			}
			break;
		case 5:
			bmid 		= 	Integer.valueOf(req.getParameter("bmid"));
			sql	 		= 	"select * from boxmanageinfo where bmid='" + bmid + "'";
			list 		= 	dbTool.doDBQueryBoxmanageinfo(sql);
			simg		=	list.get(0).getSimg();
			imgs=simg.split("_");
			session.setAttribute("imgs", imgs);
			session.setAttribute("listBoxmanage", list);
			sResult 	= 	"boxmanage/boxmanage_update.jsp";
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
			sql = "select * from boxmanageinfo " + tmp + " order by bmid limit 0," + nItemLimit;
			
			list = dbTool.doDBQueryBoxmanageinfo(sql);

			session.setAttribute("listBoxmanage", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);

			sResult = "boxmanage/boxmanage_all.jsp";
			break;
		// 07.全信息删除;
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
					tmp	+=	"bmid="+strs[i]+" ";
				else
					tmp	+=	"bmid="+strs[i]+" or ";
			}
			sql			=	"delete from boxmanageinfo where "+tmp;
			dbTool.doDBUpdate(sql);
			
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'箱管货物操作'," +
					"'删除编号为"+str+"的箱管货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp = " where  bmid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from boxmanageinfo " + tmp + " order by bmid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryBoxmanageinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listBoxmanage", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "boxmanage/boxmanage_all.jsp";
				}
			}
//			sResult		=	"../../JYTest02/boxmanage_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			break;
		// 08.信息新增;
		case 8:
			tmp			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			bid			=	tmp.substring(0, tmp.indexOf("-"));
			gid			=	tmp.substring(tmp.indexOf("-")+1 );
			getboxspace		= new String(req.getParameter("getboxspace").getBytes("ISO8859_1"),"utf-8");
			getboxtime		= new String(req.getParameter("getboxtime").getBytes("ISO8859_1"),"utf-8");
			backchnportime	= new String(req.getParameter("backchnportime").getBytes("ISO8859_1"),"utf-8");
			backportstorehoustime	= new String(req.getParameter("backportstorehoustime").getBytes("ISO8859_1"),"utf-8");
			portranstime	= new String(req.getParameter("portranstime").getBytes("ISO8859_1"),"utf-8");
			transtid		= new String(req.getParameter("transtid").getBytes("ISO8859_1"),"utf-8");
			downlineovertime	= new String(req.getParameter("downlineovertime").getBytes("ISO8859_1"),"utf-8");
			railwaydownlinetime		= new String(req.getParameter("railwaydownlinetime").getBytes("ISO8859_1"),"utf-8");
			fbacknulltime	= new String(req.getParameter("fbacknulltime").getBytes("ISO8859_1"),"utf-8");
			state			= new String(req.getParameter("state").getBytes("ISO8859_1"),"utf-8");
			simg			= new String(req.getParameter("simg").getBytes("ISO8859_1"),"utf-8");
//			img				= new String(req.getParameter("img").getBytes("ISO8859_1"),"utf-8");
			
			bmid			=	Integer.valueOf(req.getParameter("bmid"));
			img		=	"info_1_2_3_4";
			
			sql = "insert into boxmanageinfo(bid,gid,getboxspace, getboxtime, backchnportime, backportstorehoustime,portranstime, transtid, downlineovertime,railwaydownlinetime,fbacknulltime,state,simg, img,bmid) "
					+ "values(" 
					+ "'"+ bid+ "',"
					+ "'"+ gid+ "',"
					+ "'"+ getboxspace+ "',"
					+ "'"+ getboxtime+ "',"
					+ "'"+ backchnportime+ "',"
					+ "'"+ backportstorehoustime+ "',"
					+ "'"+ portranstime+ "',"
					+ "'"+ transtid+ "',"
					+ "'"+ downlineovertime+ "',"
					+ "'"+ railwaydownlinetime+ "',"
					+ "'"+ fbacknulltime+ "',"
					+ "'"+ state+ "',"
					+ "'"+ simg+ "',"
					+ "'"+ img+ "',"
					+ "'"+ bmid + "')";
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'箱管货物操作'," +
					"'新增编号为"+bmid+"的箱管货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			sResult 	= 	"../../JYTest02/boxmanage_info?operid=3&bmid=" + bmid + "";
			break;
		// 09.信息修改后完成;
		case 9:
//			bmid			= Integer.valueOf(req.getParameter("bmid"));
//			bid  			= new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
//			gid			=	new String(req.getParameter("gid").getBytes("ISO8859_1"),"utf-8");
//			getboxspace		= new String(req.getParameter("getboxspace").getBytes("ISO8859_1"),"utf-8");
//			getboxtime		= new String(req.getParameter("getboxtime").getBytes("ISO8859_1"),"utf-8");
//			backchnportime	= new String(req.getParameter("backchnportime").getBytes("ISO8859_1"),"utf-8");
//			backportstorehoustime	= new String(req.getParameter("backportstorehoustime").getBytes("ISO8859_1"),"utf-8");
//			portranstime	= new String(req.getParameter("portranstime").getBytes("ISO8859_1"),"utf-8");
//			transtid		= new String(req.getParameter("transtid").getBytes("ISO8859_1"),"utf-8");
//			downlineovertime	= new String(req.getParameter("downlineovertime").getBytes("ISO8859_1"),"utf-8");
//			railwaydownlinetime		= new String(req.getParameter("railwaydownlinetime").getBytes("ISO8859_1"),"utf-8");
//			fbacknulltime	= new String(req.getParameter("fbacknulltime").getBytes("ISO8859_1"),"utf-8");
//			state			= new String(req.getParameter("state").getBytes("ISO8859_1"),"utf-8");
//			simg			= new String(req.getParameter("simg").getBytes("ISO8859_1"),"utf-8");
//			img				= new String(req.getParameter("img").getBytes("ISO8859_1"),"utf-8");
			
			bid				= 	req.getParameter("bid");
			gid				=	req.getParameter("gid");
			getboxspace		=	req.getParameter("getboxspace");
			getboxtime		=	req.getParameter("getboxtime");
			backchnportime	=	req.getParameter("backchnportime");
			backportstorehoustime	=	req.getParameter("backportstorehoustime");
			portranstime	=	req.getParameter("portranstime");
			transtid		=	req.getParameter("transtid");
			downlineovertime		= 	req.getParameter("downlineovertime");
			railwaydownlinetime		= 	req.getParameter("railwaydownlinetime");
			fbacknulltime	= 	req.getParameter("fbacknulltime");
			state			= 	req.getParameter("state");
			simg			= 	req.getParameter("simg");
			img		=	"info_1_2_3_4";
			bmid			= Integer.valueOf(req.getParameter("bmid"));
			
			sql = "update boxmanageinfo "
					+ "set getboxspace='" + getboxspace + "'," 
					+ "getboxtime='"+ getboxtime + "'," 
					+ "backchnportime='" + backchnportime + "'," 
					+ "backportstorehoustime='"+ backportstorehoustime + "'," 
					+ "portranstime='" + portranstime + "',"
					+ "transtid='" + transtid + "'," 
					+ "downlineovertime='" + downlineovertime + "',"
					+ "railwaydownlinetime='" + railwaydownlinetime + "'," 
					+ "fbacknulltime='"+ fbacknulltime + "'," 
					+ "state='" + state + "'," 
					+ "simg='"+ simg + "'," 
					+ "img='" + img + "' "
					
					+ "where bmid='" + bmid + "'";

			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sql="insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime) values(" +
					"'"+user.getWid()+"'," +
					"'"+user.getWname()+"'," +
					"'"+bid+"'," +
					"'"+gid+"'," +
					"'箱管货物操作'," +
					"'修改编号为"+bmid+"的箱管货物信息',"+
					"'"+myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分")+"'" +
					")";
			dbTool.doDBUpdate(sql);
			
			sResult = "../../JYTest02/boxmanage_info?operid=3&bmid=" +bmid + "";

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
				tmp = " where  bmid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			
			if (pageCurrent > 0) {
				pageCount = (pageCurrent - 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from boxmanageinfo " + tmp + " order by bmid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryBoxmanageinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listBoxmanage", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "boxmanage/boxmanage_all.jsp";
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
				tmp = " where  bmid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent + 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from boxmanageinfo " + tmp + " order by bmid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryBoxmanageinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listBoxmanage", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "boxmanage/boxmanage_all.jsp";
				}
			}
			break;
			
			// 12.某一页;
		case 12:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where  bmid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent - 1);
				itemCount = pageCount * nItemLimit;
				sql = "select * from boxmanageinfo " + tmp + " order by bmid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryBoxmanageinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listBoxmanage", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "boxmanage/boxmanage_all.jsp";
				}
			}
			break;
			
		// 14.综合在一个页面，多条件查询
		case 14:
			searchvalue = new String(req.getParameter("searchvalue").getBytes( "ISO8859_1"), "utf-8");
			str = searchvalue + " ";
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
				strs = str.split(",");
				tmp = " where  bmid like '" + "%" + strs[0] + "%"
						+ "' and  bid like '" + "%" + strs[1].trim() + "%"
						+ "' and  gid like '" + "%" + strs[2].trim() + "%"
						+ "'";
			}
			sql = "select * from boxmanageinfo  " + tmp + " order by bmid limit 0," + nItemLimit;
			list = dbTool.doDBQueryBoxmanageinfo(sql);
			session.setAttribute("listBoxmanage", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", searchvalue);

			sResult = "boxmanage/boxmanage_all.jsp";
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
