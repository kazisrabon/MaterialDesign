package com.example.iit.materialdesign;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.iit.materialdesign.database.MyDB;
import com.example.iit.materialdesign.model.Comment;
import com.example.iit.materialdesign.parse.ReadTextFromURL;
import com.example.iit.materialdesign.parse.StarDataObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IIT on 4/8/2015.
 */
public class WebData extends Service{

//    String url = "http://maxi.riken.jp/fluxtop/fluxtop57119.dat";
    ArrayList<StarDataObject> tableOfDatas = new ArrayList<>();
    StarDataObject starDataObject = new StarDataObject();
//    TableOfData tableOfData = null;
    ReadTextFromURL readTextFromURL;
    List<Comment> values;
    Comment value;
    private String notifyData;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        notifyData = new String();
        MyDB datasource = new MyDB(this);
        datasource.open();
        values = datasource.getAllComments();

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                tableOfDatas = new ReadTextFromURL().RTF();

                //tableOfDatas = readTextFromURL.RTF();
                if(tableOfDatas != null){
                    notifyData = "Sco X-1";
                    for(int j=0; j<tableOfDatas.size(); j++){
                        for(int i=0; i<values.size(); i++){
                            value = values.get(i);
                            starDataObject = tableOfDatas.get(j);
                            if(value.getStarName().equals(starDataObject.getName())){

                                if(!value.getStarFlux().equals(starDataObject.getName())){
                                    sendNotification(starDataObject.getName() + "'s flux is changed check the graph", R.mipmap.ic_fab);
                                }
                            }
                        }
                    }
                }

                sendNotification(notifyData + "'s flux is changed check the graph", R.mipmap.ic_fab);
                return null;
            }
        }.execute();
//        drs.readFile(url);
//        tableOfData = tableOfDatas.get(0);
//        Log.e("Service", tableOfData.top + " " + tableOfData.jName + " " + tableOfData.fluxInKiloEVolt + " " + tableOfData.sigmaError + " " + tableOfData.mjd + " " + tableOfData.starName);



    }

    @Override
    public void onDestroy() {
        AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarm.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (1000 * 60 * 60 * 4),
                PendingIntent.getService(this, 0, new Intent(this, WebData.class), 0)
        );
    }
    private void sendNotification(String alert, int icon) {
        Intent intent = new Intent(this, ParallaxToolbarScrollViewActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setAutoCancel(true);
        builder.setContentTitle("NASA");
        builder.setContentText(alert);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.addAction(icon, "Fabourite", pIntent);
        builder.setVibrate(new long[(int)1]);
        builder.setAutoCancel(true);

        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(8, notification);
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
    }

    public String getFlux(String name){

        if(tableOfDatas != null){
            for(int j=0; j<tableOfDatas.size(); j++){
                starDataObject = tableOfDatas.get(j);
                if(name.equals(starDataObject.getName())){
                    return starDataObject.getFlux();
                    }
                }
            }
        return "0";
    }
}
