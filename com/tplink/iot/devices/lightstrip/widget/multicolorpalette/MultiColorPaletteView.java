package com.tplink.iot.devices.lightstrip.widget.multicolorpalette;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class MultiColorPaletteView
  extends MultiColorSpectrumPickerView
{
  private List<c> Y3 = new ArrayList();
  private boolean Z3;
  
  public MultiColorPaletteView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public MultiColorPaletteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public MultiColorPaletteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void K(boolean paramBoolean)
  {
    this.Z3 = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiColorPaletteView#markHasChangedOrigin: ");
    localStringBuilder.append(this.Z3);
    b.d.w.c.a.n("LightStrip", localStringBuilder.toString());
  }
  
  protected void B(a parama, boolean paramBoolean)
  {
    super.B(parama, paramBoolean);
    if (paramBoolean) {
      K(true);
    }
  }
  
  public final void H(c paramc)
  {
    j.e(paramc, "hsb");
    K(true);
    a(paramc.d());
    invalidate();
  }
  
  public final void I()
  {
    K(true);
    H(c.b.a());
  }
  
  public final void J(int paramInt)
  {
    if (paramInt > 0)
    {
      K(true);
      for (int i = 0; i < paramInt; i++) {
        I();
      }
    }
  }
  
  public final void L()
  {
    K(true);
    C();
    invalidate();
  }
  
  public final List<Integer> getColors()
  {
    if (this.Z3)
    {
      localObject = getSelectedValues();
      j.d(localObject, "selectedValues");
      localArrayList = new ArrayList(l.l((Iterable)localObject, 10));
      localIterator = ((Iterable)localObject).iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (float[])localIterator.next();
        j.d(localObject, "it");
        localArrayList.add(Integer.valueOf(new c((float[])localObject).g()));
      }
    }
    Object localObject = this.Y3;
    ArrayList localArrayList = new ArrayList(l.l((Iterable)localObject, 10));
    Iterator localIterator = ((Iterable)localObject).iterator();
    for (;;)
    {
      localObject = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(Integer.valueOf(((c)localIterator.next()).g()));
    }
    return (List<Integer>)localObject;
  }
  
  public final List<c> getHSBColors()
  {
    if (this.Z3)
    {
      localObject = getSelectedValues();
      j.d(localObject, "selectedValues");
      ArrayList localArrayList = new ArrayList(l.l((Iterable)localObject, 10));
      Iterator localIterator = ((Iterable)localObject).iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (float[])localIterator.next();
        j.d(localObject, "it");
        localArrayList.add(new c((float[])localObject));
      }
    }
    Object localObject = this.Y3;
    return (List<c>)localObject;
  }
  
  public final List<d> getRGBColors()
  {
    if (this.Z3)
    {
      localObject = getSelectedValues();
      j.d(localObject, "selectedValues");
      localArrayList = new ArrayList(l.l((Iterable)localObject, 10));
      localIterator = ((Iterable)localObject).iterator();
      for (;;)
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (float[])localIterator.next();
        j.d(localObject, "it");
        localArrayList.add(new c((float[])localObject).i());
      }
    }
    Object localObject = this.Y3;
    ArrayList localArrayList = new ArrayList(l.l((Iterable)localObject, 10));
    Iterator localIterator = ((Iterable)localObject).iterator();
    for (;;)
    {
      localObject = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(((c)localIterator.next()).i());
    }
    return (List<d>)localObject;
  }
  
  public final void setColors(List<Integer> paramList)
  {
    j.e(paramList, "colors");
    K(true);
    ArrayList localArrayList = new ArrayList(l.l(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      paramList = d.a.a(i).c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setColors: ");
      localStringBuilder.append(paramList);
      Log.e("TAG", localStringBuilder.toString());
      localArrayList.add(paramList);
    }
    setCursors(localArrayList);
    invalidate();
  }
  
  public final void setHSBColors(List<c> paramList)
  {
    j.e(paramList, "colors");
    K(true);
    setCursors(paramList);
    invalidate();
  }
  
  public final void setOriginHSBColors(final List<c> paramList)
  {
    j.e(paramList, "colors");
    K(false);
    this.Y3.clear();
    this.Y3.addAll(paramList);
    post(new a(this, paramList));
  }
  
  static final class a
    implements Runnable
  {
    a(MultiColorPaletteView paramMultiColorPaletteView, List paramList) {}
    
    public final void run()
    {
      this.c.setCursors(paramList);
      this.c.invalidate();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\widget\multicolorpalette\MultiColorPaletteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */