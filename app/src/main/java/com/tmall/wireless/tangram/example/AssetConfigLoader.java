//package com.tmall.wireless.tangram.example;
//
//import android.content.Context;
//
//import com.libra.virtualview.compiler.config.ConfigManager;
//
//import java.io.IOException;
//import java.io.InputStream;
//
///*
// * Author: hongfei
// * Create: 2019/1/15
// */
//public class AssetConfigLoader implements ConfigManager.ConfigLoader {
//
//    private Context mContenxt;
//    private static final String CONFIG = "config.properties";
//
//    public AssetConfigLoader(Context context) {
//        mContenxt = context;
//    }
//
//    @Override
//    public InputStream getConfigResource() {
//        try {
//            InputStream inputStream = mContenxt.getAssets().open(CONFIG);
//            return inputStream;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//
