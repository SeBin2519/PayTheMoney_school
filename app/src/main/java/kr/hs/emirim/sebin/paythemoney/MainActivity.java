package kr.hs.emirim.sebin.paythemoney;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

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
/*public class MainActivity extends AppCompatActivity
{
    ActionBar actionBar;  //ActionBar 참조변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Activity 객체는 이미 ActionBar를 가지고 있으므로
        //이미 존해하는 ActionBar 객체를 얻어오기.(API 10버전 이상에서 사용가능)
        actionBar= getActionBar();

        //ActionBar가 Tab를 보여줄 수 있는 모양이 되도록 설정
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        //ActionBar에 추가 될 Tab 참조변수
        android.app.ActionBar.Tab tab=null;

        //첫번째 Tab 객체 생성 및 ActionBar에 추가하기
        tab= actionBar.newTab(); //ActionBar에 붇는 Tab객체 생성
        tab.setText("더치 페이");    //Tab에 보여지는 글씨
        //Tab의 선택이 변경되는 것을 인지하는 TabListener 설정(아래쪽 객체 생성 코드 참고)
        tab.setTabListener(listener);
        //ActionBar에 Tab 추가
        actionBar.addTab(tab);

        //두번째 Tab 객체 생성 및 ActionBar에 추가하기
        tab= actionBar.newTab();//ActionBar에 붇는 Tab객체 생성
        tab.setText("몰빵");   //Tab에 보여지는 글씨
        //Tab의 선택이 변경되는 것을 인지하는 TabListener 설정(아래쪽 객체 생성 코드 참고)
        tab.setTabListener(listener);
        //ActionBar에 Tab 추가
        actionBar.addTab(tab);

        //세번째 Tab 객체 생성 및 ActionBar에 추가하기
        tab= actionBar.newTab(); //ActionBar에 붇는 Tab객체 생성
        tab.setText("랜덤");   //Tab에 보여지는 글씨
        //Tab의 선택이 변경되는 것을 인지하는 TabListener 설정(아래쪽 객체 생성 코드 참고)
        tab.setTabListener(listener);
        //ActionBar에 Tab 추가
        actionBar.addTab(tab);


    }

    @Override
    protected void onResume() { //화면이 보여질 떄마다 실행, 액티비티가 다시 재개될때
        super.onResume();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    //Tab의 선택변화를 인지하는 Listener 객체 생성
    //(Button의 onClickListner 처럼 생각하시면 됩니다.)
    ActionBar.TabListener listener= new ActionBar.TabListener() {

        //Tab의 선택이 벗어날 때 호출
        //첫번째 파라미터 : 선택에서 벗어나는 Tab 객체
        //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)
        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            // TODO Auto-generated method stub

        }

        //Tab이 선택될 때 호출
        //첫번째 파라미터 : 선택된 Tab 객체
        //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            // TODO Auto-generated method stub

            //선택된 Tab객체의 위치값(왼족 처음부터 0,1,2....순으로 됨)
            int position = tab.getPosition();

            switch( position ){
                case 0: //가장 왼쪽 Tab 선택(Analog)

                    //MainActivity가 보여 줄 View를
                    //res폴더>>layout폴더>>layout_tab_0.xml 로 설정
                    setContentView(R.layout.douch);
                    //break;
                    //Intent intent =new Intent(this,Douch.class);
                    //startActivity(intent);
                    //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    break;

                case 1: //두번째 Tab 선택(Digital)

                    //MainActivity가 보여 줄 View를
                    //res폴더>>layout폴더>>layout_tab_1.xml 로 설정
                    setContentView(R.layout.mol);
                    //break;
                    //Intent intent1 =new Intent(this,Mol.class);
                    //startActivity(intent1);
                    //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    break;

                case 2: //세번째 Tab 선택(Calendar)

                    //MainActivity가 보여 줄 View를
                    //res폴더>>layout폴더>>layout_tab_2.xml 로 설정
                    setContentView(R.layout.random);
                    //break;
                    //Intent intent2 =new Intent(this,RandomMenu.class);
                    //startActivity(intent2);
                    //overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    break;
            }


        }

        //Tab이 재 선택될 때 호출
        //첫번째 파라미터 : 재 선택된 Tab 객체
        //두번째 파라미터 : Tab에 해당하는 View를 Fragment로 만들때 사용하는 트랜젝션.(여기서는 사용X)
        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            // TODO Auto-generated method stub

        }
    };
}
*/

