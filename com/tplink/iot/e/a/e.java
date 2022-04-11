package com.tplink.iot.e.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import java.util.Arrays;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;

public final class e
{
  public static final e a = new e();
  
  public final int a(int paramInt, Context paramContext)
  {
    j.e(paramContext, "context");
    float f = paramInt;
    paramContext = paramContext.getResources();
    j.d(paramContext, "context\n                .resources");
    return (int)TypedValue.applyDimension(1, f, paramContext.getDisplayMetrics());
  }
  
  public final String b(int paramInt)
  {
    Object localObject = p.a;
    String str1 = String.format("%02d", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt / 60) }, 1));
    j.d(str1, "java.lang.String.format(format, *args)");
    String str2 = String.format("%02d", Arrays.copyOf(new Object[] { Integer.valueOf(paramInt % 60) }, 1));
    j.d(str2, "java.lang.String.format(format, *args)");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(':');
    ((StringBuilder)localObject).append(str2);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\e\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */