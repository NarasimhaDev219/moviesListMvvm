package com.example.movielistmvvm.data.repository

import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest{
// this function used to RestApi
    // Type T is the genaric Function

    suspend fun<T: Any> appiRequest(call: suspend () -> Response<T>) : T{
        val responce = call.invoke()
        if (responce.isSuccessful){
            return responce.body()!!
        }else{
            //@todo handle Api Exception
            throw ApiException(
                responce.code().toString()
            )
        }
    }
}

class ApiException(message: String) : IOException(message)