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
import snsoft.tss.quote.chance.cxf.FtcCenterWebServiceBas;
import snsoft.tss.quote.chance.cxf.FtcCenterWebServiceBasService;
import cn.jy.entity.Portinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_CheckPortinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String bid, gid, inporttime, ctime, intime, pboxtime, state, simg, lkind, reporttime, classorderid, tid,
			tkind, oid, gtime, stime, wid;
	private int pid, percount, tcount;
	private boolean islean;
	private double perweight, tformatweight;

	private int nOperType, nSize;
	private String sql, tmp, sOperType, sResult = "fail";
	ArrayList<Portinfo> list;
	private FtcCenterWebServiceBas bas;
	private FtcCenterWebServiceBasService basService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();
		MyConfig myConfig = new MyConfig();
		DBTool dbTool = new DBTool();
		sOperType = req.getParameter("operType");
		nOperType = Integer.parseInt(sOperType);
		basService = new FtcCenterWebServiceBasService();
		bas = basService.getFtcCenterWebServiceBasPort();
		switch (nOperType) {
		// 信息新增
		case 1:
			bid = new String(req.getParameter("bid").getBytes("ISO8859_1"), "utf-8");
			gid = new String(req.getParameter("gid").getBytes("ISO8859_1"), "utf-8");
			// inporttime = new
			// String(req.getParameter("inporttime").getBytes("ISO8859_1"),"utf-8");
			// ctime = new String(req.getParameter("ctime").getBytes("ISO8859_1"),"utf-8");
			// intime = new
			// String(req.getParameter("intime").getBytes("ISO8859_1"),"utf-8");
			// pboxtime = new
			// String(req.getParameter("pboxtime").getBytes("ISO8859_1"),"utf-8");
			// state = new String(req.getParameter("state").getBytes("ISO8859_1"),"utf-8");
			// simg = new String(req.getParameter("simg").getBytes("ISO8859_1"),"utf-8");
			// lkind = new String(req.getParameter("lkind").getBytes("ISO8859_1"),"utf-8");
			// reporttime = new
			// String(req.getParameter("reporttime").getBytes("ISO8859_1"),"utf-8");
			// classorderid = new
			// String(req.getParameter("classorderid").getBytes("ISO8859_1"),"utf-8");
			// tid = new String(req.getParameter("tid").getBytes("ISO8859_1"),"utf-8");
			// tkind = new String(req.getParameter("tkind").getBytes("ISO8859_1"),"utf-8");
			// oid = new String(req.getParameter("oid").getBytes("ISO8859_1"),"utf-8");
			// gtime = new String(req.getParameter("gtime").getBytes("ISO8859_1"),"utf-8");
			// stime = new String(req.getParameter("stime").getBytes("ISO8859_1"),"utf-8");
			// wid = new String(req.getParameter("wid").getBytes("ISO8859_1"),"utf-8");
			// percount = Integer.valueOf(req.getParameter("percount"));
			// tcount = Integer.valueOf(req.getParameter("tcount"));
			// islean = Boolean.valueOf(req.getParameter("islean"));
			// perweight = Double.valueOf(req.getParameter("perweight"));
			// tformatweight = Double.valueOf(req.getParameter("tformatweight"));

			inporttime = req.getParameter("inporttime");
			ctime = req.getParameter("ctime");
			intime = req.getParameter("intime");
			pboxtime = req.getParameter("pboxtime");
			state = req.getParameter("state");
			simg = req.getParameter("simg");
			islean = Boolean.valueOf(req.getParameter("islean"));
			lkind = req.getParameter("lkind");
			tid = req.getParameter("tid");
			tkind = req.getParameter("tkind");
			oid = req.getParameter("oid");
			gtime = req.getParameter("gtime");
			stime = req.getParameter("stime");
			percount = Integer.valueOf(req.getParameter("percount"));
			perweight = Double.valueOf(req.getParameter("perweight"));
			tcount = Integer.valueOf(req.getParameter("tcount"));
			tformatweight = Double.valueOf(req.getParameter("tformatweight"));
			reporttime = req.getParameter("reporttime");
			classorderid = req.getParameter("classorderid");
			wid = req.getParameter("wid");

			sql = "insert into portinfo(bid,gid,inporttime,ctime,intime, pboxtime,"
					+ "state,simg,lkind,reporttime,classorderid,tid,tkind,oid,gtime,stime,"
					+ " percount,tcount,islean,perweight,tformatweight) " + "values(" + "'" + bid + "'," + "'" + gid
					+ "'," + "'" + inporttime + "'," + "'" + ctime + "'," + "'" + intime + "'," + "'" + pboxtime + "',"
					+ "'" + state + "'," + "'" + simg + "'," + "'" + lkind + "'," + "'" + reporttime + "'," + "'"
					+ classorderid + "'," + "'" + tid + "'," + "'" + tkind + "'," + "'" + oid + "'," + "'" + gtime
					+ "'," + "'" + stime + "'," + "'" + percount + "'," + "'" + tcount + "'," + "'" + islean + "',"
					+ "'" + perweight + "'," + "'" + tformatweight + "')";
			System.out.println(sql);
			dbTool.doDBUpdate(sql);
			sql = "insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime)values(" + "'" + wid + "',"
					+ "'null'," + "'" + bid + "'," + "'" + gid + "','港口货物操作','新增操作'," + "'"
					+ myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分") + "'" + ")";
			System.out.println(sql);

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;

		// 信息查询
		case 2:
			pid = Integer.valueOf(req.getParameter("pid"));
			sql = "select * from Portinfo where pid='" + pid + "'";
			list = dbTool.doDBQueryPortinfo(sql);
			nSize = list.size();
			if (nSize > 0) {
				JSONArray array = new JSONArray();
				for (Portinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("bid", bean.getBid());
						obj.put("gid", bean.getBid());
						obj.put("pid", bean.getPid());
						obj.put("inporttime", bean.getInporttime());
						obj.put("ctime", bean.getCtime());
						obj.put("intime", bean.getIntime());
						obj.put("pboxtime", bean.getPboxtime());
						obj.put("islean", bean.getIslean());
						obj.put("state", bean.getState());
						obj.put("simg", bean.getSimg());
						obj.put("lkind", bean.getLkind());
						obj.put("reporttime", bean.getReporttime());
						obj.put("classorderid", bean.getClassorderid());
						obj.put("tid", bean.getTid());
						obj.put("tkind", bean.getTkind());
						obj.put("oid", bean.getOid());
						obj.put("percount", bean.getPercount());
						obj.put("perweight", bean.getPerweight());
						obj.put("tformatweight", bean.getTformatweight());
						obj.put("tcount", bean.getTcount());
						obj.put("gtime", bean.getGtime());
						obj.put("stime", bean.getStime());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult = array.toString();
			}
			break;

		// 修改信息
		case 3:
			bid = new String(req.getParameter("bid").getBytes("ISO8859_1"), "utf-8");
			inporttime = new String(req.getParameter("inporttime").getBytes("ISO8859_1"), "utf-8");
			ctime = new String(req.getParameter("ctime").getBytes("ISO8859_1"), "utf-8");
			intime = new String(req.getParameter("intime").getBytes("ISO8859_1"), "utf-8");
			pboxtime = new String(req.getParameter("pboxtime").getBytes("ISO8859_1"), "utf-8");
			state = new String(req.getParameter("state").getBytes("ISO8859_1"), "utf-8");
			simg = new String(req.getParameter("simg").getBytes("ISO8859_1"), "utf-8");
			lkind = new String(req.getParameter("lkind").getBytes("ISO8859_1"), "utf-8");
			reporttime = new String(req.getParameter("reporttime").getBytes("ISO8859_1"), "utf-8");
			classorderid = new String(req.getParameter("classorderid").getBytes("ISO8859_1"), "utf-8");
			tid = new String(req.getParameter("tid").getBytes("ISO8859_1"), "utf-8");
			tkind = new String(req.getParameter("tkind").getBytes("ISO8859_1"), "utf-8");
			oid = new String(req.getParameter("oid").getBytes("ISO8859_1"), "utf-8");
			gtime = new String(req.getParameter("gtime").getBytes("ISO8859_1"), "utf-8");
			stime = new String(req.getParameter("stime").getBytes("ISO8859_1"), "utf-8");

			pid = Integer.valueOf(req.getParameter("pid"));
			percount = Integer.valueOf(req.getParameter("percount"));
			tcount = Integer.valueOf(req.getParameter("tcount"));

			islean = Boolean.valueOf(req.getParameter("islean"));
			perweight = Double.valueOf(req.getParameter("perweight"));
			tformatweight = Double.valueOf(req.getParameter("tformatweight"));

			sql = "update portinfo " + "set inporttime='" + inporttime + "'," + "ctime='" + ctime + "'," + "intime='"
					+ intime + "'," + "pboxtime='" + pboxtime + "'," + "state='" + state + "'," + "simg='" + simg + "',"
					+ "lkind='" + lkind + "'," + "reporttime='" + reporttime + "'," + "classorderid='" + classorderid
					+ "'," + "tid='" + tid + "'," + "tkind='" + tkind + "'," + "oid='" + oid + "'," + "gtime='" + gtime
					+ "'," + "stime='" + stime + "'," + "pid='" + pid + "'," + "percount='" + percount + "',"
					+ "tcount='" + tcount + "'," + "islean='" + islean + "'," + "perweight='" + perweight + "',"
					+ "tformatweight='" + tformatweight + "' "

					+ "where pid='" + pid + "'";

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;
		// 信息查询
		case 4:
			tmp = new String(req.getParameter("bid").getBytes("iso-8859-1"), "utf-8");
			if (tmp.indexOf("-") < 0) {
				bid = tmp;
				gid = "";
			} else {
				bid = tmp.substring(0, tmp.indexOf("-"));
				gid = tmp.substring(tmp.indexOf("-") + 1);
			}
			sql = "select * from Portinfo where bid='" + bid + "' and gid='" + gid + "' ";
			list = dbTool.doDBQueryPortinfo(sql);
			nSize = list.size();
			if (nSize > 0) {
				JSONArray array = new JSONArray();
				for (Portinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("bid", bean.getBid());
						obj.put("pid", bean.getPid());
						obj.put("gid", bean.getBid());
						obj.put("inporttime", bean.getInporttime());
						obj.put("ctime", bean.getCtime());
						obj.put("intime", bean.getIntime());
						obj.put("pboxtime", bean.getPboxtime());
						obj.put("islean", bean.getIslean());
						obj.put("state", bean.getState());
						obj.put("simg", bean.getSimg());
						obj.put("lkind", bean.getLkind());
						obj.put("reporttime", bean.getReporttime());
						obj.put("classorderid", bean.getClassorderid());
						obj.put("tid", bean.getTid());
						obj.put("tkind", bean.getTkind());
						obj.put("oid", bean.getOid());
						obj.put("percount", bean.getPercount());
						obj.put("perweight", bean.getPerweight());
						obj.put("tformatweight", bean.getTformatweight());
						obj.put("tcount", bean.getTcount());
						obj.put("gtime", bean.getGtime());
						obj.put("stime", bean.getStime());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult = array.toString();
			} else
				sResult = null;
			break;
		// 删除信息
		case 5:
			pid = Integer.valueOf(req.getParameter("pid"));

			sql = "delete from portinfo where pid='" + pid + "'";

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;
		case 6:
			bid = req.getParameter("bid");
			String str = "{\"barcode\": \"" + bid + "\"}";
			String json = bas.getSeaportGoods(str);
			break;
		default:
			break;

		}

		pWriter.print(sResult);
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
