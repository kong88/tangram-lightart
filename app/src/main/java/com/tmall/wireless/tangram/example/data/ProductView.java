package com.tmall.wireless.tangram.example.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tmall.wireless.tangram.dataparser.concrete.Cell;
import com.tmall.wireless.tangram.example.R;
import com.tmall.wireless.tangram.example.support.SampleScrollSupport;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import com.tmall.wireless.tangram.util.ImageUtils;
import com.tmall.wireless.tangram.util.Utils;

/*
 * Author: hongfei
 * Create: 2019/1/15
 */
public class ProductView extends RelativeLayout implements ITangramViewLifeCycle, SampleScrollSupport.IScrollListener {
    private ImageView mIvIcon;
    private TextView mTvTitle, mTvDesc;
    private BaseCell cell;

    public ProductView(Context context) {
        super(context);
        init();
    }

    public ProductView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProductView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_product_grid, this);
        mIvIcon = findViewById(R.id.iv_icon);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvDesc = findViewById(R.id.tv_desc);
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        Log.i("ProductView", "onScrollStateChanged: ");
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Log.i("ProductView", "onScrolled: ");
    }

    @Override
    public void cellInited(BaseCell cell) {
        setOnClickListener(cell);
        this.cell = cell;
        if (cell.serviceManager != null) {
            SampleScrollSupport scrollSupport = cell.serviceManager.getService(SampleScrollSupport.class);
            scrollSupport.register(this);
        }
    }

    @Override
    public void postBindView(BaseCell cell) {
        int pos = cell.pos;
        String parent = "";
        if (cell.parent != null) {
            parent = cell.parent.getClass().getSimpleName();
        }

        String imgUrl = cell.optStringParam("imgUrl");
        String title = cell.optStringParam("title");
        String desc = cell.optStringParam("desc");

        ImageUtils.doLoadImageUrl(mIvIcon, imgUrl);

        mTvTitle.setText(cell.id + " pos: " + pos + title);
        mTvDesc.setText(desc);
    }

    @Override
    public void postUnBindView(BaseCell cell) {
    }


}
