package com.tplink.iot.widget.plug;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public final class a
{
  private final AnimationDrawable a;
  private long b;
  
  public a(Drawable[] paramArrayOfDrawable, long paramLong)
  {
    this.b = paramLong;
    this.a = new AnimationDrawable();
    int i = paramArrayOfDrawable.length;
    for (int j = 0; j < i; j++)
    {
      Drawable localDrawable = paramArrayOfDrawable[j];
      this.a.addFrame(localDrawable, (int)this.b);
    }
  }
  
  public final void a(ImageView paramImageView)
  {
    if (paramImageView != null) {
      paramImageView.setImageDrawable(this.a);
    }
  }
  
  public final void b()
  {
    this.a.stop();
  }
  
  public final void c()
  {
    this.a.start();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\plug\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */