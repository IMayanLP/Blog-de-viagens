package BR.com.app.blog.views;

import BR.com.app.blog.classes.Category;
import BR.com.app.blog.classes.Post;
import BR.com.app.blog.classes.Rating;
import BR.com.app.blog.classes.Section;
import BR.com.app.blog.classes.entities.Admin;
import BR.com.app.blog.classes.entities.Entity;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class App extends javax.swing.JFrame {

    private Connection con;
    private Section section;
    private Post selectedPost;

    public App(Connection con, Section section) {
        this.con = con;
        this.section = section;
        this.selectedPost = null;
        initComponents();
        addPanel.setVisible(false);
        learnMorePanel.setVisible(false);
        this.usernameLabel.setText(section.haveUser() ? "Olá, " + section.getUserLogged().getName() : "Guest");
        this.postsTable.setDefaultEditor(Object.class, null);
        this.titlePostField.setEditable(false);
        this.descPostField.setEditable(false);
        resetTableModel();
        fillTable();
        this.learnMoreContent.setLineWrap(true);
        this.learnMoreContent.setEditable(false);
        this.postsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (postsTable.getRowCount() > 0) {
                    selectedPost = Post.getById(con, (int) postsTable.getValueAt(postsTable.getSelectedRow(), 0));
                    if (selectedPost != null) {
                        titlePostField.setText(selectedPost.getTitle());
                        descPostField.setText(selectedPost.getDescription());
                        ratingQuantity.setText(Rating.quanityRating(con, selectedPost.getId(), 1) + " Likes, " + Rating.quanityRating(con, selectedPost.getId(), 0) + " Dislikes");
                    }
                }
            }
        });
    }

    public void fillTable() {
        ArrayList<Post> posts = Post.list(con);
        resetTableModel();
        DefaultTableModel model = (DefaultTableModel) this.postsTable.getModel();
        for (Post p : posts) {
            model.addRow(new Object[]{p.getId(), p.getDate(), p.getTitle(), p.getDescription(), Category.getCategory(con, p.getCategory_id()).getName()});
        }
    }

    public void resetTableModel() {
        this.postsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Data", "Titulo", "Descrição", "Categoria"}
        ) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        this.postsTable.getColumnModel().getColumn(0).setMinWidth(0);
        this.postsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        this.postsTable.getColumnModel().getColumn(1).setMinWidth(100);
        this.postsTable.getColumnModel().getColumn(1).setMaxWidth(100);
        this.postsTable.getColumnModel().getColumn(1).setMaxWidth(100);
    }

    public boolean validateFields(String title, String desc, String content) {
        return ((title.length() > 0 && title.length() < 45)
                && (desc.length() > 0 && desc.length() < 100)
                && (content.length() > 0 && content.length() < 500));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        edit_screen = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        edit_name_input = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        edit_pass_input = new javax.swing.JPasswordField();
        update_user_button = new javax.swing.JButton();
        navBar = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();
        addCategoryButton = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        homePanel = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        postsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        refreshPosts = new javax.swing.JButton();
        titlePostField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descPostField = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        learnMoreButton = new javax.swing.JButton();
        editPostButton = new javax.swing.JButton();
        deletePostButton = new javax.swing.JButton();
        ratingQuantity = new javax.swing.JLabel();
        editPanel = new javax.swing.JPanel();
        content3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        editTitleTextField = new javax.swing.JTextField();
        editDescTextField = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        editContentTextField = new javax.swing.JTextArea();
        submitEditPostButton = new javax.swing.JButton();
        addPanel = new javax.swing.JPanel();
        content2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addTitleTextField = new javax.swing.JTextField();
        addDescTextField = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        addContentTextField = new javax.swing.JTextArea();
        submitPostButton = new javax.swing.JButton();
        learnMorePanel = new javax.swing.JPanel();
        content1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        backToHomeButton = new javax.swing.JButton();
        learnMoreTitle = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        learnMoreContent = new javax.swing.JTextArea();
        learnMoreAuthor = new javax.swing.JLabel();
        dislikeLabel = new javax.swing.JLabel();
        likeLabel = new javax.swing.JLabel();
        rateDesc = new javax.swing.JLabel();

        edit_screen.setMaximumSize(new java.awt.Dimension(370, 320));
        edit_screen.setResizable(false);
        edit_screen.setSize(new java.awt.Dimension(370, 320));

        jLabel11.setText("Nome:");

        edit_name_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_name_inputActionPerformed(evt);
            }
        });

        jLabel12.setText("Senha:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setText("Editar perfil:");

        update_user_button.setText("Atualizar informações");
        update_user_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_user_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel13))
                    .addComponent(update_user_button, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edit_pass_input)
                            .addComponent(edit_name_input, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(edit_name_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(edit_pass_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(update_user_button)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        edit_screen.setVisible(false);

        javax.swing.GroupLayout edit_screenLayout = new javax.swing.GroupLayout(edit_screen.getContentPane());
        edit_screen.getContentPane().setLayout(edit_screenLayout);
        edit_screenLayout.setHorizontalGroup(
            edit_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        edit_screenLayout.setVerticalGroup(
            edit_screenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Publicações");
        setPreferredSize(new java.awt.Dimension(960, 520));
        setResizable(false);
        setSize(new java.awt.Dimension(960, 520));
        getContentPane().setLayout(null);

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add Post");
        addButton.setMaximumSize(new java.awt.Dimension(100, 24));
        addButton.setMinimumSize(new java.awt.Dimension(100, 24));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username");
        usernameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameLabelMouseClicked(evt);
            }
        });

        exitButton.setText("Sair");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        editUserButton.setText("Editar perfil");
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        addCategoryButton.setText("Add Category");
        addCategoryButton.setMaximumSize(new java.awt.Dimension(100, 24));
        addCategoryButton.setMinimumSize(new java.awt.Dimension(100, 24));
        addCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exitButton)
                        .addComponent(usernameLabel)
                        .addComponent(editUserButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(homeButton)
                        .addComponent(addCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        if (this.section.haveUser() && !this.section.isAdmin()) {
            this.addButton.setVisible(false);
        };
        if (this.section.haveUser() && !this.section.isAdmin()) {
            this.addCategoryButton.setVisible(false);
        };

        getContentPane().add(navBar);
        navBar.setBounds(0, 0, 962, 50);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(940, 300));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(940, 300));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(950, 400));

        homePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Home"));
        homePanel.setPreferredSize(new java.awt.Dimension(936, 248));
        homePanel.setLayout(new java.awt.GridLayout(1, 0));

        postsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Titulo", "Descrição", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        postsTable.setRowHeight(35);
        postsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        postsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(postsTable);

        jLabel1.setText("Ações:");

        refreshPosts.setText("Atualizar publicações");
        refreshPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshPostsActionPerformed(evt);
            }
        });

        titlePostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titlePostFieldActionPerformed(evt);
            }
        });

        descPostField.setColumns(20);
        descPostField.setRows(5);
        jScrollPane2.setViewportView(descPostField);
        descPostField.setLineWrap(true);

        jLabel2.setText("Publicação selecionada:");

        jLabel3.setText("Título:");

        jLabel4.setText("Descrição:");

        learnMoreButton.setText("Ler mais...");
        learnMoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                learnMoreButtonActionPerformed(evt);
            }
        });

        editPostButton.setText("Editar");
        editPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPostButtonActionPerformed(evt);
            }
        });

        deletePostButton.setText("Deletar");
        deletePostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePostButtonActionPerformed(evt);
            }
        });

        ratingQuantity.setText("0 Likes, 0 Dislikes");

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addComponent(editPostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deletePostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(learnMoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePostField)
                    .addComponent(refreshPosts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(ratingQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
            .addGroup(contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshPosts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titlePostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ratingQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(learnMoreButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPostButton)
                    .addComponent(deletePostButton)))
        );

        if(this.section.haveUser() && !this.section.isAdmin()){
            editPostButton.setVisible(false);
        }
        if(this.section.haveUser() && !this.section.isAdmin()){
            deletePostButton.setVisible(false);
        }
        if(this.section.haveUser() && !this.section.isAdmin()){
            ratingQuantity.setVisible(false);
        }

        homePanel.add(content);

        editPanel.setPreferredSize(new java.awt.Dimension(950, 300));

        content3.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar publicação"));

        jLabel8.setText("Título (45):");

        jLabel9.setText("Descrição (100):");

        jLabel10.setText("Conteúdo (500):");

        editContentTextField.setColumns(20);
        editContentTextField.setRows(5);
        jScrollPane6.setViewportView(editContentTextField);
        editContentTextField.setLineWrap(true);

        submitEditPostButton.setText("Editar");
        submitEditPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitEditPostButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout content3Layout = new javax.swing.GroupLayout(content3);
        content3.setLayout(content3Layout);
        content3Layout.setHorizontalGroup(
            content3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(content3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editTitleTextField)
                    .addComponent(editDescTextField)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addGroup(content3Layout.createSequentialGroup()
                        .addGroup(content3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(submitEditPostButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        content3Layout.setVerticalGroup(
            content3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editDescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitEditPostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(content3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        addPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Adicionar Publicação"));
        addPanel.setMaximumSize(new java.awt.Dimension(300, 300));
        addPanel.setPreferredSize(new java.awt.Dimension(936, 248));
        addPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setText("Título (45):");

        jLabel7.setText("Descrição (100):");

        jLabel5.setText("Conteúdo (500):");

        addContentTextField.setColumns(20);
        addContentTextField.setRows(5);
        jScrollPane5.setViewportView(addContentTextField);
        addContentTextField.setLineWrap(true);

        submitPostButton.setText("Adicionar Post");
        submitPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPostButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout content2Layout = new javax.swing.GroupLayout(content2);
        content2.setLayout(content2Layout);
        content2Layout.setHorizontalGroup(
            content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addTitleTextField)
                    .addComponent(addDescTextField)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addGroup(content2Layout.createSequentialGroup()
                        .addGroup(content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(submitPostButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        content2Layout.setVerticalGroup(
            content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addDescTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitPostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        addPanel.add(content2);

        learnMorePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes da publicação"));
        learnMorePanel.setLayout(new java.awt.GridLayout(1, 0));

        backToHomeButton.setText("Voltar");
        backToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToHomeButtonActionPerformed(evt);
            }
        });
        jScrollPane3.setViewportView(backToHomeButton);

        learnMoreTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        learnMoreTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        learnMoreTitle.setText("Título");

        learnMoreContent.setColumns(20);
        learnMoreContent.setRows(5);
        jScrollPane4.setViewportView(learnMoreContent);

        learnMoreAuthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        learnMoreAuthor.setText("Autor");

        dislikeLabel.setText("NÃO GOSTEI");
        dislikeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dislikeLabelMouseClicked(evt);
            }
        });

        likeLabel.setText("GOSTEI");
        likeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                likeLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout content1Layout = new javax.swing.GroupLayout(content1);
        content1.setLayout(content1Layout);
        content1Layout.setHorizontalGroup(
            content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(content1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addComponent(learnMoreAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(learnMoreTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content1Layout.createSequentialGroup()
                        .addComponent(rateDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(likeLabel)
                        .addGap(53, 53, 53)
                        .addComponent(dislikeLabel)))
                .addContainerGap())
        );
        content1Layout.setVerticalGroup(
            content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(content1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(learnMoreTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(learnMoreAuthor)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(content1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dislikeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(likeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(rateDesc))
                .addGap(29, 29, 29))
        );

        dislikeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/dislike.png")));

        if (this.section.haveUser() && this.section.isAdmin()) {
            this.dislikeLabel.setVisible(false);
        };
        likeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/like.png")));

        if (this.section.haveUser() && this.section.isAdmin()) {
            this.likeLabel.setVisible(false);
        };

        learnMorePanel.add(content1);

        jLayeredPane1.setLayer(homePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(editPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(addPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(learnMorePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(learnMorePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(addPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(editPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(learnMorePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(addPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        homePanel.getAccessibleContext().setAccessibleName("Editar Post");
        editPanel.setVisible(false);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(6, 50, 940, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.section.close();
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        homePanel.setVisible(false);
        addPanel.setVisible(true);
        editPanel.setVisible(false);
        learnMorePanel.setVisible(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        homePanel.setVisible(true);
        editPanel.setVisible(false);
        addPanel.setVisible(false);
        learnMorePanel.setVisible(false);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void backToHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToHomeButtonActionPerformed
        homePanel.setVisible(true);
        editPanel.setVisible(false);
        addPanel.setVisible(false);
        learnMorePanel.setVisible(false);
    }//GEN-LAST:event_backToHomeButtonActionPerformed

    private void submitPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPostButtonActionPerformed
        String title = addTitleTextField.getText();
        String desc = addDescTextField.getText();
        String content = addContentTextField.getText();
        if (validateFields(title, desc, content)) {
            if (this.section.haveUser() && this.section.isAdmin()) {
                Post newPost;
                newPost = new Post(-1,
                        title,
                        desc,
                        BR.com.app.blog.classes.utils.Utils.getDate(),
                        content,
                        this.section.getUserLogged().getId(),
                        1);
                if (newPost.insert(this.con)) {
                    addTitleTextField.setText("");
                    addDescTextField.setText("");
                    addContentTextField.setText("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Há campos vazios ou que ultrapassam o tamanho máximo\nEspecificado entre parênteses");
        }
    }//GEN-LAST:event_submitPostButtonActionPerformed

    private void editPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPostButtonActionPerformed
        if (selectedPost != null) {
            homePanel.setVisible(false);
            editPanel.setVisible(true);
            editTitleTextField.setText(selectedPost.getTitle());
            editDescTextField.setText(selectedPost.getDescription());
            editContentTextField.setText(selectedPost.getContent());
        }
    }//GEN-LAST:event_editPostButtonActionPerformed

    private void titlePostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titlePostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titlePostFieldActionPerformed

    private void learnMoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_learnMoreButtonActionPerformed
        if (selectedPost != null) {
            homePanel.setVisible(false);
            learnMorePanel.setVisible(true);
            learnMoreTitle.setText(selectedPost.getTitle());
            learnMoreContent.setText(selectedPost.getContent());

            Admin autor = Admin.getById(this.con, selectedPost.getAdmin_id());

            learnMoreAuthor.setText("By " + autor.getName());

            if (!section.isAdmin()) {
                Rating postRate = Rating.getRate(this.con, section.getUserLogged().getId(), selectedPost.getId());

                if (postRate != null) {
                    rateDesc.setText(postRate.getIsLiked() == 1 ? "Marcado como Gostei" : "Marcado como Não Gostei");
                } else {
                    rateDesc.setText("");
                }
            }

        }
    }//GEN-LAST:event_learnMoreButtonActionPerformed

    private void refreshPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshPostsActionPerformed
        fillTable();
    }//GEN-LAST:event_refreshPostsActionPerformed

    private void deletePostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePostButtonActionPerformed
        if (selectedPost != null) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir\nessa publicação permanentemente?", "Aviso", 2);
            if (dialogResult == JOptionPane.YES_OPTION) {
                selectedPost.del(this.con);
                selectedPost = null;

                titlePostField.setText("");
                descPostField.setText("");

                fillTable();
            }
        }
    }//GEN-LAST:event_deletePostButtonActionPerformed

    private void submitEditPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitEditPostButtonActionPerformed
        if (selectedPost != null) {
            String title = editTitleTextField.getText();
            String desc = editDescTextField.getText();
            String content = editContentTextField.getText();
            if (validateFields(title, desc, content)) {
                selectedPost.setTitle(title);
                selectedPost.setDescription(desc);
                selectedPost.setContent(content);
                selectedPost.setDate(BR.com.app.blog.classes.utils.Utils.getDate());
                selectedPost.update(this.con);

                titlePostField.setText(selectedPost.getTitle());
                descPostField.setText(selectedPost.getDescription());

                homePanel.setVisible(true);
                editPanel.setVisible(false);
                addPanel.setVisible(false);
                learnMorePanel.setVisible(false);

                fillTable();
            } else {
                JOptionPane.showMessageDialog(null, "Há campos vazios ou que ultrapassam o tamanho máximo\nEspecificado entre parênteses");
            }
        }
    }//GEN-LAST:event_submitEditPostButtonActionPerformed

    private void likeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_likeLabelMouseClicked
        Rating newRate = new Rating(-1,
                section.getUserLogged().getId(),
                selectedPost.getId(),
                1);

        if (newRate.alreadyRated(this.con)) {
            newRate.del(this.con);
            rateDesc.setText("");
        } else {
            newRate.insert(this.con);
            rateDesc.setText("Marcado como: Gostei");
        }
    }//GEN-LAST:event_likeLabelMouseClicked

    private void dislikeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dislikeLabelMouseClicked
        Rating newRate = new Rating(-1,
                section.getUserLogged().getId(),
                selectedPost.getId(),
                0);

        if (newRate.alreadyRated(this.con)) {
            newRate.del(this.con);
            rateDesc.setText("");
        } else {
            newRate.insert(this.con);
            rateDesc.setText("Marcado como: Não Gostei");
        }
    }//GEN-LAST:event_dislikeLabelMouseClicked

    private void usernameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameLabelMouseClicked

    }//GEN-LAST:event_usernameLabelMouseClicked

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserButtonActionPerformed
        edit_screen.setVisible(true);
    }//GEN-LAST:event_editUserButtonActionPerformed

    private void edit_name_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_name_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_name_inputActionPerformed

    private void update_user_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_user_buttonActionPerformed
        if (this.section.haveUser()) {
            Entity u = this.section.getUserLogged();
            String new_name = edit_name_input.getText();
            String new_psswd = String.valueOf(edit_pass_input.getPassword());
            if(!new_name.equals("")) u.setName(new_name);
            if(!new_psswd.equals("")) u.setPassword(new_psswd);
            
            if(u.update(this.con)) usernameLabel.setText("Olá, " + u.getName());
            edit_screen.setVisible(false);
        }
    }//GEN-LAST:event_update_user_buttonActionPerformed

    private void addCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCategoryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addCategoryButton;
    private javax.swing.JTextArea addContentTextField;
    private javax.swing.JTextField addDescTextField;
    private javax.swing.JPanel addPanel;
    private javax.swing.JTextField addTitleTextField;
    private javax.swing.JButton backToHomeButton;
    private javax.swing.JPanel content;
    private javax.swing.JPanel content1;
    private javax.swing.JPanel content2;
    private javax.swing.JPanel content3;
    private javax.swing.JButton deletePostButton;
    private javax.swing.JTextArea descPostField;
    private javax.swing.JLabel dislikeLabel;
    private javax.swing.JTextArea editContentTextField;
    private javax.swing.JTextField editDescTextField;
    private javax.swing.JPanel editPanel;
    private javax.swing.JButton editPostButton;
    private javax.swing.JTextField editTitleTextField;
    private javax.swing.JButton editUserButton;
    private javax.swing.JTextField edit_name_input;
    private javax.swing.JPasswordField edit_pass_input;
    private javax.swing.JFrame edit_screen;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel learnMoreAuthor;
    private javax.swing.JButton learnMoreButton;
    private javax.swing.JTextArea learnMoreContent;
    private javax.swing.JPanel learnMorePanel;
    private javax.swing.JLabel learnMoreTitle;
    private javax.swing.JLabel likeLabel;
    private javax.swing.JPanel navBar;
    private javax.swing.JTable postsTable;
    private javax.swing.JLabel rateDesc;
    private javax.swing.JLabel ratingQuantity;
    private javax.swing.JButton refreshPosts;
    private javax.swing.JButton submitEditPostButton;
    private javax.swing.JButton submitPostButton;
    private javax.swing.JTextField titlePostField;
    private javax.swing.JButton update_user_button;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
