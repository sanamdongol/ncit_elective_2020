package com.e.day13;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recycler_view);

        String[] images = {
                "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "https://i.redd.it/tpsnoz5bzo501.jpg",
                "https://i.redd.it/qn7f9oqu7o501.jpg",
                "https://i.redd.it/j6myfqglup501.jpg",
                "https://i.redd.it/0h2gm1ix6p501.jpg",
                "https://i.redd.it/k98uzl68eh501.jpg",
                "https://i.redd.it/glin0nwndo501.jpg",
                "https://i.redd.it/obx4zydshg601.jpg",
                "https://i.imgur.com/ZcLLrkY.jpg",
                "http://i.imgur.com/DvpvklR.png"
        };

        List<CountryModel> dataSet = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CountryModel model = new CountryModel("Name " + i, "Place " + i, images[i]);
            dataSet.add(model);
        }


        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
/*
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);*/
        recyclerView.setLayoutManager(layoutManager);

      /*  StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);*/


        MyAdapter adapter = new MyAdapter(dataSet);
        recyclerView.setAdapter(adapter);

    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


        private List<CountryModel> dataSet;

        public MyAdapter(List<CountryModel> dataSet) {
            this.dataSet = dataSet;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list,
                    parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.ic_launcher);


            CountryModel data = dataSet.get(position);
            holder.tvName.setText(data.getName());
            holder.tvPlace.setText(data.getPlace());
            Glide.with(RecyclerActivity.this).load(data.getUrl()).apply(requestOptions).into(holder.img);
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView img;
            TextView tvName;
            TextView tvPlace;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.imgView);
                tvName = itemView.findViewById(R.id.tv_name);
                tvPlace = itemView.findViewById(R.id.tv_place);
            }
        }
    }

}
