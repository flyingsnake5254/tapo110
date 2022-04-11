package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class d
  extends c
{
  private final ImageView a;
  private int b = 0;
  private int c = 0;
  
  public d(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  public void b()
  {
    int i = c.a(this.c);
    this.c = i;
    Drawable localDrawable;
    if (i != 0)
    {
      localDrawable = f.a.f.a.d.d(this.a.getContext(), this.c);
      if (localDrawable != null) {
        this.a.setImageDrawable(localDrawable);
      }
    }
    else
    {
      i = c.a(this.b);
      this.b = i;
      if (i == 0) {
        return;
      }
      localDrawable = f.a.f.a.d.d(this.a.getContext(), this.b);
      if (localDrawable != null) {
        this.a.setImageDrawable(localDrawable);
      }
    }
  }
  
  public void c(AttributeSet paramAttributeSet, int paramInt)
  {
    AttributeSet localAttributeSet = null;
    try
    {
      paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, f.a.d.SkinCompatImageView, paramInt, 0);
      localAttributeSet = paramAttributeSet;
      this.b = paramAttributeSet.getResourceId(f.a.d.SkinCompatImageView_android_src, 0);
      localAttributeSet = paramAttributeSet;
      this.c = paramAttributeSet.getResourceId(f.a.d.SkinCompatImageView_srcCompat, 0);
      paramAttributeSet.recycle();
      b();
      return;
    }
    finally
    {
      if (localAttributeSet != null) {
        localAttributeSet.recycle();
      }
    }
  }
  
  public void d(int paramInt)
  {
    this.b = paramInt;
    b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\skin\support\widget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */