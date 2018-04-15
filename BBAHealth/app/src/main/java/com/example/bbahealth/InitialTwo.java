package com.example.bbahealth;


import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class InitialTwo extends Fragment {




    public InitialTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // needs to be inflated first
        View view = inflater.inflate(R.layout.fragment_initial_two, container, false);

        String[] pathwayOptions = {"Palliative", "Radical"};

        ListView listView = (ListView) view.findViewById(R.id.listViewPathwayOptions);

        // figuring out what to draw on screen
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, pathwayOptions );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Toast.makeText(getActivity(), "You have chosen Palliative pathway", Toast.LENGTH_SHORT).show();
                }
                else if (position == 1)
                {
                    Toast.makeText(getActivity(), "You have chosen Radical pathway", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Inflate the layout for this fragment
        return view;



    }



}
