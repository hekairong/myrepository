/** 
 * <pre>项目名称:education-consumer 
 * 文件名称:ZwtController.java 
 * 包名:com.jk.controller 
 * 创建日期:2018年10月30日下午6:56:08 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.zwt.ZwtUser;
import com.jk.service.IeduService;

/** 
 * <pre>项目名称：education-consumer    
 * 类名称：ZwtController    
 * 类描述：    
 * 创建人：张文韬  
 * 创建时间：2018年10月30日 下午6:56:08    
 * 修改人：张文韬
 * 修改时间：2018年10月30日 下午6:56:08    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("zwt")
public class ZwtController {
	
	@Autowired IeduService ieduService;
	
	/**
	 * <pre>uploadMultipleFileHandler(文件上传)   
	 * 创建人：张文韬
	 * 创建时间：2018年11月2日 上午9:34:08    
	 * 修改人：张文韬
	 * 修改时间：2018年11月2日 上午9:34:08    
	 * 修改备注： 
	 * @param files
	 * @param request
	 * @return
	 * @throws IOException</pre>
	 */
/*	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public Object uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files,HttpServletRequest request) throws IOException {

		JSONObject json = new JSONObject();
		String info = "";
		
		Map<String ,String> map = new HashMap<String ,String>();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];

            if (!file.isEmpty()) {
                InputStream in = null;
                OutputStream out = null;

                try {
                	String oldFileName = file.getOriginalFilename();
//            		解决重名问题
            		long timeStr = System.currentTimeMillis();
//            		重命名文件名
            		String newFileName = timeStr+"_"+oldFileName;
                	String realPath = request.getSession().getServletContext().getRealPath("/"+newFileName);
            		File serverFile = new File(realPath);
                    in = file.getInputStream();
                    out = new FileOutputStream(serverFile);
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = in.read(b)) > 0) {
                        out.write(b, 0, len);
                    }
                    out.close();
                    in.close();
                    json.put("url",serverFile.toString());
                    map.put("url", newFileName);
                    info = serverFile.toString();

                } catch (Exception e) {
                    arr.add(i);
                } finally {
                    if (out != null) {
                        out.close();
                        out = null;
                    }

                    if (in != null) {
                        in.close();
                        in = null;
                    }
                }
            } else {
                arr.add(i);
            }


        }

        if(arr.size() > 0) {
        	json.put("info", "ERROR");
        	map.put("info","ERROR");

        } else {
        	json.put("info", "SUCCESS");
        	map.put("info","SUCCESS");

        }
        return map;
    }
	*/
	/**
	 * <pre>queryUserList(用户列表查询)   
	 * 创建人：张文韬
	 * 创建时间：2018年11月2日 上午9:34:50    
	 * 修改人：张文韬
	 * 修改时间：2018年11月2日 上午9:34:50    
	 * 修改备注： 
	 * @param user
	 * @param offset
	 * @param limit
	 * @return</pre>
	 */
	@RequestMapping("queryUserList")
	@ResponseBody
	public JSONObject queryUserList(ZwtUser user,Integer offset,Integer limit){
		JSONObject json = new JSONObject();
		json = ieduService.queryUserList(user,offset,limit);
		return json;
	}
	
	/**
	 * <pre>queryOneUser(根据id查询单个对象)   
	 * 创建人：张文韬
	 * 创建时间：2018年11月2日 上午9:35:14    
	 * 修改人：张文韬
	 * 修改时间：2018年11月2日 上午9:35:14    
	 * 修改备注： 
	 * @param user
	 * @param model
	 * @return</pre>
	 */
	@RequestMapping("queryOneUser")
	public String queryOneUser(ZwtUser user,Model model){
		ZwtUser users = ieduService.queryOneUser(user);
		model.addAttribute("users", users);
		return "zwt/editUser";
	}
	
	/**
	 * <pre>updateUser(修改User对象)   
	 * 创建人：张文韬
	 * 创建时间：2018年11月2日 上午9:35:38    
	 * 修改人：张文韬
	 * 修改时间：2018年11月2日 上午9:35:38    
	 * 修改备注： 
	 * @param user
	 * @return</pre>
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public String updateUser(ZwtUser user){
		ieduService.updateUser(user);
		return "1";
	}
	
	/**
	 * <pre>deleteUser(删除User对象)   
	 * 创建人：张文韬
	 * 创建时间：2018年11月2日 上午9:36:10    
	 * 修改人：张文韬
	 * 修改时间：2018年11月2日 上午9:36:10    
	 * 修改备注： 
	 * @param user
	 * @return</pre>
	 */
	@RequestMapping("deleteUser")
	@ResponseBody
	public String deleteUser(ZwtUser user){
		ieduService.deleteUser(user);
		return "1";
	}

}
