package com.ideas.entity;

import javax.persistence.*;

//@Entity
//@Table()
//public class Person {
//    int id;
//    String first;
//    String last;
//    String email;
//}

@Entity
@Table(name= "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "firstname")
    private String firstName="Amit";
    @Column(name = "lastname")
    private String lastName="chakor";
    @Column(name = "email")
    private String email="amit@s.com";

    public Person(){
        System.out.println("Inside Person Constructor");
    }

    public Person(String firstName,String lastName,String email){
        this.firstName=firstName;
        this.email=email;
        this.lastName=lastName;
        System.out.println("Inside Person Constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Person Details?= Id: " + this.id + ", Name: " + this.firstName + " " + this.lastName + ", Email: " + this.email;
    }
}