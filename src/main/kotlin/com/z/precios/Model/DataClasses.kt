package com.z.precios.Model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.time.LocalDateTime

data class Message(val message:String,
                   val status:Int,
                   val uri:String,
                   @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
                   val date: LocalDateTime = LocalDateTime.now(),
                   val data: JsonNode?= jacksonObjectMapper().createObjectNode())

data class Product(val id:String?="",val name:String,val price:Double,val date:LocalDateTime?=null)