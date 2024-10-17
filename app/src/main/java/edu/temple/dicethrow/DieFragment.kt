package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

const val DIESIDE = "sidenumber" // must initialize outside of class

class DieFragment : Fragment() {

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        savedInstanceState?.run {

        }

        throwDie()
        view.setOnClickListener{
            throwDie()
        }


    }


    fun throwDie() {

        dieTextView.text = (Random.nextInt(dieSides)+1).toString()
    }


    companion object {       // accept how many sides a die will have
        fun newInstance(sides: Int) = DieFragment().apply {
            arguments = Bundle().apply { putInt(DIESIDE,sides) }


        }
    }

}