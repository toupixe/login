package com.wyd.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wyd.login.dto.LoadingCountByIsComputor;
import com.wyd.login.dto.LoadingDto;

@Repository
public interface LoadingMapper {
	/**
	 * 
	 * <p>Title: insertUser</p>  
	 * <p>Description:保存一个用户 </p>  
	 * @param userDto 用户数据传输类
	 */
	void insertLoading(@Param("loadingDto") LoadingDto loadingDto);
	
	/**
	 * 
	 * <p>Title: loadingCount</p>  
	 * <p>Description:分组查询移动端与pc端的条数</p>  
	 * @return
	 */
	List<LoadingCountByIsComputor> getloadingCount(); 
}
