package com.rsa.navigation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
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
        Log.d("check__","onCreateView")
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("check__","onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("check__","onViewCreated")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("check__","onAttach")
    }

    override fun onResume() {
        super.onResume()
        Log.d("check__","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("check__","onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("check__","onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("check__","onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("check__","onDetach")
    }
}