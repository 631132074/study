package com.bwl.study.controller;

import com.bwl.study.model.dto.UserDTO;
import com.bwl.study.model.vo.ResponseResult;
import com.bwl.study.model.vo.SysRequest;
import com.bwl.study.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;


/**
 * @author BW Li
 * @date 2020-05-21 13:04
 * @description
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/add")
    public ResponseResult add(@Valid @RequestBody UserDTO request){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(Long.valueOf(1111111111));
        userDTO.setUserName("liz");
        userDTO.setCreatTime(new Date());
        return ResponseResult.ok(userDTO);
    }

    @PostMapping("/find")
    public ResponseResult find(){
        return ResponseResult.ok(userService.find());
    }
}
