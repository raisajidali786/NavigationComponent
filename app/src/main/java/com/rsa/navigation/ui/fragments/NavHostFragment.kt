package com.rsa.navigation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.rsa.navigation.R

class NavHostFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_nav_host, container, false)
        view.findViewById<Button>(R.id.btnGotoFragA).setOnClickListener {
            it.findNavController().navigate(R.id.action_navHostFragment_to_fragmentA)
        }
        return view
    }
}