package com.soniacruz.mismascotasbd.mailsenderactivity;
/*
 * Clase tomada de: https://github.com/arpit999/SendMail
 * */

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.soniacruz.mismascotasbd.R;

import java.util.List;

public class SendMailTask extends AsyncTask {

    private ProgressDialog statusDialog;
    private Activity sendMailActivity;

    public SendMailTask(Activity activity) {
        sendMailActivity = activity;

    }

    protected void onPreExecute() {
        statusDialog = new ProgressDialog(sendMailActivity);
        statusDialog.setMessage(sendMailActivity.getString(R.string.statusMail_gettingReady));
        statusDialog.setIndeterminate(false);
        statusDialog.setCancelable(false);
        statusDialog.show();
    }

    @Override
    protected Object doInBackground(Object... args) {
        try {
            Log.i("SendMailTask", sendMailActivity.getString(R.string.statusMail_instantiateGMail));
            publishProgress(sendMailActivity.getString(R.string.statusMail_ProcessingInput));
            GMail androidEmail = new GMail(args[0].toString(),
                    args[1].toString(), (List) args[2], args[3].toString(),
                    args[4].toString());
            publishProgress(sendMailActivity.getString(R.string.statusMail_Preparing));
            androidEmail.createEmailMessage();
            publishProgress(sendMailActivity.getString(R.string.statusMail_Sending));
            androidEmail.sendEmail();
            publishProgress(sendMailActivity.getString(R.string.statusMail_Sent));
            Log.i("SendMailTask", sendMailActivity.getString(R.string.statusMail_Sent));
        } catch (Exception e) {
            publishProgress(e.getMessage());
            Log.e("SendMailTask", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void onProgressUpdate(Object... values) {
        statusDialog.setMessage(values[0].toString());

    }

    @Override
    public void onPostExecute(Object result) {
        statusDialog.dismiss();
    }

}