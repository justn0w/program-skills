package com.justnow.javabase.learnconcurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author justnow
 * Created on 2023-07-01
 * Description
 */
public class DemoThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        Arrays.asList(threadInfos).forEach(x -> System.out.println("[" + x.getThreadId() + "] " + x.getThreadName()));
    }
}
