package boot.pp_3_1.dao;

import boot.pp_3_1.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@EnableTransactionManagement
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManagerFactory;

    @Override
    public void add(User user) {
        entityManagerFactory.persist(user);
    }

    @Override
    public void update(User user) {
        entityManagerFactory.merge(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManagerFactory.createNativeQuery("SELECT * FROM test1.users",User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManagerFactory.find(User.class, (long) id);
    }

    @Override
    public void delete(int id) {
        entityManagerFactory.remove(getUser(id));
    }
}