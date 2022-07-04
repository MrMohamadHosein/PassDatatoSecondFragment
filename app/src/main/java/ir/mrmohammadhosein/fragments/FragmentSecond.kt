package ir.mrmohammadhosein.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.mrmohammadhosein.fragments.databinding.FragmentSecondBinding

class FragmentSecond :Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater , container , false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null) {

//            val myText = bundle.getString(KEY_SEND_DATA)
//            binding.txtShowName.text = myText

            val person = bundle.getParcelable<Person>(KEY_SEND_PARCELABLE)!!
            binding.txtShowName.text = " ${person.name} - ${person.lastName} - ${person.age} - ${person.gender} "


        } else {

            binding.txtShowName.text = "etelaati ferestade nashode ast!"

        }


    }

}