package com.atuldwivedi.cp.design.patterns.structural.proxy.impl01;

/**
 * @author Atul Dwivedi
 */
public class ImageProxy implements Image {
    private String imagePath;
    private Image proxifiedImage;

    public ImageProxy(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void showImage() {
        proxifiedImage = new HighResolutionImage(imagePath);
        proxifiedImage.showImage();
    }
}
