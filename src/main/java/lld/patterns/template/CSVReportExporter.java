package lld.patterns.template;

import java.util.Map;

class CSVReportExporter extends AbstractReportExporter {
    @Override
    protected void writeHeader(ReportData data) {
        System.out.println("CSV: " + String.join(",", data.getHeaders()));
    }

    @Override
    protected void writeDataRows(ReportData data) {
        for (Map<String, Object> row : data.getRows()) {
            StringBuilder sb = new StringBuilder();
            for (String header : data.getHeaders()) {
                if (sb.length() > 0) sb.append(",");
                sb.append(row.get(header));
            }
            System.out.println("CSV: " + sb);
        }
    }
}
