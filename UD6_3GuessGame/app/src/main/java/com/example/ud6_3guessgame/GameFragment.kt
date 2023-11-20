package com.example.ud6_3guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.ud6_3guessgame.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private val gameModel: GameViewModel by viewModels(
        ownerProducer = { this.requireActivity() }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
//        updateScreen()

        binding.buttonText.setOnClickListener {
            if (binding.txtGuess.text.isEmpty()) {
                Toast.makeText(activity, "Introduce una letra", Toast.LENGTH_LONG).show()
            } else {
                gameModel.game(binding.txtGuess.text.toString()[0])
//                updateScreen()
                if (gameModel.win() || gameModel.lost()){
                    view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
                }
            }
            //gameModel.secretWord = "Abc"
            //view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
        }
        gameModel.lives.observe(
            viewLifecycleOwner,
            Observer {
                newvalue -> binding.txtLives.text = "Te quedan ${newvalue} vidas"
            }
        )
        gameModel.secretWordDisplay.observe(
            viewLifecycleOwner,
            Observer {
                it-> binding.txtWord.text = it
            }
        )
        return view
    }

//    fun updateScreen() {
//        binding.txtWord.text = gameModel.secretWordDisplay.value
//        binding.txtLives.text = "Te quedan ${gameModel.lives.value} vidas"
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
