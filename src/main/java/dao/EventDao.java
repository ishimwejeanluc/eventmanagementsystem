package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.Query;
import modal.Event;
import modal.User;
import util.HibernateUtil;

public class EventDao {
	Session session = HibernateUtil.getSession().openSession();

    // Save a new event
    public String createEvent(Event event) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(event);
            transaction.commit();
            session.close();
            return "Event created successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error creating event";
        }
    }

    // Get event by ID
    public Event getEventById(int eventId) {
        try (Session session = HibernateUtil.getSession().openSession()) {
            return session.get(Event.class, eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get all events hosted by a specific user
    public List<Event> getEventsByHost(int hostId) {
        List<Event> events;
        try (Session session = HibernateUtil.getSession().openSession()) {
            String hql = "FROM Event e WHERE e.host.id = :hostId";
            Query query = session.createQuery(hql, Event.class);
            query.setParameter("hostId", hostId);
            events = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return events;
    }
    public Event getEventByTitle(String title) {
        String hql = "FROM Event WHERE title = :title";
        return session.createQuery(hql, Event.class)
                      .setParameter("title", title)
                      .uniqueResult();
    }
    public boolean deleteEvent(int eventId) {
        Event event = session.get(Event.class, eventId);
        if (event != null) {
            session.delete(event);
            return true;
        }
        return false;
    }
    
    public boolean hostHasEvents(int hostId) {
        String hql = "SELECT COUNT(e) FROM Event e WHERE e.host.id = :hostId";
        Long count = session.createQuery(hql, Long.class)
                            .setParameter("hostId", hostId)
                            .uniqueResult();
        return count > 0;
    }
     
    public boolean eventExists(int eventId) {
        String hql = "SELECT COUNT(e) FROM Event e WHERE e.id = :eventId";
        Long count = session.createQuery(hql, Long.class)
                            .setParameter("eventId", eventId)
                            .uniqueResult();
        return count > 0;
    }

    public List<User> getAllGuestsForEvent(int eventId) {
        String hql = "SELECT i.guest FROM Invitation i WHERE i.event.id = :eventId";
        return session.createQuery(hql, User.class)
                      .setParameter("eventId", eventId)
                      .list();
    }

}

