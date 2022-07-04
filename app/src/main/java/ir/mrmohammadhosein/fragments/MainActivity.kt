package ir.mrmohammadhosein.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ir.mrmohammadhosein.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenFragmentFirst.setOnClickListener {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.frame_main_container , FragmentFirst() )
            transaction.addToBackStack(null)
            transaction.commit()

        }


    }
}