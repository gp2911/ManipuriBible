package com.garamtech.manipuribible.service.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.garamtech.manipuribible.R;
import com.garamtech.manipuribible.service.api.DeviceFileWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by gp on 5/9/15.
 */
public class DeviceFileWriterImpl implements DeviceFileWriter {

    private static String tag = "SDCW";

    /**
     * Copy asset to SDCard
     * @param context Activity object calling this function
     * @param assetName Name of asset to transfer
     * @return absolute path of the asset on device
     */
    @Override
    public String copyAssetToDevice(Context context, String assetName) {

        AssetManager assetManager = context.getResources().getAssets();

        InputStream in = null;
        OutputStream out = null;
        String basepath = null;

        basepath = context.getFilesDir() + "/"
                            + context.getResources().getString(R.string.app_basedir) + "/"
                            + context.getResources().getString(R.string.basepath);
        String fileAbsolutePath = basepath + "/" + assetName ;
        Log.i(tag, "Basepath = " + basepath);
        Log.i(tag, "Absolute Path - "+fileAbsolutePath);

        //create File object for the required asset
        File assetFile = new File(fileAbsolutePath);

        //check if asset file already exists in External Storage
        if(!assetFile.exists()) {

            //first create the base directory
            File basedir = new File(basepath);
            if (!basedir.isDirectory())
                basedir.mkdirs();

            //now, copy the file to external storage
            try {
                in = assetManager.open(assetName);

                out = new FileOutputStream(fileAbsolutePath);

                //buffer of 1MB size
                byte[] buffer = new byte[1048576];
                int read;
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;
                Log.d(tag, "File Copied to Device: " + assetName);
            } catch (Exception e) {
                Log.e(tag, "ERROR: " + e.toString());
            }
        }
        else{
            Log.i(tag, "Asset already exists.");
        }
        return fileAbsolutePath;
    }
}
