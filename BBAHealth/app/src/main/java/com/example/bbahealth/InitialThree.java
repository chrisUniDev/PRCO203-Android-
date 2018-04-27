package com.example.bbahealth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class InitialThree extends Fragment {

    View view;

    boolean oneTicked = false;
    boolean twoTicked = false;
    boolean threeTicked = false;
    boolean fourTicked = false;
    boolean fiveTicked = false;
    boolean sixTicked = false;
    boolean sevenTicked = false;
    boolean eightTicked = false;

    public InitialThree() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // needs to be inflated first
        view = inflater.inflate(R.layout.fragment_initial_three, container, false);

        String[] cancerOptions = {
                "Bladder",
                "Breast",
                "Gynae",
                "Head & Neck",
                "Lower GI",
                "Prostate",
                "Skin",
                "Upper GI"
        };

        Button buttonAccept = (Button) view.findViewById(R.id.buttonConfirm);

        ListView listView = (ListView) view.findViewById(R.id.listViewCancerSelection);

        final ImageView tickOne = view.findViewById(R.id.imageViewSelectionOne);
        final ImageView tickTwo = view.findViewById(R.id.imageViewSelectionTwo);
        final ImageView tickThree = view.findViewById(R.id.imageViewSelectionThree);
        final ImageView tickFour = view.findViewById(R.id.imageViewSelectionFour);
        final ImageView tickFive = view.findViewById(R.id.imageViewSelectionFive);
        final ImageView tickSix = view.findViewById(R.id.imageViewSelectionSix);
        final ImageView tickSeven = view.findViewById(R.id.imageViewSelectionSeven);
        final ImageView tickEight = view.findViewById(R.id.imageViewSelectionEight);

        // figuring out what to draw on screen
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cancerOptions );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    if (!oneTicked) {
                        tickOne.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        oneTicked = true;
                    } else {
                        tickOne.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        oneTicked = false;
                    }
                }
                if (position == 1) {
                    if (!twoTicked) {
                        tickTwo.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        twoTicked = true;
                    } else {
                        tickTwo.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        twoTicked = false;
                    }
                }
                if (position == 2) {
                    if (!threeTicked) {
                        tickThree.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        threeTicked = true;
                    } else {
                        tickThree.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        threeTicked = false;
                    }
                }
                if (position == 3) {
                    if (!fourTicked) {
                        tickFour.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        fourTicked = true;
                    } else {
                        tickFour.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        fourTicked = false;
                    }
                }
                if (position == 4) {
                        if (!fiveTicked) {
                            tickFive.setBackgroundResource(R.drawable.ic_check_black_24dp);
                            fiveTicked = true;
                        } else {
                            tickFive.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                            fiveTicked = false;
                        }
                    }
                if (position == 5) {
                    if (!sixTicked) {
                        tickSix.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        sixTicked = true;
                    } else {
                        tickSix.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        sixTicked = false;
                    }
                }
                if (position == 6) {
                    if (!sevenTicked) {
                        tickSeven.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        sevenTicked = true;
                    } else {
                        tickSeven.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        sevenTicked = false;
                    }
                }
                if (position == 7) {
                    if (!eightTicked) {
                        tickEight.setBackgroundResource(R.drawable.ic_check_black_24dp);
                        eightTicked = true;
                    } else {
                        tickEight.setBackgroundResource(R.drawable.ic_check_box_outline_blank_black_24dp);
                        eightTicked = false;
                    }
                }
            }
        });

        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();

                MainActivity.firstTime = true;

                //Toast.makeText(getActivity().getApplicationContext(), "Initialization Closed" ,Toast.LENGTH_LONG).show();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}