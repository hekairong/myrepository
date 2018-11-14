package com.jk.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="book")
public class BookBean {
	
	private String bookid;
	
	private String bookname;
	
	private String time;
	
	private String price;
	
	private  List<BookBean> busList;
	
	private String maxtime;
	
	private String mintime;
	
	private HashMap<String, Object> map;
	
	public List<BookBean> getBusList() {
		return busList;
	}

	public void setBusList(List<BookBean> busList) {
		this.busList = busList;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMaxtime() {
		return maxtime;
	}

	public void setMaxtime(String maxtime) {
		this.maxtime = maxtime;
	}

	public String getMintime() {
		return mintime;
	}

	public void setMintime(String mintime) {
		this.mintime = mintime;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "BookBean [bookid=" + bookid + ", bookname=" + bookname + ", time=" + time + ", price=" + price
				+ ", busList=" + busList + ", maxtime=" + maxtime + ", mintime=" + mintime + ", map="
				+ map + "]";
	}
}
