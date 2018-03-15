package com.example.neo.myapplication.model;

/**
 * Created by Neo on 2018/3/15.
 */
public interface IUser {
	String getName();

	String getPasswd();

	int checkUserValidity(String name, String passwd);
}
