package com.example.threefragmentactivity;




import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class OneFragment extends Fragment  {
	private OnClickAuthentication auth;
	private final static String TAG="OneFragment";
	
	public interface OnClickAuthentication {
		public void onClickAuthButton(int flag);
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d(TAG, "in onAttach");
		try {
			Log.d("connected", "in onAttach");
			auth = (OnClickAuthentication) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeadlineSelectedListener");
		}
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_one, container, false);
		Button button1 = (Button) view.findViewById(R.id.one);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				auth.onClickAuthButton(2);

			}
		});
		Button button2 = (Button) view.findViewById(R.id.two);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				auth.onClickAuthButton(3);

			}
		});

		return view;

	}

}
