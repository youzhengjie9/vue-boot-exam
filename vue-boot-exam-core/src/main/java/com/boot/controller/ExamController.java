package com.boot.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Api("考试接口")
@RequestMapping("/exam")
public class ExamController {

    @GetMapping(path = "/getQuestion")
    public String getQuestion()
    {

        return "666777";
    }

}
