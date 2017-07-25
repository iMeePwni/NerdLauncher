package com.imeepwni.android.nerdlauncher.model.repository

import android.app.*
import android.content.*
import com.imeepwni.android.nerdlauncher.model.data.*
import java.util.*


/**
 * Create by guofeng on 2017/7/25.
 */
object ActivityIntentRepository {

    fun getActivityIntent(activity: Activity): List<ActivityIntent> {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val packageManager = activity.packageManager
        val activities = packageManager.queryIntentActivities(intent, 0)
                .map {
                    with(it) {
                        ActivityIntent(loadLabel(packageManager).toString(),
                                activityInfo.packageName,
                                activityInfo.name)
                    }
                }
        Collections.sort(activities) { o1, o2 ->
            String.CASE_INSENSITIVE_ORDER.compare(o1.activityName, o2.activityName)
        }
        return activities
    }
}