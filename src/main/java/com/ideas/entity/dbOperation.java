package com.ideas.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class dbOperation {
    static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();;
    static Session session;

    public static void addToDb(Person p){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
    }

    public static List readRec() {
        List list = new ArrayList();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        list = session.createQuery("FROM Person").list();
        session.close();
        return list;
    }

    public static void updateRecord(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Creating Transaction Entity
        Person p = (Person) session.get(Person.class, id);
        p.setFirstName("Karan");
        p.setLastName("Joshi");
        p.setEmail("kj@sdjf");
        session.getTransaction().commit();
        System.out.println("\nPerson With Id?= " + id + " Is Successfully Updated In The Database!\n");
        session.close();
    }

    public static void deleteRecord(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person p = (Person) session.get(Person.class, id);
        session.delete(p);
        session.getTransaction().commit();
        System.out.println("\nPerson With Id?= " + id + " Is Successfully Removed from In The Database!\n");
        session.close();

    }
}
