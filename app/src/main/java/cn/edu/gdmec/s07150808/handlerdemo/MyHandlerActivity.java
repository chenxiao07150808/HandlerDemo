package cn.edu.gdmec.s07150808.handlerdemo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MyHandlerActivity extends AppCompatActivity {


    Button button ;
    MyHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_handler);

        button = (Button) findViewById(R.id.button);

        mHandler= new MyHandler();

        /*
        * 当创建一个新Handler实例是，它会绑定到当前线程和消息的队列，开始分发数据
        * Handler有两个作用，1、定时执行Message和Runable对象
        * 2、让一个动作，在不同的线程中执行。它安排消息，用以下方法
        * post(Runnable)
        * postAtTime(Runnable,long)
        * postDelayed(Runnable,long)
        * sendEmptyMessage(int)
        * sendMessage(Message)
        * sendMessageAtTime(Message ,long)
             以上方法以post开头的允许你处理Runnale
             senfMessage()允许处理Message()
               * */
        MyThread  m =new MyThread();
        new Thread(m).start();
    }
    class MyHandler extends Handler{
        public MyHandler(){

        }
        public MyHandler(Looper L){
            super(L);
        }

        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MyHandlerActivity.this,"MyHandler HandlerMessage",Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
            Bundle b =msg.getData();
            String color =b.getString("color");

            MyHandlerActivity.this.button.append(color);
        }
    }
    class MyThread implements  Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("thread....","mThread...");
            Message msg = new Message();
            Bundle b = new Bundle();
            b.putString("color","我的");
            msg.setData(b);

                MyHandlerActivity.this.mHandler.sendMessage(msg);
        }
    }
}
