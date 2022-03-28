package br.com.lucianolaurentino.gestordegastos.model

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "Expenses")
data class Expense(
    @DatabaseField(generatedId = true)
    val id: Int = 0,
    @DatabaseField
    val expensesValue: String = ""
)
