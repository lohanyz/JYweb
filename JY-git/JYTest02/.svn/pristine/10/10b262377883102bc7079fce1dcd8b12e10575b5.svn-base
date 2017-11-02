package cn.jy.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jy.entity.Oilinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_Web_Oil extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 		  id,okind,oid,opayway,ocardid,ocity,oimg,otime,tid,wid,wname;
	private double		  oliter,omoney,olmoney,omile,olat,olng;
	private String		  sResult	=	"error.jsp",
						  sql,
						  tmp,
						  kindName,
						  kindValue,
						  sPageCurrent
						  ;
	

	private	int 		  operId	 =	0,	//	操作类型;
						  nSize	   	 =	0,	//	长度;
						  nItemLimit =	MyConfig.N_PAGE_COUNT,	//	数量限制;
						  pageCurrent=	0,	//	当前页数;
						  pageCount  =	0,	//	页码计数;
						  itemCount  =	0;	//	条目计数;	
	
	private ArrayList<Oilinfo> 	  list;
	private DBTool 		  dbTool	;
	private HttpSession   session	;

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
			id  		= 	req.getParameter("id");
			sql			=	"delete from oilinfo where id="+id;
			dbTool.doDBUpdate(sql);		
			kindName=(String)session.getAttribute("kindName");
			kindValue=(String)session.getAttribute("kindValue");
			sResult		=	"../../JYTest02/oil_info?operid=6&kindName="+kindName+"&kindValue="+kindValue+"";
			break;
		case 2:
			sql			=	"select * from oilinfo order by id limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryOilinfo(sql);
			session.setAttribute("listOil", list);
			System.out.println(list.size());
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult		=	"oil/oil_all.jsp";
			break;
		case 3:
			id			=	req.getParameter("id");
			sql			=	"select * from oilinfo where id="+id;
			list		=	dbTool.doDBQueryOilinfo(sql);
			session.setAttribute("listOil", list);
			sResult		=	"oil/oil_detail.jsp";
			break;
		case 5:
			id			=	req.getParameter("id");
			sql			=	"select * from oilinfo where id="+id;
			list		=	dbTool.doDBQueryOilinfo(sql);
			session.setAttribute("listOil", list);
			sResult		=	"oil/oil_update.jsp";
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
			sql			=	"select * from oilinfo "+tmp+" order by id limit 0,"+nItemLimit;
			list		=	dbTool.doDBQueryOilinfo(sql);
			session.setAttribute("listOil", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", kindName);
			session.setAttribute("kindValue", kindValue);
			
			sResult		=	"oil/oil_all.jsp";
			break;
//			13.分类查询;
				case 13:
					kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");
					kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");
					System.out.println(kindName);
					System.out.println(kindValue);

					if(kindName.equals(" ")){
						tmp		=	"";
					}else{
						tmp		=	"where "+kindName+"='"+kindValue+"'";
					}
					sql			=	"select * from oilinfo "+tmp+" order by id limit 0,"+nItemLimit;
					list		=	dbTool.doDBQueryOilinfo(sql);
					session.setAttribute("listOil", list);
					session.setAttribute("pageCurrent", "0");
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					
					sResult		=	"oil/oil_all.jsp";
					break;
		//	07.全信息删除;
		case 7:
			sql			=	"delete from oilinfo ";
			dbTool.doDBUpdate(sql);
			sql			=	"select * from oilinfo ";
			list		=	dbTool.doDBQueryOilinfo(sql);
			session.setAttribute("listOil", list);
			sResult		=	"oil/oil_detail.jsp";
			break;
	//		08.信息新增;
		case 8:
			 id 	= 	req.getParameter("id");
			 okind 	= 	new String(req.getParameter("okind").getBytes("ISO8859_1"),"utf-8");
			 oid 	= 	new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
			 oliter	= 	Double.valueOf(req.getParameter("oliter"));
			 omoney 	= 	Double.valueOf(req.getParameter("omoney"));
			 opayway	= 	new String(req.getParameter("opayway").getBytes("ISO8859_1"),"utf-8");
			 ocardid	= 	new String(req.getParameter("ocardid").getBytes("ISO8859_1"),"utf-8");
			 olmoney = 	Double.valueOf(req.getParameter("olmoney"));
			 omile 	= 	Double.valueOf(req.getParameter("omile"));
	//		 olat 	= 	req.getParameter("olat");
	//		 olng 	= 	req.getParameter("olng");
			 olat 	= 	1;
			 olng 	= 	1;
			 ocity 	= 	new String(req.getParameter("ocity").getBytes("ISO8859_1"),"utf-8");
	//		 oimg 	= 	new String(req.getParameter("oimg").getBytes("ISO8859_1"),"utf-8");
			 oimg 	= 	"oil/images/1.jpg";
			 otime 	= 	new String(req.getParameter("otime").getBytes("ISO8859_1"),"utf-8");
			 tid 	= 	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			 wid 	= 	new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
			 wname 	= 	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
				
			 sql		=
					"insert into oilinfo (" +
					"okind,oid,oliter,omoney,opayway,ocardid,olmoney,omile,olat,olng,ocity,oimg,otime,tid,wid,wname) values(" +
					"'"+okind+"'," +
					"'"+oid+"',"+ 
					""+oliter+"," +
					""+omoney+"," +
					"'"+opayway+"'," +
					"'"+ocardid+"'," +
					""+olmoney+"," +
					""+omile+"," +
					""+olat+"," +
					""+olng+"," +
					"'"+ocity+"'," +
					"'"+oimg+"'," +
					"'"+otime+"'," +
					"'"+tid+"'," +
					"'"+wid+"'," +
					"'"+wname+"')"; 
			dbTool.doDBUpdate(sql);
//			sql			=	"select * from oilinfo order by id limit 0,"+nItemLimit;
//			list		=	dbTool.doDBQueryOilinfo(sql);
//			session.setAttribute("listOil", list);
//			session.setAttribute("pageCurrent", "0");
//			session.setAttribute("kindName", " ");
			
			sql			=	"select * from oilinfo order by id desc limit 1";
			list		=	dbTool.doDBQueryOilinfo(sql);
			System.out.println(list.get(0).getId());
			sResult		=	"../../JYTest02/oil_info?operid=3&id="+list.get(0).getId()+"";
			break;
			
//			09.信息修改后完成;
		case 9:
			id = req.getParameter("id");
			okind = new String(req.getParameter("okind").getBytes("ISO8859_1"), "utf-8");
			oid = new String(req.getParameter("oid").getBytes("ISO8859_1"), "utf-8");
			oliter = Double.valueOf(req.getParameter("oliter"));
			omoney = Double.valueOf(req.getParameter("omoney"));
			opayway = new String(req.getParameter("opayway").getBytes( "ISO8859_1"), "utf-8");
			ocardid = new String(req.getParameter("ocardid").getBytes( "ISO8859_1"), "utf-8");
			olmoney = Double.valueOf(req.getParameter("olmoney"));
			omile = Double.valueOf(req.getParameter("omile"));
			// olat = req.getParameter("olat");
			// olng = req.getParameter("olng");
			olat = 1;
			olng = 1;
			ocity = new String(req.getParameter("ocity").getBytes("ISO8859_1"), "utf-8");
			// oimg = new
			// String(req.getParameter("oimg").getBytes("ISO8859_1"),"utf-8");
			oimg = "oil/images/1.jpg";
			otime = new String(req.getParameter("otime").getBytes("ISO8859_1"), "utf-8");
			tid = new String(req.getParameter("tid").getBytes("ISO8859_1"), "utf-8");
			wid = new String(req.getParameter("wid").getBytes("ISO8859_1"), "utf-8");
			wname = new String(req.getParameter("wname").getBytes("ISO8859_1"), "utf-8");

			sql = "update oilinfo set "
					+ "okind='" + okind + "',"
					+ "oid='" + oid+ "',"
					+ "oliter='" + oliter + "',"
					+ "omoney='" + omoney+ "',"
					+ "opayway='" + opayway + "',"
					+ "ocardid='" + ocardid+ "',"
					+ "olmoney='" + olmoney + "'," 
					+ "omile='" + omile+ "',"
					+ "ocity='" + ocity + "',"
					+ "otime='" + otime + "',"
					+ "tid='"+ tid + "',"
					+ "wid='" + wid + "',"
					+ "wname='" + wname
					+ "' where  id='" + id + "'";
			
			dbTool.doDBUpdate(sql);
			sql = "select * from oilinfo order by id limit 0," + nItemLimit;
			list = dbTool.doDBQueryOilinfo(sql);
			session.setAttribute("listOil", list);
			session.setAttribute("pageCurrent", "0");
			session.setAttribute("kindName", " ");
			sResult = "../../JYTest02/oil_info?operid=5&id=" + id + "";
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
				sql			=	"select * from oilinfo "+tmp+" order by id limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryOilinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listOil", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					session.setAttribute("kindName", kindName);
					session.setAttribute("kindValue", kindValue);
					sResult		=	"oil/oil_all.jsp";
				}
			}
			break;
		//	11.下一页;
		case 11:
			kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
			kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
			
			sPageCurrent=	req.getParameter("pageCurrent");
			pageCurrent	=	Integer.parseInt(sPageCurrent);
			
			if(kindName.equals(" ")){
				tmp		=	"";
			}else{
				tmp		=	"where "+kindName+"='"+kindValue+"'";
			}
			if(pageCurrent>=0){
				pageCount	=	(pageCurrent+1);
				itemCount	= 	pageCount*nItemLimit;
				sql			=	"select * from oilinfo "+tmp+" order by id limit "+itemCount+","+nItemLimit;
				list		=	dbTool.doDBQueryOilinfo(sql);
				nSize		=	list.size();
				if(nSize>0){					
					session.setAttribute("listOil", list);
					session.setAttribute("pageCurrent", String.valueOf(pageCount));
					sResult	=	"oil/oil_all.jsp";
				}
			}
			break;	
//			12.某一页;
				case 12:
					kindName  	= 	new String(req.getParameter("kindName").getBytes("ISO8859_1"),"utf-8");;
					kindValue  	= 	new String(req.getParameter("kindValue").getBytes("ISO8859_1"),"utf-8");;
					
					sPageCurrent=	req.getParameter("pageCurrent");
					pageCurrent	=	Integer.parseInt(sPageCurrent);
					
					if(kindName.equals(" ")){
						tmp		=	"";
					}else{
						tmp		=	"where "+kindName+"='"+kindValue+"'";
					}
					if(pageCurrent>=0){
						pageCount	=	(pageCurrent-1);
						itemCount	= 	pageCount*nItemLimit;
						sql			=	"select * from oilinfo "+tmp+" order by id limit "+itemCount+","+nItemLimit;
						list		=	dbTool.doDBQueryOilinfo(sql);
						nSize		=	list.size();
						if(nSize>0){					
							session.setAttribute("listOil", list);
							session.setAttribute("pageCurrent", String.valueOf(pageCount));
							sResult	=	"oil/oil_all.jsp";
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
