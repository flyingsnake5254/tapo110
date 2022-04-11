package com.tplink.iot;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.databinding.ActivityAdvancedSettingNewIpcBindingImpl;
import com.tplink.iot.databinding.ActivityAiDetectionBindingImpl;
import com.tplink.iot.databinding.ActivityAlarmSettingBindingImpl;
import com.tplink.iot.databinding.ActivityAlarmSoundBindingImpl;
import com.tplink.iot.databinding.ActivityAlarmTypeBindingImpl;
import com.tplink.iot.databinding.ActivityAreaIntrusionRegionSettingBindingImpl;
import com.tplink.iot.databinding.ActivityAreaIntrusionRegionSettingBindingLandImpl;
import com.tplink.iot.databinding.ActivityAutoRebootBindingImpl;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBindingImpl;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBottomBindingImpl;
import com.tplink.iot.databinding.ActivityBaseIotDeviceInfoBindingImpl;
import com.tplink.iot.databinding.ActivityBaseIotDeviceSettingsBindingImpl;
import com.tplink.iot.databinding.ActivityCameraCloudConnectBindingImpl;
import com.tplink.iot.databinding.ActivityCameraPreviewBindingImpl;
import com.tplink.iot.databinding.ActivityCameraPreviewCloudVideoServerBindingImpl;
import com.tplink.iot.databinding.ActivityCameraPreviewModePartBindingImpl;
import com.tplink.iot.databinding.ActivityCameraV2OnboardingBindingImpl;
import com.tplink.iot.databinding.ActivityColorPaintingMakeBindingImpl;
import com.tplink.iot.databinding.ActivityCustomizedEffectsMakeBindingImpl;
import com.tplink.iot.databinding.ActivityDailySummaryBindingImpl;
import com.tplink.iot.databinding.ActivityDebugFwUpdateBindingImpl;
import com.tplink.iot.databinding.ActivityDetectSettingBindingImpl;
import com.tplink.iot.databinding.ActivityDeviceDetailInfoNewIpcBindingImpl;
import com.tplink.iot.databinding.ActivityDeviceNameEditorBindingImpl;
import com.tplink.iot.databinding.ActivityDeviceSettingNewIpcBindingImpl;
import com.tplink.iot.databinding.ActivityDiagnoseStatusBindingImpl;
import com.tplink.iot.databinding.ActivityDiscoveredDevicesBindingImpl;
import com.tplink.iot.databinding.ActivityDiscoveryDevicePairingFailedBindingImpl;
import com.tplink.iot.databinding.ActivityEditEffectsNameBindingImpl;
import com.tplink.iot.databinding.ActivityFeaturedActionHostBindingImpl;
import com.tplink.iot.databinding.ActivityGuardModeBindingImpl;
import com.tplink.iot.databinding.ActivityHubAlarmLogBindingImpl;
import com.tplink.iot.databinding.ActivityIntrusionScheduleSettingBindingImpl;
import com.tplink.iot.databinding.ActivityIotDeviceInfoBindingImpl;
import com.tplink.iot.databinding.ActivityLdcSettingBindingImpl;
import com.tplink.iot.databinding.ActivityLightAdjustBindingImpl;
import com.tplink.iot.databinding.ActivityLightStripConnectPartsGuideBindingImpl;
import com.tplink.iot.databinding.ActivityLightStripEffectsBindingImpl;
import com.tplink.iot.databinding.ActivityLightStripPlacementGuideBindingImpl;
import com.tplink.iot.databinding.ActivityLightStripSetDefaultStateBindingImpl;
import com.tplink.iot.databinding.ActivityLightStripSetLengthBindingImpl;
import com.tplink.iot.databinding.ActivityLightStripSoftApResetHintBindingImpl;
import com.tplink.iot.databinding.ActivityLightStripUserGuideBindingImpl;
import com.tplink.iot.databinding.ActivityLightingEffectDebugBindingImpl;
import com.tplink.iot.databinding.ActivityLineCrossingRegionSettingBindingImpl;
import com.tplink.iot.databinding.ActivityLineCrossingRegionSettingBindingLandImpl;
import com.tplink.iot.databinding.ActivityLineCrossingScheduleSettingBindingImpl;
import com.tplink.iot.databinding.ActivityMemoriesFilterBindingImpl;
import com.tplink.iot.databinding.ActivityMemoriesImageBindingImpl;
import com.tplink.iot.databinding.ActivityMemoriesVideoBindingImpl;
import com.tplink.iot.databinding.ActivityModeDetectSettingBindingImpl;
import com.tplink.iot.databinding.ActivityMotionDetectionBindingImpl;
import com.tplink.iot.databinding.ActivityMotionRegionSettingBindingImpl;
import com.tplink.iot.databinding.ActivityMotionRegionSettingBindingLandImpl;
import com.tplink.iot.databinding.ActivityMsgPushBindingImpl;
import com.tplink.iot.databinding.ActivityOsdNewIpcBindingImpl;
import com.tplink.iot.databinding.ActivityPlaybackNewIpcBindingImpl;
import com.tplink.iot.databinding.ActivityPlugElectricityStatisticBindingImpl;
import com.tplink.iot.databinding.ActivityPlugPowerStatisticBindingImpl;
import com.tplink.iot.databinding.ActivityPrivacyMaskBindingImpl;
import com.tplink.iot.databinding.ActivityPrivacyMaskZonesBindingImpl;
import com.tplink.iot.databinding.ActivityPrivacyMaskZonesBindingLandImpl;
import com.tplink.iot.databinding.ActivityPrivacyModeBindingImpl;
import com.tplink.iot.databinding.ActivityQsPlugIconSelectIconBindingImpl;
import com.tplink.iot.databinding.ActivityRecordAudioSettingBindingImpl;
import com.tplink.iot.databinding.ActivityScheduleEditBindingImpl;
import com.tplink.iot.databinding.ActivityScheduleSettingBindingImpl;
import com.tplink.iot.databinding.ActivitySelectDeviceBindingImpl;
import com.tplink.iot.databinding.ActivitySensorDetailBindingImpl;
import com.tplink.iot.databinding.ActivitySensorDetailBottomBindingImpl;
import com.tplink.iot.databinding.ActivitySensorDetailContentBindingImpl;
import com.tplink.iot.databinding.ActivitySensorSetReportIntervalBindingImpl;
import com.tplink.iot.databinding.ActivitySensorSetSensitivityBindingImpl;
import com.tplink.iot.databinding.ActivitySensorSettingsBindingImpl;
import com.tplink.iot.databinding.ActivitySetLocationBindingImpl;
import com.tplink.iot.databinding.ActivitySoftApCommonGuideBindingImpl;
import com.tplink.iot.databinding.ActivitySoftApResetHintBindingImpl;
import com.tplink.iot.databinding.ActivityStoreManageBindingImpl;
import com.tplink.iot.databinding.ActivitySubGOnBoardingBindingImpl;
import com.tplink.iot.databinding.ActivitySummaryClipListBindingImpl;
import com.tplink.iot.databinding.ActivitySummaryClipListBindingLandImpl;
import com.tplink.iot.databinding.ActivitySummaryHistoryBindingImpl;
import com.tplink.iot.databinding.ActivitySummaryPlayBindingImpl;
import com.tplink.iot.databinding.ActivitySummaryPlayBindingLandImpl;
import com.tplink.iot.databinding.ActivitySwitchSetDelayOffBindingImpl;
import com.tplink.iot.databinding.ActivitySwitchSetDoubleClickBindingImpl;
import com.tplink.iot.databinding.ActivityTapoDebugBindingImpl;
import com.tplink.iot.databinding.ActivityTargetTrackBindingImpl;
import com.tplink.iot.databinding.ActivityTimeZoneNewIpcBindingImpl;
import com.tplink.iot.databinding.ActivityTrvEarlyStartBindingImpl;
import com.tplink.iot.databinding.ActivityTrvSetChildProtectionBindingImpl;
import com.tplink.iot.databinding.ActivityTrvSetFrostProtectionBindingImpl;
import com.tplink.iot.databinding.ActivityTrvSetProgressCalibrationBindingImpl;
import com.tplink.iot.databinding.ActivityTrvSetRemoveScaleBindingImpl;
import com.tplink.iot.databinding.ActivityTrvSetShutdownModeBindingImpl;
import com.tplink.iot.databinding.ActivityTrvSetTemperatureRangeBindingImpl;
import com.tplink.iot.databinding.ActivityTrvSetTemperatureUnitBindingImpl;
import com.tplink.iot.databinding.ActivityTrvSetWindowOpenBindingImpl;
import com.tplink.iot.databinding.ActivityTrvTemperatureRecordBindingImpl;
import com.tplink.iot.databinding.ActivityUpnpSettingBindingImpl;
import com.tplink.iot.databinding.ActivityVideoPlayNewIpcBindingImpl;
import com.tplink.iot.databinding.ActivityVideoQualityBindingImpl;
import com.tplink.iot.databinding.ActivityWhiteLampConfigBindingImpl;
import com.tplink.iot.databinding.DialogFormatProcessBindingImpl;
import com.tplink.iot.databinding.DialogHomeAwayModeLoadingBindingImpl;
import com.tplink.iot.databinding.DialogIntRangePickerBindingImpl;
import com.tplink.iot.databinding.DialogMarkPositionConfirmBindingImpl;
import com.tplink.iot.databinding.DialogMemoryBottomOperationBindingImpl;
import com.tplink.iot.databinding.DialogMemorySlideOperationBindingImpl;
import com.tplink.iot.databinding.DialogMicrophoneControlBindingImpl;
import com.tplink.iot.databinding.DialogMultiLiveDragBindingImpl;
import com.tplink.iot.databinding.DialogMusicRhythmColorPickerSheetBindingImpl;
import com.tplink.iot.databinding.DialogMusicRhythmFlowingBeamModeSettingSheetBindingImpl;
import com.tplink.iot.databinding.DialogMusicRhythmLightStrengthSheetBindingImpl;
import com.tplink.iot.databinding.DialogMusicRhythmPowerModeSettingSheetBindingImpl;
import com.tplink.iot.databinding.DialogSelectDeviceBindingImpl;
import com.tplink.iot.databinding.DialogVolumeControlBindingImpl;
import com.tplink.iot.databinding.DialogVolumeControlFullScreenBindingImpl;
import com.tplink.iot.databinding.ExoPlaybackControlViewBindingImpl;
import com.tplink.iot.databinding.FragmentAbstractFeaturedActionBindingImpl;
import com.tplink.iot.databinding.FragmentAbstractFeaturedActionChooseBindingImpl;
import com.tplink.iot.databinding.FragmentBottomScrollPickerBindingImpl;
import com.tplink.iot.databinding.FragmentButtonFeaturedActionsBindingImpl;
import com.tplink.iot.databinding.FragmentButtonFeaturedActionsGuideBindingImpl;
import com.tplink.iot.databinding.FragmentButtonReplaceBatteryBindingImpl;
import com.tplink.iot.databinding.FragmentCameraAutoUpdateHintBindingImpl;
import com.tplink.iot.databinding.FragmentCameraConnectRouterBindingImpl;
import com.tplink.iot.databinding.FragmentCameraConnectTypeBindingImpl;
import com.tplink.iot.databinding.FragmentCameraControlBindingImpl;
import com.tplink.iot.databinding.FragmentCameraTriggerBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2BeforeInstallBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2CannotFindWifiBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2CheckStatusBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2CompleteBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2ConfiguredBeforeBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2ConnectApBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2ConnectToPairBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2ConnectingBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2IdentifyBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2InputPwdBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2InstallGuideBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2InstallGuideItemLayoutBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2InstallGuideWaterproofLayoutBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2InstallHelpfulItemsBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2InstallPreviewBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2InstructionBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2IntroduceTapoCareBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2IntroduceVideoplayItemBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2LocationPermissionBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2LocationSetBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2ManualInputPwdBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2NameBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2NotFoundBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2PairingFailedBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2PermissionBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2RescanWifiBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2ResetBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2RoomCustomBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2RoomSelectBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2SaveSettingBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2SdHintBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2SearchAfterSetupBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2SsidListBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2TroubleShootingBindingImpl;
import com.tplink.iot.databinding.FragmentCameraV2WifiListBindingImpl;
import com.tplink.iot.databinding.FragmentCameraWiredCompleteBindingImpl;
import com.tplink.iot.databinding.FragmentCameraWiredConnectApBindingImpl;
import com.tplink.iot.databinding.FragmentCameraWiredConnectingBindingImpl;
import com.tplink.iot.databinding.FragmentCameraWiredSetWirelessFailedBindingImpl;
import com.tplink.iot.databinding.FragmentCloudPasswordCheckBindingImpl;
import com.tplink.iot.databinding.FragmentCloudTerraceControlBindingImpl;
import com.tplink.iot.databinding.FragmentCloudTerracePresetBindingImpl;
import com.tplink.iot.databinding.FragmentColorLightSettingBindingImpl;
import com.tplink.iot.databinding.FragmentColorPickerDialogBindingImpl;
import com.tplink.iot.databinding.FragmentColorTemperatureSettingBindingImpl;
import com.tplink.iot.databinding.FragmentContactSensorReplaceBatteryBindingImpl;
import com.tplink.iot.databinding.FragmentDevicePasswordCheckBindingImpl;
import com.tplink.iot.databinding.FragmentDevicePasswordSettingBindingImpl;
import com.tplink.iot.databinding.FragmentDeviceTriggerContainerBindingImpl;
import com.tplink.iot.databinding.FragmentDeviceTriggerSingleChoiceBindingImpl;
import com.tplink.iot.databinding.FragmentDialogGetLostBindingImpl;
import com.tplink.iot.databinding.FragmentFirmwareCheckBindingImpl;
import com.tplink.iot.databinding.FragmentFirmwareUpdateNewIpcBindingImpl;
import com.tplink.iot.databinding.FragmentGuardModeConfigBindingImpl;
import com.tplink.iot.databinding.FragmentGuardModeRecyclerviewListBindingImpl;
import com.tplink.iot.databinding.FragmentGuardModeSetAlarmTimeBindingImpl;
import com.tplink.iot.databinding.FragmentLightStripLightEffectsBindingImpl;
import com.tplink.iot.databinding.FragmentLightStripLightSettingsBindingImpl;
import com.tplink.iot.databinding.FragmentLightStripLightSettingsDialogBindingImpl;
import com.tplink.iot.databinding.FragmentLightStripScheduleBindingImpl;
import com.tplink.iot.databinding.FragmentMotionSensorReplaceBatteryBindingImpl;
import com.tplink.iot.databinding.FragmentMultiLiveVideoBindingImpl;
import com.tplink.iot.databinding.FragmentOperationShellBindingImpl;
import com.tplink.iot.databinding.FragmentPhotosBindingImpl;
import com.tplink.iot.databinding.FragmentPlayBackControlBindingImpl;
import com.tplink.iot.databinding.FragmentPlayBackVideoBindingImpl;
import com.tplink.iot.databinding.FragmentPlugEnergyMonitorBindingImpl;
import com.tplink.iot.databinding.FragmentRateUsDialogBindingImpl;
import com.tplink.iot.databinding.FragmentRecordTypeDialogBindingImpl;
import com.tplink.iot.databinding.FragmentSubGCompleteBindingImpl;
import com.tplink.iot.databinding.FragmentSubGHubEmptyBindingImpl;
import com.tplink.iot.databinding.FragmentSubGHubFirmwareUpdateBindingImpl;
import com.tplink.iot.databinding.FragmentSubGHubListBindingImpl;
import com.tplink.iot.databinding.FragmentSubGNoFoundBindingImpl;
import com.tplink.iot.databinding.FragmentSubGSaveSettingBindingImpl;
import com.tplink.iot.databinding.FragmentSubGSearchingDeviceBindingImpl;
import com.tplink.iot.databinding.FragmentSubGSetupAvatarBindingImpl;
import com.tplink.iot.databinding.FragmentSubGSetupLocationCustomBindingImpl;
import com.tplink.iot.databinding.FragmentSubGSetupLocationSelectBindingImpl;
import com.tplink.iot.databinding.FragmentSubGSetupNameBindingImpl;
import com.tplink.iot.databinding.FragmentSubgEnablePairingModeBindingImpl;
import com.tplink.iot.databinding.FragmentSubgLedNotBlinkingHelpBindingImpl;
import com.tplink.iot.databinding.FragmentSubgPowerUpDeviceBindingImpl;
import com.tplink.iot.databinding.FragmentSubgRemoveCoverBindingImpl;
import com.tplink.iot.databinding.FragmentSubgSwitchHowToInstallBindingImpl;
import com.tplink.iot.databinding.FragmentSwitchQuicksetupGuideBindingImpl;
import com.tplink.iot.databinding.FragmentSwitchReplaceBatteryBindingImpl;
import com.tplink.iot.databinding.FragmentTalkBindingImpl;
import com.tplink.iot.databinding.FragmentTaskDeviceControlContainerBindingImpl;
import com.tplink.iot.databinding.FragmentTaskHubControlBindingImpl;
import com.tplink.iot.databinding.FragmentThermostatControlBindingImpl;
import com.tplink.iot.databinding.FragmentThermostatTriggerBindingImpl;
import com.tplink.iot.databinding.FragmentTrvErrorTroubleShootingBindingImpl;
import com.tplink.iot.databinding.FragmentTrvReplaceBatteryBindingImpl;
import com.tplink.iot.databinding.FragmentVoiceCallBindingImpl;
import com.tplink.iot.databinding.ItemCameraCloudTerracePositionInfoBindingImpl;
import com.tplink.iot.databinding.ItemCameraLocationBindingImpl;
import com.tplink.iot.databinding.ItemCameraPreviewBindingImpl;
import com.tplink.iot.databinding.ItemCameraPreviewSortBindingImpl;
import com.tplink.iot.databinding.ItemCameraSelectDeviceBindingImpl;
import com.tplink.iot.databinding.ItemCameraSelectDeviceFullScreenBindingImpl;
import com.tplink.iot.databinding.ItemCameraSsidLayoutBindingImpl;
import com.tplink.iot.databinding.ItemCameraWifiOtherItemBindingImpl;
import com.tplink.iot.databinding.ItemCloudTerraceMarkPositionBindingImpl;
import com.tplink.iot.databinding.ItemFeatureGridBindingImpl;
import com.tplink.iot.databinding.ItemFeaturedActionChooseBindingImpl;
import com.tplink.iot.databinding.ItemHomeAwayModeFailBindingImpl;
import com.tplink.iot.databinding.ItemHubSubDeviceCardBindingImpl;
import com.tplink.iot.databinding.ItemModeAddCameraBindingImpl;
import com.tplink.iot.databinding.ItemModeSettingBindingImpl;
import com.tplink.iot.databinding.ItemMultiLiveBindingImpl;
import com.tplink.iot.databinding.ItemRegionListContentBindingImpl;
import com.tplink.iot.databinding.ItemRegionListTitleBindingImpl;
import com.tplink.iot.databinding.ItemSummaryClipTitleBindingImpl;
import com.tplink.iot.databinding.ItemSummaryClipVideoBindingImpl;
import com.tplink.iot.databinding.ItemSummaryHistoryBindingImpl;
import com.tplink.iot.databinding.ItemSummaryHomeBindingImpl;
import com.tplink.iot.databinding.LayoutCameraMenuButtonBindingImpl;
import com.tplink.iot.databinding.LayoutCameraMenuButtonDayNightModeBindingImpl;
import com.tplink.iot.databinding.LayoutCameraMenuButtonWhiteLampBindingImpl;
import com.tplink.iot.databinding.LayoutCameraMenuDefinitionBindingImpl;
import com.tplink.iot.databinding.LayoutCameraMenuInfraredBindingImpl;
import com.tplink.iot.databinding.LayoutCameraMenuSettingsBindingImpl;
import com.tplink.iot.databinding.LayoutDailySummarySettingsBindingImpl;
import com.tplink.iot.databinding.LayoutDayNightModeBindingImpl;
import com.tplink.iot.databinding.LayoutFullScreenBottomBarBindingImpl;
import com.tplink.iot.databinding.LayoutFullScreenControlBindingImpl;
import com.tplink.iot.databinding.LayoutFullScreenQualityBindingImpl;
import com.tplink.iot.databinding.LayoutHubGuardModeGuideBindingImpl;
import com.tplink.iot.databinding.LayoutLightStripControllerBindingImpl;
import com.tplink.iot.databinding.LayoutLightStripDetailBgBindingImpl;
import com.tplink.iot.databinding.LayoutLightStripDetailBottomExtBindingImpl;
import com.tplink.iot.databinding.LayoutLightStripDetailContentExtBindingImpl;
import com.tplink.iot.databinding.LayoutLightStripGuidePageBindingImpl;
import com.tplink.iot.databinding.LayoutLightStripSettingsFeatureExtBindingImpl;
import com.tplink.iot.databinding.LayoutLightStripSettingsOtherExtBindingImpl;
import com.tplink.iot.databinding.LayoutLightingEffectPresetBindingImpl;
import com.tplink.iot.databinding.LayoutMultiLiveToolbarBottomBindingImpl;
import com.tplink.iot.databinding.LayoutPalybackFullBottomBindingImpl;
import com.tplink.iot.databinding.LayoutPlayBackFullscreenCalendarBindingImpl;
import com.tplink.iot.databinding.LayoutPlayBackFullscreenFilterBindingImpl;
import com.tplink.iot.databinding.LayoutPlaybackToolbarBottomBindingImpl;
import com.tplink.iot.databinding.LayoutPlaybackToolbarPopupBindingImpl;
import com.tplink.iot.databinding.LayoutPlaybackToolbarTopBindingImpl;
import com.tplink.iot.databinding.LayoutSelectReportIntervalBindingImpl;
import com.tplink.iot.databinding.LayoutSummaryTimeAxisBindingImpl;
import com.tplink.iot.databinding.LayoutSwitchDetailBottomExtBindingImpl;
import com.tplink.iot.databinding.LayoutSwitchDetailContentExtBindingImpl;
import com.tplink.iot.databinding.LayoutSwitchSettingsFeatureExtBindingImpl;
import com.tplink.iot.databinding.LayoutTemperatureSeekbarBindingImpl;
import com.tplink.iot.databinding.LayoutTrvDetailBottomExtBindingImpl;
import com.tplink.iot.databinding.LayoutTrvDetailContentExtBindingImpl;
import com.tplink.iot.databinding.LayoutTrvOneSelectSettingsBindingImpl;
import com.tplink.iot.databinding.LayoutTrvSettingsFeatureExtBindingImpl;
import com.tplink.iot.databinding.LayoutVariousImageViewBindingImpl;
import com.tplink.iot.databinding.LayoutVoiceTalkPanelBindingImpl;
import com.tplink.iot.databinding.MenuSaveBindingImpl;
import com.tplink.iot.databinding.ModeSettingFooterViewBindingImpl;
import com.tplink.iot.databinding.PlayBackBottomBarBindingImpl;
import com.tplink.iot.databinding.PlayBackDateSelectorBindingImpl;
import com.tplink.iot.databinding.PlayBackRulerLayoutBindingImpl;
import com.tplink.iot.databinding.PlayBackTimeRulerBindingImpl;
import com.tplink.iot.databinding.PlayBackTopBarBindingImpl;
import com.tplink.iot.databinding.ViewCloudTerraceControlSensitivityPanelBindingImpl;
import com.tplink.iot.databinding.ViewFoundedDeviceItemBindingImpl;
import com.tplink.iot.databinding.ViewMultiFeaturesGridBindingImpl;
import com.tplink.iot.databinding.ViewPreviewDisplayBindingImpl;
import com.tplink.iot.databinding.ViewVideoSurfaceLayoutBindingImpl;
import com.tplink.iot.databinding.WidgetTipsBarBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl
  extends DataBinderMapper
{
  private static final SparseIntArray a;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray(293);
    a = localSparseIntArray;
    localSparseIntArray.put(2131558437, 1);
    localSparseIntArray.put(2131558438, 2);
    localSparseIntArray.put(2131558439, 3);
    localSparseIntArray.put(2131558440, 4);
    localSparseIntArray.put(2131558441, 5);
    localSparseIntArray.put(2131558446, 6);
    localSparseIntArray.put(2131558448, 7);
    localSparseIntArray.put(2131558452, 8);
    localSparseIntArray.put(2131558453, 9);
    localSparseIntArray.put(2131558454, 10);
    localSparseIntArray.put(2131558455, 11);
    localSparseIntArray.put(2131558470, 12);
    localSparseIntArray.put(2131558473, 13);
    localSparseIntArray.put(2131558474, 14);
    localSparseIntArray.put(2131558475, 15);
    localSparseIntArray.put(2131558477, 16);
    localSparseIntArray.put(2131558488, 17);
    localSparseIntArray.put(2131558492, 18);
    localSparseIntArray.put(2131558493, 19);
    localSparseIntArray.put(2131558494, 20);
    localSparseIntArray.put(2131558495, 21);
    localSparseIntArray.put(2131558496, 22);
    localSparseIntArray.put(2131558499, 23);
    localSparseIntArray.put(2131558501, 24);
    localSparseIntArray.put(2131558510, 25);
    localSparseIntArray.put(2131558511, 26);
    localSparseIntArray.put(2131558512, 27);
    localSparseIntArray.put(2131558513, 28);
    localSparseIntArray.put(2131558515, 29);
    localSparseIntArray.put(2131558535, 30);
    localSparseIntArray.put(2131558539, 31);
    localSparseIntArray.put(2131558545, 32);
    localSparseIntArray.put(2131558546, 33);
    localSparseIntArray.put(2131558552, 34);
    localSparseIntArray.put(2131558559, 35);
    localSparseIntArray.put(2131558562, 36);
    localSparseIntArray.put(2131558563, 37);
    localSparseIntArray.put(2131558564, 38);
    localSparseIntArray.put(2131558565, 39);
    localSparseIntArray.put(2131558566, 40);
    localSparseIntArray.put(2131558567, 41);
    localSparseIntArray.put(2131558568, 42);
    localSparseIntArray.put(2131558569, 43);
    localSparseIntArray.put(2131558571, 44);
    localSparseIntArray.put(2131558572, 45);
    localSparseIntArray.put(2131558579, 46);
    localSparseIntArray.put(2131558580, 47);
    localSparseIntArray.put(2131558581, 48);
    localSparseIntArray.put(2131558582, 49);
    localSparseIntArray.put(2131558584, 50);
    localSparseIntArray.put(2131558585, 51);
    localSparseIntArray.put(2131558586, 52);
    localSparseIntArray.put(2131558595, 53);
    localSparseIntArray.put(2131558598, 54);
    localSparseIntArray.put(2131558606, 55);
    localSparseIntArray.put(2131558608, 56);
    localSparseIntArray.put(2131558615, 57);
    localSparseIntArray.put(2131558616, 58);
    localSparseIntArray.put(2131558617, 59);
    localSparseIntArray.put(2131558626, 60);
    localSparseIntArray.put(2131558632, 61);
    localSparseIntArray.put(2131558640, 62);
    localSparseIntArray.put(2131558643, 63);
    localSparseIntArray.put(2131558647, 64);
    localSparseIntArray.put(2131558648, 65);
    localSparseIntArray.put(2131558649, 66);
    localSparseIntArray.put(2131558650, 67);
    localSparseIntArray.put(2131558652, 68);
    localSparseIntArray.put(2131558653, 69);
    localSparseIntArray.put(2131558654, 70);
    localSparseIntArray.put(2131558655, 71);
    localSparseIntArray.put(2131558664, 72);
    localSparseIntArray.put(2131558665, 73);
    localSparseIntArray.put(2131558681, 74);
    localSparseIntArray.put(2131558682, 75);
    localSparseIntArray.put(2131558683, 76);
    localSparseIntArray.put(2131558684, 77);
    localSparseIntArray.put(2131558685, 78);
    localSparseIntArray.put(2131558686, 79);
    localSparseIntArray.put(2131558687, 80);
    localSparseIntArray.put(2131558688, 81);
    localSparseIntArray.put(2131558689, 82);
    localSparseIntArray.put(2131558690, 83);
    localSparseIntArray.put(2131558693, 84);
    localSparseIntArray.put(2131558694, 85);
    localSparseIntArray.put(2131558695, 86);
    localSparseIntArray.put(2131558696, 87);
    localSparseIntArray.put(2131558697, 88);
    localSparseIntArray.put(2131558698, 89);
    localSparseIntArray.put(2131558699, 90);
    localSparseIntArray.put(2131558700, 91);
    localSparseIntArray.put(2131558701, 92);
    localSparseIntArray.put(2131558702, 93);
    localSparseIntArray.put(2131558704, 94);
    localSparseIntArray.put(2131558706, 95);
    localSparseIntArray.put(2131558707, 96);
    localSparseIntArray.put(2131558711, 97);
    localSparseIntArray.put(2131558788, 98);
    localSparseIntArray.put(2131558793, 99);
    localSparseIntArray.put(2131558798, 100);
    localSparseIntArray.put(2131558804, 101);
    localSparseIntArray.put(2131558806, 102);
    localSparseIntArray.put(2131558808, 103);
    localSparseIntArray.put(2131558809, 104);
    localSparseIntArray.put(2131558810, 105);
    localSparseIntArray.put(2131558813, 106);
    localSparseIntArray.put(2131558814, 107);
    localSparseIntArray.put(2131558815, 108);
    localSparseIntArray.put(2131558816, 109);
    localSparseIntArray.put(2131558821, 110);
    localSparseIntArray.put(2131558830, 111);
    localSparseIntArray.put(2131558831, 112);
    localSparseIntArray.put(2131558837, 113);
    localSparseIntArray.put(2131558853, 114);
    localSparseIntArray.put(2131558854, 115);
    localSparseIntArray.put(2131558857, 116);
    localSparseIntArray.put(2131558858, 117);
    localSparseIntArray.put(2131558859, 118);
    localSparseIntArray.put(2131558860, 119);
    localSparseIntArray.put(2131558861, 120);
    localSparseIntArray.put(2131558862, 121);
    localSparseIntArray.put(2131558863, 122);
    localSparseIntArray.put(2131558864, 123);
    localSparseIntArray.put(2131558865, 124);
    localSparseIntArray.put(2131558866, 125);
    localSparseIntArray.put(2131558867, 126);
    localSparseIntArray.put(2131558868, 127);
    localSparseIntArray.put(2131558869, 128);
    localSparseIntArray.put(2131558870, 129);
    localSparseIntArray.put(2131558871, 130);
    localSparseIntArray.put(2131558872, 131);
    localSparseIntArray.put(2131558873, 132);
    localSparseIntArray.put(2131558874, 133);
    localSparseIntArray.put(2131558875, 134);
    localSparseIntArray.put(2131558876, 135);
    localSparseIntArray.put(2131558877, 136);
    localSparseIntArray.put(2131558878, 137);
    localSparseIntArray.put(2131558879, 138);
    localSparseIntArray.put(2131558880, 139);
    localSparseIntArray.put(2131558881, 140);
    localSparseIntArray.put(2131558882, 141);
    localSparseIntArray.put(2131558883, 142);
    localSparseIntArray.put(2131558884, 143);
    localSparseIntArray.put(2131558885, 144);
    localSparseIntArray.put(2131558886, 145);
    localSparseIntArray.put(2131558887, 146);
    localSparseIntArray.put(2131558888, 147);
    localSparseIntArray.put(2131558891, 148);
    localSparseIntArray.put(2131558892, 149);
    localSparseIntArray.put(2131558893, 150);
    localSparseIntArray.put(2131558894, 151);
    localSparseIntArray.put(2131558895, 152);
    localSparseIntArray.put(2131558896, 153);
    localSparseIntArray.put(2131558897, 154);
    localSparseIntArray.put(2131558898, 155);
    localSparseIntArray.put(2131558899, 156);
    localSparseIntArray.put(2131558900, 157);
    localSparseIntArray.put(2131558901, 158);
    localSparseIntArray.put(2131558902, 159);
    localSparseIntArray.put(2131558903, 160);
    localSparseIntArray.put(2131558904, 161);
    localSparseIntArray.put(2131558905, 162);
    localSparseIntArray.put(2131558906, 163);
    localSparseIntArray.put(2131558908, 164);
    localSparseIntArray.put(2131558910, 165);
    localSparseIntArray.put(2131558911, 166);
    localSparseIntArray.put(2131558912, 167);
    localSparseIntArray.put(2131558913, 168);
    localSparseIntArray.put(2131558914, 169);
    localSparseIntArray.put(2131558915, 170);
    localSparseIntArray.put(2131558916, 171);
    localSparseIntArray.put(2131558917, 172);
    localSparseIntArray.put(2131558919, 173);
    localSparseIntArray.put(2131558920, 174);
    localSparseIntArray.put(2131558921, 175);
    localSparseIntArray.put(2131558922, 176);
    localSparseIntArray.put(2131558923, 177);
    localSparseIntArray.put(2131558926, 178);
    localSparseIntArray.put(2131558927, 179);
    localSparseIntArray.put(2131558928, 180);
    localSparseIntArray.put(2131558931, 181);
    localSparseIntArray.put(2131558932, 182);
    localSparseIntArray.put(2131558933, 183);
    localSparseIntArray.put(2131558934, 184);
    localSparseIntArray.put(2131558937, 185);
    localSparseIntArray.put(2131558938, 186);
    localSparseIntArray.put(2131558940, 187);
    localSparseIntArray.put(2131558941, 188);
    localSparseIntArray.put(2131558942, 189);
    localSparseIntArray.put(2131558943, 190);
    localSparseIntArray.put(2131558944, 191);
    localSparseIntArray.put(2131558948, 192);
    localSparseIntArray.put(2131558949, 193);
    localSparseIntArray.put(2131558963, 194);
    localSparseIntArray.put(2131558964, 195);
    localSparseIntArray.put(2131558965, 196);
    localSparseIntArray.put(2131558966, 197);
    localSparseIntArray.put(2131558967, 198);
    localSparseIntArray.put(2131558968, 199);
    localSparseIntArray.put(2131558969, 200);
    localSparseIntArray.put(2131558970, 201);
    localSparseIntArray.put(2131558971, 202);
    localSparseIntArray.put(2131558972, 203);
    localSparseIntArray.put(2131558973, 204);
    localSparseIntArray.put(2131558974, 205);
    localSparseIntArray.put(2131558975, 206);
    localSparseIntArray.put(2131558976, 207);
    localSparseIntArray.put(2131558977, 208);
    localSparseIntArray.put(2131558978, 209);
    localSparseIntArray.put(2131558979, 210);
    localSparseIntArray.put(2131558980, 211);
    localSparseIntArray.put(2131558981, 212);
    localSparseIntArray.put(2131558982, 213);
    localSparseIntArray.put(2131558983, 214);
    localSparseIntArray.put(2131558984, 215);
    localSparseIntArray.put(2131558985, 216);
    localSparseIntArray.put(2131558986, 217);
    localSparseIntArray.put(2131558987, 218);
    localSparseIntArray.put(2131558989, 219);
    localSparseIntArray.put(2131559001, 220);
    localSparseIntArray.put(2131559002, 221);
    localSparseIntArray.put(2131559003, 222);
    localSparseIntArray.put(2131559004, 223);
    localSparseIntArray.put(2131559005, 224);
    localSparseIntArray.put(2131559006, 225);
    localSparseIntArray.put(2131559007, 226);
    localSparseIntArray.put(2131559008, 227);
    localSparseIntArray.put(2131559009, 228);
    localSparseIntArray.put(2131559030, 229);
    localSparseIntArray.put(2131559031, 230);
    localSparseIntArray.put(2131559039, 231);
    localSparseIntArray.put(2131559045, 232);
    localSparseIntArray.put(2131559056, 233);
    localSparseIntArray.put(2131559057, 234);
    localSparseIntArray.put(2131559059, 235);
    localSparseIntArray.put(2131559073, 236);
    localSparseIntArray.put(2131559074, 237);
    localSparseIntArray.put(2131559088, 238);
    localSparseIntArray.put(2131559089, 239);
    localSparseIntArray.put(2131559090, 240);
    localSparseIntArray.put(2131559091, 241);
    localSparseIntArray.put(2131559103, 242);
    localSparseIntArray.put(2131559104, 243);
    localSparseIntArray.put(2131559105, 244);
    localSparseIntArray.put(2131559106, 245);
    localSparseIntArray.put(2131559107, 246);
    localSparseIntArray.put(2131559108, 247);
    localSparseIntArray.put(2131559119, 248);
    localSparseIntArray.put(2131559120, 249);
    localSparseIntArray.put(2131559154, 250);
    localSparseIntArray.put(2131559155, 251);
    localSparseIntArray.put(2131559156, 252);
    localSparseIntArray.put(2131559163, 253);
    localSparseIntArray.put(2131559170, 254);
    localSparseIntArray.put(2131559171, 255);
    localSparseIntArray.put(2131559172, 256);
    localSparseIntArray.put(2131559173, 257);
    localSparseIntArray.put(2131559174, 258);
    localSparseIntArray.put(2131559175, 259);
    localSparseIntArray.put(2131559176, 260);
    localSparseIntArray.put(2131559177, 261);
    localSparseIntArray.put(2131559181, 262);
    localSparseIntArray.put(2131559190, 263);
    localSparseIntArray.put(2131559193, 264);
    localSparseIntArray.put(2131559194, 265);
    localSparseIntArray.put(2131559198, 266);
    localSparseIntArray.put(2131559199, 267);
    localSparseIntArray.put(2131559200, 268);
    localSparseIntArray.put(2131559214, 269);
    localSparseIntArray.put(2131559233, 270);
    localSparseIntArray.put(2131559235, 271);
    localSparseIntArray.put(2131559236, 272);
    localSparseIntArray.put(2131559237, 273);
    localSparseIntArray.put(2131559238, 274);
    localSparseIntArray.put(2131559239, 275);
    localSparseIntArray.put(2131559240, 276);
    localSparseIntArray.put(2131559241, 277);
    localSparseIntArray.put(2131559242, 278);
    localSparseIntArray.put(2131559243, 279);
    localSparseIntArray.put(2131559244, 280);
    localSparseIntArray.put(2131559272, 281);
    localSparseIntArray.put(2131559273, 282);
    localSparseIntArray.put(2131559327, 283);
    localSparseIntArray.put(2131559328, 284);
    localSparseIntArray.put(2131559329, 285);
    localSparseIntArray.put(2131559330, 286);
    localSparseIntArray.put(2131559331, 287);
    localSparseIntArray.put(2131559405, 288);
    localSparseIntArray.put(2131559420, 289);
    localSparseIntArray.put(2131559432, 290);
    localSparseIntArray.put(2131559436, 291);
    localSparseIntArray.put(2131559451, 292);
    localSparseIntArray.put(2131559457, 293);
  }
  
  private final ViewDataBinding a(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 50: 
      if ("layout/activity_motion_detection_0".equals(paramObject)) {
        return new ActivityMotionDetectionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_motion_detection is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 49: 
      if ("layout/activity_mode_detect_setting_0".equals(paramObject)) {
        return new ActivityModeDetectSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_mode_detect_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 48: 
      if ("layout/activity_memories_video_0".equals(paramObject)) {
        return new ActivityMemoriesVideoBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_memories_video is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 47: 
      if ("layout/activity_memories_image_0".equals(paramObject)) {
        return new ActivityMemoriesImageBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_memories_image is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 46: 
      if ("layout/activity_memories_filter_0".equals(paramObject)) {
        return new ActivityMemoriesFilterBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_memories_filter is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 45: 
      if ("layout/activity_line_crossing_schedule_setting_0".equals(paramObject)) {
        return new ActivityLineCrossingScheduleSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_line_crossing_schedule_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 44: 
      if ("layout/activity_line_crossing_region_setting_0".equals(paramObject)) {
        return new ActivityLineCrossingRegionSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      if ("layout-land/activity_line_crossing_region_setting_0".equals(paramObject)) {
        return new ActivityLineCrossingRegionSettingBindingLandImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_line_crossing_region_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 43: 
      if ("layout/activity_lighting_effect_debug_0".equals(paramObject)) {
        return new ActivityLightingEffectDebugBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_lighting_effect_debug is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 42: 
      if ("layout/activity_light_strip_user_guide_0".equals(paramObject)) {
        return new ActivityLightStripUserGuideBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_light_strip_user_guide is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 41: 
      if ("layout/activity_light_strip_soft_ap_reset_hint_0".equals(paramObject)) {
        return new ActivityLightStripSoftApResetHintBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_light_strip_soft_ap_reset_hint is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 40: 
      if ("layout/activity_light_strip_set_length_0".equals(paramObject)) {
        return new ActivityLightStripSetLengthBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_light_strip_set_length is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 39: 
      if ("layout/activity_light_strip_set_default_state_0".equals(paramObject)) {
        return new ActivityLightStripSetDefaultStateBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_light_strip_set_default_state is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 38: 
      if ("layout/activity_light_strip_placement_guide_0".equals(paramObject)) {
        return new ActivityLightStripPlacementGuideBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_light_strip_placement_guide is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 37: 
      if ("layout/activity_light_strip_effects_0".equals(paramObject)) {
        return new ActivityLightStripEffectsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_light_strip_effects is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 36: 
      if ("layout/activity_light_strip_connect_parts_guide_0".equals(paramObject)) {
        return new ActivityLightStripConnectPartsGuideBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_light_strip_connect_parts_guide is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 35: 
      if ("layout/activity_light_adjust_0".equals(paramObject)) {
        return new ActivityLightAdjustBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_light_adjust is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 34: 
      if ("layout/activity_ldc_setting_0".equals(paramObject)) {
        return new ActivityLdcSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_ldc_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 33: 
      if ("layout/activity_iot_device_info_0".equals(paramObject)) {
        return new ActivityIotDeviceInfoBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_iot_device_info is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 32: 
      if ("layout/activity_intrusion_schedule_setting_0".equals(paramObject)) {
        return new ActivityIntrusionScheduleSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_intrusion_schedule_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 31: 
      if ("layout/activity_hub_alarm_log_0".equals(paramObject)) {
        return new ActivityHubAlarmLogBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_hub_alarm_log is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 30: 
      if ("layout/activity_guard_mode_0".equals(paramObject)) {
        return new ActivityGuardModeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_guard_mode is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 29: 
      if ("layout/activity_featured_action_host_0".equals(paramObject)) {
        return new ActivityFeaturedActionHostBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_featured_action_host is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 28: 
      if ("layout/activity_edit_effects_name_0".equals(paramObject)) {
        return new ActivityEditEffectsNameBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_edit_effects_name is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 27: 
      if ("layout/activity_discovery_device_pairing_failed_0".equals(paramObject)) {
        return new ActivityDiscoveryDevicePairingFailedBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_discovery_device_pairing_failed is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 26: 
      if ("layout/activity_discovered_devices_0".equals(paramObject)) {
        return new ActivityDiscoveredDevicesBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_discovered_devices is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 25: 
      if ("layout/activity_diagnose_status_0".equals(paramObject)) {
        return new ActivityDiagnoseStatusBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_diagnose_status is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 24: 
      if ("layout/activity_device_setting_new_ipc_0".equals(paramObject)) {
        return new ActivityDeviceSettingNewIpcBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_device_setting_new_ipc is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 23: 
      if ("layout/activity_device_name_editor_0".equals(paramObject)) {
        return new ActivityDeviceNameEditorBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_device_name_editor is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 22: 
      if ("layout/activity_device_detail_info_new_ipc_0".equals(paramObject)) {
        return new ActivityDeviceDetailInfoNewIpcBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_device_detail_info_new_ipc is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 21: 
      if ("layout/activity_detect_setting_0".equals(paramObject)) {
        return new ActivityDetectSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_detect_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 20: 
      if ("layout/activity_debug_fw_update_0".equals(paramObject)) {
        return new ActivityDebugFwUpdateBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_debug_fw_update is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 19: 
      if ("layout/activity_daily_summary_0".equals(paramObject)) {
        return new ActivityDailySummaryBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_daily_summary is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 18: 
      if ("layout/activity_customized_effects_make_0".equals(paramObject)) {
        return new ActivityCustomizedEffectsMakeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_customized_effects_make is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 17: 
      if ("layout/activity_color_painting_make_0".equals(paramObject)) {
        return new ActivityColorPaintingMakeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_color_painting_make is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 16: 
      if ("layout/activity_camera_v2_onboarding_0".equals(paramObject)) {
        return new ActivityCameraV2OnboardingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_camera_v2_onboarding is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 15: 
      if ("layout/activity_camera_preview_mode_part_0".equals(paramObject)) {
        return new ActivityCameraPreviewModePartBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_camera_preview_mode_part is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 14: 
      if ("layout/activity_camera_preview_cloud_video_server_0".equals(paramObject)) {
        return new ActivityCameraPreviewCloudVideoServerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_camera_preview_cloud_video_server is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 13: 
      if ("layout/activity_camera_preview_0".equals(paramObject)) {
        return new ActivityCameraPreviewBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_camera_preview is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 12: 
      if ("layout/activity_camera_cloud_connect_0".equals(paramObject)) {
        return new ActivityCameraCloudConnectBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_camera_cloud_connect is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 11: 
      if ("layout/activity_base_iot_device_settings_0".equals(paramObject)) {
        return new ActivityBaseIotDeviceSettingsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_base_iot_device_settings is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 10: 
      if ("layout/activity_base_iot_device_info_0".equals(paramObject)) {
        return new ActivityBaseIotDeviceInfoBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_base_iot_device_info is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 9: 
      if ("layout/activity_base_iot_device_detail_bottom_0".equals(paramObject)) {
        return new ActivityBaseIotDeviceDetailBottomBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_base_iot_device_detail_bottom is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 8: 
      if ("layout/activity_base_iot_device_detail_0".equals(paramObject)) {
        return new ActivityBaseIotDeviceDetailBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_base_iot_device_detail is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 7: 
      if ("layout/activity_auto_reboot_0".equals(paramObject)) {
        return new ActivityAutoRebootBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_auto_reboot is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 6: 
      if ("layout-land/activity_area_intrusion_region_setting_0".equals(paramObject)) {
        return new ActivityAreaIntrusionRegionSettingBindingLandImpl(paramDataBindingComponent, paramView);
      }
      if ("layout/activity_area_intrusion_region_setting_0".equals(paramObject)) {
        return new ActivityAreaIntrusionRegionSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_area_intrusion_region_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 5: 
      if ("layout/activity_alarm_type_0".equals(paramObject)) {
        return new ActivityAlarmTypeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_alarm_type is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 4: 
      if ("layout/activity_alarm_sound_0".equals(paramObject)) {
        return new ActivityAlarmSoundBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_alarm_sound is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 3: 
      if ("layout/activity_alarm_setting_0".equals(paramObject)) {
        return new ActivityAlarmSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_alarm_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 2: 
      if ("layout/activity_ai_detection_0".equals(paramObject)) {
        return new ActivityAiDetectionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_ai_detection is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    }
    if ("layout/activity_advanced_setting_new_ipc_0".equals(paramObject)) {
      return new ActivityAdvancedSettingNewIpcBindingImpl(paramDataBindingComponent, paramView);
    }
    paramDataBindingComponent = new StringBuilder();
    paramDataBindingComponent.append("The tag for activity_advanced_setting_new_ipc is invalid. Received: ");
    paramDataBindingComponent.append(paramObject);
    throw new IllegalArgumentException(paramDataBindingComponent.toString());
  }
  
  private final ViewDataBinding b(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      if ("layout/dialog_int_range_picker_0".equals(paramObject)) {
        return new DialogIntRangePickerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_int_range_picker is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 99: 
      if ("layout/dialog_home_away_mode_loading_0".equals(paramObject)) {
        return new DialogHomeAwayModeLoadingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_home_away_mode_loading is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 98: 
      if ("layout/dialog_format_process_0".equals(paramObject)) {
        return new DialogFormatProcessBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_format_process is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 97: 
      if ("layout/activity_white_lamp_config_0".equals(paramObject)) {
        return new ActivityWhiteLampConfigBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_white_lamp_config is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 96: 
      if ("layout/activity_video_quality_0".equals(paramObject)) {
        return new ActivityVideoQualityBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_video_quality is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 95: 
      if ("layout/activity_video_play_new_ipc_0".equals(paramObject)) {
        return new ActivityVideoPlayNewIpcBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_video_play_new_ipc is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 94: 
      if ("layout/activity_upnp_setting_0".equals(paramObject)) {
        return new ActivityUpnpSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_upnp_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 93: 
      if ("layout/activity_trv_temperature_record_0".equals(paramObject)) {
        return new ActivityTrvTemperatureRecordBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_temperature_record is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 92: 
      if ("layout/activity_trv_set_window_open_0".equals(paramObject)) {
        return new ActivityTrvSetWindowOpenBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_set_window_open is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 91: 
      if ("layout/activity_trv_set_temperature_unit_0".equals(paramObject)) {
        return new ActivityTrvSetTemperatureUnitBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_set_temperature_unit is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 90: 
      if ("layout/activity_trv_set_temperature_range_0".equals(paramObject)) {
        return new ActivityTrvSetTemperatureRangeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_set_temperature_range is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 89: 
      if ("layout/activity_trv_set_shutdown_mode_0".equals(paramObject)) {
        return new ActivityTrvSetShutdownModeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_set_shutdown_mode is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 88: 
      if ("layout/activity_trv_set_remove_scale_0".equals(paramObject)) {
        return new ActivityTrvSetRemoveScaleBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_set_remove_scale is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 87: 
      if ("layout/activity_trv_set_progress_calibration_0".equals(paramObject)) {
        return new ActivityTrvSetProgressCalibrationBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_set_progress_calibration is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 86: 
      if ("layout/activity_trv_set_frost_protection_0".equals(paramObject)) {
        return new ActivityTrvSetFrostProtectionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_set_frost_protection is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 85: 
      if ("layout/activity_trv_set_child_protection_0".equals(paramObject)) {
        return new ActivityTrvSetChildProtectionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_set_child_protection is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 84: 
      if ("layout/activity_trv_early_start_0".equals(paramObject)) {
        return new ActivityTrvEarlyStartBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_trv_early_start is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 83: 
      if ("layout/activity_time_zone_new_ipc_0".equals(paramObject)) {
        return new ActivityTimeZoneNewIpcBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_time_zone_new_ipc is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 82: 
      if ("layout/activity_target_track_0".equals(paramObject)) {
        return new ActivityTargetTrackBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_target_track is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 81: 
      if ("layout/activity_tapo_debug_0".equals(paramObject)) {
        return new ActivityTapoDebugBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_tapo_debug is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 80: 
      if ("layout/activity_switch_set_double_click_0".equals(paramObject)) {
        return new ActivitySwitchSetDoubleClickBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_switch_set_double_click is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 79: 
      if ("layout/activity_switch_set_delay_off_0".equals(paramObject)) {
        return new ActivitySwitchSetDelayOffBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_switch_set_delay_off is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 78: 
      if ("layout-land/activity_summary_play_0".equals(paramObject)) {
        return new ActivitySummaryPlayBindingLandImpl(paramDataBindingComponent, paramView);
      }
      if ("layout/activity_summary_play_0".equals(paramObject)) {
        return new ActivitySummaryPlayBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_summary_play is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 77: 
      if ("layout/activity_summary_history_0".equals(paramObject)) {
        return new ActivitySummaryHistoryBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_summary_history is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 76: 
      if ("layout-land/activity_summary_clip_list_0".equals(paramObject)) {
        return new ActivitySummaryClipListBindingLandImpl(paramDataBindingComponent, paramView);
      }
      if ("layout/activity_summary_clip_list_0".equals(paramObject)) {
        return new ActivitySummaryClipListBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_summary_clip_list is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 75: 
      if ("layout/activity_sub_g_on_boarding_0".equals(paramObject)) {
        return new ActivitySubGOnBoardingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_sub_g_on_boarding is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 74: 
      if ("layout/activity_store_manage_0".equals(paramObject)) {
        return new ActivityStoreManageBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_store_manage is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 73: 
      if ("layout/activity_soft_ap_reset_hint_0".equals(paramObject)) {
        return new ActivitySoftApResetHintBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_soft_ap_reset_hint is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 72: 
      if ("layout/activity_soft_ap_common_guide_0".equals(paramObject)) {
        return new ActivitySoftApCommonGuideBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_soft_ap_common_guide is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 71: 
      if ("layout/activity_set_location_0".equals(paramObject)) {
        return new ActivitySetLocationBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_set_location is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 70: 
      if ("layout/activity_sensor_settings_0".equals(paramObject)) {
        return new ActivitySensorSettingsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_sensor_settings is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 69: 
      if ("layout/activity_sensor_set_sensitivity_0".equals(paramObject)) {
        return new ActivitySensorSetSensitivityBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_sensor_set_sensitivity is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 68: 
      if ("layout/activity_sensor_set_report_interval_0".equals(paramObject)) {
        return new ActivitySensorSetReportIntervalBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_sensor_set_report_interval is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 67: 
      if ("layout/activity_sensor_detail_content_0".equals(paramObject)) {
        return new ActivitySensorDetailContentBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_sensor_detail_content is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 66: 
      if ("layout/activity_sensor_detail_bottom_0".equals(paramObject)) {
        return new ActivitySensorDetailBottomBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_sensor_detail_bottom is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 65: 
      if ("layout/activity_sensor_detail_0".equals(paramObject)) {
        return new ActivitySensorDetailBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_sensor_detail is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 64: 
      if ("layout/activity_select_device_0".equals(paramObject)) {
        return new ActivitySelectDeviceBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_select_device is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 63: 
      if ("layout/activity_schedule_setting_0".equals(paramObject)) {
        return new ActivityScheduleSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_schedule_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 62: 
      if ("layout/activity_schedule_edit_0".equals(paramObject)) {
        return new ActivityScheduleEditBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_schedule_edit is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 61: 
      if ("layout/activity_record_audio_setting_0".equals(paramObject)) {
        return new ActivityRecordAudioSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_record_audio_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 60: 
      if ("layout/activity_qs_plug_icon_select_icon_0".equals(paramObject)) {
        return new ActivityQsPlugIconSelectIconBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_qs_plug_icon_select_icon is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 59: 
      if ("layout/activity_privacy_mode_0".equals(paramObject)) {
        return new ActivityPrivacyModeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_privacy_mode is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 58: 
      if ("layout/activity_privacy_mask_zones_0".equals(paramObject)) {
        return new ActivityPrivacyMaskZonesBindingImpl(paramDataBindingComponent, paramView);
      }
      if ("layout-land/activity_privacy_mask_zones_0".equals(paramObject)) {
        return new ActivityPrivacyMaskZonesBindingLandImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_privacy_mask_zones is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 57: 
      if ("layout/activity_privacy_mask_0".equals(paramObject)) {
        return new ActivityPrivacyMaskBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_privacy_mask is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 56: 
      if ("layout/activity_plug_power_statistic_0".equals(paramObject)) {
        return new ActivityPlugPowerStatisticBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_plug_power_statistic is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 55: 
      if ("layout/activity_plug_electricity_statistic_0".equals(paramObject)) {
        return new ActivityPlugElectricityStatisticBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_plug_electricity_statistic is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 54: 
      if ("layout/activity_playback_new_ipc_0".equals(paramObject)) {
        return new ActivityPlaybackNewIpcBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_playback_new_ipc is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 53: 
      if ("layout/activity_osd_new_ipc_0".equals(paramObject)) {
        return new ActivityOsdNewIpcBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_osd_new_ipc is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 52: 
      if ("layout/activity_msg_push_0".equals(paramObject)) {
        return new ActivityMsgPushBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for activity_msg_push is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    }
    if ("layout-land/activity_motion_region_setting_0".equals(paramObject)) {
      return new ActivityMotionRegionSettingBindingLandImpl(paramDataBindingComponent, paramView);
    }
    if ("layout/activity_motion_region_setting_0".equals(paramObject)) {
      return new ActivityMotionRegionSettingBindingImpl(paramDataBindingComponent, paramView);
    }
    paramDataBindingComponent = new StringBuilder();
    paramDataBindingComponent.append("The tag for activity_motion_region_setting is invalid. Received: ");
    paramDataBindingComponent.append(paramObject);
    throw new IllegalArgumentException(paramDataBindingComponent.toString());
  }
  
  private final ViewDataBinding c(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 150: 
      if ("layout/fragment_camera_v2_rescan_wifi_0".equals(paramObject)) {
        return new FragmentCameraV2RescanWifiBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_rescan_wifi is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 149: 
      if ("layout/fragment_camera_v2_permission_0".equals(paramObject)) {
        return new FragmentCameraV2PermissionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_permission is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 148: 
      if ("layout/fragment_camera_v2_pairing_failed_0".equals(paramObject)) {
        return new FragmentCameraV2PairingFailedBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_pairing_failed is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 147: 
      if ("layout/fragment_camera_v2_not_found_0".equals(paramObject)) {
        return new FragmentCameraV2NotFoundBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_not_found is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 146: 
      if ("layout/fragment_camera_v2_name_0".equals(paramObject)) {
        return new FragmentCameraV2NameBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_name is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 145: 
      if ("layout/fragment_camera_v2_manual_input_pwd_0".equals(paramObject)) {
        return new FragmentCameraV2ManualInputPwdBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_manual_input_pwd is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 144: 
      if ("layout/fragment_camera_v2_location_set_0".equals(paramObject)) {
        return new FragmentCameraV2LocationSetBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_location_set is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 143: 
      if ("layout/fragment_camera_v2_location_permission_0".equals(paramObject)) {
        return new FragmentCameraV2LocationPermissionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_location_permission is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 142: 
      if ("layout/fragment_camera_v2_introduce_videoplay_item_0".equals(paramObject)) {
        return new FragmentCameraV2IntroduceVideoplayItemBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_introduce_videoplay_item is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 141: 
      if ("layout/fragment_camera_v2_introduce_tapo_care_0".equals(paramObject)) {
        return new FragmentCameraV2IntroduceTapoCareBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_introduce_tapo_care is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 140: 
      if ("layout/fragment_camera_v2_instruction_0".equals(paramObject)) {
        return new FragmentCameraV2InstructionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_instruction is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 139: 
      if ("layout/fragment_camera_v2_install_preview_0".equals(paramObject)) {
        return new FragmentCameraV2InstallPreviewBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_install_preview is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 138: 
      if ("layout/fragment_camera_v2_install_helpful_items_0".equals(paramObject)) {
        return new FragmentCameraV2InstallHelpfulItemsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_install_helpful_items is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 137: 
      if ("layout/fragment_camera_v2_install_guide_waterproof_layout_0".equals(paramObject)) {
        return new FragmentCameraV2InstallGuideWaterproofLayoutBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_install_guide_waterproof_layout is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 136: 
      if ("layout/fragment_camera_v2_install_guide_item_layout_0".equals(paramObject)) {
        return new FragmentCameraV2InstallGuideItemLayoutBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_install_guide_item_layout is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 135: 
      if ("layout/fragment_camera_v2_install_guide_0".equals(paramObject)) {
        return new FragmentCameraV2InstallGuideBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_install_guide is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 134: 
      if ("layout/fragment_camera_v2_input_pwd_0".equals(paramObject)) {
        return new FragmentCameraV2InputPwdBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_input_pwd is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 133: 
      if ("layout/fragment_camera_v2_identify_0".equals(paramObject)) {
        return new FragmentCameraV2IdentifyBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_identify is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 132: 
      if ("layout/fragment_camera_v2_connecting_0".equals(paramObject)) {
        return new FragmentCameraV2ConnectingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_connecting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 131: 
      if ("layout/fragment_camera_v2_connect_to_pair_0".equals(paramObject)) {
        return new FragmentCameraV2ConnectToPairBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_connect_to_pair is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 130: 
      if ("layout/fragment_camera_v2_connect_ap_0".equals(paramObject)) {
        return new FragmentCameraV2ConnectApBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_connect_ap is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 129: 
      if ("layout/fragment_camera_v2_configured_before_0".equals(paramObject)) {
        return new FragmentCameraV2ConfiguredBeforeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_configured_before is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 128: 
      if ("layout/fragment_camera_v2_complete_0".equals(paramObject)) {
        return new FragmentCameraV2CompleteBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_complete is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 127: 
      if ("layout/fragment_camera_v2_check_status_0".equals(paramObject)) {
        return new FragmentCameraV2CheckStatusBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_check_status is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 126: 
      if ("layout/fragment_camera_v2_cannot_find_wifi_0".equals(paramObject)) {
        return new FragmentCameraV2CannotFindWifiBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_cannot_find_wifi is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 125: 
      if ("layout/fragment_camera_v2_before_install_0".equals(paramObject)) {
        return new FragmentCameraV2BeforeInstallBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_before_install is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 124: 
      if ("layout/fragment_camera_trigger_0".equals(paramObject)) {
        return new FragmentCameraTriggerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_trigger is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 123: 
      if ("layout/fragment_camera_control_0".equals(paramObject)) {
        return new FragmentCameraControlBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_control is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 122: 
      if ("layout/fragment_camera_connect_type_0".equals(paramObject)) {
        return new FragmentCameraConnectTypeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_connect_type is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 121: 
      if ("layout/fragment_camera_connect_router_0".equals(paramObject)) {
        return new FragmentCameraConnectRouterBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_connect_router is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 120: 
      if ("layout/fragment_camera_auto_update_hint_0".equals(paramObject)) {
        return new FragmentCameraAutoUpdateHintBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_auto_update_hint is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 119: 
      if ("layout/fragment_button_replace_battery_0".equals(paramObject)) {
        return new FragmentButtonReplaceBatteryBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_button_replace_battery is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 118: 
      if ("layout/fragment_button_featured_actions_guide_0".equals(paramObject)) {
        return new FragmentButtonFeaturedActionsGuideBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_button_featured_actions_guide is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 117: 
      if ("layout/fragment_button_featured_actions_0".equals(paramObject)) {
        return new FragmentButtonFeaturedActionsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_button_featured_actions is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 116: 
      if ("layout/fragment_bottom_scroll_picker_0".equals(paramObject)) {
        return new FragmentBottomScrollPickerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_bottom_scroll_picker is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 115: 
      if ("layout/fragment_abstract_featured_action_choose_0".equals(paramObject)) {
        return new FragmentAbstractFeaturedActionChooseBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_abstract_featured_action_choose is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 114: 
      if ("layout/fragment_abstract_featured_action_0".equals(paramObject)) {
        return new FragmentAbstractFeaturedActionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_abstract_featured_action is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 113: 
      if ("layout/exo_playback_control_view_0".equals(paramObject)) {
        return new ExoPlaybackControlViewBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for exo_playback_control_view is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 112: 
      if ("layout/dialog_volume_control_full_screen_0".equals(paramObject)) {
        return new DialogVolumeControlFullScreenBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_volume_control_full_screen is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 111: 
      if ("layout/dialog_volume_control_0".equals(paramObject)) {
        return new DialogVolumeControlBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_volume_control is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 110: 
      if ("layout/dialog_select_device_0".equals(paramObject)) {
        return new DialogSelectDeviceBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_select_device is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 109: 
      if ("layout/dialog_music_rhythm_power_mode_setting_sheet_0".equals(paramObject)) {
        return new DialogMusicRhythmPowerModeSettingSheetBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_music_rhythm_power_mode_setting_sheet is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 108: 
      if ("layout/dialog_music_rhythm_light_strength_sheet_0".equals(paramObject)) {
        return new DialogMusicRhythmLightStrengthSheetBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_music_rhythm_light_strength_sheet is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 107: 
      if ("layout/dialog_music_rhythm_flowing_beam_mode_setting_sheet_0".equals(paramObject)) {
        return new DialogMusicRhythmFlowingBeamModeSettingSheetBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_music_rhythm_flowing_beam_mode_setting_sheet is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 106: 
      if ("layout/dialog_music_rhythm_color_picker_sheet_0".equals(paramObject)) {
        return new DialogMusicRhythmColorPickerSheetBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_music_rhythm_color_picker_sheet is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 105: 
      if ("layout/dialog_multi_live_drag_0".equals(paramObject)) {
        return new DialogMultiLiveDragBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_multi_live_drag is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 104: 
      if ("layout/dialog_microphone_control_0".equals(paramObject)) {
        return new DialogMicrophoneControlBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_microphone_control is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 103: 
      if ("layout/dialog_memory_slide_operation_0".equals(paramObject)) {
        return new DialogMemorySlideOperationBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_memory_slide_operation is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 102: 
      if ("layout/dialog_memory_bottom_operation_0".equals(paramObject)) {
        return new DialogMemoryBottomOperationBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for dialog_memory_bottom_operation is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    }
    if ("layout/dialog_mark_position_confirm_0".equals(paramObject)) {
      return new DialogMarkPositionConfirmBindingImpl(paramDataBindingComponent, paramView);
    }
    paramDataBindingComponent = new StringBuilder();
    paramDataBindingComponent.append("The tag for dialog_mark_position_confirm is invalid. Received: ");
    paramDataBindingComponent.append(paramObject);
    throw new IllegalArgumentException(paramDataBindingComponent.toString());
  }
  
  private final ViewDataBinding d(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 200: 
      if ("layout/fragment_sub_g_searching_device_0".equals(paramObject)) {
        return new FragmentSubGSearchingDeviceBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_searching_device is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 199: 
      if ("layout/fragment_sub_g_save_setting_0".equals(paramObject)) {
        return new FragmentSubGSaveSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_save_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 198: 
      if ("layout/fragment_sub_g_no_found_0".equals(paramObject)) {
        return new FragmentSubGNoFoundBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_no_found is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 197: 
      if ("layout/fragment_sub_g_hub_list_0".equals(paramObject)) {
        return new FragmentSubGHubListBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_hub_list is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 196: 
      if ("layout/fragment_sub_g_hub_firmware_update_0".equals(paramObject)) {
        return new FragmentSubGHubFirmwareUpdateBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_hub_firmware_update is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 195: 
      if ("layout/fragment_sub_g_hub_empty_0".equals(paramObject)) {
        return new FragmentSubGHubEmptyBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_hub_empty is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 194: 
      if ("layout/fragment_sub_g_complete_0".equals(paramObject)) {
        return new FragmentSubGCompleteBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_complete is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 193: 
      if ("layout/fragment_record_type_dialog_0".equals(paramObject)) {
        return new FragmentRecordTypeDialogBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_record_type_dialog is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 192: 
      if ("layout/fragment_rate_us_dialog_0".equals(paramObject)) {
        return new FragmentRateUsDialogBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_rate_us_dialog is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 191: 
      if ("layout/fragment_plug_energy_monitor_0".equals(paramObject)) {
        return new FragmentPlugEnergyMonitorBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_plug_energy_monitor is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 190: 
      if ("layout/fragment_play_back_video_0".equals(paramObject)) {
        return new FragmentPlayBackVideoBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_play_back_video is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 189: 
      if ("layout/fragment_play_back_control_0".equals(paramObject)) {
        return new FragmentPlayBackControlBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_play_back_control is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 188: 
      if ("layout/fragment_photos_0".equals(paramObject)) {
        return new FragmentPhotosBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_photos is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 187: 
      if ("layout/fragment_operation_shell_0".equals(paramObject)) {
        return new FragmentOperationShellBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_operation_shell is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 186: 
      if ("layout/fragment_multi_live_video_0".equals(paramObject)) {
        return new FragmentMultiLiveVideoBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_multi_live_video is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 185: 
      if ("layout/fragment_motion_sensor_replace_battery_0".equals(paramObject)) {
        return new FragmentMotionSensorReplaceBatteryBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_motion_sensor_replace_battery is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 184: 
      if ("layout/fragment_light_strip_schedule_0".equals(paramObject)) {
        return new FragmentLightStripScheduleBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_light_strip_schedule is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 183: 
      if ("layout/fragment_light_strip_light_settings_dialog_0".equals(paramObject)) {
        return new FragmentLightStripLightSettingsDialogBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_light_strip_light_settings_dialog is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 182: 
      if ("layout/fragment_light_strip_light_settings_0".equals(paramObject)) {
        return new FragmentLightStripLightSettingsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_light_strip_light_settings is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 181: 
      if ("layout/fragment_light_strip_light_effects_0".equals(paramObject)) {
        return new FragmentLightStripLightEffectsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_light_strip_light_effects is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 180: 
      if ("layout/fragment_guard_mode_set_alarm_time_0".equals(paramObject)) {
        return new FragmentGuardModeSetAlarmTimeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_guard_mode_set_alarm_time is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 179: 
      if ("layout/fragment_guard_mode_recyclerview_list_0".equals(paramObject)) {
        return new FragmentGuardModeRecyclerviewListBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_guard_mode_recyclerview_list is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 178: 
      if ("layout/fragment_guard_mode_config_0".equals(paramObject)) {
        return new FragmentGuardModeConfigBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_guard_mode_config is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 177: 
      if ("layout/fragment_firmware_update_new_ipc_0".equals(paramObject)) {
        return new FragmentFirmwareUpdateNewIpcBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_firmware_update_new_ipc is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 176: 
      if ("layout/fragment_firmware_check_0".equals(paramObject)) {
        return new FragmentFirmwareCheckBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_firmware_check is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 175: 
      if ("layout/fragment_dialog_get_lost_0".equals(paramObject)) {
        return new FragmentDialogGetLostBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_dialog_get_lost is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 174: 
      if ("layout/fragment_device_trigger_single_choice_0".equals(paramObject)) {
        return new FragmentDeviceTriggerSingleChoiceBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_device_trigger_single_choice is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 173: 
      if ("layout/fragment_device_trigger_container_0".equals(paramObject)) {
        return new FragmentDeviceTriggerContainerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_device_trigger_container is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 172: 
      if ("layout/fragment_device_password_setting_0".equals(paramObject)) {
        return new FragmentDevicePasswordSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_device_password_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 171: 
      if ("layout/fragment_device_password_check_0".equals(paramObject)) {
        return new FragmentDevicePasswordCheckBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_device_password_check is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 170: 
      if ("layout/fragment_contact_sensor_replace_battery_0".equals(paramObject)) {
        return new FragmentContactSensorReplaceBatteryBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_contact_sensor_replace_battery is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 169: 
      if ("layout/fragment_color_temperature_setting_0".equals(paramObject)) {
        return new FragmentColorTemperatureSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_color_temperature_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 168: 
      if ("layout/fragment_color_picker_dialog_0".equals(paramObject)) {
        return new FragmentColorPickerDialogBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_color_picker_dialog is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 167: 
      if ("layout/fragment_color_light_setting_0".equals(paramObject)) {
        return new FragmentColorLightSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_color_light_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 166: 
      if ("layout/fragment_cloud_terrace_preset_0".equals(paramObject)) {
        return new FragmentCloudTerracePresetBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_cloud_terrace_preset is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 165: 
      if ("layout/fragment_cloud_terrace_control_0".equals(paramObject)) {
        return new FragmentCloudTerraceControlBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_cloud_terrace_control is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 164: 
      if ("layout/fragment_cloud_password_check_0".equals(paramObject)) {
        return new FragmentCloudPasswordCheckBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_cloud_password_check is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 163: 
      if ("layout/fragment_camera_wired_set_wireless_failed_0".equals(paramObject)) {
        return new FragmentCameraWiredSetWirelessFailedBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_wired_set_wireless_failed is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 162: 
      if ("layout/fragment_camera_wired_connecting_0".equals(paramObject)) {
        return new FragmentCameraWiredConnectingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_wired_connecting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 161: 
      if ("layout/fragment_camera_wired_connect_ap_0".equals(paramObject)) {
        return new FragmentCameraWiredConnectApBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_wired_connect_ap is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 160: 
      if ("layout/fragment_camera_wired_complete_0".equals(paramObject)) {
        return new FragmentCameraWiredCompleteBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_wired_complete is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 159: 
      if ("layout/fragment_camera_v2_wifi_list_0".equals(paramObject)) {
        return new FragmentCameraV2WifiListBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_wifi_list is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 158: 
      if ("layout/fragment_camera_v2_trouble_shooting_0".equals(paramObject)) {
        return new FragmentCameraV2TroubleShootingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_trouble_shooting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 157: 
      if ("layout/fragment_camera_v2_ssid_list_0".equals(paramObject)) {
        return new FragmentCameraV2SsidListBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_ssid_list is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 156: 
      if ("layout/fragment_camera_v2_search_after_setup_0".equals(paramObject)) {
        return new FragmentCameraV2SearchAfterSetupBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_search_after_setup is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 155: 
      if ("layout/fragment_camera_v2_sd_hint_0".equals(paramObject)) {
        return new FragmentCameraV2SdHintBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_sd_hint is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 154: 
      if ("layout/fragment_camera_v2_save_setting_0".equals(paramObject)) {
        return new FragmentCameraV2SaveSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_save_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 153: 
      if ("layout/fragment_camera_v2_room_select_0".equals(paramObject)) {
        return new FragmentCameraV2RoomSelectBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_room_select is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 152: 
      if ("layout/fragment_camera_v2_room_custom_0".equals(paramObject)) {
        return new FragmentCameraV2RoomCustomBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_camera_v2_room_custom is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    }
    if ("layout/fragment_camera_v2_reset_0".equals(paramObject)) {
      return new FragmentCameraV2ResetBindingImpl(paramDataBindingComponent, paramView);
    }
    paramDataBindingComponent = new StringBuilder();
    paramDataBindingComponent.append("The tag for fragment_camera_v2_reset is invalid. Received: ");
    paramDataBindingComponent.append(paramObject);
    throw new IllegalArgumentException(paramDataBindingComponent.toString());
  }
  
  private final ViewDataBinding e(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 250: 
      if ("layout/layout_full_screen_bottom_bar_0".equals(paramObject)) {
        return new LayoutFullScreenBottomBarBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_full_screen_bottom_bar is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 249: 
      if ("layout/layout_day_night_mode_0".equals(paramObject)) {
        return new LayoutDayNightModeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_day_night_mode is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 248: 
      if ("layout/layout_daily_summary_settings_0".equals(paramObject)) {
        return new LayoutDailySummarySettingsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_daily_summary_settings is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 247: 
      if ("layout/layout_camera_menu_settings_0".equals(paramObject)) {
        return new LayoutCameraMenuSettingsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_camera_menu_settings is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 246: 
      if ("layout/layout_camera_menu_infrared_0".equals(paramObject)) {
        return new LayoutCameraMenuInfraredBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_camera_menu_infrared is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 245: 
      if ("layout/layout_camera_menu_definition_0".equals(paramObject)) {
        return new LayoutCameraMenuDefinitionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_camera_menu_definition is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 244: 
      if ("layout/layout_camera_menu_button_white_lamp_0".equals(paramObject)) {
        return new LayoutCameraMenuButtonWhiteLampBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_camera_menu_button_white_lamp is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 243: 
      if ("layout/layout_camera_menu_button_day_night_mode_0".equals(paramObject)) {
        return new LayoutCameraMenuButtonDayNightModeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_camera_menu_button_day_night_mode is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 242: 
      if ("layout/layout_camera_menu_button_0".equals(paramObject)) {
        return new LayoutCameraMenuButtonBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_camera_menu_button is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 241: 
      if ("layout/item_summary_home_0".equals(paramObject)) {
        return new ItemSummaryHomeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_summary_home is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 240: 
      if ("layout/item_summary_history_0".equals(paramObject)) {
        return new ItemSummaryHistoryBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_summary_history is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 239: 
      if ("layout/item_summary_clip_video_0".equals(paramObject)) {
        return new ItemSummaryClipVideoBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_summary_clip_video is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 238: 
      if ("layout/item_summary_clip_title_0".equals(paramObject)) {
        return new ItemSummaryClipTitleBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_summary_clip_title is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 237: 
      if ("layout/item_region_list_title_0".equals(paramObject)) {
        return new ItemRegionListTitleBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_region_list_title is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 236: 
      if ("layout/item_region_list_content_0".equals(paramObject)) {
        return new ItemRegionListContentBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_region_list_content is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 235: 
      if ("layout/item_multi_live_0".equals(paramObject)) {
        return new ItemMultiLiveBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_multi_live is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 234: 
      if ("layout/item_mode_setting_0".equals(paramObject)) {
        return new ItemModeSettingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_mode_setting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 233: 
      if ("layout/item_mode_add_camera_0".equals(paramObject)) {
        return new ItemModeAddCameraBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_mode_add_camera is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 232: 
      if ("layout/item_hub_sub_device_card_0".equals(paramObject)) {
        return new ItemHubSubDeviceCardBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_hub_sub_device_card is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 231: 
      if ("layout/item_home_away_mode_fail_0".equals(paramObject)) {
        return new ItemHomeAwayModeFailBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_home_away_mode_fail is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 230: 
      if ("layout/item_featured_action_choose_0".equals(paramObject)) {
        return new ItemFeaturedActionChooseBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_featured_action_choose is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 229: 
      if ("layout/item_feature_grid_0".equals(paramObject)) {
        return new ItemFeatureGridBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_feature_grid is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 228: 
      if ("layout/item_cloud_terrace_mark_position_0".equals(paramObject)) {
        return new ItemCloudTerraceMarkPositionBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_cloud_terrace_mark_position is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 227: 
      if ("layout/item_camera_wifi_other_item_0".equals(paramObject)) {
        return new ItemCameraWifiOtherItemBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_camera_wifi_other_item is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 226: 
      if ("layout/item_camera_ssid_layout_0".equals(paramObject)) {
        return new ItemCameraSsidLayoutBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_camera_ssid_layout is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 225: 
      if ("layout/item_camera_select_device_full_screen_0".equals(paramObject)) {
        return new ItemCameraSelectDeviceFullScreenBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_camera_select_device_full_screen is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 224: 
      if ("layout/item_camera_select_device_0".equals(paramObject)) {
        return new ItemCameraSelectDeviceBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_camera_select_device is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 223: 
      if ("layout/item_camera_preview_sort_0".equals(paramObject)) {
        return new ItemCameraPreviewSortBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_camera_preview_sort is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 222: 
      if ("layout/item_camera_preview_0".equals(paramObject)) {
        return new ItemCameraPreviewBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_camera_preview is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 221: 
      if ("layout/item_camera_location_0".equals(paramObject)) {
        return new ItemCameraLocationBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_camera_location is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 220: 
      if ("layout/item_camera_cloud_terrace_position_info_0".equals(paramObject)) {
        return new ItemCameraCloudTerracePositionInfoBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for item_camera_cloud_terrace_position_info is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 219: 
      if ("layout/fragment_voice_call_0".equals(paramObject)) {
        return new FragmentVoiceCallBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_voice_call is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 218: 
      if ("layout/fragment_trv_replace_battery_0".equals(paramObject)) {
        return new FragmentTrvReplaceBatteryBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_trv_replace_battery is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 217: 
      if ("layout/fragment_trv_error_trouble_shooting_0".equals(paramObject)) {
        return new FragmentTrvErrorTroubleShootingBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_trv_error_trouble_shooting is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 216: 
      if ("layout/fragment_thermostat_trigger_0".equals(paramObject)) {
        return new FragmentThermostatTriggerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_thermostat_trigger is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 215: 
      if ("layout/fragment_thermostat_control_0".equals(paramObject)) {
        return new FragmentThermostatControlBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_thermostat_control is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 214: 
      if ("layout/fragment_task_hub_control_0".equals(paramObject)) {
        return new FragmentTaskHubControlBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_task_hub_control is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 213: 
      if ("layout/fragment_task_device_control_container_0".equals(paramObject)) {
        return new FragmentTaskDeviceControlContainerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_task_device_control_container is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 212: 
      if ("layout/fragment_talk_0".equals(paramObject)) {
        return new FragmentTalkBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_talk is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 211: 
      if ("layout/fragment_switch_replace_battery_0".equals(paramObject)) {
        return new FragmentSwitchReplaceBatteryBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_switch_replace_battery is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 210: 
      if ("layout/fragment_switch_quicksetup_guide_0".equals(paramObject)) {
        return new FragmentSwitchQuicksetupGuideBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_switch_quicksetup_guide is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 209: 
      if ("layout/fragment_subg_switch_how_to_install_0".equals(paramObject)) {
        return new FragmentSubgSwitchHowToInstallBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_subg_switch_how_to_install is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 208: 
      if ("layout/fragment_subg_remove_cover_0".equals(paramObject)) {
        return new FragmentSubgRemoveCoverBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_subg_remove_cover is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 207: 
      if ("layout/fragment_subg_power_up_device_0".equals(paramObject)) {
        return new FragmentSubgPowerUpDeviceBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_subg_power_up_device is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 206: 
      if ("layout/fragment_subg_led_not_blinking_help_0".equals(paramObject)) {
        return new FragmentSubgLedNotBlinkingHelpBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_subg_led_not_blinking_help is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 205: 
      if ("layout/fragment_subg_enable_pairing_mode_0".equals(paramObject)) {
        return new FragmentSubgEnablePairingModeBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_subg_enable_pairing_mode is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 204: 
      if ("layout/fragment_sub_g_setup_name_0".equals(paramObject)) {
        return new FragmentSubGSetupNameBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_setup_name is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 203: 
      if ("layout/fragment_sub_g_setup_location_select_0".equals(paramObject)) {
        return new FragmentSubGSetupLocationSelectBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_setup_location_select is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 202: 
      if ("layout/fragment_sub_g_setup_location_custom_0".equals(paramObject)) {
        return new FragmentSubGSetupLocationCustomBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for fragment_sub_g_setup_location_custom is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    }
    if ("layout/fragment_sub_g_setup_avatar_0".equals(paramObject)) {
      return new FragmentSubGSetupAvatarBindingImpl(paramDataBindingComponent, paramView);
    }
    paramDataBindingComponent = new StringBuilder();
    paramDataBindingComponent.append("The tag for fragment_sub_g_setup_avatar is invalid. Received: ");
    paramDataBindingComponent.append(paramObject);
    throw new IllegalArgumentException(paramDataBindingComponent.toString());
  }
  
  private final ViewDataBinding f(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 293: 
      if ("layout/widget_tips_bar_0".equals(paramObject)) {
        return new WidgetTipsBarBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for widget_tips_bar is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 292: 
      if ("layout/view_video_surface_layout_0".equals(paramObject)) {
        return new ViewVideoSurfaceLayoutBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for view_video_surface_layout is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 291: 
      if ("layout/view_preview_display_0".equals(paramObject)) {
        return new ViewPreviewDisplayBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for view_preview_display is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 290: 
      if ("layout/view_multi_features_grid_0".equals(paramObject)) {
        return new ViewMultiFeaturesGridBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for view_multi_features_grid is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 289: 
      if ("layout/view_founded_device_item_0".equals(paramObject)) {
        return new ViewFoundedDeviceItemBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for view_founded_device_item is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 288: 
      if ("layout/view_cloud_terrace_control_sensitivity_panel_0".equals(paramObject)) {
        return new ViewCloudTerraceControlSensitivityPanelBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for view_cloud_terrace_control_sensitivity_panel is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 287: 
      if ("layout/play_back_top_bar_0".equals(paramObject)) {
        return new PlayBackTopBarBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for play_back_top_bar is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 286: 
      if ("layout/play_back_time_ruler_0".equals(paramObject)) {
        return new PlayBackTimeRulerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for play_back_time_ruler is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 285: 
      if ("layout/play_back_ruler_layout_0".equals(paramObject)) {
        return new PlayBackRulerLayoutBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for play_back_ruler_layout is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 284: 
      if ("layout/play_back_date_selector_0".equals(paramObject)) {
        return new PlayBackDateSelectorBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for play_back_date_selector is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 283: 
      if ("layout/play_back_bottom_bar_0".equals(paramObject)) {
        return new PlayBackBottomBarBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for play_back_bottom_bar is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 282: 
      if ("layout/mode_setting_footer_view_0".equals(paramObject)) {
        return new ModeSettingFooterViewBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for mode_setting_footer_view is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 281: 
      if ("layout/menu_save_0".equals(paramObject)) {
        return new MenuSaveBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for menu_save is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 280: 
      if ("layout/layout_voice_talk_panel_0".equals(paramObject)) {
        return new LayoutVoiceTalkPanelBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_voice_talk_panel is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 279: 
      if ("layout/layout_various_image_view_0".equals(paramObject)) {
        return new LayoutVariousImageViewBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_various_image_view is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 278: 
      if ("layout/layout_trv_settings_feature_ext_0".equals(paramObject)) {
        return new LayoutTrvSettingsFeatureExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_trv_settings_feature_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 277: 
      if ("layout/layout_trv_one_select_settings_0".equals(paramObject)) {
        return new LayoutTrvOneSelectSettingsBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_trv_one_select_settings is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 276: 
      if ("layout/layout_trv_detail_content_ext_0".equals(paramObject)) {
        return new LayoutTrvDetailContentExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_trv_detail_content_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 275: 
      if ("layout/layout_trv_detail_bottom_ext_0".equals(paramObject)) {
        return new LayoutTrvDetailBottomExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_trv_detail_bottom_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 274: 
      if ("layout/layout_temperature_seekbar_0".equals(paramObject)) {
        return new LayoutTemperatureSeekbarBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_temperature_seekbar is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 273: 
      if ("layout/layout_switch_settings_feature_ext_0".equals(paramObject)) {
        return new LayoutSwitchSettingsFeatureExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_switch_settings_feature_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 272: 
      if ("layout/layout_switch_detail_content_ext_0".equals(paramObject)) {
        return new LayoutSwitchDetailContentExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_switch_detail_content_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 271: 
      if ("layout/layout_switch_detail_bottom_ext_0".equals(paramObject)) {
        return new LayoutSwitchDetailBottomExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_switch_detail_bottom_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 270: 
      if ("layout/layout_summary_time_axis_0".equals(paramObject)) {
        return new LayoutSummaryTimeAxisBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_summary_time_axis is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 269: 
      if ("layout/layout_select_report_interval_0".equals(paramObject)) {
        return new LayoutSelectReportIntervalBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_select_report_interval is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 268: 
      if ("layout/layout_playback_toolbar_top_0".equals(paramObject)) {
        return new LayoutPlaybackToolbarTopBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_playback_toolbar_top is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 267: 
      if ("layout/layout_playback_toolbar_popup_0".equals(paramObject)) {
        return new LayoutPlaybackToolbarPopupBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_playback_toolbar_popup is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 266: 
      if ("layout/layout_playback_toolbar_bottom_0".equals(paramObject)) {
        return new LayoutPlaybackToolbarBottomBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_playback_toolbar_bottom is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 265: 
      if ("layout/layout_play_back_fullscreen_filter_0".equals(paramObject)) {
        return new LayoutPlayBackFullscreenFilterBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_play_back_fullscreen_filter is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 264: 
      if ("layout/layout_play_back_fullscreen_calendar_0".equals(paramObject)) {
        return new LayoutPlayBackFullscreenCalendarBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_play_back_fullscreen_calendar is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 263: 
      if ("layout/layout_palyback_full_bottom_0".equals(paramObject)) {
        return new LayoutPalybackFullBottomBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_palyback_full_bottom is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 262: 
      if ("layout/layout_multi_live_toolbar_bottom_0".equals(paramObject)) {
        return new LayoutMultiLiveToolbarBottomBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_multi_live_toolbar_bottom is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 261: 
      if ("layout/layout_lighting_effect_preset_0".equals(paramObject)) {
        return new LayoutLightingEffectPresetBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_lighting_effect_preset is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 260: 
      if ("layout/layout_light_strip_settings_other_ext_0".equals(paramObject)) {
        return new LayoutLightStripSettingsOtherExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_light_strip_settings_other_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 259: 
      if ("layout/layout_light_strip_settings_feature_ext_0".equals(paramObject)) {
        return new LayoutLightStripSettingsFeatureExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_light_strip_settings_feature_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 258: 
      if ("layout/layout_light_strip_guide_page_0".equals(paramObject)) {
        return new LayoutLightStripGuidePageBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_light_strip_guide_page is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 257: 
      if ("layout/layout_light_strip_detail_content_ext_0".equals(paramObject)) {
        return new LayoutLightStripDetailContentExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_light_strip_detail_content_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 256: 
      if ("layout/layout_light_strip_detail_bottom_ext_0".equals(paramObject)) {
        return new LayoutLightStripDetailBottomExtBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_light_strip_detail_bottom_ext is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 255: 
      if ("layout/layout_light_strip_detail_bg_0".equals(paramObject)) {
        return new LayoutLightStripDetailBgBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_light_strip_detail_bg is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 254: 
      if ("layout/layout_light_strip_controller_0".equals(paramObject)) {
        return new LayoutLightStripControllerBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_light_strip_controller is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 253: 
      if ("layout/layout_hub_guard_mode_guide_0".equals(paramObject)) {
        return new LayoutHubGuardModeGuideBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_hub_guard_mode_guide is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    case 252: 
      if ("layout/layout_full_screen_quality_0".equals(paramObject)) {
        return new LayoutFullScreenQualityBindingImpl(paramDataBindingComponent, paramView);
      }
      paramDataBindingComponent = new StringBuilder();
      paramDataBindingComponent.append("The tag for layout_full_screen_quality is invalid. Received: ");
      paramDataBindingComponent.append(paramObject);
      throw new IllegalArgumentException(paramDataBindingComponent.toString());
    }
    if ("layout/layout_full_screen_control_0".equals(paramObject)) {
      return new LayoutFullScreenControlBindingImpl(paramDataBindingComponent, paramView);
    }
    paramDataBindingComponent = new StringBuilder();
    paramDataBindingComponent.append("The tag for layout_full_screen_control is invalid. Received: ");
    paramDataBindingComponent.append(paramObject);
    throw new IllegalArgumentException(paramDataBindingComponent.toString());
  }
  
  public List<DataBinderMapper> collectDependencies()
  {
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    localArrayList.add(new com.tplink.libtplivemedia.DataBinderMapperImpl());
    localArrayList.add(new com.tplink.libtpvodmedia.DataBinderMapperImpl());
    return localArrayList;
  }
  
  public String convertBrIdToString(int paramInt)
  {
    return (String)a.a.get(paramInt);
  }
  
  public ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt)
  {
    int i = a.get(paramInt);
    if (i > 0)
    {
      Object localObject = paramView.getTag();
      if (localObject != null)
      {
        paramInt = (i - 1) / 50;
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3)
              {
                if (paramInt != 4)
                {
                  if (paramInt == 5) {
                    return f(paramDataBindingComponent, paramView, i, localObject);
                  }
                }
                else {
                  return e(paramDataBindingComponent, paramView, i, localObject);
                }
              }
              else {
                return d(paramDataBindingComponent, paramView, i, localObject);
              }
            }
            else {
              return c(paramDataBindingComponent, paramView, i, localObject);
            }
          }
          else {
            return b(paramDataBindingComponent, paramView, i, localObject);
          }
        }
        else {
          return a(paramDataBindingComponent, paramView, i, localObject);
        }
      }
      else
      {
        throw new RuntimeException("view must have a tag");
      }
    }
    return null;
  }
  
  public ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View[] paramArrayOfView, int paramInt)
  {
    if ((paramArrayOfView != null) && (paramArrayOfView.length != 0) && (a.get(paramInt) > 0) && (paramArrayOfView[0].getTag() == null)) {
      throw new RuntimeException("view must have a tag");
    }
    return null;
  }
  
  public int getLayoutId(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    paramString = (Integer)b.a.get(paramString);
    if (paramString != null) {
      i = paramString.intValue();
    }
    return i;
  }
  
  private static class a
  {
    static final SparseArray<String> a;
    
    static
    {
      SparseArray localSparseArray = new SparseArray(108);
      a = localSparseArray;
      localSparseArray.put(1, "View");
      localSparseArray.put(0, "_all");
      localSparseArray.put(2, "callback");
      localSparseArray.put(3, "cameraDeviceIdMD5");
      localSparseArray.put(4, "cameraLocation");
      localSparseArray.put(5, "cameraName");
      localSparseArray.put(6, "cameraPreviewInfo");
      localSparseArray.put(7, "checkChangedListener");
      localSparseArray.put(8, "checkedChangeListener");
      localSparseArray.put(9, "clickListener");
      localSparseArray.put(10, "clipItem");
      localSparseArray.put(11, "cloudTerraceVM");
      localSparseArray.put(12, "connecting");
      localSparseArray.put(13, "curFocusPosition");
      localSparseArray.put(14, "deleteClickListener");
      localSparseArray.put(15, "detail");
      localSparseArray.put(16, "deviceIdMD5");
      localSparseArray.put(17, "deviceIsShared");
      localSparseArray.put(18, "diagnoseVM");
      localSparseArray.put(19, "doubleClickListener");
      localSparseArray.put(20, "enabled");
      localSparseArray.put(21, "featureBtnVisible");
      localSparseArray.put(22, "fileOrBitmap");
      localSparseArray.put(23, "firmwareUpdateAvailable");
      localSparseArray.put(24, "firstOfflinePosition");
      localSparseArray.put(25, "fullScreen");
      localSparseArray.put(26, "gotoClickListener");
      localSparseArray.put(27, "hideCloseBtn");
      localSparseArray.put(28, "id");
      localSparseArray.put(29, "inEditModel");
      localSparseArray.put(30, "inRearrangeStatus");
      localSparseArray.put(31, "info");
      localSparseArray.put(32, "isAutoMode");
      localSparseArray.put(33, "isCameraLocked");
      localSparseArray.put(34, "isCloudVideoServiceShow");
      localSparseArray.put(35, "isDayMode");
      localSparseArray.put(36, "isDeviceEmpty");
      localSparseArray.put(37, "isEditMode");
      localSparseArray.put(38, "isFullScreen");
      localSparseArray.put(39, "isHq");
      localSparseArray.put(40, "isHqSelected");
      localSparseArray.put(41, "isLiveLoading");
      localSparseArray.put(42, "isLiveNetworkError");
      localSparseArray.put(43, "isMainView");
      localSparseArray.put(44, "isMasked");
      localSparseArray.put(45, "isMultiScreen");
      localSparseArray.put(46, "isMultiVideo");
      localSparseArray.put(47, "isNightMode");
      localSparseArray.put(48, "isOnlyDeviceUser");
      localSparseArray.put(49, "isRearranging");
      localSparseArray.put(50, "isRecording");
      localSparseArray.put(51, "isSelected");
      localSparseArray.put(52, "isUpdating");
      localSparseArray.put(53, "ldcVM");
      localSparseArray.put(54, "lensMaskVM");
      localSparseArray.put(55, "listener");
      localSparseArray.put(56, "liveTagVisible");
      localSparseArray.put(57, "loading");
      localSparseArray.put(58, "location");
      localSparseArray.put(59, "longClickListener");
      localSparseArray.put(60, "macAddress");
      localSparseArray.put(61, "memoriesFilterViewModel");
      localSparseArray.put(62, "memoriesViewModel");
      localSparseArray.put(63, "monthDateClickListener");
      localSparseArray.put(64, "monthSelectedListener");
      localSparseArray.put(65, "moveListener");
      localSparseArray.put(66, "multiVM");
      localSparseArray.put(67, "name");
      localSparseArray.put(68, "onBoardingViewModel");
      localSparseArray.put(69, "onClickListener");
      localSparseArray.put(70, "onItemClickListener");
      localSparseArray.put(71, "onLongClickListener");
      localSparseArray.put(72, "onTimeChangedListener");
      localSparseArray.put(73, "playProperly");
      localSparseArray.put(74, "playVM");
      localSparseArray.put(75, "playbackViewModel");
      localSparseArray.put(76, "position");
      localSparseArray.put(77, "positionName");
      localSparseArray.put(78, "present");
      localSparseArray.put(79, "presenter");
      localSparseArray.put(80, "previewCoverEvent");
      localSparseArray.put(81, "previewCoverVisibility");
      localSparseArray.put(82, "rate");
      localSparseArray.put(83, "rearranging");
      localSparseArray.put(84, "recommendVisible");
      localSparseArray.put(85, "recordDuration");
      localSparseArray.put(86, "relayEventSubject");
      localSparseArray.put(87, "rightBtnVisible");
      localSparseArray.put(88, "sensitivity");
      localSparseArray.put(89, "setting");
      localSparseArray.put(90, "settingVM");
      localSparseArray.put(91, "speedTagVisible");
      localSparseArray.put(92, "ssid");
      localSparseArray.put(93, "stopTrackingListener");
      localSparseArray.put(94, "subGViewModel");
      localSparseArray.put(95, "summary");
      localSparseArray.put(96, "talkVM");
      localSparseArray.put(97, "talkViewModel");
      localSparseArray.put(98, "text");
      localSparseArray.put(99, "timeChangedListener");
      localSparseArray.put(100, "videoPlayViewModel");
      localSparseArray.put(101, "videoResolution");
      localSparseArray.put(102, "viewHolder");
      localSparseArray.put(103, "viewModel");
      localSparseArray.put(104, "viewState");
      localSparseArray.put(105, "viewmodel");
      localSparseArray.put(106, "visible");
      localSparseArray.put(107, "vodViewModel");
    }
  }
  
  private static class b
  {
    static final HashMap<String, Integer> a;
    
    static
    {
      HashMap localHashMap = new HashMap(299);
      a = localHashMap;
      localHashMap.put("layout/activity_advanced_setting_new_ipc_0", Integer.valueOf(2131558437));
      localHashMap.put("layout/activity_ai_detection_0", Integer.valueOf(2131558438));
      localHashMap.put("layout/activity_alarm_setting_0", Integer.valueOf(2131558439));
      localHashMap.put("layout/activity_alarm_sound_0", Integer.valueOf(2131558440));
      localHashMap.put("layout/activity_alarm_type_0", Integer.valueOf(2131558441));
      Integer localInteger = Integer.valueOf(2131558446);
      localHashMap.put("layout-land/activity_area_intrusion_region_setting_0", localInteger);
      localHashMap.put("layout/activity_area_intrusion_region_setting_0", localInteger);
      localHashMap.put("layout/activity_auto_reboot_0", Integer.valueOf(2131558448));
      localHashMap.put("layout/activity_base_iot_device_detail_0", Integer.valueOf(2131558452));
      localHashMap.put("layout/activity_base_iot_device_detail_bottom_0", Integer.valueOf(2131558453));
      localHashMap.put("layout/activity_base_iot_device_info_0", Integer.valueOf(2131558454));
      localHashMap.put("layout/activity_base_iot_device_settings_0", Integer.valueOf(2131558455));
      localHashMap.put("layout/activity_camera_cloud_connect_0", Integer.valueOf(2131558470));
      localHashMap.put("layout/activity_camera_preview_0", Integer.valueOf(2131558473));
      localHashMap.put("layout/activity_camera_preview_cloud_video_server_0", Integer.valueOf(2131558474));
      localHashMap.put("layout/activity_camera_preview_mode_part_0", Integer.valueOf(2131558475));
      localHashMap.put("layout/activity_camera_v2_onboarding_0", Integer.valueOf(2131558477));
      localHashMap.put("layout/activity_color_painting_make_0", Integer.valueOf(2131558488));
      localHashMap.put("layout/activity_customized_effects_make_0", Integer.valueOf(2131558492));
      localHashMap.put("layout/activity_daily_summary_0", Integer.valueOf(2131558493));
      localHashMap.put("layout/activity_debug_fw_update_0", Integer.valueOf(2131558494));
      localHashMap.put("layout/activity_detect_setting_0", Integer.valueOf(2131558495));
      localHashMap.put("layout/activity_device_detail_info_new_ipc_0", Integer.valueOf(2131558496));
      localHashMap.put("layout/activity_device_name_editor_0", Integer.valueOf(2131558499));
      localHashMap.put("layout/activity_device_setting_new_ipc_0", Integer.valueOf(2131558501));
      localHashMap.put("layout/activity_diagnose_status_0", Integer.valueOf(2131558510));
      localHashMap.put("layout/activity_discovered_devices_0", Integer.valueOf(2131558511));
      localHashMap.put("layout/activity_discovery_device_pairing_failed_0", Integer.valueOf(2131558512));
      localHashMap.put("layout/activity_edit_effects_name_0", Integer.valueOf(2131558513));
      localHashMap.put("layout/activity_featured_action_host_0", Integer.valueOf(2131558515));
      localHashMap.put("layout/activity_guard_mode_0", Integer.valueOf(2131558535));
      localHashMap.put("layout/activity_hub_alarm_log_0", Integer.valueOf(2131558539));
      localHashMap.put("layout/activity_intrusion_schedule_setting_0", Integer.valueOf(2131558545));
      localHashMap.put("layout/activity_iot_device_info_0", Integer.valueOf(2131558546));
      localHashMap.put("layout/activity_ldc_setting_0", Integer.valueOf(2131558552));
      localHashMap.put("layout/activity_light_adjust_0", Integer.valueOf(2131558559));
      localHashMap.put("layout/activity_light_strip_connect_parts_guide_0", Integer.valueOf(2131558562));
      localHashMap.put("layout/activity_light_strip_effects_0", Integer.valueOf(2131558563));
      localHashMap.put("layout/activity_light_strip_placement_guide_0", Integer.valueOf(2131558564));
      localHashMap.put("layout/activity_light_strip_set_default_state_0", Integer.valueOf(2131558565));
      localHashMap.put("layout/activity_light_strip_set_length_0", Integer.valueOf(2131558566));
      localHashMap.put("layout/activity_light_strip_soft_ap_reset_hint_0", Integer.valueOf(2131558567));
      localHashMap.put("layout/activity_light_strip_user_guide_0", Integer.valueOf(2131558568));
      localHashMap.put("layout/activity_lighting_effect_debug_0", Integer.valueOf(2131558569));
      localInteger = Integer.valueOf(2131558571);
      localHashMap.put("layout/activity_line_crossing_region_setting_0", localInteger);
      localHashMap.put("layout-land/activity_line_crossing_region_setting_0", localInteger);
      localHashMap.put("layout/activity_line_crossing_schedule_setting_0", Integer.valueOf(2131558572));
      localHashMap.put("layout/activity_memories_filter_0", Integer.valueOf(2131558579));
      localHashMap.put("layout/activity_memories_image_0", Integer.valueOf(2131558580));
      localHashMap.put("layout/activity_memories_video_0", Integer.valueOf(2131558581));
      localHashMap.put("layout/activity_mode_detect_setting_0", Integer.valueOf(2131558582));
      localHashMap.put("layout/activity_motion_detection_0", Integer.valueOf(2131558584));
      localInteger = Integer.valueOf(2131558585);
      localHashMap.put("layout-land/activity_motion_region_setting_0", localInteger);
      localHashMap.put("layout/activity_motion_region_setting_0", localInteger);
      localHashMap.put("layout/activity_msg_push_0", Integer.valueOf(2131558586));
      localHashMap.put("layout/activity_osd_new_ipc_0", Integer.valueOf(2131558595));
      localHashMap.put("layout/activity_playback_new_ipc_0", Integer.valueOf(2131558598));
      localHashMap.put("layout/activity_plug_electricity_statistic_0", Integer.valueOf(2131558606));
      localHashMap.put("layout/activity_plug_power_statistic_0", Integer.valueOf(2131558608));
      localHashMap.put("layout/activity_privacy_mask_0", Integer.valueOf(2131558615));
      localInteger = Integer.valueOf(2131558616);
      localHashMap.put("layout/activity_privacy_mask_zones_0", localInteger);
      localHashMap.put("layout-land/activity_privacy_mask_zones_0", localInteger);
      localHashMap.put("layout/activity_privacy_mode_0", Integer.valueOf(2131558617));
      localHashMap.put("layout/activity_qs_plug_icon_select_icon_0", Integer.valueOf(2131558626));
      localHashMap.put("layout/activity_record_audio_setting_0", Integer.valueOf(2131558632));
      localHashMap.put("layout/activity_schedule_edit_0", Integer.valueOf(2131558640));
      localHashMap.put("layout/activity_schedule_setting_0", Integer.valueOf(2131558643));
      localHashMap.put("layout/activity_select_device_0", Integer.valueOf(2131558647));
      localHashMap.put("layout/activity_sensor_detail_0", Integer.valueOf(2131558648));
      localHashMap.put("layout/activity_sensor_detail_bottom_0", Integer.valueOf(2131558649));
      localHashMap.put("layout/activity_sensor_detail_content_0", Integer.valueOf(2131558650));
      localHashMap.put("layout/activity_sensor_set_report_interval_0", Integer.valueOf(2131558652));
      localHashMap.put("layout/activity_sensor_set_sensitivity_0", Integer.valueOf(2131558653));
      localHashMap.put("layout/activity_sensor_settings_0", Integer.valueOf(2131558654));
      localHashMap.put("layout/activity_set_location_0", Integer.valueOf(2131558655));
      localHashMap.put("layout/activity_soft_ap_common_guide_0", Integer.valueOf(2131558664));
      localHashMap.put("layout/activity_soft_ap_reset_hint_0", Integer.valueOf(2131558665));
      localHashMap.put("layout/activity_store_manage_0", Integer.valueOf(2131558681));
      localHashMap.put("layout/activity_sub_g_on_boarding_0", Integer.valueOf(2131558682));
      localInteger = Integer.valueOf(2131558683);
      localHashMap.put("layout-land/activity_summary_clip_list_0", localInteger);
      localHashMap.put("layout/activity_summary_clip_list_0", localInteger);
      localHashMap.put("layout/activity_summary_history_0", Integer.valueOf(2131558684));
      localInteger = Integer.valueOf(2131558685);
      localHashMap.put("layout-land/activity_summary_play_0", localInteger);
      localHashMap.put("layout/activity_summary_play_0", localInteger);
      localHashMap.put("layout/activity_switch_set_delay_off_0", Integer.valueOf(2131558686));
      localHashMap.put("layout/activity_switch_set_double_click_0", Integer.valueOf(2131558687));
      localHashMap.put("layout/activity_tapo_debug_0", Integer.valueOf(2131558688));
      localHashMap.put("layout/activity_target_track_0", Integer.valueOf(2131558689));
      localHashMap.put("layout/activity_time_zone_new_ipc_0", Integer.valueOf(2131558690));
      localHashMap.put("layout/activity_trv_early_start_0", Integer.valueOf(2131558693));
      localHashMap.put("layout/activity_trv_set_child_protection_0", Integer.valueOf(2131558694));
      localHashMap.put("layout/activity_trv_set_frost_protection_0", Integer.valueOf(2131558695));
      localHashMap.put("layout/activity_trv_set_progress_calibration_0", Integer.valueOf(2131558696));
      localHashMap.put("layout/activity_trv_set_remove_scale_0", Integer.valueOf(2131558697));
      localHashMap.put("layout/activity_trv_set_shutdown_mode_0", Integer.valueOf(2131558698));
      localHashMap.put("layout/activity_trv_set_temperature_range_0", Integer.valueOf(2131558699));
      localHashMap.put("layout/activity_trv_set_temperature_unit_0", Integer.valueOf(2131558700));
      localHashMap.put("layout/activity_trv_set_window_open_0", Integer.valueOf(2131558701));
      localHashMap.put("layout/activity_trv_temperature_record_0", Integer.valueOf(2131558702));
      localHashMap.put("layout/activity_upnp_setting_0", Integer.valueOf(2131558704));
      localHashMap.put("layout/activity_video_play_new_ipc_0", Integer.valueOf(2131558706));
      localHashMap.put("layout/activity_video_quality_0", Integer.valueOf(2131558707));
      localHashMap.put("layout/activity_white_lamp_config_0", Integer.valueOf(2131558711));
      localHashMap.put("layout/dialog_format_process_0", Integer.valueOf(2131558788));
      localHashMap.put("layout/dialog_home_away_mode_loading_0", Integer.valueOf(2131558793));
      localHashMap.put("layout/dialog_int_range_picker_0", Integer.valueOf(2131558798));
      localHashMap.put("layout/dialog_mark_position_confirm_0", Integer.valueOf(2131558804));
      localHashMap.put("layout/dialog_memory_bottom_operation_0", Integer.valueOf(2131558806));
      localHashMap.put("layout/dialog_memory_slide_operation_0", Integer.valueOf(2131558808));
      localHashMap.put("layout/dialog_microphone_control_0", Integer.valueOf(2131558809));
      localHashMap.put("layout/dialog_multi_live_drag_0", Integer.valueOf(2131558810));
      localHashMap.put("layout/dialog_music_rhythm_color_picker_sheet_0", Integer.valueOf(2131558813));
      localHashMap.put("layout/dialog_music_rhythm_flowing_beam_mode_setting_sheet_0", Integer.valueOf(2131558814));
      localHashMap.put("layout/dialog_music_rhythm_light_strength_sheet_0", Integer.valueOf(2131558815));
      localHashMap.put("layout/dialog_music_rhythm_power_mode_setting_sheet_0", Integer.valueOf(2131558816));
      localHashMap.put("layout/dialog_select_device_0", Integer.valueOf(2131558821));
      localHashMap.put("layout/dialog_volume_control_0", Integer.valueOf(2131558830));
      localHashMap.put("layout/dialog_volume_control_full_screen_0", Integer.valueOf(2131558831));
      localHashMap.put("layout/exo_playback_control_view_0", Integer.valueOf(2131558837));
      localHashMap.put("layout/fragment_abstract_featured_action_0", Integer.valueOf(2131558853));
      localHashMap.put("layout/fragment_abstract_featured_action_choose_0", Integer.valueOf(2131558854));
      localHashMap.put("layout/fragment_bottom_scroll_picker_0", Integer.valueOf(2131558857));
      localHashMap.put("layout/fragment_button_featured_actions_0", Integer.valueOf(2131558858));
      localHashMap.put("layout/fragment_button_featured_actions_guide_0", Integer.valueOf(2131558859));
      localHashMap.put("layout/fragment_button_replace_battery_0", Integer.valueOf(2131558860));
      localHashMap.put("layout/fragment_camera_auto_update_hint_0", Integer.valueOf(2131558861));
      localHashMap.put("layout/fragment_camera_connect_router_0", Integer.valueOf(2131558862));
      localHashMap.put("layout/fragment_camera_connect_type_0", Integer.valueOf(2131558863));
      localHashMap.put("layout/fragment_camera_control_0", Integer.valueOf(2131558864));
      localHashMap.put("layout/fragment_camera_trigger_0", Integer.valueOf(2131558865));
      localHashMap.put("layout/fragment_camera_v2_before_install_0", Integer.valueOf(2131558866));
      localHashMap.put("layout/fragment_camera_v2_cannot_find_wifi_0", Integer.valueOf(2131558867));
      localHashMap.put("layout/fragment_camera_v2_check_status_0", Integer.valueOf(2131558868));
      localHashMap.put("layout/fragment_camera_v2_complete_0", Integer.valueOf(2131558869));
      localHashMap.put("layout/fragment_camera_v2_configured_before_0", Integer.valueOf(2131558870));
      localHashMap.put("layout/fragment_camera_v2_connect_ap_0", Integer.valueOf(2131558871));
      localHashMap.put("layout/fragment_camera_v2_connect_to_pair_0", Integer.valueOf(2131558872));
      localHashMap.put("layout/fragment_camera_v2_connecting_0", Integer.valueOf(2131558873));
      localHashMap.put("layout/fragment_camera_v2_identify_0", Integer.valueOf(2131558874));
      localHashMap.put("layout/fragment_camera_v2_input_pwd_0", Integer.valueOf(2131558875));
      localHashMap.put("layout/fragment_camera_v2_install_guide_0", Integer.valueOf(2131558876));
      localHashMap.put("layout/fragment_camera_v2_install_guide_item_layout_0", Integer.valueOf(2131558877));
      localHashMap.put("layout/fragment_camera_v2_install_guide_waterproof_layout_0", Integer.valueOf(2131558878));
      localHashMap.put("layout/fragment_camera_v2_install_helpful_items_0", Integer.valueOf(2131558879));
      localHashMap.put("layout/fragment_camera_v2_install_preview_0", Integer.valueOf(2131558880));
      localHashMap.put("layout/fragment_camera_v2_instruction_0", Integer.valueOf(2131558881));
      localHashMap.put("layout/fragment_camera_v2_introduce_tapo_care_0", Integer.valueOf(2131558882));
      localHashMap.put("layout/fragment_camera_v2_introduce_videoplay_item_0", Integer.valueOf(2131558883));
      localHashMap.put("layout/fragment_camera_v2_location_permission_0", Integer.valueOf(2131558884));
      localHashMap.put("layout/fragment_camera_v2_location_set_0", Integer.valueOf(2131558885));
      localHashMap.put("layout/fragment_camera_v2_manual_input_pwd_0", Integer.valueOf(2131558886));
      localHashMap.put("layout/fragment_camera_v2_name_0", Integer.valueOf(2131558887));
      localHashMap.put("layout/fragment_camera_v2_not_found_0", Integer.valueOf(2131558888));
      localHashMap.put("layout/fragment_camera_v2_pairing_failed_0", Integer.valueOf(2131558891));
      localHashMap.put("layout/fragment_camera_v2_permission_0", Integer.valueOf(2131558892));
      localHashMap.put("layout/fragment_camera_v2_rescan_wifi_0", Integer.valueOf(2131558893));
      localHashMap.put("layout/fragment_camera_v2_reset_0", Integer.valueOf(2131558894));
      localHashMap.put("layout/fragment_camera_v2_room_custom_0", Integer.valueOf(2131558895));
      localHashMap.put("layout/fragment_camera_v2_room_select_0", Integer.valueOf(2131558896));
      localHashMap.put("layout/fragment_camera_v2_save_setting_0", Integer.valueOf(2131558897));
      localHashMap.put("layout/fragment_camera_v2_sd_hint_0", Integer.valueOf(2131558898));
      localHashMap.put("layout/fragment_camera_v2_search_after_setup_0", Integer.valueOf(2131558899));
      localHashMap.put("layout/fragment_camera_v2_ssid_list_0", Integer.valueOf(2131558900));
      localHashMap.put("layout/fragment_camera_v2_trouble_shooting_0", Integer.valueOf(2131558901));
      localHashMap.put("layout/fragment_camera_v2_wifi_list_0", Integer.valueOf(2131558902));
      localHashMap.put("layout/fragment_camera_wired_complete_0", Integer.valueOf(2131558903));
      localHashMap.put("layout/fragment_camera_wired_connect_ap_0", Integer.valueOf(2131558904));
      localHashMap.put("layout/fragment_camera_wired_connecting_0", Integer.valueOf(2131558905));
      localHashMap.put("layout/fragment_camera_wired_set_wireless_failed_0", Integer.valueOf(2131558906));
      localHashMap.put("layout/fragment_cloud_password_check_0", Integer.valueOf(2131558908));
      localHashMap.put("layout/fragment_cloud_terrace_control_0", Integer.valueOf(2131558910));
      localHashMap.put("layout/fragment_cloud_terrace_preset_0", Integer.valueOf(2131558911));
      localHashMap.put("layout/fragment_color_light_setting_0", Integer.valueOf(2131558912));
      localHashMap.put("layout/fragment_color_picker_dialog_0", Integer.valueOf(2131558913));
      localHashMap.put("layout/fragment_color_temperature_setting_0", Integer.valueOf(2131558914));
      localHashMap.put("layout/fragment_contact_sensor_replace_battery_0", Integer.valueOf(2131558915));
      localHashMap.put("layout/fragment_device_password_check_0", Integer.valueOf(2131558916));
      localHashMap.put("layout/fragment_device_password_setting_0", Integer.valueOf(2131558917));
      localHashMap.put("layout/fragment_device_trigger_container_0", Integer.valueOf(2131558919));
      localHashMap.put("layout/fragment_device_trigger_single_choice_0", Integer.valueOf(2131558920));
      localHashMap.put("layout/fragment_dialog_get_lost_0", Integer.valueOf(2131558921));
      localHashMap.put("layout/fragment_firmware_check_0", Integer.valueOf(2131558922));
      localHashMap.put("layout/fragment_firmware_update_new_ipc_0", Integer.valueOf(2131558923));
      localHashMap.put("layout/fragment_guard_mode_config_0", Integer.valueOf(2131558926));
      localHashMap.put("layout/fragment_guard_mode_recyclerview_list_0", Integer.valueOf(2131558927));
      localHashMap.put("layout/fragment_guard_mode_set_alarm_time_0", Integer.valueOf(2131558928));
      localHashMap.put("layout/fragment_light_strip_light_effects_0", Integer.valueOf(2131558931));
      localHashMap.put("layout/fragment_light_strip_light_settings_0", Integer.valueOf(2131558932));
      localHashMap.put("layout/fragment_light_strip_light_settings_dialog_0", Integer.valueOf(2131558933));
      localHashMap.put("layout/fragment_light_strip_schedule_0", Integer.valueOf(2131558934));
      localHashMap.put("layout/fragment_motion_sensor_replace_battery_0", Integer.valueOf(2131558937));
      localHashMap.put("layout/fragment_multi_live_video_0", Integer.valueOf(2131558938));
      localHashMap.put("layout/fragment_operation_shell_0", Integer.valueOf(2131558940));
      localHashMap.put("layout/fragment_photos_0", Integer.valueOf(2131558941));
      localHashMap.put("layout/fragment_play_back_control_0", Integer.valueOf(2131558942));
      localHashMap.put("layout/fragment_play_back_video_0", Integer.valueOf(2131558943));
      localHashMap.put("layout/fragment_plug_energy_monitor_0", Integer.valueOf(2131558944));
      localHashMap.put("layout/fragment_rate_us_dialog_0", Integer.valueOf(2131558948));
      localHashMap.put("layout/fragment_record_type_dialog_0", Integer.valueOf(2131558949));
      localHashMap.put("layout/fragment_sub_g_complete_0", Integer.valueOf(2131558963));
      localHashMap.put("layout/fragment_sub_g_hub_empty_0", Integer.valueOf(2131558964));
      localHashMap.put("layout/fragment_sub_g_hub_firmware_update_0", Integer.valueOf(2131558965));
      localHashMap.put("layout/fragment_sub_g_hub_list_0", Integer.valueOf(2131558966));
      localHashMap.put("layout/fragment_sub_g_no_found_0", Integer.valueOf(2131558967));
      localHashMap.put("layout/fragment_sub_g_save_setting_0", Integer.valueOf(2131558968));
      localHashMap.put("layout/fragment_sub_g_searching_device_0", Integer.valueOf(2131558969));
      localHashMap.put("layout/fragment_sub_g_setup_avatar_0", Integer.valueOf(2131558970));
      localHashMap.put("layout/fragment_sub_g_setup_location_custom_0", Integer.valueOf(2131558971));
      localHashMap.put("layout/fragment_sub_g_setup_location_select_0", Integer.valueOf(2131558972));
      localHashMap.put("layout/fragment_sub_g_setup_name_0", Integer.valueOf(2131558973));
      localHashMap.put("layout/fragment_subg_enable_pairing_mode_0", Integer.valueOf(2131558974));
      localHashMap.put("layout/fragment_subg_led_not_blinking_help_0", Integer.valueOf(2131558975));
      localHashMap.put("layout/fragment_subg_power_up_device_0", Integer.valueOf(2131558976));
      localHashMap.put("layout/fragment_subg_remove_cover_0", Integer.valueOf(2131558977));
      localHashMap.put("layout/fragment_subg_switch_how_to_install_0", Integer.valueOf(2131558978));
      localHashMap.put("layout/fragment_switch_quicksetup_guide_0", Integer.valueOf(2131558979));
      localHashMap.put("layout/fragment_switch_replace_battery_0", Integer.valueOf(2131558980));
      localHashMap.put("layout/fragment_talk_0", Integer.valueOf(2131558981));
      localHashMap.put("layout/fragment_task_device_control_container_0", Integer.valueOf(2131558982));
      localHashMap.put("layout/fragment_task_hub_control_0", Integer.valueOf(2131558983));
      localHashMap.put("layout/fragment_thermostat_control_0", Integer.valueOf(2131558984));
      localHashMap.put("layout/fragment_thermostat_trigger_0", Integer.valueOf(2131558985));
      localHashMap.put("layout/fragment_trv_error_trouble_shooting_0", Integer.valueOf(2131558986));
      localHashMap.put("layout/fragment_trv_replace_battery_0", Integer.valueOf(2131558987));
      localHashMap.put("layout/fragment_voice_call_0", Integer.valueOf(2131558989));
      localHashMap.put("layout/item_camera_cloud_terrace_position_info_0", Integer.valueOf(2131559001));
      localHashMap.put("layout/item_camera_location_0", Integer.valueOf(2131559002));
      localHashMap.put("layout/item_camera_preview_0", Integer.valueOf(2131559003));
      localHashMap.put("layout/item_camera_preview_sort_0", Integer.valueOf(2131559004));
      localHashMap.put("layout/item_camera_select_device_0", Integer.valueOf(2131559005));
      localHashMap.put("layout/item_camera_select_device_full_screen_0", Integer.valueOf(2131559006));
      localHashMap.put("layout/item_camera_ssid_layout_0", Integer.valueOf(2131559007));
      localHashMap.put("layout/item_camera_wifi_other_item_0", Integer.valueOf(2131559008));
      localHashMap.put("layout/item_cloud_terrace_mark_position_0", Integer.valueOf(2131559009));
      localHashMap.put("layout/item_feature_grid_0", Integer.valueOf(2131559030));
      localHashMap.put("layout/item_featured_action_choose_0", Integer.valueOf(2131559031));
      localHashMap.put("layout/item_home_away_mode_fail_0", Integer.valueOf(2131559039));
      localHashMap.put("layout/item_hub_sub_device_card_0", Integer.valueOf(2131559045));
      localHashMap.put("layout/item_mode_add_camera_0", Integer.valueOf(2131559056));
      localHashMap.put("layout/item_mode_setting_0", Integer.valueOf(2131559057));
      localHashMap.put("layout/item_multi_live_0", Integer.valueOf(2131559059));
      localHashMap.put("layout/item_region_list_content_0", Integer.valueOf(2131559073));
      localHashMap.put("layout/item_region_list_title_0", Integer.valueOf(2131559074));
      localHashMap.put("layout/item_summary_clip_title_0", Integer.valueOf(2131559088));
      localHashMap.put("layout/item_summary_clip_video_0", Integer.valueOf(2131559089));
      localHashMap.put("layout/item_summary_history_0", Integer.valueOf(2131559090));
      localHashMap.put("layout/item_summary_home_0", Integer.valueOf(2131559091));
      localHashMap.put("layout/layout_camera_menu_button_0", Integer.valueOf(2131559103));
      localHashMap.put("layout/layout_camera_menu_button_day_night_mode_0", Integer.valueOf(2131559104));
      localHashMap.put("layout/layout_camera_menu_button_white_lamp_0", Integer.valueOf(2131559105));
      localHashMap.put("layout/layout_camera_menu_definition_0", Integer.valueOf(2131559106));
      localHashMap.put("layout/layout_camera_menu_infrared_0", Integer.valueOf(2131559107));
      localHashMap.put("layout/layout_camera_menu_settings_0", Integer.valueOf(2131559108));
      localHashMap.put("layout/layout_daily_summary_settings_0", Integer.valueOf(2131559119));
      localHashMap.put("layout/layout_day_night_mode_0", Integer.valueOf(2131559120));
      localHashMap.put("layout/layout_full_screen_bottom_bar_0", Integer.valueOf(2131559154));
      localHashMap.put("layout/layout_full_screen_control_0", Integer.valueOf(2131559155));
      localHashMap.put("layout/layout_full_screen_quality_0", Integer.valueOf(2131559156));
      localHashMap.put("layout/layout_hub_guard_mode_guide_0", Integer.valueOf(2131559163));
      localHashMap.put("layout/layout_light_strip_controller_0", Integer.valueOf(2131559170));
      localHashMap.put("layout/layout_light_strip_detail_bg_0", Integer.valueOf(2131559171));
      localHashMap.put("layout/layout_light_strip_detail_bottom_ext_0", Integer.valueOf(2131559172));
      localHashMap.put("layout/layout_light_strip_detail_content_ext_0", Integer.valueOf(2131559173));
      localHashMap.put("layout/layout_light_strip_guide_page_0", Integer.valueOf(2131559174));
      localHashMap.put("layout/layout_light_strip_settings_feature_ext_0", Integer.valueOf(2131559175));
      localHashMap.put("layout/layout_light_strip_settings_other_ext_0", Integer.valueOf(2131559176));
      localHashMap.put("layout/layout_lighting_effect_preset_0", Integer.valueOf(2131559177));
      localHashMap.put("layout/layout_multi_live_toolbar_bottom_0", Integer.valueOf(2131559181));
      localHashMap.put("layout/layout_palyback_full_bottom_0", Integer.valueOf(2131559190));
      localHashMap.put("layout/layout_play_back_fullscreen_calendar_0", Integer.valueOf(2131559193));
      localHashMap.put("layout/layout_play_back_fullscreen_filter_0", Integer.valueOf(2131559194));
      localHashMap.put("layout/layout_playback_toolbar_bottom_0", Integer.valueOf(2131559198));
      localHashMap.put("layout/layout_playback_toolbar_popup_0", Integer.valueOf(2131559199));
      localHashMap.put("layout/layout_playback_toolbar_top_0", Integer.valueOf(2131559200));
      localHashMap.put("layout/layout_select_report_interval_0", Integer.valueOf(2131559214));
      localHashMap.put("layout/layout_summary_time_axis_0", Integer.valueOf(2131559233));
      localHashMap.put("layout/layout_switch_detail_bottom_ext_0", Integer.valueOf(2131559235));
      localHashMap.put("layout/layout_switch_detail_content_ext_0", Integer.valueOf(2131559236));
      localHashMap.put("layout/layout_switch_settings_feature_ext_0", Integer.valueOf(2131559237));
      localHashMap.put("layout/layout_temperature_seekbar_0", Integer.valueOf(2131559238));
      localHashMap.put("layout/layout_trv_detail_bottom_ext_0", Integer.valueOf(2131559239));
      localHashMap.put("layout/layout_trv_detail_content_ext_0", Integer.valueOf(2131559240));
      localHashMap.put("layout/layout_trv_one_select_settings_0", Integer.valueOf(2131559241));
      localHashMap.put("layout/layout_trv_settings_feature_ext_0", Integer.valueOf(2131559242));
      localHashMap.put("layout/layout_various_image_view_0", Integer.valueOf(2131559243));
      localHashMap.put("layout/layout_voice_talk_panel_0", Integer.valueOf(2131559244));
      localHashMap.put("layout/menu_save_0", Integer.valueOf(2131559272));
      localHashMap.put("layout/mode_setting_footer_view_0", Integer.valueOf(2131559273));
      localHashMap.put("layout/play_back_bottom_bar_0", Integer.valueOf(2131559327));
      localHashMap.put("layout/play_back_date_selector_0", Integer.valueOf(2131559328));
      localHashMap.put("layout/play_back_ruler_layout_0", Integer.valueOf(2131559329));
      localHashMap.put("layout/play_back_time_ruler_0", Integer.valueOf(2131559330));
      localHashMap.put("layout/play_back_top_bar_0", Integer.valueOf(2131559331));
      localHashMap.put("layout/view_cloud_terrace_control_sensitivity_panel_0", Integer.valueOf(2131559405));
      localHashMap.put("layout/view_founded_device_item_0", Integer.valueOf(2131559420));
      localHashMap.put("layout/view_multi_features_grid_0", Integer.valueOf(2131559432));
      localHashMap.put("layout/view_preview_display_0", Integer.valueOf(2131559436));
      localHashMap.put("layout/view_video_surface_layout_0", Integer.valueOf(2131559451));
      localHashMap.put("layout/widget_tips_bar_0", Integer.valueOf(2131559457));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\DataBinderMapperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */