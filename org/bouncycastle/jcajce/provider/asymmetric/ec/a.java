package org.bouncycastle.jcajce.provider.asymmetric.ec;

import e.a.b.a.d;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.m;
import org.bouncycastle.asn1.u2.h;
import org.bouncycastle.asn1.u2.j;
import org.bouncycastle.asn1.v0;
import org.bouncycastle.jcajce.provider.asymmetric.util.b;
import org.bouncycastle.jce.spec.c;

class a
{
  static h a(ECParameterSpec paramECParameterSpec, boolean paramBoolean)
  {
    Object localObject;
    if ((paramECParameterSpec instanceof c))
    {
      c localc = (c)paramECParameterSpec;
      localObject = b.h(localc.a());
      paramECParameterSpec = (ECParameterSpec)localObject;
      if (localObject == null) {
        paramECParameterSpec = new m(localc.a());
      }
      paramECParameterSpec = new h(paramECParameterSpec);
    }
    else if (paramECParameterSpec == null)
    {
      paramECParameterSpec = new h(v0.c);
    }
    else
    {
      localObject = org.bouncycastle.jcajce.provider.asymmetric.util.a.b(paramECParameterSpec.getCurve());
      paramECParameterSpec = new h(new j((d)localObject, org.bouncycastle.jcajce.provider.asymmetric.util.a.f((d)localObject, paramECParameterSpec.getGenerator(), paramBoolean), paramECParameterSpec.getOrder(), BigInteger.valueOf(paramECParameterSpec.getCofactor()), paramECParameterSpec.getCurve().getSeed()));
    }
    return paramECParameterSpec;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */