package br.com.pitagorasgurarapari.parcial2oo;

import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.rest.Pusher;
import java.util.HashMap;
import java.util.Map;

public class ControleChat {
    
    private Pusher pusher;
    private Channel channel;
    com.pusher.client.Pusher pusherCliente;
    
    private static final String APP_ID ="535996";
    private static final String KEY = "6aaab1066467567d4da5";
    private static final String SECRET = "97c62a01600e7dbc535f";
    
    public void inicializaPusher(){
        pusher = new Pusher(APP_ID, KEY, SECRET);
        pusher.setCluster("us2");
        pusher.setEncrypted(true);
        
        PusherOptions options = new PusherOptions();
        options.setCluster("us2");
        pusherCliente = new com.pusher.client.Pusher(KEY, options);
        channel = pusherCliente.subscribe("pitagoras-guarapari");
        //TODO CONECTAR O pusherClient para poder receber as mensagens
        
        pusherCliente.connect();
    }
    
    public void enviarMenssagem(Usuario user, String mensagem){
        Map<String,String> conteudo = new HashMap<>();
        conteudo.put("usuario", user.getNome());
        conteudo.put("mensagem", mensagem);
        pusher.trigger("pitagoras-guarapari", "imagem-acao", conteudo);
        //TODO FAZER O ENVIO DA MENSAGEM USANDO O OBJETO pusher
    }

    public Channel getChannel() {
        return channel;
    }                
}
