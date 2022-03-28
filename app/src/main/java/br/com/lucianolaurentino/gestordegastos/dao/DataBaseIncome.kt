package br.com.lucianolaurentino.gestordegastos.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.com.lucianolaurentino.gestordegastos.model.Income
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

class DataBaseIncome(context: Context) : OrmLiteSqliteOpenHelper(context, db, null, version) {
    companion object {
        private const val db = "Incomes.db"
        private const val version = 1
    }

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTable(connectionSource, Income::class.java)
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {
    }
}