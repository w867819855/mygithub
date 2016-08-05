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
		map.put("���Ǳ��� 1", "http://www.soomal.com/images/doc/20150707/00052886_01.jpg");
		map.put("���Ǳ��� 2", "http://img.ithome.com/newsuploadfiles/2013/10/20131026_202938_747.jpg");
		map.put("���Ǳ��� 3", "http://images.cnitblog.com/blog/608747/201501/151335444483480.png");
		map.put("���Ǳ��� 4", "http://58pic.ooopic.com/58pic/16/80/58/42958PICxXV.jpg");
		map.put("���Ǳ��� 5", "http://n1.itc.cn/img8/wb/smccloud/recom/2015/11/04/144658670871459798.PNG");
		map.put("���Ǳ��� 6", "http://img.zcool.cn/community/01a782554558ed0000019ae9e89713.jpg");
		map.put("���Ǳ��� 7", "http://www.myexception.cn/img/2013/10/19/111719132.jpg");
		map.put("���Ǳ��� 8", "http://pic.58pic.com/58pic/17/41/96/81n58PICS2x_1024.jpg");
		mCycleViewPager.setURLMap(map).setDuration(3000);
		mCycleViewPager.start();
		
		**/
		
	//	mCycleViewPager.setBottomBackgroundColor(Color.rgb(11, 12, 12));
//		setBottomBackgroundColor //���õײ�������ɫ
//		setIndicatorRadius ����ָʾ����Բ��ֵ
//		setUnSelectedColor ����ָʾ��δѡ�е���ɫ
//		setSelectedColor ����ָʾ��ѡ�е���ɫ
//		setDuration �����ֲ���ִ��ʱ����
//		setIndicatorDirection ����ָʾ����ʾλ��
//		setIndicatorPointSize ����ָʾ����ĳߴ�
//		setIndicatorPointMargin ����ָʾ���������
//		setShowTitle �����Ƿ���ʾ����
//		setTitleTextSize ���ñ��������С
//		setTitleTextColor ���ñ���������ɫ
//		setHandler ���� handler
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
			// ȡ���ֲ���ʱ��
			mCycleViewPager.cancel();
		}
	}
}
