package com.example.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4, tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnEx3 = findViewById(R.id.buttonEx3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);

        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvEx3 = findViewById(R.id.textViewEx3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);


        //button demo 1
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //Set the dialog details
                /*
                myBuilder.setTitle("Demo 1-Simple Dialog")
                        .setMessage("I can develop Android App.")
                        //cant use back button to close the dialog
                        .setCancelable(false)
                        .setPositiveButton("Close", null);
                 */

                myBuilder.setTitle(R.string.title)
                        .setMessage("You have completed a simple Dialog Box")
                        .setPositiveButton("Dismiss", null);


                //show dialog
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //button demo 2
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 buttons Dialog")
                        .setMessage("Select one of the Buttons below.")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvDemo2.setText("You have selected Positive");
                            }
                        })
                        .setNeutralButton("cancel", null)
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvDemo2.setText("You have selected Negative");
                            }
                        });

                AlertDialog myDialog  = myBuilder.create();
                myDialog.show();
            }
        });

        //button demo 3
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inflate
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                //obtain ui components in layout
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                //build dialog
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);

                myBuilder.setTitle("Demo 3-TExt Input Dialog")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //get edit text input
                                String message = etInput.getText().toString();
                                //set text of text view
                                tvDemo3.setText(message);
                            }
                        })
                        .setNegativeButton("cancel", null);

                //show dialog
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        //button exercise 3
        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inflate
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3, null);

                //obtain ui components in layout
                final EditText num1 = viewDialog.findViewById(R.id.editTextNumber1);
                final EditText num2 = viewDialog.findViewById(R.id.editTextNumber2);

                //build dialog
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);

                myBuilder.setTitle("Exercise 3")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //get edit text input
                                int num1Int = Integer.parseInt(num1.getText().toString());
                                int num2Int = Integer.parseInt(num2.getText().toString());
                                //sum
                                int sum = num1Int + num2Int;
                                //set text of text view
                                tvEx3.setText("The sum is " + sum);
                            }
                        })
                        .setNegativeButton("cancel", null);

                //show dialog
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int curDay = cal.get(Calendar.DAY_OF_MONTH);
                int curMonth = cal.get(Calendar.MONTH);
                int curYear = cal.get(Calendar.YEAR);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, curYear, curMonth, curDay);

                //show date picker dialog
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int curHour = cal.get(Calendar.HOUR_OF_DAY);
                int curMin = cal.get(Calendar.MINUTE);

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        tvDemo5.setText(String.format("Time: %02d : %02d", hourOfDay, minute));
                    }
                }, curHour, curMin, false);

                //show time picker dialog
                myTimeDialog.show();
            }
        });
    }
}