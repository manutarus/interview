<!DOCTYPE HTML>
<html xmlns:ng="http://angularjs.org">
<head>
    <title>Exams</title>


</head>

<body ng-app="studentMod">

<div id="header">
    <img src="resources/imgs/25888_116229138398995_4560197_a.png" alt="moi uni" width="90" height="90">

        MOI UNIVERSITY COLLAGE OF HEALTH SCIENCES SCHOOL OF MEDICINE


</div>


<div id="sidebar">
    <ng:include src="'resources/partials/side-list.html'"></ng:include>
</div>

<div id="content">
    <ng:view></ng:view>
</div>

<script src="resources/js/angular.min.js"></script>
<script src="resources/js/app.js"></script>
<script src="resources/js/controllers.js"></script>
<link rel="stylesheet" href="resources/styles/custom/custom.css"/>
<link rel="stylesheet" href="resources/styles/bootstrap/css/bootstrap.css"/>
<script src="resources/js/jquery/jquery.js" />
<script src="resources/js/angular/angular.js"/>
<script src="resources/js/angular/angular-resource.js"/>

<script src="resources/js/ui-bootstrap/ui-bootstrap-custom-0.4.0.js"/>
<script src="resources/js/ui-bootstrap/ui-bootstrap-custom-tpls-0.4.0.js"/>

</body>

</html>

