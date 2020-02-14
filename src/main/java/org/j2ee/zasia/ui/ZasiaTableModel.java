package org.j2ee.zasia.ui;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class ZasiaTableModel extends AbstractTableModel {

    Vector<Vector<Object>> rowData = new Vector<>();
    private Vector<Object> columnNames = new Vector<>();

    public ZasiaTableModel() {
        columnNames.add("");
        columnNames.add("序号");
        columnNames.add("编号");
        columnNames.add("来信主题");
        columnNames.add("来源");
        columnNames.add("受理/分配部门");
        columnNames.add("转发时间");
        columnNames.add("状态");
        columnNames.add("操作");
        rowData.add(columnNames);
    }

    @Override
    public int getRowCount() {
        return rowData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int col) {
        return (String) columnNames.get(col);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rowData.get(rowIndex).get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col >= 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        rowData.get(row).set(col, value);
        fireTableCellUpdated(row, col);

    }

}
