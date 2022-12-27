package com.azhagar.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PwdGenerator {

	public String genearatePwd(int len) {
		String chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
		
		Random rnd=new Random();
		
		StringBuilder sb=new StringBuilder(len);
		
		for(int i=0;i<len;i++) {
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		}
		return sb.toString();
	}
}
