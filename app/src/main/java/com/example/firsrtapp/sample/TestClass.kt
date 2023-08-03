package com.example.firsrtapp.sample

fun main() {

    val numbers = listOf(5, 2, 10, 4)

    val simpleSum = numbers.reduce {
            sum, element ->
        sum + element }
    println("Reduce values:::$simpleSum")
    val sumDoubled = numbers.fold(0) {
            sum, element ->
        sum + element * 2 }
    println("Fold values:::$sumDoubled")
    /*val evenList = mutableListOf<Int>()
    val oddList = mutableListOf<Int>()
    for (i in 1..20) {
        val isEven = (i % 2 == 0)
        if (isEven) {
            evenList.add(i)
        } else
            oddList.add(i)
    }

    print("Even List::: $evenList \n")
    print("Odd List::: $oddList \n")*/

/*val mutableList = mutableListOf<Int>()
    for(i in 2..50) {
        if(isPrimeNumber(i)) {
            mutableList.add(i)
            *//*if(mutableList.size < 10) {
                mutableList.add(i)
            }*//*
        }
    }
    print(mutableList)*/
}

private fun isPrimeNumber(num: Int): Boolean {

    if(num < 2) return false
    for (i in 2 until num) {
        if(num % i == 0 ) {
            println("$num is not prime number")
            return false
        }

    }
    println("$num is prime number")
    return true
}
