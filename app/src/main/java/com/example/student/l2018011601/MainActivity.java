package com.example.student.l2018011601;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v) {
        String str = getFilesDir().getAbsolutePath();
        Log.d("File",str);
        String str2 = getCacheDir().getAbsolutePath();
        Log.d("Cache",str2);

    }

    public  void  click2(View v){
        File f=new File(getFilesDir(),"myfile.txt");

        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            fw.write("Hello!");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
