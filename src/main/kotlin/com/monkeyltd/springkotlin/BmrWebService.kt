package com.monkeyltd.springkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BmrWebService

fun main(args: Array<String>) {
	runApplication<BmrWebService>(*args)
}

data class Greeting(val id: Long, val content: String)

data class BmrResults(val one: Int, val two: Int, val three: Int, val four: Int, val five: Int, val six: Int)

data class Results (
		val response: String,
		val base: Int? = null,
		val sedentary: Int? = null,
		val light: Int? = null,
		val moderate: Int? = null,
		val active: Int? = null,
		val veryactive: Int? = null
)
