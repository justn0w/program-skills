package com.justnow.skills.learnmthodMethodReferences;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MethodReferDemoClass {


    private String s;

    public void getCharEqualsA() {
        char[] chars = s.toCharArray();
        int num = 0;
        for (char aChar : chars) {
            if (aChar == 'A') {
                num++;
            }
        }
        System.out.println("字符串: " + s + ", 中包含的A的格式为" + num);
    }
}
