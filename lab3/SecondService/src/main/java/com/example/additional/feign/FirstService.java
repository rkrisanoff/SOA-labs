package com.example.additional.feign;

import com.example.additional.DTO.StudyGroupBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "first-service", url = "http://localhost:27183/api")
public interface FirstService {
    String URL_GET_EXPEL_ALL_STUDENT_IN_GROUP = "/group/{group-id}/expel-all";
    String URL_GET_COUNT_EXPEL_STUDENT_IN_GROUP = "/statistics/count-expelled";
    String URL_GET_ALL_GROUP = "/study-groups";
    String URL_GET_GROUP = "/study-groups/{id}";
    String URL_PUT_GROUP = "/study-groups/{id}";

    @GetMapping(URL_GET_COUNT_EXPEL_STUDENT_IN_GROUP)
    Long getExpelCountAllStudent();

    @GetMapping(URL_GET_ALL_GROUP)
    List<StudyGroupBase> getALLGroup();
    @PutMapping(URL_PUT_GROUP)
    void saveGroup(@PathVariable Long id, @RequestBody StudyGroupBase studyGroupBase);
    @GetMapping(URL_GET_GROUP)
    StudyGroupBase getGroupById(@PathVariable Long id);
}
