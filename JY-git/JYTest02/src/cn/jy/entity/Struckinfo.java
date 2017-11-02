package cn.jy.entity;

public class Struckinfo {
	private String sid;
	private String snote;
	private String tid;
	private String bid;
	public Struckinfo(String sid, String snote, String tid, String bid) {
		super();
		this.sid = sid;
		this.snote = snote;
		this.tid = tid;
		this.bid = bid;
	}
	public Struckinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSnote() {
		return snote;
	}
	public void setSnote(String snote) {
		this.snote = snote;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
}
