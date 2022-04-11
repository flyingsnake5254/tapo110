package com.tplink.iot.Utils.a1;

import android.app.AppOpsManager;
import android.app.AppOpsManager.OnOpNotedCallback;
import android.app.AsyncNotedAppOp;
import android.app.SyncNotedAppOp;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class a
{
  public static final boolean a()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 30) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean b()
  {
    return a();
  }
  
  public static final void c(Context paramContext, boolean paramBoolean)
  {
    j.e(paramContext, "context");
    if (!b()) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 28) {
      d(paramContext, paramBoolean);
    }
  }
  
  @RequiresApi(api=30)
  private static final void d(Context paramContext, boolean paramBoolean)
  {
    a locala = new a(paramBoolean);
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService(AppOpsManager.class);
    if (localAppOpsManager != null) {
      localAppOpsManager.setOnOpNotedCallback(paramContext.getMainExecutor(), locala);
    }
  }
  
  public static final class a
    extends AppOpsManager.OnOpNotedCallback
  {
    private final String a = "AuditDataAccess";
    
    a(boolean paramBoolean) {}
    
    private final void a(String paramString1, String paramString2, Throwable paramThrowable)
    {
      if (this.b)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("\n                    Private data accessed.\n                    Operation: ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\n                    Attribution Tag: ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("\n                    Stack Trace\n                ");
        paramString1 = m.f(localStringBuilder.toString());
        b.d.w.c.a.f(this.a, paramThrowable, paramString1, new Object[0]);
      }
      else
      {
        paramThrowable = new StringBuilder();
        paramThrowable.append("\n                    Private data accessed.\n                    Operation: ");
        paramThrowable.append(paramString1);
        paramThrowable.append("\n                    Attribution Tag: ");
        paramThrowable.append(paramString2);
        paramThrowable.append("\n                ");
        paramString1 = m.f(paramThrowable.toString());
        b.d.w.c.a.e(this.a, paramString1);
      }
    }
    
    public void onAsyncNoted(AsyncNotedAppOp paramAsyncNotedAppOp)
    {
      j.e(paramAsyncNotedAppOp, "asyncOp");
      String str = paramAsyncNotedAppOp.getOp();
      j.d(str, "asyncOp.op");
      a(str, paramAsyncNotedAppOp.getAttributionTag(), new Throwable());
    }
    
    public void onNoted(SyncNotedAppOp paramSyncNotedAppOp)
    {
      j.e(paramSyncNotedAppOp, "op");
      String str = paramSyncNotedAppOp.getOp();
      j.d(str, "op.op");
      a(str, paramSyncNotedAppOp.getAttributionTag(), new Throwable());
    }
    
    public void onSelfNoted(SyncNotedAppOp paramSyncNotedAppOp)
    {
      j.e(paramSyncNotedAppOp, "op");
      String str = paramSyncNotedAppOp.getOp();
      j.d(str, "op.op");
      a(str, paramSyncNotedAppOp.getAttributionTag(), new Throwable());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\a1\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */