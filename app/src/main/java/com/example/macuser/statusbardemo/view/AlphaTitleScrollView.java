package com.example.macuser.statusbardemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by macuser on 16/7/11.
 **/
public class AlphaTitleScrollView extends ScrollView {
    private int mSlop;
    private RelativeLayout toolbar;
    private ImageView headView;
    private OnAlphaTitleScrollChangedListener onAlphaTitleScrollChangedListener;
    private int headviewHight;

    public AlphaTitleScrollView(Context context, AttributeSet attrs,
                                int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public AlphaTitleScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        // TODO Auto-generated constructor stub
    }

    public AlphaTitleScrollView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        // mSlop = ViewConfiguration.get(context).getScaledDoubleTapSlop();
        mSlop = 10;
    }

    /**
     * @param toolbar  头部布局
     * @param headView 标题
     */
    public void setTitleAndHead(RelativeLayout toolbar, ImageView headView) {
        this.toolbar = toolbar;
        this.headView = headView;
    }

    public void setTitleAndHead(RelativeLayout toolbar, int headView) {
        this.toolbar = toolbar;
        this.headviewHight = headView;

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        float headHeight;
        if (headView != null) {
            headHeight = headView.getMeasuredHeight()
                    - toolbar.getMeasuredHeight();
        } else {
            headHeight = headviewHight
                    - toolbar.getMeasuredHeight();
        }

        float alphaPercent = (float) t / headHeight;
        int alpha = (int) (alphaPercent * 255);

        if (alpha >= 255)
            alpha = 255;
        if (alpha <= mSlop)
            alpha = 0;
        toolbar.getBackground().setAlpha(alpha);
        onAlphaTitleScrollChangedListener.onAlphaTitleScroll(alpha, alphaPercent);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public interface OnAlphaTitleScrollChangedListener {
        public void onAlphaTitleScroll(int alpha, float alphaPercent);
    }

    public void setOnAlphaTitleScrollChangedListener(OnAlphaTitleScrollChangedListener listener) {
        this.onAlphaTitleScrollChangedListener = listener;
    }

}