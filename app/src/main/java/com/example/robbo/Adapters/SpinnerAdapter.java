package com.example.robbo.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Layer;

import com.example.robbo.Models.Image;
import com.example.robbo.R;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Image> {

    public SpinnerAdapter(@NonNull  Context context, int resource, ArrayList<Image> images, int text) {
        super(context, resource, text, images);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinnerelement, parent, false);
        byte[] buff = getItem(position).getImg();
        Drawable image = new BitmapDrawable(getContext().getResources(), BitmapFactory.decodeByteArray(buff, 0, buff.length));
        ((ImageView)convertView.findViewById(R.id.ImageSpinner)).setImageDrawable(image);
        return convertView;
    }
}
