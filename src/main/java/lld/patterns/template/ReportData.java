package lld.patterns.template;

import java.util.List;
import java.util.Map;

public interface ReportData {
    List<Map<String, Object>> getRows();
    List<String> getHeaders();
}
