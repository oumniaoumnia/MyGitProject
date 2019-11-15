package com.umniah.app1;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneStateCatcher extends PhoneStateListener {
    public void onCallStateChanged(int etat, String numero)
    {
        super.onCallStateChanged(etat,numero);
        if(etat == TelephonyManager.CALL_STATE_OFFHOOK)
        {
            Log.i("ensak","occupé");
        }
    }
}
