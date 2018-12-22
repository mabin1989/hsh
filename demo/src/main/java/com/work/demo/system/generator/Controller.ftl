package com.work.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import com.work.demo.model.${modelName}Example;
import com.work.demo.model.${modelName}Example.Criteria;
import com.work.demo.model.${modelName};
import com.work.demo.service.${modelName}Service;
import com.work.demo.system.model.HshConstant;
import com.work.demo.system.model.ReturnData;
import com.work.demo.system.util.GrStringUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/api/${modelName?lower_case}controller")
public class ${modelName}Controller{

	/** 日志记录器 */
	private static final Logger logger = LoggerFactory.getLogger(${modelName}Controller.class);
	
	@Autowired
	private ${modelName}Service ${modelName?uncap_first}Service;
	
	/**
	 * 
	 * 功能： <br/>
	 *
	 * @author gr <br/>
	 * @version ${datetime} <br/>
	 */
	@ApiOperation(value="API名称", notes="API描述") 
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "参数1描述", required = false, dataType = "String")
    }) 
    @ResponseBody 
	@RequestMapping(value="/query",method = { RequestMethod.POST, RequestMethod.GET })
	public ReturnData<List<${modelName}>> selectByExample(@ApiIgnore HttpServletRequest request, 
			@RequestParam(value = "ids", required = false) String ids
		){
		
		${modelName}Example example = new ${modelName}Example();
		Criteria criteria = example.createCriteria();
		
		if (!StringUtils.isEmpty(ids)) {
			criteria.andIdIn(Arrays.asList(GrStringUtil.split(ids)));
		}
		
		// 获取查询结果
		List<${modelName}> list = ${modelName?uncap_first}Service.selectByExample(example);
		ReturnData<List<${modelName}>> ret = new ReturnData<>();
		ret.setData(list);
		ret.setReturnCode(HshConstant.ReturnInfo.SUCCESS);
		ret.setReturnMsg(HshConstant.ReturnInfo.SUCCESS_MSG);
		logger.debug(JSON.toJSONString(ret, true));
		
		return ret;
	}

}

