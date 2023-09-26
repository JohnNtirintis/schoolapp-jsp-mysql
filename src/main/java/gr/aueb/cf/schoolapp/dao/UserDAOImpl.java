package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.User;

public class UserDAOImpl implements IUserDAO {
//    @Override
//    public User getByUsername(String username) {
//        return new User(1, username, "password");
//    }

    // TODO
    @Override
    public boolean isUserValid(String username, String password) {
        return true;
    }
}
