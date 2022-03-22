import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    ObjectMapper mapper;

    public Film[] parseJson(String path) throws IOException {
        mapper = new ObjectMapper();
        return mapper.readValue(new File(path), Film[].class);
    }
}
