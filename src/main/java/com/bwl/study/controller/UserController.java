package com.bwl.study.controller;

import com.bwl.study.enums.ResultEnum;
import com.bwl.study.exception.Assertion;
import com.bwl.study.exception.BusinessException;
import com.bwl.study.model.dto.UserDTO;
import com.bwl.study.model.vo.ResponseResult;
import com.bwl.study.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
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
    public ResponseResult add(@Valid @RequestBody UserDTO userDTO) {

        if (userDTO.getUserId() > 1 && userDTO.getUserId() < 10) {
            int i = 1 / 0;
        } else if (userDTO.getUserId() > 10 && userDTO.getUserId() < 100) {
            throw new BusinessException(ResultEnum.UNKNOW_ERROR);
        } else if (userDTO.getUserId() > 100 && userDTO.getUserId() < 1000) {
            Assertion.isTrue(true, ResultEnum.REMOTE_INTERFACE_ERROR);
        } else if (userDTO.getUserId() > 1000 && userDTO.getUserId() < 10000) {
            ArrayList list = new ArrayList();
            while (true) {
                list.add(new UserController());
            }
        }

        userDTO.setUserId(Long.valueOf(1111111111));
        userDTO.setUserName("liz");
        userDTO.setCreatTime(new Date());
        return ResponseResult.ok(userDTO);
    }

    @PostMapping("/find")
    public ResponseResult find() {
        return ResponseResult.ok(userService.find());
    }
}
