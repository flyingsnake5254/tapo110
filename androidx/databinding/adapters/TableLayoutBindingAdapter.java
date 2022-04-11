package androidx.databinding.adapters;

import android.util.SparseBooleanArray;
import android.widget.TableLayout;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import java.util.regex.Pattern;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class TableLayoutBindingAdapter
{
  private static final int MAX_COLUMNS = 20;
  private static Pattern sColumnPattern = Pattern.compile("\\s*,\\s*");
  
  private static SparseBooleanArray parseColumns(CharSequence paramCharSequence)
  {
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    if (paramCharSequence == null) {
      return localSparseBooleanArray;
    }
    paramCharSequence = sColumnPattern.split(paramCharSequence);
    int i = paramCharSequence.length;
    int j = 0;
    while (j < i)
    {
      String str = paramCharSequence[j];
      try
      {
        int k = Integer.parseInt(str);
        if (k >= 0) {
          localSparseBooleanArray.put(k, true);
        }
        j++;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
    return localSparseBooleanArray;
  }
  
  @BindingAdapter({"android:collapseColumns"})
  public static void setCollapseColumns(TableLayout paramTableLayout, CharSequence paramCharSequence)
  {
    paramCharSequence = parseColumns(paramCharSequence);
    for (int i = 0; i < 20; i++)
    {
      boolean bool = paramCharSequence.get(i, false);
      if (bool != paramTableLayout.isColumnCollapsed(i)) {
        paramTableLayout.setColumnCollapsed(i, bool);
      }
    }
  }
  
  @BindingAdapter({"android:shrinkColumns"})
  public static void setShrinkColumns(TableLayout paramTableLayout, CharSequence paramCharSequence)
  {
    int i = 0;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0) && (paramCharSequence.charAt(0) == '*'))
    {
      paramTableLayout.setShrinkAllColumns(true);
    }
    else
    {
      paramTableLayout.setShrinkAllColumns(false);
      paramCharSequence = parseColumns(paramCharSequence);
      int j = paramCharSequence.size();
      while (i < j)
      {
        int k = paramCharSequence.keyAt(i);
        boolean bool = paramCharSequence.valueAt(i);
        if (bool) {
          paramTableLayout.setColumnShrinkable(k, bool);
        }
        i++;
      }
    }
  }
  
  @BindingAdapter({"android:stretchColumns"})
  public static void setStretchColumns(TableLayout paramTableLayout, CharSequence paramCharSequence)
  {
    int i = 0;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0) && (paramCharSequence.charAt(0) == '*'))
    {
      paramTableLayout.setStretchAllColumns(true);
    }
    else
    {
      paramTableLayout.setStretchAllColumns(false);
      paramCharSequence = parseColumns(paramCharSequence);
      int j = paramCharSequence.size();
      while (i < j)
      {
        int k = paramCharSequence.keyAt(i);
        boolean bool = paramCharSequence.valueAt(i);
        if (bool) {
          paramTableLayout.setColumnStretchable(k, bool);
        }
        i++;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\TableLayoutBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */