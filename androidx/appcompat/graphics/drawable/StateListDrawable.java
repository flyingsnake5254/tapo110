package androidx.appcompat.graphics.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R.styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class StateListDrawable
  extends DrawableContainer
{
  private static final boolean DEBUG = false;
  private static final String TAG = "StateListDrawable";
  private boolean mMutated;
  private StateListState mStateListState;
  
  StateListDrawable()
  {
    this(null, null);
  }
  
  StateListDrawable(@Nullable StateListState paramStateListState)
  {
    if (paramStateListState != null) {
      setConstantState(paramStateListState);
    }
  }
  
  StateListDrawable(StateListState paramStateListState, Resources paramResources)
  {
    setConstantState(new StateListState(paramStateListState, this, paramResources));
    onStateChange(getState());
  }
  
  private void inflateChildElements(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    StateListState localStateListState = this.mStateListState;
    int i = paramXmlPullParser.getDepth() + 1;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        Object localObject = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawableItem);
        Drawable localDrawable = null;
        j = ((TypedArray)localObject).getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
        if (j > 0) {
          localDrawable = ResourceManagerInternal.get().getDrawable(paramContext, j);
        }
        ((TypedArray)localObject).recycle();
        int[] arrayOfInt = extractStateSet(paramAttributeSet);
        localObject = localDrawable;
        if (localDrawable == null)
        {
          do
          {
            j = paramXmlPullParser.next();
          } while (j == 4);
          if (j == 2)
          {
            if (Build.VERSION.SDK_INT >= 21) {
              localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            } else {
              localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
            }
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            throw new XmlPullParserException(paramContext.toString());
          }
        }
        localStateListState.addStateSet(arrayOfInt, (Drawable)localObject);
      }
    }
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray)
  {
    StateListState localStateListState = this.mStateListState;
    if (Build.VERSION.SDK_INT >= 21) {
      localStateListState.mChangingConfigurations |= paramTypedArray.getChangingConfigurations();
    }
    localStateListState.mVariablePadding = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, localStateListState.mVariablePadding);
    localStateListState.mConstantSize = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, localStateListState.mConstantSize);
    localStateListState.mEnterFadeDuration = paramTypedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, localStateListState.mEnterFadeDuration);
    localStateListState.mExitFadeDuration = paramTypedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, localStateListState.mExitFadeDuration);
    localStateListState.mDither = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_dither, localStateListState.mDither);
  }
  
  public void addState(int[] paramArrayOfInt, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.mStateListState.addStateSet(paramArrayOfInt, paramDrawable);
      onStateChange(getState());
    }
  }
  
  @RequiresApi(21)
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    super.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  void clearMutated()
  {
    super.clearMutated();
    this.mMutated = false;
  }
  
  StateListState cloneConstantState()
  {
    return new StateListState(this.mStateListState, this, null);
  }
  
  int[] extractStateSet(AttributeSet paramAttributeSet)
  {
    int i = paramAttributeSet.getAttributeCount();
    int[] arrayOfInt = new int[i];
    int j = 0;
    int n;
    for (int k = 0; j < i; k = n)
    {
      int m = paramAttributeSet.getAttributeNameResource(j);
      n = k;
      if (m != 0)
      {
        n = k;
        if (m != 16842960)
        {
          n = k;
          if (m != 16843161)
          {
            if (paramAttributeSet.getAttributeBooleanValue(j, false)) {
              n = m;
            } else {
              n = -m;
            }
            arrayOfInt[k] = n;
            n = k + 1;
          }
        }
      }
      j++;
    }
    return StateSet.trimStateSet(arrayOfInt, k);
  }
  
  int getStateCount()
  {
    return this.mStateListState.getChildCount();
  }
  
  Drawable getStateDrawable(int paramInt)
  {
    return this.mStateListState.getChild(paramInt);
  }
  
  int getStateDrawableIndex(int[] paramArrayOfInt)
  {
    return this.mStateListState.indexOfStateSet(paramArrayOfInt);
  }
  
  StateListState getStateListState()
  {
    return this.mStateListState;
  }
  
  int[] getStateSet(int paramInt)
  {
    return this.mStateListState.mStateSets[paramInt];
  }
  
  public void inflate(@NonNull Context paramContext, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawable);
    setVisible(localTypedArray.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
    updateStateFromTypedArray(localTypedArray);
    updateDensity(paramResources);
    localTypedArray.recycle();
    inflateChildElements(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    onStateChange(getState());
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  @NonNull
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mStateListState.mutate();
      this.mMutated = true;
    }
    return this;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int i = this.mStateListState.indexOfStateSet(paramArrayOfInt);
    int j = i;
    if (i < 0) {
      j = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    }
    if ((!selectDrawable(j)) && (!bool)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  void setConstantState(@NonNull DrawableContainer.DrawableContainerState paramDrawableContainerState)
  {
    super.setConstantState(paramDrawableContainerState);
    if ((paramDrawableContainerState instanceof StateListState)) {
      this.mStateListState = ((StateListState)paramDrawableContainerState);
    }
  }
  
  static class StateListState
    extends DrawableContainer.DrawableContainerState
  {
    int[][] mStateSets;
    
    StateListState(StateListState paramStateListState, StateListDrawable paramStateListDrawable, Resources paramResources)
    {
      super(paramStateListDrawable, paramResources);
      if (paramStateListState != null) {
        this.mStateSets = paramStateListState.mStateSets;
      } else {
        this.mStateSets = new int[getCapacity()][];
      }
    }
    
    int addStateSet(int[] paramArrayOfInt, Drawable paramDrawable)
    {
      int i = addChild(paramDrawable);
      this.mStateSets[i] = paramArrayOfInt;
      return i;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      super.growArray(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(this.mStateSets, 0, arrayOfInt, 0, paramInt1);
      this.mStateSets = arrayOfInt;
    }
    
    int indexOfStateSet(int[] paramArrayOfInt)
    {
      int[][] arrayOfInt = this.mStateSets;
      int i = getChildCount();
      for (int j = 0; j < i; j++) {
        if (StateSet.stateSetMatches(arrayOfInt[j], paramArrayOfInt)) {
          return j;
        }
      }
      return -1;
    }
    
    void mutate()
    {
      Object localObject = this.mStateSets;
      int[][] arrayOfInt = new int[localObject.length][];
      for (int i = localObject.length - 1; i >= 0; i--)
      {
        localObject = this.mStateSets;
        if (localObject[i] != null) {
          localObject = (int[])localObject[i].clone();
        } else {
          localObject = null;
        }
        arrayOfInt[i] = localObject;
      }
      this.mStateSets = arrayOfInt;
    }
    
    @NonNull
    public Drawable newDrawable()
    {
      return new StateListDrawable(this, null);
    }
    
    @NonNull
    public Drawable newDrawable(Resources paramResources)
    {
      return new StateListDrawable(this, paramResources);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\graphics\drawable\StateListDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */