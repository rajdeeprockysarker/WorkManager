package com.raj.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager = WorkManager.getInstance(this)

        val uploadWorkRequest0 = OneTimeWorkRequestBuilder<DoSomeWorkForWorkManager>()
            .build()
//--------------------------------------------------------------------------
        // Execute One Task
        // workManager.enqueue(uploadWorkRequest0)
//--------------------------------------------------------------------------

        val uploadWorkRequest1 = OneTimeWorkRequestBuilder<DoSomeWorkForWorkManagerOne>()
            .build()
        val uploadWorkRequest2 = OneTimeWorkRequestBuilder<DoSomeWorkForWorkManagerTwo>()
            .build()

//--------------------------------------------------------------------------

        // Execute ZERO and ONE Task First and THEN SECOND

        workManager

            .beginWith(Arrays.asList(  uploadWorkRequest0  ,uploadWorkRequest1  ))

            .then(uploadWorkRequest2)

           .enqueue()
//--------------------------------------------------------------------------


    }
}
