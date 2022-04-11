package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private final CrashListener crashListener;
  private final Thread.UncaughtExceptionHandler defaultHandler;
  private final AtomicBoolean isHandlingException;
  private final SettingsDataProvider settingsDataProvider;
  
  public CrashlyticsUncaughtExceptionHandler(CrashListener paramCrashListener, SettingsDataProvider paramSettingsDataProvider, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.crashListener = paramCrashListener;
    this.settingsDataProvider = paramSettingsDataProvider;
    this.defaultHandler = paramUncaughtExceptionHandler;
    this.isHandlingException = new AtomicBoolean(false);
  }
  
  boolean isHandlingException()
  {
    return this.isHandlingException.get();
  }
  
  /* Error */
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: iconst_1
    //   5: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   8: aload_1
    //   9: ifnonnull +22 -> 31
    //   12: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   15: ldc 55
    //   17: invokevirtual 59	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;)V
    //   20: goto +41 -> 61
    //   23: astore_3
    //   24: goto +80 -> 104
    //   27: astore_3
    //   28: goto +63 -> 91
    //   31: aload_2
    //   32: ifnonnull +14 -> 46
    //   35: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   38: ldc 61
    //   40: invokevirtual 59	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;)V
    //   43: goto +18 -> 61
    //   46: aload_0
    //   47: getfield 24	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:crashListener	Lcom/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler$CrashListener;
    //   50: aload_0
    //   51: getfield 26	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:settingsDataProvider	Lcom/google/firebase/crashlytics/internal/settings/SettingsDataProvider;
    //   54: aload_1
    //   55: aload_2
    //   56: invokeinterface 65 4 0
    //   61: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   64: ldc 67
    //   66: invokevirtual 70	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 28	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   73: aload_1
    //   74: aload_2
    //   75: invokeinterface 72 3 0
    //   80: aload_0
    //   81: getfield 35	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   84: iconst_0
    //   85: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   88: goto +15 -> 103
    //   91: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   94: ldc 74
    //   96: aload_3
    //   97: invokevirtual 77	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: goto -39 -> 61
    //   103: return
    //   104: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   107: ldc 67
    //   109: invokevirtual 70	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   112: aload_0
    //   113: getfield 28	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   116: aload_1
    //   117: aload_2
    //   118: invokeinterface 72 3 0
    //   123: aload_0
    //   124: getfield 35	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   127: iconst_0
    //   128: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   131: aload_3
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	133	1	paramThread	Thread
    //   0	133	2	paramThrowable	Throwable
    //   23	1	3	localObject	Object
    //   27	105	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   12	20	23	finally
    //   35	43	23	finally
    //   46	61	23	finally
    //   91	100	23	finally
    //   12	20	27	java/lang/Exception
    //   35	43	27	java/lang/Exception
    //   46	61	27	java/lang/Exception
  }
  
  static abstract interface CrashListener
  {
    public abstract void onUncaughtException(SettingsDataProvider paramSettingsDataProvider, Thread paramThread, Throwable paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsUncaughtExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */