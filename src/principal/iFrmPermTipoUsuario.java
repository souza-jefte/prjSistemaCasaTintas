/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import lib.jdb.jdbquery.JDBQuery;
import lib.jdb.jdbupdate.JDBUpdate;

/**
 *
 * @author paulo
 */
public class iFrmPermTipoUsuario extends javax.swing.JInternalFrame {
    private JDBQuery qryTipoUsuario, qryPermTipoUsuario, qryTarefas;
    private JDBUpdate updTransacao;
    private int idPermTipoUsuario;
    private int idTarefa;
    private boolean alteracao;
            
    /**
     * Creates new form FrmPermTipoUsuario
     */
    public iFrmPermTipoUsuario() {
        qryTipoUsuario = new JDBQuery();
        qryPermTipoUsuario = new JDBQuery();
        qryTarefas = new JDBQuery();
        
        JDBQuery[] qry = {qryTipoUsuario, qryPermTipoUsuario, qryTarefas};
        for(JDBQuery q: qry){
            q.setJDBConnection(principal.Principal.conexao.getConexao());
            q.setConcurUpdatable(false);
            q.setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        }
        
        updTransacao = new JDBUpdate();
        updTransacao.setJDBConnection(principal.Principal.conexao.getConexao());
        
        qryTipoUsuario.setSQL("SELECT id, descricao FROM tipos_usuario");
        
        initComponents();
        
        cbxTipoUsuario.setJDBListQuery(qryTipoUsuario);
        cbxTipoUsuario.setKeyListField("id");
        cbxTipoUsuario.setInvisibleFields("id");
        
        tblPermTipoUsuario.setJDBQuery(qryPermTipoUsuario);
        tblPermTipoUsuario.setFieldsTitle("descricao_tarefa", "TAREFA"); 
        tblPermTipoUsuario.setFieldsTitle("acesso_desc", "ACESSO"); 
        tblPermTipoUsuario.setFieldsTitle("gravacao_desc", "GRAVAÇÃO");
        tblPermTipoUsuario.setFieldsTitle("remocao_desc", "REMOÇÃO");
        tblPermTipoUsuario.setFieldsTitle("data_inclusao", "D.INCLUSÃO");
        tblPermTipoUsuario.setFieldsTitle("data_modificacao", "D.MODIFICAÇÃO");
        tblPermTipoUsuario.setInvisibleFields(
                "id id_tipo_usuario descricao_tipo_usuario id_tarefa nome_tarefa "
                        + "acesso gravacao remocao");
        tblPermTipoUsuario.setEditable(false);
        tblPermTipoUsuario.setFieldsWidth("acesso_desc", 10);
        tblPermTipoUsuario.setFieldsWidth("gravacao_desc", 10);
        tblPermTipoUsuario.setFieldsWidth("remocao_desc", 10);
        tblPermTipoUsuario.setFieldsWidth("descricao_tarefa", 180);
        
        // a atualização da qryTipoUsuario está sendo feita no limpar()
//        qryTipoUsuario.execQuery();
        
        limpar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        btnSalvar = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        btnCancelar = new lib.jdb.control.jdbbuttoncancel.JDBButtonCancel();
        btnConsultar = new javax.swing.JButton();
        cbxTipoUsuario = new lib.jdb.control.jdblistcombobox.JDBListComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPermTipoUsuario = new lib.jdb.control.jdbtable.JDBTable();
        chxAcesso = new javax.swing.JCheckBox();
        chxGravacao = new javax.swing.JCheckBox();
        chxRemocao = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtTarefa = new javax.swing.JTextField();
        btnLimparTarefa = new lib.jdb.control.jdbbuttoncancel.JDBButtonCancel();
        jLabel2 = new javax.swing.JLabel();
        btnRemover1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Permissão por tipo de usuário");
        setName(""); // NOI18N

        Painel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSalvar.setMnemonic('s');
        btnSalvar.setFont(principal.FrmLogin.fontePadrao);
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return2.png"))); // NOI18N
        btnCancelar.setMnemonic('l');
        btnCancelar.setFont(principal.FrmLogin.fontePadrao);
        btnCancelar.setText("Limpar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(principal.FrmLogin.fontePadrao);
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/look.png"))); // NOI18N
        btnConsultar.setMnemonic('c');
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        cbxTipoUsuario.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbxTipoUsuarioPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        tblPermTipoUsuario.setToolTipText("Duplo clique para selecionar");
        tblPermTipoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPermTipoUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPermTipoUsuario);

        chxAcesso.setText("Acesso");

        chxGravacao.setText("Gravação");

        chxRemocao.setText("Remoção");

        jLabel1.setText("Tipo de usuário");

        txtTarefa.setEditable(false);

        btnLimparTarefa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return2.png"))); // NOI18N
        btnLimparTarefa.setMnemonic('l');
        btnLimparTarefa.setFont(principal.FrmLogin.fontePadrao);
        btnLimparTarefa.setText("Limpar");
        btnLimparTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTarefaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tarefa");

        btnRemover1.setIcon(new javax.swing.ImageIcon("/home/paulo/NetBeansProjects/prjSistemaCasaTintas/src/icons/delete.png")); // NOI18N
        btnRemover1.setMnemonic('r');
        btnRemover1.setText("Remover");
        btnRemover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover1ActionPerformed1(evt);
            }
        });

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PainelLayout.createSequentialGroup()
                                        .addComponent(cbxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PainelLayout.createSequentialGroup()
                                        .addComponent(txtTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnConsultar)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PainelLayout.createSequentialGroup()
                                        .addComponent(chxAcesso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chxGravacao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chxRemocao)))
                                .addGap(18, 18, 18)
                                .addComponent(btnLimparTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemover1)))
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chxAcesso)
                    .addComponent(chxGravacao)
                    .addComponent(chxRemocao)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void cbxTipoUsuarioPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxTipoUsuarioPopupMenuWillBecomeInvisible
        carregarPermTipoUsuario();
        
        limparCamposPerm();
    }//GEN-LAST:event_cbxTipoUsuarioPopupMenuWillBecomeInvisible

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblPermTipoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPermTipoUsuarioMouseClicked
        if(evt.getClickCount() == 2){
            selecionarPermTipoUsuario();
        }
    }//GEN-LAST:event_tblPermTipoUsuarioMouseClicked

    private void btnLimparTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTarefaActionPerformed
        limparCamposPerm();
    }//GEN-LAST:event_btnLimparTarefaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(FrmLogin.usuario.verificarPermissao(this, 1)){

            if(cbxTipoUsuario.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(this, 
                        "Selecione um tipo de usuário",
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);
                cbxTipoUsuario.requestFocus();
            }else if(idTarefa == 0){
                JOptionPane.showMessageDialog(this, 
                        "Selecione uma tarefa",
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);
                btnConsultar.requestFocus();
            }else{
                if(alteracao){
                    updTransacao.setSQL(String.format(
                            "UPDATE "
                                + "tarefas_tipo_usuario "
                            + "SET "
                                + "id_tipo_usuario='%s',"
                                + "id_tarefa='%s',"
                                + "acesso='%s',"
                                + "gravacao='%s',"
                                + "remocao='%s' "
                            + "WHERE id='%s'",
                            cbxTipoUsuario.getKeyListValue(),
                            idTarefa,
                            chxAcesso.isSelected()?"1":"0",
                            chxGravacao.isSelected()?"1":"0",
                            chxRemocao.isSelected()?"1":"0",
                            idPermTipoUsuario ));
                    updTransacao.execUpdate();   
                    
                    // registro de log
                    FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                            this, String.valueOf(idPermTipoUsuario), 2);
                    
                    cbxTipoUsuario.requestFocus();
                }else{
                    if(!encontrarTarefaDuplicada(idTarefa)){
                        updTransacao.setSQL(String.format(
                                "INSERT INTO tarefas_tipo_usuario("
                                    + "id_tipo_usuario, "
                                    + "id_tarefa, "
                                    + "acesso, "
                                    + "gravacao, "
                                    + "remocao) "
                                + "VALUES ("
                                    + "'%s','%s','%s','%s','%s')",
                                cbxTipoUsuario.getKeyListValue(), 
                                idTarefa,
                                chxAcesso.isSelected()?"1":"0",
                                chxGravacao.isSelected()?"1":"0",
                                chxRemocao.isSelected()?"1":"0"));
                        updTransacao.execUpdate();

                        JDBQuery temp = new JDBQuery();
                        temp.setJDBConnection(principal.Principal.conexao.getConexao());
                        temp.setSQL("SELECT LAST_INSERT_ID()");
                        temp.execQuery();
                        String id = temp.getCurrentFieldValueAsString(1);

                        // registro de log
                        FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                               this, id, 1); 
                    }else{
                        JOptionPane.showMessageDialog(this, 
                                "Este tipo de usuário já tem essa tarefa",
                                "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        btnConsultar.requestFocus();
                        
//                        limparCamposPerm();
                    }
                    btnConsultar.requestFocus();
                }

                limparCamposPerm();

                carregarPermTipoUsuario();
                
                FrmLogin.usuario.atualizarPermissao();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        chxAcesso.requestFocus();
        
        // campos para combobox sendo texto visual e o nome campo do banco referente.
        LinkedHashMap<String, String> combo = new LinkedHashMap<>();
        combo.put("Nome", "descricao");
        
        // titulos para as colunas da tabela, sendo texto visual e nome campo do banco referente.
        LinkedHashMap<String, String> titulo = new LinkedHashMap<>();
        titulo.put("DESCRIÇÃO", "descricao");
        titulo.put("CÓDIGO", "id");

        // campos que deseja deixar invisível, pode-se omitir.
        String[] invisivel = null;

        // tamanho das colunas visíveis, pode-se omitir.
        int[] tamanho = {440, 80};
        
        pesquisa.iFrmPesquisa tarefas;
        tarefas = new pesquisa.iFrmPesquisa(this,
                "Pesquisa de Tarefas",
                principal.Principal.conexao.getConexao(),
                qryTarefas,
                "id",
                combo,
                titulo,
                "SELECT id, descricao FROM tarefas",
                invisivel,
                tamanho);

        
        principal.FrmPrincipal.Desktop.add(tarefas);
        tarefas.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnRemover1ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover1ActionPerformed1
        if(FrmLogin.usuario.verificarPermissao(this, 2)){

            if(alteracao){
                if(sistema.Mensagem.showConfirmDialog(this,
                    "Deseja realmente excluir esta tarefa?", "Confirmação") == 0){

                    String sql = String.format(
                            "DELETE FROM tarefas_tipo_usuario WHERE id = '%s'", 
                            idPermTipoUsuario);

                    updTransacao.setSQL(sql);
                    updTransacao.execUpdate();

                    // registro de log
                    FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                        this, String.valueOf(idPermTipoUsuario), 3);

                    limparCamposPerm();

                    carregarPermTipoUsuario();
                }
            }else{
                JOptionPane.showMessageDialog(this,
                    "Selecione uma tarefa para excluir", "Atenção",
                    JOptionPane.INFORMATION_MESSAGE);

                cbxTipoUsuario.requestFocus();
            }
            
            FrmLogin.usuario.atualizarPermissao();
        }
    }//GEN-LAST:event_btnRemover1ActionPerformed1


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private lib.jdb.control.jdbbuttoncancel.JDBButtonCancel btnCancelar;
    private javax.swing.JButton btnConsultar;
    private lib.jdb.control.jdbbuttoncancel.JDBButtonCancel btnLimparTarefa;
    private javax.swing.JButton btnRemover1;
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnSalvar;
    private lib.jdb.control.jdblistcombobox.JDBListComboBox cbxTipoUsuario;
    private javax.swing.JCheckBox chxAcesso;
    private javax.swing.JCheckBox chxGravacao;
    private javax.swing.JCheckBox chxRemocao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private lib.jdb.control.jdbtable.JDBTable tblPermTipoUsuario;
    private javax.swing.JTextField txtTarefa;
    // End of variables declaration//GEN-END:variables
    
    private void limpar(){
        idPermTipoUsuario = 0;
        
        cbxTipoUsuario.requestFocus();
        
        qryTipoUsuario.execQuery();
        
        cbxTipoUsuario.setSelectedIndex(0);
        
        carregarPermTipoUsuario();
        
        limparCamposPerm();
    }
    
    private void limparCamposPerm(){
        idTarefa = 0;
        
        alteracao = false;
        
        txtTarefa.setText("");
        
        chxAcesso.setSelected(false);
        chxGravacao.setSelected(false);
        chxRemocao.setSelected(false);
    }
    
    private void carregarPermTipoUsuario(){
        qryPermTipoUsuario.setSQL(String.format(
                "SELECT "
                    + "id, "
                    + "id_tipo_usuario, "
                    + "descricao_tipo_usuario, "
                    + "id_tarefa, "
                    + "nome_tarefa, "
                    + "descricao_tarefa, "
                    + "acesso, "
                    + "acesso_desc, "
                    + "gravacao, "
                    + "gravacao_desc, "
                    + "remocao, "
                    + "remocao_desc, "
                    + "data_inclusao, "
                    + "data_modificacao "
                + "FROM vw_tarefas_tipo_usuario "
                + "WHERE id_tipo_usuario = %s "
                + "ORDER BY data_modificacao DESC",
                cbxTipoUsuario.getKeyListValue()));
        qryPermTipoUsuario.execQuery();
    }
    
    private void selecionarPermTipoUsuario(){
        if(cbxTipoUsuario.getSelectedIndex() != 0){
            idPermTipoUsuario = qryPermTipoUsuario.getCurrentFieldValueAsInteger("id");
            idTarefa = qryPermTipoUsuario.getCurrentFieldValueAsInteger("id_tarefa");

            txtTarefa.setText(qryPermTipoUsuario.getCurrentFieldValueAsString("descricao_tarefa"));

            chxAcesso.setSelected(qryPermTipoUsuario.getCurrentFieldValueAsBoolean("acesso"));
            chxGravacao.setSelected(qryPermTipoUsuario.getCurrentFieldValueAsBoolean("gravacao"));
            chxRemocao.setSelected(qryPermTipoUsuario.getCurrentFieldValueAsBoolean("remocao"));

            alteracao = true;
            
            btnSalvar.requestFocus();
        }else{
            JOptionPane.showMessageDialog(this, 
                    "Selecione um tipo de usuário",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            cbxTipoUsuario.requestFocus();
        }
    }
    
    public void atribuirCampos(){
        idTarefa = qryTarefas.getCurrentFieldValueAsInteger("id");
        txtTarefa.setText(qryTarefas.getCurrentFieldValueAsString("descricao"));
    }
    
    public boolean encontrarTarefaDuplicada(int idTarefa){
        boolean verificacao = false;
        
        qryPermTipoUsuario.first();
        if(qryPermTipoUsuario.getRow() == 1){
            do{
                if(qryPermTipoUsuario.getCurrentFieldValueAsInteger("id_tarefa") == 
                        idTarefa){
                    verificacao = true;
                    break;
                }
            }while(qryPermTipoUsuario.next() != -1);

            qryPermTipoUsuario.first();
        }

        return verificacao;
    }
    
}
