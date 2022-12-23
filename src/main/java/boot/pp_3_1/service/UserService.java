package boot.pp_3_1.service;

import boot.pp_3_1.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    public User getUser(int id);
    void update(User user);
    void delete(int id);
}
