package com.msms.scaffoldsession3.util

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    NO_ACTION
}

fun String?.toAction(): Action{
    return if(this.isNullOrEmpty()) Action.NO_ACTION else Action.valueOf((this))
}