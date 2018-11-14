package com.jk.controller.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.files.File;
import com.jk.model.yunschool.SonYunSchool;
import com.jk.model.yunschool.YunSchool;
import com.jk.service.IeduService;
import com.jk.util.OSSClientUtil;
import com.mongodb.gridfs.GridFSDBFile;
@Controller
@RequestMapping("controlleer")
public class FilesController {

    @Autowired IeduService ieduService;
 
    //进入全部课程页面
	@RequestMapping("toKeCheng")
	public String toWenjian() {
		return "WEB-INF/qbkc/kecheng";
	}
	//查询全部课程
	@RequestMapping("queryKeCheng")
	@ResponseBody
	public List<YunSchool> queryKeCheng(YunSchool subject){
		List<YunSchool> list=ieduService.queryKeCheng(subject);
		return list;
	}

    //进入文件页面
	@RequestMapping("toFile")
	public String toFile() {
		return "WEB-INF/file/fileinput";
	}	
    //调转新增页面
	@RequestMapping("tofilemogo")
	public String tofilemogo() {
		return "WEB-INF/file/addfile";
	}
	
	//查询
	@RequestMapping("findMongo")
	@ResponseBody
	public  HashMap<String, Object> findMongo(Integer pageSize,Integer start,File file){
		return	ieduService.findMongo( pageSize,start,file);
	}
	
	//新增
	@RequestMapping("addmongo")
	@ResponseBody
	public  void addmongo(File file){
		ieduService.addmongo(file);
	}
	
	//删除
	@RequestMapping("deleFile")
	@ResponseBody
	public void deleFile(String did){
		ieduService.deleFile(did);
	}
	
	//上传
	@RequestMapping("headImgUpload")
	@ResponseBody
	public HashMap<String, Object> headImgUpload(@RequestParam(value = "file", required = false)
	MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws IOException{
		if (file == null || file.getSize() <= 0) {
			throw new IOException("file 不能为空");
			}
		    String name2 = file.getOriginalFilename();
			//(实例化下配置文件)
			OSSClientUtil ossClient=new OSSClientUtil();
			//(调用配置文件的上传方法)
			String name = ossClient.uploadImg2Oss(file);
			//(生成的文件名可以展示到前台做回显)
			String imgUrl = ossClient.getImgUrl(name);
			HashMap<String, Object> map=new HashMap<>();
			//(文件存储的路径)
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			map.put("fileid", UUID.randomUUID().toString());
			map.put("filename", name2);
			map.put("time",time);
			map.put("fileImg", imgUrl);
			map.put("size", (file.getSize()/1024)+"kb");
			map.put("ossName", name);
			ieduService.Upload(map);
		return map ; 
	}
	
	//下载
	@RequestMapping("DownLoadLink")
	public void DownLoadLink(HttpServletResponse response, String  ossName) throws IOException{
		OSSClientUtil ossClient=new OSSClientUtil();
		//(调用配置文件的上传方法)
		String imgUrl = ossClient.getImgUrl(ossName);
	    if(StringUtils.isNotBlank(imgUrl)) {

	        URL url = new URL(imgUrl);
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        //设置超时间为3秒
	        conn.setConnectTimeout(3*1000);
	        //防止屏蔽程序抓取而返回403错误
	        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

	        //得到输入流
	        InputStream inputStream;
	        inputStream = conn.getInputStream();
	       // InputStream ins = new FileInputStream(Path);
	        BufferedInputStream bins = new BufferedInputStream(inputStream);// 放到缓冲流里面    
	        OutputStream outs = response.getOutputStream();// 获取文件输出IO流    
	        BufferedOutputStream bouts = new BufferedOutputStream(outs);    
	        response.setContentType("application/x-download");// 设置response内容的类型    
	        response.setHeader(    
	                "Content-disposition",    
	                "attachment;filename="    
	                        + URLEncoder.encode(imgUrl, "UTF-8"));// 设置头部信息
	        int bytesRead = 0;    

	        byte[] buffer = new byte[8192];    
	        // 开始向网络传输文件流    
	        while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {    
	            bouts.write(buffer, 0, bytesRead);    
	        }    
	        bouts.flush();// 这里一定要调用flush()方法    
	        inputStream.close();    
	        bins.close();    
	        outs.close();    
	        bouts.close();    
	    } else {    
	        response.sendRedirect("../error.jsp");    
	    }   

	}
	
	//根据ID查询图片
	@RequestMapping("queryImg")
	public void queryImg(String ossName, HttpServletRequest request, HttpServletResponse response) {
		GridFSDBFile file = ieduService.findImgById(ossName);
		try {
			if (file != null) {
				OutputStream sos;
				sos = response.getOutputStream();
				response.setContentType("application/octet-stream");
				// 向客户端输出文件
				file.writeTo(sos);
				sos.flush();
				sos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    //调转新增页面
	@RequestMapping("tohichar")
	public String tohichar() {
		return "WEB-INF/hichar/hichar";
	}
	
	//报表
	@RequestMapping("queryChart")
	@ResponseBody
	public  JSONObject  queryChart(HttpServletResponse response,HttpServletRequest request){
			// 查询所有月份 去重
			List<String> xlist=ieduService.findChart();			
				JSONObject json=new JSONObject();
			json.put("Xax", xlist);
			//  查到所有用户
			List<LinkedHashMap<String, Object>> findChartUser = ieduService.findChartUser();
			json.put("userName", findChartUser);			
			for (int i = 0; i < findChartUser.size(); i++) {
				LinkedHashMap<String, Object> userName= findChartUser.get(i);
				//查到用户对应的月份的钱
				List<Integer> price=ieduService.findUsrByName(userName.get("name").toString());
				json.put("userPrice_"+i, price);
			}		
			return json;
		}
	/*	@RequestMapping("queryZiJie")
	@ResponseBody
	public List<SonYunSchool> queryZiJie(){
		List<SonYunSchool> list=ieduService.queryZiJie();
		return list;
	}
	@RequestMapping("queryShenPiById")
	public String queryShenPiById(Model model,YunSchool yun){
		List<YunSchool>  yun1  = ieduService.queryShenPiById();
		model.addAttribute("hx", yun1);
		return "ws/shenpiTwo";
	}
	@RequestMapping("editStatus")
	public String editStatus(){
		
		ieduService.editStatus();
			
		return "哈哈哈";
	}*/
}
