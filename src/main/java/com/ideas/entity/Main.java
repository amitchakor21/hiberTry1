package com.ideas.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
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

    }

}
