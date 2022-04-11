package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

public class WindowInsetsCompat
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
  private static final String TAG = "WindowInsetsCompat";
  private final Impl mImpl;
  
  @RequiresApi(20)
  private WindowInsetsCompat(@NonNull WindowInsets paramWindowInsets)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29) {
      this.mImpl = new Impl29(this, paramWindowInsets);
    } else if (i >= 28) {
      this.mImpl = new Impl28(this, paramWindowInsets);
    } else if (i >= 21) {
      this.mImpl = new Impl21(this, paramWindowInsets);
    } else if (i >= 20) {
      this.mImpl = new Impl20(this, paramWindowInsets);
    } else {
      this.mImpl = new Impl(this);
    }
  }
  
  public WindowInsetsCompat(@Nullable WindowInsetsCompat paramWindowInsetsCompat)
  {
    if (paramWindowInsetsCompat != null)
    {
      paramWindowInsetsCompat = paramWindowInsetsCompat.mImpl;
      int i = Build.VERSION.SDK_INT;
      if ((i >= 29) && ((paramWindowInsetsCompat instanceof Impl29))) {
        this.mImpl = new Impl29(this, (Impl29)paramWindowInsetsCompat);
      } else if ((i >= 28) && ((paramWindowInsetsCompat instanceof Impl28))) {
        this.mImpl = new Impl28(this, (Impl28)paramWindowInsetsCompat);
      } else if ((i >= 21) && ((paramWindowInsetsCompat instanceof Impl21))) {
        this.mImpl = new Impl21(this, (Impl21)paramWindowInsetsCompat);
      } else if ((i >= 20) && ((paramWindowInsetsCompat instanceof Impl20))) {
        this.mImpl = new Impl20(this, (Impl20)paramWindowInsetsCompat);
      } else {
        this.mImpl = new Impl(this);
      }
    }
    else
    {
      this.mImpl = new Impl(this);
    }
  }
  
  static Insets insetInsets(Insets paramInsets, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Math.max(0, paramInsets.left - paramInt1);
    int j = Math.max(0, paramInsets.top - paramInt2);
    int k = Math.max(0, paramInsets.right - paramInt3);
    int m = Math.max(0, paramInsets.bottom - paramInt4);
    if ((i == paramInt1) && (j == paramInt2) && (k == paramInt3) && (m == paramInt4)) {
      return paramInsets;
    }
    return Insets.of(i, j, k, m);
  }
  
  @NonNull
  @RequiresApi(20)
  public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets paramWindowInsets)
  {
    return new WindowInsetsCompat((WindowInsets)Preconditions.checkNotNull(paramWindowInsets));
  }
  
  @NonNull
  public WindowInsetsCompat consumeDisplayCutout()
  {
    return this.mImpl.consumeDisplayCutout();
  }
  
  @NonNull
  public WindowInsetsCompat consumeStableInsets()
  {
    return this.mImpl.consumeStableInsets();
  }
  
  @NonNull
  public WindowInsetsCompat consumeSystemWindowInsets()
  {
    return this.mImpl.consumeSystemWindowInsets();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof WindowInsetsCompat)) {
      return false;
    }
    paramObject = (WindowInsetsCompat)paramObject;
    return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat)paramObject).mImpl);
  }
  
  @Nullable
  public DisplayCutoutCompat getDisplayCutout()
  {
    return this.mImpl.getDisplayCutout();
  }
  
  @NonNull
  public Insets getMandatorySystemGestureInsets()
  {
    return this.mImpl.getMandatorySystemGestureInsets();
  }
  
  public int getStableInsetBottom()
  {
    return getStableInsets().bottom;
  }
  
  public int getStableInsetLeft()
  {
    return getStableInsets().left;
  }
  
  public int getStableInsetRight()
  {
    return getStableInsets().right;
  }
  
  public int getStableInsetTop()
  {
    return getStableInsets().top;
  }
  
  @NonNull
  public Insets getStableInsets()
  {
    return this.mImpl.getStableInsets();
  }
  
  @NonNull
  public Insets getSystemGestureInsets()
  {
    return this.mImpl.getSystemGestureInsets();
  }
  
  public int getSystemWindowInsetBottom()
  {
    return getSystemWindowInsets().bottom;
  }
  
  public int getSystemWindowInsetLeft()
  {
    return getSystemWindowInsets().left;
  }
  
  public int getSystemWindowInsetRight()
  {
    return getSystemWindowInsets().right;
  }
  
  public int getSystemWindowInsetTop()
  {
    return getSystemWindowInsets().top;
  }
  
  @NonNull
  public Insets getSystemWindowInsets()
  {
    return this.mImpl.getSystemWindowInsets();
  }
  
  @NonNull
  public Insets getTappableElementInsets()
  {
    return this.mImpl.getTappableElementInsets();
  }
  
  public boolean hasInsets()
  {
    if ((!hasSystemWindowInsets()) && (!hasStableInsets()) && (getDisplayCutout() == null))
    {
      Insets localInsets1 = getSystemGestureInsets();
      Insets localInsets2 = Insets.NONE;
      if ((localInsets1.equals(localInsets2)) && (getMandatorySystemGestureInsets().equals(localInsets2)) && (getTappableElementInsets().equals(localInsets2))) {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public boolean hasStableInsets()
  {
    return getStableInsets().equals(Insets.NONE) ^ true;
  }
  
  public boolean hasSystemWindowInsets()
  {
    return getSystemWindowInsets().equals(Insets.NONE) ^ true;
  }
  
  public int hashCode()
  {
    Impl localImpl = this.mImpl;
    int i;
    if (localImpl == null) {
      i = 0;
    } else {
      i = localImpl.hashCode();
    }
    return i;
  }
  
  @NonNull
  public WindowInsetsCompat inset(@IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4)
  {
    return this.mImpl.inset(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @NonNull
  public WindowInsetsCompat inset(@NonNull Insets paramInsets)
  {
    return inset(paramInsets.left, paramInsets.top, paramInsets.right, paramInsets.bottom);
  }
  
  public boolean isConsumed()
  {
    return this.mImpl.isConsumed();
  }
  
  public boolean isRound()
  {
    return this.mImpl.isRound();
  }
  
  @Deprecated
  @NonNull
  public WindowInsetsCompat replaceSystemWindowInsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return new Builder(this).setSystemWindowInsets(Insets.of(paramInt1, paramInt2, paramInt3, paramInt4)).build();
  }
  
  @Deprecated
  @NonNull
  public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect paramRect)
  {
    return new Builder(this).setSystemWindowInsets(Insets.of(paramRect)).build();
  }
  
  @Nullable
  @RequiresApi(20)
  public WindowInsets toWindowInsets()
  {
    Object localObject = this.mImpl;
    if ((localObject instanceof Impl20)) {
      localObject = ((Impl20)localObject).mPlatformInsets;
    } else {
      localObject = null;
    }
    return (WindowInsets)localObject;
  }
  
  public static final class Builder
  {
    private final WindowInsetsCompat.BuilderImpl mImpl;
    
    public Builder()
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 29) {
        this.mImpl = new WindowInsetsCompat.BuilderImpl29();
      } else if (i >= 20) {
        this.mImpl = new WindowInsetsCompat.BuilderImpl20();
      } else {
        this.mImpl = new WindowInsetsCompat.BuilderImpl();
      }
    }
    
    public Builder(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 29) {
        this.mImpl = new WindowInsetsCompat.BuilderImpl29(paramWindowInsetsCompat);
      } else if (i >= 20) {
        this.mImpl = new WindowInsetsCompat.BuilderImpl20(paramWindowInsetsCompat);
      } else {
        this.mImpl = new WindowInsetsCompat.BuilderImpl(paramWindowInsetsCompat);
      }
    }
    
    @NonNull
    public WindowInsetsCompat build()
    {
      return this.mImpl.build();
    }
    
    @NonNull
    public Builder setDisplayCutout(@Nullable DisplayCutoutCompat paramDisplayCutoutCompat)
    {
      this.mImpl.setDisplayCutout(paramDisplayCutoutCompat);
      return this;
    }
    
    @NonNull
    public Builder setMandatorySystemGestureInsets(@NonNull Insets paramInsets)
    {
      this.mImpl.setMandatorySystemGestureInsets(paramInsets);
      return this;
    }
    
    @NonNull
    public Builder setStableInsets(@NonNull Insets paramInsets)
    {
      this.mImpl.setStableInsets(paramInsets);
      return this;
    }
    
    @NonNull
    public Builder setSystemGestureInsets(@NonNull Insets paramInsets)
    {
      this.mImpl.setSystemGestureInsets(paramInsets);
      return this;
    }
    
    @NonNull
    public Builder setSystemWindowInsets(@NonNull Insets paramInsets)
    {
      this.mImpl.setSystemWindowInsets(paramInsets);
      return this;
    }
    
    @NonNull
    public Builder setTappableElementInsets(@NonNull Insets paramInsets)
    {
      this.mImpl.setTappableElementInsets(paramInsets);
      return this;
    }
  }
  
  private static class BuilderImpl
  {
    private final WindowInsetsCompat mInsets;
    
    BuilderImpl()
    {
      this(new WindowInsetsCompat(null));
    }
    
    BuilderImpl(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
    {
      this.mInsets = paramWindowInsetsCompat;
    }
    
    @NonNull
    WindowInsetsCompat build()
    {
      return this.mInsets;
    }
    
    void setDisplayCutout(@Nullable DisplayCutoutCompat paramDisplayCutoutCompat) {}
    
    void setMandatorySystemGestureInsets(@NonNull Insets paramInsets) {}
    
    void setStableInsets(@NonNull Insets paramInsets) {}
    
    void setSystemGestureInsets(@NonNull Insets paramInsets) {}
    
    void setSystemWindowInsets(@NonNull Insets paramInsets) {}
    
    void setTappableElementInsets(@NonNull Insets paramInsets) {}
  }
  
  @RequiresApi(api=20)
  private static class BuilderImpl20
    extends WindowInsetsCompat.BuilderImpl
  {
    private static Constructor<WindowInsets> sConstructor;
    private static boolean sConstructorFetched = false;
    private static Field sConsumedField;
    private static boolean sConsumedFieldFetched = false;
    private WindowInsets mInsets;
    
    BuilderImpl20()
    {
      this.mInsets = createWindowInsetsInstance();
    }
    
    BuilderImpl20(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
    {
      this.mInsets = paramWindowInsetsCompat.toWindowInsets();
    }
    
    @Nullable
    private static WindowInsets createWindowInsetsInstance()
    {
      if (!sConsumedFieldFetched)
      {
        try
        {
          sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
        }
        catch (ReflectiveOperationException localReflectiveOperationException1)
        {
          Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", localReflectiveOperationException1);
        }
        sConsumedFieldFetched = true;
      }
      Object localObject1 = sConsumedField;
      if (localObject1 != null) {
        try
        {
          localObject1 = (WindowInsets)((Field)localObject1).get(null);
          if (localObject1 != null)
          {
            localObject1 = new WindowInsets((WindowInsets)localObject1);
            return (WindowInsets)localObject1;
          }
        }
        catch (ReflectiveOperationException localReflectiveOperationException2)
        {
          Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", localReflectiveOperationException2);
        }
      }
      if (!sConstructorFetched)
      {
        try
        {
          sConstructor = WindowInsets.class.getConstructor(new Class[] { Rect.class });
        }
        catch (ReflectiveOperationException localReflectiveOperationException3)
        {
          Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", localReflectiveOperationException3);
        }
        sConstructorFetched = true;
      }
      Constructor localConstructor = sConstructor;
      if (localConstructor != null) {
        try
        {
          Object localObject2 = new android/graphics/Rect;
          ((Rect)localObject2).<init>();
          localObject2 = (WindowInsets)localConstructor.newInstance(new Object[] { localObject2 });
          return (WindowInsets)localObject2;
        }
        catch (ReflectiveOperationException localReflectiveOperationException4)
        {
          Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", localReflectiveOperationException4);
        }
      }
      return null;
    }
    
    @NonNull
    WindowInsetsCompat build()
    {
      return WindowInsetsCompat.toWindowInsetsCompat(this.mInsets);
    }
    
    void setSystemWindowInsets(@NonNull Insets paramInsets)
    {
      WindowInsets localWindowInsets = this.mInsets;
      if (localWindowInsets != null) {
        this.mInsets = localWindowInsets.replaceSystemWindowInsets(paramInsets.left, paramInsets.top, paramInsets.right, paramInsets.bottom);
      }
    }
  }
  
  @RequiresApi(api=29)
  private static class BuilderImpl29
    extends WindowInsetsCompat.BuilderImpl
  {
    final WindowInsets.Builder mPlatBuilder;
    
    BuilderImpl29()
    {
      this.mPlatBuilder = new WindowInsets.Builder();
    }
    
    BuilderImpl29(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
    {
      paramWindowInsetsCompat = paramWindowInsetsCompat.toWindowInsets();
      if (paramWindowInsetsCompat != null) {
        paramWindowInsetsCompat = new WindowInsets.Builder(paramWindowInsetsCompat);
      } else {
        paramWindowInsetsCompat = new WindowInsets.Builder();
      }
      this.mPlatBuilder = paramWindowInsetsCompat;
    }
    
    @NonNull
    WindowInsetsCompat build()
    {
      return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
    }
    
    void setDisplayCutout(@Nullable DisplayCutoutCompat paramDisplayCutoutCompat)
    {
      WindowInsets.Builder localBuilder = this.mPlatBuilder;
      if (paramDisplayCutoutCompat != null) {
        paramDisplayCutoutCompat = paramDisplayCutoutCompat.unwrap();
      } else {
        paramDisplayCutoutCompat = null;
      }
      localBuilder.setDisplayCutout(paramDisplayCutoutCompat);
    }
    
    void setMandatorySystemGestureInsets(@NonNull Insets paramInsets)
    {
      this.mPlatBuilder.setMandatorySystemGestureInsets(paramInsets.toPlatformInsets());
    }
    
    void setStableInsets(@NonNull Insets paramInsets)
    {
      this.mPlatBuilder.setStableInsets(paramInsets.toPlatformInsets());
    }
    
    void setSystemGestureInsets(@NonNull Insets paramInsets)
    {
      this.mPlatBuilder.setSystemGestureInsets(paramInsets.toPlatformInsets());
    }
    
    void setSystemWindowInsets(@NonNull Insets paramInsets)
    {
      this.mPlatBuilder.setSystemWindowInsets(paramInsets.toPlatformInsets());
    }
    
    void setTappableElementInsets(@NonNull Insets paramInsets)
    {
      this.mPlatBuilder.setTappableElementInsets(paramInsets.toPlatformInsets());
    }
  }
  
  private static class Impl
  {
    final WindowInsetsCompat mHost;
    
    Impl(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
    {
      this.mHost = paramWindowInsetsCompat;
    }
    
    @NonNull
    WindowInsetsCompat consumeDisplayCutout()
    {
      return this.mHost;
    }
    
    @NonNull
    WindowInsetsCompat consumeStableInsets()
    {
      return this.mHost;
    }
    
    @NonNull
    WindowInsetsCompat consumeSystemWindowInsets()
    {
      return this.mHost;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof Impl)) {
        return false;
      }
      paramObject = (Impl)paramObject;
      if ((isRound() != ((Impl)paramObject).isRound()) || (isConsumed() != ((Impl)paramObject).isConsumed()) || (!ObjectsCompat.equals(getSystemWindowInsets(), ((Impl)paramObject).getSystemWindowInsets())) || (!ObjectsCompat.equals(getStableInsets(), ((Impl)paramObject).getStableInsets())) || (!ObjectsCompat.equals(getDisplayCutout(), ((Impl)paramObject).getDisplayCutout()))) {
        bool = false;
      }
      return bool;
    }
    
    @Nullable
    DisplayCutoutCompat getDisplayCutout()
    {
      return null;
    }
    
    @NonNull
    Insets getMandatorySystemGestureInsets()
    {
      return getSystemWindowInsets();
    }
    
    @NonNull
    Insets getStableInsets()
    {
      return Insets.NONE;
    }
    
    @NonNull
    Insets getSystemGestureInsets()
    {
      return getSystemWindowInsets();
    }
    
    @NonNull
    Insets getSystemWindowInsets()
    {
      return Insets.NONE;
    }
    
    @NonNull
    Insets getTappableElementInsets()
    {
      return getSystemWindowInsets();
    }
    
    public int hashCode()
    {
      return ObjectsCompat.hash(new Object[] { Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout() });
    }
    
    @NonNull
    WindowInsetsCompat inset(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return WindowInsetsCompat.CONSUMED;
    }
    
    boolean isConsumed()
    {
      return false;
    }
    
    boolean isRound()
    {
      return false;
    }
  }
  
  @RequiresApi(20)
  private static class Impl20
    extends WindowInsetsCompat.Impl
  {
    @NonNull
    final WindowInsets mPlatformInsets;
    private Insets mSystemWindowInsets = null;
    
    Impl20(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull WindowInsets paramWindowInsets)
    {
      super();
      this.mPlatformInsets = paramWindowInsets;
    }
    
    Impl20(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Impl20 paramImpl20)
    {
      this(paramWindowInsetsCompat, new WindowInsets(paramImpl20.mPlatformInsets));
    }
    
    @NonNull
    final Insets getSystemWindowInsets()
    {
      if (this.mSystemWindowInsets == null) {
        this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
      }
      return this.mSystemWindowInsets;
    }
    
    @NonNull
    WindowInsetsCompat inset(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      WindowInsetsCompat.Builder localBuilder = new WindowInsetsCompat.Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
      localBuilder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), paramInt1, paramInt2, paramInt3, paramInt4));
      localBuilder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), paramInt1, paramInt2, paramInt3, paramInt4));
      return localBuilder.build();
    }
    
    boolean isRound()
    {
      return this.mPlatformInsets.isRound();
    }
  }
  
  @RequiresApi(21)
  private static class Impl21
    extends WindowInsetsCompat.Impl20
  {
    private Insets mStableInsets = null;
    
    Impl21(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    Impl21(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Impl21 paramImpl21)
    {
      super(paramImpl21);
    }
    
    @NonNull
    WindowInsetsCompat consumeStableInsets()
    {
      return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
    }
    
    @NonNull
    WindowInsetsCompat consumeSystemWindowInsets()
    {
      return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
    }
    
    @NonNull
    final Insets getStableInsets()
    {
      if (this.mStableInsets == null) {
        this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
      }
      return this.mStableInsets;
    }
    
    boolean isConsumed()
    {
      return this.mPlatformInsets.isConsumed();
    }
  }
  
  @RequiresApi(28)
  private static class Impl28
    extends WindowInsetsCompat.Impl21
  {
    Impl28(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    Impl28(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Impl28 paramImpl28)
    {
      super(paramImpl28);
    }
    
    @NonNull
    WindowInsetsCompat consumeDisplayCutout()
    {
      return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof Impl28)) {
        return false;
      }
      paramObject = (Impl28)paramObject;
      return Objects.equals(this.mPlatformInsets, ((WindowInsetsCompat.Impl20)paramObject).mPlatformInsets);
    }
    
    @Nullable
    DisplayCutoutCompat getDisplayCutout()
    {
      return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
    }
    
    public int hashCode()
    {
      return this.mPlatformInsets.hashCode();
    }
  }
  
  @RequiresApi(29)
  private static class Impl29
    extends WindowInsetsCompat.Impl28
  {
    private Insets mMandatorySystemGestureInsets = null;
    private Insets mSystemGestureInsets = null;
    private Insets mTappableElementInsets = null;
    
    Impl29(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    Impl29(@NonNull WindowInsetsCompat paramWindowInsetsCompat, @NonNull Impl29 paramImpl29)
    {
      super(paramImpl29);
    }
    
    @NonNull
    Insets getMandatorySystemGestureInsets()
    {
      if (this.mMandatorySystemGestureInsets == null) {
        this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
      }
      return this.mMandatorySystemGestureInsets;
    }
    
    @NonNull
    Insets getSystemGestureInsets()
    {
      if (this.mSystemGestureInsets == null) {
        this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
      }
      return this.mSystemGestureInsets;
    }
    
    @NonNull
    Insets getTappableElementInsets()
    {
      if (this.mTappableElementInsets == null) {
        this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
      }
      return this.mTappableElementInsets;
    }
    
    @NonNull
    WindowInsetsCompat inset(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(paramInt1, paramInt2, paramInt3, paramInt4));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\WindowInsetsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */