package com.justnow.skills;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author justnow
 * Created on 2022-08-22
 * Description
 */
public class LogDemo01 {

    public static final Logger log = LoggerFactory.getLogger(LogDemo01.class);

    public static void main(String[] args) {
        log.error("Hello world!");
    }

}
