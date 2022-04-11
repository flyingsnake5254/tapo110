package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
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
public class RangeDateSelector
  implements DateSelector<Pair<Long, Long>>
{
  public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator()
  {
    @NonNull
    public RangeDateSelector createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      RangeDateSelector localRangeDateSelector = new RangeDateSelector();
      RangeDateSelector.access$302(localRangeDateSelector, (Long)paramAnonymousParcel.readValue(Long.class.getClassLoader()));
      RangeDateSelector.access$402(localRangeDateSelector, (Long)paramAnonymousParcel.readValue(Long.class.getClassLoader()));
      return localRangeDateSelector;
    }
    
    @NonNull
    public RangeDateSelector[] newArray(int paramAnonymousInt)
    {
      return new RangeDateSelector[paramAnonymousInt];
    }
  };
  private final String invalidRangeEndError = " ";
  private String invalidRangeStartError;
  @Nullable
  private Long proposedTextEnd = null;
  @Nullable
  private Long proposedTextStart = null;
  @Nullable
  private Long selectedEndItem = null;
  @Nullable
  private Long selectedStartItem = null;
  
  private void clearInvalidRange(@NonNull TextInputLayout paramTextInputLayout1, @NonNull TextInputLayout paramTextInputLayout2)
  {
    if ((paramTextInputLayout1.getError() != null) && (this.invalidRangeStartError.contentEquals(paramTextInputLayout1.getError()))) {
      paramTextInputLayout1.setError(null);
    }
    if ((paramTextInputLayout2.getError() != null) && (" ".contentEquals(paramTextInputLayout2.getError()))) {
      paramTextInputLayout2.setError(null);
    }
  }
  
  private boolean isValidRange(long paramLong1, long paramLong2)
  {
    boolean bool;
    if (paramLong1 <= paramLong2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void setInvalidRange(@NonNull TextInputLayout paramTextInputLayout1, @NonNull TextInputLayout paramTextInputLayout2)
  {
    paramTextInputLayout1.setError(this.invalidRangeStartError);
    paramTextInputLayout2.setError(" ");
  }
  
  private void updateIfValidTextProposal(@NonNull TextInputLayout paramTextInputLayout1, @NonNull TextInputLayout paramTextInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> paramOnSelectionChangedListener)
  {
    Long localLong = this.proposedTextStart;
    if ((localLong != null) && (this.proposedTextEnd != null))
    {
      if (isValidRange(localLong.longValue(), this.proposedTextEnd.longValue()))
      {
        this.selectedStartItem = this.proposedTextStart;
        this.selectedEndItem = this.proposedTextEnd;
        paramOnSelectionChangedListener.onSelectionChanged(getSelection());
      }
      else
      {
        setInvalidRange(paramTextInputLayout1, paramTextInputLayout2);
        paramOnSelectionChangedListener.onIncompleteSelectionChanged();
      }
      return;
    }
    clearInvalidRange(paramTextInputLayout1, paramTextInputLayout2);
    paramOnSelectionChangedListener.onIncompleteSelectionChanged();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDefaultThemeResId(@NonNull Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    int i = localResources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis);
    if (Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) > i) {
      i = R.attr.materialCalendarTheme;
    } else {
      i = R.attr.materialCalendarFullscreenTheme;
    }
    return MaterialAttributes.resolveOrThrow(paramContext, i, MaterialDatePicker.class.getCanonicalName());
  }
  
  public int getDefaultTitleResId()
  {
    return R.string.mtrl_picker_range_header_title;
  }
  
  @NonNull
  public Collection<Long> getSelectedDays()
  {
    ArrayList localArrayList = new ArrayList();
    Long localLong = this.selectedStartItem;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    localLong = this.selectedEndItem;
    if (localLong != null) {
      localArrayList.add(localLong);
    }
    return localArrayList;
  }
  
  @NonNull
  public Collection<Pair<Long, Long>> getSelectedRanges()
  {
    if ((this.selectedStartItem != null) && (this.selectedEndItem != null))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
      return localArrayList;
    }
    return new ArrayList();
  }
  
  @NonNull
  public Pair<Long, Long> getSelection()
  {
    return new Pair(this.selectedStartItem, this.selectedEndItem);
  }
  
  @NonNull
  public String getSelectionDisplayString(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    Object localObject = this.selectedStartItem;
    if ((localObject == null) && (this.selectedEndItem == null)) {
      return paramContext.getString(R.string.mtrl_picker_range_header_unselected);
    }
    Long localLong = this.selectedEndItem;
    if (localLong == null) {
      return paramContext.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[] { DateStrings.getDateString(((Long)localObject).longValue()) });
    }
    if (localObject == null) {
      return paramContext.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[] { DateStrings.getDateString(localLong.longValue()) });
    }
    localObject = DateStrings.getDateRangeString((Long)localObject, localLong);
    return paramContext.getString(R.string.mtrl_picker_range_header_selected, new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
  }
  
  public boolean isSelectionComplete()
  {
    Long localLong = this.selectedStartItem;
    boolean bool;
    if ((localLong != null) && (this.selectedEndItem != null) && (isValidRange(localLong.longValue(), this.selectedEndItem.longValue()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public View onCreateTextInputView(@NonNull LayoutInflater paramLayoutInflater, @Nullable final ViewGroup paramViewGroup, @Nullable final Bundle paramBundle, CalendarConstraints paramCalendarConstraints, @NonNull final OnSelectionChangedListener<Pair<Long, Long>> paramOnSelectionChangedListener)
  {
    View localView = paramLayoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, paramViewGroup, false);
    paramViewGroup = (TextInputLayout)localView.findViewById(R.id.mtrl_picker_text_input_range_start);
    paramBundle = (TextInputLayout)localView.findViewById(R.id.mtrl_picker_text_input_range_end);
    EditText localEditText = paramViewGroup.getEditText();
    paramLayoutInflater = paramBundle.getEditText();
    if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters())
    {
      localEditText.setInputType(17);
      paramLayoutInflater.setInputType(17);
    }
    this.invalidRangeStartError = localView.getResources().getString(R.string.mtrl_picker_invalid_range);
    SimpleDateFormat localSimpleDateFormat = UtcDates.getTextInputFormat();
    Object localObject = this.selectedStartItem;
    if (localObject != null)
    {
      localEditText.setText(localSimpleDateFormat.format(localObject));
      this.proposedTextStart = this.selectedStartItem;
    }
    localObject = this.selectedEndItem;
    if (localObject != null)
    {
      paramLayoutInflater.setText(localSimpleDateFormat.format(localObject));
      this.proposedTextEnd = this.selectedEndItem;
    }
    localObject = UtcDates.getTextInputHint(localView.getResources(), localSimpleDateFormat);
    localEditText.addTextChangedListener(new DateFormatTextWatcher((String)localObject, localSimpleDateFormat, paramViewGroup, paramCalendarConstraints)
    {
      void onInvalidDate()
      {
        RangeDateSelector.access$002(RangeDateSelector.this, null);
        RangeDateSelector.this.updateIfValidTextProposal(paramViewGroup, paramBundle, paramOnSelectionChangedListener);
      }
      
      void onValidDate(@Nullable Long paramAnonymousLong)
      {
        RangeDateSelector.access$002(RangeDateSelector.this, paramAnonymousLong);
        RangeDateSelector.this.updateIfValidTextProposal(paramViewGroup, paramBundle, paramOnSelectionChangedListener);
      }
    });
    paramLayoutInflater.addTextChangedListener(new DateFormatTextWatcher((String)localObject, localSimpleDateFormat, paramBundle, paramCalendarConstraints)
    {
      void onInvalidDate()
      {
        RangeDateSelector.access$202(RangeDateSelector.this, null);
        RangeDateSelector.this.updateIfValidTextProposal(paramViewGroup, paramBundle, paramOnSelectionChangedListener);
      }
      
      void onValidDate(@Nullable Long paramAnonymousLong)
      {
        RangeDateSelector.access$202(RangeDateSelector.this, paramAnonymousLong);
        RangeDateSelector.this.updateIfValidTextProposal(paramViewGroup, paramBundle, paramOnSelectionChangedListener);
      }
    });
    ViewUtils.requestFocusAndShowKeyboard(localEditText);
    return localView;
  }
  
  public void select(long paramLong)
  {
    Long localLong = this.selectedStartItem;
    if (localLong == null)
    {
      this.selectedStartItem = Long.valueOf(paramLong);
    }
    else if ((this.selectedEndItem == null) && (isValidRange(localLong.longValue(), paramLong)))
    {
      this.selectedEndItem = Long.valueOf(paramLong);
    }
    else
    {
      this.selectedEndItem = null;
      this.selectedStartItem = Long.valueOf(paramLong);
    }
  }
  
  public void setSelection(@NonNull Pair<Long, Long> paramPair)
  {
    Object localObject1 = paramPair.first;
    if ((localObject1 != null) && (paramPair.second != null)) {
      Preconditions.checkArgument(isValidRange(((Long)localObject1).longValue(), ((Long)paramPair.second).longValue()));
    }
    localObject1 = paramPair.first;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long)localObject1).longValue()));
    }
    this.selectedStartItem = ((Long)localObject1);
    paramPair = paramPair.second;
    if (paramPair == null) {
      paramPair = (Pair<Long, Long>)localObject2;
    } else {
      paramPair = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long)paramPair).longValue()));
    }
    this.selectedEndItem = paramPair;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.selectedStartItem);
    paramParcel.writeValue(this.selectedEndItem);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\RangeDateSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */