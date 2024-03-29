package com.example.ud03_1_secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class MessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        val buttonStart = view.findViewById<Button>(R.id.button_nect)
        buttonStart.setOnClickListener {
            val message = view.findViewById<EditText>(R.id.edit_text)
            val actions = MessageFragmentDirections.actionMessageFragmentToEncryptFragment(message.text.toString())
            view.findNavController().navigate(actions)
        }
        return view
    }
}