package com.work.demo.system.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.work.demo.system.util.GrDateUtil;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HshGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(HshGenerator.class);

	public static  void  main(String[] args) {
		
		String modelName = "FileInfo";
		generator(modelName,false);

    }
	
	/**
	* 功能： 生成Service、ServiceImpl、Controller代码<br>
	*
	* @param modelName 实体类名
	* @author gr <br>
	* @version 2018年6月7日 下午12:01:23 <br>
	*/
	public static void generator(String modelName) {
		generator(modelName,true);
	}

	/**
	* 功能： 生成Service、ServiceImpl、Controller代码. 如果文件已存在，则在控制台输出生成的代码.<br>
	*
	* @param modelName 实体类名
	* @param hasController true 生成Controller代码, false 不生成Controller代码
	* @author gr <br>
	* @version 2018年6月7日 上午11:58:52 <br>
	*/
	public static void generator(String modelName, boolean hasController) {
		
		String line_separator = System.getProperty("line.separator");
		String file_separator = System.getProperty("file.separator");
		String project_dir = System.getProperty("user.dir");
		String service_dir = String.format("%2$s%1$ssrc%1$smain%1$sjava%1$scom%1$swork%1$sdemo%1$sservice", file_separator, project_dir);
		String controller_dir = String.format("%2$s%1$ssrc%1$smain%1$sjava%1$scom%1$swork%1$sdemo%1$scontroller", file_separator, project_dir);
		logger.debug("project_dir="+project_dir);
		logger.debug("service_dir="+service_dir);
		logger.debug("controller_dir="+controller_dir);

        try {

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);

            // 指定模板文件从何处加载的数据源，这里设置成一个文件目录
            //System.out.println(new File(HshGenerator.class.getResource("").getFile()).getPath());
            cfg.setDirectoryForTemplateLoading(new File(HshGenerator.class.getResource("").getFile()));
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_26));

            // 获取或创建模板
            Template templateService = cfg.getTemplate("Service.ftl");
            Template templateServiceImpl = cfg.getTemplate("ServiceImpl.ftl");
            Template templateController = cfg.getTemplate("Controller.ftl");
             

            // 创建数据模型
            boolean hasWithBLOBs = false;
            
            try {
				hasWithBLOBs = null != Class.forName(String.format("com.work.demo.model.%sWithBLOBs",modelName));
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
			}
            
            Map<String, Object> root = new HashMap<>();
            root.put("modelName", modelName);       
            root.put("hasWithBLOBs", hasWithBLOBs);       
            root.put("datetime", GrDateUtil.formatDateTime(new Date()));       

            // 将模板和数据模型合并 输出到文件或Console
            File fileService = new File(service_dir,String.format("%sService.java", modelName));
            File fileServiceImpl = new File(service_dir,String.format("%sServiceImpl.java", modelName));
            File fileController = new File(controller_dir,String.format("%sController.java", modelName));
            
            Writer out = new OutputStreamWriter(System.out);
            // service接口
            if (fileService.exists()) {
            	logger.debug("生成的service接口："+line_separator);
            	templateService.process(root, out);
                out.flush();
			} else {
				Writer outService = new OutputStreamWriter(new FileOutputStream(fileService));
				templateService.process(root, outService);
                outService.flush();
			}
            // service实现
            if (fileServiceImpl.exists()) {
            	logger.debug("生成的service实现："+line_separator);
            	templateServiceImpl.process(root, out);
                out.flush();
            } else {
            	Writer outServiceImpl = new OutputStreamWriter(new FileOutputStream(fileServiceImpl));
            	templateServiceImpl.process(root, outServiceImpl);
            	outServiceImpl.flush();
            }
            // Controller控制器
            if (hasController) {
            	if (fileController.exists()) {
            		logger.debug("生成的serviceController控制器："+line_separator);
            		templateController.process(root, out);
            		out.flush();
            	} else {
            		Writer outController = new OutputStreamWriter(new FileOutputStream(fileController));
            		templateController.process(root, outController);
            		outController.flush();
            	}
			}

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
	}

}