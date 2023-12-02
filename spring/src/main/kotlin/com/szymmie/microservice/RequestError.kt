package com.szymmie.microservice

data class RequestError(
    val error: Type,
    val reason: String,
    val requested: String
) {
    enum class Type {
        NOT_FOUND,
        BAD_VALUE
    }
}