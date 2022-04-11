package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import b.d.w.f.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarUtils
{
  public static void a(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 19) && (i < 21)) {
      b(paramActivity);
    }
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity = (ViewGroup)paramActivity.findViewById(16908290);
    int i = paramActivity.getChildCount();
    if (i > 0)
    {
      i--;
      if ((paramActivity.getChildAt(i) instanceof StatusBarView)) {
        paramActivity.removeViewAt(i);
      }
    }
  }
  
  private static void c(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    int i = localViewGroup.getChildCount();
    if (i > 0)
    {
      i--;
      if ((localViewGroup.getChildAt(i) instanceof StatusBarView))
      {
        localViewGroup.removeViewAt(i);
        ((ViewGroup)((ViewGroup)paramActivity.findViewById(16908290)).getChildAt(0)).setPadding(0, 0, 0, 0);
      }
    }
  }
  
  private static StatusBarView d(Activity paramActivity, int paramInt)
  {
    int i = paramActivity.getResources().getIdentifier("status_bar_height", "dimen", "android");
    i = paramActivity.getResources().getDimensionPixelSize(i);
    paramActivity = new StatusBarView(paramActivity);
    paramActivity.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
    paramActivity.setBackgroundColor(paramInt);
    return paramActivity;
  }
  
  public static int e()
  {
    if (h()) {
      return 1;
    }
    if (i()) {
      return 2;
    }
    if (g()) {
      return 3;
    }
    return 4;
  }
  
  /* Error */
  private static String f(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 115	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore_2
    //   6: new 117	java/lang/StringBuilder
    //   9: astore_3
    //   10: aload_3
    //   11: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   14: aload_3
    //   15: ldc 122
    //   17: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: aload_3
    //   29: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 134	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   35: astore_2
    //   36: new 136	java/io/BufferedReader
    //   39: astore_0
    //   40: new 138	java/io/InputStreamReader
    //   43: astore_3
    //   44: aload_3
    //   45: aload_2
    //   46: invokevirtual 144	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   49: invokespecial 147	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   52: aload_0
    //   53: aload_3
    //   54: sipush 1024
    //   57: invokespecial 150	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   60: aload_0
    //   61: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: astore_3
    //   65: aload_0
    //   66: invokevirtual 156	java/io/BufferedReader:close	()V
    //   69: aload_0
    //   70: invokevirtual 156	java/io/BufferedReader:close	()V
    //   73: aload_3
    //   74: areturn
    //   75: astore_3
    //   76: aload_0
    //   77: astore_1
    //   78: aload_3
    //   79: astore_0
    //   80: goto +8 -> 88
    //   83: astore_3
    //   84: goto +17 -> 101
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 156	java/io/BufferedReader:close	()V
    //   96: aload_0
    //   97: athrow
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +7 -> 109
    //   105: aload_0
    //   106: invokevirtual 156	java/io/BufferedReader:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: goto -39 -> 73
    //   115: astore_3
    //   116: goto -20 -> 96
    //   119: astore_0
    //   120: goto -11 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   1	92	1	str	String
    //   5	41	2	localObject1	Object
    //   9	65	3	localObject2	Object
    //   75	4	3	localObject3	Object
    //   83	1	3	localIOException1	java.io.IOException
    //   115	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   60	69	75	finally
    //   60	69	83	java/io/IOException
    //   2	60	87	finally
    //   2	60	98	java/io/IOException
    //   69	73	111	java/io/IOException
    //   92	96	115	java/io/IOException
    //   105	109	119	java/io/IOException
  }
  
  private static boolean g()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private static boolean h()
  {
    String str1 = f("ro.miui.ui.version.code");
    String str2 = f("ro.miui.version.code_time");
    boolean bool1 = TextUtils.isEmpty(str1);
    boolean bool2 = false;
    if (!bool1) {}
    try
    {
      if (Integer.parseInt(str1) >= 4)
      {
        if (!TextUtils.isEmpty(str2))
        {
          long l = Long.parseLong(str2);
          if (l <= 1499875200L) {
            bool2 = true;
          }
          return bool2;
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return false;
  }
  
  private static boolean i()
  {
    Object localObject = Build.DISPLAY;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("Flyme")))
    {
      localObject = ((String)localObject).split(" ");
      int i = localObject.length;
      for (int j = 0; j < i; j++) {
        if (localObject[j].matches("^[4-9]\\.(\\d+\\.)+\\S*")) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static void j(Activity paramActivity, boolean paramBoolean)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    if (paramBoolean) {
      paramActivity.setSystemUiVisibility(8192);
    } else {
      paramActivity.setSystemUiVisibility(0);
    }
  }
  
  private static boolean k(Activity paramActivity, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramActivity != null) {}
    try
    {
      WindowManager.LayoutParams localLayoutParams = paramActivity.getWindow().getAttributes();
      Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
      Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
      localField1.setAccessible(true);
      localField2.setAccessible(true);
      int i = localField1.getInt(null);
      int j = localField2.getInt(localLayoutParams);
      if (paramBoolean) {
        i = j | i;
      } else {
        i = (i ^ 0xFFFFFFFF) & j;
      }
      localField2.setInt(localLayoutParams, i);
      paramActivity.getWindow().setAttributes(localLayoutParams);
      paramBoolean = bool;
    }
    catch (Exception paramActivity)
    {
      for (;;) {}
    }
    paramBoolean = false;
    return paramBoolean;
  }
  
  public static void l(Activity paramActivity, boolean paramBoolean)
  {
    int i = e();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          j(paramActivity, paramBoolean);
        }
      }
      else {
        k(paramActivity, paramBoolean);
      }
    }
    else {
      m(paramActivity, paramBoolean);
    }
  }
  
  private static boolean m(Activity paramActivity, boolean paramBoolean)
  {
    Object localObject = paramActivity.getWindow().getClass();
    try
    {
      Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
      int i = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
      localClass = Integer.TYPE;
      localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { localClass, localClass });
      paramActivity = paramActivity.getWindow();
      int j;
      if (paramBoolean) {
        j = i;
      } else {
        j = 0;
      }
      ((Method)localObject).invoke(paramActivity, new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      return true;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return false;
  }
  
  public static void n(Activity paramActivity, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 19) && (i < 21))
    {
      paramActivity.getWindow().addFlags(67108864);
      StatusBarView localStatusBarView = d(paramActivity, paramInt);
      ((ViewGroup)paramActivity.getWindow().getDecorView()).addView(localStatusBarView);
      paramActivity = (ViewGroup)((ViewGroup)paramActivity.findViewById(16908290)).getChildAt(0);
      paramActivity.setFitsSystemWindows(true);
      paramActivity.setClipToPadding(true);
    }
  }
  
  public static void o(Activity paramActivity, View paramView, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i >= 19) && (i < 21))
    {
      paramActivity.getWindow().addFlags(67108864);
      ViewGroup localViewGroup = (ViewGroup)paramActivity.findViewById(16908290);
      if (localViewGroup.getChildCount() > 1) {
        localViewGroup.getChildAt(1).setBackgroundColor(paramInt);
      } else {
        localViewGroup.addView(d(paramActivity, paramInt));
      }
      if (paramView != null)
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
        paramView.setMargins(paramView.leftMargin, paramView.topMargin + a.f(paramActivity), paramView.rightMargin, paramView.bottomMargin);
      }
      c(paramActivity);
    }
  }
  
  private static class StatusBarView
    extends View
  {
    public StatusBarView(Context paramContext)
    {
      super();
    }
    
    public StatusBarView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\StatusBarUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */