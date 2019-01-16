package com.tmall.wireless.tangram.example.data;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tmall.wireless.tangram.example.R;
import com.tmall.wireless.tangram.example.support.SampleScrollSupport;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;
import com.tmall.wireless.tangram.util.ImageUtils;

import org.w3c.dom.Text;

/*
 * Author: hongfei
 * Create: 2019/1/16
 */
public class TestView1 extends LinearLayout implements ITangramViewLifeCycle, SampleScrollSupport.IScrollListener {

    ImageView mIvIcon;
    TextView mTvTitle;

    public TestView1(Context context) {
        super(context);
        init();
    }

    public TestView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        inflate(getContext(), R.layout.item_product_grid, this);
        mIvIcon = findViewById(R.id.iv_icon);
        mTvTitle = (TextView) findViewById(R.id.tv_title);

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

    }

    @Override
    public void cellInited(BaseCell cell) {

    }

    @Override
    public void postBindView(BaseCell cell) {
        String url = cell.optStringParam("url");
        String title = cell.optStringParam("title");

        ImageUtils.doLoadImageUrl(mIvIcon, url);
        mTvTitle.setText(title);
    }

    @Override
    public void postUnBindView(BaseCell cell) {

    }
}
