package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        processSms(context, intent);
    }

    private void processSms(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        String message = "";
        String body = "";
        String address = "";

        if (myBundle != null)
        {
            Object[] mySms = (Object[]) myBundle.get("pdus");
            for (int i = 0; i < mySms.length; i++) {
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) mySms[i]);
                body += sms.getMessageBody();    // Lấy nội dung tin nhắn
                address = sms.getOriginatingAddress();  // Lấy số điện thoại
            }
            message = "Bạn có 1 tin nhắn đến từ số điện thoại " + address +
                    "\n với nội dung: " + body + " vừa gửi đến.";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }
}