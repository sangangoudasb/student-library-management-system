package com.example.student.library.management.system.controller;


import com.example.student.library.management.system.model.Card;
import com.example.student.library.management.system.requestdto.CardRequestDto;
import com.example.student.library.management.system.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card/apis")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/save")
    public String saveCard(@RequestBody CardRequestDto cardRequestDto){
        return cardService.saveCard(cardRequestDto);
    }

    @GetMapping("/find/{id}")
    public Card findById(@PathVariable int id){
        return cardService.getCardById(id);
    }

    @GetMapping("/findAll")
    public List<Card> findAll(){
        return cardService.getAllCards();
    }

    @GetMapping("/findAllByPage")
    public List<Card> findAllByPage(
            @RequestParam int pageNo,
            @RequestParam int pageSize){
        return cardService.getCardsByPagination(pageNo, pageSize);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return cardService.deleteCardById(id);
    }

    @PutMapping("/update/{id}")
    public String updateCard(
            @PathVariable int id,
            @RequestBody CardRequestDto cardRequestDto){
        return cardService.updateCard(id, cardRequestDto);
    }
}
