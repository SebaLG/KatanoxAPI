package com.katanox.assessment.metavendors;


import java.util.HashMap;
import java.util.Map;

public enum MetaVendorType {
    PMS("PMS"), CRS("CRS"), CHANNEL_MANAGER("Channel Manager"), SWITCH("Switch"), OTHER("Other");

    public final String label;
    private static final Map<String, MetaVendorType> BY_LABEL = new HashMap<>();

    MetaVendorType(String label) {
        this.label = label;
    }

    //We can avoid iterating the enum values by using a Map to cache the labels
    static {
        for (MetaVendorType e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public static MetaVendorType valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
