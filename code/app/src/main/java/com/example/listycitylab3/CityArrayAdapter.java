package com.example.listycitylab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City>  {

    public CityArrayAdapter(Context context, ArrayList<City> cites) {

        super(context, 0, cites);  // 0 indicates the layout file, means we'll do it later
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        if (convertView == null) {  // convert view is a reused view, to save resources
            // create new view using layout inflater if no recyclable view available
            view = LayoutInflater.from(getContext()).inflate(R.layout.content, parent, false);
        }
        else {
            // just reuse the garbage view
            view = convertView;
        }

        // found city
        City city = getItem(position);

        // found attr
        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById((R.id.province_text));

        // set texts
        cityName.setText(city.getName());
        provinceName.setText(city.getProvince());

        return view;
    }
}
