package br.com.lucianolaurentino.gestordegastos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.lucianolaurentino.gestordegastos.databinding.ActivityNewIncomeBinding
import br.com.lucianolaurentino.gestordegastos.model.Income
import br.com.lucianolaurentino.gestordegastos.repository.IncomeRepository
import com.google.android.material.snackbar.Snackbar

class NewIncomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewIncomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveIncome.setOnClickListener {

            val repository = IncomeRepository(applicationContext)
            val incomesValue = binding.edtIncome.text.toString()

            val income = Income(
                incomesValue = incomesValue
            )

            val intent = Intent(this, IncomesActivity::class.java)
            intent.putExtra("incomesValue", incomesValue)
            startActivity(intent)

            if (repository.insert(income) != 0) {
                Snackbar.make(it, "Income value saved with success!!!", Snackbar.LENGTH_SHORT)
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