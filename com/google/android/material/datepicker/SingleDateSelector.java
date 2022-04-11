package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class SingleDateSelector
  implements DateSelector<Long>
{
  public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator()
  {
    @NonNull
    public SingleDateSelector createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      SingleDateSelector localSingleDateSelector = new SingleDateSelector();
      SingleDateSelector.access$102(localSingleDateSelector, (Long)paramAnonymousParcel.readValue(Long.class.getClassLoader()));
      return localSingleDateSelector;
    }
    
    @NonNull
    public SingleDateSelector[] newArray(int paramAnonymousInt)
    {
      return new SingleDateSelector[paramAnonymousInt];
    }
  };
  @Nullable
  private Long selectedItem;
  
  private void clearSelection()
  {
    this.selectedItem = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDefaultThemeResId(Context paramContext)
  {
    return MaterialAttributes.resolveOrThrow(paramContext, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
  }
  
  public int getDefaultTitleResId()
  {
    return R.string.mtrl_picker_date_header_title;
  }
  
  @NonNull
  public Collection<Long> getSelectedDays()
  {
    ArrayList localArrayList = new ArrayList();
    Long localLong = this.selectedItem;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    return localArrayList;
  }
  
  @NonNull
  public Collection<Pair<Long, Long>> getSelectedRanges()
  {
    return new ArrayList();
  }
  
  @Nullable
  public Long getSelection()
  {
    return this.selectedItem;
  }
  
  @NonNull
  public String getSelectionDisplayString(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    Object localObject = this.selectedItem;
    if (localObject == null) {
      return paramContext.getString(R.string.mtrl_picker_date_header_unselected);
    }
    localObject = DateStrings.getYearMonthDay(((Long)localObject).longValue());
    return paramContext.getString(R.string.mtrl_picker_date_header_selected, new Object[] { localObject });
  }
  
  public boolean isSelectionComplete()
  {
    boolean bool;
    if (this.selectedItem != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public View onCreateTextInputView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle, CalendarConstraints paramCalendarConstraints, @NonNull final OnSelectionChangedListener<Long> paramOnSelectionChangedListener)
  {
    View localView = paramLayoutInflater.inflate(R.layout.mtrl_picker_text_input_date, paramViewGroup, false);
    TextInputLayout localTextInputLayout = (TextInputLayout)localView.findViewById(R.id.mtrl_picker_text_input_date);
    paramBundle = localTextInputLayout.getEditText();
    if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
      paramBundle.setInputType(17);
    }
    paramViewGroup = UtcDates.getTextInputFormat();
    String str = UtcDates.getTextInputHint(localView.getResources(), paramViewGroup);
    paramLayoutInflater = this.selectedItem;
    if (paramLayoutInflater != null) {
      paramBundle.setText(paramViewGroup.format(paramLayoutInflater));
    }
    paramBundle.addTextChangedListener(new DateFormatTextWatcher(str, paramViewGroup, localTextInputLayout, paramCalendarConstraints)
    {
      void onInvalidDate()
      {
        paramOnSelectionChangedListener.onIncompleteSelectionChanged();
      }
      
      void onValidDate(@Nullable Long paramAnonymousLong)
      {
        if (paramAnonymousLong == null) {
          SingleDateSelector.this.clearSelection();
        } else {
          SingleDateSelector.this.select(paramAnonymousLong.longValue());
        }
        paramOnSelectionChangedListener.onSelectionChanged(SingleDateSelector.this.getSelection());
      }
    });
    ViewUtils.requestFocusAndShowKeyboard(paramBundle);
    return localView;
  }
  
  public void select(long paramLong)
  {
    this.selectedItem = Long.valueOf(paramLong);
  }
  
  public void setSelection(@Nullable Long paramLong)
  {
    if (paramLong == null) {
      paramLong = null;
    } else {
      paramLong = Long.valueOf(UtcDates.canonicalYearMonthDay(paramLong.longValue()));
    }
    this.selectedItem = paramLong;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.selectedItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\SingleDateSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */