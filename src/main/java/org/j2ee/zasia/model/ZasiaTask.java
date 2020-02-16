package org.j2ee.zasia.model;

import lombok.Data;

@Data
public class ZasiaTask {

    private String downloadUrl;
    private String savePath;
    private String filename;
    private int threadCount;

}
