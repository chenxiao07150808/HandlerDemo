package cn.edu.gdmec.s07150808.handlerdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;
/*
*  Handler 进行消息的传递 当监听的msg值为1时，调用updatetitle的方法
*
*  MyTask类复杂对对任务执行间隔时间的控制与初始值的设定
*
*  UpdateTitle主要负责对标题的修改
* */
public class MainActivity extends AppCompatActivity {


    private int title = 0;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case 1:
                    updateTitle();
                    break;
            }
        }
    };

    private void updateTitle() {
        setTitle("Time :"+title);
        title++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Timer  timer = new Timer();
        timer.scheduleAtFixedRate(new MyTask(),1,5000);
    }
    private class MyTask extends TimerTask{

        @Override
        public void run() {
            Message message = new Message();

            message.what=1;
            mHandler.sendMessage(message);


        }
    }
}
