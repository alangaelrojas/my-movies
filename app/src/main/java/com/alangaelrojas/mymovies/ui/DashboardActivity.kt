package com.alangaelrojas.mymovies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alangaelrojas.mymovies.R
import com.alangaelrojas.mymovies.ui.discover.DiscoverMoviesFragment
import com.alangaelrojas.mymovies.ui.movies.MoviesFragment
import com.alangaelrojas.mymovies.ui.search.SearchMoviesFragment
import com.alangaelrojas.mymovies.ui.settings.SettingsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class DashboardActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    // Variable declarada con valor inicial
    private var a: Int = 0
    private var b: Int = 0
    private var c: Int = 0

    // Variable con valor nulo
    private var aa: Int? = null
    private var ab: Int? = null
    private var ac: Int? = null

    // Variable con inicializacion tardia
    private lateinit var ba: String
    private lateinit var bb: String
    private lateinit var bc: String

    // Variable con inicializacion peresoza
    private val ca: Int by lazy { 0 }
    private val cb by lazy { "Hola" }
    private val cc: Boolean by lazy { true }

    // Widgets o views
    private lateinit var imgUser: ImageView
    private lateinit var container: FrameLayout
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Assign to ours views values
        imgUser = findViewById(R.id.imgUser)
        container = findViewById(R.id.container)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        val greeting = intent.getStringExtra("greeting")
        Toast.makeText(this, greeting, Toast.LENGTH_SHORT).show()



        imgUser.setOnClickListener {
            //  Aqui vamos a escuchar cuando se de click en imgUser
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        bottomNavigationView.setOnItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.navMovies

    }

    private fun withLazyInit() {
        //Peresoza
        if (cc){ }
        val number: Int = ca
        val greeting: String = cb
    }

    private fun withLateInit() {
        Toast.makeText(this, ba, Toast.LENGTH_SHORT).show()
    }

    private fun withNulls() {
        aa?.let { aaAsNotNull ->
            val sum: Int = aaAsNotNull + 10
        }

        val substraction = ab!! - 20

    }

    private fun withValues() {
        if (a != null){
            val sum = a + 10
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.navMovies -> {
                changeFragment(MoviesFragment.newInstance())
            }
            R.id.navSearch -> {
                changeFragment(SearchMoviesFragment())
            }
            R.id.navDiscover -> {
                changeFragment(DiscoverMoviesFragment())
            }
        }

        return true
    }

    private fun changeFragment(fragment: Fragment){
        /*
        Este codigo hace exactamente lo mismo que el de debajo
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
         */

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }
}