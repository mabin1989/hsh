package com.work.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.work.demo.model.FileInfo;
import com.work.demo.service.FileInfoService;
import com.work.demo.system.util.GrDateUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired  FileInfoService fileInfoService;
	
	
	@RequestMapping(value="/upload",method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody 
	public void upload(@RequestBody MultipartFile file,HttpServletRequest request, HttpServletResponse response) {
			JSONObject jsonObject = new JSONObject();
			try {
			// 文件改名
			String filename = file.getOriginalFilename();
			// 后缀   无"."
			String suffix = FilenameUtils.getExtension(filename);
			//uuid,给上传文件重新起名字
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String newName = uuid + "." + suffix;
			String realPath = "E:/images/"+GrDateUtil.format(new Date())+"/";
			System.out.println(realPath);
			File f=new File(realPath);
			//如果文件夹不存在则创建    
			if  (!f.exists()  && !f.isDirectory())      
			{       
			    System.out.println("文件夹不存在");  
			    f.mkdir();    
			}
			String realUrl = realPath + newName; 
			// 保存文件
			file.transferTo(new File(realUrl));
			// 返回文件路径
			jsonObject.put("realUrl", realUrl);
			jsonObject.put("msg", "上传成功");
			} catch (Exception e) {
				jsonObject.put("msg", "上传异常");
				e.printStackTrace();
			}finally {
				response.setContentType("application/json;charset=UTF-8");
				try {
					response.getWriter().write(jsonObject.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	@ResponseBody
	@RequestMapping(value="/saveFile",method = { RequestMethod.POST, RequestMethod.GET })
	public String save(@RequestParam(value = "fileList", required = true) String fileList) {
		JSONArray jsonArray=JSONArray.parseArray(fileList);
		fileInfoService.deleteAll();
		for(int i=0;i<jsonArray.size();i++) {
			FileInfo fileInfo=new FileInfo();
			fileInfo.setUuid(UUID.randomUUID().toString().replace("-", ""));
            fileInfo.setFilename(jsonArray.getJSONObject(i).getString("name"));
			JSONObject response=JSONObject.parseObject(jsonArray.getJSONObject(i).getString("response"));
			fileInfo.setFilepath(response.getString("realUrl"));
			fileInfoService.insertSelective(fileInfo);
		}
		return "提交成功";
	}
	
	@ResponseBody
	@RequestMapping(value="/showFile",method = { RequestMethod.POST, RequestMethod.GET })
	public JSONObject show() {
		List<FileInfo> files=fileInfoService.queryAll();
		JSONObject ob=new JSONObject();
		List<JSONObject> fileList=new ArrayList<JSONObject>();
		for(FileInfo f: files) {
			JSONObject file=new JSONObject();
			file.fluentPut("name",f.getFilename());
			file.fluentPut("response", JSONObject.parseObject("{\"realUrl\":\""+f.getFilepath()+"\"}"));
			fileList.add(file);
		}
		ob.fluentPut("fileList", fileList);
		return ob;
	}
	
	@ResponseBody
	@RequestMapping(value="/viewFile",method = { RequestMethod.POST, RequestMethod.GET })
	public void view(String fileName, String path,String flag,HttpServletRequest request,HttpServletResponse response) {
		File file = new File(path);
//        if (!(file.exists() && file.canRead())) {
//            file = new File(request.getSession().getServletContext().getRealPath("/")
//                    + "resource/icons/auth/root.png");
//        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            int length = inputStream.read(data);
            inputStream.close();
            //下载
            if("download".equals(flag)) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
            }
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
