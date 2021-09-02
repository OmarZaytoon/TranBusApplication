package com.example.tranbus.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tranbus.Models.Bus;
import com.example.tranbus.R;
import com.example.tranbus.Util.DownLoadImageTask;
import com.example.tranbus.Util.Requester;
import com.example.tranbus.Util.Statics;

public class BusDetailsActivity extends AppCompatActivity {
Bus bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_deatils);
        int id= Integer.parseInt(getIntent().getExtras().getString("id"));
        bus=new Requester(this).getBusDetails(id);
        ImageView imageView=findViewById(R.id.bus_details_main_image);
        TextView trackName=findViewById(R.id.bus_details_bus_type);
        TextView  busType=findViewById(R.id.bus_details_main_busType);
        TextView busID=findViewById(R.id.bus_details_main_id);
        TextView busYear=findViewById(R.id.bus_details_year);
        TextView passengers=findViewById(R.id.bus_details_passengers);
        new DownLoadImageTask(imageView).execute(Statics.IMAGE_URL+bus.getImageModel().getUrl());
        if(Statics.language)
        trackName.setText(bus.getTrack().getTrack_name_En());
        else  trackName.setText(bus.getTrack().getTrack_name_Ar());
        busType.setText(bus.getBus_type());
        busID.setText(bus.getVehicle_id());
        busYear.setText(bus.getBus_year()+"");
        passengers.setText(bus.getMax_number_of_passengers()+"");

    }

    public void goToTrackDetails(View view) {
        Intent intent=new Intent(this,MainTrackDetails.class);
        intent.putExtra("id",bus.getTrack().getId()+"");
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
    }
}