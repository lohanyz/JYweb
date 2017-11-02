package cn.jy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.jy.entity.Goodsinfo;
import cn.jy.tool.DBTool;

public class JY_CheckGoodsinfo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private int    nOperType,
				   nSize;
	private String sOperType,
				   gid,
				   bid,
				   gname,
				   boxid,
				   boxsize,
				   boxkind,
				   leadnumber,
				   gunit,
				   sql,
				   tmp,
				   sResult="fail"
				   ;
	
	private int    gcount;
	private double gtotalweight,
				   glength,
				   gwidth,
				   gheight,
				   gvolume;
	private ArrayList<Goodsinfo> list;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = 	resp.getWriter();
		DBTool 		dbTool	=	new DBTool();
		sOperType			=	req.getParameter("operType"); 
		nOperType			=	Integer.parseInt(sOperType);
		JSONArray array;
		switch (nOperType) {
		//	网络更新;
		case 1:
			bid 			= 	req.getParameter("bid");
			sql				=	"select * from goodsinfo where bid='"+bid+"'";
			list			=	dbTool.doDBQueryGoodsinfo(sql);
			nSize			=	list.size();		
			if(nSize>0){	
				array = new JSONArray();
				for (Goodsinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("gid", bean.getGid());
						obj.put("bid", bean.getBid());
						obj.put("gname", bean.getGname());
						obj.put("boxid", bean.getBoxid());
						obj.put("boxsize", bean.getBoxsize());
						obj.put("boxkind", bean.getBoxkind());
						obj.put("leadnumber", bean.getLeadnumber());
						obj.put("gcount", bean.getGcount());
						obj.put("gunit", bean.getGunit());
						obj.put("gtotalweight", bean.getGtotalweight());
						obj.put("glength", bean.getGlength());
						obj.put("gwidth", bean.getGwidth());
						obj.put("gheight", bean.getGheight());
						obj.put("gvolume", bean.getGvolume());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult=array.toString();
			}		
			else
				sResult=null;
			break;
		case 4:
			tmp				=	new String(req.getParameter("bid").getBytes("iso-8859-1"),"utf-8");
			if(tmp.indexOf("-")<0){
				bid=tmp;
				gid="";
			}
			else{
				bid				=	tmp.substring(0, tmp.indexOf("-"));
				gid				=	tmp.substring(tmp.indexOf("-")+1 );
			}
			
			sql				=	"select * from goodsinfo where gid='"+gid+"' and bid='"+bid+"'";
			list			=	dbTool.doDBQueryGoodsinfo(sql);
			nSize			=	list.size();		
			array = new JSONArray();
			if(nSize>0){			
				for (Goodsinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("gid", bean.getGid());
						obj.put("bid", bean.getBid());
						obj.put("gname", bean.getGname());
						obj.put("boxid", bean.getBoxid());
						obj.put("boxsize", bean.getBoxsize());
						obj.put("boxkind", bean.getBoxkind());
						obj.put("leadnumber", bean.getLeadnumber());
						obj.put("gcount", bean.getGcount());
						obj.put("gunit", bean.getGunit());
						obj.put("gtotalweight", bean.getGtotalweight());
						obj.put("glength", bean.getGlength());
						obj.put("gwidth", bean.getGwidth());
						obj.put("gheight", bean.getGheight());
						obj.put("gvolume", bean.getGvolume());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult=array.toString();
			}		
			else
				sResult=null;
			break;
		//信息新增
		case 2:
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
			sResult = "success";
			break;

		// 修改信息
		case 3:
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
			sResult = "success";
			break;
		// 删除信息
		case 5:
			gid  		= 	req.getParameter("gid");
			sql			=	"delete from goodsinfo where gid='"+gid+"'";

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;

		default:
			break;

		}
		pWriter.print(sResult)	;
		pWriter.flush();
		pWriter.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();
		doGet(req, resp);
//		String wId = req.getParameter("wid");
//		String wPwd = req.getParameter("wpwd");
//		System.out.println("wid="+wId);
//		System.out.println("wpwd="+wPwd);
		pWriter.flush();
		pWriter.close();
	}

}
