package com.work.demo.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.work.demo.model.${modelName};
import com.work.demo.model.${modelName}Example;
<#if hasWithBLOBs>import com.work.demo.model.${modelName}WithBLOBs;</#if>

public interface ${modelName}Service {

	long countByExample(${modelName}Example example);
	
	int deleteByExample(${modelName}Example example);

	int deleteByPrimaryKey(String id);

	int insert(${modelName}<#if hasWithBLOBs>WithBLOBs</#if> record);
	
	int insertSelective(${modelName}<#if hasWithBLOBs>WithBLOBs</#if> record);
	
	<#if hasWithBLOBs>List<${modelName}WithBLOBs> selectByExampleWithBLOBs(${modelName}Example example);</#if>
	
	List<${modelName}> selectByExample(${modelName}Example example);
	
	${modelName}<#if hasWithBLOBs>WithBLOBs</#if> selectByPrimaryKey(String id);
	
	int updateByExampleSelective(@Param("record") ${modelName}<#if hasWithBLOBs>WithBLOBs</#if> record, @Param("example") ${modelName}Example example);

	<#if hasWithBLOBs>int updateByExampleWithBLOBs(@Param("record") ${modelName}WithBLOBs record, @Param("example") ${modelName}Example example);</#if>

	int updateByExample(@Param("record") ${modelName} record, @Param("example") ${modelName}Example example);

	int updateByPrimaryKeySelective(${modelName}<#if hasWithBLOBs>WithBLOBs</#if> record);

	<#if hasWithBLOBs>int updateByPrimaryKeyWithBLOBs(${modelName}WithBLOBs record);</#if>

	int updateByPrimaryKey(${modelName} record);
    
}

