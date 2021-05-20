package es.iesramonarcas.amg.messenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Yo {
    static ServerSocket servidor;
    static Socket cliente;
    
    static void escuchar() {
        try {
            Yo.servidor = new ServerSocket(5000);
            Yo.cliente = Yo.servidor.accept();
        } catch (IOException ex) {
            System.out.println("ERROR en escuchar");
        }
    }
    
    static void enviar(String mensaje) {
        try {
            OutputStream os = Yo.cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(mensaje);
        } catch (IOException ex) {
            System.out.println("ERROR en enviar");
        }
    }
    
    static String recibir() {
        String mensaje = null;
        
        try {
            InputStream os = Yo.cliente.getInputStream();
            DataInputStream dos = new DataInputStream(os);
            mensaje = dos.readUTF();
            return mensaje;
        } catch (IOException ex) {
            System.out.println("ERROR en recibir");
        }
        
        return null;
    }
}