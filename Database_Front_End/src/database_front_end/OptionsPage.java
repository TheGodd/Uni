/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_front_end;

/**
 *
 * @author golde
 */
public class OptionsPage extends javax.swing.JFrame {

    /**
     * Creates new form OptionsPage
     */
    public OptionsPage() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddMembers = new javax.swing.JButton();
        addInvoice = new javax.swing.JButton();
        btnAddOrder = new javax.swing.JButton();
        btnAddCatagory = new javax.swing.JButton();
        btnAddBook = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddMembers.setText("Add Members");
        btnAddMembers.setToolTipText("Add Members");
        btnAddMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMembersMouseClicked(evt);
            }
        });

        addInvoice.setText("Add Invoice");
        addInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addInvoiceMouseClicked(evt);
            }
        });

        btnAddOrder.setText("Add Order");
        btnAddOrder.setActionCommand("");
        btnAddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddOrderMouseClicked(evt);
            }
        });

        btnAddCatagory.setText("Add Catagory");
        btnAddCatagory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddCatagoryMouseClicked(evt);
            }
        });

        btnAddBook.setText("Add Book");
        btnAddBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddBookMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddBook)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddMembers)
                            .addComponent(btnAddOrder))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddCatagory)
                            .addComponent(addInvoice))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMembers)
                    .addComponent(addInvoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddOrder)
                    .addComponent(btnAddCatagory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddBook)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMembersMouseClicked
        AddMemberPage changeForm = new AddMemberPage();
        changeForm.setVisible(true);
        //shows the add member page when the button is pressed
    }//GEN-LAST:event_btnAddMembersMouseClicked

    private void addInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addInvoiceMouseClicked
        AddInvoicePage changeForm = new AddInvoicePage();
        changeForm.setVisible(true);
        //shows the add invoice page when the button is pressed
    }//GEN-LAST:event_addInvoiceMouseClicked

    private void btnAddOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrderMouseClicked
        AddOrderPage changeForm = new AddOrderPage();
        changeForm.setVisible(true);
        //shows the add order page when the button is pressed
    }//GEN-LAST:event_btnAddOrderMouseClicked

    private void btnAddCatagoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddCatagoryMouseClicked
        AddCatagoryPage changeForm = new AddCatagoryPage();
        changeForm.setVisible(true);
        //shows the add catagory page when the button is pressed
    }//GEN-LAST:event_btnAddCatagoryMouseClicked

    private void btnAddBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBookMouseClicked
        AddBookPage changeForm = new AddBookPage();
        changeForm.setVisible(true);
        //shows the add book page when the button is pressed
    }//GEN-LAST:event_btnAddBookMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(OptionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInvoice;
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnAddCatagory;
    private javax.swing.JButton btnAddMembers;
    private javax.swing.JButton btnAddOrder;
    // End of variables declaration//GEN-END:variables
}
