package com.ggendrick.cursach;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime; //таймер выхода
    private Toast backToast; //всплывающее сообщение о выходе
    public Dialog dialog;
    private SharedPreferences pref; //сохранение данных через sharedpreferences
    private final String save_key = "save_key";//ключ
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button buttonstart =(Button)findViewById(R.id.button_start);
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try { Intent intent = new Intent(MainActivity.this,Levels_list.class);
                    startActivity(intent); finish();

                }catch (Exception e){}
            }
        });
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_statistics);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        Button button_statistics = (Button)findViewById(R.id.button_statistics);
        button_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            try {
                dialog.show();
            }catch (Exception e){}
            }
        });
        pref = getSharedPreferences("level_info",MODE_PRIVATE);
        Button button_refresh = (Button)dialog.findViewById(R.id.button_statistics_refresh);
        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = pref.edit();
                edit.putInt(save_key,0); //
                edit.apply();//
                dialog.dismiss();
            }
        });
        Button button_back = (Button)dialog.findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
    }
    @Override
    public void onBackPressed() {

        if(backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;}
        else{
            backToast= Toast.makeText(getBaseContext(),"Нажмите еще раз чтобы выйти",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}