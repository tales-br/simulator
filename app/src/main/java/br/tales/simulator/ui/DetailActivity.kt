package br.tales.simulator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.tales.simulator.databinding.ActivityDetailBinding
import br.tales.simulator.domain.Match
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity()
{
    object Extras
    {
        const val MATCH = "EXTRA_MATCH"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadMatchFromExtra()
    }

    private fun loadMatchFromExtra()
    {
        intent?.extras?.getParcelable<Match>(Extras.MATCH)?.let {
            Glide.with(this).load(it.local.image).into(binding.ivPlace)
            supportActionBar?.title = it.local.name
        }
    }
}