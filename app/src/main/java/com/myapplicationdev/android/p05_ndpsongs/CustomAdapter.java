package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id; //layout id
    ArrayList<Song> songList;  //pass in the data and store it

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {     //getView() calls for every item in the listview
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvStar = rowView.findViewById(R.id.textViewStar);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);
        ImageView ivNew = rowView.findViewById(R.id.imageView2);
        RatingBar rb = rowView.findViewById(R.id.ratingBar);

        // Obtain the Android Version information based on the position
        Song currentList = songList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentList.getTitle());
        tvYear.setText(currentList.getYearReleased() + "");
        tvStar.setText(currentList.getStars() + "");
        tvSinger.setText(currentList.getSingers());
        rb.setRating(currentList.getStars());

        if (currentList.getYearReleased() >= 2019) {
            ivNew.setImageResource(R.drawable.newSong);
        } else {
            ivNew.setVisibility(View.INVISIBLE);
        }

        rb.setRating(currentList.getRating());

        return rowView;
    }
}