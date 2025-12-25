package com.example.student.library.management.system.model;

import com.example.student.library.management.system.enums.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="book")
public class Book {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="title", nullable = false)
   private String title;

    @Column(name="publisher_name", nullable = false)
   private  String publisherName;

    @Column(name="published_date", nullable = false)
   private  String publishedDate;

    @Column(name="pages", nullable = false)
   private  String pages;

    @Column(name="availability" ,  nullable = false)
    private boolean availability;

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Column(name="category", nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Category category;

    @Column(name="rack_no", nullable = false)
    private String rackNo;

    @JsonBackReference
    @JoinColumn          //in one to many relationship always one acts as a Foreign Key.
    @ManyToOne
    private Author author;

    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Card card;

    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Transcation> transcationList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPages() {
        return pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transcation> getTranscationList() {
        return transcationList;
    }

    public void setTranscationList(List<Transcation> transcationList) {
        this.transcationList = transcationList;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo;
    }


}
