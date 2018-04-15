package com.example.bbahealth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class InitialThree extends Fragment {

    public InitialThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // needs to be inflated first
        View view = inflater.inflate(R.layout.fragment_initial_three, container, false);

        String[] cancerOptions = {"Bladder", "Breast", "Gynae", "Head & Neck", "Lower GI", "Prostate", "Skin", "Upper GI"};

        ListView listView = (ListView) view.findViewById(R.id.listViewCancerSelection);

        // figuring out what to draw on screen
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cancerOptions );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Toast.makeText(getActivity(), "You have chosen bladder cancer", Toast.LENGTH_SHORT).show();
                }
                else if (position == 1)
                {
                    Toast.makeText(getActivity(), "You have chosen breast cancer", Toast.LENGTH_SHORT).show();
                }
                else if (position == 2)
                {
                    Toast.makeText(getActivity(), "You have chosen gynae cancer", Toast.LENGTH_SHORT).show();
                }
                else if (position == 3)
                {
                    Toast.makeText(getActivity(), "You have chosen head & neck cancer", Toast.LENGTH_SHORT).show();
                }
                else if (position == 4)
                {
                    Toast.makeText(getActivity(), "You have chosen lower GI cancer", Toast.LENGTH_SHORT).show();
                }
                else if (position == 5)
                {
                    Toast.makeText(getActivity(), "You have chosen prostate cancer", Toast.LENGTH_SHORT).show();
                }
                else if (position == 6)
                {
                    Toast.makeText(getActivity(), "You have chosen skin cancer", Toast.LENGTH_SHORT).show();
                }
                else if (position == 7)
                {
                    Toast.makeText(getActivity(), "You have chosen upper GI cancer", Toast.LENGTH_SHORT).show();
                }
            }
        });



        // Inflate the layout for this fragment
        return view;



    }

}
