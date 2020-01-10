package com.ipaynow.bcfinance.service.impl;

import com.ipaynow.bcfinance.dao.LoginMapper;
import com.ipaynow.bcfinance.domain.Login;
import com.ipaynow.bcfinance.domain.LoginExample;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.LoginService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by ipaynow0407 on 2017/12/4.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static Logger logger = LogManager.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login getByNameAndPassword(String name, String password) throws BusinessException {
        try {
            LoginExample loginExample = new LoginExample();
            loginExample.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
            List<Login> loginList = loginMapper.selectByExample(loginExample);
            if (null == loginList || loginList.size() <= 0) {
                return null;
            }
            return loginList.get(0);
        } catch (Exception e) {
            logger.error("getByNameAndPassword数据库异常 name:%s, password:%s  :%s", name, password, e.getMessage());
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }

    }
}
