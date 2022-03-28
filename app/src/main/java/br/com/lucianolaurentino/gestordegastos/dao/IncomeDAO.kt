package br.com.lucianolaurentino.gestordegastos.dao

import br.com.lucianolaurentino.gestordegastos.model.Income
import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource

class IncomeDAO(connectionSource: ConnectionSource?) :
    BaseDaoImpl<Income, Int>(Income::class.java) {
    init {
        setConnectionSource(connectionSource)
        initialize()
    }
}