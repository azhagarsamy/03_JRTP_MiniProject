package com.azhagar.service;

import com.azhagar.entity.UserRegistration;

public interface IRegisterService {

	String isValdCrdntlAndActvt(String email, String password);

	String isEmailExists(String email);

	String saveUser(UserRegistration user);

	String updateNewPwd(String email, String tmpPwd, String newPwd);

	String sendForgotPwd(String email);

}
