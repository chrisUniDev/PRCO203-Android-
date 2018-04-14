package com.example.bbahealth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class InitialThree extends Fragment {

    View view;

    public InitialThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_initial_three, container, false);

        Button buttonClose = (Button) view.findViewById(R.id.buttonClose);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                getActivity().finish();

                MainActivity mainActivity = new MainActivity();
                mainActivity.firstTime = true;

                Toast.makeText(getActivity().getApplicationContext(), "Initialization Closed" ,Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
