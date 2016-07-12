package br.com.caelum.casadocodigo.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.activity.MainActivity;

/**
 * Created by alex-felipe on 20/06/16.
 */
public class CDCMessasingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        mostrarNotificacao(notification);
        Map<String, String> data = remoteMessage.getData();
    }

    public void mostrarNotificacao(RemoteMessage.Notification notification) {
        String titulo = notification.getTitle();
        String mensagem = notification.getBody();

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent
                .getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        Notification notificacao = builder
                .setSmallIcon(R.drawable.casadocodigo)
                .setContentTitle(titulo)
                .setContentText(mensagem)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager nm =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0, notificacao);
    }
}
