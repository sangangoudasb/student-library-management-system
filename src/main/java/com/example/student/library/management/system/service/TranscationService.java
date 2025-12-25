package com.example.student.library.management.system.service;

import com.example.student.library.management.system.converters.TranscationConverter;
import com.example.student.library.management.system.model.Book;
import com.example.student.library.management.system.model.Card;
import com.example.student.library.management.system.model.Transcation;
import com.example.student.library.management.system.repository.BookRepository;
import com.example.student.library.management.system.repository.CardRepository;
import com.example.student.library.management.system.repository.TranscationRepository;
import com.example.student.library.management.system.requestdto.TranscationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranscationService {

     @Autowired
    TranscationRepository transcationRepository;

     @Autowired
    BookRepository bookRepository;

     @Autowired
    CardRepository cardRepository;

    public String saveTranscation(TranscationRequestDto transcationRequestDto){

       Transcation transcation= TranscationConverter.converTransactionRequestDtoIntoTransaction(transcationRequestDto);

       // using cardid fetch the complete object of card from cardRepository. this is bcz of foreign key.
      Card card=cardRepository.findById(transcationRequestDto.getCardId()).get();
      if(card!= null){
          transcation.setCard(card);
      }
      else{
          transcation.setCard(null);
      }

        // using bookid fetch the complete object of book from bookRepository. this is bcz of foreign key.
        Book book=bookRepository.findById((transcationRequestDto.getBookId())).get();
      if(book!=null){
          transcation.setBook(book);
      }
      else{
          transcation.setBook(book);
      }

       transcationRepository.save(transcation);
    return "Transaction saved successfully";
    }

    public Transcation getTranscationById(int id){
        Optional<Transcation> transcationOptional = transcationRepository.findById(id);
        if(transcationOptional.isPresent()){
            return transcationOptional.get();
        } else {
            throw new RuntimeException("Transaction not found with id: " + id);
        }
    }

    public List<Transcation> getAllTranscations(){
        return transcationRepository.findAll();
    }

    public List<Transcation> getTranscationsByPagination(int pageNo, int pageSize){
        return transcationRepository
                .findAll(PageRequest.of(pageNo, pageSize, Sort.by("id").ascending()))
                .getContent();
    }

    public String deleteTranscationById(int id){
        transcationRepository.deleteById(id);
        return "Transaction with id " + id + " got deleted successfully!";
    }

    public String updateTranscation(int id, TranscationRequestDto transcationRequestDto){

        Transcation existingTranscation = getTranscationById(id);

        existingTranscation.setDueDate(transcationRequestDto.getDueDate());
        existingTranscation.setTranscationType(transcationRequestDto.getTranscationType());

        transcationRepository.save(existingTranscation);
        return "Transaction updated successfully";
    }

}
