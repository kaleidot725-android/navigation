package jp.kaleidot725.navgraph.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import jp.kaleidot725.navgraph.databinding.FragmentSecondBinding
import jp.kaleidot725.navgraph.model.Counter
import jp.kaleidot725.navgraph.viewmodel.CounterViewModel

@AndroidEntryPoint
class SecondFragment  : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigateButton.setOnClickListener {
            findNavController().popBackStack()
            viewModel.increment()
        }

        viewModel.countLiveData.observe(findNavController().currentBackStackEntry!!) {
            binding.countText.text = "POPUP:" + it.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
