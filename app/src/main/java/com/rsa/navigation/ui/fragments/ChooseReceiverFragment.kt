package com.rsa.navigation.ui.fragments

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.rsa.navigation.R
import com.rsa.navigation.ui.utils.CHANNEL_ID
import kotlinx.android.synthetic.main.fragment_choose_receiver.*

class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext.setOnClickListener {
            val receiverName = etReceiverName.text.toString()

            val pendingIntent =
                NavDeepLinkBuilder(requireContext()).setGraph(R.navigation.nav_graph)
                    .setDestination(R.id.sendCashFragment)
                    .setArguments(SendCashFragmentArgs(receiverName).toBundle())
                    .createPendingIntent()
            showNotification(pendingIntent, receiverName)

            val action = ChooseReceiverFragmentDirections
                .actionChooseReceiverFragmentToSendCashFragment(receiverName)
            findNavController().navigate(action)
        }
        btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun showNotification(pendingIntent: PendingIntent, receiverName: String) {
        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle("Transaction Completed!")
            .setContentTitle("Send money to $receiverName")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(requireContext()).notify(1, notification)
    }
}