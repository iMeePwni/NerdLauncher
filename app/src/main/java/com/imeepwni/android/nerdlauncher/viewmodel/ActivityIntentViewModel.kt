package com.imeepwni.android.nerdlauncher.viewmodel

import android.content.*
import android.databinding.*
import com.imeepwni.android.nerdlauncher.model.data.*

/**
 * Create by guofeng on 2017/7/25.
 */
class ActivityIntentViewModel(activityIntent: ActivityIntent) : BaseObservable() {

    private var activityIntent = activityIntent

    fun setActivityIntent(activityIntent: ActivityIntent) {
        this.activityIntent = activityIntent
        notifyChange()
    }

    @Bindable
    fun getActivityName() = activityIntent.activityName

    @Bindable
    fun getPackageName() = activityIntent.packageName

    @Bindable
    fun getActivityClassName() = activityIntent.activityClassName

    @Bindable
    fun getIcon() = activityIntent.icon

    @Bindable
    fun getIntent() = Intent(Intent.ACTION_MAIN)
            .apply {
                setClassName(getPackageName(), getActivityClassName())
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
}