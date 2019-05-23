package com.wyd.login.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.login.dao.LoadingMapper;
import com.wyd.login.dto.LoadingCountByIsComputor;
import com.wyd.login.dto.LoadingDto;
import com.wyd.login.service.LoadingService;
import com.wyd.login.webutils.exception.BusinessException;


@Service
public class LoadingServiceIpml implements LoadingService{

	@Autowired
	private LoadingMapper loadingMapper;
	
	
	@Override
	public void insertLoadingCount(LoadingDto loadingDto) throws BusinessException {
		loadingMapper.insertLoading(loadingDto);
	}


	@Override
	public List<LoadingCountByIsComputor> getLoadingCount() throws BusinessException {
		return loadingMapper.getloadingCount();
	}


}
