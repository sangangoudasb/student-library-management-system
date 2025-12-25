package com.example.student.library.management.system.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column(name="name" ,  nullable=false)
    private String name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="mobile", nullable = false)
    private String mobile;

    @Column(name="dept", nullable = false)
    private String dept;

    @Column(name ="sem", nullable = false)
    private String sem;

    @Column(name="gender", nullable = false)
    private String gender;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name = "dob", nullable = false)
    private String dob;

    @JsonManagedReference // this annotation is used bcz whnever we get request comes in postman it continuosly prints card details , student details and again card details. Basically it starts looping.
    // so to prevent this looping we use above annotation. It manages this objects here only. it should be given where mappedBy is done.
    @OneToOne(mappedBy = "student", cascade=CascadeType.ALL)  //Cascade is added bcz any changes made in student
    private Card card;                                        //will affect in card. ex: if student is added card also added.
                                                          //  or whatever add/delete changes made in student reflects in card.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDept() {
        return dept;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dept='" + dept + '\'' +
                ", sem='" + sem + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", card=" + card +
                '}';
    }
}
