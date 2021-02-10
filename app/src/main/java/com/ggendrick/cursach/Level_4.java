package com.ggendrick.cursach;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level_4 extends AppCompatActivity {
    private final static int level = 4;
   private SharedPreferences pref;
    private final String save_key = "save_key";//ключ
    public Dialog dialog;
    public int leftnum;
    public int rightnum;
    public int score;
    Random random = new Random();
    Arrays array = new Arrays();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_end_level);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        score=0;
        TextView level_number = (TextView)findViewById(R.id.level_status);
        level_number.setText("Уровень "+ level);
        Button button_continue = (Button)dialog.findViewById(R.id.button_change_level);
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level_4.this,Levels_list.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });
        Button button_next_level = (Button)dialog.findViewById(R.id.button_next_level);
        button_next_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level_4.this,Level_5.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });
        Button butonback = (Button)findViewById(R.id.buttonback);
        butonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {   Intent intent = new Intent(Level_4.this,Levels_list.class);
                        startActivity(intent);
                        finish();
                }catch (Exception e){}
            }
        });
        final  int[] indicator = {R.id.indicator_1,R.id.indicator_2,R.id.indicator_3,R.id.indicator_4,R.id.indicator_5,R.id.indicator_6,R.id.indicator_7,R.id.indicator_8,R.id.indicator_9,
                R.id.indicator_10,R.id.indicator_11,R.id.indicator_12,R.id.indicator_13,R.id.indicator_14,R.id.indicator_15,R.id.indicator_16,R.id.indicator_17,R.id.indicator_18,R.id.indicator_19,R.id.indicator_20,};
        final Animation a = AnimationUtils.loadAnimation(Level_4.this,R.anim.alpha);
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    leftnum = random.nextInt(9)+1;
    img_left.setImageResource(array.images_level_1[leftnum]);
    rightnum=random.nextInt(9)+1;
    while(((leftnum%2==0)&&(rightnum%2==0))||((leftnum%2!=0)&&(rightnum%2!=0))){
        rightnum=random.nextInt(9)+1;  }
        img_right.setImageResource(array.images_level_1[rightnum]);

        img_left.setOnTouchListener(new View.OnTouchListener() { //слушатель нажатия на  левую картинку
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) { //метод, вызываемый нажатием на картинку
                if(motionEvent.getAction()==motionEvent.ACTION_DOWN){ // когда картинка нажата проверяем правильность нажаития и выводоим картинки правда или ложь
                    img_right.setEnabled(false);
                    if(leftnum%2!=0){
                        img_left.setImageResource(R.drawable.truee);

                    }
                    else{img_left.setImageResource(R.drawable.falsee);}
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){ //когда картинка отпущена записываем счет

                    if(leftnum%2!=0){ //меняем счет в случае правильного ответа
                        if(score<20){
                            score++;
                        }



                    }
                    else{if(score>0){ //меняем счет в случае неправильного ответа
                        if(score==1){
                            score=0;
                        }
                        else{score-=2;}
                    }

                    }
                    for(int i = 0 ;i<20;i++){  //меняем прогресс
                        ImageView image = findViewById(indicator[i]);
                        if(i<score){image.setImageResource(R.drawable.indicator_true);}
                        else{image.setImageResource(R.drawable.indicator_false);}}
                    if(score==20){//выход из уровня
                        dialog.show();
                        pref = getSharedPreferences("level_info",MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putInt(save_key,level);
                        edit.apply();
                    }else{ //если счет меньше 20 меняем карники
                        leftnum=random.nextInt(9)+1;
                        img_left.setImageResource(array.images_level_1[leftnum]);
                        img_left.startAnimation(a); //меняем картинки через анимацию
                        rightnum=random.nextInt(9)+1;//рандом от 1 до 10
                        while((((leftnum%2==0)&&(rightnum%2==0))||((leftnum%2!=0)&&(rightnum%2!=0)))){
                            rightnum=random.nextInt(9)+1;
                        }
                        img_right.setImageResource(array.images_level_1[rightnum]);
                        img_right.startAnimation(a);
                        img_right.setEnabled(true);
                    }
                }
                return true;

            }
        });

        img_right.setOnTouchListener(new View.OnTouchListener() { //слушатель нажатия на  левую картинку
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) { //метод, вызываемый нажатием на картинку
                if(motionEvent.getAction()==motionEvent.ACTION_DOWN){ // когда картинка нажата проверяем правильность нажаития и выводоим картинки правда или ложь
                    img_left.setEnabled(false);
                    if(rightnum%2!=0){
                        img_right.setImageResource(R.drawable.truee);

                    }
                    else{img_right.setImageResource(R.drawable.falsee);}
                }
                else if(motionEvent.getAction()==MotionEvent.ACTION_UP){ //когда картинка отпущена записываем счет

                    if(rightnum%2!=0){ //меняем счет в случае правильного ответа
                        if(score<20){
                            score++;
                        }

                    }
                    else{if(score>0){ //меняем счет в случае неправильного ответа
                        if(score==1){
                            score=0;
                        }
                        else{score-=2;}
                    }

                    }
                    for(int i = 0 ;i<20;i++){  //меняем прогресс
                        ImageView image = findViewById(indicator[i]);
                        if(i<score){image.setImageResource(R.drawable.indicator_true);}
                        else{image.setImageResource(R.drawable.indicator_false);}}
                    if(score==20){//выход из уровня
                        dialog.show();
                        pref = getSharedPreferences("level_info",MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putInt(save_key,level);
                        edit.apply();
                    }else{ //если счет меньше 20 меняем карники
                        leftnum=random.nextInt(9)+1;
                        img_left.setImageResource(array.images_level_1[leftnum]);
                        img_left.startAnimation(a); //меняем картинки через анимацию
                        rightnum=random.nextInt(9)+1;//рандом от 0 до 10
                        while((((leftnum%2==0)&&(rightnum%2==0))||((leftnum%2!=0)&&(rightnum%2!=0)))){
                            rightnum=random.nextInt(9)+1;
                        }
                        img_right.setImageResource(array.images_level_1[rightnum]);
                        img_right.startAnimation(a);
                        img_left.setEnabled(true);
                    }
                }
                return true;

            }
        });





    }



    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level_4.this,Levels_list.class);
            startActivity(intent);
            finish();
        }catch (Exception e){}

    }
}