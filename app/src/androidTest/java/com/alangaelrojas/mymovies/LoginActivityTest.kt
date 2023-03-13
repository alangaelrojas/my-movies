package com.alangaelrojas.mymovies

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.alangaelrojas.mymovies.ui.MainActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Espresso es un framework de pruebas automatizadas para aplicaciones Android
 * que permite realizar pruebas funcionales de la interfaz de usuario.
 * Con Espresso, se puede escribir pruebas que simulen las acciones que un
 * usuario realiza en la aplicación y verificar que la aplicación responde
 * correctamente a esas acciones.
 *
 * Espresso es una herramienta muy útil para los desarrolladores de aplicaciones Android,
 * ya que les permite asegurarse de que la aplicación funciona correctamente antes de
 * lanzarla al mercado. Además, es muy fácil de usar y ofrece una amplia gama de funcionalidades,
 * como la interacción con vistas, la validación de texto y la realización de acciones en la barra de navegación.
 *
 * @ee [https://developer.android.com/training/testing/espresso?hl=es-419]
 * **/
@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    private val scenario by lazy { launch(MainActivity::class.java) }

    @Before
    fun setup() {

        scenario.moveToState(Lifecycle.State.RESUMED)

    }


    @Test
    fun testUserAndPassword() {
        onView(withId(R.id.edtCorreo)).perform(ViewActions.clearText())
        onView(withId(R.id.edtCorreo)).perform(ViewActions.typeText("alan@gmail.com"))

        closeSoftKeyboard()

        onView(withId(R.id.edtPassword)).perform(ViewActions.clearText())
        onView(withId(R.id.edtPassword)).perform(ViewActions.typeText("123456"))

        closeSoftKeyboard()

        onView(withId(R.id.btnLogin)).perform(click())

    }

}