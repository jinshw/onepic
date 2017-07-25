package com.ykkj.weiyi.util;

public class ImageSize
{

    private int imgHeight;
    private int imgWidth;

    public ImageSize()
    {
    }

    /**
     * 设置图片的高
     * @param imgHeight 图片的高
     */
    public void setImageHeight(int imgHeight)
    {
        this.imgHeight = imgHeight;
    }

    /**
     * 获得图片的高
     * @return 图片的高
     */
    public int getImageHeight()
    {
        return imgHeight;
    }

    /**
     * 设置图片的宽
     * @param imgWidth 图片的宽
     */
    public void setImageWidth(int imgWidth)
    {
        this.imgWidth = imgWidth;
    }

    /**
     * 获得图片的宽
     * @return 图片的宽
     */
    public int getImageWidth()
    {
        return this.imgWidth;
    }
}