package com.example.guilherme.nac1q2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executaPost(View view){
        String url = "https://jsonplaceholder.typicode.com/posts";
        EditText txtUserId = findViewById(R.id.editTextUderId);
        EditText txtTitle = findViewById(R.id.editTextTitle);
        EditText txtBody = findViewById(R.id.editTextBody);
        TextView txtMensagem = findViewById(R.id.txtMensagem);

        String parameter =  "{\n" +
                "    \"userId\": "+txtUserId.getText().toString()+",\n" +
                "    \"title\": "+txtTitle.getText().toString()+",\n" +
                "    \"body\": "+txtBody.getText().toString()+"\n" +
                "}";
        new DataGetterPost(txtMensagem).execute(url,parameter);
    }
}