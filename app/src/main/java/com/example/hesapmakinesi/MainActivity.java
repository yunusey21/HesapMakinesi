package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button
            zero,
            one,
            two,
            three,
            four,
            five,
            six,
            yedi,
            eight,
            nine,
            toplama,
            cıkarma,
            bolme,
            carpma,
            esittir,
            nokta,
            clear;

    Double ilkSayi;
    TextView hesapEkrani;
    Boolean virgulDurum;
    String islemDurum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        toplama = findViewById(R.id.toplama);
        cıkarma = findViewById(R.id.cıkarma);
        bolme = findViewById(R.id.bolme);
        carpma = findViewById(R.id.carpma);
        esittir = findViewById(R.id.esittir);
        clear = findViewById(R.id.clear);
        nokta = findViewById(R.id.nokta);

        hesapEkrani = findViewById(R.id.hesapEkrani);

        hesapEkrani.setText("0");
        ilkSayi = 0.0;
        virgulDurum = false;
        islemDurum = "0";


        esittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("=");
            }
        });
        toplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("+");
            }
        });
        cıkarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("-");
            }
        });
        carpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("*");
            }
        });
        bolme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("/");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL("sifirla");
            }
        });
        nokta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_SEMBOL(".");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(0);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TIKLA_NUMARA(9);
            }
        });
    }

    private void TIKLA_NUMARA(int sayi) {
        if (hesapEkrani.getText().toString() == "0") {
            hesapEkrani.setText("");
        } else if (
                hesapEkrani.getText().toString() == "+" ||
                        hesapEkrani.getText().toString() == "*" ||
                        hesapEkrani.getText().toString() == "/" ||
                        hesapEkrani.getText().toString() == "-") {
            hesapEkrani.setText("");
        }
        hesapEkrani.setText(hesapEkrani.getText() + String.valueOf(sayi));
    }

    private void TIKLA_SEMBOL(String sembol) {
        switch (sembol) {
            default: {
                if (hesapEkrani.getText().toString() == "+" || hesapEkrani.getText().toString() == "*"
                        || hesapEkrani.getText().toString() == "/" || hesapEkrani.getText().toString() == "-") {
                    if (islemDurum == "*" || islemDurum == "/")
                        ilkSayi = -1 * ilkSayi;

                    hesapEkrani.setText(sembol);
                    islemDurum = sembol;
                } else {
                    ilkSayi = Double.parseDouble(hesapEkrani.getText().toString());
                    hesapEkrani.setText(sembol);
                    islemDurum = sembol;
                }
            }
            break;
            case "sifirla": {
                ilkSayi = 0.0;
                hesapEkrani.setText("0");
                islemDurum = "0";
            }
            break;
            case "=": {
                if (hesapEkrani.getText().toString() == "+" || hesapEkrani.getText().toString() == "*"
                        || hesapEkrani.getText().toString() == "/" || hesapEkrani.getText().toString() == "-") {

                } else {
                    switch (islemDurum) {
                        default: {
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "+": {
                            ilkSayi = ilkSayi + Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "-": {
                            ilkSayi = ilkSayi - Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "/": {
                            ilkSayi = ilkSayi / Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "*": {
                            ilkSayi = ilkSayi * Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                    }
                }


            }
            break;
            case ",": {

            }
            break;
        }
    }
}
