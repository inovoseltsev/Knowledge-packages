<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sets</title>
    <link
            href="<c:url value="/webjars/bootstrap/4.5.0/css/bootstrap.min.css"/>"
            type="text/css"
            rel="stylesheet">
    <link rel="stylesheet"
          href="<c:url value="http://cdn.dhtmlx.com/edge/dhtmlx.css"/>"
          type="text/css">
    <link rel="stylesheet"
          href="<c:url value="/resources/css/index.css"/>"
          type="text/css">
    <link rel="stylesheet"
          href="<c:url value="/resources/css/set.css"/>"
          type="text/css">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand"
           href="${pageContext.request.contextPath}/">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/kpacs">Kpacs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/sets">Sets</a>
                </li>
            </ul>
        </div>
    </nav>
</header>

<div class="table-container">
    <h1>Knowledge package sets</h1>
    <table class="dhtmlxGrid table table-bordered" id="k_pacs_set_table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="set" items="${sets}">
            <tr class="table-row">
                <td>${set.getId()}</td>
                <td>${set.getTitle()}</td>
                <td><a
                        href="/sets/deletion/${set.getId()}">
                    <button
                            class="btn btn-danger">Delete
                    </button>
                </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="add-btn-container">
        <div class="add-btn-wrapper">
            <button class="btn btn-primary" data-toggle="modal"
                    data-target="#modal-form" onclick="resetAddForm()">Add
            </button>
        </div>
    </div>
</div>

<div class="modal fade" id="modal-form" tabindex="-1" role="dialog"
     aria-labelledby="modalTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalTitle">Add
                    Package</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form name="meForm" id="changeForm"
                  action="${pageContext.request.contextPath}/sets"
                  method="post">
                <div class="modal-body">
                    <p>Please fill the form</p>

                    <label for="title"><b>Title</b></label>
                    <div class="form-group">
                        <input class="form-control form-control-sm" type="text"
                               id="title"
                               name="title" placeholder="Enter title"
                               required>
                    </div>

                    <label for="packNames"><b>Knowledge pacs</b></label>
                    <div class="form-group">
                        <input
                                class="form-control form-control-sm form-readonly"
                                type="text"
                                id="packNames"
                                readonly required>
                    </div>
                    <div class="form-group description-field">
                        <input type="hidden" name="packIdList" id="pacsId">
                        <div class="dropdown open">
                            <button class="btn btn-secondary dropdown-toggle"
                                    type="button" id="dropdownMenuButton"
                                    data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                Packages
                            </button>
                            <div class="dropdown-menu"
                                 aria-labelledby="dropdownMenuButton">
                                <c:forEach var="kpac" items="${kpacs}">
                                    <a class="dropdown-item"
                                       id="${kpac.getId()}"
                                       onclick="addToPackList(${kpac.getId()})">
                                            ${kpac.getTitle()}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" id="cancel-button"
                            name="cancel"
                            class="btn btn-secondary"
                            data-dismiss="modal">Close
                    </button>
                    <button id="formAddBtn" type="submit"
                            class="btn btn-primary">Add
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="<c:url value="https://code.jquery.com/jquery-3.4.1.slim.min.js"/>"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="<c:url
value="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"/>"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="<c:url value="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"/>"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/dhtmlx/grid/dhtmlxgrid.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/script.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/pack-set-table-config.js"
        type="text/javascript"></script>
</body>
</html>
