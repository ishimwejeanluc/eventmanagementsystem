package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.Query;
import modal.Attendance;
import util.HibernateUtil;

public class AttendanceDao {

    // Check in a guest
    public String checkInGuest(Attendance attendance) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(attendance);
            transaction.commit();
            session.close();
            return "Guest checked in successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error checking in guest";
        }
    }

    // Get list of attendees for an event
    public List<Attendance> getAttendeesByEvent(int eventId) {
        List<Attendance> attendees;
        try (Session session = HibernateUtil.getSession().openSession()) {
            String hql = "SELECT a FROM Attendance a " +
                         "JOIN a.event e " +
                         "WHERE e.id = :eventId";
            Query query = session.createQuery(hql, Attendance.class);
            query.setParameter("eventId", eventId);
            attendees = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return attendees;
    }
}
