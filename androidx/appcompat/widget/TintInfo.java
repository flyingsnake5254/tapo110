package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintInfo
{
  public boolean mHasTintList;
  public boolean mHasTintMode;
  public ColorStateList mTintList;
  public PorterDuff.Mode mTintMode;
  
  void clear()
  {
    this.mTintList = null;
    this.mHasTintList = false;
    this.mTintMode = null;
    this.mHasTintMode = false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\TintInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */