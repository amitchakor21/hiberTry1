package com.ideas.entity;

//reference https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-crud-operations-tutorial/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class dbOperation {
    static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();;
    static Session session;

    public static void addToDb(Person p){
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Exception occured : "+ e);
            if(session.getTransaction()!=null){
                session.getTransaction().rollback();
            }
        }finally {
            if(session!=null)
                session.close();
        }
    }

    public static List readRec() {
        List list = new ArrayList();
        try{
           Session session = sessionFactory.openSession();
           session.beginTransaction();
           list = session.createQuery("FROM Person").list();
        }
        catch (Exception e){
            System.out.println("Exception occured : "+ e);
            if(session.getTransaction()!=null){
                session.getTransaction().rollback();
            }
        }
        finally {
            if(session!=null)
                session.close();
        }
        return list;
    }

    public static void updateRecord(int id) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // Creating Transaction Entity
            Person p = (Person) session.get(Person.class, id);
            p.setFirstName("Karan");
            p.setLastName("Joshi");
            p.setEmail("kj@sdjf");
            session.getTransaction().commit();
            System.out.println("\nPerson With Id?= " + id + " Is Successfully Updated In The Database!\n");
        }
        catch (Exception e){
            System.out.println("Exception occured : "+ e);
            if(session.getTransaction()!=null){
                session.getTransaction().rollback();
            }
        }
        finally {
            if(session!=null)
                session.close();
        }
    }

    public static void deleteRecord(int id){
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Person p = (Person) session.get(Person.class, id);
            session.delete(p);
            session.getTransaction().commit();
            System.out.println("\nPerson With Id?= " + id + " Is Successfully Removed from In The Database!\n");
        }
        catch (Exception e){
            System.out.println("Exception occured : "+ e);
            if(session.getTransaction()!=null){
                session.getTransaction().rollback();
            }
        }
        finally {
            if(session!=null)
                session.close();
        }
    }
}
