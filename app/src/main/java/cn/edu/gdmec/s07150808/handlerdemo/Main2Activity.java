package cn.edu.gdmec.s07150808.handlerdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Main2Activity extends AppCompatActivity {

    private TextView tv1;

     Handler mHandler = new Handler(){
         @Override
         public void handleMessage(Message msg) {
             switch (msg.what){
                 case 1:
                     UpdateTime();
                     break;
             }
         }
     };

    private void UpdateTime() {
        SimpleDateFormat Sformat =new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss ");
        Date curDate    = new Date(System.currentTimeMillis());
        tv1.setText(Sformat.format(curDate));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1= (TextView) findViewById(R.id.tv1);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTask(),1,1000);
    }
    private class MyTask extends TimerTask {

        @Override
        public void run() {
            Message message = new Message();

            message.what=1;
            mHandler.sendMessage(message);


        }
    }

}
