function setUpPacksTable(table) {
    setUpCommonTableSettings(table);
    table.setInitWidths("200,200,200,200");
    table.attachHeader('#numeric_filter,#text_filter,#text_filter,#text_filter');
    table.setColTypes("ron,rotxt,rotxt,rotxt");
    table.setColSorting("int,str,str,date");
    table.setColWidth(0, "200");
    table.setColWidth(1, "200");
    table.setColWidth(2, "200");
    table.setColWidth(3, "200");
    table.setColWidth(4, "200");
}

let pacsTable = dhtmlXGridFromTable('k_pacs_table');
setUpPacksTable(pacsTable);