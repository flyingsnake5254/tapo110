package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import b.d.b.f.b;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCProtocolRepository;
import io.reactivex.q;

public class s0
{
  private static h0 a;
  private static k0 b;
  private static i0 c;
  private static j0 d;
  
  public static void A(Activity paramActivity, int paramInt, h paramh)
  {
    z(paramActivity, true, paramActivity.getString(paramInt), paramh);
  }
  
  public static void B(Activity paramActivity, h paramh)
  {
    z(paramActivity, true, "", paramh);
  }
  
  public static void C(Activity paramActivity, CharSequence paramCharSequence, h paramh)
  {
    z(paramActivity, true, paramCharSequence, paramh);
  }
  
  public static void D(Context paramContext, long paramLong)
  {
    ((Vibrator)paramContext.getSystemService("vibrator")).vibrate(paramLong);
  }
  
  public static void g()
  {
    h0 localh0 = a;
    if (localh0 != null)
    {
      localh0.c();
      a = null;
    }
  }
  
  public static void h()
  {
    j0 localj0 = d;
    if (localj0 != null)
    {
      localj0.b();
      d = null;
    }
  }
  
  public static void i()
  {
    Object localObject = b;
    if (localObject != null)
    {
      ((k0)localObject).b();
      b = null;
    }
    localObject = c;
    if (localObject != null)
    {
      ((i0)localObject).b();
      c = null;
    }
  }
  
  public static boolean j()
  {
    h0 localh0 = a;
    boolean bool;
    if ((localh0 != null) && (localh0.f())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void k(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing()))
    {
      TPMaterialDialog.Builder localBuilder = new TPMaterialDialog.Builder(paramActivity);
      localBuilder.m(paramActivity.getString(2131952370));
      localBuilder.g(paramActivity.getString(2131952371));
      localBuilder.b(false);
      localBuilder.c(false);
      localBuilder.i(2131952441, 2131099808, new g());
      localBuilder.a().show();
    }
  }
  
  public static boolean l(Activity paramActivity)
  {
    return m(paramActivity, null);
  }
  
  public static boolean m(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing()))
    {
      h0 localh0 = a;
      if ((localh0 != null) && (localh0.f()) && (paramActivity == a.d()))
      {
        a.h(paramString);
        return true;
      }
      paramActivity = new h0(paramActivity);
      a = paramActivity;
      paramActivity.h(paramString);
      a.g(false);
      a.i();
      return true;
    }
    return false;
  }
  
  public static void n(Activity paramActivity, int paramInt)
  {
    z(paramActivity, false, paramActivity.getString(paramInt), null);
  }
  
  public static void o(Activity paramActivity, int paramInt, h paramh)
  {
    z(paramActivity, false, paramActivity.getString(paramInt), paramh);
  }
  
  public static void p(Activity paramActivity, CharSequence paramCharSequence)
  {
    z(paramActivity, false, paramCharSequence, null);
  }
  
  public static void q(Activity paramActivity, CharSequence paramCharSequence, h paramh)
  {
    z(paramActivity, false, paramCharSequence, paramh);
  }
  
  public static void r(Activity paramActivity, CharSequence paramCharSequence, long paramLong)
  {
    y(paramActivity, false, paramCharSequence, 0, null, paramLong);
  }
  
  public static void s(Activity paramActivity, int paramInt)
  {
    w(paramActivity, paramActivity.getString(paramInt), null);
  }
  
  public static void t(Activity paramActivity, int paramInt, h paramh)
  {
    x(paramActivity, paramActivity.getString(paramInt), paramh, 2000L);
  }
  
  public static void u(Activity paramActivity, int paramInt, h paramh, long paramLong)
  {
    x(paramActivity, paramActivity.getString(paramInt), paramh, paramLong);
  }
  
  public static void v(Activity paramActivity, String paramString)
  {
    w(paramActivity, paramString, null);
  }
  
  public static void w(Activity paramActivity, String paramString, h paramh)
  {
    x(paramActivity, paramString, paramh, 2000L);
  }
  
  public static void x(Activity paramActivity, String paramString, h paramh, long paramLong)
  {
    j0 localj0 = d;
    if (localj0 != null)
    {
      localj0.b();
      d = null;
    }
    paramActivity = new j0(paramActivity, paramString);
    d = paramActivity;
    paramActivity.d();
    if (paramh != null) {
      d.c(new a(paramh));
    }
    new Handler().postDelayed(new b(), paramLong);
  }
  
  private static void y(Activity paramActivity, boolean paramBoolean, CharSequence paramCharSequence, int paramInt, h paramh, long paramLong)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = null;
    if (localObject != null)
    {
      ((h0)localObject).c();
      a = null;
    }
    localObject = b;
    if (localObject != null)
    {
      ((k0)localObject).b();
      b = null;
    }
    localObject = c;
    if (localObject != null)
    {
      ((i0)localObject).b();
      c = null;
    }
    localObject = d;
    if (localObject != null)
    {
      ((j0)localObject).b();
      d = null;
    }
    if ((paramActivity != null) && (!paramActivity.isDestroyed()) && (!paramActivity.isFinishing())) {
      if (paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCharSequence);
        localStringBuilder.append("");
        paramActivity = new k0(paramActivity, localStringBuilder.toString());
        b = paramActivity;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCharSequence);
        localStringBuilder.append("");
        paramActivity.d(localStringBuilder.toString());
        b.c(false);
        b.f();
        if (paramh != null) {
          b.e(new c(paramh));
        }
        new Handler().postDelayed(new d(), paramLong);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramCharSequence);
        ((StringBuilder)localObject).append("");
        localObject = new i0(paramActivity, ((StringBuilder)localObject).toString());
        c = (i0)localObject;
        if (TextUtils.isEmpty(paramCharSequence))
        {
          paramActivity = localStringBuilder;
        }
        else
        {
          paramActivity = new StringBuilder();
          paramActivity.append(paramCharSequence);
          paramActivity.append("");
          paramActivity = paramActivity.toString();
        }
        ((i0)localObject).e(paramActivity);
        if (paramInt > 0) {
          c.d(paramInt);
        }
        c.c(false);
        c.g();
        if (paramh != null) {
          c.f(new e(paramh));
        }
        new Handler().postDelayed(new f(), paramLong);
      }
    }
  }
  
  private static void z(Activity paramActivity, boolean paramBoolean, CharSequence paramCharSequence, h paramh)
  {
    y(paramActivity, paramBoolean, paramCharSequence, 0, paramh, 2000L);
  }
  
  static final class a
    implements j0.b
  {
    a(s0.h paramh) {}
    
    public void onDismiss()
    {
      s0.b(null);
      this.a.onDismiss();
    }
  }
  
  static final class b
    implements Runnable
  {
    public void run()
    {
      if (s0.a() != null)
      {
        s0.a().b();
        s0.b(null);
      }
    }
  }
  
  static final class c
    implements k0.b
  {
    c(s0.h paramh) {}
    
    public void onDismiss()
    {
      s0.d(null);
      this.a.onDismiss();
    }
  }
  
  static final class d
    implements Runnable
  {
    public void run()
    {
      if (s0.c() != null)
      {
        s0.c().b();
        s0.d(null);
      }
    }
  }
  
  static final class e
    implements i0.b
  {
    e(s0.h paramh) {}
    
    public void onDismiss()
    {
      s0.f(null);
      this.a.onDismiss();
    }
  }
  
  static final class f
    implements Runnable
  {
    public void run()
    {
      if (s0.e() != null)
      {
        s0.e().b();
        s0.f(null);
      }
    }
  }
  
  static final class g
    implements TPMaterialDialog.d
  {
    public void onClick(View paramView)
    {
      ((TCProtocolRepository)b.a(b.d.s.a.a.f(), TCProtocolRepository.class)).e().L0(io.reactivex.l0.a.c()).F0();
    }
  }
  
  public static abstract interface h
  {
    public abstract void onDismiss();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\s0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */