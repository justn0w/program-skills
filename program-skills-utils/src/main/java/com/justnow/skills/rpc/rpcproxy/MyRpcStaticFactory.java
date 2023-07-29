package com.justnow.skills.rpc.rpcproxy;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 * @author justnow
 * Created on 2023-05-21
 * Description rpc配置服务工厂
 */
@Slf4j
public class MyRpcStaticFactory {



    /**
     * location和serversMap, 通过构造器配置
     * @param location 当前部署使用的机房名称
     * @param serversMap rpc consumer列表map
     * @param <T>
     * @return
     */
    public static <T> T getMyRpcProxy(String location, Map<String, T> serversMap) {
        // 1 基础校验
        if (MapUtils.isEmpty(serversMap)) {
            log.error("serversMap为空, 请配置");
            throw new RuntimeException("serversMap为空, 请配置");
        }

        return null;
    }
}
