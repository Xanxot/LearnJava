package com.company.dbService;


import com.company.entyties.AddressDataSet;
import com.company.entyties.PhoneDataSet;
import com.company.entyties.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DbServiceHibernate implements DbService {

    SessionFactory sessionFactory;

    public DbServiceHibernate() {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(PhoneDataSet.class)
                .addAnnotatedClass(AddressDataSet.class)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }


    @Override
    public void save(Object objectData) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(objectData);
            session.getTransaction().commit();
        }
    }

    @Override
    public Object load(long id, Class clazz) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(clazz,id);
        }

    }
}
