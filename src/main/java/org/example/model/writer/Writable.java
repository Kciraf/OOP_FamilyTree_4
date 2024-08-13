package org.example.model.writer;

import java.io.Serializable;

public interface Writable {
    void write(Serializable serializable);
    Object read();
    void filePlace(String place);
}
