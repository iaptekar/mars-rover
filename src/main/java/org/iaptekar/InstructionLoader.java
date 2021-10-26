package org.iaptekar;

import java.io.IOException;
import java.util.List;

public interface InstructionLoader {

    List<String> execute() throws IOException;
}