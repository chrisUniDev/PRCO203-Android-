package com.example.bbahealth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class InitialTwo extends Fragment {

    boolean oneTicked = false;
    boolean twoTicked = false;

    public InitialTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // needs to be inflated first
        View view = inflater.inflate(R.layout.fragment_initial_two, container, false);
        String[] pathwayOptions = {
                "Palliative",
                "Radical"
        };
        ListView listView = (ListView) view.findViewById(R.id.listViewPathwayOptions);

        final ImageView tickOne = view.findViewById(R.id.imageViewTickOne);
        final ImageView tickTwo = view.findViewById(R.id.imageViewTickTwo);

        // figuring out what to draw on screen
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, pathwayOptions);

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    if(!oneTicked){
                        tickOne.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        oneTicked = true;
                    }else{
                        tickOne.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        oneTicked = false;
                    }
                }else if(position == 1){
                    if(!twoTicked){
                        tickTwo.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        twoTicked = true;
                    }else {
                        tickTwo.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        twoTicked = false;
                    }
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
