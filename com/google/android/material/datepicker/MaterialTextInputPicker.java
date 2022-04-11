package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.LinkedHashSet;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S>
  extends PickerFragment<S>
{
  private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
  private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
  @Nullable
  private CalendarConstraints calendarConstraints;
  @Nullable
  private DateSelector<S> dateSelector;
  
  @NonNull
  static <T> MaterialTextInputPicker<T> newInstance(@NonNull DateSelector<T> paramDateSelector, @NonNull CalendarConstraints paramCalendarConstraints)
  {
    MaterialTextInputPicker localMaterialTextInputPicker = new MaterialTextInputPicker();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("DATE_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    localMaterialTextInputPicker.setArguments(localBundle);
    return localMaterialTextInputPicker;
  }
  
  @NonNull
  public DateSelector<S> getDateSelector()
  {
    DateSelector localDateSelector = this.dateSelector;
    if (localDateSelector != null) {
      return localDateSelector;
    }
    throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.dateSelector = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    this.calendarConstraints = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
  }
  
  @NonNull
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.dateSelector.onCreateTextInputView(paramLayoutInflater, paramViewGroup, paramBundle, this.calendarConstraints, new OnSelectionChangedListener()
    {
      void onIncompleteSelectionChanged()
      {
        Iterator localIterator = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
        while (localIterator.hasNext()) {
          ((OnSelectionChangedListener)localIterator.next()).onIncompleteSelectionChanged();
        }
      }
      
      public void onSelectionChanged(S paramAnonymousS)
      {
        Iterator localIterator = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
        while (localIterator.hasNext()) {
          ((OnSelectionChangedListener)localIterator.next()).onSelectionChanged(paramAnonymousS);
        }
      }
    });
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\MaterialTextInputPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */