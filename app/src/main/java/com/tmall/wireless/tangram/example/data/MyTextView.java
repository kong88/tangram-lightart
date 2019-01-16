package com.tmall.wireless.tangram.example.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tmall.wireless.tangram.example.R;
import com.tmall.wireless.tangram.example.support.SampleScrollSupport;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle;

/*
 * Author: hongfei
 * Create: 2019/1/16
 */
public class MyTextView extends FrameLayout implements ITangramViewLifeCycle, SampleScrollSupport.IScrollListener {
    private TextView textView;
    private BaseCell cell;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_textview, this);
        textView = (TextView) findViewById(R.id.title);
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
        textView.setText(cell.optStringParam("msg"));

        if (cell.style != null) {
            if (cell.style.bgColor > 0) {
               textView.setBackgroundColor(cell.style.bgColor);

            }
        }
    }

    @Override
    public void postUnBindView(BaseCell cell) {
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

    }
}
