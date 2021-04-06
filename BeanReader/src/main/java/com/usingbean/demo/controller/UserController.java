package com.usingbean.demo.controller;

import com.usingbean.demo.models.User;
import com.usingbean.demo.repostory.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserRepostory userRepostory;

    @Autowired
    DriverManagerDataSource db;//this one we create with util using bean


    public UserController(UserRepostory userRepostory) {
        this.userRepostory = userRepostory;
    }


    @PostMapping("/insertdatabase1")
    public Map<String,User> insertdb1( @RequestBody User user){
        Map<String, User> userMap = new HashMap<>();
        userMap.put("Result",userRepostory.save(user));

        return userMap;
    }

    @GetMapping("/getfromdatabase1")
    public Map<String,User> getAlldb1(){
        Map<String, User> userMap = new HashMap<>();
        List<User> users;
        users = userRepostory.findAll();

        for (User user : users) {
            userMap.put("Result",user);
        }

        return userMap;
    }

    @PostMapping("/insertdatabase2")
    public Map<String,User> insertdb2( @RequestBody User user) throws SQLException {
        Map<String, User> userMap = new HashMap<>();


        String sqlm = "INSERT INTO USER " +
                "VALUES ("+user.getId()+", '"+user.getName()+"', '"+user.getEmail()+"', "+user.getAge()+")";
        PreparedStatement pre = db.getConnection().prepareStatement(sqlm);
        ResultSet rs = pre.executeQuery();

        return userMap;
    }

    @GetMapping("/getfromdatabase2")
    public Map<String,Object> getAlldb2() throws SQLException {
        Map<String, Object> userMap = new HashMap<>();

        String sql ="select * from USER ";
        PreparedStatement pre = db.getConnection().prepareStatement(sql);

        ResultSet rs = pre.executeQuery();
        String name="";
        while (rs.next()) {
             System.out.println(rs.getString("name"));
             name = rs.getString("name");
        }

        userMap.put("result",name);

        return userMap;
    }


}
