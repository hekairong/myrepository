package com.jk.model.files;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="file")
public class File implements Serializable{

	private String fileid;
	
	private String filename;
	
	private String time;
	
	private String fileImg;
	
	private String mvid;
	
	private String size;
	
	private HashMap<String, Object>map;
	
	private LinkedHashMap<String, String>redisMap;
 

	public String getFileImg() {
		return fileImg;
	}

	public void setFileImg(String fileImg) {
		this.fileImg = fileImg;
	}

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

 

	public String getMvid() {
		return mvid;
	}

	public void setMvid(String mvid) {
		this.mvid = mvid;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public LinkedHashMap<String, String> getRedisMap() {
		return redisMap;
	}

	public void setRedisMap(LinkedHashMap<String, String> redisMap) {
		this.redisMap = redisMap;
	}
	
	
	
	
}
