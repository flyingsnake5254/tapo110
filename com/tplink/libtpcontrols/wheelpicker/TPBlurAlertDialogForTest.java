package com.tplink.libtpcontrols.wheelpicker;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.commit451.nativestackblur.NativeStackBlur;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;

public class TPBlurAlertDialogForTest
  extends Fragment
{
  private View.OnClickListener H3 = null;
  private CharSequence I3 = null;
  private int J3 = -1;
  private int K3 = -1;
  private View.OnClickListener L3 = null;
  private CharSequence M3 = null;
  private View N3 = null;
  private LayoutInflater O3 = null;
  private Activity P3 = null;
  private ImageView Q3 = null;
  private ImageView R3 = null;
  private ImageView S3 = null;
  private TextView T3 = null;
  private TextView U3 = null;
  private TextView V3 = null;
  private TextView W3 = null;
  private View X3 = null;
  private View Y3 = null;
  private ImageView Z3 = null;
  private int a4 = 0;
  private Bitmap b4;
  private FragmentManager c = null;
  private boolean c4 = false;
  private CharSequence d = null;
  private int f = -1;
  private int p0 = -1;
  private View p1 = null;
  private int p2 = -1;
  private int p3 = -1;
  private int q = -1;
  private CharSequence x = null;
  private int y = -1;
  private int z = -1;
  
  private void I0()
  {
    int i = b.d.w.f.a.e(this.P3);
    int j = b.d.w.f.a.c(this.P3);
    int k = this.Y3.getHeight();
    Object localObject;
    if (i > 0)
    {
      int m = b.d.w.f.a.a(this.P3, 20.0F);
      int n = this.Y3.getTop();
      localObject = ObjectAnimator.ofFloat(this.Y3, "translationY", new float[] { 0.0F, j - i - k - m - n });
    }
    else
    {
      i = (j - k) / 2;
      localObject = new int[2];
      this.Y3.getLocationOnScreen((int[])localObject);
      k = localObject[1];
      localObject = ObjectAnimator.ofFloat(this.Y3, "translationY", new float[] { -(i - k), 0.0F });
    }
    ((ObjectAnimator)localObject).addListener(new b());
    ((ObjectAnimator)localObject).setDuration(150L);
    ((ObjectAnimator)localObject).start();
  }
  
  private void J0()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.N3, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(400L);
    localObjectAnimator.start();
  }
  
  private void K0()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = this.X3;
    if (localObject == null) {
      localObject = this.P3.getWindow().getDecorView();
    }
    ((View)localObject).setDrawingCacheEnabled(true);
    if (!this.c4) {
      ((View)localObject).buildDrawingCache();
    }
    Bitmap localBitmap = ((View)localObject).getDrawingCache();
    this.b4 = localBitmap;
    N0(this.Y3, localBitmap, this.Z3);
    ((View)localObject).setDrawingCacheEnabled(false);
    long l2 = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Blur time = ");
    ((StringBuilder)localObject).append(l2 - l1);
    b.d.w.c.a.e("TPBlurAlertDialog", ((StringBuilder)localObject).toString());
  }
  
  private void L0(Bitmap paramBitmap)
  {
    Bitmap localBitmap = this.b4;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      N0(this.Y3, paramBitmap, this.Z3);
    } else {
      K0();
    }
  }
  
  private void N0(View paramView, Bitmap paramBitmap, ImageView paramImageView)
  {
    int i = b.d.w.f.a.c(this.P3);
    int j = paramBitmap.getHeight();
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    localObject[1] -= i - j;
    paramView = Bitmap.createBitmap(paramBitmap, localObject[0], localObject[1], paramView.getWidth(), paramView.getHeight());
    paramBitmap = new Canvas(paramView);
    localObject = new Paint();
    ((Paint)localObject).setFlags(2);
    paramBitmap.drawBitmap(paramView, 0.0F, 0.0F, (Paint)localObject);
    paramView = NativeStackBlur.process(paramView, 100);
    paramImageView.setImageDrawable(new BitmapDrawable(getResources(), paramView));
  }
  
  private void O0()
  {
    View localView = this.N3;
    int i = s0.dialog_title_tv;
    this.T3 = ((TextView)localView.findViewById(i));
    this.U3 = ((TextView)this.N3.findViewById(i));
    this.V3 = ((TextView)this.N3.findViewById(s0.dialog_left_button_tv));
    this.W3 = ((TextView)this.N3.findViewById(s0.dialog_right_button_tv));
    this.Y3 = this.N3.findViewById(s0.dialog_container_rl);
    this.Z3 = ((ImageView)this.N3.findViewById(s0.dialog_blur_bg_iv));
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.P3 = getActivity();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (this.O3 == null) {
      this.O3 = paramLayoutInflater;
    }
    this.N3 = paramLayoutInflater.inflate(t0.tpblur_alert_dialog_main, paramViewGroup, true);
    O0();
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(this.N3);
    this.N3.getViewTreeObserver().addOnPreDrawListener(new a());
    this.N3.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    return this.N3;
  }
  
  public void onDestroyView()
  {
    ((ViewGroup)this.P3.getWindow().getDecorView()).removeView(this.N3);
    super.onDestroyView();
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      TPBlurAlertDialogForTest.A0(TPBlurAlertDialogForTest.this);
      TPBlurAlertDialogForTest.B0(TPBlurAlertDialogForTest.this);
      TPBlurAlertDialogForTest.C0(TPBlurAlertDialogForTest.this).getViewTreeObserver().removeOnPreDrawListener(this);
      return true;
    }
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = TPBlurAlertDialogForTest.this;
      TPBlurAlertDialogForTest.H0(paramAnimator, TPBlurAlertDialogForTest.G0(paramAnimator));
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpicker\TPBlurAlertDialogForTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */