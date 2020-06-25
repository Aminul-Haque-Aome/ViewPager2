package com.aomi.mybase.ui.activity

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import com.aomi.mybase.R
import com.aomi.mybase.core.platform.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    val navController: NavController by lazy {
        findNavController(R.id.navigation_fragment)
    }

    private val navOptions = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun getLayoutResource() = R.layout.activity_main

}