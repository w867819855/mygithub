package cn.ifavor.cycleviewpager.cache.manager;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
	private static ThreadManager instance = new ThreadManager();

	private ThreadManager() {
	}

	public static ThreadManager getInstance() {
		return instance;
	}

	private ThreadPoolProxy shortPool;
	private ThreadPoolProxy longPool;

	/** �������̳߳�(�����ļ�����) */
	public synchronized ThreadPoolProxy createShortPool() {
		if (shortPool == null) {
			shortPool = new ThreadPoolProxy(3, 3, 5000);
		}
		return shortPool;
	}

	/** �������̳߳�(������������) */
	public synchronized ThreadPoolProxy creatLongPool() {
		if (longPool == null) {
			longPool = new ThreadPoolProxy(5, 5, 5000);
		}
		return longPool;
	}

	/**
	 * �̳߳�������(ÿһ������һ�������̳߳�)
	 * 
	 * @author Administrator
	 * 
	 */
	public class ThreadPoolProxy {
		private ThreadPoolExecutor mThreadPoolExecutor;
		private int corePoolSize;
		private int maximumPoolSize;
		private long keepAliveTime;

		public ThreadPoolProxy(int corePoolSize, int maximumPoolSize,
				long keepAliveTime) {
			this.corePoolSize = corePoolSize;
			this.maximumPoolSize = maximumPoolSize;
			this.keepAliveTime = keepAliveTime;
		}

		/** ִ��һ���߳����� */
		public void execute(Runnable runnable) {
			if (mThreadPoolExecutor == null) {

				/**
				 * 
				 * �������ͣ�
				 * ��һ�����������ĵ��߳�������corePoolSizeһ��ʹ��cpu������ * 2 + 1��
				 * �ڶ������������corePoolSize�������ˣ��ٴ������ٸ��̣߳���corePoolSize������һ�£�
				 * ������������ÿ���̴߳���ʱ�䣨�͵��ĸ��������ʹ�ã�
				 * ���ĸ������������������ĵ�λ������һ��������У�������������
				 * 	�������Ϊ�˷����û��Զ���洢�����ݽṹ�ŵ��������ṩ������
				 * 
				 * 1. corePoolSize��maximumPoolSize������������� 2.
				 * corePoolSizeһ��ʹ��cpu������ * 2 + 1
				 */
				mThreadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
						maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
						new LinkedBlockingDeque<Runnable>(10));
			}

			mThreadPoolExecutor.execute(runnable);

		}

		/** ȡ��һ���߳����� */
		public void cancel(Runnable runnable) {
			if (mThreadPoolExecutor != null && !mThreadPoolExecutor.isShutdown() &&!mThreadPoolExecutor.isTerminated()) {
				mThreadPoolExecutor.remove(runnable);
			}
			
		}
	}

}
