package com.iteams.stepper;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private UserRegistration modelInstance; //calling main class
    private ModelProvider provider; //calling provider Interface
    private email uEmail;   //calling required object class
    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Connecting fragment with activity
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            provider = (ModelProvider) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentToActivity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);
        modelInstance=provider.getInstance();
        uEmail=modelInstance.userEmail;
        int id;
        final EditText email=(EditText) view.findViewById(R.id.email);

        final Button b= view.findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setting value to different class
                uEmail.useremail=email.getText().toString();
            }
        });
        return view;
    }

}
