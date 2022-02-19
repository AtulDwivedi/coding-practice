package com.atuldwivedi.codingpractice.design.patterns.structural.proxy.impl01;

/**
 * @author Atul Dwivedi
 */
public class ImageViewer {
    public static void main(String[] args) {
        //all three images are loaded into memory
        Image hrImg1 = new HighResolutionImage("/usr/lib/img/img01.JPEG");
        Image hrImg2 = new HighResolutionImage("/usr/lib/img/img02.JPEG");
        Image hrImg3 = new HighResolutionImage("/usr/lib/img/img03.JPEG");

        //but only one image is being utilized
        hrImg1.showImage();

        System.out.println("----");

        //on the other hand in case of Proxy Design Pattern
        //currently no image is loaded into memory
        Image imgProxy01 = new ImageProxy("/usr/lib/img/img01.JPEG");
        Image imgProxy02 = new ImageProxy("/usr/lib/img/img02.JPEG");
        Image imgProxy03 = new ImageProxy("/usr/lib/img/img03.JPEG");

        //now img01 image will be loaded and rendered
        imgProxy01.showImage();
    }
}
