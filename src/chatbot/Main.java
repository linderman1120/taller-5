
package chatbot;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.applet.AudioClip;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main extends javax.swing.JFrame {

    String pregunta, respuesta,preguntagenerada;
    boolean reproducciendo=false;
     AudioClip sonido1, sonido2, alive;
     JLabel etiqueta5 = new JLabel(new ImageIcon("img.png"));
     
    
    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        texto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        panta = new javax.swing.JTextArea();
        online = new javax.swing.JLabel();
        Namebot = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enviar.setText("enviar");
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoActionPerformed(evt);
            }
        });

        panta.setEditable(false);
        panta.setColumns(20);
        panta.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        panta.setRows(5);
        panta.setText("¡Hola, soy Cortana, pregúntame lo que quieras! :D\n\n");
        jScrollPane1.setViewportView(panta);

        online.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        Namebot.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        Namebot.setText("ChatBot");

        jButton1.setText("Enseñar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Namebot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(online, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(texto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(enviar, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(online, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Namebot, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enviar))
                    .addComponent(texto, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // TODO add your handling code here:
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
        pregunta=texto.getText();
        respuesta=(new BuscaDatos().translate(texto.getText()));
        preguntagenerada=(new BuscaDatos().translate(generarpregunta()));
        panta.append("Usted: "+texto.getText() +"\n");
        if (respuesta.equalsIgnoreCase("ok")){
        panta.append("Cortana: Podrias enseñarme que debo responder si me dicen: '"+pregunta+"' "
                + "por favor (si/no)\n");
        String respuestUsuario= JOptionPane.showInputDialog("Deseas enseñarle?(si/no)");
        if (respuestUsuario.equalsIgnoreCase("si")){
             String respuestUsuarioPregunta= JOptionPane.showInputDialog("Que responder a '"+pregunta+"'");
             Leer aprender =new Leer();
             String nuevapalabra=aprender.preguntanueva(pregunta,respuestUsuarioPregunta);
             aprender.guardar(aprender.leertxt("datos.txt"), nuevapalabra);   
        }
    }
        texto.setText("");
        animacionEscribir(respuesta);
        int probabilidad=mitadProbabilidad();
        //System.out.println(probabilidad);
        if(probabilidad>5){
        //  System.out.println("entra");
             animacionpregunta(preguntagenerada);
             if (preguntagenerada.equalsIgnoreCase("pongamos musica") && reproducciendo != true){
                 alive =java.applet.Applet.newAudioClip(getClass().getResource("./alive.wav"));
                 alive.play();
             }
             
        }   
        } catch (Exception e) {
        }
        }
        });
        hilo.start();

    }//GEN-LAST:event_enviarActionPerformed

    public String generarpregunta(){
        int numero;
        numero = (int) (Math.random() * 9) + 1;
        String preguntaAleatoria = Integer.toString(numero);
        String preguntacompletada= preguntaAleatoria+"p";
        return preguntacompletada;
    }
    public int mitadProbabilidad(){
         int numero;
        numero = (int) (Math.random() * 9) + 1;
        return numero;
    }
    public void animacionEscribir(String respuestaxd) throws InterruptedException, 
            URISyntaxException, IOException{
        sonido1 =java.applet.Applet.newAudioClip(getClass().getResource
        ("./mensajellegada.wav"));
        sonido2 =java.applet.Applet .newAudioClip(getClass().getResource
        ("./pop.wav"));
        Thread.sleep(generarRandom());
        online.setForeground(Color.blue);
        sonido2.play();
        online.setText("Visto");
        Thread.sleep(generarRandom());
        online.setText("Escribiendo..."); 
        Thread.sleep(generarRandom());
        online.setText("");
        sonido1.play();
        panta.append("Cortana: " + respuestaxd+"\n");
          if(pregunta.equalsIgnoreCase("reproducir musica")){
            reproducciendo=true;
              Desktop.getDesktop().browse(new URI
        ("https://www.youtube.com/watch?v=I_izvAbhExY"));
          //  alive =java.applet.Applet.newAudioClip(getClass().getResource("./alive.wav"));
           // alive.play();
        }
        //  System.out.println(generarRandom());
        
    }
      public void animacionpregunta(String respuestaxd) throws InterruptedException{
        sonido1 =java.applet.Applet.newAudioClip(getClass().getResource("./mensajellegada.wav"));
        Thread.sleep(1500);
        online.setText("Escribiendo"); 
        Thread.sleep(1000);
        online.setText("");
        sonido1.play();
        panta.append("Cortana: "+ respuestaxd+"\n");
    }
    
    public int generarRandom(){
        int numero;
        numero = (int) (Math.random() * 4000) + 1000;
        return numero;
        
    }
    public void fijarTexto(){
         panta.append("Maquina: "+ respuesta+"\n");
        texto.setText("");
    }
    private void textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_textoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String UsuarioPregunta= JOptionPane.showInputDialog("Ingrese pregunta");
         String respuestUsuarioPregunta= JOptionPane.showInputDialog("En respuesta a tu pregunta es: "
                 + "'"+ UsuarioPregunta+"'");
         Leer aprender =new Leer();
         String nuevapalabra=aprender.preguntanueva(UsuarioPregunta,respuestUsuarioPregunta);
         aprender.guardar(aprender.leertxt("datos.txt"), nuevapalabra);   
    }//GEN-LAST:event_jButton1ActionPerformed

    public JButton enviarPresionado(){
        return enviar;
    }
    public void setPanatalla(){
        panta.append("Maquina: "+ respuesta+"\n");
    }
    public JTextArea regresaPantalla(){
        return panta;
    }
    public JTextField regresaTexto(){
        return texto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Namebot;
    private javax.swing.JButton enviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel online;
    private javax.swing.JTextArea panta;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}
