package com.work.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.demo.mapper01.FileInfoMapper;
import com.work.demo.model.FileInfoExample;
import com.work.demo.model.FileInfo;


@Service(value = "fileInfoService")
public class FileInfoServiceImpl implements FileInfoService {

	/** 日志记录器 */
	private static final Logger logger = LoggerFactory.getLogger(FileInfoServiceImpl.class);

    @Autowired
    private FileInfoMapper fileInfoMapper;
    
    @Override
    public long countByExample(FileInfoExample example) {
    	logger.debug("调用行数统计.");
    	return fileInfoMapper.countByExample(example);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int deleteByExample(FileInfoExample example) {
    	return fileInfoMapper.deleteByExample(example);
    }
    
    
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int insert(FileInfo record) {
    	return fileInfoMapper.insert(record);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int insertSelective(FileInfo record) {
    	return fileInfoMapper.insertSelective(record);
    }
    
    @Override
    public List<FileInfo> selectByExample(FileInfoExample example) {
    	return fileInfoMapper.selectByExample(example);
    }
    
   
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int updateByExampleSelective(@Param("record") FileInfo record, @Param("example") FileInfoExample example) {
    	return fileInfoMapper.updateByExampleSelective(record, example);
    }
    
    @Override
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public int updateByExample(@Param("record") FileInfo record, @Param("example") FileInfoExample example) {
    	return fileInfoMapper.updateByExample(record, example);
    }

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FileInfo selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(FileInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(FileInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return fileInfoMapper.deleteAll();
	}

	@Override
	public List<FileInfo> queryAll() {
		// TODO Auto-generated method stub
		return fileInfoMapper.queryAll();
	}
    
  
  

}

