package boot.pp_3_1.dao;

import boot.pp_3_1.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void update(User user);
    User getUser(int id);
    void delete(int id);
}
