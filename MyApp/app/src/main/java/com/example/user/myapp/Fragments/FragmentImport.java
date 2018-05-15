package com.example.user.myapp.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.myapp.BluetoothLowEnergyActivity;
import com.example.user.myapp.R;

public class FragmentImport extends Fragment {

    private Button mStartButton;

    private OnFragmentInteractionListener mListener;

    public FragmentImport() {
    }


    public static FragmentImport newInstance(String param1, String param2) {
        FragmentImport fragment = new FragmentImport();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initViews(View view) {
        mStartButton = view.findViewById(R.id.mStartButton);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), BluetoothLowEnergyActivity.class);
                getActivity().startActivity(myIntent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_import, container, false);
        initViews(view);
        return view;

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
