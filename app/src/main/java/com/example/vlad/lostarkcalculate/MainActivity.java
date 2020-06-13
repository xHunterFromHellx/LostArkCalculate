package com.example.vlad.lostarkcalculate;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton[] classes = new ImageButton[12];

    ImageButton destr;
    ImageButton guard;
    ImageButton bers;
    ImageButton avatar;
    ImageButton infigt;
    ImageButton kimast;
    ImageButton hunt;
    ImageButton mech;
    ImageButton rang;
    ImageButton arcan;
    ImageButton summ;
    ImageButton bard;
    LinearLayout skillLayout;
    LinearLayout tripodLayout;

    int[] skillLenght = new int[12];
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skillLenght[0] = 17;
        skillLenght[1] = 17;
        skillLenght[2] = 18;
        skillLenght[3] = 18;
        skillLenght[4] = 18;
        skillLenght[5] = 17;
        skillLenght[6] = 21;
        skillLenght[7] = 17;
        skillLenght[8] = 18;
        skillLenght[9] = 17;
        skillLenght[10] = 17;
        skillLenght[11] = 17;


        final int[] finalClass = {0};
        final int[] finalSkill = new int[21];
        final int[] finalTripod = {0, 0, 0};
        final int[][] finalScoreCheck = new int[21][12];
        final int[][] finalBuild = {finalClass, finalSkill, finalTripod};

        dbHelper = new DBHelper(this);


        for (int i = 0; i< 17; i++)
        {
            for (int c = 0; c < 12; c++) {
                finalScoreCheck[i][c] = 1;
            }
        }

        destr = (ImageButton)findViewById(R.id.destr);
        guard = (ImageButton)findViewById(R.id.guard);
        bers = (ImageButton)findViewById(R.id.bers);
        avatar = (ImageButton)findViewById(R.id.avatar);
        infigt = (ImageButton)findViewById(R.id.infigt);
        kimast = (ImageButton)findViewById(R.id.kimast);
        hunt = (ImageButton)findViewById(R.id.hunt);
        mech = (ImageButton)findViewById(R.id.mech);
        rang = (ImageButton)findViewById(R.id.rang);
        arcan = (ImageButton)findViewById(R.id.arcan);
        summ = (ImageButton)findViewById(R.id.summ);
        bard = (ImageButton)findViewById(R.id.bard);

        classes[0] = destr;
        classes[1] = guard;
        classes[2] = bers;
        classes[3] = avatar;
        classes[4] = infigt;
        classes[5] = kimast;
        classes[6] = hunt;
        classes[7] = mech;
        classes[8] = rang;
        classes[9] = arcan;
        classes[10] = summ;
        classes[11] = bard;

        skillLayout = (LinearLayout)findViewById(R.id.skillLayout);
        tripodLayout = (LinearLayout)findViewById(R.id.tripodLayout);
        {
            destr.setPadding(20, 0, 15, 0);
            destr.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/destr"));

            guard.setPadding(20, 0, 15, 0);
            guard.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/guard"));

            bers.setPadding(20, 0, 15, 0);
            bers.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/bers"));

            avatar.setPadding(20, 0, 15, 0);
            avatar.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avatar"));

            infigt.setPadding(20, 0, 15, 0);
            infigt.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/infighter"));

            kimast.setPadding(20, 0, 15, 0);
            kimast.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/soulmaster"));

            hunt.setPadding(20, 0, 15, 0);
            hunt.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/devilhunter"));

            mech.setPadding(20, 0, 15, 0);
            mech.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/blaster"));

            rang.setPadding(20, 0, 15, 0);
            rang.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/hawkeye"));

            summ.setPadding(20, 0, 15, 0);
            summ.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/summoner"));

            bard.setPadding(20, 0, 15, 0);
            bard.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/bard"));

            arcan.setPadding(20, 0, 15, 0);
            arcan.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/arcana"));
        } //иконки и позиции классов

        for (int c = 0; c < classes.length; c++) {
            final int finalC = c;
            classes[c].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finalClass[0] = finalC + 1;
                    skillLayout.removeAllViews();
                    tripodLayout.removeAllViews();
                    final String[] dbBuild = {""};


                    for (int i = 0; i < skillLenght[finalC]; i++) {
                        final int finalI = i;
                        finalSkill[finalI] = finalI;


                        LinearLayout smallFuncWindow = new LinearLayout(getApplicationContext());
                        smallFuncWindow.setOrientation(LinearLayout.HORIZONTAL);
                        smallFuncWindow.setMinimumHeight(LinearLayout.LayoutParams.WRAP_CONTENT);

                            ImageButton minusButton = new ImageButton(getApplicationContext());
                            minusButton.setBackground(null);
                            minusButton.setImageDrawable(getDrawable(R.drawable.minus_button));
                            minusButton.setAdjustViewBounds(true);
                            minusButton.setMaxHeight(60);
                            minusButton.setPadding(20, 0, 10, 0);
                            minusButton.setElevation(10);


                            ImageButton plusButton = new ImageButton(getApplicationContext());
                            plusButton.setBackground(null);
                            plusButton.setImageDrawable(getDrawable(R.drawable.plus_button));
                            plusButton.setAdjustViewBounds(true);
                            plusButton.setMaxHeight(60);
                            plusButton.setPadding(10, 0, 0, 0);
                            plusButton.setElevation(10);


                        final LinearLayout skillRow = new LinearLayout(getApplicationContext());
                        skillRow.setMinimumWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
                        skillRow.setMinimumHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                        skillRow.setOrientation(LinearLayout.HORIZONTAL);
                        skillRow.setId(10000 + i);
                        if (i % 2 == 0) {
                            skillRow.setBackgroundColor(getResources().getColor(R.color.PrimaryDark2));
                        } else
                            skillRow.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                        LinearLayout bigFuncWindow = new LinearLayout(getApplicationContext());
                        bigFuncWindow.setOrientation(LinearLayout.VERTICAL);
                        bigFuncWindow.setGravity(Gravity.END);


                        int imgId = i + 1;
                        ImageButton sButton = new ImageButton(getApplicationContext());
                        sButton.setPadding(0, 0, 0, 0);
                        sButton.setAdjustViewBounds(true);
                        sButton.setMaxWidth(100);
                        sButton.setMaxHeight(100);

                        TextView skillDescript = new TextView(getApplicationContext());
                        skillDescript.setPadding(50, 0, 0, 0);
                        skillDescript.setTextColor(getResources().getColor(R.color.White));
                        skillDescript.setMinWidth(1000);

                        final int[][] score = {{1,1,1, 1,1,1, 1,1,1, 1,1,1}};
                        score[0][0] = finalScoreCheck[i][finalC];
                        if (score[0][0] == 0)
                        {
                            score[0][0] = 1;
                        }

                        switch (finalC) //натройка иконок и описаний скиллов
                        {
                            case 0:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/gd" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Жестокий удар");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Поглощение энергии");
                                        break;
                                    case 2:
                                        skillDescript.setText("Подготовка\n" +
                                                "Гравитационный вихрь");
                                        break;
                                    case 3:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Тектонический раскат");
                                        break;
                                    case 4:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Беспощадность севера");
                                        break;
                                    case 5:
                                        skillDescript.setText("Комбо\n" +
                                                "Сейсмический удар");
                                        break;
                                    case 6:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Сокрушительное преимущество");
                                        break;
                                    case 7:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Тектонический разлом");
                                        break;
                                    case 8:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Клич эрдлингов");
                                        break;
                                    case 9:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Возмущение земли");
                                        break;
                                    case 10:
                                        skillDescript.setText("Направленное\n" +
                                                "Дробитель черепов");
                                        break;
                                    case 11:
                                        skillDescript.setText("Подготовка\n" +
                                                "Молот рока");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Молот ненависти");
                                        break;
                                    case 13:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Гравитационная буря");
                                        break;
                                    case 14:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Гравитационный луч");
                                        break;
                                    case 15:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Безжалостный рывок");
                                        break;
                                    case 16:
                                        skillDescript.setText("Комбо\n" +
                                                "Стальной таран");
                                        break;

                                }
                                break;
                            case 1:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Штыковая атака");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Подавление");
                                        break;
                                    case 2:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Неумолимый натиск");
                                        break;
                                    case 3:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Огненный снаряд");
                                        break;
                                    case 4:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Сдерживающий выстрел");
                                        break;
                                    case 5:
                                        skillDescript.setText("Комбо\n" +
                                                "Заградительный огонь");
                                        break;
                                    case 6:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Стальной захват");
                                        break;
                                    case 7:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Раздробленная земля");
                                        break;
                                    case 8:
                                        skillDescript.setText("Направленное\n" +
                                                "Героический прыжок");
                                        break;
                                    case 9:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Ни шагу назад");
                                        break;
                                    case 10:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Расколотые небеса");
                                        break;
                                    case 11:
                                        skillDescript.setText("Комбо\n" +
                                                "Удары щитом");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Испепеляющий выстрел");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Победный клич");
                                        break;
                                    case 14:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Отмщение");
                                        break;
                                    case 15:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Мощный залп");
                                        break;
                                    case 16:
                                        skillDescript.setText("Подготовка\n" +
                                                "Прорыв блокады");
                                        break;

                                }
                                break;
                            case 2:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/bers" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Титанический размах");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Дробитель черепов");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Неудержимый рывок");
                                        break;
                                    case 3:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Вихрь смерти");
                                        break;
                                    case 4:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Горнило гнева");
                                        break;
                                    case 5:
                                        skillDescript.setText("Подготовка\n" +
                                                "Вулканический раскол");
                                        break;
                                    case 6:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Крестовой удар");
                                        break;
                                    case 7:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Рассекающий клинок");
                                        break;
                                    case 8:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Зазубренное лезвие");
                                        break;
                                    case 9:
                                        skillDescript.setText("Комбо\n" +
                                                "Штурмовой натиск");
                                        break;
                                    case 10:
                                        skillDescript.setText("Направленное\n" +
                                                "Приговор");
                                        break;
                                    case 11:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Дрожь земли");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Казнь");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Раскаленный воздух");
                                        break;
                                    case 14:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Калечащий удар");
                                        break;
                                    case 15:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Вердикт колосса");
                                        break;
                                    case 16:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Танец стали");
                                        break;
                                    case 17:
                                        skillDescript.setText("Комбо\n" +
                                                "Рубящий удар");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                            case 3:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Сокрушающий гонг");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Цветок лотоса");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Воплощение пламени");
                                        break;
                                    case 3:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Огненные кулаки");
                                        break;
                                    case 4:
                                        skillDescript.setText("Комбо\n" +
                                                "Аньшуйский силоворот");
                                        break;
                                    case 5:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Яростный крик");
                                        break;
                                    case 6:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Пульс земли");
                                        break;
                                    case 7:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Кулак грома");
                                        break;
                                    case 8:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Воплощение бури");
                                        break;
                                    case 9:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Покров ветра");
                                        break;
                                    case 10:
                                        skillDescript.setText("Направленное\n" +
                                                "Полет феникса");
                                        break;
                                    case 11:
                                        skillDescript.setText("Комбо\n" +
                                                "Танец алого журавля");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Живая молния");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Удар тигра");
                                        break;
                                    case 14:
                                        skillDescript.setText("Комбо\n" +
                                                "Лунный серп");
                                        break;
                                    case 15:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Бешеный вихрь");
                                        break;
                                    case 16:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Хлещущий ветер");
                                        break;
                                    case 17:
                                        skillDescript.setText("Комбо\n" +
                                                "Аньшуйская подсечка");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                            case 4:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Взбучка");
                                        break;
                                    case 1:
                                        skillDescript.setText("Направленное\n" +
                                                "Удар нисходящего солнца");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Сокрушающий прыжок");
                                        break;
                                    case 3:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Громовой удар");
                                        break;
                                    case 4:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Незримая цепь");
                                        break;
                                    case 5:
                                        skillDescript.setText("Комбо\n" +
                                                "Тройная волна");
                                        break;
                                    case 6:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Беспощадный гнев");
                                        break;
                                    case 7:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Ослепительная вспышка");
                                        break;
                                    case 8:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Духовные сферы");
                                        break;
                                    case 9:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Парализующий удар");
                                        break;
                                    case 10:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Духовный порыв");
                                        break;
                                    case 11:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Неистовые кулаки");
                                        break;
                                    case 12:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Дзен-натиск");
                                        break;
                                    case 13:
                                        skillDescript.setText("Подготовка\n" +
                                                "Внутренняя буря");
                                        break;
                                    case 14:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Молотящие кулаки");
                                        break;
                                    case 15:
                                        skillDescript.setText("Комбо\n" +
                                                "Трехточечный удар");
                                        break;
                                    case 16:
                                        skillDescript.setText("Комбо\n" +
                                                "Удар восходящего солнца");
                                        break;
                                    case 17:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Внутреннее опустошение");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                            case 5:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/sm" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Сметающая волна");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Хлесткая плеть");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Дыхание смерти");
                                        break;
                                    case 3:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Тройная вспышка");
                                        break;
                                    case 4:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Волна увечий");
                                        break;
                                    case 5:
                                        skillDescript.setText("Направленное\n" +
                                                "Длань судьбы");
                                        break;
                                    case 6:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Мантра воздаяния");
                                        break;
                                    case 7:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Бушующая энергия");
                                        break;
                                    case 8:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Ки-рывок");
                                        break;
                                    case 9:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Нить смерти");
                                        break;
                                    case 10:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Грозовые раскаты");
                                        break;
                                    case 11:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Пламенный танец");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Нокаутирующий прием");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Алая хризантема");
                                        break;
                                    case 14:
                                        skillDescript.setText("Серия приёмов\n" +
                                                "Мерцающий шаг");
                                        break;
                                    case 15:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Мантра спасения");
                                        break;
                                    case 16:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Ки-обстрел");
                                        break;
                                    case 17:
                                        skillDescript.setText("");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                            case 6:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Комбо\n" +
                                                "Грязный прием");
                                        break;
                                    case 1:
                                        skillDescript.setText("Комбо\n" +
                                                "Правосудие пустошей");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Судный час");
                                        break;
                                    case 3:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Критическая масса");
                                        break;
                                    case 4:
                                        skillDescript.setText("Серия приемов\n" +
                                                "Тройной залп");
                                        break;
                                    case 5:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Контролируемый взрыв");
                                        break;
                                    case 6:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Отход под прикрытием");
                                        break;
                                    case 7:
                                        skillDescript.setText("Направленное\n" +
                                                "Плазменный залп");
                                        break;
                                    case 8:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Стрельба по-ардетайнски");
                                        break;
                                    case 9:
                                        skillDescript.setText("Направленное\n" +
                                                "Граната AT-2");
                                        break;
                                    case 10:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Энергетический выстрел");
                                        break;
                                    case 11:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Железный аргумент");
                                        break;
                                    case 12:
                                        skillDescript.setText("Направленное\n" +
                                                "Крутящийся револьвер");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Контрольный выстрел");
                                        break;
                                    case 14:
                                        skillDescript.setText("Комбо\n" +
                                                "Беглый огонь");
                                        break;
                                    case 15:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Кульбит");
                                        break;
                                    case 16:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Скоростной обстрел");
                                        break;
                                    case 17:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Мгновенный приговор");
                                        break;
                                    case 18:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Прицельный обстрел");
                                        break;
                                    case 19:
                                        skillDescript.setText("Серия приемов\n" +
                                                "Перестрелка");
                                        break;
                                    case 20:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Верный выстрел");
                                        break;

                                }
                                break;
                            case 7:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mch" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Фугас");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Криоснаряд");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Залп картечи");
                                        break;
                                    case 3:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Ракетный обстрел");
                                        break;
                                    case 4:
                                        skillDescript.setText("Направленное\n" +
                                                "Пушечный выстрел");
                                        break;
                                    case 5:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Автономная турель");
                                        break;
                                    case 6:
                                        skillDescript.setText("Направленное\n" +
                                                "Минометный огонь");
                                        break;
                                    case 7:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Огнемет");
                                        break;
                                    case 8:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Проверенный метод");
                                        break;
                                    case 9:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Выстрел в прыжке");
                                        break;
                                    case 10:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Энергетический барьер");
                                        break;
                                    case 11:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Пулеметная очередь");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Напалм");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Огневой залп");
                                        break;
                                    case 14:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Гравитационная пушка");
                                        break;
                                    case 15:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Магнитная аномалия");
                                        break;
                                    case 16:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Точечный удар");
                                        break;
                                    case 17:
                                        skillDescript.setText("");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                            case 8:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Тройной выстрел");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Залп стрел");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Плазменная стрела");
                                        break;
                                    case 3:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Электрическая стрела");
                                        break;
                                    case 4:
                                        skillDescript.setText("Направленное\n" +
                                                "Дымовая завеса");
                                        break;
                                    case 5:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Закрученная стрела");
                                        break;
                                    case 6:
                                        skillDescript.setText("Направленное\n" +
                                                "Ливень стрел");
                                        break;
                                    case 7:
                                        skillDescript.setText("Подготовка\n" +
                                                "Подготовленный выстрел");
                                        break;
                                    case 8:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Прикрывающий выстрел");
                                        break;
                                    case 9:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Смертельная зона");
                                        break;
                                    case 10:
                                        skillDescript.setText("Мгновенное\n" +
                                                "ПМН-42");
                                        break;
                                    case 11:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Метка смерти");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Обходной маневр");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Веер клинков");
                                        break;
                                    case 14:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Тактика выживания");
                                        break;
                                    case 15:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Упорное преследование");
                                        break;
                                    case 16:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Перехват");
                                        break;
                                    case 17:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Снайперский выстрел");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                            case 9:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/arc" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Серия приемов\n" +
                                                "Марьяж");
                                        break;
                                    case 1:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Непрерывная дивинация");
                                        break;
                                    case 2:
                                        skillDescript.setText("Направленное\n" +
                                                "Король Червей");
                                        break;
                                    case 3:
                                        skillDescript.setText("Направленное\n" +
                                                "Перетасовка");
                                        break;
                                    case 4:
                                        skillDescript.setText("Направленное\n" +
                                                "Колода Кубков");
                                        break;
                                    case 5:
                                        skillDescript.setText("Направленное\n" +
                                                "Колдовской час");
                                        break;
                                    case 6:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Сакральное число");
                                        break;
                                    case 7:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Тригоны стихий");
                                        break;
                                    case 8:
                                        skillDescript.setText("Обычный\n" +
                                                "Быстрый расклад");
                                        break;
                                    case 9:
                                        skillDescript.setText("Серия приёмов\n" +
                                                "Поворот судьбы");
                                        break;
                                    case 10:
                                        skillDescript.setText("Комбо\n" +
                                                "Начало пути");
                                        break;
                                    case 11:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Шеакрийский Крест");
                                        break;
                                    case 12:
                                        skillDescript.setText("Комбо\n" +
                                                "Малый Крест");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Судьбоносный расклад");
                                        break;
                                    case 14:
                                        skillDescript.setText("Комбо\n" +
                                                "Колода Кинжалов");
                                        break;
                                    case 15:
                                        skillDescript.setText("Обычный\n" +
                                                "Тайный сад");
                                        break;
                                    case 16:
                                        skillDescript.setText("Комбо\n" +
                                                "Неблагоприятный расклад");
                                        break;
                                    case 17:
                                        skillDescript.setText("");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                            case 10:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/summ" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Фантомная сфера");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Призрачный галоп");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Оберег Энвиссы");
                                        break;
                                    case 3:
                                        skillDescript.setText("Направленное\n" +
                                                "Магическая эксплозия");
                                        break;
                                    case 4:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Ветряные пташки");
                                        break;
                                    case 5:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Хищный сад");
                                        break;
                                    case 6:
                                        skillDescript.setText("Направленное\n" +
                                                "Игнис");
                                        break;
                                    case 7:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Кармакул");
                                        break;
                                    case 8:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Шинти");
                                        break;
                                    case 9:
                                        skillDescript.setText("Направленное\n" +
                                                "Болотная скверна");
                                        break;
                                    case 10:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Порыв ветра");
                                        break;
                                    case 11:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Вестник бури");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Шаровая молния");
                                        break;
                                    case 13:
                                        skillDescript.setText("Направленное\n" +
                                                "Огненная стигма");
                                        break;
                                    case 14:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Аквандер");
                                        break;
                                    case 15:
                                        skillDescript.setText("Обычное\n" +
                                                "Копье Древних");
                                        break;
                                    case 16:
                                        skillDescript.setText("Обычное\n" +
                                                "Грозовой купол");
                                        break;
                                    case 17:
                                        skillDescript.setText("");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                            case 11:
                                sButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brd" + imgId));
                                switch (i) {
                                    case 0:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Мощный аккорд");
                                        break;
                                    case 1:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Рондо возмездия");
                                        break;
                                    case 2:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Звуковая волна");
                                        break;
                                    case 3:
                                        skillDescript.setText("Направленное\n" +
                                                "Диссонанс");
                                        break;
                                    case 4:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Рапсодия ветра");
                                        break;
                                    case 5:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Увертюра молний");
                                        break;
                                    case 6:
                                        skillDescript.setText("Обычное\n" +
                                                "Власть ритма");
                                        break;
                                    case 7:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Стаккато");
                                        break;
                                    case 8:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Ноктюрн");
                                        break;
                                    case 9:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Экспромт");
                                        break;
                                    case 10:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Гимн войны");
                                        break;
                                    case 11:
                                        skillDescript.setText("Направленное\n" +
                                                "Обертон");
                                        break;
                                    case 12:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Смертоносный дуэт");
                                        break;
                                    case 13:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Прелюдия смерти");
                                        break;
                                    case 14:
                                        skillDescript.setText("Мгновенное\n" +
                                                "Элегия жизни");
                                        break;
                                    case 15:
                                        skillDescript.setText("Направленное\n" +
                                                "Лунная соната");
                                        break;
                                    case 16:
                                        skillDescript.setText("Поддерживаемое\n" +
                                                "Походный марш");
                                        break;
                                    case 17:
                                        skillDescript.setText("");
                                        break;
                                    case 18:
                                        skillDescript.setText("");
                                        break;
                                    case 19:
                                        skillDescript.setText("");
                                        break;
                                    case 20:
                                        skillDescript.setText("");
                                        break;

                                }
                                break;
                        }

                        final int finalScore = score[0][0];
                        final TextView skillPoints = new TextView(getApplicationContext());
                        skillPoints.setText(String.valueOf(finalScore));
                        skillPoints.setTextColor(getResources().getColor(R.color.green));
                        skillPoints.setPadding(70, 10, 0, 10);

                        skillLayout.addView(skillRow);

                        skillRow.addView(sButton);
                        skillRow.addView(skillDescript);
                        skillRow.addView(bigFuncWindow);

                        bigFuncWindow.addView(skillPoints);


                        bigFuncWindow.addView(smallFuncWindow);

                        smallFuncWindow.addView(minusButton);
                        smallFuncWindow.addView(plusButton);

                        sButton.setId(10 + i);

                        minusButton.setId(1000 + i);
                        plusButton.setId(2000 + i);

                        minusButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (score[0][0] > 1) {
                                    score[0][0]--;
                                    skillPoints.setText(String.valueOf(score[0][0]));
                                }
                                skillRow.callOnClick();
                            }
                        });

                        plusButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (score[0][0] < 10) {
                                    score[0][0]++;
                                    skillPoints.setText(String.valueOf(score[0][0]));
                                }
                                skillRow.callOnClick();
                            }
                        });


                        skillRow.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                skillRow.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                                return false;
                            }
                        });

                        final int[] tripodCheck = {i, finalTripod[0], finalTripod[1], finalTripod[2]};

                        skillRow.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tripodLayout.removeAllViews();

                                float[] nmData = new float[]{
                                        1, 0, 0, 0, 0,
                                        0, 1, 0, 0, 0,
                                        0, 0, 1, 0, 0,
                                        0, 0, 0, 1, 0};
                                float[] cmData = new float[]{
                                        0.213f, 0.715f, 0.072f, 0.0f, 0.0f,
                                        0.213f, 0.715f, 0.072f, 0.0f, 0.0f,
                                        0.213f, 0.715f, 0.072f, 0.0f, 0.0f,
                                        0.0f, 0.0f, 0.0f, 1.0f, 0.0f,};
                                ColorMatrix nrml = new ColorMatrix(nmData);
                                ColorMatrix bckWht = new ColorMatrix(cmData);
                                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(bckWht);
                                ColorMatrixColorFilter nFilter = new ColorMatrixColorFilter(nrml);

                                final LinearLayout tripod1 = new LinearLayout(getApplicationContext());
                                tripod1.setGravity(Gravity.CENTER_HORIZONTAL);
                                final LinearLayout tripod2 = new LinearLayout(getApplicationContext());
                                tripod2.setGravity(Gravity.CENTER_HORIZONTAL);
                                final LinearLayout tripod3 = new LinearLayout(getApplicationContext());
                                tripod3.setGravity(Gravity.CENTER_HORIZONTAL);
                                final LinearLayout tripod4 = new LinearLayout(getApplicationContext());
                                tripod4.setGravity(Gravity.CENTER_HORIZONTAL);
                                final LinearLayout tripod5 = new LinearLayout(getApplicationContext());
                                tripod5.setGravity(Gravity.CENTER_HORIZONTAL);
                                final LinearLayout tripod6 = new LinearLayout(getApplicationContext());
                                tripod6.setGravity(Gravity.CENTER_HORIZONTAL);
                                final LinearLayout tripod7 = new LinearLayout(getApplicationContext());
                                tripod7.setGravity(Gravity.CENTER_HORIZONTAL);
                                final LinearLayout tripod8 = new LinearLayout(getApplicationContext());
                                tripod8.setGravity(Gravity.CENTER_HORIZONTAL);

                                if (finalI % 2 == 0)
                                    skillRow.setBackgroundColor(getResources().getColor(R.color.PrimaryDark2));
                                else
                                    skillRow.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

                                LinearLayout firstThreeLayout = new LinearLayout(getApplicationContext());
                                LinearLayout secondThreeLayout = new LinearLayout(firstThreeLayout.getContext());
                                LinearLayout firstTripod = new LinearLayout(getApplicationContext());
                                LinearLayout secondTripod = new LinearLayout(getApplicationContext());
                                LinearLayout thirdTripod = new LinearLayout(getApplicationContext());
                                LinearLayout firstTripod2 = new LinearLayout(firstTripod.getContext());
                                LinearLayout secondTripod2 = new LinearLayout(secondTripod.getContext());
                                LinearLayout thirdTripod2 = new LinearLayout(thirdTripod.getContext());
                                ImageButton firstTripodButton = new ImageButton(getApplicationContext());
                                ImageButton secondTripodButton = new ImageButton(getApplicationContext());
                                ImageButton thirdTripodButton = new ImageButton(getApplicationContext());
                                ImageButton firstTripodButton2 = new ImageButton(getApplicationContext());
                                ImageButton secondTripodButton2 = new ImageButton(getApplicationContext());
                                ImageButton thirdTripodButton2 = new ImageButton(getApplicationContext());
                                LinearLayout thirdThreeLayout = new LinearLayout(getApplicationContext());
                                LinearLayout firstTripod3 = new LinearLayout(getApplicationContext());
                                LinearLayout secondTripod3 = new LinearLayout(getApplicationContext());
                                ImageButton firstTripodButton3 = new ImageButton(getApplicationContext());
                                ImageButton secondTripodButton3 = new ImageButton(getApplicationContext());

                                //настройки меню триподов
                                {
                                firstThreeLayout.setOrientation(LinearLayout.HORIZONTAL);
                                firstThreeLayout.setId(50 + finalI);

                                firstTripod.setOrientation(LinearLayout.VERTICAL);
                                firstTripod.setPadding(80, 40, 0, 0);
                                firstTripod.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);

                                secondTripod.setOrientation(LinearLayout.VERTICAL);
                                secondTripod.setPadding(50, 40, 0, 0);
                                secondTripod.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);

                                thirdTripod.setOrientation(LinearLayout.VERTICAL);
                                thirdTripod.setPadding(50, 40, 0, 0);
                                thirdTripod.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);

                                firstTripodButton.setBackground(null);
                                firstTripodButton.setAdjustViewBounds(true);
                                firstTripodButton.setMaxWidth(250);
                                firstTripodButton.setMaxHeight(250);

                                secondTripodButton.setBackground(null);
                                secondTripodButton.setAdjustViewBounds(true);
                                secondTripodButton.setMaxWidth(250);
                                secondTripodButton.setMaxHeight(250);

                                thirdTripodButton.setBackground(null);
                                thirdTripodButton.setAdjustViewBounds(true);
                                thirdTripodButton.setMaxWidth(250);
                                thirdTripodButton.setMaxHeight(250);

                                secondThreeLayout.setOrientation(LinearLayout.HORIZONTAL);
                                secondThreeLayout.setId(60 + finalI);
                                secondThreeLayout.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);

                                firstTripod2.setOrientation(LinearLayout.VERTICAL);
                                firstTripod2.setPadding(80, 40, 0, 0);
                                firstTripod2.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);

                                secondTripod2.setOrientation(LinearLayout.VERTICAL);
                                secondTripod2.setPadding(50, 40, 0, 0);
                                firstTripod2.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);

                                thirdTripod2.setOrientation(LinearLayout.VERTICAL);
                                thirdTripod2.setPadding(50, 40, 0, 0);
                                firstTripod2.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);


                                firstTripodButton2.setBackground(null);
                                firstTripodButton2.setAdjustViewBounds(true);
                                firstTripodButton2.setMaxWidth(250);
                                firstTripodButton2.setMaxHeight(250);

                                secondTripodButton2.setBackground(null);
                                secondTripodButton2.setAdjustViewBounds(true);
                                secondTripodButton2.setMaxWidth(250);
                                secondTripodButton2.setMaxHeight(250);

                                thirdTripodButton2.setBackground(null);
                                thirdTripodButton2.setAdjustViewBounds(true);
                                thirdTripodButton2.setMaxWidth(250);
                                thirdTripodButton2.setMaxHeight(250);

                                thirdThreeLayout.setOrientation(LinearLayout.HORIZONTAL);
                                thirdThreeLayout.setId(70 + finalI);

                                firstTripod3.setOrientation(LinearLayout.VERTICAL);
                                firstTripod3.setPadding(230, 40, 0, 40);
                                firstTripod3.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);

                                secondTripod3.setOrientation(LinearLayout.VERTICAL);
                                secondTripod3.setPadding(100, 40, 70, 40);
                                secondTripod3.setMinimumWidth(LinearLayout.LayoutParams.MATCH_PARENT);


                                firstTripodButton3.setBackground(null);
                                firstTripodButton3.setAdjustViewBounds(true);
                                firstTripodButton3.setMaxWidth(250);
                                firstTripodButton3.setMaxHeight(250);
                                secondTripodButton3.setBackground(null);
                                secondTripodButton3.setAdjustViewBounds(true);
                                secondTripodButton3.setMaxWidth(250);
                                secondTripodButton3.setMaxHeight(250);
                            }

                                //настройки цветовой гаммы и подсвечивания
                                {
                                    if (score[0][0] < 4) {
                                        firstTripodButton.setColorFilter(filter);
                                        tripodCheck[1] = 0;
                                        secondTripodButton.setColorFilter(filter);
                                        thirdTripodButton.setColorFilter(filter);
                                        firstTripodButton2.setColorFilter(filter);
                                        secondTripodButton2.setColorFilter(filter);
                                        thirdTripodButton2.setColorFilter(filter);
                                        tripodCheck[2] = 0;
                                        firstTripodButton3.setColorFilter(filter);
                                        secondTripodButton3.setColorFilter(filter);
                                        tripodCheck[3] = 0;
                                    } else if (4 <= score[0][0] && score[0][0] < 7) {
                                        tripodCheck[2] = 0;
                                        tripodCheck[3] = 0;
                                        firstTripodButton.clearColorFilter();
                                        firstTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod1.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod2.setBackgroundResource(0);
                                                tripod3.setBackgroundResource(0);
                                                tripodCheck[1] = 1;
                                            }
                                        });
                                        secondTripodButton.clearColorFilter();
                                        secondTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod2.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod1.setBackgroundResource(0);
                                                tripod3.setBackgroundResource(0);
                                                tripodCheck[1] = 2;
                                            }
                                        });
                                        thirdTripodButton.clearColorFilter();
                                        thirdTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod3.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod1.setBackgroundResource(0);
                                                tripod2.setBackgroundResource(0);
                                                tripodCheck[1] = 3;
                                            }
                                        });
                                        firstTripodButton2.setColorFilter(filter);
                                        secondTripodButton2.setColorFilter(filter);
                                        thirdTripodButton2.setColorFilter(filter);
                                        firstTripodButton3.setColorFilter(filter);
                                        secondTripodButton3.setColorFilter(filter);
                                    } else if (7 <= score[0][0] && score[0][0] < 10) {
                                        tripodCheck[3] = 0;
                                        firstTripodButton.clearColorFilter();
                                        firstTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod1.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod2.setBackgroundResource(0);
                                                tripod3.setBackgroundResource(0);
                                                tripodCheck[1] = 1;
                                            }
                                        });
                                        secondTripodButton.clearColorFilter();
                                        secondTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod2.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod1.setBackgroundResource(0);
                                                tripod3.setBackgroundResource(0);
                                                tripodCheck[1] = 2;
                                            }
                                        });
                                        thirdTripodButton.clearColorFilter();
                                        thirdTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod3.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod1.setBackgroundResource(0);
                                                tripod2.setBackgroundResource(0);
                                                tripodCheck[1] = 3;
                                            }
                                        });
                                        firstTripodButton2.clearColorFilter();
                                        firstTripodButton2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod4.setBackgroundResource(R.drawable.green_tripod_selected);
                                                tripod5.setBackgroundResource(0);
                                                tripod6.setBackgroundResource(0);
                                                tripodCheck[2] = 1;
                                            }
                                        });
                                        secondTripodButton2.clearColorFilter();
                                        secondTripodButton2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod5.setBackgroundResource(R.drawable.green_tripod_selected);
                                                tripod4.setBackgroundResource(0);
                                                tripod6.setBackgroundResource(0);
                                                tripodCheck[2] = 2;
                                            }
                                        });
                                        thirdTripodButton2.clearColorFilter();
                                        thirdTripodButton2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod6.setBackgroundResource(R.drawable.green_tripod_selected);
                                                tripod4.setBackgroundResource(0);
                                                tripod5.setBackgroundResource(0);
                                                tripodCheck[2] = 3;
                                            }
                                        });
                                        firstTripodButton3.setColorFilter(filter);
                                        secondTripodButton3.setColorFilter(filter);
                                    } else {
                                        firstTripodButton.clearColorFilter();
                                        firstTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod1.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod2.setBackgroundResource(0);
                                                tripod3.setBackgroundResource(0);
                                                tripodCheck[1] = 1;
                                            }
                                        });
                                        secondTripodButton.clearColorFilter();
                                        secondTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod2.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod1.setBackgroundResource(0);
                                                tripod3.setBackgroundResource(0);
                                                tripodCheck[1] = 2;
                                            }
                                        });
                                        thirdTripodButton.clearColorFilter();
                                        thirdTripodButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod3.setBackgroundResource(R.drawable.blue_tripod_selected);
                                                tripod1.setBackgroundResource(0);
                                                tripod2.setBackgroundResource(0);
                                                tripodCheck[1] = 3;
                                            }
                                        });
                                        firstTripodButton2.clearColorFilter();
                                        firstTripodButton2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod4.setBackgroundResource(R.drawable.green_tripod_selected);
                                                tripod5.setBackgroundResource(0);
                                                tripod6.setBackgroundResource(0);
                                                tripodCheck[2] = 1;
                                            }
                                        });
                                        secondTripodButton2.clearColorFilter();
                                        secondTripodButton2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod5.setBackgroundResource(R.drawable.green_tripod_selected);
                                                tripod4.setBackgroundResource(0);
                                                tripod6.setBackgroundResource(0);
                                                tripodCheck[2] = 2;
                                            }
                                        });
                                        thirdTripodButton2.clearColorFilter();
                                        thirdTripodButton2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod6.setBackgroundResource(R.drawable.green_tripod_selected);
                                                tripod4.setBackgroundResource(0);
                                                tripod5.setBackgroundResource(0);
                                                tripodCheck[2] = 3;
                                            }
                                        });
                                        firstTripodButton3.clearColorFilter();
                                        firstTripodButton3.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod7.setBackgroundResource(R.drawable.yellow_tripod_selected);
                                                tripod8.setBackgroundResource(0);
                                                tripodCheck[3] = 1;
                                            }
                                        });
                                        secondTripodButton3.clearColorFilter();
                                        secondTripodButton3.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                tripod8.setBackgroundResource(R.drawable.yellow_tripod_selected);
                                                tripod7.setBackgroundResource(0);
                                                tripodCheck[3] = 2;
                                            }
                                        });
                                    }

                                    if (tripodCheck[0] == finalI && tripodCheck[1] == 1) {
                                        tripod1.setBackgroundResource(R.drawable.blue_tripod_selected);
                                        tripod2.setBackgroundResource(0);
                                        tripod3.setBackgroundResource(0);
                                    } else if (tripodCheck[0] == finalI && tripodCheck[1] == 2) {
                                        tripod2.setBackgroundResource(R.drawable.blue_tripod_selected);
                                        tripod1.setBackgroundResource(0);
                                        tripod3.setBackgroundResource(0);
                                    } else if (tripodCheck[0] == finalI && tripodCheck[1] == 3) {
                                        tripod3.setBackgroundResource(R.drawable.blue_tripod_selected);
                                        tripod1.setBackgroundResource(0);
                                        tripod2.setBackgroundResource(0);
                                    } else if (tripodCheck[0] == finalI && tripodCheck[1] == 0) {
                                        tripod2.setBackgroundResource(0);
                                        tripod1.setBackgroundResource(0);
                                        tripod3.setBackgroundResource(0);
                                    }
                                    if (tripodCheck[0] == finalI && tripodCheck[2] == 1) {
                                        tripod4.setBackgroundResource(R.drawable.green_tripod_selected);
                                        tripod5.setBackgroundResource(0);
                                        tripod6.setBackgroundResource(0);
                                    } else if (tripodCheck[0] == finalI && tripodCheck[2] == 2) {
                                        tripod5.setBackgroundResource(R.drawable.green_tripod_selected);
                                        tripod4.setBackgroundResource(0);
                                        tripod6.setBackgroundResource(0);
                                    } else if (tripodCheck[0] == finalI && tripodCheck[2] == 3) {
                                        tripod6.setBackgroundResource(R.drawable.green_tripod_selected);
                                        tripod4.setBackgroundResource(0);
                                        tripod5.setBackgroundResource(0);
                                    } else if (tripodCheck[0] == finalI && tripodCheck[2] == 0) {
                                        tripod4.setBackgroundResource(0);
                                        tripod5.setBackgroundResource(0);
                                        tripod6.setBackgroundResource(0);
                                    }
                                    if (tripodCheck[0] == finalI && tripodCheck[3] == 1) {
                                        tripod7.setBackgroundResource(R.drawable.yellow_tripod_selected);
                                        tripod8.setBackgroundResource(0);
                                    } else if (tripodCheck[0] == finalI && tripodCheck[3] == 2) {
                                        tripod8.setBackgroundResource(R.drawable.yellow_tripod_selected);
                                        tripod7.setBackgroundResource(0);
                                    } else if (tripodCheck[0] == finalI && tripodCheck[3] == 0) {
                                        tripod7.setBackgroundResource(0);
                                        tripod8.setBackgroundResource(0);

                                    }
                                }
                                finalTripod[0] = tripodCheck[1];
                                finalTripod[1] = tripodCheck[2];
                                finalTripod[2] = tripodCheck[3];
                                finalScoreCheck[finalI][finalC] = score[0][0];

                                TextView firstDescript = new TextView(getApplicationContext());
                                TextView secondDescript = new TextView(getApplicationContext());
                                TextView thirdDescript = new TextView(getApplicationContext());
                                TextView firstDescript2 = new TextView(getApplicationContext());
                                TextView secondDescript2 = new TextView(getApplicationContext());
                                TextView thirdDescript2 = new TextView(getApplicationContext());
                                TextView firstDescript3 = new TextView(getApplicationContext());
                                TextView secondDescript3 = new TextView(getApplicationContext());

                                String[][][] descriptTripods = new String[8][21][1];

                                //иконки и дескрипшн триподов
                                switch (finalC) {
                                    case 0:
                                    {
                                    firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dstr_tripod" + (finalI + 1) + "_1"));
                                    secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dstr_tripod" + (finalI + 1) + "_2"));
                                    thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dstr_tripod" + (finalI + 1) + "_3"));
                                    firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dstr_tripod" + (finalI + 1) + "_4"));
                                    secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dstr_tripod" + (finalI + 1) + "_5"));
                                    thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dstr_tripod" + (finalI + 1) + "_6"));
                                    firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dstr_tripod" + (finalI + 1) + "_7"));
                                    secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dstr_tripod" + (finalI + 1) + "_8"));
                                        {
                                            descriptTripods[0][0][0] = "Быстрый \n удар";
                                            descriptTripods[1][0][0] = "Мстительный" + "\n" + "удар";
                                            descriptTripods[2][0][0] = "Мощь земли";
                                            descriptTripods[3][0][0] = "Временная \n аномалия";
                                            descriptTripods[4][0][0] = "Рассеянная \n энергия";
                                            descriptTripods[5][0][0] = "Бей лежачего";
                                            descriptTripods[6][0][0] = "Широкий       \n замах";
                                            descriptTripods[7][0][0] = "Дрожь земли";

                                            descriptTripods[0][1][0] = "Воодушевление";
                                            descriptTripods[1][1][0] = "Концентрация";
                                            descriptTripods[2][1][0] = "Рассеянная \n энергия";
                                            descriptTripods[3][1][0] = "Идеальная \n защита";
                                            descriptTripods[4][1][0] = "Жажда мести";
                                            descriptTripods[5][1][0] = "Оглушающий \n взмах";
                                            descriptTripods[6][1][0] = "Гравитационное \n поле";
                                            descriptTripods[7][1][0] = "Энергетическое \n ядро";

                                            descriptTripods[0][2][0] = "Стойкость \n эрдлинга";
                                            descriptTripods[1][2][0] = "Молниеносные \n рефлексы";
                                            descriptTripods[2][2][0] = "Боеготовность";
                                            descriptTripods[3][2][0] = "Несгибаемая \n воля";
                                            descriptTripods[4][2][0] = "Сила гравитации";
                                            descriptTripods[5][2][0] = "Молот гнева";
                                            descriptTripods[6][2][0] = "Тщательная \n подготовка";
                                            descriptTripods[7][2][0] = "Стремительный \n вихрь";

                                            descriptTripods[0][3][0] = "Угрожающая \n сила";
                                            descriptTripods[1][3][0] = "Стальная \n броня";
                                            descriptTripods[2][3][0] = "Мощь \n гравитации";
                                            descriptTripods[3][3][0] = "Широкий \n замах";
                                            descriptTripods[4][3][0] = "Волевое \n решение";
                                            descriptTripods[5][3][0] = "Контузия";
                                            descriptTripods[6][3][0] = "Круговой \n разлет";
                                            descriptTripods[7][3][0] = "Внезапный \n рывок";

                                            descriptTripods[0][4][0] = "Боеготовность";
                                            descriptTripods[1][4][0] = "Северный \n ветер";
                                            descriptTripods[2][4][0] = "Концентрация";
                                            descriptTripods[3][4][0] = "Мощные \n взмахи";
                                            descriptTripods[4][4][0] = "Слабое \n место";
                                            descriptTripods[5][4][0] = "Нарастающий \n гнев";
                                            descriptTripods[6][4][0] = "Неостановимый \n натиск";
                                            descriptTripods[7][4][0] = "Круговые \n удары";

                                            descriptTripods[0][5][0] = "Гравитационные \n искажения";
                                            descriptTripods[1][5][0] = "Смятый \n доспех";
                                            descriptTripods[2][5][0] = "Абсолютный \n контроль";
                                            descriptTripods[3][5][0] = "Мощный \n выброс";
                                            descriptTripods[4][5][0] = "Тройной выброс";
                                            descriptTripods[5][5][0] = "Нарастающая \n мощь";
                                            descriptTripods[6][5][0] = "Сейсмический \n сдвиг";
                                            descriptTripods[7][5][0] = "Пульсация земли";

                                            descriptTripods[0][6][0] = "Несгибаемая \n воля";
                                            descriptTripods[1][6][0] = "Смятый \n доспех";
                                            descriptTripods[2][6][0] = "Мощный прыжок";
                                            descriptTripods[3][6][0] = "Стальная броня";
                                            descriptTripods[4][6][0] = "Точный удар";
                                            descriptTripods[5][6][0] = "Мясорубка";
                                            descriptTripods[6][6][0] = "Гравитационный \n взрыв";
                                            descriptTripods[7][6][0] = "Моментальное \n подавление";

                                            descriptTripods[0][7][0] = "Боеготовность";
                                            descriptTripods[1][7][0] = "Несгибаемая \n воля";
                                            descriptTripods[2][7][0] = "Сила гравитации";
                                            descriptTripods[3][7][0] = "Раскол \n доспехов";
                                            descriptTripods[4][7][0] = "Изнурение";
                                            descriptTripods[5][7][0] = "Острые шипы";
                                            descriptTripods[6][7][0] = "Тектонический \n сдвиг";
                                            descriptTripods[7][7][0] = "Гнев земли";

                                            descriptTripods[0][8][0] = "Отголоски боли";
                                            descriptTripods[1][8][0] = "Концентрация";
                                            descriptTripods[2][8][0] = "Отбрасывание";
                                            descriptTripods[3][8][0] = "Гравитационный \n щит";
                                            descriptTripods[4][8][0] = "Устрашающий \n клич";
                                            descriptTripods[5][8][0] = "Пронзительный \n клич";
                                            descriptTripods[6][8][0] = "Долгое эхо";
                                            descriptTripods[7][8][0] = "Громогласный \n клич";

                                            descriptTripods[0][9][0] = "Сокрушение";
                                            descriptTripods[1][9][0] = "Камнепад";
                                            descriptTripods[2][9][0] = "Мощь \n гравитации";
                                            descriptTripods[3][9][0] = "Каменная воля";
                                            descriptTripods[4][9][0] = "Разлет осколков";
                                            descriptTripods[5][9][0] = "Сотрясение\n земли";
                                            descriptTripods[6][9][0] = "Каменный молот";
                                            descriptTripods[7][9][0] = "Каменный вихрь";

                                            descriptTripods[0][10][0] = "Темный\n мститель";
                                            descriptTripods[1][10][0] = "Мощь земли";
                                            descriptTripods[2][10][0] = "Ловкий\n прыжок";
                                            descriptTripods[3][10][0] = "Искривление\n времени";
                                            descriptTripods[4][10][0] = "Двойной молот";
                                            descriptTripods[5][10][0] = "Завихрения\n энергии";
                                            descriptTripods[6][10][0] = "Гравитационный\n взрыв";
                                            descriptTripods[7][10][0] = "Кульбит";

                                            descriptTripods[0][11][0] = "Слабое место";
                                            descriptTripods[1][11][0] = "Милосердие\n севера";
                                            descriptTripods[2][11][0] = "Несгибаемая\n воля";
                                            descriptTripods[3][11][0] = "Изнурение";
                                            descriptTripods[4][11][0] = "Точный удар";
                                            descriptTripods[5][11][0] = "Мастерское\n исполнение";
                                            descriptTripods[6][11][0] = "Смертоносная\n волна";
                                            descriptTripods[7][11][0] = "Аннигиляция";

                                            descriptTripods[0][12][0] = "Безрассудство";
                                            descriptTripods[1][12][0] = "Смятый доспех";
                                            descriptTripods[2][12][0] = "Боеготовность";
                                            descriptTripods[3][12][0] = "Волевое\n решение";
                                            descriptTripods[4][12][0] = "Молот гнева";
                                            descriptTripods[5][12][0] = "Размашистый\n удар";
                                            descriptTripods[6][12][0] = "Безумная\n ярость";
                                            descriptTripods[7][12][0] = "Точный удар";

                                            descriptTripods[0][13][0] = "Стойкость\n эрдлинга";
                                            descriptTripods[1][13][0] = "Поиск баланса";
                                            descriptTripods[2][13][0] = "Смятый доспех";
                                            descriptTripods[3][13][0] = "Разрастающаяся\n буря";
                                            descriptTripods[4][13][0] = "Мощный\n взрыв";
                                            descriptTripods[5][13][0] = "Сила гравитации";
                                            descriptTripods[6][13][0] = "Блуждающая\n буря";
                                            descriptTripods[7][13][0] = "Бушующая\n буря";

                                            descriptTripods[0][14][0] = "Боеготовность";
                                            descriptTripods[1][14][0] = "Стальная \nброня";
                                            descriptTripods[2][14][0] = "Искусство\n войны";
                                            descriptTripods[3][14][0] = "Мастерство";
                                            descriptTripods[4][14][0] = "Один\n на один";
                                            descriptTripods[5][14][0] = "Завихрения\n энергии";
                                            descriptTripods[6][14][0] = "Смертоносный\n луч";
                                            descriptTripods[7][14][0] = "Остаточное\n излучение";

                                            descriptTripods[0][15][0] = "Завихрения\n энергии";
                                            descriptTripods[1][15][0] = "Концентрация";
                                            descriptTripods[2][15][0] = "Боеготовность";
                                            descriptTripods[3][15][0] = "Гравитационный\n щит";
                                            descriptTripods[4][15][0] = "Оглушительный\n взрыв";
                                            descriptTripods[5][15][0] = "Раскол\n доспехов";
                                            descriptTripods[6][15][0] = "Смена\n тактики";
                                            descriptTripods[7][15][0] = "Мощный\n выброс";

                                            descriptTripods[0][16][0] = "Стальная\n броня";
                                            descriptTripods[1][16][0] = "Смертоносный\n взмах";
                                            descriptTripods[2][16][0] = "Тяжелая\n поступь";
                                            descriptTripods[3][16][0] = "Мощный\n рывок";
                                            descriptTripods[4][16][0] = "Гравитационный\n щит";
                                            descriptTripods[5][16][0] = "Прорыв";
                                            descriptTripods[6][16][0] = "Сокрушение";
                                            descriptTripods[7][16][0] = "Круговой\n удар";
                                        }



                                    break;
                                    }
                                    case 1:
                                    {
                                        firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_1"));
                                        secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_2"));
                                        thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_3"));
                                        firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_5"));
                                        thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_6"));
                                        firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "Напролом";
                                        descriptTripods[2][0][0] = "Удар\n с разворота";
                                        descriptTripods[3][0][0] = "Кровожадность";
                                        descriptTripods[4][0][0] = "Тактический\n прием";
                                        descriptTripods[5][0][0] = "Стальной крюк";
                                        descriptTripods[6][0][0] = "Двойная атака";
                                        descriptTripods[7][0][0] = "Неукротимая мощь";

                                        descriptTripods[0][1][0] = "Раскол\n брони";
                                        descriptTripods[1][1][0] = "Быстрый удар";
                                        descriptTripods[2][1][0] = "Разряд";
                                        descriptTripods[3][1][0] = "Ликование";
                                        descriptTripods[4][1][0] = "Изнуряющий\n прием";
                                        descriptTripods[5][1][0] = "Непреклонный\n защитник";
                                        descriptTripods[6][1][0] = "Размашистый удар";
                                        descriptTripods[7][1][0] = "Контузящий удар";

                                        descriptTripods[0][2][0] = "Стальная\n броня";
                                        descriptTripods[1][2][0] = "Боеготовность";
                                        descriptTripods[2][2][0] = "Искусство\n войны";
                                        descriptTripods[3][2][0] = "Осадный щит\n";
                                        descriptTripods[4][2][0] = "Энергетический\n щит";
                                        descriptTripods[5][2][0] = "Молниеносный\n натиск";
                                        descriptTripods[6][2][0] = "Штурм";
                                        descriptTripods[7][2][0] = "Эйфория";

                                        descriptTripods[0][3][0] = "Стальная броня";
                                        descriptTripods[1][3][0] = "Боеготовность";
                                        descriptTripods[2][3][0] = "Концентрация";
                                        descriptTripods[3][3][0] = "Разрушительная\n мощь";
                                        descriptTripods[4][3][0] = "Зажигательный\n снаряд";
                                        descriptTripods[5][3][0] = "Искусство\n войны";
                                        descriptTripods[6][3][0] = "Двойной выстрел";
                                        descriptTripods[7][3][0] = "Прицельный\n выстрел";

                                        descriptTripods[0][4][0] = "Рывок";
                                        descriptTripods[1][4][0] = "Боеготовность\n";
                                        descriptTripods[2][4][0] = "Молниеносный\n удар";
                                        descriptTripods[3][4][0] = "Искусство\n войны";
                                        descriptTripods[4][4][0] = "Горячая\n кровь";
                                        descriptTripods[5][4][0] = "Разряд";
                                        descriptTripods[6][4][0] = "Вздыбленная\n земля";
                                        descriptTripods[7][4][0] = "Цепной взрыв";

                                        descriptTripods[0][5][0] = "Боеготовность";
                                        descriptTripods[1][5][0] = "Рывок";
                                        descriptTripods[2][5][0] = "Ликование";
                                        descriptTripods[3][5][0] = "Искусство\n войны";
                                        descriptTripods[4][5][0] = "Слабое место";
                                        descriptTripods[5][5][0] = "Разреженный\n огонь";
                                        descriptTripods[6][5][0] = "В рукопашную";
                                        descriptTripods[7][5][0] = "Разрывной снаряд";

                                        descriptTripods[0][6][0] = "Боеготовность";
                                        descriptTripods[1][6][0] = "Концентрация";
                                        descriptTripods[2][6][0] = "Искусство\n войны";
                                        descriptTripods[3][6][0] = "Острые крюки";
                                        descriptTripods[4][6][0] = "Зазубренные\n лезвия";
                                        descriptTripods[5][6][0] = "Ликование";
                                        descriptTripods[6][6][0] = "Мощный бросок";
                                        descriptTripods[7][6][0] = "Провокация";

                                        descriptTripods[0][7][0] = "Боеготовность";
                                        descriptTripods[1][7][0] = "Отличные\n рефлексы";
                                        descriptTripods[2][7][0] = "Раскол брони";
                                        descriptTripods[3][7][0] = "Мощный удар";
                                        descriptTripods[4][7][0] = "Сейсмическая\n волна";
                                        descriptTripods[5][7][0] = "Глухая\n оборона";
                                        descriptTripods[6][7][0] = "Двойной удар";
                                        descriptTripods[7][7][0] = "Штурмовой\n натиск";

                                        descriptTripods[0][8][0] = "Стальные\n сабатоны";
                                        descriptTripods[1][8][0] = "Боеготовность";
                                        descriptTripods[2][8][0] = "Маневренность";
                                        descriptTripods[3][8][0] = "Сейсмическая\n волна";
                                        descriptTripods[4][8][0] = "Статическое\n электричество";
                                        descriptTripods[5][8][0] = "Взрывная\n волна";
                                        descriptTripods[6][8][0] = "Двойной прыжок";
                                        descriptTripods[7][8][0] = "Сокрушение";

                                        descriptTripods[0][9][0] = "Марш-бросок";
                                        descriptTripods[1][9][0] = "Концентрация\n";
                                        descriptTripods[2][9][0] = "Боеготовность";
                                        descriptTripods[3][9][0] = "Искусный\n лидер";
                                        descriptTripods[4][9][0] = "Ободрение";
                                        descriptTripods[5][9][0] = "Вдохновляющая\n речь";
                                        descriptTripods[6][9][0] = "В атаку!\n";
                                        descriptTripods[7][9][0] = "Поднять щиты!";

                                        descriptTripods[0][10][0] = "Концентрация";
                                        descriptTripods[1][10][0] = "Мастерство\n";
                                        descriptTripods[2][10][0] = "Гнев небес";
                                        descriptTripods[3][10][0] = "Непоколебимая\n воля";
                                        descriptTripods[4][10][0] = "Искусство\n войны";
                                        descriptTripods[5][10][0] = "Ревущая\n буря";
                                        descriptTripods[6][10][0] = "Грозовой\n крест";
                                        descriptTripods[7][10][0] = "Полный\n контроль";

                                        descriptTripods[0][11][0] = "Раскол\n брони";
                                        descriptTripods[1][11][0] = "Глухая\n оборона";
                                        descriptTripods[2][11][0] = "Быстрые удары";
                                        descriptTripods[3][11][0] = "Непреклонный\n защитник";
                                        descriptTripods[4][11][0] = "Маневренность";
                                        descriptTripods[5][11][0] = "Слабое место";
                                        descriptTripods[6][11][0] = "Разящий щит";
                                        descriptTripods[7][11][0] = "Сокрушительная\n мощь";

                                        descriptTripods[0][12][0] = "Стальная броня";
                                        descriptTripods[1][12][0] = "Отличные\n рефлексы";
                                        descriptTripods[2][12][0] = "Непоколебимая\n воля";
                                        descriptTripods[3][12][0] = "Искусство\n войны";
                                        descriptTripods[4][12][0] = "Слабое место";
                                        descriptTripods[5][12][0] = "Разрушительная\n мощь";
                                        descriptTripods[6][12][0] = "Боец\n авангарда";
                                        descriptTripods[7][12][0] = "Тщательная\n подготовка";

                                        descriptTripods[0][13][0] = "Боеготовность";
                                        descriptTripods[1][13][0] = "Громогласный\n клич";
                                        descriptTripods[2][13][0] = "Глухая\n оборона";
                                        descriptTripods[3][13][0] = "Дерзкий клич";
                                        descriptTripods[4][13][0] = "Превосходство\n силы";
                                        descriptTripods[5][13][0] = "Энергетический\n щит";
                                        descriptTripods[6][13][0] = "Вдохновляющий\n клич";
                                        descriptTripods[7][13][0] = "Деморализующий\n клич";

                                        descriptTripods[0][14][0] = "Ликование";
                                        descriptTripods[1][14][0] = "Стальная броня";
                                        descriptTripods[2][14][0] = "Изнурен и\n побежден";
                                        descriptTripods[3][14][0] = "Новый баланс";
                                        descriptTripods[4][14][0] = "Искусство\n войны";
                                        descriptTripods[5][14][0] = "Слабое место";
                                        descriptTripods[6][14][0] = "Выстрел\n в упор";
                                        descriptTripods[7][14][0] = "Шоковый удар";

                                        descriptTripods[0][15][0] = "Бронебойный\n выстрел";
                                        descriptTripods[1][15][0] = "Веерный\n залп";
                                        descriptTripods[2][15][0] = "Разрывной\n снаряд";
                                        descriptTripods[3][15][0] = "Снайперская\n точность";
                                        descriptTripods[4][15][0] = "Быстрый\n выстрел";
                                        descriptTripods[5][15][0] = "Подготовленный\n выстрел";
                                        descriptTripods[6][15][0] = "Круговая\n бомбардировка";
                                        descriptTripods[7][15][0] = "Шквал огня";

                                        descriptTripods[0][16][0] = "Кровожадность";
                                        descriptTripods[1][16][0] = "Слабое\n место";
                                        descriptTripods[2][16][0] = "Стальная\n броня";
                                        descriptTripods[3][16][0] = "Напролом!";
                                        descriptTripods[4][16][0] = "Нарастающая\n мощь";
                                        descriptTripods[5][16][0] = "Несокрушимая\n воля";
                                        descriptTripods[6][16][0] = "Громовой\n удар";
                                        descriptTripods[7][16][0] = "Тщательная\n подготовка";
                                    }
                                        break;
                                    case 2:
                                    {
                                        firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brs_tripod" + (finalI + 1) + "_1"));
                                        secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brs_tripod" + (finalI + 1) + "_2"));
                                        thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brs_tripod" + (finalI + 1) + "_3"));
                                        firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brs_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brs_tripod" + (finalI + 1) + "_5"));
                                        thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brs_tripod" + (finalI + 1) + "_6"));
                                        firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brs_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/brs_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                    case 3:
                                    {
                                          firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr_tripod" + (finalI + 1) + "_1"));
                                         secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr_tripod" + (finalI + 1) + "_2"));
                                          thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr_tripod" + (finalI + 1) + "_3"));
                                         firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr_tripod" + (finalI + 1) + "_5"));
                                         thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr_tripod" + (finalI + 1) + "_6"));
                                         firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/avtr_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";

                                        descriptTripods[0][17][0] = "";
                                        descriptTripods[1][17][0] = "";
                                        descriptTripods[2][17][0] = "";
                                        descriptTripods[3][17][0] = "";
                                        descriptTripods[4][17][0] = "";
                                        descriptTripods[5][17][0] = "";
                                        descriptTripods[6][17][0] = "";
                                        descriptTripods[7][17][0] = "";
                                    }
                                    break;
                                    case 4:
                                    {
                                          firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft_tripod" + (finalI + 1) + "_1"));
                                         secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft_tripod" + (finalI + 1) + "_2"));
                                          thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft_tripod" + (finalI + 1) + "_3"));
                                         firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft_tripod" + (finalI + 1) + "_5"));
                                         thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft_tripod" + (finalI + 1) + "_6"));
                                         firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/inft_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                    case 5:
                                    {
                                          firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/smst_tripod" + (finalI + 1) + "_1"));
                                         secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/smst_tripod" + (finalI + 1) + "_2"));
                                          thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/smst_tripod" + (finalI + 1) + "_3"));
                                         firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/smst_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/smst_tripod" + (finalI + 1) + "_5"));
                                         thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/smst_tripod" + (finalI + 1) + "_6"));
                                         firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/smst_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/smst_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                    case 6:
                                    {
                                          firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh_tripod" + (finalI + 1) + "_1"));
                                         secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh_tripod" + (finalI + 1) + "_2"));
                                          thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh_tripod" + (finalI + 1) + "_3"));
                                         firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh_tripod" + (finalI + 1) + "_5"));
                                         thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh_tripod" + (finalI + 1) + "_6"));
                                         firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/dh_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                    case 7:
                                    {
                                          firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mech_tripod" + (finalI + 1) + "_1"));
                                         secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mech_tripod" + (finalI + 1) + "_2"));
                                          thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mech_tripod" + (finalI + 1) + "_3"));
                                         firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mech_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mech_tripod" + (finalI + 1) + "_5"));
                                         thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mech_tripod" + (finalI + 1) + "_6"));
                                         firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mech_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/mech_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                    case 8:
                                    {
                                        firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng_tripod" + (finalI + 1) + "_1"));
                                        secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng_tripod" + (finalI + 1) + "_2"));
                                        thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng_tripod" + (finalI + 1) + "_3"));
                                        firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng_tripod" + (finalI + 1) + "_5"));
                                        thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng_tripod" + (finalI + 1) + "_6"));
                                        firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/rng_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                    case 9:
                                    {
                                        firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_1"));
                                        secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_2"));
                                        thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_3"));
                                        firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_5"));
                                        thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_6"));
                                        firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                    case 10:
                                    {
                                        firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_1"));
                                        secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_2"));
                                        thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_3"));
                                        firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_5"));
                                        thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_6"));
                                        firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                    case 11:
                                    {
                                        firstTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_1"));
                                        secondTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_2"));
                                        thirdTripodButton.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_3"));
                                        firstTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_4"));
                                        secondTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_5"));
                                        thirdTripodButton2.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_6"));
                                        firstTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_7"));
                                        secondTripodButton3.setImageURI(Uri.parse("android.resource://com.example.vlad.lostarkcalculate/drawable/grd_tripod" + (finalI + 1) + "_8"));
                                    }
                                    {
                                        descriptTripods[0][0][0] = "Шаг вперед";
                                        descriptTripods[1][0][0] = "";
                                        descriptTripods[2][0][0] = "";
                                        descriptTripods[3][0][0] = "";
                                        descriptTripods[4][0][0] = "";
                                        descriptTripods[5][0][0] = "";
                                        descriptTripods[6][0][0] = "";
                                        descriptTripods[7][0][0] = "";

                                        descriptTripods[0][1][0] = "";
                                        descriptTripods[1][1][0] = "";
                                        descriptTripods[2][1][0] = "";
                                        descriptTripods[3][1][0] = "";
                                        descriptTripods[4][1][0] = "";
                                        descriptTripods[5][1][0] = "";
                                        descriptTripods[6][1][0] = "";
                                        descriptTripods[7][1][0] = "";

                                        descriptTripods[0][2][0] = "";
                                        descriptTripods[1][2][0] = "";
                                        descriptTripods[2][2][0] = "";
                                        descriptTripods[3][2][0] = "";
                                        descriptTripods[4][2][0] = "";
                                        descriptTripods[5][2][0] = "";
                                        descriptTripods[6][2][0] = "";
                                        descriptTripods[7][2][0] = "";

                                        descriptTripods[0][3][0] = "";
                                        descriptTripods[1][3][0] = "";
                                        descriptTripods[2][3][0] = "";
                                        descriptTripods[3][3][0] = "";
                                        descriptTripods[4][3][0] = "";
                                        descriptTripods[5][3][0] = "";
                                        descriptTripods[6][3][0] = "";
                                        descriptTripods[7][3][0] = "";

                                        descriptTripods[0][4][0] = "";
                                        descriptTripods[1][4][0] = "";
                                        descriptTripods[2][4][0] = "";
                                        descriptTripods[3][4][0] = "";
                                        descriptTripods[4][4][0] = "";
                                        descriptTripods[5][4][0] = "";
                                        descriptTripods[6][4][0] = "";
                                        descriptTripods[7][4][0] = "";

                                        descriptTripods[0][5][0] = "";
                                        descriptTripods[1][5][0] = "";
                                        descriptTripods[2][5][0] = "";
                                        descriptTripods[3][5][0] = "";
                                        descriptTripods[4][5][0] = "";
                                        descriptTripods[5][5][0] = "";
                                        descriptTripods[6][5][0] = "";
                                        descriptTripods[7][5][0] = "";

                                        descriptTripods[0][6][0] = "";
                                        descriptTripods[1][6][0] = "";
                                        descriptTripods[2][6][0] = "";
                                        descriptTripods[3][6][0] = "";
                                        descriptTripods[4][6][0] = "";
                                        descriptTripods[5][6][0] = "";
                                        descriptTripods[6][6][0] = "";
                                        descriptTripods[7][6][0] = "";

                                        descriptTripods[0][7][0] = "";
                                        descriptTripods[1][7][0] = "";
                                        descriptTripods[2][7][0] = "";
                                        descriptTripods[3][7][0] = "";
                                        descriptTripods[4][7][0] = "";
                                        descriptTripods[5][7][0] = "";
                                        descriptTripods[6][7][0] = "";
                                        descriptTripods[7][7][0] = "";

                                        descriptTripods[0][8][0] = "";
                                        descriptTripods[1][8][0] = "";
                                        descriptTripods[2][8][0] = "";
                                        descriptTripods[3][8][0] = "";
                                        descriptTripods[4][8][0] = "";
                                        descriptTripods[5][8][0] = "";
                                        descriptTripods[6][8][0] = "";
                                        descriptTripods[7][8][0] = "";

                                        descriptTripods[0][9][0] = "";
                                        descriptTripods[1][9][0] = "";
                                        descriptTripods[2][9][0] = "";
                                        descriptTripods[3][9][0] = "";
                                        descriptTripods[4][9][0] = "";
                                        descriptTripods[5][9][0] = "";
                                        descriptTripods[6][9][0] = "";
                                        descriptTripods[7][9][0] = "";

                                        descriptTripods[0][10][0] = "";
                                        descriptTripods[1][10][0] = "";
                                        descriptTripods[2][10][0] = "";
                                        descriptTripods[3][10][0] = "";
                                        descriptTripods[4][10][0] = "";
                                        descriptTripods[5][10][0] = "";
                                        descriptTripods[6][10][0] = "";
                                        descriptTripods[7][10][0] = "";

                                        descriptTripods[0][11][0] = "";
                                        descriptTripods[1][11][0] = "";
                                        descriptTripods[2][11][0] = "";
                                        descriptTripods[3][11][0] = "";
                                        descriptTripods[4][11][0] = "";
                                        descriptTripods[5][11][0] = "";
                                        descriptTripods[6][11][0] = "";
                                        descriptTripods[7][11][0] = "";

                                        descriptTripods[0][12][0] = "";
                                        descriptTripods[1][12][0] = "";
                                        descriptTripods[2][12][0] = "";
                                        descriptTripods[3][12][0] = "";
                                        descriptTripods[4][12][0] = "";
                                        descriptTripods[5][12][0] = "";
                                        descriptTripods[6][12][0] = "";
                                        descriptTripods[7][12][0] = "";

                                        descriptTripods[0][13][0] = "";
                                        descriptTripods[1][13][0] = "";
                                        descriptTripods[2][13][0] = "";
                                        descriptTripods[3][13][0] = "";
                                        descriptTripods[4][13][0] = "";
                                        descriptTripods[5][13][0] = "";
                                        descriptTripods[6][13][0] = "";
                                        descriptTripods[7][13][0] = "";

                                        descriptTripods[0][14][0] = "";
                                        descriptTripods[1][14][0] = "";
                                        descriptTripods[2][14][0] = "";
                                        descriptTripods[3][14][0] = "";
                                        descriptTripods[4][14][0] = "";
                                        descriptTripods[5][14][0] = "";
                                        descriptTripods[6][14][0] = "";
                                        descriptTripods[7][14][0] = "";

                                        descriptTripods[0][15][0] = "";
                                        descriptTripods[1][15][0] = "";
                                        descriptTripods[2][15][0] = "";
                                        descriptTripods[3][15][0] = "";
                                        descriptTripods[4][15][0] = "";
                                        descriptTripods[5][15][0] = "";
                                        descriptTripods[6][15][0] = "";
                                        descriptTripods[7][15][0] = "";

                                        descriptTripods[0][16][0] = "";
                                        descriptTripods[1][16][0] = "";
                                        descriptTripods[2][16][0] = "";
                                        descriptTripods[3][16][0] = "";
                                        descriptTripods[4][16][0] = "";
                                        descriptTripods[5][16][0] = "";
                                        descriptTripods[6][16][0] = "";
                                        descriptTripods[7][16][0] = "";
                                    }
                                    break;
                                } //:TODO добить проклятые триподы


                                //вывод текста
                                {
                                    firstDescript.setTextColor(getResources().getColor(R.color.White));
                                    firstDescript.setText(descriptTripods[0][finalI][0]);
                                    firstDescript.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    firstDescript.setTextSize(8);
                                    secondDescript.setText(descriptTripods[1][finalI][0]);
                                    secondDescript.setTextColor(getResources().getColor(R.color.White));
                                    secondDescript.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    secondDescript.setTextSize(8);
                                    thirdDescript.setText(descriptTripods[2][finalI][0]);
                                    thirdDescript.setTextColor(getResources().getColor(R.color.White));
                                    thirdDescript.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    thirdDescript.setTextSize(8);
                                    firstDescript2.setText(descriptTripods[3][finalI][0]);
                                    firstDescript2.setTextColor(getResources().getColor(R.color.White));
                                    firstDescript2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    firstDescript2.setTextSize(8);
                                    secondDescript2.setText(descriptTripods[4][finalI][0]);
                                    secondDescript2.setTextColor(getResources().getColor(R.color.White));
                                    secondDescript2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    secondDescript2.setTextSize(8);
                                    thirdDescript2.setText(descriptTripods[5][finalI][0]);
                                    thirdDescript2.setTextColor(getResources().getColor(R.color.White));
                                    thirdDescript2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    thirdDescript2.setTextSize(8);
                                    firstDescript3.setText(descriptTripods[6][finalI][0]);
                                    firstDescript3.setTextColor(getResources().getColor(R.color.White));
                                    firstDescript3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    firstDescript3.setTextSize(8);
                                    secondDescript3.setText(descriptTripods[7][finalI][0]);
                                    secondDescript3.setTextColor(getResources().getColor(R.color.White));
                                    secondDescript3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                    secondDescript3.setTextSize(8);
                                }

                                //вывод меню триподов на экран
                                {
                                    tripodLayout.addView(firstThreeLayout);
                                    tripodLayout.addView(secondThreeLayout);
                                    tripodLayout.addView(thirdThreeLayout);

                                    firstThreeLayout.addView(firstTripod);
                                    firstTripod.addView(tripod1);
                                    tripod1.addView(firstTripodButton);
                                    firstTripod.addView(firstDescript);
                                    firstThreeLayout.addView(secondTripod);
                                    secondTripod.addView(tripod2);
                                    tripod2.addView(secondTripodButton);
                                    secondTripod.addView(secondDescript);
                                    firstThreeLayout.addView(thirdTripod);
                                    thirdTripod.addView(tripod3);
                                    tripod3.addView(thirdTripodButton);
                                    thirdTripod.addView(thirdDescript);

                                    secondThreeLayout.addView(firstTripod2);
                                    firstTripod2.addView(tripod4);
                                    tripod4.addView(firstTripodButton2);
                                    firstTripod2.addView(firstDescript2);
                                    secondThreeLayout.addView(secondTripod2);
                                    secondTripod2.addView(tripod5);
                                    tripod5.addView(secondTripodButton2);
                                    secondTripod2.addView(secondDescript2);
                                    secondThreeLayout.addView(thirdTripod2);
                                    thirdTripod2.addView(tripod6);
                                    tripod6.addView(thirdTripodButton2);
                                    thirdTripod2.addView(thirdDescript2);

                                    thirdThreeLayout.addView(firstTripod3);
                                    firstTripod3.addView(tripod7);
                                    tripod7.addView(firstTripodButton3);
                                    firstTripod3.addView(firstDescript3);
                                    thirdThreeLayout.addView(secondTripod3);
                                    secondTripod3.addView(tripod8);
                                    tripod8.addView(secondTripodButton3);
                                    secondTripod3.addView(secondDescript3);
                                }
                                String dbClass = String.valueOf(finalClass[0]);
                                dbBuild[0] = dbBuild[0] + String.valueOf("skill&" + finalSkill[finalI] + "&" + "score&" + score[0][0] + "t1&" + finalTripod[0] + "&" + "t2&" + finalTripod[1] + "&" + "t3&" + finalTripod[0]);

                            }
                        });

                    }

                }
            });
        }





    }

}
