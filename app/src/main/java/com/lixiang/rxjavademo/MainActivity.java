package com.lixiang.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lixiang.rxjavademo.createOperator.delay.Defer;
import com.lixiang.rxjavademo.createOperator.delay.Interval;
import com.lixiang.rxjavademo.createOperator.delay.IntervalRange;
import com.lixiang.rxjavademo.createOperator.delay.Range;
import com.lixiang.rxjavademo.createOperator.delay.Timer;
import com.lixiang.rxjavademo.createOperator.normal.Create;
import com.lixiang.rxjavademo.createOperator.normal.FromArray;
import com.lixiang.rxjavademo.createOperator.normal.FromIterable;
import com.lixiang.rxjavademo.createOperator.normal.Just;
import com.lixiang.rxjavademo.switchOperator.SwitchConcatMap;
import com.lixiang.rxjavademo.switchOperator.SwitchFlatMap;
import com.lixiang.rxjavademo.switchOperator.SwitchMap;

public class MainActivity extends AppCompatActivity {
    Button createBtn;
    Button justBtn;
    Button fromArrayBtn;
    Button fromIterableBtn;
    Button deferBtn;
    Button intervalBtn;
    Button intervalRangeBtn;
    Button rangeBtn;
    Button timerBtn;
    Button mapBtn;
    Button flatMapBtn;
    Button concatMapBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createOperator();

        switchOperator();

    }

    private void switchOperator() {
        mapBtn = findViewById(R.id.map);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchMap.use();
            }
        });

        flatMapBtn = findViewById(R.id.flatMap);
        flatMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchFlatMap.use();
            }
        });

        concatMapBtn = findViewById(R.id.concatMap);
        concatMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchConcatMap.use();
            }
        });
    }

    private void createOperator() {
        normal();

        delay();
    }

    private void delay() {
        deferBtn = findViewById(R.id.defer);
        deferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Defer.use();
            }
        });


        intervalBtn = findViewById(R.id.interval);
        intervalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Interval.use();
            }
        });

        intervalRangeBtn = findViewById(R.id.intervalRange);
        intervalRangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntervalRange.use();
            }
        });

        rangeBtn = findViewById(R.id.range);
        rangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Range.use();
            }
        });

        timerBtn = findViewById(R.id.timer);
        timerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timer.use();
            }
        });
    }

    private void normal() {
        createBtn = findViewById(R.id.create);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Create.use();
            }
        });


        justBtn = findViewById(R.id.just);
        justBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Just.use();
            }
        });

        fromArrayBtn = findViewById(R.id.fromArray);
        fromArrayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FromArray.use();
            }
        });

        fromIterableBtn = findViewById(R.id.fromIterable);
        fromIterableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FromIterable.use();
            }
        });
    }
}