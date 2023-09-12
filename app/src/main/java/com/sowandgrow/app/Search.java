package com.sowandgrow.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Search extends Fragment {

    private String param1;
    private String param2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            param1 = arguments.getString(ARG_PARAM1);
            param2 = arguments.getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Find the EditText
        EditText nameEditText = view.findViewById(R.id.searchBox);
        nameEditText.setKeyListener(null);

        // Set up the click listener for EditText
        nameEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to DiscoverPlant
                Intent intent = new Intent(getActivity(), DiscoverPlant.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int CAMERA_PERMISSION_REQUEST = 1001;
}
