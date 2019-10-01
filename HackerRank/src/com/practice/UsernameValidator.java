package com.practice;
/**
 * 
 * @author nabin
 * @apiNote
 * The username consists of 8 to 30 characters inclusive
 * The username can only contain alphanumeric characters and underscores(_).
 * The first character of the username must be an alphabetic character i.e. either lowercase character[a-z] or
 * uppercase character[A-Z]
 */
public class UsernameValidator {

	public final String regularExpressions = "^([a-zA-Z][\\w] {7, 29})$";
}
