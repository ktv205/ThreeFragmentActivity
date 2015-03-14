package com.example.threefragmentactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TwoFragment extends Fragment {
	private LoginInterface loginInterface;
	private final String TAG = "TwoFragment";

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		Log.d(TAG, "in onAttach");
		try {
			Log.d("connected", "in onAttach");
			loginInterface = (LoginInterface) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeadlineSelectedListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_two, container, false);
		Button button3 = (Button) view.findViewById(R.id.three);
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				loginInterface.switchToSignup();

			}
		});
		return view;
	}

	public interface LoginInterface {
		public void switchToSignup();
	}

}
