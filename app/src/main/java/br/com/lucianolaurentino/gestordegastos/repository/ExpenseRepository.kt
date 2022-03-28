package br.com.lucianolaurentino.gestordegastos.repository

import android.content.Context
import br.com.lucianolaurentino.gestordegastos.dao.DataBaseExpense
import br.com.lucianolaurentino.gestordegastos.dao.ExpenseDAO
import br.com.lucianolaurentino.gestordegastos.model.Expense

class ExpenseRepository(context: Context) {
    private val dbH = DataBaseExpense(context)
    private val dao = ExpenseDAO(dbH.connectionSource)

    fun insert(expense: Expense):Int {
        val result = dao.create(expense)
        dao.connectionSource.close()
        return result
    }

    fun findAll() = dao.queryForAll()
}