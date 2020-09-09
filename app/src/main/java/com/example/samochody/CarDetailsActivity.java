package com.example.samochody;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity {

    private EditText mModel_editTxt;
    private EditText mMarka_editTxt;
    private EditText mMoc_editTxt;
    private EditText mRok_produkcji_editTxt;
    private EditText mRodzaj_paliwa_editTxt;
    private Spinner mSkrzynia_spinner;

    private Button mUpdate_btn;
    private Button mDelete_btn;
    private Button mBack_btn;

    private String key;

    private String marka;
    private String model;
    private String skrzynia;
    private String rodzaj_paliwa;
    private String rok_produkcji;
    private String moc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        key = getIntent().getStringExtra("key");
        marka = getIntent().getStringExtra("marka");
        model = getIntent().getStringExtra("model");
        skrzynia = getIntent().getStringExtra("skrzynia");
        rok_produkcji = getIntent().getStringExtra("rok_produkcji");
        rodzaj_paliwa = getIntent().getStringExtra("rodzaj_paliwa");
        moc = getIntent().getStringExtra("moc");

        mModel_editTxt = (EditText) findViewById(R.id.model_editTxt);
        mModel_editTxt.setText(model);
        mMarka_editTxt = (EditText) findViewById(R.id.marka_editTxt);
        mMarka_editTxt.setText(marka);
        mMoc_editTxt = (EditText) findViewById(R.id.moc_editTxt);
        mMoc_editTxt.setText(moc);
        mRok_produkcji_editTxt = (EditText) findViewById(R.id.rok_produkcji_editTxt);
        mRok_produkcji_editTxt.setText(rok_produkcji);
        mRodzaj_paliwa_editTxt = (EditText) findViewById(R.id.rodzaj_paliwa_editTxt);
        mRodzaj_paliwa_editTxt.setText(rodzaj_paliwa);
        mSkrzynia_spinner = (Spinner) findViewById(R.id.skrzynia_spinner);
        mSkrzynia_spinner.setSelection(getIndex_SpinnerItem(mSkrzynia_spinner, skrzynia));

        mUpdate_btn = (Button) findViewById(R.id.update_btn);
        mDelete_btn = (Button) findViewById(R.id.delete_btn);
        mBack_btn = (Button) findViewById(R.id.back_btn);


        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car car = new car();
                car.setMarka(mMarka_editTxt.getText().toString());
                car.setModel(mModel_editTxt.getText().toString());
                car.setMoc(mMoc_editTxt.getText().toString());
                car.setRok_produkcji(mRok_produkcji_editTxt.getText().toString());
                car.setRodzaj_paliwa(mRodzaj_paliwa_editTxt.getText().toString());
                car.setSkrzynia(mSkrzynia_spinner.getSelectedItem().toString());

                new FirebaseDatabaseHelper().updateCar(key, car, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<com.example.samochody.car> cars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(CarDetailsActivity.this, "Car record has been updated successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
        mDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FirebaseDatabaseHelper().deleteCar(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<car> cars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(CarDetailsActivity.this, "Car record has been deleted successfully", Toast.LENGTH_LONG).show();
                        finish(); return;
                    }
                });
            }
        });
        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); return;
            }
        });
    }

    private int getIndex_SpinnerItem(Spinner spinner, String item){
        int index = 0;
        for(int i=0; i<spinner.getCount(); i++){
            if(spinner.getItemAtPosition(i).equals(item)){
                index = i;
                break;
            }
        }
        return index;
    }
}