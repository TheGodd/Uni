/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_front_end;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

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
    // Generated using JFormDesigner Evaluation license - George Godden
    private void initComponents() {
        btnAddMembers = new JButton();
        addInvoice = new JButton();
        btnAddOrder = new JButton();
        btnAddCatagory = new JButton();
        btnAddBook = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- btnAddMembers ----
        btnAddMembers.setText("Add Members");
        btnAddMembers.setToolTipText("Add Members");
        btnAddMembers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAddMembersMouseClicked(e);
            }
        });

        //---- addInvoice ----
        addInvoice.setText("Add Invoice");
        addInvoice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addInvoiceMouseClicked(e);
            }
        });

        //---- btnAddOrder ----
        btnAddOrder.setText("Add Order");
        btnAddOrder.setActionCommand("");
        btnAddOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAddOrderMouseClicked(e);
            }
        });

        //---- btnAddCatagory ----
        btnAddCatagory.setText("Add Catagory");
        btnAddCatagory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAddCatagoryMouseClicked(e);
            }
        });

        //---- btnAddBook ----
        btnAddBook.setText("Add Book");
        btnAddBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAddBookMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(btnAddBook)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(btnAddMembers)
                                .addComponent(btnAddOrder))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(btnAddCatagory)
                                .addComponent(addInvoice))))
                    .addContainerGap(117, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddMembers)
                        .addComponent(addInvoice))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddOrder)
                        .addComponent(btnAddCatagory))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnAddBook)
                    .addContainerGap(144, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
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
    // Generated using JFormDesigner Evaluation license - George Godden
    private JButton btnAddMembers;
    private JButton addInvoice;
    private JButton btnAddOrder;
    private JButton btnAddCatagory;
    private JButton btnAddBook;
    // End of variables declaration//GEN-END:variables
}
