package com.abc.validators;

import java.util.HashMap;
import java.util.Map;

import com.abc.model.UserModel;

public class UserValidator {

	public static Map<String, String> userValidator(UserModel user) {
		Map<String, String> map = new HashMap<String, String>();
		if (user.getUserName().equals("")) {
			map.put("firstName", "Error! ** first name could not be empty");
		}
		if (user.getPassword() == null) {
			map.put("type", "Error! ** type could not be empty");
		}
		// System.out.println(map.get("firstName"));
		return map;

	}
}
