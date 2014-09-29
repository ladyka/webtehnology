package org.vurtatoo.ptv6;

public class FileView {
    
    private String fileName;
    private String filePath;
    
    public FileView(String fileName, String filePath) {
        super();
        this.fileName = fileName;
        this.filePath = filePath;
    }
    public String getFileName() {
        return fileName;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    @Override
    public String toString() {
        return "FileView [fileName=" + fileName + ", filePath=" + filePath + "]";
    }

    
}
