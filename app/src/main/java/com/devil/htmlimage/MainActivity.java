package com.devil.htmlimage;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private DisplayImageOptions options;
    final String sText = "测试图片信息：<img src=\"http://t12.baidu.com/it/u=2627729012,2757221180&fm=32&s=6FF03AD45F22531708D914660300A074&w=800&h=533&img.JPEG\" />";
    final String sText2 = "测试图片信息：<img src=\"http://b.hiphotos.baidu.com/image/pic/item/d788d43f8794a4c274c8110d0bf41bd5ad6e3928.jpg\" />";
    final String sText3 = "测试图片信息：<img src=\"http://www.52ij.com/uploads/allimg/160317/1110104P8-4.jpg\" />";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView)findViewById(R.id.text1);
        textView2 = (TextView)findViewById(R.id.text2);
        textView3 = (TextView)findViewById(R.id.text3);
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
        textView1.setText(Html.fromHtml(sText+sText+sText,new URLImageGetter(sText+sText+sText,MainActivity.this,textView1,options),null));
        textView2.setText(Html.fromHtml(sText2+sText2+sText2,new URLImageGetter(sText2+sText2+sText2,MainActivity.this,textView1,options),null));
        textView3.setText(Html.fromHtml(sText3+sText3+sText3,new URLImageGetter(sText3+sText3+sText3,MainActivity.this,textView1,options),null));
//        textView2.setText(Html.fromHtml(sText2,new URLImageGetter(sText2,MainActivity.this,textView2,options),null));
//        textView3.setText(Html.fromHtml(sText3,new URLImageGetter(sText3,MainActivity.this,textView3,options),null));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
