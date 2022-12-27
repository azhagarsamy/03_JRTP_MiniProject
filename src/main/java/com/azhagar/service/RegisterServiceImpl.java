package com.azhagar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.entity.UserRegistration;
import com.azhagar.repo.IRegistrationRepository;
import com.azhagar.util.MailUtil;
import com.azhagar.util.PwdGenerator;

@Service
public class RegisterServiceImpl implements IRegisterService {

	@Autowired
	private IRegistrationRepository repo;

	@Autowired
	private PwdGenerator pwtgen;

	@Autowired
	private MailUtil mailutil;

	@Override
	public String isValdCrdntlAndActvt(String email, String password) {
		Optional<UserRegistration> user = repo.findByEmail(email);
		if (!user.isPresent()) {
			return "Invaild Credentials";
		} else if (user.get().getIsAccutActvd().equals("N")) {
			return "Your Account Is Locked";
		} else if (user.get().getPwd().equals(password)) {
			return "Welcome to Ashok It";
		}
		return null;
	}

	@Override
	public String isEmailExists(String email) {
		Optional<UserRegistration> opt = repo.findByEmail(email);
		if (opt.isPresent()) {
			return "Already registered the email";
		} else {
			return null;
		}
	}

	@Override
	public String saveUser(UserRegistration user) {
		user.setPwd(pwtgen.genearatePwd(6));
		user.setIsAccutActvd("N");
		UserRegistration save = repo.save(user);
		StringBuilder sb = new StringBuilder();
		sb.append("Hi".concat(save.getUFirstName().concat(" ").concat(save.getULastName().concat(",").concat("/n")
				.concat("Welcome to IES family, your registration is almost complete. Please unlock your account using below details.")
				.concat("/n").concat("Temporary Passsword :" + save.getPwd()))));
		mailutil.sendMail(save.getEmail(), sb.toString());
		return "Please check your email to unlock account";
	}

	@Override
	public String updateNewPwd(String email, String tmpPwd, String newPwd) {
		Optional<UserRegistration> user = repo.findByEmail(email);
		if (user.isPresent()) {
			if (user.get().getIsAccutActvd().equals("Y")) {
				return "Already account activated";
			} else if (!user.get().getPwd().equals(tmpPwd)) {
				return "Temporary password is wrong";
			} else {
				user.get().setPwd(newPwd);
				user.get().setIsAccutActvd("Y");
				repo.save(user.get());
				return "Account unlocked, please proceed with login";
			}
		} else {
			return "Email not registered";
		}

	}

	@Override
	public String sendForgotPwd(String email) {
		Optional<UserRegistration> user = repo.findByEmail(email);
		if (user.isPresent()) {
			if (user.get().getIsAccutActvd() == "Y") {
				StringBuilder sb = new StringBuilder();
				sb.append("Hi".concat(user.get().getUFirstName().concat(" ").concat(user.get().getULastName()
						.concat(",").concat("/n").concat("your password is" + user.get().getPwd()))));
				mailutil.sendMail(user.get().getEmail(), sb.toString());
				return "Password has sent in your mail Id";
			} else {
				return "Your Account not activated";
			}

		} else {
			return "Email not registered";
		}
	}

}
