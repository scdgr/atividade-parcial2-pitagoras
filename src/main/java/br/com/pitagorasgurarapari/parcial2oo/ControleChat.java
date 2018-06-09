/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pitagorasgurarapari.parcial2oo;

import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.rest.Pusher;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alunos
 */
public class ControleChat {
    
    private Pusher pusher;
    private Channel channel;
    com.pusher.client.Pusher pusherCliente;
    
    private static final String APP_ID ="531130";
    private static final String KEY = "d9fa8bf48773fde111e7";
    private static final String SECRET = "8728c7c304bd5a5f4319";
    
    public void inicializaPusher(){
        pusher = new Pusher(APP_ID, KEY, SECRET);
        pusher.setCluster("us2");
        pusher.setEncrypted(true);
        
        PusherOptions options = new PusherOptions();
        options.setCluster("us2");
        pusherCliente = new com.pusher.client.Pusher(KEY, options);
        channel = pusherCliente.subscribe("pitagoras-guarapari");
        pusherCliente.connect();
    }
    
    public void enviarMenssagem(Usuario user, String mensagem){
        Map<String,String> conteudo = new HashMap<>();
        conteudo.put("usuario", user.getNome());
        conteudo.put("mensagem", mensagem);
        pusher.trigger("pitagoras-guarapari", "imagem-acao", conteudo);
    }

    public Channel getChannel() {
        return channel;
    }
    
    
    
    
}
