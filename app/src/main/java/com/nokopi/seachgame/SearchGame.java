package com.nokopi.seachgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchGame extends AppCompatActivity {
    private SensorManager manager;
    private SensorEventListener listener;
    private Sensor s1;

    private TextView tvAccX, tvAccY,tv1;
    private Button btReturn1;

    private SampleView1 myView;
    private Locate circle;

    float xx, yy ;

    int result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_game);
        tv1=(TextView)findViewById(R.id.tv1);
        tvAccX = (TextView)findViewById(R.id.tvAccX);
        tvAccY = (TextView)findViewById(R.id.tvAccY);
        myView=(SampleView1)findViewById(R.id.view1);
        circle=(Locate)findViewById(R.id.view2);
        btReturn1 = (Button)findViewById(R.id.btReturn1);
        btReturn1.setText("戻る");

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (result==1){
                    return;
                }
                if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    tvAccX.setText("x: " + sensorEvent.values[0]);
                    tvAccY.setText("y: " + sensorEvent.values[1]);
                    myView.changeColor(sensorEvent.values[0],sensorEvent.values[1]);
                    circle.Circle(sensorEvent.values[0],sensorEvent.values[1]);
                    xx = sensorEvent.values[0];
                    yy = sensorEvent.values[1];
                }
            }



            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        if (result==1){
            return;
        }else {
            Button Result = (Button) findViewById(R.id.result);
            Result.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent i = new Intent();
                    if (myView.result(xx, yy) == 1) {
                        result = 1;
                        tv1.setText("宝発見！！");
                        btReturn1.setText("宝を確認する！");
                    } else {
                        result = -1;
                        tv1.setText("残念！そこにはないよ！！");
                    }
                    i.putExtra("Result", result);
                    setResult(RESULT_OK, i);
                }
            });
        }

        btReturn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        s1 = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        manager.registerListener(listener, s1, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause(){
        super.onPause();
        manager.unregisterListener(listener, s1);
    }
}
