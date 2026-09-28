package data;

import Util.DBUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityTransaction;

import business.User;

public class UserDB {
    
    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static boolean emailExists(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u "
                + "WHERE u.email = :email";
        
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        
        try {
            User user = q.getSingleResultOrNull();
            if (user != null) {
                return true;
            }
            else {
                return false;
            }
        }
        finally{
            em.close();
        }
    }
}