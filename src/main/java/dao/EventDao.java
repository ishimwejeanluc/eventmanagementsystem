package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.Query;
import modal.Event;
import util.HibernateUtil;

public class EventDao {

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
}

