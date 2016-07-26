# StatusBarDemo
## 仿网易云音乐个人中心
* 状态栏透明。
* 状态栏+标题栏 背景颜色随手指滑动渐变。
* 展示个人信息的viewpager切换时，背景渐变。
* 题外话，gilde加载图片各种应用。

### 渐变效果控制
```java
activityPersonalAlphaScroll.setOnAlphaTitleScrollChangedListener(new AlphaTitleScrollView.OnAlphaTitleScrollChangedListener() {
            @Override
            public void onAlphaTitleScroll(int alpha, float alphaPercent) {
                 //...
            }
        });
```

### 注意问题
* 用onMeasure计算自身高度的listview，子布局里不能用RelativeLayout。 
这里以后可以考虑用recycleview;

## 相关博客，资料以及依赖项目
* [AlphaTitleScrollView](http://blog.csdn.net/u013000152/article/details/51622587)
* [StatusBarCompat](http://blog.csdn.net/jdsjlzx/article/details/41643587)
* [butterknife](https://github.com/JakeWharton/butterknife) 
* [fresco](https://github.com/facebook/fresco) 
* [glide](https://github.com/bumptech/glide) 

