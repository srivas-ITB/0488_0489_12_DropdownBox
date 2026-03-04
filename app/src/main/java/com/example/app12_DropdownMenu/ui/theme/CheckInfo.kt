package com.example.app12_DropdownMenu.ui.theme

data class CheckInfo(
    val title: String,
    var checked: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)
