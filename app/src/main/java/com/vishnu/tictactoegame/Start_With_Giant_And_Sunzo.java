package com.vishnu.tictactoegame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class Start_With_Giant_And_Sunzo extends AppCompatActivity {

    Button exit,play;
    ImageView giant,sunzo;
    int ActivePlayer=0;
    Boolean GameActive=true;
    int [] GameState={2,2,2,2,2,2,2,2,2};
    int[][]WinningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7,},{2,5,8},{0,4,8},{2,4,6}};
    //0=giant  1=sunzo 2=empty
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_start_with_giant_and_sunzo);
        exit=findViewById(R.id.button111);
        play=findViewById(R.id.button112);
        giant=findViewById(R.id.first121);
        sunzo=findViewById(R.id.second121);
        sunzo.setVisibility(View.INVISIBLE);
        play.setVisibility(View.INVISIBLE);
    }
    public void taptap11(View view)
    {
        ImageView counter=(ImageView) view;
        int tappeduser=Integer.parseInt(counter.getTag().toString());
        if(GameState[tappeduser] == 2 && GameActive)
        {
            play.setText("Play");
            play.setVisibility(View.VISIBLE);
            GameState[tappeduser]=ActivePlayer;
            counter.setTranslationY(-1500);
            if (ActivePlayer == 0) {
                giant.setVisibility(View.INVISIBLE);
                sunzo.setVisibility(View.VISIBLE);
                counter.setImageResource(R.drawable.giant);
                ActivePlayer = 1;
            } else {
                giant.setVisibility(View.VISIBLE);
                sunzo.setVisibility(View.INVISIBLE);
                counter.setImageResource(R.drawable.sunzo);
                ActivePlayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] winningposition : WinningPositions) {
                if (GameState[winningposition[0]] == GameState[winningposition[1]] && GameState[winningposition[1]] == GameState[winningposition[2]] && GameState[winningposition[0]] != 2) {
                    GameActive = false;
                    giant.setVisibility(View.INVISIBLE);
                    sunzo.setVisibility(View.INVISIBLE);
                    if (ActivePlayer == 0) {
                        sunzo.setVisibility(View.VISIBLE);

                        AlertDialog.Builder alertdialog=new AlertDialog.Builder(this);
                        alertdialog.setIcon(R.drawable.sunzo);
                        alertdialog.setTitle("Congratulation..!Sunzo Win Match");
                        alertdialog.setPositiveButton("ok", (dialog, which) -> dialog.dismiss());
                        alertdialog.show();
                        play.setText("R-Play");
                        play.setVisibility(View.VISIBLE);
                    } else {
                        giant.setVisibility(View.VISIBLE);

                        AlertDialog.Builder builder=new AlertDialog.Builder(this);
                        builder.setIcon(R.drawable.giant);
                        builder.setTitle("Congratulation..!Giant Win Match");
                        builder.setPositiveButton("ok", (dialog, which) -> dialog.dismiss());
                        builder.show();
                        play.setText("R-Play");
                        play.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    public void againexit(View view){
        Intent intent=new Intent(getApplicationContext(),Second.class);
        startActivity(intent);
    }

    public void again(View view){
        giant.setVisibility(View.VISIBLE);
        sunzo.setVisibility(View.INVISIBLE);
        ImageView a,s,d,f,g,h,j,k,l;
        a=findViewById(R.id.imageView101);
        s=findViewById(R.id.imageView102);
        d=findViewById(R.id.imageView103);
        f=findViewById(R.id.imageView104);
        g=findViewById(R.id.imageView105);
        h=findViewById(R.id.imageView106);
        j=findViewById(R.id.imageView107);
        k=findViewById(R.id.imageView108);
        l=findViewById(R.id.imageView109);

        a.setImageDrawable(null);
        s.setImageDrawable(null);
        d.setImageDrawable(null);
        f.setImageDrawable(null);
        g.setImageDrawable(null);
        h.setImageDrawable(null);
        j.setImageDrawable(null);
        k.setImageDrawable(null);
        l.setImageDrawable(null);

        for(int i=0;i<9;i++)
        {
            GameState[i]=2;
        }

        ActivePlayer=0;
        GameActive=true;
    }
}