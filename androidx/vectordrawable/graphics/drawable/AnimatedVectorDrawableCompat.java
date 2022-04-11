package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat
  extends VectorDrawableCommon
  implements Animatable2Compat
{
  private static final String ANIMATED_VECTOR = "animated-vector";
  private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
  private static final String LOGTAG = "AnimatedVDCompat";
  private static final String TARGET = "target";
  private AnimatedVectorDrawableCompatState mAnimatedVectorState;
  ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks = null;
  private Animator.AnimatorListener mAnimatorListener = null;
  private ArgbEvaluator mArgbEvaluator = null;
  AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
  final Drawable.Callback mCallback;
  private Context mContext;
  
  AnimatedVectorDrawableCompat()
  {
    this(null, null, null);
  }
  
  private AnimatedVectorDrawableCompat(@Nullable Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  private AnimatedVectorDrawableCompat(@Nullable Context paramContext, @Nullable AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, @Nullable Resources paramResources)
  {
    Drawable.Callback local1 = new Drawable.Callback()
    {
      public void invalidateDrawable(Drawable paramAnonymousDrawable)
      {
        AnimatedVectorDrawableCompat.this.invalidateSelf();
      }
      
      public void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
      {
        AnimatedVectorDrawableCompat.this.scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
      }
      
      public void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
      {
        AnimatedVectorDrawableCompat.this.unscheduleSelf(paramAnonymousRunnable);
      }
    };
    this.mCallback = local1;
    this.mContext = paramContext;
    if (paramAnimatedVectorDrawableCompatState != null) {
      this.mAnimatedVectorState = paramAnimatedVectorDrawableCompatState;
    } else {
      this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(paramContext, paramAnimatedVectorDrawableCompatState, local1, paramResources);
    }
  }
  
  public static void clearAnimationCallbacks(Drawable paramDrawable)
  {
    if (!(paramDrawable instanceof Animatable)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 24) {
      ((AnimatedVectorDrawable)paramDrawable).clearAnimationCallbacks();
    } else {
      ((AnimatedVectorDrawableCompat)paramDrawable).clearAnimationCallbacks();
    }
  }
  
  @Nullable
  public static AnimatedVectorDrawableCompat create(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new AnimatedVectorDrawableCompat(paramContext);
      paramContext = ResourcesCompat.getDrawable(paramContext.getResources(), paramInt, paramContext.getTheme());
      ((VectorDrawableCommon)localObject).mDelegateDrawable = paramContext;
      paramContext.setCallback(((AnimatedVectorDrawableCompat)localObject).mCallback);
      ((AnimatedVectorDrawableCompat)localObject).mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(((VectorDrawableCommon)localObject).mDelegateDrawable.getConstantState());
      return (AnimatedVectorDrawableCompat)localObject;
    }
    Object localObject = paramContext.getResources();
    try
    {
      XmlResourceParser localXmlResourceParser = ((Resources)localObject).getXml(paramInt);
      localObject = Xml.asAttributeSet(localXmlResourceParser);
      do
      {
        paramInt = localXmlResourceParser.next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return createFromXmlInner(paramContext, paramContext.getResources(), localXmlResourceParser, (AttributeSet)localObject, paramContext.getTheme());
      }
      paramContext = new org/xmlpull/v1/XmlPullParserException;
      paramContext.<init>("No start tag found");
      throw paramContext;
    }
    catch (IOException paramContext)
    {
      Log.e("AnimatedVDCompat", "parser error", paramContext);
    }
    catch (XmlPullParserException paramContext)
    {
      Log.e("AnimatedVDCompat", "parser error", paramContext);
    }
    return null;
  }
  
  public static AnimatedVectorDrawableCompat createFromXmlInner(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    paramContext = new AnimatedVectorDrawableCompat(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  public static void registerAnimationCallback(Drawable paramDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if ((paramDrawable != null) && (paramAnimationCallback != null))
    {
      if (!(paramDrawable instanceof Animatable)) {
        return;
      }
      if (Build.VERSION.SDK_INT >= 24) {
        registerPlatformCallback((AnimatedVectorDrawable)paramDrawable, paramAnimationCallback);
      } else {
        ((AnimatedVectorDrawableCompat)paramDrawable).registerAnimationCallback(paramAnimationCallback);
      }
    }
  }
  
  @RequiresApi(23)
  private static void registerPlatformCallback(@NonNull AnimatedVectorDrawable paramAnimatedVectorDrawable, @NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    paramAnimatedVectorDrawable.registerAnimationCallback(paramAnimationCallback.getPlatformCallback());
  }
  
  private void removeAnimatorSetListener()
  {
    Animator.AnimatorListener localAnimatorListener = this.mAnimatorListener;
    if (localAnimatorListener != null)
    {
      this.mAnimatedVectorState.mAnimatorSet.removeListener(localAnimatorListener);
      this.mAnimatorListener = null;
    }
  }
  
  private void setupAnimatorsForTarget(String paramString, Animator paramAnimator)
  {
    paramAnimator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(paramString));
    if (Build.VERSION.SDK_INT < 21) {
      setupColorAnimator(paramAnimator);
    }
    AnimatedVectorDrawableCompatState localAnimatedVectorDrawableCompatState = this.mAnimatedVectorState;
    if (localAnimatedVectorDrawableCompatState.mAnimators == null)
    {
      localAnimatedVectorDrawableCompatState.mAnimators = new ArrayList();
      this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
    }
    this.mAnimatedVectorState.mAnimators.add(paramAnimator);
    this.mAnimatedVectorState.mTargetNameMap.put(paramAnimator, paramString);
  }
  
  private void setupColorAnimator(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null) {
        for (int i = 0; i < ((List)localObject).size(); i++) {
          setupColorAnimator((Animator)((List)localObject).get(i));
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      localObject = (ObjectAnimator)paramAnimator;
      paramAnimator = ((ObjectAnimator)localObject).getPropertyName();
      if (("fillColor".equals(paramAnimator)) || ("strokeColor".equals(paramAnimator)))
      {
        if (this.mArgbEvaluator == null) {
          this.mArgbEvaluator = new ArgbEvaluator();
        }
        ((ObjectAnimator)localObject).setEvaluator(this.mArgbEvaluator);
      }
    }
  }
  
  public static boolean unregisterAnimationCallback(Drawable paramDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if ((paramDrawable != null) && (paramAnimationCallback != null))
    {
      if (!(paramDrawable instanceof Animatable)) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 24) {
        return unregisterPlatformCallback((AnimatedVectorDrawable)paramDrawable, paramAnimationCallback);
      }
      return ((AnimatedVectorDrawableCompat)paramDrawable).unregisterAnimationCallback(paramAnimationCallback);
    }
    return false;
  }
  
  @RequiresApi(23)
  private static boolean unregisterPlatformCallback(AnimatedVectorDrawable paramAnimatedVectorDrawable, Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    return paramAnimatedVectorDrawable.unregisterAnimationCallback(paramAnimationCallback.getPlatformCallback());
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      DrawableCompat.applyTheme(localDrawable, paramTheme);
    }
  }
  
  public boolean canApplyTheme()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.canApplyTheme(localDrawable);
    }
    return false;
  }
  
  public void clearAnimationCallbacks()
  {
    Object localObject = this.mDelegateDrawable;
    if (localObject != null)
    {
      ((AnimatedVectorDrawable)localObject).clearAnimationCallbacks();
      return;
    }
    removeAnimatorSetListener();
    localObject = this.mAnimationCallbacks;
    if (localObject == null) {
      return;
    }
    ((ArrayList)localObject).clear();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.draw(paramCanvas);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.draw(paramCanvas);
    if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
      invalidateSelf();
    }
  }
  
  public int getAlpha()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.getAlpha(localDrawable);
    }
    return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
  }
  
  public int getChangingConfigurations()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
  }
  
  public ColorFilter getColorFilter()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.getColorFilter(localDrawable);
    }
    return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((this.mDelegateDrawable != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    Object localObject1 = this.mDelegateDrawable;
    if (localObject1 != null)
    {
      DrawableCompat.inflate((Drawable)localObject1, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    while ((i != 1) && ((paramXmlPullParser.getDepth() >= j + 1) || (i != 3)))
    {
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        Object localObject2;
        Object localObject3;
        if ("animated-vector".equals(localObject1))
        {
          localObject2 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
          i = ((TypedArray)localObject2).getResourceId(0, 0);
          if (i != 0)
          {
            localObject1 = VectorDrawableCompat.create(paramResources, i, paramTheme);
            ((VectorDrawableCompat)localObject1).setAllowCaching(false);
            ((Drawable)localObject1).setCallback(this.mCallback);
            localObject3 = this.mAnimatedVectorState.mVectorDrawable;
            if (localObject3 != null) {
              ((Drawable)localObject3).setCallback(null);
            }
            this.mAnimatedVectorState.mVectorDrawable = ((VectorDrawableCompat)localObject1);
          }
          ((TypedArray)localObject2).recycle();
        }
        else if ("target".equals(localObject1))
        {
          localObject1 = paramResources.obtainAttributes(paramAttributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
          localObject3 = ((TypedArray)localObject1).getString(0);
          i = ((TypedArray)localObject1).getResourceId(1, 0);
          if (i != 0)
          {
            localObject2 = this.mContext;
            if (localObject2 != null)
            {
              setupAnimatorsForTarget((String)localObject3, AnimatorInflaterCompat.loadAnimator((Context)localObject2, i));
            }
            else
            {
              ((TypedArray)localObject1).recycle();
              throw new IllegalStateException("Context can't be null when inflating animators");
            }
          }
          ((TypedArray)localObject1).recycle();
        }
      }
      i = paramXmlPullParser.next();
    }
    this.mAnimatedVectorState.setupAnimatorSet();
  }
  
  public boolean isAutoMirrored()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.isAutoMirrored(localDrawable);
    }
    return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
  }
  
  public boolean isRunning()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return ((AnimatedVectorDrawable)localDrawable).isRunning();
    }
    return this.mAnimatedVectorState.mAnimatorSet.isRunning();
  }
  
  public boolean isStateful()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.isStateful();
    }
    return this.mAnimatedVectorState.mVectorDrawable.isStateful();
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      localDrawable.mutate();
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramRect);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setBounds(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return this.mAnimatedVectorState.mVectorDrawable.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return this.mAnimatedVectorState.mVectorDrawable.setState(paramArrayOfInt);
  }
  
  public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      registerPlatformCallback((AnimatedVectorDrawable)localDrawable, paramAnimationCallback);
      return;
    }
    if (paramAnimationCallback == null) {
      return;
    }
    if (this.mAnimationCallbacks == null) {
      this.mAnimationCallbacks = new ArrayList();
    }
    if (this.mAnimationCallbacks.contains(paramAnimationCallback)) {
      return;
    }
    this.mAnimationCallbacks.add(paramAnimationCallback);
    if (this.mAnimatorListener == null) {
      this.mAnimatorListener = new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramAnonymousAnimator = new ArrayList(AnimatedVectorDrawableCompat.this.mAnimationCallbacks);
          int i = paramAnonymousAnimator.size();
          for (int j = 0; j < i; j++) {
            ((Animatable2Compat.AnimationCallback)paramAnonymousAnimator.get(j)).onAnimationEnd(AnimatedVectorDrawableCompat.this);
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramAnonymousAnimator = new ArrayList(AnimatedVectorDrawableCompat.this.mAnimationCallbacks);
          int i = paramAnonymousAnimator.size();
          for (int j = 0; j < i; j++) {
            ((Animatable2Compat.AnimationCallback)paramAnonymousAnimator.get(j)).onAnimationStart(AnimatedVectorDrawableCompat.this);
          }
        }
      };
    }
    this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setAutoMirrored(localDrawable, paramBoolean);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setTint(int paramInt)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setTint(localDrawable, paramInt);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setTintList(localDrawable, paramColorStateList);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setTintMode(localDrawable, paramMode);
      return;
    }
    this.mAnimatedVectorState.mVectorDrawable.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    this.mAnimatedVectorState.mVectorDrawable.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).start();
      return;
    }
    if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
      return;
    }
    this.mAnimatedVectorState.mAnimatorSet.start();
    invalidateSelf();
  }
  
  public void stop()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).stop();
      return;
    }
    this.mAnimatedVectorState.mAnimatorSet.end();
  }
  
  public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    Object localObject = this.mDelegateDrawable;
    if (localObject != null) {
      unregisterPlatformCallback((AnimatedVectorDrawable)localObject, paramAnimationCallback);
    }
    localObject = this.mAnimationCallbacks;
    if ((localObject != null) && (paramAnimationCallback != null))
    {
      boolean bool = ((ArrayList)localObject).remove(paramAnimationCallback);
      if (this.mAnimationCallbacks.size() == 0) {
        removeAnimatorSetListener();
      }
      return bool;
    }
    return false;
  }
  
  private static class AnimatedVectorDrawableCompatState
    extends Drawable.ConstantState
  {
    AnimatorSet mAnimatorSet;
    ArrayList<Animator> mAnimators;
    int mChangingConfigurations;
    ArrayMap<Animator, String> mTargetNameMap;
    VectorDrawableCompat mVectorDrawable;
    
    public AnimatedVectorDrawableCompatState(Context paramContext, AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, Drawable.Callback paramCallback, Resources paramResources)
    {
      if (paramAnimatedVectorDrawableCompatState != null)
      {
        this.mChangingConfigurations = paramAnimatedVectorDrawableCompatState.mChangingConfigurations;
        paramContext = paramAnimatedVectorDrawableCompatState.mVectorDrawable;
        int i = 0;
        if (paramContext != null)
        {
          paramContext = paramContext.getConstantState();
          if (paramResources != null) {
            this.mVectorDrawable = ((VectorDrawableCompat)paramContext.newDrawable(paramResources));
          } else {
            this.mVectorDrawable = ((VectorDrawableCompat)paramContext.newDrawable());
          }
          paramContext = (VectorDrawableCompat)this.mVectorDrawable.mutate();
          this.mVectorDrawable = paramContext;
          paramContext.setCallback(paramCallback);
          this.mVectorDrawable.setBounds(paramAnimatedVectorDrawableCompatState.mVectorDrawable.getBounds());
          this.mVectorDrawable.setAllowCaching(false);
        }
        paramContext = paramAnimatedVectorDrawableCompatState.mAnimators;
        if (paramContext != null)
        {
          int j = paramContext.size();
          this.mAnimators = new ArrayList(j);
          this.mTargetNameMap = new ArrayMap(j);
          while (i < j)
          {
            paramCallback = (Animator)paramAnimatedVectorDrawableCompatState.mAnimators.get(i);
            paramContext = paramCallback.clone();
            paramCallback = (String)paramAnimatedVectorDrawableCompatState.mTargetNameMap.get(paramCallback);
            paramContext.setTarget(this.mVectorDrawable.getTargetByName(paramCallback));
            this.mAnimators.add(paramContext);
            this.mTargetNameMap.put(paramContext, paramCallback);
            i++;
          }
          setupAnimatorSet();
        }
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public void setupAnimatorSet()
    {
      if (this.mAnimatorSet == null) {
        this.mAnimatorSet = new AnimatorSet();
      }
      this.mAnimatorSet.playTogether(this.mAnimators);
    }
  }
  
  @RequiresApi(24)
  private static class AnimatedVectorDrawableDelegateState
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState mDelegateState;
    
    public AnimatedVectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
    {
      this.mDelegateState = paramConstantState;
    }
    
    public boolean canApplyTheme()
    {
      return this.mDelegateState.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return this.mDelegateState.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
      Drawable localDrawable = this.mDelegateState.newDrawable();
      localAnimatedVectorDrawableCompat.mDelegateDrawable = localDrawable;
      localDrawable.setCallback(localAnimatedVectorDrawableCompat.mCallback);
      return localAnimatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
      paramResources = this.mDelegateState.newDrawable(paramResources);
      localAnimatedVectorDrawableCompat.mDelegateDrawable = paramResources;
      paramResources.setCallback(localAnimatedVectorDrawableCompat.mCallback);
      return localAnimatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
      paramResources = this.mDelegateState.newDrawable(paramResources, paramTheme);
      localAnimatedVectorDrawableCompat.mDelegateDrawable = paramResources;
      paramResources.setCallback(localAnimatedVectorDrawableCompat.mCallback);
      return localAnimatedVectorDrawableCompat;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\vectordrawable\graphics\drawable\AnimatedVectorDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */