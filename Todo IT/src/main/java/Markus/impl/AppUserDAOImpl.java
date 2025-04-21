package Markus.impl;

import Markus.dao.AppUserDAO;
import Markus.models.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDAOImpl implements AppUserDAO {
    private List<AppUser> users = new ArrayList<>();

    @Override
    public void persist(AppUser user) {
        users.add(user);
    }

    @Override
    public AppUser findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUserName().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void remove(AppUser user) {
        users.remove(user);
    }
}
