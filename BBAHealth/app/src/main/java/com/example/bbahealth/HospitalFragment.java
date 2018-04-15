package com.example.bbahealth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class HospitalFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hospital, container, false);

        TextView googleMaps = (TextView) view.findViewById(R.id.textViewHospitalMap);
        //ImageButton zoomHospital = (ImageButton) view.findViewById(R.id.imageViewHospital);

//        zoomHospital.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), ZoomOneActivity.class);
//                startActivity(intent);
//
//                //Toast.makeText(getActivity().getApplicationContext(), "Zoomed" ,Toast.LENGTH_LONG).show();
//            }
//        });


        googleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 51.011839, -3.119286);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);

                //Toast.makeText(getActivity().getApplicationContext(), "Calling" ,Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
