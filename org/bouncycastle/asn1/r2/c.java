package org.bouncycastle.asn1.r2;

import e.a.b.a.d;
import e.a.b.a.d.e;
import e.a.b.a.h;
import java.math.BigInteger;
import org.bouncycastle.asn1.m;
import org.bouncycastle.crypto.w.n;

public class c
{
  private static final BigInteger a;
  private static final BigInteger b;
  static final n[] c;
  static final m[] d;
  static final String e;
  
  static
  {
    Object localObject1 = BigInteger.valueOf(0L);
    a = (BigInteger)localObject1;
    Object localObject2 = BigInteger.valueOf(1L);
    b = (BigInteger)localObject2;
    c = new n[10];
    d = new m[10];
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(f.b.q());
    ((StringBuilder)localObject3).append(".2.");
    e = ((StringBuilder)localObject3).toString();
    localObject3 = new BigInteger[10];
    Object localObject4 = new BigInteger("400000000000000000002BEC12BE2262D39BCF14D", 16);
    int i = 0;
    localObject3[0] = localObject4;
    localObject3[1] = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFB12EBCC7D7F29FF7701F", 16);
    localObject3[2] = new BigInteger("800000000000000000000189B4E67606E3825BB2831", 16);
    localObject3[3] = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFB981960435FE5AB64236EF", 16);
    localObject3[4] = new BigInteger("40000000000000000000000069A779CAC1DABC6788F7474F", 16);
    localObject3[5] = new BigInteger("1000000000000000000000000000013E974E72F8A6922031D2603CFE0D7", 16);
    localObject3[6] = new BigInteger("800000000000000000000000000000006759213AF182E987D3E17714907D470D", 16);
    localObject3[7] = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC079C2F3825DA70D390FBBA588D4604022B7B7", 16);
    localObject3[8] = new BigInteger("40000000000000000000000000000000000000000000009C300B75A3FA824F22428FD28CE8812245EF44049B2D49", 16);
    localObject3[9] = new BigInteger("3FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFBA3175458009A8C0A724F02F81AA8A1FCBAF80D90C7A95110504CF", 16);
    BigInteger[] arrayOfBigInteger = new BigInteger[10];
    arrayOfBigInteger[0] = BigInteger.valueOf(2L);
    arrayOfBigInteger[1] = BigInteger.valueOf(2L);
    arrayOfBigInteger[2] = BigInteger.valueOf(4L);
    arrayOfBigInteger[3] = BigInteger.valueOf(2L);
    arrayOfBigInteger[4] = BigInteger.valueOf(2L);
    arrayOfBigInteger[5] = BigInteger.valueOf(2L);
    arrayOfBigInteger[6] = BigInteger.valueOf(4L);
    arrayOfBigInteger[7] = BigInteger.valueOf(2L);
    arrayOfBigInteger[8] = BigInteger.valueOf(2L);
    arrayOfBigInteger[9] = BigInteger.valueOf(2L);
    localObject4 = new d.e[10];
    localObject4[0] = new d.e(163, 3, 6, 7, (BigInteger)localObject2, new BigInteger("5FF6108462A2DC8210AB403925E638A19C1455D21", 16), localObject3[0], arrayOfBigInteger[0]);
    localObject4[1] = new d.e(167, 6, (BigInteger)localObject2, new BigInteger("6EE3CEEB230811759F20518A0930F1A4315A827DAC", 16), localObject3[1], arrayOfBigInteger[1]);
    localObject4[2] = new d.e(173, 1, 2, 10, (BigInteger)localObject1, new BigInteger("108576C80499DB2FC16EDDF6853BBB278F6B6FB437D9", 16), localObject3[2], arrayOfBigInteger[2]);
    localObject4[3] = new d.e(179, 1, 2, 4, (BigInteger)localObject2, new BigInteger("4A6E0856526436F2F88DD07A341E32D04184572BEB710", 16), localObject3[3], arrayOfBigInteger[3]);
    localObject4[4] = new d.e(191, 9, (BigInteger)localObject2, new BigInteger("7BC86E2102902EC4D5890E8B6B4981ff27E0482750FEFC03", 16), localObject3[4], arrayOfBigInteger[4]);
    localObject4[5] = new d.e(233, 1, 4, 9, (BigInteger)localObject2, new BigInteger("06973B15095675534C7CF7E64A21BD54EF5DD3B8A0326AA936ECE454D2C", 16), localObject3[5], arrayOfBigInteger[5]);
    localObject4[6] = new d.e(257, 12, (BigInteger)localObject1, new BigInteger("1CEF494720115657E18F938D7A7942394FF9425C1458C57861F9EEA6ADBE3BE10", 16), localObject3[6], arrayOfBigInteger[6]);
    localObject4[7] = new d.e(307, 2, 4, 8, (BigInteger)localObject2, new BigInteger("393C7F7D53666B5054B5E6C6D3DE94F4296C0C599E2E2E241050DF18B6090BDC90186904968BB", 16), localObject3[7], arrayOfBigInteger[7]);
    localObject4[8] = new d.e(367, 21, (BigInteger)localObject2, new BigInteger("43FC8AD242B0B7A6F3D1627AD5654447556B47BF6AA4A64B0C2AFE42CADAB8F93D92394C79A79755437B56995136", 16), localObject3[8], arrayOfBigInteger[8]);
    localObject4[9] = new d.e(431, 1, 3, 5, (BigInteger)localObject2, new BigInteger("03CE10490F6A708FC26DFE8C3D27C4F94E690134D5BFF988D8D28AAEAEDE975936C66BAC536B18AE2DC312CA493117DAA469C640CAF3", 16), localObject3[9], arrayOfBigInteger[9]);
    h localh1 = localObject4[0].g(new BigInteger("2E2F85F5DD74CE983A5C4237229DAF8A3F35823BE", 16), new BigInteger("3826F008A8C51D7B95284D9D03FF0E00CE2CD723A", 16));
    h localh2 = localObject4[1].g(new BigInteger("7A1F6653786A68192803910A3D30B2A2018B21CD54", 16), new BigInteger("5F49EB26781C0EC6B8909156D98ED435E45FD59918", 16));
    h localh3 = localObject4[2].g(new BigInteger("4D41A619BCC6EADF0448FA22FAD567A9181D37389CA", 16), new BigInteger("10B51CC12849B234C75E6DD2028BF7FF5C1CE0D991A1", 16));
    h localh4 = localObject4[3].g(new BigInteger("6BA06FE51464B2BD26DC57F48819BA9954667022C7D03", 16), new BigInteger("25FBC363582DCEC065080CA8287AAFF09788A66DC3A9E", 16));
    localObject2 = localObject4[4].g(new BigInteger("714114B762F2FF4A7912A6D2AC58B9B5C2FCFE76DAEB7129", 16), new BigInteger("29C41E568B77C617EFE5902F11DB96FA9613CD8D03DB08DA", 16));
    h localh5 = localObject4[5].g(new BigInteger("3FCDA526B6CDF83BA1118DF35B3C31761D3545F32728D003EEB25EFE96", 16), new BigInteger("9CA8B57A934C54DEEDA9E54A7BBAD95E3B2E91C54D32BE0B9DF96D8D35", 16));
    h localh6 = localObject4[6].g(new BigInteger("02A29EF207D0E9B6C55CD260B306C7E007AC491CA1B10C62334A9E8DCD8D20FB7", 16), new BigInteger("10686D41FF744D4449FCCF6D8EEA03102E6812C93A9D60B978B702CF156D814EF", 16));
    h localh7 = localObject4[7].g(new BigInteger("216EE8B189D291A0224984C1E92F1D16BF75CCD825A087A239B276D3167743C52C02D6E7232AA", 16), new BigInteger("5D9306BACD22B7FAEB09D2E049C6E2866C5D1677762A8F2F2DC9A11C7F7BE8340AB2237C7F2A0", 16));
    localObject1 = localObject4[8].g(new BigInteger("324A6EDDD512F08C49A99AE0D3F961197A76413E7BE81A400CA681E09639B5FE12E59A109F78BF4A373541B3B9A1", 16), new BigInteger("1AB597A5B4477F59E39539007C7F977D1A567B92B043A49C6B61984C3FE3481AAF454CD41BA1F051626442B3C10", 16));
    h localh8 = localObject4[9].g(new BigInteger("1A62BA79D98133A16BBAE7ED9A8E03C32E0824D57AEF72F88986874E5AAE49C27BED49A2A95058068426C2171E99FD3B43C5947C857D", 16), new BigInteger("70B5E1E14031C1F70BBEFE96BDDE66F451754B4CA5F48DA241F331AA396B8D1839A855C1769B1EA14BA53308B5E2723724E090E02DB9", 16));
    int k;
    for (int j = 0;; j++)
    {
      n[] arrayOfn = c;
      k = i;
      if (j >= arrayOfn.length) {
        break;
      }
      arrayOfn[j] = new n(localObject4[j], new h[] { localh1, localh2, localh3, localh4, localObject2, localh5, localh6, localh7, localObject1, localh8 }[j], localObject3[j], arrayOfBigInteger[j]);
    }
    for (;;)
    {
      localObject3 = d;
      if (k >= localObject3.length) {
        break;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(e);
      ((StringBuilder)localObject4).append(k);
      localObject3[k] = new m(((StringBuilder)localObject4).toString());
      k++;
    }
  }
  
  public static n a(m paramm)
  {
    Object localObject1 = paramm.q();
    boolean bool = ((String)localObject1).startsWith(e);
    Object localObject2 = null;
    paramm = (m)localObject2;
    if (bool)
    {
      int i = Integer.parseInt(((String)localObject1).substring(((String)localObject1).lastIndexOf('.') + 1));
      paramm = (m)localObject2;
      if (i >= 0)
      {
        localObject1 = c;
        paramm = (m)localObject2;
        if (i < localObject1.length) {
          paramm = localObject1[i];
        }
      }
    }
    return paramm;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\asn1\r2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */