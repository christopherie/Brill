package com.christophergovenderkubiec.brill;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by predator on 02/09/2017.
 */

public class Ideas extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ideastab, container, false);
        String[] items = {"1. Add an idea", "2. Add a location", "3. Take an inspirepic",
                "4. Find out where you have the most Brill ideas"};
        ListView listView = view.findViewById(R.id.listView);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                items
        );
        listView.setAdapter(listViewAdapter);
        return view;
    }
}
