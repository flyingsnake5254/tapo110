package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.widget.colorbulb.c.a;
import com.tplink.iot.widget.colorbulb.c.b;
import com.tplink.iot.widget.colorbulb.c.c;
import java.util.Arrays;
import java.util.List;

public class ColorPlateWrapView
  extends LinearLayout
  implements TPCircleColorView.b, ColorListView.a
{
  private static final List<Integer> c = Arrays.asList(new Integer[] { Integer.valueOf(-207099), Integer.valueOf(-130744), Integer.valueOf(-7920644), Integer.valueOf(-14955521), Integer.valueOf(-14487457) });
  private a H3;
  private TPCircleColorView d;
  private TextView f;
  private int p0;
  private boolean p1 = false;
  private c p2;
  private b p3;
  private ColorListView q;
  private int x;
  private int y;
  private int z;
  
  public ColorPlateWrapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorPlateWrapView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorPlateWrapView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131559411, this, true);
    paramContext = (TPCircleColorView)findViewById(2131362287);
    this.d = paramContext;
    paramContext.setOnColorListener(this);
    paramContext = (ColorListView)findViewById(2131362284);
    this.q = paramContext;
    paramContext.setOnColorListCheckedListener(this);
    this.q.setColorPresets(c);
    this.f = ((TextView)findViewById(2131364377));
  }
  
  private void setColorValueText(int paramInt)
  {
    if (this.d.i())
    {
      String str = i.h(paramInt);
      this.f.setText(str);
    }
    else
    {
      this.f.setText("");
    }
  }
  
  public void J()
  {
    b localb = this.p3;
    if (localb != null) {
      localb.S(1, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    setColor(paramInt2);
    if (this.p2 != null) {
      w(paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d.setColor(paramInt1 & 0xFFFFFF);
    this.p1 = false;
    this.z = paramInt2;
    this.p0 = paramInt3;
  }
  
  public void g(int paramInt, boolean paramBoolean)
  {
    this.p1 = paramBoolean;
    Object localObject = new float[3];
    Color.colorToHSV(0xFF000000 | paramInt, (float[])localObject);
    int i = (int)localObject[0];
    this.x = i;
    int j = (int)(localObject[1] * 100.0F);
    this.y = j;
    setColorValueText(i.a(i, j));
    localObject = this.H3;
    if (localObject != null) {
      ((a)localObject).d0(paramInt, paramBoolean);
    }
  }
  
  public int getHue()
  {
    int i;
    if (this.p1) {
      i = this.x;
    } else {
      i = this.z;
    }
    return i;
  }
  
  public int getSat()
  {
    int i;
    if (this.p1) {
      i = this.y;
    } else {
      i = this.p0;
    }
    return i;
  }
  
  public void setColor(int paramInt)
  {
    this.d.setColor(paramInt & 0xFFFFFF);
    this.p1 = true;
  }
  
  public void setOnColorUpdateListener(a parama)
  {
    this.H3 = parama;
  }
  
  public void setOnLightTypeSelectListener(b paramb)
  {
    this.p3 = paramb;
  }
  
  public void setOnSampleLightStateCallback(c paramc)
  {
    this.p2 = paramc;
  }
  
  public void setSelectedStatus(boolean paramBoolean)
  {
    this.d.setSelectedStatus(paramBoolean);
    if (!paramBoolean) {
      setColorValueText(0);
    }
  }
  
  public void w(int paramInt)
  {
    Object localObject = new float[3];
    Color.colorToHSV(paramInt | 0xFF000000, (float[])localObject);
    int i = (int)localObject[0];
    paramInt = (int)(localObject[1] * 100.0F);
    localObject = this.p2;
    if (localObject != null) {
      ((c)localObject).b(0, i, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\colorbulb\ColorPlateWrapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */