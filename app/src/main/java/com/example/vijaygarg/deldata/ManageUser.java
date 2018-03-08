package com.example.vijaygarg.deldata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import a.R;

public class ManageUser extends AppCompatActivity {
Button create,delete,changestore,alluser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user);
        create=findViewById(R.id.btncreateuser);
        delete=findViewById(R.id.btndeleteuser);
        changestore=findViewById(R.id.btnchangestore);
        alluser=findViewById(R.id.btnviewalluser);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ManageUser.this,CreateUser.class));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          startActivity(new Intent(ManageUser.this,DeleteUser.class));
                                      }

        });
        changestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ManageUser.this,ChangeStore.class));
            }
        });
        alluser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
