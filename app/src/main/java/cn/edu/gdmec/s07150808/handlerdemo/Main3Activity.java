package cn.edu.gdmec.s07150808.handlerdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {


    private EditText Input;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Input = (EditText) findViewById(R.id.edit);
        tv1 = (TextView) findViewById(R.id.tv1);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(runnable).start();
            }
        });
    }
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle =msg.getData();
            tv1.setText(bundle.getString("result"));
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Message msg = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("result",Input.getText().toString());
            msg.setData(bundle);
            mHandler.sendMessage(msg);

        }
    };
}
