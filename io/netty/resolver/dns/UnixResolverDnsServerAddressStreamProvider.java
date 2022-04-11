package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class UnixResolverDnsServerAddressStreamProvider
  implements DnsServerAddressStreamProvider
{
  private static final String DOMAIN_ROW_LABEL = "domain";
  private static final String ETC_RESOLVER_DIR = "/etc/resolver";
  private static final String ETC_RESOLV_CONF_FILE = "/etc/resolv.conf";
  private static final String NAMESERVER_ROW_LABEL = "nameserver";
  private static final String OPTIONS_ROTATE_FLAG = "rotate";
  private static final String OPTIONS_ROW_LABEL = "options ";
  private static final String PORT_ROW_LABEL = "port";
  private static final String RES_OPTIONS = System.getenv("RES_OPTIONS");
  private static final String SEARCH_ROW_LABEL = "search";
  private static final String SORTLIST_ROW_LABEL = "sortlist";
  private static final Pattern WHITESPACE_PATTERN;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(UnixResolverDnsServerAddressStreamProvider.class);
  private final DnsServerAddresses defaultNameServerAddresses;
  private final Map<String, DnsServerAddresses> domainToNameServerStreamMap;
  
  static
  {
    WHITESPACE_PATTERN = Pattern.compile("\\s+");
  }
  
  public UnixResolverDnsServerAddressStreamProvider(File paramFile, File... paramVarArgs)
    throws IOException
  {
    int i = 1;
    Map localMap = parse(new File[] { (File)ObjectUtil.checkNotNull(paramFile, "etcResolvConf") });
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      i = 0;
    }
    if (i != 0) {
      paramVarArgs = parse(paramVarArgs);
    } else {
      paramVarArgs = localMap;
    }
    this.domainToNameServerStreamMap = paramVarArgs;
    Object localObject = (DnsServerAddresses)localMap.get(paramFile.getName());
    if (localObject == null)
    {
      localObject = localMap.values();
      if (!((Collection)localObject).isEmpty())
      {
        this.defaultNameServerAddresses = ((DnsServerAddresses)((Collection)localObject).iterator().next());
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(paramFile);
        paramVarArgs.append(" didn't provide any name servers");
        throw new IllegalArgumentException(paramVarArgs.toString());
      }
    }
    else
    {
      this.defaultNameServerAddresses = ((DnsServerAddresses)localObject);
    }
    if (i != 0) {
      paramVarArgs.putAll(localMap);
    }
  }
  
  public UnixResolverDnsServerAddressStreamProvider(String paramString1, String paramString2)
    throws IOException
  {
    this(paramString1, paramString2);
  }
  
  private boolean mayOverrideNameServers()
  {
    boolean bool;
    if ((this.domainToNameServerStreamMap.isEmpty()) && (this.defaultNameServerAddresses.stream().next() == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  private static Map<String, DnsServerAddresses> parse(File... paramVarArgs)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_1
    //   2: aload_1
    //   3: arraylength
    //   4: istore_2
    //   5: iconst_1
    //   6: istore_3
    //   7: new 176	java/util/HashMap
    //   10: dup
    //   11: iload_2
    //   12: iconst_1
    //   13: ishl
    //   14: invokespecial 179	java/util/HashMap:<init>	(I)V
    //   17: astore 4
    //   19: getstatic 73	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:RES_OPTIONS	Ljava/lang/String;
    //   22: astore 5
    //   24: ldc 22
    //   26: astore 6
    //   28: aload 5
    //   30: ifnull +16 -> 46
    //   33: aload 5
    //   35: ldc 22
    //   37: invokevirtual 185	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   40: ifeq +6 -> 46
    //   43: goto +5 -> 48
    //   46: iconst_0
    //   47: istore_3
    //   48: aload_1
    //   49: arraylength
    //   50: istore 7
    //   52: iconst_0
    //   53: istore 8
    //   55: iload 8
    //   57: iload 7
    //   59: if_icmpge +993 -> 1052
    //   62: aload_0
    //   63: iload 8
    //   65: aaload
    //   66: astore 9
    //   68: aload 9
    //   70: invokevirtual 188	java/io/File:isFile	()Z
    //   73: ifne +12 -> 85
    //   76: aload 6
    //   78: astore_1
    //   79: iload 7
    //   81: istore_2
    //   82: goto +932 -> 1014
    //   85: new 190	java/io/FileReader
    //   88: dup
    //   89: aload 9
    //   91: invokespecial 193	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   94: astore 10
    //   96: aconst_null
    //   97: astore_1
    //   98: new 195	java/io/BufferedReader
    //   101: astore 11
    //   103: aload 11
    //   105: aload 10
    //   107: invokespecial 198	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   110: new 200	java/util/ArrayList
    //   113: astore 12
    //   115: aload 12
    //   117: iconst_2
    //   118: invokespecial 201	java/util/ArrayList:<init>	(I)V
    //   121: aload 9
    //   123: invokevirtual 100	java/io/File:getName	()Ljava/lang/String;
    //   126: astore_1
    //   127: iload_3
    //   128: istore 13
    //   130: bipush 53
    //   132: istore_2
    //   133: aload 11
    //   135: invokevirtual 204	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   138: astore 5
    //   140: aload 5
    //   142: ifnull +841 -> 983
    //   145: aload 5
    //   147: invokevirtual 207	java/lang/String:trim	()Ljava/lang/String;
    //   150: astore 14
    //   152: aload 14
    //   154: invokevirtual 208	java/lang/String:isEmpty	()Z
    //   157: ifne +803 -> 960
    //   160: aload 14
    //   162: iconst_0
    //   163: invokevirtual 212	java/lang/String:charAt	(I)C
    //   166: istore 15
    //   168: iload 15
    //   170: bipush 35
    //   172: if_icmpeq +788 -> 960
    //   175: iload 15
    //   177: bipush 59
    //   179: if_icmpne +6 -> 185
    //   182: goto +778 -> 960
    //   185: iload 13
    //   187: ifne +34 -> 221
    //   190: aload 14
    //   192: ldc 25
    //   194: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   197: ifeq +24 -> 221
    //   200: aload 14
    //   202: aload 6
    //   204: invokevirtual 185	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   207: istore 16
    //   209: iload 16
    //   211: istore 13
    //   213: goto +767 -> 980
    //   216: astore 5
    //   218: goto +747 -> 965
    //   221: aload 14
    //   223: ldc 19
    //   225: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   228: istore 16
    //   230: iload 16
    //   232: ifeq +394 -> 626
    //   235: aload 14
    //   237: bipush 10
    //   239: invokestatic 222	io/netty/util/internal/StringUtil:indexOfNonWhiteSpace	(Ljava/lang/CharSequence;I)I
    //   242: istore 15
    //   244: iload 15
    //   246: iflt +308 -> 554
    //   249: aload 14
    //   251: iload 15
    //   253: invokestatic 225	io/netty/util/internal/StringUtil:indexOfWhiteSpace	(Ljava/lang/CharSequence;I)I
    //   256: istore 17
    //   258: iload 17
    //   260: iconst_m1
    //   261: if_icmpne +20 -> 281
    //   264: aload 14
    //   266: iload 15
    //   268: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   271: astore 5
    //   273: goto +46 -> 319
    //   276: astore 5
    //   278: goto +687 -> 965
    //   281: aload 14
    //   283: iload 17
    //   285: invokestatic 222	io/netty/util/internal/StringUtil:indexOfNonWhiteSpace	(Ljava/lang/CharSequence;I)I
    //   288: istore 18
    //   290: iload 18
    //   292: iconst_m1
    //   293: if_icmpeq +189 -> 482
    //   296: aload 14
    //   298: iload 18
    //   300: invokevirtual 212	java/lang/String:charAt	(I)C
    //   303: bipush 35
    //   305: if_icmpne +177 -> 482
    //   308: aload 14
    //   310: iload 15
    //   312: iload 17
    //   314: invokevirtual 232	java/lang/String:substring	(II)Ljava/lang/String;
    //   317: astore 5
    //   319: aload 5
    //   321: invokestatic 237	io/netty/util/NetUtil:isValidIpV4Address	(Ljava/lang/String;)Z
    //   324: ifne +130 -> 454
    //   327: aload 5
    //   329: invokestatic 240	io/netty/util/NetUtil:isValidIpV6Address	(Ljava/lang/String;)Z
    //   332: ifne +122 -> 454
    //   335: aload 5
    //   337: bipush 46
    //   339: invokevirtual 244	java/lang/String:lastIndexOf	(I)I
    //   342: istore 18
    //   344: iload 18
    //   346: iconst_1
    //   347: iadd
    //   348: istore 15
    //   350: iload 15
    //   352: aload 5
    //   354: invokevirtual 248	java/lang/String:length	()I
    //   357: if_icmpge +35 -> 392
    //   360: aload 5
    //   362: iload 15
    //   364: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   367: invokestatic 254	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   370: istore 17
    //   372: iload 17
    //   374: istore 15
    //   376: aload 5
    //   378: iconst_0
    //   379: iload 18
    //   381: invokevirtual 232	java/lang/String:substring	(II)Ljava/lang/String;
    //   384: astore 5
    //   386: iload 17
    //   388: istore_2
    //   389: goto +65 -> 454
    //   392: new 144	java/lang/IllegalArgumentException
    //   395: astore 19
    //   397: new 132	java/lang/StringBuilder
    //   400: astore 5
    //   402: aload 5
    //   404: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   407: aload 5
    //   409: ldc_w 256
    //   412: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 5
    //   418: aload 9
    //   420: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 5
    //   426: ldc_w 258
    //   429: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 5
    //   435: aload 14
    //   437: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 19
    //   443: aload 5
    //   445: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokespecial 150	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   451: aload 19
    //   453: athrow
    //   454: iload_2
    //   455: istore 15
    //   457: aload 12
    //   459: aload 5
    //   461: iload_2
    //   462: invokestatic 264	io/netty/util/internal/SocketUtils:socketAddress	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   465: invokeinterface 270 2 0
    //   470: pop
    //   471: goto +509 -> 980
    //   474: astore 5
    //   476: iload 15
    //   478: istore_2
    //   479: goto +144 -> 623
    //   482: new 144	java/lang/IllegalArgumentException
    //   485: astore 5
    //   487: new 132	java/lang/StringBuilder
    //   490: astore 19
    //   492: aload 19
    //   494: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   497: aload 19
    //   499: ldc_w 256
    //   502: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload 19
    //   508: aload 9
    //   510: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 19
    //   516: ldc_w 272
    //   519: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 19
    //   525: aload 14
    //   527: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload 5
    //   533: aload 19
    //   535: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokespecial 150	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   541: aload 5
    //   543: athrow
    //   544: astore 5
    //   546: goto +72 -> 618
    //   549: astore 5
    //   551: goto +72 -> 623
    //   554: new 144	java/lang/IllegalArgumentException
    //   557: astore 5
    //   559: new 132	java/lang/StringBuilder
    //   562: astore 19
    //   564: aload 19
    //   566: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   569: aload 19
    //   571: ldc_w 256
    //   574: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 19
    //   580: aload 9
    //   582: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 19
    //   588: ldc_w 272
    //   591: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload 19
    //   597: aload 14
    //   599: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: pop
    //   603: aload 5
    //   605: aload 19
    //   607: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokespecial 150	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   613: aload 5
    //   615: athrow
    //   616: astore 5
    //   618: goto +5 -> 623
    //   621: astore 5
    //   623: goto +342 -> 965
    //   626: iload_2
    //   627: istore 15
    //   629: aload 14
    //   631: ldc 10
    //   633: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   636: istore 16
    //   638: iload 16
    //   640: ifeq +159 -> 799
    //   643: aload 14
    //   645: bipush 6
    //   647: invokestatic 222	io/netty/util/internal/StringUtil:indexOfNonWhiteSpace	(Ljava/lang/CharSequence;I)I
    //   650: istore 17
    //   652: iload 17
    //   654: iflt +83 -> 737
    //   657: aload 14
    //   659: iload 17
    //   661: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   664: astore 5
    //   666: aload 12
    //   668: invokeinterface 273 1 0
    //   673: istore 16
    //   675: iload 16
    //   677: ifne +29 -> 706
    //   680: aload 4
    //   682: aload 5
    //   684: aload 12
    //   686: iload 13
    //   688: invokestatic 277	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:putIfAbsent	(Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Z)V
    //   691: goto +15 -> 706
    //   694: astore 19
    //   696: aload 5
    //   698: astore_1
    //   699: aload 19
    //   701: astore 5
    //   703: goto -85 -> 618
    //   706: new 200	java/util/ArrayList
    //   709: dup
    //   710: iconst_2
    //   711: invokespecial 201	java/util/ArrayList:<init>	(I)V
    //   714: astore 19
    //   716: goto +218 -> 934
    //   719: astore_1
    //   720: goto +4 -> 724
    //   723: astore_1
    //   724: aload 5
    //   726: astore 19
    //   728: aload_1
    //   729: astore 5
    //   731: aload 19
    //   733: astore_1
    //   734: goto +220 -> 954
    //   737: new 144	java/lang/IllegalArgumentException
    //   740: astore 5
    //   742: new 132	java/lang/StringBuilder
    //   745: astore 19
    //   747: aload 19
    //   749: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   752: aload 19
    //   754: ldc_w 279
    //   757: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload 19
    //   763: aload 9
    //   765: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload 19
    //   771: ldc_w 281
    //   774: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 19
    //   780: aload 14
    //   782: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload 5
    //   788: aload 19
    //   790: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokespecial 150	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   796: aload 5
    //   798: athrow
    //   799: aload 14
    //   801: ldc 28
    //   803: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   806: ifeq +89 -> 895
    //   809: aload 14
    //   811: iconst_4
    //   812: invokestatic 222	io/netty/util/internal/StringUtil:indexOfNonWhiteSpace	(Ljava/lang/CharSequence;I)I
    //   815: istore_2
    //   816: iload_2
    //   817: iflt +16 -> 833
    //   820: aload 14
    //   822: iload_2
    //   823: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   826: invokestatic 254	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   829: istore_2
    //   830: goto +150 -> 980
    //   833: new 144	java/lang/IllegalArgumentException
    //   836: astore 19
    //   838: new 132	java/lang/StringBuilder
    //   841: astore 5
    //   843: aload 5
    //   845: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   848: aload 5
    //   850: ldc_w 283
    //   853: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload 5
    //   859: aload 9
    //   861: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload 5
    //   867: ldc_w 281
    //   870: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload 5
    //   876: aload 14
    //   878: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload 19
    //   884: aload 5
    //   886: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokespecial 150	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   892: aload 19
    //   894: athrow
    //   895: aload 12
    //   897: astore 19
    //   899: aload_1
    //   900: astore 5
    //   902: aload 14
    //   904: ldc 35
    //   906: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   909: ifeq +25 -> 934
    //   912: getstatic 54	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   915: ldc_w 285
    //   918: ldc 35
    //   920: aload 14
    //   922: invokeinterface 291 4 0
    //   927: aload_1
    //   928: astore 5
    //   930: aload 12
    //   932: astore 19
    //   934: iload 15
    //   936: istore_2
    //   937: aload 19
    //   939: astore 12
    //   941: aload 5
    //   943: astore_1
    //   944: goto +36 -> 980
    //   947: astore 5
    //   949: goto +5 -> 954
    //   952: astore 5
    //   954: iload 15
    //   956: istore_2
    //   957: goto +8 -> 965
    //   960: goto -827 -> 133
    //   963: astore 5
    //   965: getstatic 54	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   968: ldc_w 293
    //   971: aload 14
    //   973: aload 5
    //   975: invokeinterface 296 4 0
    //   980: goto -847 -> 133
    //   983: iload 7
    //   985: istore_2
    //   986: aload 12
    //   988: invokeinterface 273 1 0
    //   993: ifne +13 -> 1006
    //   996: aload 4
    //   998: aload_1
    //   999: aload 12
    //   1001: iload 13
    //   1003: invokestatic 277	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:putIfAbsent	(Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Z)V
    //   1006: aload 11
    //   1008: invokevirtual 299	java/io/BufferedReader:close	()V
    //   1011: aload 6
    //   1013: astore_1
    //   1014: iinc 8 1
    //   1017: aload_1
    //   1018: astore 6
    //   1020: iload_2
    //   1021: istore 7
    //   1023: goto -968 -> 55
    //   1026: astore_0
    //   1027: aload 11
    //   1029: astore_1
    //   1030: goto +4 -> 1034
    //   1033: astore_0
    //   1034: aload_1
    //   1035: ifnonnull +11 -> 1046
    //   1038: aload 10
    //   1040: invokevirtual 300	java/io/FileReader:close	()V
    //   1043: goto +7 -> 1050
    //   1046: aload_1
    //   1047: invokevirtual 299	java/io/BufferedReader:close	()V
    //   1050: aload_0
    //   1051: athrow
    //   1052: aload 4
    //   1054: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1055	0	paramVarArgs	File[]
    //   1	698	1	localObject1	Object
    //   719	1	1	localIllegalArgumentException1	IllegalArgumentException
    //   723	6	1	localIllegalArgumentException2	IllegalArgumentException
    //   733	314	1	localObject2	Object
    //   4	1017	2	i	int
    //   6	122	3	bool1	boolean
    //   17	1036	4	localHashMap	java.util.HashMap
    //   22	124	5	str1	String
    //   216	1	5	localIllegalArgumentException3	IllegalArgumentException
    //   271	1	5	str2	String
    //   276	1	5	localIllegalArgumentException4	IllegalArgumentException
    //   317	143	5	localObject3	Object
    //   474	1	5	localIllegalArgumentException5	IllegalArgumentException
    //   485	57	5	localIllegalArgumentException6	IllegalArgumentException
    //   544	1	5	localIllegalArgumentException7	IllegalArgumentException
    //   549	1	5	localIllegalArgumentException8	IllegalArgumentException
    //   557	57	5	localIllegalArgumentException9	IllegalArgumentException
    //   616	1	5	localIllegalArgumentException10	IllegalArgumentException
    //   621	1	5	localIllegalArgumentException11	IllegalArgumentException
    //   664	278	5	localObject4	Object
    //   947	1	5	localIllegalArgumentException12	IllegalArgumentException
    //   952	1	5	localIllegalArgumentException13	IllegalArgumentException
    //   963	11	5	localIllegalArgumentException14	IllegalArgumentException
    //   26	993	6	localObject5	Object
    //   50	972	7	j	int
    //   53	962	8	k	int
    //   66	794	9	localFile	File
    //   94	945	10	localFileReader	java.io.FileReader
    //   101	927	11	localBufferedReader	java.io.BufferedReader
    //   113	887	12	localObject6	Object
    //   128	874	13	bool2	boolean
    //   150	822	14	str3	String
    //   166	789	15	m	int
    //   207	469	16	bool3	boolean
    //   256	404	17	n	int
    //   288	92	18	i1	int
    //   395	211	19	localObject7	Object
    //   694	6	19	localIllegalArgumentException15	IllegalArgumentException
    //   714	224	19	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   190	209	216	java/lang/IllegalArgumentException
    //   264	273	276	java/lang/IllegalArgumentException
    //   376	386	474	java/lang/IllegalArgumentException
    //   457	471	474	java/lang/IllegalArgumentException
    //   281	290	544	java/lang/IllegalArgumentException
    //   296	319	544	java/lang/IllegalArgumentException
    //   319	344	544	java/lang/IllegalArgumentException
    //   350	372	544	java/lang/IllegalArgumentException
    //   249	258	549	java/lang/IllegalArgumentException
    //   392	454	616	java/lang/IllegalArgumentException
    //   482	544	616	java/lang/IllegalArgumentException
    //   554	616	616	java/lang/IllegalArgumentException
    //   235	244	621	java/lang/IllegalArgumentException
    //   680	691	694	java/lang/IllegalArgumentException
    //   706	716	719	java/lang/IllegalArgumentException
    //   666	675	723	java/lang/IllegalArgumentException
    //   737	799	947	java/lang/IllegalArgumentException
    //   799	816	947	java/lang/IllegalArgumentException
    //   820	830	947	java/lang/IllegalArgumentException
    //   833	895	947	java/lang/IllegalArgumentException
    //   902	927	947	java/lang/IllegalArgumentException
    //   629	638	952	java/lang/IllegalArgumentException
    //   643	652	952	java/lang/IllegalArgumentException
    //   657	666	952	java/lang/IllegalArgumentException
    //   152	168	963	java/lang/IllegalArgumentException
    //   221	230	963	java/lang/IllegalArgumentException
    //   110	127	1026	finally
    //   133	140	1026	finally
    //   145	152	1026	finally
    //   152	168	1026	finally
    //   190	209	1026	finally
    //   221	230	1026	finally
    //   235	244	1026	finally
    //   249	258	1026	finally
    //   264	273	1026	finally
    //   281	290	1026	finally
    //   296	319	1026	finally
    //   319	344	1026	finally
    //   350	372	1026	finally
    //   376	386	1026	finally
    //   392	454	1026	finally
    //   457	471	1026	finally
    //   482	544	1026	finally
    //   554	616	1026	finally
    //   629	638	1026	finally
    //   643	652	1026	finally
    //   657	666	1026	finally
    //   666	675	1026	finally
    //   680	691	1026	finally
    //   706	716	1026	finally
    //   737	799	1026	finally
    //   799	816	1026	finally
    //   820	830	1026	finally
    //   833	895	1026	finally
    //   902	927	1026	finally
    //   965	980	1026	finally
    //   986	1006	1026	finally
    //   98	110	1033	finally
  }
  
  static UnixResolverOptions parseEtcResolverOptions()
    throws IOException
  {
    return parseEtcResolverOptions(new File("/etc/resolv.conf"));
  }
  
  /* Error */
  static UnixResolverOptions parseEtcResolverOptions(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 313	io/netty/resolver/dns/UnixResolverOptions:newBuilder	()Lio/netty/resolver/dns/UnixResolverOptions$Builder;
    //   3: astore_1
    //   4: new 190	java/io/FileReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 193	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   12: astore_2
    //   13: new 195	java/io/BufferedReader
    //   16: astore_3
    //   17: aload_3
    //   18: aload_2
    //   19: invokespecial 198	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: aload_3
    //   23: invokevirtual 204	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +22 -> 50
    //   31: aload_0
    //   32: ldc 25
    //   34: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   37: ifeq -15 -> 22
    //   40: aload_0
    //   41: bipush 8
    //   43: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   46: aload_1
    //   47: invokestatic 317	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:parseResOptions	(Ljava/lang/String;Lio/netty/resolver/dns/UnixResolverOptions$Builder;)V
    //   50: aload_3
    //   51: invokevirtual 299	java/io/BufferedReader:close	()V
    //   54: getstatic 73	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:RES_OPTIONS	Ljava/lang/String;
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull +8 -> 67
    //   62: aload_0
    //   63: aload_1
    //   64: invokestatic 317	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:parseResOptions	(Ljava/lang/String;Lio/netty/resolver/dns/UnixResolverOptions$Builder;)V
    //   67: aload_1
    //   68: invokevirtual 322	io/netty/resolver/dns/UnixResolverOptions$Builder:build	()Lio/netty/resolver/dns/UnixResolverOptions;
    //   71: areturn
    //   72: astore_0
    //   73: goto +6 -> 79
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_3
    //   79: aload_3
    //   80: ifnonnull +10 -> 90
    //   83: aload_2
    //   84: invokevirtual 300	java/io/FileReader:close	()V
    //   87: goto +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 299	java/io/BufferedReader:close	()V
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramFile	File
    //   3	65	1	localBuilder	UnixResolverOptions.Builder
    //   12	72	2	localFileReader	java.io.FileReader
    //   16	75	3	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   22	27	72	finally
    //   31	50	72	finally
    //   13	22	76	finally
  }
  
  static List<String> parseEtcResolverSearchDomains()
    throws IOException
  {
    return parseEtcResolverSearchDomains(new File("/etc/resolv.conf"));
  }
  
  /* Error */
  static List<String> parseEtcResolverSearchDomains(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: new 200	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 329	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: new 190	java/io/FileReader
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 193	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   16: astore_2
    //   17: aconst_null
    //   18: astore_0
    //   19: new 195	java/io/BufferedReader
    //   22: astore_3
    //   23: aload_3
    //   24: aload_2
    //   25: invokespecial 198	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: aload_3
    //   29: invokevirtual 204	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +87 -> 123
    //   39: aload_0
    //   40: ifnonnull +38 -> 78
    //   43: aload 4
    //   45: ldc 10
    //   47: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +28 -> 78
    //   53: aload 4
    //   55: bipush 6
    //   57: invokestatic 222	io/netty/util/internal/StringUtil:indexOfNonWhiteSpace	(Ljava/lang/CharSequence;I)I
    //   60: istore 5
    //   62: iload 5
    //   64: iflt -36 -> 28
    //   67: aload 4
    //   69: iload 5
    //   71: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   74: astore_0
    //   75: goto -47 -> 28
    //   78: aload 4
    //   80: ldc 32
    //   82: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   85: ifeq -57 -> 28
    //   88: aload 4
    //   90: bipush 6
    //   92: invokestatic 222	io/netty/util/internal/StringUtil:indexOfNonWhiteSpace	(Ljava/lang/CharSequence;I)I
    //   95: istore 5
    //   97: iload 5
    //   99: iflt -71 -> 28
    //   102: aload_1
    //   103: getstatic 64	io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider:WHITESPACE_PATTERN	Ljava/util/regex/Pattern;
    //   106: aload 4
    //   108: iload 5
    //   110: invokevirtual 229	java/lang/String:substring	(I)Ljava/lang/String;
    //   113: invokevirtual 333	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
    //   116: invokestatic 339	java/util/Collections:addAll	(Ljava/util/Collection;[Ljava/lang/Object;)Z
    //   119: pop
    //   120: goto -92 -> 28
    //   123: aload_3
    //   124: invokevirtual 299	java/io/BufferedReader:close	()V
    //   127: aload_1
    //   128: astore 4
    //   130: aload_0
    //   131: ifnull +21 -> 152
    //   134: aload_1
    //   135: astore 4
    //   137: aload_1
    //   138: invokeinterface 273 1 0
    //   143: ifeq +9 -> 152
    //   146: aload_0
    //   147: invokestatic 343	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   150: astore 4
    //   152: aload 4
    //   154: areturn
    //   155: astore 4
    //   157: aload_3
    //   158: astore_0
    //   159: goto +7 -> 166
    //   162: astore 4
    //   164: aconst_null
    //   165: astore_0
    //   166: aload_0
    //   167: ifnonnull +10 -> 177
    //   170: aload_2
    //   171: invokevirtual 300	java/io/FileReader:close	()V
    //   174: goto +7 -> 181
    //   177: aload_0
    //   178: invokevirtual 299	java/io/BufferedReader:close	()V
    //   181: aload 4
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramFile	File
    //   7	131	1	localArrayList	java.util.ArrayList
    //   16	155	2	localFileReader	java.io.FileReader
    //   22	136	3	localBufferedReader	java.io.BufferedReader
    //   32	121	4	localObject1	Object
    //   155	1	4	localObject2	Object
    //   162	20	4	localObject3	Object
    //   60	49	5	i	int
    // Exception table:
    //   from	to	target	type
    //   28	34	155	finally
    //   43	62	155	finally
    //   67	75	155	finally
    //   78	97	155	finally
    //   102	120	155	finally
    //   19	28	162	finally
  }
  
  private static int parseResIntOption(String paramString1, String paramString2)
  {
    return Integer.parseInt(paramString1.substring(paramString2.length()));
  }
  
  private static void parseResOptions(String paramString, UnixResolverOptions.Builder paramBuilder)
  {
    paramString = WHITESPACE_PATTERN.split(paramString);
    int i = paramString.length;
    int j = 0;
    while (j < i)
    {
      String str = paramString[j];
      try
      {
        if (str.startsWith("ndots:")) {
          paramBuilder.setNdots(parseResIntOption(str, "ndots:"));
        } else if (str.startsWith("attempts:")) {
          paramBuilder.setAttempts(parseResIntOption(str, "attempts:"));
        } else if (str.startsWith("timeout:")) {
          paramBuilder.setTimeout(parseResIntOption(str, "timeout:"));
        }
        j++;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
  
  static DnsServerAddressStreamProvider parseSilently()
  {
    try
    {
      localObject = new io/netty/resolver/dns/UnixResolverDnsServerAddressStreamProvider;
      ((UnixResolverDnsServerAddressStreamProvider)localObject).<init>("/etc/resolv.conf", "/etc/resolver");
      if (!((UnixResolverDnsServerAddressStreamProvider)localObject).mayOverrideNameServers()) {
        localObject = DefaultDnsServerAddressStreamProvider.INSTANCE;
      }
      return (DnsServerAddressStreamProvider)localObject;
    }
    catch (Exception localException)
    {
      Object localObject = logger;
      if (((InternalLogger)localObject).isDebugEnabled()) {
        ((InternalLogger)localObject).debug("failed to parse {} and/or {}", new Object[] { "/etc/resolv.conf", "/etc/resolver", localException });
      }
    }
    return DefaultDnsServerAddressStreamProvider.INSTANCE;
  }
  
  private static void putIfAbsent(Map<String, DnsServerAddresses> paramMap, String paramString, DnsServerAddresses paramDnsServerAddresses)
  {
    DnsServerAddresses localDnsServerAddresses = (DnsServerAddresses)paramMap.put(paramString, paramDnsServerAddresses);
    if (localDnsServerAddresses != null)
    {
      paramMap.put(paramString, localDnsServerAddresses);
      paramMap = logger;
      if (paramMap.isDebugEnabled()) {
        paramMap.debug("Domain name {} already maps to addresses {} so new addresses {} will be discarded", new Object[] { paramString, localDnsServerAddresses, paramDnsServerAddresses });
      }
    }
  }
  
  private static void putIfAbsent(Map<String, DnsServerAddresses> paramMap, String paramString, List<InetSocketAddress> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramList = DnsServerAddresses.rotational(paramList);
    } else {
      paramList = DnsServerAddresses.sequential(paramList);
    }
    putIfAbsent(paramMap, paramString, paramList);
  }
  
  public DnsServerAddressStream nameServerAddressStream(String paramString)
  {
    for (;;)
    {
      int i = paramString.indexOf('.', 1);
      if ((i < 0) || (i == paramString.length() - 1)) {
        break;
      }
      DnsServerAddresses localDnsServerAddresses = (DnsServerAddresses)this.domainToNameServerStreamMap.get(paramString);
      if (localDnsServerAddresses != null) {
        return localDnsServerAddresses.stream();
      }
      paramString = paramString.substring(i + 1);
    }
    return this.defaultNameServerAddresses.stream();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\UnixResolverDnsServerAddressStreamProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */