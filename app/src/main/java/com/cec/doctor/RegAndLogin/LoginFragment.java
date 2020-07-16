package com.cec.doctor.RegAndLogin;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.cec.doctor.Main.MainActivity;
import com.cec.doctor.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    public Button button, button2 = null;
    Intent intent;
    EditText ed1, ed2;
    int counter = 3;
//    TextView tx1;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login,container,false);

        ed1 = rootView.findViewById(R.id.et_email);
        ed2= rootView.findViewById(R.id.et_password);
        button2 = rootView.findViewById(R.id.btn_flogin);

//        tx1 = rootView.findViewById(R.id.txtview3);
//        tx1.setVisibility(View.GONE);
        intent = new Intent(getActivity(),MainActivity.class);

        button = rootView.findViewById(R.id.btn_login);
//      for password log in
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                startActivity(intent);

                if ( ed1.getText().toString().equals("admin")&& ed2.getText().toString().equals("admin")){
                    Toast.makeText(getContext(),"Redirecting....",Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }else {
                    Toast.makeText(getContext(),"wrong credentials",Toast.LENGTH_SHORT).show();

                    counter--;
                    if (counter == 0){
                        button.setEnabled(false);
                    }
                }
            }
        });

//        for biometric login

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"not supported yet",Toast.LENGTH_SHORT).show();
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

}
