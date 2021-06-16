package service;

import com.mysql.cj.xdevapi.SessionFactory;
import model.Product;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ProductService implements IProductService{

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> findAll() {
        String query = "SELECT c FROM Product AS c";
        TypedQuery<Product> productTypedQuery = entityManager.createQuery(query, Product.class);
        return productTypedQuery.getResultList();
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void delete(int id) {

    }
}
