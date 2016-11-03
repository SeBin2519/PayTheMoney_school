package kr.hs.emirim.sebin.paythemoney;

import android.content.Intent;
import android.os.Bundle;
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
    Button butCheck,butCancel;
    EditText editPerson;

    int molMoney=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mol);

        editPerson = (EditText) findViewById(R.id.edit_person);
        textresult=(TextView)findViewById(R.id.text_result);
        vFlipper =(ViewFlipper)findViewById(R.id.view_flip);
        butCheck =(Button)findViewById(R.id.but_mol_check);
        butCheck.setOnClickListener(this);
        butCancel =(Button)findViewById(R.id.but_mol_delete);
        butCancel.setOnClickListener(this);

        //molMoney=Integer.parseInt(editPerson.getText().toString())
    }

    public void startMolRoulette(int molMoney){
            //Toast.makeText(this," 더치 페이 결과:"+douchMoney+"원을 내주세요~",Toast.LENGTH_LONG).show()
            int perIndex = (int)(Math.random()%molMoney+1);
            textresult.setText(" * 걸린 사람: "+perIndex+"번째 사람!!");
            Toast.makeText(this,"룰렛결과:"+perIndex+"번쨰 사람이 돈을 내주세요!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        String mMon=editPerson.getText().toString();
        molMoney=Integer.parseInt(mMon);
        switch(view.getId()){
            case R.id.but_mol_check:
                startMolRoulette(molMoney);
                break;
            case R.id.but_mol_delete:
                editPerson.setText("");
                break;
        }
    }
}
