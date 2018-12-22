package com.work.demo.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.work.demo.model.FileInfo;
import com.work.demo.model.FileInfoExample;


public interface FileInfoService {

	long countByExample(FileInfoExample example);
	
	int deleteByExample(FileInfoExample example);

	int deleteByPrimaryKey(String id);

	int insert(FileInfo record);
	
	int insertSelective(FileInfo record);
	
	
	
	List<FileInfo> selectByExample(FileInfoExample example);
	
	FileInfo selectByPrimaryKey(String id);
	
	int updateByExampleSelective(@Param("record") FileInfo record, @Param("example") FileInfoExample example);

	

	int updateByExample(@Param("record") FileInfo record, @Param("example") FileInfoExample example);

	int updateByPrimaryKeySelective(FileInfo record);

	

	int updateByPrimaryKey(FileInfo record);

	int deleteAll();

	List<FileInfo> queryAll();
    
}

