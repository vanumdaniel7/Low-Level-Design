package lld.patterns.template;

import java.util.Map;

class PdfReportExporter extends AbstractReportExporter {
    @Override
    protected void writeHeader(ReportData data) {
        System.out.println("PDF: | " + String.join(" | ", data.getHeaders()) + " |");
        System.out.println("PDF: " + "-".repeat(40));
    }

    @Override
    protected void writeDataRows(ReportData data) {
        for (Map<String, Object> row : data.getRows()) {
            StringBuilder sb = new StringBuilder("PDF: | ");
            for (String header : data.getHeaders()) {
                sb.append(row.get(header)).append(" | ");
            }
            System.out.println(sb);
        }
    }

    @Override
    protected void writeFooter(ReportData data) {
        System.out.println("PDF: --- Page 1 of 1 ---");
    }
}
