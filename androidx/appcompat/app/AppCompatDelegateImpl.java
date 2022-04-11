package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.color;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.style;
import androidx.appcompat.R.styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper.CallbackWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ContentFrameLayout.OnAttachListener;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat.ThemeCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher.Component;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class AppCompatDelegateImpl
  extends AppCompatDelegate
  implements MenuBuilder.Callback, LayoutInflater.Factory2
{
  static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
  private static final boolean IS_PRE_LOLLIPOP;
  private static final boolean sCanApplyOverrideConfiguration;
  private static final boolean sCanReturnDifferentContext;
  private static boolean sInstalledExceptionHandler;
  private static final SimpleArrayMap<String, Integer> sLocalNightModes = new SimpleArrayMap();
  private static final int[] sWindowBackgroundStyleable;
  ActionBar mActionBar;
  private ActionMenuPresenterCallback mActionMenuPresenterCallback;
  androidx.appcompat.view.ActionMode mActionMode;
  PopupWindow mActionModePopup;
  ActionBarContextView mActionModeView;
  private boolean mActivityHandlesUiMode;
  private boolean mActivityHandlesUiModeChecked;
  final AppCompatCallback mAppCompatCallback;
  private AppCompatViewInflater mAppCompatViewInflater;
  private AppCompatWindowCallback mAppCompatWindowCallback;
  private AutoNightModeManager mAutoBatteryNightModeManager;
  private AutoNightModeManager mAutoTimeNightModeManager;
  private boolean mBaseContextAttached;
  private boolean mClosingActionMenu;
  final Context mContext;
  private boolean mCreated;
  private DecorContentParent mDecorContentParent;
  private boolean mEnableDefaultActionBarUp;
  ViewPropertyAnimatorCompat mFadeAnim = null;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private boolean mHandleNativeActionModes = true;
  boolean mHasActionBar;
  final Object mHost;
  int mInvalidatePanelMenuFeatures;
  boolean mInvalidatePanelMenuPosted;
  private final Runnable mInvalidatePanelMenuRunnable = new Runnable()
  {
    public void run()
    {
      AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if ((localAppCompatDelegateImpl.mInvalidatePanelMenuFeatures & 0x1) != 0) {
        localAppCompatDelegateImpl.doInvalidatePanelMenu(0);
      }
      localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if ((localAppCompatDelegateImpl.mInvalidatePanelMenuFeatures & 0x1000) != 0) {
        localAppCompatDelegateImpl.doInvalidatePanelMenu(108);
      }
      localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      localAppCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
      localAppCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
    }
  };
  boolean mIsDestroyed;
  boolean mIsFloating;
  private int mLocalNightMode = -100;
  private boolean mLongPressBackDown;
  MenuInflater mMenuInflater;
  boolean mOverlayActionBar;
  boolean mOverlayActionMode;
  private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
  private PanelFeatureState[] mPanels;
  private PanelFeatureState mPreparedPanel;
  Runnable mShowActionModePopup;
  private boolean mStarted;
  private View mStatusGuard;
  ViewGroup mSubDecor;
  private boolean mSubDecorInstalled;
  private Rect mTempRect1;
  private Rect mTempRect2;
  private int mThemeResId;
  private CharSequence mTitle;
  private TextView mTitleView;
  Window mWindow;
  boolean mWindowNoTitle;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2;
    if (i < 21) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    IS_PRE_LOLLIPOP = bool2;
    sWindowBackgroundStyleable = new int[] { 16842836 };
    sCanReturnDifferentContext = "robolectric".equals(Build.FINGERPRINT) ^ true;
    if (i >= 17) {
      bool1 = true;
    }
    sCanApplyOverrideConfiguration = bool1;
    if ((bool2) && (!sInstalledExceptionHandler))
    {
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
      {
        private boolean shouldWrapException(Throwable paramAnonymousThrowable)
        {
          boolean bool1 = paramAnonymousThrowable instanceof Resources.NotFoundException;
          boolean bool2 = false;
          boolean bool3 = bool2;
          if (bool1)
          {
            paramAnonymousThrowable = paramAnonymousThrowable.getMessage();
            bool3 = bool2;
            if (paramAnonymousThrowable != null) {
              if (!paramAnonymousThrowable.contains("drawable"))
              {
                bool3 = bool2;
                if (!paramAnonymousThrowable.contains("Drawable")) {}
              }
              else
              {
                bool3 = true;
              }
            }
          }
          return bool3;
        }
        
        public void uncaughtException(@NonNull Thread paramAnonymousThread, @NonNull Throwable paramAnonymousThrowable)
        {
          if (shouldWrapException(paramAnonymousThrowable))
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramAnonymousThrowable.getMessage());
            ((StringBuilder)localObject).append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            localObject = new Resources.NotFoundException(((StringBuilder)localObject).toString());
            ((Throwable)localObject).initCause(paramAnonymousThrowable.getCause());
            ((Throwable)localObject).setStackTrace(paramAnonymousThrowable.getStackTrace());
            AppCompatDelegateImpl.this.uncaughtException(paramAnonymousThread, (Throwable)localObject);
          }
          else
          {
            AppCompatDelegateImpl.this.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        }
      });
      sInstalledExceptionHandler = true;
    }
  }
  
  AppCompatDelegateImpl(Activity paramActivity, AppCompatCallback paramAppCompatCallback)
  {
    this(paramActivity, null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImpl(Dialog paramDialog, AppCompatCallback paramAppCompatCallback)
  {
    this(paramDialog.getContext(), paramDialog.getWindow(), paramAppCompatCallback, paramDialog);
  }
  
  AppCompatDelegateImpl(Context paramContext, Activity paramActivity, AppCompatCallback paramAppCompatCallback)
  {
    this(paramContext, null, paramAppCompatCallback, paramActivity);
  }
  
  AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    this(paramContext, paramWindow, paramAppCompatCallback, paramContext);
  }
  
  private AppCompatDelegateImpl(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback, Object paramObject)
  {
    this.mContext = paramContext;
    this.mAppCompatCallback = paramAppCompatCallback;
    this.mHost = paramObject;
    if ((this.mLocalNightMode == -100) && ((paramObject instanceof Dialog)))
    {
      paramContext = tryUnwrapContext();
      if (paramContext != null) {
        this.mLocalNightMode = paramContext.getDelegate().getLocalNightMode();
      }
    }
    if (this.mLocalNightMode == -100)
    {
      paramContext = sLocalNightModes;
      paramAppCompatCallback = (Integer)paramContext.get(paramObject.getClass().getName());
      if (paramAppCompatCallback != null)
      {
        this.mLocalNightMode = paramAppCompatCallback.intValue();
        paramContext.remove(paramObject.getClass().getName());
      }
    }
    if (paramWindow != null) {
      attachToWindow(paramWindow);
    }
    AppCompatDrawableManager.preload();
  }
  
  private boolean applyDayNight(boolean paramBoolean)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    int i = calculateNightMode();
    paramBoolean = updateForNightMode(mapNightMode(this.mContext, i), paramBoolean);
    AutoNightModeManager localAutoNightModeManager;
    if (i == 0)
    {
      getAutoTimeNightModeManager(this.mContext).setup();
    }
    else
    {
      localAutoNightModeManager = this.mAutoTimeNightModeManager;
      if (localAutoNightModeManager != null) {
        localAutoNightModeManager.cleanup();
      }
    }
    if (i == 3)
    {
      getAutoBatteryNightModeManager(this.mContext).setup();
    }
    else
    {
      localAutoNightModeManager = this.mAutoBatteryNightModeManager;
      if (localAutoNightModeManager != null) {
        localAutoNightModeManager.cleanup();
      }
    }
    return paramBoolean;
  }
  
  private void applyFixedSizeWindow()
  {
    ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(16908290);
    Object localObject = this.mWindow.getDecorView();
    localContentFrameLayout.setDecorPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), ((View)localObject).getPaddingBottom());
    localObject = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, localContentFrameLayout.getMinWidthMajor());
    ((TypedArray)localObject).getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, localContentFrameLayout.getMinWidthMinor());
    int i = R.styleable.AppCompatTheme_windowFixedWidthMajor;
    if (((TypedArray)localObject).hasValue(i)) {
      ((TypedArray)localObject).getValue(i, localContentFrameLayout.getFixedWidthMajor());
    }
    i = R.styleable.AppCompatTheme_windowFixedWidthMinor;
    if (((TypedArray)localObject).hasValue(i)) {
      ((TypedArray)localObject).getValue(i, localContentFrameLayout.getFixedWidthMinor());
    }
    i = R.styleable.AppCompatTheme_windowFixedHeightMajor;
    if (((TypedArray)localObject).hasValue(i)) {
      ((TypedArray)localObject).getValue(i, localContentFrameLayout.getFixedHeightMajor());
    }
    i = R.styleable.AppCompatTheme_windowFixedHeightMinor;
    if (((TypedArray)localObject).hasValue(i)) {
      ((TypedArray)localObject).getValue(i, localContentFrameLayout.getFixedHeightMinor());
    }
    ((TypedArray)localObject).recycle();
    localContentFrameLayout.requestLayout();
  }
  
  private void attachToWindow(@NonNull Window paramWindow)
  {
    if (this.mWindow == null)
    {
      Object localObject = paramWindow.getCallback();
      if (!(localObject instanceof AppCompatWindowCallback))
      {
        localObject = new AppCompatWindowCallback((Window.Callback)localObject);
        this.mAppCompatWindowCallback = ((AppCompatWindowCallback)localObject);
        paramWindow.setCallback((Window.Callback)localObject);
        TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
        localObject = localTintTypedArray.getDrawableIfKnown(0);
        if (localObject != null) {
          paramWindow.setBackgroundDrawable((Drawable)localObject);
        }
        localTintTypedArray.recycle();
        this.mWindow = paramWindow;
        return;
      }
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    throw new IllegalStateException("AppCompat has already installed itself into the Window");
  }
  
  private int calculateNightMode()
  {
    int i = this.mLocalNightMode;
    if (i == -100) {
      i = AppCompatDelegate.getDefaultNightMode();
    }
    return i;
  }
  
  private void cleanupAutoManagers()
  {
    AutoNightModeManager localAutoNightModeManager = this.mAutoTimeNightModeManager;
    if (localAutoNightModeManager != null) {
      localAutoNightModeManager.cleanup();
    }
    localAutoNightModeManager = this.mAutoBatteryNightModeManager;
    if (localAutoNightModeManager != null) {
      localAutoNightModeManager.cleanup();
    }
  }
  
  @NonNull
  private Configuration createOverrideConfigurationForDayNight(@NonNull Context paramContext, int paramInt, @Nullable Configuration paramConfiguration)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        paramInt = paramContext.getApplicationContext().getResources().getConfiguration().uiMode & 0x30;
      } else {
        paramInt = 32;
      }
    }
    else {
      paramInt = 16;
    }
    paramContext = new Configuration();
    paramContext.fontScale = 0.0F;
    if (paramConfiguration != null) {
      paramContext.setTo(paramConfiguration);
    }
    paramContext.uiMode = (paramInt | paramContext.uiMode & 0xFFFFFFCF);
    return paramContext;
  }
  
  private ViewGroup createSubDecor()
  {
    Object localObject1 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
    int i = R.styleable.AppCompatTheme_windowActionBar;
    if (((TypedArray)localObject1).hasValue(i))
    {
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
        requestWindowFeature(1);
      } else if (((TypedArray)localObject1).getBoolean(i, false)) {
        requestWindowFeature(108);
      }
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
        requestWindowFeature(109);
      }
      if (((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
        requestWindowFeature(10);
      }
      this.mIsFloating = ((TypedArray)localObject1).getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
      ((TypedArray)localObject1).recycle();
      ensureWindow();
      this.mWindow.getDecorView();
      localObject1 = LayoutInflater.from(this.mContext);
      Object localObject2;
      if (!this.mWindowNoTitle)
      {
        if (this.mIsFloating)
        {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_dialog_title_material, null);
          this.mOverlayActionBar = false;
          this.mHasActionBar = false;
        }
        else if (this.mHasActionBar)
        {
          localObject1 = new TypedValue();
          this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject1, true);
          if (((TypedValue)localObject1).resourceId != 0) {
            localObject1 = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, ((TypedValue)localObject1).resourceId);
          } else {
            localObject1 = this.mContext;
          }
          localObject2 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(R.layout.abc_screen_toolbar, null);
          localObject1 = (DecorContentParent)((ViewGroup)localObject2).findViewById(R.id.decor_content_parent);
          this.mDecorContentParent = ((DecorContentParent)localObject1);
          ((DecorContentParent)localObject1).setWindowCallback(getWindowCallback());
          if (this.mOverlayActionBar) {
            this.mDecorContentParent.initFeature(109);
          }
          if (this.mFeatureProgress) {
            this.mDecorContentParent.initFeature(2);
          }
          localObject1 = localObject2;
          if (this.mFeatureIndeterminateProgress)
          {
            this.mDecorContentParent.initFeature(5);
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      else if (this.mOverlayActionMode) {
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple_overlay_action_mode, null);
      } else {
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(R.layout.abc_screen_simple, null);
      }
      if (localObject1 != null)
      {
        if (Build.VERSION.SDK_INT >= 21) {
          ViewCompat.setOnApplyWindowInsetsListener((View)localObject1, new OnApplyWindowInsetsListener()
          {
            public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
            {
              int i = paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop();
              int j = AppCompatDelegateImpl.this.updateStatusGuard(paramAnonymousWindowInsetsCompat, null);
              WindowInsetsCompat localWindowInsetsCompat = paramAnonymousWindowInsetsCompat;
              if (i != j) {
                localWindowInsetsCompat = paramAnonymousWindowInsetsCompat.replaceSystemWindowInsets(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), j, paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
              }
              return ViewCompat.onApplyWindowInsets(paramAnonymousView, localWindowInsetsCompat);
            }
          });
        } else if ((localObject1 instanceof FitWindowsViewGroup)) {
          ((FitWindowsViewGroup)localObject1).setOnFitSystemWindowsListener(new FitWindowsViewGroup.OnFitSystemWindowsListener()
          {
            public void onFitSystemWindows(Rect paramAnonymousRect)
            {
              paramAnonymousRect.top = AppCompatDelegateImpl.this.updateStatusGuard(null, paramAnonymousRect);
            }
          });
        }
        if (this.mDecorContentParent == null) {
          this.mTitleView = ((TextView)((ViewGroup)localObject1).findViewById(R.id.title));
        }
        ViewUtils.makeOptionalFitsSystemWindows((View)localObject1);
        ContentFrameLayout localContentFrameLayout = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(R.id.action_bar_activity_content);
        ViewGroup localViewGroup = (ViewGroup)this.mWindow.findViewById(16908290);
        if (localViewGroup != null)
        {
          while (localViewGroup.getChildCount() > 0)
          {
            localObject2 = localViewGroup.getChildAt(0);
            localViewGroup.removeViewAt(0);
            localContentFrameLayout.addView((View)localObject2);
          }
          localViewGroup.setId(-1);
          localContentFrameLayout.setId(16908290);
          if ((localViewGroup instanceof FrameLayout)) {
            ((FrameLayout)localViewGroup).setForeground(null);
          }
        }
        this.mWindow.setContentView((View)localObject1);
        localContentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener()
        {
          public void onAttachedFromWindow() {}
          
          public void onDetachedFromWindow()
          {
            AppCompatDelegateImpl.this.dismissPopups();
          }
        });
        return (ViewGroup)localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("AppCompat does not support the current theme features: { windowActionBar: ");
      ((StringBuilder)localObject1).append(this.mHasActionBar);
      ((StringBuilder)localObject1).append(", windowActionBarOverlay: ");
      ((StringBuilder)localObject1).append(this.mOverlayActionBar);
      ((StringBuilder)localObject1).append(", android:windowIsFloating: ");
      ((StringBuilder)localObject1).append(this.mIsFloating);
      ((StringBuilder)localObject1).append(", windowActionModeOverlay: ");
      ((StringBuilder)localObject1).append(this.mOverlayActionMode);
      ((StringBuilder)localObject1).append(", windowNoTitle: ");
      ((StringBuilder)localObject1).append(this.mWindowNoTitle);
      ((StringBuilder)localObject1).append(" }");
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    ((TypedArray)localObject1).recycle();
    throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
  }
  
  private void ensureSubDecor()
  {
    if (!this.mSubDecorInstalled)
    {
      this.mSubDecor = createSubDecor();
      Object localObject1 = getTitle();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = this.mDecorContentParent;
        if (localObject2 != null)
        {
          ((DecorContentParent)localObject2).setWindowTitle((CharSequence)localObject1);
        }
        else if (peekSupportActionBar() != null)
        {
          peekSupportActionBar().setWindowTitle((CharSequence)localObject1);
        }
        else
        {
          localObject2 = this.mTitleView;
          if (localObject2 != null) {
            ((TextView)localObject2).setText((CharSequence)localObject1);
          }
        }
      }
      applyFixedSizeWindow();
      onSubDecorInstalled(this.mSubDecor);
      this.mSubDecorInstalled = true;
      localObject1 = getPanelState(0, false);
      if ((!this.mIsDestroyed) && ((localObject1 == null) || (((PanelFeatureState)localObject1).menu == null))) {
        invalidatePanelMenu(108);
      }
    }
  }
  
  private void ensureWindow()
  {
    if (this.mWindow == null)
    {
      Object localObject = this.mHost;
      if ((localObject instanceof Activity)) {
        attachToWindow(((Activity)localObject).getWindow());
      }
    }
    if (this.mWindow != null) {
      return;
    }
    throw new IllegalStateException("We have not been given a Window");
  }
  
  @NonNull
  private static Configuration generateConfigDelta(@NonNull Configuration paramConfiguration1, @Nullable Configuration paramConfiguration2)
  {
    Configuration localConfiguration = new Configuration();
    localConfiguration.fontScale = 0.0F;
    if ((paramConfiguration2 != null) && (paramConfiguration1.diff(paramConfiguration2) != 0))
    {
      float f1 = paramConfiguration1.fontScale;
      float f2 = paramConfiguration2.fontScale;
      if (f1 != f2) {
        localConfiguration.fontScale = f2;
      }
      int i = paramConfiguration1.mcc;
      int j = paramConfiguration2.mcc;
      if (i != j) {
        localConfiguration.mcc = j;
      }
      i = paramConfiguration1.mnc;
      j = paramConfiguration2.mnc;
      if (i != j) {
        localConfiguration.mnc = j;
      }
      i = Build.VERSION.SDK_INT;
      if (i >= 24) {
        ConfigurationImplApi24.generateConfigDelta_locale(paramConfiguration1, paramConfiguration2, localConfiguration);
      } else if (!ObjectsCompat.equals(paramConfiguration1.locale, paramConfiguration2.locale)) {
        localConfiguration.locale = paramConfiguration2.locale;
      }
      int k = paramConfiguration1.touchscreen;
      j = paramConfiguration2.touchscreen;
      if (k != j) {
        localConfiguration.touchscreen = j;
      }
      j = paramConfiguration1.keyboard;
      k = paramConfiguration2.keyboard;
      if (j != k) {
        localConfiguration.keyboard = k;
      }
      j = paramConfiguration1.keyboardHidden;
      k = paramConfiguration2.keyboardHidden;
      if (j != k) {
        localConfiguration.keyboardHidden = k;
      }
      j = paramConfiguration1.navigation;
      k = paramConfiguration2.navigation;
      if (j != k) {
        localConfiguration.navigation = k;
      }
      j = paramConfiguration1.navigationHidden;
      k = paramConfiguration2.navigationHidden;
      if (j != k) {
        localConfiguration.navigationHidden = k;
      }
      k = paramConfiguration1.orientation;
      j = paramConfiguration2.orientation;
      if (k != j) {
        localConfiguration.orientation = j;
      }
      j = paramConfiguration1.screenLayout;
      k = paramConfiguration2.screenLayout;
      if ((j & 0xF) != (k & 0xF)) {
        localConfiguration.screenLayout |= k & 0xF;
      }
      j = paramConfiguration1.screenLayout;
      k = paramConfiguration2.screenLayout;
      if ((j & 0xC0) != (k & 0xC0)) {
        localConfiguration.screenLayout |= k & 0xC0;
      }
      k = paramConfiguration1.screenLayout;
      j = paramConfiguration2.screenLayout;
      if ((k & 0x30) != (j & 0x30)) {
        localConfiguration.screenLayout |= j & 0x30;
      }
      k = paramConfiguration1.screenLayout;
      j = paramConfiguration2.screenLayout;
      if ((k & 0x300) != (j & 0x300)) {
        localConfiguration.screenLayout |= j & 0x300;
      }
      if (i >= 26) {
        ConfigurationImplApi26.generateConfigDelta_colorMode(paramConfiguration1, paramConfiguration2, localConfiguration);
      }
      j = paramConfiguration1.uiMode;
      k = paramConfiguration2.uiMode;
      if ((j & 0xF) != (k & 0xF)) {
        localConfiguration.uiMode |= k & 0xF;
      }
      k = paramConfiguration1.uiMode;
      j = paramConfiguration2.uiMode;
      if ((k & 0x30) != (j & 0x30)) {
        localConfiguration.uiMode |= j & 0x30;
      }
      k = paramConfiguration1.screenWidthDp;
      j = paramConfiguration2.screenWidthDp;
      if (k != j) {
        localConfiguration.screenWidthDp = j;
      }
      j = paramConfiguration1.screenHeightDp;
      k = paramConfiguration2.screenHeightDp;
      if (j != k) {
        localConfiguration.screenHeightDp = k;
      }
      k = paramConfiguration1.smallestScreenWidthDp;
      j = paramConfiguration2.smallestScreenWidthDp;
      if (k != j) {
        localConfiguration.smallestScreenWidthDp = j;
      }
      if (i >= 17) {
        ConfigurationImplApi17.generateConfigDelta_densityDpi(paramConfiguration1, paramConfiguration2, localConfiguration);
      }
    }
    return localConfiguration;
  }
  
  private AutoNightModeManager getAutoBatteryNightModeManager(@NonNull Context paramContext)
  {
    if (this.mAutoBatteryNightModeManager == null) {
      this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(paramContext);
    }
    return this.mAutoBatteryNightModeManager;
  }
  
  private AutoNightModeManager getAutoTimeNightModeManager(@NonNull Context paramContext)
  {
    if (this.mAutoTimeNightModeManager == null) {
      this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(TwilightManager.getInstance(paramContext));
    }
    return this.mAutoTimeNightModeManager;
  }
  
  private void initWindowDecorActionBar()
  {
    ensureSubDecor();
    if ((this.mHasActionBar) && (this.mActionBar == null))
    {
      Object localObject = this.mHost;
      if ((localObject instanceof Activity)) {
        this.mActionBar = new WindowDecorActionBar((Activity)this.mHost, this.mOverlayActionBar);
      } else if ((localObject instanceof Dialog)) {
        this.mActionBar = new WindowDecorActionBar((Dialog)this.mHost);
      }
      localObject = this.mActionBar;
      if (localObject != null) {
        ((ActionBar)localObject).setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
      }
    }
  }
  
  private boolean initializePanelContent(PanelFeatureState paramPanelFeatureState)
  {
    View localView = paramPanelFeatureState.createdPanelView;
    boolean bool = true;
    if (localView != null)
    {
      paramPanelFeatureState.shownPanelView = localView;
      return true;
    }
    if (paramPanelFeatureState.menu == null) {
      return false;
    }
    if (this.mPanelMenuPresenterCallback == null) {
      this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback();
    }
    localView = (View)paramPanelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
    paramPanelFeatureState.shownPanelView = localView;
    if (localView == null) {
      bool = false;
    }
    return bool;
  }
  
  private boolean initializePanelDecor(PanelFeatureState paramPanelFeatureState)
  {
    paramPanelFeatureState.setStyle(getActionBarThemedContext());
    paramPanelFeatureState.decorView = new ListMenuDecorView(paramPanelFeatureState.listPresenterContext);
    paramPanelFeatureState.gravity = 81;
    return true;
  }
  
  private boolean initializePanelMenu(PanelFeatureState paramPanelFeatureState)
  {
    Context localContext = this.mContext;
    int i = paramPanelFeatureState.featureId;
    if (i != 0)
    {
      localObject1 = localContext;
      if (i != 108) {}
    }
    else
    {
      localObject1 = localContext;
      if (this.mDecorContentParent != null)
      {
        TypedValue localTypedValue = new TypedValue();
        Resources.Theme localTheme = localContext.getTheme();
        localTheme.resolveAttribute(R.attr.actionBarTheme, localTypedValue, true);
        localObject1 = null;
        if (localTypedValue.resourceId != 0)
        {
          localObject1 = localContext.getResources().newTheme();
          ((Resources.Theme)localObject1).setTo(localTheme);
          ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
          ((Resources.Theme)localObject1).resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        else
        {
          localTheme.resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
        }
        Object localObject2 = localObject1;
        if (localTypedValue.resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(localTypedValue.resourceId, true);
        }
        localObject1 = localContext;
        if (localObject2 != null)
        {
          localObject1 = new androidx.appcompat.view.ContextThemeWrapper(localContext, 0);
          ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
        }
      }
    }
    Object localObject1 = new MenuBuilder((Context)localObject1);
    ((MenuBuilder)localObject1).setCallback(this);
    paramPanelFeatureState.setMenu((MenuBuilder)localObject1);
    return true;
  }
  
  private void invalidatePanelMenu(int paramInt)
  {
    this.mInvalidatePanelMenuFeatures = (1 << paramInt | this.mInvalidatePanelMenuFeatures);
    if (!this.mInvalidatePanelMenuPosted)
    {
      ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
      this.mInvalidatePanelMenuPosted = true;
    }
  }
  
  private boolean isActivityManifestHandlingUiMode()
  {
    if ((!this.mActivityHandlesUiModeChecked) && ((this.mHost instanceof Activity)))
    {
      Object localObject = this.mContext.getPackageManager();
      if (localObject == null) {
        return false;
      }
      try
      {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
          i = 269221888;
        } else if (i >= 24) {
          i = 786432;
        } else {
          i = 0;
        }
        ComponentName localComponentName = new android/content/ComponentName;
        localComponentName.<init>(this.mContext, this.mHost.getClass());
        localObject = ((PackageManager)localObject).getActivityInfo(localComponentName, i);
        boolean bool;
        if ((localObject != null) && ((((ActivityInfo)localObject).configChanges & 0x200) != 0)) {
          bool = true;
        } else {
          bool = false;
        }
        this.mActivityHandlesUiMode = bool;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
        this.mActivityHandlesUiMode = false;
      }
    }
    this.mActivityHandlesUiModeChecked = true;
    return this.mActivityHandlesUiMode;
  }
  
  private boolean onKeyDownPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getRepeatCount() == 0)
    {
      PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
      if (!localPanelFeatureState.isOpen) {
        return preparePanel(localPanelFeatureState, paramKeyEvent);
      }
    }
    return false;
  }
  
  private boolean onKeyUpPanel(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mActionMode != null) {
      return false;
    }
    boolean bool1 = true;
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    if (paramInt == 0)
    {
      DecorContentParent localDecorContentParent = this.mDecorContentParent;
      if ((localDecorContentParent != null) && (localDecorContentParent.canShowOverflowMenu()) && (!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()))
      {
        if (!this.mDecorContentParent.isOverflowMenuShowing())
        {
          if ((this.mIsDestroyed) || (!preparePanel(localPanelFeatureState, paramKeyEvent))) {
            break label192;
          }
          bool2 = this.mDecorContentParent.showOverflowMenu();
          break label205;
        }
        bool2 = this.mDecorContentParent.hideOverflowMenu();
        break label205;
      }
    }
    boolean bool2 = localPanelFeatureState.isOpen;
    if ((!bool2) && (!localPanelFeatureState.isHandled))
    {
      if (localPanelFeatureState.isPrepared)
      {
        if (localPanelFeatureState.refreshMenuContent)
        {
          localPanelFeatureState.isPrepared = false;
          bool2 = preparePanel(localPanelFeatureState, paramKeyEvent);
        }
        else
        {
          bool2 = true;
        }
        if (bool2)
        {
          openPanel(localPanelFeatureState, paramKeyEvent);
          bool2 = bool1;
          break label205;
        }
      }
      label192:
      bool2 = false;
    }
    else
    {
      closePanel(localPanelFeatureState, true);
    }
    label205:
    if (bool2)
    {
      paramKeyEvent = (AudioManager)this.mContext.getApplicationContext().getSystemService("audio");
      if (paramKeyEvent != null) {
        paramKeyEvent.playSoundEffect(0);
      } else {
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
      }
    }
    return bool2;
  }
  
  private void openPanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if ((!paramPanelFeatureState.isOpen) && (!this.mIsDestroyed))
    {
      if (paramPanelFeatureState.featureId == 0)
      {
        if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) == 4) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return;
        }
      }
      Object localObject = getWindowCallback();
      if ((localObject != null) && (!((Window.Callback)localObject).onMenuOpened(paramPanelFeatureState.featureId, paramPanelFeatureState.menu)))
      {
        closePanel(paramPanelFeatureState, true);
        return;
      }
      WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
      if (localWindowManager == null) {
        return;
      }
      if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {
        return;
      }
      paramKeyEvent = paramPanelFeatureState.decorView;
      if ((paramKeyEvent != null) && (!paramPanelFeatureState.refreshDecorView))
      {
        paramKeyEvent = paramPanelFeatureState.createdPanelView;
        if (paramKeyEvent != null)
        {
          paramKeyEvent = paramKeyEvent.getLayoutParams();
          if ((paramKeyEvent != null) && (paramKeyEvent.width == -1))
          {
            i = -1;
            break label336;
          }
        }
      }
      else
      {
        if (paramKeyEvent == null)
        {
          if ((initializePanelDecor(paramPanelFeatureState)) && (paramPanelFeatureState.decorView != null)) {}
        }
        else if ((paramPanelFeatureState.refreshDecorView) && (paramKeyEvent.getChildCount() > 0)) {
          paramPanelFeatureState.decorView.removeAllViews();
        }
        if ((!initializePanelContent(paramPanelFeatureState)) || (!paramPanelFeatureState.hasPanelItems())) {
          break label402;
        }
        localObject = paramPanelFeatureState.shownPanelView.getLayoutParams();
        paramKeyEvent = (KeyEvent)localObject;
        if (localObject == null) {
          paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
        }
        i = paramPanelFeatureState.background;
        paramPanelFeatureState.decorView.setBackgroundResource(i);
        localObject = paramPanelFeatureState.shownPanelView.getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(paramPanelFeatureState.shownPanelView);
        }
        paramPanelFeatureState.decorView.addView(paramPanelFeatureState.shownPanelView, paramKeyEvent);
        if (!paramPanelFeatureState.shownPanelView.hasFocus()) {
          paramPanelFeatureState.shownPanelView.requestFocus();
        }
      }
      int i = -2;
      label336:
      paramPanelFeatureState.isHandled = false;
      paramKeyEvent = new WindowManager.LayoutParams(i, -2, paramPanelFeatureState.x, paramPanelFeatureState.y, 1002, 8519680, -3);
      paramKeyEvent.gravity = paramPanelFeatureState.gravity;
      paramKeyEvent.windowAnimations = paramPanelFeatureState.windowAnimations;
      localWindowManager.addView(paramPanelFeatureState.decorView, paramKeyEvent);
      paramPanelFeatureState.isOpen = true;
      return;
      label402:
      paramPanelFeatureState.refreshDecorView = true;
    }
  }
  
  private boolean performPanelShortcut(PanelFeatureState paramPanelFeatureState, int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    boolean bool1 = paramKeyEvent.isSystem();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if (!paramPanelFeatureState.isPrepared)
    {
      bool1 = bool2;
      if (!preparePanel(paramPanelFeatureState, paramKeyEvent)) {}
    }
    else
    {
      MenuBuilder localMenuBuilder = paramPanelFeatureState.menu;
      bool1 = bool2;
      if (localMenuBuilder != null) {
        bool1 = localMenuBuilder.performShortcut(paramInt1, paramKeyEvent, paramInt2);
      }
    }
    if ((bool1) && ((paramInt2 & 0x1) == 0) && (this.mDecorContentParent == null)) {
      closePanel(paramPanelFeatureState, true);
    }
    return bool1;
  }
  
  private boolean preparePanel(PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    if (paramPanelFeatureState.isPrepared) {
      return true;
    }
    Object localObject1 = this.mPreparedPanel;
    if ((localObject1 != null) && (localObject1 != paramPanelFeatureState)) {
      closePanel((PanelFeatureState)localObject1, false);
    }
    localObject1 = getWindowCallback();
    if (localObject1 != null) {
      paramPanelFeatureState.createdPanelView = ((Window.Callback)localObject1).onCreatePanelView(paramPanelFeatureState.featureId);
    }
    int i = paramPanelFeatureState.featureId;
    if ((i != 0) && (i != 108)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2;
    if (i != 0)
    {
      localObject2 = this.mDecorContentParent;
      if (localObject2 != null) {
        ((DecorContentParent)localObject2).setMenuPrepared();
      }
    }
    if ((paramPanelFeatureState.createdPanelView == null) && ((i == 0) || (!(peekSupportActionBar() instanceof ToolbarActionBar))))
    {
      localObject2 = paramPanelFeatureState.menu;
      if ((localObject2 == null) || (paramPanelFeatureState.refreshMenuContent))
      {
        if ((localObject2 == null) && ((!initializePanelMenu(paramPanelFeatureState)) || (paramPanelFeatureState.menu == null))) {
          return false;
        }
        if ((i != 0) && (this.mDecorContentParent != null))
        {
          if (this.mActionMenuPresenterCallback == null) {
            this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
          }
          this.mDecorContentParent.setMenu(paramPanelFeatureState.menu, this.mActionMenuPresenterCallback);
        }
        paramPanelFeatureState.menu.stopDispatchingItemsChanged();
        if (!((Window.Callback)localObject1).onCreatePanelMenu(paramPanelFeatureState.featureId, paramPanelFeatureState.menu))
        {
          paramPanelFeatureState.setMenu(null);
          if (i != 0)
          {
            paramPanelFeatureState = this.mDecorContentParent;
            if (paramPanelFeatureState != null) {
              paramPanelFeatureState.setMenu(null, this.mActionMenuPresenterCallback);
            }
          }
          return false;
        }
        paramPanelFeatureState.refreshMenuContent = false;
      }
      paramPanelFeatureState.menu.stopDispatchingItemsChanged();
      localObject2 = paramPanelFeatureState.frozenActionViewState;
      if (localObject2 != null)
      {
        paramPanelFeatureState.menu.restoreActionViewStates((Bundle)localObject2);
        paramPanelFeatureState.frozenActionViewState = null;
      }
      if (!((Window.Callback)localObject1).onPreparePanel(0, paramPanelFeatureState.createdPanelView, paramPanelFeatureState.menu))
      {
        if (i != 0)
        {
          paramKeyEvent = this.mDecorContentParent;
          if (paramKeyEvent != null) {
            paramKeyEvent.setMenu(null, this.mActionMenuPresenterCallback);
          }
        }
        paramPanelFeatureState.menu.startDispatchingItemsChanged();
        return false;
      }
      if (paramKeyEvent != null) {
        i = paramKeyEvent.getDeviceId();
      } else {
        i = -1;
      }
      boolean bool;
      if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramPanelFeatureState.qwertyMode = bool;
      paramPanelFeatureState.menu.setQwertyMode(bool);
      paramPanelFeatureState.menu.startDispatchingItemsChanged();
    }
    paramPanelFeatureState.isPrepared = true;
    paramPanelFeatureState.isHandled = false;
    this.mPreparedPanel = paramPanelFeatureState;
    return true;
  }
  
  private void reopenMenu(boolean paramBoolean)
  {
    Object localObject = this.mDecorContentParent;
    if ((localObject != null) && (((DecorContentParent)localObject).canShowOverflowMenu()) && ((!ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) || (this.mDecorContentParent.isOverflowMenuShowPending())))
    {
      localObject = getWindowCallback();
      if ((this.mDecorContentParent.isOverflowMenuShowing()) && (paramBoolean))
      {
        this.mDecorContentParent.hideOverflowMenu();
        if (!this.mIsDestroyed) {
          ((Window.Callback)localObject).onPanelClosed(108, getPanelState(0, true).menu);
        }
      }
      else if ((localObject != null) && (!this.mIsDestroyed))
      {
        if ((this.mInvalidatePanelMenuPosted) && ((this.mInvalidatePanelMenuFeatures & 0x1) != 0))
        {
          this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
          this.mInvalidatePanelMenuRunnable.run();
        }
        PanelFeatureState localPanelFeatureState = getPanelState(0, true);
        MenuBuilder localMenuBuilder = localPanelFeatureState.menu;
        if ((localMenuBuilder != null) && (!localPanelFeatureState.refreshMenuContent) && (((Window.Callback)localObject).onPreparePanel(0, localPanelFeatureState.createdPanelView, localMenuBuilder)))
        {
          ((Window.Callback)localObject).onMenuOpened(108, localPanelFeatureState.menu);
          this.mDecorContentParent.showOverflowMenu();
        }
      }
      return;
    }
    localObject = getPanelState(0, true);
    ((PanelFeatureState)localObject).refreshDecorView = true;
    closePanel((PanelFeatureState)localObject, false);
    openPanel((PanelFeatureState)localObject, null);
  }
  
  private int sanitizeWindowFeatureId(int paramInt)
  {
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      return 108;
    }
    int i = paramInt;
    if (paramInt == 9)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
      i = 109;
    }
    return i;
  }
  
  private boolean shouldInheritContext(ViewParent paramViewParent)
  {
    if (paramViewParent == null) {
      return false;
    }
    View localView = this.mWindow.getDecorView();
    for (;;)
    {
      if (paramViewParent == null) {
        return true;
      }
      if ((paramViewParent == localView) || (!(paramViewParent instanceof View)) || (ViewCompat.isAttachedToWindow((View)paramViewParent))) {
        break;
      }
      paramViewParent = paramViewParent.getParent();
    }
    return false;
  }
  
  private void throwFeatureRequestIfSubDecorInstalled()
  {
    if (!this.mSubDecorInstalled) {
      return;
    }
    throw new AndroidRuntimeException("Window feature must be requested before adding content");
  }
  
  @Nullable
  private AppCompatActivity tryUnwrapContext()
  {
    for (Context localContext = this.mContext; localContext != null; localContext = ((ContextWrapper)localContext).getBaseContext())
    {
      if ((localContext instanceof AppCompatActivity)) {
        return (AppCompatActivity)localContext;
      }
      if (!(localContext instanceof ContextWrapper)) {
        break;
      }
    }
    return null;
  }
  
  private boolean updateForNightMode(int paramInt, boolean paramBoolean)
  {
    Object localObject = createOverrideConfigurationForDayNight(this.mContext, paramInt, null);
    boolean bool1 = isActivityManifestHandlingUiMode();
    int i = this.mContext.getResources().getConfiguration().uiMode & 0x30;
    int j = ((Configuration)localObject).uiMode & 0x30;
    boolean bool2 = true;
    if ((i != j) && (paramBoolean) && (!bool1) && (this.mBaseContextAttached) && ((sCanReturnDifferentContext) || (this.mCreated)))
    {
      localObject = this.mHost;
      if (((localObject instanceof Activity)) && (!((Activity)localObject).isChild()))
      {
        ActivityCompat.recreate((Activity)this.mHost);
        paramBoolean = true;
        break label122;
      }
    }
    paramBoolean = false;
    label122:
    if ((!paramBoolean) && (i != j))
    {
      updateResourcesConfigurationForNightMode(j, bool1, null);
      paramBoolean = bool2;
    }
    if (paramBoolean)
    {
      localObject = this.mHost;
      if ((localObject instanceof AppCompatActivity)) {
        ((AppCompatActivity)localObject).onNightModeChanged(paramInt);
      }
    }
    return paramBoolean;
  }
  
  private void updateResourcesConfigurationForNightMode(int paramInt, boolean paramBoolean, @Nullable Configuration paramConfiguration)
  {
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = new Configuration(localResources.getConfiguration());
    if (paramConfiguration != null) {
      localConfiguration.updateFrom(paramConfiguration);
    }
    localConfiguration.uiMode = (paramInt | localResources.getConfiguration().uiMode & 0xFFFFFFCF);
    localResources.updateConfiguration(localConfiguration, null);
    paramInt = Build.VERSION.SDK_INT;
    if (paramInt < 26) {
      ResourcesFlusher.flush(localResources);
    }
    int i = this.mThemeResId;
    if (i != 0)
    {
      this.mContext.setTheme(i);
      if (paramInt >= 23) {
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
      }
    }
    if (paramBoolean)
    {
      paramConfiguration = this.mHost;
      if ((paramConfiguration instanceof Activity))
      {
        paramConfiguration = (Activity)paramConfiguration;
        if ((paramConfiguration instanceof LifecycleOwner))
        {
          if (((LifecycleOwner)paramConfiguration).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            paramConfiguration.onConfigurationChanged(localConfiguration);
          }
        }
        else if (this.mStarted) {
          paramConfiguration.onConfigurationChanged(localConfiguration);
        }
      }
    }
  }
  
  private void updateStatusGuardColor(View paramView)
  {
    int i;
    if ((ViewCompat.getWindowSystemUiVisibility(paramView) & 0x2000) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard_light);
    } else {
      i = ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard);
    }
    paramView.setBackgroundColor(i);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)this.mSubDecor.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public boolean applyDayNight()
  {
    return applyDayNight(true);
  }
  
  @CallSuper
  @NonNull
  public Context attachBaseContext2(@NonNull Context paramContext)
  {
    int i = 1;
    this.mBaseContextAttached = true;
    int j = mapNightMode(paramContext, calculateNightMode());
    boolean bool = sCanApplyOverrideConfiguration;
    Object localObject = null;
    if ((bool) && ((paramContext instanceof android.view.ContextThemeWrapper)))
    {
      Configuration localConfiguration1 = createOverrideConfigurationForDayNight(paramContext, j, null);
      try
      {
        ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper)paramContext, localConfiguration1);
        return paramContext;
      }
      catch (IllegalStateException localIllegalStateException1) {}
    }
    if ((paramContext instanceof androidx.appcompat.view.ContextThemeWrapper))
    {
      Configuration localConfiguration2 = createOverrideConfigurationForDayNight(paramContext, j, null);
      try
      {
        ((androidx.appcompat.view.ContextThemeWrapper)paramContext).applyOverrideConfiguration(localConfiguration2);
        return paramContext;
      }
      catch (IllegalStateException localIllegalStateException2) {}
    }
    if (!sCanReturnDifferentContext) {
      return super.attachBaseContext2(paramContext);
    }
    try
    {
      Configuration localConfiguration3 = paramContext.getPackageManager().getResourcesForApplication(paramContext.getApplicationInfo()).getConfiguration();
      Configuration localConfiguration4 = paramContext.getResources().getConfiguration();
      if (!localConfiguration3.equals(localConfiguration4)) {
        localObject = generateConfigDelta(localConfiguration3, localConfiguration4);
      }
      localConfiguration3 = createOverrideConfigurationForDayNight(paramContext, j, (Configuration)localObject);
      localObject = new androidx.appcompat.view.ContextThemeWrapper(paramContext, R.style.Theme_AppCompat_Empty);
      ((androidx.appcompat.view.ContextThemeWrapper)localObject).applyOverrideConfiguration(localConfiguration3);
      j = 0;
      try
      {
        paramContext = paramContext.getTheme();
        if (paramContext == null) {
          i = 0;
        }
      }
      catch (NullPointerException paramContext)
      {
        i = j;
      }
      if (i != 0) {
        ResourcesCompat.ThemeCompat.rebase(((androidx.appcompat.view.ContextThemeWrapper)localObject).getTheme());
      }
      return super.attachBaseContext2((Context)localObject);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new RuntimeException("Application failed to obtain resources from itself", paramContext);
    }
  }
  
  void callOnPanelClosed(int paramInt, PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localObject2 = this.mPanels;
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < localObject2.length) {
            localPanelFeatureState = localObject2[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = localPanelFeatureState.menu;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!((PanelFeatureState)localObject1).isOpen)) {
      return;
    }
    if (!this.mIsDestroyed) {
      this.mAppCompatWindowCallback.getWrapped().onPanelClosed(paramInt, (Menu)localObject2);
    }
  }
  
  void checkCloseActionMenu(@NonNull MenuBuilder paramMenuBuilder)
  {
    if (this.mClosingActionMenu) {
      return;
    }
    this.mClosingActionMenu = true;
    this.mDecorContentParent.dismissPopups();
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!this.mIsDestroyed)) {
      localCallback.onPanelClosed(108, paramMenuBuilder);
    }
    this.mClosingActionMenu = false;
  }
  
  void closePanel(int paramInt)
  {
    closePanel(getPanelState(paramInt, true), true);
  }
  
  void closePanel(PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    Object localObject;
    if ((paramBoolean) && (paramPanelFeatureState.featureId == 0))
    {
      localObject = this.mDecorContentParent;
      if ((localObject != null) && (((DecorContentParent)localObject).isOverflowMenuShowing()))
      {
        checkCloseActionMenu(paramPanelFeatureState.menu);
        return;
      }
    }
    WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
    if ((localWindowManager != null) && (paramPanelFeatureState.isOpen))
    {
      localObject = paramPanelFeatureState.decorView;
      if (localObject != null)
      {
        localWindowManager.removeView((View)localObject);
        if (paramBoolean) {
          callOnPanelClosed(paramPanelFeatureState.featureId, paramPanelFeatureState, null);
        }
      }
    }
    paramPanelFeatureState.isPrepared = false;
    paramPanelFeatureState.isHandled = false;
    paramPanelFeatureState.isOpen = false;
    paramPanelFeatureState.shownPanelView = null;
    paramPanelFeatureState.refreshDecorView = true;
    if (this.mPreparedPanel == paramPanelFeatureState) {
      this.mPreparedPanel = null;
    }
  }
  
  /* Error */
  public View createView(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1382	androidx/appcompat/app/AppCompatDelegateImpl:mAppCompatViewInflater	Landroidx/appcompat/app/AppCompatViewInflater;
    //   4: astore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: aload 5
    //   11: ifnonnull +131 -> 142
    //   14: aload_0
    //   15: getfield 249	androidx/appcompat/app/AppCompatDelegateImpl:mContext	Landroid/content/Context;
    //   18: getstatic 375	androidx/appcompat/R$styleable:AppCompatTheme	[I
    //   21: invokevirtual 381	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   24: getstatic 1385	androidx/appcompat/R$styleable:AppCompatTheme_viewInflaterClass	I
    //   27: invokevirtual 1389	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   30: astore 5
    //   32: aload 5
    //   34: ifnonnull +17 -> 51
    //   37: aload_0
    //   38: new 1391	androidx/appcompat/app/AppCompatViewInflater
    //   41: dup
    //   42: invokespecial 1392	androidx/appcompat/app/AppCompatViewInflater:<init>	()V
    //   45: putfield 1382	androidx/appcompat/app/AppCompatDelegateImpl:mAppCompatViewInflater	Landroidx/appcompat/app/AppCompatViewInflater;
    //   48: goto +94 -> 142
    //   51: aload_0
    //   52: aload 5
    //   54: invokestatic 1396	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   57: iconst_0
    //   58: anewarray 275	java/lang/Class
    //   61: invokevirtual 1400	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   64: iconst_0
    //   65: anewarray 269	java/lang/Object
    //   68: invokevirtual 1406	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 1391	androidx/appcompat/app/AppCompatViewInflater
    //   74: putfield 1382	androidx/appcompat/app/AppCompatDelegateImpl:mAppCompatViewInflater	Landroidx/appcompat/app/AppCompatViewInflater;
    //   77: goto +65 -> 142
    //   80: astore 7
    //   82: new 676	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 677	java/lang/StringBuilder:<init>	()V
    //   89: astore 8
    //   91: aload 8
    //   93: ldc_w 1408
    //   96: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 8
    //   102: aload 5
    //   104: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 8
    //   110: ldc_w 1410
    //   113: invokevirtual 683	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc_w 948
    //   120: aload 8
    //   122: invokevirtual 701	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload 7
    //   127: invokestatic 1412	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   130: pop
    //   131: aload_0
    //   132: new 1391	androidx/appcompat/app/AppCompatViewInflater
    //   135: dup
    //   136: invokespecial 1392	androidx/appcompat/app/AppCompatViewInflater:<init>	()V
    //   139: putfield 1382	androidx/appcompat/app/AppCompatDelegateImpl:mAppCompatViewInflater	Landroidx/appcompat/app/AppCompatViewInflater;
    //   142: getstatic 183	androidx/appcompat/app/AppCompatDelegateImpl:IS_PRE_LOLLIPOP	Z
    //   145: istore 9
    //   147: iload 9
    //   149: ifeq +44 -> 193
    //   152: aload 4
    //   154: instanceof 1414
    //   157: ifeq +23 -> 180
    //   160: aload 4
    //   162: checkcast 1414	org/xmlpull/v1/XmlPullParser
    //   165: invokeinterface 1417 1 0
    //   170: iconst_1
    //   171: if_icmple +19 -> 190
    //   174: iconst_1
    //   175: istore 6
    //   177: goto +13 -> 190
    //   180: aload_0
    //   181: aload_1
    //   182: checkcast 1202	android/view/ViewParent
    //   185: invokespecial 1419	androidx/appcompat/app/AppCompatDelegateImpl:shouldInheritContext	(Landroid/view/ViewParent;)Z
    //   188: istore 6
    //   190: goto +6 -> 196
    //   193: iconst_0
    //   194: istore 6
    //   196: aload_0
    //   197: getfield 1382	androidx/appcompat/app/AppCompatDelegateImpl:mAppCompatViewInflater	Landroidx/appcompat/app/AppCompatViewInflater;
    //   200: aload_1
    //   201: aload_2
    //   202: aload_3
    //   203: aload 4
    //   205: iload 6
    //   207: iload 9
    //   209: iconst_1
    //   210: invokestatic 1424	androidx/appcompat/widget/VectorEnabledTintResources:shouldBeUsed	()Z
    //   213: invokevirtual 1427	androidx/appcompat/app/AppCompatViewInflater:createView	(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;ZZZZ)Landroid/view/View;
    //   216: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	AppCompatDelegateImpl
    //   0	217	1	paramView	View
    //   0	217	2	paramString	String
    //   0	217	3	paramContext	Context
    //   0	217	4	paramAttributeSet	AttributeSet
    //   4	99	5	localObject	Object
    //   7	199	6	bool1	boolean
    //   80	46	7	localThrowable	Throwable
    //   89	32	8	localStringBuilder	StringBuilder
    //   145	63	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   51	77	80	finally
  }
  
  void dismissPopups()
  {
    Object localObject = this.mDecorContentParent;
    if (localObject != null) {
      ((DecorContentParent)localObject).dismissPopups();
    }
    if (this.mActionModePopup != null)
    {
      this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
      if (!this.mActionModePopup.isShowing()) {}
    }
    try
    {
      this.mActionModePopup.dismiss();
      this.mActionModePopup = null;
      endOnGoingFadeAnimation();
      localObject = getPanelState(0, false);
      if (localObject != null)
      {
        localObject = ((PanelFeatureState)localObject).menu;
        if (localObject != null) {
          ((MenuBuilder)localObject).close();
        }
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    Object localObject = this.mHost;
    boolean bool = localObject instanceof KeyEventDispatcher.Component;
    int i = 1;
    if ((bool) || ((localObject instanceof AppCompatDialog)))
    {
      localObject = this.mWindow.getDecorView();
      if ((localObject != null) && (KeyEventDispatcher.dispatchBeforeHierarchy((View)localObject, paramKeyEvent))) {
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    int j = paramKeyEvent.getKeyCode();
    if (paramKeyEvent.getAction() != 0) {
      i = 0;
    }
    if (i != 0) {
      bool = onKeyDown(j, paramKeyEvent);
    } else {
      bool = onKeyUp(j, paramKeyEvent);
    }
    return bool;
  }
  
  void doInvalidatePanelMenu(int paramInt)
  {
    PanelFeatureState localPanelFeatureState = getPanelState(paramInt, true);
    Object localObject;
    if (localPanelFeatureState.menu != null)
    {
      localObject = new Bundle();
      localPanelFeatureState.menu.saveActionViewStates((Bundle)localObject);
      if (((Bundle)localObject).size() > 0) {
        localPanelFeatureState.frozenActionViewState = ((Bundle)localObject);
      }
      localPanelFeatureState.menu.stopDispatchingItemsChanged();
      localPanelFeatureState.menu.clear();
    }
    localPanelFeatureState.refreshMenuContent = true;
    localPanelFeatureState.refreshDecorView = true;
    if (((paramInt == 108) || (paramInt == 0)) && (this.mDecorContentParent != null))
    {
      localObject = getPanelState(0, false);
      if (localObject != null)
      {
        ((PanelFeatureState)localObject).isPrepared = false;
        preparePanel((PanelFeatureState)localObject, null);
      }
    }
  }
  
  void endOnGoingFadeAnimation()
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = this.mFadeAnim;
    if (localViewPropertyAnimatorCompat != null) {
      localViewPropertyAnimatorCompat.cancel();
    }
  }
  
  PanelFeatureState findMenuPanel(Menu paramMenu)
  {
    PanelFeatureState[] arrayOfPanelFeatureState = this.mPanels;
    int i = 0;
    int j;
    if (arrayOfPanelFeatureState != null) {
      j = arrayOfPanelFeatureState.length;
    } else {
      j = 0;
    }
    while (i < j)
    {
      PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[i];
      if ((localPanelFeatureState != null) && (localPanelFeatureState.menu == paramMenu)) {
        return localPanelFeatureState;
      }
      i++;
    }
    return null;
  }
  
  @Nullable
  public <T extends View> T findViewById(@IdRes int paramInt)
  {
    ensureSubDecor();
    return this.mWindow.findViewById(paramInt);
  }
  
  final Context getActionBarThemedContext()
  {
    Object localObject1 = getSupportActionBar();
    if (localObject1 != null) {
      localObject1 = ((ActionBar)localObject1).getThemedContext();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.mContext;
    }
    return (Context)localObject2;
  }
  
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  @VisibleForTesting
  final AutoNightModeManager getAutoTimeNightModeManager()
  {
    return getAutoTimeNightModeManager(this.mContext);
  }
  
  public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarDrawableToggleImpl();
  }
  
  public int getLocalNightMode()
  {
    return this.mLocalNightMode;
  }
  
  public MenuInflater getMenuInflater()
  {
    if (this.mMenuInflater == null)
    {
      initWindowDecorActionBar();
      Object localObject = this.mActionBar;
      if (localObject != null) {
        localObject = ((ActionBar)localObject).getThemedContext();
      } else {
        localObject = this.mContext;
      }
      this.mMenuInflater = new SupportMenuInflater((Context)localObject);
    }
    return this.mMenuInflater;
  }
  
  protected PanelFeatureState getPanelState(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = this.mPanels;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length > paramInt) {}
    }
    else
    {
      localObject2 = new PanelFeatureState[paramInt + 1];
      if (localObject1 != null) {
        System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
      }
      this.mPanels = ((PanelFeatureState[])localObject2);
    }
    Object localObject3 = localObject2[paramInt];
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = new PanelFeatureState(paramInt);
      localObject2[paramInt] = localObject1;
    }
    return (PanelFeatureState)localObject1;
  }
  
  ViewGroup getSubDecor()
  {
    return this.mSubDecor;
  }
  
  public ActionBar getSupportActionBar()
  {
    initWindowDecorActionBar();
    return this.mActionBar;
  }
  
  final CharSequence getTitle()
  {
    Object localObject = this.mHost;
    if ((localObject instanceof Activity)) {
      return ((Activity)localObject).getTitle();
    }
    return this.mTitle;
  }
  
  final Window.Callback getWindowCallback()
  {
    return this.mWindow.getCallback();
  }
  
  public boolean hasWindowFeature(int paramInt)
  {
    int i = sanitizeWindowFeatureId(paramInt);
    boolean bool1 = true;
    boolean bool2;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 5)
        {
          if (i != 10)
          {
            if (i != 108)
            {
              if (i != 109) {
                bool2 = false;
              } else {
                bool2 = this.mOverlayActionBar;
              }
            }
            else {
              bool2 = this.mHasActionBar;
            }
          }
          else {
            bool2 = this.mOverlayActionMode;
          }
        }
        else {
          bool2 = this.mFeatureIndeterminateProgress;
        }
      }
      else {
        bool2 = this.mFeatureProgress;
      }
    }
    else {
      bool2 = this.mWindowNoTitle;
    }
    boolean bool3 = bool1;
    if (!bool2) {
      if (this.mWindow.hasFeature(paramInt)) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }
    }
    return bool3;
  }
  
  public void installViewFactory()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mContext);
    if (localLayoutInflater.getFactory() == null) {
      LayoutInflaterCompat.setFactory2(localLayoutInflater, this);
    } else if (!(localLayoutInflater.getFactory2() instanceof AppCompatDelegateImpl)) {
      Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
    }
  }
  
  public void invalidateOptionsMenu()
  {
    ActionBar localActionBar = getSupportActionBar();
    if ((localActionBar != null) && (localActionBar.invalidateOptionsMenu())) {
      return;
    }
    invalidatePanelMenu(0);
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return this.mHandleNativeActionModes;
  }
  
  int mapNightMode(@NonNull Context paramContext, int paramInt)
  {
    if (paramInt != -100)
    {
      if (paramInt != -1) {
        if (paramInt != 0)
        {
          if ((paramInt != 1) && (paramInt != 2))
          {
            if (paramInt == 3) {
              return getAutoBatteryNightModeManager(paramContext).getApplyableNightMode();
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
          }
        }
        else
        {
          if ((Build.VERSION.SDK_INT >= 23) && (((UiModeManager)paramContext.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() == 0)) {
            return -1;
          }
          return getAutoTimeNightModeManager(paramContext).getApplyableNightMode();
        }
      }
      return paramInt;
    }
    return -1;
  }
  
  boolean onBackPressed()
  {
    Object localObject = this.mActionMode;
    if (localObject != null)
    {
      ((androidx.appcompat.view.ActionMode)localObject).finish();
      return true;
    }
    localObject = getSupportActionBar();
    return (localObject != null) && (((ActionBar)localObject).collapseActionView());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mHasActionBar) && (this.mSubDecorInstalled))
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.onConfigurationChanged(paramConfiguration);
      }
    }
    AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
    applyDayNight(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mBaseContextAttached = true;
    applyDayNight(false);
    ensureWindow();
    Object localObject = this.mHost;
    if ((localObject instanceof Activity))
    {
      paramBundle = null;
      try
      {
        localObject = NavUtils.getParentActivityName((Activity)localObject);
        paramBundle = (Bundle)localObject;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
      if (paramBundle != null)
      {
        paramBundle = peekSupportActionBar();
        if (paramBundle == null) {
          this.mEnableDefaultActionBarUp = true;
        } else {
          paramBundle.setDefaultDisplayHomeAsUpEnabled(true);
        }
      }
      AppCompatDelegate.addActiveDelegate(this);
    }
    this.mCreated = true;
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return createView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public void onDestroy()
  {
    if ((this.mHost instanceof Activity)) {
      AppCompatDelegate.removeActivityDelegate(this);
    }
    if (this.mInvalidatePanelMenuPosted) {
      this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    }
    this.mStarted = false;
    this.mIsDestroyed = true;
    if (this.mLocalNightMode != -100)
    {
      localObject = this.mHost;
      if (((localObject instanceof Activity)) && (((Activity)localObject).isChangingConfigurations()))
      {
        sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
        break label121;
      }
    }
    sLocalNightModes.remove(this.mHost.getClass().getName());
    label121:
    Object localObject = this.mActionBar;
    if (localObject != null) {
      ((ActionBar)localObject).onDestroy();
    }
    cleanupAutoManagers();
  }
  
  boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt != 4)
    {
      if (paramInt == 82)
      {
        onKeyDownPanel(0, paramKeyEvent);
        return true;
      }
    }
    else
    {
      if ((paramKeyEvent.getFlags() & 0x80) == 0) {
        bool = false;
      }
      this.mLongPressBackDown = bool;
    }
    return false;
  }
  
  boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getSupportActionBar();
    if ((localObject != null) && (((ActionBar)localObject).onKeyShortcut(paramInt, paramKeyEvent))) {
      return true;
    }
    localObject = this.mPreparedPanel;
    if ((localObject != null) && (performPanelShortcut((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1)))
    {
      paramKeyEvent = this.mPreparedPanel;
      if (paramKeyEvent != null) {
        paramKeyEvent.isHandled = true;
      }
      return true;
    }
    if (this.mPreparedPanel == null)
    {
      localObject = getPanelState(0, true);
      preparePanel((PanelFeatureState)localObject, paramKeyEvent);
      boolean bool = performPanelShortcut((PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent, 1);
      ((PanelFeatureState)localObject).isPrepared = false;
      if (bool) {
        return true;
      }
    }
    return false;
  }
  
  boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4)
    {
      if (paramInt == 82)
      {
        onKeyUpPanel(0, paramKeyEvent);
        return true;
      }
    }
    else
    {
      boolean bool = this.mLongPressBackDown;
      this.mLongPressBackDown = false;
      paramKeyEvent = getPanelState(0, false);
      if ((paramKeyEvent != null) && (paramKeyEvent.isOpen))
      {
        if (!bool) {
          closePanel(paramKeyEvent, true);
        }
        return true;
      }
      if (onBackPressed()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean onMenuItemSelected(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    Window.Callback localCallback = getWindowCallback();
    if ((localCallback != null) && (!this.mIsDestroyed))
    {
      paramMenuBuilder = findMenuPanel(paramMenuBuilder.getRootMenu());
      if (paramMenuBuilder != null) {
        return localCallback.onMenuItemSelected(paramMenuBuilder.featureId, paramMenuItem);
      }
    }
    return false;
  }
  
  public void onMenuModeChange(@NonNull MenuBuilder paramMenuBuilder)
  {
    reopenMenu(true);
  }
  
  void onMenuOpened(int paramInt)
  {
    if (paramInt == 108)
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.dispatchMenuVisibilityChanged(true);
      }
    }
  }
  
  void onPanelClosed(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = getSupportActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).dispatchMenuVisibilityChanged(false);
      }
    }
    else if (paramInt == 0)
    {
      localObject = getPanelState(paramInt, true);
      if (((PanelFeatureState)localObject).isOpen) {
        closePanel((PanelFeatureState)localObject, false);
      }
    }
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    ensureSubDecor();
  }
  
  public void onPostResume()
  {
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.mStarted = true;
    applyDayNight();
  }
  
  public void onStop()
  {
    this.mStarted = false;
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      localActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  void onSubDecorInstalled(ViewGroup paramViewGroup) {}
  
  final ActionBar peekSupportActionBar()
  {
    return this.mActionBar;
  }
  
  public boolean requestWindowFeature(int paramInt)
  {
    paramInt = sanitizeWindowFeatureId(paramInt);
    if ((this.mWindowNoTitle) && (paramInt == 108)) {
      return false;
    }
    if ((this.mHasActionBar) && (paramInt == 1)) {
      this.mHasActionBar = false;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 5)
        {
          if (paramInt != 10)
          {
            if (paramInt != 108)
            {
              if (paramInt != 109) {
                return this.mWindow.requestFeature(paramInt);
              }
              throwFeatureRequestIfSubDecorInstalled();
              this.mOverlayActionBar = true;
              return true;
            }
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
          }
          throwFeatureRequestIfSubDecorInstalled();
          this.mOverlayActionMode = true;
          return true;
        }
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureIndeterminateProgress = true;
        return true;
      }
      throwFeatureRequestIfSubDecorInstalled();
      this.mFeatureProgress = true;
      return true;
    }
    throwFeatureRequestIfSubDecorInstalled();
    this.mWindowNoTitle = true;
    return true;
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.mContext).inflate(paramInt, localViewGroup);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)this.mSubDecor.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.mAppCompatWindowCallback.getWrapped().onContentChanged();
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    this.mHandleNativeActionModes = paramBoolean;
  }
  
  @RequiresApi(17)
  public void setLocalNightMode(int paramInt)
  {
    if (this.mLocalNightMode != paramInt)
    {
      this.mLocalNightMode = paramInt;
      if (this.mBaseContextAttached) {
        applyDayNight();
      }
    }
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    if (!(this.mHost instanceof Activity)) {
      return;
    }
    ActionBar localActionBar = getSupportActionBar();
    if (!(localActionBar instanceof WindowDecorActionBar))
    {
      this.mMenuInflater = null;
      if (localActionBar != null) {
        localActionBar.onDestroy();
      }
      if (paramToolbar != null)
      {
        paramToolbar = new ToolbarActionBar(paramToolbar, getTitle(), this.mAppCompatWindowCallback);
        this.mActionBar = paramToolbar;
        this.mWindow.setCallback(paramToolbar.getWrappedWindowCallback());
      }
      else
      {
        this.mActionBar = null;
        this.mWindow.setCallback(this.mAppCompatWindowCallback);
      }
      invalidateOptionsMenu();
      return;
    }
    throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
  }
  
  public void setTheme(@StyleRes int paramInt)
  {
    this.mThemeResId = paramInt;
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    Object localObject = this.mDecorContentParent;
    if (localObject != null)
    {
      ((DecorContentParent)localObject).setWindowTitle(paramCharSequence);
    }
    else if (peekSupportActionBar() != null)
    {
      peekSupportActionBar().setWindowTitle(paramCharSequence);
    }
    else
    {
      localObject = this.mTitleView;
      if (localObject != null) {
        ((TextView)localObject).setText(paramCharSequence);
      }
    }
  }
  
  final boolean shouldAnimateActionModeView()
  {
    if (this.mSubDecorInstalled)
    {
      ViewGroup localViewGroup = this.mSubDecor;
      if ((localViewGroup != null) && (ViewCompat.isLaidOut(localViewGroup))) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public androidx.appcompat.view.ActionMode startSupportActionMode(@NonNull androidx.appcompat.view.ActionMode.Callback paramCallback)
  {
    if (paramCallback != null)
    {
      Object localObject = this.mActionMode;
      if (localObject != null) {
        ((androidx.appcompat.view.ActionMode)localObject).finish();
      }
      paramCallback = new ActionModeCallbackWrapperV9(paramCallback);
      localObject = getSupportActionBar();
      if (localObject != null)
      {
        androidx.appcompat.view.ActionMode localActionMode = ((ActionBar)localObject).startActionMode(paramCallback);
        this.mActionMode = localActionMode;
        if (localActionMode != null)
        {
          localObject = this.mAppCompatCallback;
          if (localObject != null) {
            ((AppCompatCallback)localObject).onSupportActionModeStarted(localActionMode);
          }
        }
      }
      if (this.mActionMode == null) {
        this.mActionMode = startSupportActionModeFromWindow(paramCallback);
      }
      return this.mActionMode;
    }
    throw new IllegalArgumentException("ActionMode callback can not be null.");
  }
  
  androidx.appcompat.view.ActionMode startSupportActionModeFromWindow(@NonNull androidx.appcompat.view.ActionMode.Callback paramCallback)
  {
    endOnGoingFadeAnimation();
    Object localObject1 = this.mActionMode;
    if (localObject1 != null) {
      ((androidx.appcompat.view.ActionMode)localObject1).finish();
    }
    localObject1 = paramCallback;
    if (!(paramCallback instanceof ActionModeCallbackWrapperV9)) {
      localObject1 = new ActionModeCallbackWrapperV9(paramCallback);
    }
    paramCallback = this.mAppCompatCallback;
    if ((paramCallback != null) && (!this.mIsDestroyed)) {}
    try
    {
      paramCallback = paramCallback.onWindowStartingSupportActionMode((androidx.appcompat.view.ActionMode.Callback)localObject1);
    }
    catch (AbstractMethodError paramCallback)
    {
      boolean bool;
      Object localObject2;
      Object localObject3;
      int i;
      for (;;) {}
    }
    paramCallback = null;
    if (paramCallback != null)
    {
      this.mActionMode = paramCallback;
    }
    else
    {
      paramCallback = this.mActionModeView;
      bool = true;
      if (paramCallback == null) {
        if (this.mIsFloating)
        {
          localObject2 = new TypedValue();
          paramCallback = this.mContext.getTheme();
          paramCallback.resolveAttribute(R.attr.actionBarTheme, (TypedValue)localObject2, true);
          if (((TypedValue)localObject2).resourceId != 0)
          {
            localObject3 = this.mContext.getResources().newTheme();
            ((Resources.Theme)localObject3).setTo(paramCallback);
            ((Resources.Theme)localObject3).applyStyle(((TypedValue)localObject2).resourceId, true);
            paramCallback = new androidx.appcompat.view.ContextThemeWrapper(this.mContext, 0);
            paramCallback.getTheme().setTo((Resources.Theme)localObject3);
          }
          else
          {
            paramCallback = this.mContext;
          }
          this.mActionModeView = new ActionBarContextView(paramCallback);
          localObject3 = new PopupWindow(paramCallback, null, R.attr.actionModePopupWindowStyle);
          this.mActionModePopup = ((PopupWindow)localObject3);
          PopupWindowCompat.setWindowLayoutType((PopupWindow)localObject3, 2);
          this.mActionModePopup.setContentView(this.mActionModeView);
          this.mActionModePopup.setWidth(-1);
          paramCallback.getTheme().resolveAttribute(R.attr.actionBarSize, (TypedValue)localObject2, true);
          i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject2).data, paramCallback.getResources().getDisplayMetrics());
          this.mActionModeView.setContentHeight(i);
          this.mActionModePopup.setHeight(-2);
          this.mShowActionModePopup = new Runnable()
          {
            public void run()
            {
              AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
              localAppCompatDelegateImpl.mActionModePopup.showAtLocation(localAppCompatDelegateImpl.mActionModeView, 55, 0, 0);
              AppCompatDelegateImpl.this.endOnGoingFadeAnimation();
              if (AppCompatDelegateImpl.this.shouldAnimateActionModeView())
              {
                AppCompatDelegateImpl.this.mActionModeView.setAlpha(0.0F);
                localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
                localAppCompatDelegateImpl.mFadeAnim = ViewCompat.animate(localAppCompatDelegateImpl.mActionModeView).alpha(1.0F);
                AppCompatDelegateImpl.this.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter()
                {
                  public void onAnimationEnd(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0F);
                    AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                    AppCompatDelegateImpl.this.mFadeAnim = null;
                  }
                  
                  public void onAnimationStart(View paramAnonymous2View)
                  {
                    AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
                  }
                });
              }
              else
              {
                AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0F);
                AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
              }
            }
          };
        }
        else
        {
          paramCallback = (ViewStubCompat)this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
          if (paramCallback != null)
          {
            paramCallback.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
            this.mActionModeView = ((ActionBarContextView)paramCallback.inflate());
          }
        }
      }
      if (this.mActionModeView != null)
      {
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        localObject2 = this.mActionModeView.getContext();
        paramCallback = this.mActionModeView;
        if (this.mActionModePopup != null) {
          bool = false;
        }
        paramCallback = new StandaloneActionMode((Context)localObject2, paramCallback, (androidx.appcompat.view.ActionMode.Callback)localObject1, bool);
        if (((androidx.appcompat.view.ActionMode.Callback)localObject1).onCreateActionMode(paramCallback, paramCallback.getMenu()))
        {
          paramCallback.invalidate();
          this.mActionModeView.initForMode(paramCallback);
          this.mActionMode = paramCallback;
          if (shouldAnimateActionModeView())
          {
            this.mActionModeView.setAlpha(0.0F);
            paramCallback = ViewCompat.animate(this.mActionModeView).alpha(1.0F);
            this.mFadeAnim = paramCallback;
            paramCallback.setListener(new ViewPropertyAnimatorListenerAdapter()
            {
              public void onAnimationEnd(View paramAnonymousView)
              {
                AppCompatDelegateImpl.this.mActionModeView.setAlpha(1.0F);
                AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                AppCompatDelegateImpl.this.mFadeAnim = null;
              }
              
              public void onAnimationStart(View paramAnonymousView)
              {
                AppCompatDelegateImpl.this.mActionModeView.setVisibility(0);
                AppCompatDelegateImpl.this.mActionModeView.sendAccessibilityEvent(32);
                if ((AppCompatDelegateImpl.this.mActionModeView.getParent() instanceof View)) {
                  ViewCompat.requestApplyInsets((View)AppCompatDelegateImpl.this.mActionModeView.getParent());
                }
              }
            });
          }
          else
          {
            this.mActionModeView.setAlpha(1.0F);
            this.mActionModeView.setVisibility(0);
            this.mActionModeView.sendAccessibilityEvent(32);
            if ((this.mActionModeView.getParent() instanceof View)) {
              ViewCompat.requestApplyInsets((View)this.mActionModeView.getParent());
            }
          }
          if (this.mActionModePopup != null) {
            this.mWindow.getDecorView().post(this.mShowActionModePopup);
          }
        }
        else
        {
          this.mActionMode = null;
        }
      }
    }
    paramCallback = this.mActionMode;
    if (paramCallback != null)
    {
      localObject1 = this.mAppCompatCallback;
      if (localObject1 != null) {
        ((AppCompatCallback)localObject1).onSupportActionModeStarted(paramCallback);
      }
    }
    return this.mActionMode;
  }
  
  final int updateStatusGuard(@Nullable WindowInsetsCompat paramWindowInsetsCompat, @Nullable Rect paramRect)
  {
    int i = 0;
    int j;
    if (paramWindowInsetsCompat != null) {
      j = paramWindowInsetsCompat.getSystemWindowInsetTop();
    } else if (paramRect != null) {
      j = paramRect.top;
    } else {
      j = 0;
    }
    Object localObject = this.mActionModeView;
    int m;
    int i3;
    if ((localObject != null) && ((((ViewGroup)localObject).getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
      boolean bool = this.mActionModeView.isShown();
      int k = 1;
      m = 1;
      int i1;
      if (bool)
      {
        if (this.mTempRect1 == null)
        {
          this.mTempRect1 = new Rect();
          this.mTempRect2 = new Rect();
        }
        Rect localRect1 = this.mTempRect1;
        Rect localRect2 = this.mTempRect2;
        if (paramWindowInsetsCompat == null) {
          localRect1.set(paramRect);
        } else {
          localRect1.set(paramWindowInsetsCompat.getSystemWindowInsetLeft(), paramWindowInsetsCompat.getSystemWindowInsetTop(), paramWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.getSystemWindowInsetBottom());
        }
        ViewUtils.computeFitSystemWindows(this.mSubDecor, localRect1, localRect2);
        int n = localRect1.top;
        i1 = localRect1.left;
        int i2 = localRect1.right;
        paramWindowInsetsCompat = ViewCompat.getRootWindowInsets(this.mSubDecor);
        if (paramWindowInsetsCompat == null) {
          k = 0;
        } else {
          k = paramWindowInsetsCompat.getSystemWindowInsetLeft();
        }
        if (paramWindowInsetsCompat == null) {
          i3 = 0;
        } else {
          i3 = paramWindowInsetsCompat.getSystemWindowInsetRight();
        }
        if ((((ViewGroup.MarginLayoutParams)localObject).topMargin == n) && (((ViewGroup.MarginLayoutParams)localObject).leftMargin == i1) && (((ViewGroup.MarginLayoutParams)localObject).rightMargin == i2))
        {
          i1 = 0;
        }
        else
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = n;
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i1;
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i2;
          i1 = 1;
        }
        if ((n > 0) && (this.mStatusGuard == null))
        {
          paramWindowInsetsCompat = new View(this.mContext);
          this.mStatusGuard = paramWindowInsetsCompat;
          paramWindowInsetsCompat.setVisibility(8);
          paramWindowInsetsCompat = new FrameLayout.LayoutParams(-1, ((ViewGroup.MarginLayoutParams)localObject).topMargin, 51);
          paramWindowInsetsCompat.leftMargin = k;
          paramWindowInsetsCompat.rightMargin = i3;
          this.mSubDecor.addView(this.mStatusGuard, -1, paramWindowInsetsCompat);
        }
        else
        {
          paramWindowInsetsCompat = this.mStatusGuard;
          if (paramWindowInsetsCompat != null)
          {
            paramWindowInsetsCompat = (ViewGroup.MarginLayoutParams)paramWindowInsetsCompat.getLayoutParams();
            i2 = paramWindowInsetsCompat.height;
            n = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
            if ((i2 != n) || (paramWindowInsetsCompat.leftMargin != k) || (paramWindowInsetsCompat.rightMargin != i3))
            {
              paramWindowInsetsCompat.height = n;
              paramWindowInsetsCompat.leftMargin = k;
              paramWindowInsetsCompat.rightMargin = i3;
              this.mStatusGuard.setLayoutParams(paramWindowInsetsCompat);
            }
          }
        }
        paramWindowInsetsCompat = this.mStatusGuard;
        if (paramWindowInsetsCompat != null) {
          i3 = m;
        } else {
          i3 = 0;
        }
        if ((i3 != 0) && (paramWindowInsetsCompat.getVisibility() != 0)) {
          updateStatusGuardColor(this.mStatusGuard);
        }
        k = j;
        if (!this.mOverlayActionMode)
        {
          k = j;
          if (i3 != 0) {
            k = 0;
          }
        }
        j = k;
        k = i1;
        i1 = i3;
      }
      else if (((ViewGroup.MarginLayoutParams)localObject).topMargin != 0)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
        i1 = 0;
      }
      else
      {
        i1 = 0;
        k = 0;
      }
      i3 = j;
      m = i1;
      if (k != 0)
      {
        this.mActionModeView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        i3 = j;
        m = i1;
      }
    }
    else
    {
      m = 0;
      i3 = j;
    }
    paramWindowInsetsCompat = this.mStatusGuard;
    if (paramWindowInsetsCompat != null)
    {
      if (m != 0) {
        j = i;
      } else {
        j = 8;
      }
      paramWindowInsetsCompat.setVisibility(j);
    }
    return i3;
  }
  
  private class ActionBarDrawableToggleImpl
    implements ActionBarDrawerToggle.Delegate
  {
    ActionBarDrawableToggleImpl() {}
    
    public Context getActionBarThemedContext()
    {
      return AppCompatDelegateImpl.this.getActionBarThemedContext();
    }
    
    public Drawable getThemeUpIndicator()
    {
      TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[] { R.attr.homeAsUpIndicator });
      Drawable localDrawable = localTintTypedArray.getDrawable(0);
      localTintTypedArray.recycle();
      return localDrawable;
    }
    
    public boolean isNavigationVisible()
    {
      ActionBar localActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
      boolean bool;
      if ((localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void setActionBarDescription(int paramInt)
    {
      ActionBar localActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      ActionBar localActionBar = AppCompatDelegateImpl.this.getSupportActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeAsUpIndicator(paramDrawable);
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  private final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    ActionMenuPresenterCallback() {}
    
    public void onCloseMenu(@NonNull MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      AppCompatDelegateImpl.this.checkCloseActionMenu(paramMenuBuilder);
    }
    
    public boolean onOpenSubMenu(@NonNull MenuBuilder paramMenuBuilder)
    {
      Window.Callback localCallback = AppCompatDelegateImpl.this.getWindowCallback();
      if (localCallback != null) {
        localCallback.onMenuOpened(108, paramMenuBuilder);
      }
      return true;
    }
  }
  
  class ActionModeCallbackWrapperV9
    implements androidx.appcompat.view.ActionMode.Callback
  {
    private androidx.appcompat.view.ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapperV9(androidx.appcompat.view.ActionMode.Callback paramCallback)
    {
      this.mWrapped = paramCallback;
    }
    
    public boolean onActionItemClicked(androidx.appcompat.view.ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(androidx.appcompat.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(androidx.appcompat.view.ActionMode paramActionMode)
    {
      this.mWrapped.onDestroyActionMode(paramActionMode);
      paramActionMode = AppCompatDelegateImpl.this;
      if (paramActionMode.mActionModePopup != null) {
        paramActionMode.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.mShowActionModePopup);
      }
      paramActionMode = AppCompatDelegateImpl.this;
      if (paramActionMode.mActionModeView != null)
      {
        paramActionMode.endOnGoingFadeAnimation();
        paramActionMode = AppCompatDelegateImpl.this;
        paramActionMode.mFadeAnim = ViewCompat.animate(paramActionMode.mActionModeView).alpha(0.0F);
        AppCompatDelegateImpl.this.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter()
        {
          public void onAnimationEnd(View paramAnonymousView)
          {
            AppCompatDelegateImpl.this.mActionModeView.setVisibility(8);
            paramAnonymousView = AppCompatDelegateImpl.this;
            PopupWindow localPopupWindow = paramAnonymousView.mActionModePopup;
            if (localPopupWindow != null) {
              localPopupWindow.dismiss();
            } else if ((paramAnonymousView.mActionModeView.getParent() instanceof View)) {
              ViewCompat.requestApplyInsets((View)AppCompatDelegateImpl.this.mActionModeView.getParent());
            }
            AppCompatDelegateImpl.this.mActionModeView.removeAllViews();
            AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
            paramAnonymousView = AppCompatDelegateImpl.this;
            paramAnonymousView.mFadeAnim = null;
            ViewCompat.requestApplyInsets(paramAnonymousView.mSubDecor);
          }
        });
      }
      paramActionMode = AppCompatDelegateImpl.this;
      AppCompatCallback localAppCompatCallback = paramActionMode.mAppCompatCallback;
      if (localAppCompatCallback != null) {
        localAppCompatCallback.onSupportActionModeFinished(paramActionMode.mActionMode);
      }
      paramActionMode = AppCompatDelegateImpl.this;
      paramActionMode.mActionMode = null;
      ViewCompat.requestApplyInsets(paramActionMode.mSubDecor);
    }
    
    public boolean onPrepareActionMode(androidx.appcompat.view.ActionMode paramActionMode, Menu paramMenu)
    {
      ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.mSubDecor);
      return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
  
  class AppCompatWindowCallback
    extends WindowCallbackWrapper
  {
    AppCompatWindowCallback(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      boolean bool;
      if ((!AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      boolean bool;
      if ((!super.dispatchKeyShortcutEvent(paramKeyEvent)) && (!AppCompatDelegateImpl.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof MenuBuilder))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      AppCompatDelegateImpl.this.onMenuOpened(paramInt);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      AppCompatDelegateImpl.this.onPanelClosed(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      MenuBuilder localMenuBuilder;
      if ((paramMenu instanceof MenuBuilder)) {
        localMenuBuilder = (MenuBuilder)paramMenu;
      } else {
        localMenuBuilder = null;
      }
      if ((paramInt == 0) && (localMenuBuilder == null)) {
        return false;
      }
      if (localMenuBuilder != null) {
        localMenuBuilder.setOverrideVisibleItems(true);
      }
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if (localMenuBuilder != null) {
        localMenuBuilder.setOverrideVisibleItems(false);
      }
      return bool;
    }
    
    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      Object localObject = AppCompatDelegateImpl.this.getPanelState(0, true);
      if (localObject != null)
      {
        localObject = ((AppCompatDelegateImpl.PanelFeatureState)localObject).menu;
        if (localObject != null)
        {
          super.onProvideKeyboardShortcuts(paramList, (Menu)localObject, paramInt);
          return;
        }
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback paramCallback)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        return null;
      }
      if (AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled()) {
        return startAsSupportActionMode(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
    
    @RequiresApi(23)
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback paramCallback, int paramInt)
    {
      if ((AppCompatDelegateImpl.this.isHandleNativeActionModesEnabled()) && (paramInt == 0)) {
        return startAsSupportActionMode(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback, paramInt);
    }
    
    final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback paramCallback)
    {
      SupportActionModeWrapper.CallbackWrapper localCallbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImpl.this.mContext, paramCallback);
      paramCallback = AppCompatDelegateImpl.this.startSupportActionMode(localCallbackWrapper);
      if (paramCallback != null) {
        return localCallbackWrapper.getActionModeWrapper(paramCallback);
      }
      return null;
    }
  }
  
  private class AutoBatteryNightModeManager
    extends AppCompatDelegateImpl.AutoNightModeManager
  {
    private final PowerManager mPowerManager;
    
    AutoBatteryNightModeManager(Context paramContext)
    {
      super();
      this.mPowerManager = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
    }
    
    IntentFilter createIntentFilterForBroadcastReceiver()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
        return localIntentFilter;
      }
      return null;
    }
    
    public int getApplyableNightMode()
    {
      int i = Build.VERSION.SDK_INT;
      int j = 1;
      int k = j;
      if (i >= 21)
      {
        k = j;
        if (this.mPowerManager.isPowerSaveMode()) {
          k = 2;
        }
      }
      return k;
    }
    
    public void onChange()
    {
      AppCompatDelegateImpl.this.applyDayNight();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  @VisibleForTesting
  abstract class AutoNightModeManager
  {
    private BroadcastReceiver mReceiver;
    
    AutoNightModeManager() {}
    
    void cleanup()
    {
      BroadcastReceiver localBroadcastReceiver = this.mReceiver;
      if (localBroadcastReceiver != null) {}
      try
      {
        AppCompatDelegateImpl.this.mContext.unregisterReceiver(localBroadcastReceiver);
        this.mReceiver = null;
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;) {}
      }
    }
    
    @Nullable
    abstract IntentFilter createIntentFilterForBroadcastReceiver();
    
    abstract int getApplyableNightMode();
    
    boolean isListening()
    {
      boolean bool;
      if (this.mReceiver != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    abstract void onChange();
    
    void setup()
    {
      cleanup();
      IntentFilter localIntentFilter = createIntentFilterForBroadcastReceiver();
      if ((localIntentFilter != null) && (localIntentFilter.countActions() != 0))
      {
        if (this.mReceiver == null) {
          this.mReceiver = new BroadcastReceiver()
          {
            public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
            {
              AppCompatDelegateImpl.AutoNightModeManager.this.onChange();
            }
          };
        }
        AppCompatDelegateImpl.this.mContext.registerReceiver(this.mReceiver, localIntentFilter);
      }
    }
  }
  
  private class AutoTimeNightModeManager
    extends AppCompatDelegateImpl.AutoNightModeManager
  {
    private final TwilightManager mTwilightManager;
    
    AutoTimeNightModeManager(TwilightManager paramTwilightManager)
    {
      super();
      this.mTwilightManager = paramTwilightManager;
    }
    
    IntentFilter createIntentFilterForBroadcastReceiver()
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.TIME_SET");
      localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      localIntentFilter.addAction("android.intent.action.TIME_TICK");
      return localIntentFilter;
    }
    
    public int getApplyableNightMode()
    {
      int i;
      if (this.mTwilightManager.isNight()) {
        i = 2;
      } else {
        i = 1;
      }
      return i;
    }
    
    public void onChange()
    {
      AppCompatDelegateImpl.this.applyDayNight();
    }
  }
  
  @RequiresApi(17)
  static class ConfigurationImplApi17
  {
    static void generateConfigDelta_densityDpi(@NonNull Configuration paramConfiguration1, @NonNull Configuration paramConfiguration2, @NonNull Configuration paramConfiguration3)
    {
      int i = paramConfiguration1.densityDpi;
      int j = paramConfiguration2.densityDpi;
      if (i != j) {
        paramConfiguration3.densityDpi = j;
      }
    }
  }
  
  @RequiresApi(24)
  static class ConfigurationImplApi24
  {
    static void generateConfigDelta_locale(@NonNull Configuration paramConfiguration1, @NonNull Configuration paramConfiguration2, @NonNull Configuration paramConfiguration3)
    {
      paramConfiguration1 = paramConfiguration1.getLocales();
      LocaleList localLocaleList = paramConfiguration2.getLocales();
      if (!paramConfiguration1.equals(localLocaleList))
      {
        paramConfiguration3.setLocales(localLocaleList);
        paramConfiguration3.locale = paramConfiguration2.locale;
      }
    }
  }
  
  @RequiresApi(26)
  static class ConfigurationImplApi26
  {
    static void generateConfigDelta_colorMode(@NonNull Configuration paramConfiguration1, @NonNull Configuration paramConfiguration2, @NonNull Configuration paramConfiguration3)
    {
      int i = paramConfiguration1.colorMode;
      int j = paramConfiguration2.colorMode;
      if ((i & 0x3) != (j & 0x3)) {
        paramConfiguration3.colorMode |= j & 0x3;
      }
      j = paramConfiguration1.colorMode;
      i = paramConfiguration2.colorMode;
      if ((j & 0xC) != (i & 0xC)) {
        paramConfiguration3.colorMode |= i & 0xC;
      }
    }
  }
  
  @RequiresApi(17)
  private static class ContextThemeWrapperCompatApi17Impl
  {
    static void applyOverrideConfiguration(android.view.ContextThemeWrapper paramContextThemeWrapper, Configuration paramConfiguration)
    {
      paramContextThemeWrapper.applyOverrideConfiguration(paramConfiguration);
    }
  }
  
  private class ListMenuDecorView
    extends ContentFrameLayout
  {
    public ListMenuDecorView(Context paramContext)
    {
      super();
    }
    
    private boolean isOutOfBounds(int paramInt1, int paramInt2)
    {
      boolean bool;
      if ((paramInt1 >= -5) && (paramInt2 >= -5) && (paramInt1 <= getWidth() + 5) && (paramInt2 <= getHeight() + 5)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      boolean bool;
      if ((!AppCompatDelegateImpl.this.dispatchKeyEvent(paramKeyEvent)) && (!super.dispatchKeyEvent(paramKeyEvent))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((paramMotionEvent.getAction() == 0) && (isOutOfBounds((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
      {
        AppCompatDelegateImpl.this.closePanel(0);
        return true;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void setBackgroundResource(int paramInt)
    {
      setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
    }
  }
  
  protected static final class PanelFeatureState
  {
    int background;
    View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    Bundle frozenMenuState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;
    int windowAnimations;
    int x;
    int y;
    
    PanelFeatureState(int paramInt)
    {
      this.featureId = paramInt;
      this.refreshDecorView = false;
    }
    
    void applyFrozenState()
    {
      MenuBuilder localMenuBuilder = this.menu;
      if (localMenuBuilder != null)
      {
        Bundle localBundle = this.frozenMenuState;
        if (localBundle != null)
        {
          localMenuBuilder.restorePresenterStates(localBundle);
          this.frozenMenuState = null;
        }
      }
    }
    
    public void clearMenuPresenters()
    {
      MenuBuilder localMenuBuilder = this.menu;
      if (localMenuBuilder != null) {
        localMenuBuilder.removeMenuPresenter(this.listMenuPresenter);
      }
      this.listMenuPresenter = null;
    }
    
    MenuView getListMenuView(MenuPresenter.Callback paramCallback)
    {
      if (this.menu == null) {
        return null;
      }
      if (this.listMenuPresenter == null)
      {
        ListMenuPresenter localListMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
        this.listMenuPresenter = localListMenuPresenter;
        localListMenuPresenter.setCallback(paramCallback);
        this.menu.addMenuPresenter(this.listMenuPresenter);
      }
      return this.listMenuPresenter.getMenuView(this.decorView);
    }
    
    public boolean hasPanelItems()
    {
      View localView = this.shownPanelView;
      boolean bool = false;
      if (localView == null) {
        return false;
      }
      if (this.createdPanelView != null) {
        return true;
      }
      if (this.listMenuPresenter.getAdapter().getCount() > 0) {
        bool = true;
      }
      return bool;
    }
    
    void onRestoreInstanceState(Parcelable paramParcelable)
    {
      paramParcelable = (SavedState)paramParcelable;
      this.featureId = paramParcelable.featureId;
      this.wasLastOpen = paramParcelable.isOpen;
      this.frozenMenuState = paramParcelable.menuState;
      this.shownPanelView = null;
      this.decorView = null;
    }
    
    Parcelable onSaveInstanceState()
    {
      SavedState localSavedState = new SavedState();
      localSavedState.featureId = this.featureId;
      localSavedState.isOpen = this.isOpen;
      if (this.menu != null)
      {
        Bundle localBundle = new Bundle();
        localSavedState.menuState = localBundle;
        this.menu.savePresenterStates(localBundle);
      }
      return localSavedState;
    }
    
    void setMenu(MenuBuilder paramMenuBuilder)
    {
      Object localObject = this.menu;
      if (paramMenuBuilder == localObject) {
        return;
      }
      if (localObject != null) {
        ((MenuBuilder)localObject).removeMenuPresenter(this.listMenuPresenter);
      }
      this.menu = paramMenuBuilder;
      if (paramMenuBuilder != null)
      {
        localObject = this.listMenuPresenter;
        if (localObject != null) {
          paramMenuBuilder.addMenuPresenter((MenuPresenter)localObject);
        }
      }
    }
    
    void setStyle(Context paramContext)
    {
      TypedValue localTypedValue = new TypedValue();
      Resources.Theme localTheme = paramContext.getResources().newTheme();
      localTheme.setTo(paramContext.getTheme());
      localTheme.resolveAttribute(R.attr.actionBarPopupTheme, localTypedValue, true);
      int i = localTypedValue.resourceId;
      if (i != 0) {
        localTheme.applyStyle(i, true);
      }
      localTheme.resolveAttribute(R.attr.panelMenuListTheme, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i != 0) {
        localTheme.applyStyle(i, true);
      } else {
        localTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
      }
      paramContext = new androidx.appcompat.view.ContextThemeWrapper(paramContext, 0);
      paramContext.getTheme().setTo(localTheme);
      this.listPresenterContext = paramContext;
      paramContext = paramContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
      this.background = paramContext.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
      this.windowAnimations = paramContext.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
      paramContext.recycle();
    }
    
    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState
      implements Parcelable
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
      {
        public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel paramAnonymousParcel)
        {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel(paramAnonymousParcel, null);
        }
        
        public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
        {
          return AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel(paramAnonymousParcel, paramAnonymousClassLoader);
        }
        
        public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int paramAnonymousInt)
        {
          return new AppCompatDelegateImpl.PanelFeatureState.SavedState[paramAnonymousInt];
        }
      };
      int featureId;
      boolean isOpen;
      Bundle menuState;
      
      static SavedState readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        SavedState localSavedState = new SavedState();
        localSavedState.featureId = paramParcel.readInt();
        int i = paramParcel.readInt();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        localSavedState.isOpen = bool;
        if (bool) {
          localSavedState.menuState = paramParcel.readBundle(paramClassLoader);
        }
        return localSavedState;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(this.featureId);
        paramParcel.writeInt(this.isOpen);
        if (this.isOpen) {
          paramParcel.writeBundle(this.menuState);
        }
      }
    }
  }
  
  private final class PanelMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    PanelMenuPresenterCallback() {}
    
    public void onCloseMenu(@NonNull MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
      int i;
      if (localMenuBuilder != paramMenuBuilder) {
        i = 1;
      } else {
        i = 0;
      }
      AppCompatDelegateImpl localAppCompatDelegateImpl = AppCompatDelegateImpl.this;
      if (i != 0) {
        paramMenuBuilder = localMenuBuilder;
      }
      paramMenuBuilder = localAppCompatDelegateImpl.findMenuPanel(paramMenuBuilder);
      if (paramMenuBuilder != null) {
        if (i != 0)
        {
          AppCompatDelegateImpl.this.callOnPanelClosed(paramMenuBuilder.featureId, paramMenuBuilder, localMenuBuilder);
          AppCompatDelegateImpl.this.closePanel(paramMenuBuilder, true);
        }
        else
        {
          AppCompatDelegateImpl.this.closePanel(paramMenuBuilder, paramBoolean);
        }
      }
    }
    
    public boolean onOpenSubMenu(@NonNull MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder == paramMenuBuilder.getRootMenu())
      {
        Object localObject = AppCompatDelegateImpl.this;
        if (((AppCompatDelegateImpl)localObject).mHasActionBar)
        {
          localObject = ((AppCompatDelegateImpl)localObject).getWindowCallback();
          if ((localObject != null) && (!AppCompatDelegateImpl.this.mIsDestroyed)) {
            ((Window.Callback)localObject).onMenuOpened(108, paramMenuBuilder);
          }
        }
      }
      return true;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\app\AppCompatDelegateImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */