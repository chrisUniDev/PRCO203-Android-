package com.example.bbahealth;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{

    private Context context;

    public ImageAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        return ThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(720, 875));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(20, 10, 20, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(ThumbIds[position]);
        return imageView;
    }

    private Integer[] ThumbIds = {
            R.drawable.ic_card_image_four,
            R.drawable.ic_card_image_seven,
            R.drawable.ic_card_image_six,
            R.drawable.ic_card_image_five
    };
}