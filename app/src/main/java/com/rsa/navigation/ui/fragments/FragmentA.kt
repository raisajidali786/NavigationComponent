package com.rsa.navigation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.rsa.navigation.R

class FragmentA : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        view.findViewById<Button>(R.id.btnGotoFragB).setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentA_to_fragmentB)
        }
        view.findViewById<Button>(R.id.btnSendDataToFragB).setOnClickListener {
            val bundle = bundleOf()
            bundle.putString("data","This is data(By Bundle)")
            it.findNavController().navigate(R.id.action_fragmentA_to_fragmentB, bundle)
        }
        return view
    }
}