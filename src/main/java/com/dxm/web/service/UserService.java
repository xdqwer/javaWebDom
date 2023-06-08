package com.dxm.web.service;
import cn.hutool.core.lang.UUID;
import com.dxm.web.dao.UserDao;
import com.dxm.web.entity.User;
import com.dxm.web.utils.JwtUtils;
import com.dxm.web.utils.Md5Utils;
import com.dxm.web.utils.RedisUtil;
import redis.clients.jedis.Jedis;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    public UserDao userDao  = new UserDao();;
    public List<User> userList() throws SQLException {
        List<User> users = userDao.selectAll();
        return users;
    }

    //登录判断
    public Map<String,String>  login(String username,String password) throws SQLException, NoSuchAlgorithmException {
        List<User> userOn = userDao.selectAll();
        Md5Utils md5Utils = new Md5Utils();
        String passwordMd = md5Utils.md5(password);
        Map<String,String> map=new HashMap<>();
        Jedis jedis = RedisUtil.getJedis();
        UUID uuid = UUID.randomUUID();
        for(int i = 0; i < userOn.size(); i++)
        {
                if (username.equals(userOn.get(i).getUser_name()) && passwordMd.equals(userOn.get(i).getPassword())){
                    String id = String.valueOf(userOn.get(i).getId());
                    int type = userOn.get(i).getType();
                    jedis.set(String.valueOf(uuid),id);
                    String jwtToken = JwtUtils.getJwtToken(String.valueOf(uuid));
                    map.put("id",jwtToken);
                    map.put("type",type+"");
                }
        }
        return  map;
    }


//    public static void main(String[] args) throws NoSuchAlgorithmException {
//        Md5Utils md5Utils = new Md5Utils();
//        String password="12345";
//        String passwordMd = md5Utils.md5(password);
//        System.out.println(passwordMd);
//    }
}
