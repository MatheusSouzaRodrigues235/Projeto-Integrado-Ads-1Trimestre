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
public class CadastroProdutos extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProdutos
     */
    public CadastroProdutos() {
        initComponents();
        conexao = ModuloConexao.conector();

    }

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void cadastroProdutos() {
        String sqlCadProd = "INSERT INTO tb_produtos (descricao_produtos, marca_produtos, preco_produtos, caracteristica_produtos, estoque_produtos) VALUES (?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sqlCadProd);
            pst.setString(1, txt_descProduto.getText());
            pst.setString(2, txt_MarcaProduto.getText());
            pst.setString(3, txt_PrecoProduto.getText());
            pst.setString(4, txt_CaractProd.getText());
            pst.setString(5, spin_Estoque.getValue().toString());
            if ((txt_descProduto.getText().isEmpty()) || (txt_MarcaProduto.getText().isEmpty()) || (txt_PrecoProduto.getText().isEmpty()) || (txt_CaractProd.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para cadastrar !");
            } else {
                //executa a query sqlCadProd 
                int insert = pst.executeUpdate();
                if (insert > 0) {
                    JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");
                    LimparPainel();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void LimparPainel() {
        txt_descProduto.setText("");
        txt_MarcaProduto.setText("");
        txt_PrecoProduto.setText("");
        spin_Estoque.setValue(0);
        txt_CaractProd.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_voltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_Cadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_MarcaProduto = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_CaractProd = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        spin_Estoque = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_PrecoProduto = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descProduto = new javax.swing.JTextPane();
        btn_panelCadastrar = new javax.swing.JButton();
        btn_PesquisaProdutos = new javax.swing.JButton();
        btn_LimparPanel = new javax.swing.JButton();
        btn_FecharPanel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                fecharPainel(evt);
            }
        });

        btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/sair.png"))); // NOI18N
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(13, 221, 186));

        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("Cadastrar Produtos");

        jLabel2.setText("Nome do Produto:");

        jLabel3.setText("Marca do Produto");

        jScrollPane2.setViewportView(txt_MarcaProduto);

        jLabel4.setText("Preço do Produto:");

        jLabel5.setText("Característica do produto:");

        jScrollPane3.setViewportView(txt_CaractProd);

        jLabel6.setText("Estoque do produto:");

        jScrollPane4.setViewportView(txt_PrecoProduto);

        jScrollPane1.setViewportView(txt_descProduto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(spin_Estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Cadastrar)
                        .addGap(32, 32, 32))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(spin_Estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Cadastrar)
                .addContainerGap())
        );

        btn_panelCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/Add.png"))); // NOI18N
        btn_panelCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_panelCadastrarActionPerformed(evt);
            }
        });

        btn_PesquisaProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/Research.png"))); // NOI18N
        btn_PesquisaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PesquisaProdutosActionPerformed(evt);
            }
        });

        btn_LimparPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/Limpar.png"))); // NOI18N
        btn_LimparPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparPanelActionPerformed(evt);
            }
        });

        btn_FecharPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/Close.png"))); // NOI18N
        btn_FecharPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FecharPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btn_panelCadastrar)
                .addGap(49, 49, 49)
                .addComponent(btn_PesquisaProdutos)
                .addGap(40, 40, 40)
                .addComponent(btn_LimparPanel)
                .addGap(42, 42, 42)
                .addComponent(btn_FecharPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_voltar)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_panelCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btn_PesquisaProdutos)
                    .addComponent(btn_LimparPanel)
                    .addComponent(btn_FecharPanel))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        PaginaInicial principal = new PaginaInicial();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void fecharPainel(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fecharPainel
        jPanel1.setVisible(false);

    }//GEN-LAST:event_fecharPainel

    private void btn_panelCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_panelCadastrarActionPerformed
        jPanel1.setVisible(true);
    }//GEN-LAST:event_btn_panelCadastrarActionPerformed

    private void btn_FecharPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FecharPanelActionPerformed
        jPanel1.setVisible(false);
    }//GEN-LAST:event_btn_FecharPanelActionPerformed

    private void btn_LimparPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparPanelActionPerformed
        LimparPainel();
    }//GEN-LAST:event_btn_LimparPanelActionPerformed

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
        cadastroProdutos();
    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private void btn_PesquisaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesquisaProdutosActionPerformed
        ConsultarProdutos ConsultaProd = new ConsultarProdutos();
        ConsultaProd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_PesquisaProdutosActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_FecharPanel;
    private javax.swing.JButton btn_LimparPanel;
    private javax.swing.JButton btn_PesquisaProdutos;
    private javax.swing.JButton btn_panelCadastrar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner spin_Estoque;
    private javax.swing.JTextPane txt_CaractProd;
    private javax.swing.JTextPane txt_MarcaProduto;
    private javax.swing.JTextPane txt_PrecoProduto;
    private javax.swing.JTextPane txt_descProduto;
    // End of variables declaration//GEN-END:variables
}
