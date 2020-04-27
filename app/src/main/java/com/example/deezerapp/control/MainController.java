package com.example.deezerapp.control;

import android.view.View;

import com.example.deezerapp.R;
import com.example.deezerapp.util.Constants;
import com.example.deezerapp.util.HTTPSWebUtil;
import com.example.deezerapp.view.MainActivity;

public class MainController implements View.OnClickListener{

    private MainActivity activity;

    public MainController(MainActivity activity){

        this.activity = activity;
        this.activity.getBuscarBt().setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buscarBt:

                String search = activity.getBuscar().getText().toString();
                HTTPSWebUtil util = new HTTPSWebUtil();

                new Thread(

                        () -> {

                            util.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/playlist/"+search);

                        }

                ).start();



            break;

        }
    }
}
