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

public class ThreeFragment extends Fragment {
	private SignupInterface signupInterface;
	private final String TAG = "TwoFragment";

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		Log.d(TAG, "in onAttach");
		try {
			Log.d("connected", "in onAttach");
			signupInterface = (SignupInterface) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeadlineSelectedListener");
		}
	}
  @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	  View view = inflater.inflate(R.layout.fragment_three, container, false);
		Button button4 = (Button) view.findViewById(R.id.four);
		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
                signupInterface.switchToLogin();
			}
		});
		return view;
	}

}
