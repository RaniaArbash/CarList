package com.example.carlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.viewHolder> {
    Context context;
    ArrayList<Car> allCars;

   public interface calListClickListener{
       void onCarSelected(Car selectedCar);
   }

   public calListClickListener listener;


    // inner class
    // View Holder = Row in the tabel
    // static = able to access it from the class without creating object
    //
    public static class viewHolder extends RecyclerView.ViewHolder{
            private final ImageView car_image;
            private final TextView car_model;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            car_image = itemView.findViewById(R.id.image);
            car_model = itemView.findViewById(R.id.model_text);
        }
        public ImageView getCar_image() {
            return car_image;
        }
        public TextView getCar_model() {
            return car_model;
        }
    }


    CarAdapter(Context c, ArrayList<Car> cars){
        context = c;
        allCars = cars;
    }
    @NonNull
    @Override
    public CarAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row_item,parent,false);
        return new viewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.getCar_model().setText(allCars.get(position).car_model);
        holder.getCar_image().setImageResource(allCars.get(position).image_id);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCarSelected(allCars.get(position));
            }
        });
    }
    @Override
    public int getItemCount() {
        return allCars.size();// 30
    }
}
