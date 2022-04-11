package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;

public class SimplePagerTitleView
  extends TextView
  implements net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
{
  protected int c;
  protected int d;
  
  public SimplePagerTitleView(Context paramContext)
  {
    super(paramContext, null);
    e(paramContext);
  }
  
  private void e(Context paramContext)
  {
    setGravity(17);
    int i = net.lucode.hackware.magicindicator.g.b.a(paramContext, 10.0D);
    setPadding(i, 0, i, 0);
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    setTextColor(this.d);
  }
  
  public void b(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean) {}
  
  public void c(int paramInt1, int paramInt2)
  {
    setTextColor(this.c);
  }
  
  public void d(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean) {}
  
  public int getContentBottom()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f1 = localFontMetrics.bottom;
    float f2 = localFontMetrics.top;
    return (int)(getHeight() / 2 + (f1 - f2) / 2.0F);
  }
  
  public int getContentLeft()
  {
    Rect localRect = new Rect();
    if (getText().toString().contains("\n"))
    {
      String[] arrayOfString = getText().toString().split("\\n");
      int i = arrayOfString.length;
      Object localObject1 = "";
      j = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (j >= i) {
          break;
        }
        String str = arrayOfString[j];
        localObject2 = localObject1;
        if (str.length() > ((String)localObject1).length()) {
          localObject2 = str;
        }
        j++;
        localObject1 = localObject2;
      }
    }
    Object localObject2 = getText().toString();
    getPaint().getTextBounds((String)localObject2, 0, ((String)localObject2).length(), localRect);
    int j = localRect.width();
    return getLeft() + getWidth() / 2 - j / 2;
  }
  
  public int getContentRight()
  {
    Rect localRect = new Rect();
    if (getText().toString().contains("\n"))
    {
      String[] arrayOfString = getText().toString().split("\\n");
      int i = arrayOfString.length;
      Object localObject1 = "";
      j = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (j >= i) {
          break;
        }
        String str = arrayOfString[j];
        localObject2 = localObject1;
        if (str.length() > ((String)localObject1).length()) {
          localObject2 = str;
        }
        j++;
        localObject1 = localObject2;
      }
    }
    Object localObject2 = getText().toString();
    getPaint().getTextBounds((String)localObject2, 0, ((String)localObject2).length(), localRect);
    int j = localRect.width();
    return getLeft() + getWidth() / 2 + j / 2;
  }
  
  public int getContentTop()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    float f1 = localFontMetrics.bottom;
    float f2 = localFontMetrics.top;
    return (int)(getHeight() / 2 - (f1 - f2) / 2.0F);
  }
  
  public int getNormalColor()
  {
    return this.d;
  }
  
  public int getSelectedColor()
  {
    return this.c;
  }
  
  public void setNormalColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setSelectedColor(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\net\lucode\hackware\magicindicator\buildins\commonnavigator\titles\SimplePagerTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */