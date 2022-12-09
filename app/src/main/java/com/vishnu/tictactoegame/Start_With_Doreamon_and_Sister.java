package com.vishnu.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Start_With_Doreamon_and_Sister extends AppCompatActivity {

    ImageView f,s;

    Button play,exit;

    private static final int TIME_DELAY = 1000;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_start_with_doreamon_and_sister);
        f=(ImageView)findViewById(R.id.first);

        s=(ImageView)findViewById(R.id.second);

        play=(Button) findViewById(R.id.play);

        exit=(Button) findViewById(R.id.exit);

        s.setVisibility(View.INVISIBLE);

        exit.setVisibility(View.VISIBLE);

        play.setVisibility(View.INVISIBLE);

    }
    int activeplayer=0;

    int []gamestate={2,2,2,2,2,2,2,2,2};

    int [][] winningPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    Boolean gameactive=true;

    //0=doreamon 1=doreamon_sister

    public void tap(View view)
    {
        ImageView counter=(ImageView) view;
        int tappeduser=Integer.parseInt(counter.getTag().toString());
        if(gamestate[tappeduser] ==2 && gameactive)
        {
            play.setText("Play");
            gamestate[tappeduser]=activeplayer;
            counter.setTranslationY(-1500);
            play.setVisibility(View.VISIBLE);
            if (activeplayer == 0)
            {

                counter.setImageResource(R.drawable.doreamon);
                activeplayer = 1;
                s.setVisibility(View.VISIBLE);
                f.setVisibility(View.INVISIBLE);
            }
            else
            {

                counter.setImageResource(R.drawable.doreamon_sister);
                activeplayer = 0;
                f.setVisibility(View.VISIBLE);
                s.setVisibility(View.INVISIBLE);

            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winnigPositions : winningPosition)
            {
                if(gamestate[winnigPositions[0]]==gamestate[winnigPositions[1]] && gamestate[winnigPositions[1]]==gamestate[winnigPositions[2]]  && gamestate[winnigPositions[0]] != 2)
                {
                    //codition true manje Koni Tari Jinkala AAhe re
                    gameactive=false;
                    f.setVisibility(View.INVISIBLE);
                    s.setVisibility(View.INVISIBLE);
                    if(activeplayer == 1)
                    {
                        f.setVisibility(View.VISIBLE);

                        play.setText("R-Play");
                        play.setVisibility(View.VISIBLE);
                        android.app.AlertDialog.Builder alertDialog=new android.app.AlertDialog.Builder(this);
                        alertDialog.setIcon(R.drawable.doreamon);
                        alertDialog.setTitle("Congratulation...! Doreamon Win The Match");
                        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertDialog.show();
                    }
                    else if(activeplayer==0)
                    {

                        play.setText("R-Play");
                        s.setVisibility(View.VISIBLE);
                        play.setVisibility(View.VISIBLE);
                        android.app.AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
                        alertDialog.setIcon(R.drawable.doreamon_sister);

                        alertDialog.setTitle("Congratulation...! Doreamon Sister Win The Match");
                        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertDialog.show();
                    }


                }
            }
        }
    }

    public void playAgain(View view)
    {
        f.setVisibility(View.VISIBLE);
        s.setVisibility(View.INVISIBLE);
        ImageView a,b,c,d,e,f,g,h,i;
        a=(ImageView)findViewById(R.id.imageView1);
        b=(ImageView)findViewById(R.id.imageView2);
        c=(ImageView)findViewById(R.id.imageView3);
        d=(ImageView)findViewById(R.id.imageView4);
        e=(ImageView)findViewById(R.id.imageView5);
        f=(ImageView)findViewById(R.id.imageView6);
        g=(ImageView)findViewById(R.id.imageView7);
        h=(ImageView)findViewById(R.id.imageView8);
        i=(ImageView)findViewById(R.id.imageView9);

        a.setImageDrawable(null);
        b.setImageDrawable(null);
        c.setImageDrawable(null);
        d.setImageDrawable(null);
        e.setImageDrawable(null);
        f.setImageDrawable(null);
        g.setImageDrawable(null);
        h.setImageDrawable(null);
        i.setImageDrawable(null);

        for(int j=0;j<9;j++)
        {
            gamestate[j]=2;
        }
        activeplayer=0;
        gameactive=true;

    }

    public void exit(View view)
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