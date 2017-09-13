package com.christophergovenderkubiec.brill;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by predator on 02/09/2017.
 */
// public class Profile extends Fragment
public class Profile extends Fragment  {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profiletab, container, false);
        TextView ideaCount = view.findViewById(R.id.textView3);
        TextView userLevel = view.findViewById(R.id.textView5);
        userLevel.setText("Beginner");
        ideaCount.setText("45");
        return view;
    }
}


