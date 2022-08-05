package com.nokopi.seachgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    Button bt;
    ImageView iv1;
    Random r=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        iv1=(ImageView)findViewById(R.id.imageView1);

        bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SearchGame.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            int result = data.getIntExtra("Result",3);
            if (result==1){
                int a=r.nextInt(3)+1;
                if (a==1){
                    iv1.setImageResource(R.drawable.kin);
                    tv1.setText("金の延べ棒を発見した！！");
                    tv2.setText("");
                    tv3.setText("");
                    bt.setText("もう一度探しに行く");
                }else if (a==2){
                    iv1.setImageResource(R.drawable.oukan);
                    tv1.setText("王冠を発見した！！");
                    tv2.setText("");
                    tv3.setText("");
                    bt.setText("もう一度探しに行く");
                }else if (a==3){
                    iv1.setImageResource(R.drawable.nekkuresu);
                    tv1.setText("ネックレスを発見した！！");
                    tv2.setText("");
                    tv3.setText("");
                    bt.setText("もう一度探しに行く");
                }

            }else {
                iv1.setImageDrawable(null);
                tv1.setText("あきらめるのかい？？");
                tv2.setText("");
                tv3.setText("");
                bt.setText("まだ探す");
            }


        }
    }

}