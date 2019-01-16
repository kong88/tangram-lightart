package com.tmall.wireless.tangram.example.data;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tmall.wireless.tangram.example.R;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.util.ImageUtils;

/*
 * Author: hongfei
 * Create: 2019/1/16
 */
public class ProductViewHolderCell extends BaseCell<RelativeLayout> {
    @Override
    public void bindView(@NonNull RelativeLayout view) {
        ImageView ivIcon = view.findViewById(R.id.iv_icon);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvDesc = view.findViewById(R.id.tv_desc);


        String imgUrl = optStringParam("imgUrl");
        String title = optStringParam("title");
        String desc = optStringParam("desc");

        tvTitle.setText(title);
        tvDesc.setText(desc);
        ImageUtils.doLoadImageUrl(ivIcon, imgUrl);

    }

    @Override
    public void postBindView(@NonNull RelativeLayout view) {
        super.postBindView(view);
    }

    @Override
    public void unbindView(@NonNull RelativeLayout view) {
        super.unbindView(view);
    }
}
