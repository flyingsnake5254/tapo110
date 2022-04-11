package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing.EasingFunction;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.ComponentBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>>
  extends ViewGroup
  implements ChartInterface
{
  public static final String LOG_TAG = "MPAndroidChart";
  public static final int PAINT_CENTER_TEXT = 14;
  public static final int PAINT_DESCRIPTION = 11;
  public static final int PAINT_GRID_BACKGROUND = 4;
  public static final int PAINT_HOLE = 13;
  public static final int PAINT_INFO = 7;
  public static final int PAINT_LEGEND_LABEL = 18;
  protected ChartAnimator mAnimator;
  protected ChartTouchListener mChartTouchListener;
  protected T mData = null;
  protected DefaultValueFormatter mDefaultValueFormatter = new DefaultValueFormatter(0);
  protected Paint mDescPaint;
  protected Description mDescription;
  private boolean mDragDecelerationEnabled = true;
  private float mDragDecelerationFrictionCoef = 0.9F;
  protected boolean mDrawMarkers = true;
  private float mExtraBottomOffset = 0.0F;
  private float mExtraLeftOffset = 0.0F;
  private float mExtraRightOffset = 0.0F;
  private float mExtraTopOffset = 0.0F;
  private OnChartGestureListener mGestureListener;
  protected boolean mHighLightPerTapEnabled = true;
  protected IHighlighter mHighlighter;
  protected Highlight[] mIndicesToHighlight;
  protected Paint mInfoPaint;
  protected ArrayList<Runnable> mJobs = new ArrayList();
  protected Legend mLegend;
  protected LegendRenderer mLegendRenderer;
  protected boolean mLogEnabled = false;
  protected IMarker mMarker;
  protected float mMaxHighlightDistance = 0.0F;
  private String mNoDataText = "No chart data available.";
  private boolean mOffsetsCalculated = false;
  protected DataRenderer mRenderer;
  protected OnChartValueSelectedListener mSelectionListener;
  protected boolean mTouchEnabled = true;
  private boolean mUnbind = false;
  protected ViewPortHandler mViewPortHandler = new ViewPortHandler();
  protected XAxis mXAxis;
  
  public Chart(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public Chart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public Chart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void unbindDrawables(View paramView)
  {
    if (paramView.getBackground() != null) {
      paramView.getBackground().setCallback(null);
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup;
      for (int i = 0;; i++)
      {
        localViewGroup = (ViewGroup)paramView;
        if (i >= localViewGroup.getChildCount()) {
          break;
        }
        unbindDrawables(localViewGroup.getChildAt(i));
      }
      localViewGroup.removeAllViews();
    }
  }
  
  public void addViewportJob(Runnable paramRunnable)
  {
    if (this.mViewPortHandler.hasChartDimens()) {
      post(paramRunnable);
    } else {
      this.mJobs.add(paramRunnable);
    }
  }
  
  @RequiresApi(11)
  public void animateX(int paramInt)
  {
    this.mAnimator.animateX(paramInt);
  }
  
  @RequiresApi(11)
  public void animateX(int paramInt, Easing.EasingFunction paramEasingFunction)
  {
    this.mAnimator.animateX(paramInt, paramEasingFunction);
  }
  
  @RequiresApi(11)
  public void animateXY(int paramInt1, int paramInt2)
  {
    this.mAnimator.animateXY(paramInt1, paramInt2);
  }
  
  @RequiresApi(11)
  public void animateXY(int paramInt1, int paramInt2, Easing.EasingFunction paramEasingFunction)
  {
    this.mAnimator.animateXY(paramInt1, paramInt2, paramEasingFunction);
  }
  
  @RequiresApi(11)
  public void animateXY(int paramInt1, int paramInt2, Easing.EasingFunction paramEasingFunction1, Easing.EasingFunction paramEasingFunction2)
  {
    this.mAnimator.animateXY(paramInt1, paramInt2, paramEasingFunction1, paramEasingFunction2);
  }
  
  @RequiresApi(11)
  public void animateY(int paramInt)
  {
    this.mAnimator.animateY(paramInt);
  }
  
  @RequiresApi(11)
  public void animateY(int paramInt, Easing.EasingFunction paramEasingFunction)
  {
    this.mAnimator.animateY(paramInt, paramEasingFunction);
  }
  
  protected abstract void calcMinMax();
  
  protected abstract void calculateOffsets();
  
  public void clear()
  {
    this.mData = null;
    this.mOffsetsCalculated = false;
    this.mIndicesToHighlight = null;
    this.mChartTouchListener.setLastHighlighted(null);
    invalidate();
  }
  
  public void clearAllViewportJobs()
  {
    this.mJobs.clear();
  }
  
  public void clearValues()
  {
    this.mData.clearValues();
    invalidate();
  }
  
  public void disableScroll()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  protected void drawDescription(Canvas paramCanvas)
  {
    Object localObject = this.mDescription;
    if ((localObject != null) && (((ComponentBase)localObject).isEnabled()))
    {
      localObject = this.mDescription.getPosition();
      this.mDescPaint.setTypeface(this.mDescription.getTypeface());
      this.mDescPaint.setTextSize(this.mDescription.getTextSize());
      this.mDescPaint.setColor(this.mDescription.getTextColor());
      this.mDescPaint.setTextAlign(this.mDescription.getTextAlign());
      float f1;
      float f2;
      if (localObject == null)
      {
        f1 = getWidth() - this.mViewPortHandler.offsetRight() - this.mDescription.getXOffset();
        f2 = getHeight() - this.mViewPortHandler.offsetBottom() - this.mDescription.getYOffset();
      }
      else
      {
        f1 = ((MPPointF)localObject).x;
        f2 = ((MPPointF)localObject).y;
      }
      paramCanvas.drawText(this.mDescription.getText(), f1, f2, this.mDescPaint);
    }
  }
  
  protected void drawMarkers(Canvas paramCanvas)
  {
    if ((this.mMarker != null) && (isDrawMarkersEnabled()) && (valuesToHighlight())) {
      for (int i = 0;; i++)
      {
        Object localObject1 = this.mIndicesToHighlight;
        if (i >= localObject1.length) {
          break;
        }
        localObject1 = localObject1[i];
        Object localObject2 = this.mData.getDataSetByIndex(((Highlight)localObject1).getDataSetIndex());
        Entry localEntry = this.mData.getEntryForHighlight(this.mIndicesToHighlight[i]);
        int j = ((IDataSet)localObject2).getEntryIndex(localEntry);
        if ((localEntry != null) && (j <= ((IDataSet)localObject2).getEntryCount() * this.mAnimator.getPhaseX()))
        {
          localObject2 = getMarkerPosition((Highlight)localObject1);
          if (this.mViewPortHandler.isInBounds(localObject2[0], localObject2[1]))
          {
            this.mMarker.refreshContent(localEntry, (Highlight)localObject1);
            this.mMarker.draw(paramCanvas, localObject2[0], localObject2[1]);
          }
        }
      }
    }
  }
  
  public void enableScroll()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(false);
    }
  }
  
  public ChartAnimator getAnimator()
  {
    return this.mAnimator;
  }
  
  public MPPointF getCenter()
  {
    return MPPointF.getInstance(getWidth() / 2.0F, getHeight() / 2.0F);
  }
  
  public MPPointF getCenterOfView()
  {
    return getCenter();
  }
  
  public MPPointF getCenterOffsets()
  {
    return this.mViewPortHandler.getContentCenter();
  }
  
  public Bitmap getChartBitmap()
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    } else {
      localCanvas.drawColor(-1);
    }
    draw(localCanvas);
    return localBitmap;
  }
  
  public RectF getContentRect()
  {
    return this.mViewPortHandler.getContentRect();
  }
  
  public T getData()
  {
    return this.mData;
  }
  
  public ValueFormatter getDefaultValueFormatter()
  {
    return this.mDefaultValueFormatter;
  }
  
  public Description getDescription()
  {
    return this.mDescription;
  }
  
  public float getDragDecelerationFrictionCoef()
  {
    return this.mDragDecelerationFrictionCoef;
  }
  
  public float getExtraBottomOffset()
  {
    return this.mExtraBottomOffset;
  }
  
  public float getExtraLeftOffset()
  {
    return this.mExtraLeftOffset;
  }
  
  public float getExtraRightOffset()
  {
    return this.mExtraRightOffset;
  }
  
  public float getExtraTopOffset()
  {
    return this.mExtraTopOffset;
  }
  
  public Highlight getHighlightByTouchPoint(float paramFloat1, float paramFloat2)
  {
    if (this.mData == null)
    {
      Log.e("MPAndroidChart", "Can't select by touch. No data set.");
      return null;
    }
    return getHighlighter().getHighlight(paramFloat1, paramFloat2);
  }
  
  public Highlight[] getHighlighted()
  {
    return this.mIndicesToHighlight;
  }
  
  public IHighlighter getHighlighter()
  {
    return this.mHighlighter;
  }
  
  public ArrayList<Runnable> getJobs()
  {
    return this.mJobs;
  }
  
  public Legend getLegend()
  {
    return this.mLegend;
  }
  
  public LegendRenderer getLegendRenderer()
  {
    return this.mLegendRenderer;
  }
  
  public IMarker getMarker()
  {
    return this.mMarker;
  }
  
  protected float[] getMarkerPosition(Highlight paramHighlight)
  {
    return new float[] { paramHighlight.getDrawX(), paramHighlight.getDrawY() };
  }
  
  @Deprecated
  public IMarker getMarkerView()
  {
    return getMarker();
  }
  
  public float getMaxHighlightDistance()
  {
    return this.mMaxHighlightDistance;
  }
  
  public OnChartGestureListener getOnChartGestureListener()
  {
    return this.mGestureListener;
  }
  
  public ChartTouchListener getOnTouchListener()
  {
    return this.mChartTouchListener;
  }
  
  public Paint getPaint(int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt != 11) {
        return null;
      }
      return this.mDescPaint;
    }
    return this.mInfoPaint;
  }
  
  public DataRenderer getRenderer()
  {
    return this.mRenderer;
  }
  
  public ViewPortHandler getViewPortHandler()
  {
    return this.mViewPortHandler;
  }
  
  public XAxis getXAxis()
  {
    return this.mXAxis;
  }
  
  public float getXChartMax()
  {
    return this.mXAxis.mAxisMaximum;
  }
  
  public float getXChartMin()
  {
    return this.mXAxis.mAxisMinimum;
  }
  
  public float getXRange()
  {
    return this.mXAxis.mAxisRange;
  }
  
  public float getYMax()
  {
    return this.mData.getYMax();
  }
  
  public float getYMin()
  {
    return this.mData.getYMin();
  }
  
  public void highlightValue(float paramFloat1, float paramFloat2, int paramInt)
  {
    highlightValue(paramFloat1, paramFloat2, paramInt, true);
  }
  
  public void highlightValue(float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.getDataSetCount())) {
      highlightValue(new Highlight(paramFloat1, paramFloat2, paramInt), paramBoolean);
    } else {
      highlightValue(null, paramBoolean);
    }
  }
  
  public void highlightValue(float paramFloat, int paramInt)
  {
    highlightValue(paramFloat, paramInt, true);
  }
  
  public void highlightValue(float paramFloat, int paramInt, boolean paramBoolean)
  {
    highlightValue(paramFloat, NaN.0F, paramInt, paramBoolean);
  }
  
  public void highlightValue(Highlight paramHighlight)
  {
    highlightValue(paramHighlight, false);
  }
  
  public void highlightValue(Highlight paramHighlight, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramHighlight == null)
    {
      this.mIndicesToHighlight = null;
    }
    else
    {
      if (this.mLogEnabled)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Highlighted: ");
        ((StringBuilder)localObject).append(paramHighlight.toString());
        Log.i("MPAndroidChart", ((StringBuilder)localObject).toString());
      }
      localObject = this.mData.getEntryForHighlight(paramHighlight);
      if (localObject == null)
      {
        this.mIndicesToHighlight = null;
        paramHighlight = null;
      }
      else
      {
        this.mIndicesToHighlight = new Highlight[] { paramHighlight };
      }
    }
    setLastHighlighted(this.mIndicesToHighlight);
    if ((paramBoolean) && (this.mSelectionListener != null)) {
      if (!valuesToHighlight()) {
        this.mSelectionListener.onNothingSelected();
      } else {
        this.mSelectionListener.onValueSelected((Entry)localObject, paramHighlight);
      }
    }
    invalidate();
  }
  
  public void highlightValues(Highlight[] paramArrayOfHighlight)
  {
    this.mIndicesToHighlight = paramArrayOfHighlight;
    setLastHighlighted(paramArrayOfHighlight);
    invalidate();
  }
  
  protected void init()
  {
    setWillNotDraw(false);
    this.mAnimator = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        Chart.this.postInvalidate();
      }
    });
    Utils.init(getContext());
    this.mMaxHighlightDistance = Utils.convertDpToPixel(500.0F);
    this.mDescription = new Description();
    Object localObject = new Legend();
    this.mLegend = ((Legend)localObject);
    this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, (Legend)localObject);
    this.mXAxis = new XAxis();
    this.mDescPaint = new Paint(1);
    localObject = new Paint(1);
    this.mInfoPaint = ((Paint)localObject);
    ((Paint)localObject).setColor(Color.rgb(247, 189, 51));
    this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
    this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0F));
    if (this.mLogEnabled) {
      Log.i("", "Chart.init()");
    }
  }
  
  public boolean isDragDecelerationEnabled()
  {
    return this.mDragDecelerationEnabled;
  }
  
  @Deprecated
  public boolean isDrawMarkerViewsEnabled()
  {
    return isDrawMarkersEnabled();
  }
  
  public boolean isDrawMarkersEnabled()
  {
    return this.mDrawMarkers;
  }
  
  public boolean isEmpty()
  {
    ChartData localChartData = this.mData;
    if (localChartData == null) {
      return true;
    }
    return localChartData.getEntryCount() <= 0;
  }
  
  public boolean isHighlightPerTapEnabled()
  {
    return this.mHighLightPerTapEnabled;
  }
  
  public boolean isLogEnabled()
  {
    return this.mLogEnabled;
  }
  
  public abstract void notifyDataSetChanged();
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mUnbind) {
      unbindDrawables(this);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mData == null)
    {
      if ((TextUtils.isEmpty(this.mNoDataText) ^ true))
      {
        MPPointF localMPPointF = getCenter();
        paramCanvas.drawText(this.mNoDataText, localMPPointF.x, localMPPointF.y, this.mInfoPaint);
      }
      return;
    }
    if (!this.mOffsetsCalculated)
    {
      calculateOffsets();
      this.mOffsetsCalculated = true;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (int i = 0; i < getChildCount(); i++) {
      getChildAt(i).layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = (int)Utils.convertDpToPixel(50.0F);
    setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), ViewGroup.resolveSize(i, paramInt1)), Math.max(getSuggestedMinimumHeight(), ViewGroup.resolveSize(i, paramInt2)));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mLogEnabled) {
      Log.i("MPAndroidChart", "OnSizeChanged()");
    }
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 < 10000) && (paramInt2 < 10000))
    {
      if (this.mLogEnabled)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Setting chart dimens, width: ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", height: ");
        ((StringBuilder)localObject).append(paramInt2);
        Log.i("MPAndroidChart", ((StringBuilder)localObject).toString());
      }
      this.mViewPortHandler.setChartDimens(paramInt1, paramInt2);
    }
    else if (this.mLogEnabled)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("*Avoiding* setting chart dimens! width: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", height: ");
      ((StringBuilder)localObject).append(paramInt2);
      Log.w("MPAndroidChart", ((StringBuilder)localObject).toString());
    }
    notifyDataSetChanged();
    Object localObject = this.mJobs.iterator();
    while (((Iterator)localObject).hasNext()) {
      post((Runnable)((Iterator)localObject).next());
    }
    this.mJobs.clear();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void removeViewportJob(Runnable paramRunnable)
  {
    this.mJobs.remove(paramRunnable);
  }
  
  public boolean saveToGallery(String paramString)
  {
    return saveToGallery(paramString, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
  }
  
  public boolean saveToGallery(String paramString, int paramInt)
  {
    return saveToGallery(paramString, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, paramInt);
  }
  
  public boolean saveToGallery(String paramString1, String paramString2, String paramString3, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 100) {}
    }
    else
    {
      i = 50;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = Environment.getExternalStorageDirectory();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject2).append("/DCIM/");
    ((StringBuilder)localObject2).append(paramString2);
    File localFile = new File(((StringBuilder)localObject2).toString());
    boolean bool1 = localFile.exists();
    boolean bool2 = false;
    if ((!bool1) && (!localFile.mkdirs())) {
      return false;
    }
    paramInt = 2.$SwitchMap$android$graphics$Bitmap$CompressFormat[paramCompressFormat.ordinal()];
    localObject1 = "image/png";
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        paramString2 = paramString1;
        if (!paramString1.endsWith(".jpg"))
        {
          paramString2 = paramString1;
          if (!paramString1.endsWith(".jpeg"))
          {
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append(".jpg");
            paramString2 = paramString2.toString();
          }
        }
        localObject2 = "image/jpeg";
      }
      else
      {
        paramString2 = paramString1;
        if (!paramString1.endsWith(".webp"))
        {
          paramString2 = new StringBuilder();
          paramString2.append(paramString1);
          paramString2.append(".webp");
          paramString2 = paramString2.toString();
        }
        localObject2 = "image/webp";
      }
    }
    else
    {
      localObject2 = localObject1;
      paramString2 = paramString1;
      if (!paramString1.endsWith(".png"))
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append(".png");
        paramString2 = paramString2.toString();
        localObject2 = localObject1;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append(localFile.getAbsolutePath());
    paramString1.append("/");
    paramString1.append(paramString2);
    paramString1 = paramString1.toString();
    try
    {
      localObject1 = new java/io/FileOutputStream;
      ((FileOutputStream)localObject1).<init>(paramString1);
      getChartBitmap().compress(paramCompressFormat, i, (OutputStream)localObject1);
      ((FileOutputStream)localObject1).flush();
      ((FileOutputStream)localObject1).close();
      long l2 = new File(paramString1).length();
      paramCompressFormat = new ContentValues(8);
      paramCompressFormat.put("title", paramString2);
      paramCompressFormat.put("_display_name", paramString2);
      paramCompressFormat.put("date_added", Long.valueOf(l1));
      paramCompressFormat.put("mime_type", (String)localObject2);
      paramCompressFormat.put("description", paramString3);
      paramCompressFormat.put("orientation", Integer.valueOf(0));
      paramCompressFormat.put("_data", paramString1);
      paramCompressFormat.put("_size", Long.valueOf(l2));
      if (getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramCompressFormat) != null) {
        bool2 = true;
      }
      return bool2;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public boolean saveToPath(String paramString1, String paramString2)
  {
    Bitmap localBitmap = getChartBitmap();
    try
    {
      FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append(paramString2);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".png");
      localFileOutputStream.<init>(localStringBuilder.toString());
      localBitmap.compress(Bitmap.CompressFormat.PNG, 40, localFileOutputStream);
      localFileOutputStream.close();
      return true;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public void setData(T paramT)
  {
    this.mData = paramT;
    this.mOffsetsCalculated = false;
    if (paramT == null) {
      return;
    }
    setupDefaultFormatter(paramT.getYMin(), paramT.getYMax());
    Iterator localIterator = this.mData.getDataSets().iterator();
    while (localIterator.hasNext())
    {
      paramT = (IDataSet)localIterator.next();
      if ((paramT.needsFormatter()) || (paramT.getValueFormatter() == this.mDefaultValueFormatter)) {
        paramT.setValueFormatter(this.mDefaultValueFormatter);
      }
    }
    notifyDataSetChanged();
    if (this.mLogEnabled) {
      Log.i("MPAndroidChart", "Data is set.");
    }
  }
  
  public void setDescription(Description paramDescription)
  {
    this.mDescription = paramDescription;
  }
  
  public void setDragDecelerationEnabled(boolean paramBoolean)
  {
    this.mDragDecelerationEnabled = paramBoolean;
  }
  
  public void setDragDecelerationFrictionCoef(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    paramFloat = f;
    if (f >= 1.0F) {
      paramFloat = 0.999F;
    }
    this.mDragDecelerationFrictionCoef = paramFloat;
  }
  
  @Deprecated
  public void setDrawMarkerViews(boolean paramBoolean)
  {
    setDrawMarkers(paramBoolean);
  }
  
  public void setDrawMarkers(boolean paramBoolean)
  {
    this.mDrawMarkers = paramBoolean;
  }
  
  public void setExtraBottomOffset(float paramFloat)
  {
    this.mExtraBottomOffset = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setExtraLeftOffset(float paramFloat)
  {
    this.mExtraLeftOffset = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setExtraOffsets(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setExtraLeftOffset(paramFloat1);
    setExtraTopOffset(paramFloat2);
    setExtraRightOffset(paramFloat3);
    setExtraBottomOffset(paramFloat4);
  }
  
  public void setExtraRightOffset(float paramFloat)
  {
    this.mExtraRightOffset = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setExtraTopOffset(float paramFloat)
  {
    this.mExtraTopOffset = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setHardwareAccelerationEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      setLayerType(2, null);
    } else {
      setLayerType(1, null);
    }
  }
  
  public void setHighlightPerTapEnabled(boolean paramBoolean)
  {
    this.mHighLightPerTapEnabled = paramBoolean;
  }
  
  public void setHighlighter(ChartHighlighter paramChartHighlighter)
  {
    this.mHighlighter = paramChartHighlighter;
  }
  
  protected void setLastHighlighted(Highlight[] paramArrayOfHighlight)
  {
    if ((paramArrayOfHighlight != null) && (paramArrayOfHighlight.length > 0) && (paramArrayOfHighlight[0] != null)) {
      this.mChartTouchListener.setLastHighlighted(paramArrayOfHighlight[0]);
    } else {
      this.mChartTouchListener.setLastHighlighted(null);
    }
  }
  
  public void setLogEnabled(boolean paramBoolean)
  {
    this.mLogEnabled = paramBoolean;
  }
  
  public void setMarker(IMarker paramIMarker)
  {
    this.mMarker = paramIMarker;
  }
  
  @Deprecated
  public void setMarkerView(IMarker paramIMarker)
  {
    setMarker(paramIMarker);
  }
  
  public void setMaxHighlightDistance(float paramFloat)
  {
    this.mMaxHighlightDistance = Utils.convertDpToPixel(paramFloat);
  }
  
  public void setNoDataText(String paramString)
  {
    this.mNoDataText = paramString;
  }
  
  public void setNoDataTextColor(int paramInt)
  {
    this.mInfoPaint.setColor(paramInt);
  }
  
  public void setNoDataTextTypeface(Typeface paramTypeface)
  {
    this.mInfoPaint.setTypeface(paramTypeface);
  }
  
  public void setOnChartGestureListener(OnChartGestureListener paramOnChartGestureListener)
  {
    this.mGestureListener = paramOnChartGestureListener;
  }
  
  public void setOnChartValueSelectedListener(OnChartValueSelectedListener paramOnChartValueSelectedListener)
  {
    this.mSelectionListener = paramOnChartValueSelectedListener;
  }
  
  public void setOnTouchListener(ChartTouchListener paramChartTouchListener)
  {
    this.mChartTouchListener = paramChartTouchListener;
  }
  
  public void setPaint(Paint paramPaint, int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt == 11) {
        this.mDescPaint = paramPaint;
      }
    }
    else {
      this.mInfoPaint = paramPaint;
    }
  }
  
  public void setRenderer(DataRenderer paramDataRenderer)
  {
    if (paramDataRenderer != null) {
      this.mRenderer = paramDataRenderer;
    }
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    this.mTouchEnabled = paramBoolean;
  }
  
  public void setUnbindEnabled(boolean paramBoolean)
  {
    this.mUnbind = paramBoolean;
  }
  
  protected void setupDefaultFormatter(float paramFloat1, float paramFloat2)
  {
    ChartData localChartData = this.mData;
    if ((localChartData != null) && (localChartData.getEntryCount() >= 2)) {
      paramFloat1 = Math.abs(paramFloat2 - paramFloat1);
    } else {
      paramFloat1 = Math.max(Math.abs(paramFloat1), Math.abs(paramFloat2));
    }
    int i = Utils.getDecimals(paramFloat1);
    this.mDefaultValueFormatter.setup(i);
  }
  
  public boolean valuesToHighlight()
  {
    Highlight[] arrayOfHighlight = this.mIndicesToHighlight;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (arrayOfHighlight != null)
    {
      bool2 = bool1;
      if (arrayOfHighlight.length > 0) {
        if (arrayOfHighlight[0] == null) {
          bool2 = bool1;
        } else {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\charts\Chart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */