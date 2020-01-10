package com.ipaynow.bcfinance.service;


import com.ipaynow.bcfinance.domain.Login;
import com.ipaynow.bcfinance.expcetion.BusinessException;

/**
 * Created by ipaynow0407 on 2017/12/4.
 */

public interface LoginService {

    Login getByNameAndPassword(String name, String password) throws BusinessException;
}
