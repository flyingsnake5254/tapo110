package androidx.exifinterface.media;

import android.content.res.AssetManager.AssetInputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class ExifInterface
{
  public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
  public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
  static final Charset ASCII;
  public static final int[] BITS_PER_SAMPLE_GREYSCALE_1;
  public static final int[] BITS_PER_SAMPLE_GREYSCALE_2;
  public static final int[] BITS_PER_SAMPLE_RGB;
  static final short BYTE_ALIGN_II = 18761;
  static final short BYTE_ALIGN_MM = 19789;
  public static final int COLOR_SPACE_S_RGB = 1;
  public static final int COLOR_SPACE_UNCALIBRATED = 65535;
  public static final short CONTRAST_HARD = 2;
  public static final short CONTRAST_NORMAL = 0;
  public static final short CONTRAST_SOFT = 1;
  public static final int DATA_DEFLATE_ZIP = 8;
  public static final int DATA_HUFFMAN_COMPRESSED = 2;
  public static final int DATA_JPEG = 6;
  public static final int DATA_JPEG_COMPRESSED = 7;
  public static final int DATA_LOSSY_JPEG = 34892;
  public static final int DATA_PACK_BITS_COMPRESSED = 32773;
  public static final int DATA_UNCOMPRESSED = 1;
  private static final boolean DEBUG;
  static final byte[] EXIF_ASCII_PREFIX;
  private static final ExifTag[] EXIF_POINTER_TAGS;
  static final ExifTag[][] EXIF_TAGS;
  public static final short EXPOSURE_MODE_AUTO = 0;
  public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
  public static final short EXPOSURE_MODE_MANUAL = 1;
  public static final short EXPOSURE_PROGRAM_ACTION = 6;
  public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
  public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
  public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
  public static final short EXPOSURE_PROGRAM_MANUAL = 1;
  public static final short EXPOSURE_PROGRAM_NORMAL = 2;
  public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
  public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
  public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
  public static final short FILE_SOURCE_DSC = 3;
  public static final short FILE_SOURCE_OTHER = 0;
  public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
  public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
  public static final short FLAG_FLASH_FIRED = 1;
  public static final short FLAG_FLASH_MODE_AUTO = 24;
  public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
  public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
  public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
  public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
  public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
  public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
  private static final List<Integer> FLIPPED_ROTATION_ORDER;
  public static final short FORMAT_CHUNKY = 1;
  public static final short FORMAT_PLANAR = 2;
  public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
  public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
  public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
  public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
  public static final short GAIN_CONTROL_NONE = 0;
  public static final String GPS_DIRECTION_MAGNETIC = "M";
  public static final String GPS_DIRECTION_TRUE = "T";
  public static final String GPS_DISTANCE_KILOMETERS = "K";
  public static final String GPS_DISTANCE_MILES = "M";
  public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
  public static final String GPS_MEASUREMENT_2D = "2";
  public static final String GPS_MEASUREMENT_3D = "3";
  public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
  public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
  public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
  public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
  public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
  public static final String GPS_SPEED_KNOTS = "N";
  public static final String GPS_SPEED_MILES_PER_HOUR = "M";
  private static final byte[] HEIF_BRAND_HEIC;
  private static final byte[] HEIF_BRAND_MIF1;
  private static final byte[] HEIF_TYPE_FTYP;
  static final byte[] IDENTIFIER_EXIF_APP1;
  private static final byte[] IDENTIFIER_XMP_APP1;
  private static final ExifTag[] IFD_EXIF_TAGS;
  private static final int IFD_FORMAT_BYTE = 1;
  static final int[] IFD_FORMAT_BYTES_PER_FORMAT;
  private static final int IFD_FORMAT_DOUBLE = 12;
  private static final int IFD_FORMAT_IFD = 13;
  static final String[] IFD_FORMAT_NAMES;
  private static final int IFD_FORMAT_SBYTE = 6;
  private static final int IFD_FORMAT_SINGLE = 11;
  private static final int IFD_FORMAT_SLONG = 9;
  private static final int IFD_FORMAT_SRATIONAL = 10;
  private static final int IFD_FORMAT_SSHORT = 8;
  private static final int IFD_FORMAT_STRING = 2;
  private static final int IFD_FORMAT_ULONG = 4;
  private static final int IFD_FORMAT_UNDEFINED = 7;
  private static final int IFD_FORMAT_URATIONAL = 5;
  private static final int IFD_FORMAT_USHORT = 3;
  private static final ExifTag[] IFD_GPS_TAGS;
  private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
  private static final int IFD_OFFSET = 8;
  private static final ExifTag[] IFD_THUMBNAIL_TAGS;
  private static final ExifTag[] IFD_TIFF_TAGS;
  private static final int IFD_TYPE_EXIF = 1;
  private static final int IFD_TYPE_GPS = 2;
  private static final int IFD_TYPE_INTEROPERABILITY = 3;
  private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
  private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
  private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
  private static final int IFD_TYPE_PEF = 9;
  static final int IFD_TYPE_PREVIEW = 5;
  static final int IFD_TYPE_PRIMARY = 0;
  static final int IFD_TYPE_THUMBNAIL = 4;
  private static final int IMAGE_TYPE_ARW = 1;
  private static final int IMAGE_TYPE_CR2 = 2;
  private static final int IMAGE_TYPE_DNG = 3;
  private static final int IMAGE_TYPE_HEIF = 12;
  private static final int IMAGE_TYPE_JPEG = 4;
  private static final int IMAGE_TYPE_NEF = 5;
  private static final int IMAGE_TYPE_NRW = 6;
  private static final int IMAGE_TYPE_ORF = 7;
  private static final int IMAGE_TYPE_PEF = 8;
  private static final int IMAGE_TYPE_PNG = 13;
  private static final int IMAGE_TYPE_RAF = 9;
  private static final int IMAGE_TYPE_RW2 = 10;
  private static final int IMAGE_TYPE_SRW = 11;
  private static final int IMAGE_TYPE_UNKNOWN = 0;
  private static final int IMAGE_TYPE_WEBP = 14;
  private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG;
  private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG;
  static final byte[] JPEG_SIGNATURE;
  public static final String LATITUDE_NORTH = "N";
  public static final String LATITUDE_SOUTH = "S";
  public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
  public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
  public static final short LIGHT_SOURCE_D50 = 23;
  public static final short LIGHT_SOURCE_D55 = 20;
  public static final short LIGHT_SOURCE_D65 = 21;
  public static final short LIGHT_SOURCE_D75 = 22;
  public static final short LIGHT_SOURCE_DAYLIGHT = 1;
  public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
  public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
  public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
  public static final short LIGHT_SOURCE_FLASH = 4;
  public static final short LIGHT_SOURCE_FLUORESCENT = 2;
  public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
  public static final short LIGHT_SOURCE_OTHER = 255;
  public static final short LIGHT_SOURCE_SHADE = 11;
  public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
  public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
  public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
  public static final short LIGHT_SOURCE_TUNGSTEN = 3;
  public static final short LIGHT_SOURCE_UNKNOWN = 0;
  public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
  public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
  public static final String LONGITUDE_EAST = "E";
  public static final String LONGITUDE_WEST = "W";
  static final byte MARKER = -1;
  static final byte MARKER_APP1 = -31;
  private static final byte MARKER_COM = -2;
  static final byte MARKER_EOI = -39;
  private static final byte MARKER_SOF0 = -64;
  private static final byte MARKER_SOF1 = -63;
  private static final byte MARKER_SOF10 = -54;
  private static final byte MARKER_SOF11 = -53;
  private static final byte MARKER_SOF13 = -51;
  private static final byte MARKER_SOF14 = -50;
  private static final byte MARKER_SOF15 = -49;
  private static final byte MARKER_SOF2 = -62;
  private static final byte MARKER_SOF3 = -61;
  private static final byte MARKER_SOF5 = -59;
  private static final byte MARKER_SOF6 = -58;
  private static final byte MARKER_SOF7 = -57;
  private static final byte MARKER_SOF9 = -55;
  private static final byte MARKER_SOI = -40;
  private static final byte MARKER_SOS = -38;
  private static final int MAX_THUMBNAIL_SIZE = 512;
  public static final short METERING_MODE_AVERAGE = 1;
  public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
  public static final short METERING_MODE_MULTI_SPOT = 4;
  public static final short METERING_MODE_OTHER = 255;
  public static final short METERING_MODE_PARTIAL = 6;
  public static final short METERING_MODE_PATTERN = 5;
  public static final short METERING_MODE_SPOT = 3;
  public static final short METERING_MODE_UNKNOWN = 0;
  private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
  private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
  private static final byte[] ORF_MAKER_NOTE_HEADER_1;
  private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
  private static final byte[] ORF_MAKER_NOTE_HEADER_2;
  private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
  private static final ExifTag[] ORF_MAKER_NOTE_TAGS;
  private static final short ORF_SIGNATURE_1 = 20306;
  private static final short ORF_SIGNATURE_2 = 21330;
  public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
  public static final int ORIENTATION_FLIP_VERTICAL = 4;
  public static final int ORIENTATION_NORMAL = 1;
  public static final int ORIENTATION_ROTATE_180 = 3;
  public static final int ORIENTATION_ROTATE_270 = 8;
  public static final int ORIENTATION_ROTATE_90 = 6;
  public static final int ORIENTATION_TRANSPOSE = 5;
  public static final int ORIENTATION_TRANSVERSE = 7;
  public static final int ORIENTATION_UNDEFINED = 0;
  public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
  private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
  private static final String PEF_SIGNATURE = "PENTAX";
  private static final ExifTag[] PEF_TAGS;
  public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
  public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
  public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
  public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
  private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
  private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
  private static final byte[] PNG_CHUNK_TYPE_EXIF;
  private static final byte[] PNG_CHUNK_TYPE_IEND;
  private static final byte[] PNG_CHUNK_TYPE_IHDR;
  private static final byte[] PNG_SIGNATURE;
  private static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
  private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
  private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
  public static final int REDUCED_RESOLUTION_IMAGE = 1;
  public static final short RENDERED_PROCESS_CUSTOM = 1;
  public static final short RENDERED_PROCESS_NORMAL = 0;
  public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
  public static final short RESOLUTION_UNIT_INCHES = 2;
  private static final List<Integer> ROTATION_ORDER;
  private static final short RW2_SIGNATURE = 85;
  public static final short SATURATION_HIGH = 0;
  public static final short SATURATION_LOW = 0;
  public static final short SATURATION_NORMAL = 0;
  public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
  public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
  public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
  public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
  public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
  public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
  public static final short SENSITIVITY_TYPE_REI = 2;
  public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
  public static final short SENSITIVITY_TYPE_SOS = 1;
  public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
  public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
  public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
  public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
  public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
  public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
  public static final short SENSOR_TYPE_NOT_DEFINED = 1;
  public static final short SENSOR_TYPE_ONE_CHIP = 2;
  public static final short SENSOR_TYPE_THREE_CHIP = 4;
  public static final short SENSOR_TYPE_TRILINEAR = 7;
  public static final short SENSOR_TYPE_TWO_CHIP = 3;
  public static final short SHARPNESS_HARD = 2;
  public static final short SHARPNESS_NORMAL = 0;
  public static final short SHARPNESS_SOFT = 1;
  private static final int SIGNATURE_CHECK_SIZE = 5000;
  static final byte START_CODE = 42;
  public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
  public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
  public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
  public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
  public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
  public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
  private static final String TAG = "ExifInterface";
  public static final String TAG_APERTURE_VALUE = "ApertureValue";
  public static final String TAG_ARTIST = "Artist";
  public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
  public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
  public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
  @Deprecated
  public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
  public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
  public static final String TAG_CFA_PATTERN = "CFAPattern";
  public static final String TAG_COLOR_SPACE = "ColorSpace";
  public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
  public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
  public static final String TAG_COMPRESSION = "Compression";
  public static final String TAG_CONTRAST = "Contrast";
  public static final String TAG_COPYRIGHT = "Copyright";
  public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
  public static final String TAG_DATETIME = "DateTime";
  public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
  public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
  public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
  public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
  public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
  public static final String TAG_DNG_VERSION = "DNGVersion";
  private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
  public static final String TAG_EXIF_VERSION = "ExifVersion";
  public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
  public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
  public static final String TAG_EXPOSURE_MODE = "ExposureMode";
  public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
  public static final String TAG_EXPOSURE_TIME = "ExposureTime";
  public static final String TAG_FILE_SOURCE = "FileSource";
  public static final String TAG_FLASH = "Flash";
  public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
  public static final String TAG_FLASH_ENERGY = "FlashEnergy";
  public static final String TAG_FOCAL_LENGTH = "FocalLength";
  public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
  public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
  public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
  public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
  public static final String TAG_F_NUMBER = "FNumber";
  public static final String TAG_GAIN_CONTROL = "GainControl";
  public static final String TAG_GAMMA = "Gamma";
  public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
  public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
  public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
  public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
  public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
  public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
  public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
  public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
  public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
  public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
  public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
  public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
  public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
  public static final String TAG_GPS_DOP = "GPSDOP";
  public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
  public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
  public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
  private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
  public static final String TAG_GPS_LATITUDE = "GPSLatitude";
  public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
  public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
  public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
  public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
  public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
  public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
  public static final String TAG_GPS_SATELLITES = "GPSSatellites";
  public static final String TAG_GPS_SPEED = "GPSSpeed";
  public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
  public static final String TAG_GPS_STATUS = "GPSStatus";
  public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
  public static final String TAG_GPS_TRACK = "GPSTrack";
  public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
  public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
  public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
  public static final String TAG_IMAGE_LENGTH = "ImageLength";
  public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
  public static final String TAG_IMAGE_WIDTH = "ImageWidth";
  private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
  public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
  public static final String TAG_ISO_SPEED = "ISOSpeed";
  public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
  public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
  @Deprecated
  public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
  public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
  public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
  public static final String TAG_LENS_MAKE = "LensMake";
  public static final String TAG_LENS_MODEL = "LensModel";
  public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
  public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
  public static final String TAG_LIGHT_SOURCE = "LightSource";
  public static final String TAG_MAKE = "Make";
  public static final String TAG_MAKER_NOTE = "MakerNote";
  public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
  public static final String TAG_METERING_MODE = "MeteringMode";
  public static final String TAG_MODEL = "Model";
  public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
  public static final String TAG_OECF = "OECF";
  public static final String TAG_OFFSET_TIME = "OffsetTime";
  public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
  public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
  public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
  private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
  private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
  public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
  public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
  public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
  public static final String TAG_ORIENTATION = "Orientation";
  public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
  public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
  public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
  public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
  public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
  public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
  private static final ExifTag TAG_RAF_IMAGE_SIZE;
  public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
  public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
  public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
  public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
  public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
  public static final String TAG_RW2_ISO = "ISO";
  public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
  public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
  public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
  public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
  public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
  public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
  public static final String TAG_SATURATION = "Saturation";
  public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
  public static final String TAG_SCENE_TYPE = "SceneType";
  public static final String TAG_SENSING_METHOD = "SensingMethod";
  public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
  public static final String TAG_SHARPNESS = "Sharpness";
  public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
  public static final String TAG_SOFTWARE = "Software";
  public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
  public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
  public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
  public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
  public static final String TAG_STRIP_OFFSETS = "StripOffsets";
  public static final String TAG_SUBFILE_TYPE = "SubfileType";
  public static final String TAG_SUBJECT_AREA = "SubjectArea";
  public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
  public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
  public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
  public static final String TAG_SUBSEC_TIME = "SubSecTime";
  public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
  public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
  private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
  public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
  public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
  public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
  public static final String TAG_USER_COMMENT = "UserComment";
  public static final String TAG_WHITE_BALANCE = "WhiteBalance";
  public static final String TAG_WHITE_POINT = "WhitePoint";
  public static final String TAG_XMP = "Xmp";
  public static final String TAG_X_RESOLUTION = "XResolution";
  public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
  public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
  public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
  public static final String TAG_Y_RESOLUTION = "YResolution";
  private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
  private static final byte[] WEBP_CHUNK_TYPE_ANIM;
  private static final byte[] WEBP_CHUNK_TYPE_ANMF;
  private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
  private static final byte[] WEBP_CHUNK_TYPE_EXIF;
  private static final byte[] WEBP_CHUNK_TYPE_VP8;
  private static final byte[] WEBP_CHUNK_TYPE_VP8L;
  private static final byte[] WEBP_CHUNK_TYPE_VP8X;
  private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
  private static final byte[] WEBP_CHUNK_TYPE_XMP;
  private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
  private static final byte[] WEBP_SIGNATURE_1;
  private static final byte[] WEBP_SIGNATURE_2;
  private static final byte WEBP_VP8L_SIGNATURE = 47;
  private static final byte[] WEBP_VP8_SIGNATURE;
  @Deprecated
  public static final int WHITEBALANCE_AUTO = 0;
  @Deprecated
  public static final int WHITEBALANCE_MANUAL = 1;
  public static final short WHITE_BALANCE_AUTO = 0;
  public static final short WHITE_BALANCE_MANUAL = 1;
  public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
  public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
  private static final HashMap<Integer, Integer> sExifPointerTagMap;
  private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
  private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
  private static SimpleDateFormat sFormatter;
  private static final Pattern sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
  private static final Pattern sNonZeroTimePattern;
  private static final HashSet<String> sTagSetForCompatibility;
  private boolean mAreThumbnailStripsConsecutive;
  private AssetManager.AssetInputStream mAssetInputStream;
  private final HashMap<String, ExifAttribute>[] mAttributes;
  private Set<Integer> mAttributesOffsets;
  private ByteOrder mExifByteOrder;
  private int mExifOffset;
  private String mFilename;
  private boolean mHasThumbnail;
  private boolean mHasThumbnailStrips;
  private boolean mIsExifDataOnly;
  private boolean mIsSupportedFile;
  private int mMimeType;
  private boolean mModified;
  private int mOrfMakerNoteOffset;
  private int mOrfThumbnailLength;
  private int mOrfThumbnailOffset;
  private int mRw2JpgFromRawOffset;
  private FileDescriptor mSeekableFileDescriptor;
  private byte[] mThumbnailBytes;
  private int mThumbnailCompression;
  private int mThumbnailLength;
  private int mThumbnailOffset;
  private boolean mXmpIsFromSeparateMarker;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(3);
    DEBUG = Log.isLoggable("ExifInterface", 3);
    Integer localInteger2 = Integer.valueOf(1);
    Integer localInteger3 = Integer.valueOf(2);
    Integer localInteger4 = Integer.valueOf(8);
    ROTATION_ORDER = Arrays.asList(new Integer[] { localInteger2, Integer.valueOf(6), localInteger1, localInteger4 });
    Integer localInteger5 = Integer.valueOf(7);
    Integer localInteger6 = Integer.valueOf(5);
    FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[] { localInteger3, localInteger5, Integer.valueOf(4), localInteger6 });
    BITS_PER_SAMPLE_RGB = new int[] { 8, 8, 8 };
    BITS_PER_SAMPLE_GREYSCALE_1 = new int[] { 4 };
    BITS_PER_SAMPLE_GREYSCALE_2 = new int[] { 8 };
    JPEG_SIGNATURE = new byte[] { -1, -40, -1 };
    HEIF_TYPE_FTYP = new byte[] { 102, 116, 121, 112 };
    HEIF_BRAND_MIF1 = new byte[] { 109, 105, 102, 49 };
    HEIF_BRAND_HEIC = new byte[] { 104, 101, 105, 99 };
    ORF_MAKER_NOTE_HEADER_1 = new byte[] { 79, 76, 89, 77, 80, 0 };
    ORF_MAKER_NOTE_HEADER_2 = new byte[] { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
    PNG_SIGNATURE = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
    PNG_CHUNK_TYPE_EXIF = new byte[] { 101, 88, 73, 102 };
    PNG_CHUNK_TYPE_IHDR = new byte[] { 73, 72, 68, 82 };
    PNG_CHUNK_TYPE_IEND = new byte[] { 73, 69, 78, 68 };
    WEBP_SIGNATURE_1 = new byte[] { 82, 73, 70, 70 };
    WEBP_SIGNATURE_2 = new byte[] { 87, 69, 66, 80 };
    WEBP_CHUNK_TYPE_EXIF = new byte[] { 69, 88, 73, 70 };
    WEBP_VP8_SIGNATURE = new byte[] { -99, 1, 42 };
    WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    WEBP_CHUNK_TYPE_XMP = "XMP ".getBytes(Charset.defaultCharset());
    IFD_FORMAT_NAMES = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
    IFD_FORMAT_BYTES_PER_FORMAT = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
    EXIF_ASCII_PREFIX = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
    ExifTag[] arrayOfExifTag1 = new ExifTag[42];
    arrayOfExifTag1[0] = new ExifTag("NewSubfileType", 254, 4);
    arrayOfExifTag1[1] = new ExifTag("SubfileType", 255, 4);
    arrayOfExifTag1[2] = new ExifTag("ImageWidth", 256, 3, 4);
    arrayOfExifTag1[3] = new ExifTag("ImageLength", 257, 3, 4);
    arrayOfExifTag1[4] = new ExifTag("BitsPerSample", 258, 3);
    arrayOfExifTag1[5] = new ExifTag("Compression", 259, 3);
    arrayOfExifTag1[6] = new ExifTag("PhotometricInterpretation", 262, 3);
    arrayOfExifTag1[7] = new ExifTag("ImageDescription", 270, 2);
    arrayOfExifTag1[8] = new ExifTag("Make", 271, 2);
    arrayOfExifTag1[9] = new ExifTag("Model", 272, 2);
    arrayOfExifTag1[10] = new ExifTag("StripOffsets", 273, 3, 4);
    arrayOfExifTag1[11] = new ExifTag("Orientation", 274, 3);
    arrayOfExifTag1[12] = new ExifTag("SamplesPerPixel", 277, 3);
    arrayOfExifTag1[13] = new ExifTag("RowsPerStrip", 278, 3, 4);
    arrayOfExifTag1[14] = new ExifTag("StripByteCounts", 279, 3, 4);
    arrayOfExifTag1[15] = new ExifTag("XResolution", 282, 5);
    arrayOfExifTag1[16] = new ExifTag("YResolution", 283, 5);
    arrayOfExifTag1[17] = new ExifTag("PlanarConfiguration", 284, 3);
    arrayOfExifTag1[18] = new ExifTag("ResolutionUnit", 296, 3);
    arrayOfExifTag1[19] = new ExifTag("TransferFunction", 301, 3);
    arrayOfExifTag1[20] = new ExifTag("Software", 305, 2);
    arrayOfExifTag1[21] = new ExifTag("DateTime", 306, 2);
    arrayOfExifTag1[22] = new ExifTag("Artist", 315, 2);
    arrayOfExifTag1[23] = new ExifTag("WhitePoint", 318, 5);
    arrayOfExifTag1[24] = new ExifTag("PrimaryChromaticities", 319, 5);
    arrayOfExifTag1[25] = new ExifTag("SubIFDPointer", 330, 4);
    arrayOfExifTag1[26] = new ExifTag("JPEGInterchangeFormat", 513, 4);
    arrayOfExifTag1[27] = new ExifTag("JPEGInterchangeFormatLength", 514, 4);
    arrayOfExifTag1[28] = new ExifTag("YCbCrCoefficients", 529, 5);
    arrayOfExifTag1[29] = new ExifTag("YCbCrSubSampling", 530, 3);
    arrayOfExifTag1[30] = new ExifTag("YCbCrPositioning", 531, 3);
    arrayOfExifTag1[31] = new ExifTag("ReferenceBlackWhite", 532, 5);
    arrayOfExifTag1[32] = new ExifTag("Copyright", 33432, 2);
    arrayOfExifTag1[33] = new ExifTag("ExifIFDPointer", 34665, 4);
    arrayOfExifTag1[34] = new ExifTag("GPSInfoIFDPointer", 34853, 4);
    arrayOfExifTag1[35] = new ExifTag("SensorTopBorder", 4, 4);
    arrayOfExifTag1[36] = new ExifTag("SensorLeftBorder", 5, 4);
    arrayOfExifTag1[37] = new ExifTag("SensorBottomBorder", 6, 4);
    arrayOfExifTag1[38] = new ExifTag("SensorRightBorder", 7, 4);
    arrayOfExifTag1[39] = new ExifTag("ISO", 23, 3);
    arrayOfExifTag1[40] = new ExifTag("JpgFromRaw", 46, 7);
    arrayOfExifTag1[41] = new ExifTag("Xmp", 700, 1);
    IFD_TIFF_TAGS = arrayOfExifTag1;
    ExifTag[] arrayOfExifTag2 = new ExifTag[74];
    arrayOfExifTag2[0] = new ExifTag("ExposureTime", 33434, 5);
    arrayOfExifTag2[1] = new ExifTag("FNumber", 33437, 5);
    arrayOfExifTag2[2] = new ExifTag("ExposureProgram", 34850, 3);
    arrayOfExifTag2[3] = new ExifTag("SpectralSensitivity", 34852, 2);
    arrayOfExifTag2[4] = new ExifTag("PhotographicSensitivity", 34855, 3);
    arrayOfExifTag2[5] = new ExifTag("OECF", 34856, 7);
    arrayOfExifTag2[6] = new ExifTag("SensitivityType", 34864, 3);
    arrayOfExifTag2[7] = new ExifTag("StandardOutputSensitivity", 34865, 4);
    arrayOfExifTag2[8] = new ExifTag("RecommendedExposureIndex", 34866, 4);
    arrayOfExifTag2[9] = new ExifTag("ISOSpeed", 34867, 4);
    arrayOfExifTag2[10] = new ExifTag("ISOSpeedLatitudeyyy", 34868, 4);
    arrayOfExifTag2[11] = new ExifTag("ISOSpeedLatitudezzz", 34869, 4);
    arrayOfExifTag2[12] = new ExifTag("ExifVersion", 36864, 2);
    arrayOfExifTag2[13] = new ExifTag("DateTimeOriginal", 36867, 2);
    arrayOfExifTag2[14] = new ExifTag("DateTimeDigitized", 36868, 2);
    arrayOfExifTag2[15] = new ExifTag("OffsetTime", 36880, 2);
    arrayOfExifTag2[16] = new ExifTag("OffsetTimeOriginal", 36881, 2);
    arrayOfExifTag2[17] = new ExifTag("OffsetTimeDigitized", 36882, 2);
    arrayOfExifTag2[18] = new ExifTag("ComponentsConfiguration", 37121, 7);
    arrayOfExifTag2[19] = new ExifTag("CompressedBitsPerPixel", 37122, 5);
    arrayOfExifTag2[20] = new ExifTag("ShutterSpeedValue", 37377, 10);
    arrayOfExifTag2[21] = new ExifTag("ApertureValue", 37378, 5);
    arrayOfExifTag2[22] = new ExifTag("BrightnessValue", 37379, 10);
    arrayOfExifTag2[23] = new ExifTag("ExposureBiasValue", 37380, 10);
    arrayOfExifTag2[24] = new ExifTag("MaxApertureValue", 37381, 5);
    arrayOfExifTag2[25] = new ExifTag("SubjectDistance", 37382, 5);
    arrayOfExifTag2[26] = new ExifTag("MeteringMode", 37383, 3);
    arrayOfExifTag2[27] = new ExifTag("LightSource", 37384, 3);
    arrayOfExifTag2[28] = new ExifTag("Flash", 37385, 3);
    arrayOfExifTag2[29] = new ExifTag("FocalLength", 37386, 5);
    arrayOfExifTag2[30] = new ExifTag("SubjectArea", 37396, 3);
    arrayOfExifTag2[31] = new ExifTag("MakerNote", 37500, 7);
    arrayOfExifTag2[32] = new ExifTag("UserComment", 37510, 7);
    arrayOfExifTag2[33] = new ExifTag("SubSecTime", 37520, 2);
    arrayOfExifTag2[34] = new ExifTag("SubSecTimeOriginal", 37521, 2);
    arrayOfExifTag2[35] = new ExifTag("SubSecTimeDigitized", 37522, 2);
    arrayOfExifTag2[36] = new ExifTag("FlashpixVersion", 40960, 7);
    arrayOfExifTag2[37] = new ExifTag("ColorSpace", 40961, 3);
    arrayOfExifTag2[38] = new ExifTag("PixelXDimension", 40962, 3, 4);
    arrayOfExifTag2[39] = new ExifTag("PixelYDimension", 40963, 3, 4);
    arrayOfExifTag2[40] = new ExifTag("RelatedSoundFile", 40964, 2);
    arrayOfExifTag2[41] = new ExifTag("InteroperabilityIFDPointer", 40965, 4);
    arrayOfExifTag2[42] = new ExifTag("FlashEnergy", 41483, 5);
    arrayOfExifTag2[43] = new ExifTag("SpatialFrequencyResponse", 41484, 7);
    arrayOfExifTag2[44] = new ExifTag("FocalPlaneXResolution", 41486, 5);
    arrayOfExifTag2[45] = new ExifTag("FocalPlaneYResolution", 41487, 5);
    arrayOfExifTag2[46] = new ExifTag("FocalPlaneResolutionUnit", 41488, 3);
    arrayOfExifTag2[47] = new ExifTag("SubjectLocation", 41492, 3);
    arrayOfExifTag2[48] = new ExifTag("ExposureIndex", 41493, 5);
    arrayOfExifTag2[49] = new ExifTag("SensingMethod", 41495, 3);
    arrayOfExifTag2[50] = new ExifTag("FileSource", 41728, 7);
    arrayOfExifTag2[51] = new ExifTag("SceneType", 41729, 7);
    arrayOfExifTag2[52] = new ExifTag("CFAPattern", 41730, 7);
    arrayOfExifTag2[53] = new ExifTag("CustomRendered", 41985, 3);
    arrayOfExifTag2[54] = new ExifTag("ExposureMode", 41986, 3);
    arrayOfExifTag2[55] = new ExifTag("WhiteBalance", 41987, 3);
    arrayOfExifTag2[56] = new ExifTag("DigitalZoomRatio", 41988, 5);
    arrayOfExifTag2[57] = new ExifTag("FocalLengthIn35mmFilm", 41989, 3);
    arrayOfExifTag2[58] = new ExifTag("SceneCaptureType", 41990, 3);
    arrayOfExifTag2[59] = new ExifTag("GainControl", 41991, 3);
    arrayOfExifTag2[60] = new ExifTag("Contrast", 41992, 3);
    arrayOfExifTag2[61] = new ExifTag("Saturation", 41993, 3);
    arrayOfExifTag2[62] = new ExifTag("Sharpness", 41994, 3);
    arrayOfExifTag2[63] = new ExifTag("DeviceSettingDescription", 41995, 7);
    arrayOfExifTag2[64] = new ExifTag("SubjectDistanceRange", 41996, 3);
    arrayOfExifTag2[65] = new ExifTag("ImageUniqueID", 42016, 2);
    arrayOfExifTag2[66] = new ExifTag("CameraOwnerName", 42032, 2);
    arrayOfExifTag2[67] = new ExifTag("BodySerialNumber", 42033, 2);
    arrayOfExifTag2[68] = new ExifTag("LensSpecification", 42034, 5);
    arrayOfExifTag2[69] = new ExifTag("LensMake", 42035, 2);
    arrayOfExifTag2[70] = new ExifTag("LensModel", 42036, 2);
    arrayOfExifTag2[71] = new ExifTag("Gamma", 42240, 5);
    arrayOfExifTag2[72] = new ExifTag("DNGVersion", 50706, 1);
    arrayOfExifTag2[73] = new ExifTag("DefaultCropSize", 50720, 3, 4);
    IFD_EXIF_TAGS = arrayOfExifTag2;
    ExifTag[] arrayOfExifTag3 = new ExifTag[32];
    arrayOfExifTag3[0] = new ExifTag("GPSVersionID", 0, 1);
    arrayOfExifTag3[1] = new ExifTag("GPSLatitudeRef", 1, 2);
    arrayOfExifTag3[2] = new ExifTag("GPSLatitude", 2, 5);
    arrayOfExifTag3[3] = new ExifTag("GPSLongitudeRef", 3, 2);
    arrayOfExifTag3[4] = new ExifTag("GPSLongitude", 4, 5);
    arrayOfExifTag3[5] = new ExifTag("GPSAltitudeRef", 5, 1);
    arrayOfExifTag3[6] = new ExifTag("GPSAltitude", 6, 5);
    arrayOfExifTag3[7] = new ExifTag("GPSTimeStamp", 7, 5);
    arrayOfExifTag3[8] = new ExifTag("GPSSatellites", 8, 2);
    arrayOfExifTag3[9] = new ExifTag("GPSStatus", 9, 2);
    arrayOfExifTag3[10] = new ExifTag("GPSMeasureMode", 10, 2);
    arrayOfExifTag3[11] = new ExifTag("GPSDOP", 11, 5);
    arrayOfExifTag3[12] = new ExifTag("GPSSpeedRef", 12, 2);
    arrayOfExifTag3[13] = new ExifTag("GPSSpeed", 13, 5);
    arrayOfExifTag3[14] = new ExifTag("GPSTrackRef", 14, 2);
    arrayOfExifTag3[15] = new ExifTag("GPSTrack", 15, 5);
    arrayOfExifTag3[16] = new ExifTag("GPSImgDirectionRef", 16, 2);
    arrayOfExifTag3[17] = new ExifTag("GPSImgDirection", 17, 5);
    arrayOfExifTag3[18] = new ExifTag("GPSMapDatum", 18, 2);
    arrayOfExifTag3[19] = new ExifTag("GPSDestLatitudeRef", 19, 2);
    arrayOfExifTag3[20] = new ExifTag("GPSDestLatitude", 20, 5);
    arrayOfExifTag3[21] = new ExifTag("GPSDestLongitudeRef", 21, 2);
    arrayOfExifTag3[22] = new ExifTag("GPSDestLongitude", 22, 5);
    arrayOfExifTag3[23] = new ExifTag("GPSDestBearingRef", 23, 2);
    arrayOfExifTag3[24] = new ExifTag("GPSDestBearing", 24, 5);
    arrayOfExifTag3[25] = new ExifTag("GPSDestDistanceRef", 25, 2);
    arrayOfExifTag3[26] = new ExifTag("GPSDestDistance", 26, 5);
    arrayOfExifTag3[27] = new ExifTag("GPSProcessingMethod", 27, 7);
    arrayOfExifTag3[28] = new ExifTag("GPSAreaInformation", 28, 7);
    arrayOfExifTag3[29] = new ExifTag("GPSDateStamp", 29, 2);
    arrayOfExifTag3[30] = new ExifTag("GPSDifferential", 30, 3);
    arrayOfExifTag3[31] = new ExifTag("GPSHPositioningError", 31, 5);
    IFD_GPS_TAGS = arrayOfExifTag3;
    Object localObject1 = new ExifTag[1];
    localObject1[0] = new ExifTag("InteroperabilityIndex", 1, 2);
    IFD_INTEROPERABILITY_TAGS = (ExifTag[])localObject1;
    ExifTag[] arrayOfExifTag4 = new ExifTag[37];
    arrayOfExifTag4[0] = new ExifTag("NewSubfileType", 254, 4);
    arrayOfExifTag4[1] = new ExifTag("SubfileType", 255, 4);
    arrayOfExifTag4[2] = new ExifTag("ThumbnailImageWidth", 256, 3, 4);
    arrayOfExifTag4[3] = new ExifTag("ThumbnailImageLength", 257, 3, 4);
    arrayOfExifTag4[4] = new ExifTag("BitsPerSample", 258, 3);
    arrayOfExifTag4[5] = new ExifTag("Compression", 259, 3);
    arrayOfExifTag4[6] = new ExifTag("PhotometricInterpretation", 262, 3);
    arrayOfExifTag4[7] = new ExifTag("ImageDescription", 270, 2);
    arrayOfExifTag4[8] = new ExifTag("Make", 271, 2);
    arrayOfExifTag4[9] = new ExifTag("Model", 272, 2);
    arrayOfExifTag4[10] = new ExifTag("StripOffsets", 273, 3, 4);
    arrayOfExifTag4[11] = new ExifTag("ThumbnailOrientation", 274, 3);
    arrayOfExifTag4[12] = new ExifTag("SamplesPerPixel", 277, 3);
    arrayOfExifTag4[13] = new ExifTag("RowsPerStrip", 278, 3, 4);
    arrayOfExifTag4[14] = new ExifTag("StripByteCounts", 279, 3, 4);
    arrayOfExifTag4[15] = new ExifTag("XResolution", 282, 5);
    arrayOfExifTag4[16] = new ExifTag("YResolution", 283, 5);
    arrayOfExifTag4[17] = new ExifTag("PlanarConfiguration", 284, 3);
    arrayOfExifTag4[18] = new ExifTag("ResolutionUnit", 296, 3);
    arrayOfExifTag4[19] = new ExifTag("TransferFunction", 301, 3);
    arrayOfExifTag4[20] = new ExifTag("Software", 305, 2);
    arrayOfExifTag4[21] = new ExifTag("DateTime", 306, 2);
    arrayOfExifTag4[22] = new ExifTag("Artist", 315, 2);
    arrayOfExifTag4[23] = new ExifTag("WhitePoint", 318, 5);
    arrayOfExifTag4[24] = new ExifTag("PrimaryChromaticities", 319, 5);
    arrayOfExifTag4[25] = new ExifTag("SubIFDPointer", 330, 4);
    arrayOfExifTag4[26] = new ExifTag("JPEGInterchangeFormat", 513, 4);
    arrayOfExifTag4[27] = new ExifTag("JPEGInterchangeFormatLength", 514, 4);
    arrayOfExifTag4[28] = new ExifTag("YCbCrCoefficients", 529, 5);
    arrayOfExifTag4[29] = new ExifTag("YCbCrSubSampling", 530, 3);
    arrayOfExifTag4[30] = new ExifTag("YCbCrPositioning", 531, 3);
    arrayOfExifTag4[31] = new ExifTag("ReferenceBlackWhite", 532, 5);
    arrayOfExifTag4[32] = new ExifTag("Copyright", 33432, 2);
    arrayOfExifTag4[33] = new ExifTag("ExifIFDPointer", 34665, 4);
    arrayOfExifTag4[34] = new ExifTag("GPSInfoIFDPointer", 34853, 4);
    arrayOfExifTag4[35] = new ExifTag("DNGVersion", 50706, 1);
    arrayOfExifTag4[36] = new ExifTag("DefaultCropSize", 50720, 3, 4);
    IFD_THUMBNAIL_TAGS = arrayOfExifTag4;
    TAG_RAF_IMAGE_SIZE = new ExifTag("StripOffsets", 273, 3);
    ExifTag[] arrayOfExifTag5 = new ExifTag[3];
    arrayOfExifTag5[0] = new ExifTag("ThumbnailImage", 256, 7);
    arrayOfExifTag5[1] = new ExifTag("CameraSettingsIFDPointer", 8224, 4);
    arrayOfExifTag5[2] = new ExifTag("ImageProcessingIFDPointer", 8256, 4);
    ORF_MAKER_NOTE_TAGS = arrayOfExifTag5;
    ExifTag[] arrayOfExifTag6 = new ExifTag[2];
    arrayOfExifTag6[0] = new ExifTag("PreviewImageStart", 257, 4);
    arrayOfExifTag6[1] = new ExifTag("PreviewImageLength", 258, 4);
    ORF_CAMERA_SETTINGS_TAGS = arrayOfExifTag6;
    ExifTag[] arrayOfExifTag7 = new ExifTag[1];
    arrayOfExifTag7[0] = new ExifTag("AspectFrame", 4371, 3);
    ORF_IMAGE_PROCESSING_TAGS = arrayOfExifTag7;
    Object localObject2 = new ExifTag[1];
    localObject2[0] = new ExifTag("ColorSpace", 55, 3);
    PEF_TAGS = (ExifTag[])localObject2;
    ExifTag[][] arrayOfExifTag = new ExifTag[10][];
    arrayOfExifTag[0] = arrayOfExifTag1;
    arrayOfExifTag[1] = arrayOfExifTag2;
    arrayOfExifTag[2] = arrayOfExifTag3;
    arrayOfExifTag[3] = localObject1;
    arrayOfExifTag[4] = arrayOfExifTag4;
    arrayOfExifTag[5] = arrayOfExifTag1;
    arrayOfExifTag[6] = arrayOfExifTag5;
    arrayOfExifTag[7] = arrayOfExifTag6;
    arrayOfExifTag[8] = arrayOfExifTag7;
    arrayOfExifTag[9] = localObject2;
    EXIF_TAGS = arrayOfExifTag;
    EXIF_POINTER_TAGS = new ExifTag[] { new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1) };
    JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag("JPEGInterchangeFormat", 513, 4);
    JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag("JPEGInterchangeFormatLength", 514, 4);
    sExifTagMapsForReading = new HashMap[arrayOfExifTag.length];
    sExifTagMapsForWriting = new HashMap[arrayOfExifTag.length];
    sTagSetForCompatibility = new HashSet(Arrays.asList(new String[] { "FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp" }));
    sExifPointerTagMap = new HashMap();
    localObject1 = Charset.forName("US-ASCII");
    ASCII = (Charset)localObject1;
    IDENTIFIER_EXIF_APP1 = "Exif\000\000".getBytes((Charset)localObject1);
    IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\000".getBytes((Charset)localObject1);
    localObject1 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    sFormatter = (SimpleDateFormat)localObject1;
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    for (int i = 0;; i++)
    {
      localObject1 = EXIF_TAGS;
      if (i >= localObject1.length) {
        break;
      }
      sExifTagMapsForReading[i] = new HashMap();
      sExifTagMapsForWriting[i] = new HashMap();
      for (localObject1 : localObject1[i])
      {
        sExifTagMapsForReading[i].put(Integer.valueOf(((ExifTag)localObject1).number), localObject1);
        sExifTagMapsForWriting[i].put(((ExifTag)localObject1).name, localObject1);
      }
    }
    localObject2 = sExifPointerTagMap;
    localObject1 = EXIF_POINTER_TAGS;
    ((HashMap)localObject2).put(Integer.valueOf(localObject1[0].number), localInteger6);
    ((HashMap)localObject2).put(Integer.valueOf(localObject1[1].number), localInteger2);
    ((HashMap)localObject2).put(Integer.valueOf(localObject1[2].number), localInteger3);
    ((HashMap)localObject2).put(Integer.valueOf(localObject1[3].number), localInteger1);
    ((HashMap)localObject2).put(Integer.valueOf(localObject1[4].number), localInteger5);
    ((HashMap)localObject2).put(Integer.valueOf(localObject1[5].number), localInteger4);
    sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
  }
  
  public ExifInterface(@NonNull File paramFile)
    throws IOException
  {
    ExifTag[][] arrayOfExifTag = EXIF_TAGS;
    this.mAttributes = new HashMap[arrayOfExifTag.length];
    this.mAttributesOffsets = new HashSet(arrayOfExifTag.length);
    this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
    Objects.requireNonNull(paramFile, "file cannot be null");
    initForFilename(paramFile.getAbsolutePath());
  }
  
  /* Error */
  public ExifInterface(@NonNull FileDescriptor paramFileDescriptor)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1295	java/lang/Object:<init>	()V
    //   4: getstatic 1205	androidx/exifinterface/media/ExifInterface:EXIF_TAGS	[[Landroidx/exifinterface/media/ExifInterface$ExifTag;
    //   7: astore_2
    //   8: aload_0
    //   9: aload_2
    //   10: arraylength
    //   11: anewarray 1213	java/util/HashMap
    //   14: putfield 1297	androidx/exifinterface/media/ExifInterface:mAttributes	[Ljava/util/HashMap;
    //   17: aload_0
    //   18: new 1219	java/util/HashSet
    //   21: dup
    //   22: aload_2
    //   23: arraylength
    //   24: invokespecial 1300	java/util/HashSet:<init>	(I)V
    //   27: putfield 1302	androidx/exifinterface/media/ExifInterface:mAttributesOffsets	Ljava/util/Set;
    //   30: aload_0
    //   31: getstatic 1307	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   34: putfield 1309	androidx/exifinterface/media/ExifInterface:mExifByteOrder	Ljava/nio/ByteOrder;
    //   37: aload_1
    //   38: ldc_w 1333
    //   41: invokestatic 1317	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 1335	androidx/exifinterface/media/ExifInterface:mAssetInputStream	Landroid/content/res/AssetManager$AssetInputStream;
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   55: iconst_0
    //   56: istore_3
    //   57: getstatic 1342	android/os/Build$VERSION:SDK_INT	I
    //   60: bipush 21
    //   62: if_icmplt +38 -> 100
    //   65: aload_1
    //   66: invokestatic 1346	androidx/exifinterface/media/ExifInterface:isSeekableFD	(Ljava/io/FileDescriptor;)Z
    //   69: ifeq +31 -> 100
    //   72: aload_0
    //   73: aload_1
    //   74: putfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   77: aload_1
    //   78: invokestatic 1354	android/system/Os:dup	(Ljava/io/FileDescriptor;)Ljava/io/FileDescriptor;
    //   81: astore_1
    //   82: iconst_1
    //   83: istore_3
    //   84: goto +21 -> 105
    //   87: astore_1
    //   88: new 1293	java/io/IOException
    //   91: dup
    //   92: ldc_w 1356
    //   95: aload_1
    //   96: invokespecial 1359	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: athrow
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   105: new 1361	java/io/FileInputStream
    //   108: astore 4
    //   110: aload 4
    //   112: aload_1
    //   113: invokespecial 1363	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   116: aload_0
    //   117: aload 4
    //   119: invokespecial 1367	androidx/exifinterface/media/ExifInterface:loadAttributes	(Ljava/io/InputStream;)V
    //   122: aload 4
    //   124: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   127: iload_3
    //   128: ifeq +7 -> 135
    //   131: aload_1
    //   132: invokestatic 1374	androidx/exifinterface/media/ExifInterface:closeFileDescriptor	(Ljava/io/FileDescriptor;)V
    //   135: return
    //   136: astore_2
    //   137: goto +7 -> 144
    //   140: astore_2
    //   141: aconst_null
    //   142: astore 4
    //   144: aload 4
    //   146: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   149: iload_3
    //   150: ifeq +7 -> 157
    //   153: aload_1
    //   154: invokestatic 1374	androidx/exifinterface/media/ExifInterface:closeFileDescriptor	(Ljava/io/FileDescriptor;)V
    //   157: aload_2
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	ExifInterface
    //   0	159	1	paramFileDescriptor	FileDescriptor
    //   7	16	2	arrayOfExifTag	ExifTag[][]
    //   136	1	2	localObject1	Object
    //   140	18	2	localObject2	Object
    //   56	94	3	i	int
    //   108	37	4	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   77	82	87	java/lang/Exception
    //   116	122	136	finally
    //   105	116	140	finally
  }
  
  public ExifInterface(@NonNull InputStream paramInputStream)
    throws IOException
  {
    this(paramInputStream, false);
  }
  
  public ExifInterface(@NonNull InputStream paramInputStream, int paramInt)
    throws IOException
  {
    this(paramInputStream, bool);
  }
  
  private ExifInterface(@NonNull InputStream paramInputStream, boolean paramBoolean)
    throws IOException
  {
    Object localObject = EXIF_TAGS;
    this.mAttributes = new HashMap[localObject.length];
    this.mAttributesOffsets = new HashSet(localObject.length);
    this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
    Objects.requireNonNull(paramInputStream, "inputStream cannot be null");
    this.mFilename = null;
    if (paramBoolean)
    {
      paramInputStream = new BufferedInputStream(paramInputStream, 5000);
      if (!isExifDataOnly(paramInputStream))
      {
        Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
        return;
      }
      this.mIsExifDataOnly = true;
      this.mAssetInputStream = null;
      this.mSeekableFileDescriptor = null;
    }
    else if ((paramInputStream instanceof AssetManager.AssetInputStream))
    {
      this.mAssetInputStream = ((AssetManager.AssetInputStream)paramInputStream);
      this.mSeekableFileDescriptor = null;
    }
    else
    {
      if ((paramInputStream instanceof FileInputStream))
      {
        localObject = (FileInputStream)paramInputStream;
        if (isSeekableFD(((FileInputStream)localObject).getFD()))
        {
          this.mAssetInputStream = null;
          this.mSeekableFileDescriptor = ((FileInputStream)localObject).getFD();
          break label173;
        }
      }
      this.mAssetInputStream = null;
      this.mSeekableFileDescriptor = null;
    }
    label173:
    loadAttributes(paramInputStream);
  }
  
  public ExifInterface(@NonNull String paramString)
    throws IOException
  {
    ExifTag[][] arrayOfExifTag = EXIF_TAGS;
    this.mAttributes = new HashMap[arrayOfExifTag.length];
    this.mAttributesOffsets = new HashSet(arrayOfExifTag.length);
    this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
    Objects.requireNonNull(paramString, "filename cannot be null");
    initForFilename(paramString);
  }
  
  private void addDefaultValuesForCompatibility()
  {
    String str = getAttribute("DateTimeOriginal");
    if ((str != null) && (getAttribute("DateTime") == null)) {
      this.mAttributes[0].put("DateTime", ExifAttribute.createString(str));
    }
    if (getAttribute("ImageWidth") == null) {
      this.mAttributes[0].put("ImageWidth", ExifAttribute.createULong(0L, this.mExifByteOrder));
    }
    if (getAttribute("ImageLength") == null) {
      this.mAttributes[0].put("ImageLength", ExifAttribute.createULong(0L, this.mExifByteOrder));
    }
    if (getAttribute("Orientation") == null) {
      this.mAttributes[0].put("Orientation", ExifAttribute.createULong(0L, this.mExifByteOrder));
    }
    if (getAttribute("LightSource") == null) {
      this.mAttributes[1].put("LightSource", ExifAttribute.createULong(0L, this.mExifByteOrder));
    }
  }
  
  private static String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      localStringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
    }
    return localStringBuilder.toString();
  }
  
  private static void closeFileDescriptor(FileDescriptor paramFileDescriptor)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        Os.close(paramFileDescriptor);
      }
      catch (Exception paramFileDescriptor)
      {
        Log.e("ExifInterface", "Error closing fd.");
      }
    } else {
      Log.e("ExifInterface", "closeFileDescriptor is called in API < 21, which must be wrong.");
    }
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      try
      {
        paramCloseable.close();
      }
      catch (RuntimeException paramCloseable)
      {
        throw paramCloseable;
      }
      return;
    }
    catch (Exception paramCloseable)
    {
      for (;;) {}
    }
  }
  
  private String convertDecimalDegree(double paramDouble)
  {
    long l1 = paramDouble;
    paramDouble -= l1;
    long l2 = (paramDouble * 60.0D);
    long l3 = Math.round((paramDouble - l2 / 60.0D) * 3600.0D * 1.0E7D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1);
    localStringBuilder.append("/1,");
    localStringBuilder.append(l2);
    localStringBuilder.append("/1,");
    localStringBuilder.append(l3);
    localStringBuilder.append("/10000000");
    return localStringBuilder.toString();
  }
  
  private static double convertRationalLatLonToDouble(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.split(",", -1);
      String[] arrayOfString = paramString1[0].split("/", -1);
      double d1 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      arrayOfString = paramString1[1].split("/", -1);
      double d2 = Double.parseDouble(arrayOfString[0].trim()) / Double.parseDouble(arrayOfString[1].trim());
      paramString1 = paramString1[2].split("/", -1);
      double d3 = Double.parseDouble(paramString1[0].trim()) / Double.parseDouble(paramString1[1].trim());
      d1 = d1 + d2 / 60.0D + d3 / 3600.0D;
      if ((!paramString2.equals("S")) && (!paramString2.equals("W")))
      {
        if ((!paramString2.equals("N")) && (!paramString2.equals("E")))
        {
          paramString1 = new java/lang/IllegalArgumentException;
          paramString1.<init>();
          throw paramString1;
        }
        return d1;
      }
      return -d1;
    }
    catch (NumberFormatException|ArrayIndexOutOfBoundsException paramString1)
    {
      throw new IllegalArgumentException();
    }
  }
  
  private static long[] convertToLongArray(Object paramObject)
  {
    if ((paramObject instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramObject;
      paramObject = new long[arrayOfInt.length];
      for (int i = 0; i < arrayOfInt.length; i++) {
        paramObject[i] = arrayOfInt[i];
      }
      return (long[])paramObject;
    }
    if ((paramObject instanceof long[])) {
      return (long[])paramObject;
    }
    return null;
  }
  
  private static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[' '];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      i += j;
      paramOutputStream.write(arrayOfByte, 0, j);
    }
    return i;
  }
  
  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[' '];
    while (paramInt > 0)
    {
      int i = Math.min(paramInt, 8192);
      int j = paramInputStream.read(arrayOfByte, 0, i);
      if (j == i)
      {
        paramInt -= j;
        paramOutputStream.write(arrayOfByte, 0, j);
      }
      else
      {
        throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
      }
    }
  }
  
  private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream paramByteOrderedDataInputStream, ByteOrderedDataOutputStream paramByteOrderedDataOutputStream, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws IOException
  {
    byte[] arrayOfByte;
    do
    {
      arrayOfByte = new byte[4];
      if (paramByteOrderedDataInputStream.read(arrayOfByte) != 4)
      {
        paramByteOrderedDataOutputStream = new StringBuilder();
        paramByteOrderedDataOutputStream.append("Encountered invalid length while copying WebP chunks up tochunk type ");
        paramByteOrderedDataInputStream = ASCII;
        paramByteOrderedDataOutputStream.append(new String(paramArrayOfByte1, paramByteOrderedDataInputStream));
        if (paramArrayOfByte2 == null)
        {
          paramByteOrderedDataInputStream = "";
        }
        else
        {
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append(" or ");
          paramArrayOfByte1.append(new String(paramArrayOfByte2, paramByteOrderedDataInputStream));
          paramByteOrderedDataInputStream = paramArrayOfByte1.toString();
        }
        paramByteOrderedDataOutputStream.append(paramByteOrderedDataInputStream);
        throw new IOException(paramByteOrderedDataOutputStream.toString());
      }
      copyWebPChunk(paramByteOrderedDataInputStream, paramByteOrderedDataOutputStream, arrayOfByte);
    } while ((!Arrays.equals(arrayOfByte, paramArrayOfByte1)) && ((paramArrayOfByte2 == null) || (!Arrays.equals(arrayOfByte, paramArrayOfByte2))));
  }
  
  private void copyWebPChunk(ByteOrderedDataInputStream paramByteOrderedDataInputStream, ByteOrderedDataOutputStream paramByteOrderedDataOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramByteOrderedDataInputStream.readInt();
    paramByteOrderedDataOutputStream.write(paramArrayOfByte);
    paramByteOrderedDataOutputStream.writeInt(i);
    int j = i;
    if (i % 2 == 1) {
      j = i + 1;
    }
    copy(paramByteOrderedDataInputStream, paramByteOrderedDataOutputStream, j);
  }
  
  @Nullable
  private ExifAttribute getExifAttribute(@NonNull String paramString)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    String str = paramString;
    if ("ISOSpeedRatings".equals(paramString))
    {
      if (DEBUG) {
        Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
      }
      str = "PhotographicSensitivity";
    }
    for (int i = 0; i < EXIF_TAGS.length; i++)
    {
      paramString = (ExifAttribute)this.mAttributes[i].get(str);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  private void getHeifAttributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = new androidx/exifinterface/media/ExifInterface$1;
        ((1)localObject1).<init>(this, paramByteOrderedDataInputStream);
        localMediaMetadataRetriever.setDataSource((MediaDataSource)localObject1);
      }
      else
      {
        localObject1 = this.mSeekableFileDescriptor;
        if (localObject1 != null)
        {
          localMediaMetadataRetriever.setDataSource((FileDescriptor)localObject1);
        }
        else
        {
          localObject1 = this.mFilename;
          if (localObject1 == null) {
            break label550;
          }
          localMediaMetadataRetriever.setDataSource((String)localObject1);
        }
      }
      Object localObject2 = localMediaMetadataRetriever.extractMetadata(33);
      String str1 = localMediaMetadataRetriever.extractMetadata(34);
      Object localObject3 = localMediaMetadataRetriever.extractMetadata(26);
      Object localObject1 = localMediaMetadataRetriever.extractMetadata(17);
      boolean bool = "yes".equals(localObject3);
      String str2 = null;
      if (bool)
      {
        str2 = localMediaMetadataRetriever.extractMetadata(29);
        localObject1 = localMediaMetadataRetriever.extractMetadata(30);
        localObject3 = localMediaMetadataRetriever.extractMetadata(31);
      }
      else if ("yes".equals(localObject1))
      {
        str2 = localMediaMetadataRetriever.extractMetadata(18);
        localObject1 = localMediaMetadataRetriever.extractMetadata(19);
        localObject3 = localMediaMetadataRetriever.extractMetadata(24);
      }
      else
      {
        localObject1 = null;
        localObject3 = localObject1;
      }
      if (str2 != null) {
        this.mAttributes[0].put("ImageWidth", ExifAttribute.createUShort(Integer.parseInt(str2), this.mExifByteOrder));
      }
      if (localObject1 != null) {
        this.mAttributes[0].put("ImageLength", ExifAttribute.createUShort(Integer.parseInt((String)localObject1), this.mExifByteOrder));
      }
      int i;
      int j;
      if (localObject3 != null)
      {
        i = 1;
        j = Integer.parseInt((String)localObject3);
        if (j != 90)
        {
          if (j != 180)
          {
            if (j == 270) {
              i = 8;
            }
          }
          else {
            i = 3;
          }
        }
        else {
          i = 6;
        }
        this.mAttributes[0].put("Orientation", ExifAttribute.createUShort(i, this.mExifByteOrder));
      }
      if ((localObject2 != null) && (str1 != null))
      {
        i = Integer.parseInt((String)localObject2);
        j = Integer.parseInt(str1);
        if (j > 6)
        {
          paramByteOrderedDataInputStream.seek(i);
          localObject2 = new byte[6];
          if (paramByteOrderedDataInputStream.read((byte[])localObject2) == 6)
          {
            j -= 6;
            if (Arrays.equals((byte[])localObject2, IDENTIFIER_EXIF_APP1))
            {
              localObject2 = new byte[j];
              if (paramByteOrderedDataInputStream.read((byte[])localObject2) == j)
              {
                this.mExifOffset = (i + 6);
                readExifSegment((byte[])localObject2, 0);
              }
              else
              {
                paramByteOrderedDataInputStream = new java/io/IOException;
                paramByteOrderedDataInputStream.<init>("Can't read exif");
                throw paramByteOrderedDataInputStream;
              }
            }
            else
            {
              paramByteOrderedDataInputStream = new java/io/IOException;
              paramByteOrderedDataInputStream.<init>("Invalid identifier");
              throw paramByteOrderedDataInputStream;
            }
          }
          else
          {
            paramByteOrderedDataInputStream = new java/io/IOException;
            paramByteOrderedDataInputStream.<init>("Can't read identifier");
            throw paramByteOrderedDataInputStream;
          }
        }
        else
        {
          paramByteOrderedDataInputStream = new java/io/IOException;
          paramByteOrderedDataInputStream.<init>("Invalid exif length");
          throw paramByteOrderedDataInputStream;
        }
      }
      if (DEBUG)
      {
        paramByteOrderedDataInputStream = new java/lang/StringBuilder;
        paramByteOrderedDataInputStream.<init>();
        paramByteOrderedDataInputStream.append("Heif meta: ");
        paramByteOrderedDataInputStream.append(str2);
        paramByteOrderedDataInputStream.append("x");
        paramByteOrderedDataInputStream.append((String)localObject1);
        paramByteOrderedDataInputStream.append(", rotation ");
        paramByteOrderedDataInputStream.append((String)localObject3);
        Log.d("ExifInterface", paramByteOrderedDataInputStream.toString());
      }
      return;
      label550:
      return;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  private void getJpegAttributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject;
    if (DEBUG)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getJpegAttributes starting with: ");
      ((StringBuilder)localObject).append(paramByteOrderedDataInputStream);
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    paramByteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    paramByteOrderedDataInputStream.seek(paramInt1);
    int i = paramByteOrderedDataInputStream.readByte();
    if (i == -1)
    {
      if (paramByteOrderedDataInputStream.readByte() == -40)
      {
        for (paramInt1 = paramInt1 + 1 + 1;; paramInt1 = i + paramInt1)
        {
          i = paramByteOrderedDataInputStream.readByte();
          if (i != -1) {
            break label791;
          }
          int j = paramByteOrderedDataInputStream.readByte();
          boolean bool = DEBUG;
          if (bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Found JPEG segment indicator: ");
            ((StringBuilder)localObject).append(Integer.toHexString(j & 0xFF));
            Log.d("ExifInterface", ((StringBuilder)localObject).toString());
          }
          if ((j == -39) || (j == -38)) {
            break label782;
          }
          int k = paramByteOrderedDataInputStream.readUnsignedShort() - 2;
          i = paramInt1 + 1 + 1 + 2;
          if (bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("JPEG segment: ");
            ((StringBuilder)localObject).append(Integer.toHexString(j & 0xFF));
            ((StringBuilder)localObject).append(" (length: ");
            ((StringBuilder)localObject).append(k + 2);
            ((StringBuilder)localObject).append(")");
            Log.d("ExifInterface", ((StringBuilder)localObject).toString());
          }
          if (k < 0) {
            break label771;
          }
          if (j != -31)
          {
            if (j != -2)
            {
              switch (j)
              {
              default: 
                switch (j)
                {
                default: 
                  switch (j)
                  {
                  default: 
                    switch (j)
                    {
                    }
                    break;
                  }
                  break;
                }
                break;
              }
              for (paramInt1 = k;; paramInt1 = k - 5)
              {
                break label728;
                if (paramByteOrderedDataInputStream.skipBytes(1) != 1) {
                  break;
                }
                this.mAttributes[paramInt2].put("ImageLength", ExifAttribute.createULong(paramByteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                this.mAttributes[paramInt2].put("ImageWidth", ExifAttribute.createULong(paramByteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
              }
              throw new IOException("Invalid SOFx");
            }
            localObject = new byte[k];
            if (paramByteOrderedDataInputStream.read((byte[])localObject) == k)
            {
              if (getAttribute("UserComment") == null) {
                this.mAttributes[1].put("UserComment", ExifAttribute.createString(new String((byte[])localObject, ASCII)));
              }
              paramInt1 = i;
            }
          }
          for (;;)
          {
            break;
            throw new IOException("Invalid exif");
            localObject = new byte[k];
            paramByteOrderedDataInputStream.readFully((byte[])localObject);
            j = i + k;
            byte[] arrayOfByte = IDENTIFIER_EXIF_APP1;
            if (startsWith((byte[])localObject, arrayOfByte))
            {
              paramInt1 = arrayOfByte.length;
              localObject = Arrays.copyOfRange((byte[])localObject, arrayOfByte.length, k);
              this.mExifOffset = (i + paramInt1);
              readExifSegment((byte[])localObject, paramInt2);
              paramInt1 = j;
            }
            else
            {
              arrayOfByte = IDENTIFIER_XMP_APP1;
              paramInt1 = j;
              if (startsWith((byte[])localObject, arrayOfByte))
              {
                int m = arrayOfByte.length;
                localObject = Arrays.copyOfRange((byte[])localObject, arrayOfByte.length, k);
                paramInt1 = j;
                if (getAttribute("Xmp") == null)
                {
                  this.mAttributes[0].put("Xmp", new ExifAttribute(1, localObject.length, i + m, (byte[])localObject));
                  this.mXmpIsFromSeparateMarker = true;
                  paramInt1 = j;
                }
              }
            }
          }
          j = 0;
          i = paramInt1;
          paramInt1 = j;
          label728:
          if (paramInt1 < 0) {
            break label760;
          }
          if (paramByteOrderedDataInputStream.skipBytes(paramInt1) != paramInt1) {
            break;
          }
        }
        throw new IOException("Invalid JPEG segment");
        label760:
        throw new IOException("Invalid length");
        label771:
        throw new IOException("Invalid length");
        label782:
        paramByteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
        return;
        label791:
        paramByteOrderedDataInputStream = new StringBuilder();
        paramByteOrderedDataInputStream.append("Invalid marker:");
        paramByteOrderedDataInputStream.append(Integer.toHexString(i & 0xFF));
        throw new IOException(paramByteOrderedDataInputStream.toString());
      }
      paramByteOrderedDataInputStream = new StringBuilder();
      paramByteOrderedDataInputStream.append("Invalid marker: ");
      paramByteOrderedDataInputStream.append(Integer.toHexString(i & 0xFF));
      throw new IOException(paramByteOrderedDataInputStream.toString());
    }
    paramByteOrderedDataInputStream = new StringBuilder();
    paramByteOrderedDataInputStream.append("Invalid marker: ");
    paramByteOrderedDataInputStream.append(Integer.toHexString(i & 0xFF));
    throw new IOException(paramByteOrderedDataInputStream.toString());
  }
  
  private int getMimeType(BufferedInputStream paramBufferedInputStream)
    throws IOException
  {
    paramBufferedInputStream.mark(5000);
    byte[] arrayOfByte = new byte['ᎈ'];
    paramBufferedInputStream.read(arrayOfByte);
    paramBufferedInputStream.reset();
    if (isJpegFormat(arrayOfByte)) {
      return 4;
    }
    if (isRafFormat(arrayOfByte)) {
      return 9;
    }
    if (isHeifFormat(arrayOfByte)) {
      return 12;
    }
    if (isOrfFormat(arrayOfByte)) {
      return 7;
    }
    if (isRw2Format(arrayOfByte)) {
      return 10;
    }
    if (isPngFormat(arrayOfByte)) {
      return 13;
    }
    if (isWebpFormat(arrayOfByte)) {
      return 14;
    }
    return 0;
  }
  
  private void getOrfAttributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    getRawAttributes(paramByteOrderedDataInputStream);
    paramByteOrderedDataInputStream = (ExifAttribute)this.mAttributes[1].get("MakerNote");
    if (paramByteOrderedDataInputStream != null)
    {
      Object localObject = new ByteOrderedDataInputStream(paramByteOrderedDataInputStream.bytes);
      ((ByteOrderedDataInputStream)localObject).setByteOrder(this.mExifByteOrder);
      paramByteOrderedDataInputStream = ORF_MAKER_NOTE_HEADER_1;
      byte[] arrayOfByte1 = new byte[paramByteOrderedDataInputStream.length];
      ((ByteOrderedDataInputStream)localObject).readFully(arrayOfByte1);
      ((ByteOrderedDataInputStream)localObject).seek(0L);
      byte[] arrayOfByte2 = ORF_MAKER_NOTE_HEADER_2;
      byte[] arrayOfByte3 = new byte[arrayOfByte2.length];
      ((ByteOrderedDataInputStream)localObject).readFully(arrayOfByte3);
      if (Arrays.equals(arrayOfByte1, paramByteOrderedDataInputStream)) {
        ((ByteOrderedDataInputStream)localObject).seek(8L);
      } else if (Arrays.equals(arrayOfByte3, arrayOfByte2)) {
        ((ByteOrderedDataInputStream)localObject).seek(12L);
      }
      readImageFileDirectory((ByteOrderedDataInputStream)localObject, 6);
      localObject = (ExifAttribute)this.mAttributes[7].get("PreviewImageStart");
      paramByteOrderedDataInputStream = (ExifAttribute)this.mAttributes[7].get("PreviewImageLength");
      if ((localObject != null) && (paramByteOrderedDataInputStream != null))
      {
        this.mAttributes[5].put("JPEGInterchangeFormat", localObject);
        this.mAttributes[5].put("JPEGInterchangeFormatLength", paramByteOrderedDataInputStream);
      }
      paramByteOrderedDataInputStream = (ExifAttribute)this.mAttributes[8].get("AspectFrame");
      if (paramByteOrderedDataInputStream != null)
      {
        localObject = (int[])paramByteOrderedDataInputStream.getValue(this.mExifByteOrder);
        if ((localObject != null) && (localObject.length == 4))
        {
          if ((localObject[2] > localObject[0]) && (localObject[3] > localObject[1]))
          {
            int i = localObject[2] - localObject[0] + 1;
            int j = localObject[3] - localObject[1] + 1;
            int k = i;
            int m = j;
            if (i < j)
            {
              k = i + j;
              m = k - j;
              k -= m;
            }
            paramByteOrderedDataInputStream = ExifAttribute.createUShort(k, this.mExifByteOrder);
            localObject = ExifAttribute.createUShort(m, this.mExifByteOrder);
            this.mAttributes[0].put("ImageWidth", paramByteOrderedDataInputStream);
            this.mAttributes[0].put("ImageLength", localObject);
          }
        }
        else
        {
          paramByteOrderedDataInputStream = new StringBuilder();
          paramByteOrderedDataInputStream.append("Invalid aspect frame values. frame=");
          paramByteOrderedDataInputStream.append(Arrays.toString((int[])localObject));
          Log.w("ExifInterface", paramByteOrderedDataInputStream.toString());
        }
      }
    }
  }
  
  private void getPngAttributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    if (DEBUG)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getPngAttributes starting with: ");
      ((StringBuilder)localObject1).append(paramByteOrderedDataInputStream);
      Log.d("ExifInterface", ((StringBuilder)localObject1).toString());
    }
    paramByteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    Object localObject1 = PNG_SIGNATURE;
    paramByteOrderedDataInputStream.skipBytes(localObject1.length);
    int i = localObject1.length + 0;
    try
    {
      for (;;)
      {
        int j = paramByteOrderedDataInputStream.readInt();
        localObject1 = new byte[4];
        if (paramByteOrderedDataInputStream.read((byte[])localObject1) != 4) {
          break;
        }
        i = i + 4 + 4;
        if ((i == 16) && (!Arrays.equals((byte[])localObject1, PNG_CHUNK_TYPE_IHDR)))
        {
          paramByteOrderedDataInputStream = new java/io/IOException;
          paramByteOrderedDataInputStream.<init>("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
          throw paramByteOrderedDataInputStream;
        }
        if (!Arrays.equals((byte[])localObject1, PNG_CHUNK_TYPE_IEND))
        {
          if (!Arrays.equals((byte[])localObject1, PNG_CHUNK_TYPE_EXIF)) {
            break label314;
          }
          localObject2 = new byte[j];
          if (paramByteOrderedDataInputStream.read((byte[])localObject2) != j) {
            break label272;
          }
          j = paramByteOrderedDataInputStream.readInt();
          paramByteOrderedDataInputStream = new java/util/zip/CRC32;
          paramByteOrderedDataInputStream.<init>();
          paramByteOrderedDataInputStream.update((byte[])localObject1);
          paramByteOrderedDataInputStream.update((byte[])localObject2);
          if ((int)paramByteOrderedDataInputStream.getValue() == j)
          {
            this.mExifOffset = i;
            readExifSegment((byte[])localObject2, 0);
            validateImages();
          }
        }
        else
        {
          return;
        }
        localObject1 = new java/io/IOException;
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(", calculated CRC value: ");
        ((StringBuilder)localObject2).append(paramByteOrderedDataInputStream.getValue());
        ((IOException)localObject1).<init>(((StringBuilder)localObject2).toString());
        throw ((Throwable)localObject1);
        label272:
        localObject2 = new java/io/IOException;
        paramByteOrderedDataInputStream = new java/lang/StringBuilder;
        paramByteOrderedDataInputStream.<init>();
        paramByteOrderedDataInputStream.append("Failed to read given length for given PNG chunk type: ");
        paramByteOrderedDataInputStream.append(byteArrayToHexString((byte[])localObject1));
        ((IOException)localObject2).<init>(paramByteOrderedDataInputStream.toString());
        throw ((Throwable)localObject2);
        label314:
        j += 4;
        paramByteOrderedDataInputStream.skipBytes(j);
        i += j;
      }
      paramByteOrderedDataInputStream = new java/io/IOException;
      paramByteOrderedDataInputStream.<init>("Encountered invalid length while parsing PNG chunktype");
      throw paramByteOrderedDataInputStream;
    }
    catch (EOFException paramByteOrderedDataInputStream)
    {
      throw new IOException("Encountered corrupt PNG file.");
    }
  }
  
  private void getRafAttributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    paramByteOrderedDataInputStream.skipBytes(84);
    Object localObject = new byte[4];
    byte[] arrayOfByte = new byte[4];
    paramByteOrderedDataInputStream.read((byte[])localObject);
    paramByteOrderedDataInputStream.skipBytes(4);
    paramByteOrderedDataInputStream.read(arrayOfByte);
    int i = ByteBuffer.wrap((byte[])localObject).getInt();
    int j = ByteBuffer.wrap(arrayOfByte).getInt();
    getJpegAttributes(paramByteOrderedDataInputStream, i, 5);
    paramByteOrderedDataInputStream.seek(j);
    paramByteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    i = paramByteOrderedDataInputStream.readInt();
    if (DEBUG)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("numberOfDirectoryEntry: ");
      ((StringBuilder)localObject).append(i);
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    for (j = 0; j < i; j++)
    {
      int k = paramByteOrderedDataInputStream.readUnsignedShort();
      int m = paramByteOrderedDataInputStream.readUnsignedShort();
      if (k == TAG_RAF_IMAGE_SIZE.number)
      {
        j = paramByteOrderedDataInputStream.readShort();
        i = paramByteOrderedDataInputStream.readShort();
        localObject = ExifAttribute.createUShort(j, this.mExifByteOrder);
        paramByteOrderedDataInputStream = ExifAttribute.createUShort(i, this.mExifByteOrder);
        this.mAttributes[0].put("ImageLength", localObject);
        this.mAttributes[0].put("ImageWidth", paramByteOrderedDataInputStream);
        if (DEBUG)
        {
          paramByteOrderedDataInputStream = new StringBuilder();
          paramByteOrderedDataInputStream.append("Updated to length: ");
          paramByteOrderedDataInputStream.append(j);
          paramByteOrderedDataInputStream.append(", width: ");
          paramByteOrderedDataInputStream.append(i);
          Log.d("ExifInterface", paramByteOrderedDataInputStream.toString());
        }
        return;
      }
      paramByteOrderedDataInputStream.skipBytes(m);
    }
  }
  
  private void getRawAttributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    parseTiffHeaders(paramByteOrderedDataInputStream, paramByteOrderedDataInputStream.available());
    readImageFileDirectory(paramByteOrderedDataInputStream, 0);
    updateImageSizeValues(paramByteOrderedDataInputStream, 0);
    updateImageSizeValues(paramByteOrderedDataInputStream, 5);
    updateImageSizeValues(paramByteOrderedDataInputStream, 4);
    validateImages();
    if (this.mMimeType == 8)
    {
      paramByteOrderedDataInputStream = (ExifAttribute)this.mAttributes[1].get("MakerNote");
      if (paramByteOrderedDataInputStream != null)
      {
        paramByteOrderedDataInputStream = new ByteOrderedDataInputStream(paramByteOrderedDataInputStream.bytes);
        paramByteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
        paramByteOrderedDataInputStream.seek(6L);
        readImageFileDirectory(paramByteOrderedDataInputStream, 9);
        paramByteOrderedDataInputStream = (ExifAttribute)this.mAttributes[9].get("ColorSpace");
        if (paramByteOrderedDataInputStream != null) {
          this.mAttributes[1].put("ColorSpace", paramByteOrderedDataInputStream);
        }
      }
    }
  }
  
  private void getRw2Attributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    getRawAttributes(paramByteOrderedDataInputStream);
    if ((ExifAttribute)this.mAttributes[0].get("JpgFromRaw") != null) {
      getJpegAttributes(paramByteOrderedDataInputStream, this.mRw2JpgFromRawOffset, 5);
    }
    ExifAttribute localExifAttribute = (ExifAttribute)this.mAttributes[0].get("ISO");
    paramByteOrderedDataInputStream = (ExifAttribute)this.mAttributes[1].get("PhotographicSensitivity");
    if ((localExifAttribute != null) && (paramByteOrderedDataInputStream == null)) {
      this.mAttributes[1].put("PhotographicSensitivity", localExifAttribute);
    }
  }
  
  private void getStandaloneAttributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    byte[] arrayOfByte1 = IDENTIFIER_EXIF_APP1;
    paramByteOrderedDataInputStream.skipBytes(arrayOfByte1.length);
    byte[] arrayOfByte2 = new byte[paramByteOrderedDataInputStream.available()];
    paramByteOrderedDataInputStream.readFully(arrayOfByte2);
    this.mExifOffset = arrayOfByte1.length;
    readExifSegment(arrayOfByte2, 0);
  }
  
  private void getWebpAttributes(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    Object localObject1;
    if (DEBUG)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getWebpAttributes starting with: ");
      ((StringBuilder)localObject1).append(paramByteOrderedDataInputStream);
      Log.d("ExifInterface", ((StringBuilder)localObject1).toString());
    }
    paramByteOrderedDataInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
    paramByteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_1.length);
    int i = paramByteOrderedDataInputStream.readInt() + 8;
    int j = paramByteOrderedDataInputStream.skipBytes(WEBP_SIGNATURE_2.length) + 8;
    try
    {
      for (;;)
      {
        localObject1 = new byte[4];
        if (paramByteOrderedDataInputStream.read((byte[])localObject1) != 4) {
          break label283;
        }
        int k = paramByteOrderedDataInputStream.readInt();
        int m = j + 4 + 4;
        if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, (byte[])localObject1))
        {
          Object localObject2 = new byte[k];
          if (paramByteOrderedDataInputStream.read((byte[])localObject2) == k)
          {
            this.mExifOffset = m;
            readExifSegment((byte[])localObject2, 0);
            this.mExifOffset = m;
          }
          else
          {
            localObject2 = new java/io/IOException;
            paramByteOrderedDataInputStream = new java/lang/StringBuilder;
            paramByteOrderedDataInputStream.<init>();
            paramByteOrderedDataInputStream.append("Failed to read given length for given PNG chunk type: ");
            paramByteOrderedDataInputStream.append(byteArrayToHexString((byte[])localObject1));
            ((IOException)localObject2).<init>(paramByteOrderedDataInputStream.toString());
            throw ((Throwable)localObject2);
          }
        }
        else
        {
          j = k;
          if (k % 2 == 1) {
            j = k + 1;
          }
          k = m + j;
          if (k != i) {
            break label226;
          }
        }
        return;
        label226:
        if (k > i) {
          break label270;
        }
        k = paramByteOrderedDataInputStream.skipBytes(j);
        if (k != j) {
          break;
        }
        j = m + k;
      }
      paramByteOrderedDataInputStream = new java/io/IOException;
      paramByteOrderedDataInputStream.<init>("Encountered WebP file with invalid chunk size");
      throw paramByteOrderedDataInputStream;
      label270:
      paramByteOrderedDataInputStream = new java/io/IOException;
      paramByteOrderedDataInputStream.<init>("Encountered WebP file with invalid chunk size");
      throw paramByteOrderedDataInputStream;
      label283:
      paramByteOrderedDataInputStream = new java/io/IOException;
      paramByteOrderedDataInputStream.<init>("Encountered invalid length while parsing WebP chunktype");
      throw paramByteOrderedDataInputStream;
    }
    catch (EOFException paramByteOrderedDataInputStream)
    {
      throw new IOException("Encountered corrupt WebP file.");
    }
  }
  
  private static Pair<Integer, Integer> guessDataFormat(String paramString)
  {
    boolean bool = paramString.contains(",");
    int i = 1;
    Integer localInteger1 = Integer.valueOf(2);
    Integer localInteger2 = Integer.valueOf(-1);
    Object localObject;
    if (bool)
    {
      String[] arrayOfString = paramString.split(",", -1);
      localObject = guessDataFormat(arrayOfString[0]);
      paramString = (String)localObject;
      if (((Integer)((Pair)localObject).first).intValue() == 2) {
        return (Pair<Integer, Integer>)localObject;
      }
      while (i < arrayOfString.length)
      {
        localObject = guessDataFormat(arrayOfString[i]);
        int j;
        if ((!((Integer)((Pair)localObject).first).equals(paramString.first)) && (!((Integer)((Pair)localObject).second).equals(paramString.first))) {
          j = -1;
        } else {
          j = ((Integer)paramString.first).intValue();
        }
        int k;
        if ((((Integer)paramString.second).intValue() != -1) && ((((Integer)((Pair)localObject).first).equals(paramString.second)) || (((Integer)((Pair)localObject).second).equals(paramString.second)))) {
          k = ((Integer)paramString.second).intValue();
        } else {
          k = -1;
        }
        if ((j == -1) && (k == -1)) {
          return new Pair(localInteger1, localInteger2);
        }
        if (j == -1) {
          paramString = new Pair(Integer.valueOf(k), localInteger2);
        } else if (k == -1) {
          paramString = new Pair(Integer.valueOf(j), localInteger2);
        }
        i++;
      }
      return paramString;
    }
    if (paramString.contains("/"))
    {
      paramString = paramString.split("/", -1);
      if (paramString.length != 2) {}
    }
    try
    {
      long l1 = Double.parseDouble(paramString[0]);
      long l2 = Double.parseDouble(paramString[1]);
      if ((l1 >= 0L) && (l2 >= 0L))
      {
        if ((l1 <= 2147483647L) && (l2 <= 2147483647L)) {
          return new Pair(Integer.valueOf(10), Integer.valueOf(5));
        }
        return new Pair(Integer.valueOf(5), localInteger2);
      }
      paramString = new Pair(Integer.valueOf(10), localInteger2);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return new Pair(localInteger1, localInteger2);
    try
    {
      localObject = Long.valueOf(Long.parseLong(paramString));
      if ((((Long)localObject).longValue() >= 0L) && (((Long)localObject).longValue() <= 65535L)) {
        return new Pair(Integer.valueOf(3), Integer.valueOf(4));
      }
      if (((Long)localObject).longValue() < 0L) {
        return new Pair(Integer.valueOf(9), localInteger2);
      }
      localObject = new Pair(Integer.valueOf(4), localInteger2);
      return (Pair<Integer, Integer>)localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        Double.parseDouble(paramString);
        paramString = new Pair(Integer.valueOf(12), localInteger2);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        return new Pair(localInteger1, localInteger2);
      }
    }
  }
  
  private void handleThumbnailFromJfif(ByteOrderedDataInputStream paramByteOrderedDataInputStream, HashMap paramHashMap)
    throws IOException
  {
    ExifAttribute localExifAttribute = (ExifAttribute)paramHashMap.get("JPEGInterchangeFormat");
    paramHashMap = (ExifAttribute)paramHashMap.get("JPEGInterchangeFormatLength");
    if ((localExifAttribute != null) && (paramHashMap != null))
    {
      int i = localExifAttribute.getIntValue(this.mExifByteOrder);
      int j = paramHashMap.getIntValue(this.mExifByteOrder);
      int k = i;
      if (this.mMimeType == 7) {
        k = i + this.mOrfMakerNoteOffset;
      }
      i = Math.min(j, paramByteOrderedDataInputStream.getLength() - k);
      if ((k > 0) && (i > 0))
      {
        this.mHasThumbnail = true;
        j = this.mExifOffset + k;
        this.mThumbnailOffset = j;
        this.mThumbnailLength = i;
        if ((this.mFilename == null) && (this.mAssetInputStream == null) && (this.mSeekableFileDescriptor == null))
        {
          paramHashMap = new byte[i];
          paramByteOrderedDataInputStream.seek(j);
          paramByteOrderedDataInputStream.readFully(paramHashMap);
          this.mThumbnailBytes = paramHashMap;
        }
      }
      if (DEBUG)
      {
        paramByteOrderedDataInputStream = new StringBuilder();
        paramByteOrderedDataInputStream.append("Setting thumbnail attributes with offset: ");
        paramByteOrderedDataInputStream.append(k);
        paramByteOrderedDataInputStream.append(", length: ");
        paramByteOrderedDataInputStream.append(i);
        Log.d("ExifInterface", paramByteOrderedDataInputStream.toString());
      }
    }
  }
  
  private void handleThumbnailFromStrips(ByteOrderedDataInputStream paramByteOrderedDataInputStream, HashMap paramHashMap)
    throws IOException
  {
    Object localObject1 = (ExifAttribute)paramHashMap.get("StripOffsets");
    Object localObject2 = (ExifAttribute)paramHashMap.get("StripByteCounts");
    if ((localObject1 != null) && (localObject2 != null))
    {
      paramHashMap = convertToLongArray(((ExifAttribute)localObject1).getValue(this.mExifByteOrder));
      localObject1 = convertToLongArray(((ExifAttribute)localObject2).getValue(this.mExifByteOrder));
      if ((paramHashMap != null) && (paramHashMap.length != 0))
      {
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          if (paramHashMap.length != localObject1.length)
          {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
          }
          long l = 0L;
          int i = localObject1.length;
          for (int j = 0; j < i; j++) {
            l += localObject1[j];
          }
          int k = (int)l;
          localObject2 = new byte[k];
          this.mAreThumbnailStripsConsecutive = true;
          this.mHasThumbnailStrips = true;
          this.mHasThumbnail = true;
          i = 0;
          int m = 0;
          j = 0;
          while (i < paramHashMap.length)
          {
            int n = (int)paramHashMap[i];
            int i1 = (int)localObject1[i];
            if ((i < paramHashMap.length - 1) && (n + i1 != paramHashMap[(i + 1)])) {
              this.mAreThumbnailStripsConsecutive = false;
            }
            n -= m;
            if (n < 0) {
              Log.d("ExifInterface", "Invalid strip offset value");
            }
            paramByteOrderedDataInputStream.seek(n);
            byte[] arrayOfByte = new byte[i1];
            paramByteOrderedDataInputStream.read(arrayOfByte);
            m = m + n + i1;
            System.arraycopy(arrayOfByte, 0, localObject2, j, i1);
            j += i1;
            i++;
          }
          this.mThumbnailBytes = ((byte[])localObject2);
          if (this.mAreThumbnailStripsConsecutive)
          {
            this.mThumbnailOffset = ((int)paramHashMap[0] + this.mExifOffset);
            this.mThumbnailLength = k;
          }
        }
        else
        {
          Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
        }
      }
      else {
        Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
      }
    }
  }
  
  /* Error */
  private void initForFilename(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 1404
    //   4: invokestatic 1317	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aconst_null
    //   9: astore_2
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 1335	androidx/exifinterface/media/ExifInterface:mAssetInputStream	Landroid/content/res/AssetManager$AssetInputStream;
    //   15: aload_0
    //   16: aload_1
    //   17: putfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   20: new 1361	java/io/FileInputStream
    //   23: astore_3
    //   24: aload_3
    //   25: aload_1
    //   26: invokespecial 1926	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   29: aload_3
    //   30: invokevirtual 1402	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   33: invokestatic 1346	androidx/exifinterface/media/ExifInterface:isSeekableFD	(Ljava/io/FileDescriptor;)Z
    //   36: ifeq +14 -> 50
    //   39: aload_0
    //   40: aload_3
    //   41: invokevirtual 1402	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   44: putfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   47: goto +8 -> 55
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   55: aload_0
    //   56: aload_3
    //   57: invokespecial 1367	androidx/exifinterface/media/ExifInterface:loadAttributes	(Ljava/io/InputStream;)V
    //   60: aload_3
    //   61: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   64: return
    //   65: astore_1
    //   66: aload_3
    //   67: astore_2
    //   68: goto +4 -> 72
    //   71: astore_1
    //   72: aload_2
    //   73: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ExifInterface
    //   0	78	1	paramString	String
    //   9	64	2	localObject	Object
    //   23	44	3	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   29	47	65	finally
    //   50	55	65	finally
    //   55	60	65	finally
    //   20	29	71	finally
  }
  
  private static boolean isExifDataOnly(BufferedInputStream paramBufferedInputStream)
    throws IOException
  {
    byte[] arrayOfByte = IDENTIFIER_EXIF_APP1;
    paramBufferedInputStream.mark(arrayOfByte.length);
    arrayOfByte = new byte[arrayOfByte.length];
    paramBufferedInputStream.read(arrayOfByte);
    paramBufferedInputStream.reset();
    for (int i = 0;; i++)
    {
      paramBufferedInputStream = IDENTIFIER_EXIF_APP1;
      if (i >= paramBufferedInputStream.length) {
        break;
      }
      if (arrayOfByte[i] != paramBufferedInputStream[i]) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private boolean isHeifFormat(byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_3
    //   5: astore 4
    //   7: new 8	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream
    //   10: astore 5
    //   12: aload_3
    //   13: astore 4
    //   15: aload 5
    //   17: aload_1
    //   18: invokespecial 1740	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:<init>	([B)V
    //   21: aload 5
    //   23: invokevirtual 1558	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readInt	()I
    //   26: i2l
    //   27: lstore 6
    //   29: iconst_4
    //   30: newarray <illegal type>
    //   32: astore 4
    //   34: aload 5
    //   36: aload 4
    //   38: invokevirtual 1521	java/io/InputStream:read	([B)I
    //   41: pop
    //   42: aload 4
    //   44: getstatic 976	androidx/exifinterface/media/ExifInterface:HEIF_TYPE_FTYP	[B
    //   47: invokestatic 1554	java/util/Arrays:equals	([B[B)Z
    //   50: istore 8
    //   52: iload 8
    //   54: ifne +10 -> 64
    //   57: aload 5
    //   59: invokevirtual 1927	java/io/InputStream:close	()V
    //   62: iconst_0
    //   63: ireturn
    //   64: ldc2_w 1928
    //   67: lstore 9
    //   69: lload 6
    //   71: lconst_1
    //   72: lcmp
    //   73: ifne +30 -> 103
    //   76: aload 5
    //   78: invokevirtual 1932	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readLong	()J
    //   81: lstore 11
    //   83: lload 11
    //   85: lstore 6
    //   87: lload 11
    //   89: ldc2_w 1928
    //   92: lcmp
    //   93: ifge +15 -> 108
    //   96: aload 5
    //   98: invokevirtual 1927	java/io/InputStream:close	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: ldc2_w 1741
    //   106: lstore 9
    //   108: lload 6
    //   110: lstore 11
    //   112: lload 6
    //   114: aload_1
    //   115: arraylength
    //   116: i2l
    //   117: lcmp
    //   118: ifle +12 -> 130
    //   121: aload_1
    //   122: arraylength
    //   123: istore 13
    //   125: iload 13
    //   127: i2l
    //   128: lstore 11
    //   130: lload 11
    //   132: lload 9
    //   134: lsub
    //   135: lstore 9
    //   137: lload 9
    //   139: ldc2_w 1741
    //   142: lcmp
    //   143: ifge +10 -> 153
    //   146: aload 5
    //   148: invokevirtual 1927	java/io/InputStream:close	()V
    //   151: iconst_0
    //   152: ireturn
    //   153: iconst_4
    //   154: newarray <illegal type>
    //   156: astore_1
    //   157: lconst_0
    //   158: lstore 6
    //   160: iconst_0
    //   161: istore 14
    //   163: iconst_0
    //   164: istore 13
    //   166: lload 6
    //   168: lload 9
    //   170: ldc2_w 1933
    //   173: ldiv
    //   174: lcmp
    //   175: ifge +125 -> 300
    //   178: aload 5
    //   180: aload_1
    //   181: invokevirtual 1521	java/io/InputStream:read	([B)I
    //   184: istore 15
    //   186: iload 15
    //   188: iconst_4
    //   189: if_icmpeq +10 -> 199
    //   192: aload 5
    //   194: invokevirtual 1927	java/io/InputStream:close	()V
    //   197: iconst_0
    //   198: ireturn
    //   199: lload 6
    //   201: lconst_1
    //   202: lcmp
    //   203: ifne +10 -> 213
    //   206: iload 13
    //   208: istore 16
    //   210: goto +77 -> 287
    //   213: aload_1
    //   214: getstatic 981	androidx/exifinterface/media/ExifInterface:HEIF_BRAND_MIF1	[B
    //   217: invokestatic 1554	java/util/Arrays:equals	([B[B)Z
    //   220: ifeq +9 -> 229
    //   223: iconst_1
    //   224: istore 15
    //   226: goto +28 -> 254
    //   229: aload_1
    //   230: getstatic 986	androidx/exifinterface/media/ExifInterface:HEIF_BRAND_HEIC	[B
    //   233: invokestatic 1554	java/util/Arrays:equals	([B[B)Z
    //   236: istore 8
    //   238: iload 14
    //   240: istore 15
    //   242: iload 8
    //   244: ifeq +10 -> 254
    //   247: iconst_1
    //   248: istore 13
    //   250: iload 14
    //   252: istore 15
    //   254: iload 15
    //   256: istore 14
    //   258: iload 13
    //   260: istore 16
    //   262: iload 15
    //   264: ifeq +23 -> 287
    //   267: iload 15
    //   269: istore 14
    //   271: iload 13
    //   273: istore 16
    //   275: iload 13
    //   277: ifeq +10 -> 287
    //   280: aload 5
    //   282: invokevirtual 1927	java/io/InputStream:close	()V
    //   285: iconst_1
    //   286: ireturn
    //   287: lload 6
    //   289: lconst_1
    //   290: ladd
    //   291: lstore 6
    //   293: iload 16
    //   295: istore 13
    //   297: goto -131 -> 166
    //   300: aload 5
    //   302: invokevirtual 1927	java/io/InputStream:close	()V
    //   305: goto +63 -> 368
    //   308: astore_1
    //   309: aload 5
    //   311: astore 4
    //   313: goto +57 -> 370
    //   316: astore 4
    //   318: aload 5
    //   320: astore_1
    //   321: aload 4
    //   323: astore 5
    //   325: goto +11 -> 336
    //   328: astore_1
    //   329: goto +41 -> 370
    //   332: astore 5
    //   334: aload_2
    //   335: astore_1
    //   336: aload_1
    //   337: astore 4
    //   339: getstatic 952	androidx/exifinterface/media/ExifInterface:DEBUG	Z
    //   342: ifeq +18 -> 360
    //   345: aload_1
    //   346: astore 4
    //   348: ldc_w 382
    //   351: ldc_w 1936
    //   354: aload 5
    //   356: invokestatic 1939	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   359: pop
    //   360: aload_1
    //   361: ifnull +7 -> 368
    //   364: aload_1
    //   365: invokevirtual 1927	java/io/InputStream:close	()V
    //   368: iconst_0
    //   369: ireturn
    //   370: aload 4
    //   372: ifnull +8 -> 380
    //   375: aload 4
    //   377: invokevirtual 1927	java/io/InputStream:close	()V
    //   380: aload_1
    //   381: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	ExifInterface
    //   0	382	1	paramArrayOfByte	byte[]
    //   1	334	2	localObject1	Object
    //   3	10	3	localObject2	Object
    //   5	307	4	localObject3	Object
    //   316	6	4	localException1	Exception
    //   337	39	4	arrayOfByte	byte[]
    //   10	314	5	localObject4	Object
    //   332	23	5	localException2	Exception
    //   27	265	6	l1	long
    //   50	193	8	bool	boolean
    //   67	102	9	l2	long
    //   81	50	11	l3	long
    //   123	173	13	i	int
    //   161	109	14	j	int
    //   184	84	15	k	int
    //   208	86	16	m	int
    // Exception table:
    //   from	to	target	type
    //   21	52	308	finally
    //   76	83	308	finally
    //   112	125	308	finally
    //   153	157	308	finally
    //   166	186	308	finally
    //   213	223	308	finally
    //   229	238	308	finally
    //   21	52	316	java/lang/Exception
    //   76	83	316	java/lang/Exception
    //   112	125	316	java/lang/Exception
    //   153	157	316	java/lang/Exception
    //   166	186	316	java/lang/Exception
    //   213	223	316	java/lang/Exception
    //   229	238	316	java/lang/Exception
    //   7	12	328	finally
    //   15	21	328	finally
    //   339	345	328	finally
    //   348	360	328	finally
    //   7	12	332	java/lang/Exception
    //   15	21	332	java/lang/Exception
  }
  
  private static boolean isJpegFormat(byte[] paramArrayOfByte)
    throws IOException
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = JPEG_SIGNATURE;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i] != arrayOfByte[i]) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private boolean isOrfFormat(byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: new 8	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream
    //   10: astore 5
    //   12: aload 5
    //   14: aload_1
    //   15: invokespecial 1740	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:<init>	([B)V
    //   18: aload_0
    //   19: aload 5
    //   21: invokespecial 1943	androidx/exifinterface/media/ExifInterface:readByteOrder	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)Ljava/nio/ByteOrder;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 1309	androidx/exifinterface/media/ExifInterface:mExifByteOrder	Ljava/nio/ByteOrder;
    //   30: aload 5
    //   32: aload_1
    //   33: invokevirtual 1648	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:setByteOrder	(Ljava/nio/ByteOrder;)V
    //   36: aload 5
    //   38: invokevirtual 1806	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readShort	()S
    //   41: istore 6
    //   43: iload 6
    //   45: sipush 20306
    //   48: if_icmpeq +11 -> 59
    //   51: iload 6
    //   53: sipush 21330
    //   56: if_icmpne +5 -> 61
    //   59: iconst_1
    //   60: istore_2
    //   61: aload 5
    //   63: invokevirtual 1927	java/io/InputStream:close	()V
    //   66: iload_2
    //   67: ireturn
    //   68: astore_1
    //   69: goto +15 -> 84
    //   72: astore_1
    //   73: aload 5
    //   75: astore_1
    //   76: goto +23 -> 99
    //   79: astore_1
    //   80: aload 4
    //   82: astore 5
    //   84: aload 5
    //   86: ifnull +8 -> 94
    //   89: aload 5
    //   91: invokevirtual 1927	java/io/InputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_3
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 1927	java/io/InputStream:close	()V
    //   107: iconst_0
    //   108: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	ExifInterface
    //   0	109	1	paramArrayOfByte	byte[]
    //   1	66	2	bool	boolean
    //   3	95	3	localObject1	Object
    //   5	76	4	localObject2	Object
    //   10	80	5	localObject3	Object
    //   41	16	6	i	int
    // Exception table:
    //   from	to	target	type
    //   18	43	68	finally
    //   18	43	72	java/lang/Exception
    //   7	18	79	finally
    //   7	18	96	java/lang/Exception
  }
  
  private boolean isPngFormat(byte[] paramArrayOfByte)
    throws IOException
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = PNG_SIGNATURE;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i] != arrayOfByte[i]) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isRafFormat(byte[] paramArrayOfByte)
    throws IOException
  {
    byte[] arrayOfByte = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
    for (int i = 0; i < arrayOfByte.length; i++) {
      if (paramArrayOfByte[i] != arrayOfByte[i]) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private boolean isRw2Format(byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: new 8	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream
    //   10: astore 5
    //   12: aload 5
    //   14: aload_1
    //   15: invokespecial 1740	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:<init>	([B)V
    //   18: aload_0
    //   19: aload 5
    //   21: invokespecial 1943	androidx/exifinterface/media/ExifInterface:readByteOrder	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)Ljava/nio/ByteOrder;
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 1309	androidx/exifinterface/media/ExifInterface:mExifByteOrder	Ljava/nio/ByteOrder;
    //   30: aload 5
    //   32: aload_1
    //   33: invokevirtual 1648	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:setByteOrder	(Ljava/nio/ByteOrder;)V
    //   36: aload 5
    //   38: invokevirtual 1806	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readShort	()S
    //   41: istore 6
    //   43: iload 6
    //   45: bipush 85
    //   47: if_icmpne +5 -> 52
    //   50: iconst_1
    //   51: istore_2
    //   52: aload 5
    //   54: invokevirtual 1927	java/io/InputStream:close	()V
    //   57: iload_2
    //   58: ireturn
    //   59: astore_1
    //   60: goto +12 -> 72
    //   63: astore_1
    //   64: goto +24 -> 88
    //   67: astore_1
    //   68: aload 4
    //   70: astore 5
    //   72: aload 5
    //   74: ifnull +8 -> 82
    //   77: aload 5
    //   79: invokevirtual 1927	java/io/InputStream:close	()V
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_3
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +8 -> 98
    //   93: aload 5
    //   95: invokevirtual 1927	java/io/InputStream:close	()V
    //   98: iconst_0
    //   99: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	ExifInterface
    //   0	100	1	paramArrayOfByte	byte[]
    //   1	57	2	bool	boolean
    //   3	83	3	localObject1	Object
    //   5	64	4	localObject2	Object
    //   10	84	5	localObject3	Object
    //   41	7	6	i	int
    // Exception table:
    //   from	to	target	type
    //   18	43	59	finally
    //   18	43	63	java/lang/Exception
    //   7	18	67	finally
    //   7	18	84	java/lang/Exception
  }
  
  private static boolean isSeekableFD(FileDescriptor paramFileDescriptor)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        Os.lseek(paramFileDescriptor, 0L, OsConstants.SEEK_CUR);
        return true;
      }
      catch (Exception paramFileDescriptor)
      {
        if (DEBUG) {
          Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
        }
      }
    }
    return false;
  }
  
  private boolean isSupportedDataType(HashMap paramHashMap)
    throws IOException
  {
    Object localObject = (ExifAttribute)paramHashMap.get("BitsPerSample");
    if (localObject != null)
    {
      int[] arrayOfInt = (int[])((ExifAttribute)localObject).getValue(this.mExifByteOrder);
      localObject = BITS_PER_SAMPLE_RGB;
      if (Arrays.equals((int[])localObject, arrayOfInt)) {
        return true;
      }
      if (this.mMimeType == 3)
      {
        paramHashMap = (ExifAttribute)paramHashMap.get("PhotometricInterpretation");
        if (paramHashMap != null)
        {
          int i = paramHashMap.getIntValue(this.mExifByteOrder);
          if (((i == 1) && (Arrays.equals(arrayOfInt, BITS_PER_SAMPLE_GREYSCALE_2))) || ((i == 6) && (Arrays.equals(arrayOfInt, (int[])localObject)))) {
            return true;
          }
        }
      }
    }
    if (DEBUG) {
      Log.d("ExifInterface", "Unsupported data type value");
    }
    return false;
  }
  
  private boolean isSupportedFormatForSavingAttributes()
  {
    if (this.mIsSupportedFile)
    {
      int i = this.mMimeType;
      if ((i == 4) || (i == 13) || (i == 14)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSupportedMimeType(@NonNull String paramString)
  {
    Objects.requireNonNull(paramString, "mimeType shouldn't be null");
    paramString = paramString.toLowerCase(Locale.ROOT);
    paramString.hashCode();
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2111234748: 
      if (paramString.equals("image/x-canon-cr2")) {
        i = 14;
      }
      break;
    case 2099152524: 
      if (paramString.equals("image/x-nikon-nrw")) {
        i = 13;
      }
      break;
    case 2099152104: 
      if (paramString.equals("image/x-nikon-nef")) {
        i = 12;
      }
      break;
    case 1378106698: 
      if (paramString.equals("image/x-olympus-orf")) {
        i = 11;
      }
      break;
    case -332763809: 
      if (paramString.equals("image/x-pentax-pef")) {
        i = 10;
      }
      break;
    case -879258763: 
      if (paramString.equals("image/png")) {
        i = 9;
      }
      break;
    case -985160897: 
      if (paramString.equals("image/x-panasonic-rw2")) {
        i = 8;
      }
      break;
    case -1423313290: 
      if (paramString.equals("image/x-adobe-dng")) {
        i = 7;
      }
      break;
    case -1487018032: 
      if (paramString.equals("image/webp")) {
        i = 6;
      }
      break;
    case -1487394660: 
      if (paramString.equals("image/jpeg")) {
        i = 5;
      }
      break;
    case -1487464690: 
      if (paramString.equals("image/heif")) {
        i = 4;
      }
      break;
    case -1487464693: 
      if (paramString.equals("image/heic")) {
        i = 3;
      }
      break;
    case -1594371159: 
      if (paramString.equals("image/x-sony-arw")) {
        i = 2;
      }
      break;
    case -1635437028: 
      if (paramString.equals("image/x-samsung-srw")) {
        i = 1;
      }
      break;
    case -1875291391: 
      if (paramString.equals("image/x-fuji-raf")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean isThumbnail(HashMap paramHashMap)
    throws IOException
  {
    ExifAttribute localExifAttribute = (ExifAttribute)paramHashMap.get("ImageLength");
    paramHashMap = (ExifAttribute)paramHashMap.get("ImageWidth");
    if ((localExifAttribute != null) && (paramHashMap != null))
    {
      int i = localExifAttribute.getIntValue(this.mExifByteOrder);
      int j = paramHashMap.getIntValue(this.mExifByteOrder);
      if ((i <= 512) && (j <= 512)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isWebpFormat(byte[] paramArrayOfByte)
    throws IOException
  {
    byte[] arrayOfByte;
    for (int i = 0;; i++)
    {
      arrayOfByte = WEBP_SIGNATURE_1;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[i] != arrayOfByte[i]) {
        return false;
      }
    }
    for (i = 0;; i++)
    {
      arrayOfByte = WEBP_SIGNATURE_2;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (paramArrayOfByte[(WEBP_SIGNATURE_1.length + i + 4)] != arrayOfByte[i]) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private void loadAttributes(@NonNull InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 2015
    //   4: invokestatic 1317	java/util/Objects:requireNonNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: getstatic 1205	androidx/exifinterface/media/ExifInterface:EXIF_TAGS	[[Landroidx/exifinterface/media/ExifInterface$ExifTag;
    //   14: arraylength
    //   15: if_icmpge +22 -> 37
    //   18: aload_0
    //   19: getfield 1297	androidx/exifinterface/media/ExifInterface:mAttributes	[Ljava/util/HashMap;
    //   22: iload_2
    //   23: new 1213	java/util/HashMap
    //   26: dup
    //   27: invokespecial 1226	java/util/HashMap:<init>	()V
    //   30: aastore
    //   31: iinc 2 1
    //   34: goto -24 -> 10
    //   37: aload_1
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 1396	androidx/exifinterface/media/ExifInterface:mIsExifDataOnly	Z
    //   43: ifne +24 -> 67
    //   46: new 1382	java/io/BufferedInputStream
    //   49: astore_3
    //   50: aload_3
    //   51: aload_1
    //   52: sipush 5000
    //   55: invokespecial 1384	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   58: aload_0
    //   59: aload_0
    //   60: aload_3
    //   61: invokespecial 2017	androidx/exifinterface/media/ExifInterface:getMimeType	(Ljava/io/BufferedInputStream;)I
    //   64: putfield 1821	androidx/exifinterface/media/ExifInterface:mMimeType	I
    //   67: new 8	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream
    //   70: astore_1
    //   71: aload_1
    //   72: aload_3
    //   73: invokespecial 2019	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: aload_0
    //   77: getfield 1396	androidx/exifinterface/media/ExifInterface:mIsExifDataOnly	Z
    //   80: ifne +149 -> 229
    //   83: aload_0
    //   84: getfield 1821	androidx/exifinterface/media/ExifInterface:mMimeType	I
    //   87: tableswitch	default:+73->160, 0:+134->221, 1:+134->221, 2:+134->221, 3:+134->221, 4:+124->211, 5:+134->221, 6:+134->221, 7:+116->203, 8:+134->221, 9:+108->195, 10:+100->187, 11:+134->221, 12:+92->179, 13:+84->171, 14:+76->163
    //   160: goto +74 -> 234
    //   163: aload_0
    //   164: aload_1
    //   165: invokespecial 2021	androidx/exifinterface/media/ExifInterface:getWebpAttributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   168: goto +66 -> 234
    //   171: aload_0
    //   172: aload_1
    //   173: invokespecial 2023	androidx/exifinterface/media/ExifInterface:getPngAttributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   176: goto +58 -> 234
    //   179: aload_0
    //   180: aload_1
    //   181: invokespecial 2025	androidx/exifinterface/media/ExifInterface:getHeifAttributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   184: goto +50 -> 234
    //   187: aload_0
    //   188: aload_1
    //   189: invokespecial 2027	androidx/exifinterface/media/ExifInterface:getRw2Attributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   192: goto +42 -> 234
    //   195: aload_0
    //   196: aload_1
    //   197: invokespecial 2029	androidx/exifinterface/media/ExifInterface:getRafAttributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   200: goto +34 -> 234
    //   203: aload_0
    //   204: aload_1
    //   205: invokespecial 2031	androidx/exifinterface/media/ExifInterface:getOrfAttributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   208: goto +26 -> 234
    //   211: aload_0
    //   212: aload_1
    //   213: iconst_0
    //   214: iconst_0
    //   215: invokespecial 1800	androidx/exifinterface/media/ExifInterface:getJpegAttributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;II)V
    //   218: goto +16 -> 234
    //   221: aload_0
    //   222: aload_1
    //   223: invokespecial 1735	androidx/exifinterface/media/ExifInterface:getRawAttributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   226: goto +8 -> 234
    //   229: aload_0
    //   230: aload_1
    //   231: invokespecial 2033	androidx/exifinterface/media/ExifInterface:getStandaloneAttributes	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   234: aload_0
    //   235: aload_1
    //   236: invokespecial 2036	androidx/exifinterface/media/ExifInterface:setThumbnailData	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;)V
    //   239: aload_0
    //   240: iconst_1
    //   241: putfield 1965	androidx/exifinterface/media/ExifInterface:mIsSupportedFile	Z
    //   244: aload_0
    //   245: invokespecial 2038	androidx/exifinterface/media/ExifInterface:addDefaultValuesForCompatibility	()V
    //   248: getstatic 952	androidx/exifinterface/media/ExifInterface:DEBUG	Z
    //   251: ifeq +50 -> 301
    //   254: goto +43 -> 297
    //   257: astore_1
    //   258: goto +44 -> 302
    //   261: astore_1
    //   262: aload_0
    //   263: iconst_0
    //   264: putfield 1965	androidx/exifinterface/media/ExifInterface:mIsSupportedFile	Z
    //   267: getstatic 952	androidx/exifinterface/media/ExifInterface:DEBUG	Z
    //   270: istore 4
    //   272: iload 4
    //   274: ifeq +14 -> 288
    //   277: ldc_w 382
    //   280: ldc_w 2040
    //   283: aload_1
    //   284: invokestatic 2042	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   287: pop
    //   288: aload_0
    //   289: invokespecial 2038	androidx/exifinterface/media/ExifInterface:addDefaultValuesForCompatibility	()V
    //   292: iload 4
    //   294: ifeq +7 -> 301
    //   297: aload_0
    //   298: invokespecial 2045	androidx/exifinterface/media/ExifInterface:printAttributes	()V
    //   301: return
    //   302: aload_0
    //   303: invokespecial 2038	androidx/exifinterface/media/ExifInterface:addDefaultValuesForCompatibility	()V
    //   306: getstatic 952	androidx/exifinterface/media/ExifInterface:DEBUG	Z
    //   309: ifeq +7 -> 316
    //   312: aload_0
    //   313: invokespecial 2045	androidx/exifinterface/media/ExifInterface:printAttributes	()V
    //   316: aload_1
    //   317: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	ExifInterface
    //   0	318	1	paramInputStream	InputStream
    //   9	23	2	i	int
    //   38	35	3	localObject	Object
    //   270	23	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	31	257	finally
    //   39	67	257	finally
    //   67	160	257	finally
    //   163	168	257	finally
    //   171	176	257	finally
    //   179	184	257	finally
    //   187	192	257	finally
    //   195	200	257	finally
    //   203	208	257	finally
    //   211	218	257	finally
    //   221	226	257	finally
    //   229	234	257	finally
    //   234	244	257	finally
    //   262	272	257	finally
    //   277	288	257	finally
    //   10	31	261	java/io/IOException
    //   39	67	261	java/io/IOException
    //   67	160	261	java/io/IOException
    //   163	168	261	java/io/IOException
    //   171	176	261	java/io/IOException
    //   179	184	261	java/io/IOException
    //   187	192	261	java/io/IOException
    //   195	200	261	java/io/IOException
    //   203	208	261	java/io/IOException
    //   211	218	261	java/io/IOException
    //   221	226	261	java/io/IOException
    //   229	234	261	java/io/IOException
    //   234	244	261	java/io/IOException
  }
  
  private static long parseDateTime(@Nullable String paramString1, @Nullable String paramString2)
  {
    ParsePosition localParsePosition;
    if ((paramString1 != null) && (sNonZeroTimePattern.matcher(paramString1).matches())) {
      localParsePosition = new ParsePosition(0);
    }
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        paramString1 = sFormatter.parse(paramString1, localParsePosition);
        if (paramString1 == null) {
          return -1L;
        }
        l1 = paramString1.getTime();
        l2 = l1;
        if (paramString2 == null) {}
      }
      catch (IllegalArgumentException paramString1)
      {
        continue;
      }
      try
      {
        l2 = Long.parseLong(paramString2);
        if (l2 > 1000L) {
          l2 /= 10L;
        } else {
          l2 = l1 + l2;
        }
      }
      catch (NumberFormatException paramString1)
      {
        l2 = l1;
      }
    }
    return l2;
    return -1L;
  }
  
  private void parseTiffHeaders(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt)
    throws IOException
  {
    ByteOrder localByteOrder = readByteOrder(paramByteOrderedDataInputStream);
    this.mExifByteOrder = localByteOrder;
    paramByteOrderedDataInputStream.setByteOrder(localByteOrder);
    int i = paramByteOrderedDataInputStream.readUnsignedShort();
    int j = this.mMimeType;
    if ((j != 7) && (j != 10) && (i != 42))
    {
      paramByteOrderedDataInputStream = new StringBuilder();
      paramByteOrderedDataInputStream.append("Invalid start code: ");
      paramByteOrderedDataInputStream.append(Integer.toHexString(i));
      throw new IOException(paramByteOrderedDataInputStream.toString());
    }
    i = paramByteOrderedDataInputStream.readInt();
    if ((i >= 8) && (i < paramInt))
    {
      paramInt = i - 8;
      if ((paramInt > 0) && (paramByteOrderedDataInputStream.skipBytes(paramInt) != paramInt))
      {
        paramByteOrderedDataInputStream = new StringBuilder();
        paramByteOrderedDataInputStream.append("Couldn't jump to first Ifd: ");
        paramByteOrderedDataInputStream.append(paramInt);
        throw new IOException(paramByteOrderedDataInputStream.toString());
      }
      return;
    }
    paramByteOrderedDataInputStream = new StringBuilder();
    paramByteOrderedDataInputStream.append("Invalid first Ifd offset: ");
    paramByteOrderedDataInputStream.append(i);
    throw new IOException(paramByteOrderedDataInputStream.toString());
  }
  
  private void printAttributes()
  {
    for (int i = 0; i < this.mAttributes.length; i++)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("The size of tag group[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]: ");
      ((StringBuilder)localObject).append(this.mAttributes[i].size());
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
      Iterator localIterator = this.mAttributes[i].entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localObject = (ExifAttribute)localEntry.getValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tagName: ");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append(", tagType: ");
        localStringBuilder.append(((ExifAttribute)localObject).toString());
        localStringBuilder.append(", tagValue: '");
        localStringBuilder.append(((ExifAttribute)localObject).getStringValue(this.mExifByteOrder));
        localStringBuilder.append("'");
        Log.d("ExifInterface", localStringBuilder.toString());
      }
    }
  }
  
  private ByteOrder readByteOrder(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    int i = paramByteOrderedDataInputStream.readShort();
    if (i != 18761)
    {
      if (i == 19789)
      {
        if (DEBUG) {
          Log.d("ExifInterface", "readExifSegment: Byte Align MM");
        }
        return ByteOrder.BIG_ENDIAN;
      }
      paramByteOrderedDataInputStream = new StringBuilder();
      paramByteOrderedDataInputStream.append("Invalid byte order: ");
      paramByteOrderedDataInputStream.append(Integer.toHexString(i));
      throw new IOException(paramByteOrderedDataInputStream.toString());
    }
    if (DEBUG) {
      Log.d("ExifInterface", "readExifSegment: Byte Align II");
    }
    return ByteOrder.LITTLE_ENDIAN;
  }
  
  private void readExifSegment(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    ByteOrderedDataInputStream localByteOrderedDataInputStream = new ByteOrderedDataInputStream(paramArrayOfByte);
    parseTiffHeaders(localByteOrderedDataInputStream, paramArrayOfByte.length);
    readImageFileDirectory(localByteOrderedDataInputStream, paramInt);
  }
  
  private void readImageFileDirectory(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt)
    throws IOException
  {
    this.mAttributesOffsets.add(Integer.valueOf(paramByteOrderedDataInputStream.mPosition));
    if (paramByteOrderedDataInputStream.mPosition + 2 > paramByteOrderedDataInputStream.mLength) {
      return;
    }
    int i = paramByteOrderedDataInputStream.readShort();
    boolean bool = DEBUG;
    String str = "ExifInterface";
    Object localObject1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("numberOfDirectoryEntry: ");
      ((StringBuilder)localObject1).append(i);
      Log.d("ExifInterface", ((StringBuilder)localObject1).toString());
    }
    if ((paramByteOrderedDataInputStream.mPosition + i * 12 <= paramByteOrderedDataInputStream.mLength) && (i > 0))
    {
      long l3;
      for (int j = 0;; j = (short)(j + 1))
      {
        int k = paramInt;
        if (j >= i) {
          break;
        }
        int m = paramByteOrderedDataInputStream.readUnsignedShort();
        int n = paramByteOrderedDataInputStream.readUnsignedShort();
        int i1 = paramByteOrderedDataInputStream.readInt();
        long l1 = paramByteOrderedDataInputStream.peek() + 4L;
        Object localObject2 = (ExifTag)sExifTagMapsForReading[k].get(Integer.valueOf(m));
        bool = DEBUG;
        if (bool)
        {
          if (localObject2 != null) {
            localObject1 = ((ExifTag)localObject2).name;
          } else {
            localObject1 = null;
          }
          Log.d(str, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m), localObject1, Integer.valueOf(n), Integer.valueOf(i1) }));
        }
        if (localObject2 == null) {
          if (bool)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Skip the tag entry since tag number is not defined: ");
            ((StringBuilder)localObject1).append(m);
            Log.d(str, ((StringBuilder)localObject1).toString());
          }
        }
        long l2;
        for (;;)
        {
          break;
          if (n > 0)
          {
            localObject1 = IFD_FORMAT_BYTES_PER_FORMAT;
            if (n < localObject1.length)
            {
              if (!((ExifTag)localObject2).isFormatCompatible(n))
              {
                if (!bool) {
                  continue;
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Skip the tag entry since data format (");
                ((StringBuilder)localObject1).append(IFD_FORMAT_NAMES[n]);
                ((StringBuilder)localObject1).append(") is unexpected for tag: ");
                ((StringBuilder)localObject1).append(((ExifTag)localObject2).name);
                Log.d(str, ((StringBuilder)localObject1).toString());
                continue;
              }
              i2 = n;
              if (n == 7) {
                i2 = ((ExifTag)localObject2).primaryFormat;
              }
              l2 = i1 * localObject1[i2];
              if ((l2 >= 0L) && (l2 <= 2147483647L))
              {
                n = 1;
                l3 = l2;
                break label577;
              }
              l3 = l2;
              n = i2;
              if (!bool) {
                break label566;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Skip the tag entry since the number of components is invalid: ");
              ((StringBuilder)localObject1).append(i1);
              Log.d(str, ((StringBuilder)localObject1).toString());
              l3 = l2;
              n = i2;
              break label566;
            }
          }
          if (bool)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Skip the tag entry since data format is invalid: ");
            ((StringBuilder)localObject1).append(n);
            Log.d(str, ((StringBuilder)localObject1).toString());
          }
        }
        l3 = 0L;
        label566:
        int i3 = 0;
        int i2 = n;
        n = i3;
        label577:
        if (n == 0) {
          paramByteOrderedDataInputStream.seek(l1);
        }
        for (;;)
        {
          break;
          Object localObject3;
          if (l3 > 4L)
          {
            i3 = paramByteOrderedDataInputStream.readInt();
            if (bool)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("seek to data offset: ");
              ((StringBuilder)localObject1).append(i3);
              Log.d(str, ((StringBuilder)localObject1).toString());
            }
            n = this.mMimeType;
            if (n == 7)
            {
              if ("MakerNote".equals(((ExifTag)localObject2).name))
              {
                this.mOrfMakerNoteOffset = i3;
              }
              else if ((k == 6) && ("ThumbnailImage".equals(((ExifTag)localObject2).name)))
              {
                this.mOrfThumbnailOffset = i3;
                this.mOrfThumbnailLength = i1;
                ExifAttribute localExifAttribute = ExifAttribute.createUShort(6, this.mExifByteOrder);
                localObject1 = ExifAttribute.createULong(this.mOrfThumbnailOffset, this.mExifByteOrder);
                localObject3 = ExifAttribute.createULong(this.mOrfThumbnailLength, this.mExifByteOrder);
                this.mAttributes[4].put("Compression", localExifAttribute);
                this.mAttributes[4].put("JPEGInterchangeFormat", localObject1);
                this.mAttributes[4].put("JPEGInterchangeFormatLength", localObject3);
                break label837;
              }
            }
            else if ((n == 10) && ("JpgFromRaw".equals(((ExifTag)localObject2).name))) {
              this.mRw2JpgFromRawOffset = i3;
            }
            label837:
            l2 = i3;
            if (l2 + l3 <= paramByteOrderedDataInputStream.mLength)
            {
              paramByteOrderedDataInputStream.seek(l2);
            }
            else
            {
              if (bool)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Skip the tag entry since data offset is invalid: ");
                ((StringBuilder)localObject1).append(i3);
                Log.d(str, ((StringBuilder)localObject1).toString());
              }
              paramByteOrderedDataInputStream.seek(l1);
              continue;
            }
          }
          localObject1 = (Integer)sExifPointerTagMap.get(Integer.valueOf(m));
          if (bool)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("nextIfdType: ");
            ((StringBuilder)localObject3).append(localObject1);
            ((StringBuilder)localObject3).append(" byteCount: ");
            ((StringBuilder)localObject3).append(l3);
            Log.d(str, ((StringBuilder)localObject3).toString());
          }
          if (localObject1 != null)
          {
            l3 = -1L;
            if (i2 != 3)
            {
              if (i2 != 4)
              {
                if (i2 != 8)
                {
                  if ((i2 != 9) && (i2 != 13)) {
                    break label1078;
                  }
                  i2 = paramByteOrderedDataInputStream.readInt();
                }
                else
                {
                  i2 = paramByteOrderedDataInputStream.readShort();
                }
              }
              else
              {
                l3 = paramByteOrderedDataInputStream.readUnsignedInt();
                break label1078;
              }
            }
            else {
              i2 = paramByteOrderedDataInputStream.readUnsignedShort();
            }
            l3 = i2;
            label1078:
            if (bool) {
              Log.d(str, String.format("Offset: %d, tagName: %s", new Object[] { Long.valueOf(l3), ((ExifTag)localObject2).name }));
            }
            if ((l3 > 0L) && (l3 < paramByteOrderedDataInputStream.mLength))
            {
              if (!this.mAttributesOffsets.contains(Integer.valueOf((int)l3)))
              {
                paramByteOrderedDataInputStream.seek(l3);
                readImageFileDirectory(paramByteOrderedDataInputStream, ((Integer)localObject1).intValue());
              }
              else if (bool)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Skip jump into the IFD since it has already been read: IfdType ");
                ((StringBuilder)localObject2).append(localObject1);
                ((StringBuilder)localObject2).append(" (at ");
                ((StringBuilder)localObject2).append(l3);
                ((StringBuilder)localObject2).append(")");
                Log.d(str, ((StringBuilder)localObject2).toString());
              }
            }
            else if (bool)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Skip jump into the IFD since its offset is invalid: ");
              ((StringBuilder)localObject1).append(l3);
              Log.d(str, ((StringBuilder)localObject1).toString());
            }
            paramByteOrderedDataInputStream.seek(l1);
          }
          else
          {
            n = paramByteOrderedDataInputStream.peek();
            k = this.mExifOffset;
            localObject1 = new byte[(int)l3];
            paramByteOrderedDataInputStream.readFully((byte[])localObject1);
            localObject1 = new ExifAttribute(i2, i1, n + k, (byte[])localObject1);
            this.mAttributes[paramInt].put(((ExifTag)localObject2).name, localObject1);
            if ("DNGVersion".equals(((ExifTag)localObject2).name)) {
              this.mMimeType = 3;
            }
            if (((!"Make".equals(((ExifTag)localObject2).name)) && (!"Model".equals(((ExifTag)localObject2).name))) || ((((ExifAttribute)localObject1).getStringValue(this.mExifByteOrder).contains("PENTAX")) || (("Compression".equals(((ExifTag)localObject2).name)) && (((ExifAttribute)localObject1).getIntValue(this.mExifByteOrder) == 65535)))) {
              this.mMimeType = 8;
            }
            if (paramByteOrderedDataInputStream.peek() != l1) {
              paramByteOrderedDataInputStream.seek(l1);
            }
          }
        }
      }
      if (paramByteOrderedDataInputStream.peek() + 4 <= paramByteOrderedDataInputStream.mLength)
      {
        paramInt = paramByteOrderedDataInputStream.readInt();
        bool = DEBUG;
        if (bool) {
          Log.d(str, String.format("nextIfdOffset: %d", new Object[] { Integer.valueOf(paramInt) }));
        }
        l3 = paramInt;
        if ((l3 > 0L) && (paramInt < paramByteOrderedDataInputStream.mLength))
        {
          if (!this.mAttributesOffsets.contains(Integer.valueOf(paramInt)))
          {
            paramByteOrderedDataInputStream.seek(l3);
            if (this.mAttributes[4].isEmpty()) {
              readImageFileDirectory(paramByteOrderedDataInputStream, 4);
            } else if (this.mAttributes[5].isEmpty()) {
              readImageFileDirectory(paramByteOrderedDataInputStream, 5);
            }
          }
          else if (bool)
          {
            paramByteOrderedDataInputStream = new StringBuilder();
            paramByteOrderedDataInputStream.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
            paramByteOrderedDataInputStream.append(paramInt);
            Log.d(str, paramByteOrderedDataInputStream.toString());
          }
        }
        else if (bool)
        {
          paramByteOrderedDataInputStream = new StringBuilder();
          paramByteOrderedDataInputStream.append("Stop reading file since a wrong offset may cause an infinite loop: ");
          paramByteOrderedDataInputStream.append(paramInt);
          Log.d(str, paramByteOrderedDataInputStream.toString());
        }
      }
    }
  }
  
  private void removeAttribute(String paramString)
  {
    for (int i = 0; i < EXIF_TAGS.length; i++) {
      this.mAttributes[i].remove(paramString);
    }
  }
  
  private void retrieveJpegImageSize(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt)
    throws IOException
  {
    ExifAttribute localExifAttribute1 = (ExifAttribute)this.mAttributes[paramInt].get("ImageLength");
    ExifAttribute localExifAttribute2 = (ExifAttribute)this.mAttributes[paramInt].get("ImageWidth");
    if ((localExifAttribute1 == null) || (localExifAttribute2 == null))
    {
      localExifAttribute2 = (ExifAttribute)this.mAttributes[paramInt].get("JPEGInterchangeFormat");
      if (localExifAttribute2 != null) {
        getJpegAttributes(paramByteOrderedDataInputStream, localExifAttribute2.getIntValue(this.mExifByteOrder), paramInt);
      }
    }
  }
  
  private void saveJpegAttributes(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    if (DEBUG)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveJpegAttributes starting with (inputStream: ");
      ((StringBuilder)localObject).append(paramInputStream);
      ((StringBuilder)localObject).append(", outputStream: ");
      ((StringBuilder)localObject).append(paramOutputStream);
      ((StringBuilder)localObject).append(")");
      Log.d("ExifInterface", ((StringBuilder)localObject).toString());
    }
    Object localObject = new DataInputStream(paramInputStream);
    ByteOrderedDataOutputStream localByteOrderedDataOutputStream = new ByteOrderedDataOutputStream(paramOutputStream, ByteOrder.BIG_ENDIAN);
    if (((DataInputStream)localObject).readByte() == -1)
    {
      localByteOrderedDataOutputStream.writeByte(-1);
      if (((DataInputStream)localObject).readByte() == -40)
      {
        localByteOrderedDataOutputStream.writeByte(-40);
        paramOutputStream = null;
        paramInputStream = paramOutputStream;
        if (getAttribute("Xmp") != null)
        {
          paramInputStream = paramOutputStream;
          if (this.mXmpIsFromSeparateMarker) {
            paramInputStream = (ExifAttribute)this.mAttributes[0].remove("Xmp");
          }
        }
        localByteOrderedDataOutputStream.writeByte(-1);
        localByteOrderedDataOutputStream.writeByte(-31);
        writeExifSegment(localByteOrderedDataOutputStream);
        if (paramInputStream != null) {
          this.mAttributes[0].put("Xmp", paramInputStream);
        }
        paramOutputStream = new byte['က'];
        while (((DataInputStream)localObject).readByte() == -1)
        {
          int i = ((DataInputStream)localObject).readByte();
          if ((i != -39) && (i != -38))
          {
            int j;
            if (i != -31)
            {
              localByteOrderedDataOutputStream.writeByte(-1);
              localByteOrderedDataOutputStream.writeByte(i);
              i = ((DataInputStream)localObject).readUnsignedShort();
              localByteOrderedDataOutputStream.writeUnsignedShort(i);
              i -= 2;
              if (i >= 0) {
                for (;;)
                {
                  if (i <= 0) {
                    break label308;
                  }
                  j = ((DataInputStream)localObject).read(paramOutputStream, 0, Math.min(i, 4096));
                  if (j < 0) {
                    break;
                  }
                  localByteOrderedDataOutputStream.write(paramOutputStream, 0, j);
                  i -= j;
                }
              } else {
                label308:
                throw new IOException("Invalid length");
              }
            }
            else
            {
              j = ((DataInputStream)localObject).readUnsignedShort() - 2;
              if (j >= 0)
              {
                paramInputStream = new byte[6];
                if (j >= 6) {
                  if (((DataInputStream)localObject).read(paramInputStream) == 6)
                  {
                    if (Arrays.equals(paramInputStream, IDENTIFIER_EXIF_APP1))
                    {
                      i = j - 6;
                      if (((DataInputStream)localObject).skipBytes(i) == i) {
                        continue;
                      }
                      throw new IOException("Invalid length");
                    }
                  }
                  else {
                    throw new IOException("Invalid exif");
                  }
                }
                localByteOrderedDataOutputStream.writeByte(-1);
                localByteOrderedDataOutputStream.writeByte(i);
                localByteOrderedDataOutputStream.writeUnsignedShort(j + 2);
                i = j;
                if (j >= 6)
                {
                  i = j - 6;
                  localByteOrderedDataOutputStream.write(paramInputStream);
                }
                for (;;)
                {
                  if (i <= 0) {
                    break label498;
                  }
                  j = ((DataInputStream)localObject).read(paramOutputStream, 0, Math.min(i, 4096));
                  if (j < 0) {
                    break;
                  }
                  localByteOrderedDataOutputStream.write(paramOutputStream, 0, j);
                  i -= j;
                }
              }
              else
              {
                label498:
                throw new IOException("Invalid length");
              }
            }
          }
          else
          {
            localByteOrderedDataOutputStream.writeByte(-1);
            localByteOrderedDataOutputStream.writeByte(i);
            copy((InputStream)localObject, localByteOrderedDataOutputStream);
            return;
          }
        }
        throw new IOException("Invalid marker");
      }
      throw new IOException("Invalid marker");
    }
    throw new IOException("Invalid marker");
  }
  
  /* Error */
  private void savePngAttributes(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 952	androidx/exifinterface/media/ExifInterface:DEBUG	Z
    //   3: ifeq +58 -> 61
    //   6: new 1421	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 1471	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 2237
    //   18: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 1644	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc_w 2208
    //   32: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 1644	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: ldc_w 1669
    //   46: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc_w 382
    //   53: aload_3
    //   54: invokevirtual 1440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 1575	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   60: pop
    //   61: new 2210	java/io/DataInputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 2211	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore_1
    //   70: getstatic 1307	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   73: astore 4
    //   75: new 11	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream
    //   78: dup
    //   79: aload_2
    //   80: aload 4
    //   82: invokespecial 2214	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   85: astore 5
    //   87: getstatic 1003	androidx/exifinterface/media/ExifInterface:PNG_SIGNATURE	[B
    //   90: astore_2
    //   91: aload_1
    //   92: aload 5
    //   94: aload_2
    //   95: arraylength
    //   96: invokestatic 1566	androidx/exifinterface/media/ExifInterface:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   99: aload_0
    //   100: getfield 1616	androidx/exifinterface/media/ExifInterface:mExifOffset	I
    //   103: istore 6
    //   105: iload 6
    //   107: ifne +31 -> 138
    //   110: aload_1
    //   111: invokevirtual 2238	java/io/DataInputStream:readInt	()I
    //   114: istore 6
    //   116: aload 5
    //   118: iload 6
    //   120: invokevirtual 1564	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:writeInt	(I)V
    //   123: aload_1
    //   124: aload 5
    //   126: iload 6
    //   128: iconst_4
    //   129: iadd
    //   130: iconst_4
    //   131: iadd
    //   132: invokestatic 1566	androidx/exifinterface/media/ExifInterface:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   135: goto +31 -> 166
    //   138: aload_1
    //   139: aload 5
    //   141: iload 6
    //   143: aload_2
    //   144: arraylength
    //   145: isub
    //   146: iconst_4
    //   147: isub
    //   148: iconst_4
    //   149: isub
    //   150: invokestatic 1566	androidx/exifinterface/media/ExifInterface:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   153: aload_1
    //   154: aload_1
    //   155: invokevirtual 2238	java/io/DataInputStream:readInt	()I
    //   158: iconst_4
    //   159: iadd
    //   160: iconst_4
    //   161: iadd
    //   162: invokevirtual 2230	java/io/DataInputStream:skipBytes	(I)I
    //   165: pop
    //   166: aconst_null
    //   167: astore_3
    //   168: new 2240	java/io/ByteArrayOutputStream
    //   171: astore_2
    //   172: aload_2
    //   173: invokespecial 2241	java/io/ByteArrayOutputStream:<init>	()V
    //   176: new 11	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream
    //   179: astore_3
    //   180: aload_3
    //   181: aload_2
    //   182: aload 4
    //   184: invokespecial 2214	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   187: aload_0
    //   188: aload_3
    //   189: invokespecial 2222	androidx/exifinterface/media/ExifInterface:writeExifSegment	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream;)I
    //   192: pop
    //   193: aload_3
    //   194: getfield 2245	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:mOutputStream	Ljava/io/OutputStream;
    //   197: checkcast 2240	java/io/ByteArrayOutputStream
    //   200: invokevirtual 2249	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   203: astore 4
    //   205: aload 5
    //   207: aload 4
    //   209: invokevirtual 1561	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:write	([B)V
    //   212: new 1766	java/util/zip/CRC32
    //   215: astore_3
    //   216: aload_3
    //   217: invokespecial 1767	java/util/zip/CRC32:<init>	()V
    //   220: aload_3
    //   221: aload 4
    //   223: iconst_4
    //   224: aload 4
    //   226: arraylength
    //   227: iconst_4
    //   228: isub
    //   229: invokevirtual 2251	java/util/zip/CRC32:update	([BII)V
    //   232: aload 5
    //   234: aload_3
    //   235: invokevirtual 1773	java/util/zip/CRC32:getValue	()J
    //   238: l2i
    //   239: invokevirtual 1564	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:writeInt	(I)V
    //   242: aload_2
    //   243: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   246: aload_1
    //   247: aload 5
    //   249: invokestatic 2232	androidx/exifinterface/media/ExifInterface:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   252: pop
    //   253: return
    //   254: astore_1
    //   255: goto +6 -> 261
    //   258: astore_1
    //   259: aload_3
    //   260: astore_2
    //   261: aload_2
    //   262: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   265: aload_1
    //   266: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	ExifInterface
    //   0	267	1	paramInputStream	InputStream
    //   0	267	2	paramOutputStream	OutputStream
    //   13	247	3	localObject1	Object
    //   73	152	4	localObject2	Object
    //   85	163	5	localByteOrderedDataOutputStream	ByteOrderedDataOutputStream
    //   103	43	6	i	int
    // Exception table:
    //   from	to	target	type
    //   176	242	254	finally
    //   168	176	258	finally
  }
  
  /* Error */
  private void saveWebpAttributes(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 952	androidx/exifinterface/media/ExifInterface:DEBUG	Z
    //   3: ifeq +58 -> 61
    //   6: new 1421	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 1471	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 2254
    //   18: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_1
    //   24: invokevirtual 1644	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc_w 2208
    //   32: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 1644	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: ldc_w 1669
    //   46: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc_w 382
    //   53: aload_3
    //   54: invokevirtual 1440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 1575	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   60: pop
    //   61: getstatic 1833	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   64: astore 4
    //   66: new 8	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream
    //   69: dup
    //   70: aload_1
    //   71: aload 4
    //   73: invokespecial 2257	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:<init>	(Ljava/io/InputStream;Ljava/nio/ByteOrder;)V
    //   76: astore 5
    //   78: new 11	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream
    //   81: dup
    //   82: aload_2
    //   83: aload 4
    //   85: invokespecial 2214	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   88: astore 6
    //   90: getstatic 1017	androidx/exifinterface/media/ExifInterface:WEBP_SIGNATURE_1	[B
    //   93: astore 7
    //   95: aload 5
    //   97: aload 6
    //   99: aload 7
    //   101: arraylength
    //   102: invokestatic 1566	androidx/exifinterface/media/ExifInterface:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   105: getstatic 1021	androidx/exifinterface/media/ExifInterface:WEBP_SIGNATURE_2	[B
    //   108: astore 8
    //   110: aload 5
    //   112: aload 8
    //   114: arraylength
    //   115: iconst_4
    //   116: iadd
    //   117: invokevirtual 1673	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:skipBytes	(I)I
    //   120: pop
    //   121: aconst_null
    //   122: astore 9
    //   124: aconst_null
    //   125: astore 10
    //   127: aload 10
    //   129: astore_2
    //   130: new 2240	java/io/ByteArrayOutputStream
    //   133: astore_3
    //   134: aload 10
    //   136: astore_2
    //   137: aload_3
    //   138: invokespecial 2241	java/io/ByteArrayOutputStream:<init>	()V
    //   141: new 11	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream
    //   144: astore_2
    //   145: aload_2
    //   146: aload_3
    //   147: aload 4
    //   149: invokespecial 2214	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:<init>	(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
    //   152: aload_0
    //   153: getfield 1616	androidx/exifinterface/media/ExifInterface:mExifOffset	I
    //   156: istore 11
    //   158: iload 11
    //   160: ifeq +52 -> 212
    //   163: aload 5
    //   165: aload_2
    //   166: iload 11
    //   168: aload 7
    //   170: arraylength
    //   171: iconst_4
    //   172: iadd
    //   173: aload 8
    //   175: arraylength
    //   176: iadd
    //   177: isub
    //   178: iconst_4
    //   179: isub
    //   180: iconst_4
    //   181: isub
    //   182: invokestatic 1566	androidx/exifinterface/media/ExifInterface:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   185: aload 5
    //   187: iconst_4
    //   188: invokevirtual 1673	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:skipBytes	(I)I
    //   191: pop
    //   192: aload 5
    //   194: aload 5
    //   196: invokevirtual 1558	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readInt	()I
    //   199: invokevirtual 1673	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:skipBytes	(I)I
    //   202: pop
    //   203: aload_0
    //   204: aload_2
    //   205: invokespecial 2222	androidx/exifinterface/media/ExifInterface:writeExifSegment	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream;)I
    //   208: pop
    //   209: goto +236 -> 445
    //   212: iconst_4
    //   213: newarray <illegal type>
    //   215: astore 10
    //   217: aload 5
    //   219: aload 10
    //   221: invokevirtual 1521	java/io/InputStream:read	([B)I
    //   224: iconst_4
    //   225: if_icmpne +277 -> 502
    //   228: getstatic 1042	androidx/exifinterface/media/ExifInterface:WEBP_CHUNK_TYPE_VP8X	[B
    //   231: astore 9
    //   233: aload 10
    //   235: aload 9
    //   237: invokestatic 1554	java/util/Arrays:equals	([B[B)Z
    //   240: ifeq +183 -> 423
    //   243: aload 5
    //   245: invokevirtual 1558	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readInt	()I
    //   248: istore 12
    //   250: iconst_1
    //   251: istore 13
    //   253: iload 12
    //   255: iconst_2
    //   256: irem
    //   257: iconst_1
    //   258: if_icmpne +12 -> 270
    //   261: iload 12
    //   263: iconst_1
    //   264: iadd
    //   265: istore 11
    //   267: goto +7 -> 274
    //   270: iload 12
    //   272: istore 11
    //   274: iload 11
    //   276: newarray <illegal type>
    //   278: astore 10
    //   280: aload 5
    //   282: aload 10
    //   284: invokevirtual 1521	java/io/InputStream:read	([B)I
    //   287: pop
    //   288: aload 10
    //   290: iconst_0
    //   291: aload 10
    //   293: iconst_0
    //   294: baload
    //   295: bipush 8
    //   297: ior
    //   298: i2b
    //   299: i2b
    //   300: bastore
    //   301: aload 10
    //   303: iconst_0
    //   304: baload
    //   305: iconst_1
    //   306: ishr
    //   307: iconst_1
    //   308: iand
    //   309: iconst_1
    //   310: if_icmpne +10 -> 320
    //   313: iload 13
    //   315: istore 11
    //   317: goto +6 -> 323
    //   320: iconst_0
    //   321: istore 11
    //   323: aload_2
    //   324: aload 9
    //   326: invokevirtual 1561	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:write	([B)V
    //   329: aload_2
    //   330: iload 12
    //   332: invokevirtual 1564	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:writeInt	(I)V
    //   335: aload_2
    //   336: aload 10
    //   338: invokevirtual 1561	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:write	([B)V
    //   341: iload 11
    //   343: ifeq +58 -> 401
    //   346: aload_0
    //   347: aload 5
    //   349: aload_2
    //   350: getstatic 1054	androidx/exifinterface/media/ExifInterface:WEBP_CHUNK_TYPE_ANIM	[B
    //   353: aconst_null
    //   354: invokespecial 2259	androidx/exifinterface/media/ExifInterface:copyChunksUpToGivenChunkType	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream;[B[B)V
    //   357: iconst_4
    //   358: newarray <illegal type>
    //   360: astore 9
    //   362: aload_1
    //   363: aload 9
    //   365: invokevirtual 1521	java/io/InputStream:read	([B)I
    //   368: pop
    //   369: aload 9
    //   371: getstatic 1058	androidx/exifinterface/media/ExifInterface:WEBP_CHUNK_TYPE_ANMF	[B
    //   374: invokestatic 1554	java/util/Arrays:equals	([B[B)Z
    //   377: ifne +12 -> 389
    //   380: aload_0
    //   381: aload_2
    //   382: invokespecial 2222	androidx/exifinterface/media/ExifInterface:writeExifSegment	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream;)I
    //   385: pop
    //   386: goto +59 -> 445
    //   389: aload_0
    //   390: aload 5
    //   392: aload_2
    //   393: aload 9
    //   395: invokespecial 1551	androidx/exifinterface/media/ExifInterface:copyWebPChunk	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream;[B)V
    //   398: goto -41 -> 357
    //   401: aload_0
    //   402: aload 5
    //   404: aload_2
    //   405: getstatic 1050	androidx/exifinterface/media/ExifInterface:WEBP_CHUNK_TYPE_VP8	[B
    //   408: getstatic 1046	androidx/exifinterface/media/ExifInterface:WEBP_CHUNK_TYPE_VP8L	[B
    //   411: invokespecial 2259	androidx/exifinterface/media/ExifInterface:copyChunksUpToGivenChunkType	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream;Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream;[B[B)V
    //   414: aload_0
    //   415: aload_2
    //   416: invokespecial 2222	androidx/exifinterface/media/ExifInterface:writeExifSegment	(Landroidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream;)I
    //   419: pop
    //   420: goto +25 -> 445
    //   423: aload 10
    //   425: getstatic 1050	androidx/exifinterface/media/ExifInterface:WEBP_CHUNK_TYPE_VP8	[B
    //   428: invokestatic 1554	java/util/Arrays:equals	([B[B)Z
    //   431: ifne +58 -> 489
    //   434: aload 10
    //   436: getstatic 1046	androidx/exifinterface/media/ExifInterface:WEBP_CHUNK_TYPE_VP8L	[B
    //   439: invokestatic 1554	java/util/Arrays:equals	([B[B)Z
    //   442: ifne +47 -> 489
    //   445: aload 5
    //   447: aload_2
    //   448: invokestatic 2232	androidx/exifinterface/media/ExifInterface:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   451: pop
    //   452: aload_3
    //   453: invokevirtual 2260	java/io/ByteArrayOutputStream:size	()I
    //   456: istore 11
    //   458: getstatic 1021	androidx/exifinterface/media/ExifInterface:WEBP_SIGNATURE_2	[B
    //   461: astore_1
    //   462: aload 6
    //   464: iload 11
    //   466: aload_1
    //   467: arraylength
    //   468: iadd
    //   469: invokevirtual 1564	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:writeInt	(I)V
    //   472: aload 6
    //   474: aload_1
    //   475: invokevirtual 1561	androidx/exifinterface/media/ExifInterface$ByteOrderedDataOutputStream:write	([B)V
    //   478: aload_3
    //   479: aload 6
    //   481: invokevirtual 2264	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   484: aload_3
    //   485: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   488: return
    //   489: new 1293	java/io/IOException
    //   492: astore_1
    //   493: aload_1
    //   494: ldc_w 2266
    //   497: invokespecial 1538	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   500: aload_1
    //   501: athrow
    //   502: new 1293	java/io/IOException
    //   505: astore_1
    //   506: aload_1
    //   507: ldc_w 2268
    //   510: invokespecial 1538	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   513: aload_1
    //   514: athrow
    //   515: astore_1
    //   516: aload_3
    //   517: astore_2
    //   518: goto +42 -> 560
    //   521: astore_2
    //   522: aload_3
    //   523: astore_1
    //   524: aload_2
    //   525: astore_3
    //   526: goto +11 -> 537
    //   529: astore_1
    //   530: goto +30 -> 560
    //   533: astore_3
    //   534: aload 9
    //   536: astore_1
    //   537: aload_1
    //   538: astore_2
    //   539: new 1293	java/io/IOException
    //   542: astore 9
    //   544: aload_1
    //   545: astore_2
    //   546: aload 9
    //   548: ldc_w 2270
    //   551: aload_3
    //   552: invokespecial 1359	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   555: aload_1
    //   556: astore_2
    //   557: aload 9
    //   559: athrow
    //   560: aload_2
    //   561: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   564: aload_1
    //   565: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	ExifInterface
    //   0	566	1	paramInputStream	InputStream
    //   0	566	2	paramOutputStream	OutputStream
    //   13	513	3	localObject1	Object
    //   533	19	3	localException	Exception
    //   64	84	4	localByteOrder	ByteOrder
    //   76	370	5	localByteOrderedDataInputStream	ByteOrderedDataInputStream
    //   88	392	6	localByteOrderedDataOutputStream	ByteOrderedDataOutputStream
    //   93	76	7	arrayOfByte1	byte[]
    //   108	66	8	arrayOfByte2	byte[]
    //   122	436	9	localObject2	Object
    //   125	310	10	arrayOfByte3	byte[]
    //   156	313	11	i	int
    //   248	83	12	j	int
    //   251	63	13	k	int
    // Exception table:
    //   from	to	target	type
    //   141	158	515	finally
    //   163	209	515	finally
    //   212	250	515	finally
    //   274	288	515	finally
    //   323	341	515	finally
    //   346	357	515	finally
    //   357	386	515	finally
    //   389	398	515	finally
    //   401	420	515	finally
    //   423	445	515	finally
    //   445	484	515	finally
    //   489	502	515	finally
    //   502	515	515	finally
    //   141	158	521	java/lang/Exception
    //   163	209	521	java/lang/Exception
    //   212	250	521	java/lang/Exception
    //   274	288	521	java/lang/Exception
    //   323	341	521	java/lang/Exception
    //   346	357	521	java/lang/Exception
    //   357	386	521	java/lang/Exception
    //   389	398	521	java/lang/Exception
    //   401	420	521	java/lang/Exception
    //   423	445	521	java/lang/Exception
    //   445	484	521	java/lang/Exception
    //   489	502	521	java/lang/Exception
    //   502	515	521	java/lang/Exception
    //   130	134	529	finally
    //   137	141	529	finally
    //   539	544	529	finally
    //   546	555	529	finally
    //   557	560	529	finally
    //   130	134	533	java/lang/Exception
    //   137	141	533	java/lang/Exception
  }
  
  private void setThumbnailData(ByteOrderedDataInputStream paramByteOrderedDataInputStream)
    throws IOException
  {
    HashMap localHashMap = this.mAttributes[4];
    ExifAttribute localExifAttribute = (ExifAttribute)localHashMap.get("Compression");
    if (localExifAttribute != null)
    {
      int i = localExifAttribute.getIntValue(this.mExifByteOrder);
      this.mThumbnailCompression = i;
      if (i != 1) {
        if (i != 6)
        {
          if (i != 7) {
            return;
          }
        }
        else
        {
          handleThumbnailFromJfif(paramByteOrderedDataInputStream, localHashMap);
          return;
        }
      }
      if (isSupportedDataType(localHashMap)) {
        handleThumbnailFromStrips(paramByteOrderedDataInputStream, localHashMap);
      }
    }
    else
    {
      this.mThumbnailCompression = 6;
      handleThumbnailFromJfif(paramByteOrderedDataInputStream, localHashMap);
    }
  }
  
  private static boolean startsWith(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      if (paramArrayOfByte1.length < paramArrayOfByte2.length) {
        return false;
      }
      for (int i = 0; i < paramArrayOfByte2.length; i++) {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private void swapBasedOnImageSize(int paramInt1, int paramInt2)
    throws IOException
  {
    if ((!this.mAttributes[paramInt1].isEmpty()) && (!this.mAttributes[paramInt2].isEmpty()))
    {
      ExifAttribute localExifAttribute1 = (ExifAttribute)this.mAttributes[paramInt1].get("ImageLength");
      ExifAttribute localExifAttribute2 = (ExifAttribute)this.mAttributes[paramInt1].get("ImageWidth");
      Object localObject = (ExifAttribute)this.mAttributes[paramInt2].get("ImageLength");
      ExifAttribute localExifAttribute3 = (ExifAttribute)this.mAttributes[paramInt2].get("ImageWidth");
      if ((localExifAttribute1 != null) && (localExifAttribute2 != null))
      {
        if ((localObject != null) && (localExifAttribute3 != null))
        {
          int i = localExifAttribute1.getIntValue(this.mExifByteOrder);
          int j = localExifAttribute2.getIntValue(this.mExifByteOrder);
          int k = ((ExifAttribute)localObject).getIntValue(this.mExifByteOrder);
          int m = localExifAttribute3.getIntValue(this.mExifByteOrder);
          if ((i < k) && (j < m))
          {
            localObject = this.mAttributes;
            localExifAttribute1 = localObject[paramInt1];
            localObject[paramInt1] = localObject[paramInt2];
            localObject[paramInt2] = localExifAttribute1;
          }
        }
        else if (DEBUG)
        {
          Log.d("ExifInterface", "Second image does not contain valid size information");
        }
      }
      else if (DEBUG) {
        Log.d("ExifInterface", "First image does not contain valid size information");
      }
      return;
    }
    if (DEBUG) {
      Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
    }
  }
  
  private void updateImageSizeValues(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt)
    throws IOException
  {
    ExifAttribute localExifAttribute1 = (ExifAttribute)this.mAttributes[paramInt].get("DefaultCropSize");
    Object localObject = (ExifAttribute)this.mAttributes[paramInt].get("SensorTopBorder");
    ExifAttribute localExifAttribute2 = (ExifAttribute)this.mAttributes[paramInt].get("SensorLeftBorder");
    ExifAttribute localExifAttribute3 = (ExifAttribute)this.mAttributes[paramInt].get("SensorBottomBorder");
    ExifAttribute localExifAttribute4 = (ExifAttribute)this.mAttributes[paramInt].get("SensorRightBorder");
    if (localExifAttribute1 != null)
    {
      if (localExifAttribute1.format == 5)
      {
        localObject = (Rational[])localExifAttribute1.getValue(this.mExifByteOrder);
        if ((localObject != null) && (localObject.length == 2))
        {
          paramByteOrderedDataInputStream = ExifAttribute.createURational(localObject[0], this.mExifByteOrder);
          localObject = ExifAttribute.createURational(localObject[1], this.mExifByteOrder);
        }
        else
        {
          paramByteOrderedDataInputStream = new StringBuilder();
          paramByteOrderedDataInputStream.append("Invalid crop size values. cropSize=");
          paramByteOrderedDataInputStream.append(Arrays.toString((Object[])localObject));
          Log.w("ExifInterface", paramByteOrderedDataInputStream.toString());
        }
      }
      else
      {
        localObject = (int[])localExifAttribute1.getValue(this.mExifByteOrder);
        if ((localObject == null) || (localObject.length != 2)) {
          break label275;
        }
        paramByteOrderedDataInputStream = ExifAttribute.createUShort(localObject[0], this.mExifByteOrder);
        localObject = ExifAttribute.createUShort(localObject[1], this.mExifByteOrder);
      }
      this.mAttributes[paramInt].put("ImageWidth", paramByteOrderedDataInputStream);
      this.mAttributes[paramInt].put("ImageLength", localObject);
      return;
      label275:
      paramByteOrderedDataInputStream = new StringBuilder();
      paramByteOrderedDataInputStream.append("Invalid crop size values. cropSize=");
      paramByteOrderedDataInputStream.append(Arrays.toString((int[])localObject));
      Log.w("ExifInterface", paramByteOrderedDataInputStream.toString());
    }
    else if ((localObject != null) && (localExifAttribute2 != null) && (localExifAttribute3 != null) && (localExifAttribute4 != null))
    {
      int i = ((ExifAttribute)localObject).getIntValue(this.mExifByteOrder);
      int j = localExifAttribute3.getIntValue(this.mExifByteOrder);
      int k = localExifAttribute4.getIntValue(this.mExifByteOrder);
      int m = localExifAttribute2.getIntValue(this.mExifByteOrder);
      if ((j > i) && (k > m))
      {
        localObject = ExifAttribute.createUShort(j - i, this.mExifByteOrder);
        paramByteOrderedDataInputStream = ExifAttribute.createUShort(k - m, this.mExifByteOrder);
        this.mAttributes[paramInt].put("ImageLength", localObject);
        this.mAttributes[paramInt].put("ImageWidth", paramByteOrderedDataInputStream);
      }
    }
    else
    {
      retrieveJpegImageSize(paramByteOrderedDataInputStream, paramInt);
    }
  }
  
  private void validateImages()
    throws IOException
  {
    swapBasedOnImageSize(0, 5);
    swapBasedOnImageSize(0, 4);
    swapBasedOnImageSize(5, 4);
    Object localObject = (ExifAttribute)this.mAttributes[1].get("PixelXDimension");
    ExifAttribute localExifAttribute = (ExifAttribute)this.mAttributes[1].get("PixelYDimension");
    if ((localObject != null) && (localExifAttribute != null))
    {
      this.mAttributes[0].put("ImageWidth", localObject);
      this.mAttributes[0].put("ImageLength", localExifAttribute);
    }
    if ((this.mAttributes[4].isEmpty()) && (isThumbnail(this.mAttributes[5])))
    {
      localObject = this.mAttributes;
      localObject[4] = localObject[5];
      localObject[5] = new HashMap();
    }
    if (!isThumbnail(this.mAttributes[4])) {
      Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }
  }
  
  private int writeExifSegment(ByteOrderedDataOutputStream paramByteOrderedDataOutputStream)
    throws IOException
  {
    Object localObject1 = EXIF_TAGS;
    int[] arrayOfInt = new int[localObject1.length];
    localObject1 = new int[localObject1.length];
    Object localObject2 = EXIF_POINTER_TAGS;
    int i = localObject2.length;
    for (int j = 0; j < i; j++) {
      removeAttribute(localObject2[j].name);
    }
    removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
    removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
    int k;
    for (j = 0; j < EXIF_TAGS.length; j++)
    {
      localObject2 = this.mAttributes[j].entrySet().toArray();
      k = localObject2.length;
      for (i = 0; i < k; i++)
      {
        Map.Entry localEntry = (Map.Entry)localObject2[i];
        if (localEntry.getValue() == null) {
          this.mAttributes[j].remove(localEntry.getKey());
        }
      }
    }
    if (!this.mAttributes[1].isEmpty()) {
      this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
    }
    if (!this.mAttributes[2].isEmpty()) {
      this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
    }
    if (!this.mAttributes[3].isEmpty()) {
      this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0L, this.mExifByteOrder));
    }
    if (this.mHasThumbnail)
    {
      this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0L, this.mExifByteOrder));
      this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong(this.mThumbnailLength, this.mExifByteOrder));
    }
    for (j = 0; j < EXIF_TAGS.length; j++)
    {
      localObject2 = this.mAttributes[j].entrySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        k = ((ExifAttribute)((Map.Entry)((Iterator)localObject2).next()).getValue()).size();
        if (k > 4) {
          i += k;
        }
      }
      localObject1[j] += i;
    }
    j = 8;
    i = 0;
    while (i < EXIF_TAGS.length)
    {
      k = j;
      if (!this.mAttributes[i].isEmpty())
      {
        arrayOfInt[i] = j;
        k = j + (this.mAttributes[i].size() * 12 + 2 + 4 + localObject1[i]);
      }
      i++;
      j = k;
    }
    i = j;
    if (this.mHasThumbnail)
    {
      this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(j, this.mExifByteOrder));
      this.mThumbnailOffset = (this.mExifOffset + j);
      i = j + this.mThumbnailLength;
    }
    j = i;
    if (this.mMimeType == 4) {
      j = i + 8;
    }
    if (DEBUG) {
      for (i = 0; i < EXIF_TAGS.length; i++) {
        Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(arrayOfInt[i]), Integer.valueOf(this.mAttributes[i].size()), Integer.valueOf(localObject1[i]), Integer.valueOf(j) }));
      }
    }
    if (!this.mAttributes[1].isEmpty()) {
      this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(arrayOfInt[1], this.mExifByteOrder));
    }
    if (!this.mAttributes[2].isEmpty()) {
      this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(arrayOfInt[2], this.mExifByteOrder));
    }
    if (!this.mAttributes[3].isEmpty()) {
      this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(arrayOfInt[3], this.mExifByteOrder));
    }
    i = this.mMimeType;
    if (i != 4)
    {
      if (i != 13)
      {
        if (i == 14)
        {
          paramByteOrderedDataOutputStream.write(WEBP_CHUNK_TYPE_EXIF);
          paramByteOrderedDataOutputStream.writeInt(j);
        }
      }
      else
      {
        paramByteOrderedDataOutputStream.writeInt(j);
        paramByteOrderedDataOutputStream.write(PNG_CHUNK_TYPE_EXIF);
      }
    }
    else
    {
      paramByteOrderedDataOutputStream.writeUnsignedShort(j);
      paramByteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
    }
    int m;
    if (this.mExifByteOrder == ByteOrder.BIG_ENDIAN)
    {
      i = 19789;
      m = i;
    }
    else
    {
      i = 18761;
      m = i;
    }
    paramByteOrderedDataOutputStream.writeShort(m);
    paramByteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
    paramByteOrderedDataOutputStream.writeUnsignedShort(42);
    paramByteOrderedDataOutputStream.writeUnsignedInt(8L);
    for (i = 0; i < EXIF_TAGS.length; i++) {
      if (!this.mAttributes[i].isEmpty())
      {
        paramByteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[i].size());
        k = arrayOfInt[i] + 2 + this.mAttributes[i].size() * 12 + 4;
        localObject1 = this.mAttributes[i].entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          int n = ((ExifTag)sExifTagMapsForWriting[i].get(((Map.Entry)localObject2).getKey())).number;
          localObject2 = (ExifAttribute)((Map.Entry)localObject2).getValue();
          int i1 = ((ExifAttribute)localObject2).size();
          paramByteOrderedDataOutputStream.writeUnsignedShort(n);
          paramByteOrderedDataOutputStream.writeUnsignedShort(((ExifAttribute)localObject2).format);
          paramByteOrderedDataOutputStream.writeInt(((ExifAttribute)localObject2).numberOfComponents);
          if (i1 > 4)
          {
            paramByteOrderedDataOutputStream.writeUnsignedInt(k);
            k += i1;
          }
          else
          {
            paramByteOrderedDataOutputStream.write(((ExifAttribute)localObject2).bytes);
            if (i1 < 4) {
              while (i1 < 4)
              {
                paramByteOrderedDataOutputStream.writeByte(0);
                i1++;
              }
            }
          }
        }
        if ((i == 0) && (!this.mAttributes[4].isEmpty())) {
          paramByteOrderedDataOutputStream.writeUnsignedInt(arrayOfInt[4]);
        } else {
          paramByteOrderedDataOutputStream.writeUnsignedInt(0L);
        }
        localObject2 = this.mAttributes[i].entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((ExifAttribute)((Map.Entry)((Iterator)localObject2).next()).getValue()).bytes;
          if (localObject1.length > 4) {
            paramByteOrderedDataOutputStream.write((byte[])localObject1, 0, localObject1.length);
          }
        }
      }
    }
    if (this.mHasThumbnail) {
      paramByteOrderedDataOutputStream.write(getThumbnailBytes());
    }
    if ((this.mMimeType == 14) && (j % 2 == 1)) {
      paramByteOrderedDataOutputStream.writeByte(0);
    }
    paramByteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    return j;
  }
  
  public void flipHorizontally()
  {
    int i = 1;
    switch (getAttributeInt("Orientation", 1))
    {
    default: 
      i = 0;
      break;
    case 8: 
      i = 7;
      break;
    case 7: 
      i = 8;
      break;
    case 6: 
      i = 5;
      break;
    case 5: 
      i = 6;
      break;
    case 4: 
      i = 3;
      break;
    case 3: 
      i = 4;
      break;
    case 1: 
      i = 2;
    }
    setAttribute("Orientation", Integer.toString(i));
  }
  
  public void flipVertically()
  {
    int i = 1;
    switch (getAttributeInt("Orientation", 1))
    {
    default: 
      i = 0;
      break;
    case 8: 
      i = 5;
      break;
    case 7: 
      i = 6;
      break;
    case 6: 
      i = 7;
      break;
    case 5: 
      i = 8;
      break;
    case 3: 
      i = 2;
      break;
    case 2: 
      i = 3;
      break;
    case 1: 
      i = 4;
    }
    setAttribute("Orientation", Integer.toString(i));
  }
  
  public double getAltitude(double paramDouble)
  {
    double d = getAttributeDouble("GPSAltitude", -1.0D);
    int i = -1;
    int j = getAttributeInt("GPSAltitudeRef", -1);
    if ((d >= 0.0D) && (j >= 0))
    {
      if (j != 1) {
        i = 1;
      }
      return d * i;
    }
    return paramDouble;
  }
  
  @Nullable
  public String getAttribute(@NonNull String paramString)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    Object localObject = getExifAttribute(paramString);
    if (localObject != null)
    {
      if (!sTagSetForCompatibility.contains(paramString)) {
        return ((ExifAttribute)localObject).getStringValue(this.mExifByteOrder);
      }
      if (paramString.equals("GPSTimeStamp"))
      {
        int i = ((ExifAttribute)localObject).format;
        if ((i != 5) && (i != 10))
        {
          paramString = new StringBuilder();
          paramString.append("GPS Timestamp format is not rational. format=");
          paramString.append(((ExifAttribute)localObject).format);
          Log.w("ExifInterface", paramString.toString());
          return null;
        }
        localObject = (Rational[])((ExifAttribute)localObject).getValue(this.mExifByteOrder);
        if ((localObject != null) && (localObject.length == 3)) {
          return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf((int)((float)localObject[0].numerator / (float)localObject[0].denominator)), Integer.valueOf((int)((float)localObject[1].numerator / (float)localObject[1].denominator)), Integer.valueOf((int)((float)localObject[2].numerator / (float)localObject[2].denominator)) });
        }
        paramString = new StringBuilder();
        paramString.append("Invalid GPS Timestamp array. array=");
        paramString.append(Arrays.toString((Object[])localObject));
        Log.w("ExifInterface", paramString.toString());
        return null;
      }
    }
    try
    {
      paramString = Double.toString(((ExifAttribute)localObject).getDoubleValue(this.mExifByteOrder));
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  @Nullable
  public byte[] getAttributeBytes(@NonNull String paramString)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    paramString = getExifAttribute(paramString);
    if (paramString != null) {
      return paramString.bytes;
    }
    return null;
  }
  
  public double getAttributeDouble(@NonNull String paramString, double paramDouble)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    paramString = getExifAttribute(paramString);
    if (paramString == null) {
      return paramDouble;
    }
    try
    {
      double d = paramString.getDoubleValue(this.mExifByteOrder);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  public int getAttributeInt(@NonNull String paramString, int paramInt)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    paramString = getExifAttribute(paramString);
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i = paramString.getIntValue(this.mExifByteOrder);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  @Nullable
  public long[] getAttributeRange(@NonNull String paramString)
  {
    Objects.requireNonNull(paramString, "tag shouldn't be null");
    if (!this.mModified)
    {
      paramString = getExifAttribute(paramString);
      if (paramString != null) {
        return new long[] { paramString.bytesOffset, paramString.bytes.length };
      }
      return null;
    }
    throw new IllegalStateException("The underlying file has been modified since being parsed");
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public long getDateTime()
  {
    return parseDateTime(getAttribute("DateTime"), getAttribute("SubSecTime"));
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public long getDateTimeDigitized()
  {
    return parseDateTime(getAttribute("DateTimeDigitized"), getAttribute("SubSecTimeDigitized"));
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public long getDateTimeOriginal()
  {
    return parseDateTime(getAttribute("DateTimeOriginal"), getAttribute("SubSecTimeOriginal"));
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public long getGpsDateTime()
  {
    Object localObject1 = getAttribute("GPSDateStamp");
    Object localObject2 = getAttribute("GPSTimeStamp");
    if ((localObject1 != null) && (localObject2 != null))
    {
      Object localObject3 = sNonZeroTimePattern;
      if ((((Pattern)localObject3).matcher((CharSequence)localObject1).matches()) || (((Pattern)localObject3).matcher((CharSequence)localObject2).matches()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(' ');
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject3).toString();
        localObject2 = new ParsePosition(0);
      }
    }
    try
    {
      localObject1 = sFormatter.parse((String)localObject1, (ParsePosition)localObject2);
      if (localObject1 == null) {
        return -1L;
      }
      long l = ((Date)localObject1).getTime();
      return l;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    return -1L;
  }
  
  @Deprecated
  public boolean getLatLong(float[] paramArrayOfFloat)
  {
    double[] arrayOfDouble = getLatLong();
    if (arrayOfDouble == null) {
      return false;
    }
    paramArrayOfFloat[0] = ((float)arrayOfDouble[0]);
    paramArrayOfFloat[1] = ((float)arrayOfDouble[1]);
    return true;
  }
  
  @Nullable
  public double[] getLatLong()
  {
    String str1 = getAttribute("GPSLatitude");
    String str2 = getAttribute("GPSLatitudeRef");
    String str3 = getAttribute("GPSLongitude");
    String str4 = getAttribute("GPSLongitudeRef");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null)) {
      try
      {
        double d1 = convertRationalLatLonToDouble(str1, str2);
        double d2 = convertRationalLatLonToDouble(str3, str4);
        return new double[] { d1, d2 };
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Latitude/longitude values are not parsable. ");
        localStringBuilder.append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[] { str1, str2, str3, str4 }));
        Log.w("ExifInterface", localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public int getRotationDegrees()
  {
    switch (getAttributeInt("Orientation", 1))
    {
    default: 
      return 0;
    case 6: 
    case 7: 
      return 90;
    case 5: 
    case 8: 
      return 270;
    }
    return 180;
  }
  
  @Nullable
  public byte[] getThumbnail()
  {
    int i = this.mThumbnailCompression;
    if ((i != 6) && (i != 7)) {
      return null;
    }
    return getThumbnailBytes();
  }
  
  @Nullable
  public Bitmap getThumbnailBitmap()
  {
    if (!this.mHasThumbnail) {
      return null;
    }
    if (this.mThumbnailBytes == null) {
      this.mThumbnailBytes = getThumbnailBytes();
    }
    int i = this.mThumbnailCompression;
    if ((i != 6) && (i != 7))
    {
      if (i == 1)
      {
        int j = this.mThumbnailBytes.length / 3;
        int[] arrayOfInt = new int[j];
        for (i = 0; i < j; i++)
        {
          localObject = this.mThumbnailBytes;
          int k = i * 3;
          arrayOfInt[i] = ((localObject[k] << 16) + 0 + (localObject[(k + 1)] << 8) + localObject[(k + 2)]);
        }
        ExifAttribute localExifAttribute = (ExifAttribute)this.mAttributes[4].get("ImageLength");
        Object localObject = (ExifAttribute)this.mAttributes[4].get("ImageWidth");
        if ((localExifAttribute != null) && (localObject != null))
        {
          i = localExifAttribute.getIntValue(this.mExifByteOrder);
          return Bitmap.createBitmap(arrayOfInt, ((ExifAttribute)localObject).getIntValue(this.mExifByteOrder), i, Bitmap.Config.ARGB_8888);
        }
      }
      return null;
    }
    return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
  }
  
  /* Error */
  @Nullable
  public byte[] getThumbnailBytes()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1894	androidx/exifinterface/media/ExifInterface:mHasThumbnail	Z
    //   4: istore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: iload_1
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_0
    //   14: getfield 1900	androidx/exifinterface/media/ExifInterface:mThumbnailBytes	[B
    //   17: astore_3
    //   18: aload_3
    //   19: ifnull +5 -> 24
    //   22: aload_3
    //   23: areturn
    //   24: aload_0
    //   25: getfield 1335	androidx/exifinterface/media/ExifInterface:mAssetInputStream	Landroid/content/res/AssetManager$AssetInputStream;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +51 -> 83
    //   35: aload 4
    //   37: invokevirtual 2432	java/io/InputStream:markSupported	()Z
    //   40: ifeq +13 -> 53
    //   43: aload 4
    //   45: invokevirtual 2433	java/io/InputStream:reset	()V
    //   48: aconst_null
    //   49: astore_3
    //   50: goto +127 -> 177
    //   53: ldc_w 382
    //   56: ldc_w 2435
    //   59: invokestatic 1575	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   62: pop
    //   63: aload 4
    //   65: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   68: aconst_null
    //   69: areturn
    //   70: astore_3
    //   71: aconst_null
    //   72: astore 5
    //   74: goto +368 -> 442
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_3
    //   80: goto +324 -> 404
    //   83: aload_0
    //   84: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   87: ifnull +19 -> 106
    //   90: new 1361	java/io/FileInputStream
    //   93: dup
    //   94: aload_0
    //   95: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   98: invokespecial 1926	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   101: astore 4
    //   103: goto -55 -> 48
    //   106: getstatic 1342	android/os/Build$VERSION:SDK_INT	I
    //   109: bipush 21
    //   111: if_icmplt +60 -> 171
    //   114: aload_0
    //   115: getfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   118: astore_3
    //   119: aload_3
    //   120: ifnull +51 -> 171
    //   123: aload_3
    //   124: invokestatic 1354	android/system/Os:dup	(Ljava/io/FileDescriptor;)Ljava/io/FileDescriptor;
    //   127: astore_3
    //   128: aload_3
    //   129: lconst_0
    //   130: getstatic 2438	android/system/OsConstants:SEEK_SET	I
    //   133: invokestatic 1952	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   136: pop2
    //   137: new 1361	java/io/FileInputStream
    //   140: dup
    //   141: aload_3
    //   142: invokespecial 1363	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   145: astore 4
    //   147: goto +30 -> 177
    //   150: astore 4
    //   152: aload_3
    //   153: astore 5
    //   155: aload 4
    //   157: astore_3
    //   158: aload_2
    //   159: astore 4
    //   161: goto +281 -> 442
    //   164: astore_2
    //   165: aconst_null
    //   166: astore 4
    //   168: goto +236 -> 404
    //   171: aconst_null
    //   172: astore 4
    //   174: aload 4
    //   176: astore_3
    //   177: aload 4
    //   179: ifnull +177 -> 356
    //   182: aload 4
    //   184: astore 6
    //   186: aload_3
    //   187: astore 5
    //   189: aload 4
    //   191: aload_0
    //   192: getfield 1896	androidx/exifinterface/media/ExifInterface:mThumbnailOffset	I
    //   195: i2l
    //   196: invokevirtual 2442	java/io/InputStream:skip	(J)J
    //   199: lstore 7
    //   201: aload 4
    //   203: astore 6
    //   205: aload_3
    //   206: astore 5
    //   208: aload_0
    //   209: getfield 1896	androidx/exifinterface/media/ExifInterface:mThumbnailOffset	I
    //   212: istore 9
    //   214: lload 7
    //   216: iload 9
    //   218: i2l
    //   219: lcmp
    //   220: ifne +98 -> 318
    //   223: aload 4
    //   225: astore 6
    //   227: aload_3
    //   228: astore 5
    //   230: aload_0
    //   231: getfield 1898	androidx/exifinterface/media/ExifInterface:mThumbnailLength	I
    //   234: newarray <illegal type>
    //   236: astore_2
    //   237: aload 4
    //   239: astore 6
    //   241: aload_3
    //   242: astore 5
    //   244: aload 4
    //   246: aload_2
    //   247: invokevirtual 1521	java/io/InputStream:read	([B)I
    //   250: aload_0
    //   251: getfield 1898	androidx/exifinterface/media/ExifInterface:mThumbnailLength	I
    //   254: if_icmpne +30 -> 284
    //   257: aload 4
    //   259: astore 6
    //   261: aload_3
    //   262: astore 5
    //   264: aload_0
    //   265: aload_2
    //   266: putfield 1900	androidx/exifinterface/media/ExifInterface:mThumbnailBytes	[B
    //   269: aload 4
    //   271: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   274: aload_3
    //   275: ifnull +7 -> 282
    //   278: aload_3
    //   279: invokestatic 1374	androidx/exifinterface/media/ExifInterface:closeFileDescriptor	(Ljava/io/FileDescriptor;)V
    //   282: aload_2
    //   283: areturn
    //   284: aload 4
    //   286: astore 6
    //   288: aload_3
    //   289: astore 5
    //   291: new 1293	java/io/IOException
    //   294: astore_2
    //   295: aload 4
    //   297: astore 6
    //   299: aload_3
    //   300: astore 5
    //   302: aload_2
    //   303: ldc_w 2444
    //   306: invokespecial 1538	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   309: aload 4
    //   311: astore 6
    //   313: aload_3
    //   314: astore 5
    //   316: aload_2
    //   317: athrow
    //   318: aload 4
    //   320: astore 6
    //   322: aload_3
    //   323: astore 5
    //   325: new 1293	java/io/IOException
    //   328: astore_2
    //   329: aload 4
    //   331: astore 6
    //   333: aload_3
    //   334: astore 5
    //   336: aload_2
    //   337: ldc_w 2444
    //   340: invokespecial 1538	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   343: aload 4
    //   345: astore 6
    //   347: aload_3
    //   348: astore 5
    //   350: aload_2
    //   351: athrow
    //   352: astore_2
    //   353: goto +51 -> 404
    //   356: aload 4
    //   358: astore 6
    //   360: aload_3
    //   361: astore 5
    //   363: new 2446	java/io/FileNotFoundException
    //   366: astore_2
    //   367: aload 4
    //   369: astore 6
    //   371: aload_3
    //   372: astore 5
    //   374: aload_2
    //   375: invokespecial 2447	java/io/FileNotFoundException:<init>	()V
    //   378: aload 4
    //   380: astore 6
    //   382: aload_3
    //   383: astore 5
    //   385: aload_2
    //   386: athrow
    //   387: astore_3
    //   388: aconst_null
    //   389: astore 5
    //   391: aload_2
    //   392: astore 4
    //   394: goto +48 -> 442
    //   397: astore_2
    //   398: aconst_null
    //   399: astore 4
    //   401: aload 4
    //   403: astore_3
    //   404: aload 4
    //   406: astore 6
    //   408: aload_3
    //   409: astore 5
    //   411: ldc_w 382
    //   414: ldc_w 2449
    //   417: aload_2
    //   418: invokestatic 1939	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   421: pop
    //   422: aload 4
    //   424: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   427: aload_3
    //   428: ifnull +7 -> 435
    //   431: aload_3
    //   432: invokestatic 1374	androidx/exifinterface/media/ExifInterface:closeFileDescriptor	(Ljava/io/FileDescriptor;)V
    //   435: aconst_null
    //   436: areturn
    //   437: astore_3
    //   438: aload 6
    //   440: astore 4
    //   442: aload 4
    //   444: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   447: aload 5
    //   449: ifnull +8 -> 457
    //   452: aload 5
    //   454: invokestatic 1374	androidx/exifinterface/media/ExifInterface:closeFileDescriptor	(Ljava/io/FileDescriptor;)V
    //   457: aload_3
    //   458: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	this	ExifInterface
    //   4	4	1	bool	boolean
    //   6	1	2	localObject1	Object
    //   77	82	2	localException1	Exception
    //   164	1	2	localException2	Exception
    //   236	115	2	localObject2	Object
    //   352	1	2	localException3	Exception
    //   366	26	2	localFileNotFoundException	java.io.FileNotFoundException
    //   397	21	2	localException4	Exception
    //   17	33	3	arrayOfByte	byte[]
    //   70	1	3	localObject3	Object
    //   79	304	3	localObject4	Object
    //   387	1	3	localObject5	Object
    //   403	29	3	localObject6	Object
    //   437	21	3	localObject7	Object
    //   28	118	4	localObject8	Object
    //   150	6	4	localObject9	Object
    //   159	284	4	localObject10	Object
    //   72	381	5	localObject11	Object
    //   184	255	6	localObject12	Object
    //   199	16	7	l	long
    //   212	5	9	i	int
    // Exception table:
    //   from	to	target	type
    //   35	48	70	finally
    //   53	63	70	finally
    //   35	48	77	java/lang/Exception
    //   53	63	77	java/lang/Exception
    //   128	147	150	finally
    //   128	147	164	java/lang/Exception
    //   189	201	352	java/lang/Exception
    //   208	214	352	java/lang/Exception
    //   230	237	352	java/lang/Exception
    //   244	257	352	java/lang/Exception
    //   264	269	352	java/lang/Exception
    //   291	295	352	java/lang/Exception
    //   302	309	352	java/lang/Exception
    //   316	318	352	java/lang/Exception
    //   325	329	352	java/lang/Exception
    //   336	343	352	java/lang/Exception
    //   350	352	352	java/lang/Exception
    //   363	367	352	java/lang/Exception
    //   374	378	352	java/lang/Exception
    //   385	387	352	java/lang/Exception
    //   24	30	387	finally
    //   83	103	387	finally
    //   106	119	387	finally
    //   123	128	387	finally
    //   24	30	397	java/lang/Exception
    //   83	103	397	java/lang/Exception
    //   106	119	397	java/lang/Exception
    //   123	128	397	java/lang/Exception
    //   189	201	437	finally
    //   208	214	437	finally
    //   230	237	437	finally
    //   244	257	437	finally
    //   264	269	437	finally
    //   291	295	437	finally
    //   302	309	437	finally
    //   316	318	437	finally
    //   325	329	437	finally
    //   336	343	437	finally
    //   350	352	437	finally
    //   363	367	437	finally
    //   374	378	437	finally
    //   385	387	437	finally
    //   411	422	437	finally
  }
  
  @Nullable
  public long[] getThumbnailRange()
  {
    if (!this.mModified)
    {
      if (this.mHasThumbnail)
      {
        if ((this.mHasThumbnailStrips) && (!this.mAreThumbnailStripsConsecutive)) {
          return null;
        }
        return new long[] { this.mThumbnailOffset, this.mThumbnailLength };
      }
      return null;
    }
    throw new IllegalStateException("The underlying file has been modified since being parsed");
  }
  
  public boolean hasAttribute(@NonNull String paramString)
  {
    boolean bool;
    if (getExifAttribute(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean hasThumbnail()
  {
    return this.mHasThumbnail;
  }
  
  public boolean isFlipped()
  {
    int i = getAttributeInt("Orientation", 1);
    return (i == 2) || (i == 7) || (i == 4) || (i == 5);
  }
  
  public boolean isThumbnailCompressed()
  {
    if (!this.mHasThumbnail) {
      return false;
    }
    int i = this.mThumbnailCompression;
    return (i == 6) || (i == 7);
  }
  
  public void resetOrientation()
  {
    setAttribute("Orientation", Integer.toString(1));
  }
  
  public void rotate(int paramInt)
  {
    if (paramInt % 90 == 0)
    {
      int i = getAttributeInt("Orientation", 1);
      List localList = ROTATION_ORDER;
      boolean bool = localList.contains(Integer.valueOf(i));
      int j = 0;
      int k = 0;
      int m = 0;
      if (bool)
      {
        j = (localList.indexOf(Integer.valueOf(i)) + paramInt / 90) % 4;
        paramInt = m;
        if (j < 0) {
          paramInt = 4;
        }
        m = ((Integer)localList.get(j + paramInt)).intValue();
      }
      else
      {
        localList = FLIPPED_ROTATION_ORDER;
        m = k;
        if (localList.contains(Integer.valueOf(i)))
        {
          m = (localList.indexOf(Integer.valueOf(i)) + paramInt / 90) % 4;
          paramInt = j;
          if (m < 0) {
            paramInt = 4;
          }
          m = ((Integer)localList.get(m + paramInt)).intValue();
        }
      }
      setAttribute("Orientation", Integer.toString(m));
      return;
    }
    throw new IllegalArgumentException("degree should be a multiple of 90");
  }
  
  /* Error */
  public void saveAttributes()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 2473	androidx/exifinterface/media/ExifInterface:isSupportedFormatForSavingAttributes	()Z
    //   4: ifeq +701 -> 705
    //   7: aload_0
    //   8: getfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   11: ifnonnull +24 -> 35
    //   14: aload_0
    //   15: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   18: ifnull +6 -> 24
    //   21: goto +14 -> 35
    //   24: new 1293	java/io/IOException
    //   27: dup
    //   28: ldc_w 2475
    //   31: invokespecial 1538	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 2378	androidx/exifinterface/media/ExifInterface:mModified	Z
    //   40: aload_0
    //   41: aload_0
    //   42: invokevirtual 2477	androidx/exifinterface/media/ExifInterface:getThumbnail	()[B
    //   45: putfield 1900	androidx/exifinterface/media/ExifInterface:mThumbnailBytes	[B
    //   48: aload_0
    //   49: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_2
    //   55: aconst_null
    //   56: astore_3
    //   57: aconst_null
    //   58: astore 4
    //   60: aconst_null
    //   61: astore 5
    //   63: aload_1
    //   64: ifnull +19 -> 83
    //   67: new 1319	java/io/File
    //   70: dup
    //   71: aload_0
    //   72: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   75: invokespecial 2478	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 6
    //   80: goto +6 -> 86
    //   83: aconst_null
    //   84: astore 6
    //   86: aload_0
    //   87: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   90: ifnull +104 -> 194
    //   93: new 1319	java/io/File
    //   96: astore_1
    //   97: new 1421	java/lang/StringBuilder
    //   100: astore 7
    //   102: aload 7
    //   104: invokespecial 1471	java/lang/StringBuilder:<init>	()V
    //   107: aload 7
    //   109: aload_0
    //   110: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   113: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 7
    //   119: ldc_w 2480
    //   122: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: aload 7
    //   129: invokevirtual 1440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokespecial 2478	java/io/File:<init>	(Ljava/lang/String;)V
    //   135: aload 6
    //   137: aload_1
    //   138: invokevirtual 2484	java/io/File:renameTo	(Ljava/io/File;)Z
    //   141: ifeq +6 -> 147
    //   144: goto +164 -> 308
    //   147: new 1293	java/io/IOException
    //   150: astore 6
    //   152: new 1421	java/lang/StringBuilder
    //   155: astore 7
    //   157: aload 7
    //   159: invokespecial 1471	java/lang/StringBuilder:<init>	()V
    //   162: aload 7
    //   164: ldc_w 2486
    //   167: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 7
    //   173: aload_1
    //   174: invokevirtual 1323	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   177: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 6
    //   183: aload 7
    //   185: invokevirtual 1440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokespecial 1538	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   191: aload 6
    //   193: athrow
    //   194: getstatic 1342	android/os/Build$VERSION:SDK_INT	I
    //   197: bipush 21
    //   199: if_icmplt +107 -> 306
    //   202: aload_0
    //   203: getfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   206: ifnull +100 -> 306
    //   209: ldc_w 2488
    //   212: ldc_w 2490
    //   215: invokestatic 2494	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   218: astore 8
    //   220: aload_0
    //   221: getfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   224: lconst_0
    //   225: getstatic 2438	android/system/OsConstants:SEEK_SET	I
    //   228: invokestatic 1952	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   231: pop2
    //   232: new 1361	java/io/FileInputStream
    //   235: dup
    //   236: aload_0
    //   237: getfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   240: invokespecial 1363	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   243: astore_1
    //   244: new 2496	java/io/FileOutputStream
    //   247: astore 7
    //   249: aload 7
    //   251: aload 8
    //   253: invokespecial 2498	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   256: aload_1
    //   257: aload 7
    //   259: invokestatic 2232	androidx/exifinterface/media/ExifInterface:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   262: pop
    //   263: aload 8
    //   265: astore_3
    //   266: aload_1
    //   267: astore 4
    //   269: goto +47 -> 316
    //   272: astore 4
    //   274: goto +13 -> 287
    //   277: astore 4
    //   279: goto +24 -> 303
    //   282: astore 4
    //   284: aconst_null
    //   285: astore 7
    //   287: aload_1
    //   288: astore_3
    //   289: aload 4
    //   291: astore_1
    //   292: aload_3
    //   293: astore 4
    //   295: goto +398 -> 693
    //   298: astore 4
    //   300: aconst_null
    //   301: astore 7
    //   303: goto +369 -> 672
    //   306: aconst_null
    //   307: astore_1
    //   308: aconst_null
    //   309: astore 4
    //   311: aconst_null
    //   312: astore 7
    //   314: aload_1
    //   315: astore_3
    //   316: aload 4
    //   318: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   321: aload 7
    //   323: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   326: new 1361	java/io/FileInputStream
    //   329: astore 7
    //   331: aload 7
    //   333: aload_3
    //   334: invokespecial 2499	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   337: aload_0
    //   338: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   341: ifnull +18 -> 359
    //   344: new 2496	java/io/FileOutputStream
    //   347: astore_1
    //   348: aload_1
    //   349: aload_0
    //   350: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   353: invokespecial 2500	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   356: goto +46 -> 402
    //   359: getstatic 1342	android/os/Build$VERSION:SDK_INT	I
    //   362: bipush 21
    //   364: if_icmplt +36 -> 400
    //   367: aload_0
    //   368: getfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   371: astore_1
    //   372: aload_1
    //   373: ifnull +27 -> 400
    //   376: aload_1
    //   377: lconst_0
    //   378: getstatic 2438	android/system/OsConstants:SEEK_SET	I
    //   381: invokestatic 1952	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   384: pop2
    //   385: new 2496	java/io/FileOutputStream
    //   388: dup
    //   389: aload_0
    //   390: getfield 1348	androidx/exifinterface/media/ExifInterface:mSeekableFileDescriptor	Ljava/io/FileDescriptor;
    //   393: invokespecial 2501	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   396: astore_1
    //   397: goto +5 -> 402
    //   400: aconst_null
    //   401: astore_1
    //   402: new 1382	java/io/BufferedInputStream
    //   405: astore 8
    //   407: aload 8
    //   409: aload 7
    //   411: invokespecial 2502	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   414: new 2504	java/io/BufferedOutputStream
    //   417: astore 7
    //   419: aload 7
    //   421: aload_1
    //   422: invokespecial 2506	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   425: aload_0
    //   426: getfield 1821	androidx/exifinterface/media/ExifInterface:mMimeType	I
    //   429: istore 9
    //   431: iload 9
    //   433: iconst_4
    //   434: if_icmpne +14 -> 448
    //   437: aload_0
    //   438: aload 8
    //   440: aload 7
    //   442: invokespecial 2508	androidx/exifinterface/media/ExifInterface:saveJpegAttributes	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   445: goto +36 -> 481
    //   448: iload 9
    //   450: bipush 13
    //   452: if_icmpne +14 -> 466
    //   455: aload_0
    //   456: aload 8
    //   458: aload 7
    //   460: invokespecial 2510	androidx/exifinterface/media/ExifInterface:savePngAttributes	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   463: goto +18 -> 481
    //   466: iload 9
    //   468: bipush 14
    //   470: if_icmpne +11 -> 481
    //   473: aload_0
    //   474: aload 8
    //   476: aload 7
    //   478: invokespecial 2512	androidx/exifinterface/media/ExifInterface:saveWebpAttributes	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   481: aload 8
    //   483: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   486: aload 7
    //   488: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   491: aload_3
    //   492: invokevirtual 2515	java/io/File:delete	()Z
    //   495: pop
    //   496: aload_0
    //   497: aconst_null
    //   498: putfield 1900	androidx/exifinterface/media/ExifInterface:mThumbnailBytes	[B
    //   501: return
    //   502: astore_1
    //   503: goto +12 -> 515
    //   506: astore 4
    //   508: goto +19 -> 527
    //   511: astore_1
    //   512: aconst_null
    //   513: astore 7
    //   515: aload 8
    //   517: astore 4
    //   519: goto +122 -> 641
    //   522: astore 4
    //   524: aconst_null
    //   525: astore 7
    //   527: aload 8
    //   529: astore_1
    //   530: goto +21 -> 551
    //   533: astore_1
    //   534: aconst_null
    //   535: astore 7
    //   537: aload_2
    //   538: astore 4
    //   540: goto +101 -> 641
    //   543: astore 4
    //   545: aconst_null
    //   546: astore 7
    //   548: aload 5
    //   550: astore_1
    //   551: aload_0
    //   552: getfield 1337	androidx/exifinterface/media/ExifInterface:mFilename	Ljava/lang/String;
    //   555: ifnull +60 -> 615
    //   558: aload_3
    //   559: aload 6
    //   561: invokevirtual 2484	java/io/File:renameTo	(Ljava/io/File;)Z
    //   564: ifne +51 -> 615
    //   567: new 1293	java/io/IOException
    //   570: astore 8
    //   572: new 1421	java/lang/StringBuilder
    //   575: astore 4
    //   577: aload 4
    //   579: invokespecial 1471	java/lang/StringBuilder:<init>	()V
    //   582: aload 4
    //   584: ldc_w 2517
    //   587: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 4
    //   593: aload 6
    //   595: invokevirtual 1323	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   598: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 8
    //   604: aload 4
    //   606: invokevirtual 1440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokespecial 1538	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   612: aload 8
    //   614: athrow
    //   615: new 1293	java/io/IOException
    //   618: astore 6
    //   620: aload 6
    //   622: ldc_w 2519
    //   625: aload 4
    //   627: invokespecial 1359	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   630: aload 6
    //   632: athrow
    //   633: astore 6
    //   635: aload_1
    //   636: astore 4
    //   638: aload 6
    //   640: astore_1
    //   641: aload 4
    //   643: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   646: aload 7
    //   648: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   651: aload_3
    //   652: invokevirtual 2515	java/io/File:delete	()Z
    //   655: pop
    //   656: aload_1
    //   657: athrow
    //   658: astore_1
    //   659: aconst_null
    //   660: astore 7
    //   662: goto +31 -> 693
    //   665: astore 4
    //   667: aconst_null
    //   668: astore 7
    //   670: aload_3
    //   671: astore_1
    //   672: new 1293	java/io/IOException
    //   675: astore_3
    //   676: aload_3
    //   677: ldc_w 2521
    //   680: aload 4
    //   682: invokespecial 1359	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   685: aload_3
    //   686: athrow
    //   687: astore_3
    //   688: aload_1
    //   689: astore 4
    //   691: aload_3
    //   692: astore_1
    //   693: aload 4
    //   695: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   698: aload 7
    //   700: invokestatic 1371	androidx/exifinterface/media/ExifInterface:closeQuietly	(Ljava/io/Closeable;)V
    //   703: aload_1
    //   704: athrow
    //   705: new 1293	java/io/IOException
    //   708: dup
    //   709: ldc_w 2523
    //   712: invokespecial 1538	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   715: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	ExifInterface
    //   52	370	1	localObject1	Object
    //   502	1	1	localObject2	Object
    //   511	1	1	localObject3	Object
    //   529	1	1	localObject4	Object
    //   533	1	1	localObject5	Object
    //   550	107	1	localObject6	Object
    //   658	1	1	localObject7	Object
    //   671	33	1	localObject8	Object
    //   54	484	2	localObject9	Object
    //   56	630	3	localObject10	Object
    //   687	5	3	localObject11	Object
    //   58	210	4	localObject12	Object
    //   272	1	4	localObject13	Object
    //   277	1	4	localException1	Exception
    //   282	8	4	localObject14	Object
    //   293	1	4	localObject15	Object
    //   298	1	4	localException2	Exception
    //   309	8	4	localCloseable	Closeable
    //   506	1	4	localException3	Exception
    //   517	1	4	localObject16	Object
    //   522	1	4	localException4	Exception
    //   538	1	4	localObject17	Object
    //   543	1	4	localException5	Exception
    //   575	67	4	localObject18	Object
    //   665	16	4	localException6	Exception
    //   689	5	4	localObject19	Object
    //   61	488	5	localObject20	Object
    //   78	553	6	localObject21	Object
    //   633	6	6	localObject22	Object
    //   100	599	7	localObject23	Object
    //   218	395	8	localObject24	Object
    //   429	42	9	i	int
    // Exception table:
    //   from	to	target	type
    //   256	263	272	finally
    //   256	263	277	java/lang/Exception
    //   244	256	282	finally
    //   244	256	298	java/lang/Exception
    //   425	431	502	finally
    //   437	445	502	finally
    //   455	463	502	finally
    //   473	481	502	finally
    //   425	431	506	java/lang/Exception
    //   437	445	506	java/lang/Exception
    //   455	463	506	java/lang/Exception
    //   473	481	506	java/lang/Exception
    //   414	425	511	finally
    //   414	425	522	java/lang/Exception
    //   326	356	533	finally
    //   359	372	533	finally
    //   376	397	533	finally
    //   402	414	533	finally
    //   326	356	543	java/lang/Exception
    //   359	372	543	java/lang/Exception
    //   376	397	543	java/lang/Exception
    //   402	414	543	java/lang/Exception
    //   551	615	633	finally
    //   615	633	633	finally
    //   86	144	658	finally
    //   147	194	658	finally
    //   194	244	658	finally
    //   86	144	665	java/lang/Exception
    //   147	194	665	java/lang/Exception
    //   194	244	665	java/lang/Exception
    //   672	687	687	finally
  }
  
  public void setAltitude(double paramDouble)
  {
    String str;
    if (paramDouble >= 0.0D) {
      str = "0";
    } else {
      str = "1";
    }
    setAttribute("GPSAltitude", new Rational(Math.abs(paramDouble)).toString());
    setAttribute("GPSAltitudeRef", str);
  }
  
  public void setAttribute(@NonNull String paramString1, @Nullable String paramString2)
  {
    String str1 = paramString1;
    paramString1 = paramString2;
    Objects.requireNonNull(str1, "tag shouldn't be null");
    boolean bool = "ISOSpeedRatings".equals(str1);
    Object localObject1 = "ExifInterface";
    if (bool)
    {
      if (DEBUG) {
        Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
      }
      str1 = "PhotographicSensitivity";
    }
    String str2 = paramString1;
    if (paramString1 != null)
    {
      str2 = paramString1;
      if (sTagSetForCompatibility.contains(str1)) {
        if (str1.equals("GPSTimeStamp"))
        {
          paramString2 = sGpsTimestampPattern.matcher(paramString1);
          if (!paramString2.find())
          {
            paramString2 = new StringBuilder();
            paramString2.append("Invalid value for ");
            paramString2.append(str1);
            paramString2.append(" : ");
            paramString2.append(paramString1);
            Log.w("ExifInterface", paramString2.toString());
            return;
          }
          paramString1 = new StringBuilder();
          paramString1.append(Integer.parseInt(paramString2.group(1)));
          paramString1.append("/1,");
          paramString1.append(Integer.parseInt(paramString2.group(2)));
          paramString1.append("/1,");
          paramString1.append(Integer.parseInt(paramString2.group(3)));
          paramString1.append("/1");
          str2 = paramString1.toString();
        }
        else
        {
          try
          {
            double d = Double.parseDouble(paramString2);
            paramString2 = new androidx/exifinterface/media/ExifInterface$Rational;
            paramString2.<init>(d);
            str2 = paramString2.toString();
          }
          catch (NumberFormatException paramString2)
          {
            paramString2 = new StringBuilder();
            paramString2.append("Invalid value for ");
            paramString2.append(str1);
            paramString2.append(" : ");
            paramString2.append(paramString1);
            Log.w("ExifInterface", paramString2.toString());
            return;
          }
        }
      }
    }
    int i = 0;
    paramString1 = (String)localObject1;
    while (i < EXIF_TAGS.length)
    {
      if ((i == 4) && (!this.mHasThumbnail))
      {
        paramString2 = paramString1;
      }
      else
      {
        ExifTag localExifTag = (ExifTag)sExifTagMapsForWriting[i].get(str1);
        paramString2 = paramString1;
        if (localExifTag != null) {
          if (str2 == null)
          {
            this.mAttributes[i].remove(str1);
            paramString2 = paramString1;
          }
          else
          {
            Pair localPair = guessDataFormat(str2);
            int j;
            Object localObject2;
            if ((localExifTag.primaryFormat != ((Integer)localPair.first).intValue()) && (localExifTag.primaryFormat != ((Integer)localPair.second).intValue()))
            {
              j = localExifTag.secondaryFormat;
              if ((j != -1) && ((j == ((Integer)localPair.first).intValue()) || (localExifTag.secondaryFormat == ((Integer)localPair.second).intValue())))
              {
                j = localExifTag.secondaryFormat;
              }
              else
              {
                j = localExifTag.primaryFormat;
                if ((j != 1) && (j != 7) && (j != 2))
                {
                  paramString2 = paramString1;
                  if (!DEBUG) {
                    break label1389;
                  }
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("Given tag (");
                  ((StringBuilder)localObject2).append(str1);
                  ((StringBuilder)localObject2).append(") value didn't match with one of expected formats: ");
                  String[] arrayOfString = IFD_FORMAT_NAMES;
                  ((StringBuilder)localObject2).append(arrayOfString[localExifTag.primaryFormat]);
                  j = localExifTag.secondaryFormat;
                  localObject1 = "";
                  if (j == -1)
                  {
                    paramString2 = "";
                  }
                  else
                  {
                    paramString2 = new StringBuilder();
                    paramString2.append(", ");
                    paramString2.append(arrayOfString[localExifTag.secondaryFormat]);
                    paramString2 = paramString2.toString();
                  }
                  ((StringBuilder)localObject2).append(paramString2);
                  ((StringBuilder)localObject2).append(" (guess: ");
                  ((StringBuilder)localObject2).append(arrayOfString[((Integer)localPair.first).intValue()]);
                  if (((Integer)localPair.second).intValue() == -1)
                  {
                    paramString2 = (String)localObject1;
                  }
                  else
                  {
                    paramString2 = new StringBuilder();
                    paramString2.append(", ");
                    paramString2.append(arrayOfString[((Integer)localPair.second).intValue()]);
                    paramString2 = paramString2.toString();
                  }
                  ((StringBuilder)localObject2).append(paramString2);
                  ((StringBuilder)localObject2).append(")");
                  Log.d(paramString1, ((StringBuilder)localObject2).toString());
                  paramString2 = paramString1;
                  break label1389;
                }
              }
            }
            else
            {
              j = localExifTag.primaryFormat;
            }
            switch (j)
            {
            case 6: 
            case 8: 
            case 11: 
            default: 
              if (!DEBUG) {
                break label1386;
              }
              paramString2 = new StringBuilder();
              paramString2.append("Data format isn't one of expected formats: ");
              paramString2.append(j);
              paramString2 = paramString2.toString();
              Log.d(paramString1, paramString2);
              break;
            case 12: 
              paramString2 = str2.split(",", -1);
              localObject1 = new double[paramString2.length];
              for (j = 0; j < paramString2.length; j++) {
                localObject1[j] = Double.parseDouble(paramString2[j]);
              }
              this.mAttributes[i].put(str1, ExifAttribute.createDouble((double[])localObject1, this.mExifByteOrder));
              paramString2 = paramString1;
              break;
            case 10: 
              localObject1 = str2.split(",", -1);
              paramString2 = new Rational[localObject1.length];
              for (j = 0; j < localObject1.length; j++)
              {
                localObject2 = localObject1[j].split("/", -1);
                paramString2[j] = new Rational(Double.parseDouble(localObject2[0]), Double.parseDouble(localObject2[1]));
              }
              this.mAttributes[i].put(str1, ExifAttribute.createSRational(paramString2, this.mExifByteOrder));
              break;
            case 9: 
              paramString2 = str2.split(",", -1);
              localObject1 = new int[paramString2.length];
              for (j = 0; j < paramString2.length; j++) {
                localObject1[j] = Integer.parseInt(paramString2[j]);
              }
              this.mAttributes[i].put(str1, ExifAttribute.createSLong((int[])localObject1, this.mExifByteOrder));
              paramString2 = paramString1;
              break;
            case 5: 
              paramString2 = str2.split(",", -1);
              localObject1 = new Rational[paramString2.length];
              for (j = 0; j < paramString2.length; j++)
              {
                localObject2 = paramString2[j].split("/", -1);
                localObject1[j] = new Rational(Double.parseDouble(localObject2[0]), Double.parseDouble(localObject2[1]));
              }
              this.mAttributes[i].put(str1, ExifAttribute.createURational((Rational[])localObject1, this.mExifByteOrder));
              break;
            case 4: 
              paramString2 = str2.split(",", -1);
              localObject1 = new long[paramString2.length];
              for (j = 0; j < paramString2.length; j++) {
                localObject1[j] = Long.parseLong(paramString2[j]);
              }
              this.mAttributes[i].put(str1, ExifAttribute.createULong((long[])localObject1, this.mExifByteOrder));
              break;
            case 3: 
              localObject1 = str2.split(",", -1);
              paramString2 = new int[localObject1.length];
              for (j = 0; j < localObject1.length; j++) {
                paramString2[j] = Integer.parseInt(localObject1[j]);
              }
              this.mAttributes[i].put(str1, ExifAttribute.createUShort(paramString2, this.mExifByteOrder));
              break;
            case 2: 
            case 7: 
              this.mAttributes[i].put(str1, ExifAttribute.createString(str2));
              break;
            }
            this.mAttributes[i].put(str1, ExifAttribute.createByte(str2));
            label1386:
            break label1391;
          }
        }
      }
      label1389:
      paramString1 = paramString2;
      label1391:
      i++;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void setDateTime(long paramLong)
  {
    setAttribute("DateTime", sFormatter.format(new Date(paramLong)));
    setAttribute("SubSecTime", Long.toString(paramLong % 1000L));
  }
  
  public void setGpsInfo(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    setAttribute("GPSProcessingMethod", paramLocation.getProvider());
    setLatLong(paramLocation.getLatitude(), paramLocation.getLongitude());
    setAltitude(paramLocation.getAltitude());
    setAttribute("GPSSpeedRef", "K");
    setAttribute("GPSSpeed", new Rational(paramLocation.getSpeed() * (float)TimeUnit.HOURS.toSeconds(1L) / 1000.0F).toString());
    paramLocation = sFormatter.format(new Date(paramLocation.getTime())).split("\\s+", -1);
    setAttribute("GPSDateStamp", paramLocation[0]);
    setAttribute("GPSTimeStamp", paramLocation[1]);
  }
  
  public void setLatLong(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 >= -90.0D) && (paramDouble1 <= 90.0D) && (!Double.isNaN(paramDouble1)))
    {
      if ((paramDouble2 >= -180.0D) && (paramDouble2 <= 180.0D) && (!Double.isNaN(paramDouble2)))
      {
        if (paramDouble1 >= 0.0D) {
          localObject = "N";
        } else {
          localObject = "S";
        }
        setAttribute("GPSLatitudeRef", (String)localObject);
        setAttribute("GPSLatitude", convertDecimalDegree(Math.abs(paramDouble1)));
        if (paramDouble2 >= 0.0D) {
          localObject = "E";
        } else {
          localObject = "W";
        }
        setAttribute("GPSLongitudeRef", (String)localObject);
        setAttribute("GPSLongitude", convertDecimalDegree(Math.abs(paramDouble2)));
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Longitude value ");
      ((StringBuilder)localObject).append(paramDouble2);
      ((StringBuilder)localObject).append(" is not valid.");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Latitude value ");
    ((StringBuilder)localObject).append(paramDouble1);
    ((StringBuilder)localObject).append(" is not valid.");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static class ByteOrderedDataInputStream
    extends InputStream
    implements DataInput
  {
    private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    private ByteOrder mByteOrder = ByteOrder.BIG_ENDIAN;
    private DataInputStream mDataInputStream;
    final int mLength;
    int mPosition;
    
    public ByteOrderedDataInputStream(InputStream paramInputStream)
      throws IOException
    {
      this(paramInputStream, ByteOrder.BIG_ENDIAN);
    }
    
    ByteOrderedDataInputStream(InputStream paramInputStream, ByteOrder paramByteOrder)
      throws IOException
    {
      paramInputStream = new DataInputStream(paramInputStream);
      this.mDataInputStream = paramInputStream;
      int i = paramInputStream.available();
      this.mLength = i;
      this.mPosition = 0;
      this.mDataInputStream.mark(i);
      this.mByteOrder = paramByteOrder;
    }
    
    public ByteOrderedDataInputStream(byte[] paramArrayOfByte)
      throws IOException
    {
      this(new ByteArrayInputStream(paramArrayOfByte));
    }
    
    public int available()
      throws IOException
    {
      return this.mDataInputStream.available();
    }
    
    public int getLength()
    {
      return this.mLength;
    }
    
    public int peek()
    {
      return this.mPosition;
    }
    
    public int read()
      throws IOException
    {
      this.mPosition += 1;
      return this.mDataInputStream.read();
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = this.mDataInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      this.mPosition += paramInt1;
      return paramInt1;
    }
    
    public boolean readBoolean()
      throws IOException
    {
      this.mPosition += 1;
      return this.mDataInputStream.readBoolean();
    }
    
    public byte readByte()
      throws IOException
    {
      int i = this.mPosition + 1;
      this.mPosition = i;
      if (i <= this.mLength)
      {
        i = this.mDataInputStream.read();
        if (i >= 0) {
          return (byte)i;
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public char readChar()
      throws IOException
    {
      this.mPosition += 2;
      return this.mDataInputStream.readChar();
    }
    
    public double readDouble()
      throws IOException
    {
      return Double.longBitsToDouble(readLong());
    }
    
    public float readFloat()
      throws IOException
    {
      return Float.intBitsToFloat(readInt());
    }
    
    public void readFully(byte[] paramArrayOfByte)
      throws IOException
    {
      int i = this.mPosition + paramArrayOfByte.length;
      this.mPosition = i;
      if (i <= this.mLength)
      {
        if (this.mDataInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length) == paramArrayOfByte.length) {
          return;
        }
        throw new IOException("Couldn't read up to the length of buffer");
      }
      throw new EOFException();
    }
    
    public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = this.mPosition + paramInt2;
      this.mPosition = i;
      if (i <= this.mLength)
      {
        if (this.mDataInputStream.read(paramArrayOfByte, paramInt1, paramInt2) == paramInt2) {
          return;
        }
        throw new IOException("Couldn't read up to the length of buffer");
      }
      throw new EOFException();
    }
    
    public int readInt()
      throws IOException
    {
      int i = this.mPosition + 4;
      this.mPosition = i;
      if (i <= this.mLength)
      {
        int j = this.mDataInputStream.read();
        i = this.mDataInputStream.read();
        int k = this.mDataInputStream.read();
        int m = this.mDataInputStream.read();
        if ((j | i | k | m) >= 0)
        {
          Object localObject = this.mByteOrder;
          if (localObject == LITTLE_ENDIAN) {
            return (m << 24) + (k << 16) + (i << 8) + j;
          }
          if (localObject == BIG_ENDIAN) {
            return (j << 24) + (i << 16) + (k << 8) + m;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid byte order: ");
          ((StringBuilder)localObject).append(this.mByteOrder);
          throw new IOException(((StringBuilder)localObject).toString());
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public String readLine()
      throws IOException
    {
      Log.d("ExifInterface", "Currently unsupported");
      return null;
    }
    
    public long readLong()
      throws IOException
    {
      int i = this.mPosition + 8;
      this.mPosition = i;
      if (i <= this.mLength)
      {
        int j = this.mDataInputStream.read();
        int k = this.mDataInputStream.read();
        int m = this.mDataInputStream.read();
        int n = this.mDataInputStream.read();
        i = this.mDataInputStream.read();
        int i1 = this.mDataInputStream.read();
        int i2 = this.mDataInputStream.read();
        int i3 = this.mDataInputStream.read();
        if ((j | k | m | n | i | i1 | i2 | i3) >= 0)
        {
          Object localObject = this.mByteOrder;
          if (localObject == LITTLE_ENDIAN) {
            return (i3 << 56) + (i2 << 48) + (i1 << 40) + (i << 32) + (n << 24) + (m << 16) + (k << 8) + j;
          }
          if (localObject == BIG_ENDIAN) {
            return (j << 56) + (k << 48) + (m << 40) + (n << 32) + (i << 24) + (i1 << 16) + (i2 << 8) + i3;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid byte order: ");
          ((StringBuilder)localObject).append(this.mByteOrder);
          throw new IOException(((StringBuilder)localObject).toString());
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public short readShort()
      throws IOException
    {
      int i = this.mPosition + 2;
      this.mPosition = i;
      if (i <= this.mLength)
      {
        int j = this.mDataInputStream.read();
        i = this.mDataInputStream.read();
        if ((j | i) >= 0)
        {
          Object localObject = this.mByteOrder;
          if (localObject == LITTLE_ENDIAN) {
            return (short)((i << 8) + j);
          }
          if (localObject == BIG_ENDIAN) {
            return (short)((j << 8) + i);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid byte order: ");
          ((StringBuilder)localObject).append(this.mByteOrder);
          throw new IOException(((StringBuilder)localObject).toString());
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public String readUTF()
      throws IOException
    {
      this.mPosition += 2;
      return this.mDataInputStream.readUTF();
    }
    
    public int readUnsignedByte()
      throws IOException
    {
      this.mPosition += 1;
      return this.mDataInputStream.readUnsignedByte();
    }
    
    public long readUnsignedInt()
      throws IOException
    {
      return readInt() & 0xFFFFFFFF;
    }
    
    public int readUnsignedShort()
      throws IOException
    {
      int i = this.mPosition + 2;
      this.mPosition = i;
      if (i <= this.mLength)
      {
        i = this.mDataInputStream.read();
        int j = this.mDataInputStream.read();
        if ((i | j) >= 0)
        {
          Object localObject = this.mByteOrder;
          if (localObject == LITTLE_ENDIAN) {
            return (j << 8) + i;
          }
          if (localObject == BIG_ENDIAN) {
            return (i << 8) + j;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid byte order: ");
          ((StringBuilder)localObject).append(this.mByteOrder);
          throw new IOException(((StringBuilder)localObject).toString());
        }
        throw new EOFException();
      }
      throw new EOFException();
    }
    
    public void seek(long paramLong)
      throws IOException
    {
      int i = this.mPosition;
      if (i > paramLong)
      {
        this.mPosition = 0;
        this.mDataInputStream.reset();
        this.mDataInputStream.mark(this.mLength);
      }
      else
      {
        paramLong -= i;
      }
      i = (int)paramLong;
      if (skipBytes(i) == i) {
        return;
      }
      throw new IOException("Couldn't seek up to the byteCount");
    }
    
    public void setByteOrder(ByteOrder paramByteOrder)
    {
      this.mByteOrder = paramByteOrder;
    }
    
    public int skipBytes(int paramInt)
      throws IOException
    {
      int i = Math.min(paramInt, this.mLength - this.mPosition);
      paramInt = 0;
      while (paramInt < i) {
        paramInt += this.mDataInputStream.skipBytes(i - paramInt);
      }
      this.mPosition += paramInt;
      return paramInt;
    }
  }
  
  private static class ByteOrderedDataOutputStream
    extends FilterOutputStream
  {
    private ByteOrder mByteOrder;
    final OutputStream mOutputStream;
    
    public ByteOrderedDataOutputStream(OutputStream paramOutputStream, ByteOrder paramByteOrder)
    {
      super();
      this.mOutputStream = paramOutputStream;
      this.mByteOrder = paramByteOrder;
    }
    
    public void setByteOrder(ByteOrder paramByteOrder)
    {
      this.mByteOrder = paramByteOrder;
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this.mOutputStream.write(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.mOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public void writeByte(int paramInt)
      throws IOException
    {
      this.mOutputStream.write(paramInt);
    }
    
    public void writeInt(int paramInt)
      throws IOException
    {
      ByteOrder localByteOrder = this.mByteOrder;
      if (localByteOrder == ByteOrder.LITTLE_ENDIAN)
      {
        this.mOutputStream.write(paramInt >>> 0 & 0xFF);
        this.mOutputStream.write(paramInt >>> 8 & 0xFF);
        this.mOutputStream.write(paramInt >>> 16 & 0xFF);
        this.mOutputStream.write(paramInt >>> 24 & 0xFF);
      }
      else if (localByteOrder == ByteOrder.BIG_ENDIAN)
      {
        this.mOutputStream.write(paramInt >>> 24 & 0xFF);
        this.mOutputStream.write(paramInt >>> 16 & 0xFF);
        this.mOutputStream.write(paramInt >>> 8 & 0xFF);
        this.mOutputStream.write(paramInt >>> 0 & 0xFF);
      }
    }
    
    public void writeShort(short paramShort)
      throws IOException
    {
      ByteOrder localByteOrder = this.mByteOrder;
      if (localByteOrder == ByteOrder.LITTLE_ENDIAN)
      {
        this.mOutputStream.write(paramShort >>> 0 & 0xFF);
        this.mOutputStream.write(paramShort >>> 8 & 0xFF);
      }
      else if (localByteOrder == ByteOrder.BIG_ENDIAN)
      {
        this.mOutputStream.write(paramShort >>> 8 & 0xFF);
        this.mOutputStream.write(paramShort >>> 0 & 0xFF);
      }
    }
    
    public void writeUnsignedInt(long paramLong)
      throws IOException
    {
      writeInt((int)paramLong);
    }
    
    public void writeUnsignedShort(int paramInt)
      throws IOException
    {
      writeShort((short)paramInt);
    }
  }
  
  private static class ExifAttribute
  {
    public static final long BYTES_OFFSET_UNKNOWN = -1L;
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;
    
    ExifAttribute(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
    {
      this.format = paramInt1;
      this.numberOfComponents = paramInt2;
      this.bytesOffset = paramLong;
      this.bytes = paramArrayOfByte;
    }
    
    ExifAttribute(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      this(paramInt1, paramInt2, -1L, paramArrayOfByte);
    }
    
    public static ExifAttribute createByte(String paramString)
    {
      if ((paramString.length() == 1) && (paramString.charAt(0) >= '0') && (paramString.charAt(0) <= '1')) {
        return new ExifAttribute(1, 1, new byte[] { (byte)(paramString.charAt(0) - '0') });
      }
      paramString = paramString.getBytes(ExifInterface.ASCII);
      return new ExifAttribute(1, paramString.length, paramString);
    }
    
    public static ExifAttribute createDouble(double paramDouble, ByteOrder paramByteOrder)
    {
      return createDouble(new double[] { paramDouble }, paramByteOrder);
    }
    
    public static ExifAttribute createDouble(double[] paramArrayOfDouble, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * paramArrayOfDouble.length]);
      localByteBuffer.order(paramByteOrder);
      int i = paramArrayOfDouble.length;
      for (int j = 0; j < i; j++) {
        localByteBuffer.putDouble(paramArrayOfDouble[j]);
      }
      return new ExifAttribute(12, paramArrayOfDouble.length, localByteBuffer.array());
    }
    
    public static ExifAttribute createSLong(int paramInt, ByteOrder paramByteOrder)
    {
      return createSLong(new int[] { paramInt }, paramByteOrder);
    }
    
    public static ExifAttribute createSLong(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * paramArrayOfInt.length]);
      localByteBuffer.order(paramByteOrder);
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++) {
        localByteBuffer.putInt(paramArrayOfInt[j]);
      }
      return new ExifAttribute(9, paramArrayOfInt.length, localByteBuffer.array());
    }
    
    public static ExifAttribute createSRational(ExifInterface.Rational paramRational, ByteOrder paramByteOrder)
    {
      return createSRational(new ExifInterface.Rational[] { paramRational }, paramByteOrder);
    }
    
    public static ExifAttribute createSRational(ExifInterface.Rational[] paramArrayOfRational, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * paramArrayOfRational.length]);
      localByteBuffer.order(paramByteOrder);
      int i = paramArrayOfRational.length;
      for (int j = 0; j < i; j++)
      {
        paramByteOrder = paramArrayOfRational[j];
        localByteBuffer.putInt((int)paramByteOrder.numerator);
        localByteBuffer.putInt((int)paramByteOrder.denominator);
      }
      return new ExifAttribute(10, paramArrayOfRational.length, localByteBuffer.array());
    }
    
    public static ExifAttribute createString(String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('\000');
      paramString = localStringBuilder.toString().getBytes(ExifInterface.ASCII);
      return new ExifAttribute(2, paramString.length, paramString);
    }
    
    public static ExifAttribute createULong(long paramLong, ByteOrder paramByteOrder)
    {
      return createULong(new long[] { paramLong }, paramByteOrder);
    }
    
    public static ExifAttribute createULong(long[] paramArrayOfLong, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * paramArrayOfLong.length]);
      localByteBuffer.order(paramByteOrder);
      int i = paramArrayOfLong.length;
      for (int j = 0; j < i; j++) {
        localByteBuffer.putInt((int)paramArrayOfLong[j]);
      }
      return new ExifAttribute(4, paramArrayOfLong.length, localByteBuffer.array());
    }
    
    public static ExifAttribute createURational(ExifInterface.Rational paramRational, ByteOrder paramByteOrder)
    {
      return createURational(new ExifInterface.Rational[] { paramRational }, paramByteOrder);
    }
    
    public static ExifAttribute createURational(ExifInterface.Rational[] paramArrayOfRational, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * paramArrayOfRational.length]);
      localByteBuffer.order(paramByteOrder);
      int i = paramArrayOfRational.length;
      for (int j = 0; j < i; j++)
      {
        paramByteOrder = paramArrayOfRational[j];
        localByteBuffer.putInt((int)paramByteOrder.numerator);
        localByteBuffer.putInt((int)paramByteOrder.denominator);
      }
      return new ExifAttribute(5, paramArrayOfRational.length, localByteBuffer.array());
    }
    
    public static ExifAttribute createUShort(int paramInt, ByteOrder paramByteOrder)
    {
      return createUShort(new int[] { paramInt }, paramByteOrder);
    }
    
    public static ExifAttribute createUShort(int[] paramArrayOfInt, ByteOrder paramByteOrder)
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * paramArrayOfInt.length]);
      localByteBuffer.order(paramByteOrder);
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++) {
        localByteBuffer.putShort((short)paramArrayOfInt[j]);
      }
      return new ExifAttribute(3, paramArrayOfInt.length, localByteBuffer.array());
    }
    
    public double getDoubleValue(ByteOrder paramByteOrder)
    {
      paramByteOrder = getValue(paramByteOrder);
      if (paramByteOrder != null)
      {
        if ((paramByteOrder instanceof String)) {
          return Double.parseDouble((String)paramByteOrder);
        }
        if ((paramByteOrder instanceof long[]))
        {
          paramByteOrder = (long[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        if ((paramByteOrder instanceof int[]))
        {
          paramByteOrder = (int[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        if ((paramByteOrder instanceof double[]))
        {
          paramByteOrder = (double[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        if ((paramByteOrder instanceof ExifInterface.Rational[]))
        {
          paramByteOrder = (ExifInterface.Rational[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0].calculate();
          }
          throw new NumberFormatException("There are more than one component");
        }
        throw new NumberFormatException("Couldn't find a double value");
      }
      throw new NumberFormatException("NULL can't be converted to a double value");
    }
    
    public int getIntValue(ByteOrder paramByteOrder)
    {
      paramByteOrder = getValue(paramByteOrder);
      if (paramByteOrder != null)
      {
        if ((paramByteOrder instanceof String)) {
          return Integer.parseInt((String)paramByteOrder);
        }
        if ((paramByteOrder instanceof long[]))
        {
          paramByteOrder = (long[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return (int)paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        if ((paramByteOrder instanceof int[]))
        {
          paramByteOrder = (int[])paramByteOrder;
          if (paramByteOrder.length == 1) {
            return paramByteOrder[0];
          }
          throw new NumberFormatException("There are more than one component");
        }
        throw new NumberFormatException("Couldn't find a integer value");
      }
      throw new NumberFormatException("NULL can't be converted to a integer value");
    }
    
    public String getStringValue(ByteOrder paramByteOrder)
    {
      Object localObject = getValue(paramByteOrder);
      if (localObject == null) {
        return null;
      }
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      paramByteOrder = new StringBuilder();
      boolean bool = localObject instanceof long[];
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
      if (bool)
      {
        localObject = (long[])localObject;
        while (m < localObject.length)
        {
          paramByteOrder.append(localObject[m]);
          i = m + 1;
          m = i;
          if (i != localObject.length)
          {
            paramByteOrder.append(",");
            m = i;
          }
        }
        return paramByteOrder.toString();
      }
      if ((localObject instanceof int[]))
      {
        localObject = (int[])localObject;
        m = i;
        while (m < localObject.length)
        {
          paramByteOrder.append(localObject[m]);
          i = m + 1;
          m = i;
          if (i != localObject.length)
          {
            paramByteOrder.append(",");
            m = i;
          }
        }
        return paramByteOrder.toString();
      }
      if ((localObject instanceof double[]))
      {
        localObject = (double[])localObject;
        m = j;
        while (m < localObject.length)
        {
          paramByteOrder.append(localObject[m]);
          i = m + 1;
          m = i;
          if (i != localObject.length)
          {
            paramByteOrder.append(",");
            m = i;
          }
        }
        return paramByteOrder.toString();
      }
      if ((localObject instanceof ExifInterface.Rational[]))
      {
        localObject = (ExifInterface.Rational[])localObject;
        m = k;
        while (m < localObject.length)
        {
          paramByteOrder.append(localObject[m].numerator);
          paramByteOrder.append('/');
          paramByteOrder.append(localObject[m].denominator);
          i = m + 1;
          m = i;
          if (i != localObject.length)
          {
            paramByteOrder.append(",");
            m = i;
          }
        }
        return paramByteOrder.toString();
      }
      return null;
    }
    
    /* Error */
    Object getValue(ByteOrder paramByteOrder)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: new 198	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream
      //   5: astore_3
      //   6: aload_3
      //   7: aload_0
      //   8: getfield 30	androidx/exifinterface/media/ExifInterface$ExifAttribute:bytes	[B
      //   11: invokespecial 201	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:<init>	([B)V
      //   14: aload_3
      //   15: astore_2
      //   16: aload_3
      //   17: aload_1
      //   18: invokevirtual 205	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:setByteOrder	(Ljava/nio/ByteOrder;)V
      //   21: aload_3
      //   22: astore_2
      //   23: aload_0
      //   24: getfield 24	androidx/exifinterface/media/ExifInterface$ExifAttribute:format	I
      //   27: istore 4
      //   29: iconst_1
      //   30: istore 5
      //   32: iconst_0
      //   33: istore 6
      //   35: iconst_0
      //   36: istore 7
      //   38: iconst_0
      //   39: istore 8
      //   41: iconst_0
      //   42: istore 9
      //   44: iconst_0
      //   45: istore 10
      //   47: iconst_0
      //   48: istore 11
      //   50: iconst_0
      //   51: istore 12
      //   53: iconst_0
      //   54: istore 13
      //   56: iconst_0
      //   57: istore 14
      //   59: iload 4
      //   61: tableswitch	default:+63->124, 1:+746->807, 2:+561->622, 3:+502->563, 4:+443->504, 5:+372->433, 6:+746->807, 7:+561->622, 8:+313->374, 9:+254->315, 10:+181->242, 11:+121->182, 12:+66->127
      //   124: goto +792 -> 916
      //   127: aload_3
      //   128: astore_2
      //   129: aload_0
      //   130: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   133: newarray <illegal type>
      //   135: astore_1
      //   136: aload_3
      //   137: astore_2
      //   138: iload 14
      //   140: aload_0
      //   141: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   144: if_icmpge +19 -> 163
      //   147: aload_3
      //   148: astore_2
      //   149: aload_1
      //   150: iload 14
      //   152: aload_3
      //   153: invokevirtual 208	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readDouble	()D
      //   156: dastore
      //   157: iinc 14 1
      //   160: goto -24 -> 136
      //   163: aload_3
      //   164: invokevirtual 213	java/io/InputStream:close	()V
      //   167: goto +13 -> 180
      //   170: astore_2
      //   171: ldc -41
      //   173: ldc -39
      //   175: aload_2
      //   176: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   179: pop
      //   180: aload_1
      //   181: areturn
      //   182: aload_3
      //   183: astore_2
      //   184: aload_0
      //   185: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   188: newarray <illegal type>
      //   190: astore_1
      //   191: iload 6
      //   193: istore 14
      //   195: aload_3
      //   196: astore_2
      //   197: iload 14
      //   199: aload_0
      //   200: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   203: if_icmpge +20 -> 223
      //   206: aload_3
      //   207: astore_2
      //   208: aload_1
      //   209: iload 14
      //   211: aload_3
      //   212: invokevirtual 227	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readFloat	()F
      //   215: f2d
      //   216: dastore
      //   217: iinc 14 1
      //   220: goto -25 -> 195
      //   223: aload_3
      //   224: invokevirtual 213	java/io/InputStream:close	()V
      //   227: goto +13 -> 240
      //   230: astore_2
      //   231: ldc -41
      //   233: ldc -39
      //   235: aload_2
      //   236: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   239: pop
      //   240: aload_1
      //   241: areturn
      //   242: aload_3
      //   243: astore_2
      //   244: aload_0
      //   245: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   248: anewarray 96	androidx/exifinterface/media/ExifInterface$Rational
      //   251: astore_1
      //   252: iload 7
      //   254: istore 14
      //   256: aload_3
      //   257: astore_2
      //   258: iload 14
      //   260: aload_0
      //   261: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   264: if_icmpge +32 -> 296
      //   267: aload_3
      //   268: astore_2
      //   269: aload_1
      //   270: iload 14
      //   272: new 96	androidx/exifinterface/media/ExifInterface$Rational
      //   275: dup
      //   276: aload_3
      //   277: invokevirtual 230	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readInt	()I
      //   280: i2l
      //   281: aload_3
      //   282: invokevirtual 230	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readInt	()I
      //   285: i2l
      //   286: invokespecial 233	androidx/exifinterface/media/ExifInterface$Rational:<init>	(JJ)V
      //   289: aastore
      //   290: iinc 14 1
      //   293: goto -37 -> 256
      //   296: aload_3
      //   297: invokevirtual 213	java/io/InputStream:close	()V
      //   300: goto +13 -> 313
      //   303: astore_2
      //   304: ldc -41
      //   306: ldc -39
      //   308: aload_2
      //   309: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   312: pop
      //   313: aload_1
      //   314: areturn
      //   315: aload_3
      //   316: astore_2
      //   317: aload_0
      //   318: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   321: newarray <illegal type>
      //   323: astore_1
      //   324: iload 8
      //   326: istore 14
      //   328: aload_3
      //   329: astore_2
      //   330: iload 14
      //   332: aload_0
      //   333: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   336: if_icmpge +19 -> 355
      //   339: aload_3
      //   340: astore_2
      //   341: aload_1
      //   342: iload 14
      //   344: aload_3
      //   345: invokevirtual 230	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readInt	()I
      //   348: iastore
      //   349: iinc 14 1
      //   352: goto -24 -> 328
      //   355: aload_3
      //   356: invokevirtual 213	java/io/InputStream:close	()V
      //   359: goto +13 -> 372
      //   362: astore_2
      //   363: ldc -41
      //   365: ldc -39
      //   367: aload_2
      //   368: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   371: pop
      //   372: aload_1
      //   373: areturn
      //   374: aload_3
      //   375: astore_2
      //   376: aload_0
      //   377: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   380: newarray <illegal type>
      //   382: astore_1
      //   383: iload 9
      //   385: istore 14
      //   387: aload_3
      //   388: astore_2
      //   389: iload 14
      //   391: aload_0
      //   392: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   395: if_icmpge +19 -> 414
      //   398: aload_3
      //   399: astore_2
      //   400: aload_1
      //   401: iload 14
      //   403: aload_3
      //   404: invokevirtual 237	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readShort	()S
      //   407: iastore
      //   408: iinc 14 1
      //   411: goto -24 -> 387
      //   414: aload_3
      //   415: invokevirtual 213	java/io/InputStream:close	()V
      //   418: goto +13 -> 431
      //   421: astore_2
      //   422: ldc -41
      //   424: ldc -39
      //   426: aload_2
      //   427: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   430: pop
      //   431: aload_1
      //   432: areturn
      //   433: aload_3
      //   434: astore_2
      //   435: aload_0
      //   436: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   439: anewarray 96	androidx/exifinterface/media/ExifInterface$Rational
      //   442: astore_1
      //   443: iload 10
      //   445: istore 14
      //   447: aload_3
      //   448: astore_2
      //   449: iload 14
      //   451: aload_0
      //   452: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   455: if_icmpge +30 -> 485
      //   458: aload_3
      //   459: astore_2
      //   460: aload_1
      //   461: iload 14
      //   463: new 96	androidx/exifinterface/media/ExifInterface$Rational
      //   466: dup
      //   467: aload_3
      //   468: invokevirtual 241	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readUnsignedInt	()J
      //   471: aload_3
      //   472: invokevirtual 241	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readUnsignedInt	()J
      //   475: invokespecial 233	androidx/exifinterface/media/ExifInterface$Rational:<init>	(JJ)V
      //   478: aastore
      //   479: iinc 14 1
      //   482: goto -35 -> 447
      //   485: aload_3
      //   486: invokevirtual 213	java/io/InputStream:close	()V
      //   489: goto +13 -> 502
      //   492: astore_2
      //   493: ldc -41
      //   495: ldc -39
      //   497: aload_2
      //   498: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   501: pop
      //   502: aload_1
      //   503: areturn
      //   504: aload_3
      //   505: astore_2
      //   506: aload_0
      //   507: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   510: newarray <illegal type>
      //   512: astore_1
      //   513: iload 11
      //   515: istore 14
      //   517: aload_3
      //   518: astore_2
      //   519: iload 14
      //   521: aload_0
      //   522: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   525: if_icmpge +19 -> 544
      //   528: aload_3
      //   529: astore_2
      //   530: aload_1
      //   531: iload 14
      //   533: aload_3
      //   534: invokevirtual 241	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readUnsignedInt	()J
      //   537: lastore
      //   538: iinc 14 1
      //   541: goto -24 -> 517
      //   544: aload_3
      //   545: invokevirtual 213	java/io/InputStream:close	()V
      //   548: goto +13 -> 561
      //   551: astore_2
      //   552: ldc -41
      //   554: ldc -39
      //   556: aload_2
      //   557: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   560: pop
      //   561: aload_1
      //   562: areturn
      //   563: aload_3
      //   564: astore_2
      //   565: aload_0
      //   566: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   569: newarray <illegal type>
      //   571: astore_1
      //   572: iload 12
      //   574: istore 14
      //   576: aload_3
      //   577: astore_2
      //   578: iload 14
      //   580: aload_0
      //   581: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   584: if_icmpge +19 -> 603
      //   587: aload_3
      //   588: astore_2
      //   589: aload_1
      //   590: iload 14
      //   592: aload_3
      //   593: invokevirtual 244	androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream:readUnsignedShort	()I
      //   596: iastore
      //   597: iinc 14 1
      //   600: goto -24 -> 576
      //   603: aload_3
      //   604: invokevirtual 213	java/io/InputStream:close	()V
      //   607: goto +13 -> 620
      //   610: astore_2
      //   611: ldc -41
      //   613: ldc -39
      //   615: aload_2
      //   616: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   619: pop
      //   620: aload_1
      //   621: areturn
      //   622: iload 13
      //   624: istore 14
      //   626: aload_3
      //   627: astore_2
      //   628: aload_0
      //   629: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   632: getstatic 247	androidx/exifinterface/media/ExifInterface:EXIF_ASCII_PREFIX	[B
      //   635: arraylength
      //   636: if_icmplt +68 -> 704
      //   639: iconst_0
      //   640: istore 14
      //   642: aload_3
      //   643: astore_2
      //   644: getstatic 247	androidx/exifinterface/media/ExifInterface:EXIF_ASCII_PREFIX	[B
      //   647: astore_1
      //   648: iload 5
      //   650: istore 6
      //   652: aload_3
      //   653: astore_2
      //   654: iload 14
      //   656: aload_1
      //   657: arraylength
      //   658: if_icmpge +31 -> 689
      //   661: aload_3
      //   662: astore_2
      //   663: aload_0
      //   664: getfield 30	androidx/exifinterface/media/ExifInterface$ExifAttribute:bytes	[B
      //   667: iload 14
      //   669: baload
      //   670: aload_1
      //   671: iload 14
      //   673: baload
      //   674: if_icmpeq +9 -> 683
      //   677: iconst_0
      //   678: istore 6
      //   680: goto +9 -> 689
      //   683: iinc 14 1
      //   686: goto -44 -> 642
      //   689: iload 13
      //   691: istore 14
      //   693: iload 6
      //   695: ifeq +9 -> 704
      //   698: aload_3
      //   699: astore_2
      //   700: aload_1
      //   701: arraylength
      //   702: istore 14
      //   704: aload_3
      //   705: astore_2
      //   706: new 108	java/lang/StringBuilder
      //   709: astore_1
      //   710: aload_3
      //   711: astore_2
      //   712: aload_1
      //   713: invokespecial 109	java/lang/StringBuilder:<init>	()V
      //   716: aload_3
      //   717: astore_2
      //   718: iload 14
      //   720: aload_0
      //   721: getfield 26	androidx/exifinterface/media/ExifInterface$ExifAttribute:numberOfComponents	I
      //   724: if_icmpge +57 -> 781
      //   727: aload_3
      //   728: astore_2
      //   729: aload_0
      //   730: getfield 30	androidx/exifinterface/media/ExifInterface$ExifAttribute:bytes	[B
      //   733: iload 14
      //   735: baload
      //   736: istore 6
      //   738: iload 6
      //   740: ifne +6 -> 746
      //   743: goto +38 -> 781
      //   746: iload 6
      //   748: bipush 32
      //   750: if_icmplt +16 -> 766
      //   753: aload_3
      //   754: astore_2
      //   755: aload_1
      //   756: iload 6
      //   758: i2c
      //   759: invokevirtual 116	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   762: pop
      //   763: goto +12 -> 775
      //   766: aload_3
      //   767: astore_2
      //   768: aload_1
      //   769: bipush 63
      //   771: invokevirtual 116	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   774: pop
      //   775: iinc 14 1
      //   778: goto -62 -> 716
      //   781: aload_3
      //   782: astore_2
      //   783: aload_1
      //   784: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   787: astore_1
      //   788: aload_3
      //   789: invokevirtual 213	java/io/InputStream:close	()V
      //   792: goto +13 -> 805
      //   795: astore_2
      //   796: ldc -41
      //   798: ldc -39
      //   800: aload_2
      //   801: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   804: pop
      //   805: aload_1
      //   806: areturn
      //   807: aload_3
      //   808: astore_2
      //   809: aload_0
      //   810: getfield 30	androidx/exifinterface/media/ExifInterface$ExifAttribute:bytes	[B
      //   813: astore_1
      //   814: aload_3
      //   815: astore_2
      //   816: aload_1
      //   817: arraylength
      //   818: iconst_1
      //   819: if_icmpne +61 -> 880
      //   822: aload_1
      //   823: iconst_0
      //   824: baload
      //   825: iflt +55 -> 880
      //   828: aload_1
      //   829: iconst_0
      //   830: baload
      //   831: iconst_1
      //   832: if_icmpgt +48 -> 880
      //   835: aload_3
      //   836: astore_2
      //   837: new 38	java/lang/String
      //   840: dup
      //   841: iconst_1
      //   842: newarray <illegal type>
      //   844: dup
      //   845: iconst_0
      //   846: aload_0
      //   847: getfield 30	androidx/exifinterface/media/ExifInterface$ExifAttribute:bytes	[B
      //   850: iconst_0
      //   851: baload
      //   852: bipush 48
      //   854: iadd
      //   855: i2c
      //   856: castore
      //   857: invokespecial 250	java/lang/String:<init>	([C)V
      //   860: astore_1
      //   861: aload_3
      //   862: invokevirtual 213	java/io/InputStream:close	()V
      //   865: goto +13 -> 878
      //   868: astore_2
      //   869: ldc -41
      //   871: ldc -39
      //   873: aload_2
      //   874: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   877: pop
      //   878: aload_1
      //   879: areturn
      //   880: aload_3
      //   881: astore_2
      //   882: new 38	java/lang/String
      //   885: dup
      //   886: aload_0
      //   887: getfield 30	androidx/exifinterface/media/ExifInterface$ExifAttribute:bytes	[B
      //   890: getstatic 52	androidx/exifinterface/media/ExifInterface:ASCII	Ljava/nio/charset/Charset;
      //   893: invokespecial 253	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
      //   896: astore_1
      //   897: aload_3
      //   898: invokevirtual 213	java/io/InputStream:close	()V
      //   901: goto +13 -> 914
      //   904: astore_2
      //   905: ldc -41
      //   907: ldc -39
      //   909: aload_2
      //   910: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   913: pop
      //   914: aload_1
      //   915: areturn
      //   916: aload_3
      //   917: invokevirtual 213	java/io/InputStream:close	()V
      //   920: goto +13 -> 933
      //   923: astore_1
      //   924: ldc -41
      //   926: ldc -39
      //   928: aload_1
      //   929: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   932: pop
      //   933: aconst_null
      //   934: areturn
      //   935: astore_2
      //   936: aload_3
      //   937: astore_1
      //   938: aload_2
      //   939: astore_3
      //   940: goto +10 -> 950
      //   943: astore_1
      //   944: goto +41 -> 985
      //   947: astore_3
      //   948: aconst_null
      //   949: astore_1
      //   950: aload_1
      //   951: astore_2
      //   952: ldc -41
      //   954: ldc -1
      //   956: aload_3
      //   957: invokestatic 258	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   960: pop
      //   961: aload_1
      //   962: ifnull +20 -> 982
      //   965: aload_1
      //   966: invokevirtual 213	java/io/InputStream:close	()V
      //   969: goto +13 -> 982
      //   972: astore_1
      //   973: ldc -41
      //   975: ldc -39
      //   977: aload_1
      //   978: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   981: pop
      //   982: aconst_null
      //   983: areturn
      //   984: astore_1
      //   985: aload_2
      //   986: ifnull +20 -> 1006
      //   989: aload_2
      //   990: invokevirtual 213	java/io/InputStream:close	()V
      //   993: goto +13 -> 1006
      //   996: astore_2
      //   997: ldc -41
      //   999: ldc -39
      //   1001: aload_2
      //   1002: invokestatic 223	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   1005: pop
      //   1006: aload_1
      //   1007: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1008	0	this	ExifAttribute
      //   0	1008	1	paramByteOrder	ByteOrder
      //   1	148	2	localObject1	Object
      //   170	6	2	localIOException1	IOException
      //   183	25	2	localObject2	Object
      //   230	6	2	localIOException2	IOException
      //   243	26	2	localObject3	Object
      //   303	6	2	localIOException3	IOException
      //   316	25	2	localObject4	Object
      //   362	6	2	localIOException4	IOException
      //   375	25	2	localObject5	Object
      //   421	6	2	localIOException5	IOException
      //   434	26	2	localObject6	Object
      //   492	6	2	localIOException6	IOException
      //   505	25	2	localObject7	Object
      //   551	6	2	localIOException7	IOException
      //   564	25	2	localObject8	Object
      //   610	6	2	localIOException8	IOException
      //   627	156	2	localObject9	Object
      //   795	6	2	localIOException9	IOException
      //   808	29	2	localObject10	Object
      //   868	6	2	localIOException10	IOException
      //   881	1	2	localObject11	Object
      //   904	6	2	localIOException11	IOException
      //   935	4	2	localIOException12	IOException
      //   951	39	2	localByteOrder	ByteOrder
      //   996	6	2	localIOException13	IOException
      //   5	935	3	localObject12	Object
      //   947	10	3	localIOException14	IOException
      //   27	33	4	i	int
      //   30	619	5	j	int
      //   33	724	6	k	int
      //   36	217	7	m	int
      //   39	286	8	n	int
      //   42	342	9	i1	int
      //   45	399	10	i2	int
      //   48	466	11	i3	int
      //   51	522	12	i4	int
      //   54	636	13	i5	int
      //   57	719	14	i6	int
      // Exception table:
      //   from	to	target	type
      //   163	167	170	java/io/IOException
      //   223	227	230	java/io/IOException
      //   296	300	303	java/io/IOException
      //   355	359	362	java/io/IOException
      //   414	418	421	java/io/IOException
      //   485	489	492	java/io/IOException
      //   544	548	551	java/io/IOException
      //   603	607	610	java/io/IOException
      //   788	792	795	java/io/IOException
      //   861	865	868	java/io/IOException
      //   897	901	904	java/io/IOException
      //   916	920	923	java/io/IOException
      //   16	21	935	java/io/IOException
      //   23	29	935	java/io/IOException
      //   129	136	935	java/io/IOException
      //   138	147	935	java/io/IOException
      //   149	157	935	java/io/IOException
      //   184	191	935	java/io/IOException
      //   197	206	935	java/io/IOException
      //   208	217	935	java/io/IOException
      //   244	252	935	java/io/IOException
      //   258	267	935	java/io/IOException
      //   269	290	935	java/io/IOException
      //   317	324	935	java/io/IOException
      //   330	339	935	java/io/IOException
      //   341	349	935	java/io/IOException
      //   376	383	935	java/io/IOException
      //   389	398	935	java/io/IOException
      //   400	408	935	java/io/IOException
      //   435	443	935	java/io/IOException
      //   449	458	935	java/io/IOException
      //   460	479	935	java/io/IOException
      //   506	513	935	java/io/IOException
      //   519	528	935	java/io/IOException
      //   530	538	935	java/io/IOException
      //   565	572	935	java/io/IOException
      //   578	587	935	java/io/IOException
      //   589	597	935	java/io/IOException
      //   628	639	935	java/io/IOException
      //   644	648	935	java/io/IOException
      //   654	661	935	java/io/IOException
      //   663	677	935	java/io/IOException
      //   700	704	935	java/io/IOException
      //   706	710	935	java/io/IOException
      //   712	716	935	java/io/IOException
      //   718	727	935	java/io/IOException
      //   729	738	935	java/io/IOException
      //   755	763	935	java/io/IOException
      //   768	775	935	java/io/IOException
      //   783	788	935	java/io/IOException
      //   809	814	935	java/io/IOException
      //   816	822	935	java/io/IOException
      //   837	861	935	java/io/IOException
      //   882	897	935	java/io/IOException
      //   2	14	943	finally
      //   2	14	947	java/io/IOException
      //   965	969	972	java/io/IOException
      //   16	21	984	finally
      //   23	29	984	finally
      //   129	136	984	finally
      //   138	147	984	finally
      //   149	157	984	finally
      //   184	191	984	finally
      //   197	206	984	finally
      //   208	217	984	finally
      //   244	252	984	finally
      //   258	267	984	finally
      //   269	290	984	finally
      //   317	324	984	finally
      //   330	339	984	finally
      //   341	349	984	finally
      //   376	383	984	finally
      //   389	398	984	finally
      //   400	408	984	finally
      //   435	443	984	finally
      //   449	458	984	finally
      //   460	479	984	finally
      //   506	513	984	finally
      //   519	528	984	finally
      //   530	538	984	finally
      //   565	572	984	finally
      //   578	587	984	finally
      //   589	597	984	finally
      //   628	639	984	finally
      //   644	648	984	finally
      //   654	661	984	finally
      //   663	677	984	finally
      //   700	704	984	finally
      //   706	710	984	finally
      //   712	716	984	finally
      //   718	727	984	finally
      //   729	738	984	finally
      //   755	763	984	finally
      //   768	775	984	finally
      //   783	788	984	finally
      //   809	814	984	finally
      //   816	822	984	finally
      //   837	861	984	finally
      //   882	897	984	finally
      //   952	961	984	finally
      //   989	993	996	java/io/IOException
    }
    
    public int size()
    {
      return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
      localStringBuilder.append(", data length:");
      localStringBuilder.append(this.bytes.length);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static @interface ExifStreamType {}
  
  static class ExifTag
  {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;
    
    ExifTag(String paramString, int paramInt1, int paramInt2)
    {
      this.name = paramString;
      this.number = paramInt1;
      this.primaryFormat = paramInt2;
      this.secondaryFormat = -1;
    }
    
    ExifTag(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      this.name = paramString;
      this.number = paramInt1;
      this.primaryFormat = paramInt2;
      this.secondaryFormat = paramInt3;
    }
    
    boolean isFormatCompatible(int paramInt)
    {
      int i = this.primaryFormat;
      if ((i != 7) && (paramInt != 7) && (i != paramInt))
      {
        int j = this.secondaryFormat;
        if (j != paramInt)
        {
          if (((i == 4) || (j == 4)) && (paramInt == 3)) {
            return true;
          }
          if (((i == 9) || (j == 9)) && (paramInt == 8)) {
            return true;
          }
          return ((i == 12) || (j == 12)) && (paramInt == 11);
        }
      }
      return true;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static @interface IfdType {}
  
  private static class Rational
  {
    public final long denominator;
    public final long numerator;
    
    Rational(double paramDouble)
    {
      this((paramDouble * 10000.0D), 10000L);
    }
    
    Rational(long paramLong1, long paramLong2)
    {
      if (paramLong2 == 0L)
      {
        this.numerator = 0L;
        this.denominator = 1L;
        return;
      }
      this.numerator = paramLong1;
      this.denominator = paramLong2;
    }
    
    public double calculate()
    {
      return this.numerator / this.denominator;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.numerator);
      localStringBuilder.append("/");
      localStringBuilder.append(this.denominator);
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\exifinterface\media\ExifInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */