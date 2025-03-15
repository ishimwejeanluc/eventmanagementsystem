package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.Query;
import modal.Invitation;
import modal.InvitationStatus;
import util.HibernateUtil;

public class InvitationDao {

    // Send an invitation
    public String sendInvitation(Invitation invitation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.save(invitation);
            transaction.commit();
            session.close();
            return "Invitation sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error sending invitation";
        }
    }

    // Get all invitations for a guest
    public List<Invitation> getInvitationsForGuest(int guestId) {
        List<Invitation> invitations;
        try (Session session = HibernateUtil.getSession().openSession()) {
            String hql = "FROM Invitation i WHERE i.guest.id = :guestId";
            Query query = session.createQuery(hql, Invitation.class);
            query.setParameter("guestId", guestId);
            invitations = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return invitations;
    }

    // Get all invited guests for an event
    public List<Invitation> getInvitedGuestsByEvent(int eventId) {
        List<Invitation> invitedGuests;
        try (Session session = HibernateUtil.getSession().openSession()) {
            String hql = "SELECT i FROM Invitation i " +
                         "JOIN i.event e " +
                         "WHERE e.id = :eventId";
            Query query = session.createQuery(hql, Invitation.class);
            query.setParameter("eventId", eventId);
            invitedGuests = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return invitedGuests;
    }

    // Update invitation status (Accept/Decline)
    public String updateInvitationStatus(int invitationId, InvitationStatus status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            Invitation invitation = session.get(Invitation.class, invitationId);
            if (invitation != null) {
                invitation.setStatus(status);
                session.update(invitation);
                transaction.commit();
                session.close();
                return "Invitation status updated";
            }
            return "Invitation not found";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error updating status";
        }
    }
}
