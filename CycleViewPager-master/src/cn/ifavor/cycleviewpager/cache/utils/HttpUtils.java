package cn.ifavor.cycleviewpager.cache.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;

public class HttpUtils {

	/**
	 * ������������
	 * 
	 * @param url
	 * @param file
	 * @return
	 */
	public static String send(String url) {
		HttpURLConnection conn = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			URL imageUrl = new URL(url);
			conn = (HttpURLConnection) imageUrl.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			// conn.setInstanceFollowRedirects(true);
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) {
				is = conn.getInputStream();
				String res = StreamUtils.InputStreamToString(is,
						Charset.forName("GBK"));
				return res;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
				if (conn != null)
					conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ������������
	 * 
	 * @param url
	 * @param file
	 * @return
	 */
	public static Bitmap loadBitmap(String url) {

		HttpURLConnection conn = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			Bitmap bitmap = null;
			URL imageUrl = new URL(url);
			conn = (HttpURLConnection) imageUrl.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setInstanceFollowRedirects(true);
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) {
				is = conn.getInputStream();

				// ������ʱ���ı�ͼƬ��������
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inSampleSize = 1;
				/*
				 * ALPHA_8 ����8λAlphaλͼ 
				 * ARGB_4444 ����16λARGBλͼ
				 *  ARGB_8888����32λARGBλͼ 
				 *  RGB_565 ����8λRGBλͼ
				 * λͼλ��Խ�ߴ�������Դ洢����ɫ��ϢԽ�࣬��Ȼͼ��Ҳ��Խ���档 
				 */
				options.inPreferredConfig = Bitmap.Config.ARGB_8888;
				bitmap = BitmapFactory.decodeStream(is, null, options);
				return bitmap;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
				if (conn != null)
					conn.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
