package com.example.tablayoutfragment

import androidx.core.app.NotificationManagerCompat
import androidx.media.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        p0.notification?.title?.let { getFirebaeMessage(it, p0.notification?.body) }
    }

   fun getFirebaeMessage(title:String, msg: String?){

       var builder:androidx.core.app.NotificationCompat.Builder=androidx.core.app.NotificationCompat.Builder(applicationContext,"Notification channel")
           .setSmallIcon(R.drawable.ic_notifications)
           .setContentTitle(title)
           .setContentText(msg)
           .setAutoCancel(true)

      var manager:NotificationManagerCompat= NotificationManagerCompat.from(this)
       manager.notify(101,builder.build())

   }
}