package lld.patterns.template;

public abstract class AbstractReportExporter {
    public final void exportReport(ReportData data, String filePath) {
        prepareData(data);
        openFile(filePath);
        writeHeader(data);
        writeDataRows(data);
        writeFooter(data);
        closeFile(filePath);
        System.out.println("Export complete: " + filePath);
    }

    protected void prepareData(ReportData data) {
        System.out.println("Preparing report data...");
    }

    protected void openFile(String filePath) {
        System.out.println("Opening file: " + filePath);
    }

    protected abstract void writeHeader(ReportData data);

    protected abstract void writeDataRows(ReportData data);

    protected void writeFooter(ReportData data) {

    }

    protected void closeFile(String filePath) {
        System.out.println("Closing file: " + filePath);
    }
}
