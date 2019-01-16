package com.tmall.wireless.tangram.example.data;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.tmall.wireless.tangram.structure.viewcreator.ViewHolderCreator;

/*
 *
 */
public class ProductViewHolder extends ViewHolderCreator.ViewHolder {
    RelativeLayout mRelativeLayout;
    public ProductViewHolder(Context context) {
        super(context);
    }

    @Override
    protected void onRootViewCreated(View view) {
        mRelativeLayout = (RelativeLayout) view;
    }
}
