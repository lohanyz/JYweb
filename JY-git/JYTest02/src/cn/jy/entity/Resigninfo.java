package cn.jy.entity;

public class Resigninfo {
	private int rid;
	private String bid;
	private String gid;
	private String state;
	private String simg;
	public Resigninfo(int rid, String bid,String gid, String state, String simg) {
		super();
		this.rid = rid;
		this.gid = gid;
		this.bid = bid;
		this.state = state;
		this.simg = simg;
	}
	public Resigninfo() {
	
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSimg() {
		return simg;
	}
	public void setSimg(String simg) {
		this.simg = simg;
	}

}
