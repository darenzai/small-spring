package com.darenzai.springframework.test.bean;

/**
 * <p>
 * description: UserSerivce
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 8:37
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}