package com.example.vijaygarg.deldata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import a.R;

public class DeleteUser extends AppCompatActivity {
    EditText uid;
    Button removeuser,confirm;
    TextView show;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        uid=findViewById(R.id.uid);
        db= FirebaseDatabase.getInstance().getReference().child("otheruserdetails");
        removeuser=findViewById(R.id.removeuser);
        show=findViewById(R.id.showdata);
        confirm.findViewById(R.id.confirmdelete);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference mydb=db.child(uid.getText().toString());
                mydb.removeValue();
            }
        });
        removeuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference mydb=db.child(uid.getText().toString());
                mydb.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        UserDetails ud=dataSnapshot.getValue(UserDetails.class);
                        show.setText(ud.getUname());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
