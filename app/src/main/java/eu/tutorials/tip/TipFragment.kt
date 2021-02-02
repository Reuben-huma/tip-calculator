package eu.tutorials.tip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import eu.tutorials.tip.databinding.FragmentTipBinding
import eu.tutorials.tip.model.TipViewModel

class TipFragment : Fragment() {

    private val tipViewModel: TipViewModel by viewModels()
    private lateinit var binding: FragmentTipBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = tipViewModel
            tipFragment = this@TipFragment
        }

        binding.switchMaterial.setOnCheckedChangeListener{ _,value -> Toast.makeText(context, "Checked is $value", Toast.LENGTH_SHORT).show() }
    }

    fun onCalculate() {
        tipViewModel.setTip(binding.textInputEditText.text.toString())
    }

}