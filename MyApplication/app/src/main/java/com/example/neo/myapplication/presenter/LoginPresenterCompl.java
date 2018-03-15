package com.example.neo.myapplication.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.neo.myapplication.model.IUser;
import com.example.neo.myapplication.model.UserModel;
import com.example.neo.myapplication.view.ILoginView;

/**
 * Created by Neo on 2018/3/15.
 */
public class LoginPresenterCompl implements ILoginPresenter {
	ILoginView iLoginView;
	IUser user;
	Handler    mhandler;

	public LoginPresenterCompl(ILoginView iLoginView,Handler handler) {
		this.iLoginView = iLoginView;
		initUser();
		mhandler = handler;
	}

	@Override
	public void clear() {
		iLoginView.onClearText();
	}

	@Override
	public void doLogin(String name, String passwd) {
		Boolean isLoginSuccess = true;
		final int code = user.checkUserValidity(name,passwd);
		if (code!=0) isLoginSuccess = false;
		final Boolean result = isLoginSuccess;
		mhandler.postDelayed(new Runnable() {
			@Override
			public void run() {
					iLoginView.onLoginResult(result, code);
			}
		}, 5000);

	}



	@Override
	public void setProgressBarVisiblity(int visiblity){
		iLoginView.onSetProgressBarVisibility(visiblity);
	}


	private void initUser(){
		user = new UserModel("mvp","mvp");
	}
}
