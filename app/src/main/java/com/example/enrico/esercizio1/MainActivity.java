package com.example.enrico.esercizio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity
{

    private static final int MINVALUE = 1;
    private static final int MAXVALUE = 100;

    int valAttuale = 50;

    Button plus, minus, divide, multiply;
    SeekBar seekBar;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        editText = (EditText) findViewById(R.id.num);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                aggiornaValore(valAttuale + 1);
            }
        });

        minus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                aggiornaValore(valAttuale - 1);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    aggiornaValore(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                aggiornaValore(seekBar.getProgress());
            }
        });

        this.aggiornaValore(valAttuale);
    }

    private void aggiornaValore(int nuovoVal)
    {
        if (nuovoVal > MAXVALUE)
            nuovoVal = MAXVALUE;
        if (nuovoVal < MINVALUE)
            nuovoVal = MINVALUE;
        this.valAttuale = nuovoVal;
        this.editText.setText("" + valAttuale);
        if(this.seekBar.getProgress() != valAttuale) {
            this.seekBar.setProgress(valAttuale);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
