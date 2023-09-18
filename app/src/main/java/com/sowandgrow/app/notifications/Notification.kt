package com.sowandgrow.app.notifications

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.sowandgrow.app.R

const val notificationID = 1
const val channelID = "channel1"
const val titleExtra = "titleExtra"
const val messageExtra = "messageExtra"

class Notification : BroadcastReceiver()
{
    override fun onReceive(context: Context, intent: Intent)
    {
        val notification = NotificationCompat.Builder(context, channelID)
            .setSmallIcon(R.drawable.sowandgrowlogo)
            .setContentTitle(intent.getStringExtra(titleExtra))
            .setContentText(intent.getStringExtra(messageExtra))
            .setSound(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI)
            .build()

        val  manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(notificationID, notification)
    }
}
