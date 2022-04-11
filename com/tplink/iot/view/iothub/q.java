package com.tplink.iot.view.iothub;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import b.d.w.g.a;
import com.tplink.iot.databinding.LayoutHubGuardModeGuideBinding;
import com.tplink.libtpnetwork.Utils.o;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class q
{
  public static final a a = new a(null);
  private final ViewGroup b;
  private final LayoutInflater c;
  private LayoutHubGuardModeGuideBinding d;
  private boolean e;
  private View.OnClickListener f;
  
  public q(AppCompatActivity paramAppCompatActivity)
  {
    View localView = paramAppCompatActivity.findViewById(16908290);
    j.d(localView, "activity.findViewById(android.R.id.content)");
    this.b = ((ViewGroup)localView);
    this.c = LayoutInflater.from(paramAppCompatActivity);
  }
  
  private final int d(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect.top;
  }
  
  private final boolean g()
  {
    return o.h0().c("sp_hub_guard_mode_guide_shown_key", false);
  }
  
  private final void h()
  {
    Object localObject = DataBindingUtil.inflate(this.c, 2131559163, null, false);
    j.d(localObject, "DataBindingUtil.inflate(…de, null, false\n        )");
    localObject = (LayoutHubGuardModeGuideBinding)localObject;
    this.d = ((LayoutHubGuardModeGuideBinding)localObject);
    if (localObject == null) {
      j.t("mBinding");
    }
    ((ViewDataBinding)localObject).getRoot().setOnClickListener(b.c);
    localObject = this.d;
    if (localObject == null) {
      j.t("mBinding");
    }
    ((LayoutHubGuardModeGuideBinding)localObject).d.setOnClickListener(new c(this));
    localObject = this.d;
    if (localObject == null) {
      j.t("mBinding");
    }
    ((LayoutHubGuardModeGuideBinding)localObject).q.setOnClickListener(new d(this));
  }
  
  private final void l()
  {
    o.h0().h("sp_hub_guard_mode_guide_shown_key", true);
  }
  
  private final void n(int paramInt)
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      j.t("mBinding");
    }
    localObject1 = ((LayoutHubGuardModeGuideBinding)localObject1).q;
    j.d(localObject1, "mBinding.layoutGuardModeOverlay");
    Object localObject2 = ((View)localObject1).getLayoutParams();
    Objects.requireNonNull(localObject2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    localObject2 = (ConstraintLayout.LayoutParams)localObject2;
    ((ViewGroup.MarginLayoutParams)localObject2).setMargins(((ViewGroup.MarginLayoutParams)localObject2).leftMargin, paramInt, ((ViewGroup.MarginLayoutParams)localObject2).rightMargin, ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin);
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
  }
  
  public final void e()
  {
    if (!this.e) {
      return;
    }
    this.e = false;
    ViewGroup localViewGroup = this.b;
    LayoutHubGuardModeGuideBinding localLayoutHubGuardModeGuideBinding = this.d;
    if (localLayoutHubGuardModeGuideBinding == null) {
      j.t("mBinding");
    }
    localViewGroup.removeView(localLayoutHubGuardModeGuideBinding.getRoot());
  }
  
  public final void f()
  {
    e();
    l();
  }
  
  public final boolean i()
  {
    return this.e;
  }
  
  public final void j(View paramView)
  {
    j.e(paramView, "anchor");
    if (!this.e) {
      return;
    }
    n(d(paramView));
  }
  
  public final void k(View.OnClickListener paramOnClickListener)
  {
    j.e(paramOnClickListener, "listener");
    this.f = paramOnClickListener;
  }
  
  public final void m(final View paramView)
  {
    j.e(paramView, "anchor");
    if ((!this.e) && (!g()))
    {
      this.e = true;
      h();
      ViewGroup localViewGroup = this.b;
      LayoutHubGuardModeGuideBinding localLayoutHubGuardModeGuideBinding = this.d;
      if (localLayoutHubGuardModeGuideBinding == null) {
        j.t("mBinding");
      }
      localViewGroup.addView(localLayoutHubGuardModeGuideBinding.getRoot(), new ViewGroup.LayoutParams(-1, -1));
      paramView.post(new e(this, paramView));
    }
  }
  
  public static final class a {}
  
  static final class b
    implements View.OnClickListener
  {
    public static final b c = new b();
    
    public final void onClick(View paramView) {}
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(q paramq) {}
    
    public final void onClick(View paramView)
    {
      this.c.f();
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(q paramq) {}
    
    public final void onClick(View paramView)
    {
      this.c.f();
      View.OnClickListener localOnClickListener = q.b(this.c);
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramView);
      }
    }
  }
  
  static final class e
    implements Runnable
  {
    e(q paramq, View paramView) {}
    
    public final void run()
    {
      int i = q.a(this.c, paramView);
      q.c(this.c, i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */