package com.genersoft.iot.vmp.vmanager.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author chenlw
 * @date 2021/12/20 6:21 下午
 */
@JacksonXmlRootElement(localName = "Notify")
public class XMLElementNotify {
    /**
     * <? xmlversion="1.0"?>
     * <Notify>
     * <CmdType>Alarm</CmdType>
     * <SN>1</SN>
     * <DeviceID>64010000001340000001</DeviceID>
     * <AlarmPriority>4</AlarmPriority>
     * <AlarmMethod>2</AlarmMethod>
     * <AlarmTime>2009-12-04T16:23:32</AlarmTime>
     * <AlarmDescription>警情描述</AlarmDescription>
     * <Longitude>171.3</Longitude>
     * <Latitude>34.2</Latitude>
     * </Notify>
     */

    public String cmdType;
    public String sn;
    public String deviceID;
    public String alarmPriority;
    public String alarmMethod;
    public String alarmTime;
    public String alarmDescription;
    public String longitude;
    public String latitude;

    public String getCmdType() {
        return cmdType;
    }

    public void setCmdType(String cmdType) {
        this.cmdType = cmdType;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getAlarmPriority() {
        return alarmPriority;
    }

    public void setAlarmPriority(String alarmPriority) {
        this.alarmPriority = alarmPriority;
    }

    public String getAlarmMethod() {
        return alarmMethod;
    }

    public void setAlarmMethod(String alarmMethod) {
        this.alarmMethod = alarmMethod;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmDescription() {
        return alarmDescription;
    }

    public void setAlarmDescription(String alarmDescription) {
        this.alarmDescription = alarmDescription;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "XMLElementNotify{" +
                "cmdType='" + cmdType + '\'' +
                ", sn='" + sn + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", alarmPriority='" + alarmPriority + '\'' +
                ", alarmMethod='" + alarmMethod + '\'' +
                ", alarmTime='" + alarmTime + '\'' +
                ", alarmDescription='" + alarmDescription + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
