package com.example.uvesports;

import com.backendless.Backendless;

import java.util.List;

public class Application extends android.app.Application {

    public static final String APPLICATION_ID = "11CBA440-1954-639F-FF6E-6FA3A0968C00";
    public static final String API_KEY = "77641846-6E76-09EC-FF75-D709329AD500";
    public static final String SERVER_URL = "https://api.backendless.com";



    @Override
    public void onCreate() {

        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );

        super.onCreate();
    }
}
