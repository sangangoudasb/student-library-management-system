package com.example.student.library.management.system.requestdto;

import com.example.student.library.management.system.enums.TranscationType;

public class TranscationRequestDto {

    private String dueDate;
    private TranscationType transcationType;
    private int bookId;
    private int cardId;

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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
