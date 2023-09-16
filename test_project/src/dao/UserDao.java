package dao;

import model.Booking;
import model.User;
import java.util.*;

import java.util.ArrayList;

public class UserDao {
    public User addUser(String userId, String name, Double funds)
    {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(name);
        user.setFunds(funds);
        return user;
    }


}
