package com.airbnb.lottie.s;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

public class a
  extends Paint
{
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(int paramInt, PorterDuff.Mode paramMode)
  {
    super(paramInt);
    setXfermode(new PorterDuffXfermode(paramMode));
  }
  
  public a(PorterDuff.Mode paramMode)
  {
    setXfermode(new PorterDuffXfermode(paramMode));
  }
  
  public void setTextLocales(@NonNull LocaleList paramLocaleList) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */