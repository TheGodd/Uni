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
import com.mongodb.MongoClient;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author golde
 */
public class ReportPage extends javax.swing.JFrame {

    /**
     * Creates new form FineHistoryReportPage
     */
    
    public ReportPage() {
        initComponents();
        comboPopulation();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memberName = new javax.swing.JComboBox<>();
        months = new javax.swing.JComboBox<>();
        btnGenerateFineHistoryReport = new javax.swing.JButton();
        btnGenerateLoanHistoryReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        memberName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select A Member" }));

        months.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select A Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        btnGenerateFineHistoryReport.setText("Generate Fine History Report");
        btnGenerateFineHistoryReport.setActionCommand("Generate Fine History Report");
        btnGenerateFineHistoryReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerateFineHistoryReportMouseClicked(evt);
            }
        });

        btnGenerateLoanHistoryReport.setText("Generate Loan History Report");
        btnGenerateLoanHistoryReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerateLoanHistoryReportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerateLoanHistoryReport)
                    .addComponent(btnGenerateFineHistoryReport)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(memberName, 0, 248, Short.MAX_VALUE)
                        .addComponent(months, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(months, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnGenerateFineHistoryReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerateLoanHistoryReport)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateFineHistoryReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateFineHistoryReportMouseClicked

        String month = (String)months.getSelectedItem();
        String memName = (String)memberName.getSelectedItem();
        
        FineHistoryReport generate = new FineHistoryReport();
        try {
            generate.fineHistoryReport(memName, month);
        } catch (IOException ex) {
            Logger.getLogger(ReportPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateFineHistoryReportMouseClicked

    private void btnGenerateLoanHistoryReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateLoanHistoryReportMouseClicked
        String month = (String)months.getSelectedItem();
        String memName = (String)memberName.getSelectedItem();
        
        LoanHistoryReport generate = new LoanHistoryReport();
        try {
            generate.loanHistoryReport(memName, month);
        } catch (IOException ex) {
            Logger.getLogger(ReportPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateLoanHistoryReportMouseClicked

    /**
     * @param args the command line arguments
     */
    
    public void comboPopulation(){
        try{
            MongoClient mongoClient = new MongoClient("192.168.1.11", 27017);
            //defines the ipaddress and the port to be used to connect
            DB db = mongoClient.getDB("Library");
            //selects the database to be used
            DBCollection collection = db.getCollection("Members");
            //chooses the collection to be used
            DBCursor cursor = collection.find(
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
        catch(Exception e){
        System.out.println(e);
        }
    }
    
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
            java.util.logging.Logger.getLogger(ReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateFineHistoryReport;
    private javax.swing.JButton btnGenerateLoanHistoryReport;
    private javax.swing.JComboBox<String> memberName;
    private javax.swing.JComboBox<String> months;
    // End of variables declaration//GEN-END:variables
}
