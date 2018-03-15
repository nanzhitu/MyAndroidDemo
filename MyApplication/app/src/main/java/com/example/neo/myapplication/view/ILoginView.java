package com.example.neo.myapplication.view;

/**
 * Created by Neo on 2018/3/15.
 */
public interface ILoginView {
	public void onClearText();
	public void onLoginResult(Boolean result, int code);
	public void onSetProgressBarVisibility(int visibility);
}
