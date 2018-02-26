package rrdl.multithread;

import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by moneem on 26/02/18.
 */

public class SimulatedTask extends AsyncTask<Integer,Void,String> {
    private final TextView _textView;
    public SimulatedTask(TextView textView)
    {
        _textView=textView;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        _textView.setText(s);
    }

    @Override
    protected String doInBackground(Integer... integers) {
       int seconds=integers[0];
       try{
           Thread.sleep(seconds*1000);
       }catch (Exception e){e.printStackTrace();}
       return "Done!!";
    }
}
