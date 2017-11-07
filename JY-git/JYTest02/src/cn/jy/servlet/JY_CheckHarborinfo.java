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
import cn.jy.entity.Harborinfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_CheckHarborinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String bid, gid, state, simg, ftochnharbortime, pboxtime, senttime, transtime, transtid, stime, wid;
	private int hid, transtcount, percount;
	private double perweight;

	private int nOperType, nSize;
	private String sql, tmp, sOperType, sResult = "fail";
	ArrayList<Harborinfo> list;
	private FtcCenterWebServiceBas bas;
	private FtcCenterWebServiceBasService basService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pWriter = resp.getWriter();

		DBTool dbTool = new DBTool();
		MyConfig myConfig = new MyConfig();
		basService = new FtcCenterWebServiceBasService();
		bas = basService.getFtcCenterWebServiceBasPort();
		sOperType = req.getParameter("operType");
		nOperType = Integer.parseInt(sOperType);
		switch (nOperType) {
		// 信息新增
		case 1:
			bid = new String(req.getParameter("bid").getBytes("ISO8859_1"), "utf-8");
			gid = new String(req.getParameter("gid").getBytes("ISO8859_1"), "utf-8");
			state = req.getParameter("state");
			simg = req.getParameter("simg");
			ftochnharbortime = req.getParameter("ftochnharbortime");
			pboxtime = req.getParameter("pboxtime");
			senttime = req.getParameter("senttime");
			transtime = req.getParameter("transtime");
			transtid = req.getParameter("transtid");
			transtcount = Integer.valueOf(req.getParameter("transtcount"));
			percount = Integer.valueOf(req.getParameter("percount"));
			perweight = Double.valueOf(req.getParameter("perweight"));
			stime = req.getParameter("stime");
			JSONObject obja = new JSONObject();
			JSONObject objb = new JSONObject();
			obja.put("pfactchportdate", ftochnharbortime);
			obja.put("mpackingdate", pboxtime);
			obja.put("ppassdate", senttime);
			obja.put("preloadcarno", transtid);
			obja.put("preloaddate", transtime);
			obja.put("msinglecarnum", percount);
			obja.put("msinglecarton", perweight);
			obja.put("pstartdate", stime);
			obja.put("cargostatusseaport", state);
			objb.put("barcode", bid);
			objb.put("body", obja);
			System.out.println(objb.toString());
			obja = JSONObject.fromObject(bas.saveSeaportGoods(objb.toString()));
			if (obja.get("Head").equals("0000")) {
				wid = new String(req.getParameter("wid").getBytes("ISO8859_1"), "utf-8");
				sql = "insert into Harborinfo(bid ,gid,state,simg,ftochnharbortime,pboxtime,senttime,transtime,transtid,transtcount,percount,perweight,stime) "
						+ "values(" + "'" + bid + "'," + "'" + gid + "'," + "'" + state + "'," + "'" + simg + "'," + "'"
						+ ftochnharbortime + "'," + "'" + pboxtime + "'," + "'" + senttime + "'," + "'" + transtime
						+ "'," + "'" + transtid + "'," + "'" + transtcount + "'," + "'" + percount + "'," + "'"
						+ perweight + "'," + "'" + stime + "')";
				System.out.println(sql);
				dbTool.doDBUpdate(sql);
				sql = "insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime)values(" + "'" + wid + "',"
						+ "'null'," + "'" + bid + "'," + "'" + gid + "','口岸货物操作','新增操作'," + "'"
						+ myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分") + "'" + ")";
				System.out.println(sql);

				dbTool.doDBUpdate(sql);
				sResult = "success";
			} else {
				sResult = "fail";
			}
			break;
		// 信息查询
		case 2:
			hid = Integer.valueOf(req.getParameter("hid"));
			sql = "select * from Harborinfo where hid='" + hid + "'";
			list = dbTool.doDBQueryHarborinfo(sql);
			nSize = list.size();
			if (nSize > 0) {
				JSONArray array = new JSONArray();
				for (Harborinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("bid", bean.getBid());
						obj.put("gid", bean.getBid());
						obj.put("hid", bean.getHid());
						obj.put("state", bean.getState());
						obj.put("simg", bean.getSimg());
						obj.put("ftochnharbortime", bean.getFtochnharbortime());
						obj.put("pboxtime", bean.getPboxtime());
						obj.put("senttime", bean.getSenttime());
						obj.put("transtime", bean.getTranstime());
						obj.put("transtid", bean.getTranstid());
						obj.put("transtcount", bean.getTranstcount());
						obj.put("percount", bean.getPercount());
						obj.put("perweight", bean.getPerweight());
						obj.put("stime", bean.getStime());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult = array.toString();
			}
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
			sql = "select * from Harborinfo where bid='" + bid + "' and gid='" + gid + "' ";
			list = dbTool.doDBQueryHarborinfo(sql);
			nSize = list.size();
			if (nSize > 0) {
				JSONArray array = new JSONArray();
				for (Harborinfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("bid", bean.getBid());
						obj.put("gid", bean.getBid());
						obj.put("hid", bean.getHid());
						obj.put("state", bean.getState());
						obj.put("simg", bean.getSimg());
						obj.put("ftochnharbortime", bean.getFtochnharbortime());
						obj.put("pboxtime", bean.getPboxtime());
						obj.put("senttime", bean.getSenttime());
						obj.put("transtime", bean.getTranstime());
						obj.put("transtid", bean.getTranstid());
						obj.put("transtcount", bean.getTranstcount());
						obj.put("percount", bean.getPercount());
						obj.put("perweight", bean.getPerweight());
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

		// 修改信息
		case 3:
			bid = new String(req.getParameter("bid").getBytes("ISO8859_1"), "utf-8");
			hid = Integer.valueOf(req.getParameter("hid"));
			state = new String(req.getParameter("state").getBytes("ISO8859_1"), "utf-8");
			simg = new String(req.getParameter("simg").getBytes("ISO8859_1"), "utf-8");
			ftochnharbortime = new String(req.getParameter("ftochnharbortime").getBytes("ISO8859_1"), "utf-8");
			pboxtime = new String(req.getParameter("pboxtime").getBytes("ISO8859_1"), "utf-8");
			senttime = new String(req.getParameter("senttime").getBytes("ISO8859_1"), "utf-8");
			transtime = new String(req.getParameter("transtime").getBytes("ISO8859_1"), "utf-8");
			transtid = new String(req.getParameter("transtid").getBytes("ISO8859_1"), "utf-8");
			transtcount = Integer.valueOf(req.getParameter("transtcount"));
			percount = Integer.valueOf(req.getParameter("percount"));
			perweight = Double.valueOf(req.getParameter("perweight"));
			stime = new String(req.getParameter("stime").getBytes("ISO8859_1"), "utf-8");

			sql = "update Harborinfo " + "set state='" + state + "'," + "simg='" + simg + "'," + "ftochnharbortime='"
					+ ftochnharbortime + "'," + "pboxtime='" + pboxtime + "'," + "senttime='" + senttime + "',"
					+ "transtime='" + transtime + "'," + "transtid='" + transtid + "'," + "transtcount='" + transtcount
					+ "'," + "percount='" + percount + "'," + "perweight='" + perweight + "'," + "stime=" + stime + " "
					+ "where hid='" + hid + "'";

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;
		// 删除信息
		case 5:
			hid = Integer.valueOf(req.getParameter("hid"));

			sql = "delete from harborinfo where hid='" + hid + "'";

			dbTool.doDBUpdate(sql);
			sResult = "success";
			break;
		case 6:
			bid = req.getParameter("bid");
			String str = "{\"barcode\": \"" + bid + "\"}";
			sResult = bas.getSeaportGoods(str);
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
