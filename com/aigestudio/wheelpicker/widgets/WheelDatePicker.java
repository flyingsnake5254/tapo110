package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aigestudio.wheelpicker.WheelPicker;
import com.aigestudio.wheelpicker.WheelPicker.a;
import com.aigestudio.wheelpicker.WheelPicker.b;
import com.aigestudio.wheelpicker.c;
import com.aigestudio.wheelpicker.d;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WheelDatePicker
  extends LinearLayout
  implements WheelPicker.a
{
  private static final SimpleDateFormat c = new SimpleDateFormat("yyyy-M-d", Locale.getDefault());
  private WheelYearPicker d;
  private WheelMonthPicker f;
  private TextView p0;
  private int p1;
  private int p2;
  private int p3;
  private WheelDayPicker q;
  private a x;
  private TextView y;
  private TextView z;
  
  public WheelDatePicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WheelDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(d.view_wheel_date_picker, this);
    this.d = ((WheelYearPicker)findViewById(c.wheel_date_picker_year));
    this.f = ((WheelMonthPicker)findViewById(c.wheel_date_picker_month));
    this.q = ((WheelDayPicker)findViewById(c.wheel_date_picker_day));
    this.d.setOnItemSelectedListener(this);
    this.f.setOnItemSelectedListener(this);
    this.q.setOnItemSelectedListener(this);
    b();
    this.f.setMaximumWidthText("00");
    this.q.setMaximumWidthText("00");
    this.y = ((TextView)findViewById(c.wheel_date_picker_year_tv));
    this.z = ((TextView)findViewById(c.wheel_date_picker_month_tv));
    this.p0 = ((TextView)findViewById(c.wheel_date_picker_day_tv));
    this.p1 = this.d.getCurrentYear();
    this.p2 = this.f.getCurrentMonth();
    this.p3 = this.q.getCurrentDay();
  }
  
  private void b()
  {
    Object localObject = this.d.getData();
    String str = String.valueOf(((List)localObject).get(((List)localObject).size() - 1));
    localObject = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      ((StringBuilder)localObject).append("0");
    }
    this.d.setMaximumWidthText(((StringBuilder)localObject).toString());
  }
  
  public void a(WheelPicker paramWheelPicker, Object paramObject, int paramInt)
  {
    if (paramWheelPicker.getId() == c.wheel_date_picker_year)
    {
      paramInt = ((Integer)paramObject).intValue();
      this.p1 = paramInt;
      this.q.setYear(paramInt);
    }
    else if (paramWheelPicker.getId() == c.wheel_date_picker_month)
    {
      paramInt = ((Integer)paramObject).intValue();
      this.p2 = paramInt;
      this.q.setMonth(paramInt);
    }
    this.p3 = this.q.getCurrentDay();
    paramWheelPicker = new StringBuilder();
    paramWheelPicker.append(this.p1);
    paramWheelPicker.append("-");
    paramWheelPicker.append(this.p2);
    paramWheelPicker.append("-");
    paramWheelPicker.append(this.p3);
    paramObject = paramWheelPicker.toString();
    paramWheelPicker = this.x;
    if (paramWheelPicker != null) {
      try
      {
        paramWheelPicker.a(this, c.parse((String)paramObject));
      }
      catch (ParseException paramWheelPicker)
      {
        paramWheelPicker.printStackTrace();
      }
    }
  }
  
  public Date getCurrentDate()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.p1);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.p2);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.p3);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      localObject = c.parse((String)localObject);
      return (Date)localObject;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return null;
  }
  
  public int getCurrentDay()
  {
    return this.q.getCurrentDay();
  }
  
  @Deprecated
  public int getCurrentItemPosition()
  {
    throw new UnsupportedOperationException("You can not get position of current item fromWheelDatePicker");
  }
  
  public int getCurrentMonth()
  {
    return this.f.getCurrentMonth();
  }
  
  public int getCurrentYear()
  {
    return this.d.getCurrentYear();
  }
  
  public int getCurtainColor()
  {
    if ((this.d.getCurtainColor() == this.f.getCurtainColor()) && (this.f.getCurtainColor() == this.q.getCurtainColor())) {
      return this.d.getCurtainColor();
    }
    throw new RuntimeException("Can not get curtain color correctly from WheelDatePicker!");
  }
  
  @Deprecated
  public List getData()
  {
    throw new UnsupportedOperationException("You can not get data source from WheelDatePicker");
  }
  
  public int getIndicatorColor()
  {
    if ((this.d.getCurtainColor() == this.f.getCurtainColor()) && (this.f.getCurtainColor() == this.q.getCurtainColor())) {
      return this.d.getCurtainColor();
    }
    throw new RuntimeException("Can not get indicator color correctly from WheelDatePicker!");
  }
  
  public int getIndicatorSize()
  {
    if ((this.d.getIndicatorSize() == this.f.getIndicatorSize()) && (this.f.getIndicatorSize() == this.q.getIndicatorSize())) {
      return this.d.getIndicatorSize();
    }
    throw new RuntimeException("Can not get indicator size correctly from WheelDatePicker!");
  }
  
  @Deprecated
  public int getItemAlign()
  {
    throw new UnsupportedOperationException("You can not get item align from WheelDatePicker");
  }
  
  public int getItemAlignDay()
  {
    return this.q.getItemAlign();
  }
  
  public int getItemAlignMonth()
  {
    return this.f.getItemAlign();
  }
  
  public int getItemAlignYear()
  {
    return this.d.getItemAlign();
  }
  
  public int getItemSpace()
  {
    if ((this.d.getItemSpace() == this.f.getItemSpace()) && (this.f.getItemSpace() == this.q.getItemSpace())) {
      return this.d.getItemSpace();
    }
    throw new RuntimeException("Can not get item space correctly from WheelDatePicker!");
  }
  
  public int getItemTextColor()
  {
    if ((this.d.getItemTextColor() == this.f.getItemTextColor()) && (this.f.getItemTextColor() == this.q.getItemTextColor())) {
      return this.d.getItemTextColor();
    }
    throw new RuntimeException("Can not get color of item text correctly fromWheelDatePicker!");
  }
  
  public int getItemTextSize()
  {
    if ((this.d.getItemTextSize() == this.f.getItemTextSize()) && (this.f.getItemTextSize() == this.q.getItemTextSize())) {
      return this.d.getItemTextSize();
    }
    throw new RuntimeException("Can not get size of item text correctly fromWheelDatePicker!");
  }
  
  @Deprecated
  public String getMaximumWidthText()
  {
    throw new UnsupportedOperationException("You can not get maximum width text fromWheelDatePicker");
  }
  
  @Deprecated
  public int getMaximumWidthTextPosition()
  {
    throw new UnsupportedOperationException("You can not get maximum width text positionfrom WheelDatePicker");
  }
  
  public int getMonth()
  {
    return getSelectedMonth();
  }
  
  public int getSelectedDay()
  {
    return this.q.getSelectedDay();
  }
  
  @Deprecated
  public int getSelectedItemPosition()
  {
    throw new UnsupportedOperationException("You can not get position of selected item fromWheelDatePicker");
  }
  
  public int getSelectedItemTextColor()
  {
    if ((this.d.getSelectedItemTextColor() == this.f.getSelectedItemTextColor()) && (this.f.getSelectedItemTextColor() == this.q.getSelectedItemTextColor())) {
      return this.d.getSelectedItemTextColor();
    }
    throw new RuntimeException("Can not get color of selected item text correctly fromWheelDatePicker!");
  }
  
  public int getSelectedMonth()
  {
    return this.f.getSelectedMonth();
  }
  
  public int getSelectedYear()
  {
    return this.d.getSelectedYear();
  }
  
  public TextView getTextViewDay()
  {
    return this.p0;
  }
  
  public TextView getTextViewMonth()
  {
    return this.z;
  }
  
  public TextView getTextViewYear()
  {
    return this.y;
  }
  
  public Typeface getTypeface()
  {
    if ((this.d.getTypeface().equals(this.f.getTypeface())) && (this.f.getTypeface().equals(this.q.getTypeface()))) {
      return this.d.getTypeface();
    }
    throw new RuntimeException("Can not get typeface correctly from WheelDatePicker!");
  }
  
  public int getVisibleItemCount()
  {
    if ((this.d.getVisibleItemCount() == this.f.getVisibleItemCount()) && (this.f.getVisibleItemCount() == this.q.getVisibleItemCount())) {
      return this.d.getVisibleItemCount();
    }
    throw new ArithmeticException("Can not get visible item count correctly fromWheelDatePicker!");
  }
  
  public WheelDayPicker getWheelDayPicker()
  {
    return this.q;
  }
  
  public WheelMonthPicker getWheelMonthPicker()
  {
    return this.f;
  }
  
  public WheelYearPicker getWheelYearPicker()
  {
    return this.d;
  }
  
  public int getYear()
  {
    return getSelectedYear();
  }
  
  public int getYearEnd()
  {
    return this.d.getYearEnd();
  }
  
  public int getYearStart()
  {
    return this.d.getYearStart();
  }
  
  public void setAtmospheric(boolean paramBoolean)
  {
    this.d.setAtmospheric(paramBoolean);
    this.f.setAtmospheric(paramBoolean);
    this.q.setAtmospheric(paramBoolean);
  }
  
  public void setCurtain(boolean paramBoolean)
  {
    this.d.setCurtain(paramBoolean);
    this.f.setCurtain(paramBoolean);
    this.q.setCurtain(paramBoolean);
  }
  
  public void setCurtainColor(int paramInt)
  {
    this.d.setCurtainColor(paramInt);
    this.f.setCurtainColor(paramInt);
    this.q.setCurtainColor(paramInt);
  }
  
  public void setCurved(boolean paramBoolean)
  {
    this.d.setCurved(paramBoolean);
    this.f.setCurved(paramBoolean);
    this.q.setCurved(paramBoolean);
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.d.setCyclic(paramBoolean);
    this.f.setCyclic(paramBoolean);
    this.q.setCyclic(paramBoolean);
  }
  
  @Deprecated
  public void setData(List paramList)
  {
    throw new UnsupportedOperationException("You don't need to set data source forWheelDatePicker");
  }
  
  public void setDebug(boolean paramBoolean)
  {
    this.d.setDebug(paramBoolean);
    this.f.setDebug(paramBoolean);
    this.q.setDebug(paramBoolean);
  }
  
  public void setIndicator(boolean paramBoolean)
  {
    this.d.setIndicator(paramBoolean);
    this.f.setIndicator(paramBoolean);
    this.q.setIndicator(paramBoolean);
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.d.setIndicatorColor(paramInt);
    this.f.setIndicatorColor(paramInt);
    this.q.setIndicatorColor(paramInt);
  }
  
  public void setIndicatorSize(int paramInt)
  {
    this.d.setIndicatorSize(paramInt);
    this.f.setIndicatorSize(paramInt);
    this.q.setIndicatorSize(paramInt);
  }
  
  @Deprecated
  public void setItemAlign(int paramInt)
  {
    throw new UnsupportedOperationException("You don't need to set item align forWheelDatePicker");
  }
  
  public void setItemAlignDay(int paramInt)
  {
    this.q.setItemAlign(paramInt);
  }
  
  public void setItemAlignMonth(int paramInt)
  {
    this.f.setItemAlign(paramInt);
  }
  
  public void setItemAlignYear(int paramInt)
  {
    this.d.setItemAlign(paramInt);
  }
  
  public void setItemSpace(int paramInt)
  {
    this.d.setItemSpace(paramInt);
    this.f.setItemSpace(paramInt);
    this.q.setItemSpace(paramInt);
  }
  
  public void setItemTextColor(int paramInt)
  {
    this.d.setItemTextColor(paramInt);
    this.f.setItemTextColor(paramInt);
    this.q.setItemTextColor(paramInt);
  }
  
  public void setItemTextSize(int paramInt)
  {
    this.d.setItemTextSize(paramInt);
    this.f.setItemTextSize(paramInt);
    this.q.setItemTextSize(paramInt);
  }
  
  @Deprecated
  public void setMaximumWidthText(String paramString)
  {
    throw new UnsupportedOperationException("You don't need to set maximum width text forWheelDatePicker");
  }
  
  @Deprecated
  public void setMaximumWidthTextPosition(int paramInt)
  {
    throw new UnsupportedOperationException("You don't need to set maximum width textposition for WheelDatePicker");
  }
  
  public void setMonth(int paramInt)
  {
    this.p2 = paramInt;
    this.f.setSelectedMonth(paramInt);
    this.q.setMonth(paramInt);
  }
  
  public void setOnDateSelectedListener(a parama)
  {
    this.x = parama;
  }
  
  @Deprecated
  public void setOnItemSelectedListener(WheelPicker.a parama)
  {
    throw new UnsupportedOperationException("You can not set OnItemSelectedListener forWheelDatePicker");
  }
  
  @Deprecated
  public void setOnWheelChangeListener(WheelPicker.b paramb)
  {
    throw new UnsupportedOperationException("WheelDatePicker unsupport setOnWheelChangeListener");
  }
  
  @Deprecated
  public void setSameWidth(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("You don't need to set same width forWheelDatePicker");
  }
  
  public void setSelectedDay(int paramInt)
  {
    this.p3 = paramInt;
    this.q.setSelectedDay(paramInt);
  }
  
  @Deprecated
  public void setSelectedItemPosition(int paramInt)
  {
    throw new UnsupportedOperationException("You can not set position of selected item forWheelDatePicker");
  }
  
  public void setSelectedItemTextColor(int paramInt)
  {
    this.d.setSelectedItemTextColor(paramInt);
    this.f.setSelectedItemTextColor(paramInt);
    this.q.setSelectedItemTextColor(paramInt);
  }
  
  public void setSelectedMonth(int paramInt)
  {
    this.p2 = paramInt;
    this.f.setSelectedMonth(paramInt);
    this.q.setMonth(paramInt);
  }
  
  public void setSelectedYear(int paramInt)
  {
    this.p1 = paramInt;
    this.d.setSelectedYear(paramInt);
    this.q.setYear(paramInt);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.d.setTypeface(paramTypeface);
    this.f.setTypeface(paramTypeface);
    this.q.setTypeface(paramTypeface);
  }
  
  public void setVisibleItemCount(int paramInt)
  {
    this.d.setVisibleItemCount(paramInt);
    this.f.setVisibleItemCount(paramInt);
    this.q.setVisibleItemCount(paramInt);
  }
  
  public void setYear(int paramInt)
  {
    this.p1 = paramInt;
    this.d.setSelectedYear(paramInt);
    this.q.setYear(paramInt);
  }
  
  public void setYearEnd(int paramInt)
  {
    this.d.setYearEnd(paramInt);
  }
  
  public void setYearStart(int paramInt)
  {
    this.d.setYearStart(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a(WheelDatePicker paramWheelDatePicker, Date paramDate);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\aigestudio\wheelpicker\widgets\WheelDatePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */