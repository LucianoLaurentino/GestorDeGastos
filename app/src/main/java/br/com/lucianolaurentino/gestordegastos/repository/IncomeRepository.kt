package br.com.lucianolaurentino.gestordegastos.repository

import android.content.Context
import br.com.lucianolaurentino.gestordegastos.dao.DataBaseIncome
import br.com.lucianolaurentino.gestordegastos.dao.IncomeDAO
import br.com.lucianolaurentino.gestordegastos.model.Income

class IncomeRepository (context: Context) {
    private val dbH = DataBaseIncome(context)
    private val dao = IncomeDAO(dbH.connectionSource)

    fun insert(income: Income):Int {
        val result = dao.create(income)
        dao.connectionSource.close()
        return result
    }

    fun findAll() = dao.queryForAll()
}