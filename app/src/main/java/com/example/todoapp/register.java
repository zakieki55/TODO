package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class register extends AppCompatActivity {

    String nama, email, password, repassword;
    EditText inpNama, inpEmail, inpPass, inpRepass;
    Button breg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        inpNama = findViewById(R.id.unama);
        inpEmail = findViewById(R.id.uemail);
        inpPass = findViewById(R.id.upswrd);
        inpRepass = findViewById(R.id.urpswrd);
        breg = findViewById(R.id.bregs);

        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = inpNama.getText().toString();
                email = inpEmail.getText().toString();
                password = inpPass.getText().toString();
                repassword = inpRepass.getText().toString();

                if(nama.isEmpty() || email.isEmpty() || password.isEmpty() || repassword.isEmpty()){
                    inpNama.setError("Masukkan Nama!");
                    inpEmail.setError("Masukkan Email!");
                    inpPass.setError("Masukkan Password!");
                    inpRepass.setError("Masukkan Repassword!");
                }
                else {
                    if(password == repassword){
                        Toast t = Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil",
                        Toast.LENGTH_SHORT);
                        t.show();

                        Intent i = new Intent(getApplicationContext(),list.class);
                        Bundle data = new Bundle();
                        data.putString("data", nama.trim());
                        i.putExtras(data);
                        startActivity(i);
                    }
                    else{
                        Snackbar.make(view, "Password dan Re-Password harus sama!",
                                Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}