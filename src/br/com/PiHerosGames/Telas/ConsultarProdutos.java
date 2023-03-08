/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.PiHerosGames.Telas;

import java.sql.*;
import br.com.PiHerosGames.conexao.ModuloConexao;
import javax.swing.JOptionPane;

/**
 *
 * @author eders
 */
public class ConsultarProdutos extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ConsultarProdutos() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    // Método para Deletar produtos 
    public void deletaProd() {
        String deletProdSql = "DELETE FROM tb_produtos WHERE idtb_produtos = ?";
        try {
            pst = conexao.prepareStatement(deletProdSql);
            pst.setString(1, txt_IdProd.getText());
            //Executa a query deletProdSql
            int deletProd = pst.executeUpdate();
            if (deletProd > 0) {
                JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
                LimparPainel();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao deletar verifique os dados corretamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Método para consultar produtos

    public void consultaProd() {
        String consultaProdSql = "SELECT * FROM tb_produtos WHERE descricao_produtos = ?";
        try {
            pst = conexao.prepareStatement(consultaProdSql);
            pst.setString(1, txt_NomeProd.getText());
            //Executa a query consultaProdSql
            rs = pst.executeQuery();
            if (rs.next()) {
                txt_IdProd.setText(rs.getString(1));
                txt_NomeProd.setText(rs.getString(2));
                txt_MarcaProd.setText(rs.getString(3));
                txt_PrecoProd.setText(rs.getString(4));
                txt_CaractProd.setText(rs.getString(5));
                spin_EstoqueProd.setValue(rs.getInt(6));
            } else {
                JOptionPane.showMessageDialog(null, "Produto Não Cadastrado !");
                LimparPainel();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //Método para limpar campos

    public void LimparPainel() {
        txt_IdProd.setText(null);
        txt_NomeProd.setText(null);
        txt_MarcaProd.setText(null);
        txt_PrecoProd.setText(null);
        spin_EstoqueProd.setValue(0);
        txt_CaractProd.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_NomeProd = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_IdProd = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_PrecoProd = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_MarcaProd = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        txt_CaractProd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        spin_EstoqueProd = new javax.swing.JSpinner();
        btn_ConsutaProd = new javax.swing.JButton();
        btn_DeletarProd = new javax.swing.JButton();
        btn_EditarProd = new javax.swing.JButton();
        btn_Limpar = new javax.swing.JButton();
        btn_Voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel1.setText("Consultar Produtos");

        jLabel2.setText("Nome  Produto:");

        jScrollPane1.setViewportView(txt_NomeProd);

        jLabel3.setText("Id Produto:");

        jScrollPane2.setViewportView(txt_IdProd);

        jLabel4.setText("Marca Produto:");

        jScrollPane3.setViewportView(txt_PrecoProd);

        jLabel5.setText("Preço Produto:");

        jScrollPane4.setViewportView(txt_MarcaProd);

        jLabel6.setText("Caracteristica Produto:");

        jLabel7.setText("Estoque Produto:");

        btn_ConsutaProd.setText("Consultar");
        btn_ConsutaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsutaProdActionPerformed(evt);
            }
        });

        btn_DeletarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/Close.png"))); // NOI18N
        btn_DeletarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeletarProdActionPerformed(evt);
            }
        });

        btn_EditarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/Editar.png"))); // NOI18N
        btn_EditarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarProdActionPerformed(evt);
            }
        });

        btn_Limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/Limpar.png"))); // NOI18N
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        btn_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/sair.png"))); // NOI18N
        btn_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Limpar)
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_DeletarProd)
                                        .addGap(34, 34, 34)
                                        .addComponent(btn_EditarProd)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_ConsutaProd)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(spin_EstoqueProd)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_CaractProd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(btn_Voltar)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(3, 3, 3)
                        .addComponent(txt_CaractProd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(spin_EstoqueProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_ConsutaProd)
                        .addGap(74, 74, 74))
                    .addComponent(btn_EditarProd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Limpar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Voltar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_DeletarProd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ConsutaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsutaProdActionPerformed
        consultaProd();
    }//GEN-LAST:event_btn_ConsutaProdActionPerformed

    private void btn_DeletarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeletarProdActionPerformed
        int deletar = JOptionPane.showConfirmDialog(null, " Tem certeza que deseja excluir o produto ?","Atenção",JOptionPane.YES_NO_OPTION);
        if(deletar == JOptionPane.YES_OPTION){
            deletaProd();
        }
        
    }//GEN-LAST:event_btn_DeletarProdActionPerformed

    private void btn_EditarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EditarProdActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        LimparPainel();
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void btn_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VoltarActionPerformed
        CadastroProdutos CadProd = new CadastroProdutos();
        CadProd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_VoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsutaProd;
    private javax.swing.JButton btn_DeletarProd;
    private javax.swing.JButton btn_EditarProd;
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JButton btn_Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner spin_EstoqueProd;
    private javax.swing.JTextField txt_CaractProd;
    private javax.swing.JTextPane txt_IdProd;
    private javax.swing.JTextPane txt_MarcaProd;
    private javax.swing.JTextPane txt_NomeProd;
    private javax.swing.JTextPane txt_PrecoProd;
    // End of variables declaration//GEN-END:variables
}
