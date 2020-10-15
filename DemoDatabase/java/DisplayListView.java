package com.example.application.demodatabase;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
    @Override
    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display_listview_layout);
        contactAdapter = new ContactAdapter(this, R.layout.row_layout);
        listView = (ListView)findViewById(R.id.listview);
        listview.setAdapter(contactAdapter);

        JSON_STRING = getIntent().getExtras().getString('json_data');
        String name, email, contact, passowrd;

        try{
           jsonObject=new JSONObject(JSON_STRING);
           int count=0;
           jsonArray = jsonObject.getJSONArray("server_response");

           while(count < jsonArray.length()){
               JSONObject JO = jsonArray.getJSONObject(i);
              name = JO.getString("name");
              email = JO.getString("email");
              contact = JO.getString("contact");
              password = JO.getString("password");

              Contacts contacts = new Contacts(name, email, contact, password); 
              contactAdapter.add(contacts);
              counter++;
           }
        }catch(JSONException e){
            e.printStackTrace()
        }
        
    }
}