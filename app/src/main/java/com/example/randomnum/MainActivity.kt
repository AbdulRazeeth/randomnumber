package com.example.randomnum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import java.util.*;
import android.widget.TextView;
import android.widget.Button;
import android.widget.SeekBar;

class MainActivity : AppCompatActivity() {
    var randomnum =0;
    lateinit var genetebutton:Button;
    lateinit var peakval:SeekBar;
    lateinit var displaytxt:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        genetebutton=findViewById<Button>(R.id.button);
        peakval=findViewById<SeekBar>(R.id.seekBar2);
        displaytxt=findViewById<TextView>(R.id.textView);
        genetebutton.setOnClickListener{

            generaterRan();
        }
        if(savedInstanceState!=null)
        {
            randomnum=savedInstanceState.getInt("ranVal");
            displaytxt.text=randomnum.toString();
        }
    }
    private fun generaterRan(){
        randomnum=peakval.progress;
        displaytxt.text=(Random().nextInt(randomnum)+1).toString();
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState);
        outState.putInt("ranVal",randomnum);
    }

}
