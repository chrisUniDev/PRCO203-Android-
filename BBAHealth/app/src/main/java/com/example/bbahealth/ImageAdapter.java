package com.example.bbahealth;

import android.content.Context;
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
        ImageView imageView = new ImageView(context);

        imageView.setLayoutParams(new GridView.LayoutParams(1250, 1250));
        imageView.setPadding(8, 26, 8, 0);

        imageView.setImageResource(ThumbIds[position]);
        return imageView;
    }

    private Integer[] ThumbIds = {
            R.drawable.ic_card_image_one,
            R.drawable.ic_card_image_two,
            R.drawable.ic_card_image_three,
            R.drawable.ic_card_image_one,
            R.drawable.ic_card_image_two,
            R.drawable.ic_card_image_three,
            R.drawable.ic_card_image_one,
            R.drawable.ic_card_image_two,
            R.drawable.ic_card_image_three,
            R.drawable.ic_card_image_one,
            R.drawable.ic_card_image_two,
            R.drawable.ic_card_image_three
    };
}