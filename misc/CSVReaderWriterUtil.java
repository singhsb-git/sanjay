import com.gs.cft.digital.cftcustomerhub.application.complianceCustomerRefresh.model.CustomerRefreshRequest;
import com.gs.cft.digital.cftcustomerhub.application.complianceCustomerRefresh.model.CustomerRefreshStatus;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CSVReaderWriterUtil {
    public static List<CustomerRefreshRequest> getCustomerRefreshRequestsFromCVSBytes(byte[] bytes)
    throws Exception{
        InputStream is = new ByteArrayInputStream(bytes);
        Pattern pattern = Pattern.compile(",");
        BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        List<CustomerRefreshRequest> customerRefreshRequests =
                in.lines().map(line -> {
                    String[] x = pattern.split(line);
                    return new CustomerRefreshRequest(x[0]);
                }).collect(Collectors.toList());

        return customerRefreshRequests;

    }

    public static byte[] getCSVBytesFromCustomerRefreshStatus(
            List<CustomerRefreshStatus> customerRefreshStatusList) throws IOException {
        StringWriter writer = new StringWriter();
        ICsvBeanWriter beanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
        final String[] header = new String[] { "CustomerId", "Status"};
        final CellProcessor[] processors = getProcessors();

        // write the header
        beanWriter.writeHeader(header);

        // write the beans data
        for (CustomerRefreshStatus refreshStatus : customerRefreshStatusList) {
            beanWriter.write(refreshStatus, header, processors);
        }
        beanWriter.close();
        return writer.toString().getBytes();
    }

    public static void copyFileToPath(byte[] bytes, String filePath)
                                            throws IOException{
        Path path = Paths.get(filePath);
        Files.write(path, bytes);
    }

    private static CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // CustomerId
                new NotNull() // Status
        };
        return processors;
    }

}
