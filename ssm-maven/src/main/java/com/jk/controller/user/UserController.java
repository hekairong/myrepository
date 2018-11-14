/** 
 * <pre>项目名称:ssm-maven-hkr 
 * 文件名称:UserController.java 
 * 包名:com.jk.controller.user 
 * 创建日期:2018年9月12日上午11:26:03 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.domain.user.User;

/** 
 * <pre>项目名称：ssm-maven-hkr    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：贺凯荣  
 * 创建时间：2018年9月12日 上午11:26:03    
 * 修改人：贺凯荣
 * 修改时间：2018年9月12日 上午11:26:03    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("user")
public class UserController {
    //使用httpclient调用查询的方法
	@RequestMapping("finduser")
	@ResponseBody
	public String queryUserlist(Integer page,Integer rows){
        CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> params =new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("page", ""+page));
		params.add(new BasicNameValuePair("rows", ""+rows));
		String paramsStr = "";
		String userJson= "";
		CloseableHttpResponse response =null;
		try {
			  paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			  HttpGet  httpGet = new  HttpGet("http://localhost:8080/User/queryUserList.do?"+paramsStr);
			  response= httpclient.execute(httpGet);
			  HttpEntity entity = response.getEntity();
			  userJson=  EntityUtils.toString(entity, "UTF-8");
		 } catch (org.apache.http.ParseException | IOException e) {
			 e.printStackTrace();
		}finally{
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return userJson;
	}
	
	//使用httpclient调用新增的方法
	@RequestMapping("adduser")
	@ResponseBody
	public  String   adduser(User user){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		List<NameValuePair> params =new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("name", ""+user.getName()));
		params.add(new BasicNameValuePair("age", ""+user.getAge()));
		params.add(new BasicNameValuePair("phone", ""+user.getPhone()));
		params.add(new BasicNameValuePair("sex", ""+user.getSex()));
		params.add(new BasicNameValuePair("birthday", ""+user.getBirthday()));
		params.add(new BasicNameValuePair("userstatus", ""+user.getUserstatus()));
		params.add(new BasicNameValuePair("email", ""+user.getEmail()));
		params.add(new BasicNameValuePair("userinfo", ""+user.getUserinfo()));
		String paramsStr = "";
		String userJson= "";
		CloseableHttpResponse response =null;
		try {
			 paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			 HttpPost  httpGet = new  HttpPost("http://localhost:8080/User/addUserList.do?"+paramsStr);
			  httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1;"
						+ " Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
			  httpGet.setHeader("Accept", "application/json");
			  
			  httpGet.setHeader("Accept-Encoding", "gzip, deflate");
			  httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			  RequestConfig config = RequestConfig.custom()
						.setConnectTimeout(10000)  		//设置链接超时的时间1秒钟
						.setSocketTimeout(10000) 		//设置读取超时1秒钟
						.build(); 						//RequestConfig静态方法  setProxy  设置代理
				httpGet.setConfig(config);
			 response= httpclient.execute(httpGet);
			  HttpEntity entity = response.getEntity();
			  userJson=  EntityUtils.toString(entity, "UTF-8");
		
		 } catch (org.apache.http.ParseException | IOException e) {
			 e.printStackTrace();
		}finally{
			try {
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return userJson;
	
	}

}
