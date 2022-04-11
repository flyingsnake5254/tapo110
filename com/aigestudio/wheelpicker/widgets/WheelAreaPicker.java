package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.aigestudio.wheelpicker.WheelPicker;
import com.aigestudio.wheelpicker.WheelPicker.a;
import com.aigestudio.wheelpicker.model.City;
import com.aigestudio.wheelpicker.model.Province;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WheelAreaPicker
  extends LinearLayout
{
  private Context c;
  private List<Province> d;
  private List<City> f;
  private WheelPicker p0;
  private WheelPicker p1;
  private WheelPicker p2;
  private List<String> q;
  private List<String> x;
  private AssetManager y;
  private LinearLayout.LayoutParams z;
  
  public WheelAreaPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    i();
    j(paramContext);
    this.d = h(this.y);
    l();
    f();
  }
  
  private void f()
  {
    this.p0.setOnItemSelectedListener(new a());
    this.p1.setOnItemSelectedListener(new b());
  }
  
  private int g(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private List<Province> h(AssetManager paramAssetManager)
  {
    try
    {
      paramAssetManager = paramAssetManager.open("RegionJsonData.dat");
      ObjectInputStream localObjectInputStream = new java/io/ObjectInputStream;
      localObjectInputStream.<init>(paramAssetManager);
      paramAssetManager = (List)localObjectInputStream.readObject();
      try
      {
        localObjectInputStream.close();
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramAssetManager = null;
    }
    return paramAssetManager;
  }
  
  private void i()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.z = localLayoutParams;
    localLayoutParams.setMargins(5, 5, 5, 5);
    this.z.width = 0;
  }
  
  private void j(Context paramContext)
  {
    setOrientation(0);
    this.c = paramContext;
    this.y = paramContext.getAssets();
    this.q = new ArrayList();
    this.x = new ArrayList();
    this.p0 = new WheelPicker(paramContext);
    this.p1 = new WheelPicker(paramContext);
    this.p2 = new WheelPicker(paramContext);
    k(this.p0, 1.0F);
    k(this.p1, 1.5F);
    k(this.p2, 1.5F);
  }
  
  private void k(WheelPicker paramWheelPicker, float paramFloat)
  {
    this.z.weight = paramFloat;
    paramWheelPicker.setItemTextSize(g(this.c, 18.0F));
    paramWheelPicker.setSelectedItemTextColor(Color.parseColor("#353535"));
    paramWheelPicker.setCurved(true);
    paramWheelPicker.setLayoutParams(this.z);
    addView(paramWheelPicker);
  }
  
  private void l()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      Province localProvince = (Province)localIterator.next();
      this.q.add(localProvince.getName());
    }
    this.p0.setData(this.q);
    setCityAndAreaData(0);
  }
  
  private void setCityAndAreaData(int paramInt)
  {
    this.f = ((Province)this.d.get(paramInt)).getCity();
    this.x.clear();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      City localCity = (City)localIterator.next();
      this.x.add(localCity.getName());
    }
    this.p1.setData(this.x);
    this.p1.setSelectedItemPosition(0);
    this.p2.setData(((City)this.f.get(0)).getArea());
    this.p2.setSelectedItemPosition(0);
  }
  
  public String getArea()
  {
    return (String)((City)this.f.get(this.p1.getCurrentItemPosition())).getArea().get(this.p2.getCurrentItemPosition());
  }
  
  public String getCity()
  {
    return ((City)this.f.get(this.p1.getCurrentItemPosition())).getName();
  }
  
  public String getProvince()
  {
    return ((Province)this.d.get(this.p0.getCurrentItemPosition())).getName();
  }
  
  class a
    implements WheelPicker.a
  {
    a() {}
    
    public void a(WheelPicker paramWheelPicker, Object paramObject, int paramInt)
    {
      paramWheelPicker = WheelAreaPicker.this;
      WheelAreaPicker.b(paramWheelPicker, ((Province)WheelAreaPicker.c(paramWheelPicker).get(paramInt)).getCity());
      WheelAreaPicker.d(WheelAreaPicker.this, paramInt);
    }
  }
  
  class b
    implements WheelPicker.a
  {
    b() {}
    
    public void a(WheelPicker paramWheelPicker, Object paramObject, int paramInt)
    {
      WheelAreaPicker.e(WheelAreaPicker.this).setData(((City)WheelAreaPicker.a(WheelAreaPicker.this).get(paramInt)).getArea());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\aigestudio\wheelpicker\widgets\WheelAreaPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */