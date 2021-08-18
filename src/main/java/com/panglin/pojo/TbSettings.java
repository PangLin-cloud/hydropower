package com.panglin.pojo;

public class TbSettings {
    private String settings;

    private Double settingsValue;

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings == null ? null : settings.trim();
    }

    public Double getSettingsValue() {
        return settingsValue;
    }

    public void setSettingsValue(Double settingsValue) {
        this.settingsValue = settingsValue;
    }
}