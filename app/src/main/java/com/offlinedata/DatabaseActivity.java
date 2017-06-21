package com.offlinedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.offlinedata.Resonse.ListResoponse;
import com.offlinedata.Resonse.MainResponse;
import com.offlinedata.WebServices.ApiHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DatabaseActivity extends AppCompatActivity {

    ListView lv;
    TextView txt_delete,txt_update;
    List<Contact> listResoponses;
    DataBaseListAdapter listAdapter;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        idMapping();
        db = new DatabaseHandler(this);

        setDatabaseList();
        setOnclick();
    }

    private void setDatabaseList() {

        List<Contact> contacts = db.getAllContacts();
        for (int i = 0; i < contacts.size(); i++) {
            Log.e("AllData", String.valueOf(contacts));
        }

        listAdapter = new DataBaseListAdapter(DatabaseActivity.this, contacts);
        lv.setAdapter(listAdapter);


    }


    private void idMapping() {
        lv = (ListView) findViewById(R.id.lv);
        txt_delete = (TextView) findViewById(R.id.txt_next);
        txt_update= (TextView) findViewById(R.id.txt_update);
    }

    private void setOnclick() {

        txt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() ;
                    // Writing Contacts to log
                    Log.e("Name: ", log);


                    if(cn.getName().equalsIgnoreCase("rahil")){


                        db.deleteContact(cn);


                        Log.e("record ","yes");



                    }
                    else{

                        Log.e("record ","not");
                        Log.e("record Data ",""+cn.getName());
                    }


                }



                setDatabaseList();
            }


        });


        txt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName();
                    // Writing Contacts to log
                    Log.e("Name: ", log);


                    if(cn.getName().equalsIgnoreCase("rahil")){


                        cn.setName("RAHILUPDATE");

                        db.updateContact(cn);


                        Log.e("record ","yes");



                    }
                    else{

                        Log.e("record ","not");
                        Log.e("record Data ",""+cn.getName());
                    }

                    setDatabaseList();
                }



            }
        });


    }


}
