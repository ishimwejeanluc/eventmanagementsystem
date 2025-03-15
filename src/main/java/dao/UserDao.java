package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.Query;
import modal.User;
import util.HibernateUtil;

public class UserDao {

    // Save a new user (Register)
    public String saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
            return "User saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error saving user";
        }
    }

    // Retrieve a user by ID
    public User getUserById(int userId) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.get(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get all users (hosts and guests)
    public List<User> getAllUsers() {
        List<User> users;
        try (Session session = HibernateUtil.getSession().openSession()) {
            Query query = session.createQuery("FROM User", User.class);
            users = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }
}
