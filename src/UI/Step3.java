/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Step3.java
 *
 * Created on 02/07/2010, 20:54:22
 */

package UI;

import java.awt.Color;
import modelo.Game;

import modelo.Jugador;

public class Step3 extends Step {

   

    /** Creates new form Step3 */
    public Step3() {
        initComponents();
        
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(Color.WHITE);
        accion = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(433, 223));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("La jugada que debe realizar es:");
        jLabel1.setName("jLabel1"); // NOI18N

        accion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        accion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        accion.setText("ASD");
        accion.setName("accion"); // NOI18N
        
        this.setBackground("imagenes/snookar-cloth-first-grade.jpg");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(accion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public boolean executeStep() {
       return false;
    }

    @Override
    public void setVisible(boolean visible){
        if( visible == true ){
            Jugador.Accion accionElegida = Game.getInstance().getJugador().getAccion();

            if( accionElegida == Jugador.Accion.Call)
                this.accion.setForeground(Color.green);
            else
                this.accion.setForeground(Color.red);

            this.accion.setText(accionElegida.toString());
        }
        super.setVisible(visible);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accion;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
