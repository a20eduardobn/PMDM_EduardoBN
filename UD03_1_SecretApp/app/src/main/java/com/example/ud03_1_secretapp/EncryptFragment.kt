package com.example.ud03_1_secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EncryptFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val message = EncryptFragmentArgs.fromBundle(requireArguments()).message.uppercase()
        var iterationarray = message.toCharArray().iterator()
        var messageCifrado = ""
        while (iterationarray.hasNext()) {
            var valorchar = iterationarray.nextChar().code + 3
            if (valorchar > 'Z'.code) {
                valorchar = '@'.code + (valorchar - 'Z'.code)
            }
            messageCifrado += valorchar.toChar()
        }

        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        view.findViewById<TextView>(R.id.encrypt_textValue).text = messageCifrado
        return view
    }

}