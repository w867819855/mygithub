package cn.ifavor.cycleviewpager;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import cn.ifavor.cycleviewpager.view.CycleViewPager;
import cn.ifavor.cycleviewpager.view.CycleViewPager.ImageCycleViewListener;
import cn.ifavor.cycleviewpager.view.CycleViewPager.IndicatorDirection;


public class MainActivity extends Activity {

    private CycleViewPager mCycleViewPager;;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

	private void init() {
		mCycleViewPager = (CycleViewPager) findViewById(R.id.cvp_main);
		
	//	Map<String, Integer> map = new TreeMap<String, Integer>();
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("1", R.drawable.a);
		map.put("2", R.drawable.b);
		map.put("3", R.drawable.c);
		map.put("4", R.drawable.d);
		//map.put("5", R.drawable.e);
		mCycleViewPager.setResIdMap(map,imcls);
		
		
	
		
		/***	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("我是标题 1", "http://www.soomal.com/images/doc/20150707/00052886_01.jpg");
		map.put("我是标题 2", "http://img.ithome.com/newsuploadfiles/2013/10/20131026_202938_747.jpg");
		map.put("我是标题 3", "http://images.cnitblog.com/blog/608747/201501/151335444483480.png");
		map.put("我是标题 4", "http://58pic.ooopic.com/58pic/16/80/58/42958PICxXV.jpg");
		map.put("我是标题 5", "http://n1.itc.cn/img8/wb/smccloud/recom/2015/11/04/144658670871459798.PNG");
		map.put("我是标题 6", "http://img.zcool.cn/community/01a782554558ed0000019ae9e89713.jpg");
		map.put("我是标题 7", "http://www.myexception.cn/img/2013/10/19/111719132.jpg");
		map.put("我是标题 8", "http://pic.58pic.com/58pic/17/41/96/81n58PICS2x_1024.jpg");
		mCycleViewPager.setURLMap(map).setDuration(3000);
		mCycleViewPager.start();
		
		**/
		
	//	mCycleViewPager.setBottomBackgroundColor(Color.rgb(11, 12, 12));
//		setBottomBackgroundColor //设置底部背景颜色
//		setIndicatorRadius 设置指示器的圆角值
//		setUnSelectedColor 设置指示器未选中的颜色
//		setSelectedColor 设置指示器选中的颜色
//		setDuration 设置轮播器执行时间间隔
//		setIndicatorDirection 设置指示器显示位置
//		setIndicatorPointSize 设置指示器点的尺寸
//		setIndicatorPointMargin 设置指示器间隔距离
//		setShowTitle 设置是否显示标题
//		setTitleTextSize 设置标题字体大小
//		setTitleTextColor 设置标题字体颜色
//		setHandler 设置 handler
		/***/
	

	
		
	}
	
	 private ImageCycleViewListener imcls=new ImageCycleViewListener(){

		@Override
		public void onImageClick(int postion, View imageView) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "click>"+postion, Toast.LENGTH_SHORT).show();
			startActivity(new Intent(MainActivity.this,Webmycl.class));
		}
		 
	 };
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mCycleViewPager != null){
			// 取消轮播定时器
			mCycleViewPager.cancel();
		}
	}
}
