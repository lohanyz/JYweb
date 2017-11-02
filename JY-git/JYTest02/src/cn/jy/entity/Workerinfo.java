package cn.jy.entity;

public class Workerinfo {
	private String wid;
	private String wname;
	private String wcall;
	private String wpwd;
	private String wtype;
	private String wnote;
	private String wpermission;
	 
	public Workerinfo(String wid, String wname, String wcall, String wpwd,
			String wtype,String wpermission, String wnote) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.wcall = wcall;
		this.wpwd = wpwd;
		this.wtype = wtype;
		this.wnote = wnote;
		this.wpermission=wpermission;
	}
	
	public String getWpermission() {
		return wpermission;
	}
	public void setWpermission(String wpermission) {
		this.wpermission = wpermission;
	}
	public String getWtype() {
		return wtype;
	}
	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWcall() {
		return wcall;
	}
	public void setWcall(String wcall) {
		this.wcall = wcall;
	}
	public String getWpwd() {
		return wpwd;
	}
	public void setWpwd(String wpwd) {
		this.wpwd = wpwd;
	}
	public String getWnote() {
		return wnote;
	}
	public void setWnote(String wnote) {
		this.wnote = wnote;
	}
	
}
