package com.z.precios.Util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


fun Date.asLocalDateTime(): LocalDateTime? = Instant.ofEpochMilli(this.time).atZone(ZoneId.systemDefault()).toLocalDateTime()