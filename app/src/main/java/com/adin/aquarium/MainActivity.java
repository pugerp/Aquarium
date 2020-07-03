package com.adin.aquarium;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView tvTemp1, tvTemp2, tvpH1, tvpH2, tvState1, tvState2;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        initView();
        initFirebase();
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Model m = dataSnapshot.getValue(Model.class);
                if(m!=null){
                    updateUI(m);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };

        myRef.addValueEventListener(eventListener);
    }

    private void initFirebase() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("dataFuzzy");
    }

    private void initView() {
        tvTemp1 = findViewById(R.id.tv_temp_1);
        tvTemp2 = findViewById(R.id.tv_temp_2);
        tvpH1 = findViewById(R.id.tv_ph_1);
        tvpH2 = findViewById(R.id.tv_ph_2);
        tvState1 = findViewById(R.id.tv_state_1);
        tvState2 = findViewById(R.id.tv_state_2);
    }

    private void updateUI(Model model) {
        tvTemp1.setText(Math.round(model.getSuhu())+"\u00B0");
        tvTemp2.setText(Math.round(model.getSuhu())+"\u00B0");
        tvpH1.setText("Kadar pH "+model.getPh());
        tvpH2.setText(""+model.getPh());
        tvState1.setText("Status Air "+model.getStatus());
        tvState2.setText(model.getStatus().toUpperCase());
    }
}