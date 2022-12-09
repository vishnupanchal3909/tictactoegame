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

public class Start_With_ChootaBheem_And_Kaliya extends AppCompatActivity {

    Button exit,play;
    ImageView bhema,kaliya;
    int[] GameState={2,2,2,2,2,2,2,2,2};
    int ActivePlayer=0;
    Boolean GameActive=true;
    int [][]WinningPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_start_with_choota_bheem_and_kaliya);
        //////////////////////////////////////////////////////////////////////////////////////////////
        bhema=findViewById(R.id.first100);
        kaliya=findViewById(R.id.second100);
        exit=findViewById(R.id.exit4);
        play=findViewById(R.id.play4);
        play.setVisibility(View.INVISIBLE);
        kaliya.setVisibility(View.INVISIBLE);
    }
    public void usertap(View view)
    {
        ImageView counter=(ImageView) view;
        int tappeduser=Integer.parseInt(counter.getTag().toString());
        if(GameState[tappeduser]==2 && GameActive) {
            play.setText("Play");
            play.setVisibility(View.VISIBLE);
            GameState[tappeduser]=ActivePlayer;
            counter.setTranslationY(-1500);
            if (ActivePlayer == 0) {
                bhema.setVisibility(View.INVISIBLE);
                kaliya.setVisibility(View.VISIBLE);
                counter.setImageResource(R.drawable.bheem);
                ActivePlayer = 1;
            } else {
                bhema.setVisibility(View.VISIBLE);
                kaliya.setVisibility(View.INVISIBLE);
                counter.setImageResource(R.drawable.kaliya);
                ActivePlayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] winningposition : WinningPosition) {
                if (GameState[winningposition[0]] == GameState[winningposition[1]] && GameState[winningposition[1]] == GameState[winningposition[2]] && GameState[winningposition[0]] != 2) {
                    GameActive = false;
                    kaliya.setVisibility(View.INVISIBLE);
                    bhema.setVisibility(View.INVISIBLE);
                    if (ActivePlayer == 0)
                    {
                        kaliya.setVisibility(View.VISIBLE);
                        AlertDialog.Builder alert = new AlertDialog.Builder(this);
                        alert.setIcon(R.drawable.kaliya);
                        alert.setTitle("Congratulation...!kaliya Win Match");
                        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alert.show();
                        play.setText("R-Play");
                        play.setVisibility(View.VISIBLE);
                    }
                    else {
                        bhema.setVisibility(View.VISIBLE);
                        AlertDialog.Builder alert = new AlertDialog.Builder(this);
                        alert.setIcon(R.drawable.bheem);
                        alert.setTitle("Congratulation..!Chota Bheem Win match");
                        alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alert.show();
                        play.setText("R-Play");
                        play.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    public void repeat(View view)
    {
        bhema.setVisibility(View.VISIBLE);
        kaliya.setVisibility(View.INVISIBLE);
        ImageView z,x,c,v,b,n,m,k,l;
        z=findViewById(R.id.imageView112);
        x=findViewById(R.id.imageView21);
        c=findViewById(R.id.imageView31);
        v=findViewById(R.id.imageView41);
        b=findViewById(R.id.imageView51);
        n=findViewById(R.id.imageView61);
        m=findViewById(R.id.imageView71);
        k=findViewById(R.id.imageView81);
        l=findViewById(R.id.imageView91);

        z.setImageDrawable(null);
        x.setImageDrawable(null);
        c.setImageDrawable(null);
        v.setImageDrawable(null);
        b.setImageDrawable(null);
        n.setImageDrawable(null);
        m.setImageDrawable(null);
        k.setImageDrawable(null);
        l.setImageDrawable(null);

        for(int i=0;i<9;i++)
        {
            GameState[i]=2;
        }
        GameActive=true;
        ActivePlayer=0;
    }

    public void ppexit(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Second.class);
        startActivity(intent);
    }
}