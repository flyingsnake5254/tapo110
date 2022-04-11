package com.github.mikephil.charting.utils;

import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtils
{
  private static final String LOG = "MPChart-FileUtils";
  
  /* Error */
  public static List<BarEntry> loadBarEntriesFromAssets(android.content.res.AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: new 19	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 20	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aload 4
    //   15: astore 5
    //   17: new 22	java/io/BufferedReader
    //   20: astore 6
    //   22: aload 4
    //   24: astore 5
    //   26: new 24	java/io/InputStreamReader
    //   29: astore 7
    //   31: aload 4
    //   33: astore 5
    //   35: aload 7
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 30	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   42: ldc 32
    //   44: invokespecial 35	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   47: aload 4
    //   49: astore 5
    //   51: aload 6
    //   53: aload 7
    //   55: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: aload 6
    //   60: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +47 -> 112
    //   68: aload_0
    //   69: ldc 44
    //   71: invokevirtual 50	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   74: astore_1
    //   75: new 52	com/github/mikephil/charting/data/BarEntry
    //   78: astore_0
    //   79: aload_0
    //   80: aload_1
    //   81: iconst_1
    //   82: aaload
    //   83: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   86: aload_1
    //   87: iconst_0
    //   88: aaload
    //   89: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   92: invokespecial 61	com/github/mikephil/charting/data/BarEntry:<init>	(FF)V
    //   95: aload_2
    //   96: aload_0
    //   97: invokeinterface 67 2 0
    //   102: pop
    //   103: aload 6
    //   105: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   108: astore_0
    //   109: goto -45 -> 64
    //   112: aload 6
    //   114: invokevirtual 70	java/io/BufferedReader:close	()V
    //   117: goto +60 -> 177
    //   120: astore_0
    //   121: aload 6
    //   123: astore 5
    //   125: goto +54 -> 179
    //   128: astore_1
    //   129: aload 6
    //   131: astore_0
    //   132: goto +10 -> 142
    //   135: astore_0
    //   136: goto +43 -> 179
    //   139: astore_1
    //   140: aload_3
    //   141: astore_0
    //   142: aload_0
    //   143: astore 5
    //   145: ldc 8
    //   147: aload_1
    //   148: invokevirtual 73	java/io/IOException:toString	()Ljava/lang/String;
    //   151: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload_0
    //   156: ifnull +21 -> 177
    //   159: aload_0
    //   160: invokevirtual 70	java/io/BufferedReader:close	()V
    //   163: goto +14 -> 177
    //   166: astore_0
    //   167: ldc 8
    //   169: aload_0
    //   170: invokevirtual 73	java/io/IOException:toString	()Ljava/lang/String;
    //   173: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   176: pop
    //   177: aload_2
    //   178: areturn
    //   179: aload 5
    //   181: ifnull +22 -> 203
    //   184: aload 5
    //   186: invokevirtual 70	java/io/BufferedReader:close	()V
    //   189: goto +14 -> 203
    //   192: astore_1
    //   193: ldc 8
    //   195: aload_1
    //   196: invokevirtual 73	java/io/IOException:toString	()Ljava/lang/String;
    //   199: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   202: pop
    //   203: aload_0
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramAssetManager	android.content.res.AssetManager
    //   0	205	1	paramString	String
    //   7	171	2	localArrayList	ArrayList
    //   9	132	3	localObject1	Object
    //   11	37	4	localObject2	Object
    //   15	170	5	localObject3	Object
    //   20	110	6	localBufferedReader	BufferedReader
    //   29	25	7	localInputStreamReader	java.io.InputStreamReader
    // Exception table:
    //   from	to	target	type
    //   58	64	120	finally
    //   68	109	120	finally
    //   58	64	128	java/io/IOException
    //   68	109	128	java/io/IOException
    //   17	22	135	finally
    //   26	31	135	finally
    //   35	47	135	finally
    //   51	58	135	finally
    //   145	155	135	finally
    //   17	22	139	java/io/IOException
    //   26	31	139	java/io/IOException
    //   35	47	139	java/io/IOException
    //   51	58	139	java/io/IOException
    //   112	117	166	java/io/IOException
    //   159	163	166	java/io/IOException
    //   184	189	192	java/io/IOException
  }
  
  /* Error */
  public static List<Entry> loadEntriesFromAssets(android.content.res.AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: new 19	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 20	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aload 4
    //   15: astore 5
    //   17: new 22	java/io/BufferedReader
    //   20: astore 6
    //   22: aload 4
    //   24: astore 5
    //   26: new 24	java/io/InputStreamReader
    //   29: astore 7
    //   31: aload 4
    //   33: astore 5
    //   35: aload 7
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 30	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   42: ldc 32
    //   44: invokespecial 35	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   47: aload 4
    //   49: astore 5
    //   51: aload 6
    //   53: aload 7
    //   55: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: aload 6
    //   60: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +128 -> 193
    //   68: aload_0
    //   69: ldc 44
    //   71: invokevirtual 50	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   74: astore_0
    //   75: aload_0
    //   76: arraylength
    //   77: istore 8
    //   79: iconst_0
    //   80: istore 9
    //   82: iload 8
    //   84: iconst_2
    //   85: if_icmpgt +34 -> 119
    //   88: new 84	com/github/mikephil/charting/data/Entry
    //   91: astore_1
    //   92: aload_1
    //   93: aload_0
    //   94: iconst_1
    //   95: aaload
    //   96: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   99: aload_0
    //   100: iconst_0
    //   101: aaload
    //   102: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   105: invokespecial 85	com/github/mikephil/charting/data/Entry:<init>	(FF)V
    //   108: aload_2
    //   109: aload_1
    //   110: invokeinterface 67 2 0
    //   115: pop
    //   116: goto +68 -> 184
    //   119: aload_0
    //   120: arraylength
    //   121: iconst_1
    //   122: isub
    //   123: istore 8
    //   125: iload 8
    //   127: newarray <illegal type>
    //   129: astore 5
    //   131: iload 9
    //   133: iload 8
    //   135: if_icmpge +21 -> 156
    //   138: aload 5
    //   140: iload 9
    //   142: aload_0
    //   143: iload 9
    //   145: aaload
    //   146: invokestatic 58	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   149: fastore
    //   150: iinc 9 1
    //   153: goto -22 -> 131
    //   156: new 52	com/github/mikephil/charting/data/BarEntry
    //   159: astore_1
    //   160: aload_1
    //   161: aload_0
    //   162: aload_0
    //   163: arraylength
    //   164: iconst_1
    //   165: isub
    //   166: aaload
    //   167: invokestatic 91	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: i2f
    //   171: aload 5
    //   173: invokespecial 94	com/github/mikephil/charting/data/BarEntry:<init>	(F[F)V
    //   176: aload_2
    //   177: aload_1
    //   178: invokeinterface 67 2 0
    //   183: pop
    //   184: aload 6
    //   186: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   189: astore_0
    //   190: goto -126 -> 64
    //   193: aload 6
    //   195: invokevirtual 70	java/io/BufferedReader:close	()V
    //   198: goto +60 -> 258
    //   201: astore_0
    //   202: aload 6
    //   204: astore 5
    //   206: goto +54 -> 260
    //   209: astore_1
    //   210: aload 6
    //   212: astore_0
    //   213: goto +10 -> 223
    //   216: astore_0
    //   217: goto +43 -> 260
    //   220: astore_1
    //   221: aload_3
    //   222: astore_0
    //   223: aload_0
    //   224: astore 5
    //   226: ldc 8
    //   228: aload_1
    //   229: invokevirtual 73	java/io/IOException:toString	()Ljava/lang/String;
    //   232: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   235: pop
    //   236: aload_0
    //   237: ifnull +21 -> 258
    //   240: aload_0
    //   241: invokevirtual 70	java/io/BufferedReader:close	()V
    //   244: goto +14 -> 258
    //   247: astore_0
    //   248: ldc 8
    //   250: aload_0
    //   251: invokevirtual 73	java/io/IOException:toString	()Ljava/lang/String;
    //   254: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: aload_2
    //   259: areturn
    //   260: aload 5
    //   262: ifnull +22 -> 284
    //   265: aload 5
    //   267: invokevirtual 70	java/io/BufferedReader:close	()V
    //   270: goto +14 -> 284
    //   273: astore_1
    //   274: ldc 8
    //   276: aload_1
    //   277: invokevirtual 73	java/io/IOException:toString	()Ljava/lang/String;
    //   280: invokestatic 79	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   283: pop
    //   284: aload_0
    //   285: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramAssetManager	android.content.res.AssetManager
    //   0	286	1	paramString	String
    //   7	252	2	localArrayList	ArrayList
    //   9	213	3	localObject1	Object
    //   11	37	4	localObject2	Object
    //   15	251	5	localObject3	Object
    //   20	191	6	localBufferedReader	BufferedReader
    //   29	25	7	localInputStreamReader	java.io.InputStreamReader
    //   77	59	8	i	int
    //   80	71	9	j	int
    // Exception table:
    //   from	to	target	type
    //   58	64	201	finally
    //   68	79	201	finally
    //   88	116	201	finally
    //   119	131	201	finally
    //   138	150	201	finally
    //   156	184	201	finally
    //   184	190	201	finally
    //   58	64	209	java/io/IOException
    //   68	79	209	java/io/IOException
    //   88	116	209	java/io/IOException
    //   119	131	209	java/io/IOException
    //   138	150	209	java/io/IOException
    //   156	184	209	java/io/IOException
    //   184	190	209	java/io/IOException
    //   17	22	216	finally
    //   26	31	216	finally
    //   35	47	216	finally
    //   51	58	216	finally
    //   226	236	216	finally
    //   17	22	220	java/io/IOException
    //   26	31	220	java/io/IOException
    //   35	47	220	java/io/IOException
    //   51	58	220	java/io/IOException
    //   193	198	247	java/io/IOException
    //   240	244	247	java/io/IOException
    //   265	270	273	java/io/IOException
  }
  
  public static List<Entry> loadEntriesFromFile(String paramString)
  {
    Object localObject1 = new File(Environment.getExternalStorageDirectory(), paramString);
    paramString = new ArrayList();
    try
    {
      BufferedReader localBufferedReader = new java/io/BufferedReader;
      Object localObject2 = new java/io/FileReader;
      ((FileReader)localObject2).<init>((File)localObject1);
      localBufferedReader.<init>((Reader)localObject2);
      for (;;)
      {
        localObject2 = localBufferedReader.readLine();
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((String)localObject2).split("#");
        int i = localObject2.length;
        int j = 0;
        if (i <= 2)
        {
          localObject1 = new com/github/mikephil/charting/data/Entry;
          ((Entry)localObject1).<init>(Float.parseFloat(localObject2[0]), Integer.parseInt(localObject2[1]));
          paramString.add(localObject1);
        }
        else
        {
          i = localObject2.length - 1;
          float[] arrayOfFloat = new float[i];
          while (j < i)
          {
            arrayOfFloat[j] = Float.parseFloat(localObject2[j]);
            j++;
          }
          localObject1 = new com/github/mikephil/charting/data/BarEntry;
          ((BarEntry)localObject1).<init>(Integer.parseInt(localObject2[(localObject2.length - 1)]), arrayOfFloat);
          paramString.add(localObject1);
        }
      }
      return paramString;
    }
    catch (IOException localIOException)
    {
      Log.e("MPChart-FileUtils", localIOException.toString());
    }
  }
  
  public static void saveToSdCard(List<Entry> paramList, String paramString)
  {
    Object localObject1 = new File(Environment.getExternalStorageDirectory(), paramString);
    if (!((File)localObject1).exists()) {
      try
      {
        ((File)localObject1).createNewFile();
      }
      catch (IOException paramString)
      {
        Log.e("MPChart-FileUtils", paramString.toString());
      }
    }
    try
    {
      paramString = new java/io/BufferedWriter;
      Object localObject2 = new java/io/FileWriter;
      ((FileWriter)localObject2).<init>((File)localObject1, true);
      paramString.<init>((Writer)localObject2);
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Entry)((Iterator)localObject1).next();
        paramList = new java/lang/StringBuilder;
        paramList.<init>();
        paramList.append(((BaseEntry)localObject2).getY());
        paramList.append("#");
        paramList.append(((Entry)localObject2).getX());
        paramString.append(paramList.toString());
        paramString.newLine();
      }
      paramString.close();
    }
    catch (IOException paramList)
    {
      Log.e("MPChart-FileUtils", paramList.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */