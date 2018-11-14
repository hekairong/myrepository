/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:StuTree.java 
 * 包名:com.jk.model 
 * 创建日期:2018年10月31日下午4:01:46 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：StuTree    
 * 类描述：    
 * 创建人：杨同隆 565598097@qq.com    
 * 创建时间：2018年10月31日 下午4:01:46    
 * 修改人：杨同隆 565598097@qq.com  
 * 修改时间：2018年10月31日 下午4:01:46    
 * 修改备注：       
 * @version </pre>    
 */
public class StuTree implements Serializable{
         private String id;
         private String text;
         private String href;
         private String pid;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getHref() {
			return href;
		}
		public void setHref(String href) {
			this.href = href;
		}
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
         
         
         
}
