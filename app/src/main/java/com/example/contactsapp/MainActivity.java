package com.example.contactsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Button num1btn,num2btn,num3btn,num4btn,num5btn,num6btn,num7btn,num8btn,num9btn,num0btn,callbtn,numasbtn,numhabtn,backspacebtn;
    String displaytext="";
    BottomNavigationView nav_bar;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num0btn = (Button) findViewById(R.id.num0);
        num1btn = (Button) findViewById(R.id.num1);
        num2btn = (Button) findViewById(R.id.num2);
        num3btn = (Button) findViewById(R.id.num3);
        num4btn = (Button) findViewById(R.id.num4);
        num5btn = (Button) findViewById(R.id.num5);
        num6btn = (Button) findViewById(R.id.num6);
        num7btn = (Button) findViewById(R.id.num7);
        num8btn = (Button) findViewById(R.id.num8);
        num9btn = (Button) findViewById(R.id.num9);
        numasbtn = (Button) findViewById(R.id.numasterik);
        numhabtn = (Button) findViewById(R.id.numhash);
        callbtn = (Button) findViewById(R.id.call);
        backspacebtn = (Button) findViewById(R.id.backspace);
        tv1 =(TextView) findViewById(R.id.displaytext);
        nav_bar = findViewById(R.id.bottomNavigationView);
        nav_bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.callID) {
                        // Handle phone item click
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        return true;
                }
                else if (item.getItemId() == R.id.msgID) {
                    // Handle message item click
                    startActivity(new Intent(MainActivity.this, Messaging.class));
                    return true;
                }
                        return false;
                }

        });


        num0btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("0");
            }
        });
        num1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("1");
            }
        });
        num2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("2");
            }
        });
        num3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("3");
            }
        });
        num4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("4");
            }
        });
        num5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("5");
            }
        });
        num6btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("6");
            }
        });
        num7btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("7");
            }
        });
        num8btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("8");
            }
        });
        num9btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("9");
            }
        });
        numhabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("#");
            }
        });
        tv1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent i1 = new Intent(Intent.ACTION_CALL);
                i1.setData(Uri.parse("tel:"+displaytext));
                startActivity(i1);
                return true;
            }
        });
        numasbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNum("*");
            }
        });
        backspacebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(displaytext!="") {
                    displaytext = displaytext.substring(0, displaytext.length() - 1);
                    updateUI();
                }
            }
        });
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Intent.ACTION_CALL);
                i1.setData(Uri.parse("tel:"+displaytext));
                startActivity(i1);
            }
        });
    }
    private void appendNum(String str){
        displaytext+=str;
        updateUI();
    }
    private void updateUI(){
        tv1.setText(displaytext);
    }

}