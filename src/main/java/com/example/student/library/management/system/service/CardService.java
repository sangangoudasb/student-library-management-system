package com.example.student.library.management.system.service;

import org.springframework.stereotype.Service;


import com.example.student.library.management.system.converters.CardConverter;
import com.example.student.library.management.system.model.Card;
import com.example.student.library.management.system.model.Student;
import com.example.student.library.management.system.repository.CardRepository;
import com.example.student.library.management.system.repository.StudentRepository;
import com.example.student.library.management.system.requestdto.CardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    StudentRepository studentRepository;

    public String saveCard(CardRequestDto cardRequestDto){

        Card card = CardConverter.convertCardRequestDtoIntoCard(cardRequestDto);

        Student student = studentRepository.findById(cardRequestDto.getStudentId())
                .orElseThrow(() -> new RuntimeException(
                        "Student not found with id: " + cardRequestDto.getStudentId()));

        card.setStudent(student);

        cardRepository.save(card);
        return "Card saved successfully";
    }

    public Card getCardById(int id){
        Optional<Card> cardOptional = cardRepository.findById(id);
        if(cardOptional.isPresent()){
            return cardOptional.get();
        } else {
            throw new RuntimeException("Card not found with id: " + id);
        }
    }

    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }

    public List<Card> getCardsByPagination(int pageNo, int pageSize){
        return cardRepository
                .findAll(PageRequest.of(pageNo, pageSize, Sort.by("id").ascending()))
                .getContent();
    }

    public String deleteCardById(int id){
        cardRepository.deleteById(id);
        return "Card with id " + id + " got deleted successfully!";
    }

    public String updateCard(int id, CardRequestDto cardRequestDto){

        Card existingCard = getCardById(id);

        existingCard.setCardStatus(cardRequestDto.getCardStatus());
        existingCard.setExpiryDate(cardRequestDto.getExpiryDate());

        cardRepository.save(existingCard);
        return "Card updated successfully";
    }
}

