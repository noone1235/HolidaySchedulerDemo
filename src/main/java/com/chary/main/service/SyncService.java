package com.chary.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SyncService {
	
    private Logger logger = LoggerFactory.getLogger(SyncService.class);
    
    
    public void start() {
        logger.info("HI HOW R U");
        //do the logic
    }
    public void start2() {
    	logger.info("hello");
    }
}
