package com.example.bbahealth;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.TELEPHONY_SERVICE;

public class SupportFragment extends Fragment {

    View view;

    String[] TO = {"pals@tst.nhs.uk"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_support, container, false);

        TextView phone = (TextView) view.findViewById(R.id.textViewTele);
        TextView email = (TextView) view.findViewById(R.id.textViewEmail);
        ImageButton NHSSupport = (ImageButton) view.findViewById(R.id.imageButtonNHSTwo);
        ImageButton BeaconSupport = (ImageButton) view.findViewById(R.id.imageButtonNHSOne);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01823344202"));
                startActivity(intent);

                //Toast.makeText(getActivity().getApplicationContext(), "Calling" ,Toast.LENGTH_LONG).show();
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");

                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    getActivity().onBackPressed();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity().getApplicationContext(), "No Email Client" ,Toast.LENGTH_LONG).show();
                }

                //Toast.makeText(getActivity().getApplicationContext(), "Emailing" ,Toast.LENGTH_LONG).show();
            }
        });

        NHSSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.tsft.nhs.uk/"));
                startActivity(intent);

                //Toast.makeText(getActivity().getApplicationContext(), "Website" ,Toast.LENGTH_LONG).show();
            }
        });

        BeaconSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws IllegalArgumentException,
                    SecurityException, IllegalStateException {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.tsft.nhs.uk/wards-and-departments/wards/beacon/"));
                startActivity(intent);

                //Toast.makeText(getActivity().getApplicationContext(), "Website" ,Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
