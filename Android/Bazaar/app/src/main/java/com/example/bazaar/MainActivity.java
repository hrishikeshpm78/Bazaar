package com.example.bazaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button signInButton;
    private Button signUpButton;
    private EditText userName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton=(Button) findViewById(R.id.signUpBtn);
        signUpButton=(Button) findViewById(R.id.signInBtn);
        userName=(EditText) findViewById(R.id.userName);
        password=(EditText) findViewById(R.id.password);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser(userName.toString(),password.toString());
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Home.class);
                startActivity(intent);
            }
        });
    }

    private void signInUser(String toString, String toString1) {
        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}
