package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class WebViewSubtitleOutput
  extends FrameLayout
  implements SubtitleView.a
{
  private final CanvasSubtitleOutput c;
  private final WebView d;
  private List<c> f = Collections.emptyList();
  private f0 q = f0.a;
  private float x = 0.0533F;
  private int y = 0;
  private float z = 0.08F;
  
  public WebViewSubtitleOutput(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebViewSubtitleOutput(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    CanvasSubtitleOutput localCanvasSubtitleOutput = new CanvasSubtitleOutput(paramContext, paramAttributeSet);
    this.c = localCanvasSubtitleOutput;
    paramContext = new a(paramContext, paramAttributeSet);
    this.d = paramContext;
    paramContext.setBackgroundColor(0);
    addView(localCanvasSubtitleOutput);
    addView(paramContext);
  }
  
  private static int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return 0;
      }
      return -100;
    }
    return -50;
  }
  
  private static String c(@Nullable Layout.Alignment paramAlignment)
  {
    if (paramAlignment == null) {
      return "center";
    }
    int i = b.a[paramAlignment.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return "center";
      }
      return "end";
    }
    return "start";
  }
  
  private static String d(f0 paramf0)
  {
    int i = paramf0.e;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return "unset";
          }
          return o0.A("-0.05em -0.05em 0.15em %s", new Object[] { h0.b(paramf0.f) });
        }
        return o0.A("0.06em 0.08em 0.15em %s", new Object[] { h0.b(paramf0.f) });
      }
      return o0.A("0.1em 0.12em 0.15em %s", new Object[] { h0.b(paramf0.f) });
    }
    return o0.A("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", new Object[] { h0.b(paramf0.f) });
  }
  
  private String e(int paramInt, float paramFloat)
  {
    paramFloat = x0.f(paramInt, paramFloat, getHeight(), getHeight() - getPaddingTop() - getPaddingBottom());
    if (paramFloat == -3.4028235E38F) {
      return "unset";
    }
    return o0.A("%.2fpx", new Object[] { Float.valueOf(paramFloat / getContext().getResources().getDisplayMetrics().density) });
  }
  
  private static String f(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return "horizontal-tb";
      }
      return "vertical-lr";
    }
    return "vertical-rl";
  }
  
  private static String h(c paramc)
  {
    float f1 = paramc.s;
    if (f1 != 0.0F)
    {
      int i = paramc.r;
      if ((i != 2) && (i != 1)) {
        paramc = "skewX";
      } else {
        paramc = "skewY";
      }
      return o0.A("%s(%.2fdeg)", new Object[] { paramc, Float.valueOf(f1) });
    }
    return "";
  }
  
  private void i()
  {
    Object localObject1 = this;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(o0.A("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", new Object[] { h0.b(((WebViewSubtitleOutput)localObject1).q.b), ((WebViewSubtitleOutput)localObject1).e(((WebViewSubtitleOutput)localObject1).y, ((WebViewSubtitleOutput)localObject1).x), Float.valueOf(1.2F), d(((WebViewSubtitleOutput)localObject1).q) }));
    HashMap localHashMap = new HashMap();
    localHashMap.put(h0.a("default_bg"), o0.A("background-color:%s;", new Object[] { h0.b(((WebViewSubtitleOutput)localObject1).q.c) }));
    Object localObject3;
    for (int i = 0;; i++)
    {
      Object localObject2 = this;
      if (i >= ((WebViewSubtitleOutput)localObject2).f.size()) {
        break;
      }
      c localc = (c)((WebViewSubtitleOutput)localObject2).f.get(i);
      float f1 = localc.j;
      if (f1 != -3.4028235E38F) {
        f1 *= 100.0F;
      } else {
        f1 = 50.0F;
      }
      int j = b(localc.k);
      float f2 = localc.g;
      int k;
      if (f2 != -3.4028235E38F)
      {
        if (localc.h != 1)
        {
          localObject1 = o0.A("%.2f%%", new Object[] { Float.valueOf(f2 * 100.0F) });
          if (localc.r == 1) {
            k = -b(localc.i);
          } else {
            k = b(localc.i);
          }
        }
        else if (f2 >= 0.0F)
        {
          localObject1 = o0.A("%.2fem", new Object[] { Float.valueOf(f2 * 1.2F) });
          k = 0;
        }
        else
        {
          localObject3 = o0.A("%.2fem", new Object[] { Float.valueOf((-f2 - 1.0F) * 1.2F) });
          k = 0;
          m = 1;
          break label376;
        }
      }
      else
      {
        localObject1 = o0.A("%.2f%%", new Object[] { Float.valueOf((1.0F - ((WebViewSubtitleOutput)localObject2).z) * 100.0F) });
        k = -100;
      }
      int m = 0;
      localObject3 = localObject1;
      label376:
      f2 = localc.l;
      if (f2 != -3.4028235E38F) {
        localObject4 = o0.A("%.2f%%", new Object[] { Float.valueOf(f2 * 100.0F) });
      } else {
        localObject4 = "fit-content";
      }
      String str1 = c(localc.d);
      String str2 = f(localc.r);
      String str3 = ((WebViewSubtitleOutput)localObject2).e(localc.p, localc.q);
      if (localc.n) {
        n = localc.o;
      } else {
        n = ((WebViewSubtitleOutput)localObject2).q.d;
      }
      String str4 = h0.b(n);
      int n = localc.r;
      String str5 = "right";
      localObject2 = "left";
      localObject1 = "top";
      if (n != 1)
      {
        if (n != 2)
        {
          if (m != 0) {
            localObject1 = "bottom";
          }
          break label566;
        }
        if (m != 0)
        {
          localObject1 = str5;
          break label561;
        }
      }
      else
      {
        localObject1 = str5;
        if (m == 0) {
          break label561;
        }
      }
      localObject1 = "left";
      label561:
      localObject2 = "top";
      label566:
      if ((n != 2) && (n != 1))
      {
        str5 = "width";
        m = j;
        j = k;
      }
      else
      {
        str5 = "height";
        m = k;
      }
      u0.b localb = u0.a(localc.c, getContext().getResources().getDisplayMetrics().density);
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str6 = (String)localIterator.next();
        String str7 = (String)localHashMap.put(str6, (String)localHashMap.get(str6));
        boolean bool;
        if ((str7 != null) && (!str7.equals(localHashMap.get(str6)))) {
          bool = false;
        } else {
          bool = true;
        }
        g.g(bool);
      }
      localStringBuilder.append(o0.A("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", new Object[] { Integer.valueOf(i), localObject2, Float.valueOf(f1), localObject1, localObject3, str5, localObject4, str1, str2, str3, str4, Integer.valueOf(m), Integer.valueOf(j), h(localc) }));
      localStringBuilder.append(o0.A("<span class='%s'>", new Object[] { "default_bg" }));
      localObject1 = localc.e;
      if (localObject1 != null)
      {
        localStringBuilder.append(o0.A("<span style='display:inline-block; text-align:%s;'>", new Object[] { c((Layout.Alignment)localObject1) }));
        localStringBuilder.append(localb.a);
        localStringBuilder.append("</span>");
      }
      else
      {
        localStringBuilder.append(localb.a);
      }
      localStringBuilder.append("</span>");
      localStringBuilder.append("</div>");
    }
    localStringBuilder.append("</div></body></html>");
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("<html><head><style>");
    localObject1 = localHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append("{");
      ((StringBuilder)localObject4).append((String)localHashMap.get(localObject3));
      ((StringBuilder)localObject4).append("}");
    }
    ((StringBuilder)localObject4).append("</style></head>");
    localStringBuilder.insert(0, ((StringBuilder)localObject4).toString());
    this.d.loadData(Base64.encodeToString(localStringBuilder.toString().getBytes(e.c), 1), "text/html", "base64");
  }
  
  public void a(List<c> paramList, f0 paramf0, float paramFloat1, int paramInt, float paramFloat2)
  {
    this.q = paramf0;
    this.x = paramFloat1;
    this.y = paramInt;
    this.z = paramFloat2;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (int i = 0; i < paramList.size(); i++)
    {
      c localc = (c)paramList.get(i);
      if (localc.f != null) {
        localArrayList1.add(localc);
      } else {
        localArrayList2.add(localc);
      }
    }
    if ((!this.f.isEmpty()) || (!localArrayList2.isEmpty()))
    {
      this.f = localArrayList2;
      i();
    }
    this.c.a(localArrayList1, paramf0, paramFloat1, paramInt, paramFloat2);
    invalidate();
  }
  
  public void g()
  {
    this.d.destroy();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.f.isEmpty())) {
      i();
    }
  }
  
  class a
    extends WebView
  {
    a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      super.onTouchEvent(paramMotionEvent);
      return false;
    }
    
    public boolean performClick()
    {
      super.performClick();
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\WebViewSubtitleOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */