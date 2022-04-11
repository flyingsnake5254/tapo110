package com.bumptech.glide.load.engine.b0;

import android.os.Build.VERSION;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class b
{
  static int a()
  {
    int i = Runtime.getRuntime().availableProcessors();
    int j = i;
    if (Build.VERSION.SDK_INT < 17) {
      j = Math.max(b(), i);
    }
    return j;
  }
  
  /* Error */
  private static int b()
  {
    // Byte code:
    //   0: invokestatic 39	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_0
    //   4: new 41	java/io/File
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 43
    //   11: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: ldc 49
    //   16: invokestatic 55	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   19: astore_2
    //   20: new 6	com/bumptech/glide/load/engine/b0/b$a
    //   23: astore_3
    //   24: aload_3
    //   25: aload_2
    //   26: invokespecial 58	com/bumptech/glide/load/engine/b0/b$a:<init>	(Ljava/util/regex/Pattern;)V
    //   29: aload_1
    //   30: aload_3
    //   31: invokevirtual 62	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   34: astore_1
    //   35: aload_0
    //   36: invokestatic 66	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   39: goto +29 -> 68
    //   42: astore_1
    //   43: ldc 68
    //   45: bipush 6
    //   47: invokestatic 74	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   50: ifeq +12 -> 62
    //   53: ldc 68
    //   55: ldc 76
    //   57: aload_1
    //   58: invokestatic 80	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   61: pop
    //   62: aload_0
    //   63: invokestatic 66	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +10 -> 79
    //   72: aload_1
    //   73: arraylength
    //   74: istore 4
    //   76: goto +6 -> 82
    //   79: iconst_0
    //   80: istore 4
    //   82: iconst_1
    //   83: iload 4
    //   85: invokestatic 32	java/lang/Math:max	(II)I
    //   88: ireturn
    //   89: astore_1
    //   90: aload_0
    //   91: invokestatic 66	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	88	0	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    //   7	28	1	localObject1	Object
    //   42	16	1	localThrowable	Throwable
    //   67	6	1	localObject2	Object
    //   89	6	1	localObject3	Object
    //   19	7	2	localPattern	Pattern
    //   23	8	3	locala	a
    //   74	10	4	i	int
    // Exception table:
    //   from	to	target	type
    //   4	35	42	finally
    //   43	62	89	finally
  }
  
  class a
    implements FilenameFilter
  {
    a() {}
    
    public boolean accept(File paramFile, String paramString)
    {
      return b.this.matcher(paramString).matches();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\b0\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */