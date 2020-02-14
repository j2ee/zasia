package org.j2ee.zasia.model;

import lombok.Data;

@Data
public class ZasiaTask {

    private String url;
    private String dir;
    private String filename;
    private int threadNumber;

}
