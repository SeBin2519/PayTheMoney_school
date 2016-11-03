package kr.hs.emirim.sebin.paythemoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton but_douch = (ImageButton) findViewById(R.id.but_douch);
        ImageButton but_mol = (ImageButton) findViewById(R.id.but_mol);
        ImageButton but_random = (ImageButton) findViewById(R.id.but_random);

        but_douch.setOnClickListener(this);
        but_mol.setOnClickListener(this);
        but_random.setOnClickListener(this);
    }

    @Override
    protected void onResume() { //화면이 보여질 떄마다 실행, 액티비티가 다시 재개될때
        super.onResume();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but_douch:
                Intent intent =new Intent(this,Douch.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                break;
            case R.id.but_mol:
                Intent intent1 =new Intent(this,Mol.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                break;
            case R.id.but_random:
                Intent intent2 =new Intent(this,RandomMenu.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                break;
        }
    }
}
