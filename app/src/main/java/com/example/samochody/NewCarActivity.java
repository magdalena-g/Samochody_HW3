package com.example.samochody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class NewCarActivity extends AppCompatActivity {

    private EditText mModel_editTxt;
    private EditText mMarka_editTxt;
    private EditText mMoc_editTxt;
    private EditText mRok_produkcji_editTxt;
    private EditText mRodzaj_paliwa_editTxt;
    private Spinner mSkrzynia_spinner;
    private Button mAdd_btn;
    private Button mBack_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car);
        mModel_editTxt = (EditText) findViewById(R.id.model_editTxt);
        mMarka_editTxt = (EditText) findViewById(R.id.marka_editTxt);
        mMoc_editTxt = (EditText) findViewById(R.id.moc_editTxt);
        mRok_produkcji_editTxt = (EditText) findViewById(R.id.rok_produkcji_editTxt);
        mRodzaj_paliwa_editTxt = (EditText) findViewById(R.id.rodzaj_paliwa_editTxt);
        mSkrzynia_spinner = (Spinner) findViewById(R.id.skrzynia_spinner);

        mAdd_btn = (Button) findViewById(R.id.update_btn);
        mBack_btn = (Button) findViewById(R.id.back_btn);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car car = new car();
                car.setMarka(mMarka_editTxt.getText().toString());
                car.setModel(mModel_editTxt.getText().toString());
                car.setMoc(mMoc_editTxt.getText().toString());
                car.setRok_produkcji(mRok_produkcji_editTxt.getText().toString());
                car.setRodzaj_paliwa(mRodzaj_paliwa_editTxt.getText().toString());
                car.setSkrzynia(mSkrzynia_spinner.getSelectedItem().toString());
                new FirebaseDatabaseHelper().addCar(car, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<com.example.samochody.car> cars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewCarActivity.this, "The car record has been inserted successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();return;
            }
        });
    }
}