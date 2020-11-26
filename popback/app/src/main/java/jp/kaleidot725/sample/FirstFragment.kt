package jp.kaleidot725.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nextButton = view.findViewById<Button>(R.id.button_next)
        nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val backButton = view.findViewById<Button>(R.id.button_pop_back_stack)
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}