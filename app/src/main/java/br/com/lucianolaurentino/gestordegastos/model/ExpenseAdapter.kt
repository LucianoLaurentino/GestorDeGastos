package br.com.lucianolaurentino.gestordegastos.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucianolaurentino.gestordegastos.NewExpenseActivity
import br.com.lucianolaurentino.gestordegastos.R

class ExpenseAdapter(private val expenses: List<Expense>) : RecyclerView.Adapter<ExpenseHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.expense_item, parent, false)
        return ExpenseHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseHolder, position: Int) {
        holder.edtExpenseVal.text = expenses[position].expensesValue
    }

    override fun getItemCount(): Int = expenses.size

}

class ExpenseHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    var edtExpenseVal: TextView = view.findViewById(R.id.edtExpenseVal)
}