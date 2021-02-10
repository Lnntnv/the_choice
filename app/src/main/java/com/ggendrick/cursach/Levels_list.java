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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Levels_list extends AppCompatActivity {
    Dialog dialog;
    private int info_level;
    private Toast toast;
    private SharedPreferences pref; //сохранение данных через sharedpreferences
    private final String save_key = "save_key";//ключ
    private final int[] buttonarray = {R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,
            R.id.button10,R.id.button11,R.id.button12,R.id.button13,R.id.button14,R.id.button15,};
    private final int[] imagearray = {R.id.image_1,R.id.image_2,R.id.image_3,R.id.image_4,R.id.image_5,R.id.image_6,R.id.image_7,R.id.image_8,R.id.image_9,
            R.id.image_10,R.id.image_11,R.id.image_12,R.id.image_13,R.id.image_14,R.id.image_15,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels_list);
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        pref = getSharedPreferences("level_info",MODE_PRIVATE);
        info_level = pref.getInt(save_key,0);
        for(int i=info_level;i<=14;i++){
            Button button = (Button)findViewById(buttonarray[i]);
            button.setBackgroundResource(R.drawable.button_type2);
        }
        if(info_level<15){
        for(int i =0;i<=info_level;i++) {
            ImageView imageView = (ImageView) findViewById(imagearray[i]);
            imageView.setImageResource(R.drawable.lock_null);
        }
        }
        else{
            for(int i =0;i<=14;i++) {
                ImageView imageView = (ImageView) findViewById(imagearray[i]);
                imageView.setImageResource(R.drawable.lock_null);
        }}
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        if(info_level==0){
            dialog.show();}
        Button buttonunderstand = (Button)(dialog.findViewById(R.id.button_understand));
        buttonunderstand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Button buttonback = (Button)findViewById(R.id.buttonback); //кнопка назад начало
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Levels_list.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });
        Button button1 = (Button)findViewById(R.id.button1); //уровень 1 наибольшее
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=0){
                try {
                    Intent intent = new Intent(Levels_list.this,Level_1.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
            }
        });
        Button button2 = (Button)findViewById(R.id.button2); //уровень 2 наименьшее
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=1){
                try {
                    Intent intent = new Intent(Levels_list.this,Level_2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
            toast.show();}}
        });

        Button button3 = (Button)findViewById(R.id.button3); //уровень 3 четное
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=2){
                try {
                    Intent intent = new Intent(Levels_list.this,Level_3.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button4 = (Button)findViewById(R.id.button4); //уровень 4 нечетное
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=3){
                try {
                    Intent intent = new Intent(Levels_list.this,Level_4.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button5 = (Button)findViewById(R.id.button5); //уровень 5 кратное 3
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=4){
                try {
                    Intent intent = new Intent(Levels_list.this,Level_5.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button6 = (Button)findViewById(R.id.button6); //уровень 5 кратное 3
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=5){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_6.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button7 = (Button)findViewById(R.id.button7); //уровень 5 кратное 3
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=6){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_7.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button8 = (Button)findViewById(R.id.button8); //уровень 5 кратное 3
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=7){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_8.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button9 = (Button)findViewById(R.id.button9); //уровень 5 кратное 3
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=8){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_9.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button10 = (Button)findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=9){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_10.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button11 = (Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=10){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_11.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button12 = (Button)findViewById(R.id.button12); //уровень 5 кратное 3
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=11){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_12.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button13 = (Button)findViewById(R.id.button13); //уровень 5 кратное 3
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=12){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_13.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button14 = (Button)findViewById(R.id.button14); //уровень 5 кратное 3
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=13){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_14.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
        Button button15 = (Button)findViewById(R.id.button15); //уровень 5 кратное 3
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info_level>=14){
                    try {
                        Intent intent = new Intent(Levels_list.this,Level_15.class);
                        startActivity(intent);
                        finish();
                    }catch (Exception e){}
                } else{toast=Toast.makeText(getBaseContext(),"Этот уровень закрыт",Toast.LENGTH_SHORT);
                    toast.show();}}
        });
    }
    @Override
    public void onBackPressed() { //аппаратная кнопка назад
        try {
            Intent intent = new Intent(Levels_list.this,MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){}
    }
}