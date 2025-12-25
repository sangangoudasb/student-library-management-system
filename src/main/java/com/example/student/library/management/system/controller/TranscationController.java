package com.example.student.library.management.system.controller;

import com.example.student.library.management.system.model.Transcation;
import com.example.student.library.management.system.requestdto.TranscationRequestDto;
import com.example.student.library.management.system.service.TranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transcation/apis")
public class TranscationController {

    @Autowired
    TranscationService transcationService;

    @PostMapping("/save")
    public String saveTranscation(@RequestBody TranscationRequestDto transcationRequestDto){

        String response=transcationService.saveTranscation(transcationRequestDto);
        return response;
    }


    @GetMapping("/find/{id}")
    public Transcation findById(@PathVariable int id){
        return transcationService.getTranscationById(id);
    }

    @GetMapping("/findAll")
    public List<Transcation> findAll(){
        return transcationService.getAllTranscations();
    }

    @GetMapping("/findAllByPage")
    public List<Transcation> findAllByPage(
            @RequestParam int pageNo,
            @RequestParam int pageSize){
        return transcationService.getTranscationsByPagination(pageNo, pageSize);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return transcationService.deleteTranscationById(id);
    }

    @PutMapping("/update/{id}")
    public String updateTranscation(
            @PathVariable int id,
            @RequestBody TranscationRequestDto transcationRequestDto){
        return transcationService.updateTranscation(id, transcationRequestDto);
    }
}
