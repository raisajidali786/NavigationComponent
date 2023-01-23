package com.rsa.navigation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rsa.navigation.R
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*

class ConfirmDialogFragment : BottomSheetDialogFragment() {
    private val args: ConfirmDialogFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val receiverName = args.receiverName
        val amount = args.amount
        tv_message.text = "Do you want to send Rs$amount to $receiverName?"
        btnYes.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "$amount has been sent to $receiverName",
                Toast.LENGTH_SHORT
            ).duration
            dismiss()
        }
        btnNo.setOnClickListener {
            dismiss()
        }
    }
}