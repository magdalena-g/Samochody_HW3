package com.example.samochody;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {

    private Context mContext;
    private CarsAdapter mCarsAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<car> cars, List<String> keys){
        mContext = context;

        mCarsAdapter = new CarsAdapter(cars, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mCarsAdapter);

    }


    class CarItemView extends RecyclerView.ViewHolder {
        private TextView mModel;
        private TextView mMarka;
        private TextView mSkrzynia;
        private TextView mRodzaj_paliwa;
        private TextView mMoc;
        private TextView mRok_produkcji;

        private String key;

        public CarItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.car_list_item, parent, false));
            mModel = (TextView) itemView.findViewById(R.id.model_txtView);
            mMarka = (TextView) itemView.findViewById(R.id.marka_txtView);
            mSkrzynia = (TextView) itemView.findViewById(R.id.skrzynia_txtView);
            mRodzaj_paliwa = (TextView) itemView.findViewById(R.id.rodzaj_paliwa_txtView);
            mMoc = (TextView) itemView.findViewById(R.id.moc_txtView);
            mRok_produkcji = (TextView) itemView.findViewById(R.id.rok_produkcji_txtView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, CarDetailsActivity.class);
                    intent.putExtra("key", key);
                    intent.putExtra("marka", mMarka.getText().toString());
                    intent.putExtra("model", mModel.getText().toString());
                    intent.putExtra("moc", mMoc.getText().toString());
                    intent.putExtra("rodzaj_paliwa", mRodzaj_paliwa.getText().toString());
                    intent.putExtra("rok_produkcji", mRok_produkcji.getText().toString());
                    intent.putExtra("skrzynia", mSkrzynia.getText().toString());

                    mContext.startActivity(intent);
                }
            });

        }
        public void bind(car car, String key){
            mModel.setText(car.getModel());
            mMarka.setText(car.getMarka());
            mSkrzynia.setText(car.getSkrzynia());
            mRodzaj_paliwa.setText(car.getRodzaj_paliwa());
            mMoc.setText(car.getMoc());
            mRok_produkcji.setText(car.getRok_produkcji());
            this.key=key;

        }


    }
    class CarsAdapter extends RecyclerView.Adapter<CarItemView>{
        private List<car> mCarList;
        private List<String> mKeys;

        public CarsAdapter(List<car> mCarList, List<String> mKeys) {
            this.mCarList = mCarList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public CarItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CarItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CarItemView holder, int position) {
            holder.bind(mCarList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            try{
                return mCarList.size();
            }catch (Exception ex){return  0;}

        }
    }
}
