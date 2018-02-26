package rrdl.multithread;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private Button mButton;
    private TextView mTextView;
    private ImageView mImageView;
    private SimulatedTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Loading widgets
        mButton=findViewById(R.id.button2);
        mTextView=findViewById(R.id.textView2);
        mImageView=findViewById(R.id.imageView2);
        //Rotation Animation
        RotateAnimation rotate=new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f
                ,Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(900);
        rotate.setRepeatCount(Animation.INFINITE);
        mImageView.startAnimation(rotate);
        //Listeners
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimulatedTask task = new SimulatedTask(mTextView);
                task.execute(2);

            }
        });
    }

    @Override
    protected void onStop() {//killing simulatedtask on exit
        super.onStop();
        task.cancel(true);

    }
}
