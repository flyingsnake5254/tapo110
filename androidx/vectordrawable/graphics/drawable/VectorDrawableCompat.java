package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser.PathDataNode;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat
  extends VectorDrawableCommon
{
  private static final boolean DBG_VECTOR_DRAWABLE = false;
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  private static final int LINECAP_BUTT = 0;
  private static final int LINECAP_ROUND = 1;
  private static final int LINECAP_SQUARE = 2;
  private static final int LINEJOIN_BEVEL = 2;
  private static final int LINEJOIN_MITER = 0;
  private static final int LINEJOIN_ROUND = 1;
  static final String LOGTAG = "VectorDrawableCompat";
  private static final int MAX_CACHED_BITMAP_SIZE = 2048;
  private static final String SHAPE_CLIP_PATH = "clip-path";
  private static final String SHAPE_GROUP = "group";
  private static final String SHAPE_PATH = "path";
  private static final String SHAPE_VECTOR = "vector";
  private boolean mAllowCaching = true;
  private Drawable.ConstantState mCachedConstantStateDelegate;
  private ColorFilter mColorFilter;
  private boolean mMutated;
  private PorterDuffColorFilter mTintFilter;
  private final Rect mTmpBounds = new Rect();
  private final float[] mTmpFloats = new float[9];
  private final Matrix mTmpMatrix = new Matrix();
  private VectorDrawableCompatState mVectorState;
  
  VectorDrawableCompat()
  {
    this.mVectorState = new VectorDrawableCompatState();
  }
  
  VectorDrawableCompat(@NonNull VectorDrawableCompatState paramVectorDrawableCompatState)
  {
    this.mVectorState = paramVectorDrawableCompatState;
    this.mTintFilter = updateTintFilter(this.mTintFilter, paramVectorDrawableCompatState.mTint, paramVectorDrawableCompatState.mTintMode);
  }
  
  static int applyAlpha(int paramInt, float paramFloat)
  {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  @Nullable
  public static VectorDrawableCompat create(@NonNull Resources paramResources, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new VectorDrawableCompat();
      ((VectorDrawableCommon)localObject).mDelegateDrawable = ResourcesCompat.getDrawable(paramResources, paramInt, paramTheme);
      ((VectorDrawableCompat)localObject).mCachedConstantStateDelegate = new VectorDrawableDelegateState(((VectorDrawableCommon)localObject).mDelegateDrawable.getConstantState());
      return (VectorDrawableCompat)localObject;
    }
    try
    {
      XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
      localObject = Xml.asAttributeSet(localXmlResourceParser);
      do
      {
        paramInt = localXmlResourceParser.next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return createFromXmlInner(paramResources, localXmlResourceParser, (AttributeSet)localObject, paramTheme);
      }
      paramResources = new org/xmlpull/v1/XmlPullParserException;
      paramResources.<init>("No start tag found");
      throw paramResources;
    }
    catch (IOException paramResources)
    {
      Log.e("VectorDrawableCompat", "parser error", paramResources);
    }
    catch (XmlPullParserException paramResources)
    {
      Log.e("VectorDrawableCompat", "parser error", paramResources);
    }
    return null;
  }
  
  public static VectorDrawableCompat createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
    localVectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localVectorDrawableCompat;
  }
  
  private void inflateInternal(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    VPathRenderer localVPathRenderer = localVectorDrawableCompatState.mVPathRenderer;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localVPathRenderer.mRootGroup);
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    int m;
    for (int k = 1; (i != 1) && ((paramXmlPullParser.getDepth() >= j + 1) || (i != 3)); k = m)
    {
      if (i == 2)
      {
        Object localObject = paramXmlPullParser.getName();
        VGroup localVGroup = (VGroup)localArrayDeque.peek();
        if ("path".equals(localObject))
        {
          localObject = new VFullPath();
          ((VFullPath)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localVGroup.mChildren.add(localObject);
          if (((VPath)localObject).getPathName() != null) {
            localVPathRenderer.mVGTargetsMap.put(((VPath)localObject).getPathName(), localObject);
          }
          m = 0;
          k = localVectorDrawableCompatState.mChangingConfigurations;
          localVectorDrawableCompatState.mChangingConfigurations = (((VPath)localObject).mChangingConfigurations | k);
        }
        else if ("clip-path".equals(localObject))
        {
          localObject = new VClipPath();
          ((VClipPath)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          localVGroup.mChildren.add(localObject);
          if (((VPath)localObject).getPathName() != null) {
            localVPathRenderer.mVGTargetsMap.put(((VPath)localObject).getPathName(), localObject);
          }
          m = localVectorDrawableCompatState.mChangingConfigurations;
          localVectorDrawableCompatState.mChangingConfigurations = (((VPath)localObject).mChangingConfigurations | m);
          m = k;
        }
        else
        {
          m = k;
          if ("group".equals(localObject))
          {
            localObject = new VGroup();
            ((VGroup)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
            localVGroup.mChildren.add(localObject);
            localArrayDeque.push(localObject);
            if (((VGroup)localObject).getGroupName() != null) {
              localVPathRenderer.mVGTargetsMap.put(((VGroup)localObject).getGroupName(), localObject);
            }
            m = localVectorDrawableCompatState.mChangingConfigurations;
            localVectorDrawableCompatState.mChangingConfigurations = (((VGroup)localObject).mChangingConfigurations | m);
            m = k;
          }
        }
      }
      else
      {
        m = k;
        if (i == 3)
        {
          m = k;
          if ("group".equals(paramXmlPullParser.getName()))
          {
            localArrayDeque.pop();
            m = k;
          }
        }
      }
      i = paramXmlPullParser.next();
    }
    if (k == 0) {
      return;
    }
    throw new XmlPullParserException("no path defined");
  }
  
  private boolean needMirroring()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (i >= 17)
    {
      bool2 = bool1;
      if (isAutoMirrored())
      {
        bool2 = bool1;
        if (DrawableCompat.getLayoutDirection(this) == 1) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private static PorterDuff.Mode parseTintModeCompat(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  private void printGroupTree(VGroup paramVGroup, int paramInt)
  {
    int i = 0;
    Object localObject = "";
    for (int j = 0; j < paramInt; j++)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("    ");
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("current group is :");
    localStringBuilder.append(paramVGroup.getGroupName());
    localStringBuilder.append(" rotation is ");
    localStringBuilder.append(paramVGroup.mRotate);
    Log.v("VectorDrawableCompat", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("matrix is :");
    localStringBuilder.append(paramVGroup.getLocalMatrix().toString());
    Log.v("VectorDrawableCompat", localStringBuilder.toString());
    for (j = i; j < paramVGroup.mChildren.size(); j++)
    {
      localObject = (VObject)paramVGroup.mChildren.get(j);
      if ((localObject instanceof VGroup)) {
        printGroupTree((VGroup)localObject, paramInt + 1);
      } else {
        ((VPath)localObject).printVPath(paramInt + 1);
      }
    }
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    throws XmlPullParserException
  {
    VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    VPathRenderer localVPathRenderer = localVectorDrawableCompatState.mVPathRenderer;
    localVectorDrawableCompatState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    paramTheme = TypedArrayUtils.getNamedColorStateList(paramTypedArray, paramXmlPullParser, paramTheme, "tint", 1);
    if (paramTheme != null) {
      localVectorDrawableCompatState.mTint = paramTheme;
    }
    localVectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, localVectorDrawableCompatState.mAutoMirrored);
    localVPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, localVPathRenderer.mViewportWidth);
    float f = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, localVPathRenderer.mViewportHeight);
    localVPathRenderer.mViewportHeight = f;
    if (localVPathRenderer.mViewportWidth > 0.0F)
    {
      if (f > 0.0F)
      {
        localVPathRenderer.mBaseWidth = paramTypedArray.getDimension(3, localVPathRenderer.mBaseWidth);
        f = paramTypedArray.getDimension(2, localVPathRenderer.mBaseHeight);
        localVPathRenderer.mBaseHeight = f;
        if (localVPathRenderer.mBaseWidth > 0.0F)
        {
          if (f > 0.0F)
          {
            localVPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "alpha", 4, localVPathRenderer.getAlpha()));
            paramTypedArray = paramTypedArray.getString(0);
            if (paramTypedArray != null)
            {
              localVPathRenderer.mRootName = paramTypedArray;
              localVPathRenderer.mVGTargetsMap.put(paramTypedArray, localVPathRenderer);
            }
            return;
          }
          paramXmlPullParser = new StringBuilder();
          paramXmlPullParser.append(paramTypedArray.getPositionDescription());
          paramXmlPullParser.append("<vector> tag requires height > 0");
          throw new XmlPullParserException(paramXmlPullParser.toString());
        }
        paramXmlPullParser = new StringBuilder();
        paramXmlPullParser.append(paramTypedArray.getPositionDescription());
        paramXmlPullParser.append("<vector> tag requires width > 0");
        throw new XmlPullParserException(paramXmlPullParser.toString());
      }
      paramXmlPullParser = new StringBuilder();
      paramXmlPullParser.append(paramTypedArray.getPositionDescription());
      paramXmlPullParser.append("<vector> tag requires viewportHeight > 0");
      throw new XmlPullParserException(paramXmlPullParser.toString());
    }
    paramXmlPullParser = new StringBuilder();
    paramXmlPullParser.append(paramTypedArray.getPositionDescription());
    paramXmlPullParser.append("<vector> tag requires viewportWidth > 0");
    throw new XmlPullParserException(paramXmlPullParser.toString());
  }
  
  public boolean canApplyTheme()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      DrawableCompat.canApplyTheme(localDrawable);
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject1 = this.mDelegateDrawable;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).draw(paramCanvas);
      return;
    }
    copyBounds(this.mTmpBounds);
    if ((this.mTmpBounds.width() > 0) && (this.mTmpBounds.height() > 0))
    {
      Object localObject2 = this.mColorFilter;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.mTintFilter;
      }
      paramCanvas.getMatrix(this.mTmpMatrix);
      this.mTmpMatrix.getValues(this.mTmpFloats);
      float f1 = Math.abs(this.mTmpFloats[0]);
      float f2 = Math.abs(this.mTmpFloats[4]);
      float f3 = Math.abs(this.mTmpFloats[1]);
      float f4 = Math.abs(this.mTmpFloats[3]);
      if ((f3 != 0.0F) || (f4 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      int i = (int)(this.mTmpBounds.width() * f1);
      int j = (int)(this.mTmpBounds.height() * f2);
      i = Math.min(2048, i);
      j = Math.min(2048, j);
      if ((i > 0) && (j > 0))
      {
        int k = paramCanvas.save();
        localObject2 = this.mTmpBounds;
        paramCanvas.translate(((Rect)localObject2).left, ((Rect)localObject2).top);
        if (needMirroring())
        {
          paramCanvas.translate(this.mTmpBounds.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.mTmpBounds.offsetTo(0, 0);
        this.mVectorState.createCachedBitmapIfNeeded(i, j);
        if (!this.mAllowCaching)
        {
          this.mVectorState.updateCachedBitmap(i, j);
        }
        else if (!this.mVectorState.canReuseCache())
        {
          this.mVectorState.updateCachedBitmap(i, j);
          this.mVectorState.updateCacheStates();
        }
        this.mVectorState.drawCachedBitmapWithRootAlpha(paramCanvas, (ColorFilter)localObject1, this.mTmpBounds);
        paramCanvas.restoreToCount(k);
      }
    }
  }
  
  public int getAlpha()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.getAlpha(localDrawable);
    }
    return this.mVectorState.mVPathRenderer.getRootAlpha();
  }
  
  public int getChangingConfigurations()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
  }
  
  public ColorFilter getColorFilter()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.getColorFilter(localDrawable);
    }
    return this.mColorFilter;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((this.mDelegateDrawable != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }
    this.mVectorState.mChangingConfigurations = getChangingConfigurations();
    return this.mVectorState;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return (int)this.mVectorState.mVPathRenderer.mBaseHeight;
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return (int)this.mVectorState.mVPathRenderer.mBaseWidth;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return -3;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public float getPixelSize()
  {
    Object localObject = this.mVectorState;
    if (localObject != null)
    {
      localObject = ((VectorDrawableCompatState)localObject).mVPathRenderer;
      if (localObject != null)
      {
        float f1 = ((VPathRenderer)localObject).mBaseWidth;
        if (f1 != 0.0F)
        {
          float f2 = ((VPathRenderer)localObject).mBaseHeight;
          if (f2 != 0.0F)
          {
            float f3 = ((VPathRenderer)localObject).mViewportHeight;
            if (f3 != 0.0F)
            {
              float f4 = ((VPathRenderer)localObject).mViewportWidth;
              if (f4 != 0.0F) {
                return Math.min(f4 / f1, f3 / f2);
              }
            }
          }
        }
      }
    }
    return 1.0F;
  }
  
  Object getTargetByName(String paramString)
  {
    return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(paramString);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    Object localObject = this.mDelegateDrawable;
    if (localObject != null)
    {
      DrawableCompat.inflate((Drawable)localObject, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    VectorDrawableCompatState localVectorDrawableCompatState = this.mVectorState;
    localVectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
    localObject = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
    updateStateFromTypedArray((TypedArray)localObject, paramXmlPullParser, paramTheme);
    ((TypedArray)localObject).recycle();
    localVectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
    localVectorDrawableCompatState.mCacheDirty = true;
    inflateInternal(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.mTintFilter = updateTintFilter(this.mTintFilter, localVectorDrawableCompatState.mTint, localVectorDrawableCompatState.mTintMode);
  }
  
  public void invalidateSelf()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.isAutoMirrored(localDrawable);
    }
    return this.mVectorState.mAutoMirrored;
  }
  
  public boolean isStateful()
  {
    Object localObject = this.mDelegateDrawable;
    if (localObject != null) {
      return ((Drawable)localObject).isStateful();
    }
    if (!super.isStateful())
    {
      localObject = this.mVectorState;
      if (localObject != null)
      {
        if (!((VectorDrawableCompatState)localObject).isStateful())
        {
          localObject = this.mVectorState.mTint;
          if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {}
        }
      }
      else {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.mutate();
      return this;
    }
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
      this.mMutated = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Object localObject = this.mDelegateDrawable;
    if (localObject != null) {
      return ((Drawable)localObject).setState(paramArrayOfInt);
    }
    boolean bool1 = false;
    localObject = this.mVectorState;
    ColorStateList localColorStateList = ((VectorDrawableCompatState)localObject).mTint;
    boolean bool2 = true;
    boolean bool3 = bool1;
    if (localColorStateList != null)
    {
      PorterDuff.Mode localMode = ((VectorDrawableCompatState)localObject).mTintMode;
      bool3 = bool1;
      if (localMode != null)
      {
        this.mTintFilter = updateTintFilter(this.mTintFilter, localColorStateList, localMode);
        invalidateSelf();
        bool3 = true;
      }
    }
    if ((((VectorDrawableCompatState)localObject).isStateful()) && (((VectorDrawableCompatState)localObject).onStateChanged(paramArrayOfInt)))
    {
      invalidateSelf();
      bool3 = bool2;
    }
    return bool3;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  void setAllowCaching(boolean paramBoolean)
  {
    this.mAllowCaching = paramBoolean;
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    if (this.mVectorState.mVPathRenderer.getRootAlpha() != paramInt)
    {
      this.mVectorState.mVPathRenderer.setRootAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setAutoMirrored(localDrawable, paramBoolean);
      return;
    }
    this.mVectorState.mAutoMirrored = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.mColorFilter = paramColorFilter;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setTint(localDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Object localObject = this.mDelegateDrawable;
    if (localObject != null)
    {
      DrawableCompat.setTintList((Drawable)localObject, paramColorStateList);
      return;
    }
    localObject = this.mVectorState;
    if (((VectorDrawableCompatState)localObject).mTint != paramColorStateList)
    {
      ((VectorDrawableCompatState)localObject).mTint = paramColorStateList;
      this.mTintFilter = updateTintFilter(this.mTintFilter, paramColorStateList, ((VectorDrawableCompatState)localObject).mTintMode);
      invalidateSelf();
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    Object localObject = this.mDelegateDrawable;
    if (localObject != null)
    {
      DrawableCompat.setTintMode((Drawable)localObject, paramMode);
      return;
    }
    localObject = this.mVectorState;
    if (((VectorDrawableCompatState)localObject).mTintMode != paramMode)
    {
      ((VectorDrawableCompatState)localObject).mTintMode = paramMode;
      this.mTintFilter = updateTintFilter(this.mTintFilter, ((VectorDrawableCompatState)localObject).mTint, paramMode);
      invalidateSelf();
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    Drawable localDrawable = this.mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  private static class VClipPath
    extends VectorDrawableCompat.VPath
  {
    VClipPath() {}
    
    VClipPath(VClipPath paramVClipPath)
    {
      super();
    }
    
    private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.mPathName = str;
      }
      str = paramTypedArray.getString(1);
      if (str != null) {
        this.mNodes = PathParser.createNodesFromPathData(str);
      }
      this.mFillRule = TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "fillType", 2, 0);
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
        return;
      }
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
      updateStateFromTypedArray(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
    
    public boolean isClipPath()
    {
      return true;
    }
  }
  
  private static class VFullPath
    extends VectorDrawableCompat.VPath
  {
    float mFillAlpha = 1.0F;
    ComplexColorCompat mFillColor;
    float mStrokeAlpha = 1.0F;
    ComplexColorCompat mStrokeColor;
    Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
    Paint.Join mStrokeLineJoin = Paint.Join.MITER;
    float mStrokeMiterlimit = 4.0F;
    float mStrokeWidth = 0.0F;
    private int[] mThemeAttrs;
    float mTrimPathEnd = 1.0F;
    float mTrimPathOffset = 0.0F;
    float mTrimPathStart = 0.0F;
    
    VFullPath() {}
    
    VFullPath(VFullPath paramVFullPath)
    {
      super();
      this.mThemeAttrs = paramVFullPath.mThemeAttrs;
      this.mStrokeColor = paramVFullPath.mStrokeColor;
      this.mStrokeWidth = paramVFullPath.mStrokeWidth;
      this.mStrokeAlpha = paramVFullPath.mStrokeAlpha;
      this.mFillColor = paramVFullPath.mFillColor;
      this.mFillRule = paramVFullPath.mFillRule;
      this.mFillAlpha = paramVFullPath.mFillAlpha;
      this.mTrimPathStart = paramVFullPath.mTrimPathStart;
      this.mTrimPathEnd = paramVFullPath.mTrimPathEnd;
      this.mTrimPathOffset = paramVFullPath.mTrimPathOffset;
      this.mStrokeLineCap = paramVFullPath.mStrokeLineCap;
      this.mStrokeLineJoin = paramVFullPath.mStrokeLineJoin;
      this.mStrokeMiterlimit = paramVFullPath.mStrokeMiterlimit;
    }
    
    private Paint.Cap getStrokeLineCap(int paramInt, Paint.Cap paramCap)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return paramCap;
          }
          return Paint.Cap.SQUARE;
        }
        return Paint.Cap.ROUND;
      }
      return Paint.Cap.BUTT;
    }
    
    private Paint.Join getStrokeLineJoin(int paramInt, Paint.Join paramJoin)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return paramJoin;
          }
          return Paint.Join.BEVEL;
        }
        return Paint.Join.ROUND;
      }
      return Paint.Join.MITER;
    }
    
    private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      this.mThemeAttrs = null;
      if (!TypedArrayUtils.hasAttribute(paramXmlPullParser, "pathData")) {
        return;
      }
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.mPathName = str;
      }
      str = paramTypedArray.getString(2);
      if (str != null) {
        this.mNodes = PathParser.createNodesFromPathData(str);
      }
      this.mFillColor = TypedArrayUtils.getNamedComplexColor(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1, 0);
      this.mFillAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.mFillAlpha);
      this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
      this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
      this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
      this.mStrokeColor = TypedArrayUtils.getNamedComplexColor(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3, 0);
      this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
      this.mStrokeWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
      this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
      this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
      this.mTrimPathStart = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
      this.mFillRule = TypedArrayUtils.getNamedInt(paramTypedArray, paramXmlPullParser, "fillType", 13, this.mFillRule);
    }
    
    public void applyTheme(Resources.Theme paramTheme)
    {
      if (this.mThemeAttrs == null) {}
    }
    
    public boolean canApplyTheme()
    {
      boolean bool;
      if (this.mThemeAttrs != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    float getFillAlpha()
    {
      return this.mFillAlpha;
    }
    
    @ColorInt
    int getFillColor()
    {
      return this.mFillColor.getColor();
    }
    
    float getStrokeAlpha()
    {
      return this.mStrokeAlpha;
    }
    
    @ColorInt
    int getStrokeColor()
    {
      return this.mStrokeColor.getColor();
    }
    
    float getStrokeWidth()
    {
      return this.mStrokeWidth;
    }
    
    float getTrimPathEnd()
    {
      return this.mTrimPathEnd;
    }
    
    float getTrimPathOffset()
    {
      return this.mTrimPathOffset;
    }
    
    float getTrimPathStart()
    {
      return this.mTrimPathStart;
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
      updateStateFromTypedArray(paramResources, paramXmlPullParser, paramTheme);
      paramResources.recycle();
    }
    
    public boolean isStateful()
    {
      boolean bool;
      if ((!this.mFillColor.isStateful()) && (!this.mStrokeColor.isStateful())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean onStateChanged(int[] paramArrayOfInt)
    {
      boolean bool = this.mFillColor.onStateChanged(paramArrayOfInt);
      return this.mStrokeColor.onStateChanged(paramArrayOfInt) | bool;
    }
    
    void setFillAlpha(float paramFloat)
    {
      this.mFillAlpha = paramFloat;
    }
    
    void setFillColor(int paramInt)
    {
      this.mFillColor.setColor(paramInt);
    }
    
    void setStrokeAlpha(float paramFloat)
    {
      this.mStrokeAlpha = paramFloat;
    }
    
    void setStrokeColor(int paramInt)
    {
      this.mStrokeColor.setColor(paramInt);
    }
    
    void setStrokeWidth(float paramFloat)
    {
      this.mStrokeWidth = paramFloat;
    }
    
    void setTrimPathEnd(float paramFloat)
    {
      this.mTrimPathEnd = paramFloat;
    }
    
    void setTrimPathOffset(float paramFloat)
    {
      this.mTrimPathOffset = paramFloat;
    }
    
    void setTrimPathStart(float paramFloat)
    {
      this.mTrimPathStart = paramFloat;
    }
  }
  
  private static class VGroup
    extends VectorDrawableCompat.VObject
  {
    int mChangingConfigurations;
    final ArrayList<VectorDrawableCompat.VObject> mChildren = new ArrayList();
    private String mGroupName;
    final Matrix mLocalMatrix;
    private float mPivotX = 0.0F;
    private float mPivotY = 0.0F;
    float mRotate = 0.0F;
    private float mScaleX = 1.0F;
    private float mScaleY = 1.0F;
    final Matrix mStackedMatrix = new Matrix();
    private int[] mThemeAttrs;
    private float mTranslateX = 0.0F;
    private float mTranslateY = 0.0F;
    
    public VGroup()
    {
      super();
      this.mLocalMatrix = new Matrix();
      this.mGroupName = null;
    }
    
    public VGroup(VGroup paramVGroup, ArrayMap<String, Object> paramArrayMap)
    {
      super();
      Object localObject1 = new Matrix();
      this.mLocalMatrix = ((Matrix)localObject1);
      this.mGroupName = null;
      this.mRotate = paramVGroup.mRotate;
      this.mPivotX = paramVGroup.mPivotX;
      this.mPivotY = paramVGroup.mPivotY;
      this.mScaleX = paramVGroup.mScaleX;
      this.mScaleY = paramVGroup.mScaleY;
      this.mTranslateX = paramVGroup.mTranslateX;
      this.mTranslateY = paramVGroup.mTranslateY;
      this.mThemeAttrs = paramVGroup.mThemeAttrs;
      Object localObject2 = paramVGroup.mGroupName;
      this.mGroupName = ((String)localObject2);
      this.mChangingConfigurations = paramVGroup.mChangingConfigurations;
      if (localObject2 != null) {
        paramArrayMap.put(localObject2, this);
      }
      ((Matrix)localObject1).set(paramVGroup.mLocalMatrix);
      localObject2 = paramVGroup.mChildren;
      int i = 0;
      while (i < ((ArrayList)localObject2).size())
      {
        paramVGroup = ((ArrayList)localObject2).get(i);
        if ((paramVGroup instanceof VGroup))
        {
          paramVGroup = (VGroup)paramVGroup;
          this.mChildren.add(new VGroup(paramVGroup, paramArrayMap));
        }
        else
        {
          if ((paramVGroup instanceof VectorDrawableCompat.VFullPath))
          {
            paramVGroup = new VectorDrawableCompat.VFullPath((VectorDrawableCompat.VFullPath)paramVGroup);
          }
          else
          {
            if (!(paramVGroup instanceof VectorDrawableCompat.VClipPath)) {
              break label316;
            }
            paramVGroup = new VectorDrawableCompat.VClipPath((VectorDrawableCompat.VClipPath)paramVGroup);
          }
          this.mChildren.add(paramVGroup);
          localObject1 = paramVGroup.mPathName;
          if (localObject1 != null) {
            paramArrayMap.put(localObject1, paramVGroup);
          }
        }
        i++;
        continue;
        label316:
        throw new IllegalStateException("Unknown object in the tree!");
      }
    }
    
    private void updateLocalMatrix()
    {
      this.mLocalMatrix.reset();
      this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
      this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
      this.mLocalMatrix.postRotate(this.mRotate, 0.0F, 0.0F);
      this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
    }
    
    private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.mThemeAttrs = null;
      this.mRotate = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "rotation", 5, this.mRotate);
      this.mPivotX = paramTypedArray.getFloat(1, this.mPivotX);
      this.mPivotY = paramTypedArray.getFloat(2, this.mPivotY);
      this.mScaleX = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleX", 3, this.mScaleX);
      this.mScaleY = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleY", 4, this.mScaleY);
      this.mTranslateX = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateX", 6, this.mTranslateX);
      this.mTranslateY = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateY", 7, this.mTranslateY);
      paramTypedArray = paramTypedArray.getString(0);
      if (paramTypedArray != null) {
        this.mGroupName = paramTypedArray;
      }
      updateLocalMatrix();
    }
    
    public String getGroupName()
    {
      return this.mGroupName;
    }
    
    public Matrix getLocalMatrix()
    {
      return this.mLocalMatrix;
    }
    
    public float getPivotX()
    {
      return this.mPivotX;
    }
    
    public float getPivotY()
    {
      return this.mPivotY;
    }
    
    public float getRotation()
    {
      return this.mRotate;
    }
    
    public float getScaleX()
    {
      return this.mScaleX;
    }
    
    public float getScaleY()
    {
      return this.mScaleY;
    }
    
    public float getTranslateX()
    {
      return this.mTranslateX;
    }
    
    public float getTranslateY()
    {
      return this.mTranslateY;
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
      updateStateFromTypedArray(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
    
    public boolean isStateful()
    {
      for (int i = 0; i < this.mChildren.size(); i++) {
        if (((VectorDrawableCompat.VObject)this.mChildren.get(i)).isStateful()) {
          return true;
        }
      }
      return false;
    }
    
    public boolean onStateChanged(int[] paramArrayOfInt)
    {
      int i = 0;
      boolean bool = false;
      while (i < this.mChildren.size())
      {
        bool |= ((VectorDrawableCompat.VObject)this.mChildren.get(i)).onStateChanged(paramArrayOfInt);
        i++;
      }
      return bool;
    }
    
    public void setPivotX(float paramFloat)
    {
      if (paramFloat != this.mPivotX)
      {
        this.mPivotX = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setPivotY(float paramFloat)
    {
      if (paramFloat != this.mPivotY)
      {
        this.mPivotY = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setRotation(float paramFloat)
    {
      if (paramFloat != this.mRotate)
      {
        this.mRotate = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setScaleX(float paramFloat)
    {
      if (paramFloat != this.mScaleX)
      {
        this.mScaleX = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setScaleY(float paramFloat)
    {
      if (paramFloat != this.mScaleY)
      {
        this.mScaleY = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.mTranslateX)
      {
        this.mTranslateX = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.mTranslateY)
      {
        this.mTranslateY = paramFloat;
        updateLocalMatrix();
      }
    }
  }
  
  private static abstract class VObject
  {
    public boolean isStateful()
    {
      return false;
    }
    
    public boolean onStateChanged(int[] paramArrayOfInt)
    {
      return false;
    }
  }
  
  private static abstract class VPath
    extends VectorDrawableCompat.VObject
  {
    protected static final int FILL_TYPE_WINDING = 0;
    int mChangingConfigurations;
    int mFillRule = 0;
    protected PathParser.PathDataNode[] mNodes = null;
    String mPathName;
    
    public VPath()
    {
      super();
    }
    
    public VPath(VPath paramVPath)
    {
      super();
      this.mPathName = paramVPath.mPathName;
      this.mChangingConfigurations = paramVPath.mChangingConfigurations;
      this.mNodes = PathParser.deepCopyNodes(paramVPath.mNodes);
    }
    
    public void applyTheme(Resources.Theme paramTheme) {}
    
    public boolean canApplyTheme()
    {
      return false;
    }
    
    public PathParser.PathDataNode[] getPathData()
    {
      return this.mNodes;
    }
    
    public String getPathName()
    {
      return this.mPathName;
    }
    
    public boolean isClipPath()
    {
      return false;
    }
    
    public String nodesToString(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      String str = " ";
      for (int i = 0; i < paramArrayOfPathDataNode.length; i++)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramArrayOfPathDataNode[i].mType);
        ((StringBuilder)localObject).append(":");
        str = ((StringBuilder)localObject).toString();
        localObject = paramArrayOfPathDataNode[i].mParams;
        for (int j = 0; j < localObject.length; j++)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(localObject[j]);
          localStringBuilder.append(",");
          str = localStringBuilder.toString();
        }
      }
      return str;
    }
    
    public void printVPath(int paramInt)
    {
      String str = "";
      for (int i = 0; i < paramInt; i++)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("    ");
        str = localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("current path is :");
      localStringBuilder.append(this.mPathName);
      localStringBuilder.append(" pathData is ");
      localStringBuilder.append(nodesToString(this.mNodes));
      Log.v("VectorDrawableCompat", localStringBuilder.toString());
    }
    
    public void setPathData(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      if (!PathParser.canMorph(this.mNodes, paramArrayOfPathDataNode)) {
        this.mNodes = PathParser.deepCopyNodes(paramArrayOfPathDataNode);
      } else {
        PathParser.updateNodes(this.mNodes, paramArrayOfPathDataNode);
      }
    }
    
    public void toPath(Path paramPath)
    {
      paramPath.reset();
      PathParser.PathDataNode[] arrayOfPathDataNode = this.mNodes;
      if (arrayOfPathDataNode != null) {
        PathParser.PathDataNode.nodesToPath(arrayOfPathDataNode, paramPath);
      }
    }
  }
  
  private static class VPathRenderer
  {
    private static final Matrix IDENTITY_MATRIX = new Matrix();
    float mBaseHeight = 0.0F;
    float mBaseWidth = 0.0F;
    private int mChangingConfigurations;
    Paint mFillPaint;
    private final Matrix mFinalPathMatrix = new Matrix();
    Boolean mIsStateful = null;
    private final Path mPath;
    private PathMeasure mPathMeasure;
    private final Path mRenderPath;
    int mRootAlpha = 255;
    final VectorDrawableCompat.VGroup mRootGroup;
    String mRootName = null;
    Paint mStrokePaint;
    final ArrayMap<String, Object> mVGTargetsMap;
    float mViewportHeight = 0.0F;
    float mViewportWidth = 0.0F;
    
    public VPathRenderer()
    {
      this.mVGTargetsMap = new ArrayMap();
      this.mRootGroup = new VectorDrawableCompat.VGroup();
      this.mPath = new Path();
      this.mRenderPath = new Path();
    }
    
    public VPathRenderer(VPathRenderer paramVPathRenderer)
    {
      ArrayMap localArrayMap = new ArrayMap();
      this.mVGTargetsMap = localArrayMap;
      this.mRootGroup = new VectorDrawableCompat.VGroup(paramVPathRenderer.mRootGroup, localArrayMap);
      this.mPath = new Path(paramVPathRenderer.mPath);
      this.mRenderPath = new Path(paramVPathRenderer.mRenderPath);
      this.mBaseWidth = paramVPathRenderer.mBaseWidth;
      this.mBaseHeight = paramVPathRenderer.mBaseHeight;
      this.mViewportWidth = paramVPathRenderer.mViewportWidth;
      this.mViewportHeight = paramVPathRenderer.mViewportHeight;
      this.mChangingConfigurations = paramVPathRenderer.mChangingConfigurations;
      this.mRootAlpha = paramVPathRenderer.mRootAlpha;
      this.mRootName = paramVPathRenderer.mRootName;
      String str = paramVPathRenderer.mRootName;
      if (str != null) {
        localArrayMap.put(str, this);
      }
      this.mIsStateful = paramVPathRenderer.mIsStateful;
    }
    
    private static float cross(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
    }
    
    private void drawGroupTree(VectorDrawableCompat.VGroup paramVGroup, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramVGroup.mStackedMatrix.set(paramMatrix);
      paramVGroup.mStackedMatrix.preConcat(paramVGroup.mLocalMatrix);
      paramCanvas.save();
      for (int i = 0; i < paramVGroup.mChildren.size(); i++)
      {
        paramMatrix = (VectorDrawableCompat.VObject)paramVGroup.mChildren.get(i);
        if ((paramMatrix instanceof VectorDrawableCompat.VGroup)) {
          drawGroupTree((VectorDrawableCompat.VGroup)paramMatrix, paramVGroup.mStackedMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        } else if ((paramMatrix instanceof VectorDrawableCompat.VPath)) {
          drawPath(paramVGroup, (VectorDrawableCompat.VPath)paramMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
      }
      paramCanvas.restore();
    }
    
    private void drawPath(VectorDrawableCompat.VGroup paramVGroup, VectorDrawableCompat.VPath paramVPath, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      float f1 = paramInt1 / this.mViewportWidth;
      float f2 = paramInt2 / this.mViewportHeight;
      float f3 = Math.min(f1, f2);
      paramVGroup = paramVGroup.mStackedMatrix;
      this.mFinalPathMatrix.set(paramVGroup);
      this.mFinalPathMatrix.postScale(f1, f2);
      f1 = getMatrixScale(paramVGroup);
      if (f1 == 0.0F) {
        return;
      }
      paramVPath.toPath(this.mPath);
      Object localObject1 = this.mPath;
      this.mRenderPath.reset();
      if (paramVPath.isClipPath())
      {
        paramColorFilter = this.mRenderPath;
        if (paramVPath.mFillRule == 0) {
          paramVGroup = Path.FillType.WINDING;
        } else {
          paramVGroup = Path.FillType.EVEN_ODD;
        }
        paramColorFilter.setFillType(paramVGroup);
        this.mRenderPath.addPath((Path)localObject1, this.mFinalPathMatrix);
        paramCanvas.clipPath(this.mRenderPath);
      }
      else
      {
        paramVPath = (VectorDrawableCompat.VFullPath)paramVPath;
        float f4 = paramVPath.mTrimPathStart;
        if ((f4 != 0.0F) || (paramVPath.mTrimPathEnd != 1.0F))
        {
          float f5 = paramVPath.mTrimPathOffset;
          float f6 = paramVPath.mTrimPathEnd;
          if (this.mPathMeasure == null) {
            this.mPathMeasure = new PathMeasure();
          }
          this.mPathMeasure.setPath(this.mPath, false);
          f2 = this.mPathMeasure.getLength();
          f4 = (f4 + f5) % 1.0F * f2;
          f5 = (f6 + f5) % 1.0F * f2;
          ((Path)localObject1).reset();
          if (f4 > f5)
          {
            this.mPathMeasure.getSegment(f4, f2, (Path)localObject1, true);
            this.mPathMeasure.getSegment(0.0F, f5, (Path)localObject1, true);
          }
          else
          {
            this.mPathMeasure.getSegment(f4, f5, (Path)localObject1, true);
          }
          ((Path)localObject1).rLineTo(0.0F, 0.0F);
        }
        this.mRenderPath.addPath((Path)localObject1, this.mFinalPathMatrix);
        Object localObject2;
        if (paramVPath.mFillColor.willDraw())
        {
          paramVGroup = paramVPath.mFillColor;
          if (this.mFillPaint == null)
          {
            localObject1 = new Paint(1);
            this.mFillPaint = ((Paint)localObject1);
            ((Paint)localObject1).setStyle(Paint.Style.FILL);
          }
          localObject1 = this.mFillPaint;
          if (paramVGroup.isGradient())
          {
            paramVGroup = paramVGroup.getShader();
            paramVGroup.setLocalMatrix(this.mFinalPathMatrix);
            ((Paint)localObject1).setShader(paramVGroup);
            ((Paint)localObject1).setAlpha(Math.round(paramVPath.mFillAlpha * 255.0F));
          }
          else
          {
            ((Paint)localObject1).setShader(null);
            ((Paint)localObject1).setAlpha(255);
            ((Paint)localObject1).setColor(VectorDrawableCompat.applyAlpha(paramVGroup.getColor(), paramVPath.mFillAlpha));
          }
          ((Paint)localObject1).setColorFilter(paramColorFilter);
          localObject2 = this.mRenderPath;
          if (paramVPath.mFillRule == 0) {
            paramVGroup = Path.FillType.WINDING;
          } else {
            paramVGroup = Path.FillType.EVEN_ODD;
          }
          ((Path)localObject2).setFillType(paramVGroup);
          paramCanvas.drawPath(this.mRenderPath, (Paint)localObject1);
        }
        if (paramVPath.mStrokeColor.willDraw())
        {
          localObject1 = paramVPath.mStrokeColor;
          if (this.mStrokePaint == null)
          {
            paramVGroup = new Paint(1);
            this.mStrokePaint = paramVGroup;
            paramVGroup.setStyle(Paint.Style.STROKE);
          }
          paramVGroup = this.mStrokePaint;
          localObject2 = paramVPath.mStrokeLineJoin;
          if (localObject2 != null) {
            paramVGroup.setStrokeJoin((Paint.Join)localObject2);
          }
          localObject2 = paramVPath.mStrokeLineCap;
          if (localObject2 != null) {
            paramVGroup.setStrokeCap((Paint.Cap)localObject2);
          }
          paramVGroup.setStrokeMiter(paramVPath.mStrokeMiterlimit);
          if (((ComplexColorCompat)localObject1).isGradient())
          {
            localObject1 = ((ComplexColorCompat)localObject1).getShader();
            ((Shader)localObject1).setLocalMatrix(this.mFinalPathMatrix);
            paramVGroup.setShader((Shader)localObject1);
            paramVGroup.setAlpha(Math.round(paramVPath.mStrokeAlpha * 255.0F));
          }
          else
          {
            paramVGroup.setShader(null);
            paramVGroup.setAlpha(255);
            paramVGroup.setColor(VectorDrawableCompat.applyAlpha(((ComplexColorCompat)localObject1).getColor(), paramVPath.mStrokeAlpha));
          }
          paramVGroup.setColorFilter(paramColorFilter);
          paramVGroup.setStrokeWidth(paramVPath.mStrokeWidth * (f3 * f1));
          paramCanvas.drawPath(this.mRenderPath, paramVGroup);
        }
      }
    }
    
    private float getMatrixScale(Matrix paramMatrix)
    {
      float[] arrayOfFloat = new float[4];
      float[] tmp5_4 = arrayOfFloat;
      tmp5_4[0] = 0.0F;
      float[] tmp9_5 = tmp5_4;
      tmp9_5[1] = 1.0F;
      float[] tmp13_9 = tmp9_5;
      tmp13_9[2] = 1.0F;
      float[] tmp17_13 = tmp13_9;
      tmp17_13[3] = 0.0F;
      tmp17_13;
      paramMatrix.mapVectors(arrayOfFloat);
      float f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f2 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f3 = cross(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      f1 = Math.max(f1, f2);
      f2 = 0.0F;
      if (f1 > 0.0F) {
        f2 = Math.abs(f3) / f1;
      }
      return f2;
    }
    
    public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, paramCanvas, paramInt1, paramInt2, paramColorFilter);
    }
    
    public float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public int getRootAlpha()
    {
      return this.mRootAlpha;
    }
    
    public boolean isStateful()
    {
      if (this.mIsStateful == null) {
        this.mIsStateful = Boolean.valueOf(this.mRootGroup.isStateful());
      }
      return this.mIsStateful.booleanValue();
    }
    
    public boolean onStateChanged(int[] paramArrayOfInt)
    {
      return this.mRootGroup.onStateChanged(paramArrayOfInt);
    }
    
    public void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(paramFloat * 255.0F));
    }
    
    public void setRootAlpha(int paramInt)
    {
      this.mRootAlpha = paramInt;
    }
  }
  
  private static class VectorDrawableCompatState
    extends Drawable.ConstantState
  {
    boolean mAutoMirrored;
    boolean mCacheDirty;
    boolean mCachedAutoMirrored;
    Bitmap mCachedBitmap;
    int mCachedRootAlpha;
    int[] mCachedThemeAttrs;
    ColorStateList mCachedTint;
    PorterDuff.Mode mCachedTintMode;
    int mChangingConfigurations;
    Paint mTempPaint;
    ColorStateList mTint = null;
    PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
    VectorDrawableCompat.VPathRenderer mVPathRenderer;
    
    public VectorDrawableCompatState()
    {
      this.mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
    }
    
    public VectorDrawableCompatState(VectorDrawableCompatState paramVectorDrawableCompatState)
    {
      if (paramVectorDrawableCompatState != null)
      {
        this.mChangingConfigurations = paramVectorDrawableCompatState.mChangingConfigurations;
        VectorDrawableCompat.VPathRenderer localVPathRenderer = new VectorDrawableCompat.VPathRenderer(paramVectorDrawableCompatState.mVPathRenderer);
        this.mVPathRenderer = localVPathRenderer;
        if (paramVectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
          localVPathRenderer.mFillPaint = new Paint(paramVectorDrawableCompatState.mVPathRenderer.mFillPaint);
        }
        if (paramVectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
          this.mVPathRenderer.mStrokePaint = new Paint(paramVectorDrawableCompatState.mVPathRenderer.mStrokePaint);
        }
        this.mTint = paramVectorDrawableCompatState.mTint;
        this.mTintMode = paramVectorDrawableCompatState.mTintMode;
        this.mAutoMirrored = paramVectorDrawableCompatState.mAutoMirrored;
      }
    }
    
    public boolean canReuseBitmap(int paramInt1, int paramInt2)
    {
      return (paramInt1 == this.mCachedBitmap.getWidth()) && (paramInt2 == this.mCachedBitmap.getHeight());
    }
    
    public boolean canReuseCache()
    {
      return (!this.mCacheDirty) && (this.mCachedTint == this.mTint) && (this.mCachedTintMode == this.mTintMode) && (this.mCachedAutoMirrored == this.mAutoMirrored) && (this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha());
    }
    
    public void createCachedBitmapIfNeeded(int paramInt1, int paramInt2)
    {
      if ((this.mCachedBitmap == null) || (!canReuseBitmap(paramInt1, paramInt2)))
      {
        this.mCachedBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.mCacheDirty = true;
      }
    }
    
    public void drawCachedBitmapWithRootAlpha(Canvas paramCanvas, ColorFilter paramColorFilter, Rect paramRect)
    {
      paramColorFilter = getPaint(paramColorFilter);
      paramCanvas.drawBitmap(this.mCachedBitmap, null, paramRect, paramColorFilter);
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Paint getPaint(ColorFilter paramColorFilter)
    {
      if ((!hasTranslucentRoot()) && (paramColorFilter == null)) {
        return null;
      }
      if (this.mTempPaint == null)
      {
        Paint localPaint = new Paint();
        this.mTempPaint = localPaint;
        localPaint.setFilterBitmap(true);
      }
      this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
      this.mTempPaint.setColorFilter(paramColorFilter);
      return this.mTempPaint;
    }
    
    public boolean hasTranslucentRoot()
    {
      boolean bool;
      if (this.mVPathRenderer.getRootAlpha() < 255) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean isStateful()
    {
      return this.mVPathRenderer.isStateful();
    }
    
    @NonNull
    public Drawable newDrawable()
    {
      return new VectorDrawableCompat(this);
    }
    
    @NonNull
    public Drawable newDrawable(Resources paramResources)
    {
      return new VectorDrawableCompat(this);
    }
    
    public boolean onStateChanged(int[] paramArrayOfInt)
    {
      boolean bool = this.mVPathRenderer.onStateChanged(paramArrayOfInt);
      this.mCacheDirty |= bool;
      return bool;
    }
    
    public void updateCacheStates()
    {
      this.mCachedTint = this.mTint;
      this.mCachedTintMode = this.mTintMode;
      this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
      this.mCachedAutoMirrored = this.mAutoMirrored;
      this.mCacheDirty = false;
    }
    
    public void updateCachedBitmap(int paramInt1, int paramInt2)
    {
      this.mCachedBitmap.eraseColor(0);
      Canvas localCanvas = new Canvas(this.mCachedBitmap);
      this.mVPathRenderer.draw(localCanvas, paramInt1, paramInt2, null);
    }
  }
  
  @RequiresApi(24)
  private static class VectorDrawableDelegateState
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState mDelegateState;
    
    public VectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
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
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
      localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable());
      return localVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
      localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable(paramResources));
      return localVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
      localVectorDrawableCompat.mDelegateDrawable = ((VectorDrawable)this.mDelegateState.newDrawable(paramResources, paramTheme));
      return localVectorDrawableCompat;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\vectordrawable\graphics\drawable\VectorDrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */