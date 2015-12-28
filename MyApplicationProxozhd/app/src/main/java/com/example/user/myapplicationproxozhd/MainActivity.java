package com.example.user.myapplicationproxozhd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String s;
    private int current=1;
    private TextView nom;
    public LinearLayout linner;
    private AbsListView.LayoutParams lpView;
    private int n;
    private TextView vpp;
    private String[][] str=new String[1000][100];
    private int[] countq=new int[1050];
    private int[] tr=new int[1000];
    private int[] tr2=new int[1000];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScrollView scr=(ScrollView)findViewById(R.id.scrollView);
         linner=(LinearLayout)findViewById(R.id.lin);
         vpp=(TextView)findViewById(R.id.textView3);
        nom=(TextView)findViewById(R.id.textView2);
        s="3☺3☺2+2*2☺Я не знаю, я  гуманитарий☺6☺я не знаю я работник mail.ru☺2☺3☺Вопрос2☺Ответ1☺Ответ2☺Ответ3☺1☺8☺Вопрос3☺Ответ1☺Ответ2☺Ответ3☺Ответ4☺Ответ5☺Ответ6☺Ответ7☺Ответ8☺1☺";
        lpView = new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT,
                AbsListView.LayoutParams.WRAP_CONTENT);
        parr(s);
        current=1;
        prr();

    }
    private void parr(String s)
    {
        int a,b,c;
        String s1,s2,s3;
        s3=s;
        a=s.indexOf("☺",0);
        s2=(s.substring(0,a));
        n= new Integer(s2);
        for (int i=1;i<=n;i++)
        {
             b=s.indexOf("☺",a+1);
            s2=s.substring(a+1,b);
             c=new Integer(s2);
            countq[i]=c;
            a=b;
            for (int j=0;j<=c;j++)
            {
                 b=s.indexOf("☺",a+1);
                s2=s.substring(a+1,b);
                str[i][j]=s2;
                a=b;
            }
             b=s.indexOf("☺",a+1);
            s2=s.substring(a+1,b);
             c= new Integer(s2);
            tr[i]=c;
            a=b;
        }

    }





    public void prr()
    {
        vpp.setText(str[current][0]);
        nom.setText("Вопрос"+Integer.toString(current)+"/"+Integer.toString(n));
        for (int i=1;i<=countq[current];i++){

            LinearLayout line=new LinearLayout(this);
            line.setOrientation(LinearLayout.HORIZONTAL);

            line.setId(current * 1000000 + 500000 + i);
            linner.addView(line);

            TextView vop=new TextView(this);
            vop.setText(str[current][i]);
            vop.setMaxLines(1);
            vop.setMaxWidth(270);
            vop.setMinWidth(270);
            vop.setLayoutParams(lpView);
            vop.setId(current * 1000000 + 100000 + i);
            line.addView(vop);





            RadioButton rb=new RadioButton(this);


            int rid=current*1000000+300000+i;
            rb.setId(rid);
            if (i==1){ rb.setChecked(true);tr2[current]=rid;}


            rb.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {

                            if (tr2[current] != 0) {

                                RadioButton r = (RadioButton) findViewById(tr2[current]);
                                r.setChecked(false);
                            }


                            ((RadioButton) v).setChecked(true);
                            tr2[current] = v.getId();
                        }
                    }


            );
            line.addView(rb, lpView);




















        }






    }

    public void otv(View v)
    {
        if (current==n)
        {

            Button b=(Button) findViewById(R.id.button5);
            b.setText("Поделиться с друзьями");
            linner.removeAllViews();
            nom.setText("Результаты");

            int a=0;
            for(int i=1;i<=n;i++)
            {
                if (tr2[i]%10000==tr[i])
                {
                    a++;
                }
            }

            double f;
            f=100*(float)a/(float)n;

            vpp.setText("Правильно "+a+"из "+n+"\n" +f+"%");
            return;
        }
        linner.removeAllViews();
        if (current<n)
        {
            current++;
        }
        if (current==n)
        {
            Button b=(Button) findViewById(R.id.button5);
            b.setText("Завершить");
        }

        prr();

    }





















}
