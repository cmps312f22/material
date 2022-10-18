package com.cmps312.todoapp.view.components

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.datetime.LocalDate

@Composable
fun Datepicker(
    context: Context, dateLabel: String, initialDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
) {

    val selectedDate =
        remember { mutableStateOf("${initialDate.dayOfMonth}/${initialDate.monthNumber}/${initialDate.year}") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            // Month is 0 based so add 1
            selectedDate.value = "$dayOfMonth/${month + 1}/$year"
            onDateSelected(LocalDate(year, month + 1, dayOfMonth))
        },
        initialDate.year, initialDate.monthNumber - 1, initialDate.dayOfMonth
    )

    Button(onClick = { datePickerDialog.show() }) {
        Text(text = dateLabel)
    }
}