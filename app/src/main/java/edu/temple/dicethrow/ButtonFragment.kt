package edu.temple.dicethrow

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class ButtonFragment : Fragment() {


    override fun onAttach(context: Context) { // first step in the lifecycle
        super.onAttach(context)
        if (context !is ButtonInterface){
            throw
                    Exception() //Must implement ButtonInterface before using fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button, container, false).apply {
            findViewById<Button>(R.id.rollButton).setOnClickListener{
                (requireActivity() as ButtonInterface).buttonClicked() // this only works if parent has implemented interface, and fragment is visible to the user

            }
        }

    }
    interface ButtonInterface{ // a list of functions
        fun buttonClicked()         // this will allow communication between parent, expect parent to implement this fn

    }

}