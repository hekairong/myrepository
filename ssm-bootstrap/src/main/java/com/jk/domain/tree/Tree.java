/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:Tree.java 
 * 包名:com.jk.domain.tree 
 * 创建日期:2018年9月17日上午10:44:22 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.domain.tree;

import java.util.List;

/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：Tree    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月17日 上午10:44:22    
 * 修改人：贺凯荣
 * 修改时间：2018年9月17日 上午10:44:22    
 * 修改备注：       
 * @version </pre>    
 */
public class Tree {
	
	private Integer id;
	
	private String text;
	
	private String url;
	
	private String pid;
	
	private String state;
	    
	private Boolean checked=false;
	
	private List<Tree> nodes;
    
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public List<Tree> getNodes() {
		return nodes;
	}

	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Tree [id=" + id + ", text=" + text + ", url=" + url + ", pid=" + pid + ", nodes=" + nodes + "]";
	}
}
