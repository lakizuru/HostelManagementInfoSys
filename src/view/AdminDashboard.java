package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import model.LoggedUser;
import util.SessionData;
import util.TableFunctions;
/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard(LoggedUser loggedUser) {
        this.setUndecorated(true); //Removing title bar
        this.setResizable(false); //locking the size
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK)); //set custom border
        
        initComponents();
        
        //Setting username to display
        loggedUserLbl.setText("Welcome, " + loggedUser.getUsername() + "!");
        
        //Centralize the window in the display
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        //Generating tables
        TableFunctions.RetrieveToTable(staffTable, "SELECT u.username, u.name, u.phone, s.department FROM user as u, staff as s WHERE u.username = s.username");
        TableFunctions.RetrieveToTable(guestTable, "SELECT u.username, u.name, u.phone, g.room, g.availability FROM user as u, guest as g WHERE u.username = g.username");
        TableFunctions.RetrieveToTable(roomTable, "SELECT * FROM room");
        TableFunctions.RetrieveToTable(noticeTable, "SELECT dateTime, message FROM notice WHERE recipients = '" + SessionData.getLoggedAccountType() + "' ORDER BY dateTime DESC;");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        noticeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        noOfGuests = new javax.swing.JLabel();
        noOfRooms = new javax.swing.JLabel();
        noOfStaff = new javax.swing.JLabel();
        newNotice = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        guestTable = new javax.swing.JTable();
        updateGuestTable = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        addStaff = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();
        viewStaff = new javax.swing.JButton();
        addAdminModer1 = new javax.swing.JButton();
        updateStaffTable = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        newRoomButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        viewRoom = new javax.swing.JButton();
        updateRoomsTable = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        loggedUserLbl = new javax.swing.JLabel();
        minimize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setToolTipText("Home");
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        noticeTable.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        noticeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Notice"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        noticeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(noticeTable);
        if (noticeTable.getColumnModel().getColumnCount() > 0) {
            noticeTable.getColumnModel().getColumn(0).setResizable(false);
            noticeTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            noticeTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GUESTS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ROOMS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("STAFF");

        noOfGuests.setFont(new java.awt.Font("Tahoma", 1, 75)); // NOI18N
        noOfGuests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noOfGuests.setText("0");

        noOfRooms.setFont(new java.awt.Font("Tahoma", 1, 75)); // NOI18N
        noOfRooms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noOfRooms.setText("0");

        noOfStaff.setFont(new java.awt.Font("Tahoma", 1, 75)); // NOI18N
        noOfStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noOfStaff.setText("0");

        newNotice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newNotice.setText("NEW NOTICE");
        newNotice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newNoticeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noOfGuests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noOfRooms, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(133, 133, 133)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noOfStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newNotice)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noOfGuests)
                    .addComponent(noOfRooms)
                    .addComponent(noOfStaff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newNotice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("HOME", jPanel2);

        guestTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        guestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Name", "Phone", "Room#", "Availability"
            }
        ));
        jScrollPane2.setViewportView(guestTable);

        updateGuestTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateGuestTable.setText("UPDATE TABLE");
        updateGuestTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateGuestTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(updateGuestTable)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateGuestTable)
                .addContainerGap())
        );

        jTabbedPane1.addTab("GUESTS", jPanel3);

        addStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addStaff.setText("NEW EMPLOYEE");
        addStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffActionPerformed(evt);
            }
        });

        staffTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Name", "Phone", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        staffTable.setColumnSelectionAllowed(true);
        staffTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(staffTable);
        staffTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        viewStaff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewStaff.setText("VIEW STAFF");
        viewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStaffActionPerformed(evt);
            }
        });

        addAdminModer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addAdminModer1.setText("NEW SYSTEM USER");
        addAdminModer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminModer1ActionPerformed(evt);
            }
        });

        updateStaffTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateStaffTable.setText("UPDATE TABLE");
        updateStaffTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStaffTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(updateStaffTable)
                        .addGap(26, 26, 26)
                        .addComponent(viewStaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(addAdminModer1)
                        .addGap(18, 18, 18)
                        .addComponent(addStaff))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStaff)
                    .addComponent(viewStaff)
                    .addComponent(addAdminModer1)
                    .addComponent(updateStaffTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("STAFF", jPanel4);

        newRoomButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newRoomButton.setText("NEW ROOM");
        newRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRoomButtonActionPerformed(evt);
            }
        });

        roomTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room#", "Rental Fee", "Capasity", "Occupied"
            }
        ));
        jScrollPane3.setViewportView(roomTable);

        viewRoom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewRoom.setText("VIEW ROOM");
        viewRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRoomActionPerformed(evt);
            }
        });

        updateRoomsTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateRoomsTable.setText("UPDATE TABLE");
        updateRoomsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRoomsTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(updateRoomsTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                        .addComponent(viewRoom)
                        .addGap(141, 141, 141)
                        .addComponent(newRoomButton)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newRoomButton)
                        .addComponent(viewRoom))
                    .addComponent(updateRoomsTable))
                .addContainerGap())
        );

        jTabbedPane1.addTab("ROOMS", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        logoutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logoutBtn.setText("LOGOUT");
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnMouseEntered(evt);
            }
        });
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        loggedUserLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        minimize.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        minimize.setText("_");
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loggedUserLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(minimize)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(minimize)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutBtn)
                    .addComponent(loggedUserLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        SessionData.setLoggedUser(null);
        this.dispose();
        new Login().setVisible(true);
        
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        // TODO add your handling code here:
        setState(this.ICONIFIED);
    }//GEN-LAST:event_minimizeActionPerformed

    private void updateRoomsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRoomsTableActionPerformed
        // TODO add your handling code here:
        TableFunctions.ClearTable(roomTable);
        TableFunctions.RetrieveToTable(roomTable, "SELECT * FROM room");
    }//GEN-LAST:event_updateRoomsTableActionPerformed

    private void viewRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewRoomActionPerformed

    private void newRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRoomButtonActionPerformed
        // TODO add your handling code here:
        new AddRoom().setVisible(true);
    }//GEN-LAST:event_newRoomButtonActionPerformed

    private void updateStaffTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStaffTableActionPerformed
        // TODO add your handling code here:
        TableFunctions.ClearTable(staffTable);
        TableFunctions.RetrieveToTable(staffTable, "SELECT u.username, u.name, u.phone, s.department FROM user as u, staff as s WHERE u.username = s.username");
    }//GEN-LAST:event_updateStaffTableActionPerformed

    private void addAdminModer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminModer1ActionPerformed
        // TODO add your handling code here:
        new AddAdminModer().setVisible(true);
    }//GEN-LAST:event_addAdminModer1ActionPerformed

    private void viewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewStaffActionPerformed

    private void addStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffActionPerformed
        // TODO add your handling code here:
        new AddStaff().setVisible(true);
    }//GEN-LAST:event_addStaffActionPerformed

    private void updateGuestTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateGuestTableActionPerformed
        // TODO add your handling code here:
        TableFunctions.ClearTable(guestTable);
        TableFunctions.RetrieveToTable(guestTable, "SELECT u.username, u.name, u.phone, g.room, g.availability FROM user as u, guest as g WHERE u.username = g.username");
    }//GEN-LAST:event_updateGuestTableActionPerformed

    private void newNoticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newNoticeActionPerformed
        // TODO add your handling code here:
        new AddNotice().setVisible(true);
    }//GEN-LAST:event_newNoticeActionPerformed

    private void logoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutBtnMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(LoggedUser loggedUser) {
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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard(loggedUser).setVisible(true);
                
                
            }
        });
        
        
    }
    
    /*    public void generateStaffTable(ArrayList<Staff> staffList){
    DefaultTableModel modelStaff = (DefaultTableModel)staffTable.getModel();
    Object[] row = new Object[4];
    
    for(int i=0; i < staffList.size(); i++){
    row[0] = staffList.get(i).getUsername();
    row[1] = staffList.get(i).getName();
    row[2] = staffList.get(i).getPhone();
    row[3] = staffList.get(i).getDept();
    
    modelStaff.addRow(row);
    }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdminModer1;
    private javax.swing.JButton addStaff;
    private javax.swing.JTable guestTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel loggedUserLbl;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton minimize;
    private javax.swing.JButton newNotice;
    private javax.swing.JButton newRoomButton;
    private javax.swing.JLabel noOfGuests;
    private javax.swing.JLabel noOfRooms;
    private javax.swing.JLabel noOfStaff;
    private javax.swing.JTable noticeTable;
    private javax.swing.JTable roomTable;
    private javax.swing.JTable staffTable;
    private javax.swing.JButton updateGuestTable;
    private javax.swing.JButton updateRoomsTable;
    private javax.swing.JButton updateStaffTable;
    private javax.swing.JButton viewRoom;
    private javax.swing.JButton viewStaff;
    // End of variables declaration//GEN-END:variables
}
