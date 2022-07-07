package com.myfirst.fashionbae.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.myfirst.fashionbae.R;
import com.myfirst.fashionbae.adapters.SliderAdapter;

public class OnBoardActivity extends AppCompatActivity {


    ViewPager viewPager;
    LinearLayout dotsLayout;

    Button btn;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Animation animation;
    int currentposition;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_board);

        getSupportActionBar().hide();
        viewPager=findViewById(R.id.slider);
        dotsLayout=findViewById(R.id.dots);
        btn=findViewById(R.id.get_started_btn);
        adddots(0);
        Button skipbutton=findViewById(R.id.skipbutton);
        skipbutton.setOnClickListener(view -> {
            moveforward(view);
        });

        Button nextbutton = findViewById(R.id.next_button);
        nextbutton.setOnClickListener(view -> {
            nextpagebutton(view);
        } );

        viewPager.addOnPageChangeListener(changeListener);

        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardActivity.this,MainActivity.class));
            }
        });


    }
    private void adddots(int position){
        dots=new TextView[3];
        dotsLayout.removeAllViews();
        for(int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0) {
           // dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            dots[position].setTextColor(getResources().getColor(R.color.Orange));

        }


    }
    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            adddots(position);
            currentposition = position;
            if(position==0){
                btn.setVisibility(View.INVISIBLE);

            }
            else if(position==1){
                btn.setVisibility(View.INVISIBLE);
            }else{
                animation = AnimationUtils.loadAnimation(OnBoardActivity.this,R.anim.slide_animation);
                btn.setAnimation(animation);
                btn.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void moveforward(View view){
        startActivity(new Intent(OnBoardActivity.this, com.myfirst.fashionbae.activities.MainActivity.class));
    }

    public void nextpagebutton(View view){
        viewPager.setCurrentItem(currentposition + 1);
    }

}