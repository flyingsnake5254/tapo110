package b.d.n.g;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import b.d.n.j.f;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.j;
import com.tplink.libtpinappmessaging.model.IAMException;
import io.reactivex.q;
import io.reactivex.v;
import java.io.File;
import java.lang.ref.WeakReference;

public class d
  implements b.d.n.i.e
{
  private static final String a = b.d.n.i.e.class.getSimpleName();
  private b.d.n.i.h b;
  private Application c;
  private LayoutInflater d;
  private CountDownTimer e;
  private WeakReference<Activity> f;
  private boolean g = false;
  private View h;
  
  public d(Application paramApplication, boolean paramBoolean)
  {
    this.c = paramApplication;
    this.g = paramBoolean;
    this.d = ((LayoutInflater)paramApplication.getSystemService("layout_inflater"));
    q();
  }
  
  private void j(com.tplink.libtpinappmessaging.model.c paramc)
  {
    if (this.f.get() != null)
    {
      b.d.n.j.d.c().e(paramc.c(), paramc.b(), paramc.a());
      Object localObject1 = ((Activity)this.f.get()).getWindow();
      if (localObject1 != null)
      {
        Object localObject2 = ((Window)localObject1).getDecorView().findViewById(16908290);
        if ((localObject2 instanceof ViewGroup))
        {
          localObject1 = this.d.inflate(b.d.n.b.layout_splash, null);
          this.h = ((View)localObject1);
          ((ViewGroup)localObject2).addView((View)localObject1);
          ((View)localObject1).setVisibility(0);
          ((View)localObject1).setAlpha(0.0F);
          ((View)localObject1).animate().alpha(1.0F).setDuration(300L).start();
          localObject2 = (ImageView)((View)localObject1).findViewById(b.d.n.a.iv_splash);
          TextView localTextView = (TextView)((View)localObject1).findViewById(b.d.n.a.tv_count);
          if ((paramc instanceof com.tplink.libtpinappmessaging.model.d))
          {
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(a);
            ((StringBuilder)localObject3).append(" rev \n[SplashMessage]:");
            com.tplink.libtpinappmessaging.model.d locald = (com.tplink.libtpinappmessaging.model.d)paramc;
            ((StringBuilder)localObject3).append(locald.g());
            b.d.n.j.e.b(((StringBuilder)localObject3).toString());
            localObject3 = new File(locald.g());
            ((com.bumptech.glide.h)((com.bumptech.glide.h)com.bumptech.glide.c.v((View)localObject2).q((File)localObject3).e0(true)).f(j.b)).x0((ImageView)localObject2);
            this.e = new c(5000L, 1000L, (View)localObject1).start();
            localTextView.setOnClickListener(new a(this, (View)localObject1));
            ((ImageView)localObject2).setOnClickListener(new b(this, paramc, (View)localObject1));
          }
        }
        else
        {
          l();
        }
      }
      else
      {
        l();
      }
    }
    else
    {
      l();
    }
  }
  
  private void k(com.tplink.libtpinappmessaging.model.c paramc)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append(" rev \n[WebMessage]:");
    com.tplink.libtpinappmessaging.model.e locale = (com.tplink.libtpinappmessaging.model.e)paramc;
    ((StringBuilder)localObject).append(locale.g());
    b.d.n.j.e.b(((StringBuilder)localObject).toString());
    localObject = (Activity)b.d.n.j.a.b().c().get();
    if ((localObject != null) && (!((Activity)localObject).isDestroyed()))
    {
      new e((Context)localObject, locale.g()).show();
      b.d.n.j.d.c().e(paramc.c(), paramc.b(), paramc.a());
    }
  }
  
  private void l()
  {
    b.d.n.i.h localh = this.b;
    if (localh != null)
    {
      localh.onFinish();
      this.b = null;
    }
  }
  
  private void q()
  {
    f.a().l0(io.reactivex.l0.a.b(b.d.n.h.c.a())).C(c.c).y0(new a());
  }
  
  private void r()
  {
    f.b().l0(io.reactivex.l0.a.b(b.d.n.h.c.a())).y0(new b());
  }
  
  public void b()
  {
    if (this.g)
    {
      View localView = this.h;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void c(b.d.n.i.h paramh)
  {
    this.b = paramh;
    r();
  }
  
  public void d(Activity paramActivity)
  {
    this.f = new WeakReference(paramActivity);
  }
  
  class a
    implements v<com.tplink.libtpinappmessaging.model.c>
  {
    a() {}
    
    public void a(com.tplink.libtpinappmessaging.model.c paramc)
    {
      if ((paramc instanceof com.tplink.libtpinappmessaging.model.e)) {
        d.a(d.this, paramc);
      }
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable) {}
    
    public void onSubscribe(io.reactivex.e0.c paramc) {}
  }
  
  class b
    implements v<com.tplink.libtpinappmessaging.model.c>
  {
    b() {}
    
    public void a(com.tplink.libtpinappmessaging.model.c paramc)
    {
      d.e(d.this, paramc);
    }
    
    public void onComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof IAMException))
      {
        paramThrowable = (IAMException)paramThrowable;
        int i = paramThrowable.getErrorCode();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(d.f());
        localStringBuilder.append("Splash onError \n[msg]:");
        localStringBuilder.append(paramThrowable.getMessage());
        b.d.n.j.e.a(localStringBuilder.toString());
        if (((i == -2) || (i == -3) || (i == -1)) && (d.g(d.this) != null))
        {
          d.g(d.this).onFinish();
          d.h(d.this, null);
        }
      }
    }
    
    public void onSubscribe(io.reactivex.e0.c paramc) {}
  }
  
  class c
    extends CountDownTimer
  {
    c(long paramLong1, long paramLong2, View paramView)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      if (d.g(d.this) != null)
      {
        if (!d.i(d.this)) {
          this.a.setVisibility(8);
        }
        d.g(d.this).onFinish();
        d.h(d.this, null);
      }
    }
    
    public void onTick(long paramLong) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */