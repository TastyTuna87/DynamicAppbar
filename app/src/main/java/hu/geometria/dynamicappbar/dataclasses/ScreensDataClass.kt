package hu.geometria.dynamicappbar.dataclasses

sealed class Screen(val route: String, val title: String){
    object Home : Screen("home", "Home")
    object MunkaLista : Screen("munkalista", "Munkalista")
    object Munkalap : Screen("munkalap", "Munkalap")
    object Map : Screen("map", "Map")
    object Lezaras : Screen("lezaras", "Lezaras")
    object Test : Screen("test", "Test")

    object MenuItems {
        val items: List<Screen> = listOf(
            Screen.MunkaLista,
            Screen.Munkalap
        )
    }

}