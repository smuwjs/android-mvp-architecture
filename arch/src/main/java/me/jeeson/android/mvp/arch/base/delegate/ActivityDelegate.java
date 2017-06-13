package me.jeeson.android.mvp.arch.base.delegate;

import android.os.Bundle;
import android.os.Parcelable;

/**
 * Created by Jeeson 26/04/2017 20:23
 * Contact with smuwjs@163.com
 */

public interface ActivityDelegate extends Parcelable {

    String ACTIVITY_DELEGATE = "activity_delegate";


    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onSaveInstanceState(Bundle outState);

    void onDestroy();
}
