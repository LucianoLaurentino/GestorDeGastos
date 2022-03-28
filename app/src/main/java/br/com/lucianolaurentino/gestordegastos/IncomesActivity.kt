package br.com.lucianolaurentino.gestordegastos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucianolaurentino.gestordegastos.databinding.ActivityIncomesBinding
import br.com.lucianolaurentino.gestordegastos.model.IncomeAdapter
import br.com.lucianolaurentino.gestordegastos.repository.ExpenseRepository
import br.com.lucianolaurentino.gestordegastos.repository.IncomeRepository

class IncomesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIncomesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncomesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Quando clicar, abre a tela de adicionar renda
        binding.fabAddIncome.setOnClickListener {
            val openAddIncome = Intent(applicationContext, NewIncomeActivity::class.java)
            startActivity(openAddIncome)
        }
        //Quando clicar, abre a tela de despesas
        binding.btnExpense.setOnClickListener {
            val openBtnExpense = Intent(applicationContext, MainActivity::class.java)
            startActivity(openBtnExpense)
        }
        val incomeTotal = intent.getStringExtra("incomeValue")

        binding.txtIncomesTotal.setText(incomeTotal)
    }

    override fun onStart() {
        super.onStart()
        val repository = IncomeRepository(applicationContext)
        val incomes = repository.findAll()
        binding.rvIncomes.adapter = IncomeAdapter(incomes)
        binding.rvIncomes.hasFixedSize()
        binding.rvIncomes.layoutManager = LinearLayoutManager(applicationContext)
    }
}