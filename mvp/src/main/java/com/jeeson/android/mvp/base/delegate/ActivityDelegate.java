package com.jeeson.android.mvp.base.delegate;

import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by jess on 26/04/2017 20:23
 * Contact with jess.yan.effort@gmail.com
 */

public interface ActivityDelegate extends Serializable {

    String LAYOUT_LINEAR_LAYOUT = "LinearLayout";
    String LAYOUT_FRAME_LAYOUT = "FrameLayout";
    String LAYOUT_RELATIVE_LAYOUT = "RelativeLayout";
    String ACTIVITY_DELEGATE = "activity_delegate";

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onSaveInstanceState(Bundle outState);

    void onDestroy();
}
