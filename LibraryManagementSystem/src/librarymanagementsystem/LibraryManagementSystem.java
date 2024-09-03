package librarymanagementsystem;
/**
 *
 * @author walter
 */
public class LibraryManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set the Nimbus look and feel (optional)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display the MainDashboard form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view.MainDashboard().setVisible(true);
            }
        });
    }
}
