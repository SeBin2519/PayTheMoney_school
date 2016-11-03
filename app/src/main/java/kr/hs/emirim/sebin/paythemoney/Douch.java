package kr.hs.emirim.sebin.paythemoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.AppOpsManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Douch extends AppCompatActivity implements View.OnClickListener{
    ViewFlipper vFlipper;
    TextView textresult;
    Button butCheck,butCancel;
    EditText editPerson,editPrice;
    int person=0,price=0;
    int douchMoney=0;
    int change=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.douch);

        editPerson = (EditText) findViewById(R.id.edit_person);
        editPrice = (EditText) findViewById(R.id.edit_price);
       textresult=(TextView)findViewById(R.id.text_result);
        vFlipper =(ViewFlipper)findViewById(R.id.view_flip);
        butCheck =(Button)findViewById(R.id.but_douch_check);
        butCheck.setOnClickListener(this);
        butCancel =(Button)findViewById(R.id.but_douch_delete);
        butCancel.setOnClickListener(this);

        //person=Integer.parseInt(editPerson.getText().toString());
        //price=Integer.parseInt(editPrice.getText().toString());
        vFlipper.setVisibility(View.INVISIBLE);
    }

   public void startRoulette(int person,int price){
        douchMoney=price/person;
        change=price-(douchMoney*person);

        if(change==0) {///남은 돈이 없다면
            // mImageView.setImageResource(R.drawable.);
            Toast.makeText(this," 더치 페이 결과:"+douchMoney+"원을 내주세요~",Toast.LENGTH_LONG).show();
            //TextView에 result설정
            textresult.setText(" * 한 사람 당 "+douchMoney+"원을 내야합니다!");

        }
        else {
            //Toast.makeText(this," 더치 페이 결과:"+douchMoney+"원을 내주세요~",Toast.LENGTH_LONG).show();
            textresult.setText(" * 한 사람 당 "+douchMoney+"원을 내고 "+change+"원이 남았습니다!");
            int perIndex = (int)Math.random()%person+1;
            vFlipper.setVisibility(View.VISIBLE);
            Toast.makeText(this,"잔돈 룰렛결과:"+perIndex+"번쨰 사람이 남은돈을 내주세요!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        String epMon=editPerson.getText().toString();
        person=Integer.parseInt(epMon);
        String erMon=editPrice.getText().toString();
        price=Integer.parseInt(erMon);

        switch(v.getId()){
            case R.id.but_douch_check:
                startRoulette(person,price);
                break;
            case R.id.but_douch_delete:
                editPerson.setText("");
                editPrice.setText("");
                break;
        }
    }
}
