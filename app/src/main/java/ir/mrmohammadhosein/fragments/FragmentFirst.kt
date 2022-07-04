package ir.mrmohammadhosein.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ir.mrmohammadhosein.fragments.databinding.FragmentFirstBinding

const val KEY_SEND_DATA = "nameKarbar"
const val KEY_SEND_PARCELABLE = "myPerson"

class FragmentFirst : Fragment() {
    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnGoToSecond.setOnClickListener {

            val name = binding.edtName.text.toString()
            val lastname = binding.edtLastName.text.toString()
            val age = 21
            val gender = true

            if (name.isNotEmpty() && lastname.isNotEmpty()) {


                // pass data to fragment second :)

//                val bundle = Bundle()
//                bundle.putString( KEY_SEND_DATA , " $name $lastname " )

                val data = Person(name, lastname, age, gender)

                val bundle = Bundle()
                bundle.putParcelable( KEY_SEND_PARCELABLE , data )


                val fragment = FragmentSecond()
                fragment.arguments = bundle

                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_main_container, fragment)
                transaction.addToBackStack(null)
                transaction.commit()


            } else {
                Toast.makeText(
                    context,
                    "لطفا نام و نام خانوادگی خود را وارد کنید :)",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }


    }

}