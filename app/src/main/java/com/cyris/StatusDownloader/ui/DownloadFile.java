package com.cyris.StatusDownloader.ui;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class DownloadFile {



    static public void DownloadFile1(String source, final Context context) throws IOException {
        if(Environment.getExternalStorageDirectory()!=null)
        {

            File destination = new File(Environment.getExternalStorageDirectory()+"/StatusSaver");
            if(!destination.exists())
            {
                destination.mkdir();
            }


            File originalFile = new File(source);
            File currentFileName = new File(destination,originalFile.getName()+".jpeg");
            if(!currentFileName.exists()) {


                FileInputStream stream = new FileInputStream(source);
                FileOutputStream outputStream = new FileOutputStream(currentFileName);
                // InputStreamReader reader = new InputStreamReader(stream);
                FileChannel input = null;
                FileChannel output = null;

                input = stream.getChannel();
                output = outputStream.getChannel();
                output.transferFrom(input, 0, input.size());
                // context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(destination)));
                MediaScannerConnection.scanFile(context, new String[]{currentFileName.getAbsolutePath()}, null, new MediaScannerConnection.MediaScannerConnectionClient() {
                    @Override
                    public void onMediaScannerConnected() {

                    }

                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        Toast.makeText(context, "File Saved", Toast.LENGTH_SHORT).show();
                    }
                });
                Log.i("download", "iamworking2");

                input.close();
                output.close();
            }
            else
            {
                Toast.makeText(context,"File Already Exist",Toast.LENGTH_SHORT).show();
            }

        }

        else
        {

            File destination = new File(Environment.getDataDirectory()+"/StatusSaver");
            if(!destination.exists())
            {
                destination.mkdir();
            }

            File originalFile = new File(source);
            File currentFileName = new File(destination,originalFile.getName()+".jpeg");
            if(!currentFileName.exists()) {
                FileInputStream stream = new FileInputStream(source);
                FileOutputStream outputStream = new FileOutputStream(currentFileName);
                // InputStreamReader reader = new InputStreamReader(stream);
                FileChannel input = null;
                FileChannel output = null;

                input = stream.getChannel();
                output = outputStream.getChannel();
                output.transferFrom(input, 0, input.size());
                // context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(destination)));
                MediaScannerConnection.scanFile(context, new String[]{currentFileName.getAbsolutePath()}, null, new MediaScannerConnection.MediaScannerConnectionClient() {
                    @Override
                    public void onMediaScannerConnected() {

                    }

                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        Toast.makeText(context, "File Saved", Toast.LENGTH_SHORT).show();
                    }
                });
                Log.i("download", "iamworking2");

                input.close();
                output.close();
            }
            else
            {
                Toast.makeText(context,"File Already Exist",Toast.LENGTH_SHORT).show();
            }

        }
    }




    static public void DownloadFile2(String source, final Context context) throws IOException {
        if(Environment.getExternalStorageDirectory()!=null)
        {

            File destination = new File(Environment.getExternalStorageDirectory()+"/StatusSaver");
            if(!destination.exists())
            {
                destination.mkdir();
            }

            File originalFile = new File(source);
            File currentFileName = new File(destination,originalFile.getName()+".mp4");
            if(!currentFileName.exists()) {
                FileInputStream stream = new FileInputStream(source);
                FileOutputStream outputStream = new FileOutputStream(currentFileName);
                // InputStreamReader reader = new InputStreamReader(stream);
                FileChannel input = null;
                FileChannel output = null;

                input = stream.getChannel();
                output = outputStream.getChannel();
                output.transferFrom(input, 0, input.size());
                // context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(destination)));
                MediaScannerConnection.scanFile(context, new String[]{currentFileName.getAbsolutePath()}, null, new MediaScannerConnection.MediaScannerConnectionClient() {
                    @Override
                    public void onMediaScannerConnected() {

                    }

                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        Toast.makeText(context, "File Saved", Toast.LENGTH_SHORT).show();
                    }
                });


                input.close();
                output.close();
            }
            else
            {
                Toast.makeText(context,"File Already Exist",Toast.LENGTH_SHORT).show();
            }



        }

        else
        {

            File destination = new File(Environment.getDataDirectory()+"/StatusSaver");
            if(!destination.exists())
            {
                destination.mkdir();
            }

            File originalFile = new File(source);
            File currentFileName = new File(destination,originalFile.getName()+".mp4");
            if(!currentFileName.exists()) {
                FileInputStream stream = new FileInputStream(source);
                FileOutputStream outputStream = new FileOutputStream(currentFileName);
                // InputStreamReader reader = new InputStreamReader(stream);
                FileChannel input = null;
                FileChannel output = null;

                input = stream.getChannel();
                output = outputStream.getChannel();
                output.transferFrom(input, 0, input.size());
                // context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(destination)));
                MediaScannerConnection.scanFile(context, new String[]{currentFileName.getAbsolutePath()}, null, new MediaScannerConnection.MediaScannerConnectionClient() {
                    @Override
                    public void onMediaScannerConnected() {

                    }

                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        Toast.makeText(context, "File Saved", Toast.LENGTH_SHORT).show();
                    }
                });
                Log.i("download", "iamworking2");

                input.close();
                output.close();
            }
            else
            {
                Toast.makeText(context,"File Already Exist",Toast.LENGTH_SHORT).show();
            }


        }
    }

}
