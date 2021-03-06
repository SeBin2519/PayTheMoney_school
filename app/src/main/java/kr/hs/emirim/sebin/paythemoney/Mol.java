package kr.hs.emirim.sebin.paythemoney;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Mol extends AppCompatActivity implements View.OnClickListener{
    ViewFlipper vFlipper;
    TextView textresult;
    Button butStart,butStop;
    EditText editPerson;
    int perIndex;
    int personNum=0;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this,"각자 번호를 정해 주십시오.",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);
        setContentView(R.layout.mol);

        editPerson = (EditText) findViewById(R.id.edit_person);
        textresult=(TextView)findViewById(R.id.text_result);
        vFlipper =(ViewFlipper)findViewById(R.id.view_flip);
        butStart =(Button)findViewById(R.id.but_start);
        butStart.setOnClickListener(this);
        butStop =(Button)findViewById(R.id.but_stop);
        butStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String person=editPerson.getText().toString();

        switch(view.getId()){
            case R.id.but_start:
                textresult.setText("");
                if(person.equals(""))
                    Toast.makeText(this,"제대로 된 값을 입력해 주세요!",Toast.LENGTH_LONG).show();
                else {
                    personNum=Integer.parseInt(person);
                    vFlipper.setFlipInterval(50);//viewFlipper에 넘겨지는 간격 설정 => 1000: 1초
                    vFlipper.startFlipping();
                    perIndex = (int)(Math.random()*personNum)+1;
                }
                break;
            case R.id.but_stop:
                vFlipper.stopFlipping();
                //Toast.makeText(this,perIndex+"번째 사람이 걸렸습니다!!",Toast.LENGTH_SHORT).show();
                textresult.setText(" 걸린 사람: "+perIndex+"번째 사람!");
                mp = MediaPlayer.create(this, R.raw.clap);
                mp.setLooping(true);
                mp.start();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mp.stop();
                break;
        }
    }
}
