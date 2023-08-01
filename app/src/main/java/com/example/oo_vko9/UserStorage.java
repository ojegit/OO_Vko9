package com.example.oo_vko9;

import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<User>();
    private static UserStorage single_instance = null;
    public UserStorage() {}

    public static synchronized UserStorage getInstance() {
        if(single_instance == null)
            single_instance = new UserStorage();
        return single_instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int id) {
        users.remove(id);
    } //optional

    public int getListSize() { return users.size(); } //optional

    public ArrayList<User> getUsers() {
        return users;
    }
}
