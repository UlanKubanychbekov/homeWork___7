package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao, AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

        entityManager.close();


    }


    @Override
    public void dropUsersTable(User users) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        entityManager.createNativeQuery("drop table users", User.class).executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();

        entityManager.close();


    }

    @Override
    public void removeUserById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.find(User.class, id));

        entityManager.getTransaction().commit();

        entityManager.close();

    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();

        return users;
    }

    @Override
    public void cleanUsersTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createNativeQuery("TRUNCATE table users ").executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();


    }

    @Override
    public boolean existsByFirstName(String name) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery<Boolean> query = entityManager.createQuery("select case when count(c) > 0 " +
                "then true " +
                "else false end " +
                "from User c where c.name = :name", Boolean.class);

        query.setParameter("name", name);

        Boolean singleResult = (Boolean) query.getSingleResult();

        entityManager.getTransaction().commit();

        entityManager.close();




        return singleResult;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
