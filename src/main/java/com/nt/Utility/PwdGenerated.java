package com.nt.Utility;

import org.apache.commons.lang3.RandomStringUtils;

import com.nt.Constant.AppConstant;

public class PwdGenerated {

	@SuppressWarnings("deprecation")
	public static String pwdGenerator() {
		String str=RandomStringUtils.random(12,AppConstant.RANDOM_LETTERS);
		return str;
	}
}
