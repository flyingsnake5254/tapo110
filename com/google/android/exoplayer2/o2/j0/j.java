package com.google.android.exoplayer2.o2.j0;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.d0;

final class j
{
  @VisibleForTesting
  static final String[] a = { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient" };
  
  @Nullable
  private static CommentFrame a(int paramInt, d0 paramd0)
  {
    int i = paramd0.n();
    if (paramd0.n() == 1684108385)
    {
      paramd0.Q(8);
      paramd0 = paramd0.y(i - 16);
      return new CommentFrame("und", paramd0, paramd0);
    }
    paramd0 = String.valueOf(e.a(paramInt));
    if (paramd0.length() != 0) {
      paramd0 = "Failed to parse comment attribute: ".concat(paramd0);
    } else {
      paramd0 = new String("Failed to parse comment attribute: ");
    }
    com.google.android.exoplayer2.util.u.h("MetadataUtil", paramd0);
    return null;
  }
  
  @Nullable
  private static ApicFrame b(d0 paramd0)
  {
    int i = paramd0.n();
    if (paramd0.n() == 1684108385)
    {
      int j = e.b(paramd0.n());
      String str;
      if (j == 13) {
        str = "image/jpeg";
      } else if (j == 14) {
        str = "image/png";
      } else {
        str = null;
      }
      if (str == null)
      {
        paramd0 = new StringBuilder(41);
        paramd0.append("Unrecognized cover art flags: ");
        paramd0.append(j);
        com.google.android.exoplayer2.util.u.h("MetadataUtil", paramd0.toString());
        return null;
      }
      paramd0.Q(4);
      j = i - 16;
      byte[] arrayOfByte = new byte[j];
      paramd0.j(arrayOfByte, 0, j);
      return new ApicFrame(str, null, 3, arrayOfByte);
    }
    com.google.android.exoplayer2.util.u.h("MetadataUtil", "Failed to parse cover art attribute");
    return null;
  }
  
  @Nullable
  public static Metadata.Entry c(d0 paramd0)
  {
    i = paramd0.e() + paramd0.n();
    j = paramd0.n();
    k = j >> 24 & 0xFF;
    if ((k == 169) || (k == 253) || (j == 1735291493)) {}
    try
    {
      localObject1 = g(paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    finally
    {
      Object localObject1;
      break label798;
      if ((k == 7233901) || (k == 7631467)) {
        break label780;
      }
      if ((k == 6516589) || (k == 7828084)) {
        break label762;
      }
      if (k != 6578553) {
        break label555;
      }
      localObject3 = h(j, "TDRC", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      if (k != 4280916) {
        break label580;
      }
      localObject3 = h(j, "TPE1", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      if (k != 7630703) {
        break label605;
      }
      localObject3 = h(j, "TSSE", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      if (k != 6384738) {
        break label630;
      }
      localObject3 = h(j, "TALB", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      if (k != 7108978) {
        break label655;
      }
      localObject3 = h(j, "USLT", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      if (k != 6776174) {
        break label680;
      }
      localObject3 = h(j, "TCON", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      if (k != 6779504) {
        break label705;
      }
      localObject3 = h(j, "TIT1", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      localObject3 = String.valueOf(e.a(j));
      if (((String)localObject3).length() == 0) {
        break label735;
      }
      localObject3 = "Skipped unknown metadata entry: ".concat((String)localObject3);
      break label747;
      localObject3 = new String("Skipped unknown metadata entry: ");
      com.google.android.exoplayer2.util.u.b("MetadataUtil", (String)localObject3);
      paramd0.P(i);
      return null;
      localObject3 = h(j, "TCOM", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      localObject3 = h(j, "TIT2", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject3;
      paramd0.P(i);
    }
    if (j == 1684632427)
    {
      localObject1 = d(j, "TPOS", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1953655662)
    {
      localObject1 = d(j, "TRCK", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1953329263)
    {
      localObject1 = i(j, "TBPM", paramd0, true, false);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1668311404)
    {
      localObject1 = i(j, "TCMP", paramd0, true, true);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1668249202)
    {
      localObject1 = b(paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1631670868)
    {
      localObject1 = h(j, "TPE2", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1936682605)
    {
      localObject1 = h(j, "TSOT", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1936679276)
    {
      localObject1 = h(j, "TSO2", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1936679282)
    {
      localObject1 = h(j, "TSOA", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1936679265)
    {
      localObject1 = h(j, "TSOP", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1936679791)
    {
      localObject1 = h(j, "TSOC", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1920233063)
    {
      localObject1 = i(j, "ITUNESADVISORY", paramd0, false, false);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1885823344)
    {
      localObject1 = i(j, "ITUNESGAPLESS", paramd0, false, true);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1936683886)
    {
      localObject1 = h(j, "TVSHOWSORT", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 1953919848)
    {
      localObject1 = h(j, "TVSHOW", paramd0);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
    }
    if (j == 757935405)
    {
      localObject1 = e(paramd0, i);
      paramd0.P(i);
      return (Metadata.Entry)localObject1;
      k = 0xFFFFFF & j;
      if (k == 6516084)
      {
        localObject1 = a(j, paramd0);
        paramd0.P(i);
        return (Metadata.Entry)localObject1;
      }
    }
  }
  
  @Nullable
  private static TextInformationFrame d(int paramInt, String paramString, d0 paramd0)
  {
    int i = paramd0.n();
    if ((paramd0.n() == 1684108385) && (i >= 22))
    {
      paramd0.Q(10);
      i = paramd0.J();
      if (i > 0)
      {
        Object localObject = new StringBuilder(11);
        ((StringBuilder)localObject).append(i);
        localObject = ((StringBuilder)localObject).toString();
        paramInt = paramd0.J();
        paramd0 = (d0)localObject;
        if (paramInt > 0)
        {
          paramd0 = String.valueOf(localObject);
          localObject = new StringBuilder(paramd0.length() + 12);
          ((StringBuilder)localObject).append(paramd0);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(paramInt);
          paramd0 = ((StringBuilder)localObject).toString();
        }
        return new TextInformationFrame(paramString, null, paramd0);
      }
    }
    paramString = String.valueOf(e.a(paramInt));
    if (paramString.length() != 0) {
      paramString = "Failed to parse index/count attribute: ".concat(paramString);
    } else {
      paramString = new String("Failed to parse index/count attribute: ");
    }
    com.google.android.exoplayer2.util.u.h("MetadataUtil", paramString);
    return null;
  }
  
  @Nullable
  private static Id3Frame e(d0 paramd0, int paramInt)
  {
    String str1 = null;
    String str2 = str1;
    int i = -1;
    int j = -1;
    while (paramd0.e() < paramInt)
    {
      int k = paramd0.e();
      int m = paramd0.n();
      int n = paramd0.n();
      paramd0.Q(4);
      if (n == 1835360622)
      {
        str1 = paramd0.y(m - 12);
      }
      else if (n == 1851878757)
      {
        str2 = paramd0.y(m - 12);
      }
      else
      {
        if (n == 1684108385)
        {
          i = k;
          j = m;
        }
        paramd0.Q(m - 12);
      }
    }
    if ((str1 != null) && (str2 != null) && (i != -1))
    {
      paramd0.P(i);
      paramd0.Q(16);
      return new InternalFrame(str1, str2, paramd0.y(j - 16));
    }
    return null;
  }
  
  @Nullable
  public static MdtaMetadataEntry f(d0 paramd0, int paramInt, String paramString)
  {
    for (;;)
    {
      int i = paramd0.e();
      if (i >= paramInt) {
        break;
      }
      int j = paramd0.n();
      if (paramd0.n() == 1684108385)
      {
        i = paramd0.n();
        paramInt = paramd0.n();
        j -= 16;
        byte[] arrayOfByte = new byte[j];
        paramd0.j(arrayOfByte, 0, j);
        return new MdtaMetadataEntry(paramString, arrayOfByte, paramInt, i);
      }
      paramd0.P(i + j);
    }
    return null;
  }
  
  @Nullable
  private static TextInformationFrame g(d0 paramd0)
  {
    int i = j(paramd0);
    if (i > 0)
    {
      paramd0 = a;
      if (i <= paramd0.length)
      {
        paramd0 = paramd0[(i - 1)];
        break label30;
      }
    }
    paramd0 = null;
    label30:
    if (paramd0 != null) {
      return new TextInformationFrame("TCON", null, paramd0);
    }
    com.google.android.exoplayer2.util.u.h("MetadataUtil", "Failed to parse standard genre code");
    return null;
  }
  
  @Nullable
  private static TextInformationFrame h(int paramInt, String paramString, d0 paramd0)
  {
    int i = paramd0.n();
    if (paramd0.n() == 1684108385)
    {
      paramd0.Q(8);
      return new TextInformationFrame(paramString, null, paramd0.y(i - 16));
    }
    paramString = String.valueOf(e.a(paramInt));
    if (paramString.length() != 0) {
      paramString = "Failed to parse text attribute: ".concat(paramString);
    } else {
      paramString = new String("Failed to parse text attribute: ");
    }
    com.google.android.exoplayer2.util.u.h("MetadataUtil", paramString);
    return null;
  }
  
  @Nullable
  private static Id3Frame i(int paramInt, String paramString, d0 paramd0, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = j(paramd0);
    int j = i;
    if (paramBoolean2) {
      j = Math.min(1, i);
    }
    if (j >= 0)
    {
      if (paramBoolean1) {
        paramString = new TextInformationFrame(paramString, null, Integer.toString(j));
      } else {
        paramString = new CommentFrame("und", paramString, Integer.toString(j));
      }
      return paramString;
    }
    paramString = String.valueOf(e.a(paramInt));
    if (paramString.length() != 0) {
      paramString = "Failed to parse uint8 attribute: ".concat(paramString);
    } else {
      paramString = new String("Failed to parse uint8 attribute: ");
    }
    com.google.android.exoplayer2.util.u.h("MetadataUtil", paramString);
    return null;
  }
  
  private static int j(d0 paramd0)
  {
    paramd0.Q(4);
    if (paramd0.n() == 1684108385)
    {
      paramd0.Q(8);
      return paramd0.D();
    }
    com.google.android.exoplayer2.util.u.h("MetadataUtil", "Failed to parse uint8 attribute value");
    return -1;
  }
  
  public static void k(int paramInt, com.google.android.exoplayer2.o2.u paramu, Format.b paramb)
  {
    if ((paramInt == 1) && (paramu.a())) {
      paramb.M(paramu.b).N(paramu.c);
    }
  }
  
  public static void l(int paramInt, @Nullable Metadata paramMetadata1, @Nullable Metadata paramMetadata2, Format.b paramb, Metadata... paramVarArgs)
  {
    int i = 0;
    Metadata localMetadata = new Metadata(new Metadata.Entry[0]);
    if (paramInt == 1)
    {
      if (paramMetadata1 != null) {
        break label106;
      }
    }
    else if ((paramInt == 2) && (paramMetadata2 != null)) {
      for (paramInt = 0; paramInt < paramMetadata2.d(); paramInt++)
      {
        paramMetadata1 = paramMetadata2.c(paramInt);
        if ((paramMetadata1 instanceof MdtaMetadataEntry))
        {
          paramMetadata1 = (MdtaMetadataEntry)paramMetadata1;
          if ("com.android.capture.fps".equals(paramMetadata1.c))
          {
            paramMetadata1 = new Metadata(new Metadata.Entry[] { paramMetadata1 });
            break label106;
          }
        }
      }
    }
    paramMetadata1 = localMetadata;
    label106:
    int j = paramVarArgs.length;
    for (paramInt = i; paramInt < j; paramInt++) {
      paramMetadata1 = paramMetadata1.b(paramVarArgs[paramInt]);
    }
    if (paramMetadata1.d() > 0) {
      paramb.X(paramMetadata1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */