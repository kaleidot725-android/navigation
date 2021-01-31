package jp.kaleidot725.navgraph.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import jp.kaleidot725.navgraph.R
import jp.kaleidot725.navgraph.databinding.FragmentFirstBinding
import jp.kaleidot725.navgraph.model.Counter
import jp.kaleidot725.navgraph.viewmodel.CountViewModel

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel = CountViewModel(Counter)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigateButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
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
