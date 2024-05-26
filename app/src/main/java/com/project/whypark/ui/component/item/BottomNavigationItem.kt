package com.project.whypark.ui.component.item

import androidx.annotation.DrawableRes

data class BottomNavigationItem (
    val title: String,
    val selectedIcon: DrawableRes,
    val unselectedIcon: DrawableRes,
    val hasNew: Boolean
)