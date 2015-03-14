package com.example.threefragmentactivity;

import com.example.threefragmentactivity.OneFragment.OnClickAuthentication;
import com.example.threefragmentactivity.TwoFragment.LoginInterface;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements OnClickAuthentication,
		LoginInterface, SignupInterface {

	FragmentManager fragmentManager;
	FragmentTransaction fragmentTransaction;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fragmentManager = getFragmentManager();
		Fragment fragment = fragmentManager.findFragmentByTag("one");
		if (fragment == null) {
			fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction
					.replace(R.id.relative, new OneFragment(), "one");
			fragmentTransaction.commit();
		}
	}

	@Override
	public void onClickAuthButton(int flag) {
		if (flag == 2) {
			fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction
					.replace(R.id.relative, new TwoFragment(), "two");
			fragmentTransaction.commit();
		} else {
			fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.replace(R.id.relative, new ThreeFragment(),
					"three");
			fragmentTransaction.commit();

		}

	}

	@Override
	public void switchToSignup() {
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction
				.replace(R.id.relative, new ThreeFragment(), "three");
		fragmentTransaction.commit();

	}

	@Override
	public void switchToLogin() {
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.relative, new TwoFragment(), "two");
		fragmentTransaction.commit();

	}

	@Override
	public void onBackPressed() {
		Fragment twoFragment = fragmentManager.findFragmentByTag("two");
		Fragment threeFragment = fragmentManager.findFragmentByTag("three");
		if ((twoFragment != null && twoFragment.isVisible())
				|| (threeFragment != null && threeFragment.isVisible())) {
			fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction
					.replace(R.id.relative, new OneFragment(), "one");
			fragmentTransaction.commit();
		} else {
			super.onBackPressed();
		}
	}

}
