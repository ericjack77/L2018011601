package com.example.student.l2018011601;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //抓取"檔案"與"快取" 的存取路徑
    public void click1(View v) {
        String str = getFilesDir().getAbsolutePath();
        Log.d("File",str);
        String str2 = getCacheDir().getAbsolutePath();
        Log.d("Cache",str2);

    }

    public  void  click2(View v){
        File f2=new File(getFilesDir(),"myfile.txt");

        FileWriter fw = null;
        try {
            fw = new FileWriter(f2);
            fw.write("Hello!");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click3(View v)
    {
        ArrayList<String> list=new ArrayList<>();
        list.add("JOb");
        list.add("Harry");
        list.add("Cool");

        File f3 =new File(getFilesDir(),"myfile2.txt");
        try {
            Gson gson = new Gson();
            String data=gson.toJson(list);

            FileWriter fw = new FileWriter(f3);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click4(View v)
    {
        ArrayList<student> list =new ArrayList<>();
        list.add(new student(1,"Alex",99));
        list.add(new student(2,"Chris",78));
        list.add(new student(3,"Allin",88));

        File f=new File(getFilesDir(),"myfile3.txt");
        Gson gson = new Gson();
        String data = gson.toJson(list);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void click5(View v)
    {
        File f=new File(getFilesDir(),"myfile2.txt");

        try {
            FileReader fr =new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("File",str);

            Gson gson =new Gson();
            ArrayList<String> mydata =gson.fromJson(str,new TypeToken<ArrayList>(){}.getType());
            for(String s: mydata)
            {
                Log.d("File","data:"+s);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void click6(View v)
    {
        File f=new File(getFilesDir(),"myfile3.txt");

        try {
            FileReader fr =new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("File",str);

            Gson gson =new Gson();
            ArrayList<student> mydata =gson.fromJson(str,new TypeToken<ArrayList<student>>(){}.getType());
            for(student s: mydata)
            {
                Log.d("File","data:"+s.id+","+s.name);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class  student
    {
        public int id;
        public  String name;
        public  int score;

        student(int id,String name,int score)
        {
            this.id=id;this.name=name;this.score=score;
        }
    }
}
