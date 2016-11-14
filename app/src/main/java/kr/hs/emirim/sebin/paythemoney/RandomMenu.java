package kr.hs.emirim.sebin.paythemoney;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Random;

public class RandomMenu extends AppCompatActivity implements View.OnClickListener{
    Button but_ok,but_cancel;
    EditText editPersonNum,editPrice;
    TextView textResult;
    String result="";

    int people=0;
    int price=0;
    int lastPrice=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this,"각자 번호를 정해 주십시오.",Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);

        but_ok=(Button)findViewById(R.id.but_random_ok);
        but_cancel=(Button)findViewById(R.id.but_random_cancel);

        editPersonNum=(EditText)findViewById(R.id.edit_personNum);
        editPrice=(EditText)findViewById(R.id.edit_price);

        textResult=(TextView)findViewById(R.id.text_result);

        but_ok.setOnClickListener(this);
        but_cancel.setOnClickListener(this);
    }
    /**
     * Called when a view has been clicked.
     *
     * @paramv The view that was clicked.
     * */

    void showResult(int editPersonNum,int editPrice){
        //   2개의 EditText에 입력된 값을 반환받는다.
        people=editPersonNum;
        price=editPrice;
        lastPrice=price;
        int i=0;

        int randomPrice[]=new int[people];

        //int randomPrice2[]=new int[people];

        for(i=0;i<people;i++) {
            randomPrice[i]=0;
            //randomPrice2[i]=0;
        }

        i=0;
        while(lastPrice!=0){
            if(i==(people-1)) {
                randomPrice[i] = lastPrice;
                break;
            }
            randomPrice[i] = ((int) (Math.random() * lastPrice)+100);
            lastPrice-=randomPrice[i];

            if(randomPrice[i]%100!=0){
                lastPrice+=randomPrice[i]%100;
                randomPrice[i]-=randomPrice[i]%100;
            }
            i++;
        }

        /*for(i=0;i<people;i++) //채워진 배열을 출력하기 위한 for문
        {
            randomPrice2[i]=randomPrice[i];
        }*/

        ArrayList<Integer> is = new ArrayList<Integer>();
        for(i=0;i<people;i++)
            is.add(randomPrice[i]);

        Log.v("*^^* Collection Value: ",is.toString());
        Collections.shuffle(is);

        for(i=0;i<people;i++){ //채워진 배열을 출력하기 위한 for문
            result += "No. " + (i + 1) + " :  " + is.get(i) + "원\n";
        }
    }

    @Override
    public void onClick(View v) {
        String editPersonNumStr=editPersonNum.getText().toString();
        String editPriceStr=editPrice.getText().toString();
        String textResultStr=textResult.getText().toString();

        int iEditPersonNumStr=0;
        int iEditPriceStr=0;

        switch(v.getId()){
            case R.id.but_random_ok:
                if(!textResult.equals("")) {
                    result="";
                    textResult.setText("");
                }
              if (editPersonNumStr.equals("") || editPrice==null) {
                  Toast.makeText(this,"제대로 된 값을 입력해 주세요!",Toast.LENGTH_LONG).show();
                  textResult.setText("");
              }
              else {
                  iEditPersonNumStr=Integer.parseInt(editPersonNumStr);
                  iEditPriceStr=Integer.parseInt(editPriceStr);
                  showResult(iEditPersonNumStr, iEditPriceStr);
                  textResult.setText(result);
              }
                break;
            case R.id.but_random_cancel:
                people=0;
                price=0;
                lastPrice=0;
                result="";
                editPersonNum.setText("");
                editPrice.setText("");
                textResult.setText("");

                break;
        }
    }
}
