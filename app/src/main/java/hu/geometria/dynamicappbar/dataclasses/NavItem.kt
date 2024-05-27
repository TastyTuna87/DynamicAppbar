package hu.geometria.dynamicappbar.dataclasses

import hu.geometria.dynamicappbar.dataclasses.NavItem.HomeView.logOff

sealed class NavItem(val route: String, val title: String, val action: (() -> Unit)? = null ){
    object HomeView : NavItem("home", "Home")
    object MunkaListaView : NavItem("munkalista", "Munkalista")
    object MunkalapView : NavItem("munkalap", "Munkalap")
    object MapView : NavItem("map", "Map")
    object LezarasView : NavItem("lezaras", "Lezaras")
    object TestView : NavItem("test", "Test")

    object LogOff : NavItem("logoff", "LogOff", {logOff()})


    object MenuItems {
        val items: List<NavItem> = listOf(
            MunkaListaView,
            MunkalapView,
            LogOff
        )
    }

    fun logOff(){
        println("kijelentkezve")
    }

}