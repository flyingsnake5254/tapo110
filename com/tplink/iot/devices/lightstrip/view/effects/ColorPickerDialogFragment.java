package com.tplink.iot.devices.lightstrip.view.effects;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.databinding.FragmentColorPickerDialogBinding;
import com.tplink.iot.widget.BrightnessSeekBar;
import com.tplink.iot.widget.bottomsheet.BottomSheetOptions;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import com.tplink.iot.widget.colorbulb.ColorPlateWrapView;
import com.tplink.iot.widget.colorbulb.c.a;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ColorPickerDialogFragment
  extends BaseBottomSheetDialog<FragmentColorPickerDialogBinding>
  implements a
{
  public static final a p1 = new a(null);
  @IntRange(from=0L, to=100L)
  private int H3;
  @IntRange(from=0L, to=360L)
  private int I3;
  @IntRange(from=0L, to=100L)
  private int J3;
  private boolean K3;
  private HashMap L3;
  private b p2;
  @IntRange(from=0L, to=360L)
  private int p3;
  
  private final void c1()
  {
    dismissAllowingStateLoss();
  }
  
  private final void d1()
  {
    int i = Color.HSVToColor(new float[] { this.p3, this.H3 / 100.0F, 1.0F });
    b localb = this.p2;
    if (localb != null) {
      localb.Q(i, this.p3, this.H3);
    }
    dismissAllowingStateLoss();
  }
  
  public void A0()
  {
    HashMap localHashMap = this.L3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int L0()
  {
    return 2131558913;
  }
  
  public BottomSheetOptions P0()
  {
    return new BottomSheetOptions().fullscreen(false).topRoundCorner(true);
  }
  
  public void Q0()
  {
    ((FragmentColorPickerDialogBinding)O0()).d.setOnColorUpdateListener(this);
    ((FragmentColorPickerDialogBinding)O0()).q.setOnClickListener(new c(this));
    ((FragmentColorPickerDialogBinding)O0()).f.setOnClickListener(new d(this));
    Object localObject = ((FragmentColorPickerDialogBinding)O0()).c;
    j.d(localObject, "mBinding.brightnessSeekBar");
    ((BrightnessSeekBar)localObject).setProgress(100);
    localObject = getArguments();
    if (localObject != null) {
      g1(((Bundle)localObject).getInt("InitColorArg"));
    }
    setCancelable(false);
  }
  
  public final int b1()
  {
    BrightnessSeekBar localBrightnessSeekBar = ((FragmentColorPickerDialogBinding)O0()).c;
    j.d(localBrightnessSeekBar, "mBinding.brightnessSeekBar");
    return localBrightnessSeekBar.getProgress();
  }
  
  public void d0(int paramInt, boolean paramBoolean)
  {
    this.K3 = paramBoolean;
    int i = (int)4278190080L;
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt | i, arrayOfFloat);
    this.p3 = ((int)arrayOfFloat[0]);
    this.H3 = ((int)(arrayOfFloat[1] * 100.0F));
  }
  
  public final void e1(final int paramInt)
  {
    if (BaseBottomSheetDialog.B0(this))
    {
      BrightnessSeekBar localBrightnessSeekBar = V0(this).c;
      j.d(localBrightnessSeekBar, "mBinding.brightnessSeekBar");
      localBrightnessSeekBar.setProgress(paramInt);
    }
    else
    {
      BaseBottomSheetDialog.C0(this).add(new e(this, paramInt));
    }
  }
  
  public final void f1(final boolean paramBoolean)
  {
    if (BaseBottomSheetDialog.B0(this))
    {
      LinearLayout localLinearLayout = V0(this).x;
      j.d(localLinearLayout, "mBinding.llBrightness");
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localLinearLayout.setVisibility(i);
      U0(this).setState(3);
    }
    else
    {
      BaseBottomSheetDialog.C0(this).add(new f(this, paramBoolean));
    }
  }
  
  public final void g1(@ColorInt final int paramInt)
  {
    if (BaseBottomSheetDialog.B0(this))
    {
      V0(this).d.setColor(paramInt);
      Y0(this, true);
    }
    else
    {
      BaseBottomSheetDialog.C0(this).add(new g(this, paramInt));
    }
  }
  
  public final void h1(@ColorInt final int paramInt1, final int paramInt2, final int paramInt3)
  {
    if (BaseBottomSheetDialog.B0(this))
    {
      V0(this).d.b(paramInt1, paramInt2, paramInt3);
      Y0(this, false);
      Z0(this, paramInt2);
      a1(this, paramInt3);
    }
    else
    {
      BaseBottomSheetDialog.C0(this).add(new h(this, paramInt1, paramInt2, paramInt3));
    }
  }
  
  public final void i1(b paramb)
  {
    j.e(paramb, "listener");
    this.p2 = paramb;
  }
  
  public static final class a
  {
    public final ColorPickerDialogFragment a(@ColorInt int paramInt)
    {
      ColorPickerDialogFragment localColorPickerDialogFragment = new ColorPickerDialogFragment();
      Bundle localBundle = new Bundle();
      localBundle.putInt("InitColorArg", paramInt);
      p localp = p.a;
      localColorPickerDialogFragment.setArguments(localBundle);
      return localColorPickerDialogFragment;
    }
  }
  
  public static abstract interface b
  {
    public abstract void Q(@ColorInt int paramInt1, int paramInt2, int paramInt3);
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(ColorPickerDialogFragment paramColorPickerDialogFragment) {}
    
    public final void onClick(View paramView)
    {
      ColorPickerDialogFragment.X0(this.c);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(ColorPickerDialogFragment paramColorPickerDialogFragment) {}
    
    public final void onClick(View paramView)
    {
      ColorPickerDialogFragment.W0(this.c);
    }
  }
  
  public static final class e
    implements Runnable
  {
    public e(ColorPickerDialogFragment paramColorPickerDialogFragment, int paramInt) {}
    
    public final void run()
    {
      BrightnessSeekBar localBrightnessSeekBar = ColorPickerDialogFragment.V0(this.c).c;
      j.d(localBrightnessSeekBar, "mBinding.brightnessSeekBar");
      localBrightnessSeekBar.setProgress(paramInt);
    }
  }
  
  public static final class f
    implements Runnable
  {
    public f(ColorPickerDialogFragment paramColorPickerDialogFragment, boolean paramBoolean) {}
    
    public final void run()
    {
      LinearLayout localLinearLayout = ColorPickerDialogFragment.V0(this.c).x;
      j.d(localLinearLayout, "mBinding.llBrightness");
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localLinearLayout.setVisibility(i);
      ColorPickerDialogFragment.U0(this.c).setState(3);
    }
  }
  
  public static final class g
    implements Runnable
  {
    public g(ColorPickerDialogFragment paramColorPickerDialogFragment, int paramInt) {}
    
    public final void run()
    {
      ColorPickerDialogFragment.V0(this.c).d.setColor(paramInt);
      ColorPickerDialogFragment.Y0(this.c, true);
    }
  }
  
  public static final class h
    implements Runnable
  {
    public h(ColorPickerDialogFragment paramColorPickerDialogFragment, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void run()
    {
      ColorPickerDialogFragment.V0(this.c).d.b(paramInt1, paramInt2, paramInt3);
      ColorPickerDialogFragment.Y0(this.c, false);
      ColorPickerDialogFragment.Z0(this.c, paramInt2);
      ColorPickerDialogFragment.a1(this.c, paramInt3);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\ColorPickerDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */