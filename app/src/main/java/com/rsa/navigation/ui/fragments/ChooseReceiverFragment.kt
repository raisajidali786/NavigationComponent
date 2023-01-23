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
import kotlinx.android.synthetic.main.fragment_choose_receiver.*

class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext.setOnClickListener {
            val receiverName = etReceiverName.text.toString()
            val action = ChooseReceiverFragmentDirections
                .actionChooseReceiverFragmentToSendCashFragment(receiverName)
            findNavController().navigate(action)
        }
        btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}