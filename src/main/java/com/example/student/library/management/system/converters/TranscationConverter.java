package com.example.student.library.management.system.converters;

import com.example.student.library.management.system.model.Transcation;
import com.example.student.library.management.system.requestdto.TranscationRequestDto;

public class TranscationConverter {

    public static Transcation converTransactionRequestDtoIntoTransaction(TranscationRequestDto transcationRequestDto) {

        Transcation transcation =new Transcation();

        transcation.setDueDate(transcationRequestDto.getDueDate());
        transcation.setTranscationType(transcationRequestDto.getTranscationType());

        return transcation;
    }
}
