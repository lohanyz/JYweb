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
import cn.jy.entity.Resigninfo;
import cn.jy.tool.DBTool;
import cn.jy.tool.MyConfig;

public class JY_CheckResigninfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int nOperType, nSize;

	private String sOperType, rid, bid, gid, state, simg, sql, tmp, sResult = "fail";

	private ArrayList<Resigninfo> list;
	private FtcCenterWebServiceBas bas;
	private FtcCenterWebServiceBasService basService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pWriter = resp.getWriter();
		DBTool dbTool = new DBTool();
		MyConfig myConfig = new MyConfig();
		req.getRequestURL();
		sOperType = req.getParameter("operType");
		nOperType = Integer.parseInt(sOperType);
		basService = new FtcCenterWebServiceBasService();
		bas = basService.getFtcCenterWebServiceBasPort();
		switch (nOperType) {
		case 1:
			bid = new String(req.getParameter("bid").getBytes("ISO8859_1"), "utf-8");
			gid = new String(req.getParameter("gid").getBytes("ISO8859_1"), "utf-8");
			state = req.getParameter("state");
			simg = req.getParameter("simg");
			String wid = new String(req.getParameter("wid").getBytes("iso-8859-1"), "utf-8");
			JSONObject obja = new JSONObject();
			JSONObject objb = new JSONObject();
			// obja.put("receiptdate", );签收时间
			obja.put("cargostatussign", state);
			objb.put("barcode", bid);
			objb.put("body", obja);
			System.out.println(objb.toString());
			obja = JSONObject.fromObject(bas.saveSignGoods(objb.toString()));
			if (obja.get("Head").equals("0000")) {
				String sql = "insert into resigninfo (" + "bid,gid,state,simg) values (" + "'" + bid + "'," + "'" + gid
						+ "'," + "'" + state + "'," + "'" + simg + "'" + ")";
				System.out.println("sql=" + sql);
				dbTool.doDBUpdate(sql);
				sql = "insert into editinfo(wid,wname,bid,gid,operkind,editkind,edittime)values(" + "'" + wid + "',"
						+ "'null'," + "'" + bid + "'," + "'" + gid + "','签收操作','新增操作'," + "'"
						+ myConfig.getCurrentTime("yyyy年MM月dd日HH时mm分") + "'" + ")";
				dbTool.doDBUpdate(sql);
				sResult = "success";
			} else {
				sResult = "fail";
			}
			break;

		// 信息查询
		case 2:
			rid = req.getParameter("rid");
			sql = "select * from signinfo where barcode=" + rid;
			list = dbTool.doDBQueryResigninfo(sql);
			nSize = list.size();
			if (nSize > 0) {
				JSONArray array = new JSONArray();
				for (Resigninfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("_id", bean.get_id());
						obj.put("busiinvcode", bean.getBusiinvcode());
						obj.put("barcode", bean.getBarcode());
						obj.put("cargostatussign", bean.getCargostatussign());
						obj.put("receiptdate", bean.getReceiptdate());
						obj.put("simg", bean.getImg());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult = array.toString();
			}
			break;
		// 信息查询 按bid和gid
		case 4:
			tmp = new String(req.getParameter("bid").getBytes("iso-8859-1"), "utf-8");
			if (tmp.indexOf("-") < 0) {
				bid = tmp;
				gid = "";
			} else {
				bid = tmp.substring(0, tmp.indexOf("-"));
				gid = tmp.substring(tmp.indexOf("-") + 1);
			}
			sql = "select * from Resigninfo where bid='" + bid + "' and gid='" + gid + "' ";
			System.out.println(sql);
			list = dbTool.doDBQueryResigninfo(sql);
			nSize = list.size();
			if (nSize > 0) {
				JSONArray array = new JSONArray();
				for (Resigninfo bean : list) {
					JSONObject obj = new JSONObject();
					try {
						obj.put("_id", bean.get_id());
						obj.put("busiinvcode", bean.getBusiinvcode());
						obj.put("barcode", bean.getBarcode());
						obj.put("cargostatussign", bean.getCargostatussign());
						obj.put("receiptdate", bean.getReceiptdate());
						obj.put("simg", bean.getImg());
					} catch (Exception e) {
						e.printStackTrace();
					}
					array.add(obj);
				}
				sResult = array.toString();
			} else
				sResult = null;
			break;
		// 网络更新;

		// 信息修改
		case 3:

			bid = new String(req.getParameter("bid").getBytes("iso-8859-1"), "utf-8");
			gid = new String(req.getParameter("gid").getBytes("iso-8859-1"), "utf-8");
			state = new String(req.getParameter("state").getBytes("iso-8859-1"), "utf-8");
			simg = new String(req.getParameter("simg").getBytes("iso-8859-1"), "utf-8");

			sql = "update resigninfo " + "set state='" + state + "'," + "simg='" + simg + "'," + "gid='" + gid + "',"
					+ "bid='" + bid + "' " + "where rid='" + rid + "'";

			dbTool.doDBUpdate(sql);
			sResult = "success";

			break;
		case 6:
			bid = req.getParameter("bid");
			String str = "{\"barcode\": \"" + bid + "\"}";
			String sResult = bas.getSignGoods(str);
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
