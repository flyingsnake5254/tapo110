package com.tplink.libtpcontrols.bottomsheet;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;

public class TPBottomSheet
  extends Fragment
  implements View.OnClickListener
{
  private boolean c = true;
  private Activity d = null;
  private e f;
  private View p0 = null;
  private ViewGroup p1;
  private LayoutInflater q = null;
  private View x;
  private int y = 2171169;
  private boolean z = false;
  
  private void C0()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 0.3F });
    localValueAnimator.addUpdateListener(new d(this));
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
  
  private void G0()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.3F, 0.0F });
    localValueAnimator.addUpdateListener(new b(this));
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
  }
  
  private void Q0()
  {
    View localView = this.p0;
    if (localView != null)
    {
      this.p1.addView(localView, -1, -2);
      this.x.getViewTreeObserver().addOnPreDrawListener(new a());
      return;
    }
    throw new IllegalStateException("Custom View Not Set!!!");
  }
  
  public void dismiss()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    new Handler().post(new a(this));
  }
  
  public View getView()
  {
    return this.p0;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == s0.bottom_sheet_rootview) && (this.z)) {
      dismiss();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = getActivity();
    if (paramBundle != null) {
      this.c = paramBundle.getBoolean("EXTRA_DISMISSED");
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = paramLayoutInflater;
    paramLayoutInflater = paramLayoutInflater.inflate(t0.bottom_sheet_container, paramViewGroup, true);
    this.x = paramLayoutInflater;
    this.p1 = ((ViewGroup)paramLayoutInflater.findViewById(s0.bottom_sheet_container));
    if (b.d.w.f.a.b(this.d)) {
      ((RelativeLayout.LayoutParams)this.p1.getLayoutParams()).bottomMargin = b.d.w.f.a.e(this.d);
    }
    this.x.setOnClickListener(this);
    Q0();
    paramLayoutInflater = (ViewGroup)getActivity().getWindow().getDecorView();
    paramLayoutInflater.removeView(this.x);
    paramLayoutInflater.addView(this.x);
    paramLayoutInflater = this.f;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.a(this, this.p1);
    }
    return this.x;
  }
  
  public void onDestroyView()
  {
    e locale = this.f;
    if (locale != null) {
      locale.b(this, this.p1);
    }
    G0();
    this.x.postDelayed(new c(this), 300L);
    this.c = true;
    super.onDestroyView();
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("EXTRA_DISMISSED", this.c);
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      TPBottomSheet.A0(TPBottomSheet.this);
      TPBottomSheet.B0(TPBottomSheet.this).getViewTreeObserver().removeOnPreDrawListener(this);
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\bottomsheet\TPBottomSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */