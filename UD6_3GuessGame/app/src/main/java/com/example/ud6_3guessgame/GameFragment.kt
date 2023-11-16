package com.example.ud6_3guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.ud6_3guessgame.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater,container,false)
        val view = binding.root
        val gameModel: GameViewModel by viewModels()
        binding.buttonText.setOnClickListener {
            gameModel.secretWord = "Abc"
            view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}
