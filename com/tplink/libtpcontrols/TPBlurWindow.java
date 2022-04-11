package com.tplink.libtpcontrols;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.commit451.nativestackblur.NativeStackBlur;
import com.tplink.libtpcontrols.z0.c;

public class TPBlurWindow
  extends Fragment
{
  private boolean H3 = true;
  private View I3 = null;
  private ImageView J3 = null;
  private int K3 = 500;
  private View c = null;
  private View d = null;
  private View f = null;
  private float p0 = 20.0F;
  private FragmentManager p1 = null;
  private boolean p2 = true;
  private c p3 = null;
  private RelativeLayout q = null;
  private LayoutInflater x = null;
  private Activity y = null;
  private float z = 5.0F;
  
  private void O0()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.f, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.start();
  }
  
  private Animation P0()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  private void W0()
  {
    if (this.c == null) {
      return;
    }
    this.q.getViewTreeObserver().addOnPreDrawListener(new a());
    this.f.setFocusable(true);
    this.f.setFocusableInTouchMode(true);
    this.f.setOnKeyListener(new k(this));
  }
  
  public void dismiss()
  {
    if (this.p2) {
      return;
    }
    this.p2 = true;
    new Handler().post(new l(this));
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = getActivity();
    if (paramBundle != null) {
      this.p2 = paramBundle.getBoolean("EXTRA_DISMISSED");
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (this.x == null) {
      this.x = paramLayoutInflater;
    }
    W0();
    if (this.f != null)
    {
      paramLayoutInflater = (ViewGroup)getActivity().getWindow().getDecorView();
      paramLayoutInflater.removeView(this.f);
      paramLayoutInflater.addView(this.f);
      paramLayoutInflater = this.p3;
      if (paramLayoutInflater != null) {
        paramLayoutInflater.a(this, this.f);
      }
    }
    return this.f;
  }
  
  public void onDestroyView()
  {
    if (this.H3)
    {
      localObject = this.f;
      if (localObject != null) {
        ((View)localObject).startAnimation(P0());
      }
    }
    Object localObject = this.p3;
    if (localObject != null) {
      ((c)localObject).b(this, this.f);
    }
    localObject = this.f;
    if (localObject != null) {
      ((View)localObject).postDelayed(new m(this), this.K3);
    }
    this.p2 = true;
    super.onDestroyView();
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      if (TPBlurWindow.A0(TPBlurWindow.this)) {
        TPBlurWindow.B0(TPBlurWindow.this);
      }
      if (TPBlurWindow.C0(TPBlurWindow.this) != null)
      {
        int i = TPBlurWindow.G0(TPBlurWindow.this).getHeight();
        int j = TPBlurWindow.C0(TPBlurWindow.this).getHeight();
        TPBlurWindow.H0(TPBlurWindow.this).setPadding(0, (i - j) * 2, 0, 0);
        TPBlurWindow.C0(TPBlurWindow.this).setDrawingCacheEnabled(true);
        TPBlurWindow.C0(TPBlurWindow.this).buildDrawingCache();
        localObject = TPBlurWindow.C0(TPBlurWindow.this).getDrawingCache();
      }
      else
      {
        localObject = TPBlurWindow.I0(TPBlurWindow.this).getWindow().getDecorView();
        ((View)localObject).setDrawingCacheEnabled(true);
        ((View)localObject).buildDrawingCache();
        localObject = ((View)localObject).getDrawingCache();
      }
      Bitmap localBitmap = Bitmap.createBitmap((int)(TPBlurWindow.J0(TPBlurWindow.this).getMeasuredWidth() / TPBlurWindow.K0(TPBlurWindow.this)), (int)(TPBlurWindow.J0(TPBlurWindow.this).getMeasuredHeight() / TPBlurWindow.K0(TPBlurWindow.this)), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.translate(-TPBlurWindow.J0(TPBlurWindow.this).getLeft() / TPBlurWindow.K0(TPBlurWindow.this), -TPBlurWindow.J0(TPBlurWindow.this).getTop() / TPBlurWindow.K0(TPBlurWindow.this));
      localCanvas.scale(1.0F / TPBlurWindow.K0(TPBlurWindow.this), 1.0F / TPBlurWindow.K0(TPBlurWindow.this));
      Paint localPaint = new Paint();
      localPaint.setFlags(2);
      localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, localPaint);
      Object localObject = NativeStackBlur.process(localBitmap, (int)TPBlurWindow.L0(TPBlurWindow.this));
      TPBlurWindow.H0(TPBlurWindow.this).setImageDrawable(new BitmapDrawable(TPBlurWindow.I0(TPBlurWindow.this).getResources(), (Bitmap)localObject));
      TPBlurWindow.N0(TPBlurWindow.this).getViewTreeObserver().removeOnPreDrawListener(this);
      if (TPBlurWindow.C0(TPBlurWindow.this) != null) {
        TPBlurWindow.C0(TPBlurWindow.this).setDrawingCacheEnabled(false);
      } else {
        TPBlurWindow.I0(TPBlurWindow.this).getWindow().getDecorView().setDrawingCacheEnabled(false);
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPBlurWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */