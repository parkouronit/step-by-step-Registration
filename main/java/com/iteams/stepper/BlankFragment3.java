package com.iteams.stepper;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {

    private UserRegistration modelInstance;
    private ModelProvider provider;
    private verification uVerification;
    public BlankFragment3() {
        // Required empty public constructor
    }

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
        View view= inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        modelInstance=provider.getInstance();
        uVerification=modelInstance.userVerification;
        int id;
        final EditText code=(EditText) view.findViewById(R.id.vcode);
        final Button b= view.findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uVerification.vCode=code.getText().toString();
            }
        });
        return view;
    }

}
