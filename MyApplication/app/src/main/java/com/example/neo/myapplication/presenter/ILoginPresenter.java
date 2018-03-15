package com.example.neo.myapplication.presenter;

/**
 * Created by Neo on 2018/3/15.
 */
public interface ILoginPresenter {
	void clear();
	void doLogin(String name, String passwd);
	void setProgressBarVisiblity(int visiblity);
}
