package com.example.vijaygarg.deldata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import a.R;

public class ChangeStore extends AppCompatActivity {
EditText  uid,store;

    DatabaseReference db;
Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_store);
        db= FirebaseDatabase.getInstance().getReference().child("otheruserdetails");
        uid=findViewById(R.id.uid);
        store=findViewById(R.id.store);
        update=findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference mydb=db.child(uid.getText().toString()).child("store");
                mydb.setValue(store.getText().toString());

            }
        });


    }
}
