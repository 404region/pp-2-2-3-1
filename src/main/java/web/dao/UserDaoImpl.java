package web.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    private String queryFindUserById="SELECT c FROM User c WHERE c.id LIKE :id";

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

        entityManager.close();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUserById(long id) {
        User user = (User) entityManager.createQuery(queryFindUserById)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("SELECT p FROM User p").getResultList();
        return users;
    }
}
