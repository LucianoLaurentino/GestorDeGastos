package br.com.lucianolaurentino.gestordegastos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucianolaurentino.gestordegastos.databinding.ActivityMainBinding
import br.com.lucianolaurentino.gestordegastos.model.ExpenseAdapter
import br.com.lucianolaurentino.gestordegastos.repository.ExpenseRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Quando clicar, abre tela de adicionar despesa
        binding.fabAddExpense.setOnClickListener {
            val openExpenseAdd = Intent(applicationContext, NewExpenseActivity::class.java)
            startActivity(openExpenseAdd)
        }
        //Quando clicar, abre a tela de renda
        binding.btnIncomes.setOnClickListener {
            val openIncomes = Intent(applicationContext, IncomesActivity::class.java)
            startActivity(openIncomes)
        }

        val expenseTotal = intent.getStringExtra("expenseTotal")
        binding.txtExpenseTotal.setText(expenseTotal)

    }

    override fun onStart() {
        super.onStart()
        val repository = ExpenseRepository(applicationContext)
        val expenses = repository.findAll()
        binding.rvExpenses.adapter = ExpenseAdapter(expenses)
        binding.rvExpenses.hasFixedSize()
        binding.rvExpenses.layoutManager = LinearLayoutManager(applicationContext)
    }
}