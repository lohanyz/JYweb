package cn.jy.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;
import cn.jy.entity.Boxmanageinfo;
import cn.jy.entity.Businessinfo;
import cn.jy.entity.Getgoodsinfo;
import cn.jy.entity.Goodsinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Getgoods extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String		bid,gstate,gsimg,lkind,tid,tkind,oid,gtime,stime;
	private int 		ggid,pertcount,tcount;
	private double		pertweight,tformatweight;
	//bid,gstate,gsimg,lkind,tid,tkind,oid,gtime,stime,ggid,pertcount,tcount,pertweight,tformatweight;
	private String 		sResult	=	"error.jsp",
						sql,
						tmp,
						kindName,
						kindValue,
						sPageCurrent
						;
	
	private int 		operId 	   =	0,	//	操作类型;
			  			nSize	   =	0,	//	长度;
			  			nItemLimit =	MyConfig.N_PAGE_COUNT,	//	数量限制;
			  			pageCurrent=	0,	//	当前页数;
			  			pageCount  =	0,	//	页码计数;
			  			itemCount  =	0;	//	条目计数;	

	private ArrayList<Getgoodsinfo> ggoodslist;
	private ArrayList<Businessinfo> blist;
	private ArrayList<Goodsinfo> goodslist;
	private DBTool 		dbTool;
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
		
		// 01.获取主要返回参数
		case 1:
			bid  		=	req.getParameter("bid") ;
			sql			=	"select * from businessinfo where bid='"+bid+"'";
			blist		=	dbTool.doDBQueryBusinessinfo(sql);
			
			session.setAttribute("listBusiness", blist.get(0));
			
			sql			=	"select * from goodsinfo where bid='"+bid+"'";
			goodslist		=	dbTool.doDBQueryGoodsinfo(sql);
			session.setAttribute("listgoods", goodslist.get(0));
			
			sql			=	"select * from getgoodsinfo where bid='"+bid+"'";
			ggoodslist		=	dbTool.doDBQueryGetgoodsinfo(sql);
			session.setAttribute("listgetgoods", ggoodslist.get(0));
			
			sResult		=	"getgoods/getgoods_info.jsp";
			break;
			
		//货物概要信息	
		case 2:
			bid  		=	req.getParameter("bid") ;
			sql			=	"select * from goodsinfo where bid='"+bid+"'";
			goodslist		=	dbTool.doDBQueryGoodsinfo(sql);
			session.setAttribute("listgoods", goodslist);
			sResult		=	"getgoods/getgoods_info.jsp";
			break;
			

		//单条信息
		case 3:
			bid  		=	req.getParameter("bid") ;
			sql			=	"select * from getgoodsinfo where bid='"+bid+"'";
			ggoodslist		=	dbTool.doDBQueryGetgoodsinfo(sql);
			session.setAttribute("listgetgoods", ggoodslist);
			sResult		=	"getgoods/getgoods_info.jsp";
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
