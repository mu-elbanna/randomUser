package com.eo.randomusers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Timezone  implements Serializable {
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("offset")
    private String offset;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
