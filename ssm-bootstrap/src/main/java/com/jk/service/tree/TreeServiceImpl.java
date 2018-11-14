/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:TreeServiceImpl.java 
 * 包名:com.jk.service 
 * 创建日期:2018年9月17日上午10:45:01 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.tree;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.jk.domain.tree.Tree;
import com.jk.mapper.tree.TreeMapper;

/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：TreeServiceImpl    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月17日 上午10:45:01    
 * 修改人：贺凯荣
 * 修改时间：2018年9月17日 上午10:45:01    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class TreeServiceImpl implements TreeService{
	
	@Autowired
	private TreeMapper treeMapper;
	
	@Autowired
	private	MongoTemplate mongoTemplate;
	

	/* (non-Javadoc)    
	 * @see com.jk.service.tree.TreeService#queryTreeList()    
	 */
	@Override
	public List<Tree> queryTreeList() {
		List<Tree> treeAll =recursionTreed("0");
		System.out.println(treeAll);
		return treeAll;
	}

	/** <pre>recursionTreed(这里用一句话描述这个方法的作用)   
	 * 创建人：贺凯荣
	 * 创建时间：2018年9月17日 上午11:51:12    
	 * 修改人：贺凯荣
	 * 修改时间：2018年9月17日 上午11:51:12    
	 * 修改备注： 
	 * @param string
	 * @return</pre>    
	 */
	private List<Tree> recursionTreed(String pid) {
		//根据id查询子节点列表
        List<Tree> trees = treeMapper.recursionTree(pid);
        //判断查询到数据，则循环操作
        if(trees != null && trees.size()>0){
            for (int i = 0; i < trees.size(); i++) {
                //根据当前节点id查询新的子集列表，
                List<Tree> trees2 = recursionTreed(trees.get(i).getId().toString());
//              将列表set到当前树节点对象中
                trees.get(i).setNodes(trees2);
            }
        }
        return trees;
	}

}
