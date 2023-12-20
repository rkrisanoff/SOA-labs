package com.example.additional.service.impl;

import com.example.additional.DTO.CountExpelledDTO;
import com.example.additional.DTO.ErrorDTO;
import com.example.additional.DTO.StudyGroupBase;
import com.example.additional.exception.ServerNotAvailable;
import com.example.additional.exception.UnrealMeaningException;
import com.example.additional.feign.FirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl {
    private final FirstService firstService;

    public CountExpelledDTO getCountExpelledStudent()  {
        try {
        List<StudyGroupBase> allGroup=firstService.getALLGroup();
        Long countExpellStudent=allGroup.stream().map(StudyGroupBase::getShouldBeExpelled).reduce(0,(x,y)->x+y).longValue();
        CountExpelledDTO countExpelledDTO = new CountExpelledDTO(countExpellStudent);
        checkValidCountExpelDTO(countExpelledDTO);
        return countExpelledDTO;
        }catch (Exception e){
            throw new ServerNotAvailable(new ErrorDTO("Сервер недоступен"));
        }
    }

    public CountExpelledDTO expelAllStudentsInGroup(Long groupId) {
        try {
            StudyGroupBase group=firstService.getGroupById(groupId);
            CountExpelledDTO countExpelledDTO=new CountExpelledDTO((long) group.getStudentsCount()-1L);
            int fuck=Math.toIntExact(group.getStudentsCount()+group.getShouldBeExpelled()-1);
            if(fuck<=0){
                fuck=1;
            }
            group.setShouldBeExpelled(fuck);
            group.setStudentsCount(1L);
            firstService.saveGroup(groupId,group);
            return countExpelledDTO;
        }catch (Exception e){
            throw new ServerNotAvailable(new ErrorDTO("Сервер недоступен"));
        }

    }

    private boolean checkValidCountExpelDTO(CountExpelledDTO countExpelledDTO) {
        Optional.ofNullable(countExpelledDTO.getExpelledStudentCount())
                .filter(count -> count >= 0)
                .orElseThrow(() -> new UnrealMeaningException(String.valueOf(countExpelledDTO.getExpelledStudentCount())));

        return true;

    }

}
