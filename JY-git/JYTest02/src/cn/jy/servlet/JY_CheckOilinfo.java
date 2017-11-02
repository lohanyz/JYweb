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
import cn.jy.entity.Oilinfo;
import cn.jy.tool.DBTool;

public class JY_CheckOilinfo extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String 		  id,okind,oid,opayway,ocardid,ocity,oimg,otime,tid,wid,wname;
	private double		  oliter,omoney,olmoney,omile,olat,olng;
	
	private int 		nOperType,
						nSize;
	private String  	sql,
						sOperType,
						sResult="fail"
						;	
	ArrayList<Oilinfo> list;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();
		DBTool 		dbTool	=	new DBTool();
		
		sOperType			=	req.getParameter("operType"); 
		nOperType			=	Integer.parseInt(sOperType);
		switch (nOperType) {
		//信息查询
		case 1:
			id			=	req.getParameter("id");
			sql			=	"select * from oilinfo where id="+id;
			list		=	dbTool.doDBQueryOilinfo(sql);
			nSize=list.size();
			if(nSize>0){			
				JSONArray array = new JSONArray();
				for (Oilinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("id", bean.getId());
						obj.put("okind", bean.getOkind());
						obj.put("oid", bean.getOid());
						obj.put("oliter", bean.getOliter());
						obj.put("omoney", bean.getOmoney());
						obj.put("opayway", bean.getOpayway());
						obj.put("ocardid", bean.getOcardid());
						obj.put("olmoney", bean.getOlmoney());
						obj.put("omile", bean.getOmile());
						obj.put("olat", bean.getOlat());
						obj.put("olng", bean.getOlng());
						obj.put("ocity", bean.getOcity());
						obj.put("oimg", bean.getOimg());
						obj.put("otime", bean.getOtime());
						obj.put("tid", bean.getTid());
						obj.put("wid", bean.getWid());
						obj.put("wname", bean.getWname());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult=array.toString();
			}		
			break;
			
		//信息新增
		case 2:
			 id 	= 	req.getParameter("id");
			 okind 	= 	new String(req.getParameter("okind").getBytes("ISO8859_1"),"utf-8");
			 oid 	= 	new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
			 oliter	= 	Double.valueOf(req.getParameter("oliter"));
			 omoney 	= 	Double.valueOf(req.getParameter("omoney"));
			 opayway	= 	new String(req.getParameter("opayway").getBytes("ISO8859_1"),"utf-8");
			 ocardid	= 	new String(req.getParameter("ocardid").getBytes("ISO8859_1"),"utf-8");
			 olmoney = 	Double.valueOf(req.getParameter("olmoney"));
			 omile 	= 	Double.valueOf(req.getParameter("omile"));
			 olat 	= 	Integer.valueOf(req.getParameter("olat"));
			 olng 	= 	Integer.valueOf(req.getParameter("olng"));
			 ocity 	= 	new String(req.getParameter("ocity").getBytes("ISO8859_1"),"utf-8");
			 oimg 	= 	new String(req.getParameter("oimg").getBytes("ISO8859_1"),"utf-8");
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
			sResult="success";
			break;
		
		//修改信息
		case 3:
			 id 	= 	req.getParameter("id");
			 okind 	= 	new String(req.getParameter("okind").getBytes("ISO8859_1"),"utf-8");
			 oid 	= 	new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
			 oliter	= 	Double.valueOf(req.getParameter("oliter"));
			 omoney 	= 	Double.valueOf(req.getParameter("omoney"));
			 opayway	= 	new String(req.getParameter("opayway").getBytes("ISO8859_1"),"utf-8");
			 ocardid	= 	new String(req.getParameter("ocardid").getBytes("ISO8859_1"),"utf-8");
			 olmoney = 	Double.valueOf(req.getParameter("olmoney"));
			 omile 	= 	Double.valueOf(req.getParameter("omile"));
			 olat 	= 	Integer.valueOf(req.getParameter("olat"));
			 olng 	= 	Integer.valueOf(req.getParameter("olng"));
			 ocity 	= 	new String(req.getParameter("ocity").getBytes("ISO8859_1"),"utf-8");
			 oimg 	= 	new String(req.getParameter("oimg").getBytes("ISO8859_1"),"utf-8");
			 otime 	= 	new String(req.getParameter("otime").getBytes("ISO8859_1"),"utf-8");
			 tid 	= 	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			 wid 	= 	new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
			 wname 	= 	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
			 
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
			sResult="success";
			break;		
			
		//删除信息
		case 4:
			id 	= 	req.getParameter("id");
			 
			sql			=	"delete from oilinfo where  id='"+ id+"'";

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;

		default:
			break;
		
		}
		
//		String 		okind 	= 	new String(req.getParameter("okind").getBytes("ISO8859_1"),"utf-8");
//		String 		oid 	= 	new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
//		String 		oliter	= 	req.getParameter("oliter");
//		String 		omoney 	= 	req.getParameter("omoney");
//		String 		opayway	= 	new String(req.getParameter("opayway").getBytes("ISO8859_1"),"utf-8");
//		String 		ocardid	= 	new String(req.getParameter("ocardid").getBytes("ISO8859_1"),"utf-8");
//		String 	 	olmoney = 	req.getParameter("olmoney");
//		String 	 	omile 	= 	req.getParameter("omile");
//		String 	 	olat 	= 	req.getParameter("olat");
//		String 	 	olng 	= 	req.getParameter("olng");
//		String 	 	ocity 	= 	new String(req.getParameter("ocity").getBytes("ISO8859_1"),"utf-8");
//		String 	 	oimg 	= 	new String(req.getParameter("oimg").getBytes("ISO8859_1"),"utf-8");
//		String 	 	otime 	= 	new String(req.getParameter("otime").getBytes("ISO8859_1"),"utf-8");
//		String 	 	tid 	= 	new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
//		String 	 	wid 	= 	new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
//		String 	 	wname 	= 	new String(req.getParameter("wname").getBytes("ISO8859_1"),"utf-8");
//		System.out.println("xx");
//		String		sql		=
//		"insert into oilinfo (" +
//		"okind,oid,oliter,omoney,opayway,ocardid,olmoney,omile,olat,olng,ocity,oimg,otime,tid,wid,wname) values (" +
//		"'"+okind+"'," +
//		"'"+oid+"',"+ 
//		""+oliter+"," +
//		""+omoney+"," +
//		"'"+opayway+"'," +
//		"'"+ocardid+"'," +
//		""+olmoney+"," +
//		""+omile+"," +
//		""+olat+"," +
//		""+olng+"," +
//		"'"+ocity+"'," +
//		"'"+oimg+"'," +
//		"'"+otime+"'," +
//		"'"+tid+"'," +
//		"'"+wid+"'," +
//		"'"+wname+"')"; 
//		System.out.println(sql);
		dbTool.doDBUpdate(sql);
		pWriter.print("success");
		pWriter.flush();
		pWriter.close();

	}
	
	
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();
		
		String wId = req.getParameter("wid");
		String wPwd = req.getParameter("wpwd");
		System.out.println("wid="+wId);
		System.out.println("wpwd="+wPwd);
		pWriter.flush();
		pWriter.close();
	}

}
