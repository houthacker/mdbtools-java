package nl.coenbijlsma.mdbtools;

public class MDBFormat {

    private long pageSize;
    private int rowCountOffset;
    private int tableNumberOfRowsOffset;
    private int tableNumberOfColumnsOffset;
    private int tableNumberOfIndexesOffset;
    private int tablesNumberOfRIndexesOffset;
    private int tableUsageMapOffset;
    private int tableFirstDPageOffset;
    private int tableColumnsStartOffset;
    private int tableRIndexEntrySize;
    private int columnFixedOffset;
    private int columnSizeOffset;
    private int columnNumberOffset;
    private int tableColumnEntrySize;
    private int tableFreeMapOffset;
    private int tableColumnOffsetVar;
    private int tableColumnOffsetFixed;
    private int tableRowColumnNumberOffset;
    
    public static final MDBFormat VERSION4 = new MDBJet4Format();
    public static final MDBFormat VERSION3 = new MDBJet3Format();  
    
    public MDBFormat(){
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public int getRowCountOffset() {
        return rowCountOffset;
    }

    public void setRowCountOffset(int rowCountOffset) {
        this.rowCountOffset = rowCountOffset;
    }

    public int getTableNumberOfRowsOffset() {
        return tableNumberOfRowsOffset;
    }

    public void setTableNumberOfRowsOffset(int tableNumberOfRowsOffset) {
        this.tableNumberOfRowsOffset = tableNumberOfRowsOffset;
    }

    public int getTableNumberOfColumnsOffset() {
        return tableNumberOfColumnsOffset;
    }

    public void setTableNumberOfColumnsOffset(int tableNumberOfColumnsOffset) {
        this.tableNumberOfColumnsOffset = tableNumberOfColumnsOffset;
    }

    public int getTableNumberOfIndexesOffset() {
        return tableNumberOfIndexesOffset;
    }

    public void setTableNumberOfIndexesOffset(int tableNumberOfIndexesOffset) {
        this.tableNumberOfIndexesOffset = tableNumberOfIndexesOffset;
    }

    public int getTablesNumberOfRIndexesOffset() {
        return tablesNumberOfRIndexesOffset;
    }

    public void setTablesNumberOfRIndexesOffset(int tablesNumberOfRIndexesOffset) {
        this.tablesNumberOfRIndexesOffset = tablesNumberOfRIndexesOffset;
    }

    public int getTableUsageMapOffset() {
        return tableUsageMapOffset;
    }

    public void setTableUsageMapOffset(int tableUsageMapOffset) {
        this.tableUsageMapOffset = tableUsageMapOffset;
    }

    public int getTableFirstDPageOffset() {
        return tableFirstDPageOffset;
    }

    public void setTableFirstDPageOffset(int tableFirstDPageOffset) {
        this.tableFirstDPageOffset = tableFirstDPageOffset;
    }

    public int getTableColumnsStartOffset() {
        return tableColumnsStartOffset;
    }

    public void setTableColumnsStartOffset(int tableColumnsStartOffset) {
        this.tableColumnsStartOffset = tableColumnsStartOffset;
    }

    public int getTableRIndexEntrySize() {
        return tableRIndexEntrySize;
    }

    public void setTableRIndexEntrySize(int tableRIndexEntrySize) {
        this.tableRIndexEntrySize = tableRIndexEntrySize;
    }

    public int getColumnFixedOffset() {
        return columnFixedOffset;
    }

    public void setColumnFixedOffset(int columnFixedOffset) {
        this.columnFixedOffset = columnFixedOffset;
    }

    public int getColumnSizeOffset() {
        return columnSizeOffset;
    }

    public void setColumnSizeOffset(int columnSizeOffset) {
        this.columnSizeOffset = columnSizeOffset;
    }

    public int getColumnNumberOffset() {
        return columnNumberOffset;
    }

    public void setColumnNumberOffset(int columnNumberOffset) {
        this.columnNumberOffset = columnNumberOffset;
    }

    public int getTableColumnEntrySize() {
        return tableColumnEntrySize;
    }

    public void setTableColumnEntrySize(int tableColumnEntrySize) {
        this.tableColumnEntrySize = tableColumnEntrySize;
    }

    public int getTableFreeMapOffset() {
        return tableFreeMapOffset;
    }

    public void setTableFreeMapOffset(int tableFreeMapOffset) {
        this.tableFreeMapOffset = tableFreeMapOffset;
    }

    public int getTableColumnOffsetVar() {
        return tableColumnOffsetVar;
    }

    public void setTableColumnOffsetVar(int tableColumnOffsetVar) {
        this.tableColumnOffsetVar = tableColumnOffsetVar;
    }

    public int getTableColumnOffsetFixed() {
        return tableColumnOffsetFixed;
    }

    public void setTableColumnOffsetFixed(int tableColumnOffsetFixed) {
        this.tableColumnOffsetFixed = tableColumnOffsetFixed;
    }

    public int getTableRowColumnNumberOffset() {
        return tableRowColumnNumberOffset;
    }

    public void setTableRowColumnNumberOffset(int tableRowColumnNumberOffset) {
        this.tableRowColumnNumberOffset = tableRowColumnNumberOffset;
    }
    
}

final class MDBJet4Format extends MDBFormat {
	
    MDBJet4Format(){
	super();
	setPageSize(4096);
	setRowCountOffset(0x0c);
	setTableNumberOfRowsOffset(16);
	setTableNumberOfColumnsOffset(45);
	setTableNumberOfIndexesOffset(47);
	setTablesNumberOfRIndexesOffset(51);
	setTableUsageMapOffset(55);
	setTableFirstDPageOffset(56);
	setTableColumnsStartOffset(63);
	setTableRIndexEntrySize(12);
	setColumnFixedOffset(15);
	setColumnSizeOffset(23);
	setColumnNumberOffset(5);
	setTableColumnEntrySize(25);
	setTableFreeMapOffset(59);
	setTableColumnOffsetVar(7);
	setTableColumnOffsetFixed(21);
	setTableRowColumnNumberOffset(9);
    }
}

final class MDBJet3Format extends MDBFormat {
  
    public MDBJet3Format() {
	super();
	setPageSize(2048);
	setRowCountOffset(0x08);
	setTableNumberOfRowsOffset(12);
	setTableNumberOfColumnsOffset(25);
	setTableNumberOfIndexesOffset(27);
	setTablesNumberOfRIndexesOffset(31);
	setTableUsageMapOffset(35);
	setTableFirstDPageOffset(36);
	setTableColumnsStartOffset(43);
	setTableRIndexEntrySize(8);
	setColumnFixedOffset(13);
	setColumnSizeOffset(16);
	setColumnNumberOffset(1);
	setTableColumnEntrySize(18);
	setTableFreeMapOffset(39);
	setTableColumnOffsetVar(3);
	setTableColumnOffsetFixed(14);
	setTableRowColumnNumberOffset(5);
    }
}
