package com.geekbrains.weathergeek;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private String cityName;
    private ImageButton imageButtonMoscow;
    private ImageButton imageButtonNewYork;
    private ImageButton imageButtonLondon;
    private TextView textView;
    private TextView textViewCurrentDay;
    private TextView textViewFutureDay;
    private TextView textViewDoubleFutureDay;
    private TextView textViewCurrentTemp;
    private TextView textViewFutureTemp;
    private TextView textViewDoubleFutureTemp;
    private TextView textViewCurrentDate;
    private TextView textViewNextDate;
    private TextView textViewDNextDate;
    private ImageView imageCurrentDay;
    private ImageView imageFutureDay;
    private ImageView imageDoubleFutureDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnImgBtnMoscowClickBehaviour();
        setOnImgBtnNewYorkClickBehaviour();
        setOnImgBtnLondonClickBehaviour();
        imageButtonMoscow.callOnClick();
        currentDay();
        setTemp("Moscow");
    }

    /*Метод задания рандомной температуры*/
    private void setTemp(String cityName) {
        String currentTemp;
        String futureTemp;
        String doubleFutureTemp;

        switch (cityName) {
            case "Moscow" :
                currentTemp = "28 C";
                textViewCurrentTemp.setText(currentTemp);

                futureTemp = "22 C";
                textViewFutureTemp.setText(futureTemp);

                doubleFutureTemp = "18 C";
                textViewDoubleFutureTemp.setText(doubleFutureTemp);

                imageCurrentDay.setImageResource(R.drawable.sun);
                imageFutureDay.setImageResource(R.drawable.cloudysun);
                imageDoubleFutureDay.setImageResource(R.drawable.storm);
                break;

            case "NewYork" :
                currentTemp = "31 C";
                textViewCurrentTemp.setText(currentTemp);

                futureTemp = "29 C";
                textViewFutureTemp.setText(futureTemp);

                doubleFutureTemp = "30 C";
                textViewDoubleFutureTemp.setText(doubleFutureTemp);

                imageCurrentDay.setImageResource(R.drawable.sun);
                imageFutureDay.setImageResource(R.drawable.cloudysun);
                imageDoubleFutureDay.setImageResource(R.drawable.sun);
                break;

            case "London" :
                currentTemp = "22 C";
                textViewCurrentTemp.setText(currentTemp);

                futureTemp = "20 C";
                textViewFutureTemp.setText(futureTemp);

                doubleFutureTemp = "21 C";
                textViewDoubleFutureTemp.setText(doubleFutureTemp);

                imageCurrentDay.setImageResource(R.drawable.rainy);
                imageFutureDay.setImageResource(R.drawable.cloudy);
                imageDoubleFutureDay.setImageResource(R.drawable.cloudysunrainy);

                break;
        }
    }

    /*Метод определения текущего дня недели и вывод его на экран*/
    private void currentDay() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        Calendar cNext = Calendar.getInstance();
        cNext.add(Calendar.DAY_OF_MONTH, 1);
        Calendar cDoubleNext = Calendar.getInstance();
        cDoubleNext.add(Calendar.DAY_OF_MONTH, 2);

        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("dd/MM");
        textViewCurrentDate.setText(df.format(c.getTime()));
        textViewNextDate.setText(df.format(cNext.getTime()));
        textViewDNextDate.setText(df.format(cDoubleNext.getTime()));

//        String cityName = String.valueOf(dayOfWeek);
//        textView.setText(cityName);

        switch (dayOfWeek) {
            case 1 :
                textViewCurrentDay.setText(getString(R.string.daySun));
                textViewFutureDay.setText(getString(R.string.dayMon));
                textViewDoubleFutureDay.setText(getString(R.string.dayTue));
                break;
            case 2 :
                textViewCurrentDay.setText(getString(R.string.dayMon));
                textViewFutureDay.setText(getString(R.string.dayTue));
                textViewDoubleFutureDay.setText(getString(R.string.dayWed));
                break;
            case 3 :
                textViewCurrentDay.setText(getString(R.string.dayTue));
                textViewFutureDay.setText(getString(R.string.dayWed));
                textViewDoubleFutureDay.setText(getString(R.string.dayThu));
                break;
            case 4 :
                textViewCurrentDay.setText(getString(R.string.dayWed));
                textViewFutureDay.setText(getString(R.string.dayThu));
                textViewDoubleFutureDay.setText(getString(R.string.dayFri));
                break;
            case 5 :
                textViewCurrentDay.setText(getString(R.string.dayThu));
                textViewFutureDay.setText(getString(R.string.dayFri));
                textViewDoubleFutureDay.setText(getString(R.string.daySat));
                break;
            case 6 :
                textViewCurrentDay.setText(getString(R.string.dayFri));
                textViewFutureDay.setText(getString(R.string.daySat));
                textViewDoubleFutureDay.setText(getString(R.string.daySun));
                break;
            case 7 :
                textViewCurrentDay.setText(getString(R.string.daySat));
                textViewFutureDay.setText(getString(R.string.daySun));
                textViewDoubleFutureDay.setText(getString(R.string.dayMon));
                break;
        }
    }

    /*Метод нажатия по иконке Москвы*/
    private void setOnImgBtnMoscowClickBehaviour() {
        imageButtonMoscow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityName = getString(R.string.cityName_moscow);
                textView.setText(cityName);
                setTemp("Moscow");
            }
        });
    }

    /*Метод нажатия по иконке Нью-Йорка*/
    private void setOnImgBtnNewYorkClickBehaviour() {
        imageButtonNewYork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityName = getString(R.string.cityName_newYork);
                textView.setText(cityName);
                setTemp("NewYork");
            }
        });
    }

    /*Метод нажатия по иконке Лондона*/
    private void setOnImgBtnLondonClickBehaviour() {
        imageButtonLondon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityName = getString(R.string.cityName_london);
                textView.setText(cityName);
                setTemp("London");
            }
        });
    }

    /*Метод инициализации полей из ресурсов*/
    private void initViews() {
        imageButtonMoscow = findViewById(R.id.imageButton_Moscow);
        imageButtonNewYork = findViewById(R.id.imageButton_NewYork);
        imageButtonLondon = findViewById(R.id.imageButton_London);
        textView = findViewById(R.id.cityName);
        textViewCurrentDay = findViewById(R.id.textViewCurrentDay);
        textViewFutureDay = findViewById(R.id.textViewFutureDay);
        textViewDoubleFutureDay = findViewById(R.id.textViewDoubleFutureDay);
        textViewCurrentTemp = findViewById(R.id.textViewCurrentTemp);
        textViewFutureTemp = findViewById(R.id.textViewFutureTemp);
        textViewDoubleFutureTemp = findViewById(R.id.textViewDoubleFutureTemp);
        imageCurrentDay = findViewById(R.id.imageViewCurrentDay);
        imageFutureDay = findViewById(R.id.imageViewFutureDay);
        imageDoubleFutureDay = findViewById(R.id.imageViewDoubleFutureDay);
        textViewCurrentDate = findViewById(R.id.textViewCurrentDate);
        textViewNextDate = findViewById(R.id.textViewNextDate);
        textViewDNextDate = findViewById(R.id.textViewDoubleNextDate);
    }
}