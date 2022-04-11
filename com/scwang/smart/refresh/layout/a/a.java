package com.scwang.smart.refresh.layout.a;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.scwang.smart.refresh.layout.c.h;
import com.scwang.smart.refresh.layout.constant.b;

public abstract interface a
  extends h
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY, androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.SUBCLASSES})
  public abstract int f(@NonNull f paramf, boolean paramBoolean);
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY, androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.SUBCLASSES})
  public abstract void g(@NonNull e parame, int paramInt1, int paramInt2);
  
  @NonNull
  public abstract b getSpinnerStyle();
  
  @NonNull
  public abstract View getView();
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY, androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.SUBCLASSES})
  public abstract void i(@NonNull f paramf, int paramInt1, int paramInt2);
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY, androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.SUBCLASSES})
  public abstract void j(@NonNull f paramf, int paramInt1, int paramInt2);
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY, androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.SUBCLASSES})
  public abstract void k(float paramFloat, int paramInt1, int paramInt2);
  
  public abstract boolean n();
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY, androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.SUBCLASSES})
  public abstract void s(boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3);
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY, androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.SUBCLASSES})
  public abstract void setPrimaryColors(@ColorInt int... paramVarArgs);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */