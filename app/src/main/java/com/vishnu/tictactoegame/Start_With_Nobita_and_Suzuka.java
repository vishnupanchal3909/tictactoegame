package com.vishnu.tictactoegame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Start_With_Nobita_and_Suzuka extends AppCompatActivity {

    Button play2,exit2;
    private static final int TIME_DELAY = 1000;
    private static long back_pressed;

    ImageView nobita,suzuka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.activity_start_with_nobita_and_suzuka);
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        play2=findViewById(R.id.play2);
        exit2=findViewById(R.id.exit2);
        nobita=(ImageView)findViewById(R.id.nobitaimage);
        suzuka=(ImageView)findViewById(R.id.suzukaimage);
        nobita.setVisibility(View.INVISIBLE);
        play2.setVisibility(View.INVISIBLE);
    }
    //0=Suzuka  1=Nobita 2=null
    int []GameState={2,2,2,2,2,2,2,2,2};
    int [][] winningPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int ActivePlayer=0;
    Boolean GameActive=true;
    public void taptap(View view)
    {
        ImageView counter=(ImageView) view;
        int tap=Integer.parseInt(counter.getTag().toString());
        if(GameState[tap]==2 && GameActive)
        {
            play2.setText("Play");
            play2.setVisibility(View.VISIBLE);
            GameState[tap]=ActivePlayer;
            counter.setTranslationY(-1500);
            if (ActivePlayer == 0)
            {
                counter.setImageResource(R.drawable.suzuka);
                ActivePlayer = 1;
                suzuka.setVisibility(View.INVISIBLE);
                nobita.setVisibility(View.VISIBLE);

            }
            else
            {
                counter.setImageResource(R.drawable.nobita);
                ActivePlayer = 0;
                suzuka.setVisibility(View.VISIBLE);
                nobita.setVisibility(View.INVISIBLE);
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for(int[] WinningPositions : winningPosition)
            {
                if (GameState[WinningPositions[0]] == GameState[WinningPositions[1]]  && GameState[WinningPositions[1]]==GameState[WinningPositions[2]] && GameState[WinningPositions[0]] != 2)
                {
                    GameActive=false;
                    if(ActivePlayer == 0)
                    {
                        nobita.setVisibility(View.VISIBLE);
                        suzuka.setVisibility(View.INVISIBLE);
                        AlertDialog.Builder builder=new AlertDialog.Builder(this);
                        builder.setIcon(R.drawable.nobita);
                        builder.setTitle("Congratulation..!Nobita Win Match");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        play2.setText("R-Play");
                        play2.setVisibility(View.VISIBLE);
                        ;
                    }
                    else
                    {
                        suzuka.setVisibility(View.VISIBLE);
                        nobita.setVisibility(View.INVISIBLE);
                        AlertDialog.Builder builder=new AlertDialog.Builder(this);
                        builder.setIcon(R.drawable.suzuka);
                        builder.setTitle("Congratulation..!Suzuka Win Match");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();
                        play2.setText("R-Play");
                        play2.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }
    public void playAgain2(View view)
    {
        suzuka.setVisibility(View.VISIBLE);
        nobita.setVisibility(View.INVISIBLE);
        ImageView p,o,i,u,y,t,r,e,w;
        p=(ImageView)findViewById(R.id.imageView11);
        o=(ImageView)findViewById(R.id.imageView12);
        i=(ImageView)findViewById(R.id.imageView13);
        u=(ImageView)findViewById(R.id.imageView14);
        y=(ImageView)findViewById(R.id.imageView15);
        t=(ImageView)findViewById(R.id.imageView16);
        r=(ImageView)findViewById(R.id.imageView17);
        e=(ImageView)findViewById(R.id.imageView18);
        w=(ImageView)findViewById(R.id.imageView19);

        p.setImageDrawable(null);
        o.setImageDrawable(null);
        i.setImageDrawable(null);
        u.setImageDrawable(null);
        y.setImageDrawable(null);
        t.setImageDrawable(null);
        r.setImageDrawable(null);
        e.setImageDrawable(null);
        w.setImageDrawable(null);

        for(int j=0;j<9;j++)
        {
            GameState[j]=2;
        }
        GameActive=true;
        ActivePlayer=0;

    }
    public void exit2(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Second.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            Intent intent=new Intent(getApplicationContext(), Second.class);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(), "Again Back To The Page..!",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }
}