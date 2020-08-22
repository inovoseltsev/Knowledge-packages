let packIdList = [];

function resetAddForm() {
    document.forms[0].reset();
    document.getElementById('packNames').value = '';
    packIdList = [];
    let pacs = document.getElementsByClassName('dropdown-item');
    for (const pac of pacs) {
        pac.style.display = "block";
    }
}

function addToPackList(id) {
    packIdList.push(id);
    document.getElementById('pacsId').value = packIdList;
    document.getElementById(id).style.display = 'none';
    showSelectedPacs(id);
}

const showSelectedPacs = (id) => {
    const selectedItemsPlace = document.getElementById('packNames');
    const selectedTitle = document.getElementById(id).innerText;
    let selectedItemsTitle = selectedItemsPlace.value;
    if (selectedItemsTitle.length > 0) {
        selectedItemsPlace.value += ', ' + selectedTitle.trim();
    } else {
        selectedItemsPlace.value = selectedTitle.trim();
    }
}

function setUpCommonTableSettings(table) {
    table.setEditable(false);
    table.setColAlign("center");
    table.enableAutoHeight(true);
    table.enableAutoWidth(true);
}

function setUpSetPackTableSettings(table) {
    setUpCommonTableSettings(table);
    table.attachHeader('#numeric_filter,#text_filter');
    table.setColTypes("ron,rotxt");
    table.setColSorting("int,str");
    table.setColWidth(0, "300");
    table.setColWidth(1, "300");
    table.setColWidth(2, "300");
}


