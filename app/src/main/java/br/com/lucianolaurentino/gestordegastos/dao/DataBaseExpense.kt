package br.com.lucianolaurentino.gestordegastos.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.com.lucianolaurentino.gestordegastos.model.Expense
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

class DataBaseExpense(context: Context) : OrmLiteSqliteOpenHelper(context, db, null, version) {
    companion object {
        private const val db = "Expense.db"
        private const val version = 1
    }

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTable(connectionSource, Expense::class.java)
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {
    }
}