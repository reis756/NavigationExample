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

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        //Aguardando a ação do usuário de voltar no app
        activity?.onBackPressedDispatcher?.addCallback {
            findNavController().popBackStack()
        }

        //Ação de clique para navegação para tela 1
        view.findViewById<Button>(R.id.buttonFragment1).setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        //Ação de clique para navegação para tela 2
        view.findViewById<Button>(R.id.buttonFragment2).setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }

        return view
    }
}