package cn.ifavor.cycleviewpager.cache.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class StreamUtils {
	public static String InputStreamToString(InputStream is, Charset charset)
			throws IOException {
		// ����һ���ڴ���
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			// �����ݴ�InputStream�������ڴ�����
			while ((len = is.read(buffer, 0, buffer.length)) != -1) {
				baos.write(buffer, 0, len);
			}

			// ͨ���ڴ�����toByteArray()�����õ�һ��byte����
			byte[] newBuffer = baos.toByteArray();
			// ����byte���鴴���ַ���

			// ���ݲ�ͬ�ı�������ɲ�ͬ��ʽ���ַ���
			String temp = new String(newBuffer, 0, newBuffer.length, charset);

			return temp;
		} finally {
			// �ر���
			if (baos != null)
				baos.close();

			if (is != null)
				is.close();
		}
	}
}
