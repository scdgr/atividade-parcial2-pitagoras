/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pitagorasgurarapari.parcial2oo;

import com.pusher.rest.Pusher;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alunos
 */
public class Teste {

    public static void main(String[] args) {
        Pusher pusher = new Pusher("531130", "d9fa8bf48773fde111e7", "8728c7c304bd5a5f4319");
        pusher.setCluster("us2");
        pusher.setEncrypted(true);

        Map<String,String> mensagem = new HashMap();
        mensagem.put("user", "Joao");
        mensagem.put("message", "Testando chat");
        pusher.trigger("my-channel", "my-event", mensagem);

    }

}
