package org.j2ee.zasia.enums;

public enum FileType {

    CLASS(".class"),
    DOC(".doc"),
    DOCX(".docx"),
    EXE(".exe"),
    GIF(".gif"),
    GZ(".gz"),
    ISO(".iso"),
    JAVA(".java"),
    JPG(".jpg"),
    MD(".md"),
    MSI(".msi"),
    PDF(".pdf"),
    PNG(".png"),
    PPT(".ppt"),
    RAR(".rar"),
    RPM(".rpm"),
    TAR(".tar"),
    TAR_GZ(".tar.gz"),
    TXT(".txt"),
    XLS(".xls"),
    XLSX(".xlsx"),
    XML(".xml"),
    ZIP(".zip"),
    ZZZZZZZ(".7z");

    private String suffix;

    private FileType(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public static FileType getFileType(String filename) {
        if (filename == null) {
            return null;
        }

        FileType[] fileTypes = FileType.values();
        for (int i = fileTypes.length - 1; i >= 0; i--) {
            if (filename.toLowerCase().endsWith(fileTypes[i].getSuffix())) {
                return fileTypes[i];
            }
        }

        return null;
    }

}
