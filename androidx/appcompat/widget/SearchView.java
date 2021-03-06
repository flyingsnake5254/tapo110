package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.string;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements CollapsibleActionView
{
  static final boolean DBG = false;
  private static final String IME_OPTION_NO_MICROPHONE = "nm";
  static final String LOG_TAG = "SearchView";
  static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER;
  private Bundle mAppSearchData;
  private boolean mClearingFocus;
  final ImageView mCloseButton;
  private final ImageView mCollapsedIcon;
  private int mCollapsedImeOptions;
  private final CharSequence mDefaultQueryHint;
  private final View mDropDownAnchor;
  private boolean mExpandedInActionView;
  final ImageView mGoButton;
  private boolean mIconified;
  private boolean mIconifiedByDefault;
  private int mMaxWidth;
  private CharSequence mOldQueryText;
  private final View.OnClickListener mOnClickListener;
  private OnCloseListener mOnCloseListener;
  private final TextView.OnEditorActionListener mOnEditorActionListener;
  private final AdapterView.OnItemClickListener mOnItemClickListener;
  private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
  private OnQueryTextListener mOnQueryChangeListener;
  View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
  private View.OnClickListener mOnSearchClickListener;
  private OnSuggestionListener mOnSuggestionListener;
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache = new WeakHashMap();
  private CharSequence mQueryHint;
  private boolean mQueryRefinement;
  private Runnable mReleaseCursorRunnable = new Runnable()
  {
    public void run()
    {
      CursorAdapter localCursorAdapter = SearchView.this.mSuggestionsAdapter;
      if ((localCursorAdapter instanceof SuggestionsAdapter)) {
        localCursorAdapter.changeCursor(null);
      }
    }
  };
  final ImageView mSearchButton;
  private final View mSearchEditFrame;
  private final Drawable mSearchHintIcon;
  private final View mSearchPlate;
  final SearchAutoComplete mSearchSrcTextView;
  private Rect mSearchSrcTextViewBounds = new Rect();
  private Rect mSearchSrtTextViewBoundsExpanded = new Rect();
  SearchableInfo mSearchable;
  private final View mSubmitArea;
  private boolean mSubmitButtonEnabled;
  private final int mSuggestionCommitIconResId;
  private final int mSuggestionRowLayout;
  CursorAdapter mSuggestionsAdapter;
  private int[] mTemp = new int[2];
  private int[] mTemp2 = new int[2];
  View.OnKeyListener mTextKeyListener;
  private TextWatcher mTextWatcher;
  private UpdatableTouchDelegate mTouchDelegate;
  private final Runnable mUpdateDrawableStateRunnable = new Runnable()
  {
    public void run()
    {
      SearchView.this.updateFocusedState();
    }
  };
  private CharSequence mUserQuery;
  private final Intent mVoiceAppSearchIntent;
  final ImageView mVoiceButton;
  private boolean mVoiceButtonEnabled;
  private final Intent mVoiceWebSearchIntent;
  
  static
  {
    PreQAutoCompleteTextViewReflector localPreQAutoCompleteTextViewReflector;
    if (Build.VERSION.SDK_INT < 29) {
      localPreQAutoCompleteTextViewReflector = new PreQAutoCompleteTextViewReflector();
    } else {
      localPreQAutoCompleteTextViewReflector = null;
    }
    PRE_API_29_HIDDEN_METHOD_INVOKER = localPreQAutoCompleteTextViewReflector;
  }
  
  public SearchView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.searchViewStyle);
  }
  
  public SearchView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.OnClickListener local5 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SearchView localSearchView = SearchView.this;
        if (paramAnonymousView == localSearchView.mSearchButton) {
          localSearchView.onSearchClicked();
        } else if (paramAnonymousView == localSearchView.mCloseButton) {
          localSearchView.onCloseClicked();
        } else if (paramAnonymousView == localSearchView.mGoButton) {
          localSearchView.onSubmitQuery();
        } else if (paramAnonymousView == localSearchView.mVoiceButton) {
          localSearchView.onVoiceClicked();
        } else if (paramAnonymousView == localSearchView.mSearchSrcTextView) {
          localSearchView.forceSuggestionQuery();
        }
      }
    };
    this.mOnClickListener = local5;
    this.mTextKeyListener = new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        SearchView localSearchView = SearchView.this;
        if (localSearchView.mSearchable == null) {
          return false;
        }
        if ((localSearchView.mSearchSrcTextView.isPopupShowing()) && (SearchView.this.mSearchSrcTextView.getListSelection() != -1)) {
          return SearchView.this.onSuggestionsKey(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
        }
        if ((!SearchView.this.mSearchSrcTextView.isEmpty()) && (paramAnonymousKeyEvent.hasNoModifiers()) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66))
        {
          paramAnonymousView.cancelLongPress();
          paramAnonymousView = SearchView.this;
          paramAnonymousView.launchQuerySearch(0, null, paramAnonymousView.mSearchSrcTextView.getText().toString());
          return true;
        }
        return false;
      }
    };
    TextView.OnEditorActionListener local7 = new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        SearchView.this.onSubmitQuery();
        return true;
      }
    };
    this.mOnEditorActionListener = local7;
    AdapterView.OnItemClickListener local8 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        SearchView.this.onItemClicked(paramAnonymousInt, 0, null);
      }
    };
    this.mOnItemClickListener = local8;
    AdapterView.OnItemSelectedListener local9 = new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        SearchView.this.onItemSelected(paramAnonymousInt);
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.mOnItemSelectedListener = local9;
    this.mTextWatcher = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        SearchView.this.onTextChanged(paramAnonymousCharSequence);
      }
    };
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.getResourceId(R.styleable.SearchView_layout, R.layout.abc_search_view), this, true);
    paramContext = (SearchAutoComplete)findViewById(R.id.search_src_text);
    this.mSearchSrcTextView = paramContext;
    paramContext.setSearchView(this);
    this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
    View localView1 = findViewById(R.id.search_plate);
    this.mSearchPlate = localView1;
    View localView2 = findViewById(R.id.submit_area);
    this.mSubmitArea = localView2;
    ImageView localImageView1 = (ImageView)findViewById(R.id.search_button);
    this.mSearchButton = localImageView1;
    ImageView localImageView2 = (ImageView)findViewById(R.id.search_go_btn);
    this.mGoButton = localImageView2;
    ImageView localImageView3 = (ImageView)findViewById(R.id.search_close_btn);
    this.mCloseButton = localImageView3;
    ImageView localImageView4 = (ImageView)findViewById(R.id.search_voice_btn);
    this.mVoiceButton = localImageView4;
    ImageView localImageView5 = (ImageView)findViewById(R.id.search_mag_icon);
    this.mCollapsedIcon = localImageView5;
    ViewCompat.setBackground(localView1, paramAttributeSet.getDrawable(R.styleable.SearchView_queryBackground));
    ViewCompat.setBackground(localView2, paramAttributeSet.getDrawable(R.styleable.SearchView_submitBackground));
    paramInt = R.styleable.SearchView_searchIcon;
    localImageView1.setImageDrawable(paramAttributeSet.getDrawable(paramInt));
    localImageView2.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_goIcon));
    localImageView3.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_closeIcon));
    localImageView4.setImageDrawable(paramAttributeSet.getDrawable(R.styleable.SearchView_voiceIcon));
    localImageView5.setImageDrawable(paramAttributeSet.getDrawable(paramInt));
    this.mSearchHintIcon = paramAttributeSet.getDrawable(R.styleable.SearchView_searchHintIcon);
    TooltipCompat.setTooltipText(localImageView1, getResources().getString(R.string.abc_searchview_description_search));
    this.mSuggestionRowLayout = paramAttributeSet.getResourceId(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
    this.mSuggestionCommitIconResId = paramAttributeSet.getResourceId(R.styleable.SearchView_commitIcon, 0);
    localImageView1.setOnClickListener(local5);
    localImageView3.setOnClickListener(local5);
    localImageView2.setOnClickListener(local5);
    localImageView4.setOnClickListener(local5);
    paramContext.setOnClickListener(local5);
    paramContext.addTextChangedListener(this.mTextWatcher);
    paramContext.setOnEditorActionListener(local7);
    paramContext.setOnItemClickListener(local8);
    paramContext.setOnItemSelectedListener(local9);
    paramContext.setOnKeyListener(this.mTextKeyListener);
    paramContext.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        paramAnonymousView = SearchView.this;
        View.OnFocusChangeListener localOnFocusChangeListener = paramAnonymousView.mOnQueryTextFocusChangeListener;
        if (localOnFocusChangeListener != null) {
          localOnFocusChangeListener.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
      }
    });
    setIconifiedByDefault(paramAttributeSet.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.mDefaultQueryHint = paramAttributeSet.getText(R.styleable.SearchView_defaultQueryHint);
    this.mQueryHint = paramAttributeSet.getText(R.styleable.SearchView_queryHint);
    paramInt = paramAttributeSet.getInt(R.styleable.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(R.styleable.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(R.styleable.SearchView_android_focusable, true));
    paramAttributeSet.recycle();
    paramAttributeSet = new Intent("android.speech.action.WEB_SEARCH");
    this.mVoiceWebSearchIntent = paramAttributeSet;
    paramAttributeSet.addFlags(268435456);
    paramAttributeSet.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    paramAttributeSet = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.mVoiceAppSearchIntent = paramAttributeSet;
    paramAttributeSet.addFlags(268435456);
    paramContext = findViewById(paramContext.getDropDownAnchor());
    this.mDropDownAnchor = paramContext;
    if (paramContext != null) {
      paramContext.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          SearchView.this.adjustDropDownSizeAndPosition();
        }
      });
    }
    updateViewsVisibility(this.mIconifiedByDefault);
    updateQueryHint();
  }
  
  private Intent createIntent(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.mUserQuery);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    paramUri = this.mAppSearchData;
    if (paramUri != null) {
      paramString1.putExtra("app_data", paramUri);
    }
    if (paramInt != 0)
    {
      paramString1.putExtra("action_key", paramInt);
      paramString1.putExtra("action_msg", paramString4);
    }
    paramString1.setComponent(this.mSearchable.getSearchActivity());
    return paramString1;
  }
  
  private Intent createIntentFromSuggestion(Cursor paramCursor, int paramInt, String paramString)
  {
    try
    {
      Object localObject1 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_action");
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.mSearchable.getSuggestIntentAction();
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "android.intent.action.SEARCH";
      }
      Object localObject3 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_data");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = this.mSearchable.getSuggestIntentData();
      }
      localObject3 = localObject2;
      if (localObject2 != null)
      {
        String str = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_data_id");
        localObject3 = localObject2;
        if (str != null)
        {
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("/");
          ((StringBuilder)localObject3).append(Uri.encode(str));
          localObject3 = ((StringBuilder)localObject3).toString();
        }
      }
      if (localObject3 == null) {
        localObject2 = null;
      } else {
        localObject2 = Uri.parse((String)localObject3);
      }
      localObject3 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_query");
      paramString = createIntent((String)localObject1, (Uri)localObject2, SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_extra_data"), (String)localObject3, paramInt, paramString);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      try
      {
        paramInt = paramCursor.getPosition();
      }
      catch (RuntimeException paramCursor)
      {
        paramInt = -1;
      }
      paramCursor = new StringBuilder();
      paramCursor.append("Search suggestions cursor at row ");
      paramCursor.append(paramInt);
      paramCursor.append(" returned exception.");
      Log.w("SearchView", paramCursor.toString(), paramString);
    }
    return null;
  }
  
  private Intent createVoiceAppSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    Object localObject1 = new Intent("android.intent.action.SEARCH");
    ((Intent)localObject1).setComponent(localComponentName);
    PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, (Intent)localObject1, 1073741824);
    Bundle localBundle = new Bundle();
    localObject1 = this.mAppSearchData;
    if (localObject1 != null) {
      localBundle.putParcelable("app_data", (Parcelable)localObject1);
    }
    Intent localIntent = new Intent(paramIntent);
    int i = 1;
    Object localObject2 = getResources();
    if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
      paramIntent = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageModeId());
    } else {
      paramIntent = "free_form";
    }
    int j = paramSearchableInfo.getVoicePromptTextId();
    Object localObject3 = null;
    if (j != 0) {
      localObject1 = ((Resources)localObject2).getString(paramSearchableInfo.getVoicePromptTextId());
    } else {
      localObject1 = null;
    }
    if (paramSearchableInfo.getVoiceLanguageId() != 0) {
      localObject2 = ((Resources)localObject2).getString(paramSearchableInfo.getVoiceLanguageId());
    } else {
      localObject2 = null;
    }
    if (paramSearchableInfo.getVoiceMaxResults() != 0) {
      i = paramSearchableInfo.getVoiceMaxResults();
    }
    localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramIntent);
    localIntent.putExtra("android.speech.extra.PROMPT", (String)localObject1);
    localIntent.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
    localIntent.putExtra("android.speech.extra.MAX_RESULTS", i);
    if (localComponentName == null) {
      paramIntent = (Intent)localObject3;
    } else {
      paramIntent = localComponentName.flattenToShortString();
    }
    localIntent.putExtra("calling_package", paramIntent);
    localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
    localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
    return localIntent;
  }
  
  private Intent createVoiceWebSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Intent localIntent = new Intent(paramIntent);
    paramIntent = paramSearchableInfo.getSearchActivity();
    if (paramIntent == null) {
      paramIntent = null;
    } else {
      paramIntent = paramIntent.flattenToShortString();
    }
    localIntent.putExtra("calling_package", paramIntent);
    return localIntent;
  }
  
  private void dismissSuggestions()
  {
    this.mSearchSrcTextView.dismissDropDown();
  }
  
  private void getChildBoundsWithinSearchView(View paramView, Rect paramRect)
  {
    paramView.getLocationInWindow(this.mTemp);
    getLocationInWindow(this.mTemp2);
    int[] arrayOfInt1 = this.mTemp;
    int i = arrayOfInt1[1];
    int[] arrayOfInt2 = this.mTemp2;
    i -= arrayOfInt2[1];
    int j = arrayOfInt1[0] - arrayOfInt2[0];
    paramRect.set(j, i, paramView.getWidth() + j, paramView.getHeight() + i);
  }
  
  private CharSequence getDecoratedHint(CharSequence paramCharSequence)
  {
    if ((this.mIconifiedByDefault) && (this.mSearchHintIcon != null))
    {
      int i = (int)(this.mSearchSrcTextView.getTextSize() * 1.25D);
      this.mSearchHintIcon.setBounds(0, 0, i, i);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
      localSpannableStringBuilder.setSpan(new ImageSpan(this.mSearchHintIcon), 1, 2, 33);
      localSpannableStringBuilder.append(paramCharSequence);
      return localSpannableStringBuilder;
    }
    return paramCharSequence;
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  private boolean hasVoiceSearch()
  {
    Object localObject = this.mSearchable;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((SearchableInfo)localObject).getVoiceSearchEnabled())
      {
        localObject = null;
        if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
          localObject = this.mVoiceWebSearchIntent;
        } else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
          localObject = this.mVoiceAppSearchIntent;
        }
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          if (getContext().getPackageManager().resolveActivity((Intent)localObject, 65536) != null) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  static boolean isLandscapeMode(Context paramContext)
  {
    boolean bool;
    if (paramContext.getResources().getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean isSubmitAreaEnabled()
  {
    boolean bool;
    if (((this.mSubmitButtonEnabled) || (this.mVoiceButtonEnabled)) && (!isIconified())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void launchIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      getContext().startActivity(paramIntent);
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed launch activity: ");
      localStringBuilder.append(paramIntent);
      Log.e("SearchView", localStringBuilder.toString(), localRuntimeException);
    }
  }
  
  private boolean launchSuggestion(int paramInt1, int paramInt2, String paramString)
  {
    Cursor localCursor = this.mSuggestionsAdapter.getCursor();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt1)))
    {
      launchIntent(createIntentFromSuggestion(localCursor, paramInt2, paramString));
      return true;
    }
    return false;
  }
  
  private void postUpdateFocusedState()
  {
    post(this.mUpdateDrawableStateRunnable);
  }
  
  private void rewriteQueryFromSuggestion(int paramInt)
  {
    Editable localEditable = this.mSearchSrcTextView.getText();
    Object localObject = this.mSuggestionsAdapter.getCursor();
    if (localObject == null) {
      return;
    }
    if (((Cursor)localObject).moveToPosition(paramInt))
    {
      localObject = this.mSuggestionsAdapter.convertToString((Cursor)localObject);
      if (localObject != null) {
        setQuery((CharSequence)localObject);
      } else {
        setQuery(localEditable);
      }
    }
    else
    {
      setQuery(localEditable);
    }
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    this.mSearchSrcTextView.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.mSearchSrcTextView;
    int i;
    if (TextUtils.isEmpty(paramCharSequence)) {
      i = 0;
    } else {
      i = paramCharSequence.length();
    }
    localSearchAutoComplete.setSelection(i);
  }
  
  private void updateCloseButton()
  {
    boolean bool = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
    int i = 1;
    int j = bool ^ true;
    int k = 0;
    int m = i;
    if (j == 0) {
      if ((this.mIconifiedByDefault) && (!this.mExpandedInActionView)) {
        m = i;
      } else {
        m = 0;
      }
    }
    Object localObject = this.mCloseButton;
    if (m != 0) {
      m = k;
    } else {
      m = 8;
    }
    ((ImageView)localObject).setVisibility(m);
    Drawable localDrawable = this.mCloseButton.getDrawable();
    if (localDrawable != null)
    {
      if (j != 0) {
        localObject = ViewGroup.ENABLED_STATE_SET;
      } else {
        localObject = ViewGroup.EMPTY_STATE_SET;
      }
      localDrawable.setState((int[])localObject);
    }
  }
  
  private void updateQueryHint()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.mSearchSrcTextView;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(getDecoratedHint((CharSequence)localObject));
  }
  
  private void updateSearchAutoComplete()
  {
    this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
    this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
    int i = this.mSearchable.getInputType();
    int j = 1;
    int k = i;
    if ((i & 0xF) == 1)
    {
      i &= 0xFFFEFFFF;
      k = i;
      if (this.mSearchable.getSuggestAuthority() != null) {
        k = i | 0x10000 | 0x80000;
      }
    }
    this.mSearchSrcTextView.setInputType(k);
    Object localObject = this.mSuggestionsAdapter;
    if (localObject != null) {
      ((CursorAdapter)localObject).changeCursor(null);
    }
    if (this.mSearchable.getSuggestAuthority() != null)
    {
      localObject = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
      this.mSuggestionsAdapter = ((CursorAdapter)localObject);
      this.mSearchSrcTextView.setAdapter((ListAdapter)localObject);
      localObject = (SuggestionsAdapter)this.mSuggestionsAdapter;
      k = j;
      if (this.mQueryRefinement) {
        k = 2;
      }
      ((SuggestionsAdapter)localObject).setQueryRefinement(k);
    }
  }
  
  private void updateSubmitArea()
  {
    int i;
    if ((isSubmitAreaEnabled()) && ((this.mGoButton.getVisibility() == 0) || (this.mVoiceButton.getVisibility() == 0))) {
      i = 0;
    } else {
      i = 8;
    }
    this.mSubmitArea.setVisibility(i);
  }
  
  private void updateSubmitButton(boolean paramBoolean)
  {
    int i;
    if ((this.mSubmitButtonEnabled) && (isSubmitAreaEnabled()) && (hasFocus()) && ((paramBoolean) || (!this.mVoiceButtonEnabled))) {
      i = 0;
    } else {
      i = 8;
    }
    this.mGoButton.setVisibility(i);
  }
  
  private void updateViewsVisibility(boolean paramBoolean)
  {
    this.mIconified = paramBoolean;
    int i = 0;
    int j;
    if (paramBoolean) {
      j = 0;
    } else {
      j = 8;
    }
    boolean bool = TextUtils.isEmpty(this.mSearchSrcTextView.getText()) ^ true;
    this.mSearchButton.setVisibility(j);
    updateSubmitButton(bool);
    View localView = this.mSearchEditFrame;
    if (paramBoolean) {
      j = 8;
    } else {
      j = 0;
    }
    localView.setVisibility(j);
    if (this.mCollapsedIcon.getDrawable() != null)
    {
      j = i;
      if (!this.mIconifiedByDefault) {}
    }
    else
    {
      j = 8;
    }
    this.mCollapsedIcon.setVisibility(j);
    updateCloseButton();
    updateVoiceButton(bool ^ true);
    updateSubmitArea();
  }
  
  private void updateVoiceButton(boolean paramBoolean)
  {
    boolean bool = this.mVoiceButtonEnabled;
    int i = 8;
    int j = i;
    if (bool)
    {
      j = i;
      if (!isIconified())
      {
        j = i;
        if (paramBoolean)
        {
          this.mGoButton.setVisibility(8);
          j = 0;
        }
      }
    }
    this.mVoiceButton.setVisibility(j);
  }
  
  void adjustDropDownSizeAndPosition()
  {
    if (this.mDropDownAnchor.getWidth() > 1)
    {
      Resources localResources = getContext().getResources();
      int i = this.mSearchPlate.getPaddingLeft();
      Rect localRect = new Rect();
      boolean bool = ViewUtils.isLayoutRtl(this);
      int j;
      if (this.mIconifiedByDefault) {
        j = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
      } else {
        j = 0;
      }
      this.mSearchSrcTextView.getDropDownBackground().getPadding(localRect);
      if (bool) {
        k = -localRect.left;
      } else {
        k = i - (localRect.left + j);
      }
      this.mSearchSrcTextView.setDropDownHorizontalOffset(k);
      int k = this.mDropDownAnchor.getWidth();
      int m = localRect.left;
      int n = localRect.right;
      this.mSearchSrcTextView.setDropDownWidth(k + m + n + j - i);
    }
  }
  
  public void clearFocus()
  {
    this.mClearingFocus = true;
    super.clearFocus();
    this.mSearchSrcTextView.clearFocus();
    this.mSearchSrcTextView.setImeVisibility(false);
    this.mClearingFocus = false;
  }
  
  void forceSuggestionQuery()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.mSearchSrcTextView.refreshAutoCompleteResults();
    }
    else
    {
      PreQAutoCompleteTextViewReflector localPreQAutoCompleteTextViewReflector = PRE_API_29_HIDDEN_METHOD_INVOKER;
      localPreQAutoCompleteTextViewReflector.doBeforeTextChanged(this.mSearchSrcTextView);
      localPreQAutoCompleteTextViewReflector.doAfterTextChanged(this.mSearchSrcTextView);
    }
  }
  
  public int getImeOptions()
  {
    return this.mSearchSrcTextView.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.mSearchSrcTextView.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return this.mSearchSrcTextView.getText();
  }
  
  @Nullable
  public CharSequence getQueryHint()
  {
    Object localObject = this.mQueryHint;
    if (localObject == null)
    {
      localObject = this.mSearchable;
      if ((localObject != null) && (((SearchableInfo)localObject).getHintId() != 0)) {
        localObject = getContext().getText(this.mSearchable.getHintId());
      } else {
        localObject = this.mDefaultQueryHint;
      }
    }
    return (CharSequence)localObject;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.mSuggestionCommitIconResId;
  }
  
  int getSuggestionRowLayout()
  {
    return this.mSuggestionRowLayout;
  }
  
  public CursorAdapter getSuggestionsAdapter()
  {
    return this.mSuggestionsAdapter;
  }
  
  public boolean isIconfiedByDefault()
  {
    return this.mIconifiedByDefault;
  }
  
  public boolean isIconified()
  {
    return this.mIconified;
  }
  
  public boolean isQueryRefinementEnabled()
  {
    return this.mQueryRefinement;
  }
  
  public boolean isSubmitButtonEnabled()
  {
    return this.mSubmitButtonEnabled;
  }
  
  void launchQuerySearch(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = createIntent("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(paramString1);
  }
  
  public void onActionViewCollapsed()
  {
    setQuery("", false);
    clearFocus();
    updateViewsVisibility(true);
    this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
    this.mExpandedInActionView = false;
  }
  
  public void onActionViewExpanded()
  {
    if (this.mExpandedInActionView) {
      return;
    }
    this.mExpandedInActionView = true;
    int i = this.mSearchSrcTextView.getImeOptions();
    this.mCollapsedImeOptions = i;
    this.mSearchSrcTextView.setImeOptions(i | 0x2000000);
    this.mSearchSrcTextView.setText("");
    setIconified(false);
  }
  
  void onCloseClicked()
  {
    if (TextUtils.isEmpty(this.mSearchSrcTextView.getText()))
    {
      if (this.mIconifiedByDefault)
      {
        OnCloseListener localOnCloseListener = this.mOnCloseListener;
        if ((localOnCloseListener == null) || (!localOnCloseListener.onClose()))
        {
          clearFocus();
          updateViewsVisibility(true);
        }
      }
    }
    else
    {
      this.mSearchSrcTextView.setText("");
      this.mSearchSrcTextView.requestFocus();
      this.mSearchSrcTextView.setImeVisibility(true);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mUpdateDrawableStateRunnable);
    post(this.mReleaseCursorRunnable);
    super.onDetachedFromWindow();
  }
  
  boolean onItemClicked(int paramInt1, int paramInt2, String paramString)
  {
    paramString = this.mOnSuggestionListener;
    if ((paramString != null) && (paramString.onSuggestionClick(paramInt1))) {
      return false;
    }
    launchSuggestion(paramInt1, 0, null);
    this.mSearchSrcTextView.setImeVisibility(false);
    dismissSuggestions();
    return true;
  }
  
  boolean onItemSelected(int paramInt)
  {
    OnSuggestionListener localOnSuggestionListener = this.mOnSuggestionListener;
    if ((localOnSuggestionListener != null) && (localOnSuggestionListener.onSuggestionSelect(paramInt))) {
      return false;
    }
    rewriteQueryFromSuggestion(paramInt);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
      Object localObject = this.mSearchSrtTextViewBoundsExpanded;
      Rect localRect = this.mSearchSrcTextViewBounds;
      ((Rect)localObject).set(localRect.left, 0, localRect.right, paramInt4 - paramInt2);
      localObject = this.mTouchDelegate;
      if (localObject == null)
      {
        localObject = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
        this.mTouchDelegate = ((UpdatableTouchDelegate)localObject);
        setTouchDelegate((TouchDelegate)localObject);
      }
      else
      {
        ((UpdatableTouchDelegate)localObject).setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (isIconified())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    if (i != Integer.MIN_VALUE)
    {
      if (i != 0)
      {
        if (i != 1073741824)
        {
          paramInt1 = j;
        }
        else
        {
          i = this.mMaxWidth;
          paramInt1 = j;
          if (i > 0) {
            paramInt1 = Math.min(i, j);
          }
        }
      }
      else
      {
        paramInt1 = this.mMaxWidth;
        if (paramInt1 <= 0) {
          paramInt1 = getPreferredWidth();
        }
      }
    }
    else
    {
      paramInt1 = this.mMaxWidth;
      if (paramInt1 > 0) {
        paramInt1 = Math.min(paramInt1, j);
      } else {
        paramInt1 = Math.min(getPreferredWidth(), j);
      }
    }
    j = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j != Integer.MIN_VALUE)
    {
      if (j == 0) {
        paramInt2 = getPreferredHeight();
      }
    }
    else {
      paramInt2 = Math.min(getPreferredHeight(), paramInt2);
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  void onQueryRefine(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    updateViewsVisibility(paramParcelable.isIconified);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.isIconified = isIconified();
    return localSavedState;
  }
  
  void onSearchClicked()
  {
    updateViewsVisibility(false);
    this.mSearchSrcTextView.requestFocus();
    this.mSearchSrcTextView.setImeVisibility(true);
    View.OnClickListener localOnClickListener = this.mOnSearchClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this);
    }
  }
  
  void onSubmitQuery()
  {
    Editable localEditable = this.mSearchSrcTextView.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0))
    {
      OnQueryTextListener localOnQueryTextListener = this.mOnQueryChangeListener;
      if ((localOnQueryTextListener == null) || (!localOnQueryTextListener.onQueryTextSubmit(localEditable.toString())))
      {
        if (this.mSearchable != null) {
          launchQuerySearch(0, null, localEditable.toString());
        }
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
      }
    }
  }
  
  boolean onSuggestionsKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mSearchable == null) {
      return false;
    }
    if (this.mSuggestionsAdapter == null) {
      return false;
    }
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.hasNoModifiers())) {
      if ((paramInt != 66) && (paramInt != 84) && (paramInt != 61))
      {
        if ((paramInt != 21) && (paramInt != 22))
        {
          if ((paramInt == 19) && (this.mSearchSrcTextView.getListSelection() == 0)) {
            return false;
          }
        }
        else
        {
          if (paramInt == 21) {
            paramInt = 0;
          } else {
            paramInt = this.mSearchSrcTextView.length();
          }
          this.mSearchSrcTextView.setSelection(paramInt);
          this.mSearchSrcTextView.setListSelection(0);
          this.mSearchSrcTextView.clearListSelection();
          this.mSearchSrcTextView.ensureImeVisible();
          return true;
        }
      }
      else {
        return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
      }
    }
    return false;
  }
  
  void onTextChanged(CharSequence paramCharSequence)
  {
    Editable localEditable = this.mSearchSrcTextView.getText();
    this.mUserQuery = localEditable;
    boolean bool = TextUtils.isEmpty(localEditable) ^ true;
    updateSubmitButton(bool);
    updateVoiceButton(bool ^ true);
    updateCloseButton();
    updateSubmitArea();
    if ((this.mOnQueryChangeListener != null) && (!TextUtils.equals(paramCharSequence, this.mOldQueryText))) {
      this.mOnQueryChangeListener.onQueryTextChange(paramCharSequence.toString());
    }
    this.mOldQueryText = paramCharSequence.toString();
  }
  
  void onTextFocusChanged()
  {
    updateViewsVisibility(isIconified());
    postUpdateFocusedState();
    if (this.mSearchSrcTextView.hasFocus()) {
      forceSuggestionQuery();
    }
  }
  
  void onVoiceClicked()
  {
    Object localObject = this.mSearchable;
    if (localObject == null) {
      return;
    }
    try
    {
      if (((SearchableInfo)localObject).getVoiceSearchLaunchWebSearch())
      {
        localObject = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, (SearchableInfo)localObject);
        getContext().startActivity((Intent)localObject);
      }
      else if (((SearchableInfo)localObject).getVoiceSearchLaunchRecognizer())
      {
        localObject = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, (SearchableInfo)localObject);
        getContext().startActivity((Intent)localObject);
      }
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.w("SearchView", "Could not find voice search activity");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    postUpdateFocusedState();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.mClearingFocus) {
      return false;
    }
    if (!isFocusable()) {
      return false;
    }
    if (!isIconified())
    {
      boolean bool = this.mSearchSrcTextView.requestFocus(paramInt, paramRect);
      if (bool) {
        updateViewsVisibility(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setAppSearchData(Bundle paramBundle)
  {
    this.mAppSearchData = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean) {
      onCloseClicked();
    } else {
      onSearchClicked();
    }
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.mIconifiedByDefault == paramBoolean) {
      return;
    }
    this.mIconifiedByDefault = paramBoolean;
    updateViewsVisibility(paramBoolean);
    updateQueryHint();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.mSearchSrcTextView.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.mSearchSrcTextView.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(OnCloseListener paramOnCloseListener)
  {
    this.mOnCloseListener = paramOnCloseListener;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mOnQueryTextFocusChangeListener = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(OnQueryTextListener paramOnQueryTextListener)
  {
    this.mOnQueryChangeListener = paramOnQueryTextListener;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnSearchClickListener = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(OnSuggestionListener paramOnSuggestionListener)
  {
    this.mOnSuggestionListener = paramOnSuggestionListener;
  }
  
  public void setQuery(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.mSearchSrcTextView.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      SearchAutoComplete localSearchAutoComplete = this.mSearchSrcTextView;
      localSearchAutoComplete.setSelection(localSearchAutoComplete.length());
      this.mUserQuery = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence))) {
      onSubmitQuery();
    }
  }
  
  public void setQueryHint(@Nullable CharSequence paramCharSequence)
  {
    this.mQueryHint = paramCharSequence;
    updateQueryHint();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.mQueryRefinement = paramBoolean;
    Object localObject = this.mSuggestionsAdapter;
    if ((localObject instanceof SuggestionsAdapter))
    {
      localObject = (SuggestionsAdapter)localObject;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((SuggestionsAdapter)localObject).setQueryRefinement(i);
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.mSearchable = paramSearchableInfo;
    if (paramSearchableInfo != null)
    {
      updateSearchAutoComplete();
      updateQueryHint();
    }
    boolean bool = hasVoiceSearch();
    this.mVoiceButtonEnabled = bool;
    if (bool) {
      this.mSearchSrcTextView.setPrivateImeOptions("nm");
    }
    updateViewsVisibility(isIconified());
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.mSubmitButtonEnabled = paramBoolean;
    updateViewsVisibility(isIconified());
  }
  
  public void setSuggestionsAdapter(CursorAdapter paramCursorAdapter)
  {
    this.mSuggestionsAdapter = paramCursorAdapter;
    this.mSearchSrcTextView.setAdapter(paramCursorAdapter);
  }
  
  void updateFocusedState()
  {
    int[] arrayOfInt;
    if (this.mSearchSrcTextView.hasFocus()) {
      arrayOfInt = ViewGroup.FOCUSED_STATE_SET;
    } else {
      arrayOfInt = ViewGroup.EMPTY_STATE_SET;
    }
    Drawable localDrawable = this.mSearchPlate.getBackground();
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    localDrawable = this.mSubmitArea.getBackground();
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public static abstract interface OnCloseListener
  {
    public abstract boolean onClose();
  }
  
  public static abstract interface OnQueryTextListener
  {
    public abstract boolean onQueryTextChange(String paramString);
    
    public abstract boolean onQueryTextSubmit(String paramString);
  }
  
  public static abstract interface OnSuggestionListener
  {
    public abstract boolean onSuggestionClick(int paramInt);
    
    public abstract boolean onSuggestionSelect(int paramInt);
  }
  
  private static class PreQAutoCompleteTextViewReflector
  {
    private Method mDoAfterTextChanged = null;
    private Method mDoBeforeTextChanged = null;
    private Method mEnsureImeVisible = null;
    
    @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
    PreQAutoCompleteTextViewReflector()
    {
      preApi29Check();
      try
      {
        localMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.mDoBeforeTextChanged = localMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          localMethod = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.mDoAfterTextChanged = localMethod;
          localMethod.setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          try
          {
            for (;;)
            {
              Method localMethod = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
              this.mEnsureImeVisible = localMethod;
              localMethod.setAccessible(true);
              return;
              localNoSuchMethodException1 = localNoSuchMethodException1;
              continue;
              localNoSuchMethodException2 = localNoSuchMethodException2;
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException3)
          {
            for (;;) {}
          }
        }
      }
    }
    
    private static void preApi29Check()
    {
      if (Build.VERSION.SDK_INT < 29) {
        return;
      }
      throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
    }
    
    void doAfterTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
    {
      preApi29Check();
      Method localMethod = this.mDoAfterTextChanged;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView)
      {
        for (;;) {}
      }
    }
    
    void doBeforeTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
    {
      preApi29Check();
      Method localMethod = this.mDoBeforeTextChanged;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView)
      {
        for (;;) {}
      }
    }
    
    void ensureImeVisible(AutoCompleteTextView paramAutoCompleteTextView)
    {
      preApi29Check();
      Method localMethod = this.mEnsureImeVisible;
      if (localMethod != null) {}
      try
      {
        localMethod.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
        return;
      }
      catch (Exception paramAutoCompleteTextView)
      {
        for (;;) {}
      }
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public SearchView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new SearchView.SavedState(paramAnonymousParcel, null);
      }
      
      public SearchView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new SearchView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public SearchView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new SearchView.SavedState[paramAnonymousInt];
      }
    };
    boolean isIconified;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.isIconified = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SearchView.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" isIconified=");
      localStringBuilder.append(this.isIconified);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.isIconified));
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    private boolean mHasPendingShowSoftInputRequest;
    final Runnable mRunShowSoftInputIfNecessary = new Runnable()
    {
      public void run()
      {
        SearchView.SearchAutoComplete.this.showSoftInputIfNecessary();
      }
    };
    private SearchView mSearchView;
    private int mThreshold = getThreshold();
    
    public SearchAutoComplete(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    private int getSearchViewTextMinWidthDp()
    {
      Configuration localConfiguration = getResources().getConfiguration();
      int i = localConfiguration.screenWidthDp;
      int j = localConfiguration.screenHeightDp;
      if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2)) {
        return 256;
      }
      if ((i < 600) && ((i < 640) || (j < 480))) {
        return 160;
      }
      return 192;
    }
    
    public boolean enoughToFilter()
    {
      boolean bool;
      if ((this.mThreshold > 0) && (!super.enoughToFilter())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    void ensureImeVisible()
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        setInputMethodMode(1);
        if (enoughToFilter()) {
          showDropDown();
        }
      }
      else
      {
        SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible(this);
      }
    }
    
    boolean isEmpty()
    {
      boolean bool;
      if (TextUtils.getTrimmedLength(getText()) == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      if (this.mHasPendingShowSoftInputRequest)
      {
        removeCallbacks(this.mRunShowSoftInputIfNecessary);
        post(this.mRunShowSoftInputIfNecessary);
      }
      return paramEditorInfo;
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
    }
    
    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.mSearchView.onTextFocusChanged();
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            this.mSearchView.clearFocus();
            setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (this.mSearchView.hasFocus()) && (getVisibility() == 0))
      {
        this.mHasPendingShowSoftInputRequest = true;
        if (SearchView.isLandscapeMode(getContext())) {
          ensureImeVisible();
        }
      }
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence paramCharSequence) {}
    
    void setImeVisibility(boolean paramBoolean)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!paramBoolean)
      {
        this.mHasPendingShowSoftInputRequest = false;
        removeCallbacks(this.mRunShowSoftInputIfNecessary);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.mHasPendingShowSoftInputRequest = false;
        removeCallbacks(this.mRunShowSoftInputIfNecessary);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      this.mHasPendingShowSoftInputRequest = true;
    }
    
    void setSearchView(SearchView paramSearchView)
    {
      this.mSearchView = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.mThreshold = paramInt;
    }
    
    void showSoftInputIfNecessary()
    {
      if (this.mHasPendingShowSoftInputRequest)
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
        this.mHasPendingShowSoftInputRequest = false;
      }
    }
  }
  
  private static class UpdatableTouchDelegate
    extends TouchDelegate
  {
    private final Rect mActualBounds;
    private boolean mDelegateTargeted;
    private final View mDelegateView;
    private final int mSlop;
    private final Rect mSlopBounds;
    private final Rect mTargetBounds;
    
    public UpdatableTouchDelegate(Rect paramRect1, Rect paramRect2, View paramView)
    {
      super(paramView);
      this.mSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.mTargetBounds = new Rect();
      this.mSlopBounds = new Rect();
      this.mActualBounds = new Rect();
      setBounds(paramRect1, paramRect2);
      this.mDelegateView = paramView;
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramMotionEvent.getAction();
      boolean bool1 = true;
      boolean bool2 = false;
      if (k != 0) {
        if ((k != 1) && (k != 2))
        {
          if (k != 3) {
            break label131;
          }
          bool1 = this.mDelegateTargeted;
          this.mDelegateTargeted = false;
        }
        else
        {
          bool3 = this.mDelegateTargeted;
          bool1 = bool3;
          if (bool3)
          {
            bool1 = bool3;
            if (!this.mSlopBounds.contains(i, j))
            {
              bool1 = bool3;
              k = 0;
              break label137;
            }
          }
        }
      }
      for (;;)
      {
        k = 1;
        break label137;
        if (!this.mTargetBounds.contains(i, j)) {
          break;
        }
        this.mDelegateTargeted = true;
      }
      label131:
      k = 1;
      bool1 = false;
      label137:
      boolean bool3 = bool2;
      if (bool1)
      {
        if ((k != 0) && (!this.mActualBounds.contains(i, j)))
        {
          paramMotionEvent.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
        }
        else
        {
          Rect localRect = this.mActualBounds;
          paramMotionEvent.setLocation(i - localRect.left, j - localRect.top);
        }
        bool3 = this.mDelegateView.dispatchTouchEvent(paramMotionEvent);
      }
      return bool3;
    }
    
    public void setBounds(Rect paramRect1, Rect paramRect2)
    {
      this.mTargetBounds.set(paramRect1);
      this.mSlopBounds.set(paramRect1);
      paramRect1 = this.mSlopBounds;
      int i = this.mSlop;
      paramRect1.inset(-i, -i);
      this.mActualBounds.set(paramRect2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */