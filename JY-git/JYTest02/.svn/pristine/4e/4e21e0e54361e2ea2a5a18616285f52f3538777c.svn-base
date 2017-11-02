package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Goodsinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Goods extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 		bid,gid,gname,boxid, boxsize,boxkind,leadnumber,gunit;
	private int 		gcount;
	private double 		gtotalweight,glength,gheight,gwidth,gvolume;
	
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

	private ArrayList<Goodsinfo> list;
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
		
			break;
			//	04.单条信息删除;
		case 4:
			gid  		= 	req.getParameter("gid");
			sql			=	"delete from goodsinfo where gid='"+gid+"'";
			dbTool.doDBUpdate(sql);		
			kindName=(String)session.getAttribute("kindName");
			kindValue=(String)session.getAttribute("kindValue");
			sResult		=	"../../JYTest02/goods_info?operid=6&kindName="+kindName+"&kindValue="+kindValue+"";
			break;
		case 2:
			sql			=	"select * from goodsinfo order by gid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryGoodsinfo(sql);
			session.setAttribute("listGoods", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult		=	"goods/goods_all.jsp";
			break;
		case 3:
//			gid			=	req.getParameter("gid");
//			sql			=	"select * from goodsinfo where gid='"+gid+"'";
			bid			=	req.getParameter("bid");
			sql			=	"select * from goodsinfo where bid='"+bid+"'";
			list		=	dbTool.doDBQueryGoodsinfo(sql);
			session.setAttribute("listGoods", list);
			sResult		=	"goods/goods_detail.jsp";
			break;
		case 5:
			gid			=	req.getParameter("gid");
			sql			=	"select * from goodsinfo where gid='"+gid+"'";
			list		=	dbTool.doDBQueryGoodsinfo(sql);
			session.setAttribute("listGoods", list);
			sResult		=	"goods/goods_update.jsp";
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
			sql			=	"select * from goodsinfo "+tmp+" order by gid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryGoodsinfo(sql);
			
			session.setAttribute("listGoods", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			
			sResult		=	"goods/goods_all.jsp";
			break;
		//	07.全信息删除;
		case 7:
			sql			=	"delete from goodsinfo ";
			dbTool.doDBUpdate(sql);
			sql			=	"select * from goodsinfo ";
			list		=	dbTool.doDBQueryGoodsinfo(sql);
			session.setAttribute("listGoods", list);
			sResult		=	"goods/goods_all.jsp";
			break;
		//	08.信息新增;
		case 8:
			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			gid			=	new String(req.getParameter("gid").getBytes("ISO8859_1"),"utf-8");
			gname		=	new String(req.getParameter("gname").getBytes("ISO8859_1"),"utf-8");
			boxid		=	new String(req.getParameter("boxid").getBytes("ISO8859_1"),"utf-8");
			boxsize		=	new String(req.getParameter("boxsize").getBytes("ISO8859_1"),"utf-8");
			boxkind		=	new String(req.getParameter("boxkind").getBytes("ISO8859_1"),"utf-8");
			leadnumber	=	new String(req.getParameter("leadnumber").getBytes("ISO8859_1"),"utf-8");
			gunit		=	new String(req.getParameter("gunit").getBytes("ISO8859_1"),"utf-8");
			gcount		=	Integer.valueOf(req.getParameter("gcount"));
			gtotalweight=	Double.valueOf(req.getParameter("gtotalweight"));
			glength		=	Double.valueOf(req.getParameter("glength"));
			gheight		=	Double.valueOf(req.getParameter("gheight"));
			gwidth		=	Double.valueOf(req.getParameter("gwidth"));
			gvolume		=	Double.valueOf(req.getParameter("gvolume"));
			
			sql	 		=	"insert into goodsinfo(bid,gid,gname,boxid, boxsize,boxkind,leadnumber,gunit,gcount,gtotalweight,glength,gheight,gwidth,gvolume) " +
							"values(" +
							"'"+bid+"'," +
							"'"+gid+"'," +
							"'"+gname+"'," +
							""+boxid+"," +
							"'"+boxsize+"'," +
							"'"+boxkind+"'," +
							"'"+leadnumber+"'," +
							"'"+gunit+"'," +
							""+gcount+"," +
							"'"+gtotalweight+"'," +
							"'"+glength+"'," +
							"'"+gheight+"'," +
							"'"+gwidth+"'," +
							"'"+gvolume+"')";
			
			dbTool.doDBUpdate(sql);
			sql			=	"select * from goodsinfo order by gid limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryGoodsinfo(sql);
			session.setAttribute("listGoods", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
//			sResult		=	"goods/goods_all.jsp";
			sResult		=	"../../JYTest02/goods_info?operid=3&gid="+gid+"";

			break;
		//	09.信息修改后完成;
		case 9:
			bid			=	new String(req.getParameter("bid").getBytes("ISO8859_1"),"utf-8");
			gid			=	new String(req.getParameter("gid").getBytes("ISO8859_1"),"utf-8");
			gname		=	new String(req.getParameter("gname").getBytes("ISO8859_1"),"utf-8");
			boxid		=	new String(req.getParameter("boxid").getBytes("ISO8859_1"),"utf-8");
			boxsize		=	new String(req.getParameter("boxsize").getBytes("ISO8859_1"),"utf-8");
			boxkind		=	new String(req.getParameter("boxkind").getBytes("ISO8859_1"),"utf-8");
			leadnumber	=	new String(req.getParameter("leadnumber").getBytes("ISO8859_1"),"utf-8");
			gunit		=	new String(req.getParameter("gunit").getBytes("ISO8859_1"),"utf-8");
			gcount		=	Integer.valueOf(req.getParameter("gcount"));
			gtotalweight=	Double.valueOf(req.getParameter("gtotalweight"));
			glength		=	Double.valueOf(req.getParameter("glength"));
			gheight		=	Double.valueOf(req.getParameter("gheight"));
			gwidth		=	Double.valueOf(req.getParameter("gwidth"));
			gvolume		=	Double.valueOf(req.getParameter("gvolume"));
			System.out.println(gname);
			sql	 		=	"update goodsinfo "
					+ "set gname='"+gname+"',"
					+ "boxid="+boxid+","
					+ "boxsize='"+boxsize+"',"
					+ "boxkind='"+boxkind+"',"
					+ "leadnumber="+leadnumber+","
					+ "gunit='"+gunit+"',"
					+ "gcount='"+gcount+"',"
					+ "gtotalweight="+gtotalweight+","
					+ "glength='"+glength+"',"
					+ "gheight='"+gheight+"',"
					+ "gwidth="+gwidth+","
					+ "gvolume='"+gvolume+"' "
					+ "where gid='"+gid+"'";

			dbTool.doDBUpdate(sql);
					
//			sql			=	"select * from goodsinfo order by gid limit 0,"+nItemLimit;
//			list		=	dbTool.doDBQueryGoodsinfo(sql);
//			session.setAttribute("listGoods", list);
//			session.setAttribute("pageCurrent", "0");
//			session.setAttribute("kindName", " ");
//			sResult		=	"goods/goods_all.jsp";
			sResult		=	"../../JYTest02/goods_info?operid=5&gid="+gid+"";

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
				sql			=	"select * from goodsinfo "+tmp+" order by gid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryGoodsinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listGoods", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					sResult		=	"goods/goods_all.jsp";
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
				sql			=	"select * from goodsinfo "+tmp+" order by gid limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryGoodsinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listGoods", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult		=	"goods/goods_all.jsp";
				}
			}
			break;
			
			
//			11.某一页;
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
						sql			=	"select * from goodsinfo "+tmp+" order by gid limit "+itemCount+","+nItemLimit;
						list		=	dbTool.doDBQueryGoodsinfo(sql);
						nSize		=	list.size();
						if(nSize>0){					
							session.setAttribute("listGoods", list);
							session.setAttribute("pageCurrent", String.valueOf(pageCount));
							sResult		=	"goods/getgoods_all.jsp";
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
