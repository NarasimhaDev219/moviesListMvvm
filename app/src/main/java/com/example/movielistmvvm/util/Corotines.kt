package com.example.movielistmvvm.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Corotines {
    // we will use this function inside our view model to get the list of movies

    // it will take the work as the parameter and it will give us callback
    fun<T: Any> ioThenMain(work : suspend (() -> T?), callback: ((T?) -> Unit)) =

        CoroutineScope(Dispatchers.Main).launch {
            val  data = CoroutineScope(Dispatchers.IO).async rt@{

               return@rt work()
            }.await()
            callback(data)
        }

}