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
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 *
 * @author golde
 */
public class AddOrderPage extends javax.swing.JFrame {

    /**
     * Creates new form AddOrderPage
     */
    public AddOrderPage() {
        initComponents();
        //calls the class that builds the form
        MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
        //defines the ipaddress and port to use to connect
        DB db = mongoClient.getDB("Library");
        //defines the database to use
        DBCollection collection = db.getCollection("Catagories");
        //defines the collection to use
        
        DBCursor cursor = collection.find(
        new BasicDBObject(), new BasicDBObject("Catagory", Boolean.TRUE)
         );
        //uses a cursor to search the collection for all values in the catagory field
        while (cursor.hasNext()) {
            catagories.addItem((String) cursor.next().get("Catagory"));
        }
        //while loop that runs until it has all the values in the catagory field
        collection = db.getCollection("Books");
        //defines the collection to use
        
        cursor = collection.find(
        new BasicDBObject(), new BasicDBObject("BookName", Boolean.TRUE)
         );
        //uses a cursor to search the collection for all values in the catagory field
        while (cursor.hasNext()) {
            bookName.addItem((String) cursor.next().get("BookName"));
        }
        cursor = collection.find(
        new BasicDBObject(), new BasicDBObject("Author", Boolean.TRUE)
         );
        //uses a cursor to search the collection for all values in the catagory field
        while (cursor.hasNext()) {
            author.addItem((String) cursor.next().get("Author"));
        }
        
        collection = db.getCollection("Members");
        //defines the collection to use
        
        cursor = collection.find(
        new BasicDBObject(), new BasicDBObject("FirstName", Boolean.TRUE)
         );
        DBCursor cursor2 = collection.find(
        new BasicDBObject(), new BasicDBObject("SecondName", Boolean.TRUE)
         );
        
        //uses a cursor to search the collection for all values in the catagory field
        while (cursor.hasNext()) {
            memberName.addItem((String) cursor.next().get("FirstName") + " " + cursor2.next().get("SecondName"));
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - George Godden
    private void initComponents() {
        dateTaken = new JTextField();
        dateDue = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        btnAddOrder = new JButton();
        catagories = new JComboBox<>();
        jLabel5 = new JLabel();
        author = new JComboBox<>();
        jLabel6 = new JLabel();
        bookName = new JComboBox<>();
        memberName = new JComboBox<>();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- jLabel1 ----
        jLabel1.setText("Book Name");

        //---- jLabel2 ----
        jLabel2.setText("Member name");

        //---- jLabel3 ----
        jLabel3.setText("Date Taken");

        //---- jLabel4 ----
        jLabel4.setText("Date Due");

        //---- btnAddOrder ----
        btnAddOrder.setText("Add Order");
        btnAddOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAddOrderMouseClicked(e);
            }
        });

        //---- catagories ----
        catagories.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select a catagory"
        }));

        //---- jLabel5 ----
        jLabel5.setText("Catagory");

        //---- author ----
        author.setMaximumRowCount(40);
        author.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select an Author"
        }));
        author.setToolTipText("");

        //---- jLabel6 ----
        jLabel6.setText("Author");

        //---- bookName ----
        bookName.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select a book"
        }));

        //---- memberName ----
        memberName.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select a member"
        }));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(btnAddOrder)
                    .addGap(207, 207, 207))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4))
                            .addGap(14, 14, 14))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jLabel5)
                                .addComponent(jLabel1)
                                .addComponent(jLabel6)
                                .addComponent(jLabel2))))
                    .addGap(3, 3, 3)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(dateTaken, GroupLayout.Alignment.TRAILING)
                        .addComponent(memberName, GroupLayout.Alignment.TRAILING)
                        .addComponent(author)
                        .addComponent(bookName)
                        .addComponent(catagories)
                        .addComponent(dateDue))
                    .addGap(76, 76, 76))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGap(11, 11, 11)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(catagories, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(memberName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(dateTaken, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(dateDue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                    .addComponent(btnAddOrder)
                    .addGap(54, 54, 54))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrderMouseClicked
        String bookname =  (String) bookName.getSelectedItem();
        String auth =  (String) author.getSelectedItem();
        String cat =  (String) catagories.getSelectedItem();
        String memname =  (String) memberName.getSelectedItem();
        String datetaken = dateTaken.getText();
        String datedue = dateDue.getText();
        
        AddOrder addorder = new AddOrder();
        addorder.addOrder(bookname, auth, cat, memname, datetaken, datedue);
        //when the add button is pushed create three strings and use them to pass the values of the textboxes to addmember class
    }//GEN-LAST:event_btnAddOrderMouseClicked

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
            java.util.logging.Logger.getLogger(AddOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrderPage().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - George Godden
    private JTextField dateTaken;
    private JTextField dateDue;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JButton btnAddOrder;
    private JComboBox<String> catagories;
    private JLabel jLabel5;
    private JComboBox<String> author;
    private JLabel jLabel6;
    private JComboBox<String> bookName;
    private JComboBox<String> memberName;
    // End of variables declaration//GEN-END:variables
}
