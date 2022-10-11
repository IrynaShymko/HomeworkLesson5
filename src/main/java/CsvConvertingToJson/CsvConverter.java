package CsvConvertingToJson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;

public class CsvConverter {
    public static void convertCsvToJson(String filePath) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<HumanExample> humanExIterator = csvMapper.readerFor(HumanExample.class)
                .with(orderLineSchema)
                .readValues(new File(filePath));
        new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .writeValue(new File("src/main/resources/resultOfConvertingFromCsvToJson.json"), humanExIterator.readAll());

    }
}
