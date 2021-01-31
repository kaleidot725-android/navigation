package jp.kaleidot725.navgraph.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.kaleidot725.navgraph.R
import jp.kaleidot725.navgraph.databinding.FragmentFirstBinding
import jp.kaleidot725.navgraph.model.Counter
import jp.kaleidot725.navgraph.viewmodel.CounterViewModel

@AndroidEntryPoint
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.v("FirstFragment", "onCreateView")
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onResume() {
        Log.v("FirstFragment", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.v("FirstFragment", "onPause")
        super.onPause()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigateButton.setOnClickListener {
            Log.v("FirstFragment", "NAVIGATE FRAGMENT")
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.navigateDialogButton.setOnClickListener {
            Log.v("FirstFragment", "NAVIGATE DIALOG")
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        viewModel.countLiveData.observe(findNavController().currentBackStackEntry!!) {
            Log.v("FirstFragment", "POPUP: ${it.toString()}")
            binding.countText.text = "POPUP:" + it.toString()
        }
    }

    override fun onDestroy() {
        Log.v("FirstFragment", "onDestroy")
        super.onDestroy()
        _binding = null
    }
}
