package cn.jy.entity;

public class Editinfo {
	private int eid;
	private String wid;
	private String wname;
	private String bid;
	private String gid;
	private String operkind;
	private String editkind;
	private String edittime;
	public Editinfo(int eid, String wid, String wname, String bid, String gid,
			String operkind, String editkind, String edittime) {
		super();
		this.eid = eid;
		this.wid = wid;
		this.wname = wname;
		this.bid = bid;
		this.gid = gid;
		this.operkind = operkind;
		this.editkind = editkind;
		this.edittime = edittime;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getOperkind() {
		return operkind;
	}

	public void setOperkind(String operkind) {
		this.operkind = operkind;
	}

	public String getEditkind() {
		return editkind;
	}

	public void setEditkind(String editkind) {
		this.editkind = editkind;
	}

	public String getEdittime() {
		return edittime;
	}

	public void setEdittime(String edittime) {
		this.edittime = edittime;
	}

	public Editinfo() {
		super();
	}
	
}
