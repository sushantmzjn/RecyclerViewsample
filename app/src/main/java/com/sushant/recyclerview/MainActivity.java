package com.sushant.recyclerview;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.sushant.recyclerview.adapter.AdapterView;
import com.sushant.recyclerview.model.DetailsClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txname, txage;
    RadioButton rbf, rbm;
    RadioGroup radioGroup;
    Spinner spinnerimg;
    RecyclerView viewR;
    Button btnsave;
    String gender, name, age;
    int imageposition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txname = findViewById(R.id.txtname);
        txage = findViewById(R.id.txtage);
        rbf = findViewById(R.id.rbf);
        rbm = findViewById(R.id.rbm);
        spinnerimg = findViewById(R.id.spinimg);
        viewR = findViewById(R.id.recycleV);
        btnsave = findViewById(R.id.btnsave);
        radioGroup = findViewById(R.id.genderG);
        final List<DetailsClass> detailsClasses = new ArrayList<>();
        final int[] title = {
                (R.drawable.ariana),
                (R.drawable.bird),
                (R.drawable.bottle),
                (R.drawable.minions),
                (R.drawable.rose),
                (R.drawable.smile),

        };
        final String[] titlenaME = {"",
                "ariana",
                "bird",
                "bottle",
                "minions",
                "rose",
                "smile",


        };
        ArrayAdapter<String> imgtitle = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, titlenaME);
        spinnerimg.setAdapter(imgtitle);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txname.getText().toString().isEmpty()) {

                    name = txname.getText().toString();

                    try {
                        int selectid = radioGroup.getCheckedRadioButtonId();
                        RadioButton radioButton = findViewById(selectid);
                        gender = radioButton.getText().toString();
                        if(!txage.getText().toString().isEmpty()) {
                            age = (txage.getText().toString());
                            int position = (spinnerimg.getSelectedItemPosition());
                            if (position!=0){
                                imageposition = title[position-1];
                                detailsClasses.add(new DetailsClass(name, age, gender, imageposition));
                                AdapterView adapterView = new AdapterView(MainActivity.this, detailsClasses);
                                viewR.setAdapter(adapterView);
                                viewR.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            } else {
                                Toast.makeText(MainActivity.this, "Please select images", Toast.LENGTH_SHORT).show();

                            }
                        } else{
                            Toast.makeText(MainActivity.this, "Please enter age", Toast.LENGTH_SHORT).show();

                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();

                }




            }
        });


    }


}
