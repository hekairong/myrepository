/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:TreeController.java 
 * 包名:com.jk.controller.tree 
 * 创建日期:2018年9月17日上午10:44:06 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.tree;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.domain.tree.Tree;
import com.jk.service.tree.TreeService;

/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：TreeController    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月17日 上午10:44:06    
 * 修改人：贺凯荣
 * 修改时间：2018年9月17日 上午10:44:06    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("tree")
public class TreeController {
	
	@Autowired
	private TreeService treeService;
	
	@RequestMapping("queryTreeList")
	@ResponseBody
	public List<Tree> queryTreeList(){
		List<Tree> list = treeService.queryTreeList();
		return list;
	}
	
}
