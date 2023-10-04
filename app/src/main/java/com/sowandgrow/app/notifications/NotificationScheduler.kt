package com.sowandgrow.app.notifications

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import com.sowandgrow.app.databinding.ActivityNotificationSchedulerBinding
import java.util.*

class NotificationScheduler : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationSchedulerBinding
    private val notificationPermissionRequestCode = 1001

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationSchedulerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check if notification permission is granted
        if (!isNotificationPermissionGranted()) {
            // If not granted, request permission
            requestNotificationPermission()
        }

        createNotificationChannel() // Always create the notification channel
        binding.submitButton.setOnClickListener { scheduleNotification() }
    }

    private fun requestNotificationPermission() {
        val intent = Intent()
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName)
        } else
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("app_package", packageName)
            intent.putExtra("app_uid", applicationInfo.uid)
        startActivityForResult(intent, notificationPermissionRequestCode)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == notificationPermissionRequestCode) {
            // Check if the user granted notification permission
            if (isNotificationPermissionGranted()) {
                // Permission granted, create the notification channel with sound
                createNotificationChannel()
            } else {
                // Permission denied, handle accordingly (e.g., show a message)
            }
        }
    }

    private fun isNotificationPermissionGranted(): Boolean {
        val notificationManager = NotificationManagerCompat.from(this)
        return notificationManager.areNotificationsEnabled()
    }

    @SuppressLint("ScheduleExactAlarm")
    private fun scheduleNotification() {
        val intent = Intent(applicationContext, Notification::class.java)
        val title = binding.titleET.text.toString()
        val message = binding.messageET.text.toString()
        intent.putExtra(titleExtra, title)
        intent.putExtra(messageExtra, message)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            notificationID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )
        showAlert(time, title, message)
    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)

        AlertDialog.Builder(this)
            .setTitle("Notification Scheduled")
            .setMessage(
                "Title: $title\nMessage: $message\nAt: ${dateFormat.format(date)} ${timeFormat.format(date)}"
            )
            .setPositiveButton("Okay") { _, _ -> }
            .show()
    }

    private fun getTime(): Long {
        val minute = binding.timePicker.minute
        val hour = binding.timePicker.hour
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month
        val year = binding.datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val name = "Notif Channel"
        val desc = "A Description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = desc

        channel.setSound(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI, null)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}
