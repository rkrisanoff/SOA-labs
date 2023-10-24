package com.example.additional.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "first-service", url = "https://localhost:61221")
public interface FirstService {
    String URL_GET_EXPEL_ALL_STUDENT_IN_GROUP = "/group/{group-id}/expel-all";
    String URL_GET_COUNT_EXPEL_STUDENT_IN_GROUP = "/statistics/count-expelled";

    @GetMapping(URL_GET_COUNT_EXPEL_STUDENT_IN_GROUP)
    Long getExpelCountAllStudent();

    @GetMapping(URL_GET_EXPEL_ALL_STUDENT_IN_GROUP)
    Long ExpelStudentInGroup(@PathVariable Long groupId);
}
