package com.example.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    TextView mesg;

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.broadcastapplication.EXAMPLE_ACTION".equals(intent.getAction())) {
            String receivedText = intent.getStringExtra("com.broadcastapplication.EXTRA_TEXT");
            Pattern pn = Pattern.compile("^[A-Za-z ]+$");
            if(!(pn.matcher(receivedText).matches())) {
                Toast.makeText(context, "Sorry message is corrupted!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();
            }
        }
    }
    }

