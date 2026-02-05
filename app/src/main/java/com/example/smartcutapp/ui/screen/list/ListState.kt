package com.example.smartcutapp.ui.screen.list

sealed interface ListState{
    data class Error(val reason: String): ListState
    data object Loading: ListState
    data class Content(
        val users: List<Any>
    ) : ListState
}