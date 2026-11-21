package helper;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportOpener {

    public static void openReport() {
        try {
            String folderPath = "FinalReports/";

            File oldFile = new File(folderPath + "extent-report.html");

            if (!oldFile.exists()) {
                System.out.println("❌ Report not found!");
                return;
            }

            // timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            // new file name
            File newFile = new File(folderPath + "AutomationReport" + timestamp + ".html");

            // rename
            boolean renamed = oldFile.renameTo(newFile);

            if (renamed) {
                System.out.println("✅ Report renamed");

                Desktop.getDesktop().open(newFile); // open renamed file
            } else {
                System.out.println("⚠ Rename failed, opening default report");

                Desktop.getDesktop().open(oldFile);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}