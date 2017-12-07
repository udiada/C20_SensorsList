package com.example.udi.c20_sensorslist;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,allSensors());
        lv.setAdapter(arrayAdapter);
    }

    public List<String> allSensors()
    {
        SensorManager sm = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);
        ArrayList<String> arrayList=new ArrayList<String>();
        for (Sensor s:list) {
            arrayList.add("Sensor name:"+s.getName());
        }
        return arrayList;
    }
}
