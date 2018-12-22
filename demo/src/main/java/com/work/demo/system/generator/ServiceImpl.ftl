package com.work.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.demo.mapper01.${modelName}Mapper;
import com.work.demo.model.${modelName}Example;
import com.work.demo.model.${modelName};
<#if hasWithBLOBs>import com.work.demo.model.${modelName}WithBLOBs;</#if>

@Service(value = "${modelName?uncap_first}Service")
public class ${modelName}ServiceImpl implements ${modelName}Service {

	/** 日志记录器 */
	private static final Logger logger = LoggerFactory.getLogger(${modelName}ServiceImpl.class);

    @Autowired
    private ${modelName}Mapper ${modelName?uncap_first}Mapper;
    
    @Override
    public long countByExample(${modelName}Example example) {
    	logger.debug("调用行数统计.");
    	return ${modelName?uncap_first}Mapper.countByExample(example);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int deleteByExample(${modelName}Example example) {
    	return ${modelName?uncap_first}Mapper.deleteByExample(example);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int deleteByPrimaryKey(String id) {
    	return ${modelName?uncap_first}Mapper.deleteByPrimaryKey(id);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int insert(${modelName}<#if hasWithBLOBs>WithBLOBs</#if> record) {
    	return ${modelName?uncap_first}Mapper.insert(record);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int insertSelective(${modelName}<#if hasWithBLOBs>WithBLOBs</#if> record) {
    	return ${modelName?uncap_first}Mapper.insertSelective(record);
    }
    
    <#if hasWithBLOBs>
    @Override
    public List<${modelName}WithBLOBs> selectByExampleWithBLOBs(${modelName}Example example) {
    	return ${modelName?uncap_first}Mapper.selectByExampleWithBLOBs(example);
    }
    
    </#if>
    @Override
    public List<${modelName}> selectByExample(${modelName}Example example) {
    	return ${modelName?uncap_first}Mapper.selectByExample(example);
    }
    
    @Override
    public ${modelName}<#if hasWithBLOBs>WithBLOBs</#if> selectByPrimaryKey(String id) {
    	return ${modelName?uncap_first}Mapper.selectByPrimaryKey(id);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int updateByExampleSelective(@Param("record") ${modelName}<#if hasWithBLOBs>WithBLOBs</#if> record, @Param("example") ${modelName}Example example) {
    	return ${modelName?uncap_first}Mapper.updateByExampleSelective(record, example);
    }
    
    <#if hasWithBLOBs>
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int updateByExampleWithBLOBs(@Param("record") ${modelName}WithBLOBs record, @Param("example") ${modelName}Example example) {
    	return ${modelName?uncap_first}Mapper.updateByExampleWithBLOBs(record, example);
    }
    
    </#if>
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int updateByExample(@Param("record") ${modelName} record, @Param("example") ${modelName}Example example) {
    	return ${modelName?uncap_first}Mapper.updateByExample(record, example);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int updateByPrimaryKeySelective(${modelName}<#if hasWithBLOBs>WithBLOBs</#if> record) {
    	return ${modelName?uncap_first}Mapper.updateByPrimaryKeySelective(record);
    }
    
    <#if hasWithBLOBs>
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int updateByPrimaryKeyWithBLOBs(${modelName}WithBLOBs record) {
    	return ${modelName?uncap_first}Mapper.updateByPrimaryKeyWithBLOBs(record);
    }
    
    </#if>
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int updateByPrimaryKey(${modelName} record) {
    	return ${modelName?uncap_first}Mapper.updateByPrimaryKey(record);
    }

}

