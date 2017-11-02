package cn.jy.entity;

public class Businessinfo {
	private String bid;
	private String bname;
	private String bkind;
	private String bcoman;
	private String bgaddress;
	private String bgoid;
	private String bshipcom;
	private String bpretoportday;
	private String boxid;
	private String boxsize;
	private String boxkind;
	private String boxbelong;
	private String retransway;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBkind() {
		return bkind;
	}
	public void setBkind(String bkind) {
		this.bkind = bkind;
	}
	public String getBcoman() {
		return bcoman;
	}
	public void setBcoman(String bcoman) {
		this.bcoman = bcoman;
	}
	public String getBgaddress() {
		return bgaddress;
	}
	public void setBgaddress(String bgaddress) {
		this.bgaddress = bgaddress;
	}
	public String getBgoid() {
		return bgoid;
	}
	public void setBgoid(String bgoid) {
		this.bgoid = bgoid;
	}
	public String getBshipcom() {
		return bshipcom;
	}
	public void setBshipcom(String bshipcom) {
		this.bshipcom = bshipcom;
	}
	public String getBpretoportday() {
		return bpretoportday;
	}
	public void setBpretoportday(String bpretoportday) {
		this.bpretoportday = bpretoportday;
	}
	public String getBoxid() {
		return boxid;
	}
	public void setBoxid(String boxid) {
		this.boxid = boxid;
	}
	public String getBoxsize() {
		return boxsize;
	}
	public void setBoxsize(String boxsize) {
		this.boxsize = boxsize;
	}
	public String getBoxkind() {
		return boxkind;
	}
	public void setBoxkind(String boxkind) {
		this.boxkind = boxkind;
	}
	public String getBoxbelong() {
		return boxbelong;
	}
	public void setBoxbelong(String boxbelong) {
		this.boxbelong = boxbelong;
	}
	public String getRetransway() {
		return retransway;
	}
	public void setRetransway(String retransway) {
		this.retransway = retransway;
	}
	public Businessinfo(String bid, String bname, String bkind, String bcoman,
			String bgaddress, String bgoid, String bshipcom,
			String bpretoportday, String boxid, String boxsize, String boxkind,
			String boxbelong, String retransway) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bkind = bkind;
		this.bcoman = bcoman;
		this.bgaddress = bgaddress;
		this.bgoid = bgoid;
		this.bshipcom = bshipcom;
		this.bpretoportday = bpretoportday;
		this.boxid = boxid;
		this.boxsize = boxsize;
		this.boxkind = boxkind;
		this.boxbelong = boxbelong;
		this.retransway = retransway;
	}
	
}
