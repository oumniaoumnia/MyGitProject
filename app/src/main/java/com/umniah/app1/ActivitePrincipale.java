package com.umniah.app1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivitePrincipale extends AppCompatActivity {

    @BindView(R.id.textView3)
    TextView tv;

    @BindView(R.id.button2)
    Button btn;

    @BindView(R.id.editText2)
    EditText ed1;

    @BindView(R.id.editText3)
    EditText ed2;

    SharedPreferences prefs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        prefs =  getPreferences(Context.MODE_PRIVATE);
        String login = prefs.getString("login","default");
        String password = prefs.getString("pass","default");
        Log.i("hahuwa1",login);
        Log.i("hahuwa2",password);
        TelephonyManager telephonyManager =
                (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        int etat = telephonyManager.getCallState();
        PhoneStateCatcher phonestate = new PhoneStateCatcher(){
            public void onCallStateChanged(int etat, String numero)
            {
                super.onCallStateChanged(etat,numero);
                if(etat == TelephonyManager.CALL_STATE_OFFHOOK)
                {
                    Toast.makeText(getApplicationContext(),"Occupé",
                            Toast.LENGTH_LONG).show();
                }
            }
        };
        telephonyManager.listen(phonestate,PhoneStateCatcher.LISTEN_CALL_STATE);

        if(login.equals("oumnia") && password.equals("admin"))
        {
            setContentView(R.layout.activity_one);
        }
        else
        {
            setContentView(R.layout.activity_main);
        }




       // Button button = (Button)findViewById(R.id.button2);
        // Register onClick listener with the below implementation
        //button.setOnClickListener(btnListener);
    }

    @OnClick(R.id.button2)
    public void buttonTwoClicked() {

        //-------intent pour envoyer des strings

       /* intent.putExtra("login",ed1.getText().toString());
        intent.putExtra("pass",ed2.getText().toString());*/

        prefs =  getPreferences(Context.MODE_PRIVATE);

        prefs.edit().putString("login", "oumnia").commit();
        prefs.edit().putString("pass","admin").commit();
        Intent intent = new Intent(ActivitePrincipale.this, ActivityOne.class);
        startActivity(intent);

        //------intent pour envoyer un mail

        /*Intent email = new Intent(Intent.ACTION_SEND);
        String[] recipients = new String[]{"mouaad.oumnia@gmail.com"};
        email.putExtra(Intent.EXTRA_EMAIL,recipients);
        email.putExtra(Intent.EXTRA_SUBJECT,"sujet");
        email.putExtra(Intent.EXTRA_TEXT,"Bonjour, ceci est un test");
        email.setType("text/plain");
        startActivity(Intent.createChooser(email,"send mail..."));*/

        //------intent pour passer un appel

        /*Uri tel = Uri.parse("tel:0661096016");
        Intent call = new Intent(Intent.ACTION_DIAL,tel);
        startActivity(call);*/

        /*MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        IntentFilter IF = new IntentFilter("action_à_communiquer");
        registerReceiver(receiver,IF);

        Intent intent = new Intent();
        intent.setAction("action_à_communiquer");
        intent.putExtra("data","oumi oumi!");
        sendBroadcast(intent);*/

    }

    //public void

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onResume() {
        super.onResume();
        sqlDB sqldb = new sqlDB(this);
        sqldb.insert("titre1","subtitle1");
        sqldb.insert("titre2","subtitle2");

        ArrayList<String> list = sqldb.read();
        for(String l : list)
        {
            Log.i("ensak",l);
            Log.i("ensak",",");
        }


    }


}
