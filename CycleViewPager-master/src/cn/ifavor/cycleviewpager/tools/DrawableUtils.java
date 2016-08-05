package cn.ifavor.cycleviewpager.tools;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableUtils {
	/**
	 * ���� shape ͼƬ��Դ
	 * @param radius Բ��
	 * @param color ��ɫ
	 * @return
	 */
	public static Drawable createShape(int radius, int color) {
		GradientDrawable normalDrawable = new GradientDrawable();
		normalDrawable.setCornerRadius(radius);
		normalDrawable.setColor(color);
		return normalDrawable;
	}
	
	/**
	 * ���� selector ͼƬ��Դ
	 * @return 
	 */
	public static  Drawable createEnableDisableSelector(int radius, int disableColor, int enableColor) {
		// ���� selector
		StateListDrawable stateListDrawable = new StateListDrawable();
		stateListDrawable.addState(new int[] { android.R.attr.state_enabled },
				createShape(radius, enableColor ));
		stateListDrawable.addState(new int[] {}, createShape(radius,disableColor ) );
		return stateListDrawable;
	}

}
