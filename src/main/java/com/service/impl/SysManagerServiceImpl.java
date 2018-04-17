package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.dao.SysManagerMapper;
import com.common.entity.SysManager;
import com.service.SysManagerService;

@Repository("sysManagerService")
public class SysManagerServiceImpl extends BaseServiceImpl<SysManager> implements SysManagerService {

	@Autowired
	private SysManagerMapper sysManagerMapper;

	public SysManager selectManagerByAccount(String account) {
		SysManager user =new SysManager();
		user.setAccount(account);
		return (SysManager) sysManagerMapper.selectOne(user);
	}

	public Integer deleteByIds(Class<SysManager> clazz, List<Object> values) {
		// TODO Auto-generated method stub
		return null;
	}

}
