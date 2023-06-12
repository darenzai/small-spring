package com.darenzai.springframework.test.bean;

/**
 * <p>
 * description: UserSerivce
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 8:37
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
