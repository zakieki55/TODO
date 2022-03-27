package com.example.todoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class list extends AppCompatActivity {

    String task,jenis,time;
    TextView uname;
    EditText etask, ejenis, etime;
    FloatingActionButton plus;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.menu.menu, menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.submit)
            task = etask.getText().toString();
        jenis = ejenis.getText().toString();
        time = etime.getText().toString();

        if (etask.getText().toString().length()==0){
            etask.setError("Task Diperlukan!!");
        }
        if (ejenis.getText().toString().length()==0){
            ejenis.setError("Jenis Task Diperlukan!!");
        }
        if (etime.getText().toString().length()==0){
            etime.setError("Time Task Diperlukan!!");
        }
        if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Isi semua data!!!", Toast.LENGTH_LONG);
            t.show();
        } else {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Berhasil", Toast.LENGTH_LONG);
            t.show();

            Bundle b = new Bundle();

            b.putString("a", task.trim());
            b.putString("b", jenis.trim());
            b.putString("c", time.trim());
            Intent i = new Intent(getApplicationContext(), data.class);
            i.putExtras(b);
            startActivity(i);
        }
        if (item.getItemId() == R.id.logout) {
            Intent l = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(l);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        etask = findViewById(R.id.inptask);
        ejenis = findViewById(R.id.jentask);
        etime = findViewById(R.id.timtask);
        uname = findViewById(R.id.username);
        plus = findViewById(R.id.btnplus);

        Bundle b = getIntent().getExtras();

        String usern = b.getString("data");
        uname.setText(usern);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = etask.getText().toString();
                jenis = ejenis.getText().toString();
                time = etime.getText().toString();

                if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()){
                    Snackbar.make(view, "Isi semua data!", Snackbar.LENGTH_SHORT).show();
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(), "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(getApplicationContext(),data.class);
                    Bundle b = new Bundle();

                    b.putString("a",task.trim());
                    b.putString("b",jenis.trim());
                    b.putString("c",time.trim());
                    i.putExtras(b);
                    startActivity(i);

                }
            }
        });


    }

}