package com.example.deezerapp.control;

import android.util.Log;
import android.view.View;

import com.example.deezerapp.R;
import com.example.deezerapp.model.Deezer;
import com.example.deezerapp.util.Constants;
import com.example.deezerapp.util.HTTPSWebUtil;
import com.example.deezerapp.view.MainActivity;
import com.google.gson.Gson;

public class MainController implements View.OnClickListener, HTTPSWebUtil.OnResponseListener{

    private MainActivity activity;
    private HTTPSWebUtil util;
    private Deezer dz;

    public MainController(MainActivity activity){

        this.activity = activity;
        this.activity.getBuscarBt().setOnClickListener(this);
        util = new HTTPSWebUtil();
        util.setListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buscarBt:

                String search = activity.getBuscar().getText().toString();


                new Thread(

                        () -> {

                           util.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/search/playlist?q="+search);


                        }

                ).start();



            break;

        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch(callbackID){
            case Constants.SEARCH_CALLBACK:
                Gson gson = new Gson();
                dz = gson.fromJson(response, Deezer.class);
                Log.e(">>>>>>>>>>>>>>>>>>>>> ", dz.getData()[3].getTitle());
                Log.e(">>>>>>>>>>>>>>>>>>>>> ", dz.getData()[1].getUser().getName());

                break;

        }
    }
}
