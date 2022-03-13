package com.example.kmmfirstapp

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}