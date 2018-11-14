/** 
 * <pre>项目名称:ssm-bootstrap 
 * 文件名称:LogServiceImpl.java 
 * 包名:com.jk.service.log 
 * 创建日期:2018年9月17日下午8:39:08 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.jk.aop.LogInfo;

/** 
 * <pre>项目名称：ssm-bootstrap    
 * 类名称：LogServiceImpl    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月17日 下午8:39:08    
 * 修改人：贺凯荣
 * 修改时间：2018年9月17日 下午8:39:08    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class LogServiceImpl implements LogService{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/* (non-Javadoc)    
	 * @see com.jk.service.tree.TreeService#findLog(java.lang.Integer, java.lang.Integer, com.jk.aop.LogInfo)    
	 */
	@Override
	public Map<String, Object> findLog(Integer pageSize, Integer start, LogInfo loginfo) throws ParseException {
		//  条件查询对象
		Criteria criteriax=new Criteria();
		
		if(loginfo!=null){
			
			if (StringUtils.isNotEmpty(loginfo.getImplUrl())) {
				//  返回  java 正则      ‘^. $’
				Pattern xx = Pattern.compile("^.*"+loginfo.getImplUrl()+".*$", Pattern.CASE_INSENSITIVE);
				criteriax.and("implUrl").regex(xx);
			}
			
			if(loginfo.getMinDate()!=null||loginfo.getMaxDate()!=null){
				criteriax.and("methDate")
				.lte( loginfo.getMaxDate()!=null?formateDate(loginfo.getMaxDate()):null)
				.gte(loginfo.getMinDate()!=null?formateDate(loginfo.getMinDate()):null);
				}
			
		}			
	
	
	Query query = new Query();
	
	long count = mongoTemplate.count(query, LogInfo.class);
	query.addCriteria(criteriax);
	
	
	
	List<LogInfo> find = mongoTemplate.find(query.with(new Sort(Direction.DESC,"methDate")).skip(start).limit(pageSize),LogInfo.class);
	
	for (int i = 0; i < find.size(); i++) {
		LogInfo logInfo2 = find.get(i);
		//解决时间
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sim.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
		System.out.println(sim.format(logInfo2.getMethDate()));
		logInfo2.setMethDate(sim.parse(sim.format(logInfo2.getMethDate())));
		find.remove(i);
		find.add(i, logInfo2);
	}
	
	
	HashMap<String, Object> map=new HashMap<>();
	
	map.put("total", count);
	
	map.put("rows",find);
	
	return map;
}
 
	public  Date  formateDate(Date date) throws ParseException{
		//解决时间
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      String format = sim.format(date);
	      sim.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
		return sim.parse(format);
	}


}
