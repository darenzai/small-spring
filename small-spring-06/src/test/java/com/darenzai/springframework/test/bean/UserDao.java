package com.darenzai.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "123");
        hashMap.put("10002", "456");
        hashMap.put("10003", "789");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
