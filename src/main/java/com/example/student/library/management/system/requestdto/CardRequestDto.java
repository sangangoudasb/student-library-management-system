package com.example.student.library.management.system.requestdto;

import com.example.student.library.management.system.enums.CardStatus;
import jakarta.persistence.Column;

public class CardRequestDto {

    private CardStatus cardStatus;
    private String expiryDate;
    private int studentId;

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
