package com.cyris.StatusDownloader.ui;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

public class GetFile {
    static ArrayList<String> imageSourceList = new ArrayList<>();

   static ArrayList<String> videoSourceList = new ArrayList<>();

   static ArrayList<String> imageVideoSourceList = new ArrayList<>();

    public static ArrayList<String> setImageSource()
    {

            if (Environment.getExternalStorageDirectory() != null) {
                imageSourceList.clear();
                File imageFile = new File(Environment.getExternalStorageDirectory(), "WhatsApp");
                if (imageFile.isDirectory()) {
                    File status = new File(imageFile + "/Media" + "/.Statuses");
                    if (status.isDirectory()) {
                        File[] allData = status.listFiles();
                        if (allData.length > 0) {

                            for (int i = 0; i < allData.length; i++) {
                                if (allData[i].getAbsolutePath().endsWith(".jpg"))
                                    imageSourceList.add(allData[i].getAbsolutePath());

                            }
                        }
                    }
                }
            } else {
                File imageFile = new File(Environment.getDataDirectory(), "WhatsApp");
                if (imageFile.isDirectory()) {
                    File status = new File(imageFile + "/Media" + ".Statuses");
                    if (status.isDirectory()) {
                        File[] allData = status.listFiles();
                        if (allData.length > 0) {
                            for (int i = 0; i < allData.length; i++) {
                                if (allData[i].getAbsolutePath().endsWith(".jpg"))
                                    imageSourceList.add(allData[i].getAbsolutePath());
                            }
                        }
                    }
                }
            }




        return imageSourceList;
    }





   static public ArrayList<String> setVideoSource()
    {



            if (Environment.getExternalStorageDirectory() != null) {
                videoSourceList.clear();
                File imageFile = new File(Environment.getExternalStorageDirectory(), "WhatsApp");
                if (imageFile.isDirectory()) {
                    File status = new File(imageFile + "/Media" + "/.Statuses");
                    if (status.isDirectory()) {
                        File[] allData = status.listFiles();
                        if (allData.length > 0) {

                            for (int i = 0; i < allData.length; i++) {
                                if (allData[i].getAbsolutePath().endsWith(".mp4"))
                                    videoSourceList.add(allData[i].getAbsolutePath());

                            }
                        }
                    }
                }
            } else {
                File imageFile = new File(Environment.getDataDirectory(), "WhatsApp");
                if (imageFile.isDirectory()) {
                    File status = new File(imageFile + "/Media" + ".Statuses");
                    if (status.isDirectory()) {
                        File[] allData = status.listFiles();
                        if (allData.length > 0) {
                            for (int i = 0; i < allData.length; i++) {
                                if (allData[i].getAbsolutePath().endsWith(".mp4"))
                                    videoSourceList.add(allData[i].getAbsolutePath());
                            }
                        }
                    }
                }
            }


        return videoSourceList;
    }






    static public ArrayList<String> setImageVideoSource()
    {


            if (Environment.getExternalStorageDirectory() != null) {
                imageVideoSourceList.clear();
                File imageFile = new File(Environment.getExternalStorageDirectory(), "StatusSaver");
                if (imageFile.isDirectory()) {

                    File[] allData = imageFile.listFiles();
                    if (allData.length > 0) {

                        for (int i = 0; i < allData.length; i++) {
                            if (allData[i].getAbsolutePath().endsWith(".mp4") || allData[i].getAbsolutePath().endsWith(".jpeg"))
                                imageVideoSourceList.add(allData[i].getAbsolutePath());

                        }
                    }

                }
            } else {
                File imageFile = new File(Environment.getDataDirectory(), "StatusSaver");
                if (imageFile.isDirectory()) {

                    File[] allData = imageFile.listFiles();
                    if (allData.length > 0) {

                        for (int i = 0; i < allData.length; i++) {
                            if (allData[i].getAbsolutePath().endsWith(".mp4") || allData[i].getAbsolutePath().endsWith(".jpeg"))
                                imageVideoSourceList.add(allData[i].getAbsolutePath());

                        }
                    }

                }
            }




        return imageVideoSourceList;
    }
}
