//package com.justnow.skills.rpc.rpcproxy;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//
//
///**
// * RPC服务
// */
//@Slf4j
//public class RpcServerHandler implements InvocationHandler {
//
//    private final String location;
//    private final Map serversMap;
//    //存放路由 调用信息
//    private static ConcurrentMap<String, FailBean> routeMap = new ConcurrentHashMap();
//
//    public RpcServerHandler(String location, Map serversMap) {
//        this.location = location;
//        this.serversMap = serversMap;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        Object result = null;
//        if (serversMap == null || serversMap.size() < 1) {
//            throw new RuntimeException("服务未配置，请配置服务");
//        }
//        //获取接口名
//        String interfaceName = method.getDeclaringClass().getName();
//        String methodName = interfaceName + "." + method.getName();
//        //处理服务降级
//        SwitchRpcConfig switchRpcConfig = RemoteConfigUtil.getRpcSwitchConfig();
//
//        //切机房处理
//        if (switchRpcConfig.getRpcSwitchMap() != null && !switchRpcConfig.getRpcSwitchMap().isEmpty()) {
//            SwitchBean bean = switchRpcConfig.getRpcSwitchMap().get(interfaceName);
//            // 切单边机房，是否影响双机房，只影响单机房则加&& severName.equals(bean.getSwitchService())
//            // 是否需要支持降某个方法
//            if (bean != null && bean.isOpenSwitch()) {
//                Object serverObj = serversMap.get(bean.getServiceKey());
//                if (serverObj != null) {
//                    MonitorUtils.monitor.count("RpcServerHandler_single_" + methodName + "_" + bean.getServiceKey() + "_count");
//                    try {
//                        result = method.invoke(serverObj, args);
//                    } catch (Exception e) {
//                        log.error("单边机房重试", e);
//                        result = method.invoke(serverObj, args);
//                    }
//                    return result;
//                }
//            }
//        }
//
//        //默认同机房调用
//        try {
//            Object serverObj = serversMap.get(location);
//            if (serverObj != null) {
//                MonitorUtils.monitor.count("RpcServerHandler_vertical_" + methodName + location + "_count");
//                result = method.invoke(serverObj, args);
//                return result;
//            }
//        } catch (Exception e) {
//            log.error("垂直机房调用出现异常：", e);
//        }
//
//        //跨机房重试
//        Iterator<Map.Entry> it = serversMap.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry entry = it.next();
//            String serverGroup = entry.getKey() == null ? "" : (String) entry.getKey();
//            if (location.equals(serverGroup)){//忽略同机房，进入跨机房重试
//                continue;
//            }
//
//            Object serverObj = entry.getValue();
//
//            //拼出路由key  接口名+方法名+serverGroup
//            String routeKey = methodName + "_" + serverGroup;
//
//            //查看路由Map中是否存在key，不存在 继续调用接口
//            //使用过程中别使用变量 FailBean failBean= routeMap.get(routeKey) 否则数据会不准
//            if (routeMap.get(routeKey) != null) {
//                //判断是否超过次数 和 失败的时间
//                if (routeMap.get(routeKey).getTime() > System.currentTimeMillis() && routeMap.get(routeKey).getFails() > switchRpcConfig.getMaxFails()) {
//                    continue;
//                }
//            }
//            String key = "RpcServerHandler_try_" + methodName +"_"+location+ "_Switch_" + serverGroup;
//            Object info = MonitorUtils.monitor.start(key);
//            try {
//                result = method.invoke(serverObj, args);
//                break;
//            } catch (Exception e) {
//                MonitorUtils.monitor.error(info);
//                /*指定时间段内失败次数累积，如超过指定最大次数，则当前不可用*/
//                if (routeMap.get(routeKey) == null) {
//                    routeMap.put(routeKey, new FailBean());
//                }
//                if (routeMap.get(routeKey).getTime() > System.currentTimeMillis()) {
//                    int retries = routeMap.get(routeKey).incrFails();
//                    if (retries > switchRpcConfig.getMaxFails()) {
//                        routeMap.get(routeKey).setTime(System.currentTimeMillis() + switchRpcConfig.getFailTimeout() * 1000);
//                    }
//                } else {
//                    routeMap.get(routeKey).setTime(System.currentTimeMillis() + switchRpcConfig.getFailTimeout() * 1000);
//                    routeMap.get(routeKey).failsZero();
//                    routeMap.get(routeKey).incrFails();
//                }
//
//                if (!it.hasNext()) {
//                    //服务调用异常，无可用服务
//                    if (routeMap.get(key) != null) {
//                        log.error("服务调用异常，无可用服务:服务：" + methodName + " 次数：" + routeMap.get(routeKey).getFails(), e);
//                    } else {
//                        log.error("服务调用异常，无可用服务:服务：" + methodName + " 次数：1", e);
//                    }
//                    throw e;
//                } else {
//                    //服务调用异常自动切换到下一个服务
//                    if (routeMap.get(key) != null) {
//                        log.error("服务调用异常自动切换到下一个备用服务：" + methodName + " 次数：" + routeMap.get(routeKey).getFails(), e);
//                    } else {
//                        log.error("服务调用异常自动切换到下一个备用服务：" + methodName + " 次数：0", e);
//                    }
//                }
//            } finally {
//                MonitorUtils.monitor.end(info);
//            }
//        }
//        return result;
//    }
//}
//
