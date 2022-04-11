package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import kotlin.TypeCastException;
import kotlin.jvm.b.a;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class ViewKt
{
  public static final void doOnAttach(View paramView, final l<? super View, p> paraml)
  {
    j.f(paramView, "$this$doOnAttach");
    j.f(paraml, "action");
    if (ViewCompat.isAttachedToWindow(paramView)) {
      paraml.invoke(paramView);
    } else {
      paramView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public void onViewAttachedToWindow(View paramAnonymousView)
        {
          j.f(paramAnonymousView, "view");
          this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
          paraml.invoke(paramAnonymousView);
        }
        
        public void onViewDetachedFromWindow(View paramAnonymousView)
        {
          j.f(paramAnonymousView, "view");
        }
      });
    }
  }
  
  public static final void doOnDetach(View paramView, final l<? super View, p> paraml)
  {
    j.f(paramView, "$this$doOnDetach");
    j.f(paraml, "action");
    if (!ViewCompat.isAttachedToWindow(paramView)) {
      paraml.invoke(paramView);
    } else {
      paramView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public void onViewAttachedToWindow(View paramAnonymousView)
        {
          j.f(paramAnonymousView, "view");
        }
        
        public void onViewDetachedFromWindow(View paramAnonymousView)
        {
          j.f(paramAnonymousView, "view");
          this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
          paraml.invoke(paramAnonymousView);
        }
      });
    }
  }
  
  public static final void doOnLayout(View paramView, l<? super View, p> paraml)
  {
    j.f(paramView, "$this$doOnLayout");
    j.f(paraml, "action");
    if ((ViewCompat.isLaidOut(paramView)) && (!paramView.isLayoutRequested())) {
      paraml.invoke(paramView);
    } else {
      paramView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          j.f(paramAnonymousView, "view");
          paramAnonymousView.removeOnLayoutChangeListener(this);
          this.$action$inlined.invoke(paramAnonymousView);
        }
      });
    }
  }
  
  public static final void doOnNextLayout(View paramView, l<? super View, p> paraml)
  {
    j.f(paramView, "$this$doOnNextLayout");
    j.f(paraml, "action");
    paramView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        j.f(paramAnonymousView, "view");
        paramAnonymousView.removeOnLayoutChangeListener(this);
        this.$action.invoke(paramAnonymousView);
      }
    });
  }
  
  public static final OneShotPreDrawListener doOnPreDraw(View paramView, final l<? super View, p> paraml)
  {
    j.f(paramView, "$this$doOnPreDraw");
    j.f(paraml, "action");
    paramView = OneShotPreDrawListener.add(paramView, new Runnable()
    {
      public final void run()
      {
        paraml.invoke(this.$this_doOnPreDraw);
      }
    });
    j.b(paramView, "OneShotPreDrawListener.add(this) { action(this) }");
    return paramView;
  }
  
  public static final Bitmap drawToBitmap(View paramView, Bitmap.Config paramConfig)
  {
    j.f(paramView, "$this$drawToBitmap");
    j.f(paramConfig, "config");
    if (ViewCompat.isLaidOut(paramView))
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), paramConfig);
      j.b(localBitmap, "Bitmap.createBitmap(width, height, config)");
      paramConfig = new Canvas(localBitmap);
      paramConfig.translate(-paramView.getScrollX(), -paramView.getScrollY());
      paramView.draw(paramConfig);
      return localBitmap;
    }
    throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
  }
  
  public static final int getMarginBottom(View paramView)
  {
    j.f(paramView, "$this$marginBottom");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    int i;
    if (paramView != null) {
      i = paramView.bottomMargin;
    } else {
      i = 0;
    }
    return i;
  }
  
  public static final int getMarginEnd(View paramView)
  {
    j.f(paramView, "$this$marginEnd");
    paramView = paramView.getLayoutParams();
    int i;
    if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
      i = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)paramView);
    } else {
      i = 0;
    }
    return i;
  }
  
  public static final int getMarginLeft(View paramView)
  {
    j.f(paramView, "$this$marginLeft");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    int i;
    if (paramView != null) {
      i = paramView.leftMargin;
    } else {
      i = 0;
    }
    return i;
  }
  
  public static final int getMarginRight(View paramView)
  {
    j.f(paramView, "$this$marginRight");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    int i;
    if (paramView != null) {
      i = paramView.rightMargin;
    } else {
      i = 0;
    }
    return i;
  }
  
  public static final int getMarginStart(View paramView)
  {
    j.f(paramView, "$this$marginStart");
    paramView = paramView.getLayoutParams();
    int i;
    if ((paramView instanceof ViewGroup.MarginLayoutParams)) {
      i = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)paramView);
    } else {
      i = 0;
    }
    return i;
  }
  
  public static final int getMarginTop(View paramView)
  {
    j.f(paramView, "$this$marginTop");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    int i;
    if (paramView != null) {
      i = paramView.topMargin;
    } else {
      i = 0;
    }
    return i;
  }
  
  public static final boolean isGone(View paramView)
  {
    j.f(paramView, "$this$isGone");
    boolean bool;
    if (paramView.getVisibility() == 8) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean isInvisible(View paramView)
  {
    j.f(paramView, "$this$isInvisible");
    boolean bool;
    if (paramView.getVisibility() == 4) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean isVisible(View paramView)
  {
    j.f(paramView, "$this$isVisible");
    boolean bool;
    if (paramView.getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final Runnable postDelayed(View paramView, long paramLong, a<p> parama)
  {
    j.f(paramView, "$this$postDelayed");
    j.f(parama, "action");
    parama = new Runnable()
    {
      public final void run()
      {
        this.$action.invoke();
      }
    };
    paramView.postDelayed(parama, paramLong);
    return parama;
  }
  
  @RequiresApi(16)
  public static final Runnable postOnAnimationDelayed(View paramView, long paramLong, a<p> parama)
  {
    j.f(paramView, "$this$postOnAnimationDelayed");
    j.f(parama, "action");
    parama = new Runnable()
    {
      public final void run()
      {
        this.$action.invoke();
      }
    };
    paramView.postOnAnimationDelayed(parama, paramLong);
    return parama;
  }
  
  public static final void setGone(View paramView, boolean paramBoolean)
  {
    j.f(paramView, "$this$isGone");
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    paramView.setVisibility(i);
  }
  
  public static final void setInvisible(View paramView, boolean paramBoolean)
  {
    j.f(paramView, "$this$isInvisible");
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    }
    paramView.setVisibility(i);
  }
  
  public static final void setPadding(View paramView, @Px int paramInt)
  {
    j.f(paramView, "$this$setPadding");
    paramView.setPadding(paramInt, paramInt, paramInt, paramInt);
  }
  
  public static final void setVisible(View paramView, boolean paramBoolean)
  {
    j.f(paramView, "$this$isVisible");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    paramView.setVisibility(i);
  }
  
  public static final void updateLayoutParams(View paramView, l<? super ViewGroup.LayoutParams, p> paraml)
  {
    j.f(paramView, "$this$updateLayoutParams");
    j.f(paraml, "block");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams != null)
    {
      paraml.invoke(localLayoutParams);
      paramView.setLayoutParams(localLayoutParams);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
  }
  
  public static final void updatePadding(View paramView, @Px int paramInt1, @Px int paramInt2, @Px int paramInt3, @Px int paramInt4)
  {
    j.f(paramView, "$this$updatePadding");
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @RequiresApi(17)
  public static final void updatePaddingRelative(View paramView, @Px int paramInt1, @Px int paramInt2, @Px int paramInt3, @Px int paramInt4)
  {
    j.f(paramView, "$this$updatePaddingRelative");
    paramView.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\ViewKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */