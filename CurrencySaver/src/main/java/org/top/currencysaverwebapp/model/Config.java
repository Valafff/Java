package org.top.currencysaverwebapp.model;

import java.util.List;

public class Config {
    private boolean autostart;
    private int poll_interval;
    private List<String> service_urls;
    private List<String> api_keys;

    // Getters and setters
    public boolean isAutostart() {
        return autostart;
    }

    public void setAutostart(boolean autostart) {
        this.autostart = autostart;
    }

    public int getPoll_interval() {
        return poll_interval;
    }

    public void setPoll_interval(int poll_interval) {
        this.poll_interval = poll_interval;
    }

    public List<String> getService_urls() {
        return service_urls;
    }

    public void setService_urls(List<String> service_urls) {
        this.service_urls = service_urls;
    }

    public List<String> getApi_keys() {
        return api_keys;
    }

    public void setApi_keys(List<String> api_keys) {
        this.api_keys = api_keys;
    }
}
