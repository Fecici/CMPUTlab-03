package com.example.listycitylab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EditCityFragment extends DialogFragment {

    public interface EditCityDialogListener {
        public void editCity(int position, String city, String province);
    }

    private EditCityDialogListener listener;
    private int position;

    public EditCityFragment(int position) {
        super();
        this.position = position;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof EditCityDialogListener) {
            listener = (EditCityDialogListener) context;
        }

        else {
            throw new RuntimeException(context + "must implement EditCityDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_add_city, null);


        EditText cityText = view.findViewById(R.id.edit_text_city_text);
        EditText provinceText = view.findViewById(R.id.edit_province_edit_text);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        return builder
                .setView(view)
                .setTitle("Edit a City")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Edit", (dialog, which) -> {
                    String cityName = cityText.getText().toString();
                    String provinceName = provinceText.getText().toString();

                    listener.editCity(position, cityName, provinceName);
                })
                .create();
    }
}
