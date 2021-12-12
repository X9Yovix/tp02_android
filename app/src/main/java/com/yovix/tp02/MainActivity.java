package com.yovix.tp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvP, tvT, res;
    private RadioButton r_cm, r_m;
    private Button btn_imc, btn_raz;

    private Button btn_edit, btn_default;
    private RadioGroup r_group;
    private LinearLayout v_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Exercice 1
        /*
        setContentView(R.layout.tp03_ex1);
        btn_edit = findViewById(R.id.btn_edit);
        btn_default = findViewById(R.id.btn_default);
        r_group = findViewById(R.id.r_group);
        v_layout = findViewById(R.id.ver_layout);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                int x = r_group.getCheckedRadioButtonId();
                switch (x) {
                    case R.id.r_jaune:
                        v_layout.setBackgroundColor(Color.YELLOW);
                        break;
                    case R.id.r_rouge:
                        v_layout.setBackgroundColor(Color.RED);
                        break;
                    case R.id.r_vert:
                        v_layout.setBackgroundColor(Color.GREEN);
                        break;
                    default:
                        // Your code
                        break;
                }
            }
        });

        btn_default.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                v_layout.setBackgroundColor(Color.WHITE);
                return true;
            }
        });

*/
        //Exercice 2
        setContentView(R.layout.tp03_ex2);

        tvP = findViewById(R.id.input_poids_l);
        tvT = findViewById(R.id.input_taille_l);

        r_cm = findViewById(R.id.r_centimetre_l);
        r_m = findViewById(R.id.r_metre_l);

        btn_imc = findViewById(R.id.btn_imc_l);
        btn_raz = findViewById(R.id.btn_raz_l);

        res = findViewById(R.id.res_cal);

        Context context = getApplicationContext();
        CharSequence text = "valuer doit etre > a 0";
        int duration = (Toast.LENGTH_SHORT);
        Toast toast = Toast.makeText(context, text, duration);

        Context context2 = getApplicationContext();
        CharSequence text2 = "your inputs are empty";
        int duration2 = (Toast.LENGTH_SHORT);
        Toast toast2 = Toast.makeText(context2, text2, duration2);

        btn_imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvP.getText().toString().isEmpty() || tvT.getText().toString().isEmpty()) {
                    toast2.show();
                } else {
                    float number1 = Float.parseFloat(tvP.getText().toString());
                    float number2 = Float.parseFloat(tvT.getText().toString());

                    if (number1 != 0 && number2 != 0) {
                        if (r_cm.isChecked()) {
                            float converted = (number2 / 100);
                            float imc = (number1 / (converted * converted));
                            double final_res = Math.round(imc);
                            res.setText(String.valueOf(final_res));
                        } else {
                            float imc = (number1 / (number2 * number2));
                            double final_res = Math.round(imc);
                            res.setText(String.valueOf(final_res));
                        }
                    } else {
                        toast.show();
                    }
                }
            }
        });

        btn_raz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvP.isFocused()) {
                    tvP.setText("");
                } else {
                    tvT.setText("");
                }
            }
        });

        tvP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (tvP.isFocused()) {
                    if (tvP.getText().toString().equals("0")) {
                        toast.show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        tvT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (tvT.isFocused()) {
                    if (tvT.getText().toString().equals("0")) {
                        toast.show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

    }
}