package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.sequences.f;

public final class ViewGroupKt
{
  public static final boolean contains(ViewGroup paramViewGroup, View paramView)
  {
    j.f(paramViewGroup, "$this$contains");
    j.f(paramView, "view");
    boolean bool;
    if (paramViewGroup.indexOfChild(paramView) != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final void forEach(ViewGroup paramViewGroup, l<? super View, kotlin.p> paraml)
  {
    j.f(paramViewGroup, "$this$forEach");
    j.f(paraml, "action");
    int i = paramViewGroup.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = paramViewGroup.getChildAt(j);
      j.b(localView, "getChildAt(index)");
      paraml.invoke(localView);
    }
  }
  
  public static final void forEachIndexed(ViewGroup paramViewGroup, kotlin.jvm.b.p<? super Integer, ? super View, kotlin.p> paramp)
  {
    j.f(paramViewGroup, "$this$forEachIndexed");
    j.f(paramp, "action");
    int i = paramViewGroup.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = paramViewGroup.getChildAt(j);
      j.b(localView, "getChildAt(index)");
      paramp.invoke(Integer.valueOf(j), localView);
    }
  }
  
  public static final View get(ViewGroup paramViewGroup, int paramInt)
  {
    j.f(paramViewGroup, "$this$get");
    Object localObject = paramViewGroup.getChildAt(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", Size: ");
    ((StringBuilder)localObject).append(paramViewGroup.getChildCount());
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public static final f<View> getChildren(ViewGroup paramViewGroup)
  {
    j.f(paramViewGroup, "$this$children");
    new f()
    {
      public Iterator<View> iterator()
      {
        return ViewGroupKt.iterator(this.$this_children);
      }
    };
  }
  
  public static final int getSize(ViewGroup paramViewGroup)
  {
    j.f(paramViewGroup, "$this$size");
    return paramViewGroup.getChildCount();
  }
  
  public static final boolean isEmpty(ViewGroup paramViewGroup)
  {
    j.f(paramViewGroup, "$this$isEmpty");
    boolean bool;
    if (paramViewGroup.getChildCount() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean isNotEmpty(ViewGroup paramViewGroup)
  {
    j.f(paramViewGroup, "$this$isNotEmpty");
    boolean bool;
    if (paramViewGroup.getChildCount() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final Iterator<View> iterator(ViewGroup paramViewGroup)
  {
    j.f(paramViewGroup, "$this$iterator");
    new Iterator()
    {
      private int index;
      
      public boolean hasNext()
      {
        boolean bool;
        if (this.index < this.$this_iterator.getChildCount()) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public View next()
      {
        Object localObject = this.$this_iterator;
        int i = this.index;
        this.index = (i + 1);
        localObject = ((ViewGroup)localObject).getChildAt(i);
        if (localObject != null) {
          return (View)localObject;
        }
        throw new IndexOutOfBoundsException();
      }
      
      public void remove()
      {
        ViewGroup localViewGroup = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        localViewGroup.removeViewAt(i);
      }
    };
  }
  
  public static final void minusAssign(ViewGroup paramViewGroup, View paramView)
  {
    j.f(paramViewGroup, "$this$minusAssign");
    j.f(paramView, "view");
    paramViewGroup.removeView(paramView);
  }
  
  public static final void plusAssign(ViewGroup paramViewGroup, View paramView)
  {
    j.f(paramViewGroup, "$this$plusAssign");
    j.f(paramView, "view");
    paramViewGroup.addView(paramView);
  }
  
  public static final void setMargins(ViewGroup.MarginLayoutParams paramMarginLayoutParams, @Px int paramInt)
  {
    j.f(paramMarginLayoutParams, "$this$setMargins");
    paramMarginLayoutParams.setMargins(paramInt, paramInt, paramInt, paramInt);
  }
  
  public static final void updateMargins(ViewGroup.MarginLayoutParams paramMarginLayoutParams, @Px int paramInt1, @Px int paramInt2, @Px int paramInt3, @Px int paramInt4)
  {
    j.f(paramMarginLayoutParams, "$this$updateMargins");
    paramMarginLayoutParams.setMargins(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @RequiresApi(17)
  public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams paramMarginLayoutParams, @Px int paramInt1, @Px int paramInt2, @Px int paramInt3, @Px int paramInt4)
  {
    j.f(paramMarginLayoutParams, "$this$updateMarginsRelative");
    paramMarginLayoutParams.setMarginStart(paramInt1);
    paramMarginLayoutParams.topMargin = paramInt2;
    paramMarginLayoutParams.setMarginEnd(paramInt3);
    paramMarginLayoutParams.bottomMargin = paramInt4;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\ViewGroupKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */