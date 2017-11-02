package cn.jy.entity;

public class Portinfo {
	private String bid;
	private String gid;
	private int pid;
	private String inporttime;
	private String ctime;
	private String intime;
	private String pboxtime;
	private boolean islean;
	private String state;
	private String simg;
	private String lkind;
	private String reporttime;
	private String classorderid;
	private String tid;
	private String tkind;
	private String oid;
	private int percount;
	private double perweight;
	private double tformatweight;
	private int tcount;
	private String gtime;
	private String stime;
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getInporttime() {
		return inporttime;
	}
	public void setInporttime(String inporttime) {
		this.inporttime = inporttime;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getPboxtime() {
		return pboxtime;
	}
	public void setPboxtime(String pboxtime) {
		this.pboxtime = pboxtime;
	}
	public boolean getIslean() {
		return islean;
	}
	public void setIslean(boolean islean) {
		this.islean = islean;
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
	public String getLkind() {
		return lkind;
	}
	public void setLkind(String lkind) {
		this.lkind = lkind;
	}
	public String getReporttime() {
		return reporttime;
	}
	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}
	public String getClassorderid() {
		return classorderid;
	}
	public void setClassorderid(String classorderid) {
		this.classorderid = classorderid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTkind() {
		return tkind;
	}
	public void setTkind(String tkind) {
		this.tkind = tkind;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	 public int getPercount() {
		return percount;
	}
	 public double getPerweight() {
		return perweight;
	}
	 public void setPerweight(double perweight) {
		this.perweight = perweight;
	}
	public void setPercount(int percount) {
		this.percount = percount;
	}
	public double getTformatweight() {
		return tformatweight;
	}
	public void setTformatweight(double tformatweight) {
		this.tformatweight = tformatweight;
	}
	public int getTcount() {
		return tcount;
	}
	public void setTcount(int tcount) {
		this.tcount = tcount;
	}
	public String getGtime() {
		return gtime;
	}
	public void setGtime(String gtime) {
		this.gtime = gtime;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public Portinfo(int pid, String bid,String gid, String inporttime, String ctime,
			String intime, String pboxtime, boolean islean, String state,
			String simg, String lkind, String reporttime, String classorderid,
			String tid, String tkind, String oid, int percount,
			double perweight, double tformatweight, int tcount, String gtime,
			String stime) {
		super();
		this.bid = bid;
		this.gid = gid;
		this.pid = pid;
		this.inporttime = inporttime;
		this.ctime = ctime;
		this.intime = intime;
		this.pboxtime = pboxtime;
		this.islean = islean;
		this.state = state;
		this.simg = simg;
		this.lkind = lkind;
		this.reporttime = reporttime;
		this.classorderid = classorderid;
		this.tid = tid;
		this.tkind = tkind;
		this.oid = oid;
		this.percount = percount;
		this.perweight = perweight;
		this.tformatweight = tformatweight;
		this.tcount = tcount;
		this.gtime = gtime;
		this.stime = stime;
	}
	public Portinfo() {
		super();
	}
	
	
}
