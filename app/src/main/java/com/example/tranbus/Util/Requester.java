package com.example.tranbus.Util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.tranbus.Models.Bus;
import com.example.tranbus.Models.Track;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Requester {
    private Context context;
    public Requester(Context context){
        this.context=context;
    }

    public ArrayList<Bus> getBuses() {
       ArrayList<Bus>buses=new ArrayList<Bus>();
        try {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(Statics.REQUEST_URL+"buses")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String responseGson=response.body().string();
            Log.d("Response Response",responseGson);
        buses = new Gson().fromJson(responseGson, new TypeToken<List<Bus>>(){}.getType());
        }catch (IOException ioException){
            ioException.printStackTrace();
            Toast.makeText(context, "Failed To Connect the Server", Toast.LENGTH_SHORT).show();
        }
    return buses;
    }
    public Bus getBusDetails(int id){
        Bus bus=new Bus();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(Statics.REQUEST_URL+"buses/"+id)
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            String responseGson=response.body().string();
            Log.d("Response Response",responseGson);
            bus = new Gson().fromJson(responseGson, Bus.class);
        }catch (IOException ioException){
            ioException.printStackTrace();
            Toast.makeText(context, "Failed To Connect the Server", Toast.LENGTH_SHORT).show();
        }
        return bus;
    }
    public Track getTrackDetails(int id){
        Track track=new Track();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(Statics.REQUEST_URL+"tracks/"+id)
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            String responseGson=response.body().string();
            Log.d("Response Response",responseGson);
            track = new Gson().fromJson(responseGson, Track.class);
            track.setEnd_point_Ar("صويلح");
            track.setEnd_point_En("swalih");
            Log.d("Response Response",track.toString());
            Log.d("Response Response",track.toString());


        }catch (IOException ioException){
            ioException.printStackTrace();
            Toast.makeText(context, "Failed To Connect the Server", Toast.LENGTH_SHORT).show();
        }
        return track;
    }

    public ArrayList<Track> getTracks() {
        ArrayList<Track>tracks=new ArrayList<Track>();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(Statics.REQUEST_URL+"tracks")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            String responseGson=response.body().string();
            Log.d("Response Response",responseGson);
            tracks = new Gson().fromJson(responseGson, new TypeToken<List<Track>>(){}.getType());
            tracks.get(0).setEnd_point_Ar("صويلح");
            tracks.get(0).setEnd_point_En("swalih");
        }catch (IOException ioException){
            ioException.printStackTrace();
            Toast.makeText(context, "Failed To Connect the Server", Toast.LENGTH_SHORT).show();
        }
        return tracks;
    }
}
