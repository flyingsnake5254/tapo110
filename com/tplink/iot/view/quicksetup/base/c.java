package com.tplink.iot.view.quicksetup.base;

import android.text.TextUtils;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class c
{
  private static final List<String> a;
  private static final List<String> b;
  private static final List<String> c;
  private static final List<String> d;
  private static final List<String> e;
  
  static
  {
    ArrayList localArrayList1 = new ArrayList();
    a = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    b = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    c = localArrayList3;
    ArrayList localArrayList4 = new ArrayList();
    d = localArrayList4;
    ArrayList localArrayList5 = new ArrayList();
    e = localArrayList5;
    localArrayList1.add("US");
    localArrayList1.add("CA");
    localArrayList1.add("MX");
    localArrayList1.add("TW");
    localArrayList1.add("TH");
    localArrayList1.add("PH");
    localArrayList2.add("GB");
    localArrayList2.add("HK");
    localArrayList2.add("SG");
    localArrayList2.add("MY");
    localArrayList3.add("FR");
    localArrayList3.add("PL");
    localArrayList3.add("CZ");
    localArrayList3.add("SK");
    localArrayList4.add("JP");
    localArrayList5.add("AU");
    localArrayList5.add("NZ");
  }
  
  private static int A()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690281;
  }
  
  public static int B(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return C();
    }
    if (paramString.contains("P105")) {
      return D();
    }
    if (paramString.contains("P115")) {
      return A();
    }
    return C();
  }
  
  private static int C()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690125;
            }
            return 2131690124;
          }
          return 2131690129;
        }
        return 2131690128;
      }
      return 2131690127;
    }
    return 2131690126;
  }
  
  private static int D()
  {
    return 2131690137;
  }
  
  private static int E()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690122;
            }
            return 2131690121;
          }
          return 2131690142;
        }
        return 2131690141;
      }
      return 2131690130;
    }
    return 2131690123;
  }
  
  public static int F(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return E();
    }
    if (paramString.contains("P105")) {
      return G();
    }
    if (paramString.contains("P115")) {
      return H();
    }
    return E();
  }
  
  private static int G()
  {
    EnumCountry localEnumCountry = p();
    if (a.a[localEnumCountry.ordinal()] != 2) {
      return 2131690140;
    }
    return 2131690138;
  }
  
  private static int H()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690282;
  }
  
  public static int I(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return J();
    }
    if (paramString.contains("P105")) {
      return K();
    }
    if (paramString.contains("P115")) {
      return L();
    }
    return J();
  }
  
  private static int J()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690132;
            }
            return 2131690131;
          }
          return 2131690136;
        }
        return 2131690135;
      }
      return 2131690134;
    }
    return 2131690133;
  }
  
  private static int K()
  {
    return 2131690139;
  }
  
  private static int L()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690283;
  }
  
  public static int M(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return N();
    }
    if (paramString.contains("P105")) {
      return O();
    }
    return N();
  }
  
  private static int N()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690263;
            }
            return 2131690262;
          }
          return 2131690267;
        }
        return 2131690266;
      }
      return 2131690265;
    }
    return 2131690264;
  }
  
  private static int O()
  {
    EnumCountry localEnumCountry = p();
    if (a.a[localEnumCountry.ordinal()] != 2) {
      return 2131690242;
    }
    return 2131690241;
  }
  
  public static int P(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return a0();
    }
    if (paramString.contains("P105")) {
      return b0();
    }
    if (paramString.contains("P115")) {
      return Z();
    }
    return a0();
  }
  
  public static int Q(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return c0();
    }
    if (paramString.contains("P105")) {
      return d0();
    }
    if (paramString.contains("P115")) {
      return e0();
    }
    return c0();
  }
  
  public static int R(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return f0();
    }
    if (paramString.contains("P105")) {
      return g0();
    }
    if (paramString.contains("P115")) {
      return h0();
    }
    return f0();
  }
  
  private static int S()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690299;
            }
            return 2131690297;
          }
          return 2131690307;
        }
        return 2131690305;
      }
      return 2131690303;
    }
    return 2131690301;
  }
  
  public static int T(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return S();
    }
    if (paramString.contains("P105")) {
      return U();
    }
    if (paramString.contains("P115")) {
      return V();
    }
    return S();
  }
  
  private static int U()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 2)
    {
      if (i != 3) {
        return 2131690293;
      }
      return 2131690256;
    }
    return 2131690292;
  }
  
  private static int V()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690257;
  }
  
  public static int W(EnumDeviceType paramEnumDeviceType, String paramString)
  {
    if (paramEnumDeviceType == null) {
      return x(paramString);
    }
    int i = a.b[paramEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return x(paramString);
      }
      return 2131689617;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131689618;
    }
    return 2131689616;
  }
  
  public static int X(EnumDeviceType paramEnumDeviceType, String paramString)
  {
    if (paramEnumDeviceType == null) {
      return z(paramString);
    }
    int i = a.b[paramEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return z(paramString);
      }
      return 2131689619;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131689620;
    }
    return 2131689615;
  }
  
  public static int Y(EnumDeviceType paramEnumDeviceType, String paramString)
  {
    if (paramEnumDeviceType == null) {
      return q(paramString);
    }
    int i = a.b[paramEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return q(paramString);
      }
      return 2131689613;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131689614;
    }
    return 2131689612;
  }
  
  private static int Z()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690295;
  }
  
  private static int a()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131689600;
            }
            return 2131689599;
          }
          return 2131689604;
        }
        return 2131689603;
      }
      return 2131689602;
    }
    return 2131689601;
  }
  
  private static int a0()
  {
    EnumCountry localEnumCountry = p();
    if (localEnumCountry == null) {
      return 2131690330;
    }
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690330;
            }
            return 2131690329;
          }
          return 2131690334;
        }
        return 2131690333;
      }
      return 2131690332;
    }
    return 2131690331;
  }
  
  private static int b()
  {
    EnumCountry localEnumCountry = p();
    if (a.a[localEnumCountry.ordinal()] != 2) {
      return 2131689596;
    }
    return 2131689595;
  }
  
  private static int b0()
  {
    return 2131690342;
  }
  
  private static int c()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690260;
  }
  
  private static int c0()
  {
    EnumCountry localEnumCountry = p();
    if (localEnumCountry == null) {
      return 2131690326;
    }
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690326;
            }
            return 2131690325;
          }
          return 2131690347;
        }
        return 2131690346;
      }
      return 2131690335;
    }
    return 2131690328;
  }
  
  public static int d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return s();
    }
    if (paramString.contains("P105")) {
      return v();
    }
    if (paramString.contains("P115")) {
      return r();
    }
    return s();
  }
  
  private static int d0()
  {
    EnumCountry localEnumCountry = p();
    if (localEnumCountry == null) {
      return 2131690345;
    }
    if (a.a[localEnumCountry.ordinal()] != 2) {
      return 2131690345;
    }
    return 2131690343;
  }
  
  private static int e()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690272;
            }
            return 2131690271;
          }
          return 2131690276;
        }
        return 2131690275;
      }
      return 2131690274;
    }
    return 2131690273;
  }
  
  private static int e0()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690296;
  }
  
  public static int f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return e();
    }
    if (paramString.contains("P105")) {
      return g();
    }
    if (paramString.contains("P115")) {
      return h();
    }
    return e();
  }
  
  private static int f0()
  {
    EnumCountry localEnumCountry = p();
    if (localEnumCountry == null) {
      return 2131690337;
    }
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690337;
            }
            return 2131690336;
          }
          return 2131690341;
        }
        return 2131690340;
      }
      return 2131690339;
    }
    return 2131690338;
  }
  
  private static int g()
  {
    return 2131690243;
  }
  
  private static int g0()
  {
    return 2131690344;
  }
  
  private static int h()
  {
    return 2131690253;
  }
  
  private static int h0()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690296;
  }
  
  private static int i()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690286;
            }
            return 2131690285;
          }
          return 2131690290;
        }
        return 2131690289;
      }
      return 2131690288;
    }
    return 2131690287;
  }
  
  public static int i0(EnumDeviceType paramEnumDeviceType, String paramString)
  {
    if (paramEnumDeviceType == null) {
      return q(paramString);
    }
    int i = a.b[paramEnumDeviceType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return q(paramString);
      }
      return 2131689613;
    }
    if (com.tplink.iot.g.b.c.c.i(paramString)) {
      return 2131689614;
    }
    return 2131689612;
  }
  
  public static int j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return i();
    }
    if (paramString.contains("P105")) {
      return k();
    }
    if (paramString.contains("P115")) {
      return l();
    }
    return i();
  }
  
  public static int j0(int paramInt)
  {
    if (paramInt >= 3) {
      return 2131690454;
    }
    if (paramInt == 2) {
      return 2131690453;
    }
    return 2131690452;
  }
  
  private static int k()
  {
    return 2131690244;
  }
  
  private static int l()
  {
    return 2131690253;
  }
  
  private static int m()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131689606;
            }
            return 2131689605;
          }
          return 2131689610;
        }
        return 2131689609;
      }
      return 2131689608;
    }
    return 2131689607;
  }
  
  private static int n()
  {
    EnumCountry localEnumCountry = p();
    if (a.a[localEnumCountry.ordinal()] != 2) {
      return 2131689598;
    }
    return 2131689597;
  }
  
  private static int o()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690310;
  }
  
  public static EnumCountry p()
  {
    Locale localLocale = Locale.getDefault();
    if (localLocale == null) {
      return EnumCountry.EU;
    }
    if (a.contains(localLocale.getCountry())) {
      return EnumCountry.US;
    }
    if (b.contains(localLocale.getCountry())) {
      return EnumCountry.UK;
    }
    if (c.contains(localLocale.getCountry())) {
      return EnumCountry.FR;
    }
    if (d.contains(localLocale.getCountry())) {
      return EnumCountry.JP;
    }
    if (e.contains(localLocale.getCountry())) {
      return EnumCountry.AU;
    }
    return EnumCountry.EU;
  }
  
  private static int q(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return a();
    }
    if (paramString.contains("P105")) {
      return b();
    }
    if (paramString.contains("P115")) {
      return c();
    }
    return a();
  }
  
  private static int r()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690253;
  }
  
  private static int s()
  {
    return t(p());
  }
  
  private static int t(EnumCountry paramEnumCountry)
  {
    if (paramEnumCountry == null) {
      return 2131690268;
    }
    int i = a.a[paramEnumCountry.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return 2131690268;
            }
            return 2131690255;
          }
          return 2131690311;
        }
        return 2131690309;
      }
      return 2131690280;
    }
    return 2131690270;
  }
  
  public static int u(EnumCountry paramEnumCountry, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return t(paramEnumCountry);
    }
    if (paramString.contains("P105")) {
      return w(paramEnumCountry);
    }
    return t(paramEnumCountry);
  }
  
  private static int v()
  {
    return w(p());
  }
  
  private static int w(EnumCountry paramEnumCountry)
  {
    if (paramEnumCountry == null) {
      return 2131690294;
    }
    if (a.a[paramEnumCountry.ordinal()] != 2) {
      return 2131690294;
    }
    return 2131690291;
  }
  
  private static int x(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return z(paramString);
    }
    if (paramString.contains("P115")) {
      return y();
    }
    return z(paramString);
  }
  
  private static int y()
  {
    EnumCountry localEnumCountry = p();
    int i = a.a[localEnumCountry.ordinal()];
    return 2131690269;
  }
  
  private static int z(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return m();
    }
    if (paramString.contains("P105")) {
      return n();
    }
    if (paramString.contains("P115")) {
      return o();
    }
    return m();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\base\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */