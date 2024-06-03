package projectkelompok3;

import com.stripbandunk.jwidget.JPagination;
import com.stripbandunk.jwidget.model.DefaultPaginationModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;


public class PegawaiView extends javax.swing.JFrame {
    int baris, kol;
    String order;
    String ascdes;
    private DefaultPaginationModel paginationModel;
    private DefaultTableModel tb= new DefaultTableModel();
    
    public PegawaiView() {
        initComponents();
        tb.addColumn("ID");
        tb.addColumn("NIP");
        tb.addColumn("Nama");
        tb.addColumn("Tempat");
        tb.addColumn("Lahir");
        tb.addColumn("Sex");
        tb.addColumn("Agama");
        tb.addColumn("HP");
        tb.addColumn("Jabatan");
        tb.addColumn("Alamat");
        tb.addColumn("Kota");
        tb.addColumn("Aktif");
        tb.addColumn("Status");
        tb.addColumn("Email");
        tbData.setModel(tb); 
        ascdes=" ASC";
        
        cbkol.removeAllItems();
        cbkol.addItem("ID");
        cbkol.addItem("NIP");
        cbkol.addItem("Nama");
        cbkol.addItem("Tempat");
        cbkol.addItem("Lahir");
        cbkol.addItem("Sex");
        cbkol.addItem("Agama");
        cbkol.addItem("Hp");
        cbkol.addItem("alamat");
        cbkol.addItem("Jabatan");
        cbkol.addItem("Kota");
        cbkol.addItem("Aktif");
        cbkol.addItem("Status");
        cbkol.addItem("Email");
        
        
        inputPage.removeAllItems();
        inputPage.addItem("10");
        inputPage.addItem("20");
        inputPage.addItem("50");
        inputPage.addItem("70");
        inputPage.addItem("100");
        
        tbData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumnModel columnModel = tbData.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30); // ID
        columnModel.getColumn(1).setPreferredWidth(70); // NIP
        columnModel.getColumn(2).setPreferredWidth(140); // NAMA
        columnModel.getColumn(3).setPreferredWidth(90); // TEMPAT
        columnModel.getColumn(4).setPreferredWidth(120); // LAHIR
        columnModel.getColumn(5).setPreferredWidth(40); // SEX
        columnModel.getColumn(6).setPreferredWidth(90); // AGAMA
        columnModel.getColumn(7).setPreferredWidth(110); // HP
        columnModel.getColumn(8).setPreferredWidth(130); // JABATAN
        columnModel.getColumn(9).setPreferredWidth(150); // ALAMAT
        columnModel.getColumn(10).setPreferredWidth(110); // KOTA
        columnModel.getColumn(11).setPreferredWidth(50); // AKTIF
        columnModel.getColumn(12).setPreferredWidth(70); // STATUS
        columnModel.getColumn(13).setPreferredWidth(180); // EMAIL

        try {
            IsiTabel();           
        } catch (SQLException ex) {
            System.out.println("gagal");
        }
    }
    
    
    // Method to Fill Table Data
    private void IsiTabel() throws SQLException {
        String tampil = (String)inputPage.getSelectedItem();
        String f = (String)cbkol.getSelectedItem();
        order = " ORDER BY " + f + ascdes;
        Global.sql = "SELECT * FROM r_pegawai WHERE id <> ''";
        kosongTabel();
        String cari = inputSearch.getText();
        String sql = Global.sql;
        if (!cari.isEmpty()) {
            // Hanya mencari di kolom yang dipilih dan dengan nilai yang sama persis
            sql = sql + " AND " + f + " = '" + cari + "'";
        }

        Global.sql = sql + order;
        System.out.println(sql);
        paginationModel = new DefaultPaginationModel();
        paginationModel.setTotalItem(Global.JmlRec(Global.sql));

        // Retrieve selected value from JComboBox
        int n = Integer.parseInt((String) inputPage.getSelectedItem());
        paginationModel.setPageSize(n);
        Halaman.setModel(paginationModel);

        Pegawai.bacaData(tb, Global.sql + " LIMIT " + n);
    }



    private void kosongTabel() {
        baris = tb.getRowCount();
        for (int i = 0; i < baris; i++) {
            tb.removeRow(0);
        }
    }
    
    private void halamanOnPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {
        int limit = (evt.getCurrentPage() - 1) * evt.getPageSize();
        String sql = "SELECT * FROM r_pegawai LIMIT " + limit + ", " + evt.getPageSize();
        System.out.println(sql);
        try {
            kosongTabel();
            Pegawai.bacaData(tb, sql);
        } catch (Exception e) {
        }
    }
    
    private void deleteData(String id) {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "DELETE FROM r_pegawai WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, id);
                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    // Perbarui tampilan tabel setelah penghapusan
                    IsiTabel();
                } else {
                    JOptionPane.showMessageDialog(null, "ID tidak ditemukan untuk dihapus");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        Halaman = new com.stripbandunk.jwidget.JPagination();
        jLabel2 = new javax.swing.JLabel();
        inputSearch = new javax.swing.JTextField();
        btnLimitView = new javax.swing.JButton();
        cbkol = new javax.swing.JComboBox<>();
        btnasc = new javax.swing.JButton();
        btndesc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputPage = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbData.setAutoCreateRowSorter(true);
        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbData.setName("tbData"); // NOI18N
        tbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbData);

        btnSearch.setText("Cari");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        Halaman.addPaginationListener(new com.stripbandunk.jwidget.listener.PaginationListener() {
            public void onPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {
                HalamanOnPageChange(evt);
            }
        });

        jLabel2.setText("Tampil");

        btnLimitView.setText("OK");
        btnLimitView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimitViewActionPerformed(evt);
            }
        });

        cbkol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbkol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkolActionPerformed(evt);
            }
        });

        btnasc.setText("Asc");
        btnasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnascActionPerformed(evt);
            }
        });

        btndesc.setText("Desc");
        btndesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndescActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Aplikasi Implementasi OOP");

        inputPage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 717, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(370, 370, 370))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Halaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(407, 407, 407))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDelete))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnLimitView, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbkol, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnasc, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(btndesc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(btnLimitView)
                        .addComponent(inputPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbkol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnasc)
                        .addComponent(btndesc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnEdit)
                        .addComponent(btnDelete))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch)
                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Halaman, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new PegawaiAdd().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnLimitViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimitViewActionPerformed
        try {
            IsiTabel();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnLimitViewActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            IsiTabel();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (Global.id != null && !Global.id.isEmpty()) {
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            deleteData(Global.id);
        }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a record to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataMouseClicked
        int selectedRow = tbData.getSelectedRow();
        if (selectedRow != -1) {
            Global.id = tbData.getValueAt(selectedRow, 0).toString();
            JOptionPane.showMessageDialog(null, "Selected No Reg " + Global.id);
        }
    }//GEN-LAST:event_tbDataMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        new PegawaiEdit().setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void HalamanOnPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) {//GEN-FIRST:event_HalamanOnPageChange
        halamanOnPageChange(evt);
    }//GEN-LAST:event_HalamanOnPageChange

    private void btndescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndescActionPerformed
        // TODO add your handling code here:
        ascdes = " DESC";
        try {
            IsiTabel();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btndescActionPerformed

<<<<<<< HEAD
    private void btnascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnascActionPerformed

        ascdes = "ASC";
        try { 
            // Memanggil method IsiTabel untuk mengisi tabel dengan urutan ascending
            IsiTabel();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
=======
    private void cbkolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkolActionPerformed

    private void btnascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnascActionPerformed
        ascdes = " ASC";
        try {
            IsiTabel();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }                
>>>>>>> 8e9e2691b8ccfad297904df59973a4d7ca1467a5
    }//GEN-LAST:event_btnascActionPerformed

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
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PegawaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PegawaiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.stripbandunk.jwidget.JPagination Halaman;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLimitView;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnasc;
    private javax.swing.JButton btndesc;
    private javax.swing.JComboBox<String> cbkol;
    private javax.swing.JComboBox<String> inputPage;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbData;
    // End of variables declaration//GEN-END:variables
}
