package com.example.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        //Aguardando a ação do usuário de voltar no app
        activity?.onBackPressedDispatcher?.addCallback {
            findNavController().popBackStack()
        }

        //Ação de clique para navegação para tela 3
        view.findViewById<Button>(R.id.buttonFragment3).setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        //Recebendo dados da tela 1
        view.findViewById<TextView>(R.id.textView).text = arguments?.getString("EXTRA") ?: "2"

        return view
    }
}