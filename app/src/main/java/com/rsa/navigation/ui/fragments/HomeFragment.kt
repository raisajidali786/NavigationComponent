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
import androidx.navigation.fragment.findNavController
import com.rsa.navigation.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        btnViewBalance.setOnClickListener {
            val action = HomeFragmentDirections.actionNavHostFragmentToFragmentViewBalance()
            controller.navigate(action)
        }

        btnViewTransaction.setOnClickListener {
            val action = HomeFragmentDirections.actionNavHostFragmentToViewTransactionFragment()
            controller.navigate(action)
        }
        btnSendMoney.setOnClickListener {
            val action = HomeFragmentDirections.actionNavHostFragmentToChooseReceiverFragment()
            controller.navigate(action)
        }
    }
}