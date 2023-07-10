package com.book.bookPojo;

    
public class bookInfo {
	private int bid;
	private String bname;

    
	private String btype;
	private int bprice;
	public bookInfo(String bname, String btype, int bprice) {
		super();
		this.bname = bname;
		this.btype = btype;
		this.bprice = bprice;
	}
	public bookInfo(int bid, String bname, String btype, int bprice) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btype = btype;
		this.bprice = bprice;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	

}


    

