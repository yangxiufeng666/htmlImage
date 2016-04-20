# htmlImage
有时候我们需要加载一段HTML文本，文本中有<img>标签图片，如商品详情。那么怎么才能更好的显示图片呢，当然是用UIL开源库了，那怎么使用呢。这就是本示例想要展示的

# 方法
textView.setText(Html.fromHtml(text,imageGetter,tagHandler);来加载有img的html文本，
imageGetter需要返回drawable对象，那么可以重写ImageGetter,即可。

# URLImageGetter
```java  
public class URLImageGetter implements Html.ImageGetter{
    private String shopDeString;
    private TextView textView;
    Context context;
    private DisplayImageOptions options;
    public URLImageGetter(String shopDeString,Context context,TextView textView) {
        this.shopDeString = shopDeString;
        this.context = context;
        this.textView = textView;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();
    }
    @Override
    public Drawable getDrawable(String source) {

        final URLDrawable urlDrawable = new URLDrawable();
        ImageLoader.getInstance().loadImage(source,options, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                urlDrawable.bitmap = loadedImage;
                urlDrawable.setBounds(0, 0, loadedImage.getWidth(), loadedImage.getHeight());
                textView.invalidate();
                textView.setText(textView.getText()); // 解决图文重叠
            }
        });
        return urlDrawable;
    }
}
```
![image](https://github.com/babylikebird/htmlImage/blob/master/picture.png)
