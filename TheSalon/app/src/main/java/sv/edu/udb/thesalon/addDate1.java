package sv.edu.udb.thesalon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class addDate1 extends AppCompatActivity {

    private Button mPickDateButton, mPickTimeButton;
    private TextView mShowSelectedDateText, mShowSelectedTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date1);

        mPickDateButton = findViewById(R.id.btnSelectDate);
        mShowSelectedDateText = findViewById(R.id.txtDateSelected);
        mPickTimeButton = findViewById(R.id.btnSelectTime);
        mShowSelectedTimeText = findViewById(R.id.txtvSelectedTime);

        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Selecciona una fecha");
        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();
        mPickDateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                    }
                });

        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
                        mShowSelectedDateText.setText(materialDatePicker.getHeaderText());

                    }
                });

        mPickTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(mPickTimeButton);
            }
        });
    }

    public void back(View view){
        Intent intent = new Intent(getApplicationContext(), mainMenu.class);
        startActivity(intent);
        finish();
    }

    private void showTimeDialog(final Button time_in) {
        final Calendar calendar=Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
                mShowSelectedTimeText.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };

        new TimePickerDialog(addDate1.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }
}