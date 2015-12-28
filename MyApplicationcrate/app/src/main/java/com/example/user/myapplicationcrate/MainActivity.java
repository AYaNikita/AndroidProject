package com.example.user.myapplicationcrate;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int current = 1;
    private TextView nom;
    private EditText vpp;
    private LinearLayout linner;
    AbsListView.LayoutParams lpView;

    private String[][] str = new String[1000][100];
    private int[] countq = new int[1050];
    private int[] tr = new int[1000];
    private int pr;
    private String name_test = new String();
    private String category = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main2);
        nom = (TextView) findViewById(R.id.textView2);
        vpp = (EditText) findViewById(R.id.editText);
        linner = (LinearLayout) findViewById(R.id.lin);

        RadioGroup gr = new RadioGroup(this);
        tr[1] = 0;
        lpView = new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT,
                AbsListView.LayoutParams.WRAP_CONTENT);

        RadioButton rr = (RadioButton) findViewById(R.id.radio1);
        rr.setId(1);
        rr = (RadioButton) findViewById(R.id.radio2);
        rr.setId(2);
        rr = (RadioButton) findViewById(R.id.radio3);
        rr.setId(3);
        rr = (RadioButton) findViewById(R.id.radio4);
        rr.setId(4);
        rr = (RadioButton) findViewById(R.id.radio5);
        rr.setId(5);

        pr = 1;
    }

    public void onleftclick(View view) {
        if (current == 1) {
            return;
        }
        grr();
        current--;
        nom.setText("Вопрос№" + current);
        linner.removeAllViews();
        prr();

    }

    public void onrightclick(View view) {
        if (current == 999) {
            return;
        }
        grr();
        current++;
        nom.setText("Вопрос№" + current);
        linner.removeAllViews();
        prr();


    }

    public void newvariant(View v) {
        countq[current]++;
        printvv();
    }

    public void printvv() {
        //LinearLayout mainL = (LinearLayout) findViewById(R.id.scrollView);
        //AbsListView.LayoutParams viewParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT);
        //ScrollView scroll=(ScrollView) findViewById(R.id.scrollView);


        // AbsListView.LayoutParams linLayoutParam = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);
        // устанавливаем linLayout как корневой элемент экрана
        LinearLayout line = new LinearLayout(this);
        line.setOrientation(LinearLayout.HORIZONTAL);

        line.setId(current * 1000000 + 500000 + countq[current]);
        linner.addView(line);


        EditText vop = new EditText(this);
        vop.setText("Ответ");
        vop.setMaxLines(1);
        vop.setMaxWidth(270);
        vop.setMinWidth(270);
        vop.setLayoutParams(lpView);
        vop.setId(current * 1000000 + 100000 + countq[current]);
        line.addView(vop);

        Button btn = new Button(this);
        btn.setText("Удалить");
        btn.setId(current * 1000000 + 200000 + countq[current]);
        btn.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        int idd = v.getId();

                        countq[current]--;


                        for (int i = idd % 10000; i <= countq[current]; i++) {
                            /*
                            LinearLayout le1=(LinearLayout) (findViewById(i+1200000+300000+1));
                            le1.setId(i+1000000+300000);
                            EditText e1=( EditText) (findViewById(i+1200000-100000+1));
                            e1.setId(i+1200000+100000);
                            Button b1=( Button) (findViewById(i+1200000+1));
                            b1.setId(i+1200000);
                            RadioButton r1=( RadioButton) (findViewById(i+1200000+100000+1));
                            r1.setId(i + 1200000 + 100000);
                            */
                            EditText e1 = (EditText) (findViewById(i + 1000000 * current + 200000 - 100000));
                            EditText e2 = (EditText) (findViewById(i + current * 1000000 + 200000 - 100000 + 1));
                            e1.setText(e2.getText());

                        }
                        int a = v.getId() % 10000;
                        linner.removeViewAt(countq[current]);
                        if (countq[current] == 0) {

                            tr[current] = 0;
                            return;
                        }
                        if (idd == countq[current] + 1) {
                            tr[current] = 1 + 1000000 * current + 300000;
                            RadioButton r1 = (RadioButton) (findViewById(1 + 1000000 * current + 300000));
                            r1.setChecked(true);
                            return;
                        }
                        if (countq[current] >= idd % 10000) {
                            RadioButton r5 = (RadioButton) (findViewById(idd % 10000 + 1000000 * current + 300000));
                            r5.setChecked(false);
                        }
                        if (tr[current] == current * 1000000 + 300000 + (idd % 1000) && countq[current] > 0) {

                            int a1 = tr[current];
                            tr[current] = 1 + current * 1000000 + 300000;
                            RadioButton r1 = (RadioButton) (findViewById(1 + current * 1000000 + 300000));
                            r1.setChecked(true);
                            if (countq[current] < a) return;
                            if (a1 % 10000 == 1) return;
                            RadioButton r2 = (RadioButton) (findViewById(a1));
                            r2.setChecked(false);
                            return;
                        }


                        if (tr[current] > current * 1000000 + 300000 + (idd % 1000) && countq[current] > 0) {
                            tr[current]--;

                            RadioButton r1 = (RadioButton) (findViewById(tr[current]));
                            r1.setChecked(true);
                            if (countq[current] < (tr[current] % 1000) + 1) return;
                            RadioButton r2 = (RadioButton) (findViewById(tr[current] + 1));
                            r2.setChecked(false);

                        }


                        if (countq[current] == 0) {
                            tr[current] = 0;
                        }


                    }
                }


        );


        line.addView(btn, lpView);

        RadioButton rb = new RadioButton(this);


        int rid = current * 1000000 + 300000 + countq[current];
        rb.setId(rid);

        if (countq[current] == 1 && tr[current] == 0) {
            rb.setChecked(true);
            tr[current] = rid;
        }

        rb.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (tr[current] != 0) {

                            RadioButton r = (RadioButton) findViewById(tr[current]);
                            r.setChecked(false);
                        }


                        ((RadioButton) v).setChecked(true);
                        tr[current] = v.getId();
                    }
                }


        );
        line.addView(rb, lpView);

    }

    public void check() {

    }


    public void prr() {
        vpp.setText(str[current][0]);
        for (int i = 1; i <= countq[current]; i++) {

            LinearLayout line = new LinearLayout(this);
            line.setOrientation(LinearLayout.HORIZONTAL);

            line.setId(current * 1000000 + 500000 + i);
            linner.addView(line);

            EditText vop = new EditText(this);
            vop.setText(str[current][i]);
            vop.setMaxLines(1);
            vop.setMaxWidth(270);
            vop.setMinWidth(270);
            vop.setLayoutParams(lpView);
            vop.setId(current * 1000000 + 100000 + i);
            line.addView(vop);

            Button btn = new Button(this);
            btn.setText("Удалить");
            btn.setId(current * 1000000 + 200000 + i);

            int ggg = i;
            btn.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            int idd = v.getId();

                            countq[current]--;


                            for (int i = idd % 10000; i <= countq[current]; i++) {

                                EditText e1 = (EditText) (findViewById(i + 1000000 * current + 200000 - 100000));
                                EditText e2 = (EditText) (findViewById(i + current * 1000000 + 200000 - 100000 + 1));
                                e1.setText(e2.getText());

                            }
                            int a = v.getId() % 10000;
                            linner.removeViewAt(countq[current]);
                            if (countq[current] == 0) {

                                tr[current] = 0;
                                return;
                            }
                            if (idd == countq[current] + 1) {
                                tr[current] = 1 + 1000000 * current + 300000;
                                RadioButton r1 = (RadioButton) (findViewById(1 + 1000000 * current + 300000));
                                r1.setChecked(true);
                                return;
                            }
                            if (countq[current] >= idd % 10000) {
                                RadioButton r5 = (RadioButton) (findViewById(idd % 10000 + 1000000 * current + 300000));
                                r5.setChecked(false);
                            }
                            if (tr[current] == current * 1000000 + 300000 + (idd % 1000) && countq[current] > 0) {

                                int a1 = tr[current];
                                tr[current] = 1 + current * 1000000 + 300000;
                                RadioButton r1 = (RadioButton) (findViewById(1 + current * 1000000 + 300000));
                                r1.setChecked(true);
                                if (countq[current] < a) return;
                                if (a1 % 10000 == 1) return;
                                RadioButton r2 = (RadioButton) (findViewById(a1));
                                r2.setChecked(false);
                                return;
                            }


                            if (tr[current] > current * 1000000 + 300000 + (idd % 1000) && countq[current] > 0) {
                                tr[current]--;

                                RadioButton r1 = (RadioButton) (findViewById(tr[current]));
                                r1.setChecked(true);
                                if (countq[current] < (tr[current] % 1000) + 1) return;
                                RadioButton r2 = (RadioButton) (findViewById(tr[current] + 1));
                                r2.setChecked(false);

                            }


                            if (countq[current] == 0) {
                                tr[current] = 0;
                            }


                        }
                    }


            );


            line.addView(btn, lpView);

            RadioButton rb = new RadioButton(this);


            int rid = current * 1000000 + 300000 + i;
            rb.setId(rid);
            if (rid == tr[current]) {
                rb.setChecked(true);
            }

            if (i == 1 && tr[current] == 0) {
                rb.setChecked(true);
                tr[current] = rid;
            }

            rb.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {

                            if (tr[current] != 0) {

                                RadioButton r = (RadioButton) findViewById(tr[current]);
                                r.setChecked(false);
                            }


                            ((RadioButton) v).setChecked(true);
                            tr[current] = v.getId();
                        }
                    }


            );
            line.addView(rb, lpView);


        }


    }

    public void grr() {
        str[current][0] = vpp.getText().toString();
        for (int i = 1; i <= countq[current]; i++) {
            EditText ed = (EditText) findViewById(i + current * 1000000 + 100000);
            str[current][i] = ed.getText().toString();
        }

    }

    public void drr(View v) {

        tr[current] = 0;
        vpp.setText("Вопрос");
        linner.removeAllViews();
        countq[current] = 0;
    }


    public void crr(View v) {
        grr();

        String s, s1, s2;
        s1 = new String();
        s = new String();
        int n = 0;
        for (int i = 1; i <= 1000; i++) {
            if (countq[i] != 0) {
                n++;
                s1 = Integer.toString(countq[i]);
                if (str[i][0].equals("")) str[i][0] = "Вопрос";
                s = s + s1 + "☺" + str[i][0] + "☺";
                for (int j = 1; j <= countq[i]; j++) {
                    s = s + str[i][j] + "☺";
                }
                s1 = Integer.toString(tr[i] % 1000);
                s = s + s1 + "☺";
            }
        }
        s = Integer.toString(n) + "☺" + s;
        int a = 18;
    }


    public void gb(View v) {

        RadioButton r = (RadioButton) findViewById(pr);
        r.setChecked(false);
        pr = v.getId();
        ((RadioButton) v).setChecked(true);

    }

    public void nx(View v) {

        EditText ed = (EditText) findViewById(R.id.editText2);

        name_test = ed.getText().toString();
        if (name_test.equals("")) name_test = "unknown";
        switch (pr) {
            case 1:
                category = "кино";
                break;
            case 2:
                category = "музыка";
                break;
            case 3:
                category = "спорт";
                break;
            case 4:
                category = "фильмы";
                break;
            case 5:
                category = "разное";
                break;
        }
        setContentView(R.layout.activity_main);


    }

}
