package BR.com.app.blog.views;

import BR.com.app.blog.connection.Conexao;
import BR.com.app.blog.classes.Section;
import BR.com.app.blog.classes.entities.Admin;
import BR.com.app.blog.classes.entities.User;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private Connection con;
    private Section section;
    protected App screen;

    public Main() {
        initComponents();
        con = Conexao.criarConexao();
        if (con != null) {
            section = new Section();
            System.out.println("Status: conectado...");
        }
    }

    public Section getSection() {
        return section;
    }

    public void setsection(Section section) {
        this.section = section;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createAccountScreen = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        createUserName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        createUserEmail = new javax.swing.JTextField();
        createAccount = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Senha = new javax.swing.JLabel();
        createUserPasswd = new javax.swing.JPasswordField();
        Senha1 = new javax.swing.JLabel();
        createUserRepeatPasswd = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        submitButtonUser = new javax.swing.JButton();
        submitButtonAdmin = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        createAccountScreen.setMinimumSize(new java.awt.Dimension(400, 450));
        createAccountScreen.setResizable(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Criar conta");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nome:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Email:");

        createAccount.setText("Criar conta");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Senha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Senha.setText("Senha:");

        Senha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Senha1.setText("Repita a senha:");

        javax.swing.GroupLayout createAccountScreenLayout = new javax.swing.GroupLayout(createAccountScreen.getContentPane());
        createAccountScreen.getContentPane().setLayout(createAccountScreenLayout);
        createAccountScreenLayout.setHorizontalGroup(
            createAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createAccountScreenLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(createUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(createAccountScreenLayout.createSequentialGroup()
                .addGroup(createAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createAccountScreenLayout.createSequentialGroup()
                        .addGroup(createAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createAccountScreenLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton3))
                            .addGroup(createAccountScreenLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(createAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(createUserPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(createAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(createUserEmail)
                                        .addComponent(createAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                    .addComponent(createUserRepeatPasswd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(createAccountScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(createAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Senha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Senha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        createAccountScreenLayout.setVerticalGroup(
            createAccountScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createAccountScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Senha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createUserPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Senha1)
                .addGap(5, 5, 5)
                .addComponent(createUserRepeatPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createAccount)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        createAccountScreen.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("E-mail:");

        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Senha:");

        txtPassword.setMinimumSize(new java.awt.Dimension(15, 24));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        submitButtonUser.setText("Entrar");
        submitButtonUser.setAlignmentY(0.0F);
        submitButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonUserActionPerformed(evt);
            }
        });

        submitButtonAdmin.setText("Entrar como Admin");
        submitButtonAdmin.setAlignmentY(0.0F);
        submitButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonAdminActionPerformed(evt);
            }
        });

        jButton1.setText("Criar conta");
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitButtonUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitButtonAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(submitButtonUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButtonAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void submitButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonUserActionPerformed
        String email = txtEmail.getText();
        String password = String.valueOf(txtPassword.getPassword());

        if (this.con != null) {
            User user = User.getByLogin(this.con, email, password);

            if (user != null) {
                this.section.setUserLogged(user);
                this.dispose();
                this.screen = new App(con, section);
                this.screen.setVisible(true);
                createAccountScreen.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR AO SERVIDOR");
        }
    }//GEN-LAST:event_submitButtonUserActionPerformed

    private void submitButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonAdminActionPerformed
        String email = txtEmail.getText();
        String password = String.valueOf(txtPassword.getPassword());

        if (this.con != null) {
            Admin admin = Admin.getByLogin(this.con, email, password);

            if (admin != null) {
                this.section.setUserLogged(admin);
                this.dispose();
                this.screen = new App(con, section);
                screen.setVisible(true);
                createAccountScreen.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos ou inexistentes");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR AO SERVIDOR");
        }
    }//GEN-LAST:event_submitButtonAdminActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        createAccountScreen.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        createAccountScreen.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
        String email = createUserEmail.getText();
        String name = createUserName.getText();
        String password = String.valueOf(createUserPasswd.getPassword());
        String confirmPassword = String.valueOf(createUserRepeatPasswd.getPassword());

        if (this.con != null) {
            if(password.equals(confirmPassword)) {
                User newUser = new User(-1, name, email, password);
                if(!newUser.alreadyExists(this.con)) {
                    newUser.insert(this.con);
                    createAccountScreen.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Email ja usado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "As senhas não correspondem");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSÍVEL CONECTAR AO SERVIDOR");
        }
    }//GEN-LAST:event_createAccountActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Senha;
    private javax.swing.JLabel Senha1;
    private javax.swing.JButton createAccount;
    private javax.swing.JFrame createAccountScreen;
    private javax.swing.JTextField createUserEmail;
    private javax.swing.JTextField createUserName;
    private javax.swing.JPasswordField createUserPasswd;
    private javax.swing.JPasswordField createUserRepeatPasswd;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton submitButtonAdmin;
    private javax.swing.JButton submitButtonUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
