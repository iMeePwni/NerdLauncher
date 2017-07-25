package com.imeepwni.android.nerdlauncher.model.data

import android.graphics.drawable.*

/**
 * Create by guofeng on 2017/7/25.
 */
data class ActivityIntent(
        var activityName: String,
        var icon: Drawable,
        var packageName: String,
        var activityClassName: String)