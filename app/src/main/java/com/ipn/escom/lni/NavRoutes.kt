package com.ipn.escom.lni

object NavRoutes {
    const val startScreen = "startScreen"
    const val mapScreen   = "mapScreen"
    const val infoScreen  = "infoScreen/{id}"
    const val eventScreen = "eventScreen"

    fun getDetailRoute(id: Int) = "infoScreen/$id"
    fun getDetailRoute() = "infoScreen/{id}"

     object arguments {
        const val id = "id"
    }
}