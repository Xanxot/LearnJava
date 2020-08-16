package com.company.dbService;

import com.company.AddressDataSet;
import com.company.PhoneDataSet;
import com.company.User;
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
        System.out.println("save");

    }

    @Override
    public Object load(long id, Class clazz) {
        System.out.println("load");
        return null;
    }
}
