package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.Query;
import modal.Attendance;
import util.HibernateUtil;

public class AttendanceDao {
	Session session = HibernateUtil.getSession().openSession();

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

	public String saveAttendance(Attendance attendance) {
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSession().openSession()) {
	            transaction = session.beginTransaction();
	            session.save(attendance);
	            transaction.commit();
	            session.close();
	            return "Attendance recorded successfully";
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return "Error creating event";
	        }
	}
	public List<Attendance> getAllAttendeesForEvent(int eventId) {
	    String hql = "FROM Attendance WHERE event.id = :eventId";
	    return session.createQuery(hql, Attendance.class)
	                  .setParameter("eventId", eventId)
	                  .list();
	}
	public boolean removeAttendee(int userId, int eventId) {
	    String hql = "DELETE FROM Attendance WHERE guest.id = :userId AND event.id = :eventId";
	    int result = session.createQuery(hql)
	                        .setParameter("userId", userId)
	                        .setParameter("eventId", eventId)
	                        .executeUpdate();
	    return result > 0;
	}
	public Long getTotalAttendanceForEvent(int eventId) {
	    String hql = "SELECT COUNT(a) FROM Attendance a WHERE a.event.id = :eventId";
	    return session.createQuery(hql, Long.class)
	                  .setParameter("eventId", eventId)
	                  .uniqueResult();
	}


}
