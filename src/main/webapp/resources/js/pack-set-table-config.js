function setUpPackSetsTable(table) {
    setUpSetPackTableSettings(table);
    table.attachEvent("onRowDblClicked", function (rId, cInd) {
        window.open('/set/' + table.cells(rId, 0).getValue(), '_blank');
    });
}

let packSetTable = dhtmlXGridFromTable('k_pacs_set_table');
setUpPackSetsTable(packSetTable);