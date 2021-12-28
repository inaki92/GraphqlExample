package com.inaki.graphqlexample.utils

sealed class UIState<T>(val success: T? = null, val error: Throwable? = null) {
    class Loading<T> : UIState<T>()
    class Success<T>(data: T) : UIState<T>(success = data)
    class Error<T>(exception: Throwable, data: T? = null) : UIState<T>(success = data, error = exception)
}
