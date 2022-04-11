package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.sequences.f;

public final class MenuKt
{
  public static final boolean contains(Menu paramMenu, MenuItem paramMenuItem)
  {
    j.f(paramMenu, "$this$contains");
    j.f(paramMenuItem, "item");
    int i = paramMenu.size();
    for (int j = 0; j < i; j++) {
      if (j.a(paramMenu.getItem(j), paramMenuItem)) {
        return true;
      }
    }
    return false;
  }
  
  public static final void forEach(Menu paramMenu, l<? super MenuItem, kotlin.p> paraml)
  {
    j.f(paramMenu, "$this$forEach");
    j.f(paraml, "action");
    int i = paramMenu.size();
    for (int j = 0; j < i; j++)
    {
      MenuItem localMenuItem = paramMenu.getItem(j);
      j.b(localMenuItem, "getItem(index)");
      paraml.invoke(localMenuItem);
    }
  }
  
  public static final void forEachIndexed(Menu paramMenu, kotlin.jvm.b.p<? super Integer, ? super MenuItem, kotlin.p> paramp)
  {
    j.f(paramMenu, "$this$forEachIndexed");
    j.f(paramp, "action");
    int i = paramMenu.size();
    for (int j = 0; j < i; j++)
    {
      MenuItem localMenuItem = paramMenu.getItem(j);
      j.b(localMenuItem, "getItem(index)");
      paramp.invoke(Integer.valueOf(j), localMenuItem);
    }
  }
  
  public static final MenuItem get(Menu paramMenu, int paramInt)
  {
    j.f(paramMenu, "$this$get");
    paramMenu = paramMenu.getItem(paramInt);
    j.b(paramMenu, "getItem(index)");
    return paramMenu;
  }
  
  public static final f<MenuItem> getChildren(Menu paramMenu)
  {
    j.f(paramMenu, "$this$children");
    new f()
    {
      public Iterator<MenuItem> iterator()
      {
        return MenuKt.iterator(this.$this_children);
      }
    };
  }
  
  public static final int getSize(Menu paramMenu)
  {
    j.f(paramMenu, "$this$size");
    return paramMenu.size();
  }
  
  public static final boolean isEmpty(Menu paramMenu)
  {
    j.f(paramMenu, "$this$isEmpty");
    boolean bool;
    if (paramMenu.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final boolean isNotEmpty(Menu paramMenu)
  {
    j.f(paramMenu, "$this$isNotEmpty");
    boolean bool;
    if (paramMenu.size() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static final Iterator<MenuItem> iterator(Menu paramMenu)
  {
    j.f(paramMenu, "$this$iterator");
    new Iterator()
    {
      private int index;
      
      public boolean hasNext()
      {
        boolean bool;
        if (this.index < this.$this_iterator.size()) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public MenuItem next()
      {
        Object localObject = this.$this_iterator;
        int i = this.index;
        this.index = (i + 1);
        localObject = ((Menu)localObject).getItem(i);
        if (localObject != null) {
          return (MenuItem)localObject;
        }
        throw new IndexOutOfBoundsException();
      }
      
      public void remove()
      {
        Menu localMenu = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        localMenu.removeItem(i);
      }
    };
  }
  
  public static final void minusAssign(Menu paramMenu, MenuItem paramMenuItem)
  {
    j.f(paramMenu, "$this$minusAssign");
    j.f(paramMenuItem, "item");
    paramMenu.removeItem(paramMenuItem.getItemId());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\MenuKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */