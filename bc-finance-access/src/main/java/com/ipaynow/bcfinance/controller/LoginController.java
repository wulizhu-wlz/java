package com.ipaynow.bcfinance.controller;

import com.alibaba.fastjson.JSONObject;

import com.ipaynow.bcfinance.domain.Login;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.LoginService;
import com.ipaynow.bcfinance.utils.Head;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ipaynow0407 on 2017/12/4.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;


    @RequestMapping("login.do")
    @ResponseBody
    public String login(String userName, String pwd) {

        JSONObject resp = new JSONObject();
        try {
            if (StringUtils.isBlank(userName) || StringUtils.isBlank(pwd)) {
                throw new BusinessException(ExceptionEnum.USERNAME_OR_PASSWORD_NULL);
            }
            Login login = loginService.getByNameAndPassword(userName.trim(), pwd.trim());
            if (null == login) {
                throw new BusinessException(ExceptionEnum.USERNAME_OR_PASSWORD_NULL);
            }
            if (login.getStatus() == 0) {
                throw new BusinessException(ExceptionEnum.FROZEN);
            }
            Head head = new Head();
            head.setRd("0");
            head.setRm("成功");
            JSONObject body = new JSONObject();
            body.put("userName", login.getName());

            resp.put("head", head);
            resp.put("body", body);
            return resp.toJSONString();
        } catch (BusinessException e) {
            Head head = new Head();
            head.setRd("1");
            head.setRm(e.getDesc());
            resp.put("head", head);
        } catch (Exception e) {
            Head head = new Head();
            head.setRd("1");
            head.setRm("系统异常");
            resp.put("head", head);
        }
        return resp.toJSONString();
    }
}
