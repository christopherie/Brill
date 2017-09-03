package com.christophergovenderkubiec.brill;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by predator on 03/09/2017.
 */

public class Locations extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.toplocations, container, false);
        String[] items = {"Create a view", "Add adapter"};
        ListView listView = view.findViewById(R.id.listView2);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                items
        );
        listView.setAdapter(listViewAdapter);
        return view;
    }
}
