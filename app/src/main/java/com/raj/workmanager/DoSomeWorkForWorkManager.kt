package com.raj.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DoSomeWorkForWorkManager(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        // Do the work here--in this case, upload the images.

       Log.v("TAG","In do Work 0");

        // Indicate whether the task finished successfully with the Result
        return Result.success()
    }
}