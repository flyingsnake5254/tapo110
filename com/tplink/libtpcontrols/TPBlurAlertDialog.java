package com.tplink.libtpcontrols;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.w.f.a;
import com.andexert.library.RippleView;
import com.commit451.nativestackblur.NativeStackBlur;
import com.tplink.libtpcontrols.z0.b;

public class TPBlurAlertDialog
  extends Fragment
  implements View.OnClickListener
{
  private com.tplink.libtpcontrols.z0.g H3 = null;
  private CharSequence I3 = null;
  private int J3 = -1;
  private int K3 = -1;
  private com.tplink.libtpcontrols.z0.g L3 = null;
  private CharSequence M3 = null;
  private View N3 = null;
  private LayoutInflater O3 = null;
  private Activity P3 = null;
  private TextView Q3 = null;
  private TextView R3 = null;
  private TextView S3 = null;
  private TextView T3 = null;
  private View U3 = null;
  private View V3 = null;
  private ImageView W3 = null;
  private int X3 = 0;
  private int Y3 = 150;
  private View Z3 = null;
  private LinearLayout a4 = null;
  private boolean b4 = true;
  private FragmentManager c = null;
  private RippleView c4 = null;
  private CharSequence d = null;
  private RippleView d4 = null;
  private boolean e4 = true;
  private int f = -1;
  private Bitmap f4 = null;
  private b g4 = null;
  private boolean h4 = true;
  private boolean i4 = true;
  private boolean j4 = false;
  private boolean k4 = false;
  private boolean l4 = false;
  private boolean m4 = true;
  private boolean n4 = true;
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
    int i = a.e(this.P3);
    final int j = a.c(this.P3);
    int k = this.V3.getHeight();
    Object localObject;
    if (i > 0)
    {
      i = j - i - k - a.a(this.P3, 20.0F);
      k = (j - k) / 2;
      j = i;
      if (i > k) {
        j = k;
      }
      localObject = new int[2];
      this.V3.getLocationOnScreen((int[])localObject);
      j -= localObject[1];
      if (this.n4)
      {
        this.V3.setTranslationY(j);
        this.n4 = false;
        this.V3.post(new i(this, j));
        return;
      }
      localObject = ObjectAnimator.ofFloat(this.V3, "translationY", new float[] { 0.0F, j });
    }
    else
    {
      j = (j - k) / 2;
      localObject = new int[2];
      this.V3.getLocationOnScreen((int[])localObject);
      j -= localObject[1];
      localObject = ObjectAnimator.ofFloat(this.V3, "translationY", new float[] { -j, 0.0F });
      ((ObjectAnimator)localObject).setStartDelay(50L);
    }
    ((ObjectAnimator)localObject).addListener(new b(j));
    ((ObjectAnimator)localObject).setDuration(250L);
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
    if ((this.Q3.getVisibility() == 0) && (8 == this.R3.getVisibility()) && (this.p0 == -1)) {
      this.Q3.setPadding(a.a(this.P3, 35.0F), a.a(this.P3, 23.0F), a.a(this.P3, 35.0F), a.a(this.P3, 19.0F));
    }
    if ((this.Q3.getVisibility() == 0) && (this.R3.getVisibility() == 0) && (this.p0 == -1))
    {
      this.Q3.setPadding(a.a(this.P3, 35.0F), a.a(this.P3, 18.0F), a.a(this.P3, 35.0F), a.a(this.P3, 14.0F));
      this.R3.setPadding(a.a(this.P3, 15.0F), 0, a.a(this.P3, 18.0F), a.a(this.P3, 14.0F));
    }
    if ((8 == this.Q3.getVisibility()) && (this.R3.getVisibility() == 0) && (this.p0 == -1)) {
      this.R3.setPadding(a.a(this.P3, 15.0F), a.a(this.P3, 29.0F), a.a(this.P3, 18.0F), a.a(this.P3, 29.0F));
    }
    if ((this.Q3.getVisibility() == 0) && (8 == this.R3.getVisibility()) && (this.p0 != -1))
    {
      this.Q3.setPadding(a.a(this.P3, 35.0F), a.a(this.P3, 23.0F), a.a(this.P3, 35.0F), a.a(this.P3, 19.0F));
      this.a4.setPadding(0, 0, 0, a.a(this.P3, 19.0F));
    }
    if ((8 == this.Q3.getVisibility()) && (this.R3.getVisibility() == 0) && (this.p0 != -1))
    {
      this.R3.setPadding(a.a(this.P3, 15.0F), a.a(this.P3, 18.0F), a.a(this.P3, 15.0F), a.a(this.P3, 19.0F));
      this.a4.setPadding(0, 0, 0, a.a(this.P3, 19.0F));
    }
    if ((this.Q3.getVisibility() == 0) && (this.R3.getVisibility() == 0) && (this.p0 != -1))
    {
      this.Q3.setPadding(a.a(this.P3, 35.0F), a.a(this.P3, 18.0F), a.a(this.P3, 35.0F), a.a(this.P3, 14.0F));
      this.R3.setPadding(a.a(this.P3, 15.0F), 0, a.a(this.P3, 18.0F), a.a(this.P3, 14.0F));
      this.a4.setPadding(0, 0, 0, a.a(this.P3, 19.0F));
    }
    if ((8 == this.Q3.getVisibility()) && (8 == this.R3.getVisibility()) && (this.p0 != -1)) {
      this.a4.setPadding(0, a.a(this.P3, 19.0F), 0, a.a(this.P3, 19.0F));
    }
  }
  
  private void L0()
  {
    if (!TextUtils.isEmpty(this.d))
    {
      this.Q3.setText(this.d);
    }
    else
    {
      i = this.f;
      if (i != -1) {
        this.Q3.setText(i);
      } else {
        this.Q3.setVisibility(8);
      }
    }
    if (!TextUtils.isEmpty(this.x))
    {
      this.R3.setText(this.x);
    }
    else
    {
      i = this.y;
      if (i != -1) {
        this.R3.setText(i);
      } else {
        this.R3.setVisibility(8);
      }
    }
    if (this.l4)
    {
      this.c4.setVisibility(0);
      if (!TextUtils.isEmpty(this.I3))
      {
        this.T3.setText(this.I3);
      }
      else
      {
        i = this.p2;
        if (i != -1) {
          this.T3.setText(i);
        }
      }
      i = this.p3;
      if (i != -1) {
        this.T3.setTextColor(ContextCompat.getColorStateList(this.P3, i));
      }
      if (this.H3 != null) {
        this.c4.setOnRippleCompleteListener(new d(this));
      }
    }
    else
    {
      this.c4.setVisibility(8);
      this.Z3.setVisibility(8);
    }
    if (this.k4)
    {
      this.d4.setVisibility(0);
      if (!TextUtils.isEmpty(this.M3))
      {
        this.S3.setText(this.M3);
      }
      else
      {
        i = this.J3;
        if (i != -1) {
          this.S3.setText(i);
        }
      }
      i = this.K3;
      if (i != -1) {
        this.S3.setTextColor(ContextCompat.getColorStateList(this.P3, i));
      }
      if (this.L3 != null) {
        this.d4.setOnRippleCompleteListener(new h(this));
      }
    }
    else
    {
      this.d4.setVisibility(8);
      this.Z3.setVisibility(8);
    }
    int i = this.q;
    if (i != -1) {
      this.Q3.setTextColor(ContextCompat.getColorStateList(this.P3, i));
    }
    i = this.z;
    if (i != -1) {
      this.R3.setTextColor(ContextCompat.getColorStateList(this.P3, i));
    }
    View localView = this.p1;
    if (localView != null)
    {
      this.a4.addView(localView);
    }
    else
    {
      i = this.p0;
      if (i != -1)
      {
        this.O3.inflate(i, this.a4, true);
        this.p1 = this.a4.getChildAt(0);
      }
    }
    this.N3.setOnKeyListener(new g(this));
    K0();
  }
  
  private void N0()
  {
    O0(0);
  }
  
  private void O0(int paramInt)
  {
    P0(this.V3, this.f4, this.W3, paramInt);
  }
  
  private void P0(View paramView, Bitmap paramBitmap, ImageView paramImageView, int paramInt)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      int i = a.c(this.P3);
      int j = paramBitmap.getHeight();
      Object localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      localObject[1] -= i - j;
      localObject[1] -= paramInt;
      localObject = Bitmap.createBitmap(paramBitmap, localObject[0], localObject[1], paramView.getWidth(), paramView.getHeight());
      paramView = new android/graphics/Canvas;
      paramView.<init>((Bitmap)localObject);
      paramBitmap = new android/graphics/Paint;
      paramBitmap.<init>();
      paramBitmap.setFlags(2);
      paramView.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, paramBitmap);
      paramBitmap = NativeStackBlur.process((Bitmap)localObject, this.Y3);
      paramView = new android/graphics/drawable/BitmapDrawable;
      paramView.<init>(this.P3.getResources(), paramBitmap);
      paramImageView.setImageDrawable(paramView);
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private Animation Q0()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(400L);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  private void S0()
  {
    View localView = this.U3;
    if (localView == null) {
      localView = this.P3.getWindow().getDecorView();
    }
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    this.f4 = localView.getDrawingCache();
  }
  
  private void T0()
  {
    Object localObject = this.f4;
    if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
      S0();
    }
    this.Q3 = ((TextView)this.N3.findViewById(s0.dialog_title_tv));
    this.R3 = ((TextView)this.N3.findViewById(s0.dialog_message_tv));
    localObject = (TextView)this.N3.findViewById(s0.dialog_left_button_tv);
    this.S3 = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    this.S3.setEnabled(this.i4);
    localObject = (TextView)this.N3.findViewById(s0.dialog_right_button_tv);
    this.T3 = ((TextView)localObject);
    ((TextView)localObject).setOnClickListener(this);
    this.T3.setEnabled(this.h4);
    this.V3 = this.N3.findViewById(s0.dialog_container_rl);
    this.Z3 = this.N3.findViewById(s0.dialog_button_divider);
    this.W3 = ((ImageView)this.N3.findViewById(s0.dialog_blur_bg_iv));
    this.a4 = ((LinearLayout)this.N3.findViewById(s0.dialog_customer_view_container_ll));
    localObject = (RippleView)this.N3.findViewById(s0.dialog_positive_button_container_rv);
    this.c4 = ((RippleView)localObject);
    ((RelativeLayout)localObject).setEnabled(this.h4);
    localObject = (RippleView)this.N3.findViewById(s0.dialog_negative_button_container_rv);
    this.d4 = ((RippleView)localObject);
    ((RelativeLayout)localObject).setEnabled(this.i4);
    this.N3.setOnClickListener(this);
    L0();
  }
  
  public void R0(boolean paramBoolean)
  {
    this.j4 = paramBoolean;
    if (this.e4) {
      return;
    }
    this.e4 = true;
    new Handler().post(new e(this));
  }
  
  public void dismiss()
  {
    R0(true);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == s0.blur_alert_dialog_root_view) && (this.b4)) {
      dismiss();
    }
    paramView.getId();
    paramView.getId();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.P3 = getActivity();
    if (paramBundle != null) {
      this.e4 = paramBundle.getBoolean("EXTRA_DISMISSED");
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (this.O3 == null) {
      this.O3 = paramLayoutInflater;
    }
    this.N3 = paramLayoutInflater.inflate(t0.tpblur_alert_dialog_main, paramViewGroup, true);
    T0();
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(this.N3);
    this.N3.getViewTreeObserver().addOnPreDrawListener(new a());
    this.N3.getViewTreeObserver().addOnGlobalLayoutListener(new f(this));
    paramLayoutInflater = this.g4;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.b(this, this.N3);
    }
    return this.N3;
  }
  
  public void onDestroyView()
  {
    a.g(this.P3);
    if (this.j4) {
      this.N3.postDelayed(new j(this), 200L);
    } else {
      ((ViewGroup)this.P3.getWindow().getDecorView()).removeView(this.N3);
    }
    b localb = this.g4;
    if (localb != null) {
      localb.a(this, this.N3);
    }
    this.e4 = true;
    super.onDestroyView();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("EXTRA_DISMISSED", this.e4);
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      TPBlurAlertDialog.A0(TPBlurAlertDialog.this);
      TPBlurAlertDialog.B0(TPBlurAlertDialog.this);
      TPBlurAlertDialog.C0(TPBlurAlertDialog.this).getViewTreeObserver().removeOnPreDrawListener(this);
      return true;
    }
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b(int paramInt) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      TPBlurAlertDialog.H0(TPBlurAlertDialog.this, -j);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      TPBlurAlertDialog.H0(TPBlurAlertDialog.this, -j);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      paramAnimator = ObjectAnimator.ofFloat(TPBlurAlertDialog.G0(TPBlurAlertDialog.this), "alpha", new float[] { 0.0F, 1.0F });
      paramAnimator.setDuration(250L);
      paramAnimator.start();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPBlurAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */