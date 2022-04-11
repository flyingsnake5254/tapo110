package androidx.databinding;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.databinding.library.R.id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public abstract class ViewDataBinding
  extends BaseObservable
  implements ViewBinding
{
  private static final int BINDING_NUMBER_START = 8;
  public static final String BINDING_TAG_PREFIX = "binding_";
  private static final CreateWeakListener CREATE_LIST_LISTENER;
  private static final CreateWeakListener CREATE_LIVE_DATA_LISTENER;
  private static final CreateWeakListener CREATE_MAP_LISTENER;
  private static final CreateWeakListener CREATE_PROPERTY_LISTENER;
  private static final int HALTED = 2;
  private static final int REBIND = 1;
  private static final CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void> REBIND_NOTIFIER;
  private static final int REBOUND = 3;
  private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER;
  static int SDK_INT;
  private static final boolean USE_CHOREOGRAPHER;
  private static final ReferenceQueue<ViewDataBinding> sReferenceQueue;
  protected final DataBindingComponent mBindingComponent;
  private Choreographer mChoreographer;
  private ViewDataBinding mContainingBinding;
  private final Choreographer.FrameCallback mFrameCallback;
  private boolean mInLiveDataRegisterObserver;
  private boolean mIsExecutingPendingBindings;
  private LifecycleOwner mLifecycleOwner;
  private WeakListener[] mLocalFieldObservers;
  private OnStartListener mOnStartListener;
  private boolean mPendingRebind = false;
  private CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> mRebindCallbacks;
  private boolean mRebindHalted = false;
  private final Runnable mRebindRunnable = new Runnable()
  {
    public void run()
    {
      try
      {
        ViewDataBinding.access$202(ViewDataBinding.this, false);
        ViewDataBinding.access$300();
        if ((Build.VERSION.SDK_INT >= 19) && (!ViewDataBinding.this.mRoot.isAttachedToWindow()))
        {
          ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
          ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
          return;
        }
        ViewDataBinding.this.executePendingBindings();
        return;
      }
      finally {}
    }
  };
  private final View mRoot;
  private Handler mUIThreadHandler;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    SDK_INT = i;
    boolean bool;
    if (i >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    USE_CHOREOGRAPHER = bool;
    CREATE_PROPERTY_LISTENER = new CreateWeakListener()
    {
      public ViewDataBinding.WeakListener create(ViewDataBinding paramAnonymousViewDataBinding, int paramAnonymousInt)
      {
        return new ViewDataBinding.WeakPropertyListener(paramAnonymousViewDataBinding, paramAnonymousInt).getListener();
      }
    };
    CREATE_LIST_LISTENER = new CreateWeakListener()
    {
      public ViewDataBinding.WeakListener create(ViewDataBinding paramAnonymousViewDataBinding, int paramAnonymousInt)
      {
        return new ViewDataBinding.WeakListListener(paramAnonymousViewDataBinding, paramAnonymousInt).getListener();
      }
    };
    CREATE_MAP_LISTENER = new CreateWeakListener()
    {
      public ViewDataBinding.WeakListener create(ViewDataBinding paramAnonymousViewDataBinding, int paramAnonymousInt)
      {
        return new ViewDataBinding.WeakMapListener(paramAnonymousViewDataBinding, paramAnonymousInt).getListener();
      }
    };
    CREATE_LIVE_DATA_LISTENER = new CreateWeakListener()
    {
      public ViewDataBinding.WeakListener create(ViewDataBinding paramAnonymousViewDataBinding, int paramAnonymousInt)
      {
        return new ViewDataBinding.LiveDataListener(paramAnonymousViewDataBinding, paramAnonymousInt).getListener();
      }
    };
    REBIND_NOTIFIER = new CallbackRegistry.NotifierCallback()
    {
      public void onNotifyCallback(OnRebindCallback paramAnonymousOnRebindCallback, ViewDataBinding paramAnonymousViewDataBinding, int paramAnonymousInt, Void paramAnonymousVoid)
      {
        if (paramAnonymousInt != 1)
        {
          if (paramAnonymousInt != 2)
          {
            if (paramAnonymousInt == 3) {
              paramAnonymousOnRebindCallback.onBound(paramAnonymousViewDataBinding);
            }
          }
          else {
            paramAnonymousOnRebindCallback.onCanceled(paramAnonymousViewDataBinding);
          }
        }
        else if (!paramAnonymousOnRebindCallback.onPreBind(paramAnonymousViewDataBinding)) {
          ViewDataBinding.access$002(paramAnonymousViewDataBinding, true);
        }
      }
    };
    sReferenceQueue = new ReferenceQueue();
    if (i < 19) {
      ROOT_REATTACHED_LISTENER = null;
    } else {
      ROOT_REATTACHED_LISTENER = new View.OnAttachStateChangeListener()
      {
        @TargetApi(19)
        public void onViewAttachedToWindow(View paramAnonymousView)
        {
          ViewDataBinding.getBinding(paramAnonymousView).mRebindRunnable.run();
          paramAnonymousView.removeOnAttachStateChangeListener(this);
        }
        
        public void onViewDetachedFromWindow(View paramAnonymousView) {}
      };
    }
  }
  
  protected ViewDataBinding(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt)
  {
    this.mBindingComponent = paramDataBindingComponent;
    this.mLocalFieldObservers = new WeakListener[paramInt];
    this.mRoot = paramView;
    if (Looper.myLooper() != null)
    {
      if (USE_CHOREOGRAPHER)
      {
        this.mChoreographer = Choreographer.getInstance();
        this.mFrameCallback = new Choreographer.FrameCallback()
        {
          public void doFrame(long paramAnonymousLong)
          {
            ViewDataBinding.this.mRebindRunnable.run();
          }
        };
      }
      else
      {
        this.mFrameCallback = null;
        this.mUIThreadHandler = new Handler(Looper.myLooper());
      }
      return;
    }
    throw new IllegalStateException("DataBinding must be created in view's UI Thread");
  }
  
  protected ViewDataBinding(Object paramObject, View paramView, int paramInt)
  {
    this(checkAndCastToBindingComponent(paramObject), paramView, paramInt);
  }
  
  protected static ViewDataBinding bind(Object paramObject, View paramView, int paramInt)
  {
    return DataBindingUtil.bind(checkAndCastToBindingComponent(paramObject), paramView, paramInt);
  }
  
  private static DataBindingComponent checkAndCastToBindingComponent(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof DataBindingComponent)) {
      return (DataBindingComponent)paramObject;
    }
    throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
  }
  
  private void executeBindingsInternal()
  {
    if (this.mIsExecutingPendingBindings)
    {
      requestRebind();
      return;
    }
    if (!hasPendingBindings()) {
      return;
    }
    this.mIsExecutingPendingBindings = true;
    this.mRebindHalted = false;
    CallbackRegistry localCallbackRegistry = this.mRebindCallbacks;
    if (localCallbackRegistry != null)
    {
      localCallbackRegistry.notifyCallbacks(this, 1, null);
      if (this.mRebindHalted) {
        this.mRebindCallbacks.notifyCallbacks(this, 2, null);
      }
    }
    if (!this.mRebindHalted)
    {
      executeBindings();
      localCallbackRegistry = this.mRebindCallbacks;
      if (localCallbackRegistry != null) {
        localCallbackRegistry.notifyCallbacks(this, 3, null);
      }
    }
    this.mIsExecutingPendingBindings = false;
  }
  
  protected static void executeBindingsOn(ViewDataBinding paramViewDataBinding)
  {
    paramViewDataBinding.executeBindingsInternal();
  }
  
  private static int findIncludeIndex(String paramString, int paramInt1, IncludedLayouts paramIncludedLayouts, int paramInt2)
  {
    paramString = paramString.subSequence(paramString.indexOf('/') + 1, paramString.length() - 2);
    paramIncludedLayouts = paramIncludedLayouts.layouts[paramInt2];
    paramInt2 = paramIncludedLayouts.length;
    while (paramInt1 < paramInt2)
    {
      if (TextUtils.equals(paramString, paramIncludedLayouts[paramInt1])) {
        return paramInt1;
      }
      paramInt1++;
    }
    return -1;
  }
  
  private static int findLastMatching(ViewGroup paramViewGroup, int paramInt)
  {
    String str1 = (String)paramViewGroup.getChildAt(paramInt).getTag();
    String str2 = str1.substring(0, str1.length() - 1);
    int i = str2.length();
    int j = paramViewGroup.getChildCount();
    int k = paramInt + 1;
    int m = paramInt;
    paramInt = k;
    while (paramInt < j)
    {
      Object localObject = paramViewGroup.getChildAt(paramInt);
      if ((((View)localObject).getTag() instanceof String)) {
        localObject = (String)((View)localObject).getTag();
      } else {
        localObject = null;
      }
      k = m;
      if (localObject != null)
      {
        k = m;
        if (((String)localObject).startsWith(str2))
        {
          if ((((String)localObject).length() == str1.length()) && (((String)localObject).charAt(((String)localObject).length() - 1) == '0')) {
            return m;
          }
          k = m;
          if (isNumeric((String)localObject, i)) {
            k = paramInt;
          }
        }
      }
      paramInt++;
      m = k;
    }
    return m;
  }
  
  static ViewDataBinding getBinding(View paramView)
  {
    if (paramView != null) {
      return (ViewDataBinding)paramView.getTag(R.id.dataBinding);
    }
    return null;
  }
  
  public static int getBuildSdkInt()
  {
    return SDK_INT;
  }
  
  protected static int getColorFromResource(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramView.getContext().getColor(paramInt);
    }
    return paramView.getResources().getColor(paramInt);
  }
  
  protected static ColorStateList getColorStateListFromResource(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramView.getContext().getColorStateList(paramInt);
    }
    return paramView.getResources().getColorStateList(paramInt);
  }
  
  protected static Drawable getDrawableFromResource(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramView.getContext().getDrawable(paramInt);
    }
    return paramView.getResources().getDrawable(paramInt);
  }
  
  protected static <K, T> T getFrom(Map<K, T> paramMap, K paramK)
  {
    if (paramMap == null) {
      return null;
    }
    return (T)paramMap.get(paramK);
  }
  
  protected static byte getFromArray(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramInt < paramArrayOfByte.length)) {
      return paramArrayOfByte[paramInt];
    }
    return 0;
  }
  
  protected static char getFromArray(char[] paramArrayOfChar, int paramInt)
  {
    if ((paramArrayOfChar != null) && (paramInt >= 0) && (paramInt < paramArrayOfChar.length)) {
      return paramArrayOfChar[paramInt];
    }
    return '\000';
  }
  
  protected static double getFromArray(double[] paramArrayOfDouble, int paramInt)
  {
    if ((paramArrayOfDouble != null) && (paramInt >= 0) && (paramInt < paramArrayOfDouble.length)) {
      return paramArrayOfDouble[paramInt];
    }
    return 0.0D;
  }
  
  protected static float getFromArray(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat != null) && (paramInt >= 0) && (paramInt < paramArrayOfFloat.length)) {
      return paramArrayOfFloat[paramInt];
    }
    return 0.0F;
  }
  
  protected static int getFromArray(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt != null) && (paramInt >= 0) && (paramInt < paramArrayOfInt.length)) {
      return paramArrayOfInt[paramInt];
    }
    return 0;
  }
  
  protected static long getFromArray(long[] paramArrayOfLong, int paramInt)
  {
    if ((paramArrayOfLong != null) && (paramInt >= 0) && (paramInt < paramArrayOfLong.length)) {
      return paramArrayOfLong[paramInt];
    }
    return 0L;
  }
  
  protected static <T> T getFromArray(T[] paramArrayOfT, int paramInt)
  {
    if ((paramArrayOfT != null) && (paramInt >= 0) && (paramInt < paramArrayOfT.length)) {
      return paramArrayOfT[paramInt];
    }
    return null;
  }
  
  protected static short getFromArray(short[] paramArrayOfShort, int paramInt)
  {
    if ((paramArrayOfShort != null) && (paramInt >= 0) && (paramInt < paramArrayOfShort.length)) {
      return paramArrayOfShort[paramInt];
    }
    return 0;
  }
  
  protected static boolean getFromArray(boolean[] paramArrayOfBoolean, int paramInt)
  {
    if ((paramArrayOfBoolean != null) && (paramInt >= 0) && (paramInt < paramArrayOfBoolean.length)) {
      return paramArrayOfBoolean[paramInt];
    }
    return false;
  }
  
  protected static int getFromList(SparseIntArray paramSparseIntArray, int paramInt)
  {
    if ((paramSparseIntArray != null) && (paramInt >= 0)) {
      return paramSparseIntArray.get(paramInt);
    }
    return 0;
  }
  
  @TargetApi(18)
  protected static long getFromList(SparseLongArray paramSparseLongArray, int paramInt)
  {
    if ((paramSparseLongArray != null) && (paramInt >= 0)) {
      return paramSparseLongArray.get(paramInt);
    }
    return 0L;
  }
  
  @TargetApi(16)
  protected static <T> T getFromList(android.util.LongSparseArray<T> paramLongSparseArray, int paramInt)
  {
    if ((paramLongSparseArray != null) && (paramInt >= 0)) {
      return (T)paramLongSparseArray.get(paramInt);
    }
    return null;
  }
  
  protected static <T> T getFromList(SparseArray<T> paramSparseArray, int paramInt)
  {
    if ((paramSparseArray != null) && (paramInt >= 0)) {
      return (T)paramSparseArray.get(paramInt);
    }
    return null;
  }
  
  protected static <T> T getFromList(androidx.collection.LongSparseArray<T> paramLongSparseArray, int paramInt)
  {
    if ((paramLongSparseArray != null) && (paramInt >= 0)) {
      return (T)paramLongSparseArray.get(paramInt);
    }
    return null;
  }
  
  protected static <T> T getFromList(List<T> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt >= 0) && (paramInt < paramList.size())) {
      return (T)paramList.get(paramInt);
    }
    return null;
  }
  
  protected static boolean getFromList(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    if ((paramSparseBooleanArray != null) && (paramInt >= 0)) {
      return paramSparseBooleanArray.get(paramInt);
    }
    return false;
  }
  
  private void handleFieldChange(int paramInt1, Object paramObject, int paramInt2)
  {
    if (this.mInLiveDataRegisterObserver) {
      return;
    }
    if (onFieldChange(paramInt1, paramObject, paramInt2)) {
      requestRebind();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected static <T extends ViewDataBinding> T inflateInternal(@NonNull LayoutInflater paramLayoutInflater, int paramInt, @Nullable ViewGroup paramViewGroup, boolean paramBoolean, @Nullable Object paramObject)
  {
    return DataBindingUtil.inflate(paramLayoutInflater, paramInt, paramViewGroup, paramBoolean, checkAndCastToBindingComponent(paramObject));
  }
  
  private static boolean isNumeric(String paramString, int paramInt)
  {
    int i = paramString.length();
    int j = paramInt;
    if (i == paramInt) {
      return false;
    }
    while (j < i)
    {
      if (!Character.isDigit(paramString.charAt(j))) {
        return false;
      }
      j++;
    }
    return true;
  }
  
  private static void mapBindings(DataBindingComponent paramDataBindingComponent, View paramView, Object[] paramArrayOfObject, IncludedLayouts paramIncludedLayouts, SparseIntArray paramSparseIntArray, boolean paramBoolean)
  {
    if (getBinding(paramView) != null) {
      return;
    }
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof String)) {
      localObject1 = (String)localObject1;
    } else {
      localObject1 = null;
    }
    int i;
    int j;
    if ((paramBoolean) && (localObject1 != null) && (((String)localObject1).startsWith("layout")))
    {
      i = ((String)localObject1).lastIndexOf('_');
      if (i > 0)
      {
        i++;
        if (isNumeric((String)localObject1, i))
        {
          j = parseTagInt((String)localObject1, i);
          if (paramArrayOfObject[j] == null) {
            paramArrayOfObject[j] = paramView;
          }
          if (paramIncludedLayouts == null) {
            j = -1;
          }
          i = 1;
          break label123;
        }
      }
      j = -1;
      i = 0;
    }
    else
    {
      label123:
      if ((localObject1 != null) && (((String)localObject1).startsWith("binding_")))
      {
        i = parseTagInt((String)localObject1, BINDING_NUMBER_START);
        if (paramArrayOfObject[i] == null) {
          paramArrayOfObject[i] = paramView;
        }
        if (paramIncludedLayouts == null) {
          i = -1;
        }
        j = i;
        i = 1;
      }
      else
      {
        i = 0;
        j = -1;
      }
    }
    if (i == 0)
    {
      i = paramView.getId();
      if ((i > 0) && (paramSparseIntArray != null))
      {
        i = paramSparseIntArray.get(i, -1);
        if ((i >= 0) && (paramArrayOfObject[i] == null)) {
          paramArrayOfObject[i] = paramView;
        }
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      localObject1 = (ViewGroup)paramView;
      int k = ((ViewGroup)localObject1).getChildCount();
      i = 0;
      int m = 0;
      while (i < k)
      {
        paramView = ((ViewGroup)localObject1).getChildAt(i);
        if ((j >= 0) && ((paramView.getTag() instanceof String)))
        {
          Object localObject2 = (String)paramView.getTag();
          if ((((String)localObject2).endsWith("_0")) && (((String)localObject2).startsWith("layout")) && (((String)localObject2).indexOf('/') > 0))
          {
            n = findIncludeIndex((String)localObject2, m, paramIncludedLayouts, j);
            if (n >= 0)
            {
              int i1 = paramIncludedLayouts.indexes[j][n];
              int i2 = paramIncludedLayouts.layoutIds[j][n];
              m = findLastMatching((ViewGroup)localObject1, i);
              if (m == i) {
                paramArrayOfObject[i1] = DataBindingUtil.bind(paramDataBindingComponent, paramView, i2);
              }
              for (;;)
              {
                i2 = n + 1;
                m = 1;
                n = i;
                i = i2;
                break;
                int i3 = m - i + 1;
                localObject2 = new View[i3];
                for (m = 0; m < i3; m++) {
                  localObject2[m] = ((ViewGroup)localObject1).getChildAt(i + m);
                }
                paramArrayOfObject[i1] = DataBindingUtil.bind(paramDataBindingComponent, (View[])localObject2, i2);
                i += i3 - 1;
              }
            }
          }
        }
        int n = i;
        i = m;
        m = 0;
        if (m == 0) {
          mapBindings(paramDataBindingComponent, paramView, paramArrayOfObject, paramIncludedLayouts, paramSparseIntArray, false);
        }
        n++;
        m = i;
        i = n;
      }
    }
  }
  
  protected static Object[] mapBindings(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt, IncludedLayouts paramIncludedLayouts, SparseIntArray paramSparseIntArray)
  {
    Object[] arrayOfObject = new Object[paramInt];
    mapBindings(paramDataBindingComponent, paramView, arrayOfObject, paramIncludedLayouts, paramSparseIntArray, true);
    return arrayOfObject;
  }
  
  protected static Object[] mapBindings(DataBindingComponent paramDataBindingComponent, View[] paramArrayOfView, int paramInt, IncludedLayouts paramIncludedLayouts, SparseIntArray paramSparseIntArray)
  {
    Object[] arrayOfObject = new Object[paramInt];
    for (paramInt = 0; paramInt < paramArrayOfView.length; paramInt++) {
      mapBindings(paramDataBindingComponent, paramArrayOfView[paramInt], arrayOfObject, paramIncludedLayouts, paramSparseIntArray, true);
    }
    return arrayOfObject;
  }
  
  protected static byte parse(String paramString, byte paramByte)
  {
    try
    {
      byte b = Byte.parseByte(paramString);
      return b;
    }
    catch (NumberFormatException paramString) {}
    return paramByte;
  }
  
  protected static char parse(String paramString, char paramChar)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return paramString.charAt(0);
    }
    return paramChar;
  }
  
  protected static double parse(String paramString, double paramDouble)
  {
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  protected static float parse(String paramString, float paramFloat)
  {
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (NumberFormatException paramString) {}
    return paramFloat;
  }
  
  protected static int parse(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  protected static long parse(String paramString, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  protected static short parse(String paramString, short paramShort)
  {
    try
    {
      short s = Short.parseShort(paramString);
      return s;
    }
    catch (NumberFormatException paramString) {}
    return paramShort;
  }
  
  protected static boolean parse(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return paramBoolean;
    }
    return Boolean.parseBoolean(paramString);
  }
  
  private static int parseTagInt(String paramString, int paramInt)
  {
    int i = paramString.length();
    int j = 0;
    while (paramInt < i)
    {
      j = j * 10 + (paramString.charAt(paramInt) - '0');
      paramInt++;
    }
    return j;
  }
  
  private static void processReferenceQueue()
  {
    for (;;)
    {
      Reference localReference = sReferenceQueue.poll();
      if (localReference == null) {
        break;
      }
      if ((localReference instanceof WeakListener)) {
        ((WeakListener)localReference).unregister();
      }
    }
  }
  
  protected static byte safeUnbox(Byte paramByte)
  {
    byte b1;
    byte b2;
    if (paramByte == null)
    {
      b1 = 0;
      b2 = b1;
    }
    else
    {
      b1 = paramByte.byteValue();
      b2 = b1;
    }
    return b2;
  }
  
  protected static char safeUnbox(Character paramCharacter)
  {
    char c1;
    char c2;
    if (paramCharacter == null)
    {
      c1 = '\000';
      c2 = c1;
    }
    else
    {
      c1 = paramCharacter.charValue();
      c2 = c1;
    }
    return c2;
  }
  
  protected static double safeUnbox(Double paramDouble)
  {
    double d;
    if (paramDouble == null) {
      d = 0.0D;
    } else {
      d = paramDouble.doubleValue();
    }
    return d;
  }
  
  protected static float safeUnbox(Float paramFloat)
  {
    float f;
    if (paramFloat == null) {
      f = 0.0F;
    } else {
      f = paramFloat.floatValue();
    }
    return f;
  }
  
  protected static int safeUnbox(Integer paramInteger)
  {
    int i;
    if (paramInteger == null) {
      i = 0;
    } else {
      i = paramInteger.intValue();
    }
    return i;
  }
  
  protected static long safeUnbox(Long paramLong)
  {
    long l;
    if (paramLong == null) {
      l = 0L;
    } else {
      l = paramLong.longValue();
    }
    return l;
  }
  
  protected static short safeUnbox(Short paramShort)
  {
    short s1;
    short s2;
    if (paramShort == null)
    {
      s1 = 0;
      s2 = s1;
    }
    else
    {
      s1 = paramShort.shortValue();
      s2 = s1;
    }
    return s2;
  }
  
  protected static boolean safeUnbox(Boolean paramBoolean)
  {
    boolean bool;
    if (paramBoolean == null) {
      bool = false;
    } else {
      bool = paramBoolean.booleanValue();
    }
    return bool;
  }
  
  protected static void setBindingInverseListener(ViewDataBinding paramViewDataBinding, InverseBindingListener paramInverseBindingListener, PropertyChangedInverseListener paramPropertyChangedInverseListener)
  {
    if (paramInverseBindingListener != paramPropertyChangedInverseListener)
    {
      if (paramInverseBindingListener != null) {
        paramViewDataBinding.removeOnPropertyChangedCallback((PropertyChangedInverseListener)paramInverseBindingListener);
      }
      if (paramPropertyChangedInverseListener != null) {
        paramViewDataBinding.addOnPropertyChangedCallback(paramPropertyChangedInverseListener);
      }
    }
  }
  
  @TargetApi(16)
  protected static <T> void setTo(android.util.LongSparseArray<T> paramLongSparseArray, int paramInt, T paramT)
  {
    if ((paramLongSparseArray != null) && (paramInt >= 0) && (paramInt < paramLongSparseArray.size())) {
      paramLongSparseArray.put(paramInt, paramT);
    }
  }
  
  protected static <T> void setTo(SparseArray<T> paramSparseArray, int paramInt, T paramT)
  {
    if ((paramSparseArray != null) && (paramInt >= 0) && (paramInt < paramSparseArray.size())) {
      paramSparseArray.put(paramInt, paramT);
    }
  }
  
  protected static void setTo(SparseBooleanArray paramSparseBooleanArray, int paramInt, boolean paramBoolean)
  {
    if ((paramSparseBooleanArray != null) && (paramInt >= 0) && (paramInt < paramSparseBooleanArray.size())) {
      paramSparseBooleanArray.put(paramInt, paramBoolean);
    }
  }
  
  protected static void setTo(SparseIntArray paramSparseIntArray, int paramInt1, int paramInt2)
  {
    if ((paramSparseIntArray != null) && (paramInt1 >= 0) && (paramInt1 < paramSparseIntArray.size())) {
      paramSparseIntArray.put(paramInt1, paramInt2);
    }
  }
  
  @TargetApi(18)
  protected static void setTo(SparseLongArray paramSparseLongArray, int paramInt, long paramLong)
  {
    if ((paramSparseLongArray != null) && (paramInt >= 0) && (paramInt < paramSparseLongArray.size())) {
      paramSparseLongArray.put(paramInt, paramLong);
    }
  }
  
  protected static <T> void setTo(androidx.collection.LongSparseArray<T> paramLongSparseArray, int paramInt, T paramT)
  {
    if ((paramLongSparseArray != null) && (paramInt >= 0) && (paramInt < paramLongSparseArray.size())) {
      paramLongSparseArray.put(paramInt, paramT);
    }
  }
  
  protected static <T> void setTo(List<T> paramList, int paramInt, T paramT)
  {
    if ((paramList != null) && (paramInt >= 0) && (paramInt < paramList.size())) {
      paramList.set(paramInt, paramT);
    }
  }
  
  protected static <K, T> void setTo(Map<K, T> paramMap, K paramK, T paramT)
  {
    if (paramMap == null) {
      return;
    }
    paramMap.put(paramK, paramT);
  }
  
  protected static void setTo(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramInt < paramArrayOfByte.length)) {
      paramArrayOfByte[paramInt] = ((byte)paramByte);
    }
  }
  
  protected static void setTo(char[] paramArrayOfChar, int paramInt, char paramChar)
  {
    if ((paramArrayOfChar != null) && (paramInt >= 0) && (paramInt < paramArrayOfChar.length)) {
      paramArrayOfChar[paramInt] = ((char)paramChar);
    }
  }
  
  protected static void setTo(double[] paramArrayOfDouble, int paramInt, double paramDouble)
  {
    if ((paramArrayOfDouble != null) && (paramInt >= 0) && (paramInt < paramArrayOfDouble.length)) {
      paramArrayOfDouble[paramInt] = paramDouble;
    }
  }
  
  protected static void setTo(float[] paramArrayOfFloat, int paramInt, float paramFloat)
  {
    if ((paramArrayOfFloat != null) && (paramInt >= 0) && (paramInt < paramArrayOfFloat.length)) {
      paramArrayOfFloat[paramInt] = paramFloat;
    }
  }
  
  protected static void setTo(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfInt != null) && (paramInt1 >= 0) && (paramInt1 < paramArrayOfInt.length)) {
      paramArrayOfInt[paramInt1] = paramInt2;
    }
  }
  
  protected static void setTo(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    if ((paramArrayOfLong != null) && (paramInt >= 0) && (paramInt < paramArrayOfLong.length)) {
      paramArrayOfLong[paramInt] = paramLong;
    }
  }
  
  protected static <T> void setTo(T[] paramArrayOfT, int paramInt, T paramT)
  {
    if ((paramArrayOfT != null) && (paramInt >= 0) && (paramInt < paramArrayOfT.length)) {
      paramArrayOfT[paramInt] = paramT;
    }
  }
  
  protected static void setTo(short[] paramArrayOfShort, int paramInt, short paramShort)
  {
    if ((paramArrayOfShort != null) && (paramInt >= 0) && (paramInt < paramArrayOfShort.length)) {
      paramArrayOfShort[paramInt] = ((short)paramShort);
    }
  }
  
  protected static void setTo(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfBoolean != null) && (paramInt >= 0) && (paramInt < paramArrayOfBoolean.length)) {
      paramArrayOfBoolean[paramInt] = paramBoolean;
    }
  }
  
  private boolean updateRegistration(int paramInt, Object paramObject, CreateWeakListener paramCreateWeakListener)
  {
    if (paramObject == null) {
      return unregisterFrom(paramInt);
    }
    WeakListener localWeakListener = this.mLocalFieldObservers[paramInt];
    if (localWeakListener == null)
    {
      registerTo(paramInt, paramObject, paramCreateWeakListener);
      return true;
    }
    if (localWeakListener.getTarget() == paramObject) {
      return false;
    }
    unregisterFrom(paramInt);
    registerTo(paramInt, paramObject, paramCreateWeakListener);
    return true;
  }
  
  public void addOnRebindCallback(@NonNull OnRebindCallback paramOnRebindCallback)
  {
    if (this.mRebindCallbacks == null) {
      this.mRebindCallbacks = new CallbackRegistry(REBIND_NOTIFIER);
    }
    this.mRebindCallbacks.add(paramOnRebindCallback);
  }
  
  protected void ensureBindingComponentIsNotNull(Class<?> paramClass)
  {
    if (this.mBindingComponent != null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Required DataBindingComponent is null in class ");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(". A BindingAdapter in ");
    localStringBuilder.append(paramClass.getCanonicalName());
    localStringBuilder.append(" is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  protected abstract void executeBindings();
  
  public void executePendingBindings()
  {
    ViewDataBinding localViewDataBinding = this.mContainingBinding;
    if (localViewDataBinding == null) {
      executeBindingsInternal();
    } else {
      localViewDataBinding.executePendingBindings();
    }
  }
  
  void forceExecuteBindings()
  {
    executeBindings();
  }
  
  @Nullable
  public LifecycleOwner getLifecycleOwner()
  {
    return this.mLifecycleOwner;
  }
  
  protected Object getObservedField(int paramInt)
  {
    WeakListener localWeakListener = this.mLocalFieldObservers[paramInt];
    if (localWeakListener == null) {
      return null;
    }
    return localWeakListener.getTarget();
  }
  
  @NonNull
  public View getRoot()
  {
    return this.mRoot;
  }
  
  public abstract boolean hasPendingBindings();
  
  public abstract void invalidateAll();
  
  protected abstract boolean onFieldChange(int paramInt1, Object paramObject, int paramInt2);
  
  protected void registerTo(int paramInt, Object paramObject, CreateWeakListener paramCreateWeakListener)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject1 = this.mLocalFieldObservers[paramInt];
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramCreateWeakListener = paramCreateWeakListener.create(this, paramInt);
      this.mLocalFieldObservers[paramInt] = paramCreateWeakListener;
      localObject1 = this.mLifecycleOwner;
      localObject2 = paramCreateWeakListener;
      if (localObject1 != null)
      {
        paramCreateWeakListener.setLifecycleOwner((LifecycleOwner)localObject1);
        localObject2 = paramCreateWeakListener;
      }
    }
    ((WeakListener)localObject2).setTarget(paramObject);
  }
  
  public void removeOnRebindCallback(@NonNull OnRebindCallback paramOnRebindCallback)
  {
    CallbackRegistry localCallbackRegistry = this.mRebindCallbacks;
    if (localCallbackRegistry != null) {
      localCallbackRegistry.remove(paramOnRebindCallback);
    }
  }
  
  protected void requestRebind()
  {
    Object localObject1 = this.mContainingBinding;
    if (localObject1 != null)
    {
      ((ViewDataBinding)localObject1).requestRebind();
    }
    else
    {
      localObject1 = this.mLifecycleOwner;
      if ((localObject1 != null) && (!((LifecycleOwner)localObject1).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED))) {
        return;
      }
    }
    try
    {
      if (this.mPendingRebind) {
        return;
      }
      this.mPendingRebind = true;
      if (USE_CHOREOGRAPHER) {
        this.mChoreographer.postFrameCallback(this.mFrameCallback);
      } else {
        this.mUIThreadHandler.post(this.mRebindRunnable);
      }
      return;
    }
    finally {}
  }
  
  protected void setContainedBinding(ViewDataBinding paramViewDataBinding)
  {
    if (paramViewDataBinding != null) {
      paramViewDataBinding.mContainingBinding = this;
    }
  }
  
  @MainThread
  public void setLifecycleOwner(@Nullable LifecycleOwner paramLifecycleOwner)
  {
    LifecycleOwner localLifecycleOwner = this.mLifecycleOwner;
    if (localLifecycleOwner == paramLifecycleOwner) {
      return;
    }
    if (localLifecycleOwner != null) {
      localLifecycleOwner.getLifecycle().removeObserver(this.mOnStartListener);
    }
    this.mLifecycleOwner = paramLifecycleOwner;
    if (paramLifecycleOwner != null)
    {
      if (this.mOnStartListener == null) {
        this.mOnStartListener = new OnStartListener(this, null);
      }
      paramLifecycleOwner.getLifecycle().addObserver(this.mOnStartListener);
    }
    for (localLifecycleOwner : this.mLocalFieldObservers) {
      if (localLifecycleOwner != null) {
        localLifecycleOwner.setLifecycleOwner(paramLifecycleOwner);
      }
    }
  }
  
  protected void setRootTag(View paramView)
  {
    paramView.setTag(R.id.dataBinding, this);
  }
  
  protected void setRootTag(View[] paramArrayOfView)
  {
    int i = paramArrayOfView.length;
    for (int j = 0; j < i; j++) {
      paramArrayOfView[j].setTag(R.id.dataBinding, this);
    }
  }
  
  public abstract boolean setVariable(int paramInt, @Nullable Object paramObject);
  
  public void unbind()
  {
    for (WeakListener localWeakListener : this.mLocalFieldObservers) {
      if (localWeakListener != null) {
        localWeakListener.unregister();
      }
    }
  }
  
  protected boolean unregisterFrom(int paramInt)
  {
    WeakListener localWeakListener = this.mLocalFieldObservers[paramInt];
    if (localWeakListener != null) {
      return localWeakListener.unregister();
    }
    return false;
  }
  
  protected boolean updateLiveDataRegistration(int paramInt, LiveData<?> paramLiveData)
  {
    this.mInLiveDataRegisterObserver = true;
    try
    {
      boolean bool = updateRegistration(paramInt, paramLiveData, CREATE_LIVE_DATA_LISTENER);
      return bool;
    }
    finally
    {
      this.mInLiveDataRegisterObserver = false;
    }
  }
  
  protected boolean updateRegistration(int paramInt, Observable paramObservable)
  {
    return updateRegistration(paramInt, paramObservable, CREATE_PROPERTY_LISTENER);
  }
  
  protected boolean updateRegistration(int paramInt, ObservableList paramObservableList)
  {
    return updateRegistration(paramInt, paramObservableList, CREATE_LIST_LISTENER);
  }
  
  protected boolean updateRegistration(int paramInt, ObservableMap paramObservableMap)
  {
    return updateRegistration(paramInt, paramObservableMap, CREATE_MAP_LISTENER);
  }
  
  private static abstract interface CreateWeakListener
  {
    public abstract ViewDataBinding.WeakListener create(ViewDataBinding paramViewDataBinding, int paramInt);
  }
  
  protected static class IncludedLayouts
  {
    public final int[][] indexes;
    public final int[][] layoutIds;
    public final String[][] layouts;
    
    public IncludedLayouts(int paramInt)
    {
      this.layouts = new String[paramInt][];
      this.indexes = new int[paramInt][];
      this.layoutIds = new int[paramInt][];
    }
    
    public void setIncludes(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      this.layouts[paramInt] = paramArrayOfString;
      this.indexes[paramInt] = paramArrayOfInt1;
      this.layoutIds[paramInt] = paramArrayOfInt2;
    }
  }
  
  private static class LiveDataListener
    implements Observer, ViewDataBinding.ObservableReference<LiveData<?>>
  {
    LifecycleOwner mLifecycleOwner;
    final ViewDataBinding.WeakListener<LiveData<?>> mListener;
    
    public LiveDataListener(ViewDataBinding paramViewDataBinding, int paramInt)
    {
      this.mListener = new ViewDataBinding.WeakListener(paramViewDataBinding, paramInt, this);
    }
    
    public void addListener(LiveData<?> paramLiveData)
    {
      LifecycleOwner localLifecycleOwner = this.mLifecycleOwner;
      if (localLifecycleOwner != null) {
        paramLiveData.observe(localLifecycleOwner, this);
      }
    }
    
    public ViewDataBinding.WeakListener<LiveData<?>> getListener()
    {
      return this.mListener;
    }
    
    public void onChanged(@Nullable Object paramObject)
    {
      paramObject = this.mListener.getBinder();
      if (paramObject != null)
      {
        ViewDataBinding.WeakListener localWeakListener = this.mListener;
        ((ViewDataBinding)paramObject).handleFieldChange(localWeakListener.mLocalFieldId, localWeakListener.getTarget(), 0);
      }
    }
    
    public void removeListener(LiveData<?> paramLiveData)
    {
      paramLiveData.removeObserver(this);
    }
    
    public void setLifecycleOwner(LifecycleOwner paramLifecycleOwner)
    {
      LiveData localLiveData = (LiveData)this.mListener.getTarget();
      if (localLiveData != null)
      {
        if (this.mLifecycleOwner != null) {
          localLiveData.removeObserver(this);
        }
        if (paramLifecycleOwner != null) {
          localLiveData.observe(paramLifecycleOwner, this);
        }
      }
      this.mLifecycleOwner = paramLifecycleOwner;
    }
  }
  
  private static abstract interface ObservableReference<T>
  {
    public abstract void addListener(T paramT);
    
    public abstract ViewDataBinding.WeakListener<T> getListener();
    
    public abstract void removeListener(T paramT);
    
    public abstract void setLifecycleOwner(LifecycleOwner paramLifecycleOwner);
  }
  
  static class OnStartListener
    implements LifecycleObserver
  {
    final WeakReference<ViewDataBinding> mBinding;
    
    private OnStartListener(ViewDataBinding paramViewDataBinding)
    {
      this.mBinding = new WeakReference(paramViewDataBinding);
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart()
    {
      ViewDataBinding localViewDataBinding = (ViewDataBinding)this.mBinding.get();
      if (localViewDataBinding != null) {
        localViewDataBinding.executePendingBindings();
      }
    }
  }
  
  protected static abstract class PropertyChangedInverseListener
    extends Observable.OnPropertyChangedCallback
    implements InverseBindingListener
  {
    final int mPropertyId;
    
    public PropertyChangedInverseListener(int paramInt)
    {
      this.mPropertyId = paramInt;
    }
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      if ((paramInt == this.mPropertyId) || (paramInt == 0)) {
        onChange();
      }
    }
  }
  
  private static class WeakListListener
    extends ObservableList.OnListChangedCallback
    implements ViewDataBinding.ObservableReference<ObservableList>
  {
    final ViewDataBinding.WeakListener<ObservableList> mListener;
    
    public WeakListListener(ViewDataBinding paramViewDataBinding, int paramInt)
    {
      this.mListener = new ViewDataBinding.WeakListener(paramViewDataBinding, paramInt, this);
    }
    
    public void addListener(ObservableList paramObservableList)
    {
      paramObservableList.addOnListChangedCallback(this);
    }
    
    public ViewDataBinding.WeakListener<ObservableList> getListener()
    {
      return this.mListener;
    }
    
    public void onChanged(ObservableList paramObservableList)
    {
      ViewDataBinding localViewDataBinding = this.mListener.getBinder();
      if (localViewDataBinding == null) {
        return;
      }
      ObservableList localObservableList = (ObservableList)this.mListener.getTarget();
      if (localObservableList != paramObservableList) {
        return;
      }
      localViewDataBinding.handleFieldChange(this.mListener.mLocalFieldId, localObservableList, 0);
    }
    
    public void onItemRangeChanged(ObservableList paramObservableList, int paramInt1, int paramInt2)
    {
      onChanged(paramObservableList);
    }
    
    public void onItemRangeInserted(ObservableList paramObservableList, int paramInt1, int paramInt2)
    {
      onChanged(paramObservableList);
    }
    
    public void onItemRangeMoved(ObservableList paramObservableList, int paramInt1, int paramInt2, int paramInt3)
    {
      onChanged(paramObservableList);
    }
    
    public void onItemRangeRemoved(ObservableList paramObservableList, int paramInt1, int paramInt2)
    {
      onChanged(paramObservableList);
    }
    
    public void removeListener(ObservableList paramObservableList)
    {
      paramObservableList.removeOnListChangedCallback(this);
    }
    
    public void setLifecycleOwner(LifecycleOwner paramLifecycleOwner) {}
  }
  
  private static class WeakListener<T>
    extends WeakReference<ViewDataBinding>
  {
    protected final int mLocalFieldId;
    private final ViewDataBinding.ObservableReference<T> mObservable;
    private T mTarget;
    
    public WeakListener(ViewDataBinding paramViewDataBinding, int paramInt, ViewDataBinding.ObservableReference<T> paramObservableReference)
    {
      super(ViewDataBinding.sReferenceQueue);
      this.mLocalFieldId = paramInt;
      this.mObservable = paramObservableReference;
    }
    
    protected ViewDataBinding getBinder()
    {
      ViewDataBinding localViewDataBinding = (ViewDataBinding)get();
      if (localViewDataBinding == null) {
        unregister();
      }
      return localViewDataBinding;
    }
    
    public T getTarget()
    {
      return (T)this.mTarget;
    }
    
    public void setLifecycleOwner(LifecycleOwner paramLifecycleOwner)
    {
      this.mObservable.setLifecycleOwner(paramLifecycleOwner);
    }
    
    public void setTarget(T paramT)
    {
      unregister();
      this.mTarget = paramT;
      if (paramT != null) {
        this.mObservable.addListener(paramT);
      }
    }
    
    public boolean unregister()
    {
      Object localObject = this.mTarget;
      boolean bool;
      if (localObject != null)
      {
        this.mObservable.removeListener(localObject);
        bool = true;
      }
      else
      {
        bool = false;
      }
      this.mTarget = null;
      return bool;
    }
  }
  
  private static class WeakMapListener
    extends ObservableMap.OnMapChangedCallback
    implements ViewDataBinding.ObservableReference<ObservableMap>
  {
    final ViewDataBinding.WeakListener<ObservableMap> mListener;
    
    public WeakMapListener(ViewDataBinding paramViewDataBinding, int paramInt)
    {
      this.mListener = new ViewDataBinding.WeakListener(paramViewDataBinding, paramInt, this);
    }
    
    public void addListener(ObservableMap paramObservableMap)
    {
      paramObservableMap.addOnMapChangedCallback(this);
    }
    
    public ViewDataBinding.WeakListener<ObservableMap> getListener()
    {
      return this.mListener;
    }
    
    public void onMapChanged(ObservableMap paramObservableMap, Object paramObject)
    {
      paramObject = this.mListener.getBinder();
      if ((paramObject != null) && (paramObservableMap == this.mListener.getTarget())) {
        ((ViewDataBinding)paramObject).handleFieldChange(this.mListener.mLocalFieldId, paramObservableMap, 0);
      }
    }
    
    public void removeListener(ObservableMap paramObservableMap)
    {
      paramObservableMap.removeOnMapChangedCallback(this);
    }
    
    public void setLifecycleOwner(LifecycleOwner paramLifecycleOwner) {}
  }
  
  private static class WeakPropertyListener
    extends Observable.OnPropertyChangedCallback
    implements ViewDataBinding.ObservableReference<Observable>
  {
    final ViewDataBinding.WeakListener<Observable> mListener;
    
    public WeakPropertyListener(ViewDataBinding paramViewDataBinding, int paramInt)
    {
      this.mListener = new ViewDataBinding.WeakListener(paramViewDataBinding, paramInt, this);
    }
    
    public void addListener(Observable paramObservable)
    {
      paramObservable.addOnPropertyChangedCallback(this);
    }
    
    public ViewDataBinding.WeakListener<Observable> getListener()
    {
      return this.mListener;
    }
    
    public void onPropertyChanged(Observable paramObservable, int paramInt)
    {
      ViewDataBinding localViewDataBinding = this.mListener.getBinder();
      if (localViewDataBinding == null) {
        return;
      }
      if ((Observable)this.mListener.getTarget() != paramObservable) {
        return;
      }
      localViewDataBinding.handleFieldChange(this.mListener.mLocalFieldId, paramObservable, paramInt);
    }
    
    public void removeListener(Observable paramObservable)
    {
      paramObservable.removeOnPropertyChangedCallback(this);
    }
    
    public void setLifecycleOwner(LifecycleOwner paramLifecycleOwner) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\ViewDataBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */