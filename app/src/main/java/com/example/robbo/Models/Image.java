package com.example.robbo.Models;

public class Image {
    private byte[] img;

    public Image(byte[] img) {
        this.img = img;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
