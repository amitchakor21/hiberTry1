package com.ideas.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        int yes=1;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        while(yes>0){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(person1);
            session.getTransaction().commit();
            session.close();
            System.out.println("You Wanna Continue 1 or 0");
            yes = myObj.nextInt();  // Read user input
            System.out.println("Enter First Name:- ");
            person1.setFirstName(myObj.nextLine().toUpperCase());
            System.out.println("Enter Last Name:- ");
            person1.setLastName(myObj.nextLine().toUpperCase());
            System.out.println("Enter Email Address:- ");
            person1.setEmail(myObj.nextLine());
        }
    }
}
