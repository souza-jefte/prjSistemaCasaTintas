/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import javax.swing.JOptionPane;
import lib.jdb.jdbquery.JDBQuery;
import lib.jdb.jdbupdate.JDBUpdate;
import principal.FrmLogin;

/**
 *
 * @author paulo
 */
public class iFrmCancelarVenda extends javax.swing.JInternalFrame {
    private JDBQuery qry;
    private int idVenda, idContaReceber;

    /**
     * Creates new form iFrmCancelarVenda
     */
    public iFrmCancelarVenda() {
        
        qry = new JDBQuery();
        qry.setJDBConnection(principal.Principal.conexao.getConexao());
        qry.setConcurUpdatable(false);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cancelamento de venda");

        btnCancelar.setText("Efetuar Cancelamento");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Código da venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(FrmLogin.usuario.verificarPermissao(this, "iFrmVendas", 2)){

            if(!txtCodigo.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(this, 
                        "Código da venda deve conter somente números",
                        "Atenção",
                        JOptionPane.INFORMATION_MESSAGE);
                txtCodigo.requestFocus();
            }else{
                if(sistema.Mensagem.showConfirmDialog(this, 
                        "Deseja realmente cancelar a venda " + txtCodigo.getText() + 
                        "\nO cancelamento da venda excluirá as contas a receber, \n"
                        + "cheques ou cartões e lançamentos de caixa \n"
                        + "vinculados a esta venda.",
                        "Confirmação") == 0){
                    
                    qry.setSQL("SELECT id, cancelada FROM vendas WHERE id = " + txtCodigo.getText());
                    qry.execQuery();
                    idVenda = qry.getCurrentFieldValueAsInteger("id");

                    qry.first();
                    // se o código de venda existe
                    if(qry.getRow() == 1){
                        if(qry.getCurrentFieldValueAsBoolean("cancelada")){
                            JOptionPane.showMessageDialog(this, 
                                    "Código referente a venda já cancelada",
                                    "Atenção",
                                    JOptionPane.INFORMATION_MESSAGE);
                            txtCodigo.requestFocus();
                        }else{

                            //capturando o id do conta receber da venda
                            qry.setSQL("SELECT id FROM contas_receber WHERE id_venda = " + idVenda);
                            qry.execQuery();
                            idContaReceber = qry.getCurrentFieldValueAsInteger("id");

                            //capturando idCaixa ref. caixa aberto hoje, se existir
                            qry.setSQL(String.format(
                                    "SELECT itens_caixa.id_caixa "
                                    + "FROM lancamentos_conta_receber "
                                    + "INNER JOIN itens_caixa "
                                        + "ON lancamentos_conta_receber.id_item_caixa = itens_caixa.id "
                                    + "WHERE CAST(itens_caixa.data as DATE) = CAST(NOW() as DATE) "
                                        + "AND id_conta_receber = %s", idContaReceber));
                            qry.execQuery();

                            int idCaixa;
                            qry.first();
                            do{
                                if(qry.getCurrentFieldValueAsInteger("id_caixa") != null){
                                    idCaixa = qry.getCurrentFieldValueAsInteger("id_caixa");

                                    break;
                                }else{
                                    idCaixa = 0;
                                }
                            }while(qry.next() != -1);

                            // se foi encontrado idCaixa(em lançamento no caixa em dh, ch ou cartão)
                            if(idCaixa != 0){

                                System.out.println("cancelamento de venda em dh, ch, ct");

                                cancelar_venda();

                            // senão, o lançamento pode ser crediário, sem entrada no caixa, 
                            // ou não existir
                            }else{
                                // verificando se a venda é de hoje
                                qry.setSQL(
                                        "SELECT id "
                                        + "FROM vendas "
                                        + "WHERE CAST(vendas.data AS DATE) = CAST(NOW() AS DATE) AND "
                                        + "id = " + idVenda);
                                qry.execQuery();

                                qry.first();
                                if(qry.getRow() == 1){

                                    System.out.println("cancelamento de venda em crediário");

                                    cancelar_venda();

                                }else{
                                    JOptionPane.showMessageDialog(this, 
                                            "Código referente a venda com data diferente ao dia corrente\n"
                                            + "NÃO pode ser cancelada!",
                                            "Atenção",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, 
                            "Código da venda não existe",
                            "Atenção",
                            JOptionPane.INFORMATION_MESSAGE);
                        txtCodigo.requestFocus();
                    } 
                }
            }
        }
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables

    private boolean enviarTransacao(String sql){
        JDBUpdate transacao = new JDBUpdate();
        transacao.setJDBConnection(principal.Principal.conexao.getConexao());

        transacao.setSQL(sql);
        transacao.setShowMessageOnError(false);
        
        boolean concluido = transacao.execUpdate();
        // Se a transação retornar erro:
        if(!concluido){
            //1062: Violação de primary key ou unique
            if(transacao.getErrorCode() == 1062){
                JOptionPane.showMessageDialog(this, 
                        "Registro já cadastrado", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
            //1451: Violação de foreign key, contém relacionamento
            }else if(transacao.getErrorCode() == 1451){
                JOptionPane.showMessageDialog(this, 
                        "Registro com relacionamento, não pode ser excluído", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);                
            }
        }
        
        return concluido;
    }
    
    private void cancelar_venda(){
        principal.Principal.conexao.abrirTransacoes();
        
        String sql;
        // marcando venda como cancelada
        sql = "UPDATE vendas SET vendas.cancelada=1 WHERE vendas.id = " + idVenda;
        enviarTransacao(sql);
        
        qry.setSQL(
                "SELECT itens_vendas.id_produto, itens_vendas.quantidade "
                + "FROM itens_vendas WHERE id_venda = " + idVenda);
        qry.execQuery();
        
        // retornando o estoque dos produtos da venda informada
        qry.first();
        do{
            sql = String.format(
                    "UPDATE produtos "
                    + "SET produtos.estoque=(produtos.estoque + %s) "
                    + "WHERE produtos.id = %s", 
                    qry.getCurrentFieldValueAsDouble("quantidade"),
                    qry.getCurrentFieldValueAsInteger("id_produto"));
            enviarTransacao(sql);
        }while(qry.next() != -1);
        
        
        // apagando entradas no itens_caixa, se existir.
        qry.setSQL(
                "SELECT id_item_caixa "
                + "FROM lancamentos_conta_receber "
                + "WHERE id_conta_receber = " + idContaReceber);
        qry.execQuery();
        
        qry.first();
        if(qry.getRow() == 1){
            do{
                sql = "DELETE FROM itens_caixa WHERE id = " + 
                        qry.getCurrentFieldValueAsInteger("id_item_caixa");
                enviarTransacao(sql);
            }while(qry.next() != -1);
        }
        
        // deletando o contas a receber referente a venda e
        // consequentemente apagando os registros vinculados por FK:
        // lancamentos conta receber, controle ch ct, lancamentos controle ch ct.
        sql = "DELETE FROM contas_receber "
                + "WHERE contas_receber.id_venda = " + idVenda;
        enviarTransacao(sql);
        
        JOptionPane.showMessageDialog(this, 
                        "Venda cancelada com sucesso", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
        
        // registro de log
        FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                    "iFrmVendas", String.valueOf(idVenda), "cancelado venda");
        
        principal.Principal.conexao.fecharTransacoes();
        
        txtCodigo.setText("");
    }

}