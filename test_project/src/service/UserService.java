package service;

import dao.UserDao;
import model.Booking;
import model.User;
import java.util.*;

public class UserService {

    private static UserService userService;
    private static UserDao userDao;
    Map<String,User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public User getUserById(String userId)
    {
        return users.get(userId);
    }



    private UserService()
    {
        userDao = new UserDao();
        users= new HashMap<>();
    }

    public static UserService getInstance()
    {
        if(userService ==null)
             userService = new UserService();

        return userService;
    }

    public User addUser(String userId, String name, Double funds)
    {
        User u =  userDao.addUser(userId,name,funds);
        users.put(userId,u);
        return u;
    }

    public boolean isUserValidForBooking(String userId,double amt)
    {
        if(users.containsKey(userId))
        {
            User user = users.get(userId);
            if(user.getFunds()>=amt)
                 return true;
        }
        return false;

    }

    public List<Booking> getUserBookings(String userId)
    {
        User user = users.get(userId);
        return user.getBooking();
    }


}
