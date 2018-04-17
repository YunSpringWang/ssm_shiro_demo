package com.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.entity.SysManager;
import com.service.SysManagerService;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class UserTest {
	private static Logger logger = Logger.getLogger(UserTest.class);

	
	@Autowired
	private SysManagerService sysManagerService;

	@Test
	public void test() {
		List<SysManager> list = sysManagerService.queryAll();
		logger.info(list);

		SysManager users = sysManagerService.selectManagerByAccount("admin");
		logger.info(users);
		
		SysManager manager = new SysManager();
		manager.setId(1);
		logger.info(sysManagerService.queryOne(manager));
	}
}
