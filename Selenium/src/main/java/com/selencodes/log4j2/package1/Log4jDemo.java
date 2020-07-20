package com.selencodes.log4j2.package1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log4jDemo {

	//use log4j at: https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core/2.13.3
	
	private final static Logger log = (Logger) LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] argv ) {
		log.trace("Log4J trace");
		log.debug("Log4J debug");
		log.info("Log4J info");
		log.warn("Log4J warn");
		log.error("log4J error");
		log.fatal("Log4J Fatal");

	}
	
		
}
