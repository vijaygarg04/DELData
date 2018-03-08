package com.example.vijaygarg.deldata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import a.R;

public class CreateUser extends AppCompatActivity {
EditText username,userid,store,number;
Button createaccount;
DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        db= FirebaseDatabase.getInstance().getReference().child("otheruserdetails");
        username=findViewById(R.id.uname);
        userid=findViewById(R.id.uid);
        store=findViewById(R.id.store);
        number=findViewById(R.id.number);
        createaccount=findViewById(R.id.createaccount);
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname=username.getText().toString();
                String sid=userid.getText().toString();
                String sstore=store.getText().toString();
                String snum=number.getText().toString();
                UserDetails ud=new UserDetails(sid,sname,snum,sstore);
                DatabaseReference mydb=db.child(sid);
                mydb.setValue(ud);

            }
        });


    }
}
