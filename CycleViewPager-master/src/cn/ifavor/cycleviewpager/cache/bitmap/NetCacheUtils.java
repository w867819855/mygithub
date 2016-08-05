package cn.ifavor.cycleviewpager.cache.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;
import cn.ifavor.cycleviewpager.R;
import cn.ifavor.cycleviewpager.cache.manager.ThreadManager;
import cn.ifavor.cycleviewpager.cache.utils.HttpUtils;

/**
 * ���ڹ������绺�����
 * 
 * @author HSW
 * 
 */
public class NetCacheUtils {
	private FileCacheUtils fileCacheUtils;
	private Context mContext;
	private Handler mHandler;

	public NetCacheUtils(Context context, Handler handler,FileCacheUtils fileCacheUtils) {
		this.fileCacheUtils = fileCacheUtils;
		mContext = context;
		mHandler = handler;
	}

	public void loadBitmap(ImageView imageView, String url) {
		Runnable runnable = new BitmapLoadRunable(imageView, url);
		ThreadManager.getInstance().creatLongPool().execute(runnable);
	}

	/** ����ͼƬ�첽���� */
	private class BitmapLoadRunable implements Runnable {
		private String mUrl;
		private ImageView mImageView;
		private Bitmap bitmap;

		public BitmapLoadRunable(ImageView imageView, String url) {
			mImageView = imageView;
			mUrl = url;
		}

		@Override
		public void run() {
			bitmap = HttpUtils.loadBitmap(mUrl);
			
			mHandler.post(new Runnable() {

				@Override
				public void run() {
					if (bitmap == null) {
						// ����Ĭ��ͼƬ
						// mImageView.setImageResource();
						Context context;
						
						bitmap = BitmapFactory.decodeResource(mContext.getResources(),
								R.drawable.ic_launcher);
					}

					// System.out.println("�����绺����ȡ");
					mImageView.setImageBitmap(bitmap);
					mImageView.setTag(mUrl);

					// ���浽FileCache��
					fileCacheUtils.put(mUrl, bitmap);

				}
			});

		}
	}
}
