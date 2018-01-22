package com.z.precios.Util

import java.net.Inet4Address
import java.net.NetworkInterface

object NetworkUtils{
    fun getLocalIpAddress(): String {
        val en = NetworkInterface.getNetworkInterfaces()
        while (en.hasMoreElements()) {
            val intf = en.nextElement()
            if(!intf.displayName.contains("VMware")){
                val enumIpAddr = intf.inetAddresses
                while (enumIpAddr.hasMoreElements()) {
                    val inetAddress = enumIpAddr.nextElement()
                    if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                        return "interfaz: ${intf.displayName} - IP: ${inetAddress.hostAddress}"
                    }
                }
            }
        }
        return ""
    }
}