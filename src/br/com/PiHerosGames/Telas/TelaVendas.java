/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.PiHerosGames.Telas;

import java.sql.*;
import br.com.PiHerosGames.conexao.ModuloConexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eders
 */
public class TelaVendas extends javax.swing.JFrame {

    /**
     * Creates new form TelaVendas
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaVendas() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    public void limparCampos() {
        txt_codigoProd.setText(null);
        txt_qtdProd.setText(null);
        cbx_nomeProd.removeAllItems();
        txt_valProdD.setText(null);
    }

    public void getValPRod() {
        //Pega o valor do produto
        String SqlValProd = "SELECT * FROM tb_produtos WHERE idtb_produtos =?";
        try {
            pst = conexao.prepareStatement(SqlValProd);
            pst.setString(1, txt_codigoProd.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                String valProdI = rs.getString(4);
                txt_valProdD.setText(valProdI);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void getCampos() {

        String codigoProd = txt_codigoProd.getText();
        String nomeProd = cbx_nomeProd.getSelectedItem().toString();
        String qtdProd = txt_qtdProd.getText();
        String valProd = txt_valProdD.getText();

        double ValorPROD = Double.parseDouble(valProd);
        int qUantProd = Integer.parseInt(qtdProd);

        // Adiciona dados na tabela
        DefaultTableModel tabela = (DefaultTableModel) tbl_ProdutoAdd.getModel();
        Object[] dadosProd = new Object[]{
            nomeProd,
            ValorPROD,
            qUantProd
        };
        tabela.addRow(dadosProd);

    }

    public void ValorTotal() {
        for (int i = 0; i < tbl_ProdutoAdd.getRowCount(); i++) {

            double valorProd;
            valorProd = (double) tbl_ProdutoAdd.getValueAt(i, 1);
            int valorQtd = (int) tbl_ProdutoAdd.getValueAt(i, 2);

            tbl_ProdutoAdd.setValueAt(valorProd * valorQtd, i, 3);

        }
    }

    public void ValorCompra() {
        double soma = 0, valor;
        int cont = tbl_ProdutoAdd.getRowCount();
        for (int i = 0; i < cont; i++) {
            valor = (double) tbl_ProdutoAdd.getValueAt(i, 3);
            soma = soma + valor;
        }
        txt_valTotal.setText(String.valueOf(soma));
    }

    public void consultarProd() {
        String sqlConsulta = "SELECT * FROM tb_produtos WHERE idtb_produtos =?";
        try {
            pst = conexao.prepareStatement(sqlConsulta);
            pst.setString(1, txt_codigoProd.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                String nome = rs.getString(2);
                cbx_nomeProd.addItem(nome);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_codigoProd = new javax.swing.JTextPane();
        cbx_nomeProd = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_qtdProd = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_Adicionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ProdutoAdd = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_valTotal = new javax.swing.JTextPane();
        btn_salvar = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_valProdD = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Código do produto");

        txt_codigoProd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codigoProdFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txt_codigoProd);

        jScrollPane4.setViewportView(txt_qtdProd);

        jLabel4.setText("Nome do produto");

        jLabel5.setText("Quantidade");

        btn_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/PiHerosGames/Icones/plus.png"))); // NOI18N
        btn_Adicionar.setText("Adicionar");
        btn_Adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TEste(evt);
            }
        });

        tbl_ProdutoAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Prod", "Preço Prod", "Quantidade Prod", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_ProdutoAdd);

        jLabel1.setText("Valor total:");

        jScrollPane3.setViewportView(txt_valTotal);

        btn_salvar.setText("Salvar");

        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(txt_valProdD);

        jLabel2.setText("Valor Produto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_cancelar)
                        .addGap(61, 61, 61)
                        .addComponent(btn_novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(136, 136, 136)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(btn_salvar)))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbx_nomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(btn_Adicionar)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbx_nomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btn_Adicionar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_novo)
                    .addComponent(btn_cancelar))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoProdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codigoProdFocusLost
        consultarProd();
        getValPRod();
    }//GEN-LAST:event_txt_codigoProdFocusLost

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        limparCampos();
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        PaginaInicial principal = new PaginaInicial();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void TEste(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TEste
        getCampos();
        limparCampos();
        ValorTotal();
        ValorCompra();
    }//GEN-LAST:event_TEste

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
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    public javax.swing.JComboBox<String> cbx_nomeProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_ProdutoAdd;
    public javax.swing.JTextPane txt_codigoProd;
    public javax.swing.JTextPane txt_qtdProd;
    private javax.swing.JTextPane txt_valProdD;
    private javax.swing.JTextPane txt_valTotal;
    // End of variables declaration//GEN-END:variables
}
