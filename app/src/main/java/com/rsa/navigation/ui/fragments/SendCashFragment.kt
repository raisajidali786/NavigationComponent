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
import androidx.navigation.fragment.navArgs
import com.rsa.navigation.R
import com.rsa.navigation.ui.utils.TestData
import kotlinx.android.synthetic.main.fragment_send_cash.*

class SendCashFragment : Fragment(R.layout.fragment_send_cash) {
    private val args: SendCashFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etAmount.setText(TestData.defaultAmount.toString())
        TestData.defaultAmount.observe(viewLifecycleOwner){
            etAmount.setText(it.toString())
        }

        val receiverName = args.receiverName
        receiver_name.text = "Send cash to $receiverName"
        btnSend.setOnClickListener {
            if (etAmount.text.isEmpty()) {
                return@setOnClickListener
            }
            val amount = etAmount.text.toString().toLong()
            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(
                receiverName,
                amount
            )
            findNavController().navigate(action)
        }
        btnDone.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToNavHostFragment()
            findNavController().navigate(action)
        }
        btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}