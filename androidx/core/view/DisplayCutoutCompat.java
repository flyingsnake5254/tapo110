package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import java.util.List;

public final class DisplayCutoutCompat
{
  private final Object mDisplayCutout;
  
  public DisplayCutoutCompat(Rect paramRect, List<Rect> paramList)
  {
    this(paramRect);
  }
  
  private DisplayCutoutCompat(Object paramObject)
  {
    this.mDisplayCutout = paramObject;
  }
  
  static DisplayCutoutCompat wrap(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = new DisplayCutoutCompat(paramObject);
    }
    return (DisplayCutoutCompat)paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (DisplayCutoutCompat.class == paramObject.getClass()))
    {
      paramObject = (DisplayCutoutCompat)paramObject;
      Object localObject = this.mDisplayCutout;
      if (localObject == null)
      {
        if (((DisplayCutoutCompat)paramObject).mDisplayCutout != null) {
          bool = false;
        }
      }
      else {
        bool = localObject.equals(((DisplayCutoutCompat)paramObject).mDisplayCutout);
      }
      return bool;
    }
    return false;
  }
  
  public List<Rect> getBoundingRects()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getBoundingRects();
    }
    return null;
  }
  
  public int getSafeInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetBottom();
    }
    return 0;
  }
  
  public int getSafeInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetLeft();
    }
    return 0;
  }
  
  public int getSafeInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetRight();
    }
    return 0;
  }
  
  public int getSafeInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetTop();
    }
    return 0;
  }
  
  public int hashCode()
  {
    Object localObject = this.mDisplayCutout;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DisplayCutoutCompat{");
    localStringBuilder.append(this.mDisplayCutout);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  @RequiresApi(api=28)
  DisplayCutout unwrap()
  {
    return (DisplayCutout)this.mDisplayCutout;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\DisplayCutoutCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */