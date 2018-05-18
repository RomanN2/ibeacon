package com.example.user.myapp.Fragments;

import android.app.Fragment;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.myapp.R;

public class DevTeamFragment extends Fragment {

    private PackageInfo mPackageInfo;
    private TextView mAppVersionText;
    private TextView mDevelopersListText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dev_team_fragment, container, false);
        mAppVersionText = view.findViewById(R.id.mAppVersionText);
        mDevelopersListText = view.findViewById(R.id.mDevelopersListText);
        setupDevelopersListText(mDevelopersListText);
        setupVersionText(mAppVersionText);
        return view;
    }

    private void setupDevelopersListText(TextView developersListText) {
        developersListText.setSelected(true);
        developersListText.setMovementMethod(new ScrollingMovementMethod());
    }

    private void setupVersionText(TextView appVersionText) {
        try {
            mPackageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String appVersion = mPackageInfo.versionName;
        appVersionText.setText(String.format("Version %s", appVersion));
    }
}
