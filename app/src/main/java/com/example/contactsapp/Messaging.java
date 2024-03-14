package com.example.contactsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Messaging extends Activity {
    Button sendtxtbtn;
    EditText messageET, numberET;
    BottomNavigationView nav_bar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messaging);
        sendtxtbtn = (Button) findViewById(R.id.sendsms);
        messageET = (EditText) findViewById(R.id.message);
        numberET = (EditText) findViewById(R.id.number);
        sendtxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = numberET.getText().toString();
                String msg = messageET.getText().toString();
                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage(num,null,msg,null,null);

            }
        });
        nav_bar = findViewById(R.id.bottomNavigationView);
        nav_bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.callID) {
                    // Handle phone item click
                    startActivity(new Intent(Messaging.this, MainActivity.class));
                    return true;
                }
                else if (item.getItemId() == R.id.msgID) {
                    // Handle message item click
                    startActivity(new Intent(Messaging.this, Messaging.class));
                    return true;
                }
                return false;
            }

        });
    }
}
