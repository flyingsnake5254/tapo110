package com.tplink.iot.view.ipcamera.widget.multiOperationEditText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.legacy.widget.Space;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.a;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.c;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.e;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.b;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.i;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.k;
import java.util.List;

public class MultiOperationInputLayout
  extends LinearLayout
{
  private int H3;
  private boolean I3;
  private CharSequence J3;
  boolean K3;
  private TextView L3;
  private int M3;
  private int N3;
  private int O3;
  private boolean P3;
  private TextView Q3;
  private int R3 = 15;
  private ColorStateList S3;
  private CharSequence T3;
  private View.OnClickListener U3;
  private boolean V3;
  private Drawable W3;
  private CharSequence X3;
  private CheckableImageButton Y3;
  private Drawable Z3;
  private Drawable a4;
  private boolean b4;
  private final FrameLayout c;
  private ColorStateList c4;
  EditText d;
  private boolean d4;
  private PorterDuff.Mode e4;
  private boolean f;
  private boolean f4;
  private View.OnClickListener g4;
  private ColorStateList h4;
  private ColorStateList i4;
  private ColorStateList j4;
  private boolean k4;
  private boolean l4;
  private boolean m4;
  final com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.b n4;
  private boolean o4;
  private int p0;
  private Typeface p1;
  private boolean p2;
  TextView p3;
  private f p4;
  private CharSequence q;
  private boolean q4;
  private boolean r4;
  private boolean s4;
  private int t4;
  private int u4;
  private Paint x;
  private final Rect y = new Rect();
  private LinearLayout z;
  
  public MultiOperationInputLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MultiOperationInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"RestrictedApi"})
  public MultiOperationInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.b localb = new com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.b(this);
    this.n4 = localb;
    e.a(paramContext);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    this.c = localFrameLayout;
    localFrameLayout.setAddStatesFromChildren(true);
    addView(localFrameLayout);
    localb.M(a.b);
    localb.J(new AccelerateInterpolator());
    localb.B(8388659);
    paramAttributeSet = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, com.tplink.iot.b.MultiOperationInputLayout, paramInt, 2132017495);
    this.f = paramAttributeSet.getBoolean(9, true);
    setHint(paramAttributeSet.getText(1));
    this.o4 = paramAttributeSet.getBoolean(8, true);
    if (paramAttributeSet.hasValue(0))
    {
      paramContext = paramAttributeSet.getColorStateList(0);
      this.i4 = paramContext;
      this.h4 = paramContext;
    }
    if (paramAttributeSet.getResourceId(10, -1) != -1) {
      setHintTextAppearance(paramAttributeSet.getResourceId(10, 0));
    }
    this.b4 = paramAttributeSet.getBoolean(17, false);
    this.H3 = paramAttributeSet.getResourceId(7, 0);
    boolean bool1 = paramAttributeSet.getBoolean(6, false);
    boolean bool2 = paramAttributeSet.getBoolean(2, false);
    setCounterMaxLength(paramAttributeSet.getInt(3, -1));
    this.N3 = paramAttributeSet.getResourceId(5, 0);
    this.O3 = paramAttributeSet.getResourceId(4, 0);
    if (paramAttributeSet.hasValue(20)) {
      this.W3 = paramAttributeSet.getDrawable(20);
    } else {
      this.W3 = getResources().getDrawable(2131231403);
    }
    this.V3 = paramAttributeSet.getBoolean(18, false);
    if (paramAttributeSet.hasValue(19)) {
      this.X3 = paramAttributeSet.getText(19);
    } else {
      this.X3 = "";
    }
    this.l4 = paramAttributeSet.getBoolean(25, false);
    if (paramAttributeSet.hasValue(21))
    {
      this.d4 = true;
      this.c4 = paramAttributeSet.getColorStateList(21);
    }
    if (paramAttributeSet.hasValue(22))
    {
      this.f4 = true;
      this.e4 = k.b(paramAttributeSet.getInt(22, -1), null);
    }
    this.t4 = paramAttributeSet.getInt(24, 1);
    this.u4 = paramAttributeSet.getInt(23, 2);
    if (paramAttributeSet.hasValue(12)) {
      this.j4 = paramAttributeSet.getColorStateList(12);
    } else {
      this.j4 = this.h4;
    }
    if (paramAttributeSet.hasValue(13)) {
      this.S3 = paramAttributeSet.getColorStateList(13);
    } else {
      this.S3 = this.h4;
    }
    if (paramAttributeSet.hasValue(15)) {
      this.R3 = paramAttributeSet.getInteger(15, this.R3);
    }
    if (paramAttributeSet.hasValue(16)) {
      this.T3 = paramAttributeSet.getText(16);
    } else {
      this.T3 = "";
    }
    paramAttributeSet.recycle();
    setErrorEnabled(bool1);
    setCounterEnabled(bool2);
    e();
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setAccessibilityDelegate(this, new f());
  }
  
  private void b(TextView paramTextView, int paramInt)
  {
    if (this.z == null)
    {
      Object localObject = new LinearLayout(getContext());
      this.z = ((LinearLayout)localObject);
      ((LinearLayout)localObject).setOrientation(0);
      addView(this.z, -1, -2);
      localObject = new Space(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.z.addView((View)localObject, localLayoutParams);
      if (this.d != null) {
        c();
      }
    }
    this.z.setVisibility(0);
    this.z.addView(paramTextView, paramInt);
    this.p0 += 1;
  }
  
  private void c()
  {
    ViewCompat.setPaddingRelative(this.z, ViewCompat.getPaddingStart(this.d), 0, ViewCompat.getPaddingEnd(this.d), this.d.getPaddingBottom());
  }
  
  private void e()
  {
    if (this.b4)
    {
      Object localObject = this.W3;
      if ((localObject != null) && ((this.d4) || (this.f4)))
      {
        localObject = DrawableCompat.wrap((Drawable)localObject).mutate();
        this.W3 = ((Drawable)localObject);
        if (this.d4) {
          DrawableCompat.setTintList((Drawable)localObject, this.c4);
        }
        if (this.f4) {
          DrawableCompat.setTintMode(this.W3, this.e4);
        }
        localObject = this.Y3;
        if (localObject != null)
        {
          Drawable localDrawable = ((ImageButton)localObject).getDrawable();
          localObject = this.W3;
          if (localDrawable != localObject) {
            this.Y3.setImageDrawable((Drawable)localObject);
          }
        }
      }
    }
  }
  
  private static boolean f(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++) {
      if (paramArrayOfInt[j] == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  private void g(boolean paramBoolean)
  {
    f localf = this.p4;
    if ((localf != null) && (localf.d())) {
      this.p4.b();
    }
    if ((paramBoolean) && (this.o4)) {
      d(1.0F);
    } else {
      this.n4.H(1.0F);
    }
    this.m4 = false;
  }
  
  private void h()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22)) {
      return;
    }
    Drawable localDrawable1 = this.d.getBackground();
    if (localDrawable1 == null) {
      return;
    }
    if (!this.q4)
    {
      Drawable localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        this.q4 = c.a((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
      if (!this.q4)
      {
        ViewCompat.setBackground(this.d, localDrawable2);
        this.q4 = true;
      }
    }
  }
  
  private void i(boolean paramBoolean)
  {
    f localf = this.p4;
    if ((localf != null) && (localf.d())) {
      this.p4.b();
    }
    if ((paramBoolean) && (this.o4)) {
      d(0.0F);
    } else {
      this.n4.H(0.0F);
    }
    this.m4 = true;
  }
  
  private boolean j()
  {
    EditText localEditText = this.d;
    boolean bool;
    if ((localEditText != null) && ((localEditText.getTransformationMethod() instanceof PasswordTransformationMethod))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean k()
  {
    boolean bool;
    if (this.t4 == 3) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean l()
  {
    int i = this.u4;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  private static void n(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = paramViewGroup.getChildAt(j);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup)) {
        n((ViewGroup)localView, paramBoolean);
      }
    }
  }
  
  private void o(TextView paramTextView)
  {
    LinearLayout localLinearLayout = this.z;
    if (localLinearLayout != null)
    {
      localLinearLayout.removeView(paramTextView);
      int i = this.p0 - 1;
      this.p0 = i;
      if (i == 0) {
        this.z.setVisibility(8);
      }
    }
  }
  
  private void p(@Nullable final CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (!this.p2)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    boolean bool = TextUtils.isEmpty(paramCharSequence) ^ true;
    this.I3 = bool;
    if ((this.J3 == paramCharSequence) && (((bool) && (this.p3.getVisibility() == 0)) || ((!this.I3) && (this.p3.getVisibility() != 0)))) {
      return;
    }
    this.J3 = paramCharSequence;
    ViewCompat.animate(this.p3).cancel();
    setShowErrorWithoutErrorText(this.I3);
    if (this.I3)
    {
      this.p3.setText(paramCharSequence);
      this.p3.setVisibility(0);
      if (paramBoolean)
      {
        if (ViewCompat.getAlpha(this.p3) == 1.0F) {
          ViewCompat.setAlpha(this.p3, 0.0F);
        }
        ViewCompat.animate(this.p3).alpha(1.0F).setDuration(200L).setInterpolator(a.d).setListener(new b()).start();
      }
      else
      {
        ViewCompat.setAlpha(this.p3, 1.0F);
      }
    }
    else if (this.p3.getVisibility() == 0)
    {
      if (paramBoolean)
      {
        ViewCompat.animate(this.p3).alpha(0.0F).setDuration(200L).setInterpolator(a.c).setListener(new c(paramCharSequence)).start();
      }
      else
      {
        this.p3.setText(paramCharSequence);
        this.p3.setVisibility(4);
      }
    }
    t();
    v(paramBoolean);
  }
  
  private boolean q()
  {
    boolean bool;
    if (this.t4 == 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean r()
  {
    return k();
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.d == null)
    {
      this.d = paramEditText;
      if (!j()) {
        this.n4.N(this.d.getTypeface());
      }
      this.n4.G(this.d.getTextSize());
      int i = this.d.getGravity();
      this.n4.B(i & 0xFFFFFF8F | 0x30);
      this.n4.F(i);
      this.d.addTextChangedListener(new a());
      if (this.h4 == null) {
        this.h4 = this.d.getHintTextColors();
      }
      if ((this.f) && (TextUtils.isEmpty(this.q)))
      {
        setHint(this.d.getHint());
        this.d.setHint(null);
      }
      if (this.L3 != null) {
        s(this.d.getText().length());
      }
      if (this.z != null) {
        c();
      }
      if (k()) {
        y();
      } else {
        x();
      }
      w(false, true);
      return;
    }
    throw new IllegalArgumentException("We already have an EditText, can only have one");
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    this.q = paramCharSequence;
    this.n4.L(paramCharSequence);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void t()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((EditText)localObject1).getBackground();
    if (localObject2 == null) {
      return;
    }
    h();
    localObject1 = localObject2;
    if (DrawableUtils.canSafelyMutateDrawable((Drawable)localObject2)) {
      localObject1 = ((Drawable)localObject2).mutate();
    }
    if (this.k4)
    {
      ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.n4.j().getDefaultColor(), PorterDuff.Mode.SRC_IN));
    }
    else
    {
      if (this.I3)
      {
        localObject2 = this.p3;
        if (localObject2 != null)
        {
          ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(((TextView)localObject2).getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
          return;
        }
      }
      if (this.P3)
      {
        localObject2 = this.L3;
        if (localObject2 != null)
        {
          ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(((TextView)localObject2).getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
          return;
        }
      }
      if (this.l4)
      {
        ((Drawable)localObject1).setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.n4.j().getDefaultColor(), PorterDuff.Mode.SRC_IN));
      }
      else
      {
        DrawableCompat.clearColorFilter((Drawable)localObject1);
        this.d.refreshDrawableState();
      }
    }
  }
  
  private void u()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    int i;
    if (this.f)
    {
      if (this.x == null) {
        this.x = new Paint();
      }
      this.x.setTypeface(this.n4.l());
      this.x.setTextSize(this.n4.k());
      i = (int)-this.x.ascent();
    }
    else
    {
      i = 0;
    }
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    if (i != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i;
      this.c.requestLayout();
    }
  }
  
  private void x()
  {
    if (this.d == null) {
      return;
    }
    Object localObject1;
    if (q())
    {
      if (this.Q3 == null)
      {
        localObject1 = (TextView)LayoutInflater.from(getContext()).inflate(2131559302, this.c, false);
        this.Q3 = ((TextView)localObject1);
        ((TextView)localObject1).setTextColor(this.S3);
        this.Q3.setText(this.T3);
        this.Q3.setTextSize(this.R3);
        this.Q3.setOnClickListener(this.U3);
        this.c.addView(this.Q3);
      }
      localObject1 = this.d;
      if ((localObject1 != null) && (ViewCompat.getMinimumHeight((View)localObject1) <= 0)) {
        this.d.setMinimumHeight(ViewCompat.getMinimumHeight(this.Q3));
      }
      if (this.Z3 == null) {
        this.Z3 = new ColorDrawable();
      }
      this.Z3.setBounds(0, 0, this.Q3.getMeasuredWidth(), 1);
      localObject1 = TextViewCompat.getCompoundDrawablesRelative(this.d);
      Object localObject2 = localObject1[2];
      Drawable localDrawable = this.Z3;
      if (localObject2 != localDrawable) {
        this.a4 = localObject1[2];
      }
      TextViewCompat.setCompoundDrawablesRelative(this.d, localObject1[0], localObject1[1], localDrawable, localObject1[3]);
      this.Q3.setPadding(this.d.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), this.d.getPaddingBottom());
      this.Q3.setVisibility(0);
    }
    else
    {
      localObject1 = this.Q3;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  private void y()
  {
    if (this.d == null) {
      return;
    }
    Object localObject1;
    if (r())
    {
      if (this.Y3 == null)
      {
        localObject1 = (CheckableImageButton)LayoutInflater.from(getContext()).inflate(2131559303, this.c, false);
        this.Y3 = ((CheckableImageButton)localObject1);
        ((AppCompatImageButton)localObject1).setImageDrawable(this.W3);
        this.Y3.setContentDescription(this.X3);
        this.c.addView(this.Y3);
        setOperationToggleChecked(this.V3);
        if (l()) {
          this.Y3.setOnClickListener(new d());
        } else {
          this.Y3.setOnClickListener(this.g4);
        }
      }
      localObject1 = this.d;
      if ((localObject1 != null) && (ViewCompat.getMinimumHeight((View)localObject1) <= 0)) {
        this.d.setMinimumHeight(ViewCompat.getMinimumHeight(this.Y3));
      }
      this.Y3.setVisibility(0);
      if (this.Z3 == null) {
        this.Z3 = new ColorDrawable();
      }
      this.Z3.setBounds(0, 0, this.Y3.getMeasuredWidth(), 1);
      localObject1 = TextViewCompat.getCompoundDrawablesRelative(this.d);
      Object localObject2 = localObject1[2];
      Drawable localDrawable = this.Z3;
      if (localObject2 != localDrawable) {
        this.a4 = localObject1[2];
      }
      TextViewCompat.setCompoundDrawablesRelative(this.d, localObject1[0], localObject1[1], localDrawable, localObject1[3]);
      this.Y3.setPadding(this.d.getPaddingLeft(), this.d.getPaddingTop(), this.d.getPaddingRight(), this.d.getPaddingBottom());
    }
    else
    {
      localObject1 = this.Y3;
      if ((localObject1 != null) && (((ImageButton)localObject1).getVisibility() == 0)) {
        this.Y3.setVisibility(8);
      }
      if (this.Z3 != null)
      {
        localObject1 = TextViewCompat.getCompoundDrawablesRelative(this.d);
        if (localObject1[2] == this.Z3)
        {
          TextViewCompat.setCompoundDrawablesRelative(this.d, localObject1[0], localObject1[1], this.a4, localObject1[3]);
          this.Z3 = null;
        }
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.c.addView(paramView, localLayoutParams);
      this.c.setLayoutParams(paramLayoutParams);
      u();
      setEditText((EditText)paramView);
    }
    else
    {
      super.addView(paramView, paramInt, paramLayoutParams);
    }
  }
  
  @VisibleForTesting
  void d(float paramFloat)
  {
    if (this.n4.o() == paramFloat) {
      return;
    }
    if (this.p4 == null)
    {
      f localf = k.a();
      this.p4 = localf;
      localf.g(a.a);
      this.p4.e(200L);
      this.p4.a(new e());
    }
    this.p4.f(this.n4.o(), paramFloat);
    this.p4.h();
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.s4 = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.s4 = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.f) {
      this.n4.h(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    if (this.r4) {
      return;
    }
    boolean bool1 = true;
    this.r4 = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if ((!ViewCompat.isLaidOut(this)) || (!isEnabled())) {
      bool1 = false;
    }
    v(bool1);
    t();
    com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.b localb = this.n4;
    boolean bool2;
    if (localb != null) {
      bool2 = localb.K(arrayOfInt) | false;
    } else {
      bool2 = false;
    }
    if (bool2) {
      invalidate();
    }
    this.r4 = false;
  }
  
  public int getCounterMaxLength()
  {
    return this.M3;
  }
  
  @Nullable
  public EditText getEditText()
  {
    return this.d;
  }
  
  @Nullable
  public CharSequence getError()
  {
    CharSequence localCharSequence;
    if (this.p2) {
      localCharSequence = this.J3;
    } else {
      localCharSequence = null;
    }
    return localCharSequence;
  }
  
  @Nullable
  public CharSequence getHint()
  {
    CharSequence localCharSequence;
    if (this.f) {
      localCharSequence = this.q;
    } else {
      localCharSequence = null;
    }
    return localCharSequence;
  }
  
  public TextView getOperationTextView()
  {
    return this.Q3;
  }
  
  public CheckableImageButton getOperationToggleView()
  {
    return this.Y3;
  }
  
  public String getText()
  {
    EditText localEditText = this.d;
    if (localEditText == null) {
      return "";
    }
    return localEditText.getText().toString();
  }
  
  public String getTrimText()
  {
    EditText localEditText = this.d;
    if (localEditText == null) {
      return "";
    }
    return localEditText.getText().toString().trim();
  }
  
  @NonNull
  public Typeface getTypeface()
  {
    return this.p1;
  }
  
  void m()
  {
    int i = this.d.getSelectionEnd();
    if (j())
    {
      this.d.setTransformationMethod(null);
      this.Y3.setChecked(true);
    }
    else
    {
      this.d.setTransformationMethod(PasswordTransformationMethod.getInstance());
      this.Y3.setChecked(false);
    }
    this.d.setSelection(i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.f)
    {
      EditText localEditText = this.d;
      if (localEditText != null)
      {
        Rect localRect = this.y;
        i.a(this, localEditText, localRect);
        paramInt3 = localRect.left + this.d.getCompoundPaddingLeft();
        paramInt1 = localRect.right - this.d.getCompoundPaddingRight();
        this.n4.D(paramInt3, localRect.top + this.d.getCompoundPaddingTop(), paramInt1, localRect.bottom - this.d.getCompoundPaddingBottom());
        this.n4.y(paramInt3, getPaddingTop(), paramInt1, paramInt4 - paramInt2 - getPaddingBottom());
        this.n4.w();
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    y();
    x();
    super.onMeasure(paramInt1, paramInt2);
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
    setError(paramParcelable.c);
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.I3) {
      localSavedState.c = getError();
    }
    return localSavedState;
  }
  
  void s(int paramInt)
  {
    boolean bool1 = this.P3;
    int i = this.M3;
    if (i == -1)
    {
      this.L3.setText(String.valueOf(paramInt));
      this.P3 = false;
    }
    else
    {
      boolean bool2;
      if (paramInt > i) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.P3 = bool2;
      if (bool1 != bool2)
      {
        TextView localTextView = this.L3;
        if (bool2) {
          i = this.O3;
        } else {
          i = this.N3;
        }
        TextViewCompat.setTextAppearance(localTextView, i);
      }
      this.L3.setText(getContext().getString(2131952067, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.M3) }));
    }
    if ((this.d != null) && (bool1 != this.P3))
    {
      v(false);
      t();
    }
  }
  
  public void setCollapsingTextSize(int paramInt)
  {
    this.n4.C(paramInt);
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.K3 != paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = new AppCompatTextView(getContext());
        this.L3 = ((TextView)localObject);
        ((TextView)localObject).setId(2131364200);
        localObject = this.p1;
        if (localObject != null) {
          this.L3.setTypeface((Typeface)localObject);
        }
        this.L3.setMaxLines(1);
        try
        {
          TextViewCompat.setTextAppearance(this.L3, this.N3);
        }
        catch (Exception localException)
        {
          TextViewCompat.setTextAppearance(this.L3, 2132017496);
          this.L3.setTextColor(ContextCompat.getColor(getContext(), 2131100194));
        }
        b(this.L3, -1);
        EditText localEditText = this.d;
        if (localEditText == null) {
          s(0);
        } else {
          s(localEditText.getText().length());
        }
      }
      else
      {
        o(this.L3);
        this.L3 = null;
      }
      this.K3 = paramBoolean;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.M3 != paramInt)
    {
      if (paramInt > 0) {
        this.M3 = paramInt;
      } else {
        this.M3 = -1;
      }
      if (this.K3)
      {
        EditText localEditText = this.d;
        if (localEditText == null) {
          paramInt = 0;
        } else {
          paramInt = localEditText.getText().length();
        }
        s(paramInt);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    n(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setError(@Nullable CharSequence paramCharSequence)
  {
    if ((ViewCompat.isLaidOut(this)) && (isEnabled()))
    {
      TextView localTextView = this.p3;
      if ((localTextView == null) || (!TextUtils.equals(localTextView.getText(), paramCharSequence)))
      {
        bool = true;
        break label41;
      }
    }
    boolean bool = false;
    label41:
    p(paramCharSequence, bool);
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    if (this.p2 != paramBoolean)
    {
      Object localObject = this.p3;
      if (localObject != null) {
        ViewCompat.animate((View)localObject).cancel();
      }
      if (paramBoolean)
      {
        localObject = new AppCompatTextView(getContext());
        this.p3 = ((TextView)localObject);
        ((TextView)localObject).setId(2131364201);
        localObject = this.p1;
        if (localObject != null) {
          this.p3.setTypeface((Typeface)localObject);
        }
      }
    }
    try
    {
      TextViewCompat.setTextAppearance(this.p3, this.H3);
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = this.p3.getTextColors().getDefaultColor();
        if (i == -65281) {}
      }
      else
      {
        i = 0;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;) {}
    }
    i = 1;
    if (i != 0)
    {
      TextViewCompat.setTextAppearance(this.p3, 2132017496);
      this.p3.setTextColor(ContextCompat.getColor(getContext(), 2131100194));
    }
    this.p3.setVisibility(4);
    ViewCompat.setAccessibilityLiveRegion(this.p3, 1);
    b(this.p3, 0);
    break label197;
    this.I3 = false;
    t();
    o(this.p3);
    this.p3 = null;
    label197:
    this.p2 = paramBoolean;
  }
  
  public void setErrorTextAppearance(@StyleRes int paramInt)
  {
    this.H3 = paramInt;
    TextView localTextView = this.p3;
    if (localTextView != null) {
      TextViewCompat.setTextAppearance(localTextView, paramInt);
    }
  }
  
  public void setHint(@Nullable CharSequence paramCharSequence)
  {
    if (this.f)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.o4 = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.f)
    {
      this.f = paramBoolean;
      CharSequence localCharSequence = this.d.getHint();
      if (!this.f)
      {
        if ((!TextUtils.isEmpty(this.q)) && (TextUtils.isEmpty(localCharSequence))) {
          this.d.setHint(this.q);
        }
        setHintInternal(null);
      }
      else if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.q)) {
          setHint(localCharSequence);
        }
        this.d.setHint(null);
      }
      if (this.d != null) {
        u();
      }
    }
  }
  
  public void setHintTextAppearance(@StyleRes int paramInt)
  {
    this.n4.z(paramInt);
    this.i4 = this.n4.j();
    if (this.d != null)
    {
      v(false);
      u();
    }
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    EditText localEditText = this.d;
    if (localEditText != null) {
      localEditText.setOnFocusChangeListener(paramOnFocusChangeListener);
    }
  }
  
  public void setOperationTextViewOnclickListener(View.OnClickListener paramOnClickListener)
  {
    this.U3 = paramOnClickListener;
    TextView localTextView = this.Q3;
    if (localTextView != null) {
      localTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOperationToggleChecked(boolean paramBoolean)
  {
    CheckableImageButton localCheckableImageButton = this.Y3;
    if (localCheckableImageButton != null)
    {
      localCheckableImageButton.setChecked(paramBoolean);
      if (!l()) {
        this.d.setTransformationMethod(null);
      } else if ((paramBoolean) && (j())) {
        this.d.setTransformationMethod(null);
      } else {
        this.d.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
    }
  }
  
  public void setOperationToggleOnclickListener(View.OnClickListener paramOnClickListener)
  {
    if (!l())
    {
      this.g4 = paramOnClickListener;
      CheckableImageButton localCheckableImageButton = this.Y3;
      if (localCheckableImageButton != null) {
        localCheckableImageButton.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  public void setSelection(int paramInt)
  {
    EditText localEditText = this.d;
    if (localEditText != null) {
      localEditText.setSelection(paramInt);
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public void setShowErrorWithoutErrorText(boolean paramBoolean)
  {
    if (this.k4 == paramBoolean) {
      return;
    }
    this.k4 = paramBoolean;
    if (paramBoolean) {
      this.n4.A(this.j4);
    } else if (f(getDrawableState(), 16842908)) {
      this.n4.A(this.i4);
    } else {
      this.n4.A(this.h4);
    }
    Drawable localDrawable1 = this.d.getBackground();
    if (localDrawable1 == null) {
      return;
    }
    h();
    Drawable localDrawable2 = localDrawable1;
    if (DrawableUtils.canSafelyMutateDrawable(localDrawable1)) {
      localDrawable2 = localDrawable1.mutate();
    }
    localDrawable2.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.n4.j().getDefaultColor(), PorterDuff.Mode.SRC_IN));
    invalidate();
  }
  
  public void setText(@StringRes int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setText(String paramString)
  {
    EditText localEditText = this.d;
    if (localEditText != null) {
      localEditText.setText(paramString);
    }
  }
  
  public void setTransformationMethod(TransformationMethod paramTransformationMethod)
  {
    EditText localEditText = this.d;
    if (localEditText != null) {
      localEditText.setTransformationMethod(paramTransformationMethod);
    }
  }
  
  public void setTypeface(@Nullable Typeface paramTypeface)
  {
    if (paramTypeface != this.p1)
    {
      this.p1 = paramTypeface;
      this.n4.N(paramTypeface);
      TextView localTextView = this.L3;
      if (localTextView != null) {
        localTextView.setTypeface(paramTypeface);
      }
      localTextView = this.p3;
      if (localTextView != null) {
        localTextView.setTypeface(paramTypeface);
      }
    }
  }
  
  void v(boolean paramBoolean)
  {
    w(paramBoolean, false);
  }
  
  void w(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = isEnabled();
    Object localObject = this.d;
    int i;
    if ((localObject != null) && (!TextUtils.isEmpty(((EditText)localObject).getText()))) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool2 = f(getDrawableState(), 16842908);
    boolean bool3 = TextUtils.isEmpty(getError());
    localObject = this.h4;
    if (localObject != null) {
      this.n4.E((ColorStateList)localObject);
    }
    if ((bool1) && (this.k4))
    {
      this.n4.A(this.j4);
    }
    else
    {
      if ((bool1) && (this.P3))
      {
        localObject = this.L3;
        if (localObject != null)
        {
          this.n4.A(((TextView)localObject).getTextColors());
          break label191;
        }
      }
      if ((bool1) && (bool2))
      {
        localObject = this.i4;
        if (localObject != null)
        {
          this.n4.A((ColorStateList)localObject);
          break label191;
        }
      }
      localObject = this.h4;
      if (localObject != null) {
        this.n4.A((ColorStateList)localObject);
      }
    }
    label191:
    if ((i == 0) && ((!isEnabled()) || ((!bool2) && (!(true ^ bool3)))))
    {
      if ((paramBoolean2) || (!this.m4)) {
        i(paramBoolean1);
      }
    }
    else if ((paramBoolean2) || (this.m4)) {
      g(paramBoolean1);
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new a());
    CharSequence c;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.c = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TextInputLayout.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" error=");
      localStringBuilder.append(this.c);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.c, paramParcel, paramInt);
    }
    
    static final class a
      implements ParcelableCompatCreatorCallbacks<MultiOperationInputLayout.SavedState>
    {
      public MultiOperationInputLayout.SavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new MultiOperationInputLayout.SavedState(paramParcel, paramClassLoader);
      }
      
      public MultiOperationInputLayout.SavedState[] b(int paramInt)
      {
        return new MultiOperationInputLayout.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      MultiOperationInputLayout localMultiOperationInputLayout = MultiOperationInputLayout.this;
      localMultiOperationInputLayout.v(MultiOperationInputLayout.a(localMultiOperationInputLayout) ^ true);
      localMultiOperationInputLayout = MultiOperationInputLayout.this;
      if (localMultiOperationInputLayout.K3) {
        localMultiOperationInputLayout.s(paramEditable.length());
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class b
    extends ViewPropertyAnimatorListenerAdapter
  {
    b() {}
    
    public void onAnimationStart(View paramView)
    {
      paramView.setVisibility(0);
    }
  }
  
  class c
    extends ViewPropertyAnimatorListenerAdapter
  {
    c(CharSequence paramCharSequence) {}
    
    public void onAnimationEnd(View paramView)
    {
      MultiOperationInputLayout.this.p3.setText(paramCharSequence);
      paramView.setVisibility(4);
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      MultiOperationInputLayout.this.m();
    }
  }
  
  class e
    implements f.b
  {
    e() {}
    
    public void a(f paramf)
    {
      MultiOperationInputLayout.this.n4.H(paramf.c());
    }
  }
  
  private class f
    extends AccessibilityDelegateCompat
  {
    f() {}
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(MultiOperationInputLayout.class.getSimpleName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(MultiOperationInputLayout.class.getSimpleName());
      paramView = MultiOperationInputLayout.this.n4.p();
      if (!TextUtils.isEmpty(paramView)) {
        paramAccessibilityNodeInfoCompat.setText(paramView);
      }
      paramView = MultiOperationInputLayout.this.d;
      if (paramView != null) {
        paramAccessibilityNodeInfoCompat.setLabelFor(paramView);
      }
      paramView = MultiOperationInputLayout.this.p3;
      if (paramView != null) {
        paramView = paramView.getText();
      } else {
        paramView = null;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        paramAccessibilityNodeInfoCompat.setContentInvalid(true);
        paramAccessibilityNodeInfoCompat.setError(paramView);
      }
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = MultiOperationInputLayout.this.n4.p();
      if (!TextUtils.isEmpty(paramView)) {
        paramAccessibilityEvent.getText().add(paramView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\multiOperationEditText\MultiOperationInputLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */