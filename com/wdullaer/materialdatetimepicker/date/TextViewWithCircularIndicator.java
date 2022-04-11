package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.wdullaer.materialdatetimepicker.a;
import com.wdullaer.materialdatetimepicker.c;

public class TextViewWithCircularIndicator
  extends TextView
{
  Paint c = new Paint();
  private int d;
  private final String f;
  private boolean q;
  
  public TextViewWithCircularIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = ContextCompat.getColor(paramContext, a.mdtp_accent_color);
    this.f = paramContext.getResources().getString(c.mdtp_item_is_selected);
    b();
  }
  
  private void b()
  {
    this.c.setFakeBoldText(true);
    this.c.setAntiAlias(true);
    this.c.setColor(this.d);
    this.c.setTextAlign(Paint.Align.CENTER);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setAlpha(255);
  }
  
  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public CharSequence getContentDescription()
  {
    CharSequence localCharSequence = getText();
    Object localObject = localCharSequence;
    if (this.q) {
      localObject = String.format(this.f, new Object[] { localCharSequence });
    }
    return (CharSequence)localObject;
  }
  
  public void onDraw(@NonNull Canvas paramCanvas)
  {
    if (this.q)
    {
      int i = getWidth();
      int j = getHeight();
      int k = Math.min(i, j) / 2;
      paramCanvas.drawCircle(i / 2, j / 2, k, this.c);
    }
    setSelected(this.q);
    super.onDraw(paramCanvas);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\TextViewWithCircularIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */