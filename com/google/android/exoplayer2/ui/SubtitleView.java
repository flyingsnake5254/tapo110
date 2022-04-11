package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.k;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SubtitleView
  extends FrameLayout
  implements k
{
  private List<c> c = Collections.emptyList();
  private f0 d = f0.a;
  private int f = 0;
  private int p0;
  private a p1;
  private View p2;
  private float q = 0.0533F;
  private float x = 0.08F;
  private boolean y = true;
  private boolean z = true;
  
  public SubtitleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubtitleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new CanvasSubtitleOutput(paramContext);
    this.p1 = paramContext;
    this.p2 = paramContext;
    addView(paramContext);
    this.p0 = 1;
  }
  
  private c a(c paramc)
  {
    paramc = paramc.a();
    if (!this.y) {
      x0.c(paramc);
    } else if (!this.z) {
      x0.d(paramc);
    }
    return paramc.a();
  }
  
  private void c(int paramInt, float paramFloat)
  {
    this.f = paramInt;
    this.q = paramFloat;
    f();
  }
  
  private void f()
  {
    this.p1.a(getCuesWithStylingPreferencesApplied(), this.d, this.q, this.f, this.x);
  }
  
  private List<c> getCuesWithStylingPreferencesApplied()
  {
    if ((this.y) && (this.z)) {
      return this.c;
    }
    ArrayList localArrayList = new ArrayList(this.c.size());
    for (int i = 0; i < this.c.size(); i++) {
      localArrayList.add(a((c)this.c.get(i)));
    }
    return localArrayList;
  }
  
  private float getUserCaptionFontScale()
  {
    int i = o0.a;
    float f1 = 1.0F;
    float f2 = f1;
    if (i >= 19) {
      if (isInEditMode())
      {
        f2 = f1;
      }
      else
      {
        CaptioningManager localCaptioningManager = (CaptioningManager)getContext().getSystemService("captioning");
        f2 = f1;
        if (localCaptioningManager != null)
        {
          f2 = f1;
          if (localCaptioningManager.isEnabled()) {
            f2 = localCaptioningManager.getFontScale();
          }
        }
      }
    }
    return f2;
  }
  
  private f0 getUserCaptionStyle()
  {
    if ((o0.a >= 19) && (!isInEditMode()))
    {
      Object localObject = (CaptioningManager)getContext().getSystemService("captioning");
      if ((localObject != null) && (((CaptioningManager)localObject).isEnabled())) {
        localObject = f0.a(((CaptioningManager)localObject).getUserStyle());
      } else {
        localObject = f0.a;
      }
      return (f0)localObject;
    }
    return f0.a;
  }
  
  private <T extends View,  extends a> void setView(T paramT)
  {
    removeView(this.p2);
    View localView = this.p2;
    if ((localView instanceof WebViewSubtitleOutput)) {
      ((WebViewSubtitleOutput)localView).g();
    }
    this.p2 = paramT;
    this.p1 = ((a)paramT);
    addView(paramT);
  }
  
  public void B(List<c> paramList)
  {
    setCues(paramList);
  }
  
  public void b(float paramFloat, boolean paramBoolean)
  {
    c(paramBoolean, paramFloat);
  }
  
  public void d()
  {
    setStyle(getUserCaptionStyle());
  }
  
  public void e()
  {
    setFractionalTextSize(getUserCaptionFontScale() * 0.0533F);
  }
  
  public void setApplyEmbeddedFontSizes(boolean paramBoolean)
  {
    this.z = paramBoolean;
    f();
  }
  
  public void setApplyEmbeddedStyles(boolean paramBoolean)
  {
    this.y = paramBoolean;
    f();
  }
  
  public void setBottomPaddingFraction(float paramFloat)
  {
    this.x = paramFloat;
    f();
  }
  
  public void setCues(@Nullable List<c> paramList)
  {
    if (paramList == null) {
      paramList = Collections.emptyList();
    }
    this.c = paramList;
    f();
  }
  
  public void setFractionalTextSize(float paramFloat)
  {
    b(paramFloat, false);
  }
  
  public void setStyle(f0 paramf0)
  {
    this.d = paramf0;
    f();
  }
  
  public void setViewType(int paramInt)
  {
    if (this.p0 == paramInt) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        setView(new WebViewSubtitleOutput(getContext()));
      } else {
        throw new IllegalArgumentException();
      }
    }
    else {
      setView(new CanvasSubtitleOutput(getContext()));
    }
    this.p0 = paramInt;
  }
  
  static abstract interface a
  {
    public abstract void a(List<c> paramList, f0 paramf0, float paramFloat1, int paramInt, float paramFloat2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\ui\SubtitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */