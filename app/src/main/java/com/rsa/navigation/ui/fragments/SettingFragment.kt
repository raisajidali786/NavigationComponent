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
import com.rsa.navigation.NavGraphDirections
import com.rsa.navigation.R
import com.rsa.navigation.ui.utils.TestData
import kotlinx.android.synthetic.main.fragment_choose_receiver.*
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment(R.layout.fragment_setting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etDefaultAmount.setText(TestData.defaultAmount.value.toString())
        btnSave.setOnClickListener {
            val amount = etDefaultAmount.text.toString().toLong()
            TestData.defaultAmount.value = amount
        }
        btnAbout.setOnClickListener {
            val action = NavGraphDirections.actionGlobalAboutAppFragment()
            findNavController().navigate(action)
        }
    }
}