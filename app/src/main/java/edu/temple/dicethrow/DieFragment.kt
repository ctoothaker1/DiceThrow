package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.Array.getInt
import kotlin.random.Random




class DieFragment : Fragment() {

    private val dieViewModel : DieViewModel by lazy {
        ViewModelProvider(requireActivity())[DieViewModel::class.java]
    }

    val DIESIDE = "sidenumber"
    val STRING_KEY = "stringkey"
    private lateinit var dieTextView: TextView

    private var dieSides: Int = 6
    private var rollValue: Int = -1


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // we will be using a bundle to carry over data from previous throw
        super.onViewCreated(view, savedInstanceState)

//        savedInstanceState?.run {
//
//        rollValue = getInt(STRING_KEY)
//        }
        //throwDie()
//        view.setOnClickListener{
//            throwDie()
//        }

//        if (rollValue < 0){
//            throwDie()
//        } else{
//            dieTextView.text = rollValue.toString()
//        }

        dieViewModel.getDieRoll().observe(viewLifecycleOwner){
            dieTextView.text = it.toString()
        }
        if (dieViewModel.getDieRoll().value == null){
            throwDie()
        }

    }

    fun throwDie() {
        dieViewModel.setDieRoll(Random.nextInt(dieSides) + 1)
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        //outState.getInt(this.rollValue)
//
//        outState.putInt(STRING_KEY, rollValue)
//
//    }

    companion object {       // accept how many sides a die will have
        fun newInstance(sides: Int) = DieFragment().apply {
            arguments = Bundle().apply { putInt(DIESIDE,sides) }


        }
    }

}