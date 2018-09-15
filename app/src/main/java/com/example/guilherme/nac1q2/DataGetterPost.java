package com.example.guilherme.nac1q2;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetterPost extends AsyncTask<String,Void,String> {


    private TextView txtMensagem;

    public DataGetterPost(TextView txtMensagem) {
        this.txtMensagem = txtMensagem;
    }

    @Override
    protected String doInBackground(String... strings) {

        return NetworkToolkit.doPost(strings[0],strings[1]);
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            JSONObject jsonResponse = new JSONObject(s);

            String id = jsonResponse.getString("id");
            //String createdAt = jsonResponse.getString("createdAt");

            txtMensagem.setText("Sucesso! ID: "+id);
        }
        catch(JSONException e){
            this.txtMensagem.setText("erroJSON");
        }
    }
}