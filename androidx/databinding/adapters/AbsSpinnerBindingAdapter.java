package androidx.databinding.adapters;

import android.widget.AbsSpinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class AbsSpinnerBindingAdapter
{
  @BindingAdapter({"android:entries"})
  public static <T> void setEntries(AbsSpinner paramAbsSpinner, List<T> paramList)
  {
    if (paramList != null)
    {
      SpinnerAdapter localSpinnerAdapter = paramAbsSpinner.getAdapter();
      if ((localSpinnerAdapter instanceof ObservableListAdapter)) {
        ((ObservableListAdapter)localSpinnerAdapter).setList(paramList);
      } else {
        paramAbsSpinner.setAdapter(new ObservableListAdapter(paramAbsSpinner.getContext(), paramList, 17367048, 17367049, 0));
      }
    }
    else
    {
      paramAbsSpinner.setAdapter(null);
    }
  }
  
  @BindingAdapter({"android:entries"})
  public static <T extends CharSequence> void setEntries(AbsSpinner paramAbsSpinner, T[] paramArrayOfT)
  {
    if (paramArrayOfT != null)
    {
      SpinnerAdapter localSpinnerAdapter = paramAbsSpinner.getAdapter();
      int i = 0;
      if ((localSpinnerAdapter != null) && (localSpinnerAdapter.getCount() == paramArrayOfT.length)) {
        for (int j = 0;; j++)
        {
          k = i;
          if (j >= paramArrayOfT.length) {
            break label69;
          }
          if (!paramArrayOfT[j].equals(localSpinnerAdapter.getItem(j))) {
            break;
          }
        }
      }
      int k = 1;
      label69:
      if (k != 0)
      {
        paramArrayOfT = new ArrayAdapter(paramAbsSpinner.getContext(), 17367048, paramArrayOfT);
        paramArrayOfT.setDropDownViewResource(17367049);
        paramAbsSpinner.setAdapter(paramArrayOfT);
      }
    }
    else
    {
      paramAbsSpinner.setAdapter(null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\AbsSpinnerBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */