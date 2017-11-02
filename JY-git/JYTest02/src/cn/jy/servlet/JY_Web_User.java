package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.jy.code.Constants;
import cn.jy.entity.Workerinfo;
import cn.jy.tool.DBTool;

public class JY_Web_User extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 		wid,wname,wcall,wpwd,wnote,wtype,wpermission;	
	private String 		code,codeNumbers;	//验证码
	private String 		message	   =	null;			//信息
	private String 		sResult	   =	"error.jsp",
				   		sql,				//	SQL语句
				   		tmp,				//	字符串组成段;
				   		str,
				   		kindName,			//	查询键;
				   		kindValue,			//	查询值;
				   		searchvalue,			//	查询值综合，
				   		sPageCurrent		//	当前页码签;
				   		;
	private	String[]	strs;
	private int    		operId	   =	0,	//	操作类型;
				   		nSize	   =	0,	//	长度;
//				   		nItemLimit =	MyConfig.N_PAGE_COUNT,	//	数量限制;
				   		nItemLimit =	7,
				   		pageCurrent=	0,	//	当前页数;
				   		pageCount  =	0,	//	页码计数;
				   		itemCount  =	0;	//	条目计数;	
	private ArrayList<Workerinfo> list;
	private DBTool 		dbTool;
	private HttpSession session;
	
	
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
		
		//	01.登录操作;
		case 1:
			
			wid  		= 	req.getParameter("wid");
			wpwd 		= 	req.getParameter("wpwd");
			
			//验证码验证
			code		=	req.getParameter("code");
			codeNumbers =	Constants.getCheck_number_name();
			
		  	session.setAttribute("message", "");

			if(code.equalsIgnoreCase(codeNumbers))
			{
				sql			=	"select * from workerinfo where wid='"+wid+"' and wpwd='"+wpwd+"' and wtype='永久'";
				list		=	dbTool.doDBQueryWorkerinfo(sql);
				nSize		=	list.size();
				if(nSize>0) {				
					session.setAttribute("user", list.get(0));
					sResult	=	"main.jsp";
				}
				else{
					message ="用户名或密码不正确";
					session.setAttribute("message", message);
					sResult	=	"JYLogin.jsp";
				}
			}
			else{
				message ="验证码错误";
				session.setAttribute("message", message);
				sResult	=	"JYLogin.jsp";
			}
			
			break;

		//	02.全条查询;
		case 2:
			sql			=	"select * from workerinfo order by wid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryWorkerinfo(sql);
			session.setAttribute("listWorker", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", " ");
//			session.setAttribute("kindName", " ");
			sResult		=	"worker/worker_all.jsp";
			break;
		//	03.单条查询;
		case 3:
			wid  		= 	req.getParameter("wid");
			sql			=	"select * from workerinfo where wid='"+wid+"'";
			list		=	dbTool.doDBQueryWorkerinfo(sql);
			session.setAttribute("listWorker", list);
			sResult		=	"worker/worker_detail.jsp";
			break;
			
		//	04.单条信息删除;
		case 4:
//			wid  		= 	req.getParameter("wid");
//			sql			=	"delete from workerinfo where wid='"+wid+"'";
//			dbTool.doDBUpdate(sql);	
//			kindName=(String)session.getAttribute("kindName");
//			kindValue=(String)session.getAttribute("kindValue");
//			sResult		=	"../../JYTest02/user_info?operid=6&kindName="+kindName+"&kindValue="+kindValue+"";
//			searchvalue=(String)session.getAttribute("searchvalue");
//			pageCurrent=Integer.valueOf((String)session.getAttribute("pageCurrent"));
//			sResult		=	"../../JYTest02/user_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
		
			searchvalue		=	req.getParameter("searchvalue");
			sPageCurrent 	= 	req.getParameter("pageCurrent");
			pageCurrent 	= 	Integer.parseInt(sPageCurrent);
			wid  		= 	req.getParameter("wid");
			sql			=	"delete from workerinfo where wid='"+wid+"'";
			dbTool.doDBUpdate(sql);	
			
			str				=	searchvalue+" ";
			System.out.println(pageCurrent);
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp		= 	" where wid like '"+"%"+strs[0]+"%"+"' "
							+ "and wname like '"+"%"+strs[1]+"%"+"' "
							+ "and  wcall like '"+"%"+strs[2]+"%"+"' "
							+ "and wtype like '"+"%"+strs[3].trim()+"%"+"'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from workerinfo " + tmp + " order by wid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryWorkerinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listWorker", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "worker/worker_all.jsp";
				}
			}
			break;
			
		//	05.单条修改;
		case 5:
			wid  		= 	req.getParameter("wid");
			sql			=	"select * from workerinfo where wid='"+wid+"'";
			list		=	dbTool.doDBQueryWorkerinfo(sql);
			session.setAttribute("listWorker", list);
			sResult		=	"worker/worker_update.jsp";
			break;
		//	06.密码修改;
		case 6:
			wid	 	= req.getParameter("wid");
			String pwd	= req.getParameter("pwd");
			wpwd	= req.getParameter("wpwd");
			System.out.println(wpwd);
			sql			=	"select * from workerinfo where wid='"+wid+"' and  wpwd='"+pwd+"'";
			list		=	dbTool.doDBQueryWorkerinfo(sql);
			nSize		=	list.size();
			JSONArray array 	= 	new JSONArray();
			JSONObject obj 	 	= 	new JSONObject();
			if(nSize>0) {				
				sql	 		=	"update workerinfo set wpwd='"+wpwd+"' where wid='"+wid+"' and  wpwd='"+pwd+"'";
				dbTool.doDBUpdate(sql);
				obj.put("message", "密码修改成功！");
				System.out.println("密码修改成功！");
			}
			else{
				obj.put("message", "原始密码错误！");
				System.out.println("原始密码错误！");
			}
			array.add(obj);
			sResult		=	array.toString();
//			sResult		=	"worker/worker_pwd_update.jsp";
			break;
		// 13.权限修改;
		case 13:
			wid	 	= req.getParameter("wid");
			wtype	= req.getParameter("wtype");
			wpermission	= req.getParameter("wpermission");
			sql	 		=	"update workerinfo set wpermission='"+wpermission+"' and wtype='"+wtype+"' where wid='"+wid+"'";
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sResult		=	"../../JYTest02/user_info?operid=3&wid="+wid+"";
			break;
			
		//	07.checkbox信息删除;
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
					tmp	+=	"wid="+strs[i]+" ";
				else
					tmp	+=	"wid="+strs[i]+" or ";
			}
			sql			=	"delete from workerinfo where "+tmp;
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp = "";
			} else {
				strs = str.split(",");
				tmp		= 	" where wid like '"+"%"+strs[0]+"%"+"' "
							+ "and wname like '"+"%"+strs[1]+"%"+"' "
							+ "and wcall like '"+"%"+strs[2]+"%"+"' "
							+ "and wtype like '"+"%"+strs[3].trim()+"%"+"'";
			}
			if (pageCurrent >= 0) {
				pageCount = (pageCurrent);
				itemCount = pageCount * nItemLimit;
				sql = "select * from workerinfo " + tmp + " order by wid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryWorkerinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listWorker", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult = "worker/worker_all.jsp";
				}
			}
//			sResult		=	"../../JYTest02/user_info?operid=12&searchvalue="+searchvalue+"&pageCurrent="+(pageCurrent+1);
			break;
		//	08.信息新增;
		case 8:
//			wid	 =new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
//			wname=new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");;
//			wcall=new String(req.getParameter("wcall").getBytes("ISO8859_1"),"utf-8");;
//			wpwd =new String(req.getParameter("wpwd").getBytes("ISO8859_1"),"utf-8");;
//			wtype =new String(req.getParameter("wtype").getBytes("ISO8859_1"),"utf-8");;
//			wnote=new String(req.getParameter("wnote").getBytes("ISO8859_1"),"utf-8");;
			wid	 	= req.getParameter("wid");
			wname	= req.getParameter("wname");
			wcall	= req.getParameter("wcall");
			wpwd 	= req.getParameter("wpwd");
			wtype	= req.getParameter("wtype");
			wnote	= req.getParameter("wnote");
			sql	 	="insert into workerinfo(wid,wname,wcall,wpwd,wtype,wnote) " +
				"values(" +
				"'"+wid+"'," +
				"'"+wname+"'," +
				"'"+wcall+"'," +
				"'"+wpwd+"'," +
				"'"+wtype+"'," +
				"'"+wnote+"')";
			dbTool.doDBUpdate(sql);
			System.out.println(sql);
			sql			=	"select * from workerinfo order by wid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryWorkerinfo(sql);
			session.setAttribute("listWorker", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult		=	"../../JYTest02/user_info?operid=3&wid="+wid+"";

			break;
		//	09.信息修改后完成;
		case 9:
//			wid			=	new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
//			wname		=	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
//			wcall		=	new String(req.getParameter("wcall").getBytes("ISO8859_1"),"utf-8");
//			wpwd 		=	new String(req.getParameter("wpwd").getBytes("ISO8859_1"),"utf-8");
//			wtype       =	new String(req.getParameter("wtype").getBytes("ISO8859_1"),"utf-8");
//			wnote		=	new String(req.getParameter("wnote").getBytes("ISO8859_1"),"utf-8");

			wid	 	= req.getParameter("wid");
			wname	= req.getParameter("wname");
			wcall	= req.getParameter("wcall");
//			wtype	= req.getParameter("wtype");
			wnote	= req.getParameter("wnote");
			sql	 		=	"update workerinfo set wname='"+wname+"',wcall='"+wcall+"' ,wnote='"+wnote+"' where wid='"+wid+"'";
			dbTool.doDBUpdate(sql);
			sResult		=	"../../JYTest02/user_info?operid=3&wid="+wid+"";
			break;
		//	10.上一页;
		case 10:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
//				tmp		=	"where "+kindName+"='"+kindValue+"'";
				strs			=	str.split(",");
				tmp		= 	" where wid like '"+"%"+strs[0]+"%"+"' and wname like '"+"%"+strs[1]+"%"+"' and  wcall like '"+"%"+strs[2]+"%"+"' and wtype like '"+"%"+strs[3].trim()+"%"+"'";

			}
			if(pageCurrent>0){
				pageCount	=	(pageCurrent-1);
				itemCount	=	pageCount*nItemLimit;
				sql			=	"select * from workerinfo "+tmp+" order by wid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryWorkerinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listWorker", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					session.setAttribute("searchvalue", searchvalue);
					sResult	=	"worker/worker_all.jsp";

				}
			}
			break;
		//	11.下一页;
		case 11:
			searchvalue		=	req.getParameter("searchvalue");
			str				=	searchvalue+" ";
			sPageCurrent	=	req.getParameter("pageCurrent");
			pageCurrent		=	Integer.parseInt(sPageCurrent);
			
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
//				tmp		=	"where "+kindName+"='"+kindValue+"'";
				strs			=	str.split(",");
				tmp		= 	" where wid like '"+"%"+strs[0]+"%"+"' and wname like '"+"%"+strs[1]+"%"+"' and  wcall like '"+"%"+strs[2]+"%"+"' and wtype like '"+"%"+strs[3].trim()+"%"+"'";

			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from workerinfo "+tmp+" order by wid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryWorkerinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listWorker", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("searchvalue", searchvalue);
					sResult	=	"worker/worker_all.jsp";

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
				strs			=	str.split(",");
				tmp		= 	" where wid like '"+"%"+strs[0]+"%"+"' and wname like '"+"%"+strs[1]+"%"+"' and  wcall like '"+"%"+strs[2]+"%"+"' and wtype like '"+"%"+strs[3].trim()+"%"+"'";

			}
			if (pageCurrent >= 0) {
				pageCount = pageCurrent - 1;
				itemCount = pageCount * nItemLimit;

				sql = "select * from workerinfo " + tmp + " order by wid limit " + itemCount + "," + nItemLimit;
				list = dbTool.doDBQueryWorkerinfo(sql);
				nSize = list.size();
				if (nSize > 0) {
					session.setAttribute("listWorker", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult = "worker/worker_all.jsp";
				}
			}
			break;

		//14.综合在一个页面，多条件查询
		case 14:
//			wid			=	new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
//			wname		=	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
//			wcall		=	new String(req.getParameter("wcall").getBytes("ISO8859_1"),"utf-8");
//			wtype       =	new String(req.getParameter("wtype").getBytes("ISO8859_1"),"utf-8");
			searchvalue	=	new String(req.getParameter("searchvalue").getBytes("ISO8859_1"),"utf-8");
			str				=	searchvalue+" ";
			if (str.trim().equals("")) {
				tmp		=	"";
			}else{
				strs			=	str.split(",");
				tmp		= 	" where wid like '"+"%"+strs[0]+"%"+"' "
						+ "and wname like '"+"%"+strs[1]+"%"+"' "
						+ "and  wcall like '"+"%"+strs[2]+"%"+"' "
						+ "and wtype like '"+"%"+strs[3].trim()+"%"+"'";
			}
			sql = "select * from workerinfo  "+tmp+" order by wid limit 0,"+nItemLimit;
			System.out.println(sql);
			list = dbTool.doDBQueryWorkerinfo(sql);
			session.setAttribute("listWorker", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("searchvalue", searchvalue);
			
			sResult = "worker/worker_all.jsp";
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
