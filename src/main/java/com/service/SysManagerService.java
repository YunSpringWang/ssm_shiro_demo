package com.service;

import com.common.entity.SysManager;

public interface SysManagerService extends BaseService<SysManager> {
	public SysManager selectManagerByAccount(String account);
}
