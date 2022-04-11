package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride;
import com.google.android.exoplayer2.trackselection.i.a;
import com.google.android.exoplayer2.util.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class TrackSelectionView
  extends LinearLayout
{
  private int H3;
  private TrackGroupArray I3;
  private boolean J3;
  @Nullable
  private Comparator<c> K3;
  @Nullable
  private d L3;
  private final int c;
  private final LayoutInflater d;
  private final CheckedTextView f;
  private boolean p0;
  private z0 p1;
  private CheckedTextView[][] p2;
  private i.a p3;
  private final CheckedTextView q;
  private final b x;
  private final SparseArray<DefaultTrackSelector.SelectionOverride> y;
  private boolean z;
  
  public TrackSelectionView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TrackSelectionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TrackSelectionView(Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    this.y = new SparseArray();
    setSaveFromParentEnabled(false);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(new int[] { 16843534 });
    paramInt = paramAttributeSet.getResourceId(0, 0);
    this.c = paramInt;
    paramAttributeSet.recycle();
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    this.d = localLayoutInflater;
    paramContext = new b(null);
    this.x = paramContext;
    this.p1 = new g0(getResources());
    this.I3 = TrackGroupArray.c;
    paramAttributeSet = (CheckedTextView)localLayoutInflater.inflate(17367055, this, false);
    this.f = paramAttributeSet;
    paramAttributeSet.setBackgroundResource(paramInt);
    paramAttributeSet.setText(r0.exo_track_selection_none);
    paramAttributeSet.setEnabled(false);
    paramAttributeSet.setFocusable(true);
    paramAttributeSet.setOnClickListener(paramContext);
    paramAttributeSet.setVisibility(8);
    addView(paramAttributeSet);
    addView(localLayoutInflater.inflate(p0.exo_list_divider, this, false));
    paramAttributeSet = (CheckedTextView)localLayoutInflater.inflate(17367055, this, false);
    this.q = paramAttributeSet;
    paramAttributeSet.setBackgroundResource(paramInt);
    paramAttributeSet.setText(r0.exo_track_selection_auto);
    paramAttributeSet.setEnabled(false);
    paramAttributeSet.setFocusable(true);
    paramAttributeSet.setOnClickListener(paramContext);
    addView(paramAttributeSet);
  }
  
  private static int[] b(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length + 1);
    paramArrayOfInt[(paramArrayOfInt.length - 1)] = paramInt;
    return paramArrayOfInt;
  }
  
  private static int[] c(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length - 1];
    int i = paramArrayOfInt.length;
    int j = 0;
    int n;
    for (int k = 0; j < i; k = n)
    {
      int m = paramArrayOfInt[j];
      n = k;
      if (m != paramInt)
      {
        arrayOfInt[k] = m;
        n = k + 1;
      }
      j++;
    }
    return arrayOfInt;
  }
  
  private void d(View paramView)
  {
    if (paramView == this.f) {
      f();
    } else if (paramView == this.q) {
      e();
    } else {
      g(paramView);
    }
    j();
    paramView = this.L3;
    if (paramView != null) {
      paramView.a(getIsDisabled(), getOverrides());
    }
  }
  
  private void e()
  {
    this.J3 = false;
    this.y.clear();
  }
  
  private void f()
  {
    this.J3 = true;
    this.y.clear();
  }
  
  private void g(View paramView)
  {
    this.J3 = false;
    Object localObject = (c)g.e(paramView.getTag());
    int i = ((c)localObject).a;
    int j = ((c)localObject).b;
    localObject = (DefaultTrackSelector.SelectionOverride)this.y.get(i);
    g.e(this.p3);
    if (localObject == null)
    {
      if ((!this.p0) && (this.y.size() > 0)) {
        this.y.clear();
      }
      this.y.put(i, new DefaultTrackSelector.SelectionOverride(i, new int[] { j }));
    }
    else
    {
      int k = ((DefaultTrackSelector.SelectionOverride)localObject).f;
      localObject = ((DefaultTrackSelector.SelectionOverride)localObject).d;
      boolean bool1 = ((CheckedTextView)paramView).isChecked();
      boolean bool2 = h(i);
      int m;
      if ((!bool2) && (!i())) {
        m = 0;
      } else {
        m = 1;
      }
      if ((bool1) && (m != 0))
      {
        if (k == 1)
        {
          this.y.remove(i);
        }
        else
        {
          paramView = c((int[])localObject, j);
          this.y.put(i, new DefaultTrackSelector.SelectionOverride(i, paramView));
        }
      }
      else if (!bool1) {
        if (bool2)
        {
          paramView = b((int[])localObject, j);
          this.y.put(i, new DefaultTrackSelector.SelectionOverride(i, paramView));
        }
        else
        {
          this.y.put(i, new DefaultTrackSelector.SelectionOverride(i, new int[] { j }));
        }
      }
    }
  }
  
  @RequiresNonNull({"mappedTrackInfo"})
  private boolean h(int paramInt)
  {
    boolean bool1 = this.z;
    boolean bool2 = true;
    if ((!bool1) || (this.I3.a(paramInt).c <= 1) || (this.p3.a(this.H3, paramInt, false) == 0)) {
      bool2 = false;
    }
    return bool2;
  }
  
  private boolean i()
  {
    boolean bool1 = this.p0;
    boolean bool2 = true;
    if ((!bool1) || (this.I3.d <= 1)) {
      bool2 = false;
    }
    return bool2;
  }
  
  private void j()
  {
    this.f.setChecked(this.J3);
    Object localObject1 = this.q;
    boolean bool;
    if ((!this.J3) && (this.y.size() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    ((CheckedTextView)localObject1).setChecked(bool);
    for (int i = 0; i < this.p2.length; i++)
    {
      localObject1 = (DefaultTrackSelector.SelectionOverride)this.y.get(i);
      for (int j = 0;; j++)
      {
        Object localObject2 = this.p2;
        if (j >= localObject2[i].length) {
          break;
        }
        if (localObject1 != null)
        {
          localObject2 = (c)g.e(localObject2[i][j].getTag());
          this.p2[i][j].setChecked(((DefaultTrackSelector.SelectionOverride)localObject1).a(((c)localObject2).b));
        }
        else
        {
          localObject2[i][j].setChecked(false);
        }
      }
    }
  }
  
  private void k()
  {
    for (int i = getChildCount() - 1; i >= 3; i--) {
      removeViewAt(i);
    }
    if (this.p3 == null)
    {
      this.f.setEnabled(false);
      this.q.setEnabled(false);
      return;
    }
    this.f.setEnabled(true);
    this.q.setEnabled(true);
    Object localObject1 = this.p3.e(this.H3);
    this.I3 = ((TrackGroupArray)localObject1);
    this.p2 = new CheckedTextView[((TrackGroupArray)localObject1).d][];
    boolean bool1 = i();
    for (i = 0;; i++)
    {
      localObject1 = this.I3;
      if (i >= ((TrackGroupArray)localObject1).d) {
        break;
      }
      Object localObject2 = ((TrackGroupArray)localObject1).a(i);
      boolean bool2 = h(i);
      localObject1 = this.p2;
      int j = ((TrackGroup)localObject2).c;
      localObject1[i] = new CheckedTextView[j];
      localObject1 = new c[j];
      for (int k = 0; k < ((TrackGroup)localObject2).c; k++) {
        localObject1[k] = new c(i, k, ((TrackGroup)localObject2).a(k));
      }
      localObject2 = this.K3;
      if (localObject2 != null) {
        Arrays.sort((Object[])localObject1, (Comparator)localObject2);
      }
      for (k = 0; k < j; k++)
      {
        if (k == 0) {
          addView(this.d.inflate(p0.exo_list_divider, this, false));
        }
        int m;
        if ((!bool2) && (!bool1)) {
          m = 17367055;
        } else {
          m = 17367056;
        }
        localObject2 = (CheckedTextView)this.d.inflate(m, this, false);
        ((CheckedTextView)localObject2).setBackgroundResource(this.c);
        ((CheckedTextView)localObject2).setText(this.p1.a(localObject1[k].c));
        ((CheckedTextView)localObject2).setTag(localObject1[k]);
        if (this.p3.f(this.H3, i, k) == 4)
        {
          ((CheckedTextView)localObject2).setFocusable(true);
          ((CheckedTextView)localObject2).setOnClickListener(this.x);
        }
        else
        {
          ((CheckedTextView)localObject2).setFocusable(false);
          ((CheckedTextView)localObject2).setEnabled(false);
        }
        this.p2[i][k] = localObject2;
        addView((View)localObject2);
      }
    }
    j();
  }
  
  public boolean getIsDisabled()
  {
    return this.J3;
  }
  
  public List<DefaultTrackSelector.SelectionOverride> getOverrides()
  {
    ArrayList localArrayList = new ArrayList(this.y.size());
    for (int i = 0; i < this.y.size(); i++) {
      localArrayList.add((DefaultTrackSelector.SelectionOverride)this.y.valueAt(i));
    }
    return localArrayList;
  }
  
  public void setAllowAdaptiveSelections(boolean paramBoolean)
  {
    if (this.z != paramBoolean)
    {
      this.z = paramBoolean;
      k();
    }
  }
  
  public void setAllowMultipleOverrides(boolean paramBoolean)
  {
    if (this.p0 != paramBoolean)
    {
      this.p0 = paramBoolean;
      if ((!paramBoolean) && (this.y.size() > 1)) {
        for (int i = this.y.size() - 1; i > 0; i--) {
          this.y.remove(i);
        }
      }
      k();
    }
  }
  
  public void setShowDisableOption(boolean paramBoolean)
  {
    CheckedTextView localCheckedTextView = this.f;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localCheckedTextView.setVisibility(i);
  }
  
  public void setTrackNameProvider(z0 paramz0)
  {
    this.p1 = ((z0)g.e(paramz0));
    k();
  }
  
  private class b
    implements View.OnClickListener
  {
    private b() {}
    
    public void onClick(View paramView)
    {
      TrackSelectionView.a(TrackSelectionView.this, paramView);
    }
  }
  
  private static final class c
  {
    public final int a;
    public final int b;
    public final Format c;
    
    public c(int paramInt1, int paramInt2, Format paramFormat)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramFormat;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, List<DefaultTrackSelector.SelectionOverride> paramList);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\TrackSelectionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */