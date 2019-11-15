package com.umniah.app1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extra = intent.getExtras();
        if(extra != null)
        {
            String val = extra.getString("data");
            Toast.makeText(context,"Broadcast msg received: "+ val, Toast.LENGTH_SHORT).show();
        }
    }
}
