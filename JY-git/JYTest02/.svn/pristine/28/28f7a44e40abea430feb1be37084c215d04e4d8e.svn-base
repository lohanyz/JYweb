package cn.jy.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Businessinfo;
import cn.jy.entity.Getgoodsinfo;
import cn.jy.entity.Goodsinfo;
import cn.jy.entity.Harborinfo;
import cn.jy.entity.Portinfo;
import cn.jy.entity.Resigninfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Resign extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 		bid,state,simg;
	private int 		rid;
	
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

	private ArrayList<Resigninfo> resignlist;
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
		case 1:
			
			bid  		=	req.getParameter("bid") ;
			sql			=	"select * from businessinfo where bid='"+bid+"'";
			blist		=	dbTool.doDBQueryBusinessinfo(sql);
			session.setAttribute("listBusiness", blist.get(0));
			
			sql			=	"select * from goodsinfo where bid='"+bid+"'";
			goodslist		=	dbTool.doDBQueryGoodsinfo(sql);
			session.setAttribute("listgoods", goodslist.get(0));
			
			sql			=	"select * from resigninfo where bid='"+bid+"'";
			resignlist		=	dbTool.doDBQueryResigninfo(sql);
			session.setAttribute("listResign", resignlist.get(0));
			
			sResult		=	"resign/resign_info.jsp";
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
