package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class MaterialDatePicker<S>
  extends DialogFragment
{
  private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
  static final Object CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
  static final Object CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
  private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
  public static final int INPUT_MODE_CALENDAR = 0;
  private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
  public static final int INPUT_MODE_TEXT = 1;
  private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
  private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
  private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
  static final Object TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
  @Nullable
  private MaterialShapeDrawable background;
  private MaterialCalendar<S> calendar;
  @Nullable
  private CalendarConstraints calendarConstraints;
  private Button confirmButton;
  @Nullable
  private DateSelector<S> dateSelector;
  private boolean fullscreen;
  private TextView headerSelectionText;
  private CheckableImageButton headerToggleButton;
  private int inputMode;
  private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners = new LinkedHashSet();
  private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners = new LinkedHashSet();
  private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners = new LinkedHashSet();
  private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners = new LinkedHashSet();
  @StyleRes
  private int overrideThemeResId;
  private PickerFragment<S> pickerFragment;
  private CharSequence titleText;
  @StringRes
  private int titleTextResId;
  
  @NonNull
  private static Drawable createHeaderToggleDrawable(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = AppCompatResources.getDrawable(paramContext, R.drawable.material_ic_calendar_black_24dp);
    localStateListDrawable.addState(new int[] { 16842912 }, localDrawable);
    paramContext = AppCompatResources.getDrawable(paramContext, R.drawable.material_ic_edit_black_24dp);
    localStateListDrawable.addState(new int[0], paramContext);
    return localStateListDrawable;
  }
  
  private static int getDialogPickerHeight(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
    int j = paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding);
    int k = paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
    int m = paramContext.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
    int n = MonthAdapter.MAXIMUM_WEEKS;
    return i + j + k + m + (paramContext.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * n + (n - 1) * paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
  }
  
  private static int getPaddedPickerWidth(@NonNull Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
    int j = Month.current().daysInWeek;
    return i * 2 + paramContext.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * j + (j - 1) * paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
  }
  
  private int getThemeResId(Context paramContext)
  {
    int i = this.overrideThemeResId;
    if (i != 0) {
      return i;
    }
    return this.dateSelector.getDefaultThemeResId(paramContext);
  }
  
  private void initHeaderToggle(Context paramContext)
  {
    this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
    this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(paramContext));
    paramContext = this.headerToggleButton;
    boolean bool;
    if (this.inputMode != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext.setChecked(bool);
    ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
    updateToggleContentDescription(this.headerToggleButton);
    this.headerToggleButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MaterialDatePicker.this.confirmButton.setEnabled(MaterialDatePicker.this.dateSelector.isSelectionComplete());
        MaterialDatePicker.this.headerToggleButton.toggle();
        paramAnonymousView = MaterialDatePicker.this;
        paramAnonymousView.updateToggleContentDescription(paramAnonymousView.headerToggleButton);
        MaterialDatePicker.this.startPickerFragment();
      }
    });
  }
  
  static boolean isFullscreen(@NonNull Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(paramContext, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[] { 16843277 });
    boolean bool = paramContext.getBoolean(0, false);
    paramContext.recycle();
    return bool;
  }
  
  @NonNull
  static <S> MaterialDatePicker<S> newInstance(@NonNull Builder<S> paramBuilder)
  {
    MaterialDatePicker localMaterialDatePicker = new MaterialDatePicker();
    Bundle localBundle = new Bundle();
    localBundle.putInt("OVERRIDE_THEME_RES_ID", paramBuilder.overrideThemeResId);
    localBundle.putParcelable("DATE_SELECTOR_KEY", paramBuilder.dateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramBuilder.calendarConstraints);
    localBundle.putInt("TITLE_TEXT_RES_ID_KEY", paramBuilder.titleTextResId);
    localBundle.putCharSequence("TITLE_TEXT_KEY", paramBuilder.titleText);
    localBundle.putInt("INPUT_MODE_KEY", paramBuilder.inputMode);
    localMaterialDatePicker.setArguments(localBundle);
    return localMaterialDatePicker;
  }
  
  private void startPickerFragment()
  {
    this.calendar = MaterialCalendar.newInstance(this.dateSelector, getThemeResId(requireContext()), this.calendarConstraints);
    if (this.headerToggleButton.isChecked()) {
      localObject = MaterialTextInputPicker.newInstance(this.dateSelector, this.calendarConstraints);
    } else {
      localObject = this.calendar;
    }
    this.pickerFragment = ((PickerFragment)localObject);
    updateHeader();
    Object localObject = getChildFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).replace(R.id.mtrl_calendar_frame, this.pickerFragment);
    ((FragmentTransaction)localObject).commitNow();
    this.pickerFragment.addOnSelectionChangedListener(new OnSelectionChangedListener()
    {
      void onIncompleteSelectionChanged()
      {
        MaterialDatePicker.this.confirmButton.setEnabled(false);
      }
      
      public void onSelectionChanged(S paramAnonymousS)
      {
        MaterialDatePicker.this.updateHeader();
        MaterialDatePicker.this.confirmButton.setEnabled(MaterialDatePicker.this.dateSelector.isSelectionComplete());
      }
    });
  }
  
  public static long thisMonthInUtcMilliseconds()
  {
    return Month.current().timeInMillis;
  }
  
  public static long todayInUtcMilliseconds()
  {
    return UtcDates.getTodayCalendar().getTimeInMillis();
  }
  
  private void updateHeader()
  {
    String str = getHeaderText();
    this.headerSelectionText.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), new Object[] { str }));
    this.headerSelectionText.setText(str);
  }
  
  private void updateToggleContentDescription(@NonNull CheckableImageButton paramCheckableImageButton)
  {
    if (this.headerToggleButton.isChecked()) {
      paramCheckableImageButton = paramCheckableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
    } else {
      paramCheckableImageButton = paramCheckableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
    }
    this.headerToggleButton.setContentDescription(paramCheckableImageButton);
  }
  
  public boolean addOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return this.onCancelListeners.add(paramOnCancelListener);
  }
  
  public boolean addOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return this.onDismissListeners.add(paramOnDismissListener);
  }
  
  public boolean addOnNegativeButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    return this.onNegativeButtonClickListeners.add(paramOnClickListener);
  }
  
  public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> paramMaterialPickerOnPositiveButtonClickListener)
  {
    return this.onPositiveButtonClickListeners.add(paramMaterialPickerOnPositiveButtonClickListener);
  }
  
  public void clearOnCancelListeners()
  {
    this.onCancelListeners.clear();
  }
  
  public void clearOnDismissListeners()
  {
    this.onDismissListeners.clear();
  }
  
  public void clearOnNegativeButtonClickListeners()
  {
    this.onNegativeButtonClickListeners.clear();
  }
  
  public void clearOnPositiveButtonClickListeners()
  {
    this.onPositiveButtonClickListeners.clear();
  }
  
  public String getHeaderText()
  {
    return this.dateSelector.getSelectionDisplayString(getContext());
  }
  
  @Nullable
  public final S getSelection()
  {
    return (S)this.dateSelector.getSelection();
  }
  
  public final void onCancel(@NonNull DialogInterface paramDialogInterface)
  {
    Iterator localIterator = this.onCancelListeners.iterator();
    while (localIterator.hasNext()) {
      ((DialogInterface.OnCancelListener)localIterator.next()).onCancel(paramDialogInterface);
    }
    super.onCancel(paramDialogInterface);
  }
  
  public final void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.overrideThemeResId = localBundle.getInt("OVERRIDE_THEME_RES_ID");
    this.dateSelector = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    this.calendarConstraints = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    this.titleTextResId = localBundle.getInt("TITLE_TEXT_RES_ID_KEY");
    this.titleText = localBundle.getCharSequence("TITLE_TEXT_KEY");
    this.inputMode = localBundle.getInt("INPUT_MODE_KEY");
  }
  
  @NonNull
  public final Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    paramBundle = new Dialog(requireContext(), getThemeResId(requireContext()));
    Context localContext = paramBundle.getContext();
    this.fullscreen = isFullscreen(localContext);
    int i = MaterialAttributes.resolveOrThrow(localContext, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable(localContext, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
    this.background = localMaterialShapeDrawable;
    localMaterialShapeDrawable.initializeElevationOverlay(localContext);
    this.background.setFillColor(ColorStateList.valueOf(i));
    this.background.setElevation(ViewCompat.getElevation(paramBundle.getWindow().getDecorView()));
    return paramBundle;
  }
  
  @NonNull
  public final View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    int i;
    if (this.fullscreen) {
      i = R.layout.mtrl_picker_fullscreen;
    } else {
      i = R.layout.mtrl_picker_dialog;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup);
    paramViewGroup = paramLayoutInflater.getContext();
    if (this.fullscreen)
    {
      paramLayoutInflater.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(paramViewGroup), -2));
    }
    else
    {
      paramBundle = paramLayoutInflater.findViewById(R.id.mtrl_calendar_main_pane);
      localObject = paramLayoutInflater.findViewById(R.id.mtrl_calendar_frame);
      paramBundle.setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(paramViewGroup), -1));
      ((View)localObject).setMinimumHeight(getDialogPickerHeight(requireContext()));
    }
    paramBundle = (TextView)paramLayoutInflater.findViewById(R.id.mtrl_picker_header_selection_text);
    this.headerSelectionText = paramBundle;
    ViewCompat.setAccessibilityLiveRegion(paramBundle, 1);
    this.headerToggleButton = ((CheckableImageButton)paramLayoutInflater.findViewById(R.id.mtrl_picker_header_toggle));
    paramBundle = (TextView)paramLayoutInflater.findViewById(R.id.mtrl_picker_title_text);
    Object localObject = this.titleText;
    if (localObject != null) {
      paramBundle.setText((CharSequence)localObject);
    } else {
      paramBundle.setText(this.titleTextResId);
    }
    initHeaderToggle(paramViewGroup);
    this.confirmButton = ((Button)paramLayoutInflater.findViewById(R.id.confirm_button));
    if (this.dateSelector.isSelectionComplete()) {
      this.confirmButton.setEnabled(true);
    } else {
      this.confirmButton.setEnabled(false);
    }
    this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
    this.confirmButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = MaterialDatePicker.this.onPositiveButtonClickListeners.iterator();
        while (paramAnonymousView.hasNext()) {
          ((MaterialPickerOnPositiveButtonClickListener)paramAnonymousView.next()).onPositiveButtonClick(MaterialDatePicker.this.getSelection());
        }
        MaterialDatePicker.this.dismiss();
      }
    });
    paramViewGroup = (Button)paramLayoutInflater.findViewById(R.id.cancel_button);
    paramViewGroup.setTag(CANCEL_BUTTON_TAG);
    paramViewGroup.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Iterator localIterator = MaterialDatePicker.this.onNegativeButtonClickListeners.iterator();
        while (localIterator.hasNext()) {
          ((View.OnClickListener)localIterator.next()).onClick(paramAnonymousView);
        }
        MaterialDatePicker.this.dismiss();
      }
    });
    return paramLayoutInflater;
  }
  
  public final void onDismiss(@NonNull DialogInterface paramDialogInterface)
  {
    Object localObject = this.onDismissListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((DialogInterface.OnDismissListener)((Iterator)localObject).next()).onDismiss(paramDialogInterface);
    }
    localObject = (ViewGroup)getView();
    if (localObject != null) {
      ((ViewGroup)localObject).removeAllViews();
    }
    super.onDismiss(paramDialogInterface);
  }
  
  public final void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
    CalendarConstraints.Builder localBuilder = new CalendarConstraints.Builder(this.calendarConstraints);
    if (this.calendar.getCurrentMonth() != null) {
      localBuilder.setOpenAt(this.calendar.getCurrentMonth().timeInMillis);
    }
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", localBuilder.build());
    paramBundle.putInt("TITLE_TEXT_RES_ID_KEY", this.titleTextResId);
    paramBundle.putCharSequence("TITLE_TEXT_KEY", this.titleText);
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = requireDialog().getWindow();
    if (this.fullscreen)
    {
      localWindow.setLayout(-1, -1);
      localWindow.setBackgroundDrawable(this.background);
    }
    else
    {
      localWindow.setLayout(-2, -2);
      int i = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
      Rect localRect = new Rect(i, i, i, i);
      localWindow.setBackgroundDrawable(new InsetDrawable(this.background, i, i, i, i));
      localWindow.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), localRect));
    }
    startPickerFragment();
  }
  
  public void onStop()
  {
    this.pickerFragment.clearOnSelectionChangedListeners();
    super.onStop();
  }
  
  public boolean removeOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return this.onCancelListeners.remove(paramOnCancelListener);
  }
  
  public boolean removeOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return this.onDismissListeners.remove(paramOnDismissListener);
  }
  
  public boolean removeOnNegativeButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    return this.onNegativeButtonClickListeners.remove(paramOnClickListener);
  }
  
  public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> paramMaterialPickerOnPositiveButtonClickListener)
  {
    return this.onPositiveButtonClickListeners.remove(paramMaterialPickerOnPositiveButtonClickListener);
  }
  
  public static final class Builder<S>
  {
    CalendarConstraints calendarConstraints;
    final DateSelector<S> dateSelector;
    int inputMode = 0;
    int overrideThemeResId = 0;
    @Nullable
    S selection = null;
    CharSequence titleText = null;
    int titleTextResId = 0;
    
    private Builder(DateSelector<S> paramDateSelector)
    {
      this.dateSelector = paramDateSelector;
    }
    
    @NonNull
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> paramDateSelector)
    {
      return new Builder(paramDateSelector);
    }
    
    @NonNull
    public static Builder<Long> datePicker()
    {
      return new Builder(new SingleDateSelector());
    }
    
    @NonNull
    public static Builder<Pair<Long, Long>> dateRangePicker()
    {
      return new Builder(new RangeDateSelector());
    }
    
    @NonNull
    public MaterialDatePicker<S> build()
    {
      if (this.calendarConstraints == null) {
        this.calendarConstraints = new CalendarConstraints.Builder().build();
      }
      if (this.titleTextResId == 0) {
        this.titleTextResId = this.dateSelector.getDefaultTitleResId();
      }
      Object localObject = this.selection;
      if (localObject != null) {
        this.dateSelector.setSelection(localObject);
      }
      return MaterialDatePicker.newInstance(this);
    }
    
    @NonNull
    public Builder<S> setCalendarConstraints(CalendarConstraints paramCalendarConstraints)
    {
      this.calendarConstraints = paramCalendarConstraints;
      return this;
    }
    
    @NonNull
    public Builder<S> setInputMode(int paramInt)
    {
      this.inputMode = paramInt;
      return this;
    }
    
    @NonNull
    public Builder<S> setSelection(S paramS)
    {
      this.selection = paramS;
      return this;
    }
    
    @NonNull
    public Builder<S> setTheme(@StyleRes int paramInt)
    {
      this.overrideThemeResId = paramInt;
      return this;
    }
    
    @NonNull
    public Builder<S> setTitleText(@StringRes int paramInt)
    {
      this.titleTextResId = paramInt;
      this.titleText = null;
      return this;
    }
    
    @NonNull
    public Builder<S> setTitleText(@Nullable CharSequence paramCharSequence)
    {
      this.titleText = paramCharSequence;
      this.titleTextResId = 0;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface InputMode {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\datepicker\MaterialDatePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */