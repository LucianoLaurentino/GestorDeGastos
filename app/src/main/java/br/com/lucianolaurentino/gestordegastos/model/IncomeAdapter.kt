package br.com.lucianolaurentino.gestordegastos.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucianolaurentino.gestordegastos.R

class IncomeAdapter(private val incomes: List<Income>) : RecyclerView.Adapter<IncomesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.incomes_item, parent, false)
        return IncomesHolder(view)
    }

    override fun onBindViewHolder(holder: IncomesHolder, position: Int) {
        holder.edtIncomesVal.text = incomes[position].incomesValue
    }

    override fun getItemCount(): Int = incomes.size

}

class IncomesHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    var edtIncomesVal: TextView = view.findViewById(R.id.edtIncomesVal)
}