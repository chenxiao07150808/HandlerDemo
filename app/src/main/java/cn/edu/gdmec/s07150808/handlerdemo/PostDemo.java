package cn.edu.gdmec.s07150808.handlerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PostDemo extends AppCompatActivity {
    private Button btn1;
    private TextView tv1;
    private EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_demo);
        btn1= (Button) findViewById(R.id.btn1);
        tv1 = (TextView) findViewById(R.id.tv1);
        input = (EditText) findViewById(R.id.input_label);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.post(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText(input.getText().toString());
                    }
                });
            }
        });
    }
}
