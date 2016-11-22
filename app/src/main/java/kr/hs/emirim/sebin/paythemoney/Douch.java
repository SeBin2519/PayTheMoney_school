package kr.hs.emirim.sebin.paythemoney;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.AppOpsManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Douch extends AppCompatActivity implements View.OnClickListener{
    ViewFlipper vFlipper;
    TextView textresult1,textresult2;
    Button butCheck,butCancel,butStart,butStop;
    EditText editPerson,editPrice;
    LinearLayout linearLayout;
    //ImageView img;
    int person=0,price=0;
    int douchMoney=0;
    int change=0;
    int c;
    int perIndex;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this,"각자 번호를 정해 주십시오.",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.douch);

        editPerson = (EditText) findViewById(R.id.edit_person);
        editPrice = (EditText) findViewById(R.id.edit_price);
        textresult1=(TextView)findViewById(R.id.text_result1);
        textresult2=(TextView)findViewById(R.id.text_result2);
        vFlipper =(ViewFlipper)findViewById(R.id.view_flip);
        butCheck =(Button)findViewById(R.id.but_douch_check);
        butCheck.setOnClickListener(this);
        butCancel =(Button)findViewById(R.id.but_douch_delete);
        butCancel.setOnClickListener(this);
        butStart =(Button)findViewById(R.id.but_start);
        butStart.setOnClickListener(this);
        butStop =(Button)findViewById(R.id.but_stop);
        butStop.setOnClickListener(this);
        linearLayout=(LinearLayout)findViewById(R.id.layout);
        //img=(ImageView)findViewById(R.id.img);

        //person=Integer.parseInt(editPerson.getText().toString());
        //price=Integer.parseInt(editPrice.getText().toString());
        vFlipper.setVisibility(View.INVISIBLE);
        butStart.setVisibility(View.INVISIBLE);
        butStop.setVisibility(View.INVISIBLE);
    }

   public void startRoulette(int person,int price){
       this.person=person;
       this.price=price;

       c=(price/person)%100;
       douchMoney=(price/person)-c;
       change=price-(person*douchMoney);

       textresult1.setText("n/1결과: "+douchMoney+"원!");

        if(change==0) {///남은 돈이 없다면
            vFlipper.setVisibility(View.INVISIBLE);
            butStart.setVisibility(View.INVISIBLE);
            butStop.setVisibility(View.INVISIBLE);
        }
        else {//남은 돈이 있다면 룰렛
            LinearLayout.LayoutParams r_p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
           linearLayout.setLayoutParams(r_p);
            vFlipper.setVisibility(View.VISIBLE);
            butStart.setVisibility(View.VISIBLE);
            butStop.setVisibility(View.VISIBLE);
            //img.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        String epMon=editPerson.getText().toString();
        String erMon=editPrice.getText().toString();

        switch(v.getId()){
            case R.id.but_douch_check:
                textresult1.setText("");
                if(epMon.equals("")&& erMon.equals("")) Toast.makeText(this,"제대로 된 값을 입력해 주세요!",Toast.LENGTH_LONG).show();
                else{
                    person=Integer.parseInt(epMon);
                    price=Integer.parseInt(erMon);
                    startRoulette(person, price);
                }
                break;
            case R.id.but_douch_delete:
                editPerson.setText("");
                editPrice.setText("");
                textresult1.setText("");
                textresult2.setText("");
                LinearLayout.LayoutParams r_p2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                linearLayout.setLayoutParams(r_p2);
                vFlipper.setVisibility(View.INVISIBLE);
                butStart.setVisibility(View.INVISIBLE);
                butStop.setVisibility(View.INVISIBLE);
                //img.setVisibility(View.VISIBLE);
                break;
            case R.id.but_start:
                perIndex = (int)(Math.random()*person)+1;
                vFlipper.setFlipInterval(50);//viewFlipper에 넘겨지는 간격 설정 => 1000: 1초
                vFlipper.startFlipping();
                break;
            case R.id.but_stop:
                vFlipper.stopFlipping();
                textresult2.setText("잔돈: "+change+"원   "+"\n"+"잔돈은 "+perIndex+"번째 사람이 내주세요!");
                mp = MediaPlayer.create(this, R.raw.clap);
                mp.setLooping(true);
                mp.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mp.stop();
        }
    }
}
