package com.example.demo.util;

import java.util.Locale;

import org.springframework.context.MessageSource;

public class AppUtil {
	
	public static String getMessage(MessageSource messageSourse, String key, Object...params) {
		return messageSourse.getMessage(key,params,Locale.JAPAN);
	}
	
}
