/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pitagorasgurarapari.parcial2oo;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionStateChange;

/**
 *
 * @author alunos
 */
public class TesteCliente {

    public static void main(String[] args) throws InterruptedException {
        PusherOptions options = new PusherOptions();
        options.setCluster("us2");
        Pusher pusher = new Pusher("d9fa8bf48773fde111e7", options);

        Channel channel = pusher.subscribe("pitagoras-guarapari");

        channel.bind("imagem-acao", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, final String data) {
                System.out.println(data);
            }
        });
        

        pusher.connect();
        Thread.sleep(30000);
    }

}
