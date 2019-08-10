package com.task.task;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int i = 0;
    public int j = 0;
    LayoutInflater inflater;
    private LinearLayout lvnumber;
    private RelativeLayout reltop;
    public int index = 0;
    TextView tvnumber;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lvnumber = (LinearLayout) findViewById(R.id.lvnumber);
        reltop=(RelativeLayout)findViewById(R.id.reltop);

        for (int i = 0; i < 6; i++) {
            final View myView_inflat = inflater.inflate(R.layout.row_rotate, null);
            tvnumber = (TextView) myView_inflat.findViewById(R.id.tvnumber);
            lvnumber.addView(tvnumber);
        }


        timer = new CountDownTimer(100, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

                if (i != 6) {
                    View view = (View) lvnumber.getChildAt(index);
                    if (view != null) {
                        tvnumber = (TextView) view.findViewById(R.id.tvnumber);
                        if (j == 9) {
                            index = i + 1;
                            j = 0;
                            i++;
                        } else {
                            j++;
                            tvnumber.setText("" + j);
                        }


                    }
                }
                if (i == 6) {
                    if (timer != null) {
                        timer.cancel();
                    }

                    Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale_up);
                    animZoomOut.setFillAfter(true);
                    reltop.startAnimation(animZoomOut);


                }

            }

            @Override
            public void onFinish() {
                timer.start();

            }
        }.start();


    }

}
