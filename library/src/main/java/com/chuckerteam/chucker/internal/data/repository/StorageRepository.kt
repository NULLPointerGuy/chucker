package com.chuckerteam.chucker.internal.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chuckerteam.chucker.internal.data.entity.StorageTuple
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

internal class StorageRepository(val context:Context) {
    private val PREFS_DIRECTORY = "shared_prefs"
    private var prefsDirectory: File = File(context.applicationInfo.dataDir,PREFS_DIRECTORY)

    /**
     * returns the list of all shared preferences files inside shared_prefs folder.
     */
    fun getSharedPreferencesList(): MutableLiveData<List<String>> {
        val data = MutableLiveData<List<String>>()
        if(prefsDirectory.exists() && prefsDirectory.isDirectory){
            data.value = prefsDirectory.list().asList()
            return data
        }
        data.value = Collections.emptyList<String>()
        return data
    }
}