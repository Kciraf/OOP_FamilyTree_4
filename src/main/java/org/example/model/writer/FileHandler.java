package org.example.model.writer;

import java.io.*;

public class FileHandler implements Writable {
    private String fileplace = "src/main/java/org/example/file.txt";

    public void setFilePlace(String place){
        this.fileplace = place;
    }

    @Override
    public void write(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileplace))) {
            objectOutputStream.writeObject(serializable);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileplace))){
            Object file = objectInputStream.readObject();
            return file;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void filePlace(String place) {
        this.fileplace = fileplace;
    }
}
