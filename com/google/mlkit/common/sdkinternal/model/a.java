package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.sdkinternal.j;

@KeepForSdk
public class a
{
  private static final GmsLogger a = new GmsLogger("ModelFileHelper", "");
  @VisibleForTesting
  private static final String b = String.format("com.google.mlkit.%s.models", new Object[] { "automl" });
  @VisibleForTesting
  private static final String c = String.format("com.google.mlkit.%s.models", new Object[] { "translate" });
  @VisibleForTesting
  private static final String d = String.format("com.google.mlkit.%s.models", new Object[] { "base" });
  private final j e;
  
  public a(j paramj)
  {
    this.e = paramj;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */