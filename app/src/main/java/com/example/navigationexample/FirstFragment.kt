package com.example.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        //Aguardando a ação do usuário de voltar no app
        activity?.onBackPressedDispatcher?.addCallback {
            findNavController().popBackStack()
        }

        //Ação de clique para navegação para tela 2 e enviando dados entre telas
        view.findViewById<Button>(R.id.buttonFragment2).setOnClickListener {
            findNavController().navigate(
                R.id.action_firstFragment_to_secondFragment,
                Bundle().apply {
                    putString("EXTRA", "Fragment 2")
                }

            )
        }

        return view
    }
}