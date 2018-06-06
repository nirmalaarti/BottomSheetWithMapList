package com.example.punchhlenovo.bottomsheetdemo;

import android.app.Application;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes(mailTo = "your mail id", // my email here
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text, formKey = "")


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
    }
}
