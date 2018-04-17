package com.logback;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
public class LogbackTest {
	private final static Logger logger = Logger.getLogger(LogbackTest.class);
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger2 = (Logger) LoggerFactory.getLogger(LogbackTest.class); 
	public static void main(String[] args) {
		logger.info("logback++++ 成功了");
		logger.error("logback---- 成功了");
		logger.debug("logback****** 成功了");
		
		
		logger2.info("logback+++++222++++ 成功了");
		logger2.error("logback_____22_____ 成功了");
		logger2.debug("logback******22****** 成功了");
	}

}
