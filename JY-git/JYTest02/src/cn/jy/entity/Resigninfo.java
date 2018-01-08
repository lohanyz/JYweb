package cn.jy.entity;

public class Resigninfo {
	private int _id;
	private String barcode;
	private String receiptdate;
	private String cargostatussign;
	private String img;
	private String busiinvcode;
	private String wid;
	public Resigninfo(int _id, String barcode,String receiptdate, String cargostatussign, String img, String busiinvcode, String wid) {
		super();
		this._id = _id;
		this.barcode = barcode;
		this.receiptdate = receiptdate;
		this.cargostatussign = cargostatussign;
		this.img = img;
		this.busiinvcode = busiinvcode;
		this.wid = wid;
	}
	public Resigninfo() {
	
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getReceiptdate() {
		return receiptdate;
	}
	public void setReceiptdate(String receiptdate) {
		this.receiptdate = receiptdate;
	}
	public String getCargostatussign() {
		return cargostatussign;
	}
	public void setCargostatussign(String cargostatussign) {
		this.cargostatussign = cargostatussign;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBusiinvcode() {
		return busiinvcode;
	}
	public void setBusiinvcode(String busiinvcode) {
		this.busiinvcode = busiinvcode;
	}
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	
}
