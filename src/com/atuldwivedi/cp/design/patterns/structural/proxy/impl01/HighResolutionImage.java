package com.atuldwivedi.cp.design.patterns.structural.proxy.impl01;

/**
 * @author Atul Dwivedi
 */
public class HighResolutionImage implements Image {

    public HighResolutionImage(String imagePath) {
        loadImage(imagePath);
    }

    private void loadImage(String imagePath) {
        System.out.println("Loading image from path: " + imagePath);
    }

    @Override
    public void showImage() {
        System.out.println("Rendering high resolution image.");
    }
}
