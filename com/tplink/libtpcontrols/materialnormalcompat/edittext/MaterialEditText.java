package com.tplink.libtpcontrols.materialnormalcompat.edittext;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView.BufferType;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;
import com.tplink.libtpcontrols.q0;
import com.tplink.libtpcontrols.u0;
import com.tplink.libtpcontrols.x0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaterialEditText
  extends AppCompatEditText
{
  Paint A4 = new Paint(1);
  TextPaint B4 = new TextPaint(1);
  StaticLayout C4;
  ObjectAnimator D4;
  ObjectAnimator E4;
  ObjectAnimator F4;
  View.OnFocusChangeListener G4;
  private int H3;
  View.OnFocusChangeListener H4;
  private int I3;
  private List<com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b> I4;
  private int J3;
  private com.tplink.libtpcontrols.materialnormalcompat.edittext.c.a J4;
  private int K3;
  private Context K4;
  private int L3;
  private CharSequence L4;
  private int M3;
  private CharSequence M4;
  private int N3;
  private Animator.AnimatorListener N4 = null;
  private int O3;
  private Bitmap O4;
  private int P3;
  private int P4;
  private boolean Q3;
  private int Q4;
  private boolean R3;
  private CharSequence R4;
  private boolean S3;
  private int S4 = 0;
  private int T3;
  private int T4 = 0;
  private int U3;
  private int U4 = 0;
  private int V3;
  private int V4 = 0;
  private float W3;
  private int W4 = 0;
  private float X3;
  private StaticLayout X4;
  private String Y3;
  private boolean Y4;
  private int Z3 = -1;
  private Bitmap[] Z4;
  private String a4;
  private Bitmap[] a5;
  private float b4;
  private boolean b5 = false;
  private int c;
  private boolean c4;
  private int c5 = 0;
  private int d;
  private float d4;
  private int d5 = 0;
  private Typeface e4;
  private int e5 = 0;
  private int f;
  private Typeface f4;
  private int f5 = 0;
  private CharSequence g4;
  private boolean g5 = false;
  private boolean h4;
  private boolean h5 = false;
  private int i4;
  private boolean i5 = false;
  private boolean j4;
  private int j5;
  private boolean k4;
  private String k5;
  private boolean l4;
  private int l5;
  private boolean m4;
  private boolean m5;
  private Bitmap[] n4;
  private e n5;
  private Bitmap[] o4;
  private int p0;
  private int p1;
  private boolean p2;
  private boolean p3;
  private Bitmap[] p4;
  private int q;
  private boolean q4;
  private boolean r4;
  private boolean s4;
  private int t4;
  private int u4;
  private boolean v4;
  private boolean w4;
  private int x;
  private ColorStateList x4;
  private int y;
  private ColorStateList y4;
  private int z;
  private ArgbEvaluator z4 = new ArgbEvaluator();
  
  public MaterialEditText(Context paramContext)
  {
    super(paramContext);
    O(paramContext, null);
  }
  
  public MaterialEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    O(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public MaterialEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    O(paramContext, paramAttributeSet);
  }
  
  private boolean A(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(paramString))
      {
        int i = paramString.charAt(0);
        if ((i < 97) || (i > 122))
        {
          bool2 = bool1;
          if (i >= 65)
          {
            bool2 = bool1;
            if (i > 90) {}
          }
        }
        else
        {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  @TargetApi(16)
  private void C()
  {
    if (f0()) {
      i = this.p4[0].getWidth();
    } else {
      i = 0;
    }
    if (d0()) {
      j = this.Z4[0].getWidth();
    } else {
      j = 0;
    }
    int k = i + j;
    int j = this.c5 + this.d5;
    int i = j;
    if (this.Y4) {
      i = j + (this.e5 + this.f5);
    }
    if (e0()) {
      super.setPaddingRelative(this.K3 + this.f + 0, this.I3 + this.c, this.L3 + this.q + k + this.S4 + i, this.J3 + this.d);
    } else {
      super.setPadding(this.K3 + this.f + 0, this.I3 + this.c, this.L3 + this.q + k + this.S4 + i, this.J3 + this.d);
    }
  }
  
  private StaticLayout D(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return null;
    }
    Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
    TextPaint localTextPaint = this.B4;
    return new StaticLayout(paramCharSequence, localTextPaint, (int)localTextPaint.measureText(paramCharSequence.toString()), localAlignment, 1.0F, 0.0F, true);
  }
  
  private Bitmap E(@DrawableRes int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int i = 1;
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
    int j = Math.max(localOptions.outWidth, localOptions.outHeight);
    int k = this.t4;
    if (j > k) {
      i = j / k;
    }
    localOptions.inSampleSize = i;
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
  }
  
  private Bitmap[] F(@DrawableRes int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int i = 1;
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
    int j = Math.max(localOptions.outWidth, localOptions.outHeight);
    int k = this.t4;
    if (j > k) {
      i = j / k;
    }
    localOptions.inSampleSize = i;
    localOptions.inJustDecodeBounds = false;
    return G(BitmapFactory.decodeResource(getResources(), paramInt, localOptions));
  }
  
  private Bitmap[] G(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap[] arrayOfBitmap = new Bitmap[4];
    arrayOfBitmap[0] = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Canvas localCanvas = new Canvas(arrayOfBitmap[0]);
    int i = this.H3;
    int j;
    if (a.a(i)) {
      j = -16777216;
    } else {
      j = -1979711488;
    }
    localCanvas.drawColor(j | i & 0xFFFFFF, PorterDuff.Mode.SRC_IN);
    arrayOfBitmap[1] = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    new Canvas(arrayOfBitmap[1]).drawColor(this.M3, PorterDuff.Mode.SRC_IN);
    arrayOfBitmap[2] = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    localCanvas = new Canvas(arrayOfBitmap[2]);
    i = this.H3;
    if (a.a(i)) {
      j = 1275068416;
    } else {
      j = 1107296256;
    }
    localCanvas.drawColor(j | 0xFFFFFF & i, PorterDuff.Mode.SRC_IN);
    arrayOfBitmap[3] = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    new Canvas(arrayOfBitmap[3]).drawColor(this.N3, PorterDuff.Mode.SRC_IN);
    if (!paramBitmap.isRecycled()) {
      paramBitmap.recycle();
    }
    return arrayOfBitmap;
  }
  
  private Bitmap[] H(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    int i = this.t4;
    return G(Bitmap.createScaledBitmap(localBitmap, i, i, false));
  }
  
  private Bitmap[] I(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap1 = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Bitmap localBitmap2 = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Bitmap localBitmap3 = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Bitmap localBitmap4 = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    if (!paramBitmap.isRecycled()) {
      paramBitmap.recycle();
    }
    return new Bitmap[] { localBitmap1, localBitmap2, localBitmap3, localBitmap4 };
  }
  
  private Bitmap[] J(@DrawableRes int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    int i = 1;
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
    int j = Math.max(localOptions.outWidth, localOptions.outHeight);
    int k = this.t4;
    if (j > k) {
      i = j / k;
    }
    localOptions.inSampleSize = i;
    localOptions.inJustDecodeBounds = false;
    return I(BitmapFactory.decodeResource(getResources(), paramInt, localOptions));
  }
  
  private ObjectAnimator K(float paramFloat)
  {
    ObjectAnimator localObjectAnimator = this.F4;
    if (localObjectAnimator == null)
    {
      this.F4 = ObjectAnimator.ofFloat(this, "currentBottomLines", new float[] { paramFloat });
    }
    else
    {
      localObjectAnimator.cancel();
      this.F4.setFloatValues(new float[] { paramFloat });
    }
    return this.F4;
  }
  
  private Typeface L(@NonNull String paramString)
  {
    return Typeface.createFromAsset(getContext().getAssets(), paramString);
  }
  
  private int M(int paramInt)
  {
    return b.a(getContext(), paramInt);
  }
  
  private boolean N()
  {
    boolean bool;
    if ((this.O3 <= 0) && (this.P3 <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void O(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.K4 = paramContext;
    if (isInEditMode()) {
      return;
    }
    this.t4 = getResources().getDimensionPixelSize(q0.icon_max_size);
    this.p1 = getResources().getDimensionPixelSize(q0.inner_components_spacing);
    this.T3 = getResources().getDimensionPixelSize(q0.bottom_ellipsis_height);
    this.P4 = getResources().getDimensionPixelSize(q0.error_icon_width);
    this.Q4 = getResources().getDimensionPixelSize(q0.error_icon_height);
    this.T4 = getResources().getDimensionPixelSize(q0.postfix_max_length);
    this.U4 = getResources().getDimensionPixelSize(q0.postfix_min_length);
    this.c5 = M(3);
    this.d5 = M(3);
    this.e5 = M(3);
    this.f5 = M(3);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, x0.MaterialEditText);
    this.x4 = localTypedArray.getColorStateList(x0.MaterialEditText_met_textColor);
    this.y4 = localTypedArray.getColorStateList(x0.MaterialEditText_met_textColorHint);
    this.H3 = localTypedArray.getColor(x0.MaterialEditText_met_baseColor, -16777216);
    Object localObject1 = new TypedValue();
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramContext.getTheme().resolveAttribute(16843827, (TypedValue)localObject1, true);
        i = ((TypedValue)localObject1).data;
      }
      else
      {
        RuntimeException localRuntimeException = new java/lang/RuntimeException;
        localRuntimeException.<init>("SDK_INT less than LOLLIPOP");
        throw localRuntimeException;
      }
    }
    catch (Exception localException2)
    {
      try
      {
        i = getResources().getIdentifier("colorPrimary", "attr", getContext().getPackageName());
        if (i != 0)
        {
          paramContext.getTheme().resolveAttribute(i, (TypedValue)localObject1, true);
          i = ((TypedValue)localObject1).data;
        }
        else
        {
          localObject1 = new java/lang/RuntimeException;
          ((RuntimeException)localObject1).<init>("colorPrimary not found");
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException1)
      {
        i = this.H3;
      }
      this.M3 = localTypedArray.getColor(x0.MaterialEditText_met_primaryColor, i);
      setFloatingLabelInternal(localTypedArray.getInt(x0.MaterialEditText_met_floatingLabel, 0));
      this.N3 = localTypedArray.getColor(x0.MaterialEditText_met_errorColor, Color.parseColor("#e7492E"));
      this.O3 = localTypedArray.getInt(x0.MaterialEditText_met_minCharacters, 0);
      this.P3 = localTypedArray.getInt(x0.MaterialEditText_met_maxCharacters, 0);
      this.Q3 = localTypedArray.getBoolean(x0.MaterialEditText_met_singleLineEllipsis, false);
      this.Y3 = localTypedArray.getString(x0.MaterialEditText_met_helperText);
      this.Z3 = localTypedArray.getColor(x0.MaterialEditText_met_helperTextColor, -1);
      this.V3 = localTypedArray.getInt(x0.MaterialEditText_met_minBottomTextLines, 0);
      Object localObject2 = localTypedArray.getString(x0.MaterialEditText_met_accentTypeface);
      if ((localObject2 != null) && (!isInEditMode()))
      {
        localObject2 = L((String)localObject2);
        this.e4 = ((Typeface)localObject2);
        this.B4.setTypeface((Typeface)localObject2);
      }
      localObject2 = localTypedArray.getString(x0.MaterialEditText_met_typeface);
      if ((localObject2 != null) && (!isInEditMode()))
      {
        localObject2 = L((String)localObject2);
        this.f4 = ((Typeface)localObject2);
        setTypeface((Typeface)localObject2);
      }
      localObject2 = localTypedArray.getString(x0.MaterialEditText_met_floatingLabelText);
      this.g4 = ((CharSequence)localObject2);
      if (localObject2 == null) {
        this.g4 = getHint();
      }
      this.p0 = localTypedArray.getDimensionPixelSize(x0.MaterialEditText_met_floatingLabelPadding, this.p1);
      this.x = localTypedArray.getDimensionPixelSize(x0.MaterialEditText_met_floatingLabelTextSize, getResources().getDimensionPixelSize(q0.floating_label_text_size));
      this.y = localTypedArray.getColor(x0.MaterialEditText_met_floatingLabelTextColor, -1);
      this.l4 = localTypedArray.getBoolean(x0.MaterialEditText_met_floatingLabelAnimating, true);
      this.z = localTypedArray.getDimensionPixelSize(x0.MaterialEditText_met_bottomTextSize, getResources().getDimensionPixelSize(q0.bottom_text_size));
      this.h4 = localTypedArray.getBoolean(x0.MaterialEditText_met_hideUnderline, false);
      this.i4 = localTypedArray.getColor(x0.MaterialEditText_met_underlineColor, -1);
      this.j4 = localTypedArray.getBoolean(x0.MaterialEditText_met_autoValidate, false);
      this.n4 = F(localTypedArray.getResourceId(x0.MaterialEditText_met_iconLeft, -1));
      this.o4 = F(localTypedArray.getResourceId(x0.MaterialEditText_met_iconRight, -1));
      this.r4 = localTypedArray.getBoolean(x0.MaterialEditText_met_clearButton, true);
      this.u4 = localTypedArray.getDimensionPixelSize(x0.MaterialEditText_met_iconPadding, M(16));
      this.R3 = localTypedArray.getBoolean(x0.MaterialEditText_met_floatingLabelAlwaysShown, false);
      this.S3 = localTypedArray.getBoolean(x0.MaterialEditText_met_helperTextAlwaysShown, false);
      this.q4 = localTypedArray.getBoolean(x0.MaterialEditText_met_validateOnFocusLost, false);
      this.m4 = localTypedArray.getBoolean(x0.MaterialEditText_met_checkCharactersCountAtBeginning, true);
      this.R4 = localTypedArray.getString(x0.MaterialEditText_met_postfix_text);
      this.V4 = localTypedArray.getColor(x0.MaterialEditText_met_postfix_textColor, -1);
      this.l5 = localTypedArray.getInt(x0.MaterialEditText_met_disable_underline_style, 0);
      this.m5 = localTypedArray.getBoolean(x0.MaterialEditText_met_enable_error_icon, true);
      this.W4 = ((int)getTextSize());
      if (this.V4 < 0) {
        this.V4 = this.H3;
      }
      this.O4 = E(localTypedArray.getResourceId(x0.MaterialEditText_met_iconError, u0.alert_triangle_met));
      if (!this.m5) {
        this.O4 = null;
      }
      int i = localTypedArray.getInt(x0.MaterialEditText_met_icon_color_mode, 0);
      this.j5 = i;
      int j;
      if (i == 0)
      {
        this.p4 = J(localTypedArray.getResourceId(x0.MaterialEditText_met_iconClear, u0.clear_cross_met));
        i = localTypedArray.getResourceId(x0.MaterialEditText_met_iconEyeOn, -1);
        j = localTypedArray.getResourceId(x0.MaterialEditText_met_iconEyeOff, -1);
        if ((i > 0) && (j > 0))
        {
          this.Z4 = J(j);
          this.a5 = J(i);
        }
        else
        {
          this.Z4 = J(u0.eyeball_invisible_met);
          this.a5 = J(u0.eyeball_visible_met);
        }
      }
      else
      {
        this.p4 = F(localTypedArray.getResourceId(x0.MaterialEditText_met_iconClear, u0.ic_clear));
        i = localTypedArray.getResourceId(x0.MaterialEditText_met_iconEyeOn, -1);
        j = localTypedArray.getResourceId(x0.MaterialEditText_met_iconEyeOff, -1);
        if ((i > 0) && (j > 0))
        {
          this.Z4 = F(j);
          this.a5 = F(i);
        }
        else
        {
          this.Z4 = F(u0.ic_visibility_off);
          this.a5 = F(u0.ic_visibility);
        }
      }
      this.Y4 = localTypedArray.getBoolean(x0.MaterialEditText_met_password, false);
      i = localTypedArray.getDimensionPixelSize(x0.MaterialEditText_met_clear_left, 0);
      if (i > 0) {
        this.c5 = i;
      }
      i = localTypedArray.getDimensionPixelSize(x0.MaterialEditText_met_clear_right, 0);
      if (i > 0) {
        this.d5 = i;
      }
      i = localTypedArray.getDimensionPixelSize(x0.MaterialEditText_met_eyeball_left, 0);
      if (i > 0) {
        this.e5 = i;
      }
      i = localTypedArray.getDimensionPixelSize(x0.MaterialEditText_met_eyeball_right, 0);
      if (i > 0) {
        this.f5 = i;
      }
      localTypedArray.recycle();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842965, 16842966, 16842967, 16842968, 16842969 });
      i = paramContext.getDimensionPixelSize(0, 0);
      this.K3 = paramContext.getDimensionPixelSize(1, i);
      this.I3 = paramContext.getDimensionPixelSize(2, i);
      this.L3 = paramContext.getDimensionPixelSize(3, i);
      this.J3 = paramContext.getDimensionPixelSize(4, i);
      paramContext.recycle();
      if (Build.VERSION.SDK_INT >= 16) {
        setBackground(null);
      } else {
        setBackgroundDrawable(null);
      }
      if (this.Q3)
      {
        paramContext = getTransformationMethod();
        setSingleLine();
        setTransformationMethod(paramContext);
      }
      R();
      T();
      W();
      V();
      U();
      X();
      Q();
      Y();
      y();
      S();
      P();
    }
  }
  
  private void P()
  {
    p();
    if ((this.P3 > 0) || (this.O3 > 0)) {
      this.i5 = true;
    }
  }
  
  private void Q()
  {
    addTextChangedListener(new c());
    d locald = new d();
    this.G4 = locald;
    super.setOnFocusChangeListener(locald);
  }
  
  private void R()
  {
    if (e0()) {
      setGravity(5);
    }
  }
  
  private void S()
  {
    this.N4 = new b();
  }
  
  private void T()
  {
    int i = this.O3;
    int j = 0;
    if ((i <= 0) && (this.P3 <= 0) && (!this.Q3) && (this.a4 == null) && (this.Y3 == null) && (this.k5 == null)) {
      i = 0;
    } else {
      i = 1;
    }
    int k = this.V3;
    if (k > 0) {
      j = k;
    } else if (i != 0) {
      j = 1;
    }
    this.U3 = j;
    this.W3 = j;
  }
  
  private void U()
  {
    if (this.p2) {
      i = this.x + this.p0;
    } else {
      i = this.p0;
    }
    this.c = i;
    this.B4.setTextSize(this.z);
    Object localObject = this.B4.getFontMetrics();
    int j = (int)((((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent) * this.W3);
    if (this.h4) {
      i = this.p1;
    } else {
      i = this.p1 * 2;
    }
    int i = j + i;
    this.d = i;
    localObject = this.O4;
    if (localObject != null) {
      this.d = (i + ((Bitmap)localObject).getHeight() / 3);
    }
    localObject = this.n4;
    j = 0;
    if (localObject == null) {
      i = 0;
    } else {
      i = this.u4;
    }
    this.f = i;
    if (this.o4 == null) {
      i = j;
    } else {
      i = this.u4;
    }
    this.q = i;
    C();
  }
  
  private void V()
  {
    x();
  }
  
  private void W()
  {
    this.S4 = 0;
    if (!TextUtils.isEmpty(this.R4))
    {
      int i = (int)getPaint().measureText(this.R4.toString());
      this.S4 = i;
      int j = this.T4;
      if (i > j) {
        this.S4 = j;
      }
      j = this.S4;
      i = this.U4;
      if (j < i) {
        this.S4 = i;
      }
    }
    else
    {
      this.S4 = 0;
    }
  }
  
  private void X()
  {
    if (!TextUtils.isEmpty(getText()))
    {
      g0();
      Selection.setSelection(getText(), getText().length());
      this.b4 = 1.0F;
      this.c4 = true;
      this.L4 = getHint();
      this.M4 = getHint();
      setHint("");
    }
    else
    {
      g0();
      this.L4 = getHint();
      this.M4 = getHint();
    }
    h0();
  }
  
  private void Y()
  {
    addTextChangedListener(new a());
  }
  
  private boolean Z(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = getScrollX();
    paramMotionEvent = this.n4;
    boolean bool1 = false;
    int j;
    if (paramMotionEvent == null) {
      j = 0;
    } else {
      j = this.u4;
    }
    int k = getScrollX();
    if (this.o4 == null) {
      m = getWidth();
    } else {
      m = getWidth() - this.u4;
    }
    int n = s();
    int i1 = this.p4[0].getWidth();
    int i2 = this.c5;
    int i3 = this.d5;
    int i6 = u();
    if (e0()) {
      j = i + j + i6 + this.S4 - getScrollX();
    } else {
      j = k + m - n - this.S4 - getScrollX();
    }
    int m = t() - M(3);
    boolean bool2 = bool1;
    if (f1 >= j)
    {
      bool2 = bool1;
      if (f1 < j + (i1 + i2 + i3))
      {
        bool2 = bool1;
        if (f2 >= m)
        {
          bool2 = bool1;
          if (f2 < m + this.p4[0].getHeight() + M(3)) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  private boolean a0(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = getScrollX();
    paramMotionEvent = this.n4;
    boolean bool1 = false;
    int j;
    if (paramMotionEvent == null) {
      j = 0;
    } else {
      j = this.u4;
    }
    int k = getScrollX();
    if (this.o4 == null) {
      m = getWidth();
    } else {
      m = getWidth() - this.u4;
    }
    int n = u();
    int i1 = this.Z4[0].getWidth();
    int i2 = this.e5;
    int i3 = this.f5;
    if (e0()) {
      j = i + j + this.S4 - getScrollX();
    } else {
      j = k + m - n - this.S4 - getScrollX();
    }
    int m = v() - M(3);
    boolean bool2 = bool1;
    if (f1 >= j)
    {
      bool2 = bool1;
      if (f1 < j + (i1 + i2 + i3))
      {
        bool2 = bool1;
        if (f2 >= m)
        {
          bool2 = bool1;
          if (f2 < m + this.p4[0].getHeight() + M(3)) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  private boolean c0()
  {
    boolean bool;
    if ((this.a4 == null) && (this.k5 == null) && (b0())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @TargetApi(17)
  private boolean e0()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 17) {
      return false;
    }
    if (getResources().getConfiguration().getLayoutDirection() == 1) {
      bool = true;
    }
    return bool;
  }
  
  private void g0()
  {
    ColorStateList localColorStateList = this.y4;
    if (localColorStateList == null) {
      setHintTextColor(this.H3 & 0xFFFFFF | 0x44000000);
    } else {
      setHintTextColor(localColorStateList);
    }
  }
  
  private int getBottomEllipsisWidth()
  {
    int i;
    if (this.Q3) {
      i = this.T3 * 5 + M(4);
    } else {
      i = 0;
    }
    return i;
  }
  
  private int getBottomTextLeftOffset()
  {
    int i;
    if (e0()) {
      i = getCharactersCounterWidth();
    } else {
      i = getBottomEllipsisWidth();
    }
    return i;
  }
  
  private int getBottomTextRightOffset()
  {
    int i;
    if (e0()) {
      i = getBottomEllipsisWidth();
    } else {
      i = getCharactersCounterWidth();
    }
    return i;
  }
  
  private int getButtonsCount()
  {
    return f0();
  }
  
  private String getCharactersCounterText()
  {
    Object localObject;
    int i;
    if (this.O3 <= 0)
    {
      if (e0())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.P3);
        ((StringBuilder)localObject).append(" / ");
        i = z(getText());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(z(getText()));
        ((StringBuilder)localObject).append(" / ");
        i = this.P3;
      }
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (this.P3 <= 0)
    {
      if (e0())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("+");
        ((StringBuilder)localObject).append(this.O3);
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(z(getText()));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(z(getText()));
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(this.O3);
        ((StringBuilder)localObject).append("+");
      }
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      if (e0())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.P3);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(this.O3);
        ((StringBuilder)localObject).append(" / ");
        i = z(getText());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(z(getText()));
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(this.O3);
        ((StringBuilder)localObject).append("-");
        i = this.P3;
      }
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  private int getCharactersCounterWidth()
  {
    int i;
    if (N()) {
      i = (int)this.B4.measureText(getCharactersCounterText());
    } else {
      i = 0;
    }
    return i;
  }
  
  private ObjectAnimator getLabelAnimator()
  {
    if (this.D4 == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "floatingLabelFraction", new float[] { 0.0F, 1.0F });
      this.D4 = localObjectAnimator;
      localObject = this.N4;
      if (localObject != null) {
        localObjectAnimator.addListener((Animator.AnimatorListener)localObject);
      }
    }
    Object localObject = this.D4;
    long l;
    if (this.l4) {
      l = 300L;
    } else {
      l = 0L;
    }
    ((ObjectAnimator)localObject).setDuration(l);
    return this.D4;
  }
  
  private ObjectAnimator getLabelFocusAnimator()
  {
    if (this.E4 == null) {
      this.E4 = ObjectAnimator.ofFloat(this, "focusFraction", new float[] { 0.0F, 1.0F });
    }
    return this.E4;
  }
  
  private void h0()
  {
    Object localObject = this.x4;
    if (localObject == null)
    {
      localObject = EditText.EMPTY_STATE_SET;
      int i = this.H3;
      localObject = new ColorStateList(new int[][] { { 16842910 }, localObject }, new int[] { i & 0xFFFFFF | 0xDF000000, i & 0xFFFFFF | 0x44000000 });
      this.x4 = ((ColorStateList)localObject);
      setTextColor((ColorStateList)localObject);
    }
    else
    {
      setTextColor((ColorStateList)localObject);
    }
  }
  
  private boolean p()
  {
    int i = getWidth();
    int j = 0;
    if (i == 0) {
      return false;
    }
    Object localObject1 = this.p4;
    int k;
    if ((localObject1 != null) && (this.Z4 != null))
    {
      if (this.r4) {
        i = localObject1[0].getWidth() + this.c5 + this.d5;
      } else {
        i = 0;
      }
      k = i;
      if (this.Y4)
      {
        int m = this.Z4[0].getWidth() + this.e5 + this.f5;
        k = i;
        i = m;
        break label103;
      }
    }
    else
    {
      k = 0;
    }
    i = 0;
    label103:
    localObject1 = this.O4;
    if (localObject1 != null) {
      j = ((Bitmap)localObject1).getWidth();
    }
    i = k + i + this.S4 / 2 - j;
    this.B4.setTextSize(this.z);
    if ((this.a4 == null) && (this.Y3 == null))
    {
      i = this.U3;
    }
    else
    {
      if (((getGravity() & 0x5) != 5) && (!e0()))
      {
        if ((getGravity() & 0x3) == 3) {
          localObject1 = Layout.Alignment.ALIGN_NORMAL;
        } else {
          localObject1 = Layout.Alignment.ALIGN_CENTER;
        }
      }
      else {
        localObject1 = Layout.Alignment.ALIGN_OPPOSITE;
      }
      Object localObject2 = localObject1;
      if (e0())
      {
        localObject2 = localObject1;
        if (!A(this.a4)) {
          localObject2 = Layout.Alignment.ALIGN_NORMAL;
        }
      }
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject1 = this.a4;
        if (localObject1 == null) {
          localObject1 = this.Y3;
        }
        this.C4 = new StaticLayout((CharSequence)localObject1, this.B4, getWidth() - getBottomTextLeftOffset() - getBottomTextRightOffset() - getPaddingStart() - getPaddingEnd() + i, (Layout.Alignment)localObject2, 1.0F, 0.0F, true);
      }
      else
      {
        localObject1 = this.a4;
        if (localObject1 == null) {
          localObject1 = this.Y3;
        }
        this.C4 = new StaticLayout((CharSequence)localObject1, this.B4, getWidth() - getBottomTextLeftOffset() - getBottomTextRightOffset() - getPaddingLeft() - getPaddingRight() + i, (Layout.Alignment)localObject2, 1.0F, 0.0F, true);
      }
      i = Math.max(this.C4.getLineCount(), this.V3);
    }
    float f1 = this.X3;
    float f2 = i;
    if (f1 != f2) {
      K(f2).start();
    }
    this.X3 = f2;
    return true;
  }
  
  private boolean q()
  {
    if (TextUtils.isEmpty(this.R4)) {
      return false;
    }
    this.B4.setTextSize(this.W4);
    this.B4.setColor(this.V4);
    if (!TextUtils.isEmpty(this.R4))
    {
      Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
      this.X4 = new StaticLayout(this.R4, this.B4, this.S4, localAlignment, 1.0F, 0.0F, true);
    }
    return true;
  }
  
  private float r()
  {
    this.B4.setTextSize(this.z);
    Paint.FontMetrics localFontMetrics = this.B4.getFontMetrics();
    float f1 = localFontMetrics.ascent;
    float f2 = localFontMetrics.descent;
    return this.z + f1 + f2;
  }
  
  private int s()
  {
    int i = this.p4[0].getWidth() + this.c5 + this.d5;
    int j = i;
    if (this.Y4) {
      j = i + (this.Z4[0].getWidth() + this.e5 + this.f5);
    }
    return j;
  }
  
  private void setFloatingLabelInternal(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        this.p2 = false;
        this.p3 = false;
      }
      else
      {
        this.p2 = true;
        this.p3 = true;
      }
    }
    else
    {
      this.p2 = true;
      this.p3 = false;
    }
    this.L4 = getHint();
  }
  
  private int t()
  {
    int i = getScrollY();
    int j = getPaddingTop();
    int k = w();
    return i + j + (getLineCount() - 1) * k + (k - this.p4[0].getHeight()) / 2;
  }
  
  private int u()
  {
    boolean bool = this.Y4;
    int i = 0;
    if (bool)
    {
      int j = this.Z4[0].getWidth();
      i = this.e5;
      i = this.f5 + (j + i);
    }
    return i;
  }
  
  private int v()
  {
    int i = getScrollY();
    int j = getPaddingTop();
    int k = w();
    return i + j + (getLineCount() - 1) * k + (k - this.Z4[0].getHeight()) / 2;
  }
  
  private int w()
  {
    int i;
    if (getLineCount() > 0) {
      i = getLineCount();
    } else {
      i = 1;
    }
    return (getHeight() - getPaddingTop() - getPaddingBottom()) / i;
  }
  
  private void x()
  {
    if (this.Y4)
    {
      Typeface localTypeface = getTypeface();
      if (!this.b5)
      {
        setInputType(129);
        setTypeface(localTypeface);
      }
      else
      {
        setInputType(1);
      }
      Selection.setSelection(getText(), getText().length());
    }
  }
  
  private void y()
  {
    boolean bool1 = this.s4;
    boolean bool2 = true;
    if (((!bool1) && (!this.m4)) || (!N()))
    {
      this.k4 = true;
    }
    else
    {
      Editable localEditable = getText();
      int i;
      if (localEditable == null) {
        i = 0;
      } else {
        i = z(localEditable);
      }
      if (i >= this.O3)
      {
        int j = this.P3;
        bool1 = bool2;
        if (j <= 0) {
          break label91;
        }
        if (i <= j)
        {
          bool1 = bool2;
          break label91;
        }
      }
      bool1 = false;
      label91:
      this.k4 = bool1;
    }
  }
  
  private int z(CharSequence paramCharSequence)
  {
    if (this.J4 == null) {
      return paramCharSequence.length();
    }
    throw null;
  }
  
  public void B()
  {
    this.k5 = null;
    postInvalidate();
  }
  
  public boolean b0()
  {
    return this.k4;
  }
  
  public boolean d0()
  {
    return this.Y4;
  }
  
  public boolean f0()
  {
    return this.r4;
  }
  
  @Nullable
  public Typeface getAccentTypeface()
  {
    return this.e4;
  }
  
  public int getBottomTextSize()
  {
    return this.z;
  }
  
  public float getCurrentBottomLines()
  {
    return this.W3;
  }
  
  public int getDisableUnderlineStyle()
  {
    return this.l5;
  }
  
  public CharSequence getError()
  {
    return this.a4;
  }
  
  public int getErrorColor()
  {
    return this.N3;
  }
  
  public float getFloatingLabelFraction()
  {
    return this.b4;
  }
  
  public int getFloatingLabelPadding()
  {
    return this.p0;
  }
  
  public CharSequence getFloatingLabelText()
  {
    return this.g4;
  }
  
  public int getFloatingLabelTextColor()
  {
    return this.y;
  }
  
  public int getFloatingLabelTextSize()
  {
    return this.x;
  }
  
  public float getFocusFraction()
  {
    return this.d4;
  }
  
  public String getHelperText()
  {
    return this.Y3;
  }
  
  public int getHelperTextColor()
  {
    return this.Z3;
  }
  
  public int getInnerPaddingBottom()
  {
    return this.J3;
  }
  
  public int getInnerPaddingLeft()
  {
    return this.K3;
  }
  
  public int getInnerPaddingRight()
  {
    return this.L3;
  }
  
  public int getInnerPaddingTop()
  {
    return this.I3;
  }
  
  public int getMaxCharacters()
  {
    return this.P3;
  }
  
  public int getMinBottomTextLines()
  {
    return this.V3;
  }
  
  public int getMinCharacters()
  {
    return this.O3;
  }
  
  public CharSequence getPostfixText()
  {
    return this.R4;
  }
  
  public Editable getText()
  {
    return super.getText();
  }
  
  public int getUnderlineColor()
  {
    return this.i4;
  }
  
  @Nullable
  public List<com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b> getValidators()
  {
    return this.I4;
  }
  
  public boolean i0()
  {
    Object localObject = this.I4;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      Editable localEditable = getText();
      boolean bool1;
      if (localEditable.length() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = this.I4.iterator();
      boolean bool2 = true;
      boolean bool3;
      com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b localb;
      do
      {
        bool3 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localb = (com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b)((Iterator)localObject).next();
        if ((bool2) && (localb.b(localEditable, bool1))) {
          bool3 = true;
        } else {
          bool3 = false;
        }
        bool2 = bool3;
      } while (bool3);
      setError(localb.a());
      if (bool3) {
        setError(null);
      }
      postInvalidate();
      return bool3;
    }
    return true;
  }
  
  public MaterialEditText o(com.tplink.libtpcontrols.materialnormalcompat.edittext.c.b paramb)
  {
    if (this.I4 == null) {
      this.I4 = new ArrayList();
    }
    this.I4.add(paramb);
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!this.s4) {
      this.s4 = true;
    }
  }
  
  @RequiresApi(api=17)
  protected void onDraw(@NonNull Canvas paramCanvas)
  {
    int i = getScrollX();
    Object localObject1 = this.n4;
    int j = 0;
    int k = 0;
    if (localObject1 == null) {
      m = 0;
    } else {
      m = this.u4;
    }
    i = i + m + getPaddingStart();
    int n = getScrollX();
    if (this.o4 == null) {
      m = getWidth();
    } else {
      m = getWidth() - this.u4;
    }
    n = n + m - this.S4;
    int i1 = getScrollY() + getHeight() - getPaddingBottom();
    int i2 = getScrollY();
    int i3 = getPaddingTop();
    this.A4.setAlpha(255);
    localObject1 = this.n4;
    int i6 = 1;
    int i8;
    int i9;
    if (localObject1 != null)
    {
      if (!c0()) {
        m = 3;
      } else if (!isEnabled()) {
        m = 2;
      } else if (hasFocus()) {
        m = 1;
      } else {
        m = 0;
      }
      localObject1 = localObject1[m];
      i7 = this.u4;
      i8 = ((Bitmap)localObject1).getWidth();
      i9 = this.p1;
      m = ((Bitmap)localObject1).getHeight();
      paramCanvas.drawBitmap((Bitmap)localObject1, i - i7 - i8, i9 + i1 - m, this.A4);
    }
    localObject1 = this.o4;
    if (localObject1 != null)
    {
      if (!c0()) {
        m = 3;
      } else if (!isEnabled()) {
        m = 2;
      } else if (hasFocus()) {
        m = 1;
      } else {
        m = 0;
      }
      localObject1 = localObject1[m];
      i7 = this.u4;
      m = ((Bitmap)localObject1).getWidth();
      i9 = this.p1;
      i8 = ((Bitmap)localObject1).getHeight();
      paramCanvas.drawBitmap((Bitmap)localObject1, i7 + n - m, i9 + i1 - i8, this.A4);
    }
    int m = s();
    int i7 = u();
    if ((hasFocus()) && (this.r4) && (!TextUtils.isEmpty(getText())) && (isEnabled()))
    {
      this.A4.setAlpha(255);
      if (e0()) {
        i8 = this.S4 + i7 + i;
      } else {
        i8 = -m + n;
      }
      localObject1 = this.p4;
      if (!c0()) {
        m = 3;
      } else if (!isEnabled()) {
        m = 2;
      } else if (hasFocus()) {
        m = 1;
      } else {
        m = 0;
      }
      localObject1 = localObject1[m];
      m = t();
      paramCanvas.drawBitmap((Bitmap)localObject1, i8, m, this.A4);
    }
    if ((this.Y4) && (!TextUtils.isEmpty(getText())) && (isEnabled()))
    {
      if (e0()) {
        i8 = this.S4 + i;
      } else {
        i8 = -i7 + n;
      }
      if (this.b5)
      {
        localObject1 = this.a5;
        if (!c0())
        {
          m = 3;
        }
        else if (!isEnabled())
        {
          m = 2;
        }
        else
        {
          m = k;
          if (hasFocus()) {
            m = 1;
          }
        }
        localObject1 = localObject1[m];
      }
      else
      {
        localObject1 = this.Z4;
        if (!c0())
        {
          m = 3;
        }
        else if (!isEnabled())
        {
          m = 2;
        }
        else
        {
          m = j;
          if (hasFocus()) {
            m = 1;
          }
        }
        localObject1 = localObject1[m];
      }
      m = v();
      paramCanvas.drawBitmap((Bitmap)localObject1, i8, m, this.A4);
    }
    float f1;
    float f3;
    if (!this.h4)
    {
      i8 = i1 + this.p1;
      if (e0())
      {
        m = this.S4;
        i1 = m + n;
        m = i + m;
      }
      else
      {
        m = i;
        i1 = n;
      }
      if (!c0())
      {
        this.A4.setColor(this.N3);
        paramCanvas.drawRect(m, i8, i1, M(2) + i8, this.A4);
      }
      else
      {
        j = i8;
        if (!isEnabled())
        {
          localObject1 = this.A4;
          k = this.i4;
          if (k == -1) {
            k = this.H3 & 0xFFFFFF | 0x44000000;
          }
          ((Paint)localObject1).setColor(k);
          if (this.l5 == 1)
          {
            f1 = M(1);
            for (f2 = 0.0F; f2 < getWidth(); f2 += f1 * 3.0F)
            {
              f3 = m + f2;
              paramCanvas.drawRect(f3, j, f3 + f1, M(1) + j, this.A4);
            }
          }
          paramCanvas.drawRect(m, j + M(1) / 2, i1, M(1) * 3 / 2 + j, this.A4);
        }
        else if (hasFocus())
        {
          this.A4.setColor(this.M3);
          paramCanvas.drawRect(m, j, i1, M(2) + j, this.A4);
        }
        else
        {
          localObject1 = this.A4;
          k = this.i4;
          if (k == -1) {
            k = this.H3;
          }
          ((Paint)localObject1).setColor(k);
          paramCanvas.drawRect(m, j + M(1) / 2, i1, M(1) * 3 / 2 + j, this.A4);
        }
      }
    }
    else
    {
      i8 = i1;
    }
    if ((this.X4 != null) && (!TextUtils.isEmpty(this.R4)))
    {
      m = i2 + i3 + (getLineCount() - 1) * w();
      this.B4.setColor(this.V4);
      this.B4.setTextSize(this.W4);
      paramCanvas.save();
      if (e0()) {
        paramCanvas.translate(i, m);
      } else {
        paramCanvas.translate(n, m);
      }
      this.X4.draw(paramCanvas);
      paramCanvas.restore();
    }
    float f2 = r();
    Object localObject2;
    if (((hasFocus()) && (N())) || ((!b0()) && (this.a4 == null)))
    {
      this.B4.setTextSize(this.z);
      localObject1 = this.B4;
      if (b0()) {
        m = this.H3;
      } else {
        m = this.N3;
      }
      ((TextPaint)localObject1).setColor(m);
      localObject1 = getCharactersCounterText();
      localObject2 = D((CharSequence)localObject1);
      if (localObject2 != null)
      {
        paramCanvas.save();
        if (e0()) {
          paramCanvas.translate(this.S4 + i, this.p1 + i8 - f2);
        } else {
          paramCanvas.translate(n - this.B4.measureText((String)localObject1), this.p1 + i8 - f2);
        }
        ((StaticLayout)localObject2).draw(paramCanvas);
        paramCanvas.restore();
      }
    }
    if ((this.C4 != null) && ((this.a4 != null) || (((this.S3) || (hasFocus())) && (!TextUtils.isEmpty(this.Y3)))))
    {
      localObject1 = this.B4;
      if (this.a4 != null)
      {
        m = this.N3;
      }
      else
      {
        m = this.Z3;
        if (m == -1) {
          m = this.H3 & 0xFFFFFF | 0x44000000;
        }
      }
      ((TextPaint)localObject1).setColor(m);
      this.B4.setTextSize(this.z);
      paramCanvas.save();
      if (e0()) {
        paramCanvas.translate(n - this.C4.getWidth() + this.S4, this.p1 + i8 - f2);
      } else {
        paramCanvas.translate(getBottomTextLeftOffset() + i, this.p1 + i8 - f2);
      }
      this.C4.draw(paramCanvas);
      paramCanvas.restore();
      if ((this.O4 != null) && (!TextUtils.isEmpty(this.a4)))
      {
        localObject1 = this.O4;
        j = ((Bitmap)localObject1).getWidth();
        i1 = this.S4;
        k = M(1);
        m = M(1);
        i2 = (this.C4.getHeight() - this.O4.getHeight()) / 2;
        i2 = this.p1 + i8 + i2;
        this.A4.setFlags(1);
        if (e0()) {
          paramCanvas.drawBitmap((Bitmap)localObject1, m + i, i2, this.A4);
        } else {
          paramCanvas.drawBitmap((Bitmap)localObject1, n - j + i1 - k, i2, this.A4);
        }
      }
    }
    if ((this.p2) && (!TextUtils.isEmpty(this.g4)))
    {
      this.B4.setTextSize(this.x);
      localObject1 = this.B4;
      localObject2 = this.z4;
      f1 = this.d4;
      f2 = isEnabled();
      m = this.y;
      if (m == -1) {
        m = this.H3 & 0xFFFFFF | 0x44000000;
      }
      ((TextPaint)localObject1).setColor(((Integer)((ArgbEvaluator)localObject2).evaluate(f1 * f2, Integer.valueOf(m), Integer.valueOf(this.M3))).intValue());
      if ((this.a4 != null) || (!b0()) || (this.k5 != null))
      {
        localObject1 = this.B4;
        localObject2 = this.z4;
        f1 = this.d4;
        f2 = isEnabled();
        m = this.N3;
        if (m == -1) {
          m = this.H3 & 0xFFFFFF | 0x44000000;
        }
        i1 = this.N3;
        if (i1 == -1) {
          i1 = this.M3;
        }
        ((TextPaint)localObject1).setColor(((Integer)((ArgbEvaluator)localObject2).evaluate(f1 * f2, Integer.valueOf(m), Integer.valueOf(i1))).intValue());
      }
      f2 = this.B4.measureText(this.g4.toString());
      if (((getGravity() & 0x5) != 5) && (!e0()))
      {
        if ((getGravity() & 0x3) == 3) {
          m = i;
        } else {
          m = (int)(getInnerPaddingLeft() + (getWidth() - getInnerPaddingLeft() - getInnerPaddingRight() - f2) / 2.0F) + i;
        }
      }
      else {
        m = (int)(n - f2);
      }
      i1 = m;
      if (e0()) {
        i1 = m + this.S4;
      }
      j = this.I3 + this.x + this.p0 + (int)getTextSize();
      k = this.I3;
      m = this.x;
      boolean bool = this.R3;
      f3 = 1.0F;
      if (bool) {
        f2 = 1.0F;
      } else {
        f2 = this.b4;
      }
      m = (int)(f2 * (k + m - j) + j + getScrollY());
      if (this.R3) {
        f2 = 1.0F;
      } else {
        f2 = this.b4;
      }
      k = this.y;
      if (k != -1) {
        f1 = 1.0F;
      } else {
        f1 = Color.alpha(k) / 255.0F;
      }
      k = (int)(f2 * 255.0F * f1);
      this.B4.setAlpha(k);
      if (this.R3) {
        f2 = f3;
      } else {
        f2 = this.b4;
      }
      f3 = this.x;
      float f6 = getTextSize();
      f1 = getTextSize();
      this.B4.setTextSize((f3 - f6) * f2 + f1);
      paramCanvas.drawText(this.g4.toString(), i1, m, this.B4);
    }
    if ((hasFocus()) && (this.Q3) && (getScrollX() != 0))
    {
      localObject1 = this.A4;
      if (c0()) {
        m = this.M3;
      } else {
        m = this.N3;
      }
      ((Paint)localObject1).setColor(m);
      f2 = i8 + this.p1;
      if (e0()) {
        i = n;
      }
      m = i6;
      if (e0()) {
        m = -1;
      }
      n = this.T3;
      paramCanvas.drawCircle(m * n / 2 + i, n / 2 + f2, n / 2, this.A4);
      n = this.T3;
      paramCanvas.drawCircle(m * n * 5 / 2 + i, n / 2 + f2, n / 2, this.A4);
      n = this.T3;
      paramCanvas.drawCircle(i + m * n * 9 / 2, f2 + n / 2, n / 2, this.A4);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      p();
      q();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.Q3) && (getScrollX() > 0) && (paramMotionEvent.getAction() == 0) && (paramMotionEvent.getX() < M(20)) && (paramMotionEvent.getY() > getHeight() - this.d - this.J3) && (paramMotionEvent.getY() < getHeight() - this.J3))
    {
      setSelection(0);
      return false;
    }
    int i;
    if ((hasFocus()) && (this.r4) && (isEnabled()))
    {
      i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              this.v4 = false;
              this.w4 = false;
            }
          }
          else
          {
            if ((this.w4) && (!Z(paramMotionEvent))) {
              this.w4 = false;
            }
            if (this.v4) {
              return true;
            }
          }
        }
        else
        {
          if (this.w4)
          {
            if (!TextUtils.isEmpty(getText())) {
              setText(null);
            }
            this.w4 = false;
          }
          if (this.v4)
          {
            this.v4 = false;
            return true;
          }
          this.v4 = false;
        }
      }
      else if (Z(paramMotionEvent))
      {
        this.v4 = true;
        this.w4 = true;
        return true;
      }
    }
    if ((this.Y4) && (isEnabled()))
    {
      i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              break label419;
            }
            this.g5 = false;
            this.h5 = false;
            break label419;
          }
        }
        else
        {
          if (this.h5)
          {
            boolean bool = this.b5 ^ true;
            this.b5 = bool;
            e locale = this.n5;
            if (locale != null) {
              locale.a(bool);
            }
            x();
            this.h5 = false;
            postInvalidate();
          }
          if (this.g5)
          {
            this.g5 = false;
            return true;
          }
          this.g5 = false;
          break label419;
        }
      }
      else if (a0(paramMotionEvent))
      {
        this.g5 = true;
        this.h5 = true;
        return true;
      }
      if ((this.h5) && (!a0(paramMotionEvent))) {
        this.h5 = false;
      }
      if (this.g5) {
        return true;
      }
    }
    label419:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAccentTypeface(Typeface paramTypeface)
  {
    this.e4 = paramTypeface;
    this.B4.setTypeface(paramTypeface);
    postInvalidate();
  }
  
  public void setAutoValidate(boolean paramBoolean)
  {
    this.j4 = paramBoolean;
    if (paramBoolean) {
      i0();
    }
  }
  
  public void setBaseColor(int paramInt)
  {
    if (this.H3 != paramInt) {
      this.H3 = paramInt;
    }
    X();
    postInvalidate();
  }
  
  public void setBottomTextSize(int paramInt)
  {
    this.z = paramInt;
    U();
  }
  
  public void setCurrentBottomLines(float paramFloat)
  {
    this.W3 = paramFloat;
    U();
  }
  
  public void setDisableUnderlineStyle(int paramInt)
  {
    this.l5 = paramInt;
    postInvalidate();
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = null;
    } else {
      paramCharSequence = paramCharSequence.toString();
    }
    this.a4 = paramCharSequence;
    if (p())
    {
      U();
      postInvalidate();
    }
  }
  
  public void setErrorColor(int paramInt)
  {
    this.N3 = paramInt;
    postInvalidate();
  }
  
  public void setFloatingLabel(int paramInt)
  {
    setFloatingLabelInternal(paramInt);
    U();
  }
  
  public void setFloatingLabelAlwaysShown(boolean paramBoolean)
  {
    this.R3 = paramBoolean;
    invalidate();
  }
  
  public void setFloatingLabelAnimating(boolean paramBoolean)
  {
    this.l4 = paramBoolean;
  }
  
  public void setFloatingLabelFraction(float paramFloat)
  {
    this.b4 = paramFloat;
    invalidate();
  }
  
  public void setFloatingLabelPadding(int paramInt)
  {
    this.p0 = paramInt;
    postInvalidate();
  }
  
  public void setFloatingLabelText(@Nullable CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence == null) {
      localCharSequence = getHint();
    }
    this.g4 = localCharSequence;
    postInvalidate();
  }
  
  public void setFloatingLabelTextColor(int paramInt)
  {
    this.y = paramInt;
    postInvalidate();
  }
  
  public void setFloatingLabelTextSize(int paramInt)
  {
    this.x = paramInt;
    U();
  }
  
  public void setFocusFraction(float paramFloat)
  {
    this.d4 = paramFloat;
    invalidate();
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = null;
    } else {
      paramCharSequence = paramCharSequence.toString();
    }
    this.Y3 = paramCharSequence;
    if (p())
    {
      U();
      postInvalidate();
    }
  }
  
  public void setHelperTextAlwaysShown(boolean paramBoolean)
  {
    this.S3 = paramBoolean;
    invalidate();
  }
  
  public void setHelperTextColor(int paramInt)
  {
    this.Z3 = paramInt;
    postInvalidate();
  }
  
  public void setHideUnderline(boolean paramBoolean)
  {
    this.h4 = paramBoolean;
    U();
    postInvalidate();
  }
  
  public void setIconLeft(@DrawableRes int paramInt)
  {
    this.n4 = F(paramInt);
    U();
  }
  
  public void setIconLeft(Bitmap paramBitmap)
  {
    this.n4 = G(paramBitmap);
    U();
  }
  
  public void setIconLeft(Drawable paramDrawable)
  {
    this.n4 = H(paramDrawable);
    U();
  }
  
  public void setIconRight(@DrawableRes int paramInt)
  {
    this.o4 = F(paramInt);
    U();
  }
  
  public void setIconRight(Bitmap paramBitmap)
  {
    this.o4 = G(paramBitmap);
    U();
  }
  
  public void setIconRight(Drawable paramDrawable)
  {
    this.o4 = H(paramDrawable);
    U();
  }
  
  public void setLengthChecker(com.tplink.libtpcontrols.materialnormalcompat.edittext.c.a parama) {}
  
  public void setMaxCharacters(int paramInt)
  {
    this.P3 = paramInt;
    y();
    T();
    U();
    postInvalidate();
  }
  
  public void setMetHintTextColor(int paramInt)
  {
    this.y4 = ColorStateList.valueOf(paramInt);
    g0();
  }
  
  public void setMetHintTextColor(ColorStateList paramColorStateList)
  {
    this.y4 = paramColorStateList;
    g0();
  }
  
  public void setMetTextColor(int paramInt)
  {
    this.x4 = ColorStateList.valueOf(paramInt);
    h0();
  }
  
  public void setMetTextColor(ColorStateList paramColorStateList)
  {
    this.x4 = paramColorStateList;
    h0();
  }
  
  public void setMinBottomTextLines(int paramInt)
  {
    this.V3 = paramInt;
    T();
    U();
    postInvalidate();
  }
  
  public void setMinCharacters(int paramInt)
  {
    this.O3 = paramInt;
    y();
    T();
    U();
    postInvalidate();
  }
  
  public void setOnEyeballVisibleChangedListener(e parame)
  {
    this.n5 = parame;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (this.G4 == null) {
      super.setOnFocusChangeListener(paramOnFocusChangeListener);
    } else {
      this.H4 = paramOnFocusChangeListener;
    }
  }
  
  @Deprecated
  @TargetApi(16)
  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (e0()) {
      super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    } else {
      super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setPaddingBottom(int paramInt)
  {
    this.J3 = paramInt;
    C();
  }
  
  public void setPaddingLeft(int paramInt)
  {
    this.K3 = paramInt;
    C();
  }
  
  public void setPaddingRight(int paramInt)
  {
    this.L3 = paramInt;
    C();
  }
  
  public void setPaddingTop(int paramInt)
  {
    this.I3 = paramInt;
    C();
  }
  
  public void setPasswordMode(boolean paramBoolean)
  {
    this.Y4 = paramBoolean;
    C();
    p();
    postInvalidate();
  }
  
  public void setPostfixText(CharSequence paramCharSequence)
  {
    this.R4 = paramCharSequence;
    W();
    C();
    p();
    q();
    postInvalidate();
  }
  
  public void setPrimaryColor(int paramInt)
  {
    this.M3 = paramInt;
    postInvalidate();
  }
  
  public void setShowClearButton(boolean paramBoolean)
  {
    this.r4 = paramBoolean;
    C();
    p();
  }
  
  public void setSingleLineEllipsis(boolean paramBoolean)
  {
    this.Q3 = paramBoolean;
    T();
    U();
    postInvalidate();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
  }
  
  public void setTextNormal(CharSequence paramCharSequence)
  {
    setText(paramCharSequence);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      Selection.setSelection(getText(), paramCharSequence.length());
    }
  }
  
  public void setUnderlineColor(int paramInt)
  {
    this.i4 = paramInt;
    postInvalidate();
  }
  
  public void setValidateOnFocusLost(boolean paramBoolean)
  {
    this.q4 = paramBoolean;
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if ((paramEditable.length() != 0) && (!MaterialEditText.this.hasFocus())) {
        Selection.setSelection(MaterialEditText.this.getText(), paramEditable.length());
      }
      MaterialEditText.a(MaterialEditText.this);
      if (MaterialEditText.b(MaterialEditText.this))
      {
        MaterialEditText.this.i0();
      }
      else
      {
        MaterialEditText.this.setError(null);
        MaterialEditText.this.B();
      }
      MaterialEditText.this.postInvalidate();
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class b
    implements Animator.AnimatorListener
  {
    b() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (MaterialEditText.d(MaterialEditText.this)) {
        if (MaterialEditText.e(MaterialEditText.this) == 0.0F)
        {
          if (TextUtils.isEmpty(MaterialEditText.g(MaterialEditText.this)))
          {
            paramAnimator = MaterialEditText.this;
            MaterialEditText.h(paramAnimator, MaterialEditText.i(paramAnimator));
          }
          paramAnimator = MaterialEditText.this;
          paramAnimator.setHint(MaterialEditText.g(paramAnimator));
        }
        else
        {
          MaterialEditText.e(MaterialEditText.this);
        }
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  class c
    implements TextWatcher
  {
    c() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if ((MaterialEditText.d(MaterialEditText.this)) && (paramEditable.length() != 0) && (!MaterialEditText.j(MaterialEditText.this)))
      {
        MaterialEditText.k(MaterialEditText.this, true);
        MaterialEditText.f(MaterialEditText.this, 1.0F);
        paramEditable = MaterialEditText.this;
        MaterialEditText.h(paramEditable, paramEditable.getHint());
        MaterialEditText.this.setHint("");
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class d
    implements View.OnFocusChangeListener
  {
    d() {}
    
    public void onFocusChange(View paramView, boolean paramBoolean)
    {
      if ((MaterialEditText.d(MaterialEditText.this)) && (MaterialEditText.l(MaterialEditText.this))) {
        if (paramBoolean) {
          MaterialEditText.m(MaterialEditText.this).start();
        } else {
          MaterialEditText.m(MaterialEditText.this).reverse();
        }
      }
      if (MaterialEditText.d(MaterialEditText.this)) {
        if (!paramBoolean)
        {
          if ((MaterialEditText.j(MaterialEditText.this)) && (TextUtils.isEmpty(MaterialEditText.this.getText())))
          {
            MaterialEditText.k(MaterialEditText.this, false);
            MaterialEditText.n(MaterialEditText.this).reverse();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("focus = 0 fs: ");
          ((StringBuilder)localObject).append(MaterialEditText.j(MaterialEditText.this));
          Log.i("material_debug", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("focus = 0 hint:");
          ((StringBuilder)localObject).append(MaterialEditText.g(MaterialEditText.this));
          Log.i("material_debug", ((StringBuilder)localObject).toString());
        }
        else
        {
          if (!MaterialEditText.j(MaterialEditText.this))
          {
            MaterialEditText.k(MaterialEditText.this, true);
            MaterialEditText.n(MaterialEditText.this).start();
            localObject = MaterialEditText.this;
            MaterialEditText.h((MaterialEditText)localObject, ((EditText)localObject).getHint());
            MaterialEditText.this.setHint("");
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("focus != 0 fs: ");
          ((StringBuilder)localObject).append(MaterialEditText.j(MaterialEditText.this));
          Log.i("material_debug", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("focus != 0 hint:");
          ((StringBuilder)localObject).append(MaterialEditText.g(MaterialEditText.this));
          Log.i("material_debug", ((StringBuilder)localObject).toString());
        }
      }
      if ((MaterialEditText.c(MaterialEditText.this)) && (!paramBoolean)) {
        MaterialEditText.this.i0();
      }
      Object localObject = MaterialEditText.this.H4;
      if (localObject != null) {
        ((View.OnFocusChangeListener)localObject).onFocusChange(paramView, paramBoolean);
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\materialnormalcompat\edittext\MaterialEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */