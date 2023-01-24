package com.rsa.navigation.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.rsa.navigation.R
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationsListView.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,getNotifications())
    }

    private fun getNotifications(): List<String> {
        val notifications = mutableListOf<String>()
        for (i in 1..20){
            notifications.add(" Notifications # $i")
        }
        return notifications
    }

}