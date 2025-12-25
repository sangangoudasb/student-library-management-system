package com.example.student.library.management.system.model;

import com.example.student.library.management.system.enums.TranscationType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="transcations")
public class Transcation {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name="transcation_date", nullable=false)
    @CreationTimestamp
    private Date transcationDate;

    @Column(name="dueDate", nullable = false)
    private String dueDate;

    @Column(name="transcation_type", nullable = false)
    @Enumerated(value= EnumType.STRING)
    private TranscationType transcationType;

    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @JsonBackReference
    @JoinColumn
    @ManyToOne                                //always joinColumn and ManyToOne will come together.
    private Book book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTranscationDate() {
        return transcationDate;
    }

    public void setTranscationDate(Date transcationDate) {
        this.transcationDate = transcationDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TranscationType getTranscationType() {
        return transcationType;
    }

    public void setTranscationType(TranscationType transcationType) {
        this.transcationType = transcationType;
    }
}
