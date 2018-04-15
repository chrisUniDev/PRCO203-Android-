package com.example.bbahealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class BeaconCenterFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_beacon_center, container, false);

        ImageButton zoomBeacon = (ImageButton) view.findViewById(R.id.imageViewBeacon);

        zoomBeacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ZoomTwoActivity.class);
                startActivity(intent);

                //Toast.makeText(getActivity().getApplicationContext(), "Zoomed" ,Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}