package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

public class a
  extends c
{
  private final View a;
  private int b = 0;
  
  public a(View paramView)
  {
    this.a = paramView;
  }
  
  public void b()
  {
    int i = c.a(this.b);
    this.b = i;
    if (i == 0) {
      return;
    }
    Drawable localDrawable = f.a.f.a.d.d(this.a.getContext(), this.b);
    if (localDrawable != null)
    {
      int j = this.a.getPaddingLeft();
      int k = this.a.getPaddingTop();
      i = this.a.getPaddingRight();
      int m = this.a.getPaddingBottom();
      ViewCompat.setBackground(this.a, localDrawable);
      this.a.setPadding(j, k, i, m);
    }
  }
  
  public void c(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, f.a.d.SkinBackgroundHelper, paramInt, 0);
    try
    {
      paramInt = f.a.d.SkinBackgroundHelper_android_background;
      if (paramAttributeSet.hasValue(paramInt)) {
        this.b = paramAttributeSet.getResourceId(paramInt, 0);
      }
      paramAttributeSet.recycle();
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  public void d(int paramInt)
  {
    this.b = paramInt;
    b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */