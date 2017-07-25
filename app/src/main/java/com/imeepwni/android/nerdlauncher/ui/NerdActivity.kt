package com.imeepwni.android.nerdlauncher.ui

import android.support.v4.app.*
import com.imeepwni.android.ankowiki.app.*

class NerdActivity : SingleFragmentActivity() {
    override fun getFragment(): Fragment {
        return NerdFragment.newInstance()
    }
}
