/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jkan997.slingbeans.dialogs;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import org.jkan997.slingbeans.helper.LogHelper;
import org.jkan997.slingbeans.version.Version;
import org.openide.util.Exceptions;

/**
 *
 * @author jakaniew
 */
public class NewVersionDialog extends javax.swing.JDialog {

    private Version version;

    /**
     * Creates new form NewVersionDialog
     */
    public NewVersionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        versionPanel = new javax.swing.JScrollPane();
        versionTextArea = new javax.swing.JTextArea();
        cancelBtn = new javax.swing.JButton();
        downloadBtn = new javax.swing.JButton();

        jLabel3.setText(org.openide.util.NbBundle.getMessage(NewVersionDialog.class, "NewVersionDialog.jLabel3.text")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        versionLabel.setText(org.openide.util.NbBundle.getMessage(NewVersionDialog.class, "NewVersionDialog.versionLabel.text")); // NOI18N

        versionTextArea.setEditable(false);
        versionTextArea.setColumns(20);
        versionTextArea.setLineWrap(true);
        versionTextArea.setRows(5);
        versionPanel.setViewportView(versionTextArea);

        cancelBtn.setText(org.openide.util.NbBundle.getMessage(NewVersionDialog.class, "NewVersionDialog.cancelBtn.text")); // NOI18N
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        downloadBtn.setText(org.openide.util.NbBundle.getMessage(NewVersionDialog.class, "NewVersionDialog.downloadBtn.text")); // NOI18N
        downloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(versionPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(versionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(versionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(versionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(downloadBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void downloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadBtnActionPerformed
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(version.getDownload()+"?nocache="+System.currentTimeMillis()));
        } catch (Exception ex) {
            LogHelper.logError(ex);
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_downloadBtnActionPerformed

    public void setVersion(Version version) {
        this.version = version;
        StringBuilder msgSb = new StringBuilder();
        msgSb.append("Version:" + version.getId() + "\n");
        msgSb.append("Released:" + version.getReleased() + "\n");
        msgSb.append("\nChanges:\n" + version.getChanges() + "\n");
        msgSb.append("\nDownload URL:\n" + version.getDownload() + "\n");
        this.versionTextArea.setText(msgSb.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton downloadBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel versionLabel;
    private javax.swing.JScrollPane versionPanel;
    private javax.swing.JTextArea versionTextArea;
    // End of variables declaration//GEN-END:variables
}
