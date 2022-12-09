package com.vishnu.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    TextView start1,start2,start3,start4;

    private static final int TIME_DELAY = 1000;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_second);
        /////////////////////////////////////////

        start1=(TextView) findViewById(R.id.start_doreamon);
        start2=(TextView) findViewById(R.id.start_nobita);
        start3=(TextView) findViewById(R.id.start_giant);
        start4=(TextView) findViewById(R.id.start_bheema);


        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Start_With_Doreamon_and_Sister.class);
                startActivity(intent);
            }
        });
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Start_With_Nobita_and_Suzuka.class);
                startActivity(intent);
            }
        });
        start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Start_With_Giant_And_Sunzo.class);
                startActivity(intent);
            }
        });
        start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Start_With_ChootaBheem_And_Kaliya.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(), "Again Back To The Page..!",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}