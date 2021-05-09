package com.android.ernb.moviesData.util

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:13 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
public class AppExecutors {
    //executor to deal with the DAO
    val diskIO = Executors.newSingleThreadExecutor()
    //executor to put runnable into the main Thread queue from a background thread
    val mainThreadExecutor = MainThreadExecutor()

    class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}