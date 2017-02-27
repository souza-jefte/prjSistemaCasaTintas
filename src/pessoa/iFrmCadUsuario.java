/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoa;

import javax.swing.JOptionPane;
import lib.jdb.jdbquery.JDBQuery;
import lib.jdb.jdbupdate.JDBUpdate;
import principal.FrmLogin;

/**
 *
 * @author patri
 */
public class iFrmCadUsuario extends javax.swing.JInternalFrame {

    private JDBQuery qryAtribuiUsu, qryTipo, qryFuncionario;
    private boolean alteracao;
    String nomeAltera, sql;
    
    public iFrmCadUsuario() {
                
        alteracao = false;
        
        qryAtribuiUsu = new JDBQuery();
        qryAtribuiUsu.setJDBConnection(principal.Principal.conexao.getConexao());
        qryAtribuiUsu.setLanguage("pt");
        qryAtribuiUsu.setConcurUpdatable(false);
        qryAtribuiUsu.setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        
        qryTipo = new JDBQuery();
        qryTipo.setJDBConnection(principal.Principal.conexao.getConexao());
        qryTipo.setLanguage("pt");
        qryTipo.setSQL("SELECT descricao, id FROM tipos_usuario");
        
        qryFuncionario = new JDBQuery();
        qryFuncionario.setJDBConnection(principal.Principal.conexao.getConexao());
        qryFuncionario.setSQL("SELECT doc_principal, nome FROM pessoas WHERE funcionario = 1");
        
        initComponents();
                
        // executados na função limpa();
//        qryTipo.execQuery();
//        qryFuncionario.execQuery();
//        
//        cbbFunc.setSelectedIndex(0);
//        cbbTipo.setSelectedIndex(0);
        
        limpa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnDados = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        lblSenhaNovamente = new javax.swing.JLabel();
        pswSenhaNovamente = new javax.swing.JPasswordField();
        lblFunc = new javax.swing.JLabel();
        btnSalvar = new lib.jdb.control.jdbbuttonsave.JDBButtonSave();
        btnConsultar = new javax.swing.JButton();
        btnLimpar = new lib.jdb.control.jdbbuttoncancel.JDBButtonCancel();
        cbxAdmin = new lib.jdb.control.jdbcheckbox.JDBCheckBox();
        cbxAtivo = new lib.jdb.control.jdbcheckbox.JDBCheckBox();
        lblTipo = new javax.swing.JLabel();
        pnDatas = new javax.swing.JPanel();
        lblInc = new javax.swing.JLabel();
        txtInc = new lib.jdb.control.jdbtextfield.JDBTextField();
        lblMod = new javax.swing.JLabel();
        txtMod = new lib.jdb.control.jdbtextfield.JDBTextField();
        cbbFunc = new lib.jdb.control.jdblistcombobox.JDBListComboBox();
        cbbTipo = new lib.jdb.control.jdblistcombobox.JDBListComboBox();
        btnRemover = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usuário");

        pnDados.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));

        lblUsuario.setFont(principal.FrmLogin.fontePadrao);
        lblUsuario.setText("Informe seu nome de usuário:");

        txtUsuario.setFont(principal.FrmLogin.fontePadrao);

        lblSenha.setFont(principal.FrmLogin.fontePadrao);
        lblSenha.setText("Informe sua senha:");

        pswSenha.setFont(principal.FrmLogin.fontePadrao);

        lblSenhaNovamente.setFont(principal.FrmLogin.fontePadrao);
        lblSenhaNovamente.setText("Informe novamente a senha:");

        pswSenhaNovamente.setFont(principal.FrmLogin.fontePadrao);

        lblFunc.setFont(principal.FrmLogin.fontePadrao);
        lblFunc.setText("Funcionário:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_add.png"))); // NOI18N
        btnSalvar.setMnemonic('s');
        btnSalvar.setFont(principal.FrmLogin.fontePadrao);
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/return2.png"))); // NOI18N
        btnLimpar.setMnemonic('l');
        btnLimpar.setFont(principal.FrmLogin.fontePadrao);
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        cbxAdmin.setText("Administrador");
        cbxAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAdminActionPerformed(evt);
            }
        });

        cbxAtivo.setSelected(true);
        cbxAtivo.setText("Ativo");

        lblTipo.setFont(principal.FrmLogin.fontePadrao);
        lblTipo.setText("Tipo:");

        pnDatas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)), "Datas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        lblInc.setFont(principal.FrmLogin.fontePadrao);
        lblInc.setText("Inclusão:");

        txtInc.setFocusable(false);

        lblMod.setFont(principal.FrmLogin.fontePadrao);
        lblMod.setText("Modificação:");

        txtMod.setFocusable(false);

        javax.swing.GroupLayout pnDatasLayout = new javax.swing.GroupLayout(pnDatas);
        pnDatas.setLayout(pnDatasLayout);
        pnDatasLayout.setHorizontalGroup(
            pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInc)
                    .addComponent(txtInc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMod)
                    .addComponent(txtMod, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        pnDatasLayout.setVerticalGroup(
            pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInc)
                    .addComponent(lblMod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        cbbFunc.setJDBListQuery(qryFuncionario);
        cbbFunc.setFont(principal.FrmLogin.fontePadrao);
        cbbFunc.setInvisibleFields("doc_principal");
        cbbFunc.setKeyListField("doc_principal");

        cbbTipo.setJDBListQuery(qryTipo);
        cbbTipo.setFont(principal.FrmLogin.fontePadrao);
        cbbTipo.setInvisibleFields("id");
        cbbTipo.setKeyListField("id");

        btnRemover.setFont(principal.FrmLogin.fontePadrao);
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed1(evt);
            }
        });

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSenhaNovamente)
                            .addComponent(lblSenha)
                            .addComponent(lblUsuario)
                            .addComponent(lblFunc)
                            .addComponent(lblTipo)
                            .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbFunc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                            .addComponent(pswSenhaNovamente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addComponent(cbbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemover)))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSenhaNovamente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswSenhaNovamente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFunc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(pnDatas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemover))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        
        // Abre a janela de consulta.
        
        pesquisa.iFrmPesUsuario Usuario = new pesquisa.iFrmPesUsuario(this, qryAtribuiUsu);
        principal.FrmPrincipal.Desktop.add(Usuario);
        Usuario.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(FrmLogin.usuario.verificarPermissao(this, 1)){
            // Realiza as verificações para salvar um novo usuário.
            if(cbxAdmin.isSelected() && !FrmLogin.usuario.isAdmin()){
                JOptionPane.showMessageDialog(this, 
                        "Somente usuários administradores podem gravar um usuário administrador", 
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }else if (txtUsuario.getText().isEmpty()){

                JOptionPane.showMessageDialog(this, "Informe o nome de usuário.", 
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }else if (txtUsuario.getText().length() > 15){

                JOptionPane.showMessageDialog(this, "Nome de usuário deve ter no máximo 15 caracteres.", 
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }else if (pswSenha.getText().isEmpty() && !alteracao){

                JOptionPane.showMessageDialog(this, "Informe uma senha.", 
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }else if (!pswSenha.getText().equals(pswSenhaNovamente.getText()) && !alteracao){

                JOptionPane.showMessageDialog(this, "Campos de senha não são iguais.", 
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }else if (pswSenha.getText().length() > 20 && !alteracao){

                JOptionPane.showMessageDialog(this, "Senha deve ter no máximo 20 caracteres.", 
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }else if (qryFuncionario.getCurrentFieldValueAsString("doc_principal") == null){

                JOptionPane.showMessageDialog(this, "Selecione um funcionário.", 
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }else if (qryTipo.getCurrentFieldValueAsString("id") == null && !cbxAdmin.isSelected()){

                JOptionPane.showMessageDialog(this, "Selecione um tipo.", 
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }else{

                if(alteracao == false){

                    if(sistema.Mensagem.showConfirmDialog(this,
                        "Deseja salvar este usuário?", "Confirmação") == 0){

                        cadUsuario();
                        limpa();

                    }

                }else if (alteracao == true){

                    if(sistema.Mensagem.showConfirmDialog(this,
                        "Deseja realmente alterar este usuário?", "Confirmação") == 0){

                        alteraUsuario();

                    }

                }

            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        // Limpa os campos da janela.
        
        limpa();
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void cbxAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAdminActionPerformed
        
        // Caso o campo administrador sela selecionado, a combobox de tipo será desativada.
        
        if (cbxAdmin.isSelected()){
            cbbTipo.setEnabled(false);
        }else if (!cbxAdmin.isSelected()){
            cbbTipo.setEnabled(true);
        }
    }//GEN-LAST:event_cbxAdminActionPerformed

    private void btnRemoverActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed1
        if(FrmLogin.usuario.verificarPermissao(this, 2)){
            // Remove um usuário já adicionado.

            if (alteracao){

                if(sistema.Mensagem.showConfirmDialog(this,
                            "Deseja realmente remover este usuário?", "Confirmação") == 0){

                        String sql = String.format("DELETE FROM usuarios WHERE nome = '%s'", nomeAltera);

                        if(gravarInf(sql)){
                        
                            // registro de log
                            FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                                    this, nomeAltera, 3);
                        }
                                
                        limpa();

                }

            }else if (!alteracao){

                JOptionPane.showMessageDialog(null, "Selecione um usuário para ser removido.");

            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed1


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private lib.jdb.control.jdbbuttoncancel.JDBButtonCancel btnLimpar;
    private javax.swing.JButton btnRemover;
    private lib.jdb.control.jdbbuttonsave.JDBButtonSave btnSalvar;
    private lib.jdb.control.jdblistcombobox.JDBListComboBox cbbFunc;
    private lib.jdb.control.jdblistcombobox.JDBListComboBox cbbTipo;
    private lib.jdb.control.jdbcheckbox.JDBCheckBox cbxAdmin;
    private lib.jdb.control.jdbcheckbox.JDBCheckBox cbxAtivo;
    private javax.swing.JLabel lblFunc;
    private javax.swing.JLabel lblInc;
    private javax.swing.JLabel lblMod;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaNovamente;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnDatas;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JPasswordField pswSenhaNovamente;
    private lib.jdb.control.jdbtextfield.JDBTextField txtInc;
    private lib.jdb.control.jdbtextfield.JDBTextField txtMod;
    private lib.jdb.control.jdbtextfield.JDBTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    private boolean gravarInf(String sql){ // Grava as informações no banco
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
                        "Usuário já cadastrado", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);
            //1451: Violação de foreign key, contém relacionamento
            }else if(transacao.getErrorCode() == 1451){
                JOptionPane.showMessageDialog(this, 
                        "Usuário com relacionamento, não pode ser excluído", "Atenção", 
                        JOptionPane.INFORMATION_MESSAGE);                
            }
        }
        
        return concluido;
    }
    
    private void cadUsuario(){ // Cadastra um usuário.
        
        String t = "1";
        String f = "0";
        
        int tipo=0;
        String doc;
        
        doc = qryFuncionario.getCurrentFieldValueAsString("doc_principal");
        
        if (cbxAdmin.isSelected()){
            tipo = 0;
        }else if(!cbxAdmin.isSelected()){
            tipo = qryTipo.getCurrentFieldValueAsInteger("id");
        }
        
        String senha = String.valueOf(pswSenha.getPassword());
        senha = sistema.Usuario.criptografarSenha20(senha);
        
        sql = String.format ("INSERT INTO usuarios ("
                    + "nome, "
                    + "senha, "
                    + "doc_principal_funcionario, "
                    + "tipo, "
                    + "administrador, "
                    + "ativo)"
                    + " VALUES ('%s','%s','%s',%s,'%s','%s')",
                    txtUsuario.getText(),
                    senha,
                    doc,
                    tipo == 0 ? "null" : tipo,
                    cbxAdmin.isSelected() ? t : f,
                    cbxAtivo.isSelected() ? t : f);

        if(gravarInf(sql)){
        
            // registro de log
            FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                   this, txtUsuario.getText(), 1); 
        }
        
        limpa();
        
//        alteracao = false;
        
    }
    
    private void alteraUsuario(){ // Altera um usuário.
        
        String t = "1";
        String f = "0";
        
        int tipo = 0;
        String doc;
        
        doc = qryFuncionario.getCurrentFieldValueAsString("doc_principal");
        
        if (cbxAdmin.isSelected()){
            tipo = 1;
        }else if(!cbxAdmin.isSelected()){
            tipo = qryTipo.getCurrentFieldValueAsInteger("id");
        }
        
        if (pswSenha.getText().isEmpty()){
            
            sql = String.format ("UPDATE usuarios "
                    + "SET "
                    + "nome='%s', "
                    + "doc_principal_funcionario='%s', "
                    + "tipo='%s', "
                    + "administrador='%s', "
                    + "ativo='%s' "
                    + "WHERE "
                    + "nome='%s'",
                    txtUsuario.getText(),
                    doc,
                    tipo,
                    cbxAdmin.isSelected() ? t : f,
                    cbxAtivo.isSelected() ? t : f,
                    nomeAltera);

            
        }else if(!pswSenha.getText().isEmpty()){
            
            String senha = String.valueOf(pswSenha.getPassword());
            senha = sistema.Usuario.criptografarSenha20(senha);
            
            sql = String.format ("UPDATE usuarios "
                    + "SET "
                    + "nome='%s', "
                    + "senha='%s', "
                    + "doc_principal_funcionario='%s', "
                    + "tipo='%s', "
                    + "administrador='%s', "
                    + "ativo='%s' "
                    + "WHERE "
                    + "nome='%s'",
                    txtUsuario.getText(),
                    senha,
                    doc,
                    tipo,
                    cbxAdmin.isSelected() ? t : f,
                    cbxAtivo.isSelected() ? t : f,
                    nomeAltera);

        }
        
        if(gravarInf(sql)){
        
            // registro de log
            FrmLogin.log.gravar(FrmLogin.usuario.getNomeUsuario(),
                    this, txtUsuario.getText(), 2);
        }
        
        limpa();
        
//        alteracao = true;
        
    }
    
    public void atribuirCampos(){ // Atribui os campos selecionados na janela de consulta.
        
        String nome, inc, mod;
        boolean admin, ativo;
        
        nome = qryAtribuiUsu.getCurrentFieldValueAsString("nome");
        qryFuncionario.locate("doc_principal", 
                qryAtribuiUsu.getCurrentFieldValueAsString("doc_principal_funcionario"), true);
        if(qryAtribuiUsu.getCurrentFieldValueAsString("tipo") != null){
            qryTipo.locate("id", qryAtribuiUsu.getCurrentFieldValueAsString("tipo"), true);
        }else{
            cbbTipo.setSelectedIndex(0);
        }
        
        admin = qryAtribuiUsu.getCurrentFieldValueAsBoolean("administrador");
        ativo = qryAtribuiUsu.getCurrentFieldValueAsBoolean("ativo");
        inc = qryAtribuiUsu.getCurrentFieldValueAsString("data_inclusao");
        mod = qryAtribuiUsu.getCurrentFieldValueAsString("data_modificacao");
        
        txtUsuario.setText(nome);
        cbxAdmin.setSelected(admin);
        cbxAtivo.setSelected(ativo);
        txtInc.setText(inc);
        txtMod.setText(mod);
        
        alteracao = true;
        
        if (cbxAdmin.isSelected()){
            cbbTipo.setEnabled(false);
        }else if(!cbxAdmin.isSelected()){
            cbbTipo.setEnabled(true);
        }
        
        nomeAltera = nome;
        
    }
    
    private void limpa(){ // Limpa os componentes da janela.
        
        txtUsuario.setText("");
        pswSenha.setText("");
        pswSenhaNovamente.setText("");
        
        qryTipo.execQuery();
        qryFuncionario.execQuery();
        cbbFunc.setSelectedIndex(0);
        cbbTipo.setSelectedIndex(0);
        
        cbxAdmin.setSelected(false);
        cbxAtivo.setSelected(true);
        txtInc.setText("");
        txtMod.setText("");
        
        cbbTipo.setEnabled(true);
        
        alteracao = false;
        
        nomeAltera = "";
        
    }
    
}