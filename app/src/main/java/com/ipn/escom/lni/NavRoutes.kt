package com.ipn.escom.lni

object NavRoutes {
    const val startScreen = "startScreen"
    const val mapScreen   = "mapScreen"
    const val infoScreen  = "infoScreen/{id}"
    const val eventScreen = "eventScreen"

    fun getDetailRoute(id: Int) = "infoScreen/$id"
    fun getDetailRoute() = "infoScreen/{id}"

    fun getEventRoute() = "eventScreen/{id}/{id2}"
    fun getEventRoute(id: Int, id2: Int) = "eventScreen/$id/$id2"

     object arguments {
        const val id = "id"
         const val id2 = "id2"
    }
}