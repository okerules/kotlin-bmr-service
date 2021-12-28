package com.monkeyltd.springkotlin

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequelstParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BmrController {

    @GetMapping("/bmr")
    fun getbmr(
            @RequestParam(value = "age") age: Int?,
            @RequestParam(value = "gender") gender: String?,
            @RequestParam(value = "units") units: String?,
            @RequestParam(value = "height") height: Int?,
            @RequestParam(value = "weight") weight: Int?
    ): Results {
        if (age == null || gender == null || units == null || height == null || weight == null){
            return Results("Values missing");
        }
        var bmr: Int
        var wtKg: Int
        var htCm: Int
        wtKg = if (units == "English") {
            (weight.toDouble() * 0.45359237).toInt()
        } else {
            weight
        }

        htCm = if (units == "English"){
            (height.toDouble() * 2.54).toInt()
        } else {
            height
        }

        bmr =  if (gender == "male") {
                ((10 * wtKg) + (6.25 * htCm) - (5 * age) + 5).toInt()
        } else {
            ((10 * wtKg) + (6.25 * htCm) - (5 * age) - 161).toInt()
        }

        return Results("Success",bmr,(bmr * 1.2).toInt(),(bmr * 1.375).toInt(),(bmr * 1.55).toInt(),(bmr * 1.725).toInt(),(bmr * 1.9).toInt())
    }

}