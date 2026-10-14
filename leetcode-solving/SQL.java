class Table {
    int col;
    HashMap<Integer, List<String>> rows;
    int rowNo;
    public Table(int col) {
        this.col = col;
        this.rows = new HashMap<>();
        this.rowNo = 0;
    }
}
public class SQL {
    HashMap<String,Table> map = new HashMap<>();
    public SQL(List<String> names, List<Integer> columns) {
        int n = names.size();
        for(int i = 0; i < n; i++) {
            map.put(names.get(i), new Table(columns.get(i)));
        }
    }
    
    public boolean ins(String name, List<String> row) {
        if(map.containsKey(name)) {
            Table table = map.get(name);
            if(table.col != row.size()) {
                return false;
            }
            int rowNo = table.rowNo + 1;
            table.rows.put(rowNo,row);
            table.rowNo = rowNo;
            return true;
        }
        return false;
    }
    
    public void rmv(String name, int rowId) {
        if(map.containsKey(name)) {
            Table table = map.get(name);
            if(table.rows.containsKey(rowId)) {
                table.rows.remove(rowId);
            }
        }
    }
    
    public String sel(String name, int rowId, int columnId) {
        if(map.containsKey(name)) {
            Table table = map.get(name);
            if(table.rows.containsKey(rowId)) {
                List<String> row = table.rows.get(rowId);
                if(columnId <= row.size()) {
                    return row.get(columnId-1);
                }
            }
        }
        return "<null>";
    }
    
    public List<String> exp(String name) {
        List<String> csv = new ArrayList<>();
        if(map.containsKey(name)) {
            Table table = map.get(name);
            int maxInd = table.rowNo;
            for(int i = 1; i <= maxInd; i++) {
                if(table.rows.containsKey(i)) {
                    StringBuilder row = new StringBuilder();
                    row.append(i).append(',');
                    for(int j = 0; j < table.rows.get(i).size(); j++) {
                        row.append(table.rows.get(i).get(j)).append(',');
                    }
                    row.deleteCharAt(row.length()-1);
                    csv.add(row.toString());
                }
            }
        }
        return csv;
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * boolean param_1 = obj.ins(name,row);
 * obj.rmv(name,rowId);
 * String param_3 = obj.sel(name,rowId,columnId);
 * List<String> param_4 = obj.exp(name);
 */