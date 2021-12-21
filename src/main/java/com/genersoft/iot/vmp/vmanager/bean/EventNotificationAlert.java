package com.genersoft.iot.vmp.vmanager.bean;

/**
 * @author chenlw
 * @date 2021/12/20 6:58 下午
 */
public class EventNotificationAlert {
    /**
     * <EventNotificationAlert version="1.0" xmlns="urn:psialliance-org">
     * <ipAddress>192.168.2.240</ipAddress>
     * <protocol>HTTP</protocol>
     * <macAddress>10:12:fb:80:d4:f6</macAddress>
     * <channelID>1</channelID>
     * <dateTime>2021-12-20T18:55:00+08:00</dateTime>
     * <activePostCount>1664</activePostCount>
     * <eventType>VMD</eventType>
     * <eventState>active</eventState>
     * <eventDescription>Motion alarm</eventDescription>
     * <channelName>98</channelName>
     * <Extensions version="1.0" xmlns="urn:psialliance-org">
     * <serialNumber>DS-2XA824E-FS20200803AACHE65917363</serialNumber>
     * <eventPush>VMD&amp;&amp;DS-2XA824E-FS20200803AACHE65917363,2021-12-20T18:55:00+08:00,1,1.0</eventPush>
     * </Extensions>
     * </EventNotificationAlert>
     */
    public String ipAddress;
    public String protocol;
    public String macAddress;
    public String channelID;
    public String channelName;
    public String dateTime;
    public Integer activePostCount;
    public String eventType;
    public String eventState;
    public String eventDescription;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getActivePostCount() {
        return activePostCount;
    }

    public void setActivePostCount(Integer activePostCount) {
        this.activePostCount = activePostCount;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventState() {
        return eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public String toString() {
        return "EventNotificationAlert{" +
                "ipAddress='" + ipAddress + '\'' +
                ", protocol='" + protocol + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", channelID='" + channelID + '\'' +
                ", channelName='" + channelName + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", activePostCount=" + activePostCount +
                ", eventType='" + eventType + '\'' +
                ", eventState='" + eventState + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }
}
