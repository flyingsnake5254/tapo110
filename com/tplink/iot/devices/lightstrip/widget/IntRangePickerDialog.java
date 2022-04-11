package com.tplink.iot.devices.lightstrip.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tplink.iot.databinding.DialogIntRangePickerBinding;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.iot.widget.NumberPickerView.d;
import com.tplink.iot.widget.bottomsheet.dialog.BaseBottomSheetDialog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.l;
import kotlin.collections.z;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.v.d;

public final class IntRangePickerDialog
  extends BaseBottomSheetDialog<DialogIntRangePickerBinding>
{
  public static final a p1 = new a(null);
  private b H3;
  private HashMap I3;
  private int p2;
  private int p3 = 100;
  
  private final int a1(int paramInt)
  {
    paramInt = l.S(f1()).indexOf(Integer.valueOf(paramInt));
    if (paramInt == -1) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private final int b1(int paramInt)
  {
    Integer localInteger = (Integer)l.z(l.S(f1()), paramInt);
    if (localInteger != null) {
      paramInt = localInteger.intValue();
    } else {
      paramInt = this.p2;
    }
    return paramInt;
  }
  
  private final void c1()
  {
    this.p2 = Math.max(0, this.p2);
    int i = Math.max(0, this.p3);
    this.p3 = i;
    if (this.p2 > i) {
      this.p2 = i;
    }
  }
  
  private final String[] d1()
  {
    Object localObject1 = f1();
    Object localObject2 = new ArrayList(l.l((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Collection)localObject2).add(String.valueOf(((z)localObject1).nextInt()));
    }
    localObject2 = ((Collection)localObject2).toArray(new String[0]);
    Objects.requireNonNull(localObject2, "null cannot be cast to non-null type kotlin.Array<T>");
    return (String[])localObject2;
  }
  
  private final int e1()
  {
    NumberPickerView localNumberPickerView = ((DialogIntRangePickerBinding)O0()).f;
    j.d(localNumberPickerView, "mBinding.numberPickerEnd");
    return b1(localNumberPickerView.getValue());
  }
  
  private final d f1()
  {
    c1();
    return new d(this.p2, this.p3);
  }
  
  private final int g1()
  {
    NumberPickerView localNumberPickerView = ((DialogIntRangePickerBinding)O0()).q;
    j.d(localNumberPickerView, "mBinding.numberPickerStart");
    return b1(localNumberPickerView.getValue());
  }
  
  private final void h1(int paramInt)
  {
    NumberPickerView localNumberPickerView = ((DialogIntRangePickerBinding)O0()).f;
    j.d(localNumberPickerView, "mBinding.numberPickerEnd");
    localNumberPickerView.setValue(a1(paramInt));
  }
  
  private final void j1(int paramInt)
  {
    NumberPickerView localNumberPickerView = ((DialogIntRangePickerBinding)O0()).q;
    j.d(localNumberPickerView, "mBinding.numberPickerStart");
    localNumberPickerView.setValue(a1(paramInt));
  }
  
  public void A0()
  {
    HashMap localHashMap = this.I3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int L0()
  {
    return 2131558798;
  }
  
  public void Q0()
  {
    ((DialogIntRangePickerBinding)O0()).q.S(d1());
    ((DialogIntRangePickerBinding)O0()).f.S(d1());
    ((DialogIntRangePickerBinding)O0()).q.setOnValueChangedListener(new c(this));
    ((DialogIntRangePickerBinding)O0()).f.setOnValueChangedListener(new d(this));
    ((DialogIntRangePickerBinding)O0()).c.setOnClickListener(new e(this));
    ((DialogIntRangePickerBinding)O0()).d.setOnClickListener(new f(this));
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      j1(localBundle.getInt("ArgInitStartInt", this.p2));
      h1(localBundle.getInt("ArgInitEndInt", this.p3));
    }
  }
  
  public final void i1(b paramb)
  {
    j.e(paramb, "listener");
    this.H3 = paramb;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.p2 = paramBundle.getInt("ArgMinInt", 0);
      this.p3 = paramBundle.getInt("ArgMaxInt", 100);
    }
    c1();
  }
  
  public static final class a
  {
    public final IntRangePickerDialog a(int paramInt1, int paramInt2, Pair<Integer, Integer> paramPair)
    {
      IntRangePickerDialog localIntRangePickerDialog = new IntRangePickerDialog();
      Bundle localBundle = new Bundle();
      localBundle.putInt("ArgMinInt", paramInt1);
      localBundle.putInt("ArgMaxInt", paramInt2);
      if (paramPair != null)
      {
        localBundle.putInt("ArgInitStartInt", ((Number)paramPair.getFirst()).intValue());
        localBundle.putInt("ArgInitEndInt", ((Number)paramPair.getSecond()).intValue());
      }
      paramPair = p.a;
      localIntRangePickerDialog.setArguments(localBundle);
      return localIntRangePickerDialog;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
  
  static final class c
    implements NumberPickerView.d
  {
    c(IntRangePickerDialog paramIntRangePickerDialog) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      paramInt2 = IntRangePickerDialog.U0(this.c, paramInt2);
      paramInt1 = IntRangePickerDialog.V0(this.c);
      if (paramInt2 > paramInt1) {
        IntRangePickerDialog.Z0(this.c, paramInt1);
      }
    }
  }
  
  static final class d
    implements NumberPickerView.d
  {
    d(IntRangePickerDialog paramIntRangePickerDialog) {}
    
    public final void a(NumberPickerView paramNumberPickerView, int paramInt1, int paramInt2)
    {
      paramInt1 = IntRangePickerDialog.X0(this.c);
      if (IntRangePickerDialog.U0(this.c, paramInt2) < paramInt1) {
        IntRangePickerDialog.Y0(this.c, paramInt1);
      }
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(IntRangePickerDialog paramIntRangePickerDialog) {}
    
    public final void onClick(View paramView)
    {
      this.c.dismissAllowingStateLoss();
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(IntRangePickerDialog paramIntRangePickerDialog) {}
    
    public final void onClick(View paramView)
    {
      int i = IntRangePickerDialog.V0(this.c);
      int j = Math.min(IntRangePickerDialog.X0(this.c), i);
      paramView = IntRangePickerDialog.W0(this.c);
      if (paramView != null) {
        paramView.a(j, i);
      }
      this.c.dismissAllowingStateLoss();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\IntRangePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */