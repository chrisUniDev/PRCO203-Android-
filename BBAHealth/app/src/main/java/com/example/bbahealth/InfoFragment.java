package com.example.bbahealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class InfoFragment extends Fragment {

    View view;
    public static int openTab = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_info, container, false);

        GridView gridView = view.findViewById(R.id.gridViewCards);

        gridView.setAdapter(new ImageAdapter(getActivity()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (MainActivity.infoViewOpen) {
                    Intent intent = new Intent(getActivity(), InfoOpenActivity.class);
                    startActivity(intent);
                    openTab = i;
                    //Toast.makeText(getActivity().getApplicationContext(), "Card: " + i, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public static int getOpenTab(){
        return openTab;
    }
}
