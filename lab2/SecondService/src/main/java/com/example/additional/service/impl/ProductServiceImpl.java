package com.example.additional.service.impl;

import com.example.additional.DTO.CountExpelledDTO;
import com.example.additional.exception.UnrealMeaningException;
import com.example.additional.feign.FirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl {
    private final FirstService firstService;

    public CountExpelledDTO getCountAllStudent() {
        CountExpelledDTO countExpelledDTO = new CountExpelledDTO(firstService.getExpelCountAllStudent());
        checkValidCountExpelDTO(countExpelledDTO);
        return countExpelledDTO;
    }

    public CountExpelledDTO expelAllStudentsInGroup(Long groupId) {
        CountExpelledDTO countExpelledDTO = new CountExpelledDTO(firstService.ExpelStudentInGroup(groupId));
        checkValidCountExpelDTO(countExpelledDTO);
        return countExpelledDTO;
    }

    private boolean checkValidCountExpelDTO(CountExpelledDTO countExpelledDTO) {
        Optional.ofNullable(countExpelledDTO.getCount())
                .filter(count -> count >= 0)
                .orElseThrow(() -> new UnrealMeaningException(String.valueOf(countExpelledDTO.getCount())));

        return true;

    }

}
