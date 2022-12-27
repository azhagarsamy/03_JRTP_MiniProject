package com.azhagar.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.azhagar.entity.UserRegistration;
import com.azhagar.service.ICityService;
import com.azhagar.service.ICountryService;
import com.azhagar.service.IRegisterService;
import com.azhagar.service.IStateService;
import com.azhagar.util.MailUtil;
import com.azhagar.util.PwdGenerator;

@Component
public class QueryExecutorRunner implements ApplicationRunner {

	@Autowired
	private ICountryService countryService;

	@Autowired
	private IStateService stateService;

	@Autowired
	private ICityService cityService;

	@Autowired
	private IRegisterService registerService;

	@Autowired
	private PwdGenerator pwd;

	@Autowired
	private MailUtil mail;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		String valdCrdntlAndActvt = registerService.isValdCrdntlAndActvt("azhagarsa@gmail.com", "Abc#@34");

		if (valdCrdntlAndActvt.equals("Invaild Credentials")) {

			UserRegistration user = new UserRegistration();
			user.setUFirstName("Sanjay");
			user.setULastName("Azhagarsamy");
			user.setCityId(1);
			user.setDob(java.sql.Date.valueOf(LocalDate.of(1984, 10, 21)));
			user.setEmail("azhagarsa@gmail.com");
			user.setGender("Male");
			user.setPhNo(7845314240L);
			user.setIsAccutActvd("N");
			user.setPwd(pwd.genearatePwd(8));
			String saveUser = registerService.saveUser(user);
			System.out.println(saveUser);
			mail.sendMail(user.getEmail(), user.getPwd());

		} else if (valdCrdntlAndActvt.equals("Your Account Is Locked")) {
			String updateNewPwd = registerService.updateNewPwd("azhagarsa@gmail.com", "Is2xMc", "Jairam@84");
			System.out.println(updateNewPwd);
		}

//		Country c1 =new Country();
//		c1.setCountryId(1);
//		c1.setCountryName("India");
//		
//		State c2 =new State();
//		c2.setStateId(7);
//		c2.setStateName("TamilNadu");
//		
//		countryService.getCountries().forEach(d->System.out.println(d));
//		stateService.getStates(c1).forEach(d->System.out.println(d));
//		cityService.getCities(c2).forEach(d->System.out.println(d));		

	}

}
