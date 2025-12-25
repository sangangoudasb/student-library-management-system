package com.example.student.library.management.system.converters;

import com.example.student.library.management.system.model.Book;
import com.example.student.library.management.system.model.Card;
import com.example.student.library.management.system.requestdto.BookRequestDto;
import com.example.student.library.management.system.requestdto.CardRequestDto;

public class CardConverter {


    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto) {

        Card card=new Card();

        card.setCardStatus(cardRequestDto.getCardStatus());
        card.setExpiryDate(cardRequestDto.getExpiryDate());

        return card;
    }
}


