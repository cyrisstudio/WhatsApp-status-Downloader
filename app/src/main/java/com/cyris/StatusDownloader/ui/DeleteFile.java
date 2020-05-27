package com.cyris.StatusDownloader.ui;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class DeleteFile {

    static public void DeleteFile1(String source, final Context context) throws IOException {
        if (Environment.getExternalStorageDirectory() != null) {

            File destination = new File(Environment.getExternalStorageDirectory() + "/StatusSaver");
            if (!destination.exists()) {
                destination.mkdir();
            }


            File originalFile = new File(source);
            File currentFileName = new File(destination, originalFile.getName() + ".jpeg");
            if (!currentFileName.exists()) {
                originalFile.delete();
                Toast.makeText(context, "File Deleted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context, "File Not Exist", Toast.LENGTH_SHORT).show();
            }

        }
        else
            {

            File destination = new File(Environment.getDataDirectory() + "/StatusSaver");
            if (!destination.exists()) {
                destination.mkdir();
            }


            File originalFile = new File(source);
            File currentFileName = new File(destination, originalFile.getName() + ".jpeg");
            if (!currentFileName.exists()) {
                currentFileName.delete();
                Toast.makeText(context, "File Deleted", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(context, "File Not Exist", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
