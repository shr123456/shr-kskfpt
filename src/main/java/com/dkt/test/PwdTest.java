package com.dkt.test;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @auther shr
 * @date 2017/12/29
 * @time 15:50
 * @desc
 **/
public class PwdTest {
    public static void main(String[] args){
        System.out.println(new SimpleHash("SHA-1", "admin", "123333").toString());
    }
}
