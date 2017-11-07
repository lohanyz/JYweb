package cn.jy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snsoft.tss.quote.chance.cxf.FtcCenterWebServiceBas;
import snsoft.tss.quote.chance.cxf.FtcCenterWebServiceBasService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.jy.entity.Businessinfo;
import cn.jy.entity.Getgoodsinfo;
import cn.jy.entity.Goodsinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_CheckGetgoodsinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int nOperType, nSize;

	private String sOperType, bid, gid, ggid, gstate, gsimg, lkind, tid, tkind, oid, gtime, stime, percount, perweight,
			tformatweight, tcount, sql, sResult = "fail", tmp;

	private ArrayList<Getgoodsinfo> list;
	private ArrayList<Businessinfo> list1;
	private ArrayList<Goodsinfo> list2;
	private FtcCenterWebServiceBas bas;
	private FtcCenterWebServiceBasService basService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pWriter = resp.getWriter();
		DBTool dbTool = new DBTool();
		MyConfig myConfig = new MyConfig();
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		req.getRequestURL();
		sOperType = req.getParameter("operType");
		nOperType = Integer.parseInt(sOperType);
		basService = new FtcCenterWebServiceBasService();
		bas = basService.getFtcCenterWebServiceBasPort();
		switch (nOperType) {
		// 网络更新;
		case 1:

			bid = new String(req.getParameter("bid").getBytes("iso-8859-1"), "utf-8");
			gid = new String(req.getParameter("gid").getBytes("iso-8859-1"), "utf-8");
			gstate = req.getParameter("gstate");
			gsimg = req.getParameter("gsimg");
			lkind = req.getParameter("lkind");
			tid = req.getParameter("tid");
			tkind = req.getParameter("tkind");
			oid = req.getParameter("oid");
			gtime = req.getParameter("gtime");
			stime = req.getParameter("stime");
			percount = req.getParameter("percount");
			perweight = req.getParameter("perweight");
			tcount = req.getParameter("tcount");
			tformatweight = req.getParameter("tformatweight");

			String wid = new String(req.getParameter("wid").getBytes("iso-8859-1"), "utf-8");
			String sql = "insert into getgoodsinfo ("
					+ "bid,gid,gstate,gsimg,lkind,tid,tkind,oid,percount,perweight,tformatweight,tcount,gtime,stime) values ("
					+ "'" + bid + "'," + "'" + gid + "'," + "'" + gstate + "'," + "'" + gsimg + "'," + "'" + lkind
					+ "'," + "'" + tid + "'," + "'" + tkind + "'," + "'" + oid + "'," + "" + percount + "," + ""
					+ perweight + "," + tformatweight + "," + tcount + "," + "'" + gtime + "'," + "'" + stime + "')";
			System.out.println(sql);
			dbTool.doDBUpdate(sql);

			sql = "insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime)values(" + "'" + wid + "',"
					+ "'null'," + "'" + bid + "'," + "'" + gid + "','提货操作','新增操作'," + "'"
					+ myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分") + "'" + ")";
			System.out.println(sql);

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;

		case 2:
			tmp = new String(req.getParameter("gid").getBytes("iso-8859-1"), "utf-8");

			if (tmp.contains("-")) {
				bid = tmp.substring(0, tmp.indexOf("-"));
				gid = tmp.substring(tmp.indexOf("-") + 1, tmp.length());
				sql = "select * from businessinfo where bid='" + bid + "'";
				list1 = dbTool.doDBQueryBusinessinfo(sql);
				array = new JSONArray();
				obj = new JSONObject();
				int nSize1 = list1.size();
				if (nSize1 > 0) {
					Businessinfo business = list1.get(0);
					obj.put("bid", business.getBid());
					obj.put("bname", business.getBname());
					obj.put("bkind", business.getBkind());
					obj.put("bcoman", business.getBcoman());
					obj.put("bgaddress", business.getBgaddress());
					obj.put("bgoid", business.getBgoid());
					obj.put("bshipcom", business.getBshipcom());
					obj.put("bpretoportday", business.getBpretoportday());
					obj.put("boxid", business.getBoxid());
					obj.put("boxsize", business.getBoxsize());
					obj.put("boxkind", business.getBoxkind());
					obj.put("boxbelong", business.getBoxbelong());
					obj.put("retransway", business.getRetransway());
				}
				System.out.println(sql);
				sql = "select * from goodsinfo where gid='" + gid + "' and bid='" + bid + "'";
				list2 = dbTool.doDBQueryGoodsinfo(sql);
				int nSize2 = list2.size();
				if (nSize2 > 0) {
					Goodsinfo goods = list2.get(0);
					obj.put("gid", goods.getGid());
					obj.put("gname", goods.getGname());
					obj.put("boxid", goods.getBoxid());
					obj.put("boxsize", goods.getBoxsize());
					obj.put("boxkind", goods.getBoxkind());
					obj.put("leadnumber", goods.getLeadnumber());
					obj.put("gcount", goods.getGcount());
					obj.put("gunit", goods.getGunit());
					obj.put("gtotalweight", goods.getGtotalweight());
					obj.put("glength", goods.getGlength());
					obj.put("gwidth", goods.getGwidth());
					obj.put("gheight", goods.getGheight());
					obj.put("gvolume", goods.getGvolume());
					if (nSize1 > 0 && nSize2 > 0) {
						array.add(obj);
						sResult = array.toString();
					}
				}
			}
			// array.add(obj);
			// System.out.println(sql);
			// sResult=array.toString();
			break;

		case 3:

			bid = new String(req.getParameter("bid").getBytes("iso-8859-1"), "utf-8");
			gid = new String(req.getParameter("gid").getBytes("iso-8859-1"), "utf-8");
			gstate = new String(req.getParameter("gstate").getBytes("iso-8859-1"), "utf-8");
			gsimg = new String(req.getParameter("gsimg").getBytes("iso-8859-1"), "utf-8");
			lkind = new String(req.getParameter("lkind").getBytes("iso-8859-1"), "utf-8");
			tid = new String(req.getParameter("tid").getBytes("iso-8859-1"), "utf-8");
			tkind = new String(req.getParameter("tkind").getBytes("iso-8859-1"), "utf-8");
			oid = new String(req.getParameter("oid").getBytes("iso-8859-1"), "utf-8");
			percount = new String(req.getParameter("percount").getBytes("iso-8859-1"), "utf-8");
			perweight = new String(req.getParameter("perweight").getBytes("iso-8859-1"), "utf-8");
			tformatweight = new String(req.getParameter("tformatweight").getBytes("iso-8859-1"), "utf-8");
			tcount = new String(req.getParameter("tcount").getBytes("iso-8859-1"), "utf-8");
			gtime = new String(req.getParameter("gtime").getBytes("iso-8859-1"), "utf-8");
			stime = new String(req.getParameter("stime").getBytes("iso-8859-1"), "utf-8");

			sql = "update getgoodsinfo " + "set gstate='" + gstate + "'," + "gsimg='" + gsimg + "'," + "lkind='" + lkind
					+ "'," + "tid='" + tid + "'," + "tkind=" + tkind + "," + "oid='" + oid + "'," + "gtime='" + gtime
					+ "'," + "stime='" + stime + "'," + "percount='" + percount + "'," + "tcount='" + tcount + "',"
					+ "perweight='" + perweight + "'," + "tformatweight='" + tformatweight + "' " + "where ggid='"
					+ ggid + "'";

			dbTool.doDBUpdate(sql);
			sResult = "success";

			break;
		// 按bid查询
		case 4:
			tmp = new String(req.getParameter("bid").getBytes("iso-8859-1"), "utf-8");
			if (tmp.indexOf("-") < 0) {
				bid = tmp;
				gid = "";
			} else {
				bid = tmp.substring(0, tmp.indexOf("-"));
				gid = tmp.substring(tmp.indexOf("-") + 1);
			}
			System.out.println(bid);
			System.out.println(gid);
			sql = "select * from getgoodsinfo where bid='" + bid + "' and gid='" + gid + "' ";
			list = dbTool.doDBQueryGetgoodsinfo(sql);
			nSize = list.size();
			if (nSize > 0) {
				array = new JSONArray();
				for (Getgoodsinfo bean : list) {
					obj = new JSONObject();
					try {
						// bid,gstate,gsimg,lkind,tid,tkind,oid,gtime,stime,ggid,pertcount,tcount,pertweight,tformatweight;
						obj.put("bid", bean.getBid());
						obj.put("ggid", bean.getGgid());
						obj.put("gstate", bean.getGstate());
						obj.put("gsimg", bean.getGsimg());
						obj.put("lkind", bean.getLkind());
						obj.put("tid", bean.getTid());
						obj.put("tkind", bean.getTkind());
						obj.put("gtime", bean.getGtime());
						obj.put("stime", bean.getStime());
						obj.put("percount", bean.getPercount());
						obj.put("perweight", bean.getPerweight());
						obj.put("tcount", bean.getTcount());
						obj.put("tformatweight", bean.getTformatweight());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult = array.toString();
			} else
				sResult = null;
			break;
		case 5:
			ggid = req.getParameter("ggid");
			sql = "select * from getgoodsinfo where ggid='" + ggid + "'";
			list = dbTool.doDBQueryGetgoodsinfo(sql);
			nSize = list.size();
			if (nSize > 0) {
				array = new JSONArray();
				for (Getgoodsinfo bean : list) {
					obj = new JSONObject();
					try {
						// bid,gstate,gsimg,lkind,tid,tkind,oid,gtime,stime,ggid,pertcount,tcount,pertweight,tformatweight;
						obj.put("bid", bean.getBid());
						obj.put("ggid", bean.getGgid());
						obj.put("gstate", bean.getGstate());
						obj.put("gsimg", bean.getGsimg());
						obj.put("lkind", bean.getLkind());
						obj.put("tid", bean.getTid());
						obj.put("tkind", bean.getTkind());
						obj.put("gtime", bean.getGtime());
						obj.put("stime", bean.getStime());
						obj.put("percount", bean.getPercount());
						obj.put("perweight", bean.getPerweight());
						obj.put("tcount", bean.getTcount());
						obj.put("tformatweight", bean.getTformatweight());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult = array.toString();
			} else
				sResult = null;
			break;

		case 6:
			bid = req.getParameter("bid");
			String str = "{\"barcode\": \"" + bid + "\"}";
			sResult = bas.getBoxGoods(str);
			break;
		default:
			break;
		}

		pWriter.print(sResult);
		sResult = "fail";
		pWriter.flush();
		pWriter.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();

		String wId = req.getParameter("wid");
		String wPwd = req.getParameter("wpwd");
		System.out.println("wid=" + wId);
		System.out.println("wpwd=" + wPwd);
		pWriter.flush();
		pWriter.close();
	}

}
