package com.wyd.login.service;

import java.util.List;

import com.wyd.login.dto.LoadingCountByIsComputor;
import com.wyd.login.dto.LoadingDto;
import com.wyd.login.webutils.exception.BusinessException;

public interface LoadingService {
	/**
	 * 
	 * <p>Title: insertLoadingCount</p>  
	 * <p>Description: 保存访问次数</p>
	 */
	public void insertLoadingCount(LoadingDto loadingDto)throws BusinessException;
	
	/**
	 * 
	 * <p>Title: insertLoadingCount</p>  
	 * <p>Description: 保存访问次数</p>
	 */
	public List<LoadingCountByIsComputor> getLoadingCount()throws BusinessException;
}
