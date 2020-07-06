package com.letskode.log4j2.package2;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Log4jDemoMain {

	private final Logger log = (Logger) LogManager.getLogger(Log4jDemoMain.class);
	
	@BeforeTest
	public void setup(){
		
	}
	
	@Test
	public void test() {
		log.trace("Log4J trace");
		log.debug("Log4J debug");
		log.info("Log4J info");
		log.warn("Log4J warn");
		log.error("log4J error");
		log.fatal("Log4J Fatal");
	}
	
	@AfterTest
	public void tearDown() {
		
	}
	
}
