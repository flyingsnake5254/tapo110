package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.wdullaer.materialdatetimepicker.b;
import com.wdullaer.materialdatetimepicker.c;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public abstract class MonthView
  extends View
{
  protected static int c = 32;
  protected static int d = 1;
  protected static int f;
  protected static int p0;
  protected static int p1;
  protected static int q;
  protected static int x;
  protected static int y;
  protected static int z;
  private String H3;
  private String I3;
  protected Paint J3;
  protected Paint K3;
  protected Paint L3;
  protected Paint M3;
  private final StringBuilder N3;
  protected int O3;
  protected int P3;
  protected int Q3;
  protected int R3;
  protected int S3;
  protected int T3;
  protected int U3;
  protected boolean V3;
  protected int W3;
  protected int X3;
  protected int Y3;
  protected int Z3;
  protected int a4;
  protected int b4;
  protected int c4;
  private final Calendar d4;
  protected final Calendar e4;
  private final MonthViewTouchHelper f4;
  protected int g4;
  protected a h4;
  private boolean i4;
  protected int j4;
  protected int k4;
  protected int l4;
  protected int m4;
  protected int n4;
  protected int o4;
  protected a p2;
  protected int p3;
  protected int p4;
  private SimpleDateFormat q4;
  private int r4;
  
  public MonthView(Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  public MonthView(Context paramContext, AttributeSet paramAttributeSet, a parama)
  {
    super(paramContext, paramAttributeSet);
    int i = 0;
    this.p3 = 0;
    this.O3 = -1;
    this.P3 = -1;
    this.Q3 = -1;
    this.U3 = c;
    this.V3 = false;
    this.W3 = -1;
    this.X3 = -1;
    this.Y3 = 1;
    this.Z3 = 7;
    this.a4 = 7;
    this.b4 = -1;
    this.c4 = -1;
    this.g4 = 6;
    this.r4 = 0;
    this.p2 = parama;
    paramAttributeSet = paramContext.getResources();
    this.e4 = Calendar.getInstance(this.p2.m(), this.p2.c());
    this.d4 = Calendar.getInstance(this.p2.m(), this.p2.c());
    this.H3 = paramAttributeSet.getString(c.mdtp_day_of_week_label_typeface);
    this.I3 = paramAttributeSet.getString(c.mdtp_sans_serif);
    parama = this.p2;
    int j = i;
    if (parama != null)
    {
      j = i;
      if (parama.h()) {
        j = 1;
      }
    }
    if (j != 0)
    {
      this.j4 = ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_date_picker_text_normal_dark_theme);
      this.l4 = ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_date_picker_month_day_dark_theme);
      this.o4 = ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_date_picker_text_disabled_dark_theme);
      this.n4 = ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_date_picker_text_highlighted_dark_theme);
    }
    else
    {
      this.j4 = ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_date_picker_text_normal);
      this.l4 = ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_date_picker_month_day);
      this.o4 = ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_date_picker_text_disabled);
      this.n4 = ContextCompat.getColor(paramContext, com.wdullaer.materialdatetimepicker.a.mdtp_date_picker_text_highlighted);
    }
    j = com.wdullaer.materialdatetimepicker.a.mdtp_white;
    this.k4 = ContextCompat.getColor(paramContext, j);
    this.m4 = this.p2.g();
    this.p4 = ContextCompat.getColor(paramContext, j);
    this.N3 = new StringBuilder(50);
    f = paramAttributeSet.getDimensionPixelSize(b.mdtp_day_number_size);
    q = paramAttributeSet.getDimensionPixelSize(b.mdtp_month_label_size);
    x = paramAttributeSet.getDimensionPixelSize(b.mdtp_month_day_label_text_size);
    y = paramAttributeSet.getDimensionPixelOffset(b.mdtp_month_list_item_header_height);
    z = paramAttributeSet.getDimensionPixelSize(b.mdtp_day_number_select_circle_radius);
    p0 = paramAttributeSet.getDimensionPixelSize(b.mdtp_day_highlight_circle_radius);
    p1 = paramAttributeSet.getDimensionPixelSize(b.mdtp_day_highlight_circle_margin);
    if (this.p2.getVersion() == DatePickerDialog.Version.VERSION_1) {
      this.U3 = ((paramAttributeSet.getDimensionPixelOffset(b.mdtp_date_picker_view_animator_height) - getMonthHeaderSize()) / 6);
    } else {
      this.U3 = ((paramAttributeSet.getDimensionPixelSize(b.mdtp_date_picker_view_animator_height_v2) - getMonthHeaderSize()) / 6);
    }
    paramContext = getMonthViewTouchHelper();
    this.f4 = paramContext;
    ViewCompat.setAccessibilityDelegate(this, paramContext);
    ViewCompat.setImportantForAccessibility(this, 1);
    this.i4 = true;
    l();
  }
  
  private int b()
  {
    int i = h();
    int j = this.a4;
    int k = this.Z3;
    int m = (i + j) / k;
    if ((i + j) % k > 0) {
      i = 1;
    } else {
      i = 0;
    }
    return m + i;
  }
  
  @NonNull
  private String getMonthAndYearString()
  {
    Object localObject = this.p2.c();
    String str;
    if (Build.VERSION.SDK_INT < 18) {
      str = getContext().getResources().getString(c.mdtp_date_v1_monthyear);
    } else {
      str = DateFormat.getBestDateTimePattern((Locale)localObject, "MMMM yyyy");
    }
    localObject = new SimpleDateFormat(str, (Locale)localObject);
    ((SimpleDateFormat)localObject).setTimeZone(this.p2.m());
    ((SimpleDateFormat)localObject).applyLocalizedPattern(str);
    this.N3.setLength(0);
    return ((SimpleDateFormat)localObject).format(this.d4.getTime());
  }
  
  private String k(Calendar paramCalendar)
  {
    Locale localLocale = this.p2.c();
    if (Build.VERSION.SDK_INT < 18)
    {
      Object localObject = new SimpleDateFormat("E", localLocale).format(paramCalendar.getTime());
      String str = ((String)localObject).toUpperCase(localLocale).substring(0, 1);
      int i;
      if ((localLocale.equals(Locale.CHINA)) || (localLocale.equals(Locale.CHINESE)) || (localLocale.equals(Locale.SIMPLIFIED_CHINESE)) || (localLocale.equals(Locale.TRADITIONAL_CHINESE)))
      {
        i = ((String)localObject).length();
        str = ((String)localObject).substring(i - 1, i);
      }
      if ((localLocale.getLanguage().equals("he")) || (localLocale.getLanguage().equals("iw"))) {
        if (this.e4.get(7) != 7)
        {
          i = ((String)localObject).length();
          str = ((String)localObject).substring(i - 2, i - 1);
        }
        else
        {
          str = ((String)localObject).toUpperCase(localLocale).substring(0, 1);
        }
      }
      if (localLocale.getLanguage().equals("ca")) {
        str = ((String)localObject).toLowerCase().substring(0, 2);
      }
      localObject = str;
      if (localLocale.getLanguage().equals("es"))
      {
        localObject = str;
        if (paramCalendar.get(7) == 4) {
          localObject = "X";
        }
      }
      return (String)localObject;
    }
    if (this.q4 == null) {
      this.q4 = new SimpleDateFormat("EEEEE", localLocale);
    }
    return this.q4.format(paramCalendar.getTime());
  }
  
  private void n(int paramInt)
  {
    if (this.p2.f(this.S3, this.R3, paramInt)) {
      return;
    }
    a locala = this.h4;
    if (locala != null) {
      locala.k(this, new MonthAdapter.a(this.S3, this.R3, paramInt, this.p2.m()));
    }
    this.f4.sendEventForVirtualView(paramInt, 1);
  }
  
  private boolean p(int paramInt, Calendar paramCalendar)
  {
    int i = this.S3;
    boolean bool = true;
    if ((i != paramCalendar.get(1)) || (this.R3 != paramCalendar.get(2)) || (paramInt != paramCalendar.get(5))) {
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    this.f4.a();
  }
  
  public abstract void d(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  public boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    boolean bool;
    if ((!this.f4.dispatchHoverEvent(paramMotionEvent)) && (!super.dispatchHoverEvent(paramMotionEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void e(Canvas paramCanvas)
  {
    int i = getMonthHeaderSize();
    int j = x / 2;
    int k = (this.T3 - this.p3 * 2) / (this.Z3 * 2);
    for (int m = 0;; m++)
    {
      int n = this.Z3;
      if (m >= n) {
        break;
      }
      int i1 = this.p3;
      int i2 = this.Y3;
      this.e4.set(7, (i2 + m) % n);
      paramCanvas.drawText(k(this.e4), (m * 2 + 1) * k + i1, i - j, this.M3);
    }
  }
  
  protected void f(Canvas paramCanvas)
  {
    int i = (this.U3 + f) / 2;
    int j = d;
    int k = getMonthHeaderSize();
    float f1 = (this.T3 - this.p3 * 2) / (this.Z3 * 2.0F);
    int m = h();
    k = i - j + k;
    i = 1;
    while (i <= this.a4)
    {
      int n = (int)((m * 2 + 1) * f1 + this.p3);
      int i1 = this.U3;
      int i2 = (f + i1) / 2;
      int i3 = d;
      float f2 = n;
      j = (int)(f2 - f1);
      int i5 = (int)(f2 + f1);
      i3 = k - (i2 - i3);
      d(paramCanvas, this.S3, this.R3, i, n, k, j, i5, i3, i3 + i1);
      i5 = m + 1;
      j = k;
      m = i5;
      if (i5 == this.Z3)
      {
        j = k + this.U3;
        m = 0;
      }
      i++;
      k = j;
    }
  }
  
  protected void g(Canvas paramCanvas)
  {
    int i = (this.T3 + this.p3 * 2) / 2;
    int j = (getMonthHeaderSize() - x) / 2;
    paramCanvas.drawText(getMonthAndYearString(), i, j, this.K3);
  }
  
  public MonthAdapter.a getAccessibilityFocus()
  {
    int i = this.f4.getAccessibilityFocusedVirtualViewId();
    if (i >= 0) {
      return new MonthAdapter.a(this.S3, this.R3, i, this.p2.m());
    }
    return null;
  }
  
  public int getMonth()
  {
    return this.R3;
  }
  
  protected int getMonthHeaderSize()
  {
    return y;
  }
  
  protected MonthViewTouchHelper getMonthViewTouchHelper()
  {
    return new MonthViewTouchHelper(this);
  }
  
  public int getYear()
  {
    return this.S3;
  }
  
  protected int h()
  {
    int i = this.r4;
    int j = this.Y3;
    int k = i;
    if (i < j) {
      k = i + this.Z3;
    }
    return k - j;
  }
  
  public int i(float paramFloat1, float paramFloat2)
  {
    int i = j(paramFloat1, paramFloat2);
    if ((i >= 1) && (i <= this.a4)) {
      return i;
    }
    return -1;
  }
  
  protected int j(float paramFloat1, float paramFloat2)
  {
    int i = this.p3;
    float f1 = i;
    if ((paramFloat1 >= f1) && (paramFloat1 <= this.T3 - i))
    {
      int j = (int)(paramFloat2 - getMonthHeaderSize()) / this.U3;
      return (int)((paramFloat1 - f1) * this.Z3 / (this.T3 - i - this.p3)) - h() + 1 + j * this.Z3;
    }
    return -1;
  }
  
  protected void l()
  {
    Paint localPaint = new Paint();
    this.K3 = localPaint;
    localPaint.setFakeBoldText(true);
    this.K3.setAntiAlias(true);
    this.K3.setTextSize(q);
    this.K3.setTypeface(Typeface.create(this.I3, 1));
    this.K3.setColor(this.j4);
    this.K3.setTextAlign(Paint.Align.CENTER);
    this.K3.setStyle(Paint.Style.FILL);
    localPaint = new Paint();
    this.L3 = localPaint;
    localPaint.setFakeBoldText(true);
    this.L3.setAntiAlias(true);
    this.L3.setColor(this.m4);
    this.L3.setTextAlign(Paint.Align.CENTER);
    this.L3.setStyle(Paint.Style.FILL);
    this.L3.setAlpha(255);
    localPaint = new Paint();
    this.M3 = localPaint;
    localPaint.setAntiAlias(true);
    this.M3.setTextSize(x);
    this.M3.setColor(this.l4);
    this.K3.setTypeface(Typeface.create(this.H3, 1));
    this.M3.setStyle(Paint.Style.FILL);
    this.M3.setTextAlign(Paint.Align.CENTER);
    this.M3.setFakeBoldText(true);
    localPaint = new Paint();
    this.J3 = localPaint;
    localPaint.setAntiAlias(true);
    this.J3.setTextSize(f);
    this.J3.setStyle(Paint.Style.FILL);
    this.J3.setTextAlign(Paint.Align.CENTER);
    this.J3.setFakeBoldText(false);
  }
  
  protected boolean m(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.p2.k(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean o(MonthAdapter.a parama)
  {
    if ((parama.b == this.S3) && (parama.c == this.R3))
    {
      int i = parama.d;
      if (i <= this.a4)
      {
        this.f4.d(i);
        return true;
      }
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    g(paramCanvas);
    e(paramCanvas);
    f(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.U3 * this.g4 + getMonthHeaderSize() + 5);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.T3 = paramInt1;
    this.f4.invalidateRoot();
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      int i = i(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (i >= 0) {
        n(i);
      }
    }
    return true;
  }
  
  public void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == -1) && (paramInt2 == -1)) {
      throw new InvalidParameterException("You must specify month and year for this view");
    }
    this.W3 = paramInt1;
    this.R3 = paramInt3;
    this.S3 = paramInt2;
    Calendar localCalendar = Calendar.getInstance(this.p2.m(), this.p2.c());
    paramInt1 = 0;
    this.V3 = false;
    this.X3 = -1;
    this.d4.set(2, this.R3);
    this.d4.set(1, this.S3);
    this.d4.set(5, 1);
    this.r4 = this.d4.get(7);
    if (paramInt4 != -1) {
      this.Y3 = paramInt4;
    } else {
      this.Y3 = this.d4.getFirstDayOfWeek();
    }
    this.a4 = this.d4.getActualMaximum(5);
    while (paramInt1 < this.a4)
    {
      paramInt2 = paramInt1 + 1;
      paramInt1 = paramInt2;
      if (p(paramInt2, localCalendar))
      {
        this.V3 = true;
        this.X3 = paramInt2;
        paramInt1 = paramInt2;
      }
    }
    this.g4 = b();
    this.f4.invalidateRoot();
  }
  
  public void setAccessibilityDelegate(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    if (!this.i4) {
      super.setAccessibilityDelegate(paramAccessibilityDelegate);
    }
  }
  
  public void setOnDayClickListener(a parama)
  {
    this.h4 = parama;
  }
  
  public void setSelectedDay(int paramInt)
  {
    this.W3 = paramInt;
  }
  
  protected class MonthViewTouchHelper
    extends ExploreByTouchHelper
  {
    private final Rect a = new Rect();
    private final Calendar b = Calendar.getInstance(MonthView.this.p2.m());
    
    MonthViewTouchHelper(View paramView)
    {
      super();
    }
    
    void a()
    {
      int i = getAccessibilityFocusedVirtualViewId();
      if (i != Integer.MIN_VALUE) {
        getAccessibilityNodeProvider(MonthView.this).performAction(i, 128, null);
      }
    }
    
    void b(int paramInt, Rect paramRect)
    {
      MonthView localMonthView = MonthView.this;
      int i = localMonthView.p3;
      int j = localMonthView.getMonthHeaderSize();
      localMonthView = MonthView.this;
      int k = localMonthView.U3;
      int m = (localMonthView.T3 - localMonthView.p3 * 2) / localMonthView.Z3;
      int n = paramInt - 1 + localMonthView.h();
      int i1 = MonthView.this.Z3;
      paramInt = n / i1;
      i += n % i1 * m;
      paramInt = j + paramInt * k;
      paramRect.set(i, paramInt, m + i, k + paramInt);
    }
    
    CharSequence c(int paramInt)
    {
      Object localObject1 = this.b;
      Object localObject2 = MonthView.this;
      ((Calendar)localObject1).set(((MonthView)localObject2).S3, ((MonthView)localObject2).R3, paramInt);
      localObject2 = DateFormat.format("dd MMMM yyyy", this.b.getTimeInMillis());
      localObject1 = MonthView.this;
      if (paramInt == ((MonthView)localObject1).W3) {
        return ((View)localObject1).getContext().getString(c.mdtp_item_is_selected, new Object[] { localObject2 });
      }
      return (CharSequence)localObject2;
    }
    
    void d(int paramInt)
    {
      getAccessibilityNodeProvider(MonthView.this).performAction(paramInt, 64, null);
    }
    
    protected int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      int i = MonthView.this.i(paramFloat1, paramFloat2);
      if (i >= 0) {
        return i;
      }
      return Integer.MIN_VALUE;
    }
    
    protected void getVisibleVirtualViews(List<Integer> paramList)
    {
      for (int i = 1; i <= MonthView.this.a4; i++) {
        paramList.add(Integer.valueOf(i));
      }
    }
    
    protected boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (paramInt2 != 16) {
        return false;
      }
      MonthView.a(MonthView.this, paramInt1);
      return true;
    }
    
    protected void onPopulateEventForVirtualView(int paramInt, @NonNull AccessibilityEvent paramAccessibilityEvent)
    {
      paramAccessibilityEvent.setContentDescription(c(paramInt));
    }
    
    protected void onPopulateNodeForVirtualView(int paramInt, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      b(paramInt, this.a);
      paramAccessibilityNodeInfoCompat.setContentDescription(c(paramInt));
      paramAccessibilityNodeInfoCompat.setBoundsInParent(this.a);
      paramAccessibilityNodeInfoCompat.addAction(16);
      if (paramInt == MonthView.this.W3) {
        paramAccessibilityNodeInfoCompat.setSelected(true);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void k(MonthView paramMonthView, MonthAdapter.a parama);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\date\MonthView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */