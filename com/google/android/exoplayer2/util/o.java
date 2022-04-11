package com.google.android.exoplayer2.util;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

public final class o
{
  public static int a(@Nullable String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    paramString = y.r(paramString);
    paramString.hashCode();
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    i = -1;
                                                    break;
                                                  } while (!paramString.equals("video/x-matroska"));
                                                  i = 23;
                                                  break;
                                                } while (!paramString.equals("audio/webm"));
                                                i = 22;
                                                break;
                                              } while (!paramString.equals("audio/mpeg"));
                                              i = 21;
                                              break;
                                            } while (!paramString.equals("audio/flac"));
                                            i = 20;
                                            break;
                                          } while (!paramString.equals("audio/eac3"));
                                          i = 19;
                                          break;
                                        } while (!paramString.equals("audio/3gpp"));
                                        i = 18;
                                        break;
                                      } while (!paramString.equals("video/mp4"));
                                      i = 17;
                                      break;
                                    } while (!paramString.equals("audio/wav"));
                                    i = 16;
                                    break;
                                  } while (!paramString.equals("audio/ogg"));
                                  i = 15;
                                  break;
                                } while (!paramString.equals("audio/mp4"));
                                i = 14;
                                break;
                              } while (!paramString.equals("audio/amr"));
                              i = 13;
                              break;
                            } while (!paramString.equals("audio/ac4"));
                            i = 12;
                            break;
                          } while (!paramString.equals("audio/ac3"));
                          i = 11;
                          break;
                        } while (!paramString.equals("video/x-flv"));
                        i = 10;
                        break;
                      } while (!paramString.equals("application/webm"));
                      i = 9;
                      break;
                    } while (!paramString.equals("audio/x-matroska"));
                    i = 8;
                    break;
                  } while (!paramString.equals("text/vtt"));
                  i = 7;
                  break;
                } while (!paramString.equals("application/mp4"));
                i = 6;
                break;
              } while (!paramString.equals("image/jpeg"));
              i = 5;
              break;
            } while (!paramString.equals("audio/amr-wb"));
            i = 4;
            break;
          } while (!paramString.equals("video/webm"));
          i = 3;
          break;
        } while (!paramString.equals("video/mp2t"));
        i = 2;
        break;
      } while (!paramString.equals("video/mp2p"));
      i = 1;
      break;
    } while (!paramString.equals("audio/eac3-joc"));
    int i = 0;
    switch (i)
    {
    default: 
      return -1;
    case 21: 
      return 7;
    case 20: 
      return 4;
    case 16: 
      return 12;
    case 15: 
      return 9;
    case 12: 
      return 1;
    case 10: 
      return 5;
    case 7: 
      return 13;
    case 6: 
    case 14: 
    case 17: 
      return 8;
    case 5: 
      return 14;
    case 4: 
    case 13: 
    case 18: 
      return 3;
    case 3: 
    case 8: 
    case 9: 
    case 22: 
    case 23: 
      return 6;
    case 2: 
      return 11;
    case 1: 
      return 10;
    }
    return 0;
  }
  
  public static int b(Map<String, List<String>> paramMap)
  {
    paramMap = (List)paramMap.get("Content-Type");
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramMap = (String)paramMap.get(0);
    } else {
      paramMap = null;
    }
    return a(paramMap);
  }
  
  public static int c(Uri paramUri)
  {
    paramUri = paramUri.getLastPathSegment();
    if (paramUri == null) {
      return -1;
    }
    if ((!paramUri.endsWith(".ac3")) && (!paramUri.endsWith(".ec3")))
    {
      if (paramUri.endsWith(".ac4")) {
        return 1;
      }
      if ((!paramUri.endsWith(".adts")) && (!paramUri.endsWith(".aac")))
      {
        if (paramUri.endsWith(".amr")) {
          return 3;
        }
        if (paramUri.endsWith(".flac")) {
          return 4;
        }
        if (paramUri.endsWith(".flv")) {
          return 5;
        }
        if ((!paramUri.startsWith(".mk", paramUri.length() - 4)) && (!paramUri.endsWith(".webm")))
        {
          if (paramUri.endsWith(".mp3")) {
            return 7;
          }
          if ((!paramUri.endsWith(".mp4")) && (!paramUri.startsWith(".m4", paramUri.length() - 4)) && (!paramUri.startsWith(".mp4", paramUri.length() - 5)) && (!paramUri.startsWith(".cmf", paramUri.length() - 5)))
          {
            if ((!paramUri.startsWith(".og", paramUri.length() - 4)) && (!paramUri.endsWith(".opus")))
            {
              if ((!paramUri.endsWith(".ps")) && (!paramUri.endsWith(".mpeg")) && (!paramUri.endsWith(".mpg")) && (!paramUri.endsWith(".m2p")))
              {
                if ((!paramUri.endsWith(".ts")) && (!paramUri.startsWith(".ts", paramUri.length() - 4)))
                {
                  if ((!paramUri.endsWith(".wav")) && (!paramUri.endsWith(".wave")))
                  {
                    if ((!paramUri.endsWith(".vtt")) && (!paramUri.endsWith(".webvtt")))
                    {
                      if ((!paramUri.endsWith(".jpg")) && (!paramUri.endsWith(".jpeg"))) {
                        return -1;
                      }
                      return 14;
                    }
                    return 13;
                  }
                  return 12;
                }
                return 11;
              }
              return 10;
            }
            return 9;
          }
          return 8;
        }
        return 6;
      }
      return 2;
    }
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */