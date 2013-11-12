<!DOCTYPE HTML>
<html xmlns:ng="http://angularjs.org">
<head>
    <title>Debz</title>
    <link rel="stylesheet" href="resources/css/styles.css" />


</head>

<body ng-app="muzimaPreferredForm">

<div id="header">
    <img src="resources/imgs/25888_116229138398995_4560197_a.png" alt="moi uni" width="60" height="60">

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

</body>

</html>

