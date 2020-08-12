package com.ideas.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        int yes = 1;
        String firstName = "asdf", lastName = "ghjk", email = "ds@ar";
        dbOperation op= new dbOperation();
        op.addToDb(person1);
        op.addToDb(person1);
        op.addToDb(person1);

        List list = op.readRec();
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next() + " ");

        op.updateRecord(2);

        op.deleteRecord(3);

        //Scanner myObj = new Scanner(System.in);  // Create a Scanner object

//        while(yes>0){
//
//
//            switch (choice){
//
//                case 0:
//                    Session session = sessionFactory.openSession();
//                    session.beginTransaction();
//                    session.save(person1);
//                    session.getTransaction().commit();
//                    session.close();
//                    System.out.println("You Wanna Continue 1 or 0");
//                    yes = myObj.nextInt();  // Read user input
//                    System.out.println("Enter First Name:- ");
//                    firstName=myObj.nextLine();
//                    person1.setFirstName(firstName);
//                    System.out.println("Enter Last Name:- ");
//                    lastName=myObj.nextLine();
//                    person1.setLastName(lastName);
//                    System.out.println("Enter Email Address:- ");
//                    email=myObj.nextLine();
//                    person1.setLastName(email);
//
//            }
//        }
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(person1);
//        session.getTransaction().commit();

//
//        myObj.nextInt();
//
//        List Persons = new ArrayList();
//        ListIterator iterator = Persons.listIterator();
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Persons = session.createQuery("FROM Person").list();
//        if (Persons != null && Persons.size() > 0) {
//            while( iterator.hasNext()) {
//                System.out.println(iterator.next().toString());
//            }
//        }
//        session.getTransaction().commit();
//        session.close();
    }

}
