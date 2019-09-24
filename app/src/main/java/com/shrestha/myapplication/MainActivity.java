package com.shrestha.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button butr, butl, butre;
    private TextView tv;
    int rm, r, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butl = findViewById(R.id.butL);
        butl.setOnClickListener(this);
        butr = findViewById(R.id.butR);
        butr.setOnClickListener(this);
        butre = findViewById(R.id.replay);
        butre.setOnClickListener(this);
        Gen_Ran(butl, butr);
        tv = findViewById(R.id.result);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.butL:
                Check(butl, butr);
                Score();
                break;

            case R.id.butR:
                Check(butr, butl);
                Score();
                break;

            case R.id.replay:
               tv.setText("");
               total = 0;
                butr.setEnabled(true);
                butl.setEnabled(true);
                Gen_Ran(butl, butr);
                break;
        }

    }

    public void Gen_Ran(Button b1, Button b2) {
        rm = new Random().nextInt((100 - 1) + 1) + 1;
        r = new Random().nextInt((100 - 1) + 1) + 1;
        b1.setText(String.valueOf(rm));
        b2.setText(String.valueOf(r));

    }

    public void Check(Button b1, Button b2) {

        if (Integer.parseInt(b1.getText().toString()) > Integer.parseInt(b2.getText().toString())) {

            Gen_Ran(butl, butr);
            total++;
            tv.setText("Point "+(total));
        } else {

            Gen_Ran(butl, butr);
            total--;
            tv.setText("Point "+total);
        }

    }

    public void Score() {
        if (total == 10) {
            tv.setText("player WON the Game point is "+total);
            butr.setEnabled(false);
            butl.setEnabled(false);
            butre.setVisibility(View.VISIBLE);

        } else if (total == -10) {
            tv.setText("player loose the Game point is "+total);
            butr.setEnabled(false);
            butl.setEnabled(false);
            butre.setVisibility(View.VISIBLE);

        }
    }
}
