package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.DocumentData.Justification;
import com.airbnb.lottie.r;
import com.airbnb.lottie.s.c.n;
import com.airbnb.lottie.s.c.o;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.v.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class g
  extends a
{
  private final Paint A = new a(1);
  private final Paint B = new b(1);
  private final Map<com.airbnb.lottie.model.c, List<com.airbnb.lottie.s.b.d>> C = new HashMap();
  private final LongSparseArray<String> D = new LongSparseArray();
  private final n E;
  private final f F;
  private final com.airbnb.lottie.d G;
  @Nullable
  private com.airbnb.lottie.s.c.a<Integer, Integer> H;
  @Nullable
  private com.airbnb.lottie.s.c.a<Integer, Integer> I;
  @Nullable
  private com.airbnb.lottie.s.c.a<Integer, Integer> J;
  @Nullable
  private com.airbnb.lottie.s.c.a<Integer, Integer> K;
  @Nullable
  private com.airbnb.lottie.s.c.a<Float, Float> L;
  @Nullable
  private com.airbnb.lottie.s.c.a<Float, Float> M;
  @Nullable
  private com.airbnb.lottie.s.c.a<Float, Float> N;
  @Nullable
  private com.airbnb.lottie.s.c.a<Float, Float> O;
  @Nullable
  private com.airbnb.lottie.s.c.a<Float, Float> P;
  @Nullable
  private com.airbnb.lottie.s.c.a<Float, Float> Q;
  private final StringBuilder x = new StringBuilder(2);
  private final RectF y = new RectF();
  private final Matrix z = new Matrix();
  
  g(f paramf, Layer paramLayer)
  {
    super(paramf, paramLayer);
    this.F = paramf;
    this.G = paramLayer.a();
    paramf = paramLayer.q().d();
    this.E = paramf;
    paramf.a(this);
    i(paramf);
    paramf = paramLayer.r();
    if (paramf != null)
    {
      paramLayer = paramf.a;
      if (paramLayer != null)
      {
        paramLayer = paramLayer.a();
        this.H = paramLayer;
        paramLayer.a(this);
        i(this.H);
      }
    }
    if (paramf != null)
    {
      paramLayer = paramf.b;
      if (paramLayer != null)
      {
        paramLayer = paramLayer.a();
        this.J = paramLayer;
        paramLayer.a(this);
        i(this.J);
      }
    }
    if (paramf != null)
    {
      paramLayer = paramf.c;
      if (paramLayer != null)
      {
        paramLayer = paramLayer.a();
        this.L = paramLayer;
        paramLayer.a(this);
        i(this.L);
      }
    }
    if (paramf != null)
    {
      paramf = paramf.d;
      if (paramf != null)
      {
        paramf = paramf.a();
        this.N = paramf;
        paramf.a(this);
        i(this.N);
      }
    }
  }
  
  private void J(DocumentData.Justification paramJustification, Canvas paramCanvas, float paramFloat)
  {
    int i = c.a[paramJustification.ordinal()];
    if (i != 2)
    {
      if (i == 3) {
        paramCanvas.translate(-paramFloat / 2.0F, 0.0F);
      }
    }
    else {
      paramCanvas.translate(-paramFloat, 0.0F);
    }
  }
  
  private String K(String paramString, int paramInt)
  {
    int i = paramString.codePointAt(paramInt);
    int j = Character.charCount(i) + paramInt;
    while (j < paramString.length())
    {
      int k = paramString.codePointAt(j);
      if (!W(k)) {
        break;
      }
      j += Character.charCount(k);
      i = i * 31 + k;
    }
    LongSparseArray localLongSparseArray = this.D;
    long l = i;
    if (localLongSparseArray.containsKey(l)) {
      return (String)this.D.get(l);
    }
    this.x.setLength(0);
    while (paramInt < j)
    {
      i = paramString.codePointAt(paramInt);
      this.x.appendCodePoint(i);
      paramInt += Character.charCount(i);
    }
    paramString = this.x.toString();
    this.D.put(l, paramString);
    return paramString;
  }
  
  private void L(String paramString, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {
      return;
    }
    if ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawText(paramString, 0, paramString.length(), 0.0F, 0.0F, paramPaint);
  }
  
  private void M(com.airbnb.lottie.model.c paramc, Matrix paramMatrix, float paramFloat, DocumentData paramDocumentData, Canvas paramCanvas)
  {
    List localList = T(paramc);
    for (int i = 0; i < localList.size(); i++)
    {
      paramc = ((com.airbnb.lottie.s.b.d)localList.get(i)).getPath();
      paramc.computeBounds(this.y, false);
      this.z.set(paramMatrix);
      this.z.preTranslate(0.0F, -paramDocumentData.g * h.e());
      this.z.preScale(paramFloat, paramFloat);
      paramc.transform(this.z);
      if (paramDocumentData.k)
      {
        P(paramc, this.A, paramCanvas);
        P(paramc, this.B, paramCanvas);
      }
      else
      {
        P(paramc, this.B, paramCanvas);
        P(paramc, this.A, paramCanvas);
      }
    }
  }
  
  private void N(String paramString, DocumentData paramDocumentData, Canvas paramCanvas)
  {
    if (paramDocumentData.k)
    {
      L(paramString, this.A, paramCanvas);
      L(paramString, this.B, paramCanvas);
    }
    else
    {
      L(paramString, this.B, paramCanvas);
      L(paramString, this.A, paramCanvas);
    }
  }
  
  private void O(String paramString, DocumentData paramDocumentData, Canvas paramCanvas, float paramFloat)
  {
    int i = 0;
    while (i < paramString.length())
    {
      Object localObject = K(paramString, i);
      i += ((String)localObject).length();
      N((String)localObject, paramDocumentData, paramCanvas);
      float f1 = this.A.measureText((String)localObject, 0, 1);
      float f2 = paramDocumentData.e / 10.0F;
      localObject = this.O;
      if (localObject != null) {}
      for (float f3 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue();; f3 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue())
      {
        f3 = f2 + f3;
        break;
        localObject = this.N;
        f3 = f2;
        if (localObject == null) {
          break;
        }
      }
      paramCanvas.translate(f1 + f3 * paramFloat, 0.0F);
    }
  }
  
  private void P(Path paramPath, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {
      return;
    }
    if ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private void Q(String paramString, DocumentData paramDocumentData, Matrix paramMatrix, com.airbnb.lottie.model.b paramb, Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    for (int i = 0; i < paramString.length(); i++)
    {
      int j = com.airbnb.lottie.model.c.c(paramString.charAt(i), paramb.a(), paramb.c());
      Object localObject = (com.airbnb.lottie.model.c)this.G.c().get(j);
      if (localObject != null)
      {
        M((com.airbnb.lottie.model.c)localObject, paramMatrix, paramFloat2, paramDocumentData, paramCanvas);
        float f1 = (float)((com.airbnb.lottie.model.c)localObject).b();
        float f2 = h.e();
        float f3 = paramDocumentData.e / 10.0F;
        localObject = this.O;
        if (localObject != null) {}
        for (float f4 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue();; f4 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue())
        {
          f4 = f3 + f4;
          break;
          localObject = this.N;
          f4 = f3;
          if (localObject == null) {
            break;
          }
        }
        paramCanvas.translate(f1 * paramFloat2 * f2 * paramFloat1 + f4 * paramFloat1, 0.0F);
      }
    }
  }
  
  private void R(DocumentData paramDocumentData, Matrix paramMatrix, com.airbnb.lottie.model.b paramb, Canvas paramCanvas)
  {
    Object localObject = this.Q;
    if (localObject != null)
    {
      f1 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue();
    }
    else
    {
      localObject = this.P;
      if (localObject != null) {
        f1 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue();
      } else {
        f1 = paramDocumentData.c;
      }
    }
    float f2 = f1 / 100.0F;
    float f3 = h.g(paramMatrix);
    localObject = paramDocumentData.a;
    float f1 = paramDocumentData.f * h.e();
    localObject = V((String)localObject);
    int i = ((List)localObject).size();
    for (int j = 0; j < i; j++)
    {
      String str = (String)((List)localObject).get(j);
      float f4 = U(str, paramb, f2, f3);
      paramCanvas.save();
      J(paramDocumentData.d, paramCanvas, f4);
      f4 = (i - 1) * f1 / 2.0F;
      paramCanvas.translate(0.0F, j * f1 - f4);
      Q(str, paramDocumentData, paramMatrix, paramb, paramCanvas, f3, f2);
      paramCanvas.restore();
    }
  }
  
  private void S(DocumentData paramDocumentData, com.airbnb.lottie.model.b paramb, Matrix paramMatrix, Canvas paramCanvas)
  {
    float f1 = h.g(paramMatrix);
    Typeface localTypeface = this.F.D(paramb.a(), paramb.c());
    if (localTypeface == null) {
      return;
    }
    Object localObject = paramDocumentData.a;
    r localr = this.F.C();
    paramb = (com.airbnb.lottie.model.b)localObject;
    if (localr != null) {
      paramb = localr.b((String)localObject);
    }
    this.A.setTypeface(localTypeface);
    localObject = this.Q;
    if (localObject != null)
    {
      f2 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue();
    }
    else
    {
      localObject = this.P;
      if (localObject != null) {
        f2 = ((Float)((com.airbnb.lottie.s.c.a)localObject).h()).floatValue();
      } else {
        f2 = paramDocumentData.c;
      }
    }
    this.A.setTextSize(f2 * h.e());
    this.B.setTypeface(this.A.getTypeface());
    this.B.setTextSize(this.A.getTextSize());
    float f2 = paramDocumentData.f * h.e();
    localObject = V(paramb);
    int i = ((List)localObject).size();
    for (int j = 0; j < i; j++)
    {
      paramb = (String)((List)localObject).get(j);
      float f3 = this.B.measureText(paramb);
      J(paramDocumentData.d, paramCanvas, f3);
      f3 = (i - 1) * f2 / 2.0F;
      paramCanvas.translate(0.0F, j * f2 - f3);
      O(paramb, paramDocumentData, paramCanvas, f1);
      paramCanvas.setMatrix(paramMatrix);
    }
  }
  
  private List<com.airbnb.lottie.s.b.d> T(com.airbnb.lottie.model.c paramc)
  {
    if (this.C.containsKey(paramc)) {
      return (List)this.C.get(paramc);
    }
    List localList = paramc.a();
    int i = localList.size();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
    {
      com.airbnb.lottie.model.content.j localj = (com.airbnb.lottie.model.content.j)localList.get(j);
      localArrayList.add(new com.airbnb.lottie.s.b.d(this.F, this, localj));
    }
    this.C.put(paramc, localArrayList);
    return localArrayList;
  }
  
  private float U(String paramString, com.airbnb.lottie.model.b paramb, float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    for (int i = 0; i < paramString.length(); i++)
    {
      int j = com.airbnb.lottie.model.c.c(paramString.charAt(i), paramb.a(), paramb.c());
      com.airbnb.lottie.model.c localc = (com.airbnb.lottie.model.c)this.G.c().get(j);
      if (localc != null) {
        f = (float)(f + localc.b() * paramFloat1 * h.e() * paramFloat2);
      }
    }
    return f;
  }
  
  private List<String> V(String paramString)
  {
    return Arrays.asList(paramString.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
  }
  
  private boolean W(int paramInt)
  {
    boolean bool;
    if ((Character.getType(paramInt) != 16) && (Character.getType(paramInt) != 27) && (Character.getType(paramInt) != 6) && (Character.getType(paramInt) != 28) && (Character.getType(paramInt) != 19)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    super.c(paramT, paramc);
    if (paramT == com.airbnb.lottie.k.a)
    {
      paramT = this.I;
      if (paramT != null) {
        C(paramT);
      }
      if (paramc == null)
      {
        this.I = null;
      }
      else
      {
        paramT = new p(paramc);
        this.I = paramT;
        paramT.a(this);
        i(this.I);
      }
    }
    else if (paramT == com.airbnb.lottie.k.b)
    {
      paramT = this.K;
      if (paramT != null) {
        C(paramT);
      }
      if (paramc == null)
      {
        this.K = null;
      }
      else
      {
        paramT = new p(paramc);
        this.K = paramT;
        paramT.a(this);
        i(this.K);
      }
    }
    else if (paramT == com.airbnb.lottie.k.o)
    {
      paramT = this.M;
      if (paramT != null) {
        C(paramT);
      }
      if (paramc == null)
      {
        this.M = null;
      }
      else
      {
        paramT = new p(paramc);
        this.M = paramT;
        paramT.a(this);
        i(this.M);
      }
    }
    else if (paramT == com.airbnb.lottie.k.p)
    {
      paramT = this.O;
      if (paramT != null) {
        C(paramT);
      }
      if (paramc == null)
      {
        this.O = null;
      }
      else
      {
        paramT = new p(paramc);
        this.O = paramT;
        paramT.a(this);
        i(this.O);
      }
    }
    else if (paramT == com.airbnb.lottie.k.B)
    {
      paramT = this.Q;
      if (paramT != null) {
        C(paramT);
      }
      if (paramc == null)
      {
        this.Q = null;
      }
      else
      {
        paramT = new p(paramc);
        this.Q = paramT;
        paramT.a(this);
        i(this.Q);
      }
    }
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.e(paramRectF, paramMatrix, paramBoolean);
    paramRectF.set(0.0F, 0.0F, this.G.b().width(), this.G.b().height());
  }
  
  void t(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramCanvas.save();
    if (!this.F.j0()) {
      paramCanvas.setMatrix(paramMatrix);
    }
    DocumentData localDocumentData = (DocumentData)this.E.h();
    com.airbnb.lottie.model.b localb = (com.airbnb.lottie.model.b)this.G.g().get(localDocumentData.b);
    if (localb == null)
    {
      paramCanvas.restore();
      return;
    }
    com.airbnb.lottie.s.c.a locala = this.I;
    if (locala != null)
    {
      this.A.setColor(((Integer)locala.h()).intValue());
    }
    else
    {
      locala = this.H;
      if (locala != null) {
        this.A.setColor(((Integer)locala.h()).intValue());
      } else {
        this.A.setColor(localDocumentData.h);
      }
    }
    locala = this.K;
    if (locala != null)
    {
      this.B.setColor(((Integer)locala.h()).intValue());
    }
    else
    {
      locala = this.J;
      if (locala != null) {
        this.B.setColor(((Integer)locala.h()).intValue());
      } else {
        this.B.setColor(localDocumentData.i);
      }
    }
    if (this.v.h() == null) {
      paramInt = 100;
    } else {
      paramInt = ((Integer)this.v.h().h()).intValue();
    }
    paramInt = paramInt * 255 / 100;
    this.A.setAlpha(paramInt);
    this.B.setAlpha(paramInt);
    locala = this.M;
    if (locala != null)
    {
      this.B.setStrokeWidth(((Float)locala.h()).floatValue());
    }
    else
    {
      locala = this.L;
      if (locala != null)
      {
        this.B.setStrokeWidth(((Float)locala.h()).floatValue());
      }
      else
      {
        float f = h.g(paramMatrix);
        this.B.setStrokeWidth(localDocumentData.j * h.e() * f);
      }
    }
    if (this.F.j0()) {
      R(localDocumentData, paramMatrix, localb, paramCanvas);
    } else {
      S(localDocumentData, localb, paramMatrix, paramCanvas);
    }
    paramCanvas.restore();
  }
  
  class a
    extends Paint
  {
    a(int paramInt)
    {
      super();
      setStyle(Paint.Style.FILL);
    }
  }
  
  class b
    extends Paint
  {
    b(int paramInt)
    {
      super();
      setStyle(Paint.Style.STROKE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\layer\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */