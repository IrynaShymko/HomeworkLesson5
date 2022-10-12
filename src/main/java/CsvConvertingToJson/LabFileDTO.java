package CsvConvertingToJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabFileDTO {

    private String cik;
    private String met;
    private String entityName;
    private String street1;
    private String street2;
    private String city;
    private String stateCode;
    private String zip;
    private String fillingDate;
    private String docTypeCode;

    public static void convertCsvToJson(String filePath) throws IOException {
        String headersForJson = "cik, aaa, met, entityName, street1, street2, city, stateCode, zip, fillingDate, docTypeCode, id\n";

        File original = new File(filePath);
        String pathToCopiedFile = "src/main/resources/draftCsv.csv";
        File copied = new File(pathToCopiedFile);
        String pathToConvertedFile = "src/main/resources/resultOfConvertingFromCsvToJson.json";
        RandomAccessFile randomAccessFile = new RandomAccessFile(copied, "rw");

        createDraftCsvForConvertingToJson(original, copied);
        changeHeadersInDraftCsv(randomAccessFile, headersForJson);
        doConvertationToJson(copied,pathToConvertedFile);

//       cleaning
        randomAccessFile.close();
        FileUtils.forceDelete(copied); //delete copied file
        System.out.println("Path to result file - "+ pathToConvertedFile);
    }

    public static void createDraftCsvForConvertingToJson(File original, File copied) throws IOException {
        FileUtils.copyFile(original, copied);
    }

    private static void changeHeadersInDraftCsv( RandomAccessFile randomAccessFile,String headersForJson) throws IOException {
        randomAccessFile.writeBytes(headersForJson);
    }

    private static void doConvertationToJson(File draft, String pathToConvertedFile) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<LabFileDTO> humanExIterator = csvMapper.readerFor(LabFileDTO.class)
                .with(orderLineSchema)
                .readValues(draft);
        new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .writeValue(new File(pathToConvertedFile), humanExIterator.readAll());
    }

}
