package rrdl.multithread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    ImageView mImageView;
    TextView mTextView;
    Button mNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=findViewById(R.id.button);
        mTextView=findViewById(R.id.textView);
        mImageView=findViewById(R.id.imageView);
        mNext=findViewById(R.id.next);
        RotateAnimation rotate=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f
                ,Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(900);
        rotate.setRepeatCount(Animation.INFINITE);
        mImageView.startAnimation(rotate);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread=new Thread()
                {
                    @Override
                    public void run() {
                        try{Thread.sleep(2000);}
                        catch (Exception e){e.printStackTrace();}
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText("Done!");
                            }
                        });
                    }
                };
                thread.start();
            }
        });
          }
}
