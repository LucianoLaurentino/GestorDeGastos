package br.com.lucianolaurentino.gestordegastos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.lucianolaurentino.gestordegastos.databinding.ActivityNewExpenseBinding
import br.com.lucianolaurentino.gestordegastos.model.Expense
import br.com.lucianolaurentino.gestordegastos.repository.ExpenseRepository
import com.google.android.material.snackbar.Snackbar

class NewExpenseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewExpenseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveExpense.setOnClickListener {

            val repository = ExpenseRepository(applicationContext)
            val expenseValue = binding.edtExpense.text.toString()

            val expense = Expense(
                expensesValue = expenseValue
            )

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("expenseValue", expenseValue)
            startActivity(intent)

            if (repository.insert(expense) != 0) {
                Snackbar.make(it, "Expense value saved with success!!!", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}