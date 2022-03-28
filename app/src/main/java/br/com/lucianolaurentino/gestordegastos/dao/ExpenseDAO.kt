package br.com.lucianolaurentino.gestordegastos.dao

import br.com.lucianolaurentino.gestordegastos.model.Expense
import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource

class ExpenseDAO(connectionSource: ConnectionSource?) :
    BaseDaoImpl<Expense, Int>(Expense::class.java) {
    init {
        setConnectionSource(connectionSource)
        initialize()
    }
}