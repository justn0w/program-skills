package com.justnow.skills.config;

import jdk.nashorn.internal.parser.Token;

/**
 * @author justnow
 * Created on 2023-08-15
 * Description 远程配置类
 */
public class RemoteConfigUtils {

    public static TokenConfig getTokenConfig() {

        try {
            System.out.println("test");
        } catch (Exception e) {
            return new TokenConfig();
        }
        return new TokenConfig();

    }
}
