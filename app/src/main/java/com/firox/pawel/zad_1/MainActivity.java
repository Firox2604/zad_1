package com.firox.pawel.zad_1;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> orders = new ArrayList<>();
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String ORDER = "com.firox.pawel.zad_1.extra.ORDER";
    private TextView textTimeDisplay;
    private TimePickerDialog.OnTimeSetListener timeSetListener;
    private Order order;
    private EditText email_address_text;
    private EditText phone_number_text;
    private EditText city_text;
    private EditText postal_code_text;
    private EditText address_text;
    private Spinner spinner;
    private Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = Calendar.getInstance();
        email_address_text = findViewById(R.id.editEmailText);
        phone_number_text = findViewById(R.id.editPhoneNumberText);
        city_text = findViewById(R.id.editCityText);
        postal_code_text = findViewById(R.id.editPostalCodeText);
        address_text = findViewById(R.id.editAddressText);
        spinner = findViewById(R.id.order_spinner);
        textTimeDisplay = findViewById(R.id.textTimeDisplay);
        textTimeDisplay.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) );

        spinnerInit();


        timeDialogInit();


    }

    public void launchSummaryActivity(View view) {
        Log.d(LOG_TAG, "Button Send clicked");
        Intent intent = new Intent(this, SummaryActivity.class);
        orderInit();
        Log.d(LOG_TAG, "wybrany=" + spinner.getSelectedItem());
        intent.putExtra(ORDER, order.toString());
        startActivityForResult(intent, 1);

    }

    private void orderInit() {
        RadioGroup rg = findViewById(R.id.radio_group);
        RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
        order = new Order(spinner.getSelectedItem().toString(),
                textTimeDisplay.getText().toString(),
                rb.getText().toString(),
                address_text.getText().toString(),
                postal_code_text.getText().toString(),
                city_text.getText().toString(),
                email_address_text.getText().toString(),
                phone_number_text.getText().toString()
        );

    }

    private void timeDialogInit() {
        textTimeDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_DeviceDefault_Light_Dialog,
                        timeSetListener,
                        hour, minute, true
                );
                dialog.show();
            }
        });

        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = hourOfDay + ":" + minute;
                Log.d(LOG_TAG, "Time selected: " + time);
                textTimeDisplay.setText(time);
            }
        };
    }

    private void spinnerInit() {
        orders.add("Peperoni");
        orders.add("Margherita");
        orders.add("HAVANA");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orders);//ArrayAdapter.createFromResource(this,R.id.order_spinner, orders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
