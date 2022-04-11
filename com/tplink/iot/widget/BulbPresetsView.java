package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tplink.iot.Utils.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BulbPresetsView
  extends RadioGroup
{
  private c c;
  private List<RadioButton> d = new ArrayList();
  private int f = 0;
  
  public BulbPresetsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BulbPresetsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnCheckedChangeListener(new a());
  }
  
  private List<Integer> e(List<Integer> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      Collections.sort(localArrayList);
      return localArrayList;
    }
    return paramList;
  }
  
  private List<Integer> f(List<Integer> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramList);
      Collections.sort(localArrayList, new b());
      return localArrayList;
    }
    return paramList;
  }
  
  public void d()
  {
    if (this.f == -1) {
      return;
    }
    this.f = -1;
    check(-1);
  }
  
  public void setOnPresetItemCheckListener(c paramc)
  {
    this.c = paramc;
  }
  
  public void setPresets(List<Integer> paramList)
  {
    removeAllViews();
    this.d.clear();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      setPadding(0, k.a(getContext(), 20.0F), 0, 0);
      Object localObject;
      int i;
      RadioGroup.LayoutParams localLayoutParams;
      if (getOrientation() == 1)
      {
        localObject = f(paramList).iterator();
        while (((Iterator)localObject).hasNext())
        {
          i = ((Integer)((Iterator)localObject).next()).intValue();
          paramList = (RadioButton)LayoutInflater.from(getContext()).inflate(2131559438, null);
          paramList.setText(String.format("%s%%", new Object[] { String.valueOf(i) }));
          paramList.setTag(Integer.valueOf(i));
          addView(paramList);
          localLayoutParams = (RadioGroup.LayoutParams)paramList.getLayoutParams();
          localLayoutParams.bottomMargin = k.a(getContext(), 12.0F);
          paramList.setLayoutParams(localLayoutParams);
          this.d.add(paramList);
        }
      }
      paramList = e(paramList).iterator();
      while (paramList.hasNext())
      {
        i = ((Integer)paramList.next()).intValue();
        localObject = (RadioButton)LayoutInflater.from(getContext()).inflate(2131559437, null);
        ((RadioButton)localObject).setText(String.format("%s%%", new Object[] { String.valueOf(i) }));
        ((RadioButton)localObject).setTag(Integer.valueOf(i));
        addView((View)localObject);
        localLayoutParams = (RadioGroup.LayoutParams)((RadioButton)localObject).getLayoutParams();
        localLayoutParams.leftMargin = k.a(getContext(), 12.0F);
        ((RadioButton)localObject).setLayoutParams(localLayoutParams);
        this.d.add(localObject);
      }
      return;
    }
    setPadding(0, 0, 0, 0);
  }
  
  class a
    implements RadioGroup.OnCheckedChangeListener
  {
    a() {}
    
    public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      if ((BulbPresetsView.a(BulbPresetsView.this) != null) && (paramInt != -1) && (BulbPresetsView.b(BulbPresetsView.this) != -1)) {
        try
        {
          paramRadioGroup = (RadioButton)BulbPresetsView.this.findViewById(paramInt);
          if ((paramRadioGroup == null) || (paramRadioGroup.getTag() == null)) {
            return;
          }
          int i = ((Integer)paramRadioGroup.getTag()).intValue();
          BulbPresetsView.c(BulbPresetsView.this, paramInt);
          BulbPresetsView.a(BulbPresetsView.this).a(i);
        }
        catch (Exception paramRadioGroup)
        {
          paramRadioGroup.printStackTrace();
        }
      } else if (BulbPresetsView.b(BulbPresetsView.this) == -1) {
        BulbPresetsView.c(BulbPresetsView.this, 0);
      }
    }
  }
  
  class b
    implements Comparator<Integer>
  {
    b() {}
    
    public int a(Integer paramInteger1, Integer paramInteger2)
    {
      return paramInteger2.intValue() - paramInteger1.intValue();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\BulbPresetsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */