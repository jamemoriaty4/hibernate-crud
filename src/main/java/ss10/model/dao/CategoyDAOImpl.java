package ss10.model.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ss10.model.entity.Category;

import java.util.List;

@Repository

public class CategoyDAOImpl implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("from Category", Category.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean create(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public void update(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Category category = session.get(Category.class, id);
            if (category != null) {
                session.delete(category);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Category findById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Category category = session.get(Category.class, id);
            session.getTransaction().commit();
            return category;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
