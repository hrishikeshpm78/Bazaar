package com.example.merchant.entity;

import java.io.Serializable;

public class MSPIdClass implements Serializable {
    private int mId;
    private int pId;

    public MSPIdClass(int mId, int pId) {
        this.mId = mId;
        this.pId = pId;
    }

    public MSPIdClass() {
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
}
