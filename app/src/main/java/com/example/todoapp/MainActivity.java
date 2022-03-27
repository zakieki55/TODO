package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name, pass;
    EditText uname, upass;
    Button blog, breg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.usname);
        upass = findViewById(R.id.uspass);
        blog = findViewById(R.id.btnlog);
        breg = findViewById(R.id.btnreg);

        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent(getApplicationContext(), register.class);
                startActivity(reg);
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = uname.getText().toString();
                pass = upass.getText().toString();

                String nama = "Dzaki";
                String password ="eki";
//

                if(name.isEmpty()|| pass.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password anda wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    if(nama.equals(nama) && password.equals(password)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);

                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());

                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), list.class);

                        i.putExtras(b);

                        startActivity(i);
                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login gagal", Toast.LENGTH_LONG);

                        t.show();
                    }
                }
            }
        });
    }
}