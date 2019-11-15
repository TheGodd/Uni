/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_front_end;

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
        DBCollection collection = db.getCollection("Books");
        //defines the collection to use
        
        DBCursor cursor = collection.find(
        new BasicDBObject(), new BasicDBObject("Catagory", Boolean.TRUE)
         );
        //uses a cursor to search the collection for all values in the catagory field
        while (cursor.hasNext()) {
            catagories.addItem((String) cursor.next().get("Catagory"));
        }
        //while loop that runs until it has all the values in the catagory field
        
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
    private void initComponents() {

        dateTaken = new javax.swing.JTextField();
        dateDue = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddOrder = new javax.swing.JButton();
        catagories = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        author = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        bookName = new javax.swing.JComboBox<>();
        memberName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Book Name");

        jLabel2.setText("Member name");

        jLabel3.setText("Date Taken");

        jLabel4.setText("Date Due");

        btnAddOrder.setText("Add Order");
        btnAddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddOrderMouseClicked(evt);
            }
        });

        catagories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a catagory" }));

        jLabel5.setText("Catagory");

        author.setMaximumRowCount(40);
        author.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Author" }));
        author.setToolTipText("");

        jLabel6.setText("Author");

        bookName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a book" }));

        memberName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a member" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnAddOrder)
                .addGap(207, 207, 207))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14))
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTaken)
                            .addComponent(dateDue)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(author, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bookName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(catagories, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(memberName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catagories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateTaken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnAddOrder)
                .addGap(54, 54, 54))
        );

        pack();
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
    private javax.swing.JComboBox<String> author;
    private javax.swing.JComboBox<String> bookName;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JComboBox<String> catagories;
    private javax.swing.JTextField dateDue;
    private javax.swing.JTextField dateTaken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> memberName;
    // End of variables declaration//GEN-END:variables
}
