package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R.attr;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;

public class AppCompatSpinner
  extends Spinner
  implements TintableBackgroundView
{
  private static final int[] ATTRS_ANDROID_SPINNERMODE = { 16843505 };
  private static final int MAX_ITEMS_MEASURED = 15;
  private static final int MODE_DIALOG = 0;
  private static final int MODE_DROPDOWN = 1;
  private static final int MODE_THEME = -1;
  private static final String TAG = "AppCompatSpinner";
  private final AppCompatBackgroundHelper mBackgroundTintHelper;
  int mDropDownWidth;
  private ForwardingListener mForwardingListener;
  private SpinnerPopup mPopup;
  private final Context mPopupContext;
  private final boolean mPopupSet;
  private SpinnerAdapter mTempAdapter;
  final Rect mTempRect;
  
  public AppCompatSpinner(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(@NonNull Context paramContext, int paramInt)
  {
    this(paramContext, null, R.attr.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public AppCompatSpinner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2, final Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 95	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 97	android/graphics/Rect
    //   11: dup
    //   12: invokespecial 99	android/graphics/Rect:<init>	()V
    //   15: putfield 101	androidx/appcompat/widget/AppCompatSpinner:mTempRect	Landroid/graphics/Rect;
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 105	android/widget/Spinner:getContext	()Landroid/content/Context;
    //   23: invokestatic 111	androidx/appcompat/widget/ThemeUtils:checkAppCompatTheme	(Landroid/view/View;Landroid/content/Context;)V
    //   26: aload_1
    //   27: aload_2
    //   28: getstatic 116	androidx/appcompat/R$styleable:Spinner	[I
    //   31: iload_3
    //   32: iconst_0
    //   33: invokestatic 122	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   36: astore 6
    //   38: aload_0
    //   39: new 124	androidx/appcompat/widget/AppCompatBackgroundHelper
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 127	androidx/appcompat/widget/AppCompatBackgroundHelper:<init>	(Landroid/view/View;)V
    //   47: putfield 129	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   50: aload 5
    //   52: ifnull +20 -> 72
    //   55: aload_0
    //   56: new 131	androidx/appcompat/view/ContextThemeWrapper
    //   59: dup
    //   60: aload_1
    //   61: aload 5
    //   63: invokespecial 134	androidx/appcompat/view/ContextThemeWrapper:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   66: putfield 136	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   69: goto +41 -> 110
    //   72: aload 6
    //   74: getstatic 139	androidx/appcompat/R$styleable:Spinner_popupTheme	I
    //   77: iconst_0
    //   78: invokevirtual 143	androidx/appcompat/widget/TintTypedArray:getResourceId	(II)I
    //   81: istore 7
    //   83: iload 7
    //   85: ifeq +20 -> 105
    //   88: aload_0
    //   89: new 131	androidx/appcompat/view/ContextThemeWrapper
    //   92: dup
    //   93: aload_1
    //   94: iload 7
    //   96: invokespecial 145	androidx/appcompat/view/ContextThemeWrapper:<init>	(Landroid/content/Context;I)V
    //   99: putfield 136	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   102: goto +8 -> 110
    //   105: aload_0
    //   106: aload_1
    //   107: putfield 136	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   110: aconst_null
    //   111: astore 8
    //   113: iload 4
    //   115: istore 7
    //   117: iload 4
    //   119: iconst_m1
    //   120: if_icmpne +128 -> 248
    //   123: aload_1
    //   124: aload_2
    //   125: getstatic 68	androidx/appcompat/widget/AppCompatSpinner:ATTRS_ANDROID_SPINNERMODE	[I
    //   128: iload_3
    //   129: iconst_0
    //   130: invokevirtual 150	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   133: astore 5
    //   135: iload 4
    //   137: istore 7
    //   139: aload 5
    //   141: astore 9
    //   143: aload 5
    //   145: astore 8
    //   147: aload 5
    //   149: iconst_0
    //   150: invokevirtual 156	android/content/res/TypedArray:hasValue	(I)Z
    //   153: ifeq +20 -> 173
    //   156: aload 5
    //   158: astore 8
    //   160: aload 5
    //   162: iconst_0
    //   163: iconst_0
    //   164: invokevirtual 159	android/content/res/TypedArray:getInt	(II)I
    //   167: istore 7
    //   169: aload 5
    //   171: astore 9
    //   173: aload 9
    //   175: invokevirtual 162	android/content/res/TypedArray:recycle	()V
    //   178: goto +70 -> 248
    //   181: astore 9
    //   183: goto +15 -> 198
    //   186: astore_2
    //   187: aload 8
    //   189: astore_1
    //   190: goto +48 -> 238
    //   193: astore 9
    //   195: aconst_null
    //   196: astore 5
    //   198: aload 5
    //   200: astore 8
    //   202: ldc 48
    //   204: ldc -92
    //   206: aload 9
    //   208: invokestatic 170	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   211: pop
    //   212: iload 4
    //   214: istore 7
    //   216: aload 5
    //   218: ifnull +30 -> 248
    //   221: iload 4
    //   223: istore 7
    //   225: aload 5
    //   227: astore 9
    //   229: goto -56 -> 173
    //   232: astore_1
    //   233: aload_1
    //   234: astore_2
    //   235: aload 8
    //   237: astore_1
    //   238: aload_1
    //   239: ifnull +7 -> 246
    //   242: aload_1
    //   243: invokevirtual 162	android/content/res/TypedArray:recycle	()V
    //   246: aload_2
    //   247: athrow
    //   248: iload 7
    //   250: ifeq +112 -> 362
    //   253: iload 7
    //   255: iconst_1
    //   256: if_icmpeq +6 -> 262
    //   259: goto +134 -> 393
    //   262: new 18	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup
    //   265: dup
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 136	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   271: aload_2
    //   272: iload_3
    //   273: invokespecial 173	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   276: astore 5
    //   278: aload_0
    //   279: getfield 136	androidx/appcompat/widget/AppCompatSpinner:mPopupContext	Landroid/content/Context;
    //   282: aload_2
    //   283: getstatic 116	androidx/appcompat/R$styleable:Spinner	[I
    //   286: iload_3
    //   287: iconst_0
    //   288: invokestatic 122	androidx/appcompat/widget/TintTypedArray:obtainStyledAttributes	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   291: astore 8
    //   293: aload_0
    //   294: aload 8
    //   296: getstatic 176	androidx/appcompat/R$styleable:Spinner_android_dropDownWidth	I
    //   299: bipush -2
    //   301: invokevirtual 179	androidx/appcompat/widget/TintTypedArray:getLayoutDimension	(II)I
    //   304: putfield 181	androidx/appcompat/widget/AppCompatSpinner:mDropDownWidth	I
    //   307: aload 5
    //   309: aload 8
    //   311: getstatic 184	androidx/appcompat/R$styleable:Spinner_android_popupBackground	I
    //   314: invokevirtual 188	androidx/appcompat/widget/TintTypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   317: invokevirtual 194	androidx/appcompat/widget/ListPopupWindow:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   320: aload 5
    //   322: aload 6
    //   324: getstatic 197	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   327: invokevirtual 201	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   330: invokevirtual 205	androidx/appcompat/widget/AppCompatSpinner$DropdownPopup:setPromptText	(Ljava/lang/CharSequence;)V
    //   333: aload 8
    //   335: invokevirtual 206	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   338: aload_0
    //   339: aload 5
    //   341: putfield 208	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   344: aload_0
    //   345: new 8	androidx/appcompat/widget/AppCompatSpinner$1
    //   348: dup
    //   349: aload_0
    //   350: aload_0
    //   351: aload 5
    //   353: invokespecial 211	androidx/appcompat/widget/AppCompatSpinner$1:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$DropdownPopup;)V
    //   356: putfield 213	androidx/appcompat/widget/AppCompatSpinner:mForwardingListener	Landroidx/appcompat/widget/ForwardingListener;
    //   359: goto +34 -> 393
    //   362: new 12	androidx/appcompat/widget/AppCompatSpinner$DialogPopup
    //   365: dup
    //   366: aload_0
    //   367: invokespecial 216	androidx/appcompat/widget/AppCompatSpinner$DialogPopup:<init>	(Landroidx/appcompat/widget/AppCompatSpinner;)V
    //   370: astore 5
    //   372: aload_0
    //   373: aload 5
    //   375: putfield 208	androidx/appcompat/widget/AppCompatSpinner:mPopup	Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   378: aload 5
    //   380: aload 6
    //   382: getstatic 197	androidx/appcompat/R$styleable:Spinner_android_prompt	I
    //   385: invokevirtual 201	androidx/appcompat/widget/TintTypedArray:getString	(I)Ljava/lang/String;
    //   388: invokeinterface 217 2 0
    //   393: aload 6
    //   395: getstatic 220	androidx/appcompat/R$styleable:Spinner_android_entries	I
    //   398: invokevirtual 224	androidx/appcompat/widget/TintTypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   401: astore 5
    //   403: aload 5
    //   405: ifnull +28 -> 433
    //   408: new 226	android/widget/ArrayAdapter
    //   411: dup
    //   412: aload_1
    //   413: ldc -29
    //   415: aload 5
    //   417: invokespecial 230	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   420: astore_1
    //   421: aload_1
    //   422: getstatic 235	androidx/appcompat/R$layout:support_simple_spinner_dropdown_item	I
    //   425: invokevirtual 239	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   428: aload_0
    //   429: aload_1
    //   430: invokevirtual 243	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   433: aload 6
    //   435: invokevirtual 206	androidx/appcompat/widget/TintTypedArray:recycle	()V
    //   438: aload_0
    //   439: iconst_1
    //   440: putfield 245	androidx/appcompat/widget/AppCompatSpinner:mPopupSet	Z
    //   443: aload_0
    //   444: getfield 247	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   447: astore_1
    //   448: aload_1
    //   449: ifnull +13 -> 462
    //   452: aload_0
    //   453: aload_1
    //   454: invokevirtual 243	androidx/appcompat/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   457: aload_0
    //   458: aconst_null
    //   459: putfield 247	androidx/appcompat/widget/AppCompatSpinner:mTempAdapter	Landroid/widget/SpinnerAdapter;
    //   462: aload_0
    //   463: getfield 129	androidx/appcompat/widget/AppCompatSpinner:mBackgroundTintHelper	Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   466: aload_2
    //   467: iload_3
    //   468: invokevirtual 251	androidx/appcompat/widget/AppCompatBackgroundHelper:loadFromAttributes	(Landroid/util/AttributeSet;I)V
    //   471: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	AppCompatSpinner
    //   0	472	1	paramContext	Context
    //   0	472	2	paramAttributeSet	AttributeSet
    //   0	472	3	paramInt1	int
    //   0	472	4	paramInt2	int
    //   0	472	5	paramTheme	Resources.Theme
    //   36	398	6	localTintTypedArray	TintTypedArray
    //   81	176	7	i	int
    //   111	223	8	localObject	Object
    //   141	33	9	localTheme1	Resources.Theme
    //   181	1	9	localException1	Exception
    //   193	14	9	localException2	Exception
    //   227	1	9	localTheme2	Resources.Theme
    // Exception table:
    //   from	to	target	type
    //   147	156	181	java/lang/Exception
    //   160	169	181	java/lang/Exception
    //   123	135	186	finally
    //   123	135	193	java/lang/Exception
    //   147	156	232	finally
    //   160	169	232	finally
    //   202	212	232	finally
  }
  
  int compatMeasureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int i = 0;
    if (paramSpinnerAdapter == null) {
      return 0;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int k = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int m = Math.max(0, getSelectedItemPosition());
    int n = Math.min(paramSpinnerAdapter.getCount(), m + 15);
    int i1 = Math.max(0, m - (15 - (n - m)));
    View localView = null;
    m = 0;
    while (i1 < n)
    {
      int i2 = paramSpinnerAdapter.getItemViewType(i1);
      int i3 = i;
      if (i2 != i)
      {
        localView = null;
        i3 = i2;
      }
      localView = paramSpinnerAdapter.getView(i1, localView, this);
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      }
      localView.measure(j, k);
      m = Math.max(m, localView.getMeasuredWidth());
      i1++;
      i = i3;
    }
    i1 = m;
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(this.mTempRect);
      paramSpinnerAdapter = this.mTempRect;
      i1 = m + (paramSpinnerAdapter.left + paramSpinnerAdapter.right);
    }
    return i1;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.applySupportBackgroundTint();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      return localSpinnerPopup.getHorizontalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownHorizontalOffset();
    }
    return 0;
  }
  
  public int getDropDownVerticalOffset()
  {
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      return localSpinnerPopup.getVerticalOffset();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownVerticalOffset();
    }
    return 0;
  }
  
  public int getDropDownWidth()
  {
    if (this.mPopup != null) {
      return this.mDropDownWidth;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getDropDownWidth();
    }
    return 0;
  }
  
  @VisibleForTesting
  final SpinnerPopup getInternalPopup()
  {
    return this.mPopup;
  }
  
  public Drawable getPopupBackground()
  {
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      return localSpinnerPopup.getBackground();
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getPopupBackground();
    }
    return null;
  }
  
  public Context getPopupContext()
  {
    return this.mPopupContext;
  }
  
  public CharSequence getPrompt()
  {
    Object localObject = this.mPopup;
    if (localObject != null) {
      localObject = ((SpinnerPopup)localObject).getHintText();
    } else {
      localObject = super.getPrompt();
    }
    return (CharSequence)localObject;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ColorStateList getSupportBackgroundTintList()
  {
    Object localObject = this.mBackgroundTintHelper;
    if (localObject != null) {
      localObject = ((AppCompatBackgroundHelper)localObject).getSupportBackgroundTintList();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    Object localObject = this.mBackgroundTintHelper;
    if (localObject != null) {
      localObject = ((AppCompatBackgroundHelper)localObject).getSupportBackgroundTintMode();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if ((localSpinnerPopup != null) && (localSpinnerPopup.isShowing())) {
      this.mPopup.dismiss();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.mShowDropdown)
    {
      paramParcelable = getViewTreeObserver();
      if (paramParcelable != null) {
        paramParcelable.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
              AppCompatSpinner.this.showPopup();
            }
            ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (localViewTreeObserver != null) {
              if (Build.VERSION.SDK_INT >= 16) {
                localViewTreeObserver.removeOnGlobalLayoutListener(this);
              } else {
                localViewTreeObserver.removeGlobalOnLayoutListener(this);
              }
            }
          }
        });
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SpinnerPopup localSpinnerPopup = this.mPopup;
    boolean bool;
    if ((localSpinnerPopup != null) && (localSpinnerPopup.isShowing())) {
      bool = true;
    } else {
      bool = false;
    }
    localSavedState.mShowDropdown = bool;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ForwardingListener localForwardingListener = this.mForwardingListener;
    if ((localForwardingListener != null) && (localForwardingListener.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null)
    {
      if (!localSpinnerPopup.isShowing()) {
        showPopup();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.mPopupSet)
    {
      this.mTempAdapter = paramSpinnerAdapter;
      return;
    }
    super.setAdapter(paramSpinnerAdapter);
    if (this.mPopup != null)
    {
      Context localContext1 = this.mPopupContext;
      Context localContext2 = localContext1;
      if (localContext1 == null) {
        localContext2 = getContext();
      }
      this.mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter, localContext2.getTheme()));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null)
    {
      localSpinnerPopup.setHorizontalOriginalOffset(paramInt);
      this.mPopup.setHorizontalOffset(paramInt);
    }
    else if (Build.VERSION.SDK_INT >= 16)
    {
      super.setDropDownHorizontalOffset(paramInt);
    }
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      localSpinnerPopup.setVerticalOffset(paramInt);
    } else if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownVerticalOffset(paramInt);
    }
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.mPopup != null) {
      this.mDropDownWidth = paramInt;
    } else if (Build.VERSION.SDK_INT >= 16) {
      super.setDropDownWidth(paramInt);
    }
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      localSpinnerPopup.setBackgroundDrawable(paramDrawable);
    } else if (Build.VERSION.SDK_INT >= 16) {
      super.setPopupBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setPopupBackgroundResource(@DrawableRes int paramInt)
  {
    setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    SpinnerPopup localSpinnerPopup = this.mPopup;
    if (localSpinnerPopup != null) {
      localSpinnerPopup.setPromptText(paramCharSequence);
    } else {
      super.setPrompt(paramCharSequence);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    AppCompatBackgroundHelper localAppCompatBackgroundHelper = this.mBackgroundTintHelper;
    if (localAppCompatBackgroundHelper != null) {
      localAppCompatBackgroundHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  void showPopup()
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.mPopup.show(getTextDirection(), getTextAlignment());
    } else {
      this.mPopup.show(-1, -1);
    }
  }
  
  @VisibleForTesting
  class DialogPopup
    implements AppCompatSpinner.SpinnerPopup, DialogInterface.OnClickListener
  {
    private ListAdapter mListAdapter;
    @VisibleForTesting
    AlertDialog mPopup;
    private CharSequence mPrompt;
    
    DialogPopup() {}
    
    public void dismiss()
    {
      AlertDialog localAlertDialog = this.mPopup;
      if (localAlertDialog != null)
      {
        localAlertDialog.dismiss();
        this.mPopup = null;
      }
    }
    
    public Drawable getBackground()
    {
      return null;
    }
    
    public CharSequence getHintText()
    {
      return this.mPrompt;
    }
    
    public int getHorizontalOffset()
    {
      return 0;
    }
    
    public int getHorizontalOriginalOffset()
    {
      return 0;
    }
    
    public int getVerticalOffset()
    {
      return 0;
    }
    
    public boolean isShowing()
    {
      AlertDialog localAlertDialog = this.mPopup;
      boolean bool;
      if (localAlertDialog != null) {
        bool = localAlertDialog.isShowing();
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppCompatSpinner.this.setSelection(paramInt);
      if (AppCompatSpinner.this.getOnItemClickListener() != null) {
        AppCompatSpinner.this.performItemClick(null, paramInt, this.mListAdapter.getItemId(paramInt));
      }
      dismiss();
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      this.mListAdapter = paramListAdapter;
    }
    
    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }
    
    public void setHorizontalOffset(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }
    
    public void setHorizontalOriginalOffset(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mPrompt = paramCharSequence;
    }
    
    public void setVerticalOffset(int paramInt)
    {
      Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }
    
    public void show(int paramInt1, int paramInt2)
    {
      if (this.mListAdapter == null) {
        return;
      }
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
      Object localObject = this.mPrompt;
      if (localObject != null) {
        localBuilder.setTitle((CharSequence)localObject);
      }
      localObject = localBuilder.setSingleChoiceItems(this.mListAdapter, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
      this.mPopup = ((AlertDialog)localObject);
      localObject = ((AlertDialog)localObject).getListView();
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((ListView)localObject).setTextDirection(paramInt1);
        ((ListView)localObject).setTextAlignment(paramInt2);
      }
      this.mPopup.show();
    }
  }
  
  private static class DropDownAdapter
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;
    
    public DropDownAdapter(@Nullable SpinnerAdapter paramSpinnerAdapter, @Nullable Resources.Theme paramTheme)
    {
      this.mAdapter = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.mListAdapter = ((ListAdapter)paramSpinnerAdapter);
      }
      if (paramTheme != null) {
        if ((Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)))
        {
          paramSpinnerAdapter = (android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
        else if ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter))
        {
          paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
          if (paramSpinnerAdapter.getDropDownViewTheme() == null) {
            paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
          }
        }
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.areAllItemsEnabled();
      }
      return true;
    }
    
    public int getCount()
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      int i;
      if (localSpinnerAdapter == null) {
        i = 0;
      } else {
        i = localSpinnerAdapter.getCount();
      }
      return i;
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter == null) {
        paramView = null;
      } else {
        paramView = localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
      }
      return paramView;
    }
    
    public Object getItem(int paramInt)
    {
      Object localObject = this.mAdapter;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((SpinnerAdapter)localObject).getItem(paramInt);
      }
      return localObject;
    }
    
    public long getItemId(int paramInt)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      long l;
      if (localSpinnerAdapter == null) {
        l = -1L;
      } else {
        l = localSpinnerAdapter.getItemId(paramInt);
      }
      return l;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      boolean bool;
      if ((localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isEmpty()
    {
      boolean bool;
      if (getCount() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.mListAdapter;
      if (localListAdapter != null) {
        return localListAdapter.isEnabled(paramInt);
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      SpinnerAdapter localSpinnerAdapter = this.mAdapter;
      if (localSpinnerAdapter != null) {
        localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  @VisibleForTesting
  class DropdownPopup
    extends ListPopupWindow
    implements AppCompatSpinner.SpinnerPopup
  {
    ListAdapter mAdapter;
    private CharSequence mHintText;
    private int mOriginalHorizontalOffset;
    private final Rect mVisibleRect = new Rect();
    
    public DropdownPopup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setAnchorView(AppCompatSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppCompatSpinner.this.setSelection(paramAnonymousInt);
          if (AppCompatSpinner.this.getOnItemClickListener() != null)
          {
            paramAnonymousAdapterView = AppCompatSpinner.DropdownPopup.this;
            paramAnonymousAdapterView.this$0.performItemClick(paramAnonymousView, paramAnonymousInt, paramAnonymousAdapterView.mAdapter.getItemId(paramAnonymousInt));
          }
          AppCompatSpinner.DropdownPopup.this.dismiss();
        }
      });
    }
    
    void computeContentWidth()
    {
      Object localObject = getBackground();
      int i = 0;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(AppCompatSpinner.this.mTempRect);
        if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
          i = AppCompatSpinner.this.mTempRect.right;
        } else {
          i = -AppCompatSpinner.this.mTempRect.left;
        }
      }
      else
      {
        localObject = AppCompatSpinner.this.mTempRect;
        ((Rect)localObject).right = 0;
        ((Rect)localObject).left = 0;
      }
      int j = AppCompatSpinner.this.getPaddingLeft();
      int k = AppCompatSpinner.this.getPaddingRight();
      int m = AppCompatSpinner.this.getWidth();
      localObject = AppCompatSpinner.this;
      int n = ((AppCompatSpinner)localObject).mDropDownWidth;
      if (n == -2)
      {
        int i1 = ((AppCompatSpinner)localObject).compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, getBackground());
        n = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
        localObject = AppCompatSpinner.this.mTempRect;
        int i2 = n - ((Rect)localObject).left - ((Rect)localObject).right;
        n = i1;
        if (i1 > i2) {
          n = i2;
        }
        setContentWidth(Math.max(n, m - j - k));
      }
      else if (n == -1)
      {
        setContentWidth(m - j - k);
      }
      else
      {
        setContentWidth(n);
      }
      if (ViewUtils.isLayoutRtl(AppCompatSpinner.this)) {
        i += m - k - getWidth() - getHorizontalOriginalOffset();
      } else {
        i += j + getHorizontalOriginalOffset();
      }
      setHorizontalOffset(i);
    }
    
    public CharSequence getHintText()
    {
      return this.mHintText;
    }
    
    public int getHorizontalOriginalOffset()
    {
      return this.mOriginalHorizontalOffset;
    }
    
    boolean isVisibleToUser(View paramView)
    {
      boolean bool;
      if ((ViewCompat.isAttachedToWindow(paramView)) && (paramView.getGlobalVisibleRect(this.mVisibleRect))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.mAdapter = paramListAdapter;
    }
    
    public void setHorizontalOriginalOffset(int paramInt)
    {
      this.mOriginalHorizontalOffset = paramInt;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mHintText = paramCharSequence;
    }
    
    public void show(int paramInt1, int paramInt2)
    {
      boolean bool = isShowing();
      computeContentWidth();
      setInputMethodMode(2);
      super.show();
      final Object localObject = getListView();
      ((ListView)localObject).setChoiceMode(1);
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((ListView)localObject).setTextDirection(paramInt1);
        ((ListView)localObject).setTextAlignment(paramInt2);
      }
      setSelection(AppCompatSpinner.this.getSelectedItemPosition());
      if (bool) {
        return;
      }
      ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
      if (localViewTreeObserver != null)
      {
        localObject = new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public void onGlobalLayout()
          {
            AppCompatSpinner.DropdownPopup localDropdownPopup = AppCompatSpinner.DropdownPopup.this;
            if (!localDropdownPopup.isVisibleToUser(localDropdownPopup.this$0))
            {
              AppCompatSpinner.DropdownPopup.this.dismiss();
            }
            else
            {
              AppCompatSpinner.DropdownPopup.this.computeContentWidth();
              AppCompatSpinner.DropdownPopup.this.show();
            }
          }
        };
        localViewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject);
        setOnDismissListener(new PopupWindow.OnDismissListener()
        {
          public void onDismiss()
          {
            ViewTreeObserver localViewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (localViewTreeObserver != null) {
              localViewTreeObserver.removeGlobalOnLayoutListener(localObject);
            }
          }
        });
      }
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public AppCompatSpinner.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AppCompatSpinner.SavedState(paramAnonymousParcel);
      }
      
      public AppCompatSpinner.SavedState[] newArray(int paramAnonymousInt)
      {
        return new AppCompatSpinner.SavedState[paramAnonymousInt];
      }
    };
    boolean mShowDropdown;
    
    SavedState(Parcel paramParcel)
    {
      super();
      boolean bool;
      if (paramParcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.mShowDropdown = bool;
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeByte((byte)this.mShowDropdown);
    }
  }
  
  @VisibleForTesting
  static abstract interface SpinnerPopup
  {
    public abstract void dismiss();
    
    public abstract Drawable getBackground();
    
    public abstract CharSequence getHintText();
    
    public abstract int getHorizontalOffset();
    
    public abstract int getHorizontalOriginalOffset();
    
    public abstract int getVerticalOffset();
    
    public abstract boolean isShowing();
    
    public abstract void setAdapter(ListAdapter paramListAdapter);
    
    public abstract void setBackgroundDrawable(Drawable paramDrawable);
    
    public abstract void setHorizontalOffset(int paramInt);
    
    public abstract void setHorizontalOriginalOffset(int paramInt);
    
    public abstract void setPromptText(CharSequence paramCharSequence);
    
    public abstract void setVerticalOffset(int paramInt);
    
    public abstract void show(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */