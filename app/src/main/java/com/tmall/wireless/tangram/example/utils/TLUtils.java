package com.tmall.wireless.tangram.example.utils;

import android.content.Context;
import android.content.res.AssetManager;

//import com.libra.expr.compiler.api.ViewCompilerApi;
//import com.tmall.wireless.tangram.example.AssetConfigLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * Author: hongfei
 * Create: 2019/1/15
 */
public class TLUtils {
//    private byte[] compile(Context context, String type, String name, int version) {
//        ViewCompilerApi viewCompiler = new ViewCompilerApi();
//        viewCompiler.setConfigLoader(new AssetConfigLoader(context));
//        InputStream fis = null;
//        try {
//            fis = context.getAssets().open(name);
//            byte[] result = viewCompiler.compile(fis, type, version);
//            return result;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    private JSONObject getJSONDataFromAsset(Context context, String name) {
        try {
            InputStream inputStream = context.getAssets().open(name);
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = inputStreamReader.readLine()) != null) {
                sb.append(str);
            }
            inputStreamReader.close();
            return new JSONObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] getAssertsFile(Context context, String fileName) {
        InputStream inputStream = null;
        AssetManager assetManager = context.getAssets();
        try {
            inputStream = assetManager.open(fileName);
            if (inputStream == null) {
                return null;
            }

            BufferedInputStream bis = null;
            int length;
            try {
                bis = new BufferedInputStream(inputStream);
                length = bis.available();
                byte[] data = new byte[length];
                bis.read(data);

                return data;
            } catch (IOException e) {

            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (Exception e) {

                    }
                }
            }

            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
